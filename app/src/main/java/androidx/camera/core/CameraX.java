package androidx.camera.core;

import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import androidx.annotation.GuardedBy;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.experimental.UseExperimental;
import androidx.arch.core.util.Function;
import androidx.camera.core.CameraX;
import androidx.camera.core.CameraXConfig;
import androidx.camera.core.impl.CameraDeviceSurfaceManager;
import androidx.camera.core.impl.CameraFactory;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.CameraRepository;
import androidx.camera.core.impl.CameraThreadConfig;
import androidx.camera.core.impl.CameraValidator;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.AsyncFunction;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.FutureChain;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.core.internal.compat.quirk.DeviceQuirks;
import androidx.camera.core.internal.compat.quirk.IncompleteCameraListQuirk;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.os.HandlerCompat;
import androidx.core.util.Preconditions;
import c.e.b.a.a.a;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes.dex */
@MainThread
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class CameraX {
    private static final long RETRY_SLEEP_MILLIS = 500;
    private static final String RETRY_TOKEN = "retry_token";
    private static final String TAG = "CameraX";
    private static final long WAIT_INITIALIZED_TIMEOUT_MILLIS = 3000;

    @GuardedBy("INSTANCE_LOCK")
    private static CameraXConfig.Provider sConfigProvider;

    @GuardedBy("INSTANCE_LOCK")
    public static CameraX sInstance;
    private Context mAppContext;
    private final Executor mCameraExecutor;
    private CameraFactory mCameraFactory;
    private final CameraXConfig mCameraXConfig;
    private UseCaseConfigFactory mDefaultConfigFactory;
    private final Handler mSchedulerHandler;

    @Nullable
    private final HandlerThread mSchedulerThread;
    private CameraDeviceSurfaceManager mSurfaceManager;
    public static final Object INSTANCE_LOCK = new Object();

    @GuardedBy("INSTANCE_LOCK")
    private static a<Void> sInitializeFuture = Futures.immediateFailedFuture(new IllegalStateException("CameraX is not initialized."));

    @GuardedBy("INSTANCE_LOCK")
    private static a<Void> sShutdownFuture = Futures.immediateFuture(null);
    public final CameraRepository mCameraRepository = new CameraRepository();
    private final Object mInitializeLock = new Object();

    @GuardedBy("mInitializeLock")
    private InternalInitState mInitState = InternalInitState.UNINITIALIZED;

    @GuardedBy("mInitializeLock")
    private a<Void> mShutdownInternalFuture = Futures.immediateFuture(null);

    /* JADX INFO: renamed from: androidx.camera.core.CameraX$2, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {
        public static final /* synthetic */ int[] $SwitchMap$androidx$camera$core$CameraX$InternalInitState;

        static {
            InternalInitState.values();
            int[] iArr = new int[4];
            $SwitchMap$androidx$camera$core$CameraX$InternalInitState = iArr;
            try {
                iArr[InternalInitState.UNINITIALIZED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$androidx$camera$core$CameraX$InternalInitState[InternalInitState.INITIALIZING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$androidx$camera$core$CameraX$InternalInitState[InternalInitState.INITIALIZED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$androidx$camera$core$CameraX$InternalInitState[InternalInitState.SHUTDOWN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public enum InternalInitState {
        UNINITIALIZED,
        INITIALIZING,
        INITIALIZED,
        SHUTDOWN
    }

    public CameraX(@NonNull CameraXConfig cameraXConfig) {
        this.mCameraXConfig = (CameraXConfig) Preconditions.checkNotNull(cameraXConfig);
        Executor cameraExecutor = cameraXConfig.getCameraExecutor(null);
        Handler schedulerHandler = cameraXConfig.getSchedulerHandler(null);
        this.mCameraExecutor = cameraExecutor == null ? new CameraExecutor() : cameraExecutor;
        if (schedulerHandler != null) {
            this.mSchedulerThread = null;
            this.mSchedulerHandler = schedulerHandler;
        } else {
            HandlerThread handlerThread = new HandlerThread("CameraX-scheduler", 10);
            this.mSchedulerThread = handlerThread;
            handlerThread.start();
            this.mSchedulerHandler = HandlerCompat.createAsync(handlerThread.getLooper());
        }
    }

    @NonNull
    private static CameraX checkInitialized() {
        CameraX cameraXWaitInitialized = waitInitialized();
        Preconditions.checkState(cameraXWaitInitialized.isInitializedInternal(), "Must call CameraX.initialize() first");
        return cameraXWaitInitialized;
    }

    public static void configureInstance(@NonNull final CameraXConfig cameraXConfig) {
        synchronized (INSTANCE_LOCK) {
            configureInstanceLocked(new CameraXConfig.Provider() { // from class: b.a.b.h
                @Override // androidx.camera.core.CameraXConfig.Provider
                public final CameraXConfig getCameraXConfig() {
                    CameraXConfig cameraXConfig2 = cameraXConfig;
                    Object obj = CameraX.INSTANCE_LOCK;
                    return cameraXConfig2;
                }
            });
        }
    }

    @GuardedBy("INSTANCE_LOCK")
    private static void configureInstanceLocked(@NonNull CameraXConfig.Provider provider) {
        Preconditions.checkNotNull(provider);
        Preconditions.checkState(sConfigProvider == null, "CameraX has already been configured. To use a different configuration, shutdown() must be called.");
        sConfigProvider = provider;
        Integer num = (Integer) provider.getCameraXConfig().retrieveOption(CameraXConfig.OPTION_MIN_LOGGING_LEVEL, null);
        if (num != null) {
            Logger.setMinLogLevel(num.intValue());
        }
    }

    @Nullable
    private static Application getApplicationFromContext(@NonNull Context context) {
        for (Context applicationContext = context.getApplicationContext(); applicationContext instanceof ContextWrapper; applicationContext = ((ContextWrapper) applicationContext).getBaseContext()) {
            if (applicationContext instanceof Application) {
                return (Application) applicationContext;
            }
        }
        return null;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static CameraInternal getCameraWithCameraSelector(@NonNull CameraSelector cameraSelector) {
        return cameraSelector.select(checkInitialized().getCameraRepository().getCameras());
    }

    @Nullable
    private static CameraXConfig.Provider getConfigProvider(@NonNull Context context) {
        ComponentCallbacks2 applicationFromContext = getApplicationFromContext(context);
        if (applicationFromContext instanceof CameraXConfig.Provider) {
            return (CameraXConfig.Provider) applicationFromContext;
        }
        try {
            return (CameraXConfig.Provider) Class.forName(context.getApplicationContext().getResources().getString(R.string.androidx_camera_default_config_provider)).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Resources.NotFoundException | ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | NullPointerException | InvocationTargetException e2) {
            Logger.e(TAG, "Failed to retrieve default CameraXConfig.Provider from resources", e2);
            return null;
        }
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Deprecated
    public static Context getContext() {
        return checkInitialized().mAppContext;
    }

    @NonNull
    private static a<CameraX> getInstance() {
        a<CameraX> instanceLocked;
        synchronized (INSTANCE_LOCK) {
            instanceLocked = getInstanceLocked();
        }
        return instanceLocked;
    }

    @NonNull
    @GuardedBy("INSTANCE_LOCK")
    private static a<CameraX> getInstanceLocked() {
        final CameraX cameraX = sInstance;
        return cameraX == null ? Futures.immediateFailedFuture(new IllegalStateException("Must call CameraX.initialize() first")) : Futures.transform(sInitializeFuture, new Function() { // from class: b.a.b.e
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                CameraX cameraX2 = this.a;
                Object obj2 = CameraX.INSTANCE_LOCK;
                return cameraX2;
            }
        }, CameraXExecutors.directExecutor());
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static a<CameraX> getOrCreateInstance(@NonNull Context context) {
        a<CameraX> instanceLocked;
        Preconditions.checkNotNull(context, "Context must not be null.");
        synchronized (INSTANCE_LOCK) {
            boolean z = sConfigProvider != null;
            instanceLocked = getInstanceLocked();
            if (instanceLocked.isDone()) {
                try {
                    instanceLocked.get();
                } catch (InterruptedException e2) {
                    throw new RuntimeException("Unexpected thread interrupt. Should not be possible since future is already complete.", e2);
                } catch (ExecutionException unused) {
                    shutdownLocked();
                    instanceLocked = null;
                }
            }
            if (instanceLocked == null) {
                if (!z) {
                    CameraXConfig.Provider configProvider = getConfigProvider(context);
                    if (configProvider == null) {
                        throw new IllegalStateException("CameraX is not configured properly. The most likely cause is you did not include a default implementation in your build such as 'camera-camera2'.");
                    }
                    configureInstanceLocked(configProvider);
                }
                initializeInstanceLocked(context);
                instanceLocked = getInstanceLocked();
            }
        }
        return instanceLocked;
    }

    @UseExperimental(markerClass = ExperimentalAvailableCamerasLimiter.class)
    private void initAndRetryRecursively(@NonNull final Executor executor, final long j2, @NonNull final Context context, @NonNull final CallbackToFutureAdapter.Completer<Void> completer) {
        executor.execute(new Runnable() { // from class: b.a.b.l
            @Override // java.lang.Runnable
            public final void run() {
                this.a.b(context, executor, completer, j2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public a<Void> initInternal(@NonNull final Context context) {
        a<Void> future;
        synchronized (this.mInitializeLock) {
            Preconditions.checkState(this.mInitState == InternalInitState.UNINITIALIZED, "CameraX.initInternal() should only be called once per instance");
            this.mInitState = InternalInitState.INITIALIZING;
            future = CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: b.a.b.d
                @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
                public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                    this.a.c(context, completer);
                    return "CameraX initInternal";
                }
            });
        }
        return future;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.TESTS})
    public static a<Void> initialize(@NonNull Context context, @NonNull final CameraXConfig cameraXConfig) {
        a<Void> aVar;
        synchronized (INSTANCE_LOCK) {
            Preconditions.checkNotNull(context);
            configureInstanceLocked(new CameraXConfig.Provider() { // from class: b.a.b.i
                @Override // androidx.camera.core.CameraXConfig.Provider
                public final CameraXConfig getCameraXConfig() {
                    CameraXConfig cameraXConfig2 = cameraXConfig;
                    Object obj = CameraX.INSTANCE_LOCK;
                    return cameraXConfig2;
                }
            });
            initializeInstanceLocked(context);
            aVar = sInitializeFuture;
        }
        return aVar;
    }

    @GuardedBy("INSTANCE_LOCK")
    private static void initializeInstanceLocked(@NonNull final Context context) {
        Preconditions.checkNotNull(context);
        Preconditions.checkState(sInstance == null, "CameraX already initialized.");
        Preconditions.checkNotNull(sConfigProvider);
        final CameraX cameraX = new CameraX(sConfigProvider.getCameraXConfig());
        sInstance = cameraX;
        sInitializeFuture = CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: b.a.b.f
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
            public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                CameraX.lambda$initializeInstanceLocked$3(this.a, context, completer);
                return "CameraX-initialize";
            }
        });
    }

    @RestrictTo({RestrictTo.Scope.TESTS})
    public static boolean isInitialized() {
        boolean z;
        synchronized (INSTANCE_LOCK) {
            CameraX cameraX = sInstance;
            z = cameraX != null && cameraX.isInitializedInternal();
        }
        return z;
    }

    private boolean isInitializedInternal() {
        boolean z;
        synchronized (this.mInitializeLock) {
            z = this.mInitState == InternalInitState.INITIALIZED;
        }
        return z;
    }

    public static /* synthetic */ Object lambda$initializeInstanceLocked$3(final CameraX cameraX, final Context context, final CallbackToFutureAdapter.Completer completer) {
        synchronized (INSTANCE_LOCK) {
            Futures.addCallback(FutureChain.from(sShutdownFuture).transformAsync(new AsyncFunction() { // from class: b.a.b.j
                @Override // androidx.camera.core.impl.utils.futures.AsyncFunction
                public final c.e.b.a.a.a apply(Object obj) {
                    return this.a.initInternal(context);
                }
            }, CameraXExecutors.directExecutor()), new FutureCallback<Void>() { // from class: androidx.camera.core.CameraX.1
                @Override // androidx.camera.core.impl.utils.futures.FutureCallback
                public void onFailure(Throwable th) {
                    Logger.w(CameraX.TAG, "CameraX initialize() failed", th);
                    synchronized (CameraX.INSTANCE_LOCK) {
                        if (CameraX.sInstance == cameraX) {
                            CameraX.shutdownLocked();
                        }
                    }
                    completer.setException(th);
                }

                @Override // androidx.camera.core.impl.utils.futures.FutureCallback
                public void onSuccess(@Nullable Void r2) {
                    completer.set(null);
                }
            }, CameraXExecutors.directExecutor());
        }
        return "CameraX-initialize";
    }

    public static /* synthetic */ Object lambda$shutdownLocked$5(final CameraX cameraX, final CallbackToFutureAdapter.Completer completer) {
        synchronized (INSTANCE_LOCK) {
            sInitializeFuture.addListener(new Runnable() { // from class: b.a.b.m
                @Override // java.lang.Runnable
                public final void run() {
                    Futures.propagate(this.a.shutdownInternal(), completer);
                }
            }, CameraXExecutors.directExecutor());
        }
        return "CameraX shutdown";
    }

    private void setStateToInitialized() {
        synchronized (this.mInitializeLock) {
            this.mInitState = InternalInitState.INITIALIZED;
        }
    }

    @NonNull
    public static a<Void> shutdown() {
        a<Void> aVarShutdownLocked;
        synchronized (INSTANCE_LOCK) {
            sConfigProvider = null;
            Logger.resetMinLogLevel();
            aVarShutdownLocked = shutdownLocked();
        }
        return aVarShutdownLocked;
    }

    @NonNull
    private a<Void> shutdownInternal() {
        synchronized (this.mInitializeLock) {
            this.mSchedulerHandler.removeCallbacksAndMessages(RETRY_TOKEN);
            int iOrdinal = this.mInitState.ordinal();
            if (iOrdinal == 0) {
                this.mInitState = InternalInitState.SHUTDOWN;
                return Futures.immediateFuture(null);
            }
            if (iOrdinal == 1) {
                throw new IllegalStateException("CameraX could not be shutdown when it is initializing.");
            }
            if (iOrdinal == 2) {
                this.mInitState = InternalInitState.SHUTDOWN;
                this.mShutdownInternalFuture = CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: b.a.b.o
                    @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
                    public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                        this.a.e(completer);
                        return "CameraX shutdownInternal";
                    }
                });
            }
            return this.mShutdownInternalFuture;
        }
    }

    @NonNull
    @GuardedBy("INSTANCE_LOCK")
    public static a<Void> shutdownLocked() {
        final CameraX cameraX = sInstance;
        if (cameraX == null) {
            return sShutdownFuture;
        }
        sInstance = null;
        a<Void> future = CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: b.a.b.n
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
            public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                CameraX.lambda$shutdownLocked$5(this.a, completer);
                return "CameraX shutdown";
            }
        });
        sShutdownFuture = future;
        return future;
    }

    @NonNull
    private static CameraX waitInitialized() {
        try {
            return getInstance().get(WAIT_INITIALIZED_TIMEOUT_MILLIS, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e2) {
            throw new IllegalStateException(e2);
        }
    }

    public /* synthetic */ void a(Executor executor, long j2, CallbackToFutureAdapter.Completer completer) {
        initAndRetryRecursively(executor, j2, this.mAppContext, completer);
    }

    public /* synthetic */ void b(Context context, final Executor executor, final CallbackToFutureAdapter.Completer completer, final long j2) {
        try {
            Application applicationFromContext = getApplicationFromContext(context);
            this.mAppContext = applicationFromContext;
            if (applicationFromContext == null) {
                this.mAppContext = context.getApplicationContext();
            }
            CameraFactory.Provider cameraFactoryProvider = this.mCameraXConfig.getCameraFactoryProvider(null);
            if (cameraFactoryProvider == null) {
                throw new InitializationException(new IllegalArgumentException("Invalid app configuration provided. Missing CameraFactory."));
            }
            this.mCameraFactory = cameraFactoryProvider.newInstance(this.mAppContext, CameraThreadConfig.create(this.mCameraExecutor, this.mSchedulerHandler), this.mCameraXConfig.getAvailableCamerasLimiter(null));
            CameraDeviceSurfaceManager.Provider deviceSurfaceManagerProvider = this.mCameraXConfig.getDeviceSurfaceManagerProvider(null);
            if (deviceSurfaceManagerProvider == null) {
                throw new InitializationException(new IllegalArgumentException("Invalid app configuration provided. Missing CameraDeviceSurfaceManager."));
            }
            this.mSurfaceManager = deviceSurfaceManagerProvider.newInstance(this.mAppContext, this.mCameraFactory.getCameraManager(), this.mCameraFactory.getAvailableCameraIds());
            UseCaseConfigFactory.Provider useCaseConfigFactoryProvider = this.mCameraXConfig.getUseCaseConfigFactoryProvider(null);
            if (useCaseConfigFactoryProvider == null) {
                throw new InitializationException(new IllegalArgumentException("Invalid app configuration provided. Missing UseCaseConfigFactory."));
            }
            this.mDefaultConfigFactory = useCaseConfigFactoryProvider.newInstance(this.mAppContext);
            if (executor instanceof CameraExecutor) {
                ((CameraExecutor) executor).init(this.mCameraFactory);
            }
            this.mCameraRepository.init(this.mCameraFactory);
            if (DeviceQuirks.get(IncompleteCameraListQuirk.class) != null) {
                CameraValidator.validateCameras(this.mAppContext, this.mCameraRepository);
            }
            setStateToInitialized();
            completer.set(null);
        } catch (InitializationException | CameraValidator.CameraIdListIncorrectException | RuntimeException e2) {
            if (SystemClock.elapsedRealtime() - j2 < 2500) {
                Logger.w(TAG, "Retry init. Start time " + j2 + " current time " + SystemClock.elapsedRealtime(), e2);
                HandlerCompat.postDelayed(this.mSchedulerHandler, new Runnable() { // from class: b.a.b.g
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.a(executor, j2, completer);
                    }
                }, RETRY_TOKEN, RETRY_SLEEP_MILLIS);
                return;
            }
            setStateToInitialized();
            if (e2 instanceof CameraValidator.CameraIdListIncorrectException) {
                Logger.e(TAG, "The device might underreport the amount of the cameras. Finish the initialize task since we are already reaching the maximum number of retries.");
                completer.set(null);
            } else if (e2 instanceof InitializationException) {
                completer.setException(e2);
            } else {
                completer.setException(new InitializationException(e2));
            }
        }
    }

    public /* synthetic */ Object c(Context context, CallbackToFutureAdapter.Completer completer) {
        initAndRetryRecursively(this.mCameraExecutor, SystemClock.elapsedRealtime(), context, completer);
        return "CameraX initInternal";
    }

    public /* synthetic */ void d(CallbackToFutureAdapter.Completer completer) {
        if (this.mSchedulerThread != null) {
            Executor executor = this.mCameraExecutor;
            if (executor instanceof CameraExecutor) {
                ((CameraExecutor) executor).deinit();
            }
            this.mSchedulerThread.quit();
            completer.set(null);
        }
    }

    public /* synthetic */ Object e(final CallbackToFutureAdapter.Completer completer) {
        this.mCameraRepository.deinit().addListener(new Runnable() { // from class: b.a.b.k
            @Override // java.lang.Runnable
            public final void run() {
                this.a.d(completer);
            }
        }, this.mCameraExecutor);
        return "CameraX shutdownInternal";
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public CameraDeviceSurfaceManager getCameraDeviceSurfaceManager() {
        CameraDeviceSurfaceManager cameraDeviceSurfaceManager = this.mSurfaceManager;
        if (cameraDeviceSurfaceManager != null) {
            return cameraDeviceSurfaceManager;
        }
        throw new IllegalStateException("CameraX not initialized yet.");
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public CameraFactory getCameraFactory() {
        CameraFactory cameraFactory = this.mCameraFactory;
        if (cameraFactory != null) {
            return cameraFactory;
        }
        throw new IllegalStateException("CameraX not initialized yet.");
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public CameraRepository getCameraRepository() {
        return this.mCameraRepository;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public UseCaseConfigFactory getDefaultConfigFactory() {
        UseCaseConfigFactory useCaseConfigFactory = this.mDefaultConfigFactory;
        if (useCaseConfigFactory != null) {
            return useCaseConfigFactory;
        }
        throw new IllegalStateException("CameraX not initialized yet.");
    }
}

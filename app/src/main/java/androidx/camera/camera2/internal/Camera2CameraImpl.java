package androidx.camera.camera2.internal;

import android.annotation.SuppressLint;
import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Rational;
import android.util.Size;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.camera.camera2.internal.Camera2CameraImpl;
import androidx.camera.camera2.internal.SynchronizedCaptureSessionOpener;
import androidx.camera.camera2.internal.compat.CameraAccessExceptionCompat;
import androidx.camera.camera2.internal.compat.CameraManagerCompat;
import androidx.camera.core.CameraControl;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.CameraUnavailableException;
import androidx.camera.core.Logger;
import androidx.camera.core.Preview;
import androidx.camera.core.UseCase;
import androidx.camera.core.impl.CameraConfig;
import androidx.camera.core.impl.CameraControlInternal;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.CameraStateRegistry;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.ImmediateSurface;
import androidx.camera.core.impl.LiveDataObservable;
import androidx.camera.core.impl.Observable;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.UseCaseAttachState;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Preconditions;
import b.a.b.w1.q;
import c.e.b.a.a.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public final class Camera2CameraImpl implements CameraInternal {
    private static final int ERROR_NONE = 0;
    private static final String TAG = "Camera2CameraImpl";
    private final CameraAvailability mCameraAvailability;
    private final Camera2CameraControlImpl mCameraControlInternal;
    public SessionConfig mCameraControlSessionConfig;

    @Nullable
    public CameraDevice mCameraDevice;
    public int mCameraDeviceError;

    @NonNull
    public final Camera2CameraInfoImpl mCameraInfoInternal;
    private final CameraManagerCompat mCameraManager;
    private final CameraStateRegistry mCameraStateRegistry;
    public CaptureSession mCaptureSession;

    @NonNull
    private final SynchronizedCaptureSessionOpener.Builder mCaptureSessionOpenerBuilder;

    @NonNull
    private final CaptureSessionRepository mCaptureSessionRepository;
    public final Set<CaptureSession> mConfiguringForClose;
    private final Executor mExecutor;
    private MeteringRepeatingSession mMeteringRepeatingSession;
    private final Set<String> mNotifyStateAttachedSet;
    private final LiveDataObservable<CameraInternal.State> mObservableState;
    public final AtomicInteger mReleaseRequestCount;
    public final Map<CaptureSession, a<Void>> mReleasedCaptureSessions;
    public volatile InternalState mState = InternalState.INITIALIZED;
    private final StateCallback mStateCallback;
    private final UseCaseAttachState mUseCaseAttachState;
    public a<Void> mUserReleaseFuture;
    public CallbackToFutureAdapter.Completer<Void> mUserReleaseNotifier;

    /* JADX INFO: renamed from: androidx.camera.camera2.internal.Camera2CameraImpl$3, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass3 {
        public static final /* synthetic */ int[] $SwitchMap$androidx$camera$camera2$internal$Camera2CameraImpl$InternalState;

        static {
            InternalState.values();
            int[] iArr = new int[8];
            $SwitchMap$androidx$camera$camera2$internal$Camera2CameraImpl$InternalState = iArr;
            try {
                iArr[InternalState.INITIALIZED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$androidx$camera$camera2$internal$Camera2CameraImpl$InternalState[InternalState.CLOSING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$androidx$camera$camera2$internal$Camera2CameraImpl$InternalState[InternalState.OPENED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$androidx$camera$camera2$internal$Camera2CameraImpl$InternalState[InternalState.OPENING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$androidx$camera$camera2$internal$Camera2CameraImpl$InternalState[InternalState.REOPENING.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$androidx$camera$camera2$internal$Camera2CameraImpl$InternalState[InternalState.PENDING_OPEN.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$androidx$camera$camera2$internal$Camera2CameraImpl$InternalState[InternalState.RELEASING.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$androidx$camera$camera2$internal$Camera2CameraImpl$InternalState[InternalState.RELEASED.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    public final class CameraAvailability extends CameraManager.AvailabilityCallback implements CameraStateRegistry.OnOpenAvailableListener {
        private boolean mCameraAvailable = true;
        private final String mCameraId;

        public CameraAvailability(String str) {
            this.mCameraId = str;
        }

        public boolean isCameraAvailable() {
            return this.mCameraAvailable;
        }

        @Override // android.hardware.camera2.CameraManager.AvailabilityCallback
        public void onCameraAvailable(@NonNull String str) {
            if (this.mCameraId.equals(str)) {
                this.mCameraAvailable = true;
                if (Camera2CameraImpl.this.mState == InternalState.PENDING_OPEN) {
                    Camera2CameraImpl.this.openCameraDevice(false);
                }
            }
        }

        @Override // android.hardware.camera2.CameraManager.AvailabilityCallback
        public void onCameraUnavailable(@NonNull String str) {
            if (this.mCameraId.equals(str)) {
                this.mCameraAvailable = false;
            }
        }

        @Override // androidx.camera.core.impl.CameraStateRegistry.OnOpenAvailableListener
        public void onOpenAvailable() {
            if (Camera2CameraImpl.this.mState == InternalState.PENDING_OPEN) {
                Camera2CameraImpl.this.openCameraDevice(false);
            }
        }
    }

    public final class ControlUpdateListenerInternal implements CameraControlInternal.ControlUpdateCallback {
        public ControlUpdateListenerInternal() {
        }

        @Override // androidx.camera.core.impl.CameraControlInternal.ControlUpdateCallback
        public void onCameraControlCaptureRequests(@NonNull List<CaptureConfig> list) {
            Camera2CameraImpl.this.submitCaptureRequests((List) Preconditions.checkNotNull(list));
        }

        @Override // androidx.camera.core.impl.CameraControlInternal.ControlUpdateCallback
        public void onCameraControlUpdateSessionConfig(@NonNull SessionConfig sessionConfig) {
            Camera2CameraImpl.this.mCameraControlSessionConfig = (SessionConfig) Preconditions.checkNotNull(sessionConfig);
            Camera2CameraImpl.this.updateCaptureSessionConfig();
        }
    }

    public enum InternalState {
        INITIALIZED,
        PENDING_OPEN,
        OPENING,
        OPENED,
        CLOSING,
        REOPENING,
        RELEASING,
        RELEASED
    }

    public final class StateCallback extends CameraDevice.StateCallback {
        public static final int REOPEN_DELAY_MS = 700;

        @NonNull
        private final CameraReopenMonitor mCameraReopenMonitor = new CameraReopenMonitor();
        private final Executor mExecutor;
        public ScheduledFuture<?> mScheduledReopenHandle;
        private ScheduledReopen mScheduledReopenRunnable;
        private final ScheduledExecutorService mScheduler;

        public class CameraReopenMonitor {
            public static final int INVALID_TIME = -1;
            public static final int REOPEN_LIMIT_MS = 10000;
            private long mFirstReopenTime = -1;

            public CameraReopenMonitor() {
            }

            public boolean canScheduleCameraReopen() {
                long jUptimeMillis = SystemClock.uptimeMillis();
                long j2 = this.mFirstReopenTime;
                if (j2 == -1) {
                    this.mFirstReopenTime = jUptimeMillis;
                    return true;
                }
                if (!(jUptimeMillis - j2 >= 10000)) {
                    return true;
                }
                reset();
                return false;
            }

            public void reset() {
                this.mFirstReopenTime = -1L;
            }
        }

        public class ScheduledReopen implements Runnable {
            private boolean mCancelled = false;
            private Executor mExecutor;

            public ScheduledReopen(@NonNull Executor executor) {
                this.mExecutor = executor;
            }

            public /* synthetic */ void a() {
                if (this.mCancelled) {
                    return;
                }
                Preconditions.checkState(Camera2CameraImpl.this.mState == InternalState.REOPENING);
                Camera2CameraImpl.this.openCameraDevice(true);
            }

            public void cancel() {
                this.mCancelled = true;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.mExecutor.execute(new Runnable() { // from class: b.a.a.d.w
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.a();
                    }
                });
            }
        }

        public StateCallback(@NonNull Executor executor, @NonNull ScheduledExecutorService scheduledExecutorService) {
            this.mExecutor = executor;
            this.mScheduler = scheduledExecutorService;
        }

        private void handleErrorOnOpen(@NonNull CameraDevice cameraDevice, int i2) {
            boolean z = Camera2CameraImpl.this.mState == InternalState.OPENING || Camera2CameraImpl.this.mState == InternalState.OPENED || Camera2CameraImpl.this.mState == InternalState.REOPENING;
            StringBuilder sbR = c.a.a.a.a.r("Attempt to handle open error from non open state: ");
            sbR.append(Camera2CameraImpl.this.mState);
            Preconditions.checkState(z, sbR.toString());
            if (i2 == 1 || i2 == 2 || i2 == 4) {
                Logger.d(Camera2CameraImpl.TAG, String.format("Attempt to reopen camera[%s] after error[%s]", cameraDevice.getId(), Camera2CameraImpl.getErrorMessage(i2)));
                reopenCameraAfterError();
                return;
            }
            StringBuilder sbR2 = c.a.a.a.a.r("Error observed on open (or opening) camera device ");
            sbR2.append(cameraDevice.getId());
            sbR2.append(": ");
            sbR2.append(Camera2CameraImpl.getErrorMessage(i2));
            sbR2.append(" closing camera.");
            Logger.e(Camera2CameraImpl.TAG, sbR2.toString());
            Camera2CameraImpl.this.setState(InternalState.CLOSING);
            Camera2CameraImpl.this.closeCamera(false);
        }

        private void reopenCameraAfterError() {
            Preconditions.checkState(Camera2CameraImpl.this.mCameraDeviceError != 0, "Can only reopen camera device after error if the camera device is actually in an error state.");
            Camera2CameraImpl.this.setState(InternalState.REOPENING);
            Camera2CameraImpl.this.closeCamera(false);
        }

        public boolean cancelScheduledReopen() {
            if (this.mScheduledReopenHandle == null) {
                return false;
            }
            Camera2CameraImpl camera2CameraImpl = Camera2CameraImpl.this;
            StringBuilder sbR = c.a.a.a.a.r("Cancelling scheduled re-open: ");
            sbR.append(this.mScheduledReopenRunnable);
            camera2CameraImpl.debugLog(sbR.toString());
            this.mScheduledReopenRunnable.cancel();
            this.mScheduledReopenRunnable = null;
            this.mScheduledReopenHandle.cancel(false);
            this.mScheduledReopenHandle = null;
            return true;
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onClosed(@NonNull CameraDevice cameraDevice) {
            Camera2CameraImpl.this.debugLog("CameraDevice.onClosed()");
            Preconditions.checkState(Camera2CameraImpl.this.mCameraDevice == null, "Unexpected onClose callback on camera device: " + cameraDevice);
            int iOrdinal = Camera2CameraImpl.this.mState.ordinal();
            if (iOrdinal != 4) {
                if (iOrdinal == 5) {
                    Camera2CameraImpl camera2CameraImpl = Camera2CameraImpl.this;
                    if (camera2CameraImpl.mCameraDeviceError == 0) {
                        camera2CameraImpl.openCameraDevice(false);
                        return;
                    }
                    StringBuilder sbR = c.a.a.a.a.r("Camera closed due to error: ");
                    sbR.append(Camera2CameraImpl.getErrorMessage(Camera2CameraImpl.this.mCameraDeviceError));
                    camera2CameraImpl.debugLog(sbR.toString());
                    scheduleCameraReopen();
                    return;
                }
                if (iOrdinal != 6) {
                    StringBuilder sbR2 = c.a.a.a.a.r("Camera closed while in state: ");
                    sbR2.append(Camera2CameraImpl.this.mState);
                    throw new IllegalStateException(sbR2.toString());
                }
            }
            Preconditions.checkState(Camera2CameraImpl.this.isSessionCloseComplete());
            Camera2CameraImpl.this.finishClose();
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onDisconnected(@NonNull CameraDevice cameraDevice) {
            Camera2CameraImpl.this.debugLog("CameraDevice.onDisconnected()");
            onError(cameraDevice, 1);
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onError(@NonNull CameraDevice cameraDevice, int i2) {
            Camera2CameraImpl camera2CameraImpl = Camera2CameraImpl.this;
            camera2CameraImpl.mCameraDevice = cameraDevice;
            camera2CameraImpl.mCameraDeviceError = i2;
            int iOrdinal = camera2CameraImpl.mState.ordinal();
            if (iOrdinal != 2 && iOrdinal != 3) {
                if (iOrdinal != 4) {
                    if (iOrdinal != 5) {
                        if (iOrdinal != 6) {
                            StringBuilder sbR = c.a.a.a.a.r("onError() should not be possible from state: ");
                            sbR.append(Camera2CameraImpl.this.mState);
                            throw new IllegalStateException(sbR.toString());
                        }
                    }
                }
                Logger.e(Camera2CameraImpl.TAG, String.format("CameraDevice.onError(): %s failed with %s while in %s state. Will finish closing camera.", cameraDevice.getId(), Camera2CameraImpl.getErrorMessage(i2), Camera2CameraImpl.this.mState.name()));
                Camera2CameraImpl.this.closeCamera(false);
                return;
            }
            Logger.d(Camera2CameraImpl.TAG, String.format("CameraDevice.onError(): %s failed with %s while in %s state. Will attempt recovering from error.", cameraDevice.getId(), Camera2CameraImpl.getErrorMessage(i2), Camera2CameraImpl.this.mState.name()));
            handleErrorOnOpen(cameraDevice, i2);
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onOpened(@NonNull CameraDevice cameraDevice) {
            Camera2CameraImpl.this.debugLog("CameraDevice.onOpened()");
            Camera2CameraImpl camera2CameraImpl = Camera2CameraImpl.this;
            camera2CameraImpl.mCameraDevice = cameraDevice;
            camera2CameraImpl.updateDefaultRequestBuilderToCameraControl(cameraDevice);
            Camera2CameraImpl camera2CameraImpl2 = Camera2CameraImpl.this;
            camera2CameraImpl2.mCameraDeviceError = 0;
            int iOrdinal = camera2CameraImpl2.mState.ordinal();
            if (iOrdinal != 2) {
                if (iOrdinal != 4) {
                    if (iOrdinal != 5) {
                        if (iOrdinal != 6) {
                            StringBuilder sbR = c.a.a.a.a.r("onOpened() should not be possible from state: ");
                            sbR.append(Camera2CameraImpl.this.mState);
                            throw new IllegalStateException(sbR.toString());
                        }
                    }
                }
                Preconditions.checkState(Camera2CameraImpl.this.isSessionCloseComplete());
                Camera2CameraImpl.this.mCameraDevice.close();
                Camera2CameraImpl.this.mCameraDevice = null;
                return;
            }
            Camera2CameraImpl.this.setState(InternalState.OPENED);
            Camera2CameraImpl.this.openCaptureSession();
        }

        public void resetReopenMonitor() {
            this.mCameraReopenMonitor.reset();
        }

        public void scheduleCameraReopen() {
            Preconditions.checkState(this.mScheduledReopenRunnable == null);
            Preconditions.checkState(this.mScheduledReopenHandle == null);
            if (!this.mCameraReopenMonitor.canScheduleCameraReopen()) {
                Logger.e(Camera2CameraImpl.TAG, "Camera reopening attempted for 10000ms without success.");
                Camera2CameraImpl.this.setState(InternalState.INITIALIZED);
                return;
            }
            this.mScheduledReopenRunnable = new ScheduledReopen(this.mExecutor);
            Camera2CameraImpl camera2CameraImpl = Camera2CameraImpl.this;
            StringBuilder sbR = c.a.a.a.a.r("Attempting camera re-open in 700ms: ");
            sbR.append(this.mScheduledReopenRunnable);
            camera2CameraImpl.debugLog(sbR.toString());
            this.mScheduledReopenHandle = this.mScheduler.schedule(this.mScheduledReopenRunnable, 700L, TimeUnit.MILLISECONDS);
        }
    }

    public Camera2CameraImpl(@NonNull CameraManagerCompat cameraManagerCompat, @NonNull String str, @NonNull Camera2CameraInfoImpl camera2CameraInfoImpl, @NonNull CameraStateRegistry cameraStateRegistry, @NonNull Executor executor, @NonNull Handler handler) throws CameraUnavailableException {
        LiveDataObservable<CameraInternal.State> liveDataObservable = new LiveDataObservable<>();
        this.mObservableState = liveDataObservable;
        this.mCameraDeviceError = 0;
        this.mCameraControlSessionConfig = SessionConfig.defaultEmptySessionConfig();
        this.mReleaseRequestCount = new AtomicInteger(0);
        this.mReleasedCaptureSessions = new LinkedHashMap();
        this.mConfiguringForClose = new HashSet();
        this.mNotifyStateAttachedSet = new HashSet();
        this.mCameraManager = cameraManagerCompat;
        this.mCameraStateRegistry = cameraStateRegistry;
        ScheduledExecutorService scheduledExecutorServiceNewHandlerExecutor = CameraXExecutors.newHandlerExecutor(handler);
        Executor executorNewSequentialExecutor = CameraXExecutors.newSequentialExecutor(executor);
        this.mExecutor = executorNewSequentialExecutor;
        this.mStateCallback = new StateCallback(executorNewSequentialExecutor, scheduledExecutorServiceNewHandlerExecutor);
        this.mUseCaseAttachState = new UseCaseAttachState(str);
        liveDataObservable.postValue(CameraInternal.State.CLOSED);
        CaptureSessionRepository captureSessionRepository = new CaptureSessionRepository(executorNewSequentialExecutor);
        this.mCaptureSessionRepository = captureSessionRepository;
        this.mCaptureSession = new CaptureSession();
        try {
            Camera2CameraControlImpl camera2CameraControlImpl = new Camera2CameraControlImpl(cameraManagerCompat.getCameraCharacteristicsCompat(str), scheduledExecutorServiceNewHandlerExecutor, executorNewSequentialExecutor, new ControlUpdateListenerInternal(), camera2CameraInfoImpl.getCameraQuirks());
            this.mCameraControlInternal = camera2CameraControlImpl;
            this.mCameraInfoInternal = camera2CameraInfoImpl;
            camera2CameraInfoImpl.linkWithCameraControl(camera2CameraControlImpl);
            this.mCaptureSessionOpenerBuilder = new SynchronizedCaptureSessionOpener.Builder(executorNewSequentialExecutor, scheduledExecutorServiceNewHandlerExecutor, handler, captureSessionRepository, camera2CameraInfoImpl.getSupportedHardwareLevel());
            CameraAvailability cameraAvailability = new CameraAvailability(str);
            this.mCameraAvailability = cameraAvailability;
            cameraStateRegistry.registerCamera(this, executorNewSequentialExecutor, cameraAvailability);
            cameraManagerCompat.registerAvailabilityCallback(executorNewSequentialExecutor, cameraAvailability);
        } catch (CameraAccessExceptionCompat e2) {
            throw CameraUnavailableExceptionHelper.createFrom(e2);
        }
    }

    private void addMeteringRepeating() {
        if (this.mMeteringRepeatingSession != null) {
            this.mUseCaseAttachState.setUseCaseAttached(this.mMeteringRepeatingSession.getName() + this.mMeteringRepeatingSession.hashCode(), this.mMeteringRepeatingSession.getSessionConfig());
            this.mUseCaseAttachState.setUseCaseActive(this.mMeteringRepeatingSession.getName() + this.mMeteringRepeatingSession.hashCode(), this.mMeteringRepeatingSession.getSessionConfig());
        }
    }

    private void addOrRemoveMeteringRepeatingUseCase() {
        SessionConfig sessionConfigBuild = this.mUseCaseAttachState.getAttachedBuilder().build();
        CaptureConfig repeatingCaptureConfig = sessionConfigBuild.getRepeatingCaptureConfig();
        int size = repeatingCaptureConfig.getSurfaces().size();
        int size2 = sessionConfigBuild.getSurfaces().size();
        if (sessionConfigBuild.getSurfaces().isEmpty()) {
            return;
        }
        if (repeatingCaptureConfig.getSurfaces().isEmpty()) {
            if (this.mMeteringRepeatingSession == null) {
                this.mMeteringRepeatingSession = new MeteringRepeatingSession(this.mCameraInfoInternal.getCameraCharacteristicsCompat());
            }
            addMeteringRepeating();
        } else {
            if (size2 == 1 && size == 1) {
                removeMeteringRepeating();
                return;
            }
            if (size >= 2) {
                removeMeteringRepeating();
                return;
            }
            Logger.d(TAG, "mMeteringRepeating is ATTACHED, SessionConfig Surfaces: " + size2 + ", CaptureConfig Surfaces: " + size);
        }
    }

    private boolean checkAndAttachRepeatingSurface(CaptureConfig.Builder builder) {
        if (!builder.getSurfaces().isEmpty()) {
            Logger.w(TAG, "The capture config builder already has surface inside.");
            return false;
        }
        Iterator<SessionConfig> it = this.mUseCaseAttachState.getActiveAndAttachedSessionConfigs().iterator();
        while (it.hasNext()) {
            List<DeferrableSurface> surfaces = it.next().getRepeatingCaptureConfig().getSurfaces();
            if (!surfaces.isEmpty()) {
                Iterator<DeferrableSurface> it2 = surfaces.iterator();
                while (it2.hasNext()) {
                    builder.addSurface(it2.next());
                }
            }
        }
        if (!builder.getSurfaces().isEmpty()) {
            return true;
        }
        Logger.w(TAG, "Unable to find a repeating surface to attach to CaptureConfig");
        return false;
    }

    private void clearCameraControlPreviewAspectRatio(Collection<UseCase> collection) {
        Iterator<UseCase> it = collection.iterator();
        while (it.hasNext()) {
            if (it.next() instanceof Preview) {
                this.mCameraControlInternal.setPreviewAspectRatio(null);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void closeInternal() {
        debugLog("Closing camera.");
        int iOrdinal = this.mState.ordinal();
        if (iOrdinal == 1) {
            Preconditions.checkState(this.mCameraDevice == null);
            setState(InternalState.INITIALIZED);
            return;
        }
        if (iOrdinal != 2) {
            if (iOrdinal == 3) {
                setState(InternalState.CLOSING);
                closeCamera(false);
                return;
            } else if (iOrdinal != 5) {
                StringBuilder sbR = c.a.a.a.a.r("close() ignored due to being in state: ");
                sbR.append(this.mState);
                debugLog(sbR.toString());
                return;
            }
        }
        boolean zCancelScheduledReopen = this.mStateCallback.cancelScheduledReopen();
        setState(InternalState.CLOSING);
        if (zCancelScheduledReopen) {
            Preconditions.checkState(isSessionCloseComplete());
            finishClose();
        }
    }

    private void configAndClose(boolean z) {
        final CaptureSession captureSession = new CaptureSession();
        this.mConfiguringForClose.add(captureSession);
        resetCaptureSession(z);
        final SurfaceTexture surfaceTexture = new SurfaceTexture(0);
        surfaceTexture.setDefaultBufferSize(640, 480);
        final Surface surface = new Surface(surfaceTexture);
        final Runnable runnable = new Runnable() { // from class: b.a.a.d.c0
            @Override // java.lang.Runnable
            public final void run() {
                Surface surface2 = surface;
                SurfaceTexture surfaceTexture2 = surfaceTexture;
                surface2.release();
                surfaceTexture2.release();
            }
        };
        SessionConfig.Builder builder = new SessionConfig.Builder();
        builder.addNonRepeatingSurface(new ImmediateSurface(surface));
        builder.setTemplateType(1);
        debugLog("Start configAndClose.");
        captureSession.open(builder.build(), (CameraDevice) Preconditions.checkNotNull(this.mCameraDevice), this.mCaptureSessionOpenerBuilder.build()).addListener(new Runnable() { // from class: b.a.a.d.e0
            @Override // java.lang.Runnable
            public final void run() {
                this.a.releaseNoOpSession(captureSession, runnable);
            }
        }, this.mExecutor);
    }

    private CameraDevice.StateCallback createDeviceStateCallback() {
        ArrayList arrayList = new ArrayList(this.mUseCaseAttachState.getAttachedBuilder().build().getDeviceStateCallbacks());
        arrayList.add(this.mStateCallback);
        arrayList.add(this.mCaptureSessionRepository.getCameraStateCallback());
        return CameraDeviceStateCallbacks.createComboCallback(arrayList);
    }

    public static String getErrorMessage(int i2) {
        return i2 != 0 ? i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? i2 != 5 ? "UNKNOWN ERROR" : "ERROR_CAMERA_SERVICE" : "ERROR_CAMERA_DEVICE" : "ERROR_CAMERA_DISABLED" : "ERROR_MAX_CAMERAS_IN_USE" : "ERROR_CAMERA_IN_USE" : "ERROR_NONE";
    }

    private a<Void> getOrCreateUserReleaseFuture() {
        if (this.mUserReleaseFuture == null) {
            if (this.mState != InternalState.RELEASED) {
                this.mUserReleaseFuture = CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: b.a.a.d.x
                    @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
                    public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                        Camera2CameraImpl camera2CameraImpl = this.a;
                        Preconditions.checkState(camera2CameraImpl.mUserReleaseNotifier == null, "Camera can only be released once, so release completer should be null on creation.");
                        camera2CameraImpl.mUserReleaseNotifier = completer;
                        return "Release[camera=" + camera2CameraImpl + "]";
                    }
                });
            } else {
                this.mUserReleaseFuture = Futures.immediateFuture(null);
            }
        }
        return this.mUserReleaseFuture;
    }

    private boolean isLegacyDevice() {
        return ((Camera2CameraInfoImpl) getCameraInfoInternal()).getSupportedHardwareLevel() == 2;
    }

    private void notifyStateAttachedToUseCases(List<UseCase> list) {
        for (UseCase useCase : list) {
            if (!this.mNotifyStateAttachedSet.contains(useCase.getName() + useCase.hashCode())) {
                this.mNotifyStateAttachedSet.add(useCase.getName() + useCase.hashCode());
                useCase.onStateAttached();
            }
        }
    }

    private void notifyStateDetachedToUseCases(List<UseCase> list) {
        for (UseCase useCase : list) {
            if (this.mNotifyStateAttachedSet.contains(useCase.getName() + useCase.hashCode())) {
                useCase.onStateDetached();
                this.mNotifyStateAttachedSet.remove(useCase.getName() + useCase.hashCode());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openInternal() {
        int iOrdinal = this.mState.ordinal();
        if (iOrdinal == 0) {
            openCameraDevice(false);
            return;
        }
        if (iOrdinal != 4) {
            StringBuilder sbR = c.a.a.a.a.r("open() ignored due to being in state: ");
            sbR.append(this.mState);
            debugLog(sbR.toString());
            return;
        }
        setState(InternalState.REOPENING);
        if (isSessionCloseComplete() || this.mCameraDeviceError != 0) {
            return;
        }
        Preconditions.checkState(this.mCameraDevice != null, "Camera Device should be open if session close is not complete");
        setState(InternalState.OPENED);
        openCaptureSession();
    }

    private a<Void> releaseInternal() {
        a<Void> orCreateUserReleaseFuture = getOrCreateUserReleaseFuture();
        switch (this.mState) {
            case INITIALIZED:
            case PENDING_OPEN:
                Preconditions.checkState(this.mCameraDevice == null);
                setState(InternalState.RELEASING);
                Preconditions.checkState(isSessionCloseComplete());
                finishClose();
                return orCreateUserReleaseFuture;
            case OPENING:
            case CLOSING:
            case REOPENING:
            case RELEASING:
                boolean zCancelScheduledReopen = this.mStateCallback.cancelScheduledReopen();
                setState(InternalState.RELEASING);
                if (zCancelScheduledReopen) {
                    Preconditions.checkState(isSessionCloseComplete());
                    finishClose();
                }
                return orCreateUserReleaseFuture;
            case OPENED:
                setState(InternalState.RELEASING);
                closeCamera(false);
                return orCreateUserReleaseFuture;
            default:
                StringBuilder sbR = c.a.a.a.a.r("release() ignored due to being in state: ");
                sbR.append(this.mState);
                debugLog(sbR.toString());
                return orCreateUserReleaseFuture;
        }
    }

    private void removeMeteringRepeating() {
        if (this.mMeteringRepeatingSession != null) {
            this.mUseCaseAttachState.setUseCaseDetached(this.mMeteringRepeatingSession.getName() + this.mMeteringRepeatingSession.hashCode());
            this.mUseCaseAttachState.setUseCaseInactive(this.mMeteringRepeatingSession.getName() + this.mMeteringRepeatingSession.hashCode());
            this.mMeteringRepeatingSession.clear();
            this.mMeteringRepeatingSession = null;
        }
    }

    private void tryAttachUseCases(@NonNull Collection<UseCase> collection) {
        boolean zIsEmpty = this.mUseCaseAttachState.getAttachedSessionConfigs().isEmpty();
        ArrayList arrayList = new ArrayList();
        for (UseCase useCase : collection) {
            if (!this.mUseCaseAttachState.isUseCaseAttached(useCase.getName() + useCase.hashCode())) {
                try {
                    this.mUseCaseAttachState.setUseCaseAttached(useCase.getName() + useCase.hashCode(), useCase.getSessionConfig());
                    arrayList.add(useCase);
                } catch (NullPointerException unused) {
                    debugLog("Failed to attach a detached use case");
                }
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        StringBuilder sbR = c.a.a.a.a.r("Use cases [");
        sbR.append(TextUtils.join(", ", arrayList));
        sbR.append("] now ATTACHED");
        debugLog(sbR.toString());
        if (zIsEmpty) {
            this.mCameraControlInternal.setActive(true);
            this.mCameraControlInternal.incrementUseCount();
        }
        addOrRemoveMeteringRepeatingUseCase();
        updateCaptureSessionConfig();
        resetCaptureSession(false);
        if (this.mState == InternalState.OPENED) {
            openCaptureSession();
        } else {
            openInternal();
        }
        updateCameraControlPreviewAspectRatio(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: tryDetachUseCases, reason: merged with bridge method [inline-methods] */
    public void d(@NonNull Collection<UseCase> collection) {
        ArrayList arrayList = new ArrayList();
        for (UseCase useCase : collection) {
            if (this.mUseCaseAttachState.isUseCaseAttached(useCase.getName() + useCase.hashCode())) {
                this.mUseCaseAttachState.removeUseCase(useCase.getName() + useCase.hashCode());
                arrayList.add(useCase);
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        StringBuilder sbR = c.a.a.a.a.r("Use cases [");
        sbR.append(TextUtils.join(", ", arrayList));
        sbR.append("] now DETACHED for camera");
        debugLog(sbR.toString());
        clearCameraControlPreviewAspectRatio(arrayList);
        addOrRemoveMeteringRepeatingUseCase();
        if (this.mUseCaseAttachState.getAttachedSessionConfigs().isEmpty()) {
            this.mCameraControlInternal.decrementUseCount();
            resetCaptureSession(false);
            this.mCameraControlInternal.setActive(false);
            this.mCaptureSession = new CaptureSession();
            closeInternal();
            return;
        }
        updateCaptureSessionConfig();
        resetCaptureSession(false);
        if (this.mState == InternalState.OPENED) {
            openCaptureSession();
        }
    }

    private void updateCameraControlPreviewAspectRatio(Collection<UseCase> collection) {
        for (UseCase useCase : collection) {
            if (useCase instanceof Preview) {
                Size attachedSurfaceResolution = useCase.getAttachedSurfaceResolution();
                if (attachedSurfaceResolution != null) {
                    this.mCameraControlInternal.setPreviewAspectRatio(new Rational(attachedSurfaceResolution.getWidth(), attachedSurfaceResolution.getHeight()));
                    return;
                }
                return;
            }
        }
    }

    @Override // androidx.camera.core.impl.CameraInternal
    public void attachUseCases(@NonNull final Collection<UseCase> collection) {
        if (collection.isEmpty()) {
            return;
        }
        this.mCameraControlInternal.incrementUseCount();
        notifyStateAttachedToUseCases(new ArrayList(collection));
        try {
            this.mExecutor.execute(new Runnable() { // from class: b.a.a.d.d0
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.b(collection);
                }
            });
        } catch (RejectedExecutionException e2) {
            debugLog("Unable to attach use cases.", e2);
            this.mCameraControlInternal.decrementUseCount();
        }
    }

    public /* synthetic */ void b(Collection collection) {
        try {
            tryAttachUseCases(collection);
        } finally {
            this.mCameraControlInternal.decrementUseCount();
        }
    }

    @Override // androidx.camera.core.impl.CameraInternal
    public void close() {
        this.mExecutor.execute(new Runnable() { // from class: b.a.a.d.y
            @Override // java.lang.Runnable
            public final void run() {
                this.a.closeInternal();
            }
        });
    }

    public void closeCamera(boolean z) {
        boolean z2 = this.mState == InternalState.CLOSING || this.mState == InternalState.RELEASING || (this.mState == InternalState.REOPENING && this.mCameraDeviceError != 0);
        StringBuilder sbR = c.a.a.a.a.r("closeCamera should only be called in a CLOSING, RELEASING or REOPENING (with error) state. Current state: ");
        sbR.append(this.mState);
        sbR.append(" (error: ");
        sbR.append(getErrorMessage(this.mCameraDeviceError));
        sbR.append(")");
        Preconditions.checkState(z2, sbR.toString());
        int i2 = Build.VERSION.SDK_INT;
        if (i2 <= 23 || i2 >= 29 || !isLegacyDevice() || this.mCameraDeviceError != 0) {
            resetCaptureSession(z);
        } else {
            configAndClose(z);
        }
        this.mCaptureSession.cancelIssuedCaptureRequests();
    }

    public void debugLog(@NonNull String str) {
        debugLog(str, null);
    }

    @Override // androidx.camera.core.impl.CameraInternal
    public void detachUseCases(@NonNull final Collection<UseCase> collection) {
        if (collection.isEmpty()) {
            return;
        }
        notifyStateDetachedToUseCases(new ArrayList(collection));
        this.mExecutor.execute(new Runnable() { // from class: b.a.a.d.q
            @Override // java.lang.Runnable
            public final void run() {
                this.a.d(collection);
            }
        });
    }

    public /* synthetic */ Object e(final UseCase useCase, final CallbackToFutureAdapter.Completer completer) {
        try {
            this.mExecutor.execute(new Runnable() { // from class: b.a.a.d.u
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.f(completer, useCase);
                }
            });
            return "isUseCaseAttached";
        } catch (RejectedExecutionException unused) {
            completer.setException(new RuntimeException("Unable to check if use case is attached. Camera executor shut down."));
            return "isUseCaseAttached";
        }
    }

    public /* synthetic */ void f(CallbackToFutureAdapter.Completer completer, UseCase useCase) {
        completer.set(Boolean.valueOf(this.mUseCaseAttachState.isUseCaseAttached(useCase.getName() + useCase.hashCode())));
    }

    @Nullable
    public SessionConfig findSessionConfigForSurface(@NonNull DeferrableSurface deferrableSurface) {
        for (SessionConfig sessionConfig : this.mUseCaseAttachState.getAttachedSessionConfigs()) {
            if (sessionConfig.getSurfaces().contains(deferrableSurface)) {
                return sessionConfig;
            }
        }
        return null;
    }

    public void finishClose() {
        Preconditions.checkState(this.mState == InternalState.RELEASING || this.mState == InternalState.CLOSING);
        Preconditions.checkState(this.mReleasedCaptureSessions.isEmpty());
        this.mCameraDevice = null;
        if (this.mState == InternalState.CLOSING) {
            setState(InternalState.INITIALIZED);
            return;
        }
        this.mCameraManager.unregisterAvailabilityCallback(this.mCameraAvailability);
        setState(InternalState.RELEASED);
        CallbackToFutureAdapter.Completer<Void> completer = this.mUserReleaseNotifier;
        if (completer != null) {
            completer.set(null);
            this.mUserReleaseNotifier = null;
        }
    }

    public /* synthetic */ void g(UseCase useCase) {
        debugLog("Use case " + useCase + " ACTIVE");
        try {
            this.mUseCaseAttachState.setUseCaseActive(useCase.getName() + useCase.hashCode(), useCase.getSessionConfig());
            this.mUseCaseAttachState.updateUseCase(useCase.getName() + useCase.hashCode(), useCase.getSessionConfig());
            updateCaptureSessionConfig();
        } catch (NullPointerException unused) {
            debugLog("Failed to set already detached use case active");
        }
    }

    @Override // androidx.camera.core.impl.CameraInternal, androidx.camera.core.Camera
    public /* synthetic */ CameraControl getCameraControl() {
        return q.a(this);
    }

    @Override // androidx.camera.core.impl.CameraInternal
    @NonNull
    public CameraControlInternal getCameraControlInternal() {
        return this.mCameraControlInternal;
    }

    @Override // androidx.camera.core.impl.CameraInternal, androidx.camera.core.Camera
    public /* synthetic */ CameraInfo getCameraInfo() {
        return q.b(this);
    }

    @Override // androidx.camera.core.impl.CameraInternal
    @NonNull
    public CameraInfoInternal getCameraInfoInternal() {
        return this.mCameraInfoInternal;
    }

    @Override // androidx.camera.core.impl.CameraInternal, androidx.camera.core.Camera
    public /* synthetic */ LinkedHashSet getCameraInternals() {
        return q.c(this);
    }

    @Override // androidx.camera.core.impl.CameraInternal
    @NonNull
    public Observable<CameraInternal.State> getCameraState() {
        return this.mObservableState;
    }

    @Override // androidx.camera.core.impl.CameraInternal, androidx.camera.core.Camera
    public /* synthetic */ CameraConfig getExtendedConfig() {
        return q.d(this);
    }

    public /* synthetic */ void h(UseCase useCase) {
        debugLog("Use case " + useCase + " INACTIVE");
        this.mUseCaseAttachState.setUseCaseInactive(useCase.getName() + useCase.hashCode());
        updateCaptureSessionConfig();
    }

    public /* synthetic */ void i(UseCase useCase) {
        debugLog("Use case " + useCase + " RESET");
        this.mUseCaseAttachState.updateUseCase(useCase.getName() + useCase.hashCode(), useCase.getSessionConfig());
        resetCaptureSession(false);
        updateCaptureSessionConfig();
        if (this.mState == InternalState.OPENED) {
            openCaptureSession();
        }
    }

    public boolean isSessionCloseComplete() {
        return this.mReleasedCaptureSessions.isEmpty() && this.mConfiguringForClose.isEmpty();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @RestrictTo({RestrictTo.Scope.TESTS})
    public boolean isUseCaseAttached(@NonNull final UseCase useCase) {
        try {
            return ((Boolean) CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: b.a.a.d.b0
                @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
                public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                    this.a.e(useCase, completer);
                    return "isUseCaseAttached";
                }
            }).get()).booleanValue();
        } catch (InterruptedException | ExecutionException e2) {
            throw new RuntimeException("Unable to check if use case is attached.", e2);
        }
    }

    public /* synthetic */ void j(UseCase useCase) {
        debugLog("Use case " + useCase + " UPDATED");
        this.mUseCaseAttachState.updateUseCase(useCase.getName() + useCase.hashCode(), useCase.getSessionConfig());
        updateCaptureSessionConfig();
    }

    public /* synthetic */ void k(CallbackToFutureAdapter.Completer completer) {
        Futures.propagate(releaseInternal(), completer);
    }

    public /* synthetic */ Object l(final CallbackToFutureAdapter.Completer completer) {
        this.mExecutor.execute(new Runnable() { // from class: b.a.a.d.r
            @Override // java.lang.Runnable
            public final void run() {
                this.a.k(completer);
            }
        });
        return "Release[request=" + this.mReleaseRequestCount.getAndIncrement() + "]";
    }

    @Override // androidx.camera.core.UseCase.StateChangeCallback
    public void onUseCaseActive(@NonNull final UseCase useCase) {
        Preconditions.checkNotNull(useCase);
        this.mExecutor.execute(new Runnable() { // from class: b.a.a.d.v
            @Override // java.lang.Runnable
            public final void run() {
                this.a.g(useCase);
            }
        });
    }

    @Override // androidx.camera.core.UseCase.StateChangeCallback
    public void onUseCaseInactive(@NonNull final UseCase useCase) {
        Preconditions.checkNotNull(useCase);
        this.mExecutor.execute(new Runnable() { // from class: b.a.a.d.f0
            @Override // java.lang.Runnable
            public final void run() {
                this.a.h(useCase);
            }
        });
    }

    @Override // androidx.camera.core.UseCase.StateChangeCallback
    public void onUseCaseReset(@NonNull final UseCase useCase) {
        Preconditions.checkNotNull(useCase);
        this.mExecutor.execute(new Runnable() { // from class: b.a.a.d.g0
            @Override // java.lang.Runnable
            public final void run() {
                this.a.i(useCase);
            }
        });
    }

    @Override // androidx.camera.core.UseCase.StateChangeCallback
    public void onUseCaseUpdated(@NonNull final UseCase useCase) {
        Preconditions.checkNotNull(useCase);
        this.mExecutor.execute(new Runnable() { // from class: b.a.a.d.a0
            @Override // java.lang.Runnable
            public final void run() {
                this.a.j(useCase);
            }
        });
    }

    @Override // androidx.camera.core.impl.CameraInternal
    public void open() {
        this.mExecutor.execute(new Runnable() { // from class: b.a.a.d.s
            @Override // java.lang.Runnable
            public final void run() {
                this.a.openInternal();
            }
        });
    }

    @SuppressLint({"MissingPermission"})
    public void openCameraDevice(boolean z) {
        if (!z) {
            this.mStateCallback.resetReopenMonitor();
        }
        this.mStateCallback.cancelScheduledReopen();
        if (!this.mCameraAvailability.isCameraAvailable() || !this.mCameraStateRegistry.tryOpenCamera(this)) {
            debugLog("No cameras available. Waiting for available camera before opening camera.");
            setState(InternalState.PENDING_OPEN);
            return;
        }
        setState(InternalState.OPENING);
        debugLog("Opening camera.");
        try {
            this.mCameraManager.openCamera(this.mCameraInfoInternal.getCameraId(), this.mExecutor, createDeviceStateCallback());
        } catch (CameraAccessExceptionCompat e2) {
            StringBuilder sbR = c.a.a.a.a.r("Unable to open camera due to ");
            sbR.append(e2.getMessage());
            debugLog(sbR.toString());
            if (e2.getReason() != 10001) {
                return;
            }
            setState(InternalState.INITIALIZED);
        } catch (SecurityException e3) {
            StringBuilder sbR2 = c.a.a.a.a.r("Unable to open camera due to ");
            sbR2.append(e3.getMessage());
            debugLog(sbR2.toString());
            setState(InternalState.REOPENING);
            this.mStateCallback.scheduleCameraReopen();
        }
    }

    public void openCaptureSession() {
        Preconditions.checkState(this.mState == InternalState.OPENED);
        SessionConfig.ValidatingBuilder attachedBuilder = this.mUseCaseAttachState.getAttachedBuilder();
        if (attachedBuilder.isValid()) {
            Futures.addCallback(this.mCaptureSession.open(attachedBuilder.build(), (CameraDevice) Preconditions.checkNotNull(this.mCameraDevice), this.mCaptureSessionOpenerBuilder.build()), new FutureCallback<Void>() { // from class: androidx.camera.camera2.internal.Camera2CameraImpl.2
                @Override // androidx.camera.core.impl.utils.futures.FutureCallback
                public void onFailure(Throwable th) {
                    if (th instanceof CameraAccessException) {
                        Camera2CameraImpl camera2CameraImpl = Camera2CameraImpl.this;
                        StringBuilder sbR = c.a.a.a.a.r("Unable to configure camera due to ");
                        sbR.append(th.getMessage());
                        camera2CameraImpl.debugLog(sbR.toString());
                        return;
                    }
                    if (th instanceof CancellationException) {
                        Camera2CameraImpl.this.debugLog("Unable to configure camera cancelled");
                        return;
                    }
                    if (th instanceof DeferrableSurface.SurfaceClosedException) {
                        SessionConfig sessionConfigFindSessionConfigForSurface = Camera2CameraImpl.this.findSessionConfigForSurface(((DeferrableSurface.SurfaceClosedException) th).getDeferrableSurface());
                        if (sessionConfigFindSessionConfigForSurface != null) {
                            Camera2CameraImpl.this.postSurfaceClosedError(sessionConfigFindSessionConfigForSurface);
                            return;
                        }
                        return;
                    }
                    if (!(th instanceof TimeoutException)) {
                        throw new RuntimeException(th);
                    }
                    StringBuilder sbR2 = c.a.a.a.a.r("Unable to configure camera ");
                    sbR2.append(Camera2CameraImpl.this.mCameraInfoInternal.getCameraId());
                    sbR2.append(", timeout!");
                    Logger.e(Camera2CameraImpl.TAG, sbR2.toString());
                }

                @Override // androidx.camera.core.impl.utils.futures.FutureCallback
                public void onSuccess(@Nullable Void r1) {
                }
            }, this.mExecutor);
        } else {
            debugLog("Unable to create capture session due to conflicting configurations");
        }
    }

    public void postSurfaceClosedError(@NonNull final SessionConfig sessionConfig) {
        ScheduledExecutorService scheduledExecutorServiceMainThreadExecutor = CameraXExecutors.mainThreadExecutor();
        List<SessionConfig.ErrorListener> errorListeners = sessionConfig.getErrorListeners();
        if (errorListeners.isEmpty()) {
            return;
        }
        final SessionConfig.ErrorListener errorListener = errorListeners.get(0);
        debugLog("Posting surface closed", new Throwable());
        scheduledExecutorServiceMainThreadExecutor.execute(new Runnable() { // from class: b.a.a.d.t
            @Override // java.lang.Runnable
            public final void run() {
                errorListener.onError(sessionConfig, SessionConfig.SessionError.SESSION_ERROR_SURFACE_NEEDS_RESET);
            }
        });
    }

    @Override // androidx.camera.core.impl.CameraInternal
    @NonNull
    public a<Void> release() {
        return CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: b.a.a.d.z
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
            public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                return this.a.l(completer);
            }
        });
    }

    public void releaseNoOpSession(CaptureSession captureSession, Runnable runnable) {
        this.mConfiguringForClose.remove(captureSession);
        releaseSession(captureSession, false).addListener(runnable, CameraXExecutors.directExecutor());
    }

    public a<Void> releaseSession(@NonNull final CaptureSession captureSession, boolean z) {
        captureSession.close();
        a<Void> aVarRelease = captureSession.release(z);
        StringBuilder sbR = c.a.a.a.a.r("Releasing session in state ");
        sbR.append(this.mState.name());
        debugLog(sbR.toString());
        this.mReleasedCaptureSessions.put(captureSession, aVarRelease);
        Futures.addCallback(aVarRelease, new FutureCallback<Void>() { // from class: androidx.camera.camera2.internal.Camera2CameraImpl.1
            @Override // androidx.camera.core.impl.utils.futures.FutureCallback
            public void onFailure(Throwable th) {
            }

            @Override // androidx.camera.core.impl.utils.futures.FutureCallback
            public void onSuccess(@Nullable Void r2) {
                CameraDevice cameraDevice;
                Camera2CameraImpl.this.mReleasedCaptureSessions.remove(captureSession);
                int iOrdinal = Camera2CameraImpl.this.mState.ordinal();
                if (iOrdinal != 4) {
                    if (iOrdinal != 5) {
                        if (iOrdinal != 6) {
                            return;
                        }
                    } else if (Camera2CameraImpl.this.mCameraDeviceError == 0) {
                        return;
                    }
                }
                if (!Camera2CameraImpl.this.isSessionCloseComplete() || (cameraDevice = Camera2CameraImpl.this.mCameraDevice) == null) {
                    return;
                }
                cameraDevice.close();
                Camera2CameraImpl.this.mCameraDevice = null;
            }
        }, CameraXExecutors.directExecutor());
        return aVarRelease;
    }

    public void resetCaptureSession(boolean z) {
        Preconditions.checkState(this.mCaptureSession != null);
        debugLog("Resetting Capture Session");
        CaptureSession captureSession = this.mCaptureSession;
        SessionConfig sessionConfig = captureSession.getSessionConfig();
        List<CaptureConfig> captureConfigs = captureSession.getCaptureConfigs();
        CaptureSession captureSession2 = new CaptureSession();
        this.mCaptureSession = captureSession2;
        captureSession2.setSessionConfig(sessionConfig);
        this.mCaptureSession.issueCaptureRequests(captureConfigs);
        releaseSession(captureSession, z);
    }

    @Override // androidx.camera.core.impl.CameraInternal, androidx.camera.core.Camera
    public /* synthetic */ void setExtendedConfig(CameraConfig cameraConfig) {
        q.e(this, cameraConfig);
    }

    public void setState(@NonNull InternalState internalState) {
        CameraInternal.State state;
        StringBuilder sbR = c.a.a.a.a.r("Transitioning camera internal state: ");
        sbR.append(this.mState);
        sbR.append(" --> ");
        sbR.append(internalState);
        debugLog(sbR.toString());
        this.mState = internalState;
        switch (internalState) {
            case INITIALIZED:
                state = CameraInternal.State.CLOSED;
                break;
            case PENDING_OPEN:
                state = CameraInternal.State.PENDING_OPEN;
                break;
            case OPENING:
            case REOPENING:
                state = CameraInternal.State.OPENING;
                break;
            case OPENED:
                state = CameraInternal.State.OPEN;
                break;
            case CLOSING:
                state = CameraInternal.State.CLOSING;
                break;
            case RELEASING:
                state = CameraInternal.State.RELEASING;
                break;
            case RELEASED:
                state = CameraInternal.State.RELEASED;
                break;
            default:
                throw new IllegalStateException("Unknown state: " + internalState);
        }
        this.mCameraStateRegistry.markCameraState(this, state);
        this.mObservableState.postValue(state);
    }

    public void submitCaptureRequests(@NonNull List<CaptureConfig> list) {
        ArrayList arrayList = new ArrayList();
        for (CaptureConfig captureConfig : list) {
            CaptureConfig.Builder builderFrom = CaptureConfig.Builder.from(captureConfig);
            if (!captureConfig.getSurfaces().isEmpty() || !captureConfig.isUseRepeatingSurface() || checkAndAttachRepeatingSurface(builderFrom)) {
                arrayList.add(builderFrom.build());
            }
        }
        debugLog("Issue capture request");
        this.mCaptureSession.issueCaptureRequests(arrayList);
    }

    @NonNull
    public String toString() {
        return String.format(Locale.US, "Camera@%x[id=%s]", Integer.valueOf(hashCode()), this.mCameraInfoInternal.getCameraId());
    }

    public void updateCaptureSessionConfig() {
        SessionConfig.ValidatingBuilder activeAndAttachedBuilder = this.mUseCaseAttachState.getActiveAndAttachedBuilder();
        if (!activeAndAttachedBuilder.isValid()) {
            this.mCaptureSession.setSessionConfig(this.mCameraControlSessionConfig);
            return;
        }
        activeAndAttachedBuilder.add(this.mCameraControlSessionConfig);
        this.mCaptureSession.setSessionConfig(activeAndAttachedBuilder.build());
    }

    public void updateDefaultRequestBuilderToCameraControl(@NonNull CameraDevice cameraDevice) {
        try {
            this.mCameraControlInternal.setDefaultRequestBuilder(cameraDevice.createCaptureRequest(this.mCameraControlInternal.getDefaultTemplate()));
        } catch (CameraAccessException e2) {
            Logger.e(TAG, "fail to create capture request.", e2);
        }
    }

    private void debugLog(@NonNull String str, @Nullable Throwable th) {
        Logger.d(TAG, String.format("{%s} %s", toString(), str), th);
    }
}

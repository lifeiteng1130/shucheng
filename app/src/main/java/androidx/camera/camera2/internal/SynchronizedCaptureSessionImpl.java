package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CaptureRequest;
import android.os.Handler;
import android.view.Surface;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.camera2.internal.SynchronizedCaptureSessionImpl;
import androidx.camera.camera2.internal.compat.params.SessionConfigurationCompat;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.AsyncFunction;
import androidx.camera.core.impl.utils.futures.FutureChain;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import c.e.b.a.a.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: classes.dex */
public class SynchronizedCaptureSessionImpl extends SynchronizedCaptureSessionBaseImpl {
    private static final String TAG = "SyncCaptureSessionImpl";
    private final CameraCaptureSession.CaptureCallback mCaptureCallback;

    @Nullable
    public CallbackToFutureAdapter.Completer<Void> mClosingDeferrableSurfaceCompleter;

    @Nullable
    private final a<Void> mClosingDeferrableSurfaceFuture;

    @Nullable
    @GuardedBy("mObjectLock")
    private List<DeferrableSurface> mDeferrableSurfaces;

    @NonNull
    private final Set<String> mEnabledFeature;

    @GuardedBy("mObjectLock")
    private boolean mHasSubmittedRepeating;
    private final Object mObjectLock;

    @Nullable
    @GuardedBy("mObjectLock")
    public a<Void> mOpeningCaptureSession;
    public CallbackToFutureAdapter.Completer<Void> mStartStreamingCompleter;

    @NonNull
    private final a<Void> mStartStreamingFuture;

    @Nullable
    @GuardedBy("mObjectLock")
    public a<List<Surface>> mStartingSurface;

    public SynchronizedCaptureSessionImpl(@NonNull Set<String> set, @NonNull CaptureSessionRepository captureSessionRepository, @NonNull Executor executor, @NonNull ScheduledExecutorService scheduledExecutorService, @NonNull Handler handler) {
        super(captureSessionRepository, executor, scheduledExecutorService, handler);
        this.mObjectLock = new Object();
        this.mCaptureCallback = new CameraCaptureSession.CaptureCallback() { // from class: androidx.camera.camera2.internal.SynchronizedCaptureSessionImpl.1
            @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
            public void onCaptureSequenceAborted(@NonNull CameraCaptureSession cameraCaptureSession, int i2) {
                CallbackToFutureAdapter.Completer<Void> completer = SynchronizedCaptureSessionImpl.this.mStartStreamingCompleter;
                if (completer != null) {
                    completer.setCancelled();
                    SynchronizedCaptureSessionImpl.this.mStartStreamingCompleter = null;
                }
            }

            @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
            public void onCaptureStarted(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull CaptureRequest captureRequest, long j2, long j3) {
                CallbackToFutureAdapter.Completer<Void> completer = SynchronizedCaptureSessionImpl.this.mStartStreamingCompleter;
                if (completer != null) {
                    completer.set(null);
                    SynchronizedCaptureSessionImpl.this.mStartStreamingCompleter = null;
                }
            }
        };
        this.mEnabledFeature = set;
        if (set.contains(SynchronizedCaptureSessionOpener.FEATURE_WAIT_FOR_REQUEST)) {
            this.mStartStreamingFuture = CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: b.a.a.d.g1
                @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
                public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                    SynchronizedCaptureSessionImpl synchronizedCaptureSessionImpl = this.a;
                    synchronizedCaptureSessionImpl.mStartStreamingCompleter = completer;
                    return "StartStreamingFuture[session=" + synchronizedCaptureSessionImpl + "]";
                }
            });
        } else {
            this.mStartStreamingFuture = Futures.immediateFuture(null);
        }
        if (set.contains(SynchronizedCaptureSessionOpener.FEATURE_DEFERRABLE_SURFACE_CLOSE)) {
            this.mClosingDeferrableSurfaceFuture = CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: b.a.a.d.c1
                @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
                public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                    SynchronizedCaptureSessionImpl synchronizedCaptureSessionImpl = this.a;
                    synchronizedCaptureSessionImpl.mClosingDeferrableSurfaceCompleter = completer;
                    return "ClosingDeferrableSurfaceFuture[session=" + synchronizedCaptureSessionImpl + "]";
                }
            });
        } else {
            this.mClosingDeferrableSurfaceFuture = Futures.immediateFuture(null);
        }
    }

    public static void forceOnClosed(@NonNull Set<SynchronizedCaptureSession> set) {
        for (SynchronizedCaptureSession synchronizedCaptureSession : set) {
            synchronizedCaptureSession.getStateCallback().onClosed(synchronizedCaptureSession);
        }
    }

    private void forceOnConfigureFailed(@NonNull Set<SynchronizedCaptureSession> set) {
        for (SynchronizedCaptureSession synchronizedCaptureSession : set) {
            synchronizedCaptureSession.getStateCallback().onConfigureFailed(synchronizedCaptureSession);
        }
    }

    private List<a<Void>> getBlockerFuture(@NonNull String str, List<SynchronizedCaptureSession> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<SynchronizedCaptureSession> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getSynchronizedBlocker(str));
        }
        return arrayList;
    }

    public /* synthetic */ void b() {
        debugLog("Session call super.close()");
        super.close();
    }

    public /* synthetic */ a c(CameraDevice cameraDevice, SessionConfigurationCompat sessionConfigurationCompat, List list) {
        return super.openCaptureSession(cameraDevice, sessionConfigurationCompat);
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSessionBaseImpl, androidx.camera.camera2.internal.SynchronizedCaptureSession
    public void close() {
        debugLog("Session call close()");
        if (this.mEnabledFeature.contains(SynchronizedCaptureSessionOpener.FEATURE_WAIT_FOR_REQUEST)) {
            synchronized (this.mObjectLock) {
                if (!this.mHasSubmittedRepeating) {
                    this.mStartStreamingFuture.cancel(true);
                }
            }
        }
        this.mStartStreamingFuture.addListener(new Runnable() { // from class: b.a.a.d.d1
            @Override // java.lang.Runnable
            public final void run() {
                this.a.b();
            }
        }, getExecutor());
    }

    public void closeConfiguredDeferrableSurfaces() {
        synchronized (this.mObjectLock) {
            if (this.mDeferrableSurfaces == null) {
                debugLog("deferrableSurface == null, maybe forceClose, skip close");
                return;
            }
            if (this.mEnabledFeature.contains(SynchronizedCaptureSessionOpener.FEATURE_DEFERRABLE_SURFACE_CLOSE)) {
                Iterator<DeferrableSurface> it = this.mDeferrableSurfaces.iterator();
                while (it.hasNext()) {
                    it.next().close();
                }
                debugLog("deferrableSurface closed");
                stopDeferrableSurface();
            }
        }
    }

    public /* synthetic */ a d(List list, long j2, List list2) {
        return super.startWithDeferrableSurface(list, j2);
    }

    public void debugLog(String str) {
        Logger.d(TAG, "[" + this + "] " + str);
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSessionBaseImpl, androidx.camera.camera2.internal.SynchronizedCaptureSession
    @NonNull
    public a<Void> getSynchronizedBlocker(@NonNull String str) {
        str.hashCode();
        return !str.equals(SynchronizedCaptureSessionOpener.FEATURE_WAIT_FOR_REQUEST) ? !str.equals(SynchronizedCaptureSessionOpener.FEATURE_DEFERRABLE_SURFACE_CLOSE) ? super.getSynchronizedBlocker(str) : Futures.nonCancellationPropagating(this.mClosingDeferrableSurfaceFuture) : Futures.nonCancellationPropagating(this.mStartStreamingFuture);
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSessionBaseImpl, androidx.camera.camera2.internal.SynchronizedCaptureSession.StateCallback
    public void onClosed(@NonNull SynchronizedCaptureSession synchronizedCaptureSession) {
        closeConfiguredDeferrableSurfaces();
        debugLog("onClosed()");
        super.onClosed(synchronizedCaptureSession);
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSessionBaseImpl, androidx.camera.camera2.internal.SynchronizedCaptureSession.StateCallback
    public void onConfigured(@NonNull SynchronizedCaptureSession synchronizedCaptureSession) {
        SynchronizedCaptureSession next;
        SynchronizedCaptureSession next2;
        debugLog("Session onConfigured()");
        if (this.mEnabledFeature.contains(SynchronizedCaptureSessionOpener.FEATURE_FORCE_CLOSE)) {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            Iterator<SynchronizedCaptureSession> it = this.mCaptureSessionRepository.getCreatingCaptureSessions().iterator();
            while (it.hasNext() && (next2 = it.next()) != synchronizedCaptureSession) {
                linkedHashSet.add(next2);
            }
            forceOnConfigureFailed(linkedHashSet);
        }
        super.onConfigured(synchronizedCaptureSession);
        if (this.mEnabledFeature.contains(SynchronizedCaptureSessionOpener.FEATURE_FORCE_CLOSE)) {
            LinkedHashSet linkedHashSet2 = new LinkedHashSet();
            Iterator<SynchronizedCaptureSession> it2 = this.mCaptureSessionRepository.getCaptureSessions().iterator();
            while (it2.hasNext() && (next = it2.next()) != synchronizedCaptureSession) {
                linkedHashSet2.add(next);
            }
            forceOnClosed(linkedHashSet2);
        }
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSessionBaseImpl, androidx.camera.camera2.internal.SynchronizedCaptureSessionOpener.OpenerImpl
    @NonNull
    public a<Void> openCaptureSession(@NonNull final CameraDevice cameraDevice, @NonNull final SessionConfigurationCompat sessionConfigurationCompat) {
        a<Void> aVarNonCancellationPropagating;
        synchronized (this.mObjectLock) {
            FutureChain futureChainTransformAsync = FutureChain.from(Futures.successfulAsList(getBlockerFuture(SynchronizedCaptureSessionOpener.FEATURE_WAIT_FOR_REQUEST, this.mCaptureSessionRepository.getClosingCaptureSession()))).transformAsync(new AsyncFunction() { // from class: b.a.a.d.f1
                @Override // androidx.camera.core.impl.utils.futures.AsyncFunction
                public final c.e.b.a.a.a apply(Object obj) {
                    return this.a.c(cameraDevice, sessionConfigurationCompat, (List) obj);
                }
            }, CameraXExecutors.directExecutor());
            this.mOpeningCaptureSession = futureChainTransformAsync;
            aVarNonCancellationPropagating = Futures.nonCancellationPropagating(futureChainTransformAsync);
        }
        return aVarNonCancellationPropagating;
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSessionBaseImpl, androidx.camera.camera2.internal.SynchronizedCaptureSession
    public int setSingleRepeatingRequest(@NonNull CaptureRequest captureRequest, @NonNull CameraCaptureSession.CaptureCallback captureCallback) {
        int singleRepeatingRequest;
        if (!this.mEnabledFeature.contains(SynchronizedCaptureSessionOpener.FEATURE_WAIT_FOR_REQUEST)) {
            return super.setSingleRepeatingRequest(captureRequest, captureCallback);
        }
        synchronized (this.mObjectLock) {
            this.mHasSubmittedRepeating = true;
            singleRepeatingRequest = super.setSingleRepeatingRequest(captureRequest, Camera2CaptureCallbacks.createComboCallback(this.mCaptureCallback, captureCallback));
        }
        return singleRepeatingRequest;
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSessionBaseImpl, androidx.camera.camera2.internal.SynchronizedCaptureSessionOpener.OpenerImpl
    @NonNull
    public a<List<Surface>> startWithDeferrableSurface(@NonNull final List<DeferrableSurface> list, final long j2) {
        a<List<Surface>> aVarNonCancellationPropagating;
        synchronized (this.mObjectLock) {
            this.mDeferrableSurfaces = list;
            List<a<Void>> listEmptyList = Collections.emptyList();
            if (this.mEnabledFeature.contains(SynchronizedCaptureSessionOpener.FEATURE_FORCE_CLOSE)) {
                Map<SynchronizedCaptureSession, List<DeferrableSurface>> mapRegisterDeferrableSurface = this.mCaptureSessionRepository.registerDeferrableSurface(this, list);
                ArrayList arrayList = new ArrayList();
                for (Map.Entry<SynchronizedCaptureSession, List<DeferrableSurface>> entry : mapRegisterDeferrableSurface.entrySet()) {
                    if (entry.getKey() != this && !Collections.disjoint(entry.getValue(), this.mDeferrableSurfaces)) {
                        arrayList.add(entry.getKey());
                    }
                }
                listEmptyList = getBlockerFuture(SynchronizedCaptureSessionOpener.FEATURE_DEFERRABLE_SURFACE_CLOSE, arrayList);
            }
            FutureChain futureChainTransformAsync = FutureChain.from(Futures.successfulAsList(listEmptyList)).transformAsync(new AsyncFunction() { // from class: b.a.a.d.e1
                @Override // androidx.camera.core.impl.utils.futures.AsyncFunction
                public final c.e.b.a.a.a apply(Object obj) {
                    return this.a.d(list, j2, (List) obj);
                }
            }, getExecutor());
            this.mStartingSurface = futureChainTransformAsync;
            aVarNonCancellationPropagating = Futures.nonCancellationPropagating(futureChainTransformAsync);
        }
        return aVarNonCancellationPropagating;
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSessionBaseImpl, androidx.camera.camera2.internal.SynchronizedCaptureSessionOpener.OpenerImpl
    public boolean stop() {
        boolean zStop;
        synchronized (this.mObjectLock) {
            if (isCameraCaptureSessionOpen()) {
                closeConfiguredDeferrableSurfaces();
            } else {
                a<Void> aVar = this.mOpeningCaptureSession;
                if (aVar != null) {
                    aVar.cancel(true);
                }
                a<List<Surface>> aVar2 = this.mStartingSurface;
                if (aVar2 != null) {
                    aVar2.cancel(true);
                }
                stopDeferrableSurface();
            }
            zStop = super.stop();
        }
        return zStop;
    }

    public void stopDeferrableSurface() {
        if (this.mEnabledFeature.contains(SynchronizedCaptureSessionOpener.FEATURE_DEFERRABLE_SURFACE_CLOSE)) {
            this.mCaptureSessionRepository.unregisterDeferrableSurface(this);
            CallbackToFutureAdapter.Completer<Void> completer = this.mClosingDeferrableSurfaceCompleter;
            if (completer != null) {
                completer.set(null);
            }
        }
    }
}

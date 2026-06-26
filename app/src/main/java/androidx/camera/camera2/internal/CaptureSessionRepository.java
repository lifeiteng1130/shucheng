package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraDevice;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.camera.camera2.internal.CaptureSessionRepository;
import androidx.camera.core.impl.DeferrableSurface;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public class CaptureSessionRepository {

    @NonNull
    public final Executor mExecutor;
    public final Object mLock = new Object();

    @GuardedBy("mLock")
    public final Set<SynchronizedCaptureSession> mCaptureSessions = new LinkedHashSet();

    @GuardedBy("mLock")
    public final Set<SynchronizedCaptureSession> mClosingCaptureSession = new LinkedHashSet();

    @GuardedBy("mLock")
    public final Set<SynchronizedCaptureSession> mCreatingCaptureSessions = new LinkedHashSet();

    @GuardedBy("mLock")
    public final Map<SynchronizedCaptureSession, List<DeferrableSurface>> mDeferrableSurfaceMap = new HashMap();
    private final CameraDevice.StateCallback mCameraStateCallback = new AnonymousClass1();

    /* JADX INFO: renamed from: androidx.camera.camera2.internal.CaptureSessionRepository$1, reason: invalid class name */
    public class AnonymousClass1 extends CameraDevice.StateCallback {
        public AnonymousClass1() {
        }

        private void forceOnClosedCaptureSessions() {
            CaptureSessionRepository.this.mExecutor.execute(new Runnable() { // from class: b.a.a.d.k0
                @Override // java.lang.Runnable
                public final void run() {
                    CaptureSessionRepository.AnonymousClass1 anonymousClass1 = this.a;
                    Objects.requireNonNull(anonymousClass1);
                    LinkedHashSet linkedHashSet = new LinkedHashSet();
                    synchronized (CaptureSessionRepository.this.mLock) {
                        linkedHashSet.addAll(new LinkedHashSet(CaptureSessionRepository.this.mCreatingCaptureSessions));
                        linkedHashSet.addAll(new LinkedHashSet(CaptureSessionRepository.this.mCaptureSessions));
                    }
                    CaptureSessionRepository.forceOnClosed(linkedHashSet);
                }
            });
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onDisconnected(@NonNull CameraDevice cameraDevice) {
            forceOnClosedCaptureSessions();
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onError(@NonNull CameraDevice cameraDevice, int i2) {
            forceOnClosedCaptureSessions();
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onOpened(@NonNull CameraDevice cameraDevice) {
        }
    }

    public CaptureSessionRepository(@NonNull Executor executor) {
        this.mExecutor = executor;
    }

    public static void forceOnClosed(@NonNull Set<SynchronizedCaptureSession> set) {
        for (SynchronizedCaptureSession synchronizedCaptureSession : set) {
            synchronizedCaptureSession.getStateCallback().onClosed(synchronizedCaptureSession);
        }
    }

    @NonNull
    public CameraDevice.StateCallback getCameraStateCallback() {
        return this.mCameraStateCallback;
    }

    @NonNull
    public List<SynchronizedCaptureSession> getCaptureSessions() {
        ArrayList arrayList;
        synchronized (this.mLock) {
            arrayList = new ArrayList(this.mCaptureSessions);
        }
        return arrayList;
    }

    @NonNull
    public List<SynchronizedCaptureSession> getClosingCaptureSession() {
        ArrayList arrayList;
        synchronized (this.mLock) {
            arrayList = new ArrayList(this.mClosingCaptureSession);
        }
        return arrayList;
    }

    @NonNull
    public List<SynchronizedCaptureSession> getCreatingCaptureSessions() {
        ArrayList arrayList;
        synchronized (this.mLock) {
            arrayList = new ArrayList(this.mCreatingCaptureSessions);
        }
        return arrayList;
    }

    public void onCaptureSessionClosed(@NonNull SynchronizedCaptureSession synchronizedCaptureSession) {
        synchronized (this.mLock) {
            this.mCaptureSessions.remove(synchronizedCaptureSession);
            this.mClosingCaptureSession.remove(synchronizedCaptureSession);
        }
    }

    public void onCaptureSessionClosing(@NonNull SynchronizedCaptureSession synchronizedCaptureSession) {
        synchronized (this.mLock) {
            this.mClosingCaptureSession.add(synchronizedCaptureSession);
        }
    }

    public void onCaptureSessionConfigureFail(@NonNull SynchronizedCaptureSession synchronizedCaptureSession) {
        synchronized (this.mLock) {
            this.mCreatingCaptureSessions.remove(synchronizedCaptureSession);
        }
    }

    public void onCaptureSessionCreated(@NonNull SynchronizedCaptureSession synchronizedCaptureSession) {
        synchronized (this.mLock) {
            this.mCaptureSessions.add(synchronizedCaptureSession);
            this.mCreatingCaptureSessions.remove(synchronizedCaptureSession);
        }
    }

    public void onCreateCaptureSession(@NonNull SynchronizedCaptureSession synchronizedCaptureSession) {
        synchronized (this.mLock) {
            this.mCreatingCaptureSessions.add(synchronizedCaptureSession);
        }
    }

    public Map<SynchronizedCaptureSession, List<DeferrableSurface>> registerDeferrableSurface(@NonNull SynchronizedCaptureSession synchronizedCaptureSession, @NonNull List<DeferrableSurface> list) {
        HashMap map;
        synchronized (this.mLock) {
            this.mDeferrableSurfaceMap.put(synchronizedCaptureSession, list);
            map = new HashMap(this.mDeferrableSurfaceMap);
        }
        return map;
    }

    public void unregisterDeferrableSurface(@NonNull SynchronizedCaptureSession synchronizedCaptureSession) {
        synchronized (this.mLock) {
            this.mDeferrableSurfaceMap.remove(synchronizedCaptureSession);
        }
    }
}

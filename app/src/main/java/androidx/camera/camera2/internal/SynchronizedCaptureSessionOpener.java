package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraDevice;
import android.os.Build;
import android.os.Handler;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.camera.camera2.internal.SynchronizedCaptureSession;
import androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat;
import androidx.camera.camera2.internal.compat.params.SessionConfigurationCompat;
import androidx.camera.core.impl.DeferrableSurface;
import c.e.b.a.a.a;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: classes.dex */
public final class SynchronizedCaptureSessionOpener {
    public static final String FEATURE_DEFERRABLE_SURFACE_CLOSE = "deferrableSurface_close";
    public static final String FEATURE_FORCE_CLOSE = "force_close";
    public static final String FEATURE_WAIT_FOR_REQUEST = "wait_for_request";

    @NonNull
    private final OpenerImpl mImpl;

    public static class Builder {
        private final CaptureSessionRepository mCaptureSessionRepository;
        private final Handler mCompatHandler;
        private final Set<String> mEnableFeature;
        private final Executor mExecutor;
        private final ScheduledExecutorService mScheduledExecutorService;
        private final int mSupportedHardwareLevel;

        public Builder(@NonNull Executor executor, @NonNull ScheduledExecutorService scheduledExecutorService, @NonNull Handler handler, @NonNull CaptureSessionRepository captureSessionRepository, int i2) {
            HashSet hashSet = new HashSet();
            this.mEnableFeature = hashSet;
            this.mExecutor = executor;
            this.mScheduledExecutorService = scheduledExecutorService;
            this.mCompatHandler = handler;
            this.mCaptureSessionRepository = captureSessionRepository;
            this.mSupportedHardwareLevel = i2;
            int i3 = Build.VERSION.SDK_INT;
            if (i3 < 23) {
                hashSet.add(SynchronizedCaptureSessionOpener.FEATURE_FORCE_CLOSE);
            }
            if (i2 == 2 || i3 <= 23) {
                hashSet.add(SynchronizedCaptureSessionOpener.FEATURE_DEFERRABLE_SURFACE_CLOSE);
            }
            if (i2 == 2) {
                hashSet.add(SynchronizedCaptureSessionOpener.FEATURE_WAIT_FOR_REQUEST);
            }
        }

        @NonNull
        public SynchronizedCaptureSessionOpener build() {
            return this.mEnableFeature.isEmpty() ? new SynchronizedCaptureSessionOpener(new SynchronizedCaptureSessionBaseImpl(this.mCaptureSessionRepository, this.mExecutor, this.mScheduledExecutorService, this.mCompatHandler)) : new SynchronizedCaptureSessionOpener(new SynchronizedCaptureSessionImpl(this.mEnableFeature, this.mCaptureSessionRepository, this.mExecutor, this.mScheduledExecutorService, this.mCompatHandler));
        }
    }

    public interface OpenerImpl {
        @NonNull
        SessionConfigurationCompat createSessionConfigurationCompat(int i2, @NonNull List<OutputConfigurationCompat> list, @NonNull SynchronizedCaptureSession.StateCallback stateCallback);

        @NonNull
        Executor getExecutor();

        @NonNull
        a<Void> openCaptureSession(@NonNull CameraDevice cameraDevice, @NonNull SessionConfigurationCompat sessionConfigurationCompat);

        @NonNull
        a<List<Surface>> startWithDeferrableSurface(@NonNull List<DeferrableSurface> list, long j2);

        boolean stop();
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public @interface SynchronizedSessionFeature {
    }

    public SynchronizedCaptureSessionOpener(@NonNull OpenerImpl openerImpl) {
        this.mImpl = openerImpl;
    }

    @NonNull
    public SessionConfigurationCompat createSessionConfigurationCompat(int i2, @NonNull List<OutputConfigurationCompat> list, @NonNull SynchronizedCaptureSession.StateCallback stateCallback) {
        return this.mImpl.createSessionConfigurationCompat(i2, list, stateCallback);
    }

    @NonNull
    public Executor getExecutor() {
        return this.mImpl.getExecutor();
    }

    @NonNull
    public a<Void> openCaptureSession(@NonNull CameraDevice cameraDevice, @NonNull SessionConfigurationCompat sessionConfigurationCompat) {
        return this.mImpl.openCaptureSession(cameraDevice, sessionConfigurationCompat);
    }

    @NonNull
    public a<List<Surface>> startWithDeferrableSurface(@NonNull List<DeferrableSurface> list, long j2) {
        return this.mImpl.startWithDeferrableSurface(list, j2);
    }

    public boolean stop() {
        return this.mImpl.stop();
    }
}

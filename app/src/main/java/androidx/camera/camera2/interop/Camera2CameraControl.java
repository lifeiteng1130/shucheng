package androidx.camera.camera2.interop;

import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.camera.camera2.impl.Camera2ImplConfig;
import androidx.camera.camera2.internal.Camera2CameraControlImpl;
import androidx.camera.camera2.interop.Camera2CameraControl;
import androidx.camera.camera2.interop.CaptureRequestOptions;
import androidx.camera.core.CameraControl;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Preconditions;
import c.e.b.a.a.a;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
@ExperimentalCamera2Interop
public final class Camera2CameraControl {

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String TAG_KEY = "Camera2CameraControl";
    private final Camera2CameraControlImpl mCamera2CameraControlImpl;
    public CallbackToFutureAdapter.Completer<Void> mCompleter;
    public final Executor mExecutor;
    private boolean mIsActive = false;
    private boolean mPendingUpdate = false;
    public final Object mLock = new Object();

    @GuardedBy("mLock")
    private Camera2ImplConfig.Builder mBuilder = new Camera2ImplConfig.Builder();
    private final Camera2CameraControlImpl.CaptureResultListener mCaptureResultListener = new Camera2CameraControlImpl.CaptureResultListener() { // from class: b.a.a.e.d
        /* JADX WARN: Removed duplicated region for block: B:11:0x0032  */
        @Override // androidx.camera.camera2.internal.Camera2CameraControlImpl.CaptureResultListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final boolean onCaptureResult(android.hardware.camera2.TotalCaptureResult r4) {
            /*
                r3 = this;
                androidx.camera.camera2.interop.Camera2CameraControl r0 = r3.a
                androidx.concurrent.futures.CallbackToFutureAdapter$Completer<java.lang.Void> r1 = r0.mCompleter
                r2 = 0
                if (r1 == 0) goto L32
                android.hardware.camera2.CaptureRequest r4 = r4.getRequest()
                java.lang.Object r4 = r4.getTag()
                boolean r1 = r4 instanceof androidx.camera.core.impl.TagBundle
                if (r1 == 0) goto L32
                androidx.camera.core.impl.TagBundle r4 = (androidx.camera.core.impl.TagBundle) r4
                java.lang.String r1 = "Camera2CameraControl"
                java.lang.Integer r4 = r4.getTag(r1)
                if (r4 == 0) goto L32
                androidx.concurrent.futures.CallbackToFutureAdapter$Completer<java.lang.Void> r1 = r0.mCompleter
                int r1 = r1.hashCode()
                java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
                boolean r4 = r4.equals(r1)
                if (r4 == 0) goto L32
                androidx.concurrent.futures.CallbackToFutureAdapter$Completer<java.lang.Void> r4 = r0.mCompleter
                r0.mCompleter = r2
                goto L33
            L32:
                r4 = r2
            L33:
                if (r4 == 0) goto L38
                r4.set(r2)
            L38:
                r4 = 0
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: b.a.a.e.d.onCaptureResult(android.hardware.camera2.TotalCaptureResult):boolean");
        }
    };

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public Camera2CameraControl(@NonNull Camera2CameraControlImpl camera2CameraControlImpl, @NonNull Executor executor) {
        this.mCamera2CameraControlImpl = camera2CameraControlImpl;
        this.mExecutor = executor;
    }

    private void addCaptureRequestOptionsInternal(@NonNull CaptureRequestOptions captureRequestOptions) {
        synchronized (this.mLock) {
            for (Config.Option<?> option : captureRequestOptions.listOptions()) {
                this.mBuilder.getMutableConfig().insertOption(option, captureRequestOptions.retrieveOption(option));
            }
        }
    }

    private void clearCaptureRequestOptionsInternal() {
        synchronized (this.mLock) {
            this.mBuilder = new Camera2ImplConfig.Builder();
        }
    }

    @NonNull
    public static Camera2CameraControl from(@NonNull CameraControl cameraControl) {
        Preconditions.checkArgument(cameraControl instanceof Camera2CameraControlImpl, "CameraControl doesn't contain Camera2 implementation.");
        return ((Camera2CameraControlImpl) cameraControl).getCamera2CameraControl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: setActiveInternal, reason: merged with bridge method [inline-methods] */
    public void c(boolean z) {
        if (this.mIsActive == z) {
            return;
        }
        this.mIsActive = z;
        if (z) {
            if (this.mPendingUpdate) {
                updateSession();
            }
        } else {
            clearCaptureRequestOptionsInternal();
            CallbackToFutureAdapter.Completer<Void> completer = this.mCompleter;
            if (completer != null) {
                completer.setException(new CameraControl.OperationCanceledException("The camera control has became inactive."));
                this.mCompleter = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: updateConfig, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public void d(CallbackToFutureAdapter.Completer<Void> completer) {
        this.mPendingUpdate = true;
        CallbackToFutureAdapter.Completer<Void> completer2 = this.mCompleter;
        if (completer2 == null) {
            completer2 = null;
        }
        this.mCompleter = completer;
        if (this.mIsActive) {
            updateSession();
        }
        if (completer2 != null) {
            completer2.setException(new CameraControl.OperationCanceledException("Camera2CameraControl was updated with new options."));
        }
    }

    private void updateSession() {
        this.mCamera2CameraControlImpl.updateSessionConfig();
        this.mPendingUpdate = false;
    }

    @NonNull
    public a<Void> addCaptureRequestOptions(@NonNull CaptureRequestOptions captureRequestOptions) {
        addCaptureRequestOptionsInternal(captureRequestOptions);
        return Futures.nonCancellationPropagating(CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: b.a.a.e.h
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
            public final Object attachCompleter(final CallbackToFutureAdapter.Completer completer) {
                final Camera2CameraControl camera2CameraControl = this.a;
                camera2CameraControl.mExecutor.execute(new Runnable() { // from class: b.a.a.e.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        camera2CameraControl.a(completer);
                    }
                });
                return "addCaptureRequestOptions";
            }
        }));
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public a<Void> clearCaptureRequestOptions() {
        clearCaptureRequestOptionsInternal();
        return Futures.nonCancellationPropagating(CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: b.a.a.e.e
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
            public final Object attachCompleter(final CallbackToFutureAdapter.Completer completer) {
                final Camera2CameraControl camera2CameraControl = this.a;
                camera2CameraControl.mExecutor.execute(new Runnable() { // from class: b.a.a.e.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        camera2CameraControl.b(completer);
                    }
                });
                return "clearCaptureRequestOptions";
            }
        }));
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public Camera2ImplConfig getCamera2ImplConfig() {
        Camera2ImplConfig camera2ImplConfigBuild;
        synchronized (this.mLock) {
            if (this.mCompleter != null) {
                this.mBuilder.getMutableConfig().insertOption(Camera2ImplConfig.CAPTURE_REQUEST_TAG_OPTION, Integer.valueOf(this.mCompleter.hashCode()));
            }
            camera2ImplConfigBuild = this.mBuilder.build();
        }
        return camera2ImplConfigBuild;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public Camera2CameraControlImpl.CaptureResultListener getCaptureRequestListener() {
        return this.mCaptureResultListener;
    }

    @NonNull
    public CaptureRequestOptions getCaptureRequestOptions() {
        CaptureRequestOptions captureRequestOptionsBuild;
        synchronized (this.mLock) {
            captureRequestOptionsBuild = CaptureRequestOptions.Builder.from(this.mBuilder.build()).build();
        }
        return captureRequestOptionsBuild;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void setActive(final boolean z) {
        this.mExecutor.execute(new Runnable() { // from class: b.a.a.e.g
            @Override // java.lang.Runnable
            public final void run() {
                this.a.c(z);
            }
        });
    }

    @NonNull
    public a<Void> setCaptureRequestOptions(@NonNull CaptureRequestOptions captureRequestOptions) {
        clearCaptureRequestOptionsInternal();
        addCaptureRequestOptionsInternal(captureRequestOptions);
        return Futures.nonCancellationPropagating(CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: b.a.a.e.f
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
            public final Object attachCompleter(final CallbackToFutureAdapter.Completer completer) {
                final Camera2CameraControl camera2CameraControl = this.a;
                camera2CameraControl.mExecutor.execute(new Runnable() { // from class: b.a.a.e.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        camera2CameraControl.d(completer);
                    }
                });
                return "setCaptureRequestOptions";
            }
        }));
    }
}

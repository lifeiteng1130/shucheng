package androidx.camera.core.impl;

import android.graphics.Rect;
import androidx.annotation.NonNull;
import androidx.camera.core.CameraControl;
import androidx.camera.core.ExperimentalExposureCompensation;
import androidx.camera.core.FocusMeteringAction;
import androidx.camera.core.FocusMeteringResult;
import androidx.camera.core.impl.CameraCaptureResult;
import androidx.camera.core.impl.utils.futures.Futures;
import c.e.b.a.a.a;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface CameraControlInternal extends CameraControl {
    public static final CameraControlInternal DEFAULT_EMPTY_INSTANCE = new CameraControlInternal() { // from class: androidx.camera.core.impl.CameraControlInternal.1
        @Override // androidx.camera.core.impl.CameraControlInternal
        public void addInteropConfig(@NonNull Config config) {
        }

        @Override // androidx.camera.core.impl.CameraControlInternal
        public void cancelAfAeTrigger(boolean z, boolean z2) {
        }

        @Override // androidx.camera.core.CameraControl
        @NonNull
        public a<Void> cancelFocusAndMetering() {
            return Futures.immediateFuture(null);
        }

        @Override // androidx.camera.core.impl.CameraControlInternal
        public void clearInteropConfig() {
        }

        @Override // androidx.camera.core.CameraControl
        @NonNull
        public a<Void> enableTorch(boolean z) {
            return Futures.immediateFuture(null);
        }

        @Override // androidx.camera.core.impl.CameraControlInternal
        public int getFlashMode() {
            return 2;
        }

        @Override // androidx.camera.core.impl.CameraControlInternal
        @NonNull
        public Config getInteropConfig() {
            return null;
        }

        @Override // androidx.camera.core.impl.CameraControlInternal
        @NonNull
        public Rect getSensorRect() {
            return new Rect();
        }

        @Override // androidx.camera.core.impl.CameraControlInternal, androidx.camera.core.CameraControl
        @NonNull
        @ExperimentalExposureCompensation
        public a<Integer> setExposureCompensationIndex(int i2) {
            return Futures.immediateFuture(0);
        }

        @Override // androidx.camera.core.impl.CameraControlInternal
        public void setFlashMode(int i2) {
        }

        @Override // androidx.camera.core.CameraControl
        @NonNull
        public a<Void> setLinearZoom(float f2) {
            return Futures.immediateFuture(null);
        }

        @Override // androidx.camera.core.CameraControl
        @NonNull
        public a<Void> setZoomRatio(float f2) {
            return Futures.immediateFuture(null);
        }

        @Override // androidx.camera.core.CameraControl
        @NonNull
        public a<FocusMeteringResult> startFocusAndMetering(@NonNull FocusMeteringAction focusMeteringAction) {
            return Futures.immediateFuture(FocusMeteringResult.emptyInstance());
        }

        @Override // androidx.camera.core.impl.CameraControlInternal
        public void submitCaptureRequests(@NonNull List<CaptureConfig> list) {
        }

        @Override // androidx.camera.core.impl.CameraControlInternal
        @NonNull
        public a<CameraCaptureResult> triggerAePrecapture() {
            return Futures.immediateFuture(CameraCaptureResult.EmptyCameraCaptureResult.create());
        }

        @Override // androidx.camera.core.impl.CameraControlInternal
        @NonNull
        public a<CameraCaptureResult> triggerAf() {
            return Futures.immediateFuture(CameraCaptureResult.EmptyCameraCaptureResult.create());
        }
    };

    public interface ControlUpdateCallback {
        void onCameraControlCaptureRequests(@NonNull List<CaptureConfig> list);

        void onCameraControlUpdateSessionConfig(@NonNull SessionConfig sessionConfig);
    }

    void addInteropConfig(@NonNull Config config);

    void cancelAfAeTrigger(boolean z, boolean z2);

    void clearInteropConfig();

    int getFlashMode();

    @NonNull
    Config getInteropConfig();

    @NonNull
    Rect getSensorRect();

    @Override // androidx.camera.core.CameraControl
    @NonNull
    @ExperimentalExposureCompensation
    a<Integer> setExposureCompensationIndex(int i2);

    void setFlashMode(int i2);

    void submitCaptureRequests(@NonNull List<CaptureConfig> list);

    @NonNull
    a<CameraCaptureResult> triggerAePrecapture();

    @NonNull
    a<CameraCaptureResult> triggerAf();

    public static final class CameraControlException extends Exception {

        @NonNull
        private CameraCaptureFailure mCameraCaptureFailure;

        public CameraControlException(@NonNull CameraCaptureFailure cameraCaptureFailure) {
            this.mCameraCaptureFailure = cameraCaptureFailure;
        }

        @NonNull
        public CameraCaptureFailure getCameraCaptureFailure() {
            return this.mCameraCaptureFailure;
        }

        public CameraControlException(@NonNull CameraCaptureFailure cameraCaptureFailure, @NonNull Throwable th) {
            super(th);
            this.mCameraCaptureFailure = cameraCaptureFailure;
        }
    }
}

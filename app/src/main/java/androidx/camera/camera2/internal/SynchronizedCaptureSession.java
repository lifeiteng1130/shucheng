package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CaptureRequest;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.camera.camera2.internal.compat.CameraCaptureSessionCompat;
import c.e.b.a.a.a;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public interface SynchronizedCaptureSession {

    public static abstract class StateCallback {
        public void onActive(@NonNull SynchronizedCaptureSession synchronizedCaptureSession) {
        }

        @RequiresApi(api = 26)
        public void onCaptureQueueEmpty(@NonNull SynchronizedCaptureSession synchronizedCaptureSession) {
        }

        public void onClosed(@NonNull SynchronizedCaptureSession synchronizedCaptureSession) {
        }

        public void onConfigureFailed(@NonNull SynchronizedCaptureSession synchronizedCaptureSession) {
        }

        public void onConfigured(@NonNull SynchronizedCaptureSession synchronizedCaptureSession) {
        }

        public void onReady(@NonNull SynchronizedCaptureSession synchronizedCaptureSession) {
        }

        @RequiresApi(api = 23)
        public void onSurfacePrepared(@NonNull SynchronizedCaptureSession synchronizedCaptureSession, @NonNull Surface surface) {
        }
    }

    void abortCaptures();

    int captureBurstRequests(@NonNull List<CaptureRequest> list, @NonNull CameraCaptureSession.CaptureCallback captureCallback);

    int captureBurstRequests(@NonNull List<CaptureRequest> list, @NonNull Executor executor, @NonNull CameraCaptureSession.CaptureCallback captureCallback);

    int captureSingleRequest(@NonNull CaptureRequest captureRequest, @NonNull CameraCaptureSession.CaptureCallback captureCallback);

    int captureSingleRequest(@NonNull CaptureRequest captureRequest, @NonNull Executor executor, @NonNull CameraCaptureSession.CaptureCallback captureCallback);

    void close();

    @NonNull
    CameraDevice getDevice();

    @NonNull
    StateCallback getStateCallback();

    @NonNull
    a<Void> getSynchronizedBlocker(@NonNull String str);

    int setRepeatingBurstRequests(@NonNull List<CaptureRequest> list, @NonNull CameraCaptureSession.CaptureCallback captureCallback);

    int setRepeatingBurstRequests(@NonNull List<CaptureRequest> list, @NonNull Executor executor, @NonNull CameraCaptureSession.CaptureCallback captureCallback);

    int setSingleRepeatingRequest(@NonNull CaptureRequest captureRequest, @NonNull CameraCaptureSession.CaptureCallback captureCallback);

    int setSingleRepeatingRequest(@NonNull CaptureRequest captureRequest, @NonNull Executor executor, @NonNull CameraCaptureSession.CaptureCallback captureCallback);

    void stopRepeating();

    @NonNull
    CameraCaptureSessionCompat toCameraCaptureSessionCompat();
}

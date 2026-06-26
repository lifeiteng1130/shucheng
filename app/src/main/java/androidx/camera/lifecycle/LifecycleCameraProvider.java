package androidx.camera.lifecycle;

import androidx.annotation.NonNull;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.UseCase;

/* JADX INFO: loaded from: classes.dex */
public interface LifecycleCameraProvider {
    boolean hasCamera(@NonNull CameraSelector cameraSelector);

    boolean isBound(@NonNull UseCase useCase);

    void unbind(@NonNull UseCase... useCaseArr);

    void unbindAll();
}

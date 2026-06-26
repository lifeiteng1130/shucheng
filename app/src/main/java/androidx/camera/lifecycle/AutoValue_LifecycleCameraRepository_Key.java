package androidx.camera.lifecycle;

import androidx.annotation.NonNull;
import androidx.camera.core.internal.CameraUseCaseAdapter;
import androidx.camera.lifecycle.LifecycleCameraRepository;
import androidx.view.LifecycleOwner;
import c.a.a.a.a;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class AutoValue_LifecycleCameraRepository_Key extends LifecycleCameraRepository.Key {
    private final CameraUseCaseAdapter.CameraId cameraId;
    private final LifecycleOwner lifecycleOwner;

    public AutoValue_LifecycleCameraRepository_Key(LifecycleOwner lifecycleOwner, CameraUseCaseAdapter.CameraId cameraId) {
        Objects.requireNonNull(lifecycleOwner, "Null lifecycleOwner");
        this.lifecycleOwner = lifecycleOwner;
        Objects.requireNonNull(cameraId, "Null cameraId");
        this.cameraId = cameraId;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LifecycleCameraRepository.Key)) {
            return false;
        }
        LifecycleCameraRepository.Key key = (LifecycleCameraRepository.Key) obj;
        return this.lifecycleOwner.equals(key.getLifecycleOwner()) && this.cameraId.equals(key.getCameraId());
    }

    @Override // androidx.camera.lifecycle.LifecycleCameraRepository.Key
    @NonNull
    public CameraUseCaseAdapter.CameraId getCameraId() {
        return this.cameraId;
    }

    @Override // androidx.camera.lifecycle.LifecycleCameraRepository.Key
    @NonNull
    public LifecycleOwner getLifecycleOwner() {
        return this.lifecycleOwner;
    }

    public int hashCode() {
        return ((this.lifecycleOwner.hashCode() ^ 1000003) * 1000003) ^ this.cameraId.hashCode();
    }

    public String toString() {
        StringBuilder sbR = a.r("Key{lifecycleOwner=");
        sbR.append(this.lifecycleOwner);
        sbR.append(", cameraId=");
        sbR.append(this.cameraId);
        sbR.append("}");
        return sbR.toString();
    }
}

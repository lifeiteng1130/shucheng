package androidx.camera.camera2.internal.compat;

import android.hardware.camera2.CameraCharacteristics;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class CameraCharacteristicsCompat {

    @NonNull
    private final CameraCharacteristics mCameraCharacteristics;

    @NonNull
    @GuardedBy("this")
    private final Map<CameraCharacteristics.Key<?>, Object> mValuesCache = new HashMap();

    private CameraCharacteristicsCompat(@NonNull CameraCharacteristics cameraCharacteristics) {
        this.mCameraCharacteristics = cameraCharacteristics;
    }

    @NonNull
    @VisibleForTesting(otherwise = 3)
    public static CameraCharacteristicsCompat toCameraCharacteristicsCompat(@NonNull CameraCharacteristics cameraCharacteristics) {
        return new CameraCharacteristicsCompat(cameraCharacteristics);
    }

    @Nullable
    public <T> T get(@NonNull CameraCharacteristics.Key<T> key) {
        synchronized (this) {
            T t = (T) this.mValuesCache.get(key);
            if (t != null) {
                return t;
            }
            T t2 = (T) this.mCameraCharacteristics.get(key);
            if (t2 != null) {
                this.mValuesCache.put((CameraCharacteristics.Key<?>) key, t2);
            }
            return t2;
        }
    }

    @NonNull
    public CameraCharacteristics toCameraCharacteristics() {
        return this.mCameraCharacteristics;
    }
}

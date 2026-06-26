package b.a.b.w1;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.core.CameraControl;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.impl.CameraConfig;
import androidx.camera.core.impl.CameraConfigs;
import androidx.camera.core.impl.CameraInternal;
import java.util.Collections;
import java.util.LinkedHashSet;

/* JADX INFO: compiled from: CameraInternal.java */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class q {
    @NonNull
    public static CameraControl a(CameraInternal _this) {
        return _this.getCameraControlInternal();
    }

    @NonNull
    public static CameraInfo b(CameraInternal _this) {
        return _this.getCameraInfoInternal();
    }

    @NonNull
    public static LinkedHashSet c(CameraInternal _this) {
        return new LinkedHashSet(Collections.singleton(_this));
    }

    @NonNull
    public static CameraConfig d(CameraInternal _this) {
        return CameraConfigs.emptyConfig();
    }

    public static void e(@Nullable CameraInternal cameraInternal, CameraConfig cameraConfig) {
    }
}

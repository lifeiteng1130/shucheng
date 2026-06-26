package b.a.b.w1;

import androidx.annotation.NonNull;
import androidx.camera.core.CameraFilter;
import androidx.camera.core.impl.CameraConfig;
import androidx.camera.core.impl.CameraFilters;

/* JADX INFO: compiled from: CameraConfig.java */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class p {
    @NonNull
    public static CameraFilter a(CameraConfig _this) {
        return (CameraFilter) _this.retrieveOption(CameraConfig.OPTION_CAMERA_FILTER, CameraFilters.ANY);
    }
}

package androidx.camera.core;

import androidx.annotation.NonNull;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@ExperimentalCameraFilter
public interface CameraFilter {
    @NonNull
    List<CameraInfo> filter(@NonNull List<CameraInfo> list);
}

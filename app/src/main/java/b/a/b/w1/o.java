package b.a.b.w1;

import androidx.annotation.NonNull;
import androidx.camera.core.impl.CameraCaptureResult;
import androidx.camera.core.impl.utils.ExifData;

/* JADX INFO: compiled from: CameraCaptureResult.java */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class o {
    public static void a(@NonNull CameraCaptureResult _this, ExifData.Builder builder) {
        builder.setFlashState(_this.getFlashState());
    }
}

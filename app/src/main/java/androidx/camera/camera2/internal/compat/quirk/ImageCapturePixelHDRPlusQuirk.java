package androidx.camera.camera2.internal.compat.quirk;

import android.os.Build;
import androidx.camera.core.impl.Quirk;

/* JADX INFO: loaded from: classes.dex */
public class ImageCapturePixelHDRPlusQuirk implements Quirk {
    private static boolean isPixel2() {
        return "Google".equals(Build.MANUFACTURER) && "Pixel 2".equals(Build.MODEL);
    }

    private static boolean isPixel3() {
        return "Google".equals(Build.MANUFACTURER) && "Pixel 3".equals(Build.MODEL);
    }

    public static boolean load() {
        return (isPixel2() || isPixel3()) && Build.VERSION.SDK_INT >= 26;
    }
}

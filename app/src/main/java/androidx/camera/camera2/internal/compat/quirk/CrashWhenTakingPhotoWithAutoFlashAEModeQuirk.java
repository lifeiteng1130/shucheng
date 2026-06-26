package androidx.camera.camera2.internal.compat.quirk;

import android.os.Build;
import androidx.camera.core.impl.Quirk;

/* JADX INFO: loaded from: classes.dex */
public class CrashWhenTakingPhotoWithAutoFlashAEModeQuirk implements Quirk {
    public static boolean load() {
        return "SAMSUNG".equals(Build.MANUFACTURER.toUpperCase()) && Build.MODEL.toUpperCase().startsWith("SM-A300");
    }
}

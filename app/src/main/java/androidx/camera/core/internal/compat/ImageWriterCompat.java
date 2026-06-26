package androidx.camera.core.internal.compat;

import android.media.ImageWriter;
import android.os.Build;
import android.view.Surface;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import c.a.a.a.a;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(26)
public final class ImageWriterCompat {
    private ImageWriterCompat() {
    }

    @NonNull
    public static ImageWriter newInstance(@NonNull Surface surface, @IntRange(from = 1) int i2, int i3) {
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 26) {
            return ImageWriterCompatApi26Impl.newInstance(surface, i2, i3);
        }
        if (i4 >= 29) {
            return ImageWriterCompatApi29Impl.newInstance(surface, i2, i3);
        }
        throw new RuntimeException(a.d("Unable to call newInstance(Surface, int, int) on API ", i4, ". Version 26 or higher required."));
    }
}

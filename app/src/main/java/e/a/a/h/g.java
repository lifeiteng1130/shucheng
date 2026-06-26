package e.a.a.h;

import android.graphics.Color;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.core.view.ViewCompat;

/* JADX INFO: compiled from: ColorUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class g {
    @ColorInt
    public static final int a(@ColorInt int i2) {
        return c(i2, 0.9f);
    }

    public static final boolean b(@ColorInt int i2) {
        return ((double) 1) - (((((double) Color.blue(i2)) * 0.114d) + ((((double) Color.green(i2)) * 0.587d) + (((double) Color.red(i2)) * 0.299d))) / ((double) 255)) < 0.4d;
    }

    @ColorInt
    public static final int c(@ColorInt int i2, @FloatRange(from = 0.0d, to = 2.0d) float f2) {
        if (f2 == 1.0f) {
            return i2;
        }
        int iAlpha = Color.alpha(i2);
        float[] fArr = new float[3];
        Color.colorToHSV(i2, fArr);
        fArr[2] = fArr[2] * f2;
        return (iAlpha << 24) + (16777215 & Color.HSVToColor(fArr));
    }

    @ColorInt
    public static final int d(@ColorInt int i2, @FloatRange(from = 0.0d, to = 1.0d) float f2) {
        return (Math.min(255, Math.max(0, (int) (f2 * 255))) << 24) + (i2 & ViewCompat.MEASURED_SIZE_MASK);
    }
}

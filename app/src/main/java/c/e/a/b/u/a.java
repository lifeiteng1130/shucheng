package c.e.a.b.u;

import android.R;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.util.StateSet;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.core.graphics.ColorUtils;

/* JADX INFO: compiled from: RippleUtils.java */
/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class a {
    public static final int[] a = {R.attr.state_pressed};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int[] f1204b = {R.attr.state_hovered, R.attr.state_focused};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int[] f1205c = {R.attr.state_focused};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int[] f1206d = {R.attr.state_hovered};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int[] f1207e = {R.attr.state_selected, R.attr.state_pressed};

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int[] f1208f = {R.attr.state_selected, R.attr.state_hovered, R.attr.state_focused};

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int[] f1209g = {R.attr.state_selected, R.attr.state_focused};

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int[] f1210h = {R.attr.state_selected, R.attr.state_hovered};

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int[] f1211i = {R.attr.state_selected};

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int[] f1212j = {R.attr.state_enabled, R.attr.state_pressed};

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @VisibleForTesting
    public static final String f1213k = a.class.getSimpleName();

    @NonNull
    public static ColorStateList a(@Nullable ColorStateList colorStateList) {
        return new ColorStateList(new int[][]{f1211i, StateSet.NOTHING}, new int[]{b(colorStateList, f1207e), b(colorStateList, a)});
    }

    @ColorInt
    public static int b(@Nullable ColorStateList colorStateList, int[] iArr) {
        int colorForState = colorStateList != null ? colorStateList.getColorForState(iArr, colorStateList.getDefaultColor()) : 0;
        return ColorUtils.setAlphaComponent(colorForState, Math.min(Color.alpha(colorForState) * 2, 255));
    }

    @NonNull
    public static ColorStateList c(@Nullable ColorStateList colorStateList) {
        if (colorStateList == null) {
            return ColorStateList.valueOf(0);
        }
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 22 && i2 <= 27 && Color.alpha(colorStateList.getDefaultColor()) == 0) {
            Color.alpha(colorStateList.getColorForState(f1212j, 0));
        }
        return colorStateList;
    }

    public static boolean d(@NonNull int[] iArr) {
        boolean z = false;
        boolean z2 = false;
        for (int i2 : iArr) {
            if (i2 == 16842910) {
                z = true;
            } else if (i2 == 16842908 || i2 == 16842919 || i2 == 16843623) {
                z2 = true;
            }
        }
        return z && z2;
    }
}

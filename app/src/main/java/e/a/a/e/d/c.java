package e.a.a.e.d;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.widget.CheckBox;
import androidx.annotation.CheckResult;
import androidx.annotation.ColorInt;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import c.b.a.m.f;
import f.c0.c.j;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: TintHelper.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c {

    @NotNull
    public static final c a = new c();

    @CheckResult
    @Nullable
    public final Drawable a(@Nullable Drawable drawable, @ColorInt int i2) {
        if (drawable == null) {
            return null;
        }
        Drawable drawableWrap = DrawableCompat.wrap(drawable.mutate());
        j.c(drawableWrap);
        DrawableCompat.setTintMode(drawableWrap, PorterDuff.Mode.SRC_IN);
        DrawableCompat.setTint(drawableWrap, i2);
        return drawableWrap;
    }

    @CheckResult
    @Nullable
    public final Drawable b(@Nullable Drawable drawable, @NotNull ColorStateList colorStateList) {
        j.e(colorStateList, "sl");
        if (drawable == null) {
            return null;
        }
        Drawable drawableWrap = DrawableCompat.wrap(drawable.mutate());
        j.c(drawableWrap);
        DrawableCompat.setTintList(drawableWrap, colorStateList);
        return drawableWrap;
    }

    public final ColorStateList c(@ColorInt int i2, @ColorInt int i3) {
        return new ColorStateList(new int[][]{new int[]{-16842910}, new int[]{R.attr.state_enabled}}, new int[]{i3, i2});
    }

    public final Drawable d(Context context, Drawable drawable, @ColorInt int i2, boolean z, boolean z2, boolean z3) {
        int color;
        int color2;
        if (z3) {
            int iAlpha = Color.alpha(i2);
            float[] fArr = new float[3];
            Color.colorToHSV(i2, fArr);
            fArr[2] = fArr[2] * 1.1f;
            i2 = (iAlpha << 24) + (16777215 & Color.HSVToColor(fArr));
        }
        int iArgb = Color.argb(f.S4(Color.alpha(i2) * ((!z2 || z) ? 1.0f : 0.5f)), Color.red(i2), Color.green(i2), Color.blue(i2));
        if (z) {
            color = ContextCompat.getColor(context, z3 ? io.wenyuange.app.release.R.color.ate_switch_thumb_disabled_dark : io.wenyuange.app.release.R.color.ate_switch_thumb_disabled_light);
            color2 = ContextCompat.getColor(context, z3 ? io.wenyuange.app.release.R.color.ate_switch_thumb_normal_dark : io.wenyuange.app.release.R.color.ate_switch_thumb_normal_light);
        } else {
            color = ContextCompat.getColor(context, z3 ? io.wenyuange.app.release.R.color.ate_switch_track_disabled_dark : io.wenyuange.app.release.R.color.ate_switch_track_disabled_light);
            color2 = ContextCompat.getColor(context, z3 ? io.wenyuange.app.release.R.color.ate_switch_track_normal_dark : io.wenyuange.app.release.R.color.ate_switch_track_normal_light);
        }
        if (!z2) {
            color2 |= ViewCompat.MEASURED_STATE_MASK;
        }
        return b(drawable, new ColorStateList(new int[][]{new int[]{-16842910}, new int[]{R.attr.state_enabled, -16843518, -16842912}, new int[]{R.attr.state_enabled, R.attr.state_activated}, new int[]{R.attr.state_enabled, R.attr.state_checked}}, new int[]{color, color2, iArgb, iArgb}));
    }

    @SuppressLint({"PrivateResource"})
    public final void e(@NotNull CheckBox checkBox, @ColorInt int i2, boolean z) {
        j.e(checkBox, "box");
        int[][] iArr = {new int[]{-16842910}, new int[]{R.attr.state_enabled, -16842912}, new int[]{R.attr.state_enabled, R.attr.state_checked}};
        int[] iArr2 = new int[3];
        iArr2[0] = ContextCompat.getColor(checkBox.getContext(), z ? io.wenyuange.app.release.R.color.ate_control_disabled_dark : io.wenyuange.app.release.R.color.ate_control_disabled_light);
        iArr2[1] = ContextCompat.getColor(checkBox.getContext(), z ? io.wenyuange.app.release.R.color.ate_control_normal_dark : io.wenyuange.app.release.R.color.ate_control_normal_light);
        iArr2[2] = i2;
        checkBox.setButtonTintList(new ColorStateList(iArr, iArr2));
    }

    /* JADX WARN: Removed duplicated region for block: B:75:0x027e  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0295  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0299  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void f(@org.jetbrains.annotations.NotNull android.view.View r19, @androidx.annotation.ColorInt int r20, boolean r21, boolean r22) {
        /*
            Method dump skipped, instruction units count: 1176
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: e.a.a.e.d.c.f(android.view.View, int, boolean, boolean):void");
    }
}

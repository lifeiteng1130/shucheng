package c.e.a.b.n;

import android.content.Context;
import android.graphics.Color;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.core.graphics.ColorUtils;
import c.b.a.m.f;
import com.google.android.material.R$attr;

/* JADX INFO: compiled from: ElevationOverlayProvider.java */
/* JADX INFO: loaded from: classes.dex */
public class a {
    public final boolean a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f1047b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f1048c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f1049d;

    public a(@NonNull Context context) {
        this.a = f.M4(context, R$attr.elevationOverlayEnabled, false);
        this.f1047b = f.Y1(context, R$attr.elevationOverlayColor, 0);
        this.f1048c = f.Y1(context, R$attr.colorSurface, 0);
        this.f1049d = context.getResources().getDisplayMetrics().density;
    }

    @ColorInt
    public int a(@ColorInt int i2, float f2) {
        if (!this.a) {
            return i2;
        }
        if (!(ColorUtils.setAlphaComponent(i2, 255) == this.f1048c)) {
            return i2;
        }
        float fMin = 0.0f;
        if (this.f1049d > 0.0f && f2 > 0.0f) {
            fMin = Math.min(((((float) Math.log1p(f2 / r1)) * 4.5f) + 2.0f) / 100.0f, 1.0f);
        }
        return ColorUtils.setAlphaComponent(f.M3(ColorUtils.setAlphaComponent(i2, 255), this.f1047b, fMin), Color.alpha(i2));
    }
}

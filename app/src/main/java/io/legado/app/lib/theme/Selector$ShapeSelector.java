package io.legado.app.lib.theme;

import android.R;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import androidx.annotation.ColorInt;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Selector.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class Selector$ShapeSelector {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f6909f;
    public int m;
    public boolean o;
    public boolean p;
    public boolean q;
    public boolean r;
    public boolean s;
    public int a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f6905b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f6906c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f6907d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f6908e = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f6910g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f6911h = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f6912i = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f6913j = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f6914k = 0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f6915l = 0;
    public int n = 0;

    /* JADX INFO: compiled from: Selector.kt */
    @Retention(RetentionPolicy.RUNTIME)
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0082\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lio/legado/app/lib/theme/Selector$ShapeSelector$Shape;", "", "<init>", "()V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
    public @interface Shape {
    }

    @NotNull
    public final StateListDrawable a() {
        StateListDrawable stateListDrawable = new StateListDrawable();
        if (this.q) {
            stateListDrawable.addState(new int[]{-16842910}, b(0, this.n, this.f6905b, this.f6910g, this.f6912i));
        }
        if (this.o) {
            stateListDrawable.addState(new int[]{R.attr.state_pressed}, b(0, this.n, this.f6906c, this.f6910g, this.f6913j));
        }
        if (this.r) {
            stateListDrawable.addState(new int[]{R.attr.state_selected}, b(0, this.n, this.f6907d, this.f6910g, this.f6914k));
        }
        if (this.p || this.s) {
            stateListDrawable.addState(new int[]{R.attr.state_checked}, b(0, this.n, this.f6909f, this.f6910g, this.m));
        }
        stateListDrawable.addState(new int[0], b(0, this.n, this.a, this.f6910g, this.f6911h));
        return stateListDrawable;
    }

    public final GradientDrawable b(int i2, int i3, int i4, int i5, int i6) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(i2);
        gradientDrawable.setStroke(i5, i6);
        gradientDrawable.setCornerRadius(i3);
        gradientDrawable.setColor(i4);
        return gradientDrawable;
    }

    @NotNull
    public final Selector$ShapeSelector c(@ColorInt int i2) {
        this.f6911h = i2;
        if (!this.q) {
            this.f6912i = i2;
        }
        this.f6913j = i2;
        if (!this.r) {
            this.f6914k = i2;
        }
        this.f6915l = i2;
        return this;
    }

    @NotNull
    public final Selector$ShapeSelector d(@ColorInt int i2) {
        this.f6912i = i2;
        this.q = true;
        return this;
    }

    @NotNull
    public final Selector$ShapeSelector e(@ColorInt int i2) {
        this.f6906c = i2;
        this.o = true;
        return this;
    }

    @NotNull
    public final Selector$ShapeSelector f(@ColorInt int i2) {
        this.f6914k = i2;
        this.r = true;
        return this;
    }
}

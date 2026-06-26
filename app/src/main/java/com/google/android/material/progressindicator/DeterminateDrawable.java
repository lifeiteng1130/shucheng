package com.google.android.material.progressindicator;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import androidx.annotation.NonNull;
import androidx.dynamicanimation.animation.FloatPropertyCompat;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;
import c.b.a.m.f;
import c.e.a.b.s.b;
import c.e.a.b.s.j;
import c.e.a.b.s.k;

/* JADX INFO: loaded from: classes.dex */
public final class DeterminateDrawable<S extends b> extends j {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final FloatPropertyCompat<DeterminateDrawable> f2325l = new a("indicatorLevel");
    public k<S> m;
    public final SpringForce n;
    public final SpringAnimation o;
    public float p;
    public boolean q;

    public static class a extends FloatPropertyCompat<DeterminateDrawable> {
        public a(String str) {
            super(str);
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public float getValue(DeterminateDrawable determinateDrawable) {
            return determinateDrawable.p * 10000.0f;
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public void setValue(DeterminateDrawable determinateDrawable, float f2) {
            DeterminateDrawable determinateDrawable2 = determinateDrawable;
            determinateDrawable2.p = f2 / 10000.0f;
            determinateDrawable2.invalidateSelf();
        }
    }

    public DeterminateDrawable(@NonNull Context context, @NonNull b bVar, @NonNull k<S> kVar) {
        super(context, bVar);
        this.q = false;
        this.m = kVar;
        kVar.f1163b = this;
        SpringForce springForce = new SpringForce();
        this.n = springForce;
        springForce.setDampingRatio(1.0f);
        springForce.setStiffness(50.0f);
        SpringAnimation springAnimation = new SpringAnimation(this, f2325l);
        this.o = springAnimation;
        springAnimation.setSpring(springForce);
        if (this.f1160i != 1.0f) {
            this.f1160i = 1.0f;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        Rect rect = new Rect();
        if (!getBounds().isEmpty() && isVisible() && canvas.getClipBounds(rect)) {
            canvas.save();
            k<S> kVar = this.m;
            float fC = c();
            kVar.a.a();
            kVar.a(canvas, fC);
            this.m.c(canvas, this.f1161j);
            this.m.b(canvas, this.f1161j, 0.0f, this.p, f.W0(this.f1154c.f1133c[0], this.f1162k));
            canvas.restore();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.m.d();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.m.e();
    }

    @Override // c.e.a.b.s.j
    public boolean h(boolean z, boolean z2, boolean z3) {
        boolean zH = super.h(z, z2, z3);
        float fA = this.f1155d.a(this.f1153b.getContentResolver());
        if (fA == 0.0f) {
            this.q = true;
        } else {
            this.q = false;
            this.n.setStiffness(50.0f / fA);
        }
        return zH;
    }

    @Override // android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        this.o.cancel();
        this.p = getLevel() / 10000.0f;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLevelChange(int i2) {
        if (!this.q) {
            this.o.setStartValue(this.p * 10000.0f);
            this.o.animateToFinalPosition(i2);
            return true;
        }
        this.o.cancel();
        this.p = i2 / 10000.0f;
        invalidateSelf();
        return true;
    }
}

package com.google.android.material.progressindicator;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build;
import androidx.annotation.NonNull;
import c.e.a.b.s.b;
import c.e.a.b.s.j;
import c.e.a.b.s.k;
import c.e.a.b.s.l;

/* JADX INFO: loaded from: classes.dex */
public final class IndeterminateDrawable<S extends b> extends j {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public k<S> f2326l;
    public l<ObjectAnimator> m;

    public IndeterminateDrawable(@NonNull Context context, @NonNull b bVar, @NonNull k<S> kVar, @NonNull l<ObjectAnimator> lVar) {
        super(context, bVar);
        this.f2326l = kVar;
        kVar.f1163b = this;
        this.m = lVar;
        lVar.a = this;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        Rect rect = new Rect();
        if (getBounds().isEmpty() || !isVisible() || !canvas.getClipBounds(rect)) {
            return;
        }
        canvas.save();
        k<S> kVar = this.f2326l;
        float fC = c();
        kVar.a.a();
        kVar.a(canvas, fC);
        this.f2326l.c(canvas, this.f1161j);
        int i2 = 0;
        while (true) {
            l<ObjectAnimator> lVar = this.m;
            int[] iArr = lVar.f1165c;
            if (i2 >= iArr.length) {
                canvas.restore();
                return;
            }
            k<S> kVar2 = this.f2326l;
            Paint paint = this.f1161j;
            float[] fArr = lVar.f1164b;
            int i3 = i2 * 2;
            kVar2.b(canvas, paint, fArr[i3], fArr[i3 + 1], iArr[i2]);
            i2++;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f2326l.d();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f2326l.e();
    }

    @Override // c.e.a.b.s.j
    public boolean h(boolean z, boolean z2, boolean z3) {
        boolean zH = super.h(z, z2, z3);
        if (!isRunning()) {
            this.m.a();
        }
        float fA = this.f1155d.a(this.f1153b.getContentResolver());
        if (z && (z3 || (Build.VERSION.SDK_INT <= 21 && fA > 0.0f))) {
            this.m.f();
        }
        return zH;
    }
}

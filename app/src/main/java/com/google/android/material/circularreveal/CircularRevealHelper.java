package com.google.android.material.circularreveal;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.b.a.m.f;
import c.e.a.b.k.b;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes.dex */
public class CircularRevealHelper {
    public final a a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final View f2163b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final Path f2164c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final Paint f2165d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NonNull
    public final Paint f2166e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    public b.e f2167f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    public Drawable f2168g;

    @Retention(RetentionPolicy.SOURCE)
    public @interface Strategy {
    }

    public interface a {
        void c(Canvas canvas);

        boolean d();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CircularRevealHelper(a aVar) {
        this.a = aVar;
        View view = (View) aVar;
        this.f2163b = view;
        view.setWillNotDraw(false);
        this.f2164c = new Path();
        this.f2165d = new Paint(7);
        Paint paint = new Paint(1);
        this.f2166e = paint;
        paint.setColor(0);
    }

    public void a(@NonNull Canvas canvas) {
        if (g()) {
            this.a.c(canvas);
            if (h()) {
                canvas.drawRect(0.0f, 0.0f, this.f2163b.getWidth(), this.f2163b.getHeight(), this.f2166e);
            }
        } else {
            this.a.c(canvas);
            if (h()) {
                canvas.drawRect(0.0f, 0.0f, this.f2163b.getWidth(), this.f2163b.getHeight(), this.f2166e);
            }
        }
        Drawable drawable = this.f2168g;
        if ((drawable == null || this.f2167f == null) ? false : true) {
            Rect bounds = drawable.getBounds();
            float fWidth = this.f2167f.a - (bounds.width() / 2.0f);
            float fHeight = this.f2167f.f1005b - (bounds.height() / 2.0f);
            canvas.translate(fWidth, fHeight);
            this.f2168g.draw(canvas);
            canvas.translate(-fWidth, -fHeight);
        }
    }

    @ColorInt
    public int b() {
        return this.f2166e.getColor();
    }

    public final float c(@NonNull b.e eVar) {
        return f.t1(eVar.a, eVar.f1005b, 0.0f, 0.0f, this.f2163b.getWidth(), this.f2163b.getHeight());
    }

    @Nullable
    public b.e d() {
        b.e eVar = this.f2167f;
        if (eVar == null) {
            return null;
        }
        b.e eVar2 = new b.e(eVar.a, eVar.f1005b, eVar.f1006c);
        if (eVar2.f1006c == Float.MAX_VALUE) {
            eVar2.f1006c = c(eVar2);
        }
        return eVar2;
    }

    public boolean e() {
        return this.a.d() && !g();
    }

    public void f(@Nullable b.e eVar) {
        if (eVar == null) {
            this.f2167f = null;
        } else {
            b.e eVar2 = this.f2167f;
            if (eVar2 == null) {
                this.f2167f = new b.e(eVar.a, eVar.f1005b, eVar.f1006c);
            } else {
                float f2 = eVar.a;
                float f3 = eVar.f1005b;
                float f4 = eVar.f1006c;
                eVar2.a = f2;
                eVar2.f1005b = f3;
                eVar2.f1006c = f4;
            }
            if (eVar.f1006c + 1.0E-4f >= c(eVar)) {
                this.f2167f.f1006c = Float.MAX_VALUE;
            }
        }
        this.f2163b.invalidate();
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean g() {
        /*
            r4 = this;
            c.e.a.b.k.b$e r0 = r4.f2167f
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L14
            float r0 = r0.f1006c
            r3 = 2139095039(0x7f7fffff, float:3.4028235E38)
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 != 0) goto L11
            r0 = 1
            goto L12
        L11:
            r0 = 0
        L12:
            if (r0 == 0) goto L15
        L14:
            r1 = 1
        L15:
            r0 = r1 ^ 1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.circularreveal.CircularRevealHelper.g():boolean");
    }

    public final boolean h() {
        return Color.alpha(this.f2166e.getColor()) != 0;
    }
}

package com.google.android.material.circularreveal;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.GridLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.e.a.b.k.b;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class CircularRevealGridLayout extends GridLayout implements b {

    @NonNull
    public final CircularRevealHelper a;

    public CircularRevealGridLayout(Context context) {
        this(context, null);
    }

    @Override // c.e.a.b.k.b
    public void a() {
        Objects.requireNonNull(this.a);
    }

    @Override // c.e.a.b.k.b
    public void b() {
        Objects.requireNonNull(this.a);
    }

    @Override // com.google.android.material.circularreveal.CircularRevealHelper.a
    public void c(Canvas canvas) {
        super.draw(canvas);
    }

    @Override // com.google.android.material.circularreveal.CircularRevealHelper.a
    public boolean d() {
        return super.isOpaque();
    }

    @Override // android.view.View
    public void draw(@NonNull Canvas canvas) {
        CircularRevealHelper circularRevealHelper = this.a;
        if (circularRevealHelper != null) {
            circularRevealHelper.a(canvas);
        } else {
            super.draw(canvas);
        }
    }

    @Nullable
    public Drawable getCircularRevealOverlayDrawable() {
        return this.a.f2168g;
    }

    @Override // c.e.a.b.k.b
    public int getCircularRevealScrimColor() {
        return this.a.b();
    }

    @Override // c.e.a.b.k.b
    @Nullable
    public b.e getRevealInfo() {
        return this.a.d();
    }

    @Override // android.view.View
    public boolean isOpaque() {
        CircularRevealHelper circularRevealHelper = this.a;
        return circularRevealHelper != null ? circularRevealHelper.e() : super.isOpaque();
    }

    @Override // c.e.a.b.k.b
    public void setCircularRevealOverlayDrawable(@Nullable Drawable drawable) {
        CircularRevealHelper circularRevealHelper = this.a;
        circularRevealHelper.f2168g = drawable;
        circularRevealHelper.f2163b.invalidate();
    }

    @Override // c.e.a.b.k.b
    public void setCircularRevealScrimColor(@ColorInt int i2) {
        CircularRevealHelper circularRevealHelper = this.a;
        circularRevealHelper.f2166e.setColor(i2);
        circularRevealHelper.f2163b.invalidate();
    }

    @Override // c.e.a.b.k.b
    public void setRevealInfo(@Nullable b.e eVar) {
        this.a.f(eVar);
    }

    public CircularRevealGridLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = new CircularRevealHelper(this);
    }
}

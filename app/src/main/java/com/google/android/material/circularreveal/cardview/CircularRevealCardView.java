package com.google.android.material.circularreveal.cardview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.e.a.b.k.b;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.circularreveal.CircularRevealHelper;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class CircularRevealCardView extends MaterialCardView implements b {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NonNull
    public final CircularRevealHelper f2169j;

    public CircularRevealCardView(Context context) {
        this(context, null);
    }

    @Override // c.e.a.b.k.b
    public void a() {
        Objects.requireNonNull(this.f2169j);
    }

    @Override // c.e.a.b.k.b
    public void b() {
        Objects.requireNonNull(this.f2169j);
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
    public void draw(Canvas canvas) {
        CircularRevealHelper circularRevealHelper = this.f2169j;
        if (circularRevealHelper != null) {
            circularRevealHelper.a(canvas);
        } else {
            super.draw(canvas);
        }
    }

    @Nullable
    public Drawable getCircularRevealOverlayDrawable() {
        return this.f2169j.f2168g;
    }

    @Override // c.e.a.b.k.b
    public int getCircularRevealScrimColor() {
        return this.f2169j.b();
    }

    @Override // c.e.a.b.k.b
    @Nullable
    public b.e getRevealInfo() {
        return this.f2169j.d();
    }

    @Override // android.view.View
    public boolean isOpaque() {
        CircularRevealHelper circularRevealHelper = this.f2169j;
        return circularRevealHelper != null ? circularRevealHelper.e() : super.isOpaque();
    }

    @Override // c.e.a.b.k.b
    public void setCircularRevealOverlayDrawable(@Nullable Drawable drawable) {
        CircularRevealHelper circularRevealHelper = this.f2169j;
        circularRevealHelper.f2168g = drawable;
        circularRevealHelper.f2163b.invalidate();
    }

    @Override // c.e.a.b.k.b
    public void setCircularRevealScrimColor(@ColorInt int i2) {
        CircularRevealHelper circularRevealHelper = this.f2169j;
        circularRevealHelper.f2166e.setColor(i2);
        circularRevealHelper.f2163b.invalidate();
    }

    @Override // c.e.a.b.k.b
    public void setRevealInfo(@Nullable b.e eVar) {
        this.f2169j.f(eVar);
    }

    public CircularRevealCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2169j = new CircularRevealHelper(this);
    }
}

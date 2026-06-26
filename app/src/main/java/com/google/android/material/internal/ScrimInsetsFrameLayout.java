package com.google.android.material.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import c.e.a.b.q.g;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class ScrimInsetsFrameLayout extends FrameLayout {

    @Nullable
    public Drawable a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Rect f2303b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Rect f2304c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f2305d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f2306e;

    public class a implements OnApplyWindowInsetsListener {
        public a() {
        }

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public WindowInsetsCompat onApplyWindowInsets(View view, @NonNull WindowInsetsCompat windowInsetsCompat) {
            ScrimInsetsFrameLayout scrimInsetsFrameLayout = ScrimInsetsFrameLayout.this;
            if (scrimInsetsFrameLayout.f2303b == null) {
                scrimInsetsFrameLayout.f2303b = new Rect();
            }
            ScrimInsetsFrameLayout.this.f2303b.set(windowInsetsCompat.getSystemWindowInsetLeft(), windowInsetsCompat.getSystemWindowInsetTop(), windowInsetsCompat.getSystemWindowInsetRight(), windowInsetsCompat.getSystemWindowInsetBottom());
            ScrimInsetsFrameLayout.this.a(windowInsetsCompat);
            ScrimInsetsFrameLayout.this.setWillNotDraw(!windowInsetsCompat.hasSystemWindowInsets() || ScrimInsetsFrameLayout.this.a == null);
            ViewCompat.postInvalidateOnAnimation(ScrimInsetsFrameLayout.this);
            return windowInsetsCompat.consumeSystemWindowInsets();
        }
    }

    public ScrimInsetsFrameLayout(@NonNull Context context) {
        this(context, null);
    }

    public void a(WindowInsetsCompat windowInsetsCompat) {
    }

    @Override // android.view.View
    public void draw(@NonNull Canvas canvas) {
        super.draw(canvas);
        int width = getWidth();
        int height = getHeight();
        if (this.f2303b == null || this.a == null) {
            return;
        }
        int iSave = canvas.save();
        canvas.translate(getScrollX(), getScrollY());
        if (this.f2305d) {
            this.f2304c.set(0, 0, width, this.f2303b.top);
            this.a.setBounds(this.f2304c);
            this.a.draw(canvas);
        }
        if (this.f2306e) {
            this.f2304c.set(0, height - this.f2303b.bottom, width, height);
            this.a.setBounds(this.f2304c);
            this.a.draw(canvas);
        }
        Rect rect = this.f2304c;
        Rect rect2 = this.f2303b;
        rect.set(0, rect2.top, rect2.left, height - rect2.bottom);
        this.a.setBounds(this.f2304c);
        this.a.draw(canvas);
        Rect rect3 = this.f2304c;
        Rect rect4 = this.f2303b;
        rect3.set(width - rect4.right, rect4.top, width, height - rect4.bottom);
        this.a.setBounds(this.f2304c);
        this.a.draw(canvas);
        canvas.restoreToCount(iSave);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Drawable drawable = this.a;
        if (drawable != null) {
            drawable.setCallback(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Drawable drawable = this.a;
        if (drawable != null) {
            drawable.setCallback(null);
        }
    }

    public void setDrawBottomInsetForeground(boolean z) {
        this.f2306e = z;
    }

    public void setDrawTopInsetForeground(boolean z) {
        this.f2305d = z;
    }

    public void setScrimInsetForeground(@Nullable Drawable drawable) {
        this.a = drawable;
    }

    public ScrimInsetsFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ScrimInsetsFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f2304c = new Rect();
        this.f2305d = true;
        this.f2306e = true;
        int[] iArr = R$styleable.ScrimInsetsFrameLayout;
        int i3 = R$style.Widget_Design_ScrimInsetsFrameLayout;
        g.a(context, attributeSet, i2, i3);
        g.b(context, attributeSet, iArr, i2, i3, new int[0]);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i2, i3);
        this.a = typedArrayObtainStyledAttributes.getDrawable(R$styleable.ScrimInsetsFrameLayout_insetForeground);
        typedArrayObtainStyledAttributes.recycle();
        setWillNotDraw(true);
        ViewCompat.setOnApplyWindowInsetsListener(this, new a());
    }
}

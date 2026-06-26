package com.google.android.material.card;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Checkable;
import android.widget.FrameLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import c.b.a.m.f;
import c.e.a.b.q.g;
import c.e.a.b.w.l;
import c.e.a.b.w.p;
import com.google.android.material.R$attr;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.shape.MaterialShapeDrawable;

/* JADX INFO: loaded from: classes.dex */
public class MaterialCardView extends CardView implements Checkable, p {
    public static final int[] a = {R.attr.state_checkable};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int[] f2132b = {R.attr.state_checked};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int[] f2133c = {R$attr.state_dragged};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f2134d = R$style.Widget_MaterialComponents_CardView;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NonNull
    public final c.e.a.b.i.a f2135e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f2136f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f2137g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f2138h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public a f2139i;

    public interface a {
        void a(MaterialCardView materialCardView, boolean z);
    }

    public MaterialCardView(Context context) {
        this(context, null);
    }

    @NonNull
    private RectF getBoundsAsRectF() {
        RectF rectF = new RectF();
        rectF.set(this.f2135e.f996e.getBounds());
        return rectF;
    }

    public final void e() {
        c.e.a.b.i.a aVar;
        Drawable drawable;
        if (Build.VERSION.SDK_INT <= 26 || (drawable = (aVar = this.f2135e).p) == null) {
            return;
        }
        Rect bounds = drawable.getBounds();
        int i2 = bounds.bottom;
        aVar.p.setBounds(bounds.left, bounds.top, bounds.right, i2 - 1);
        aVar.p.setBounds(bounds.left, bounds.top, bounds.right, i2);
    }

    public boolean f() {
        c.e.a.b.i.a aVar = this.f2135e;
        return aVar != null && aVar.u;
    }

    public void g(int i2, int i3, int i4, int i5) {
        super.setContentPadding(i2, i3, i4, i5);
    }

    @Override // androidx.cardview.widget.CardView
    @NonNull
    public ColorStateList getCardBackgroundColor() {
        return this.f2135e.f996e.f2333c.f2345d;
    }

    @NonNull
    public ColorStateList getCardForegroundColor() {
        return this.f2135e.f997f.f2333c.f2345d;
    }

    public float getCardViewRadius() {
        return super.getRadius();
    }

    @Nullable
    public Drawable getCheckedIcon() {
        return this.f2135e.f1002k;
    }

    @Dimension
    public int getCheckedIconMargin() {
        return this.f2135e.f998g;
    }

    @Dimension
    public int getCheckedIconSize() {
        return this.f2135e.f999h;
    }

    @Nullable
    public ColorStateList getCheckedIconTint() {
        return this.f2135e.m;
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingBottom() {
        return this.f2135e.f995d.bottom;
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingLeft() {
        return this.f2135e.f995d.left;
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingRight() {
        return this.f2135e.f995d.right;
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingTop() {
        return this.f2135e.f995d.top;
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float getProgress() {
        return this.f2135e.f996e.f2333c.f2352k;
    }

    @Override // androidx.cardview.widget.CardView
    public float getRadius() {
        return this.f2135e.f996e.l();
    }

    public ColorStateList getRippleColor() {
        return this.f2135e.f1003l;
    }

    @Override // c.e.a.b.w.p
    @NonNull
    public l getShapeAppearanceModel() {
        return this.f2135e.n;
    }

    @ColorInt
    @Deprecated
    public int getStrokeColor() {
        ColorStateList colorStateList = this.f2135e.o;
        if (colorStateList == null) {
            return -1;
        }
        return colorStateList.getDefaultColor();
    }

    @Nullable
    public ColorStateList getStrokeColorStateList() {
        return this.f2135e.o;
    }

    @Dimension
    public int getStrokeWidth() {
        return this.f2135e.f1000i;
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.f2137g;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        f.e5(this, this.f2135e.f996e);
    }

    @Override // android.view.ViewGroup, android.view.View
    public int[] onCreateDrawableState(int i2) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i2 + 3);
        if (f()) {
            FrameLayout.mergeDrawableStates(iArrOnCreateDrawableState, a);
        }
        if (isChecked()) {
            FrameLayout.mergeDrawableStates(iArrOnCreateDrawableState, f2132b);
        }
        if (this.f2138h) {
            FrameLayout.mergeDrawableStates(iArrOnCreateDrawableState, f2133c);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(@NonNull AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("androidx.cardview.widget.CardView");
        accessibilityEvent.setChecked(isChecked());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("androidx.cardview.widget.CardView");
        accessibilityNodeInfo.setCheckable(f());
        accessibilityNodeInfo.setClickable(isClickable());
        accessibilityNodeInfo.setChecked(isChecked());
    }

    @Override // androidx.cardview.widget.CardView, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        int i4;
        int i5;
        super.onMeasure(i2, i3);
        c.e.a.b.i.a aVar = this.f2135e;
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (aVar.q != null) {
            int i6 = aVar.f998g;
            int i7 = aVar.f999h;
            int iCeil = (measuredWidth - i6) - i7;
            int iCeil2 = (measuredHeight - i6) - i7;
            if (aVar.f994c.getUseCompatPadding()) {
                iCeil2 -= (int) Math.ceil(aVar.d() * 2.0f);
                iCeil -= (int) Math.ceil(aVar.c() * 2.0f);
            }
            int i8 = iCeil2;
            int i9 = aVar.f998g;
            if (ViewCompat.getLayoutDirection(aVar.f994c) == 1) {
                i5 = iCeil;
                i4 = i9;
            } else {
                i4 = iCeil;
                i5 = i9;
            }
            aVar.q.setLayerInset(2, i4, aVar.f998g, i5, i8);
        }
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (this.f2136f) {
            c.e.a.b.i.a aVar = this.f2135e;
            if (!aVar.t) {
                aVar.t = true;
            }
            super.setBackgroundDrawable(drawable);
        }
    }

    public void setBackgroundInternal(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    @Override // androidx.cardview.widget.CardView
    public void setCardBackgroundColor(@ColorInt int i2) {
        c.e.a.b.i.a aVar = this.f2135e;
        aVar.f996e.q(ColorStateList.valueOf(i2));
    }

    @Override // androidx.cardview.widget.CardView
    public void setCardElevation(float f2) {
        super.setCardElevation(f2);
        c.e.a.b.i.a aVar = this.f2135e;
        aVar.f996e.p(aVar.f994c.getCardElevation());
    }

    public void setCardForegroundColor(@Nullable ColorStateList colorStateList) {
        MaterialShapeDrawable materialShapeDrawable = this.f2135e.f997f;
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        materialShapeDrawable.q(colorStateList);
    }

    public void setCheckable(boolean z) {
        this.f2135e.u = z;
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z) {
        if (this.f2137g != z) {
            toggle();
        }
    }

    public void setCheckedIcon(@Nullable Drawable drawable) {
        this.f2135e.g(drawable);
    }

    public void setCheckedIconMargin(@Dimension int i2) {
        this.f2135e.f998g = i2;
    }

    public void setCheckedIconMarginResource(@DimenRes int i2) {
        if (i2 != -1) {
            this.f2135e.f998g = getResources().getDimensionPixelSize(i2);
        }
    }

    public void setCheckedIconResource(@DrawableRes int i2) {
        this.f2135e.g(AppCompatResources.getDrawable(getContext(), i2));
    }

    public void setCheckedIconSize(@Dimension int i2) {
        this.f2135e.f999h = i2;
    }

    public void setCheckedIconSizeResource(@DimenRes int i2) {
        if (i2 != 0) {
            this.f2135e.f999h = getResources().getDimensionPixelSize(i2);
        }
    }

    public void setCheckedIconTint(@Nullable ColorStateList colorStateList) {
        c.e.a.b.i.a aVar = this.f2135e;
        aVar.m = colorStateList;
        Drawable drawable = aVar.f1002k;
        if (drawable != null) {
            DrawableCompat.setTintList(drawable, colorStateList);
        }
    }

    @Override // android.view.View
    public void setClickable(boolean z) {
        super.setClickable(z);
        c.e.a.b.i.a aVar = this.f2135e;
        if (aVar != null) {
            Drawable drawable = aVar.f1001j;
            Drawable drawableE = aVar.f994c.isClickable() ? aVar.e() : aVar.f997f;
            aVar.f1001j = drawableE;
            if (drawable != drawableE) {
                if (Build.VERSION.SDK_INT < 23 || !(aVar.f994c.getForeground() instanceof InsetDrawable)) {
                    aVar.f994c.setForeground(aVar.f(drawableE));
                } else {
                    ((InsetDrawable) aVar.f994c.getForeground()).setDrawable(drawableE);
                }
            }
        }
    }

    @Override // androidx.cardview.widget.CardView
    public void setContentPadding(int i2, int i3, int i4, int i5) {
        c.e.a.b.i.a aVar = this.f2135e;
        aVar.f995d.set(i2, i3, i4, i5);
        aVar.k();
    }

    public void setDragged(boolean z) {
        if (this.f2138h != z) {
            this.f2138h = z;
            refreshDrawableState();
            e();
            invalidate();
        }
    }

    @Override // androidx.cardview.widget.CardView
    public void setMaxCardElevation(float f2) {
        super.setMaxCardElevation(f2);
        this.f2135e.l();
    }

    public void setOnCheckedChangeListener(@Nullable a aVar) {
        this.f2139i = aVar;
    }

    @Override // androidx.cardview.widget.CardView
    public void setPreventCornerOverlap(boolean z) {
        super.setPreventCornerOverlap(z);
        this.f2135e.l();
        this.f2135e.k();
    }

    public void setProgress(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        c.e.a.b.i.a aVar = this.f2135e;
        aVar.f996e.r(f2);
        MaterialShapeDrawable materialShapeDrawable = aVar.f997f;
        if (materialShapeDrawable != null) {
            materialShapeDrawable.r(f2);
        }
        MaterialShapeDrawable materialShapeDrawable2 = aVar.s;
        if (materialShapeDrawable2 != null) {
            materialShapeDrawable2.r(f2);
        }
    }

    @Override // androidx.cardview.widget.CardView
    public void setRadius(float f2) {
        super.setRadius(f2);
        c.e.a.b.i.a aVar = this.f2135e;
        aVar.h(aVar.n.f(f2));
        aVar.f1001j.invalidateSelf();
        if (aVar.j() || aVar.i()) {
            aVar.k();
        }
        if (aVar.j()) {
            aVar.l();
        }
    }

    public void setRippleColor(@Nullable ColorStateList colorStateList) {
        c.e.a.b.i.a aVar = this.f2135e;
        aVar.f1003l = colorStateList;
        aVar.m();
    }

    public void setRippleColorResource(@ColorRes int i2) {
        c.e.a.b.i.a aVar = this.f2135e;
        aVar.f1003l = AppCompatResources.getColorStateList(getContext(), i2);
        aVar.m();
    }

    @Override // c.e.a.b.w.p
    public void setShapeAppearanceModel(@NonNull l lVar) {
        setClipToOutline(lVar.e(getBoundsAsRectF()));
        this.f2135e.h(lVar);
    }

    public void setStrokeColor(@ColorInt int i2) {
        c.e.a.b.i.a aVar = this.f2135e;
        ColorStateList colorStateListValueOf = ColorStateList.valueOf(i2);
        if (aVar.o == colorStateListValueOf) {
            return;
        }
        aVar.o = colorStateListValueOf;
        aVar.n();
    }

    public void setStrokeWidth(@Dimension int i2) {
        c.e.a.b.i.a aVar = this.f2135e;
        if (i2 == aVar.f1000i) {
            return;
        }
        aVar.f1000i = i2;
        aVar.n();
    }

    @Override // androidx.cardview.widget.CardView
    public void setUseCompatPadding(boolean z) {
        super.setUseCompatPadding(z);
        this.f2135e.l();
        this.f2135e.k();
    }

    @Override // android.widget.Checkable
    public void toggle() {
        if (f() && isEnabled()) {
            this.f2137g = !this.f2137g;
            refreshDrawableState();
            e();
            a aVar = this.f2139i;
            if (aVar != null) {
                aVar.a(this, this.f2137g);
            }
        }
    }

    public MaterialCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.materialCardViewStyle);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public MaterialCardView(Context context, AttributeSet attributeSet, int i2) {
        int i3 = f2134d;
        super(c.e.a.b.b0.a.a.a(context, attributeSet, i2, i3), attributeSet, i2);
        this.f2137g = false;
        this.f2138h = false;
        this.f2136f = true;
        TypedArray typedArrayD = g.d(getContext(), attributeSet, R$styleable.MaterialCardView, i2, i3, new int[0]);
        c.e.a.b.i.a aVar = new c.e.a.b.i.a(this, attributeSet, i2, i3);
        this.f2135e = aVar;
        aVar.f996e.q(super.getCardBackgroundColor());
        aVar.f995d.set(super.getContentPaddingLeft(), super.getContentPaddingTop(), super.getContentPaddingRight(), super.getContentPaddingBottom());
        aVar.k();
        ColorStateList colorStateListA2 = f.a2(aVar.f994c.getContext(), typedArrayD, R$styleable.MaterialCardView_strokeColor);
        aVar.o = colorStateListA2;
        if (colorStateListA2 == null) {
            aVar.o = ColorStateList.valueOf(-1);
        }
        aVar.f1000i = typedArrayD.getDimensionPixelSize(R$styleable.MaterialCardView_strokeWidth, 0);
        boolean z = typedArrayD.getBoolean(R$styleable.MaterialCardView_android_checkable, false);
        aVar.u = z;
        aVar.f994c.setLongClickable(z);
        aVar.m = f.a2(aVar.f994c.getContext(), typedArrayD, R$styleable.MaterialCardView_checkedIconTint);
        aVar.g(f.n2(aVar.f994c.getContext(), typedArrayD, R$styleable.MaterialCardView_checkedIcon));
        aVar.f999h = typedArrayD.getDimensionPixelSize(R$styleable.MaterialCardView_checkedIconSize, 0);
        aVar.f998g = typedArrayD.getDimensionPixelSize(R$styleable.MaterialCardView_checkedIconMargin, 0);
        ColorStateList colorStateListA22 = f.a2(aVar.f994c.getContext(), typedArrayD, R$styleable.MaterialCardView_rippleColor);
        aVar.f1003l = colorStateListA22;
        if (colorStateListA22 == null) {
            aVar.f1003l = ColorStateList.valueOf(f.Z1(aVar.f994c, R$attr.colorControlHighlight));
        }
        ColorStateList colorStateListA23 = f.a2(aVar.f994c.getContext(), typedArrayD, R$styleable.MaterialCardView_cardForegroundColor);
        aVar.f997f.q(colorStateListA23 == null ? ColorStateList.valueOf(0) : colorStateListA23);
        aVar.m();
        aVar.f996e.p(aVar.f994c.getCardElevation());
        aVar.n();
        aVar.f994c.setBackgroundInternal(aVar.f(aVar.f996e));
        Drawable drawableE = aVar.f994c.isClickable() ? aVar.e() : aVar.f997f;
        aVar.f1001j = drawableE;
        aVar.f994c.setForeground(aVar.f(drawableE));
        typedArrayD.recycle();
    }

    @Override // androidx.cardview.widget.CardView
    public void setCardBackgroundColor(@Nullable ColorStateList colorStateList) {
        this.f2135e.f996e.q(colorStateList);
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        c.e.a.b.i.a aVar = this.f2135e;
        if (aVar.o == colorStateList) {
            return;
        }
        aVar.o = colorStateList;
        aVar.n();
    }
}

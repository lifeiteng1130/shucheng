package com.google.android.material.imageview;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatImageView;
import c.b.a.m.f;
import c.e.a.b.w.l;
import c.e.a.b.w.m;
import c.e.a.b.w.p;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.shape.MaterialShapeDrawable;

/* JADX INFO: loaded from: classes.dex */
public class ShapeableImageView extends AppCompatImageView implements p {
    public static final int a = R$style.Widget_MaterialComponents_ShapeableImageView;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final m f2258b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RectF f2259c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final RectF f2260d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Paint f2261e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Paint f2262f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Path f2263g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    public ColorStateList f2264h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    public MaterialShapeDrawable f2265i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public l f2266j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @Dimension
    public float f2267k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Path f2268l;

    @Dimension
    public int m;

    @Dimension
    public int n;

    @Dimension
    public int o;

    @Dimension
    public int p;

    @Dimension
    public int q;

    @Dimension
    public int r;
    public boolean s;

    @TargetApi(21)
    public class a extends ViewOutlineProvider {
        public final Rect a = new Rect();

        public a() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            ShapeableImageView shapeableImageView = ShapeableImageView.this;
            if (shapeableImageView.f2266j == null) {
                return;
            }
            if (shapeableImageView.f2265i == null) {
                shapeableImageView.f2265i = new MaterialShapeDrawable(ShapeableImageView.this.f2266j);
            }
            ShapeableImageView.this.f2259c.round(this.a);
            ShapeableImageView.this.f2265i.setBounds(this.a);
            ShapeableImageView.this.f2265i.getOutline(outline);
        }
    }

    public ShapeableImageView(Context context) {
        this(context, null, 0);
    }

    public final boolean a() {
        return (this.q == Integer.MIN_VALUE && this.r == Integer.MIN_VALUE) ? false : true;
    }

    public final boolean b() {
        return getLayoutDirection() == 1;
    }

    public final void c(int i2, int i3) {
        this.f2259c.set(getPaddingLeft(), getPaddingTop(), i2 - getPaddingRight(), i3 - getPaddingBottom());
        this.f2258b.a(this.f2266j, 1.0f, this.f2259c, this.f2263g);
        this.f2268l.rewind();
        this.f2268l.addPath(this.f2263g);
        this.f2260d.set(0.0f, 0.0f, i2, i3);
        this.f2268l.addRect(this.f2260d, Path.Direction.CCW);
    }

    @Dimension
    public int getContentPaddingBottom() {
        return this.p;
    }

    @Dimension
    public final int getContentPaddingEnd() {
        int i2 = this.r;
        return i2 != Integer.MIN_VALUE ? i2 : b() ? this.m : this.o;
    }

    @Dimension
    public int getContentPaddingLeft() {
        int i2;
        int i3;
        if (a()) {
            if (b() && (i3 = this.r) != Integer.MIN_VALUE) {
                return i3;
            }
            if (!b() && (i2 = this.q) != Integer.MIN_VALUE) {
                return i2;
            }
        }
        return this.m;
    }

    @Dimension
    public int getContentPaddingRight() {
        int i2;
        int i3;
        if (a()) {
            if (b() && (i3 = this.q) != Integer.MIN_VALUE) {
                return i3;
            }
            if (!b() && (i2 = this.r) != Integer.MIN_VALUE) {
                return i2;
            }
        }
        return this.o;
    }

    @Dimension
    public final int getContentPaddingStart() {
        int i2 = this.q;
        return i2 != Integer.MIN_VALUE ? i2 : b() ? this.o : this.m;
    }

    @Dimension
    public int getContentPaddingTop() {
        return this.n;
    }

    @Override // android.view.View
    @Dimension
    public int getPaddingBottom() {
        return super.getPaddingBottom() - getContentPaddingBottom();
    }

    @Override // android.view.View
    @Dimension
    public int getPaddingEnd() {
        return super.getPaddingEnd() - getContentPaddingEnd();
    }

    @Override // android.view.View
    @Dimension
    public int getPaddingLeft() {
        return super.getPaddingLeft() - getContentPaddingLeft();
    }

    @Override // android.view.View
    @Dimension
    public int getPaddingRight() {
        return super.getPaddingRight() - getContentPaddingRight();
    }

    @Override // android.view.View
    @Dimension
    public int getPaddingStart() {
        return super.getPaddingStart() - getContentPaddingStart();
    }

    @Override // android.view.View
    @Dimension
    public int getPaddingTop() {
        return super.getPaddingTop() - getContentPaddingTop();
    }

    @Override // c.e.a.b.w.p
    @NonNull
    public l getShapeAppearanceModel() {
        return this.f2266j;
    }

    @Nullable
    public ColorStateList getStrokeColor() {
        return this.f2264h;
    }

    @Dimension
    public float getStrokeWidth() {
        return this.f2267k;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        setLayerType(2, null);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        setLayerType(0, null);
        super.onDetachedFromWindow();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(this.f2268l, this.f2262f);
        if (this.f2264h == null) {
            return;
        }
        this.f2261e.setStrokeWidth(this.f2267k);
        int colorForState = this.f2264h.getColorForState(getDrawableState(), this.f2264h.getDefaultColor());
        if (this.f2267k <= 0.0f || colorForState == 0) {
            return;
        }
        this.f2261e.setColor(colorForState);
        canvas.drawPath(this.f2263g, this.f2261e);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        if (!this.s && isLayoutDirectionResolved()) {
            this.s = true;
            if (isPaddingRelative() || a()) {
                setPaddingRelative(super.getPaddingStart(), super.getPaddingTop(), super.getPaddingEnd(), super.getPaddingBottom());
            } else {
                setPadding(super.getPaddingLeft(), super.getPaddingTop(), super.getPaddingRight(), super.getPaddingBottom());
            }
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        c(i2, i3);
    }

    @Override // android.view.View
    public void setPadding(@Dimension int i2, @Dimension int i3, @Dimension int i4, @Dimension int i5) {
        super.setPadding(getContentPaddingLeft() + i2, getContentPaddingTop() + i3, getContentPaddingRight() + i4, getContentPaddingBottom() + i5);
    }

    @Override // android.view.View
    public void setPaddingRelative(@Dimension int i2, @Dimension int i3, @Dimension int i4, @Dimension int i5) {
        super.setPaddingRelative(getContentPaddingStart() + i2, getContentPaddingTop() + i3, getContentPaddingEnd() + i4, getContentPaddingBottom() + i5);
    }

    @Override // c.e.a.b.w.p
    public void setShapeAppearanceModel(@NonNull l lVar) {
        this.f2266j = lVar;
        MaterialShapeDrawable materialShapeDrawable = this.f2265i;
        if (materialShapeDrawable != null) {
            materialShapeDrawable.f2333c.a = lVar;
            materialShapeDrawable.invalidateSelf();
        }
        c(getWidth(), getHeight());
        invalidate();
        invalidateOutline();
    }

    public void setStrokeColor(@Nullable ColorStateList colorStateList) {
        this.f2264h = colorStateList;
        invalidate();
    }

    public void setStrokeColorResource(@ColorRes int i2) {
        setStrokeColor(AppCompatResources.getColorStateList(getContext(), i2));
    }

    public void setStrokeWidth(@Dimension float f2) {
        if (this.f2267k != f2) {
            this.f2267k = f2;
            invalidate();
        }
    }

    public void setStrokeWidthResource(@DimenRes int i2) {
        setStrokeWidth(getResources().getDimensionPixelSize(i2));
    }

    public ShapeableImageView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public ShapeableImageView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        int i3 = a;
        super(c.e.a.b.b0.a.a.a(context, attributeSet, i2, i3), attributeSet, i2);
        this.f2258b = m.a.a;
        this.f2263g = new Path();
        this.s = false;
        Context context2 = getContext();
        Paint paint = new Paint();
        this.f2262f = paint;
        paint.setAntiAlias(true);
        paint.setColor(-1);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        this.f2259c = new RectF();
        this.f2260d = new RectF();
        this.f2268l = new Path();
        TypedArray typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, R$styleable.ShapeableImageView, i2, i3);
        this.f2264h = f.a2(context2, typedArrayObtainStyledAttributes, R$styleable.ShapeableImageView_strokeColor);
        this.f2267k = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.ShapeableImageView_strokeWidth, 0);
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.ShapeableImageView_contentPadding, 0);
        this.m = dimensionPixelSize;
        this.n = dimensionPixelSize;
        this.o = dimensionPixelSize;
        this.p = dimensionPixelSize;
        this.m = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.ShapeableImageView_contentPaddingLeft, dimensionPixelSize);
        this.n = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.ShapeableImageView_contentPaddingTop, dimensionPixelSize);
        this.o = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.ShapeableImageView_contentPaddingRight, dimensionPixelSize);
        this.p = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.ShapeableImageView_contentPaddingBottom, dimensionPixelSize);
        this.q = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.ShapeableImageView_contentPaddingStart, Integer.MIN_VALUE);
        this.r = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.ShapeableImageView_contentPaddingEnd, Integer.MIN_VALUE);
        typedArrayObtainStyledAttributes.recycle();
        Paint paint2 = new Paint();
        this.f2261e = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setAntiAlias(true);
        this.f2266j = l.c(context2, attributeSet, i2, i3, new c.e.a.b.w.a(0)).a();
        setOutlineProvider(new a());
    }
}

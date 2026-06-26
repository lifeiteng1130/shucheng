package io.legado.app.ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import c.b.a.m.f;
import com.umeng.analytics.pro.ai;
import com.umeng.analytics.pro.c;
import f.c0.c.j;
import io.legado.app.R$styleable;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mozilla.javascript.optimizer.OptRuntime;

/* JADX INFO: compiled from: ShadowLayout.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010-\u001a\u00020,\u0012\n\b\u0002\u0010/\u001a\u0004\u0018\u00010.¢\u0006\u0004\b0\u00101J\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0014¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001a\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001d\u001a\u00020\u001b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u001cR\u0016\u0010 \u001a\u00020\u001e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u001fR\u0016\u0010\"\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\u0019R\u0016\u0010$\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010\u0019R\u0016\u0010'\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010)\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010&R\u0016\u0010+\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010&¨\u00062"}, d2 = {"Lio/legado/app/ui/widget/ShadowLayout;", "Landroid/widget/RelativeLayout;", "", "widthMeasureSpec", "heightMeasureSpec", "Lf/v;", "onMeasure", "(II)V", "Landroid/graphics/Canvas;", "canvas", "onDraw", "(Landroid/graphics/Canvas;)V", "shadowColor", "setShadowColor", "(I)V", "", "shadowRadius", "setShadowRadius", "(F)V", "b", "()V", "dpValue", ai.at, "(F)F", ai.aD, OptRuntime.GeneratorState.resumptionPoint_TYPE, "mShadowColor", "Landroid/graphics/Paint;", "Landroid/graphics/Paint;", "mPaint", "Landroid/graphics/RectF;", "Landroid/graphics/RectF;", "mRectF", "h", "mShadowShape", "g", "mShadowSide", "f", "F", "mShadowDy", "e", "mShadowDx", "d", "mShadowRadius", "Landroid/content/Context;", c.R, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class ShadowLayout extends RelativeLayout {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    @NotNull
    public final Paint mPaint;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final RectF mRectF;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    public int mShadowColor;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    public float mShadowRadius;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    public float mShadowDx;

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    public float mShadowDy;

    /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
    public int mShadowSide;

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    public int mShadowShape;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ShadowLayout(@NotNull Context context) {
        this(context, null);
        j.e(context, c.R);
    }

    public final float a(float dpValue) {
        return (dpValue * getContext().getResources().getDisplayMetrics().density) + 0.5f;
    }

    public final void b() {
        this.mPaint.reset();
        this.mPaint.setAntiAlias(true);
        this.mPaint.setColor(0);
        this.mPaint.setShadowLayer(this.mShadowRadius, this.mShadowDx, this.mShadowDy, this.mShadowColor);
    }

    @Override // android.view.View
    public void onDraw(@NotNull Canvas canvas) {
        j.e(canvas, "canvas");
        super.onDraw(canvas);
        b();
        int i2 = this.mShadowShape;
        if (i2 == 1) {
            canvas.drawRect(this.mRectF, this.mPaint);
            return;
        }
        if (i2 == 16) {
            float fCenterX = this.mRectF.centerX();
            float fCenterY = this.mRectF.centerY();
            float fWidth = this.mRectF.width();
            float fHeight = this.mRectF.height();
            if (fWidth > fHeight) {
                fWidth = fHeight;
            }
            canvas.drawCircle(fCenterX, fCenterY, fWidth / 2, this.mPaint);
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int i2;
        float f2;
        int i3;
        float f3;
        int i4;
        int i5;
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        float fA = a(5.0f) + this.mShadowRadius;
        float measuredWidth = getMeasuredWidth();
        float measuredHeight = getMeasuredHeight();
        getWidth();
        int i6 = this.mShadowSide;
        if ((i6 & 1) == 1) {
            i2 = (int) fA;
            f2 = fA;
        } else {
            i2 = 0;
            f2 = 0.0f;
        }
        if ((i6 & 16) == 16) {
            i3 = (int) fA;
            f3 = fA;
        } else {
            i3 = 0;
            f3 = 0.0f;
        }
        if ((i6 & 256) == 256) {
            measuredWidth = getMeasuredWidth() - fA;
            i4 = (int) fA;
        } else {
            i4 = 0;
        }
        if ((this.mShadowSide & 4096) == 4096) {
            measuredHeight = getMeasuredHeight() - fA;
            i5 = (int) fA;
        } else {
            i5 = 0;
        }
        float f4 = this.mShadowDy;
        if (!(f4 == 0.0f)) {
            measuredHeight -= f4;
            i5 += (int) f4;
        }
        float f5 = this.mShadowDx;
        if (!(f5 == 0.0f)) {
            measuredWidth -= f5;
            i4 += (int) f5;
        }
        RectF rectF = this.mRectF;
        rectF.left = f2;
        rectF.top = f3;
        rectF.right = measuredWidth;
        rectF.bottom = measuredHeight;
        setPadding(i2, i3, i4, i5);
    }

    public final void setShadowColor(int shadowColor) {
        this.mShadowColor = shadowColor;
        requestLayout();
        postInvalidate();
    }

    public final void setShadowRadius(float shadowRadius) {
        this.mShadowRadius = shadowRadius;
        requestLayout();
        postInvalidate();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ShadowLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        j.e(context, c.R);
        this.mPaint = new Paint(1);
        this.mRectF = new RectF();
        this.mShadowSide = 4369;
        this.mShadowShape = 1;
        setLayerType(1, null);
        setWillNotDraw(false);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ShadowLayout);
        j.d(typedArrayObtainStyledAttributes, "context.obtainStyledAttributes(attrs, R.styleable.ShadowLayout)");
        this.mShadowColor = typedArrayObtainStyledAttributes.getColor(0, f.c2(context, 17170444));
        this.mShadowRadius = typedArrayObtainStyledAttributes.getDimension(3, a(0.0f));
        this.mShadowDx = typedArrayObtainStyledAttributes.getDimension(1, a(0.0f));
        this.mShadowDy = typedArrayObtainStyledAttributes.getDimension(2, a(0.0f));
        this.mShadowSide = typedArrayObtainStyledAttributes.getInt(5, 4369);
        this.mShadowShape = typedArrayObtainStyledAttributes.getInt(4, 1);
        typedArrayObtainStyledAttributes.recycle();
        b();
    }
}

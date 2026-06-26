package io.legado.app.ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import com.umeng.analytics.pro.ai;
import com.umeng.analytics.pro.c;
import f.c0.c.j;
import io.legado.app.R$styleable;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mozilla.javascript.optimizer.OptRuntime;

/* JADX INFO: compiled from: ArcView.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010-\u001a\u00020,\u0012\n\b\u0002\u0010/\u001a\u0004\u0018\u00010.¢\u0006\u0004\b0\u00101J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\n\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0007¢\u0006\u0004\b\r\u0010\u000eR\u0019\u0010\u0014\u001a\u00020\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0019\u0010\u001a\u001a\u00020\u00158\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010!\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010#\u001a\u00020\u00078\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010 R\u0016\u0010%\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010 R\u0016\u0010'\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010 R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*¨\u00062"}, d2 = {"Lio/legado/app/ui/widget/ArcView;", "Landroid/view/View;", "Landroid/graphics/Canvas;", "canvas", "Lf/v;", "onDraw", "(Landroid/graphics/Canvas;)V", "", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "(II)V", "color", "setBgColor", "(I)V", "Landroid/graphics/Path;", "h", "Landroid/graphics/Path;", "getPath", "()Landroid/graphics/Path;", "path", "Landroid/graphics/Rect;", "g", "Landroid/graphics/Rect;", "getRect", "()Landroid/graphics/Rect;", "rect", "Landroid/graphics/Paint;", "e", "Landroid/graphics/Paint;", "mPaint", "b", OptRuntime.GeneratorState.resumptionPoint_TYPE, "mHeight", ai.aD, "mArcHeight", "d", "mBgColor", ai.at, "mWidth", "", "f", "Z", "mDirectionTop", "Landroid/content/Context;", c.R, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class ArcView extends View {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public int mWidth;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    public int mHeight;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final int mArcHeight;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    public int mBgColor;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final Paint mPaint;

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    public final boolean mDirectionTop;

    /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final Rect rect;

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final Path path;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ArcView(@NotNull Context context) {
        this(context, null);
        j.e(context, c.R);
    }

    @NotNull
    public final Path getPath() {
        return this.path;
    }

    @NotNull
    public final Rect getRect() {
        return this.rect;
    }

    @Override // android.view.View
    public void onDraw(@NotNull Canvas canvas) {
        j.e(canvas, "canvas");
        super.onDraw(canvas);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(this.mBgColor);
        if (this.mDirectionTop) {
            this.rect.set(0, this.mArcHeight, this.mWidth, this.mHeight);
            canvas.drawRect(this.rect, this.mPaint);
            this.path.reset();
            this.path.moveTo(0.0f, this.mArcHeight);
            Path path = this.path;
            int i2 = this.mWidth;
            path.quadTo(i2 / 2.0f, 0.0f, i2, this.mArcHeight);
            canvas.drawPath(this.path, this.mPaint);
            return;
        }
        this.rect.set(0, 0, this.mWidth, this.mHeight - this.mArcHeight);
        canvas.drawRect(this.rect, this.mPaint);
        this.path.reset();
        this.path.moveTo(0.0f, this.mHeight - this.mArcHeight);
        Path path2 = this.path;
        int i3 = this.mWidth;
        int i4 = this.mHeight;
        path2.quadTo(i3 / 2.0f, i4, i3, i4 - this.mArcHeight);
        canvas.drawPath(this.path, this.mPaint);
    }

    @Override // android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int size = View.MeasureSpec.getSize(widthMeasureSpec);
        int mode = View.MeasureSpec.getMode(widthMeasureSpec);
        int size2 = View.MeasureSpec.getSize(heightMeasureSpec);
        int mode2 = View.MeasureSpec.getMode(heightMeasureSpec);
        if (mode == 1073741824) {
            this.mWidth = size;
        }
        if (mode2 == 1073741824) {
            this.mHeight = size2;
        }
        setMeasuredDimension(this.mWidth, this.mHeight);
    }

    public final void setBgColor(int color) {
        this.mBgColor = color;
        invalidate();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ArcView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        j.e(context, c.R);
        this.mPaint = new Paint();
        this.rect = new Rect();
        this.path = new Path();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ArcView);
        j.d(typedArrayObtainStyledAttributes, "context.obtainStyledAttributes(attrs, R.styleable.ArcView)");
        this.mArcHeight = typedArrayObtainStyledAttributes.getDimensionPixelSize(1, 0);
        this.mBgColor = typedArrayObtainStyledAttributes.getColor(2, Color.parseColor("#303F9F"));
        this.mDirectionTop = typedArrayObtainStyledAttributes.getBoolean(0, false);
        typedArrayObtainStyledAttributes.recycle();
    }
}

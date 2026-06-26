package io.legado.app.ui.widget.image;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
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

/* JADX INFO: compiled from: FilletImageView.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010&\u001a\u00020%\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010'¢\u0006\u0004\b)\u0010*J7\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\fH\u0014¢\u0006\u0004\b\u000e\u0010\u000fR\"\u0010\u0017\u001a\u00020\u00108\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001a\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001c\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u0019R\u0016\u0010 \u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010\u0019R\"\u0010$\u001a\u00020\u00108\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b!\u0010\u0012\u001a\u0004\b\"\u0010\u0014\"\u0004\b#\u0010\u0016¨\u0006+"}, d2 = {"Lio/legado/app/ui/widget/image/FilletImageView;", "Landroidx/appcompat/widget/AppCompatImageView;", "", "changed", "", "left", "top", "right", "bottom", "Lf/v;", "onLayout", "(ZIIII)V", "Landroid/graphics/Canvas;", "canvas", "onDraw", "(Landroid/graphics/Canvas;)V", "", ai.at, "F", "getWidth$app_adsRelease", "()F", "setWidth$app_adsRelease", "(F)V", "width", "d", OptRuntime.GeneratorState.resumptionPoint_TYPE, "rightTopRadius", ai.aD, "leftTopRadius", "e", "rightBottomRadius", "f", "leftBottomRadius", "b", "getHeight$app_adsRelease", "setHeight$app_adsRelease", "height", "Landroid/content/Context;", c.R, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class FilletImageView extends AppCompatImageView {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public float width;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    public float height;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    public int leftTopRadius;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    public int rightTopRadius;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    public int rightBottomRadius;

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    public int leftBottomRadius;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public FilletImageView(@NotNull Context context) {
        this(context, null);
        j.e(context, c.R);
    }

    /* JADX INFO: renamed from: getHeight$app_adsRelease, reason: from getter */
    public final float getHeight() {
        return this.height;
    }

    /* JADX INFO: renamed from: getWidth$app_adsRelease, reason: from getter */
    public final float getWidth() {
        return this.width;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(@NotNull Canvas canvas) {
        j.e(canvas, "canvas");
        int iMax = Math.max(this.rightTopRadius, this.rightBottomRadius) + Math.max(this.leftTopRadius, this.leftBottomRadius);
        int iMax2 = Math.max(this.leftBottomRadius, this.rightBottomRadius) + Math.max(this.leftTopRadius, this.rightTopRadius);
        if (this.width >= iMax && this.height > iMax2) {
            Path path = new Path();
            path.moveTo(this.leftTopRadius, 0.0f);
            path.lineTo(this.width - this.rightTopRadius, 0.0f);
            float f2 = this.width;
            path.quadTo(f2, 0.0f, f2, this.rightTopRadius);
            path.lineTo(this.width, this.height - this.rightBottomRadius);
            float f3 = this.width;
            float f4 = this.height;
            path.quadTo(f3, f4, f3 - this.rightBottomRadius, f4);
            path.lineTo(this.leftBottomRadius, this.height);
            float f5 = this.height;
            path.quadTo(0.0f, f5, 0.0f, f5 - this.leftBottomRadius);
            path.lineTo(0.0f, this.leftTopRadius);
            path.quadTo(0.0f, 0.0f, this.leftTopRadius, 0.0f);
            canvas.clipPath(path);
        }
        super.onDraw(canvas);
    }

    @Override // android.view.View
    public void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        this.width = getWidth();
        this.height = getHeight();
    }

    public final void setHeight$app_adsRelease(float f2) {
        this.height = f2;
    }

    public final void setWidth$app_adsRelease(float f2) {
        this.width = f2;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public FilletImageView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        j.e(context, c.R);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.FilletImageView);
        j.d(typedArrayObtainStyledAttributes, "context.obtainStyledAttributes(attrs, R.styleable.FilletImageView)");
        int iM2 = f.m2(5);
        int dimensionPixelOffset = typedArrayObtainStyledAttributes.getDimensionPixelOffset(2, iM2);
        this.leftTopRadius = typedArrayObtainStyledAttributes.getDimensionPixelOffset(1, iM2);
        this.rightTopRadius = typedArrayObtainStyledAttributes.getDimensionPixelOffset(4, iM2);
        this.rightBottomRadius = typedArrayObtainStyledAttributes.getDimensionPixelOffset(3, iM2);
        int dimensionPixelOffset2 = typedArrayObtainStyledAttributes.getDimensionPixelOffset(0, iM2);
        this.leftBottomRadius = dimensionPixelOffset2;
        if (iM2 == this.leftTopRadius) {
            this.leftTopRadius = dimensionPixelOffset;
        }
        if (iM2 == this.rightTopRadius) {
            this.rightTopRadius = dimensionPixelOffset;
        }
        if (iM2 == this.rightBottomRadius) {
            this.rightBottomRadius = dimensionPixelOffset;
        }
        if (iM2 == dimensionPixelOffset2) {
            this.leftBottomRadius = dimensionPixelOffset;
        }
        typedArrayObtainStyledAttributes.recycle();
    }
}

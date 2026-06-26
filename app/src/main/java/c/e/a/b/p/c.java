package c.e.a.b.p;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import androidx.annotation.ColorInt;
import androidx.annotation.Dimension;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.ColorUtils;
import c.e.a.b.w.m;

/* JADX INFO: compiled from: BorderDrawable.java */
/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class c extends Drawable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final Paint f1057b;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Dimension
    public float f1063h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @ColorInt
    public int f1064i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @ColorInt
    public int f1065j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @ColorInt
    public int f1066k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @ColorInt
    public int f1067l;

    @ColorInt
    public int m;
    public c.e.a.b.w.l o;

    @Nullable
    public ColorStateList p;
    public final m a = m.a.a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Path f1058c = new Path();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Rect f1059d = new Rect();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final RectF f1060e = new RectF();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final RectF f1061f = new RectF();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final b f1062g = new b(null);
    public boolean n = true;

    /* JADX INFO: compiled from: BorderDrawable.java */
    public class b extends Drawable.ConstantState {
        public b(a aVar) {
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @NonNull
        public Drawable newDrawable() {
            return c.this;
        }
    }

    public c(c.e.a.b.w.l lVar) {
        this.o = lVar;
        Paint paint = new Paint(1);
        this.f1057b = paint;
        paint.setStyle(Paint.Style.STROKE);
    }

    @NonNull
    public RectF a() {
        this.f1061f.set(getBounds());
        return this.f1061f;
    }

    public void b(@Nullable ColorStateList colorStateList) {
        if (colorStateList != null) {
            this.m = colorStateList.getColorForState(getState(), this.m);
        }
        this.p = colorStateList;
        this.n = true;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        if (this.n) {
            Paint paint = this.f1057b;
            copyBounds(this.f1059d);
            float fHeight = this.f1063h / r1.height();
            paint.setShader(new LinearGradient(0.0f, r1.top, 0.0f, r1.bottom, new int[]{ColorUtils.compositeColors(this.f1064i, this.m), ColorUtils.compositeColors(this.f1065j, this.m), ColorUtils.compositeColors(ColorUtils.setAlphaComponent(this.f1065j, 0), this.m), ColorUtils.compositeColors(ColorUtils.setAlphaComponent(this.f1067l, 0), this.m), ColorUtils.compositeColors(this.f1067l, this.m), ColorUtils.compositeColors(this.f1066k, this.m)}, new float[]{0.0f, fHeight, 0.5f, 0.5f, 1.0f - fHeight, 1.0f}, Shader.TileMode.CLAMP));
            this.n = false;
        }
        float strokeWidth = this.f1057b.getStrokeWidth() / 2.0f;
        copyBounds(this.f1059d);
        this.f1060e.set(this.f1059d);
        float fMin = Math.min(this.o.f1231f.a(a()), this.f1060e.width() / 2.0f);
        if (this.o.e(a())) {
            this.f1060e.inset(strokeWidth, strokeWidth);
            canvas.drawRoundRect(this.f1060e, fMin, fMin, this.f1057b);
        }
    }

    @Override // android.graphics.drawable.Drawable
    @Nullable
    public Drawable.ConstantState getConstantState() {
        return this.f1062g;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.f1063h > 0.0f ? -3 : -2;
    }

    @Override // android.graphics.drawable.Drawable
    @TargetApi(21)
    public void getOutline(@NonNull Outline outline) {
        if (this.o.e(a())) {
            outline.setRoundRect(getBounds(), this.o.f1231f.a(a()));
            return;
        }
        copyBounds(this.f1059d);
        this.f1060e.set(this.f1059d);
        this.a.a(this.o, 1.0f, this.f1060e, this.f1058c);
        if (this.f1058c.isConvex()) {
            outline.setConvexPath(this.f1058c);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(@NonNull Rect rect) {
        if (!this.o.e(a())) {
            return true;
        }
        int iRound = Math.round(this.f1063h);
        rect.set(iRound, iRound, iRound, iRound);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList = this.p;
        return (colorStateList != null && colorStateList.isStateful()) || super.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        this.n = true;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        int colorForState;
        ColorStateList colorStateList = this.p;
        if (colorStateList != null && (colorForState = colorStateList.getColorForState(iArr, this.m)) != this.m) {
            this.n = true;
            this.m = colorForState;
        }
        if (this.n) {
            invalidateSelf();
        }
        return this.n;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(@IntRange(from = 0, to = 255) int i2) {
        this.f1057b.setAlpha(i2);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.f1057b.setColorFilter(colorFilter);
        invalidateSelf();
    }
}

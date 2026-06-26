package io.legado.app.ui.widget.anima;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import c.b.a.m.f;
import com.qq.e.comm.constants.Constants;
import com.umeng.analytics.pro.ai;
import com.umeng.analytics.pro.c;
import f.c0.c.j;
import io.legado.app.R$styleable;
import io.legado.app.ui.widget.anima.RotateLoading;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mozilla.javascript.ES6Iterator;
import org.mozilla.javascript.optimizer.OptRuntime;

/* JADX INFO: compiled from: RotateLoading.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010F\u001a\u00020E\u0012\n\b\u0002\u0010H\u001a\u0004\u0018\u00010G¢\u0006\u0004\bI\u0010JJ/\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0014¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\u0010\u0010\u000fJ\r\u0010\u0011\u001a\u00020\u0007¢\u0006\u0004\b\u0011\u0010\u000fJ\r\u0010\u0012\u001a\u00020\u0007¢\u0006\u0004\b\u0012\u0010\u000fJ\u000f\u0010\u0013\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0013\u0010\u000fR\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\"\u0010\"\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0016\u0010%\u001a\u00020#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010$R$\u0010*\u001a\u00020&2\u0006\u0010'\u001a\u00020&8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\u0016\u0010-\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010\u001dR\u0016\u0010/\u001a\u00020&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010)R\u0016\u00101\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u0010\u001dR\u0016\u00103\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u0010\u001dR\u0016\u00107\u001a\u0002048\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u00106R\u0016\u00108\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0004\u0010\u001dR\u0016\u0010:\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u0010\u001aR*\u0010?\u001a\u00020\u00022\u0006\u0010;\u001a\u00020\u00028\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b<\u0010\u001d\u001a\u0004\b=\u0010\u001f\"\u0004\b>\u0010!R\u0016\u0010A\u001a\u0002048\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b@\u00106R\u0018\u0010B\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0016R\u0016\u0010D\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bC\u0010\u001d¨\u0006K"}, d2 = {"Lio/legado/app/ui/widget/anima/RotateLoading;", "Landroid/view/View;", "", "w", "h", "oldw", "oldh", "Lf/v;", "onSizeChanged", "(IIII)V", "Landroid/graphics/Canvas;", "canvas", "onDraw", "(Landroid/graphics/Canvas;)V", "onAttachedToWindow", "()V", "onDetachedFromWindow", "b", ai.at, ai.aD, "Landroid/graphics/RectF;", "d", "Landroid/graphics/RectF;", "shadowRectF", "", "o", "F", "speedOfArc", "k", OptRuntime.GeneratorState.resumptionPoint_TYPE, "getHideMode", "()I", "setHideMode", "(I)V", "hideMode", "Landroid/graphics/Paint;", "Landroid/graphics/Paint;", "mPaint", "", "<set-?>", Constants.LANDSCAPE, "Z", "isStarted", "()Z", "j", "shadowPosition", ai.aA, "changeBigger", "e", "topDegree", "n", "speedOfDegree", "Ljava/lang/Runnable;", "q", "Ljava/lang/Runnable;", "hidden", "thisWidth", "g", "arc", ES6Iterator.VALUE_PROPERTY, "m", "getLoadingColor", "setLoadingColor", "loadingColor", "p", "shown", "loadingRectF", "f", "bottomDegree", "Landroid/content/Context;", c.R, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class RotateLoading extends View {
    public static final /* synthetic */ int a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public Paint mPaint;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public RectF loadingRectF;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public RectF shadowRectF;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    public int topDegree;

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    public int bottomDegree;

    /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
    public float arc;

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    public int thisWidth;

    /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
    public boolean changeBigger;

    /* JADX INFO: renamed from: j, reason: collision with root package name and from kotlin metadata */
    public int shadowPosition;

    /* JADX INFO: renamed from: k, reason: collision with root package name and from kotlin metadata */
    public int hideMode;

    /* JADX INFO: renamed from: l, reason: collision with root package name and from kotlin metadata */
    public boolean isStarted;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    public int loadingColor;

    /* JADX INFO: renamed from: n, reason: from kotlin metadata */
    public int speedOfDegree;

    /* JADX INFO: renamed from: o, reason: from kotlin metadata */
    public float speedOfArc;

    /* JADX INFO: renamed from: p, reason: from kotlin metadata */
    @NotNull
    public final Runnable shown;

    /* JADX INFO: renamed from: q, reason: from kotlin metadata */
    @NotNull
    public final Runnable hidden;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public RotateLoading(@NotNull Context context) {
        this(context, null);
        j.e(context, c.R);
    }

    public final void a() {
        removeCallbacks(this.shown);
        removeCallbacks(this.hidden);
        animate().cancel();
        this.isStarted = false;
        setVisibility(this.hideMode);
        invalidate();
    }

    public final void b() {
        removeCallbacks(this.shown);
        removeCallbacks(this.hidden);
        post(this.shown);
    }

    public final void c() {
        animate().cancel();
        animate().scaleX(1.0f).scaleY(1.0f).setListener(new e.a.a.g.m.i.c(this)).start();
        this.isStarted = true;
        invalidate();
    }

    public final int getHideMode() {
        return this.hideMode;
    }

    public final int getLoadingColor() {
        return this.loadingColor;
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (getVisibility() == 0) {
            c();
        }
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.isStarted = false;
        animate().cancel();
        removeCallbacks(this.shown);
        removeCallbacks(this.hidden);
    }

    @Override // android.view.View
    public void onDraw(@NotNull Canvas canvas) {
        j.e(canvas, "canvas");
        super.onDraw(canvas);
        if (this.isStarted) {
            this.mPaint.setColor(Color.parseColor("#1a000000"));
            RectF rectF = this.shadowRectF;
            if (rectF != null) {
                canvas.drawArc(rectF, this.topDegree, this.arc, false, this.mPaint);
                canvas.drawArc(rectF, this.bottomDegree, this.arc, false, this.mPaint);
            }
            this.mPaint.setColor(this.loadingColor);
            RectF rectF2 = this.loadingRectF;
            if (rectF2 != null) {
                canvas.drawArc(rectF2, this.topDegree, this.arc, false, this.mPaint);
                canvas.drawArc(rectF2, this.bottomDegree, this.arc, false, this.mPaint);
            }
            int i2 = this.topDegree;
            int i3 = this.speedOfDegree;
            int i4 = i2 + i3;
            this.topDegree = i4;
            int i5 = this.bottomDegree + i3;
            this.bottomDegree = i5;
            if (i4 > 360) {
                this.topDegree = i4 - 360;
            }
            if (i5 > 360) {
                this.bottomDegree = i5 - 360;
            }
            if (this.changeBigger) {
                float f2 = this.arc;
                if (f2 < 160.0f) {
                    this.arc = f2 + this.speedOfArc;
                    invalidate();
                }
            } else {
                float f3 = this.arc;
                if (f3 > i3) {
                    this.arc = f3 - (2 * this.speedOfArc);
                    invalidate();
                }
            }
            float f4 = this.arc;
            if (f4 >= 160.0f || f4 <= 10.0f) {
                this.changeBigger = !this.changeBigger;
                invalidate();
            }
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int w, int h2, int oldw, int oldh) {
        super.onSizeChanged(w, h2, oldw, oldh);
        this.arc = 10.0f;
        int i2 = this.thisWidth;
        this.loadingRectF = new RectF(i2 * 2, i2 * 2, w - (i2 * 2), h2 - (i2 * 2));
        int i3 = this.thisWidth;
        int i4 = this.shadowPosition;
        this.shadowRectF = new RectF((i3 * 2) + i4, (i3 * 2) + i4, (w - (i3 * 2)) + i4, (h2 - (i3 * 2)) + i4);
    }

    public final void setHideMode(int i2) {
        this.hideMode = i2;
    }

    public final void setLoadingColor(int i2) {
        this.loadingColor = i2;
        invalidate();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public RotateLoading(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        j.e(context, c.R);
        this.topDegree = 10;
        this.bottomDegree = 190;
        this.changeBigger = true;
        this.hideMode = 8;
        this.shown = new Runnable() { // from class: e.a.a.g.m.i.a
            @Override // java.lang.Runnable
            public final void run() {
                RotateLoading rotateLoading = this.a;
                int i2 = RotateLoading.a;
                j.e(rotateLoading, "this$0");
                rotateLoading.c();
            }
        };
        this.hidden = new Runnable() { // from class: e.a.a.g.m.i.b
            @Override // java.lang.Runnable
            public final void run() {
                RotateLoading rotateLoading = this.a;
                int i2 = RotateLoading.a;
                j.e(rotateLoading, "this$0");
                rotateLoading.animate().cancel();
                rotateLoading.isStarted = false;
                rotateLoading.setVisibility(rotateLoading.hideMode);
                rotateLoading.invalidate();
            }
        };
        setLoadingColor(f.M1(context));
        this.thisWidth = f.m2(6);
        this.shadowPosition = f.m2(2);
        this.speedOfDegree = 10;
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.RotateLoading);
            j.d(typedArrayObtainStyledAttributes, "context.obtainStyledAttributes(attrs, R.styleable.RotateLoading)");
            setLoadingColor(typedArrayObtainStyledAttributes.getColor(1, this.loadingColor));
            this.thisWidth = typedArrayObtainStyledAttributes.getDimensionPixelSize(3, f.m2(6));
            this.shadowPosition = typedArrayObtainStyledAttributes.getInt(4, 2);
            this.speedOfDegree = typedArrayObtainStyledAttributes.getInt(2, 10);
            this.hideMode = typedArrayObtainStyledAttributes.getInt(0, 2) == 1 ? 4 : 8;
            typedArrayObtainStyledAttributes.recycle();
        }
        this.speedOfArc = this.speedOfDegree / 4;
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setColor(this.loadingColor);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeWidth(this.thisWidth);
        this.mPaint.setStrokeCap(Paint.Cap.ROUND);
    }
}

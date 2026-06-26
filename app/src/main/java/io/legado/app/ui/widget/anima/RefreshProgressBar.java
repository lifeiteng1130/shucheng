package io.legado.app.ui.widget.anima;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import com.qq.e.comm.constants.Constants;
import com.umeng.analytics.pro.ai;
import com.umeng.analytics.pro.c;
import f.c0.c.j;
import io.legado.app.R$styleable;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mozilla.javascript.optimizer.OptRuntime;

/* JADX INFO: compiled from: RefreshProgressBar.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010I\u001a\u00020H\u0012\n\b\u0002\u0010K\u001a\u0004\u0018\u00010J¢\u0006\u0004\bL\u0010MJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\r\u001a\u00020\u0007¢\u0006\u0004\b\r\u0010\tJ\u0015\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0007¢\u0006\u0004\b\u000f\u0010\fJ\u0015\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0007¢\u0006\u0004\b\u0010\u0010\fR$\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00078\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\tR\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\"\u0010\u001d\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0013\u001a\u0004\b\u001b\u0010\t\"\u0004\b\u001c\u0010\fR\u0016\u0010\u001f\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u0013R\u0016\u0010!\u001a\u00020\u00168\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010\u0018R\"\u0010%\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010\u0013\u001a\u0004\b#\u0010\t\"\u0004\b$\u0010\fR\"\u0010)\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b&\u0010\u0013\u001a\u0004\b'\u0010\t\"\u0004\b(\u0010\fR\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010\u0013R\"\u0010.\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b+\u0010\u0013\u001a\u0004\b,\u0010\t\"\u0004\b-\u0010\fR\"\u00102\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b/\u0010\u0013\u001a\u0004\b0\u0010\t\"\u0004\b1\u0010\fR\u0016\u00103\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u0010\u0013R\u0016\u00107\u001a\u0002048\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u00106R\"\u0010;\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b8\u0010\u0013\u001a\u0004\b9\u0010\t\"\u0004\b:\u0010\fR*\u0010@\u001a\u00020<2\u0006\u0010=\u001a\u00020<8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b>\u0010?\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\u0016\u0010G\u001a\u00020D8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bE\u0010F¨\u0006N"}, d2 = {"Lio/legado/app/ui/widget/anima/RefreshProgressBar;", "Landroid/view/View;", "Landroid/graphics/Canvas;", "canvas", "Lf/v;", "onDraw", "(Landroid/graphics/Canvas;)V", "", "getDurProgress", "()I", "durProgress", "setDurProgress", "(I)V", "getSecondDurProgress", "secondDur", "setSecondDurProgress", "setSecondDurProgressWithAnim", "<set-?>", "j", OptRuntime.GeneratorState.resumptionPoint_TYPE, "getSecondFinalProgress", "secondFinalProgress", "Landroid/graphics/Rect;", Constants.LANDSCAPE, "Landroid/graphics/Rect;", "bgRect", "e", "getSecondMaxProgress", "setSecondMaxProgress", "secondMaxProgress", ai.aD, "secondDurProgress", "m", "secondRect", "g", "getSecondColor", "setSecondColor", "secondColor", "f", "getBgColor", "setBgColor", "bgColor", "b", "h", "getFontColor", "setFontColor", "fontColor", ai.aA, "getSpeed", "setSpeed", "speed", ai.at, "Landroid/graphics/RectF;", "n", "Landroid/graphics/RectF;", "fontRectF", "d", "getMaxProgress", "setMaxProgress", "maxProgress", "", "loading", "o", "Z", "isAutoLoading", "()Z", "setAutoLoading", "(Z)V", "Landroid/graphics/Paint;", "k", "Landroid/graphics/Paint;", "paint", "Landroid/content/Context;", c.R, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class RefreshProgressBar extends View {
    public int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    public int durProgress;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    public int secondDurProgress;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    public int maxProgress;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    public int secondMaxProgress;

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    public int bgColor;

    /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
    public int secondColor;

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    public int fontColor;

    /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
    public int speed;

    /* JADX INFO: renamed from: j, reason: collision with root package name and from kotlin metadata */
    public int secondFinalProgress;

    /* JADX INFO: renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public Paint paint;

    /* JADX INFO: renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final Rect bgRect;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    @NotNull
    public final Rect secondRect;

    /* JADX INFO: renamed from: n, reason: from kotlin metadata */
    @NotNull
    public final RectF fontRectF;

    /* JADX INFO: renamed from: o, reason: from kotlin metadata */
    public boolean isAutoLoading;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public RefreshProgressBar(@NotNull Context context) {
        this(context, null);
        j.e(context, c.R);
    }

    public final int getBgColor() {
        return this.bgColor;
    }

    public final int getDurProgress() {
        return this.durProgress;
    }

    public final int getFontColor() {
        return this.fontColor;
    }

    public final int getMaxProgress() {
        return this.maxProgress;
    }

    public final int getSecondColor() {
        return this.secondColor;
    }

    public final int getSecondDurProgress() {
        return this.secondDurProgress;
    }

    public final int getSecondFinalProgress() {
        return this.secondFinalProgress;
    }

    public final int getSecondMaxProgress() {
        return this.secondMaxProgress;
    }

    public final int getSpeed() {
        return this.speed;
    }

    @Override // android.view.View
    public void onDraw(@NotNull Canvas canvas) {
        int i2;
        j.e(canvas, "canvas");
        super.onDraw(canvas);
        this.paint.setColor(this.bgColor);
        this.bgRect.set(0, 0, getMeasuredWidth(), getMeasuredHeight());
        canvas.drawRect(this.bgRect, this.paint);
        int i3 = this.secondDurProgress;
        if (i3 > 0 && (i2 = this.secondMaxProgress) > 0) {
            if (i3 < 0) {
                i3 = 0;
            }
            if (i3 <= i2) {
                i2 = i3;
            }
            this.paint.setColor(this.secondColor);
            int measuredWidth = ((int) (((i2 * 1.0f) / this.secondMaxProgress) * (getMeasuredWidth() * 1.0f))) / 2;
            this.secondRect.set((getMeasuredWidth() / 2) - measuredWidth, 0, (getMeasuredWidth() / 2) + measuredWidth, getMeasuredHeight());
            canvas.drawRect(this.secondRect, this.paint);
        }
        if (this.durProgress > 0 && this.maxProgress > 0) {
            this.paint.setColor(this.fontColor);
            this.fontRectF.set(0.0f, 0.0f, ((this.durProgress * 1.0f) / this.maxProgress) * getMeasuredWidth() * 1.0f, getMeasuredHeight());
            canvas.drawRect(this.fontRectF, this.paint);
        }
        if (this.isAutoLoading) {
            int i4 = this.secondDurProgress;
            int i5 = this.secondMaxProgress;
            if (i4 >= i5) {
                this.a = -1;
            } else if (i4 <= 0) {
                this.a = 1;
            }
            int i6 = (this.a * this.speed) + i4;
            this.secondDurProgress = i6;
            if (i6 < 0) {
                this.secondDurProgress = 0;
            } else if (i6 > i5) {
                this.secondDurProgress = i5;
            }
            this.secondFinalProgress = this.secondDurProgress;
            invalidate();
            return;
        }
        int i7 = this.secondDurProgress;
        int i8 = this.secondFinalProgress;
        if (i7 != i8) {
            if (i7 > i8) {
                int i9 = i7 - this.speed;
                this.secondDurProgress = i9;
                if (i9 < i8) {
                    this.secondDurProgress = i8;
                }
            } else {
                int i10 = i7 + this.speed;
                this.secondDurProgress = i10;
                if (i10 > i8) {
                    this.secondDurProgress = i8;
                }
            }
            invalidate();
        }
    }

    public final void setAutoLoading(boolean z) {
        this.isAutoLoading = z;
        if (!z) {
            this.secondDurProgress = 0;
            this.secondFinalProgress = 0;
        }
        this.maxProgress = 0;
        invalidate();
    }

    public final void setBgColor(int i2) {
        this.bgColor = i2;
    }

    public final void setDurProgress(int durProgress) {
        if (durProgress < 0) {
            durProgress = 0;
        }
        int i2 = this.maxProgress;
        if (durProgress > i2) {
            durProgress = i2;
        }
        this.durProgress = durProgress;
        if (j.a(Looper.myLooper(), Looper.getMainLooper())) {
            invalidate();
        } else {
            postInvalidate();
        }
    }

    public final void setFontColor(int i2) {
        this.fontColor = i2;
    }

    public final void setMaxProgress(int i2) {
        this.maxProgress = i2;
    }

    public final void setSecondColor(int i2) {
        this.secondColor = i2;
    }

    public final void setSecondDurProgress(int secondDur) {
        this.secondDurProgress = secondDur;
        this.secondFinalProgress = secondDur;
        if (j.a(Looper.myLooper(), Looper.getMainLooper())) {
            invalidate();
        } else {
            postInvalidate();
        }
    }

    public final void setSecondDurProgressWithAnim(int secondDur) {
        if (secondDur < 0) {
            secondDur = 0;
        }
        int i2 = this.secondMaxProgress;
        if (secondDur > i2) {
            secondDur = i2;
        }
        this.secondFinalProgress = secondDur;
        if (j.a(Looper.myLooper(), Looper.getMainLooper())) {
            invalidate();
        } else {
            postInvalidate();
        }
    }

    public final void setSecondMaxProgress(int i2) {
        this.secondMaxProgress = i2;
    }

    public final void setSpeed(int i2) {
        this.speed = i2;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public RefreshProgressBar(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        j.e(context, c.R);
        this.a = 1;
        this.maxProgress = 100;
        this.secondMaxProgress = 100;
        this.secondColor = -4079167;
        this.fontColor = -13224394;
        this.speed = 2;
        this.paint = new Paint();
        this.bgRect = new Rect();
        this.secondRect = new Rect();
        this.fontRectF = new RectF();
        this.paint.setStyle(Paint.Style.FILL);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.RefreshProgressBar);
        j.d(typedArrayObtainStyledAttributes, "context.obtainStyledAttributes(attrs, R.styleable.RefreshProgressBar)");
        this.speed = typedArrayObtainStyledAttributes.getDimensionPixelSize(7, this.speed);
        this.maxProgress = typedArrayObtainStyledAttributes.getInt(3, this.maxProgress);
        this.durProgress = typedArrayObtainStyledAttributes.getInt(1, this.durProgress);
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(5, this.secondDurProgress);
        this.secondDurProgress = dimensionPixelSize;
        this.secondFinalProgress = dimensionPixelSize;
        this.secondMaxProgress = typedArrayObtainStyledAttributes.getDimensionPixelSize(6, this.secondMaxProgress);
        this.bgColor = typedArrayObtainStyledAttributes.getColor(0, this.bgColor);
        this.secondColor = typedArrayObtainStyledAttributes.getColor(4, this.secondColor);
        this.fontColor = typedArrayObtainStyledAttributes.getColor(2, this.fontColor);
        typedArrayObtainStyledAttributes.recycle();
    }
}

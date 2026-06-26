package io.legado.app.ui.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.util.AttributeSet;
import androidx.annotation.ColorInt;
import androidx.appcompat.widget.AppCompatTextView;
import c.b.a.m.f;
import com.umeng.analytics.pro.ai;
import com.umeng.analytics.pro.c;
import f.c0.c.j;
import f.c0.c.k;
import f.e;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mozilla.javascript.ES6Iterator;

/* JADX INFO: compiled from: BatteryView.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010)\u001a\u00020(\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010*¢\u0006\u0004\b,\u0010-J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\b\b\u0001\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\f\u0010\nJ\u0017\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0014¢\u0006\u0004\b\u000f\u0010\u0010R*\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00118\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\f\u0010\u0017R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010!\u001a\u00020\u00188\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010\u001aR%\u0010'\u001a\n \"*\u0004\u0018\u00010\u00020\u00028B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&¨\u0006."}, d2 = {"Lio/legado/app/ui/widget/BatteryView;", "Landroidx/appcompat/widget/AppCompatTextView;", "Landroid/graphics/Typeface;", "tf", "Lf/v;", "setTypeface", "(Landroid/graphics/Typeface;)V", "", "color", "setColor", "(I)V", ai.Z, "setBattery", "Landroid/graphics/Canvas;", "canvas", "onDraw", "(Landroid/graphics/Canvas;)V", "", ES6Iterator.VALUE_PROPERTY, "e", "Z", "isBattery", "()Z", "(Z)V", "Landroid/graphics/Rect;", "d", "Landroid/graphics/Rect;", "polar", "Landroid/graphics/Paint;", "b", "Landroid/graphics/Paint;", "batteryPaint", ai.aD, "outFrame", "kotlin.jvm.PlatformType", ai.at, "Lf/e;", "getBatteryTypeface", "()Landroid/graphics/Typeface;", "batteryTypeface", "Landroid/content/Context;", c.R, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class BatteryView extends AppCompatTextView {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    @NotNull
    public final e batteryTypeface;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final Paint batteryPaint;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final Rect outFrame;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final Rect polar;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    public boolean isBattery;

    /* JADX INFO: compiled from: BatteryView.kt */
    public static final class a extends k implements f.c0.b.a<Typeface> {
        public final /* synthetic */ Context $context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Context context) {
            super(0);
            this.$context = context;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // f.c0.b.a
        public final Typeface invoke() {
            return Typeface.createFromAsset(this.$context.getAssets(), "font/number.ttf");
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public BatteryView(@NotNull Context context) {
        this(context, null);
        j.e(context, c.R);
    }

    private final Typeface getBatteryTypeface() {
        return (Typeface) this.batteryTypeface.getValue();
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(@NotNull Canvas canvas) {
        j.e(canvas, "canvas");
        super.onDraw(canvas);
        if (this.isBattery) {
            this.outFrame.set(f.m2(1), f.m2(1), getWidth() - f.m2(3), getHeight() - f.m2(1));
            Rect rect = this.outFrame;
            int i2 = rect.bottom;
            int i3 = rect.top;
            int i4 = (i2 - i3) / 3;
            this.polar.set(rect.right, i3 + i4, getWidth() - f.m2(1), this.outFrame.bottom - i4);
            this.batteryPaint.setStyle(Paint.Style.STROKE);
            canvas.drawRect(this.outFrame, this.batteryPaint);
            this.batteryPaint.setStyle(Paint.Style.FILL);
            canvas.drawRect(this.polar, this.batteryPaint);
        }
    }

    public final void setBattery(boolean z) {
        this.isBattery = z;
        if (z) {
            super.setTypeface(getBatteryTypeface());
            postInvalidate();
        }
    }

    public final void setColor(@ColorInt int color) {
        setTextColor(color);
        this.batteryPaint.setColor(color);
        invalidate();
    }

    @Override // android.widget.TextView
    public void setTypeface(@Nullable Typeface tf) {
        if (this.isBattery) {
            return;
        }
        super.setTypeface(tf);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public BatteryView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        j.e(context, c.R);
        this.batteryTypeface = f.N3(new a(context));
        Paint paint = new Paint();
        this.batteryPaint = paint;
        this.outFrame = new Rect();
        this.polar = new Rect();
        setPadding(f.m2(4), f.m2(2), f.m2(6), f.m2(2));
        paint.setStrokeWidth(f.m2(1));
        paint.setAntiAlias(true);
        paint.setColor(getPaint().getColor());
    }

    @SuppressLint({"SetTextI18n"})
    public final void setBattery(int battery) {
        setText(String.valueOf(battery));
    }
}

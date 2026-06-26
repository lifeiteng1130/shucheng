package io.legado.app.ui.widget.checkbox;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.Checkable;
import com.qq.e.comm.constants.Constants;
import com.umeng.analytics.pro.ai;
import com.umeng.analytics.pro.c;
import f.c0.b.p;
import f.c0.c.f;
import f.c0.c.j;
import f.v;
import io.legado.app.R$styleable;
import io.legado.app.ui.widget.checkbox.SmoothCheckBox;
import io.wenyuange.app.release.R;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mozilla.javascript.optimizer.OptRuntime;

/* JADX INFO: compiled from: SmoothCheckBox.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001d2\u00020\u00012\u00020\u0002:\u0001\u001dB\u001d\b\u0007\u0012\u0006\u0010_\u001a\u00020^\u0012\n\b\u0002\u0010a\u001a\u0004\u0018\u00010`¢\u0006\u0004\bb\u0010cJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u000f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0014¢\u0006\u0004\b\u000f\u0010\u0010J7\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\fH\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u0018H\u0014¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\fH\u0002¢\u0006\u0004\b\u001d\u0010\u001eR\u001c\u0010#\u001a\b\u0012\u0004\u0012\u00020 0\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010&\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010,\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010%R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00103\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u00102R\u0016\u00107\u001a\u0002048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u00106R\u0016\u00109\u001a\u00020'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u0010)R\u0016\u0010;\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u00102RT\u0010F\u001a4\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b=\u0012\b\b>\u0012\u0004\b\b(?\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b=\u0012\b\b>\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u0007\u0018\u00010<8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b@\u0010A\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\u0016\u0010H\u001a\u0002048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bG\u00106R\u0016\u0010J\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bI\u0010%R\u0016\u0010L\u001a\u0002048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bK\u00106R\u0016\u0010O\u001a\u00020 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bM\u0010NR\u0016\u0010Q\u001a\u00020'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bP\u0010)R\u0016\u0010S\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bR\u0010%R\u0016\u0010U\u001a\u00020'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bT\u0010)R\u0016\u0010W\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bV\u0010%R\u0016\u0010Y\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bX\u0010%R\u0016\u0010[\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bZ\u0010%R\u0016\u0010]\u001a\u00020'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\\\u0010)¨\u0006d"}, d2 = {"Lio/legado/app/ui/widget/checkbox/SmoothCheckBox;", "Landroid/view/View;", "Landroid/widget/Checkable;", "", "isChecked", "()Z", "checked", "Lf/v;", "setChecked", "(Z)V", "toggle", "()V", "", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "(II)V", "changed", "left", "top", "right", "bottom", "onLayout", "(ZIIII)V", "Landroid/graphics/Canvas;", "canvas", "onDraw", "(Landroid/graphics/Canvas;)V", "measureSpec", ai.at, "(I)I", "", "Landroid/graphics/Point;", "e", "[Landroid/graphics/Point;", "mTickPoints", "n", OptRuntime.GeneratorState.resumptionPoint_TYPE, "mAnimDuration", "", "h", "F", "mLeftLineDistance", "r", "mFloorColor", "Landroid/graphics/Path;", "g", "Landroid/graphics/Path;", "mTickPath", ai.aF, "Z", "mChecked", "Landroid/graphics/Paint;", "d", "Landroid/graphics/Paint;", "mFloorPaint", "j", "mDrewDistance", ai.aE, "mTickDrawing", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "checkBox", ai.aC, "Lf/c0/b/p;", "getOnCheckedChangeListener", "()Lf/c0/b/p;", "setOnCheckedChangeListener", "(Lf/c0/b/p;)V", "onCheckedChangeListener", ai.aD, "mTickPaint", "o", "mStrokeWidth", "b", "mPaint", "f", "Landroid/graphics/Point;", "mCenterPoint", "k", "mScaleVal", "p", "mCheckedColor", Constants.LANDSCAPE, "mFloorScale", "m", "mWidth", "q", "mUnCheckedColor", ai.az, "mFloorUnCheckedColor", ai.aA, "mRightLineDistance", "Landroid/content/Context;", c.R, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class SmoothCheckBox extends View implements Checkable {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public Paint mPaint;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public Paint mTickPaint;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public Paint mFloorPaint;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public Point[] mTickPoints;

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public Point mCenterPoint;

    /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public Path mTickPath;

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    public float mLeftLineDistance;

    /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
    public float mRightLineDistance;

    /* JADX INFO: renamed from: j, reason: collision with root package name and from kotlin metadata */
    public float mDrewDistance;

    /* JADX INFO: renamed from: k, reason: collision with root package name and from kotlin metadata */
    public float mScaleVal;

    /* JADX INFO: renamed from: l, reason: collision with root package name and from kotlin metadata */
    public float mFloorScale;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    public int mWidth;

    /* JADX INFO: renamed from: n, reason: from kotlin metadata */
    public int mAnimDuration;

    /* JADX INFO: renamed from: o, reason: from kotlin metadata */
    public int mStrokeWidth;

    /* JADX INFO: renamed from: p, reason: from kotlin metadata */
    public int mCheckedColor;

    /* JADX INFO: renamed from: q, reason: from kotlin metadata */
    public int mUnCheckedColor;

    /* JADX INFO: renamed from: r, reason: from kotlin metadata */
    public int mFloorColor;

    /* JADX INFO: renamed from: s, reason: from kotlin metadata */
    public int mFloorUnCheckedColor;

    /* JADX INFO: renamed from: t, reason: from kotlin metadata */
    public boolean mChecked;

    /* JADX INFO: renamed from: u, reason: from kotlin metadata */
    public boolean mTickDrawing;

    /* JADX INFO: renamed from: v, reason: from kotlin metadata */
    @Nullable
    public p<? super SmoothCheckBox, ? super Boolean, v> onCheckedChangeListener;

    /* JADX INFO: renamed from: io.legado.app.ui.widget.checkbox.SmoothCheckBox$a, reason: from kotlin metadata */
    /* JADX INFO: compiled from: SmoothCheckBox.kt */
    public static final class Companion {
        public Companion(f fVar) {
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SmoothCheckBox(@NotNull Context context) {
        this(context, null);
        j.e(context, c.R);
    }

    public final int a(int measureSpec) {
        int iM2 = c.b.a.m.f.m2(25);
        int size = View.MeasureSpec.getSize(measureSpec);
        int mode = View.MeasureSpec.getMode(measureSpec);
        if (mode == Integer.MIN_VALUE || mode == 0) {
            return Math.min(iM2, size);
        }
        if (mode != 1073741824) {
            return 0;
        }
        return size;
    }

    @Nullable
    public final p<SmoothCheckBox, Boolean, v> getOnCheckedChangeListener() {
        return this.onCheckedChangeListener;
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.mChecked;
    }

    @Override // android.view.View
    public void onDraw(@NotNull Canvas canvas) {
        j.e(canvas, "canvas");
        this.mFloorPaint.setColor(this.mFloorColor);
        float f2 = this.mCenterPoint.x;
        canvas.drawCircle(f2, r0.y, this.mFloorScale * f2, this.mFloorPaint);
        this.mPaint.setColor(this.mUnCheckedColor);
        canvas.drawCircle(this.mCenterPoint.x, r0.y, (r1 - this.mStrokeWidth) * this.mScaleVal, this.mPaint);
        if (this.mTickDrawing && this.mChecked) {
            this.mTickPath.reset();
            float f3 = this.mDrewDistance;
            float f4 = this.mLeftLineDistance;
            if (f3 < f4) {
                float f5 = this.mWidth / 20.0f;
                float f6 = f3 + (f5 >= 3.0f ? f5 : 3.0f);
                this.mDrewDistance = f6;
                Point[] pointArr = this.mTickPoints;
                this.mTickPath.moveTo(pointArr[0].x, pointArr[0].y);
                this.mTickPath.lineTo((((pointArr[1].x - pointArr[0].x) * f6) / f4) + pointArr[0].x, (((pointArr[1].y - pointArr[0].y) * f6) / f4) + pointArr[0].y);
                canvas.drawPath(this.mTickPath, this.mTickPaint);
                float f7 = this.mDrewDistance;
                float f8 = this.mLeftLineDistance;
                if (f7 > f8) {
                    this.mDrewDistance = f8;
                }
            } else {
                Path path = this.mTickPath;
                Point[] pointArr2 = this.mTickPoints;
                path.moveTo(pointArr2[0].x, pointArr2[0].y);
                Path path2 = this.mTickPath;
                Point[] pointArr3 = this.mTickPoints;
                path2.lineTo(pointArr3[1].x, pointArr3[1].y);
                canvas.drawPath(this.mTickPath, this.mTickPaint);
                float f9 = this.mDrewDistance;
                float f10 = this.mLeftLineDistance;
                float f11 = this.mRightLineDistance;
                if (f9 < f10 + f11) {
                    Point[] pointArr4 = this.mTickPoints;
                    float f12 = f9 - f10;
                    float f13 = (((pointArr4[2].x - pointArr4[1].x) * f12) / f11) + pointArr4[1].x;
                    float f14 = pointArr4[1].y - ((f12 * (pointArr4[1].y - pointArr4[2].y)) / f11);
                    this.mTickPath.reset();
                    Path path3 = this.mTickPath;
                    Point[] pointArr5 = this.mTickPoints;
                    path3.moveTo(pointArr5[1].x, pointArr5[1].y);
                    this.mTickPath.lineTo(f13, f14);
                    canvas.drawPath(this.mTickPath, this.mTickPaint);
                    float f15 = this.mWidth / 20.0f;
                    this.mDrewDistance += f15 >= 3.0f ? f15 : 3.0f;
                } else {
                    this.mTickPath.reset();
                    Path path4 = this.mTickPath;
                    Point[] pointArr6 = this.mTickPoints;
                    path4.moveTo(pointArr6[1].x, pointArr6[1].y);
                    Path path5 = this.mTickPath;
                    Point[] pointArr7 = this.mTickPoints;
                    path5.lineTo(pointArr7[2].x, pointArr7[2].y);
                    canvas.drawPath(this.mTickPath, this.mTickPaint);
                }
            }
            if (this.mDrewDistance < this.mLeftLineDistance + this.mRightLineDistance) {
                postDelayed(new Runnable() { // from class: e.a.a.g.m.j.d
                    @Override // java.lang.Runnable
                    public final void run() {
                        SmoothCheckBox smoothCheckBox = this.a;
                        SmoothCheckBox.Companion companion = SmoothCheckBox.INSTANCE;
                        j.e(smoothCheckBox, "this$0");
                        smoothCheckBox.postInvalidate();
                    }
                }, 10L);
            }
        }
    }

    @Override // android.view.View
    public void onLayout(boolean changed, int left, int top, int right, int bottom) {
        this.mWidth = getMeasuredWidth();
        int measuredWidth = this.mStrokeWidth;
        if (measuredWidth == 0) {
            measuredWidth = getMeasuredWidth() / 10;
        }
        this.mStrokeWidth = measuredWidth;
        int measuredWidth2 = measuredWidth > getMeasuredWidth() / 5 ? getMeasuredWidth() / 5 : this.mStrokeWidth;
        this.mStrokeWidth = measuredWidth2;
        if (measuredWidth2 < 3) {
            measuredWidth2 = 3;
        }
        this.mStrokeWidth = measuredWidth2;
        Point point = this.mCenterPoint;
        point.x = this.mWidth / 2;
        point.y = getMeasuredHeight() / 2;
        float f2 = 30;
        this.mTickPoints[0].x = c.b.a.m.f.S4((getMeasuredWidth() / f2) * 7);
        this.mTickPoints[0].y = c.b.a.m.f.S4((getMeasuredHeight() / f2) * 14);
        this.mTickPoints[1].x = c.b.a.m.f.S4((getMeasuredWidth() / f2) * 13);
        this.mTickPoints[1].y = c.b.a.m.f.S4((getMeasuredHeight() / f2) * 20);
        this.mTickPoints[2].x = c.b.a.m.f.S4((getMeasuredWidth() / f2) * 22);
        this.mTickPoints[2].y = c.b.a.m.f.S4((getMeasuredHeight() / f2) * 10);
        Point[] pointArr = this.mTickPoints;
        double dPow = Math.pow(((double) pointArr[1].x) - ((double) pointArr[0].x), 2.0d);
        Point[] pointArr2 = this.mTickPoints;
        this.mLeftLineDistance = (float) Math.sqrt(Math.pow(((double) pointArr2[1].y) - ((double) pointArr2[0].y), 2.0d) + dPow);
        Point[] pointArr3 = this.mTickPoints;
        double dPow2 = Math.pow(((double) pointArr3[2].x) - ((double) pointArr3[1].x), 2.0d);
        Point[] pointArr4 = this.mTickPoints;
        this.mRightLineDistance = (float) Math.sqrt(Math.pow(((double) pointArr4[2].y) - ((double) pointArr4[1].y), 2.0d) + dPow2);
        this.mTickPaint.setStrokeWidth(this.mStrokeWidth);
    }

    @Override // android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(a(widthMeasureSpec), a(heightMeasureSpec));
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean checked) {
        this.mChecked = checked;
        this.mTickDrawing = true;
        this.mFloorScale = 1.0f;
        this.mScaleVal = checked ? 0.0f : 1.0f;
        this.mFloorColor = checked ? this.mCheckedColor : this.mFloorUnCheckedColor;
        this.mDrewDistance = checked ? this.mLeftLineDistance + this.mRightLineDistance : 0.0f;
        invalidate();
        p<? super SmoothCheckBox, ? super Boolean, v> pVar = this.onCheckedChangeListener;
        if (pVar == null) {
            return;
        }
        pVar.invoke(this, Boolean.valueOf(this.mChecked));
    }

    public final void setOnCheckedChangeListener(@Nullable p<? super SmoothCheckBox, ? super Boolean, v> pVar) {
        this.onCheckedChangeListener = pVar;
    }

    @Override // android.widget.Checkable
    public void toggle() {
        setChecked(!this.mChecked);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SmoothCheckBox(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        j.e(context, c.R);
        this.mScaleVal = 1.0f;
        this.mFloorScale = 1.0f;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.SmoothCheckBox);
        j.d(typedArrayObtainStyledAttributes, "context.obtainStyledAttributes(attrs, R.styleable.SmoothCheckBox)");
        j.e(context, c.R);
        j.e(context, c.R);
        SharedPreferences sharedPreferences = context.getSharedPreferences("app_themes", 0);
        j.d(sharedPreferences, "context.getSharedPreferences(\n                ThemeStorePrefKeys.CONFIG_PREFS_KEY_DEFAULT,\n                Context.MODE_PRIVATE\n            )");
        int color = Color.parseColor("#263238");
        j.e(context, c.R);
        TypedArray typedArrayObtainStyledAttributes2 = context.getTheme().obtainStyledAttributes(new int[]{R.attr.colorAccent});
        j.d(typedArrayObtainStyledAttributes2, "context.theme.obtainStyledAttributes(intArrayOf(attr))");
        try {
            color = typedArrayObtainStyledAttributes2.getColor(0, color);
        } catch (Exception unused) {
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes2.recycle();
            throw th;
        }
        typedArrayObtainStyledAttributes2.recycle();
        int i2 = sharedPreferences.getInt("accent_color", color);
        this.mCheckedColor = c.b.a.m.f.c2(context, R.color.background_menu);
        this.mUnCheckedColor = c.b.a.m.f.c2(context, R.color.background_menu);
        this.mFloorColor = c.b.a.m.f.c2(context, R.color.transparent30);
        int color2 = typedArrayObtainStyledAttributes.getColor(1, i2);
        this.mAnimDuration = typedArrayObtainStyledAttributes.getInt(4, 300);
        this.mFloorColor = typedArrayObtainStyledAttributes.getColor(3, this.mFloorColor);
        this.mCheckedColor = typedArrayObtainStyledAttributes.getColor(0, this.mCheckedColor);
        this.mUnCheckedColor = typedArrayObtainStyledAttributes.getColor(2, this.mUnCheckedColor);
        this.mStrokeWidth = typedArrayObtainStyledAttributes.getDimensionPixelSize(5, 0);
        typedArrayObtainStyledAttributes.recycle();
        this.mFloorUnCheckedColor = this.mFloorColor;
        Paint paint = new Paint(1);
        this.mTickPaint = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.mTickPaint.setStrokeCap(Paint.Cap.ROUND);
        this.mTickPaint.setColor(color2);
        Paint paint2 = new Paint(1);
        this.mFloorPaint = paint2;
        paint2.setStyle(Paint.Style.FILL);
        this.mFloorPaint.setColor(this.mFloorColor);
        Paint paint3 = new Paint(1);
        this.mPaint = paint3;
        paint3.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(this.mCheckedColor);
        this.mTickPath = new Path();
        this.mCenterPoint = new Point();
        this.mTickPoints = new Point[]{new Point(), new Point(), new Point()};
        setOnClickListener(new View.OnClickListener() { // from class: e.a.a.g.m.j.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                final SmoothCheckBox smoothCheckBox = this.a;
                SmoothCheckBox.Companion companion = SmoothCheckBox.INSTANCE;
                j.e(smoothCheckBox, "this$0");
                smoothCheckBox.toggle();
                smoothCheckBox.mTickDrawing = false;
                smoothCheckBox.mDrewDistance = 0.0f;
                if (!smoothCheckBox.mChecked) {
                    ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
                    valueAnimatorOfFloat.setDuration(smoothCheckBox.mAnimDuration);
                    valueAnimatorOfFloat.setInterpolator(new LinearInterpolator());
                    valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: e.a.a.g.m.j.b
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                            SmoothCheckBox smoothCheckBox2 = smoothCheckBox;
                            SmoothCheckBox.Companion companion2 = SmoothCheckBox.INSTANCE;
                            j.e(smoothCheckBox2, "this$0");
                            j.e(valueAnimator, "animation");
                            Object animatedValue = valueAnimator.getAnimatedValue();
                            Objects.requireNonNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
                            float fFloatValue = ((Float) animatedValue).floatValue();
                            smoothCheckBox2.mScaleVal = fFloatValue;
                            int i3 = smoothCheckBox2.mCheckedColor;
                            int i4 = smoothCheckBox2.mFloorUnCheckedColor;
                            int iAlpha = Color.alpha(i3);
                            int iRed = Color.red(i3);
                            int iGreen = Color.green(i3);
                            int iBlue = Color.blue(i3);
                            float f2 = 1 - fFloatValue;
                            smoothCheckBox2.mFloorColor = Color.argb((int) ((Color.alpha(i4) * fFloatValue) + (iAlpha * f2)), (int) ((Color.red(i4) * fFloatValue) + (iRed * f2)), (int) ((Color.green(i4) * fFloatValue) + (iGreen * f2)), (int) ((Color.blue(i4) * fFloatValue) + (iBlue * f2)));
                            smoothCheckBox2.postInvalidate();
                        }
                    });
                    valueAnimatorOfFloat.start();
                    ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(1.0f, 0.8f, 1.0f);
                    valueAnimatorOfFloat2.setDuration(smoothCheckBox.mAnimDuration);
                    valueAnimatorOfFloat2.setInterpolator(new LinearInterpolator());
                    valueAnimatorOfFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: e.a.a.g.m.j.a
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                            SmoothCheckBox smoothCheckBox2 = smoothCheckBox;
                            SmoothCheckBox.Companion companion2 = SmoothCheckBox.INSTANCE;
                            j.e(smoothCheckBox2, "this$0");
                            j.e(valueAnimator, "animation");
                            Object animatedValue = valueAnimator.getAnimatedValue();
                            Objects.requireNonNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
                            smoothCheckBox2.mFloorScale = ((Float) animatedValue).floatValue();
                            smoothCheckBox2.postInvalidate();
                        }
                    });
                    valueAnimatorOfFloat2.start();
                    return;
                }
                ValueAnimator valueAnimatorOfFloat3 = ValueAnimator.ofFloat(1.0f, 0.0f);
                valueAnimatorOfFloat3.setDuration(((long) (smoothCheckBox.mAnimDuration / 3)) * 2);
                valueAnimatorOfFloat3.setInterpolator(new LinearInterpolator());
                valueAnimatorOfFloat3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: e.a.a.g.m.j.f
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        SmoothCheckBox smoothCheckBox2 = smoothCheckBox;
                        SmoothCheckBox.Companion companion2 = SmoothCheckBox.INSTANCE;
                        j.e(smoothCheckBox2, "this$0");
                        j.e(valueAnimator, "animation");
                        Object animatedValue = valueAnimator.getAnimatedValue();
                        Objects.requireNonNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
                        float fFloatValue = ((Float) animatedValue).floatValue();
                        smoothCheckBox2.mScaleVal = fFloatValue;
                        int i3 = smoothCheckBox2.mUnCheckedColor;
                        int i4 = smoothCheckBox2.mCheckedColor;
                        float f2 = 1;
                        float f3 = f2 - fFloatValue;
                        int iAlpha = Color.alpha(i3);
                        int iRed = Color.red(i3);
                        int iGreen = Color.green(i3);
                        int iBlue = Color.blue(i3);
                        float f4 = f2 - f3;
                        smoothCheckBox2.mFloorColor = Color.argb((int) ((Color.alpha(i4) * f3) + (iAlpha * f4)), (int) ((Color.red(i4) * f3) + (iRed * f4)), (int) ((Color.green(i4) * f3) + (iGreen * f4)), (int) ((Color.blue(i4) * f3) + (iBlue * f4)));
                        smoothCheckBox2.postInvalidate();
                    }
                });
                valueAnimatorOfFloat3.start();
                ValueAnimator valueAnimatorOfFloat4 = ValueAnimator.ofFloat(1.0f, 0.8f, 1.0f);
                valueAnimatorOfFloat4.setDuration(smoothCheckBox.mAnimDuration);
                valueAnimatorOfFloat4.setInterpolator(new LinearInterpolator());
                valueAnimatorOfFloat4.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: e.a.a.g.m.j.e
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        SmoothCheckBox smoothCheckBox2 = smoothCheckBox;
                        SmoothCheckBox.Companion companion2 = SmoothCheckBox.INSTANCE;
                        j.e(smoothCheckBox2, "this$0");
                        j.e(valueAnimator, "animation");
                        Object animatedValue = valueAnimator.getAnimatedValue();
                        Objects.requireNonNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
                        smoothCheckBox2.mFloorScale = ((Float) animatedValue).floatValue();
                        smoothCheckBox2.postInvalidate();
                    }
                });
                valueAnimatorOfFloat4.start();
                smoothCheckBox.postDelayed(new Runnable() { // from class: e.a.a.g.m.j.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        SmoothCheckBox smoothCheckBox2 = smoothCheckBox;
                        SmoothCheckBox.Companion companion2 = SmoothCheckBox.INSTANCE;
                        j.e(smoothCheckBox2, "this$0");
                        smoothCheckBox2.mTickDrawing = true;
                        smoothCheckBox2.postInvalidate();
                    }
                }, smoothCheckBox.mAnimDuration);
            }
        });
    }
}

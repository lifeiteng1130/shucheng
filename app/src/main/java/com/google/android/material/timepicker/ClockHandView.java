package com.google.android.material.timepicker;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityManager;
import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import c.e.a.b.c0.f;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class ClockHandView extends View {
    public static final /* synthetic */ int a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ValueAnimator f2473b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f2474c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f2475d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f2476e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f2477f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f2478g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List<d> f2479h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f2480i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final float f2481j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Paint f2482k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final RectF f2483l;

    @Px
    public final int m;
    public float n;
    public boolean o;
    public c p;
    public double q;
    public int r;

    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            ClockHandView clockHandView = ClockHandView.this;
            int i2 = ClockHandView.a;
            clockHandView.c(fFloatValue, true);
        }
    }

    public class b extends AnimatorListenerAdapter {
        public b(ClockHandView clockHandView) {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            animator.end();
        }
    }

    public interface c {
    }

    public interface d {
        void a(@FloatRange(from = 0.0d, to = 360.0d) float f2, boolean z);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public ClockHandView(Context context, @Nullable AttributeSet attributeSet) {
        int i2 = R$attr.materialClockStyle;
        super(context, attributeSet, i2);
        this.f2479h = new ArrayList();
        Paint paint = new Paint();
        this.f2482k = paint;
        this.f2483l = new RectF();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ClockHandView, i2, R$style.Widget_MaterialComponents_TimePicker_Clock);
        this.r = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.ClockHandView_materialCircleRadius, 0);
        this.f2480i = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.ClockHandView_selectorSize, 0);
        this.m = getResources().getDimensionPixelSize(R$dimen.material_clock_hand_stroke_width);
        this.f2481j = r0.getDimensionPixelSize(R$dimen.material_clock_hand_center_dot_radius);
        int color = typedArrayObtainStyledAttributes.getColor(R$styleable.ClockHandView_clockHandColor, 0);
        paint.setAntiAlias(true);
        paint.setColor(color);
        b(0.0f, false);
        this.f2478g = ViewConfiguration.get(context).getScaledTouchSlop();
        ViewCompat.setImportantForAccessibility(this, 2);
        typedArrayObtainStyledAttributes.recycle();
    }

    public final int a(float f2, float f3) {
        int degrees = ((int) Math.toDegrees(Math.atan2(f3 - (getHeight() / 2), f2 - (getWidth() / 2)))) + 90;
        return degrees < 0 ? degrees + 360 : degrees;
    }

    public void addOnRotateListener(d dVar) {
        this.f2479h.add(dVar);
    }

    public void b(@FloatRange(from = 0.0d, to = 360.0d) float f2, boolean z) {
        ValueAnimator valueAnimator = this.f2473b;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        if (!z) {
            c(f2, false);
            return;
        }
        float f3 = this.n;
        if (Math.abs(f3 - f2) > 180.0f) {
            if (f3 > 180.0f && f2 < 180.0f) {
                f2 += 360.0f;
            }
            if (f3 < 180.0f && f2 > 180.0f) {
                f3 += 360.0f;
            }
        }
        Pair pair = new Pair(Float.valueOf(f3), Float.valueOf(f2));
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(((Float) pair.first).floatValue(), ((Float) pair.second).floatValue());
        this.f2473b = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(200L);
        this.f2473b.addUpdateListener(new a());
        this.f2473b.addListener(new b(this));
        this.f2473b.start();
    }

    public final void c(@FloatRange(from = 0.0d, to = 360.0d) float f2, boolean z) {
        float f3 = f2 % 360.0f;
        this.n = f3;
        this.q = Math.toRadians(f3 - 90.0f);
        int height = getHeight() / 2;
        float fCos = (this.r * ((float) Math.cos(this.q))) + (getWidth() / 2);
        float fSin = (this.r * ((float) Math.sin(this.q))) + height;
        RectF rectF = this.f2483l;
        int i2 = this.f2480i;
        rectF.set(fCos - i2, fSin - i2, fCos + i2, fSin + i2);
        Iterator<d> it = this.f2479h.iterator();
        while (it.hasNext()) {
            it.next().a(f3, z);
        }
        invalidate();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int height = getHeight() / 2;
        float width = getWidth() / 2;
        float fCos = (this.r * ((float) Math.cos(this.q))) + width;
        float f2 = height;
        float fSin = (this.r * ((float) Math.sin(this.q))) + f2;
        this.f2482k.setStrokeWidth(0.0f);
        canvas.drawCircle(fCos, fSin, this.f2480i, this.f2482k);
        double dSin = Math.sin(this.q);
        double dCos = Math.cos(this.q);
        this.f2482k.setStrokeWidth(this.m);
        canvas.drawLine(width, f2, r1 + ((int) (dCos * d)), height + ((int) (d * dSin)), this.f2482k);
        canvas.drawCircle(width, f2, this.f2481j, this.f2482k);
    }

    @Override // android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        b(this.n, false);
    }

    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        c cVar;
        int actionMasked = motionEvent.getActionMasked();
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        if (actionMasked != 0) {
            if (actionMasked == 1 || actionMasked == 2) {
                int i2 = (int) (x - this.f2475d);
                int i3 = (int) (y - this.f2476e);
                this.f2477f = (i3 * i3) + (i2 * i2) > this.f2478g;
                z2 = this.o;
                z = actionMasked == 1;
            } else {
                z = false;
                z2 = false;
            }
            z3 = false;
        } else {
            this.f2475d = x;
            this.f2476e = y;
            this.f2477f = true;
            this.o = false;
            z = false;
            z2 = false;
            z3 = true;
        }
        boolean z5 = this.o;
        float fA = a(x, y);
        boolean z6 = this.n != fA;
        if (z3 && z6) {
            z4 = true;
        } else if (z6 || z2) {
            b(fA, z && this.f2474c);
            z4 = true;
        } else {
            z4 = false;
        }
        boolean z7 = z4 | z5;
        this.o = z7;
        if (z7 && z && (cVar = this.p) != null) {
            float fA2 = a(x, y);
            boolean z8 = this.f2477f;
            f fVar = (f) cVar;
            fVar.f926h = true;
            TimeModel timeModel = fVar.f923e;
            int i4 = timeModel.f2498e;
            int i5 = timeModel.f2497d;
            if (timeModel.f2499f == 10) {
                fVar.f922d.f2502c.b(fVar.f925g, false);
                if (!((AccessibilityManager) ContextCompat.getSystemService(fVar.f922d.getContext(), AccessibilityManager.class)).isTouchExplorationEnabled()) {
                    fVar.f(12, true);
                }
            } else {
                int iRound = Math.round(fA2);
                if (!z8) {
                    TimeModel timeModel2 = fVar.f923e;
                    Objects.requireNonNull(timeModel2);
                    timeModel2.f2498e = (((iRound + 15) / 30) * 5) % 60;
                    fVar.f924f = fVar.f923e.f2498e * 6;
                }
                fVar.f922d.f2502c.b(fVar.f924f, z8);
            }
            fVar.f926h = false;
            fVar.g();
            TimeModel timeModel3 = fVar.f923e;
            if (timeModel3.f2498e != i4 || timeModel3.f2497d != i5) {
                fVar.f922d.performHapticFeedback(4);
            }
        }
        return true;
    }

    public void setOnActionUpListener(c cVar) {
        this.p = cVar;
    }
}

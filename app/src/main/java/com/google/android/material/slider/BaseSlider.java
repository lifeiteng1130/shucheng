package com.google.android.material.slider;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.widget.SeekBar;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import androidx.core.graphics.ColorUtils;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.math.MathUtils;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.widget.ExploreByTouchHelper;
import c.e.a.b.q.g;
import c.e.a.b.q.h;
import c.e.a.b.q.i;
import c.e.a.b.w.l;
import c.e.a.b.x.a;
import c.e.a.b.x.b;
import com.google.android.material.R$attr;
import com.google.android.material.R$color;
import com.google.android.material.R$dimen;
import com.google.android.material.R$string;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.slider.BaseSlider;
import com.google.android.material.tooltip.TooltipDrawable;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseSlider<S extends BaseSlider<S, L, T>, L extends c.e.a.b.x.a<S>, T extends c.e.a.b.x.b<S>> extends View {
    public static final String a = BaseSlider.class.getSimpleName();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f2354b = R$style.Widget_MaterialComponents_Slider;
    public int A;
    public int B;
    public int C;
    public float D;
    public MotionEvent E;
    public c.e.a.b.x.c F;
    public boolean G;
    public float H;
    public float I;
    public ArrayList<Float> J;
    public int K;
    public int O;
    public float P;
    public float[] Q;
    public boolean R;
    public int S;
    public boolean T;
    public boolean U;

    @NonNull
    public ColorStateList V;

    @NonNull
    public ColorStateList W;

    @NonNull
    public ColorStateList a0;

    @NonNull
    public ColorStateList b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final Paint f2355c;

    @NonNull
    public ColorStateList c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final Paint f2356d;

    @NonNull
    public final MaterialShapeDrawable d0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NonNull
    public final Paint f2357e;
    public float e0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final Paint f2358f;
    public int f0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final Paint f2359g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    public final Paint f2360h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NonNull
    public final e f2361i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final AccessibilityManager f2362j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public BaseSlider<S, L, T>.d f2363k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @NonNull
    public final f f2364l;

    @NonNull
    public final List<TooltipDrawable> m;

    @NonNull
    public final List<L> n;

    @NonNull
    public final List<T> o;
    public boolean p;
    public ValueAnimator q;
    public ValueAnimator r;
    public final int s;
    public int t;
    public int u;
    public int v;
    public int w;
    public int x;
    public int y;
    public int z;

    public static class SliderState extends View.BaseSavedState {
        public static final Parcelable.Creator<SliderState> CREATOR = new a();
        public float a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f2365b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public ArrayList<Float> f2366c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f2367d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f2368e;

        public static class a implements Parcelable.Creator<SliderState> {
            @Override // android.os.Parcelable.Creator
            @NonNull
            public SliderState createFromParcel(@NonNull Parcel parcel) {
                return new SliderState(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            @NonNull
            public SliderState[] newArray(int i2) {
                return new SliderState[i2];
            }
        }

        public SliderState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@NonNull Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeFloat(this.a);
            parcel.writeFloat(this.f2365b);
            parcel.writeList(this.f2366c);
            parcel.writeFloat(this.f2367d);
            parcel.writeBooleanArray(new boolean[]{this.f2368e});
        }

        public SliderState(Parcel parcel, a aVar) {
            super(parcel);
            this.a = parcel.readFloat();
            this.f2365b = parcel.readFloat();
            ArrayList<Float> arrayList = new ArrayList<>();
            this.f2366c = arrayList;
            parcel.readList(arrayList, Float.class.getClassLoader());
            this.f2367d = parcel.readFloat();
            this.f2368e = parcel.createBooleanArray()[0];
        }
    }

    public class a implements f {
        public final /* synthetic */ AttributeSet a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f2369b;

        public a(AttributeSet attributeSet, int i2) {
            this.a = attributeSet;
            this.f2369b = i2;
        }
    }

    public class b implements ValueAnimator.AnimatorUpdateListener {
        public b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            for (TooltipDrawable tooltipDrawable : BaseSlider.this.m) {
                tooltipDrawable.Q = 1.2f;
                tooltipDrawable.O = fFloatValue;
                tooltipDrawable.P = fFloatValue;
                TimeInterpolator timeInterpolator = c.e.a.b.a.a.a;
                float fA = 1.0f;
                if (fFloatValue < 0.19f) {
                    fA = 0.0f;
                } else if (fFloatValue <= 1.0f) {
                    fA = c.e.a.b.a.a.a(0.0f, 1.0f, (fFloatValue - 0.19f) / 0.81f);
                }
                tooltipDrawable.R = fA;
                tooltipDrawable.invalidateSelf();
            }
            ViewCompat.postInvalidateOnAnimation(BaseSlider.this);
        }
    }

    public class c extends AnimatorListenerAdapter {
        public c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            Iterator<TooltipDrawable> it = BaseSlider.this.m.iterator();
            while (it.hasNext()) {
                ((h) c.b.a.m.f.e2(BaseSlider.this)).a.remove(it.next());
            }
        }
    }

    public class d implements Runnable {
        public int a = -1;

        public d(a aVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
            BaseSlider.this.f2361i.sendEventForVirtualView(this.a, 4);
        }
    }

    public static class e extends ExploreByTouchHelper {
        public final BaseSlider<?, ?, ?> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Rect f2372b;

        public e(BaseSlider<?, ?, ?> baseSlider) {
            super(baseSlider);
            this.f2372b = new Rect();
            this.a = baseSlider;
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        public int getVirtualViewAt(float f2, float f3) {
            for (int i2 = 0; i2 < this.a.getValues().size(); i2++) {
                this.a.v(i2, this.f2372b);
                if (this.f2372b.contains((int) f2, (int) f3)) {
                    return i2;
                }
            }
            return -1;
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        public void getVisibleVirtualViews(List<Integer> list) {
            for (int i2 = 0; i2 < this.a.getValues().size(); i2++) {
                list.add(Integer.valueOf(i2));
            }
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        public boolean onPerformActionForVirtualView(int i2, int i3, Bundle bundle) {
            if (!this.a.isEnabled()) {
                return false;
            }
            if (i3 != 4096 && i3 != 8192) {
                if (i3 == 16908349 && bundle != null && bundle.containsKey(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_PROGRESS_VALUE)) {
                    if (this.a.t(i2, bundle.getFloat(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_PROGRESS_VALUE))) {
                        this.a.w();
                        this.a.postInvalidate();
                        invalidateVirtualView(i2);
                        return true;
                    }
                }
                return false;
            }
            float fB = this.a.b(20);
            if (i3 == 8192) {
                fB = -fB;
            }
            if (this.a.k()) {
                fB = -fB;
            }
            if (!this.a.t(i2, MathUtils.clamp(this.a.getValues().get(i2).floatValue() + fB, this.a.getValueFrom(), this.a.getValueTo()))) {
                return false;
            }
            this.a.w();
            this.a.postInvalidate();
            invalidateVirtualView(i2);
            return true;
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        public void onPopulateNodeForVirtualView(int i2, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SET_PROGRESS);
            List<Float> values = this.a.getValues();
            float fFloatValue = values.get(i2).floatValue();
            float valueFrom = this.a.getValueFrom();
            float valueTo = this.a.getValueTo();
            if (this.a.isEnabled()) {
                if (fFloatValue > valueFrom) {
                    accessibilityNodeInfoCompat.addAction(8192);
                }
                if (fFloatValue < valueTo) {
                    accessibilityNodeInfoCompat.addAction(4096);
                }
            }
            accessibilityNodeInfoCompat.setRangeInfo(AccessibilityNodeInfoCompat.RangeInfoCompat.obtain(1, valueFrom, valueTo, fFloatValue));
            accessibilityNodeInfoCompat.setClassName(SeekBar.class.getName());
            StringBuilder sb = new StringBuilder();
            if (this.a.getContentDescription() != null) {
                sb.append(this.a.getContentDescription());
                sb.append(",");
            }
            if (values.size() > 1) {
                sb.append(i2 == this.a.getValues().size() + (-1) ? this.a.getContext().getString(R$string.material_slider_range_end) : i2 == 0 ? this.a.getContext().getString(R$string.material_slider_range_start) : "");
                sb.append(this.a.h(fFloatValue));
            }
            accessibilityNodeInfoCompat.setContentDescription(sb.toString());
            this.a.v(i2, this.f2372b);
            accessibilityNodeInfoCompat.setBoundsInParent(this.f2372b);
        }
    }

    public interface f {
    }

    public BaseSlider(@NonNull Context context) {
        this(context, null);
    }

    private float[] getActiveRange() {
        float fFloatValue = ((Float) Collections.max(getValues())).floatValue();
        float fFloatValue2 = ((Float) Collections.min(getValues())).floatValue();
        if (this.J.size() == 1) {
            fFloatValue2 = this.H;
        }
        float fO = o(fFloatValue2);
        float fO2 = o(fFloatValue);
        return k() ? new float[]{fO2, fO} : new float[]{fO, fO2};
    }

    private float getValueOfTouchPosition() {
        double dRound;
        float f2 = this.e0;
        float f3 = this.P;
        if (f3 > 0.0f) {
            int i2 = (int) ((this.I - this.H) / f3);
            dRound = ((double) Math.round(f2 * i2)) / ((double) i2);
        } else {
            dRound = f2;
        }
        if (k()) {
            dRound = 1.0d - dRound;
        }
        float f4 = this.I;
        float f5 = this.H;
        return (float) ((dRound * ((double) (f4 - f5))) + ((double) f5));
    }

    private float getValueOfTouchPositionAbsolute() {
        float f2 = this.e0;
        if (k()) {
            f2 = 1.0f - f2;
        }
        float f3 = this.I;
        float f4 = this.H;
        return c.a.a.a.a.a(f3, f4, f2, f4);
    }

    private void setValuesInternal(@NonNull ArrayList<Float> arrayList) {
        if (arrayList.isEmpty()) {
            throw new IllegalArgumentException("At least one value must be set");
        }
        Collections.sort(arrayList);
        if (this.J.size() == arrayList.size() && this.J.equals(arrayList)) {
            return;
        }
        this.J = arrayList;
        this.U = true;
        this.O = 0;
        w();
        if (this.m.size() > this.J.size()) {
            List<TooltipDrawable> listSubList = this.m.subList(this.J.size(), this.m.size());
            for (TooltipDrawable tooltipDrawable : listSubList) {
                if (ViewCompat.isAttachedToWindow(this)) {
                    e(tooltipDrawable);
                }
            }
            listSubList.clear();
        }
        while (this.m.size() < this.J.size()) {
            a aVar = (a) this.f2364l;
            TypedArray typedArrayD = g.d(BaseSlider.this.getContext(), aVar.a, R$styleable.Slider, aVar.f2369b, f2354b, new int[0]);
            Context context = BaseSlider.this.getContext();
            int resourceId = typedArrayD.getResourceId(R$styleable.Slider_labelStyle, R$style.Widget_MaterialComponents_Tooltip);
            TooltipDrawable tooltipDrawable2 = new TooltipDrawable(context, null, 0, resourceId);
            TypedArray typedArrayD2 = g.d(tooltipDrawable2.A, null, R$styleable.Tooltip, 0, resourceId, new int[0]);
            tooltipDrawable2.J = tooltipDrawable2.A.getResources().getDimensionPixelSize(R$dimen.mtrl_tooltip_arrowSize);
            l lVar = tooltipDrawable2.f2333c.a;
            Objects.requireNonNull(lVar);
            l.b bVar = new l.b(lVar);
            bVar.f1247k = tooltipDrawable2.E();
            tooltipDrawable2.f2333c.a = bVar.a();
            tooltipDrawable2.invalidateSelf();
            CharSequence text = typedArrayD2.getText(R$styleable.Tooltip_android_text);
            if (!TextUtils.equals(tooltipDrawable2.z, text)) {
                tooltipDrawable2.z = text;
                tooltipDrawable2.C.f1122d = true;
                tooltipDrawable2.invalidateSelf();
            }
            tooltipDrawable2.C.b(c.b.a.m.f.Y2(tooltipDrawable2.A, typedArrayD2, R$styleable.Tooltip_android_textAppearance), tooltipDrawable2.A);
            tooltipDrawable2.q(ColorStateList.valueOf(typedArrayD2.getColor(R$styleable.Tooltip_backgroundTint, ColorUtils.compositeColors(ColorUtils.setAlphaComponent(c.b.a.m.f.N4(tooltipDrawable2.A, R$attr.colorOnBackground, TooltipDrawable.class.getCanonicalName()), 153), ColorUtils.setAlphaComponent(c.b.a.m.f.N4(tooltipDrawable2.A, R.attr.colorBackground, TooltipDrawable.class.getCanonicalName()), 229)))));
            tooltipDrawable2.y(ColorStateList.valueOf(c.b.a.m.f.N4(tooltipDrawable2.A, R$attr.colorSurface, TooltipDrawable.class.getCanonicalName())));
            tooltipDrawable2.F = typedArrayD2.getDimensionPixelSize(R$styleable.Tooltip_android_padding, 0);
            tooltipDrawable2.G = typedArrayD2.getDimensionPixelSize(R$styleable.Tooltip_android_minWidth, 0);
            tooltipDrawable2.H = typedArrayD2.getDimensionPixelSize(R$styleable.Tooltip_android_minHeight, 0);
            tooltipDrawable2.I = typedArrayD2.getDimensionPixelSize(R$styleable.Tooltip_android_layout_margin, 0);
            typedArrayD2.recycle();
            typedArrayD.recycle();
            this.m.add(tooltipDrawable2);
            if (ViewCompat.isAttachedToWindow(this)) {
                a(tooltipDrawable2);
            }
        }
        int i2 = this.m.size() == 1 ? 0 : 1;
        Iterator<TooltipDrawable> it = this.m.iterator();
        while (it.hasNext()) {
            it.next().z(i2);
        }
        f();
        postInvalidate();
    }

    public final void a(TooltipDrawable tooltipDrawable) {
        ViewGroup viewGroupD2 = c.b.a.m.f.d2(this);
        Objects.requireNonNull(tooltipDrawable);
        if (viewGroupD2 == null) {
            return;
        }
        int[] iArr = new int[2];
        viewGroupD2.getLocationOnScreen(iArr);
        tooltipDrawable.K = iArr[0];
        viewGroupD2.getWindowVisibleDisplayFrame(tooltipDrawable.E);
        viewGroupD2.addOnLayoutChangeListener(tooltipDrawable.D);
    }

    public void addOnChangeListener(@Nullable L l2) {
        this.n.add(l2);
    }

    public void addOnSliderTouchListener(@NonNull T t) {
        this.o.add(t);
    }

    public final float b(int i2) {
        float f2 = this.P;
        if (f2 == 0.0f) {
            f2 = 1.0f;
        }
        return (this.I - this.H) / f2 <= i2 ? f2 : Math.round(r1 / r4) * f2;
    }

    public final int c() {
        return this.z + (this.w == 1 ? this.m.get(0).getIntrinsicHeight() : 0);
    }

    public final ValueAnimator d(boolean z) {
        float fFloatValue = z ? 0.0f : 1.0f;
        ValueAnimator valueAnimator = z ? this.r : this.q;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(fFloatValue, z ? 1.0f : 0.0f);
        valueAnimatorOfFloat.setDuration(z ? 83L : 117L);
        valueAnimatorOfFloat.setInterpolator(z ? c.e.a.b.a.a.f842e : c.e.a.b.a.a.f840c);
        valueAnimatorOfFloat.addUpdateListener(new b());
        return valueAnimatorOfFloat;
    }

    @Override // android.view.View
    public boolean dispatchHoverEvent(@NonNull MotionEvent motionEvent) {
        return this.f2361i.dispatchHoverEvent(motionEvent) || super.dispatchHoverEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean dispatchKeyEvent(@NonNull KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        this.f2355c.setColor(i(this.c0));
        this.f2356d.setColor(i(this.b0));
        this.f2359g.setColor(i(this.a0));
        this.f2360h.setColor(i(this.W));
        for (TooltipDrawable tooltipDrawable : this.m) {
            if (tooltipDrawable.isStateful()) {
                tooltipDrawable.setState(getDrawableState());
            }
        }
        if (this.d0.isStateful()) {
            this.d0.setState(getDrawableState());
        }
        this.f2358f.setColor(i(this.V));
        this.f2358f.setAlpha(63);
    }

    public final void e(TooltipDrawable tooltipDrawable) {
        i iVarE2 = c.b.a.m.f.e2(this);
        if (iVarE2 != null) {
            ((h) iVarE2).a.remove(tooltipDrawable);
            ViewGroup viewGroupD2 = c.b.a.m.f.d2(this);
            Objects.requireNonNull(tooltipDrawable);
            if (viewGroupD2 == null) {
                return;
            }
            viewGroupD2.removeOnLayoutChangeListener(tooltipDrawable.D);
        }
    }

    public final void f() {
        for (L l2 : this.n) {
            Iterator<Float> it = this.J.iterator();
            while (it.hasNext()) {
                l2.a(this, it.next().floatValue(), false);
            }
        }
    }

    public final void g() {
        if (this.p) {
            this.p = false;
            ValueAnimator valueAnimatorD = d(false);
            this.r = valueAnimatorD;
            this.q = null;
            valueAnimatorD.addListener(new c());
            this.r.start();
        }
    }

    @Override // android.view.View
    @NonNull
    public CharSequence getAccessibilityClassName() {
        return SeekBar.class.getName();
    }

    @VisibleForTesting
    public final int getAccessibilityFocusedVirtualViewId() {
        return this.f2361i.getAccessibilityFocusedVirtualViewId();
    }

    public int getActiveThumbIndex() {
        return this.K;
    }

    public int getFocusedThumbIndex() {
        return this.O;
    }

    @Dimension
    public int getHaloRadius() {
        return this.B;
    }

    @NonNull
    public ColorStateList getHaloTintList() {
        return this.V;
    }

    public int getLabelBehavior() {
        return this.w;
    }

    public float getMinSeparation() {
        return 0.0f;
    }

    public float getStepSize() {
        return this.P;
    }

    public float getThumbElevation() {
        return this.d0.f2333c.o;
    }

    @Dimension
    public int getThumbRadius() {
        return this.A;
    }

    public ColorStateList getThumbStrokeColor() {
        return this.d0.f2333c.f2346e;
    }

    public float getThumbStrokeWidth() {
        return this.d0.f2333c.f2353l;
    }

    @NonNull
    public ColorStateList getThumbTintList() {
        return this.d0.f2333c.f2345d;
    }

    @NonNull
    public ColorStateList getTickActiveTintList() {
        return this.W;
    }

    @NonNull
    public ColorStateList getTickInactiveTintList() {
        return this.a0;
    }

    @NonNull
    public ColorStateList getTickTintList() {
        if (this.a0.equals(this.W)) {
            return this.W;
        }
        throw new IllegalStateException("The inactive and active ticks are different colors. Use the getTickColorInactive() and getTickColorActive() methods instead.");
    }

    @NonNull
    public ColorStateList getTrackActiveTintList() {
        return this.b0;
    }

    @Dimension
    public int getTrackHeight() {
        return this.x;
    }

    @NonNull
    public ColorStateList getTrackInactiveTintList() {
        return this.c0;
    }

    @Dimension
    public int getTrackSidePadding() {
        return this.y;
    }

    @NonNull
    public ColorStateList getTrackTintList() {
        if (this.c0.equals(this.b0)) {
            return this.b0;
        }
        throw new IllegalStateException("The inactive and active parts of the track are different colors. Use the getInactiveTrackColor() and getActiveTrackColor() methods instead.");
    }

    @Dimension
    public int getTrackWidth() {
        return this.S;
    }

    public float getValueFrom() {
        return this.H;
    }

    public float getValueTo() {
        return this.I;
    }

    @NonNull
    public List<Float> getValues() {
        return new ArrayList(this.J);
    }

    public final String h(float f2) {
        c.e.a.b.x.c cVar = this.F;
        if (cVar != null) {
            return cVar.a(f2);
        }
        return String.format(((float) ((int) f2)) == f2 ? "%.0f" : "%.2f", Float.valueOf(f2));
    }

    @ColorInt
    public final int i(@NonNull ColorStateList colorStateList) {
        return colorStateList.getColorForState(getDrawableState(), colorStateList.getDefaultColor());
    }

    public final boolean j() {
        ViewParent parent = getParent();
        while (true) {
            if (!(parent instanceof ViewGroup)) {
                return false;
            }
            ViewGroup viewGroup = (ViewGroup) parent;
            if ((viewGroup.canScrollVertically(1) || viewGroup.canScrollVertically(-1)) && viewGroup.shouldDelayChildPressedState()) {
                return true;
            }
            parent = parent.getParent();
        }
    }

    public final boolean k() {
        return ViewCompat.getLayoutDirection(this) == 1;
    }

    public final void l() {
        if (this.P <= 0.0f) {
            return;
        }
        x();
        int iMin = Math.min((int) (((this.I - this.H) / this.P) + 1.0f), (this.S / (this.x * 2)) + 1);
        float[] fArr = this.Q;
        if (fArr == null || fArr.length != iMin * 2) {
            this.Q = new float[iMin * 2];
        }
        float f2 = this.S / (iMin - 1);
        for (int i2 = 0; i2 < iMin * 2; i2 += 2) {
            float[] fArr2 = this.Q;
            fArr2[i2] = ((i2 / 2) * f2) + this.y;
            fArr2[i2 + 1] = c();
        }
    }

    public final boolean m(int i2) {
        int i3 = this.O;
        int iClamp = (int) MathUtils.clamp(((long) i3) + ((long) i2), 0L, this.J.size() - 1);
        this.O = iClamp;
        if (iClamp == i3) {
            return false;
        }
        if (this.K != -1) {
            this.K = iClamp;
        }
        w();
        postInvalidate();
        return true;
    }

    public final boolean n(int i2) {
        if (k()) {
            i2 = i2 == Integer.MIN_VALUE ? Integer.MAX_VALUE : -i2;
        }
        return m(i2);
    }

    public final float o(float f2) {
        float f3 = this.H;
        float f4 = (f2 - f3) / (this.I - f3);
        return k() ? 1.0f - f4 : f4;
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Iterator<TooltipDrawable> it = this.m.iterator();
        while (it.hasNext()) {
            a(it.next());
        }
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        BaseSlider<S, L, T>.d dVar = this.f2363k;
        if (dVar != null) {
            removeCallbacks(dVar);
        }
        this.p = false;
        Iterator<TooltipDrawable> it = this.m.iterator();
        while (it.hasNext()) {
            e(it.next());
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onDraw(@NonNull Canvas canvas) {
        if (this.U) {
            x();
            l();
        }
        super.onDraw(canvas);
        int iC = c();
        int i2 = this.S;
        float[] activeRange = getActiveRange();
        int i3 = this.y;
        float f2 = i2;
        float f3 = (activeRange[1] * f2) + i3;
        float f4 = i3 + i2;
        if (f3 < f4) {
            float f5 = iC;
            canvas.drawLine(f3, f5, f4, f5, this.f2355c);
        }
        float f6 = this.y;
        float f7 = (activeRange[0] * f2) + f6;
        if (f7 > f6) {
            float f8 = iC;
            canvas.drawLine(f6, f8, f7, f8, this.f2355c);
        }
        if (((Float) Collections.max(getValues())).floatValue() > this.H) {
            int i4 = this.S;
            float[] activeRange2 = getActiveRange();
            float f9 = this.y;
            float f10 = i4;
            float f11 = iC;
            canvas.drawLine((activeRange2[0] * f10) + f9, f11, (activeRange2[1] * f10) + f9, f11, this.f2356d);
        }
        if (this.R && this.P > 0.0f) {
            float[] activeRange3 = getActiveRange();
            int iRound = Math.round(activeRange3[0] * ((this.Q.length / 2) - 1));
            int iRound2 = Math.round(activeRange3[1] * ((this.Q.length / 2) - 1));
            int i5 = iRound * 2;
            canvas.drawPoints(this.Q, 0, i5, this.f2359g);
            int i6 = iRound2 * 2;
            canvas.drawPoints(this.Q, i5, i6 - i5, this.f2360h);
            float[] fArr = this.Q;
            canvas.drawPoints(fArr, i6, fArr.length - i6, this.f2359g);
        }
        if ((this.G || isFocused()) && isEnabled()) {
            int i7 = this.S;
            if (s()) {
                int iO = (int) ((o(this.J.get(this.O).floatValue()) * i7) + this.y);
                if (Build.VERSION.SDK_INT < 28) {
                    int i8 = this.B;
                    canvas.clipRect(iO - i8, iC - i8, iO + i8, i8 + iC, Region.Op.UNION);
                }
                canvas.drawCircle(iO, iC, this.B, this.f2358f);
            }
            if (this.K != -1 && this.w != 2) {
                if (!this.p) {
                    this.p = true;
                    ValueAnimator valueAnimatorD = d(true);
                    this.q = valueAnimatorD;
                    this.r = null;
                    valueAnimatorD.start();
                }
                Iterator<TooltipDrawable> it = this.m.iterator();
                for (int i9 = 0; i9 < this.J.size() && it.hasNext(); i9++) {
                    if (i9 != this.O) {
                        r(it.next(), this.J.get(i9).floatValue());
                    }
                }
                if (!it.hasNext()) {
                    throw new IllegalStateException(String.format("Not enough labels(%d) to display all the values(%d)", Integer.valueOf(this.m.size()), Integer.valueOf(this.J.size())));
                }
                r(it.next(), this.J.get(this.O).floatValue());
            }
        }
        int i10 = this.S;
        if (!isEnabled()) {
            Iterator<Float> it2 = this.J.iterator();
            while (it2.hasNext()) {
                canvas.drawCircle((o(it2.next().floatValue()) * i10) + this.y, iC, this.A, this.f2357e);
            }
        }
        for (Float f12 : this.J) {
            canvas.save();
            int iO2 = this.y + ((int) (o(f12.floatValue()) * i10));
            int i11 = this.A;
            canvas.translate(iO2 - i11, iC - i11);
            this.d0.draw(canvas);
            canvas.restore();
        }
    }

    @Override // android.view.View
    public void onFocusChanged(boolean z, int i2, @Nullable Rect rect) {
        super.onFocusChanged(z, i2, rect);
        if (!z) {
            this.K = -1;
            g();
            this.f2361i.clearKeyboardFocusForVirtualView(this.O);
            return;
        }
        if (i2 == 1) {
            m(Integer.MAX_VALUE);
        } else if (i2 == 2) {
            m(Integer.MIN_VALUE);
        } else if (i2 == 17) {
            n(Integer.MAX_VALUE);
        } else if (i2 == 66) {
            n(Integer.MIN_VALUE);
        }
        this.f2361i.requestKeyboardFocusForVirtualView(this.O);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x004d  */
    @Override // android.view.View, android.view.KeyEvent.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onKeyDown(int r12, @androidx.annotation.NonNull android.view.KeyEvent r13) {
        /*
            Method dump skipped, instruction units count: 300
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.slider.BaseSlider.onKeyDown(int, android.view.KeyEvent):boolean");
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i2, @NonNull KeyEvent keyEvent) {
        this.T = false;
        return super.onKeyUp(i2, keyEvent);
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, View.MeasureSpec.makeMeasureSpec(this.v + (this.w == 1 ? this.m.get(0).getIntrinsicHeight() : 0), BasicMeasure.EXACTLY));
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SliderState sliderState = (SliderState) parcelable;
        super.onRestoreInstanceState(sliderState.getSuperState());
        this.H = sliderState.a;
        this.I = sliderState.f2365b;
        setValuesInternal(sliderState.f2366c);
        this.P = sliderState.f2367d;
        if (sliderState.f2368e) {
            requestFocus();
        }
        f();
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SliderState sliderState = new SliderState(super.onSaveInstanceState());
        sliderState.a = this.H;
        sliderState.f2365b = this.I;
        sliderState.f2366c = new ArrayList<>(this.J);
        sliderState.f2367d = this.P;
        sliderState.f2368e = hasFocus();
        return sliderState;
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        this.S = Math.max(i2 - (this.y * 2), 0);
        l();
        w();
    }

    @Override // android.view.View
    public boolean onTouchEvent(@NonNull MotionEvent motionEvent) {
        if (!isEnabled()) {
            return false;
        }
        float x = motionEvent.getX();
        float f2 = (x - this.y) / this.S;
        this.e0 = f2;
        float fMax = Math.max(0.0f, f2);
        this.e0 = fMax;
        this.e0 = Math.min(1.0f, fMax);
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.D = x;
            if (!j()) {
                getParent().requestDisallowInterceptTouchEvent(true);
                if (q()) {
                    requestFocus();
                    this.G = true;
                    u();
                    w();
                    invalidate();
                    p();
                }
            }
        } else if (actionMasked == 1) {
            this.G = false;
            MotionEvent motionEvent2 = this.E;
            if (motionEvent2 != null && motionEvent2.getActionMasked() == 0 && Math.abs(this.E.getX() - motionEvent.getX()) <= this.s && Math.abs(this.E.getY() - motionEvent.getY()) <= this.s && q()) {
                p();
            }
            if (this.K != -1) {
                u();
                this.K = -1;
                Iterator<T> it = this.o.iterator();
                while (it.hasNext()) {
                    it.next().b(this);
                }
            }
            g();
            invalidate();
        } else if (actionMasked == 2) {
            if (!this.G) {
                if (j() && Math.abs(x - this.D) < this.s) {
                    return false;
                }
                getParent().requestDisallowInterceptTouchEvent(true);
                p();
            }
            if (q()) {
                this.G = true;
                u();
                w();
                invalidate();
            }
        }
        setPressed(this.G);
        this.E = MotionEvent.obtain(motionEvent);
        return true;
    }

    public final void p() {
        Iterator<T> it = this.o.iterator();
        while (it.hasNext()) {
            it.next().a(this);
        }
    }

    public boolean q() {
        if (this.K != -1) {
            return true;
        }
        float valueOfTouchPositionAbsolute = getValueOfTouchPositionAbsolute();
        float fO = (o(valueOfTouchPositionAbsolute) * this.S) + this.y;
        this.K = 0;
        float fAbs = Math.abs(this.J.get(0).floatValue() - valueOfTouchPositionAbsolute);
        for (int i2 = 1; i2 < this.J.size(); i2++) {
            float fAbs2 = Math.abs(this.J.get(i2).floatValue() - valueOfTouchPositionAbsolute);
            float fO2 = (o(this.J.get(i2).floatValue()) * this.S) + this.y;
            if (Float.compare(fAbs2, fAbs) > 1) {
                break;
            }
            boolean z = !k() ? fO2 - fO >= 0.0f : fO2 - fO <= 0.0f;
            if (Float.compare(fAbs2, fAbs) < 0) {
                this.K = i2;
            } else {
                if (Float.compare(fAbs2, fAbs) != 0) {
                    continue;
                } else {
                    if (Math.abs(fO2 - fO) < this.s) {
                        this.K = -1;
                        return false;
                    }
                    if (z) {
                        this.K = i2;
                    }
                }
            }
            fAbs = fAbs2;
        }
        return this.K != -1;
    }

    public final void r(TooltipDrawable tooltipDrawable, float f2) {
        String strH = h(f2);
        if (!TextUtils.equals(tooltipDrawable.z, strH)) {
            tooltipDrawable.z = strH;
            tooltipDrawable.C.f1122d = true;
            tooltipDrawable.invalidateSelf();
        }
        int iO = (this.y + ((int) (o(f2) * this.S))) - (tooltipDrawable.getIntrinsicWidth() / 2);
        int iC = c() - (this.C + this.A);
        tooltipDrawable.setBounds(iO, iC - tooltipDrawable.getIntrinsicHeight(), tooltipDrawable.getIntrinsicWidth() + iO, iC);
        Rect rect = new Rect(tooltipDrawable.getBounds());
        c.e.a.b.q.b.c(c.b.a.m.f.d2(this), this, rect);
        tooltipDrawable.setBounds(rect);
        ((h) c.b.a.m.f.e2(this)).a.add(tooltipDrawable);
    }

    public void removeOnChangeListener(@NonNull L l2) {
        this.n.remove(l2);
    }

    public void removeOnSliderTouchListener(@NonNull T t) {
        this.o.remove(t);
    }

    public final boolean s() {
        return !(getBackground() instanceof RippleDrawable);
    }

    public void setActiveThumbIndex(int i2) {
        this.K = i2;
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        setLayerType(z ? 0 : 2, null);
    }

    public void setFocusedThumbIndex(int i2) {
        if (i2 < 0 || i2 >= this.J.size()) {
            throw new IllegalArgumentException("index out of range");
        }
        this.O = i2;
        this.f2361i.requestKeyboardFocusForVirtualView(i2);
        postInvalidate();
    }

    public void setHaloRadius(@IntRange(from = 0) @Dimension int i2) {
        if (i2 == this.B) {
            return;
        }
        this.B = i2;
        Drawable background = getBackground();
        if (s() || !(background instanceof RippleDrawable)) {
            postInvalidate();
            return;
        }
        RippleDrawable rippleDrawable = (RippleDrawable) background;
        int i3 = this.B;
        if (Build.VERSION.SDK_INT >= 23) {
            rippleDrawable.setRadius(i3);
            return;
        }
        try {
            RippleDrawable.class.getDeclaredMethod("setMaxRadius", Integer.TYPE).invoke(rippleDrawable, Integer.valueOf(i3));
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e2) {
            throw new IllegalStateException("Couldn't set RippleDrawable radius", e2);
        }
    }

    public void setHaloRadiusResource(@DimenRes int i2) {
        setHaloRadius(getResources().getDimensionPixelSize(i2));
    }

    public void setHaloTintList(@NonNull ColorStateList colorStateList) {
        if (colorStateList.equals(this.V)) {
            return;
        }
        this.V = colorStateList;
        Drawable background = getBackground();
        if (!s() && (background instanceof RippleDrawable)) {
            ((RippleDrawable) background).setColor(colorStateList);
            return;
        }
        this.f2358f.setColor(colorStateList.getColorForState(getDrawableState(), colorStateList.getDefaultColor()));
        this.f2358f.setAlpha(63);
        invalidate();
    }

    public void setLabelBehavior(int i2) {
        if (this.w != i2) {
            this.w = i2;
            requestLayout();
        }
    }

    public void setLabelFormatter(@Nullable c.e.a.b.x.c cVar) {
        this.F = cVar;
    }

    public void setSeparationUnit(int i2) {
        this.f0 = i2;
    }

    public void setStepSize(float f2) {
        if (f2 < 0.0f) {
            throw new IllegalArgumentException(String.format("The stepSize(%s) must be 0, or a factor of the valueFrom(%s)-valueTo(%s) range", Float.toString(f2), Float.toString(this.H), Float.toString(this.I)));
        }
        if (this.P != f2) {
            this.P = f2;
            this.U = true;
            postInvalidate();
        }
    }

    public void setThumbElevation(float f2) {
        MaterialShapeDrawable materialShapeDrawable = this.d0;
        MaterialShapeDrawable.b bVar = materialShapeDrawable.f2333c;
        if (bVar.o != f2) {
            bVar.o = f2;
            materialShapeDrawable.C();
        }
    }

    public void setThumbElevationResource(@DimenRes int i2) {
        setThumbElevation(getResources().getDimension(i2));
    }

    public void setThumbRadius(@IntRange(from = 0) @Dimension int i2) {
        if (i2 == this.A) {
            return;
        }
        this.A = i2;
        this.y = this.t + Math.max(i2 - this.u, 0);
        if (ViewCompat.isLaidOut(this)) {
            this.S = Math.max(getWidth() - (this.y * 2), 0);
            l();
        }
        MaterialShapeDrawable materialShapeDrawable = this.d0;
        l.b bVar = new l.b();
        float f2 = this.A;
        c.e.a.b.w.d dVarJ1 = c.b.a.m.f.j1(0);
        bVar.a = dVarJ1;
        l.b.b(dVarJ1);
        bVar.f1238b = dVarJ1;
        l.b.b(dVarJ1);
        bVar.f1239c = dVarJ1;
        l.b.b(dVarJ1);
        bVar.f1240d = dVarJ1;
        l.b.b(dVarJ1);
        bVar.c(f2);
        materialShapeDrawable.f2333c.a = bVar.a();
        materialShapeDrawable.invalidateSelf();
        MaterialShapeDrawable materialShapeDrawable2 = this.d0;
        int i3 = this.A;
        materialShapeDrawable2.setBounds(0, 0, i3 * 2, i3 * 2);
        postInvalidate();
    }

    public void setThumbRadiusResource(@DimenRes int i2) {
        setThumbRadius(getResources().getDimensionPixelSize(i2));
    }

    public void setThumbStrokeColor(@Nullable ColorStateList colorStateList) {
        this.d0.y(colorStateList);
        postInvalidate();
    }

    public void setThumbStrokeColorResource(@ColorRes int i2) {
        if (i2 != 0) {
            setThumbStrokeColor(AppCompatResources.getColorStateList(getContext(), i2));
        }
    }

    public void setThumbStrokeWidth(float f2) {
        MaterialShapeDrawable materialShapeDrawable = this.d0;
        materialShapeDrawable.f2333c.f2353l = f2;
        materialShapeDrawable.invalidateSelf();
        postInvalidate();
    }

    public void setThumbStrokeWidthResource(@DimenRes int i2) {
        if (i2 != 0) {
            setThumbStrokeWidth(getResources().getDimension(i2));
        }
    }

    public void setThumbTintList(@NonNull ColorStateList colorStateList) {
        if (colorStateList.equals(this.d0.f2333c.f2345d)) {
            return;
        }
        this.d0.q(colorStateList);
        invalidate();
    }

    public void setTickActiveTintList(@NonNull ColorStateList colorStateList) {
        if (colorStateList.equals(this.W)) {
            return;
        }
        this.W = colorStateList;
        this.f2360h.setColor(i(colorStateList));
        invalidate();
    }

    public void setTickInactiveTintList(@NonNull ColorStateList colorStateList) {
        if (colorStateList.equals(this.a0)) {
            return;
        }
        this.a0 = colorStateList;
        this.f2359g.setColor(i(colorStateList));
        invalidate();
    }

    public void setTickTintList(@NonNull ColorStateList colorStateList) {
        setTickInactiveTintList(colorStateList);
        setTickActiveTintList(colorStateList);
    }

    public void setTickVisible(boolean z) {
        if (this.R != z) {
            this.R = z;
            postInvalidate();
        }
    }

    public void setTrackActiveTintList(@NonNull ColorStateList colorStateList) {
        if (colorStateList.equals(this.b0)) {
            return;
        }
        this.b0 = colorStateList;
        this.f2356d.setColor(i(colorStateList));
        invalidate();
    }

    public void setTrackHeight(@IntRange(from = 0) @Dimension int i2) {
        if (this.x != i2) {
            this.x = i2;
            this.f2355c.setStrokeWidth(i2);
            this.f2356d.setStrokeWidth(this.x);
            this.f2359g.setStrokeWidth(this.x / 2.0f);
            this.f2360h.setStrokeWidth(this.x / 2.0f);
            postInvalidate();
        }
    }

    public void setTrackInactiveTintList(@NonNull ColorStateList colorStateList) {
        if (colorStateList.equals(this.c0)) {
            return;
        }
        this.c0 = colorStateList;
        this.f2355c.setColor(i(colorStateList));
        invalidate();
    }

    public void setTrackTintList(@NonNull ColorStateList colorStateList) {
        setTrackInactiveTintList(colorStateList);
        setTrackActiveTintList(colorStateList);
    }

    public void setValueFrom(float f2) {
        this.H = f2;
        this.U = true;
        postInvalidate();
    }

    public void setValueTo(float f2) {
        this.I = f2;
        this.U = true;
        postInvalidate();
    }

    public void setValues(@NonNull Float... fArr) {
        ArrayList<Float> arrayList = new ArrayList<>();
        Collections.addAll(arrayList, fArr);
        setValuesInternal(arrayList);
    }

    public final boolean t(int i2, float f2) {
        if (Math.abs(f2 - this.J.get(i2).floatValue()) < 1.0E-4d) {
            return false;
        }
        float fA = 0.0f;
        float minSeparation = this.P == 0.0f ? getMinSeparation() : 0.0f;
        if (this.f0 == 0) {
            if (minSeparation != 0.0f) {
                float f3 = this.H;
                fA = c.a.a.a.a.a(f3, this.I, (minSeparation - this.y) / this.S, f3);
            }
            minSeparation = fA;
        }
        if (k()) {
            minSeparation = -minSeparation;
        }
        int i3 = i2 + 1;
        int i4 = i2 - 1;
        this.J.set(i2, Float.valueOf(MathUtils.clamp(f2, i4 < 0 ? this.H : minSeparation + this.J.get(i4).floatValue(), i3 >= this.J.size() ? this.I : this.J.get(i3).floatValue() - minSeparation)));
        this.O = i2;
        Iterator<L> it = this.n.iterator();
        while (it.hasNext()) {
            it.next().a(this, this.J.get(i2).floatValue(), true);
        }
        AccessibilityManager accessibilityManager = this.f2362j;
        if (accessibilityManager != null && accessibilityManager.isEnabled()) {
            BaseSlider<S, L, T>.d dVar = this.f2363k;
            if (dVar == null) {
                this.f2363k = new d(null);
            } else {
                removeCallbacks(dVar);
            }
            BaseSlider<S, L, T>.d dVar2 = this.f2363k;
            dVar2.a = i2;
            postDelayed(dVar2, 200L);
        }
        return true;
    }

    public final boolean u() {
        return t(this.K, getValueOfTouchPosition());
    }

    public void v(int i2, Rect rect) {
        int iO = this.y + ((int) (o(getValues().get(i2).floatValue()) * this.S));
        int iC = c();
        int i3 = this.A;
        rect.set(iO - i3, iC - i3, iO + i3, iC + i3);
    }

    public final void w() {
        if (s() || getMeasuredWidth() <= 0) {
            return;
        }
        Drawable background = getBackground();
        if (background instanceof RippleDrawable) {
            int iO = (int) ((o(this.J.get(this.O).floatValue()) * this.S) + this.y);
            int iC = c();
            int i2 = this.B;
            DrawableCompat.setHotspotBounds(background, iO - i2, iC - i2, iO + i2, iC + i2);
        }
    }

    public final void x() {
        if (this.U) {
            float f2 = this.H;
            float f3 = this.I;
            if (f2 >= f3) {
                throw new IllegalStateException(String.format("valueFrom(%s) must be smaller than valueTo(%s)", Float.toString(this.H), Float.toString(this.I)));
            }
            if (f3 <= f2) {
                throw new IllegalStateException(String.format("valueTo(%s) must be greater than valueFrom(%s)", Float.toString(this.I), Float.toString(this.H)));
            }
            if (this.P > 0.0f && !y(f3)) {
                throw new IllegalStateException(String.format("The stepSize(%s) must be 0, or a factor of the valueFrom(%s)-valueTo(%s) range", Float.toString(this.P), Float.toString(this.H), Float.toString(this.I)));
            }
            for (Float f4 : this.J) {
                if (f4.floatValue() < this.H || f4.floatValue() > this.I) {
                    throw new IllegalStateException(String.format("Slider value(%s) must be greater or equal to valueFrom(%s), and lower or equal to valueTo(%s)", Float.toString(f4.floatValue()), Float.toString(this.H), Float.toString(this.I)));
                }
                if (this.P > 0.0f && !y(f4.floatValue())) {
                    throw new IllegalStateException(String.format("Value(%s) must be equal to valueFrom(%s) plus a multiple of stepSize(%s) when using stepSize(%s)", Float.toString(f4.floatValue()), Float.toString(this.H), Float.toString(this.P), Float.toString(this.P)));
                }
            }
            float f5 = this.P;
            if (f5 != 0.0f) {
                if (((int) f5) != f5) {
                    String.format("Floating point value used for %s(%s). Using floats can have rounding errors which may result in incorrect values. Instead, consider using integers with a custom LabelFormatter to display the  value correctly.", "stepSize", Float.valueOf(f5));
                }
                float f6 = this.H;
                if (((int) f6) != f6) {
                    String.format("Floating point value used for %s(%s). Using floats can have rounding errors which may result in incorrect values. Instead, consider using integers with a custom LabelFormatter to display the  value correctly.", "valueFrom", Float.valueOf(f6));
                }
                float f7 = this.I;
                if (((int) f7) != f7) {
                    String.format("Floating point value used for %s(%s). Using floats can have rounding errors which may result in incorrect values. Instead, consider using integers with a custom LabelFormatter to display the  value correctly.", "valueTo", Float.valueOf(f7));
                }
            }
            this.U = false;
        }
    }

    public final boolean y(float f2) {
        double dDoubleValue = new BigDecimal(Float.toString(f2)).subtract(new BigDecimal(Float.toString(this.H))).divide(new BigDecimal(Float.toString(this.P)), MathContext.DECIMAL64).doubleValue();
        return Math.abs(((double) Math.round(dDoubleValue)) - dDoubleValue) < 1.0E-4d;
    }

    public BaseSlider(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.sliderStyle);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public BaseSlider(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        int i3 = f2354b;
        super(c.e.a.b.b0.a.a.a(context, attributeSet, i2, i3), attributeSet, i2);
        this.m = new ArrayList();
        this.n = new ArrayList();
        this.o = new ArrayList();
        this.p = false;
        this.G = false;
        this.J = new ArrayList<>();
        this.K = -1;
        this.O = -1;
        this.P = 0.0f;
        this.R = true;
        this.T = false;
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable();
        this.d0 = materialShapeDrawable;
        this.f0 = 0;
        Context context2 = getContext();
        Paint paint = new Paint();
        this.f2355c = paint;
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(Paint.Cap.ROUND);
        Paint paint2 = new Paint();
        this.f2356d = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setStrokeCap(Paint.Cap.ROUND);
        Paint paint3 = new Paint(1);
        this.f2357e = paint3;
        paint3.setStyle(Paint.Style.FILL);
        paint3.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        Paint paint4 = new Paint(1);
        this.f2358f = paint4;
        paint4.setStyle(Paint.Style.FILL);
        Paint paint5 = new Paint();
        this.f2359g = paint5;
        paint5.setStyle(Paint.Style.STROKE);
        paint5.setStrokeCap(Paint.Cap.ROUND);
        Paint paint6 = new Paint();
        this.f2360h = paint6;
        paint6.setStyle(Paint.Style.STROKE);
        paint6.setStrokeCap(Paint.Cap.ROUND);
        Resources resources = context2.getResources();
        this.v = resources.getDimensionPixelSize(R$dimen.mtrl_slider_widget_height);
        int dimensionPixelOffset = resources.getDimensionPixelOffset(R$dimen.mtrl_slider_track_side_padding);
        this.t = dimensionPixelOffset;
        this.y = dimensionPixelOffset;
        this.u = resources.getDimensionPixelSize(R$dimen.mtrl_slider_thumb_radius);
        this.z = resources.getDimensionPixelOffset(R$dimen.mtrl_slider_track_top);
        this.C = resources.getDimensionPixelSize(R$dimen.mtrl_slider_label_padding);
        this.f2364l = new a(attributeSet, i2);
        int[] iArr = R$styleable.Slider;
        g.a(context2, attributeSet, i2, i3);
        g.b(context2, attributeSet, iArr, i2, i3, new int[0]);
        TypedArray typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, iArr, i2, i3);
        this.H = typedArrayObtainStyledAttributes.getFloat(R$styleable.Slider_android_valueFrom, 0.0f);
        this.I = typedArrayObtainStyledAttributes.getFloat(R$styleable.Slider_android_valueTo, 1.0f);
        setValues(Float.valueOf(this.H));
        this.P = typedArrayObtainStyledAttributes.getFloat(R$styleable.Slider_android_stepSize, 0.0f);
        int i4 = R$styleable.Slider_trackColor;
        boolean zHasValue = typedArrayObtainStyledAttributes.hasValue(i4);
        int i5 = zHasValue ? i4 : R$styleable.Slider_trackColorInactive;
        i4 = zHasValue ? i4 : R$styleable.Slider_trackColorActive;
        ColorStateList colorStateListA2 = c.b.a.m.f.a2(context2, typedArrayObtainStyledAttributes, i5);
        setTrackInactiveTintList(colorStateListA2 == null ? AppCompatResources.getColorStateList(context2, R$color.material_slider_inactive_track_color) : colorStateListA2);
        ColorStateList colorStateListA22 = c.b.a.m.f.a2(context2, typedArrayObtainStyledAttributes, i4);
        setTrackActiveTintList(colorStateListA22 == null ? AppCompatResources.getColorStateList(context2, R$color.material_slider_active_track_color) : colorStateListA22);
        materialShapeDrawable.q(c.b.a.m.f.a2(context2, typedArrayObtainStyledAttributes, R$styleable.Slider_thumbColor));
        int i6 = R$styleable.Slider_thumbStrokeColor;
        if (typedArrayObtainStyledAttributes.hasValue(i6)) {
            setThumbStrokeColor(c.b.a.m.f.a2(context2, typedArrayObtainStyledAttributes, i6));
        }
        setThumbStrokeWidth(typedArrayObtainStyledAttributes.getDimension(R$styleable.Slider_thumbStrokeWidth, 0.0f));
        ColorStateList colorStateListA23 = c.b.a.m.f.a2(context2, typedArrayObtainStyledAttributes, R$styleable.Slider_haloColor);
        setHaloTintList(colorStateListA23 == null ? AppCompatResources.getColorStateList(context2, R$color.material_slider_halo_color) : colorStateListA23);
        this.R = typedArrayObtainStyledAttributes.getBoolean(R$styleable.Slider_tickVisible, true);
        int i7 = R$styleable.Slider_tickColor;
        boolean zHasValue2 = typedArrayObtainStyledAttributes.hasValue(i7);
        int i8 = zHasValue2 ? i7 : R$styleable.Slider_tickColorInactive;
        i7 = zHasValue2 ? i7 : R$styleable.Slider_tickColorActive;
        ColorStateList colorStateListA24 = c.b.a.m.f.a2(context2, typedArrayObtainStyledAttributes, i8);
        setTickInactiveTintList(colorStateListA24 == null ? AppCompatResources.getColorStateList(context2, R$color.material_slider_inactive_tick_marks_color) : colorStateListA24);
        ColorStateList colorStateListA25 = c.b.a.m.f.a2(context2, typedArrayObtainStyledAttributes, i7);
        setTickActiveTintList(colorStateListA25 == null ? AppCompatResources.getColorStateList(context2, R$color.material_slider_active_tick_marks_color) : colorStateListA25);
        setThumbRadius(typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.Slider_thumbRadius, 0));
        setHaloRadius(typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.Slider_haloRadius, 0));
        setThumbElevation(typedArrayObtainStyledAttributes.getDimension(R$styleable.Slider_thumbElevation, 0.0f));
        setTrackHeight(typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.Slider_trackHeight, 0));
        this.w = typedArrayObtainStyledAttributes.getInt(R$styleable.Slider_labelBehavior, 0);
        if (!typedArrayObtainStyledAttributes.getBoolean(R$styleable.Slider_android_enabled, true)) {
            setEnabled(false);
        }
        typedArrayObtainStyledAttributes.recycle();
        setFocusable(true);
        setClickable(true);
        materialShapeDrawable.u(2);
        this.s = ViewConfiguration.get(context2).getScaledTouchSlop();
        e eVar = new e(this);
        this.f2361i = eVar;
        ViewCompat.setAccessibilityDelegate(this, eVar);
        this.f2362j = (AccessibilityManager) getContext().getSystemService("accessibility");
    }

    public void setValues(@NonNull List<Float> list) {
        setValuesInternal(new ArrayList<>(list));
    }
}

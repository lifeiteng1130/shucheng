package com.google.android.material.bottomsheet;

import android.R;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.math.MathUtils;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.view.AbsSavedState;
import androidx.customview.widget.ViewDragHelper;
import c.b.a.m.f;
import c.e.a.b.w.l;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$string;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.shape.MaterialShapeDrawable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class BottomSheetBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {
    public static final int a = R$style.Widget_Design_BottomSheet_Modal;

    @Nullable
    public ViewDragHelper A;
    public boolean B;
    public int C;
    public boolean D;
    public int E;
    public int F;
    public int G;

    @Nullable
    public WeakReference<V> H;

    @Nullable
    public WeakReference<View> I;

    @NonNull
    public final ArrayList<c> J;

    @Nullable
    public VelocityTracker K;
    public int L;
    public int M;
    public boolean N;

    @Nullable
    public Map<View, Integer> O;
    public int P;
    public final ViewDragHelper.Callback Q;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f2081b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f2082c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f2083d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f2084e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f2085f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f2086g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f2087h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f2088i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public MaterialShapeDrawable f2089j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f2090k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f2091l;
    public l m;
    public boolean n;
    public BottomSheetBehavior<V>.d o;

    @Nullable
    public ValueAnimator p;
    public int q;
    public int r;
    public int s;
    public float t;
    public int u;
    public float v;
    public boolean w;
    public boolean x;
    public boolean y;
    public int z;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface SaveFlags {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface State {
    }

    public class a implements Runnable {
        public final /* synthetic */ View a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f2096b;

        public a(View view, int i2) {
            this.a = view;
            this.f2096b = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            BottomSheetBehavior.this.l(this.a, this.f2096b);
        }
    }

    public class b extends ViewDragHelper.Callback {
        public b() {
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int clampViewPositionHorizontal(@NonNull View view, int i2, int i3) {
            return view.getLeft();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int clampViewPositionVertical(@NonNull View view, int i2, int i3) {
            int iF = BottomSheetBehavior.this.f();
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            return MathUtils.clamp(i2, iF, bottomSheetBehavior.w ? bottomSheetBehavior.G : bottomSheetBehavior.u);
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int getViewVerticalDragRange(@NonNull View view) {
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            return bottomSheetBehavior.w ? bottomSheetBehavior.G : bottomSheetBehavior.u;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewDragStateChanged(int i2) {
            if (i2 == 1) {
                BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
                if (bottomSheetBehavior.y) {
                    bottomSheetBehavior.k(1);
                }
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewPositionChanged(@NonNull View view, int i2, int i3, int i4, int i5) {
            BottomSheetBehavior.this.d(i3);
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewReleased(@NonNull View view, float f2, float f3) {
            int i2;
            int i3 = 4;
            if (f3 < 0.0f) {
                BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
                if (bottomSheetBehavior.f2082c) {
                    i2 = bottomSheetBehavior.r;
                } else {
                    int top = view.getTop();
                    BottomSheetBehavior bottomSheetBehavior2 = BottomSheetBehavior.this;
                    int i4 = bottomSheetBehavior2.s;
                    if (top > i4) {
                        i2 = i4;
                        i3 = 6;
                    } else {
                        i2 = bottomSheetBehavior2.q;
                    }
                }
                i3 = 3;
            } else {
                BottomSheetBehavior bottomSheetBehavior3 = BottomSheetBehavior.this;
                if (bottomSheetBehavior3.w && bottomSheetBehavior3.n(view, f3)) {
                    if (Math.abs(f2) >= Math.abs(f3) || f3 <= 500.0f) {
                        int top2 = view.getTop();
                        BottomSheetBehavior bottomSheetBehavior4 = BottomSheetBehavior.this;
                        if (!(top2 > (bottomSheetBehavior4.f() + bottomSheetBehavior4.G) / 2)) {
                            BottomSheetBehavior bottomSheetBehavior5 = BottomSheetBehavior.this;
                            if (bottomSheetBehavior5.f2082c) {
                                i2 = bottomSheetBehavior5.r;
                            } else if (Math.abs(view.getTop() - BottomSheetBehavior.this.q) < Math.abs(view.getTop() - BottomSheetBehavior.this.s)) {
                                i2 = BottomSheetBehavior.this.q;
                            } else {
                                i2 = BottomSheetBehavior.this.s;
                                i3 = 6;
                            }
                            i3 = 3;
                        }
                    }
                    i2 = BottomSheetBehavior.this.G;
                    i3 = 5;
                } else if (f3 == 0.0f || Math.abs(f2) > Math.abs(f3)) {
                    int top3 = view.getTop();
                    BottomSheetBehavior bottomSheetBehavior6 = BottomSheetBehavior.this;
                    if (!bottomSheetBehavior6.f2082c) {
                        int i5 = bottomSheetBehavior6.s;
                        if (top3 < i5) {
                            if (top3 < Math.abs(top3 - bottomSheetBehavior6.u)) {
                                i2 = BottomSheetBehavior.this.q;
                                i3 = 3;
                            } else {
                                i2 = BottomSheetBehavior.this.s;
                            }
                        } else if (Math.abs(top3 - i5) < Math.abs(top3 - BottomSheetBehavior.this.u)) {
                            i2 = BottomSheetBehavior.this.s;
                        } else {
                            i2 = BottomSheetBehavior.this.u;
                        }
                        i3 = 6;
                    } else if (Math.abs(top3 - bottomSheetBehavior6.r) < Math.abs(top3 - BottomSheetBehavior.this.u)) {
                        i2 = BottomSheetBehavior.this.r;
                        i3 = 3;
                    } else {
                        i2 = BottomSheetBehavior.this.u;
                    }
                } else {
                    BottomSheetBehavior bottomSheetBehavior7 = BottomSheetBehavior.this;
                    if (bottomSheetBehavior7.f2082c) {
                        i2 = bottomSheetBehavior7.u;
                    } else {
                        int top4 = view.getTop();
                        if (Math.abs(top4 - BottomSheetBehavior.this.s) < Math.abs(top4 - BottomSheetBehavior.this.u)) {
                            i2 = BottomSheetBehavior.this.s;
                            i3 = 6;
                        } else {
                            i2 = BottomSheetBehavior.this.u;
                        }
                    }
                }
            }
            BottomSheetBehavior.this.o(view, i3, i2, true);
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public boolean tryCaptureView(@NonNull View view, int i2) {
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            int i3 = bottomSheetBehavior.z;
            if (i3 == 1 || bottomSheetBehavior.N) {
                return false;
            }
            if (i3 == 3 && bottomSheetBehavior.L == i2) {
                WeakReference<View> weakReference = bottomSheetBehavior.I;
                View view2 = weakReference != null ? weakReference.get() : null;
                if (view2 != null && view2.canScrollVertically(-1)) {
                    return false;
                }
            }
            WeakReference<V> weakReference2 = BottomSheetBehavior.this.H;
            return weakReference2 != null && weakReference2.get() == view;
        }
    }

    public static abstract class c {
        public abstract void a(@NonNull View view, float f2);

        public abstract void b(@NonNull View view, int i2);
    }

    public class d implements Runnable {
        public final View a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f2098b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f2099c;

        public d(View view, int i2) {
            this.a = view;
            this.f2099c = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewDragHelper viewDragHelper = BottomSheetBehavior.this.A;
            if (viewDragHelper == null || !viewDragHelper.continueSettling(true)) {
                BottomSheetBehavior.this.k(this.f2099c);
            } else {
                ViewCompat.postOnAnimation(this.a, this);
            }
            this.f2098b = false;
        }
    }

    public BottomSheetBehavior() {
        this.f2081b = 0;
        this.f2082c = true;
        this.o = null;
        this.t = 0.5f;
        this.v = -1.0f;
        this.y = true;
        this.z = 4;
        this.J = new ArrayList<>();
        this.P = -1;
        this.Q = new b();
    }

    public final void a() {
        int iB = b();
        if (this.f2082c) {
            this.u = Math.max(this.G - iB, this.r);
        } else {
            this.u = this.G - iB;
        }
    }

    public final int b() {
        int i2;
        return this.f2085f ? Math.min(Math.max(this.f2086g, this.G - ((this.F * 9) / 16)), this.E) : (this.f2091l || (i2 = this.f2090k) <= 0) ? this.f2084e : Math.max(this.f2084e, i2 + this.f2087h);
    }

    public final void c(@NonNull Context context, AttributeSet attributeSet, boolean z, @Nullable ColorStateList colorStateList) {
        if (this.f2088i) {
            this.m = l.c(context, attributeSet, R$attr.bottomSheetStyle, a, new c.e.a.b.w.a(0)).a();
            MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(this.m);
            this.f2089j = materialShapeDrawable;
            materialShapeDrawable.f2333c.f2343b = new c.e.a.b.n.a(context);
            materialShapeDrawable.C();
            if (z && colorStateList != null) {
                this.f2089j.q(colorStateList);
                return;
            }
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(R.attr.colorBackground, typedValue, true);
            this.f2089j.setTint(typedValue.data);
        }
    }

    public void d(int i2) {
        float f2;
        float f3;
        V v = this.H.get();
        if (v == null || this.J.isEmpty()) {
            return;
        }
        int i3 = this.u;
        if (i2 > i3 || i3 == f()) {
            int i4 = this.u;
            f2 = i4 - i2;
            f3 = this.G - i4;
        } else {
            int i5 = this.u;
            f2 = i5 - i2;
            f3 = i5 - f();
        }
        float f4 = f2 / f3;
        for (int i6 = 0; i6 < this.J.size(); i6++) {
            this.J.get(i6).a(v, f4);
        }
    }

    @Nullable
    @VisibleForTesting
    public View e(View view) {
        if (ViewCompat.isNestedScrollingEnabled(view)) {
            return view;
        }
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View viewE = e(viewGroup.getChildAt(i2));
            if (viewE != null) {
                return viewE;
            }
        }
        return null;
    }

    public int f() {
        return this.f2082c ? this.r : this.q;
    }

    public final void g(V v, AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat, int i2) {
        ViewCompat.replaceAccessibilityAction(v, accessibilityActionCompat, null, new c.e.a.b.g.c(this, i2));
    }

    public void h(boolean z) {
        if (this.w != z) {
            this.w = z;
            if (!z && this.z == 5) {
                j(4);
            }
            p();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void i(int r4) {
        /*
            r3 = this;
            r0 = 1
            r1 = -1
            r2 = 0
            if (r4 != r1) goto Lc
            boolean r4 = r3.f2085f
            if (r4 != 0) goto L15
            r3.f2085f = r0
            goto L1f
        Lc:
            boolean r1 = r3.f2085f
            if (r1 != 0) goto L17
            int r1 = r3.f2084e
            if (r1 == r4) goto L15
            goto L17
        L15:
            r0 = 0
            goto L1f
        L17:
            r3.f2085f = r2
            int r4 = java.lang.Math.max(r2, r4)
            r3.f2084e = r4
        L1f:
            if (r0 == 0) goto L24
            r3.s(r2)
        L24:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.i(int):void");
    }

    public void j(int i2) {
        if (i2 == this.z) {
            return;
        }
        if (this.H != null) {
            m(i2);
            return;
        }
        if (i2 == 4 || i2 == 3 || i2 == 6 || (this.w && i2 == 5)) {
            this.z = i2;
        }
    }

    public void k(int i2) {
        V v;
        if (this.z == i2) {
            return;
        }
        this.z = i2;
        WeakReference<V> weakReference = this.H;
        if (weakReference == null || (v = weakReference.get()) == null) {
            return;
        }
        if (i2 == 3) {
            r(true);
        } else if (i2 == 6 || i2 == 5 || i2 == 4) {
            r(false);
        }
        q(i2);
        for (int i3 = 0; i3 < this.J.size(); i3++) {
            this.J.get(i3).b(v, i2);
        }
        p();
    }

    public void l(@NonNull View view, int i2) {
        int iF;
        int i3;
        if (i2 == 4) {
            iF = this.u;
        } else if (i2 == 6) {
            iF = this.s;
            if (this.f2082c && iF <= (i3 = this.r)) {
                i2 = 3;
                iF = i3;
            }
        } else if (i2 == 3) {
            iF = f();
        } else {
            if (!this.w || i2 != 5) {
                throw new IllegalArgumentException(c.a.a.a.a.G("Illegal state argument: ", i2));
            }
            iF = this.G;
        }
        o(view, i2, iF, false);
    }

    public final void m(int i2) {
        V v = this.H.get();
        if (v == null) {
            return;
        }
        ViewParent parent = v.getParent();
        if (parent != null && parent.isLayoutRequested() && ViewCompat.isAttachedToWindow(v)) {
            v.post(new a(v, i2));
        } else {
            l(v, i2);
        }
    }

    public boolean n(@NonNull View view, float f2) {
        if (this.x) {
            return true;
        }
        if (view.getTop() < this.u) {
            return false;
        }
        return Math.abs(((f2 * 0.1f) + ((float) view.getTop())) - ((float) this.u)) / ((float) b()) > 0.5f;
    }

    public void o(View view, int i2, int i3, boolean z) {
        ViewDragHelper viewDragHelper = this.A;
        if (!(viewDragHelper != null && (!z ? !viewDragHelper.smoothSlideViewTo(view, view.getLeft(), i3) : !viewDragHelper.settleCapturedViewAt(view.getLeft(), i3)))) {
            k(i2);
            return;
        }
        k(2);
        q(i2);
        if (this.o == null) {
            this.o = new d(view, i2);
        }
        BottomSheetBehavior<V>.d dVar = this.o;
        if (dVar.f2098b) {
            dVar.f2099c = i2;
            return;
        }
        dVar.f2099c = i2;
        ViewCompat.postOnAnimation(view, dVar);
        this.o.f2098b = true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onAttachedToLayoutParams(@NonNull CoordinatorLayout.LayoutParams layoutParams) {
        super.onAttachedToLayoutParams(layoutParams);
        this.H = null;
        this.A = null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onDetachedFromLayoutParams() {
        super.onDetachedFromLayoutParams();
        this.H = null;
        this.A = null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onInterceptTouchEvent(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull MotionEvent motionEvent) {
        ViewDragHelper viewDragHelper;
        if (!v.isShown() || !this.y) {
            this.B = true;
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.L = -1;
            VelocityTracker velocityTracker = this.K;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.K = null;
            }
        }
        if (this.K == null) {
            this.K = VelocityTracker.obtain();
        }
        this.K.addMovement(motionEvent);
        if (actionMasked == 0) {
            int x = (int) motionEvent.getX();
            this.M = (int) motionEvent.getY();
            if (this.z != 2) {
                WeakReference<View> weakReference = this.I;
                View view = weakReference != null ? weakReference.get() : null;
                if (view != null && coordinatorLayout.isPointInChildBounds(view, x, this.M)) {
                    this.L = motionEvent.getPointerId(motionEvent.getActionIndex());
                    this.N = true;
                }
            }
            this.B = this.L == -1 && !coordinatorLayout.isPointInChildBounds(v, x, this.M);
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.N = false;
            this.L = -1;
            if (this.B) {
                this.B = false;
                return false;
            }
        }
        if (!this.B && (viewDragHelper = this.A) != null && viewDragHelper.shouldInterceptTouchEvent(motionEvent)) {
            return true;
        }
        WeakReference<View> weakReference2 = this.I;
        View view2 = weakReference2 != null ? weakReference2.get() : null;
        return (actionMasked != 2 || view2 == null || this.B || this.z == 1 || coordinatorLayout.isPointInChildBounds(view2, (int) motionEvent.getX(), (int) motionEvent.getY()) || this.A == null || Math.abs(((float) this.M) - motionEvent.getY()) <= ((float) this.A.getTouchSlop())) ? false : true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, int i2) {
        MaterialShapeDrawable materialShapeDrawable;
        if (ViewCompat.getFitsSystemWindows(coordinatorLayout) && !ViewCompat.getFitsSystemWindows(v)) {
            v.setFitsSystemWindows(true);
        }
        if (this.H == null) {
            this.f2086g = coordinatorLayout.getResources().getDimensionPixelSize(R$dimen.design_bottom_sheet_peek_height_min);
            if (Build.VERSION.SDK_INT >= 29 && !this.f2091l && !this.f2085f) {
                f.u1(v, new c.e.a.b.g.b(this));
            }
            this.H = new WeakReference<>(v);
            if (this.f2088i && (materialShapeDrawable = this.f2089j) != null) {
                ViewCompat.setBackground(v, materialShapeDrawable);
            }
            MaterialShapeDrawable materialShapeDrawable2 = this.f2089j;
            if (materialShapeDrawable2 != null) {
                float elevation = this.v;
                if (elevation == -1.0f) {
                    elevation = ViewCompat.getElevation(v);
                }
                materialShapeDrawable2.p(elevation);
                boolean z = this.z == 3;
                this.n = z;
                this.f2089j.r(z ? 0.0f : 1.0f);
            }
            p();
            if (ViewCompat.getImportantForAccessibility(v) == 0) {
                ViewCompat.setImportantForAccessibility(v, 1);
            }
        }
        if (this.A == null) {
            this.A = ViewDragHelper.create(coordinatorLayout, this.Q);
        }
        int top = v.getTop();
        coordinatorLayout.onLayoutChild(v, i2);
        this.F = coordinatorLayout.getWidth();
        this.G = coordinatorLayout.getHeight();
        int height = v.getHeight();
        this.E = height;
        this.r = Math.max(0, this.G - height);
        this.s = (int) ((1.0f - this.t) * this.G);
        a();
        int i3 = this.z;
        if (i3 == 3) {
            ViewCompat.offsetTopAndBottom(v, f());
        } else if (i3 == 6) {
            ViewCompat.offsetTopAndBottom(v, this.s);
        } else if (this.w && i3 == 5) {
            ViewCompat.offsetTopAndBottom(v, this.G);
        } else if (i3 == 4) {
            ViewCompat.offsetTopAndBottom(v, this.u);
        } else if (i3 == 1 || i3 == 2) {
            ViewCompat.offsetTopAndBottom(v, top - v.getTop());
        }
        this.I = new WeakReference<>(e(v));
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onNestedPreFling(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull View view, float f2, float f3) {
        WeakReference<View> weakReference = this.I;
        return weakReference != null && view == weakReference.get() && (this.z != 3 || super.onNestedPreFling(coordinatorLayout, v, view, f2, f3));
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onNestedPreScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull View view, int i2, int i3, @NonNull int[] iArr, int i4) {
        if (i4 == 1) {
            return;
        }
        WeakReference<View> weakReference = this.I;
        if (view != (weakReference != null ? weakReference.get() : null)) {
            return;
        }
        int top = v.getTop();
        int i5 = top - i3;
        if (i3 > 0) {
            if (i5 < f()) {
                iArr[1] = top - f();
                ViewCompat.offsetTopAndBottom(v, -iArr[1]);
                k(3);
            } else {
                if (!this.y) {
                    return;
                }
                iArr[1] = i3;
                ViewCompat.offsetTopAndBottom(v, -i3);
                k(1);
            }
        } else if (i3 < 0 && !view.canScrollVertically(-1)) {
            int i6 = this.u;
            if (i5 > i6 && !this.w) {
                iArr[1] = top - i6;
                ViewCompat.offsetTopAndBottom(v, -iArr[1]);
                k(4);
            } else {
                if (!this.y) {
                    return;
                }
                iArr[1] = i3;
                ViewCompat.offsetTopAndBottom(v, -i3);
                k(1);
            }
        }
        d(v.getTop());
        this.C = i3;
        this.D = true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull View view, int i2, int i3, int i4, int i5, int i6, @NonNull int[] iArr) {
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onRestoreInstanceState(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(coordinatorLayout, v, savedState.getSuperState());
        int i2 = this.f2081b;
        if (i2 != 0) {
            if (i2 == -1 || (i2 & 1) == 1) {
                this.f2084e = savedState.f2092b;
            }
            if (i2 == -1 || (i2 & 2) == 2) {
                this.f2082c = savedState.f2093c;
            }
            if (i2 == -1 || (i2 & 4) == 4) {
                this.w = savedState.f2094d;
            }
            if (i2 == -1 || (i2 & 8) == 8) {
                this.x = savedState.f2095e;
            }
        }
        int i3 = savedState.a;
        if (i3 == 1 || i3 == 2) {
            this.z = 4;
        } else {
            this.z = i3;
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    @NonNull
    public Parcelable onSaveInstanceState(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v) {
        return new SavedState(super.onSaveInstanceState(coordinatorLayout, v), (BottomSheetBehavior<?>) this);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull View view, @NonNull View view2, int i2, int i3) {
        this.C = 0;
        this.D = false;
        return (i2 & 2) != 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x005e  */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onStopNestedScroll(@androidx.annotation.NonNull androidx.coordinatorlayout.widget.CoordinatorLayout r2, @androidx.annotation.NonNull V r3, @androidx.annotation.NonNull android.view.View r4, int r5) {
        /*
            Method dump skipped, instruction units count: 212
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.onStopNestedScroll(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, android.view.View, int):void");
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onTouchEvent(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull MotionEvent motionEvent) {
        if (!v.isShown()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (this.z == 1 && actionMasked == 0) {
            return true;
        }
        ViewDragHelper viewDragHelper = this.A;
        if (viewDragHelper != null) {
            viewDragHelper.processTouchEvent(motionEvent);
        }
        if (actionMasked == 0) {
            this.L = -1;
            VelocityTracker velocityTracker = this.K;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.K = null;
            }
        }
        if (this.K == null) {
            this.K = VelocityTracker.obtain();
        }
        this.K.addMovement(motionEvent);
        if (this.A != null && actionMasked == 2 && !this.B && Math.abs(this.M - motionEvent.getY()) > this.A.getTouchSlop()) {
            this.A.captureChildView(v, motionEvent.getPointerId(motionEvent.getActionIndex()));
        }
        return !this.B;
    }

    public final void p() {
        V v;
        WeakReference<V> weakReference = this.H;
        if (weakReference == null || (v = weakReference.get()) == null) {
            return;
        }
        ViewCompat.removeAccessibilityAction(v, 524288);
        ViewCompat.removeAccessibilityAction(v, 262144);
        ViewCompat.removeAccessibilityAction(v, 1048576);
        int i2 = this.P;
        if (i2 != -1) {
            ViewCompat.removeAccessibilityAction(v, i2);
        }
        if (this.z != 6) {
            this.P = ViewCompat.addAccessibilityAction(v, v.getResources().getString(R$string.bottomsheet_action_expand_halfway), new c.e.a.b.g.c(this, 6));
        }
        if (this.w && this.z != 5) {
            g(v, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_DISMISS, 5);
        }
        int i3 = this.z;
        if (i3 == 3) {
            g(v, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_COLLAPSE, this.f2082c ? 4 : 6);
            return;
        }
        if (i3 == 4) {
            g(v, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_EXPAND, this.f2082c ? 3 : 6);
        } else {
            if (i3 != 6) {
                return;
            }
            g(v, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_COLLAPSE, 4);
            g(v, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_EXPAND, 3);
        }
    }

    public final void q(int i2) {
        ValueAnimator valueAnimator;
        if (i2 == 2) {
            return;
        }
        boolean z = i2 == 3;
        if (this.n != z) {
            this.n = z;
            if (this.f2089j == null || (valueAnimator = this.p) == null) {
                return;
            }
            if (valueAnimator.isRunning()) {
                this.p.reverse();
                return;
            }
            float f2 = z ? 0.0f : 1.0f;
            this.p.setFloatValues(1.0f - f2, f2);
            this.p.start();
        }
    }

    public final void r(boolean z) {
        WeakReference<V> weakReference = this.H;
        if (weakReference == null) {
            return;
        }
        ViewParent parent = weakReference.get().getParent();
        if (parent instanceof CoordinatorLayout) {
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) parent;
            int childCount = coordinatorLayout.getChildCount();
            if (z) {
                if (this.O != null) {
                    return;
                } else {
                    this.O = new HashMap(childCount);
                }
            }
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = coordinatorLayout.getChildAt(i2);
                if (childAt != this.H.get() && z) {
                    this.O.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                }
            }
            if (z) {
                return;
            }
            this.O = null;
        }
    }

    public final void s(boolean z) {
        V v;
        if (this.H != null) {
            a();
            if (this.z != 4 || (v = this.H.get()) == null) {
                return;
            }
            if (z) {
                m(this.z);
            } else {
                v.requestLayout();
            }
        }
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        public final int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f2092b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f2093c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f2094d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f2095e;

        public static class a implements Parcelable.ClassLoaderCreator<SavedState> {
            @Override // android.os.Parcelable.ClassLoaderCreator
            @NonNull
            public SavedState createFromParcel(@NonNull Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            @NonNull
            public Object[] newArray(int i2) {
                return new SavedState[i2];
            }

            @Override // android.os.Parcelable.Creator
            @Nullable
            public Object createFromParcel(@NonNull Parcel parcel) {
                return new SavedState(parcel, (ClassLoader) null);
            }
        }

        public SavedState(@NonNull Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.a = parcel.readInt();
            this.f2092b = parcel.readInt();
            this.f2093c = parcel.readInt() == 1;
            this.f2094d = parcel.readInt() == 1;
            this.f2095e = parcel.readInt() == 1;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@NonNull Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.a);
            parcel.writeInt(this.f2092b);
            parcel.writeInt(this.f2093c ? 1 : 0);
            parcel.writeInt(this.f2094d ? 1 : 0);
            parcel.writeInt(this.f2095e ? 1 : 0);
        }

        public SavedState(Parcelable parcelable, @NonNull BottomSheetBehavior<?> bottomSheetBehavior) {
            super(parcelable);
            this.a = bottomSheetBehavior.z;
            this.f2092b = bottomSheetBehavior.f2084e;
            this.f2093c = bottomSheetBehavior.f2082c;
            this.f2094d = bottomSheetBehavior.w;
            this.f2095e = bottomSheetBehavior.x;
        }
    }

    public BottomSheetBehavior(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        int i2;
        super(context, attributeSet);
        this.f2081b = 0;
        this.f2082c = true;
        this.o = null;
        this.t = 0.5f;
        this.v = -1.0f;
        this.y = true;
        this.z = 4;
        this.J = new ArrayList<>();
        this.P = -1;
        this.Q = new b();
        this.f2087h = context.getResources().getDimensionPixelSize(R$dimen.mtrl_min_touch_target_size);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.BottomSheetBehavior_Layout);
        this.f2088i = typedArrayObtainStyledAttributes.hasValue(R$styleable.BottomSheetBehavior_Layout_shapeAppearance);
        int i3 = R$styleable.BottomSheetBehavior_Layout_backgroundTint;
        boolean zHasValue = typedArrayObtainStyledAttributes.hasValue(i3);
        if (zHasValue) {
            c(context, attributeSet, zHasValue, f.a2(context, typedArrayObtainStyledAttributes, i3));
        } else {
            c(context, attributeSet, zHasValue, null);
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.p = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(500L);
        this.p.addUpdateListener(new c.e.a.b.g.a(this));
        this.v = typedArrayObtainStyledAttributes.getDimension(R$styleable.BottomSheetBehavior_Layout_android_elevation, -1.0f);
        int i4 = R$styleable.BottomSheetBehavior_Layout_behavior_peekHeight;
        TypedValue typedValuePeekValue = typedArrayObtainStyledAttributes.peekValue(i4);
        if (typedValuePeekValue != null && (i2 = typedValuePeekValue.data) == -1) {
            i(i2);
        } else {
            i(typedArrayObtainStyledAttributes.getDimensionPixelSize(i4, -1));
        }
        h(typedArrayObtainStyledAttributes.getBoolean(R$styleable.BottomSheetBehavior_Layout_behavior_hideable, false));
        this.f2091l = typedArrayObtainStyledAttributes.getBoolean(R$styleable.BottomSheetBehavior_Layout_gestureInsetBottomIgnored, false);
        boolean z = typedArrayObtainStyledAttributes.getBoolean(R$styleable.BottomSheetBehavior_Layout_behavior_fitToContents, true);
        if (this.f2082c != z) {
            this.f2082c = z;
            if (this.H != null) {
                a();
            }
            k((this.f2082c && this.z == 6) ? 3 : this.z);
            p();
        }
        this.x = typedArrayObtainStyledAttributes.getBoolean(R$styleable.BottomSheetBehavior_Layout_behavior_skipCollapsed, false);
        this.y = typedArrayObtainStyledAttributes.getBoolean(R$styleable.BottomSheetBehavior_Layout_behavior_draggable, true);
        this.f2081b = typedArrayObtainStyledAttributes.getInt(R$styleable.BottomSheetBehavior_Layout_behavior_saveFlags, 0);
        float f2 = typedArrayObtainStyledAttributes.getFloat(R$styleable.BottomSheetBehavior_Layout_behavior_halfExpandedRatio, 0.5f);
        if (f2 > 0.0f && f2 < 1.0f) {
            this.t = f2;
            if (this.H != null) {
                this.s = (int) ((1.0f - f2) * this.G);
            }
            int i5 = R$styleable.BottomSheetBehavior_Layout_behavior_expandedOffset;
            TypedValue typedValuePeekValue2 = typedArrayObtainStyledAttributes.peekValue(i5);
            if (typedValuePeekValue2 != null && typedValuePeekValue2.type == 16) {
                int i6 = typedValuePeekValue2.data;
                if (i6 >= 0) {
                    this.q = i6;
                } else {
                    throw new IllegalArgumentException("offset must be greater than or equal to 0");
                }
            } else {
                int dimensionPixelOffset = typedArrayObtainStyledAttributes.getDimensionPixelOffset(i5, 0);
                if (dimensionPixelOffset >= 0) {
                    this.q = dimensionPixelOffset;
                } else {
                    throw new IllegalArgumentException("offset must be greater than or equal to 0");
                }
            }
            typedArrayObtainStyledAttributes.recycle();
            this.f2083d = ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
            return;
        }
        throw new IllegalArgumentException("ratio must be a float value between 0 and 1");
    }
}

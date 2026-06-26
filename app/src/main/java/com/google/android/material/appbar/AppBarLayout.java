package com.google.android.material.appbar;

import android.animation.AnimatorInflater;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.math.MathUtils;
import androidx.core.util.ObjectsCompat;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.view.AbsSavedState;
import c.b.a.m.f;
import c.e.a.b.b.d;
import c.e.a.b.b.g;
import c.e.a.b.b.i;
import c.e.a.b.b.j;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$integer;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.shape.MaterialShapeDrawable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class AppBarLayout extends LinearLayout implements CoordinatorLayout.AttachedBehavior {
    public static final int a = R$style.Widget_Design_AppBarLayout;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f1965b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f1966c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f1967d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f1968e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f1969f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f1970g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    public WindowInsetsCompat f1971h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public List<b> f1972i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f1973j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f1974k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f1975l;

    @IdRes
    public int m;

    @Nullable
    public WeakReference<View> n;

    @Nullable
    public ValueAnimator o;
    public int[] p;

    @Nullable
    public Drawable q;

    public static class Behavior extends BaseBehavior<AppBarLayout> {
        public Behavior() {
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    public static class ScrollingViewBehavior extends g {
        public ScrollingViewBehavior() {
        }

        @Nullable
        public AppBarLayout d(@NonNull List<View> list) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                View view = list.get(i2);
                if (view instanceof AppBarLayout) {
                    return (AppBarLayout) view;
                }
            }
            return null;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean layoutDependsOn(CoordinatorLayout coordinatorLayout, View view, View view2) {
            return view2 instanceof AppBarLayout;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean onDependentViewChanged(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull View view2) {
            CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) view2.getLayoutParams()).getBehavior();
            if (behavior instanceof BaseBehavior) {
                ViewCompat.offsetTopAndBottom(view, (((view2.getBottom() - view.getTop()) + ((BaseBehavior) behavior).f1976j) + this.f910e) - c(view2));
            }
            if (!(view2 instanceof AppBarLayout)) {
                return false;
            }
            AppBarLayout appBarLayout = (AppBarLayout) view2;
            if (!appBarLayout.f1975l) {
                return false;
            }
            appBarLayout.d(appBarLayout.e(view));
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public void onDependentViewRemoved(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull View view2) {
            if (view2 instanceof AppBarLayout) {
                ViewCompat.removeAccessibilityAction(coordinatorLayout, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD.getId());
                ViewCompat.removeAccessibilityAction(coordinatorLayout, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD.getId());
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean onRequestChildRectangleOnScreen(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull Rect rect, boolean z) {
            AppBarLayout appBarLayoutD = d(coordinatorLayout.getDependencies(view));
            if (appBarLayoutD != null) {
                rect.offset(view.getLeft(), view.getTop());
                Rect rect2 = this.f908c;
                rect2.set(0, 0, coordinatorLayout.getWidth(), coordinatorLayout.getHeight());
                if (!rect2.contains(rect)) {
                    appBarLayoutD.c(false, !z, true);
                    return true;
                }
            }
            return false;
        }

        public ScrollingViewBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ScrollingViewBehavior_Layout);
            this.f911f = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.ScrollingViewBehavior_Layout_behavior_overlapTop, 0);
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public class a implements OnApplyWindowInsetsListener {
        public a() {
        }

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
            AppBarLayout appBarLayout = AppBarLayout.this;
            Objects.requireNonNull(appBarLayout);
            WindowInsetsCompat windowInsetsCompat2 = ViewCompat.getFitsSystemWindows(appBarLayout) ? windowInsetsCompat : null;
            if (!ObjectsCompat.equals(appBarLayout.f1971h, windowInsetsCompat2)) {
                appBarLayout.f1971h = windowInsetsCompat2;
                appBarLayout.g();
                appBarLayout.requestLayout();
            }
            return windowInsetsCompat;
        }
    }

    public interface b<T extends AppBarLayout> {
        void a(T t, int i2);
    }

    public interface c extends b<AppBarLayout> {
    }

    public AppBarLayout(@NonNull Context context) {
        this(context, null);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LinearLayout.LayoutParams ? new LayoutParams((LinearLayout.LayoutParams) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
    }

    public void addOnOffsetChangedListener(@Nullable b bVar) {
        if (this.f1972i == null) {
            this.f1972i = new ArrayList();
        }
        if (bVar == null || this.f1972i.contains(bVar)) {
            return;
        }
        this.f1972i.add(bVar);
    }

    public void b(int i2) {
        this.f1965b = i2;
        if (!willNotDraw()) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
        List<b> list = this.f1972i;
        if (list != null) {
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                b bVar = this.f1972i.get(i3);
                if (bVar != null) {
                    bVar.a(this, i2);
                }
            }
        }
    }

    public final void c(boolean z, boolean z2, boolean z3) {
        this.f1970g = (z ? 1 : 2) | (z2 ? 4 : 0) | (z3 ? 8 : 0);
        requestLayout();
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public boolean d(boolean z) {
        if (this.f1974k == z) {
            return false;
        }
        this.f1974k = z;
        refreshDrawableState();
        if (this.f1975l && (getBackground() instanceof MaterialShapeDrawable)) {
            MaterialShapeDrawable materialShapeDrawable = (MaterialShapeDrawable) getBackground();
            float dimension = getResources().getDimension(R$dimen.design_appbar_elevation);
            float f2 = z ? 0.0f : dimension;
            if (!z) {
                dimension = 0.0f;
            }
            ValueAnimator valueAnimator = this.o;
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(f2, dimension);
            this.o = valueAnimatorOfFloat;
            valueAnimatorOfFloat.setDuration(getResources().getInteger(R$integer.app_bar_elevation_anim_duration));
            this.o.setInterpolator(c.e.a.b.a.a.a);
            this.o.addUpdateListener(new c.e.a.b.b.a(this, materialShapeDrawable));
            this.o.start();
        }
        return true;
    }

    @Override // android.view.View
    public void draw(@NonNull Canvas canvas) {
        super.draw(canvas);
        if (this.q != null && getTopInset() > 0) {
            int iSave = canvas.save();
            canvas.translate(0.0f, -this.f1965b);
            this.q.draw(canvas);
            canvas.restoreToCount(iSave);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.q;
        if (drawable != null && drawable.isStateful() && drawable.setState(drawableState)) {
            invalidateDrawable(drawable);
        }
    }

    public boolean e(@Nullable View view) {
        int i2;
        if (this.n == null && (i2 = this.m) != -1) {
            View viewFindViewById = view != null ? view.findViewById(i2) : null;
            if (viewFindViewById == null && (getParent() instanceof ViewGroup)) {
                viewFindViewById = ((ViewGroup) getParent()).findViewById(this.m);
            }
            if (viewFindViewById != null) {
                this.n = new WeakReference<>(viewFindViewById);
            }
        }
        WeakReference<View> weakReference = this.n;
        View view2 = weakReference != null ? weakReference.get() : null;
        if (view2 != null) {
            view = view2;
        }
        return view != null && (view.canScrollVertically(-1) || view.getScrollY() > 0);
    }

    public final boolean f() {
        if (getChildCount() <= 0) {
            return false;
        }
        View childAt = getChildAt(0);
        return (childAt.getVisibility() == 8 || ViewCompat.getFitsSystemWindows(childAt)) ? false : true;
    }

    public final void g() {
        setWillNotDraw(!(this.q != null && getTopInset() > 0));
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -2);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.AttachedBehavior
    @NonNull
    public CoordinatorLayout.Behavior<AppBarLayout> getBehavior() {
        return new Behavior();
    }

    public int getDownNestedPreScrollRange() {
        int iMin;
        int minimumHeight;
        int i2 = this.f1967d;
        if (i2 != -1) {
            return i2;
        }
        int i3 = 0;
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int i4 = layoutParams.a;
            if ((i4 & 5) != 5) {
                if (i3 > 0) {
                    break;
                }
            } else {
                int i5 = ((LinearLayout.LayoutParams) layoutParams).topMargin + ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
                if ((i4 & 8) != 0) {
                    minimumHeight = ViewCompat.getMinimumHeight(childAt);
                } else if ((i4 & 2) != 0) {
                    minimumHeight = measuredHeight - ViewCompat.getMinimumHeight(childAt);
                } else {
                    iMin = i5 + measuredHeight;
                    if (childCount == 0 && ViewCompat.getFitsSystemWindows(childAt)) {
                        iMin = Math.min(iMin, measuredHeight - getTopInset());
                    }
                    i3 += iMin;
                }
                iMin = minimumHeight + i5;
                if (childCount == 0) {
                    iMin = Math.min(iMin, measuredHeight - getTopInset());
                }
                i3 += iMin;
            }
        }
        int iMax = Math.max(0, i3);
        this.f1967d = iMax;
        return iMax;
    }

    public int getDownNestedScrollRange() {
        int i2 = this.f1968e;
        if (i2 != -1) {
            return i2;
        }
        int childCount = getChildCount();
        int i3 = 0;
        int minimumHeight = 0;
        while (true) {
            if (i3 >= childCount) {
                break;
            }
            View childAt = getChildAt(i3);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            int measuredHeight = ((LinearLayout.LayoutParams) layoutParams).topMargin + ((LinearLayout.LayoutParams) layoutParams).bottomMargin + childAt.getMeasuredHeight();
            int i4 = layoutParams.a;
            if ((i4 & 1) == 0) {
                break;
            }
            minimumHeight += measuredHeight;
            if ((i4 & 2) != 0) {
                minimumHeight -= ViewCompat.getMinimumHeight(childAt);
                break;
            }
            i3++;
        }
        int iMax = Math.max(0, minimumHeight);
        this.f1968e = iMax;
        return iMax;
    }

    @IdRes
    public int getLiftOnScrollTargetViewId() {
        return this.m;
    }

    public final int getMinimumHeightForVisibleOverlappingContent() {
        int topInset = getTopInset();
        int minimumHeight = ViewCompat.getMinimumHeight(this);
        if (minimumHeight == 0) {
            int childCount = getChildCount();
            minimumHeight = childCount >= 1 ? ViewCompat.getMinimumHeight(getChildAt(childCount - 1)) : 0;
            if (minimumHeight == 0) {
                return getHeight() / 3;
            }
        }
        return (minimumHeight * 2) + topInset;
    }

    public int getPendingAction() {
        return this.f1970g;
    }

    @Nullable
    public Drawable getStatusBarForeground() {
        return this.q;
    }

    @Deprecated
    public float getTargetElevation() {
        return 0.0f;
    }

    @VisibleForTesting
    public final int getTopInset() {
        WindowInsetsCompat windowInsetsCompat = this.f1971h;
        if (windowInsetsCompat != null) {
            return windowInsetsCompat.getSystemWindowInsetTop();
        }
        return 0;
    }

    public final int getTotalScrollRange() {
        int i2 = this.f1966c;
        if (i2 != -1) {
            return i2;
        }
        int childCount = getChildCount();
        int i3 = 0;
        int minimumHeight = 0;
        while (true) {
            if (i3 >= childCount) {
                break;
            }
            View childAt = getChildAt(i3);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int i4 = layoutParams.a;
            if ((i4 & 1) == 0) {
                break;
            }
            int topInset = measuredHeight + ((LinearLayout.LayoutParams) layoutParams).topMargin + ((LinearLayout.LayoutParams) layoutParams).bottomMargin + minimumHeight;
            if (i3 == 0 && ViewCompat.getFitsSystemWindows(childAt)) {
                topInset -= getTopInset();
            }
            minimumHeight = topInset;
            if ((i4 & 2) != 0) {
                minimumHeight -= ViewCompat.getMinimumHeight(childAt);
                break;
            }
            i3++;
        }
        int iMax = Math.max(0, minimumHeight);
        this.f1966c = iMax;
        return iMax;
    }

    public int getUpNestedPreScrollRange() {
        return getTotalScrollRange();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Drawable background = getBackground();
        if (background instanceof MaterialShapeDrawable) {
            f.e5(this, (MaterialShapeDrawable) background);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public int[] onCreateDrawableState(int i2) {
        if (this.p == null) {
            this.p = new int[4];
        }
        int[] iArr = this.p;
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i2 + iArr.length);
        boolean z = this.f1973j;
        int i3 = R$attr.state_liftable;
        if (!z) {
            i3 = -i3;
        }
        iArr[0] = i3;
        iArr[1] = (z && this.f1974k) ? R$attr.state_lifted : -R$attr.state_lifted;
        int i4 = R$attr.state_collapsible;
        if (!z) {
            i4 = -i4;
        }
        iArr[2] = i4;
        iArr[3] = (z && this.f1974k) ? R$attr.state_collapsed : -R$attr.state_collapsed;
        return LinearLayout.mergeDrawableStates(iArrOnCreateDrawableState, iArr);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        WeakReference<View> weakReference = this.n;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.n = null;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        boolean z2;
        super.onLayout(z, i2, i3, i4, i5);
        boolean z3 = true;
        if (ViewCompat.getFitsSystemWindows(this) && f()) {
            int topInset = getTopInset();
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                ViewCompat.offsetTopAndBottom(getChildAt(childCount), topInset);
            }
        }
        this.f1966c = -1;
        this.f1967d = -1;
        this.f1968e = -1;
        this.f1969f = false;
        int childCount2 = getChildCount();
        int i6 = 0;
        while (true) {
            if (i6 >= childCount2) {
                break;
            }
            if (((LayoutParams) getChildAt(i6).getLayoutParams()).f1981b != null) {
                this.f1969f = true;
                break;
            }
            i6++;
        }
        Drawable drawable = this.q;
        if (drawable != null) {
            drawable.setBounds(0, 0, getWidth(), getTopInset());
        }
        if (!this.f1975l) {
            int childCount3 = getChildCount();
            int i7 = 0;
            while (true) {
                if (i7 >= childCount3) {
                    z2 = false;
                    break;
                }
                int i8 = ((LayoutParams) getChildAt(i7).getLayoutParams()).a;
                if ((i8 & 1) == 1 && (i8 & 10) != 0) {
                    z2 = true;
                    break;
                }
                i7++;
            }
            if (!z2) {
                z3 = false;
            }
        }
        if (this.f1973j != z3) {
            this.f1973j = z3;
            refreshDrawableState();
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        int mode = View.MeasureSpec.getMode(i3);
        if (mode != 1073741824 && ViewCompat.getFitsSystemWindows(this) && f()) {
            int measuredHeight = getMeasuredHeight();
            if (mode == Integer.MIN_VALUE) {
                measuredHeight = MathUtils.clamp(getTopInset() + getMeasuredHeight(), 0, View.MeasureSpec.getSize(i3));
            } else if (mode == 0) {
                measuredHeight += getTopInset();
            }
            setMeasuredDimension(getMeasuredWidth(), measuredHeight);
        }
        this.f1966c = -1;
        this.f1967d = -1;
        this.f1968e = -1;
    }

    public void removeOnOffsetChangedListener(@Nullable b bVar) {
        List<b> list = this.f1972i;
        if (list == null || bVar == null) {
            return;
        }
        list.remove(bVar);
    }

    @Override // android.view.View
    @RequiresApi(21)
    public void setElevation(float f2) {
        super.setElevation(f2);
        f.d5(this, f2);
    }

    public void setExpanded(boolean z) {
        c(z, ViewCompat.isLaidOut(this), true);
    }

    public void setLiftOnScroll(boolean z) {
        this.f1975l = z;
    }

    public void setLiftOnScrollTargetViewId(@IdRes int i2) {
        this.m = i2;
        WeakReference<View> weakReference = this.n;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.n = null;
    }

    @Override // android.widget.LinearLayout
    public void setOrientation(int i2) {
        if (i2 != 1) {
            throw new IllegalArgumentException("AppBarLayout is always vertical and does not support horizontal orientation");
        }
        super.setOrientation(i2);
    }

    public void setStatusBarForeground(@Nullable Drawable drawable) {
        Drawable drawable2 = this.q;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            Drawable drawableMutate = drawable != null ? drawable.mutate() : null;
            this.q = drawableMutate;
            if (drawableMutate != null) {
                if (drawableMutate.isStateful()) {
                    this.q.setState(getDrawableState());
                }
                DrawableCompat.setLayoutDirection(this.q, ViewCompat.getLayoutDirection(this));
                this.q.setVisible(getVisibility() == 0, false);
                this.q.setCallback(this);
            }
            g();
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    public void setStatusBarForegroundColor(@ColorInt int i2) {
        setStatusBarForeground(new ColorDrawable(i2));
    }

    public void setStatusBarForegroundResource(@DrawableRes int i2) {
        setStatusBarForeground(AppCompatResources.getDrawable(getContext(), i2));
    }

    @Deprecated
    public void setTargetElevation(float f2) {
        j.a(this, f2);
    }

    @Override // android.view.View
    public void setVisibility(int i2) {
        super.setVisibility(i2);
        boolean z = i2 == 0;
        Drawable drawable = this.q;
        if (drawable != null) {
            drawable.setVisible(z, false);
        }
    }

    @Override // android.view.View
    public boolean verifyDrawable(@NonNull Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.q;
    }

    public static class BaseBehavior<T extends AppBarLayout> extends c.e.a.b.b.f<T> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f1976j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f1977k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public ValueAnimator f1978l;
        public int m;
        public boolean n;
        public float o;

        @Nullable
        public WeakReference<View> p;

        public BaseBehavior() {
            this.m = -1;
        }

        public static boolean h(int i2, int i3) {
            return (i2 & i3) == i3;
        }

        @Override // c.e.a.b.b.f
        public int c() {
            return a() + this.f1976j;
        }

        /* JADX WARN: Removed duplicated region for block: B:32:0x008b  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x0090  */
        /* JADX WARN: Removed duplicated region for block: B:41:0x00aa  */
        /* JADX WARN: Removed duplicated region for block: B:42:0x00ad  */
        @Override // c.e.a.b.b.f
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public int f(@androidx.annotation.NonNull androidx.coordinatorlayout.widget.CoordinatorLayout r8, @androidx.annotation.NonNull android.view.View r9, int r10, int r11, int r12) {
            /*
                r7 = this;
                com.google.android.material.appbar.AppBarLayout r9 = (com.google.android.material.appbar.AppBarLayout) r9
                int r0 = r7.c()
                r1 = 0
                if (r11 == 0) goto Lb8
                if (r0 < r11) goto Lb8
                if (r0 > r12) goto Lb8
                int r3 = androidx.core.math.MathUtils.clamp(r10, r11, r12)
                if (r0 == r3) goto Lba
                boolean r10 = r9.f1969f
                if (r10 == 0) goto L86
                int r10 = java.lang.Math.abs(r3)
                int r11 = r9.getChildCount()
                r12 = 0
            L20:
                if (r12 >= r11) goto L86
                android.view.View r2 = r9.getChildAt(r12)
                android.view.ViewGroup$LayoutParams r4 = r2.getLayoutParams()
                com.google.android.material.appbar.AppBarLayout$LayoutParams r4 = (com.google.android.material.appbar.AppBarLayout.LayoutParams) r4
                android.view.animation.Interpolator r5 = r4.f1981b
                int r6 = r2.getTop()
                if (r10 < r6) goto L83
                int r6 = r2.getBottom()
                if (r10 > r6) goto L83
                if (r5 == 0) goto L86
                int r11 = r4.a
                r12 = r11 & 1
                if (r12 == 0) goto L57
                int r12 = r2.getHeight()
                int r6 = r4.topMargin
                int r12 = r12 + r6
                int r4 = r4.bottomMargin
                int r12 = r12 + r4
                int r12 = r12 + r1
                r11 = r11 & 2
                if (r11 == 0) goto L58
                int r11 = androidx.core.view.ViewCompat.getMinimumHeight(r2)
                int r12 = r12 - r11
                goto L58
            L57:
                r12 = 0
            L58:
                boolean r11 = androidx.core.view.ViewCompat.getFitsSystemWindows(r2)
                if (r11 == 0) goto L63
                int r11 = r9.getTopInset()
                int r12 = r12 - r11
            L63:
                if (r12 <= 0) goto L86
                int r11 = r2.getTop()
                int r10 = r10 - r11
                float r11 = (float) r12
                float r10 = (float) r10
                float r10 = r10 / r11
                float r10 = r5.getInterpolation(r10)
                float r10 = r10 * r11
                int r10 = java.lang.Math.round(r10)
                int r11 = java.lang.Integer.signum(r3)
                int r12 = r2.getTop()
                int r12 = r12 + r10
                int r12 = r12 * r11
                goto L87
            L83:
                int r12 = r12 + 1
                goto L20
            L86:
                r12 = r3
            L87:
                c.e.a.b.b.i r10 = r7.a
                if (r10 == 0) goto L90
                boolean r1 = r10.b(r12)
                goto L92
            L90:
                r7.f912b = r12
            L92:
                int r10 = r0 - r3
                int r11 = r3 - r12
                r7.f1976j = r11
                if (r1 != 0) goto La1
                boolean r11 = r9.f1969f
                if (r11 == 0) goto La1
                r8.dispatchDependentViewsChanged(r9)
            La1:
                int r11 = r7.a()
                r9.b(r11)
                if (r3 >= r0) goto Lad
                r11 = -1
                r4 = -1
                goto Laf
            Lad:
                r11 = 1
                r4 = 1
            Laf:
                r5 = 0
                r0 = r7
                r1 = r8
                r2 = r9
                r0.o(r1, r2, r3, r4, r5)
                r1 = r10
                goto Lba
            Lb8:
                r7.f1976j = r1
            Lba:
                r7.n(r8, r9)
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.AppBarLayout.BaseBehavior.f(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, int, int, int):int");
        }

        public final void g(CoordinatorLayout coordinatorLayout, @NonNull T t, int i2, float f2) {
            int iAbs = Math.abs(c() - i2);
            float fAbs = Math.abs(f2);
            int iRound = fAbs > 0.0f ? Math.round((iAbs / fAbs) * 1000.0f) * 3 : (int) (((iAbs / t.getHeight()) + 1.0f) * 150.0f);
            int iC = c();
            if (iC == i2) {
                ValueAnimator valueAnimator = this.f1978l;
                if (valueAnimator == null || !valueAnimator.isRunning()) {
                    return;
                }
                this.f1978l.cancel();
                return;
            }
            ValueAnimator valueAnimator2 = this.f1978l;
            if (valueAnimator2 == null) {
                ValueAnimator valueAnimator3 = new ValueAnimator();
                this.f1978l = valueAnimator3;
                valueAnimator3.setInterpolator(c.e.a.b.a.a.f842e);
                this.f1978l.addUpdateListener(new c.e.a.b.b.b(this, coordinatorLayout, t));
            } else {
                valueAnimator2.cancel();
            }
            this.f1978l.setDuration(Math.min(iRound, 600));
            this.f1978l.setIntValues(iC, i2);
            this.f1978l.start();
        }

        @Nullable
        public final View i(@NonNull CoordinatorLayout coordinatorLayout) {
            int childCount = coordinatorLayout.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = coordinatorLayout.getChildAt(i2);
                if ((childAt instanceof NestedScrollingChild) || (childAt instanceof ListView) || (childAt instanceof ScrollView)) {
                    return childAt;
                }
            }
            return null;
        }

        public void j(CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, View view, int i2, int[] iArr) {
            int i3;
            int downNestedPreScrollRange;
            if (i2 != 0) {
                if (i2 < 0) {
                    int i4 = -appBarLayout.getTotalScrollRange();
                    i3 = i4;
                    downNestedPreScrollRange = appBarLayout.getDownNestedPreScrollRange() + i4;
                } else {
                    i3 = -appBarLayout.getUpNestedPreScrollRange();
                    downNestedPreScrollRange = 0;
                }
                if (i3 != downNestedPreScrollRange) {
                    iArr[1] = d(coordinatorLayout, appBarLayout, i2, i3, downNestedPreScrollRange);
                }
            }
            if (appBarLayout.f1975l) {
                appBarLayout.d(appBarLayout.e(view));
            }
        }

        public void k(CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, int i2, int[] iArr) {
            if (i2 < 0) {
                iArr[1] = d(coordinatorLayout, appBarLayout, i2, -appBarLayout.getDownNestedScrollRange(), 0);
            }
            if (i2 == 0) {
                n(coordinatorLayout, appBarLayout);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x002a  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public boolean l(@androidx.annotation.NonNull androidx.coordinatorlayout.widget.CoordinatorLayout r3, @androidx.annotation.NonNull com.google.android.material.appbar.AppBarLayout r4, @androidx.annotation.NonNull android.view.View r5, int r6, int r7) {
            /*
                r2 = this;
                r6 = r6 & 2
                r0 = 1
                r1 = 0
                if (r6 == 0) goto L2a
                boolean r6 = r4.f1975l
                if (r6 != 0) goto L2b
                int r6 = r4.getTotalScrollRange()
                if (r6 == 0) goto L12
                r6 = 1
                goto L13
            L12:
                r6 = 0
            L13:
                if (r6 == 0) goto L26
                int r3 = r3.getHeight()
                int r5 = r5.getHeight()
                int r3 = r3 - r5
                int r4 = r4.getHeight()
                if (r3 > r4) goto L26
                r3 = 1
                goto L27
            L26:
                r3 = 0
            L27:
                if (r3 == 0) goto L2a
                goto L2b
            L2a:
                r0 = 0
            L2b:
                if (r0 == 0) goto L34
                android.animation.ValueAnimator r3 = r2.f1978l
                if (r3 == 0) goto L34
                r3.cancel()
            L34:
                r3 = 0
                r2.p = r3
                r2.f1977k = r7
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.AppBarLayout.BaseBehavior.l(androidx.coordinatorlayout.widget.CoordinatorLayout, com.google.android.material.appbar.AppBarLayout, android.view.View, int, int):boolean");
        }

        public final void m(CoordinatorLayout coordinatorLayout, @NonNull T t) {
            int iC = c();
            int childCount = t.getChildCount();
            int i2 = 0;
            while (true) {
                if (i2 >= childCount) {
                    i2 = -1;
                    break;
                }
                View childAt = t.getChildAt(i2);
                int top = childAt.getTop();
                int bottom = childAt.getBottom();
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (h(layoutParams.a, 32)) {
                    top -= ((LinearLayout.LayoutParams) layoutParams).topMargin;
                    bottom += ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
                }
                int i3 = -iC;
                if (top <= i3 && bottom >= i3) {
                    break;
                } else {
                    i2++;
                }
            }
            if (i2 >= 0) {
                View childAt2 = t.getChildAt(i2);
                LayoutParams layoutParams2 = (LayoutParams) childAt2.getLayoutParams();
                int i4 = layoutParams2.a;
                if ((i4 & 17) == 17) {
                    int i5 = -childAt2.getTop();
                    int minimumHeight = -childAt2.getBottom();
                    if (i2 == t.getChildCount() - 1) {
                        minimumHeight += t.getTopInset();
                    }
                    if (h(i4, 2)) {
                        minimumHeight += ViewCompat.getMinimumHeight(childAt2);
                    } else if (h(i4, 5)) {
                        int minimumHeight2 = ViewCompat.getMinimumHeight(childAt2) + minimumHeight;
                        if (iC < minimumHeight2) {
                            i5 = minimumHeight2;
                        } else {
                            minimumHeight = minimumHeight2;
                        }
                    }
                    if (h(i4, 32)) {
                        i5 += ((LinearLayout.LayoutParams) layoutParams2).topMargin;
                        minimumHeight -= ((LinearLayout.LayoutParams) layoutParams2).bottomMargin;
                    }
                    if (iC < (minimumHeight + i5) / 2) {
                        i5 = minimumHeight;
                    }
                    g(coordinatorLayout, t, MathUtils.clamp(i5, -t.getTotalScrollRange(), 0), 0.0f);
                }
            }
        }

        public final void n(CoordinatorLayout coordinatorLayout, @NonNull T t) {
            AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat = AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD;
            ViewCompat.removeAccessibilityAction(coordinatorLayout, accessibilityActionCompat.getId());
            AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat2 = AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD;
            ViewCompat.removeAccessibilityAction(coordinatorLayout, accessibilityActionCompat2.getId());
            View viewI = i(coordinatorLayout);
            if (viewI == null || t.getTotalScrollRange() == 0 || !(((CoordinatorLayout.LayoutParams) viewI.getLayoutParams()).getBehavior() instanceof ScrollingViewBehavior)) {
                return;
            }
            if (c() != (-t.getTotalScrollRange()) && viewI.canScrollVertically(1)) {
                ViewCompat.replaceAccessibilityAction(coordinatorLayout, accessibilityActionCompat, null, new d(this, t, false));
            }
            if (c() != 0) {
                if (!viewI.canScrollVertically(-1)) {
                    ViewCompat.replaceAccessibilityAction(coordinatorLayout, accessibilityActionCompat2, null, new d(this, t, true));
                    return;
                }
                int i2 = -t.getDownNestedPreScrollRange();
                if (i2 != 0) {
                    ViewCompat.replaceAccessibilityAction(coordinatorLayout, accessibilityActionCompat2, null, new c.e.a.b.b.c(this, coordinatorLayout, t, viewI, i2));
                }
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:26:0x005b  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void o(@androidx.annotation.NonNull androidx.coordinatorlayout.widget.CoordinatorLayout r7, @androidx.annotation.NonNull T r8, int r9, int r10, boolean r11) {
            /*
                r6 = this;
                int r0 = java.lang.Math.abs(r9)
                int r1 = r8.getChildCount()
                r2 = 0
                r3 = 0
            La:
                if (r3 >= r1) goto L20
                android.view.View r4 = r8.getChildAt(r3)
                int r5 = r4.getTop()
                if (r0 < r5) goto L1d
                int r5 = r4.getBottom()
                if (r0 > r5) goto L1d
                goto L21
            L1d:
                int r3 = r3 + 1
                goto La
            L20:
                r4 = 0
            L21:
                if (r4 == 0) goto L9f
                android.view.ViewGroup$LayoutParams r0 = r4.getLayoutParams()
                com.google.android.material.appbar.AppBarLayout$LayoutParams r0 = (com.google.android.material.appbar.AppBarLayout.LayoutParams) r0
                int r0 = r0.a
                r1 = r0 & 1
                r3 = 1
                if (r1 == 0) goto L5b
                int r1 = androidx.core.view.ViewCompat.getMinimumHeight(r4)
                if (r10 <= 0) goto L48
                r10 = r0 & 12
                if (r10 == 0) goto L48
                int r9 = -r9
                int r10 = r4.getBottom()
                int r10 = r10 - r1
                int r0 = r8.getTopInset()
                int r10 = r10 - r0
                if (r9 < r10) goto L5b
                goto L59
            L48:
                r10 = r0 & 2
                if (r10 == 0) goto L5b
                int r9 = -r9
                int r10 = r4.getBottom()
                int r10 = r10 - r1
                int r0 = r8.getTopInset()
                int r10 = r10 - r0
                if (r9 < r10) goto L5b
            L59:
                r9 = 1
                goto L5c
            L5b:
                r9 = 0
            L5c:
                boolean r10 = r8.f1975l
                if (r10 == 0) goto L68
                android.view.View r9 = r6.i(r7)
                boolean r9 = r8.e(r9)
            L68:
                boolean r9 = r8.d(r9)
                if (r11 != 0) goto L9c
                if (r9 == 0) goto L9f
                java.util.List r7 = r7.getDependents(r8)
                int r9 = r7.size()
                r10 = 0
            L79:
                if (r10 >= r9) goto L9a
                java.lang.Object r11 = r7.get(r10)
                android.view.View r11 = (android.view.View) r11
                android.view.ViewGroup$LayoutParams r11 = r11.getLayoutParams()
                androidx.coordinatorlayout.widget.CoordinatorLayout$LayoutParams r11 = (androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams) r11
                androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior r11 = r11.getBehavior()
                boolean r0 = r11 instanceof com.google.android.material.appbar.AppBarLayout.ScrollingViewBehavior
                if (r0 == 0) goto L97
                com.google.android.material.appbar.AppBarLayout$ScrollingViewBehavior r11 = (com.google.android.material.appbar.AppBarLayout.ScrollingViewBehavior) r11
                int r7 = r11.f911f
                if (r7 == 0) goto L9a
                r2 = 1
                goto L9a
            L97:
                int r10 = r10 + 1
                goto L79
            L9a:
                if (r2 == 0) goto L9f
            L9c:
                r8.jumpDrawablesToCurrentState()
            L9f:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.AppBarLayout.BaseBehavior.o(androidx.coordinatorlayout.widget.CoordinatorLayout, com.google.android.material.appbar.AppBarLayout, int, int, boolean):void");
        }

        @Override // c.e.a.b.b.h, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean onLayoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, int i2) {
            AppBarLayout appBarLayout = (AppBarLayout) view;
            super.onLayoutChild(coordinatorLayout, appBarLayout, i2);
            int pendingAction = appBarLayout.getPendingAction();
            int i3 = this.m;
            if (i3 >= 0 && (pendingAction & 8) == 0) {
                View childAt = appBarLayout.getChildAt(i3);
                int i4 = -childAt.getBottom();
                e(coordinatorLayout, appBarLayout, this.n ? appBarLayout.getTopInset() + ViewCompat.getMinimumHeight(childAt) + i4 : Math.round(childAt.getHeight() * this.o) + i4);
            } else if (pendingAction != 0) {
                boolean z = (pendingAction & 4) != 0;
                if ((pendingAction & 2) != 0) {
                    int i5 = -appBarLayout.getUpNestedPreScrollRange();
                    if (z) {
                        g(coordinatorLayout, appBarLayout, i5, 0.0f);
                    } else {
                        e(coordinatorLayout, appBarLayout, i5);
                    }
                } else if ((pendingAction & 1) != 0) {
                    if (z) {
                        g(coordinatorLayout, appBarLayout, 0, 0.0f);
                    } else {
                        e(coordinatorLayout, appBarLayout, 0);
                    }
                }
            }
            appBarLayout.f1970g = 0;
            this.m = -1;
            int iClamp = MathUtils.clamp(a(), -appBarLayout.getTotalScrollRange(), 0);
            i iVar = this.a;
            if (iVar != null) {
                iVar.b(iClamp);
            } else {
                this.f912b = iClamp;
            }
            o(coordinatorLayout, appBarLayout, a(), 0, true);
            appBarLayout.b(a());
            n(coordinatorLayout, appBarLayout);
            return true;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean onMeasureChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, int i2, int i3, int i4, int i5) {
            AppBarLayout appBarLayout = (AppBarLayout) view;
            if (((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.LayoutParams) appBarLayout.getLayoutParams())).height != -2) {
                return super.onMeasureChild(coordinatorLayout, appBarLayout, i2, i3, i4, i5);
            }
            coordinatorLayout.onMeasureChild(appBarLayout, i2, i3, View.MeasureSpec.makeMeasureSpec(0, 0), i5);
            return true;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ void onNestedPreScroll(CoordinatorLayout coordinatorLayout, @NonNull View view, View view2, int i2, int i3, int[] iArr, int i4) {
            j(coordinatorLayout, (AppBarLayout) view, view2, i3, iArr);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ void onNestedScroll(CoordinatorLayout coordinatorLayout, @NonNull View view, View view2, int i2, int i3, int i4, int i5, int i6, int[] iArr) {
            k(coordinatorLayout, (AppBarLayout) view, i5, iArr);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public void onRestoreInstanceState(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, Parcelable parcelable) {
            AppBarLayout appBarLayout = (AppBarLayout) view;
            if (!(parcelable instanceof SavedState)) {
                super.onRestoreInstanceState(coordinatorLayout, appBarLayout, parcelable);
                this.m = -1;
                return;
            }
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(coordinatorLayout, appBarLayout, savedState.getSuperState());
            this.m = savedState.a;
            this.o = savedState.f1979b;
            this.n = savedState.f1980c;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public Parcelable onSaveInstanceState(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view) {
            AppBarLayout appBarLayout = (AppBarLayout) view;
            Parcelable parcelableOnSaveInstanceState = super.onSaveInstanceState(coordinatorLayout, appBarLayout);
            int iA = a();
            int childCount = appBarLayout.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = appBarLayout.getChildAt(i2);
                int bottom = childAt.getBottom() + iA;
                if (childAt.getTop() + iA <= 0 && bottom >= 0) {
                    SavedState savedState = new SavedState(parcelableOnSaveInstanceState);
                    savedState.a = i2;
                    savedState.f1980c = bottom == appBarLayout.getTopInset() + ViewCompat.getMinimumHeight(childAt);
                    savedState.f1979b = bottom / childAt.getHeight();
                    return savedState;
                }
            }
            return parcelableOnSaveInstanceState;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull View view2, View view3, int i2, int i3) {
            return l(coordinatorLayout, (AppBarLayout) view, view2, i2, i3);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public void onStopNestedScroll(CoordinatorLayout coordinatorLayout, @NonNull View view, View view2, int i2) {
            AppBarLayout appBarLayout = (AppBarLayout) view;
            if (this.f1977k == 0 || i2 == 1) {
                m(coordinatorLayout, appBarLayout);
                if (appBarLayout.f1975l) {
                    appBarLayout.d(appBarLayout.e(view2));
                }
            }
            this.p = new WeakReference<>(view2);
        }

        public BaseBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.m = -1;
        }

        public static class SavedState extends AbsSavedState {
            public static final Parcelable.Creator<SavedState> CREATOR = new a();
            public int a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public float f1979b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public boolean f1980c;

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
                    return new SavedState(parcel, null);
                }
            }

            public SavedState(@NonNull Parcel parcel, ClassLoader classLoader) {
                super(parcel, classLoader);
                this.a = parcel.readInt();
                this.f1979b = parcel.readFloat();
                this.f1980c = parcel.readByte() != 0;
            }

            @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
            public void writeToParcel(@NonNull Parcel parcel, int i2) {
                super.writeToParcel(parcel, i2);
                parcel.writeInt(this.a);
                parcel.writeFloat(this.f1979b);
                parcel.writeByte(this.f1980c ? (byte) 1 : (byte) 0);
            }

            public SavedState(Parcelable parcelable) {
                super(parcelable);
            }
        }
    }

    public AppBarLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.appBarLayoutStyle);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -2);
    }

    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Illegal instructions before constructor call */
    public AppBarLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        int i3 = a;
        super(c.e.a.b.b0.a.a.a(context, attributeSet, i2, i3), attributeSet, i2);
        this.f1966c = -1;
        this.f1967d = -1;
        this.f1968e = -1;
        this.f1970g = 0;
        Context context2 = getContext();
        setOrientation(1);
        int i4 = Build.VERSION.SDK_INT;
        setOutlineProvider(ViewOutlineProvider.BOUNDS);
        Context context3 = getContext();
        TypedArray typedArrayD = c.e.a.b.q.g.d(context3, attributeSet, j.a, i2, i3, new int[0]);
        try {
            if (typedArrayD.hasValue(0)) {
                setStateListAnimator(AnimatorInflater.loadStateListAnimator(context3, typedArrayD.getResourceId(0, 0)));
            }
            typedArrayD.recycle();
            TypedArray typedArrayD2 = c.e.a.b.q.g.d(context2, attributeSet, R$styleable.AppBarLayout, i2, i3, new int[0]);
            ViewCompat.setBackground(this, typedArrayD2.getDrawable(R$styleable.AppBarLayout_android_background));
            if (getBackground() instanceof ColorDrawable) {
                ColorDrawable colorDrawable = (ColorDrawable) getBackground();
                MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable();
                materialShapeDrawable.q(ColorStateList.valueOf(colorDrawable.getColor()));
                materialShapeDrawable.f2333c.f2343b = new c.e.a.b.n.a(context2);
                materialShapeDrawable.C();
                ViewCompat.setBackground(this, materialShapeDrawable);
            }
            int i5 = R$styleable.AppBarLayout_expanded;
            if (typedArrayD2.hasValue(i5)) {
                c(typedArrayD2.getBoolean(i5, false), false, false);
            }
            if (typedArrayD2.hasValue(R$styleable.AppBarLayout_elevation)) {
                j.a(this, typedArrayD2.getDimensionPixelSize(r14, 0));
            }
            if (i4 >= 26) {
                int i6 = R$styleable.AppBarLayout_android_keyboardNavigationCluster;
                if (typedArrayD2.hasValue(i6)) {
                    setKeyboardNavigationCluster(typedArrayD2.getBoolean(i6, false));
                }
                int i7 = R$styleable.AppBarLayout_android_touchscreenBlocksFocus;
                if (typedArrayD2.hasValue(i7)) {
                    setTouchscreenBlocksFocus(typedArrayD2.getBoolean(i7, false));
                }
            }
            this.f1975l = typedArrayD2.getBoolean(R$styleable.AppBarLayout_liftOnScroll, false);
            this.m = typedArrayD2.getResourceId(R$styleable.AppBarLayout_liftOnScrollTargetViewId, -1);
            setStatusBarForeground(typedArrayD2.getDrawable(R$styleable.AppBarLayout_statusBarForeground));
            typedArrayD2.recycle();
            ViewCompat.setOnApplyWindowInsetsListener(this, new a());
        } catch (Throwable th) {
            typedArrayD.recycle();
            throw th;
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public void removeOnOffsetChangedListener(c cVar) {
        removeOnOffsetChangedListener((b) cVar);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public LinearLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public void addOnOffsetChangedListener(c cVar) {
        addOnOffsetChangedListener((b) cVar);
    }

    public static class LayoutParams extends LinearLayout.LayoutParams {
        public int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Interpolator f1981b;

        @Retention(RetentionPolicy.SOURCE)
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public @interface ScrollFlags {
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.a = 1;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.AppBarLayout_Layout);
            this.a = typedArrayObtainStyledAttributes.getInt(R$styleable.AppBarLayout_Layout_layout_scrollFlags, 0);
            int i2 = R$styleable.AppBarLayout_Layout_layout_scrollInterpolator;
            if (typedArrayObtainStyledAttributes.hasValue(i2)) {
                this.f1981b = AnimationUtils.loadInterpolator(context, typedArrayObtainStyledAttributes.getResourceId(i2, 0));
            }
            typedArrayObtainStyledAttributes.recycle();
        }

        public LayoutParams(int i2, int i3) {
            super(i2, i3);
            this.a = 1;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.a = 1;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.a = 1;
        }

        @RequiresApi(19)
        public LayoutParams(LinearLayout.LayoutParams layoutParams) {
            super(layoutParams);
            this.a = 1;
        }
    }
}

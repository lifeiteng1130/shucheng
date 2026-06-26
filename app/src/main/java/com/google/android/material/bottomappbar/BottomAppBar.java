package com.google.android.material.bottomappbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Dimension;
import androidx.annotation.MenuRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.motion.widget.Key;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.customview.view.AbsSavedState;
import c.b.a.m.f;
import c.e.a.b.a.j;
import c.e.a.b.q.g;
import c.e.a.b.q.k;
import c.e.a.b.q.m;
import c.e.a.b.q.n;
import c.e.a.b.w.l;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.shape.MaterialShapeDrawable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class BottomAppBar extends Toolbar implements CoordinatorLayout.AttachedBehavior {
    public static final int a = R$style.Widget_MaterialComponents_BottomAppBar;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f2031b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final MaterialShapeDrawable f2032c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public Animator f2033d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    public Animator f2034e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f2035f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f2036g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f2037h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f2038i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f2039j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f2040k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f2041l;

    @MenuRes
    public int m;
    public boolean n;
    public boolean o;
    public Behavior p;
    public int q;
    public int r;
    public int s;

    @NonNull
    public AnimatorListenerAdapter t;

    @NonNull
    public j<FloatingActionButton> u;

    @Retention(RetentionPolicy.SOURCE)
    public @interface FabAlignmentMode {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface FabAnimationMode {
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        public int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f2046b;

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

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@NonNull Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.a);
            parcel.writeInt(this.f2046b ? 1 : 0);
        }

        public SavedState(@NonNull Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.a = parcel.readInt();
            this.f2046b = parcel.readInt() != 0;
        }
    }

    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            BottomAppBar bottomAppBar = BottomAppBar.this;
            if (bottomAppBar.n) {
                return;
            }
            bottomAppBar.m(bottomAppBar.f2035f, bottomAppBar.o);
        }
    }

    public class b implements j<FloatingActionButton> {
        public b() {
        }
    }

    public class c implements m {
        public c() {
        }

        @Override // c.e.a.b.q.m
        @NonNull
        public WindowInsetsCompat a(View view, @NonNull WindowInsetsCompat windowInsetsCompat, @NonNull n nVar) {
            boolean z;
            BottomAppBar bottomAppBar = BottomAppBar.this;
            if (bottomAppBar.f2038i) {
                bottomAppBar.q = windowInsetsCompat.getSystemWindowInsetBottom();
            }
            BottomAppBar bottomAppBar2 = BottomAppBar.this;
            boolean z2 = false;
            if (bottomAppBar2.f2039j) {
                z = bottomAppBar2.s != windowInsetsCompat.getSystemWindowInsetLeft();
                BottomAppBar.this.s = windowInsetsCompat.getSystemWindowInsetLeft();
            } else {
                z = false;
            }
            BottomAppBar bottomAppBar3 = BottomAppBar.this;
            if (bottomAppBar3.f2040k) {
                boolean z3 = bottomAppBar3.r != windowInsetsCompat.getSystemWindowInsetRight();
                BottomAppBar.this.r = windowInsetsCompat.getSystemWindowInsetRight();
                z2 = z3;
            }
            if (z || z2) {
                BottomAppBar bottomAppBar4 = BottomAppBar.this;
                Animator animator = bottomAppBar4.f2034e;
                if (animator != null) {
                    animator.cancel();
                }
                Animator animator2 = bottomAppBar4.f2033d;
                if (animator2 != null) {
                    animator2.cancel();
                }
                BottomAppBar.this.o();
                BottomAppBar.this.n();
            }
            return windowInsetsCompat;
        }
    }

    public class d extends FloatingActionButton.a {
        public final /* synthetic */ int a;

        public class a extends FloatingActionButton.a {
            public a() {
            }

            @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.a
            public void b(FloatingActionButton floatingActionButton) {
                BottomAppBar.a(BottomAppBar.this);
            }
        }

        public d(int i2) {
            this.a = i2;
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.a
        public void a(@NonNull FloatingActionButton floatingActionButton) {
            BottomAppBar bottomAppBar = BottomAppBar.this;
            int i2 = this.a;
            int i3 = BottomAppBar.a;
            floatingActionButton.setTranslationX(bottomAppBar.k(i2));
            floatingActionButton.show(new a());
        }
    }

    public class e extends AnimatorListenerAdapter {
        public e() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BottomAppBar.a(BottomAppBar.this);
            BottomAppBar bottomAppBar = BottomAppBar.this;
            bottomAppBar.n = false;
            bottomAppBar.f2034e = null;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            BottomAppBar.this.f2041l++;
        }
    }

    public BottomAppBar(@NonNull Context context) {
        this(context, null, 0);
    }

    public static void a(BottomAppBar bottomAppBar) {
        bottomAppBar.f2041l--;
    }

    @Nullable
    private ActionMenuView getActionMenuView() {
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if (childAt instanceof ActionMenuView) {
                return (ActionMenuView) childAt;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getBottomInset() {
        return this.q;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float getFabTranslationX() {
        return k(this.f2035f);
    }

    private float getFabTranslationY() {
        return -getTopEdgeTreatment().f949d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getLeftInset() {
        return this.s;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getRightInset() {
        return this.r;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public c.e.a.b.e.e getTopEdgeTreatment() {
        return (c.e.a.b.e.e) this.f2032c.f2333c.a.f1235j;
    }

    public void g(int i2) {
        FloatingActionButton floatingActionButtonH = h();
        if (floatingActionButtonH == null || floatingActionButtonH.j()) {
            return;
        }
        this.f2041l++;
        floatingActionButtonH.hide(new d(i2));
    }

    @Nullable
    public ColorStateList getBackgroundTint() {
        return this.f2032c.f2333c.f2348g;
    }

    @Dimension
    public float getCradleVerticalOffset() {
        return getTopEdgeTreatment().f949d;
    }

    public int getFabAlignmentMode() {
        return this.f2035f;
    }

    public int getFabAnimationMode() {
        return this.f2036g;
    }

    public float getFabCradleMargin() {
        return getTopEdgeTreatment().f947b;
    }

    @Dimension
    public float getFabCradleRoundedCornerRadius() {
        return getTopEdgeTreatment().a;
    }

    public boolean getHideOnScroll() {
        return this.f2037h;
    }

    @Nullable
    public final FloatingActionButton h() {
        View viewI = i();
        if (viewI instanceof FloatingActionButton) {
            return (FloatingActionButton) viewI;
        }
        return null;
    }

    @Nullable
    public final View i() {
        if (!(getParent() instanceof CoordinatorLayout)) {
            return null;
        }
        for (View view : ((CoordinatorLayout) getParent()).getDependents(this)) {
            if ((view instanceof FloatingActionButton) || (view instanceof ExtendedFloatingActionButton)) {
                return view;
            }
        }
        return null;
    }

    public int j(@NonNull ActionMenuView actionMenuView, int i2, boolean z) {
        if (i2 != 1 || !z) {
            return 0;
        }
        boolean zC3 = f.C3(this);
        int measuredWidth = zC3 ? getMeasuredWidth() : 0;
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            View childAt = getChildAt(i3);
            if ((childAt.getLayoutParams() instanceof Toolbar.LayoutParams) && (((Toolbar.LayoutParams) childAt.getLayoutParams()).gravity & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK) == 8388611) {
                measuredWidth = zC3 ? Math.min(measuredWidth, childAt.getLeft()) : Math.max(measuredWidth, childAt.getRight());
            }
        }
        return measuredWidth - ((zC3 ? actionMenuView.getRight() : actionMenuView.getLeft()) + (zC3 ? this.r : -this.s));
    }

    public final float k(int i2) {
        boolean zC3 = f.C3(this);
        if (i2 == 1) {
            return ((getMeasuredWidth() / 2) - (this.f2031b + (zC3 ? this.s : this.r))) * (zC3 ? -1 : 1);
        }
        return 0.0f;
    }

    public final boolean l() {
        FloatingActionButton floatingActionButtonH = h();
        return floatingActionButtonH != null && floatingActionButtonH.k();
    }

    public final void m(int i2, boolean z) {
        if (!ViewCompat.isLaidOut(this)) {
            this.n = false;
            int i3 = this.m;
            if (i3 != 0) {
                this.m = 0;
                getMenu().clear();
                inflateMenu(i3);
                return;
            }
            return;
        }
        Animator animator = this.f2034e;
        if (animator != null) {
            animator.cancel();
        }
        ArrayList arrayList = new ArrayList();
        if (!l()) {
            i2 = 0;
            z = false;
        }
        ActionMenuView actionMenuView = getActionMenuView();
        if (actionMenuView != null) {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(actionMenuView, Key.ALPHA, 1.0f);
            if (Math.abs(actionMenuView.getTranslationX() - j(actionMenuView, i2, z)) > 1.0f) {
                ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(actionMenuView, Key.ALPHA, 0.0f);
                objectAnimatorOfFloat2.addListener(new c.e.a.b.e.b(this, actionMenuView, i2, z));
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.setDuration(150L);
                animatorSet.playSequentially(objectAnimatorOfFloat2, objectAnimatorOfFloat);
                arrayList.add(animatorSet);
            } else if (actionMenuView.getAlpha() < 1.0f) {
                arrayList.add(objectAnimatorOfFloat);
            }
        }
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.playTogether(arrayList);
        this.f2034e = animatorSet2;
        animatorSet2.addListener(new e());
        this.f2034e.start();
    }

    public final void n() {
        ActionMenuView actionMenuView = getActionMenuView();
        if (actionMenuView == null || this.f2034e != null) {
            return;
        }
        actionMenuView.setAlpha(1.0f);
        if (l()) {
            actionMenuView.setTranslationX(j(actionMenuView, this.f2035f, this.o));
        } else {
            actionMenuView.setTranslationX(j(actionMenuView, 0, false));
        }
    }

    public final void o() {
        getTopEdgeTreatment().f950e = getFabTranslationX();
        View viewI = i();
        this.f2032c.r((this.o && l()) ? 1.0f : 0.0f);
        if (viewI != null) {
            viewI.setTranslationY(getFabTranslationY());
            viewI.setTranslationX(getFabTranslationX());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        f.e5(this, this.f2032c);
        if (getParent() instanceof ViewGroup) {
            ((ViewGroup) getParent()).setClipChildren(false);
        }
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        if (z) {
            Animator animator = this.f2034e;
            if (animator != null) {
                animator.cancel();
            }
            Animator animator2 = this.f2033d;
            if (animator2 != null) {
                animator2.cancel();
            }
            o();
        }
        n();
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f2035f = savedState.a;
        this.o = savedState.f2046b;
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    @NonNull
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.a = this.f2035f;
        savedState.f2046b = this.o;
        return savedState;
    }

    public boolean p(@Px int i2) {
        float f2 = i2;
        if (f2 == getTopEdgeTreatment().f948c) {
            return false;
        }
        getTopEdgeTreatment().f948c = f2;
        this.f2032c.invalidateSelf();
        return true;
    }

    public void setBackgroundTint(@Nullable ColorStateList colorStateList) {
        DrawableCompat.setTintList(this.f2032c, colorStateList);
    }

    public void setCradleVerticalOffset(@Dimension float f2) {
        if (f2 != getCradleVerticalOffset()) {
            getTopEdgeTreatment().c(f2);
            this.f2032c.invalidateSelf();
            o();
        }
    }

    @Override // android.view.View
    public void setElevation(float f2) {
        MaterialShapeDrawable materialShapeDrawable = this.f2032c;
        MaterialShapeDrawable.b bVar = materialShapeDrawable.f2333c;
        if (bVar.o != f2) {
            bVar.o = f2;
            materialShapeDrawable.C();
        }
        MaterialShapeDrawable materialShapeDrawable2 = this.f2032c;
        int iJ = materialShapeDrawable2.f2333c.r - materialShapeDrawable2.j();
        Behavior behavior = getBehavior();
        behavior.f2018c = iJ;
        if (behavior.f2017b == 1) {
            setTranslationY(behavior.a + iJ);
        }
    }

    public void setFabAlignmentMode(int i2) {
        this.m = 0;
        this.n = true;
        m(i2, this.o);
        if (this.f2035f != i2 && ViewCompat.isLaidOut(this)) {
            Animator animator = this.f2033d;
            if (animator != null) {
                animator.cancel();
            }
            ArrayList arrayList = new ArrayList();
            if (this.f2036g == 1) {
                ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(h(), Key.TRANSLATION_X, k(i2));
                objectAnimatorOfFloat.setDuration(300L);
                arrayList.add(objectAnimatorOfFloat);
            } else {
                g(i2);
            }
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(arrayList);
            this.f2033d = animatorSet;
            animatorSet.addListener(new c.e.a.b.e.a(this));
            this.f2033d.start();
        }
        this.f2035f = i2;
    }

    public void setFabAnimationMode(int i2) {
        this.f2036g = i2;
    }

    public void setFabCradleMargin(@Dimension float f2) {
        if (f2 != getFabCradleMargin()) {
            getTopEdgeTreatment().f947b = f2;
            this.f2032c.invalidateSelf();
        }
    }

    public void setFabCradleRoundedCornerRadius(@Dimension float f2) {
        if (f2 != getFabCradleRoundedCornerRadius()) {
            getTopEdgeTreatment().a = f2;
            this.f2032c.invalidateSelf();
        }
    }

    public void setHideOnScroll(boolean z) {
        this.f2037h = z;
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setSubtitle(CharSequence charSequence) {
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setTitle(CharSequence charSequence) {
    }

    public BottomAppBar(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.bottomAppBarStyle);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.AttachedBehavior
    @NonNull
    public Behavior getBehavior() {
        if (this.p == null) {
            this.p = new Behavior();
        }
        return this.p;
    }

    public static class Behavior extends HideBottomViewOnScrollBehavior<BottomAppBar> {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @NonNull
        public final Rect f2042e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public WeakReference<BottomAppBar> f2043f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f2044g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final View.OnLayoutChangeListener f2045h;

        public class a implements View.OnLayoutChangeListener {
            public a() {
            }

            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
                BottomAppBar bottomAppBar = Behavior.this.f2043f.get();
                if (bottomAppBar == null || !(view instanceof FloatingActionButton)) {
                    view.removeOnLayoutChangeListener(this);
                    return;
                }
                FloatingActionButton floatingActionButton = (FloatingActionButton) view;
                Rect rect = Behavior.this.f2042e;
                rect.set(0, 0, floatingActionButton.getMeasuredWidth(), floatingActionButton.getMeasuredHeight());
                floatingActionButton.l(rect);
                int iHeight = Behavior.this.f2042e.height();
                bottomAppBar.p(iHeight);
                CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) view.getLayoutParams();
                if (Behavior.this.f2044g == 0) {
                    ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = bottomAppBar.getBottomInset() + (bottomAppBar.getResources().getDimensionPixelOffset(R$dimen.mtrl_bottomappbar_fab_bottom_margin) - ((floatingActionButton.getMeasuredHeight() - iHeight) / 2));
                    ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = bottomAppBar.getLeftInset();
                    ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = bottomAppBar.getRightInset();
                    if (f.C3(floatingActionButton)) {
                        ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin += bottomAppBar.f2031b;
                    } else {
                        ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin += bottomAppBar.f2031b;
                    }
                }
            }
        }

        public Behavior() {
            this.f2045h = new a();
            this.f2042e = new Rect();
        }

        @Override // com.google.android.material.behavior.HideBottomViewOnScrollBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean onLayoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, int i2) {
            BottomAppBar bottomAppBar = (BottomAppBar) view;
            this.f2043f = new WeakReference<>(bottomAppBar);
            int i3 = BottomAppBar.a;
            View viewI = bottomAppBar.i();
            if (viewI != null && !ViewCompat.isLaidOut(viewI)) {
                CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) viewI.getLayoutParams();
                layoutParams.anchorGravity = 49;
                this.f2044g = ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                if (viewI instanceof FloatingActionButton) {
                    FloatingActionButton floatingActionButton = (FloatingActionButton) viewI;
                    floatingActionButton.addOnLayoutChangeListener(this.f2045h);
                    floatingActionButton.d(bottomAppBar.t);
                    floatingActionButton.e(new c.e.a.b.e.d(bottomAppBar));
                    floatingActionButton.f(bottomAppBar.u);
                }
                bottomAppBar.o();
            }
            coordinatorLayout.onLayoutChild(bottomAppBar, i2);
            return super.onLayoutChild(coordinatorLayout, bottomAppBar, i2);
        }

        @Override // com.google.android.material.behavior.HideBottomViewOnScrollBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull View view2, @NonNull View view3, int i2, int i3) {
            if (((BottomAppBar) view).getHideOnScroll()) {
                if (i2 == 2) {
                    return true;
                }
            }
            return false;
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f2045h = new a();
            this.f2042e = new Rect();
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public BottomAppBar(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        int i3 = a;
        super(c.e.a.b.b0.a.a.a(context, attributeSet, i2, i3), attributeSet, i2);
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable();
        this.f2032c = materialShapeDrawable;
        this.f2041l = 0;
        this.m = 0;
        this.n = false;
        this.o = true;
        this.t = new a();
        this.u = new b();
        Context context2 = getContext();
        TypedArray typedArrayD = g.d(context2, attributeSet, R$styleable.BottomAppBar, i2, i3, new int[0]);
        ColorStateList colorStateListA2 = f.a2(context2, typedArrayD, R$styleable.BottomAppBar_backgroundTint);
        int dimensionPixelSize = typedArrayD.getDimensionPixelSize(R$styleable.BottomAppBar_elevation, 0);
        float dimensionPixelOffset = typedArrayD.getDimensionPixelOffset(R$styleable.BottomAppBar_fabCradleMargin, 0);
        float dimensionPixelOffset2 = typedArrayD.getDimensionPixelOffset(R$styleable.BottomAppBar_fabCradleRoundedCornerRadius, 0);
        float dimensionPixelOffset3 = typedArrayD.getDimensionPixelOffset(R$styleable.BottomAppBar_fabCradleVerticalOffset, 0);
        this.f2035f = typedArrayD.getInt(R$styleable.BottomAppBar_fabAlignmentMode, 0);
        this.f2036g = typedArrayD.getInt(R$styleable.BottomAppBar_fabAnimationMode, 0);
        this.f2037h = typedArrayD.getBoolean(R$styleable.BottomAppBar_hideOnScroll, false);
        this.f2038i = typedArrayD.getBoolean(R$styleable.BottomAppBar_paddingBottomSystemWindowInsets, false);
        this.f2039j = typedArrayD.getBoolean(R$styleable.BottomAppBar_paddingLeftSystemWindowInsets, false);
        this.f2040k = typedArrayD.getBoolean(R$styleable.BottomAppBar_paddingRightSystemWindowInsets, false);
        typedArrayD.recycle();
        this.f2031b = getResources().getDimensionPixelOffset(R$dimen.mtrl_bottomappbar_fabOffsetEndMode);
        c.e.a.b.e.e eVar = new c.e.a.b.e.e(dimensionPixelOffset, dimensionPixelOffset2, dimensionPixelOffset3);
        l.b bVar = new l.b();
        bVar.f1245i = eVar;
        materialShapeDrawable.f2333c.a = bVar.a();
        materialShapeDrawable.invalidateSelf();
        materialShapeDrawable.u(2);
        materialShapeDrawable.s(Paint.Style.FILL);
        materialShapeDrawable.f2333c.f2343b = new c.e.a.b.n.a(context2);
        materialShapeDrawable.C();
        setElevation(dimensionPixelSize);
        DrawableCompat.setTintList(materialShapeDrawable, colorStateListA2);
        ViewCompat.setBackground(this, materialShapeDrawable);
        c cVar = new c();
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.Insets, i2, i3);
        boolean z = typedArrayObtainStyledAttributes.getBoolean(R$styleable.Insets_paddingBottomSystemWindowInsets, false);
        boolean z2 = typedArrayObtainStyledAttributes.getBoolean(R$styleable.Insets_paddingLeftSystemWindowInsets, false);
        boolean z3 = typedArrayObtainStyledAttributes.getBoolean(R$styleable.Insets_paddingRightSystemWindowInsets, false);
        typedArrayObtainStyledAttributes.recycle();
        f.u1(this, new k(z, z2, z3, cVar));
    }
}

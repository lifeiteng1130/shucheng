package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import androidx.annotation.AnimatorRes;
import androidx.annotation.ColorInt;
import androidx.annotation.DimenRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.appcompat.widget.AppCompatImageHelper;
import androidx.collection.SimpleArrayMap;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.util.Preconditions;
import androidx.core.view.TintableBackgroundView;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TintableImageSourceView;
import c.e.a.b.a.g;
import c.e.a.b.a.j;
import c.e.a.b.p.e;
import c.e.a.b.p.f;
import c.e.a.b.p.h;
import c.e.a.b.p.k;
import c.e.a.b.w.l;
import c.e.a.b.w.p;
import com.google.android.material.R$animator;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.internal.VisibilityAwareImageButton;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.stateful.ExtendableSavedState;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class FloatingActionButton extends VisibilityAwareImageButton implements TintableBackgroundView, TintableImageSourceView, c.e.a.b.o.a, p, CoordinatorLayout.AttachedBehavior {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f2244b = R$style.Widget_Design_FloatingActionButton;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public ColorStateList f2245c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public PorterDuff.Mode f2246d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    public ColorStateList f2247e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    public PorterDuff.Mode f2248f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    public ColorStateList f2249g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f2250h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f2251i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f2252j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f2253k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f2254l;
    public boolean m;
    public final Rect n;
    public final Rect o;

    @NonNull
    public final AppCompatImageHelper p;

    @NonNull
    public final c.e.a.b.o.b q;
    public h r;

    public static class Behavior extends BaseBehavior<FloatingActionButton> {
        public Behavior() {
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior
        @VisibleForTesting
        public /* bridge */ /* synthetic */ void setInternalAutoHideListener(a aVar) {
            super.setInternalAutoHideListener(aVar);
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface Size {
    }

    public static abstract class a {
        public void a(FloatingActionButton floatingActionButton) {
        }

        public void b(FloatingActionButton floatingActionButton) {
        }
    }

    public class b implements c.e.a.b.v.b {
        public b() {
        }
    }

    public class c<T extends FloatingActionButton> implements h.e {

        @NonNull
        public final j<T> a;

        public c(@NonNull j<T> jVar) {
            this.a = jVar;
        }

        @Override // c.e.a.b.p.h.e
        public void a() {
            j<T> jVar = this.a;
            FloatingActionButton floatingActionButton = FloatingActionButton.this;
            BottomAppBar.b bVar = (BottomAppBar.b) jVar;
            Objects.requireNonNull(bVar);
            float translationX = floatingActionButton.getTranslationX();
            if (BottomAppBar.this.getTopEdgeTreatment().f950e != translationX) {
                BottomAppBar.this.getTopEdgeTreatment().f950e = translationX;
                BottomAppBar.this.f2032c.invalidateSelf();
            }
            float fMax = Math.max(0.0f, -floatingActionButton.getTranslationY());
            if (BottomAppBar.this.getTopEdgeTreatment().f949d != fMax) {
                BottomAppBar.this.getTopEdgeTreatment().c(fMax);
                BottomAppBar.this.f2032c.invalidateSelf();
            }
            BottomAppBar.this.f2032c.r(floatingActionButton.getVisibility() == 0 ? floatingActionButton.getScaleY() : 0.0f);
        }

        @Override // c.e.a.b.p.h.e
        public void b() {
            j<T> jVar = this.a;
            FloatingActionButton floatingActionButton = FloatingActionButton.this;
            BottomAppBar.b bVar = (BottomAppBar.b) jVar;
            Objects.requireNonNull(bVar);
            BottomAppBar.this.f2032c.r(floatingActionButton.getVisibility() == 0 ? floatingActionButton.getScaleY() : 0.0f);
        }

        public boolean equals(@Nullable Object obj) {
            return (obj instanceof c) && ((c) obj).a.equals(this.a);
        }

        public int hashCode() {
            return this.a.hashCode();
        }
    }

    public FloatingActionButton(@NonNull Context context) {
        this(context, null);
    }

    private h getImpl() {
        if (this.r == null) {
            this.r = new k(this, new b());
        }
        return this.r;
    }

    public static int n(int i2, int i3) {
        int mode = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i3);
        if (mode == Integer.MIN_VALUE) {
            return Math.min(i2, size);
        }
        if (mode == 0) {
            return i2;
        }
        if (mode == 1073741824) {
            return size;
        }
        throw new IllegalArgumentException();
    }

    @Override // c.e.a.b.o.a
    public boolean a() {
        return this.q.f1050b;
    }

    public void d(@NonNull Animator.AnimatorListener animatorListener) {
        h impl = getImpl();
        if (impl.D == null) {
            impl.D = new ArrayList<>();
        }
        impl.D.add(animatorListener);
    }

    @Override // android.widget.ImageView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        getImpl().k(getDrawableState());
    }

    public void e(@NonNull Animator.AnimatorListener animatorListener) {
        h impl = getImpl();
        if (impl.C == null) {
            impl.C = new ArrayList<>();
        }
        impl.C.add(animatorListener);
    }

    public void f(@NonNull j<? extends FloatingActionButton> jVar) {
        h impl = getImpl();
        c cVar = new c(jVar);
        if (impl.E == null) {
            impl.E = new ArrayList<>();
        }
        impl.E.add(cVar);
    }

    @Deprecated
    public boolean g(@NonNull Rect rect) {
        if (!ViewCompat.isLaidOut(this)) {
            return false;
        }
        rect.set(0, 0, getWidth(), getHeight());
        l(rect);
        return true;
    }

    @Override // android.view.View
    @Nullable
    public ColorStateList getBackgroundTintList() {
        return this.f2245c;
    }

    @Override // android.view.View
    @Nullable
    public PorterDuff.Mode getBackgroundTintMode() {
        return this.f2246d;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.AttachedBehavior
    @NonNull
    public CoordinatorLayout.Behavior<FloatingActionButton> getBehavior() {
        return new Behavior();
    }

    public float getCompatElevation() {
        return getImpl().d();
    }

    public float getCompatHoveredFocusedTranslationZ() {
        return getImpl().p;
    }

    public float getCompatPressedTranslationZ() {
        return getImpl().q;
    }

    @Nullable
    public Drawable getContentBackground() {
        return getImpl().f1085l;
    }

    @Px
    public int getCustomSize() {
        return this.f2252j;
    }

    public int getExpandedComponentIdHint() {
        return this.q.f1051c;
    }

    @Nullable
    public g getHideMotionSpec() {
        return getImpl().x;
    }

    @ColorInt
    @Deprecated
    public int getRippleColor() {
        ColorStateList colorStateList = this.f2249g;
        if (colorStateList != null) {
            return colorStateList.getDefaultColor();
        }
        return 0;
    }

    @Nullable
    public ColorStateList getRippleColorStateList() {
        return this.f2249g;
    }

    @Override // c.e.a.b.w.p
    @NonNull
    public l getShapeAppearanceModel() {
        return (l) Preconditions.checkNotNull(getImpl().f1081h);
    }

    @Nullable
    public g getShowMotionSpec() {
        return getImpl().w;
    }

    public int getSize() {
        return this.f2251i;
    }

    public int getSizeDimension() {
        return h(this.f2251i);
    }

    @Override // androidx.core.view.TintableBackgroundView
    @Nullable
    public ColorStateList getSupportBackgroundTintList() {
        return getBackgroundTintList();
    }

    @Override // androidx.core.view.TintableBackgroundView
    @Nullable
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        return getBackgroundTintMode();
    }

    @Override // androidx.core.widget.TintableImageSourceView
    @Nullable
    public ColorStateList getSupportImageTintList() {
        return this.f2247e;
    }

    @Override // androidx.core.widget.TintableImageSourceView
    @Nullable
    public PorterDuff.Mode getSupportImageTintMode() {
        return this.f2248f;
    }

    public boolean getUseCompatPadding() {
        return this.m;
    }

    public final int h(int i2) {
        int i3 = this.f2252j;
        if (i3 != 0) {
            return i3;
        }
        Resources resources = getResources();
        return i2 != -1 ? i2 != 1 ? resources.getDimensionPixelSize(R$dimen.design_fab_size_normal) : resources.getDimensionPixelSize(R$dimen.design_fab_size_mini) : Math.max(resources.getConfiguration().screenWidthDp, resources.getConfiguration().screenHeightDp) < 470 ? h(1) : h(0);
    }

    public void hide(@Nullable a aVar) {
        i(aVar, true);
    }

    public void i(@Nullable a aVar, boolean z) {
        h impl = getImpl();
        e eVar = aVar == null ? null : new e(this, aVar);
        if (impl.g()) {
            return;
        }
        Animator animator = impl.v;
        if (animator != null) {
            animator.cancel();
        }
        if (!impl.s()) {
            impl.F.b(z ? 8 : 4, z);
            if (eVar != null) {
                eVar.a.a(eVar.f1069b);
                return;
            }
            return;
        }
        g gVar = impl.x;
        if (gVar == null) {
            if (impl.u == null) {
                impl.u = g.b(impl.F.getContext(), R$animator.design_fab_hide_motion_spec);
            }
            gVar = (g) Preconditions.checkNotNull(impl.u);
        }
        AnimatorSet animatorSetB = impl.b(gVar, 0.0f, 0.0f, 0.0f);
        animatorSetB.addListener(new f(impl, z, eVar));
        ArrayList<Animator.AnimatorListener> arrayList = impl.D;
        if (arrayList != null) {
            Iterator<Animator.AnimatorListener> it = arrayList.iterator();
            while (it.hasNext()) {
                animatorSetB.addListener(it.next());
            }
        }
        animatorSetB.start();
    }

    public boolean j() {
        return getImpl().g();
    }

    @Override // android.widget.ImageView, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        getImpl().i();
    }

    public boolean k() {
        return getImpl().h();
    }

    public final void l(@NonNull Rect rect) {
        int i2 = rect.left;
        Rect rect2 = this.n;
        rect.left = i2 + rect2.left;
        rect.top += rect2.top;
        rect.right -= rect2.right;
        rect.bottom -= rect2.bottom;
    }

    public final void m() {
        Drawable drawable = getDrawable();
        if (drawable == null) {
            return;
        }
        ColorStateList colorStateList = this.f2247e;
        if (colorStateList == null) {
            DrawableCompat.clearColorFilter(drawable);
            return;
        }
        int colorForState = colorStateList.getColorForState(getDrawableState(), 0);
        PorterDuff.Mode mode = this.f2248f;
        if (mode == null) {
            mode = PorterDuff.Mode.SRC_IN;
        }
        drawable.mutate().setColorFilter(AppCompatDrawableManager.getPorterDuffColorFilter(colorForState, mode));
    }

    public void o(@Nullable a aVar, boolean z) {
        h impl = getImpl();
        e eVar = aVar == null ? null : new e(this, aVar);
        if (impl.h()) {
            return;
        }
        Animator animator = impl.v;
        if (animator != null) {
            animator.cancel();
        }
        if (!impl.s()) {
            impl.F.b(0, z);
            impl.F.setAlpha(1.0f);
            impl.F.setScaleY(1.0f);
            impl.F.setScaleX(1.0f);
            impl.o(1.0f);
            if (eVar != null) {
                eVar.a.b(eVar.f1069b);
                return;
            }
            return;
        }
        if (impl.F.getVisibility() != 0) {
            impl.F.setAlpha(0.0f);
            impl.F.setScaleY(0.0f);
            impl.F.setScaleX(0.0f);
            impl.o(0.0f);
        }
        g gVar = impl.w;
        if (gVar == null) {
            if (impl.t == null) {
                impl.t = g.b(impl.F.getContext(), R$animator.design_fab_show_motion_spec);
            }
            gVar = (g) Preconditions.checkNotNull(impl.t);
        }
        AnimatorSet animatorSetB = impl.b(gVar, 1.0f, 1.0f, 1.0f);
        animatorSetB.addListener(new c.e.a.b.p.g(impl, z, eVar));
        ArrayList<Animator.AnimatorListener> arrayList = impl.C;
        if (arrayList != null) {
            Iterator<Animator.AnimatorListener> it = arrayList.iterator();
            while (it.hasNext()) {
                animatorSetB.addListener(it.next());
            }
        }
        animatorSetB.start();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        h impl = getImpl();
        MaterialShapeDrawable materialShapeDrawable = impl.f1082i;
        if (materialShapeDrawable != null) {
            c.b.a.m.f.e5(impl.F, materialShapeDrawable);
        }
        if (!(impl instanceof k)) {
            ViewTreeObserver viewTreeObserver = impl.F.getViewTreeObserver();
            if (impl.L == null) {
                impl.L = new c.e.a.b.p.j(impl);
            }
            viewTreeObserver.addOnPreDrawListener(impl.L);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        h impl = getImpl();
        ViewTreeObserver viewTreeObserver = impl.F.getViewTreeObserver();
        ViewTreeObserver.OnPreDrawListener onPreDrawListener = impl.L;
        if (onPreDrawListener != null) {
            viewTreeObserver.removeOnPreDrawListener(onPreDrawListener);
            impl.L = null;
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i2, int i3) {
        int sizeDimension = getSizeDimension();
        this.f2253k = (sizeDimension - this.f2254l) / 2;
        getImpl().v();
        int iMin = Math.min(n(sizeDimension, i2), n(sizeDimension, i3));
        Rect rect = this.n;
        setMeasuredDimension(rect.left + iMin + rect.right, iMin + rect.top + rect.bottom);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof ExtendableSavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        ExtendableSavedState extendableSavedState = (ExtendableSavedState) parcelable;
        super.onRestoreInstanceState(extendableSavedState.getSuperState());
        c.e.a.b.o.b bVar = this.q;
        Bundle bundle = (Bundle) Preconditions.checkNotNull(extendableSavedState.a.get("expandableWidgetHelper"));
        Objects.requireNonNull(bVar);
        bVar.f1050b = bundle.getBoolean("expanded", false);
        bVar.f1051c = bundle.getInt("expandedComponentIdHint", 0);
        if (bVar.f1050b) {
            ViewParent parent = bVar.a.getParent();
            if (parent instanceof CoordinatorLayout) {
                ((CoordinatorLayout) parent).dispatchDependentViewsChanged(bVar.a);
            }
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        Parcelable parcelableOnSaveInstanceState = super.onSaveInstanceState();
        if (parcelableOnSaveInstanceState == null) {
            parcelableOnSaveInstanceState = new Bundle();
        }
        ExtendableSavedState extendableSavedState = new ExtendableSavedState(parcelableOnSaveInstanceState);
        SimpleArrayMap<String, Bundle> simpleArrayMap = extendableSavedState.a;
        c.e.a.b.o.b bVar = this.q;
        Objects.requireNonNull(bVar);
        Bundle bundle = new Bundle();
        bundle.putBoolean("expanded", bVar.f1050b);
        bundle.putInt("expandedComponentIdHint", bVar.f1051c);
        simpleArrayMap.put("expandableWidgetHelper", bundle);
        return extendableSavedState;
    }

    @Override // android.view.View
    public boolean onTouchEvent(@NonNull MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0 && g(this.o) && !this.o.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i2) {
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
    }

    @Override // android.view.View
    public void setBackgroundResource(int i2) {
    }

    @Override // android.view.View
    public void setBackgroundTintList(@Nullable ColorStateList colorStateList) {
        if (this.f2245c != colorStateList) {
            this.f2245c = colorStateList;
            h impl = getImpl();
            MaterialShapeDrawable materialShapeDrawable = impl.f1082i;
            if (materialShapeDrawable != null) {
                materialShapeDrawable.setTintList(colorStateList);
            }
            c.e.a.b.p.c cVar = impl.f1084k;
            if (cVar != null) {
                cVar.b(colorStateList);
            }
        }
    }

    @Override // android.view.View
    public void setBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        if (this.f2246d != mode) {
            this.f2246d = mode;
            MaterialShapeDrawable materialShapeDrawable = getImpl().f1082i;
            if (materialShapeDrawable != null) {
                materialShapeDrawable.setTintMode(mode);
            }
        }
    }

    public void setCompatElevation(float f2) {
        h impl = getImpl();
        if (impl.o != f2) {
            impl.o = f2;
            impl.l(f2, impl.p, impl.q);
        }
    }

    public void setCompatElevationResource(@DimenRes int i2) {
        setCompatElevation(getResources().getDimension(i2));
    }

    public void setCompatHoveredFocusedTranslationZ(float f2) {
        h impl = getImpl();
        if (impl.p != f2) {
            impl.p = f2;
            impl.l(impl.o, f2, impl.q);
        }
    }

    public void setCompatHoveredFocusedTranslationZResource(@DimenRes int i2) {
        setCompatHoveredFocusedTranslationZ(getResources().getDimension(i2));
    }

    public void setCompatPressedTranslationZ(float f2) {
        h impl = getImpl();
        if (impl.q != f2) {
            impl.q = f2;
            impl.l(impl.o, impl.p, f2);
        }
    }

    public void setCompatPressedTranslationZResource(@DimenRes int i2) {
        setCompatPressedTranslationZ(getResources().getDimension(i2));
    }

    public void setCustomSize(@Px int i2) {
        if (i2 < 0) {
            throw new IllegalArgumentException("Custom size must be non-negative");
        }
        if (i2 != this.f2252j) {
            this.f2252j = i2;
            requestLayout();
        }
    }

    @Override // android.view.View
    @RequiresApi(21)
    public void setElevation(float f2) {
        super.setElevation(f2);
        getImpl().w(f2);
    }

    public void setEnsureMinTouchTargetSize(boolean z) {
        if (z != getImpl().m) {
            getImpl().m = z;
            requestLayout();
        }
    }

    public void setExpandedComponentIdHint(@IdRes int i2) {
        this.q.f1051c = i2;
    }

    public void setHideMotionSpec(@Nullable g gVar) {
        getImpl().x = gVar;
    }

    public void setHideMotionSpecResource(@AnimatorRes int i2) {
        setHideMotionSpec(g.b(getContext(), i2));
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(@Nullable Drawable drawable) {
        if (getDrawable() != drawable) {
            super.setImageDrawable(drawable);
            h impl = getImpl();
            impl.o(impl.z);
            if (this.f2247e != null) {
                m();
            }
        }
    }

    @Override // android.widget.ImageView
    public void setImageResource(@DrawableRes int i2) {
        this.p.setImageResource(i2);
        m();
    }

    public void setRippleColor(@ColorInt int i2) {
        setRippleColor(ColorStateList.valueOf(i2));
    }

    @Override // android.view.View
    public void setScaleX(float f2) {
        super.setScaleX(f2);
        getImpl().m();
    }

    @Override // android.view.View
    public void setScaleY(float f2) {
        super.setScaleY(f2);
        getImpl().m();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @VisibleForTesting
    public void setShadowPaddingEnabled(boolean z) {
        h impl = getImpl();
        impl.n = z;
        impl.v();
    }

    @Override // c.e.a.b.w.p
    public void setShapeAppearanceModel(@NonNull l lVar) {
        getImpl().q(lVar);
    }

    public void setShowMotionSpec(@Nullable g gVar) {
        getImpl().w = gVar;
    }

    public void setShowMotionSpecResource(@AnimatorRes int i2) {
        setShowMotionSpec(g.b(getContext(), i2));
    }

    public void setSize(int i2) {
        this.f2252j = 0;
        if (i2 != this.f2251i) {
            this.f2251i = i2;
            requestLayout();
        }
    }

    @Override // androidx.core.view.TintableBackgroundView
    public void setSupportBackgroundTintList(@Nullable ColorStateList colorStateList) {
        setBackgroundTintList(colorStateList);
    }

    @Override // androidx.core.view.TintableBackgroundView
    public void setSupportBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        setBackgroundTintMode(mode);
    }

    @Override // androidx.core.widget.TintableImageSourceView
    public void setSupportImageTintList(@Nullable ColorStateList colorStateList) {
        if (this.f2247e != colorStateList) {
            this.f2247e = colorStateList;
            m();
        }
    }

    @Override // androidx.core.widget.TintableImageSourceView
    public void setSupportImageTintMode(@Nullable PorterDuff.Mode mode) {
        if (this.f2248f != mode) {
            this.f2248f = mode;
            m();
        }
    }

    @Override // android.view.View
    public void setTranslationX(float f2) {
        super.setTranslationX(f2);
        getImpl().n();
    }

    @Override // android.view.View
    public void setTranslationY(float f2) {
        super.setTranslationY(f2);
        getImpl().n();
    }

    @Override // android.view.View
    public void setTranslationZ(float f2) {
        super.setTranslationZ(f2);
        getImpl().n();
    }

    public void setUseCompatPadding(boolean z) {
        if (this.m != z) {
            this.m = z;
            getImpl().j();
        }
    }

    @Override // com.google.android.material.internal.VisibilityAwareImageButton, android.widget.ImageView, android.view.View
    public void setVisibility(int i2) {
        super.setVisibility(i2);
    }

    public void show(@Nullable a aVar) {
        o(aVar, true);
    }

    public static class BaseBehavior<T extends FloatingActionButton> extends CoordinatorLayout.Behavior<T> {
        public Rect a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public a f2255b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f2256c;

        public BaseBehavior() {
            this.f2256c = true;
        }

        public static boolean b(@NonNull View view) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.LayoutParams) {
                return ((CoordinatorLayout.LayoutParams) layoutParams).getBehavior() instanceof BottomSheetBehavior;
            }
            return false;
        }

        public boolean a(@NonNull FloatingActionButton floatingActionButton, @NonNull Rect rect) {
            Rect rect2 = floatingActionButton.n;
            rect.set(floatingActionButton.getLeft() + rect2.left, floatingActionButton.getTop() + rect2.top, floatingActionButton.getRight() - rect2.right, floatingActionButton.getBottom() - rect2.bottom);
            return true;
        }

        public final boolean c(@NonNull View view, @NonNull FloatingActionButton floatingActionButton) {
            return this.f2256c && ((CoordinatorLayout.LayoutParams) floatingActionButton.getLayoutParams()).getAnchorId() == view.getId() && floatingActionButton.getUserSetVisibility() == 0;
        }

        public final boolean d(CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, @NonNull FloatingActionButton floatingActionButton) {
            if (!c(appBarLayout, floatingActionButton)) {
                return false;
            }
            if (this.a == null) {
                this.a = new Rect();
            }
            Rect rect = this.a;
            c.e.a.b.q.b.a(coordinatorLayout, appBarLayout, rect);
            if (rect.bottom <= appBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
                floatingActionButton.i(this.f2255b, false);
                return true;
            }
            floatingActionButton.o(this.f2255b, false);
            return true;
        }

        public final boolean e(@NonNull View view, @NonNull FloatingActionButton floatingActionButton) {
            if (!c(view, floatingActionButton)) {
                return false;
            }
            if (view.getTop() < (floatingActionButton.getHeight() / 2) + ((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.LayoutParams) floatingActionButton.getLayoutParams())).topMargin) {
                floatingActionButton.i(this.f2255b, false);
                return true;
            }
            floatingActionButton.o(this.f2255b, false);
            return true;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean getInsetDodgeRect(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull Rect rect) {
            return a((FloatingActionButton) view, rect);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public void onAttachedToLayoutParams(@NonNull CoordinatorLayout.LayoutParams layoutParams) {
            if (layoutParams.dodgeInsetEdges == 0) {
                layoutParams.dodgeInsetEdges = 80;
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, @NonNull View view, View view2) {
            FloatingActionButton floatingActionButton = (FloatingActionButton) view;
            if (view2 instanceof AppBarLayout) {
                d(coordinatorLayout, (AppBarLayout) view2, floatingActionButton);
                return false;
            }
            if (!b(view2)) {
                return false;
            }
            e(view2, floatingActionButton);
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean onLayoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, int i2) {
            FloatingActionButton floatingActionButton = (FloatingActionButton) view;
            List<View> dependencies = coordinatorLayout.getDependencies(floatingActionButton);
            int size = dependencies.size();
            int i3 = 0;
            for (int i4 = 0; i4 < size; i4++) {
                View view2 = dependencies.get(i4);
                if (!(view2 instanceof AppBarLayout)) {
                    if (b(view2) && e(view2, floatingActionButton)) {
                        break;
                    }
                } else {
                    if (d(coordinatorLayout, (AppBarLayout) view2, floatingActionButton)) {
                        break;
                    }
                }
            }
            coordinatorLayout.onLayoutChild(floatingActionButton, i2);
            Rect rect = floatingActionButton.n;
            if (rect == null || rect.centerX() <= 0 || rect.centerY() <= 0) {
                return true;
            }
            CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) floatingActionButton.getLayoutParams();
            int i5 = floatingActionButton.getRight() >= coordinatorLayout.getWidth() - ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin ? rect.right : floatingActionButton.getLeft() <= ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin ? -rect.left : 0;
            if (floatingActionButton.getBottom() >= coordinatorLayout.getHeight() - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin) {
                i3 = rect.bottom;
            } else if (floatingActionButton.getTop() <= ((ViewGroup.MarginLayoutParams) layoutParams).topMargin) {
                i3 = -rect.top;
            }
            if (i3 != 0) {
                ViewCompat.offsetTopAndBottom(floatingActionButton, i3);
            }
            if (i5 == 0) {
                return true;
            }
            ViewCompat.offsetLeftAndRight(floatingActionButton, i5);
            return true;
        }

        @VisibleForTesting
        public void setInternalAutoHideListener(a aVar) {
            this.f2255b = aVar;
        }

        public BaseBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.FloatingActionButton_Behavior_Layout);
            this.f2256c = typedArrayObtainStyledAttributes.getBoolean(R$styleable.FloatingActionButton_Behavior_Layout_behavior_autoHide, true);
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public FloatingActionButton(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.floatingActionButtonStyle);
    }

    public void setRippleColor(@Nullable ColorStateList colorStateList) {
        if (this.f2249g != colorStateList) {
            this.f2249g = colorStateList;
            getImpl().p(this.f2249g);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public FloatingActionButton(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        int i3 = f2244b;
        super(c.e.a.b.b0.a.a.a(context, attributeSet, i2, i3), attributeSet, i2);
        this.n = new Rect();
        this.o = new Rect();
        Context context2 = getContext();
        TypedArray typedArrayD = c.e.a.b.q.g.d(context2, attributeSet, R$styleable.FloatingActionButton, i2, i3, new int[0]);
        this.f2245c = c.b.a.m.f.a2(context2, typedArrayD, R$styleable.FloatingActionButton_backgroundTint);
        this.f2246d = c.b.a.m.f.j4(typedArrayD.getInt(R$styleable.FloatingActionButton_backgroundTintMode, -1), null);
        this.f2249g = c.b.a.m.f.a2(context2, typedArrayD, R$styleable.FloatingActionButton_rippleColor);
        this.f2251i = typedArrayD.getInt(R$styleable.FloatingActionButton_fabSize, -1);
        this.f2252j = typedArrayD.getDimensionPixelSize(R$styleable.FloatingActionButton_fabCustomSize, 0);
        this.f2250h = typedArrayD.getDimensionPixelSize(R$styleable.FloatingActionButton_borderWidth, 0);
        float dimension = typedArrayD.getDimension(R$styleable.FloatingActionButton_elevation, 0.0f);
        float dimension2 = typedArrayD.getDimension(R$styleable.FloatingActionButton_hoveredFocusedTranslationZ, 0.0f);
        float dimension3 = typedArrayD.getDimension(R$styleable.FloatingActionButton_pressedTranslationZ, 0.0f);
        this.m = typedArrayD.getBoolean(R$styleable.FloatingActionButton_useCompatPadding, false);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R$dimen.mtrl_fab_min_touch_target);
        this.f2254l = typedArrayD.getDimensionPixelSize(R$styleable.FloatingActionButton_maxImageSize, 0);
        g gVarA = g.a(context2, typedArrayD, R$styleable.FloatingActionButton_showMotionSpec);
        g gVarA2 = g.a(context2, typedArrayD, R$styleable.FloatingActionButton_hideMotionSpec);
        l lVarA = l.c(context2, attributeSet, i2, i3, l.a).a();
        boolean z = typedArrayD.getBoolean(R$styleable.FloatingActionButton_ensureMinTouchTargetSize, false);
        setEnabled(typedArrayD.getBoolean(R$styleable.FloatingActionButton_android_enabled, true));
        typedArrayD.recycle();
        AppCompatImageHelper appCompatImageHelper = new AppCompatImageHelper(this);
        this.p = appCompatImageHelper;
        appCompatImageHelper.loadFromAttributes(attributeSet, i2);
        this.q = new c.e.a.b.o.b(this);
        getImpl().q(lVarA);
        getImpl().f(this.f2245c, this.f2246d, this.f2249g, this.f2250h);
        getImpl().r = dimensionPixelSize;
        h impl = getImpl();
        if (impl.o != dimension) {
            impl.o = dimension;
            impl.l(dimension, impl.p, impl.q);
        }
        h impl2 = getImpl();
        if (impl2.p != dimension2) {
            impl2.p = dimension2;
            impl2.l(impl2.o, dimension2, impl2.q);
        }
        h impl3 = getImpl();
        if (impl3.q != dimension3) {
            impl3.q = dimension3;
            impl3.l(impl3.o, impl3.p, dimension3);
        }
        h impl4 = getImpl();
        int i4 = this.f2254l;
        if (impl4.A != i4) {
            impl4.A = i4;
            impl4.o(impl4.z);
        }
        getImpl().w = gVarA;
        getImpl().x = gVarA2;
        getImpl().m = z;
        setScaleType(ImageView.ScaleType.MATRIX);
    }
}

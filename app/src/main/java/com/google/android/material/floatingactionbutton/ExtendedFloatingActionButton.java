package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.AnimatorRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import c.e.a.b.p.l;
import com.google.android.material.R$animator;
import com.google.android.material.R$attr;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.button.MaterialButton;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class ExtendedFloatingActionButton extends MaterialButton implements CoordinatorLayout.AttachedBehavior {
    public static final int q = R$style.Widget_MaterialComponents_ExtendedFloatingActionButton_Icon;
    public static final Property<View, Float> r = new c(Float.class, "width");
    public static final Property<View, Float> s = new d(Float.class, "height");
    public static final Property<View, Float> t = new e(Float.class, "paddingStart");
    public static final Property<View, Float> u = new f(Float.class, "paddingEnd");
    public final l A;
    public final int B;
    public int C;
    public int D;

    @NonNull
    public final CoordinatorLayout.Behavior<ExtendedFloatingActionButton> E;
    public boolean F;
    public boolean G;
    public boolean H;

    @NonNull
    public ColorStateList I;
    public int v;
    public final c.e.a.b.p.a w;

    @NonNull
    public final l x;

    @NonNull
    public final l y;
    public final l z;

    public class a implements k {
        public a() {
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.k
        public ViewGroup.LayoutParams a() {
            return new ViewGroup.LayoutParams(-2, -2);
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.k
        public int getHeight() {
            return ExtendedFloatingActionButton.this.getMeasuredHeight();
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.k
        public int getPaddingEnd() {
            return ExtendedFloatingActionButton.this.D;
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.k
        public int getPaddingStart() {
            return ExtendedFloatingActionButton.this.C;
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.k
        public int getWidth() {
            int measuredWidth = ExtendedFloatingActionButton.this.getMeasuredWidth() - (ExtendedFloatingActionButton.this.getCollapsedPadding() * 2);
            ExtendedFloatingActionButton extendedFloatingActionButton = ExtendedFloatingActionButton.this;
            return measuredWidth + extendedFloatingActionButton.C + extendedFloatingActionButton.D;
        }
    }

    public class b implements k {
        public b() {
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.k
        public ViewGroup.LayoutParams a() {
            return new ViewGroup.LayoutParams(ExtendedFloatingActionButton.this.getCollapsedSize(), ExtendedFloatingActionButton.this.getCollapsedSize());
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.k
        public int getHeight() {
            return ExtendedFloatingActionButton.this.getCollapsedSize();
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.k
        public int getPaddingEnd() {
            return ExtendedFloatingActionButton.this.getCollapsedPadding();
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.k
        public int getPaddingStart() {
            return ExtendedFloatingActionButton.this.getCollapsedPadding();
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.k
        public int getWidth() {
            return ExtendedFloatingActionButton.this.getCollapsedSize();
        }
    }

    public static class c extends Property<View, Float> {
        public c(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        @NonNull
        public Float get(@NonNull View view) {
            return Float.valueOf(view.getLayoutParams().width);
        }

        @Override // android.util.Property
        public void set(@NonNull View view, @NonNull Float f2) {
            View view2 = view;
            view2.getLayoutParams().width = f2.intValue();
            view2.requestLayout();
        }
    }

    public static class d extends Property<View, Float> {
        public d(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        @NonNull
        public Float get(@NonNull View view) {
            return Float.valueOf(view.getLayoutParams().height);
        }

        @Override // android.util.Property
        public void set(@NonNull View view, @NonNull Float f2) {
            View view2 = view;
            view2.getLayoutParams().height = f2.intValue();
            view2.requestLayout();
        }
    }

    public static class e extends Property<View, Float> {
        public e(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        @NonNull
        public Float get(@NonNull View view) {
            return Float.valueOf(ViewCompat.getPaddingStart(view));
        }

        @Override // android.util.Property
        public void set(@NonNull View view, @NonNull Float f2) {
            View view2 = view;
            ViewCompat.setPaddingRelative(view2, f2.intValue(), view2.getPaddingTop(), ViewCompat.getPaddingEnd(view2), view2.getPaddingBottom());
        }
    }

    public static class f extends Property<View, Float> {
        public f(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        @NonNull
        public Float get(@NonNull View view) {
            return Float.valueOf(ViewCompat.getPaddingEnd(view));
        }

        @Override // android.util.Property
        public void set(@NonNull View view, @NonNull Float f2) {
            View view2 = view;
            ViewCompat.setPaddingRelative(view2, ViewCompat.getPaddingStart(view2), view2.getPaddingTop(), f2.intValue(), view2.getPaddingBottom());
        }
    }

    public class g extends c.e.a.b.p.b {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final k f2238g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final boolean f2239h;

        public g(c.e.a.b.p.a aVar, k kVar, boolean z) {
            super(ExtendedFloatingActionButton.this, aVar);
            this.f2238g = kVar;
            this.f2239h = z;
        }

        @Override // c.e.a.b.p.l
        public int b() {
            return this.f2239h ? R$animator.mtrl_extended_fab_change_size_expand_motion_spec : R$animator.mtrl_extended_fab_change_size_collapse_motion_spec;
        }

        @Override // c.e.a.b.p.l
        public void c() {
            ExtendedFloatingActionButton extendedFloatingActionButton = ExtendedFloatingActionButton.this;
            extendedFloatingActionButton.F = this.f2239h;
            ViewGroup.LayoutParams layoutParams = extendedFloatingActionButton.getLayoutParams();
            if (layoutParams == null) {
                return;
            }
            layoutParams.width = this.f2238g.a().width;
            layoutParams.height = this.f2238g.a().height;
            ViewCompat.setPaddingRelative(ExtendedFloatingActionButton.this, this.f2238g.getPaddingStart(), ExtendedFloatingActionButton.this.getPaddingTop(), this.f2238g.getPaddingEnd(), ExtendedFloatingActionButton.this.getPaddingBottom());
            ExtendedFloatingActionButton.this.requestLayout();
        }

        @Override // c.e.a.b.p.l
        public boolean d() {
            boolean z = this.f2239h;
            ExtendedFloatingActionButton extendedFloatingActionButton = ExtendedFloatingActionButton.this;
            return z == extendedFloatingActionButton.F || extendedFloatingActionButton.getIcon() == null || TextUtils.isEmpty(ExtendedFloatingActionButton.this.getText());
        }

        @Override // c.e.a.b.p.b, c.e.a.b.p.l
        public void e() {
            super.e();
            ExtendedFloatingActionButton extendedFloatingActionButton = ExtendedFloatingActionButton.this;
            extendedFloatingActionButton.G = false;
            extendedFloatingActionButton.setHorizontallyScrolling(false);
            ViewGroup.LayoutParams layoutParams = ExtendedFloatingActionButton.this.getLayoutParams();
            if (layoutParams == null) {
                return;
            }
            layoutParams.width = this.f2238g.a().width;
            layoutParams.height = this.f2238g.a().height;
        }

        @Override // c.e.a.b.p.b, c.e.a.b.p.l
        @NonNull
        public AnimatorSet f() {
            c.e.a.b.a.g gVarI = i();
            if (gVarI.g("width")) {
                PropertyValuesHolder[] propertyValuesHolderArrE = gVarI.e("width");
                propertyValuesHolderArrE[0].setFloatValues(ExtendedFloatingActionButton.this.getWidth(), this.f2238g.getWidth());
                gVarI.f846b.put("width", propertyValuesHolderArrE);
            }
            if (gVarI.g("height")) {
                PropertyValuesHolder[] propertyValuesHolderArrE2 = gVarI.e("height");
                propertyValuesHolderArrE2[0].setFloatValues(ExtendedFloatingActionButton.this.getHeight(), this.f2238g.getHeight());
                gVarI.f846b.put("height", propertyValuesHolderArrE2);
            }
            if (gVarI.g("paddingStart")) {
                PropertyValuesHolder[] propertyValuesHolderArrE3 = gVarI.e("paddingStart");
                propertyValuesHolderArrE3[0].setFloatValues(ViewCompat.getPaddingStart(ExtendedFloatingActionButton.this), this.f2238g.getPaddingStart());
                gVarI.f846b.put("paddingStart", propertyValuesHolderArrE3);
            }
            if (gVarI.g("paddingEnd")) {
                PropertyValuesHolder[] propertyValuesHolderArrE4 = gVarI.e("paddingEnd");
                propertyValuesHolderArrE4[0].setFloatValues(ViewCompat.getPaddingEnd(ExtendedFloatingActionButton.this), this.f2238g.getPaddingEnd());
                gVarI.f846b.put("paddingEnd", propertyValuesHolderArrE4);
            }
            if (gVarI.g("labelOpacity")) {
                PropertyValuesHolder[] propertyValuesHolderArrE5 = gVarI.e("labelOpacity");
                boolean z = this.f2239h;
                propertyValuesHolderArrE5[0].setFloatValues(z ? 0.0f : 1.0f, z ? 1.0f : 0.0f);
                gVarI.f846b.put("labelOpacity", propertyValuesHolderArrE5);
            }
            return h(gVarI);
        }

        @Override // c.e.a.b.p.l
        public void g(@Nullable i iVar) {
            if (iVar == null) {
                return;
            }
            if (!this.f2239h) {
                throw null;
            }
            throw null;
        }

        @Override // c.e.a.b.p.b, c.e.a.b.p.l
        public void onAnimationStart(Animator animator) {
            c.e.a.b.p.a aVar = this.f1054d;
            Animator animator2 = aVar.a;
            if (animator2 != null) {
                animator2.cancel();
            }
            aVar.a = animator;
            ExtendedFloatingActionButton extendedFloatingActionButton = ExtendedFloatingActionButton.this;
            extendedFloatingActionButton.F = this.f2239h;
            extendedFloatingActionButton.G = true;
            extendedFloatingActionButton.setHorizontallyScrolling(true);
        }
    }

    public class h extends c.e.a.b.p.b {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f2241g;

        public h(c.e.a.b.p.a aVar) {
            super(ExtendedFloatingActionButton.this, aVar);
        }

        @Override // c.e.a.b.p.b, c.e.a.b.p.l
        public void a() {
            this.f1054d.a = null;
            this.f2241g = true;
        }

        @Override // c.e.a.b.p.l
        public int b() {
            return R$animator.mtrl_extended_fab_hide_motion_spec;
        }

        @Override // c.e.a.b.p.l
        public void c() {
            ExtendedFloatingActionButton.this.setVisibility(8);
        }

        @Override // c.e.a.b.p.l
        public boolean d() {
            ExtendedFloatingActionButton extendedFloatingActionButton = ExtendedFloatingActionButton.this;
            int i2 = ExtendedFloatingActionButton.q;
            if (extendedFloatingActionButton.getVisibility() == 0) {
                if (extendedFloatingActionButton.v != 1) {
                    return false;
                }
            } else if (extendedFloatingActionButton.v == 2) {
                return false;
            }
            return true;
        }

        @Override // c.e.a.b.p.b, c.e.a.b.p.l
        public void e() {
            super.e();
            ExtendedFloatingActionButton extendedFloatingActionButton = ExtendedFloatingActionButton.this;
            extendedFloatingActionButton.v = 0;
            if (this.f2241g) {
                return;
            }
            extendedFloatingActionButton.setVisibility(8);
        }

        @Override // c.e.a.b.p.l
        public void g(@Nullable i iVar) {
            if (iVar != null) {
                throw null;
            }
        }

        @Override // c.e.a.b.p.b, c.e.a.b.p.l
        public void onAnimationStart(Animator animator) {
            c.e.a.b.p.a aVar = this.f1054d;
            Animator animator2 = aVar.a;
            if (animator2 != null) {
                animator2.cancel();
            }
            aVar.a = animator;
            this.f2241g = false;
            ExtendedFloatingActionButton.this.setVisibility(0);
            ExtendedFloatingActionButton.this.v = 1;
        }
    }

    public static abstract class i {
    }

    public class j extends c.e.a.b.p.b {
        public j(c.e.a.b.p.a aVar) {
            super(ExtendedFloatingActionButton.this, aVar);
        }

        @Override // c.e.a.b.p.l
        public int b() {
            return R$animator.mtrl_extended_fab_show_motion_spec;
        }

        @Override // c.e.a.b.p.l
        public void c() {
            ExtendedFloatingActionButton.this.setVisibility(0);
            ExtendedFloatingActionButton.this.setAlpha(1.0f);
            ExtendedFloatingActionButton.this.setScaleY(1.0f);
            ExtendedFloatingActionButton.this.setScaleX(1.0f);
        }

        @Override // c.e.a.b.p.l
        public boolean d() {
            ExtendedFloatingActionButton extendedFloatingActionButton = ExtendedFloatingActionButton.this;
            int i2 = ExtendedFloatingActionButton.q;
            return extendedFloatingActionButton.j();
        }

        @Override // c.e.a.b.p.b, c.e.a.b.p.l
        public void e() {
            super.e();
            ExtendedFloatingActionButton.this.v = 0;
        }

        @Override // c.e.a.b.p.l
        public void g(@Nullable i iVar) {
            if (iVar != null) {
                throw null;
            }
        }

        @Override // c.e.a.b.p.b, c.e.a.b.p.l
        public void onAnimationStart(Animator animator) {
            c.e.a.b.p.a aVar = this.f1054d;
            Animator animator2 = aVar.a;
            if (animator2 != null) {
                animator2.cancel();
            }
            aVar.a = animator;
            ExtendedFloatingActionButton.this.setVisibility(0);
            ExtendedFloatingActionButton.this.v = 2;
        }
    }

    public interface k {
        ViewGroup.LayoutParams a();

        int getHeight();

        int getPaddingEnd();

        int getPaddingStart();

        int getWidth();
    }

    public ExtendedFloatingActionButton(@NonNull Context context) {
        this(context, null);
    }

    public static void i(ExtendedFloatingActionButton extendedFloatingActionButton, l lVar) {
        Objects.requireNonNull(extendedFloatingActionButton);
        if (lVar.d()) {
            return;
        }
        if (!((ViewCompat.isLaidOut(extendedFloatingActionButton) || (!extendedFloatingActionButton.j() && extendedFloatingActionButton.H)) && !extendedFloatingActionButton.isInEditMode())) {
            lVar.c();
            lVar.g(null);
            return;
        }
        extendedFloatingActionButton.measure(0, 0);
        AnimatorSet animatorSetF = lVar.f();
        animatorSetF.addListener(new c.e.a.b.p.d(extendedFloatingActionButton, lVar));
        Iterator<Animator.AnimatorListener> it = ((c.e.a.b.p.b) lVar).f1053c.iterator();
        while (it.hasNext()) {
            animatorSetF.addListener(it.next());
        }
        animatorSetF.start();
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.AttachedBehavior
    @NonNull
    public CoordinatorLayout.Behavior<ExtendedFloatingActionButton> getBehavior() {
        return this.E;
    }

    public int getCollapsedPadding() {
        return (getCollapsedSize() - getIconSize()) / 2;
    }

    @VisibleForTesting
    public int getCollapsedSize() {
        int i2 = this.B;
        return i2 < 0 ? (Math.min(ViewCompat.getPaddingStart(this), ViewCompat.getPaddingEnd(this)) * 2) + getIconSize() : i2;
    }

    @Nullable
    public c.e.a.b.a.g getExtendMotionSpec() {
        return ((c.e.a.b.p.b) this.y).f1056f;
    }

    @Nullable
    public c.e.a.b.a.g getHideMotionSpec() {
        return ((c.e.a.b.p.b) this.A).f1056f;
    }

    @Nullable
    public c.e.a.b.a.g getShowMotionSpec() {
        return ((c.e.a.b.p.b) this.z).f1056f;
    }

    @Nullable
    public c.e.a.b.a.g getShrinkMotionSpec() {
        return ((c.e.a.b.p.b) this.x).f1056f;
    }

    public final boolean j() {
        return getVisibility() != 0 ? this.v == 2 : this.v != 1;
    }

    public final void k() {
        this.I = getTextColors();
    }

    public void l(@NonNull ColorStateList colorStateList) {
        super.setTextColor(colorStateList);
    }

    @Override // com.google.android.material.button.MaterialButton, android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.F && TextUtils.isEmpty(getText()) && getIcon() != null) {
            this.F = false;
            this.x.c();
        }
    }

    public void setAnimateShowBeforeLayout(boolean z) {
        this.H = z;
    }

    public void setExtendMotionSpec(@Nullable c.e.a.b.a.g gVar) {
        ((c.e.a.b.p.b) this.y).f1056f = gVar;
    }

    public void setExtendMotionSpecResource(@AnimatorRes int i2) {
        setExtendMotionSpec(c.e.a.b.a.g.b(getContext(), i2));
    }

    public void setExtended(boolean z) {
        if (this.F == z) {
            return;
        }
        l lVar = z ? this.y : this.x;
        if (lVar.d()) {
            return;
        }
        lVar.c();
    }

    public void setHideMotionSpec(@Nullable c.e.a.b.a.g gVar) {
        ((c.e.a.b.p.b) this.A).f1056f = gVar;
    }

    public void setHideMotionSpecResource(@AnimatorRes int i2) {
        setHideMotionSpec(c.e.a.b.a.g.b(getContext(), i2));
    }

    @Override // android.widget.TextView, android.view.View
    public void setPadding(int i2, int i3, int i4, int i5) {
        super.setPadding(i2, i3, i4, i5);
        if (!this.F || this.G) {
            return;
        }
        this.C = ViewCompat.getPaddingStart(this);
        this.D = ViewCompat.getPaddingEnd(this);
    }

    @Override // android.widget.TextView, android.view.View
    public void setPaddingRelative(int i2, int i3, int i4, int i5) {
        super.setPaddingRelative(i2, i3, i4, i5);
        if (!this.F || this.G) {
            return;
        }
        this.C = i2;
        this.D = i4;
    }

    public void setShowMotionSpec(@Nullable c.e.a.b.a.g gVar) {
        ((c.e.a.b.p.b) this.z).f1056f = gVar;
    }

    public void setShowMotionSpecResource(@AnimatorRes int i2) {
        setShowMotionSpec(c.e.a.b.a.g.b(getContext(), i2));
    }

    public void setShrinkMotionSpec(@Nullable c.e.a.b.a.g gVar) {
        ((c.e.a.b.p.b) this.x).f1056f = gVar;
    }

    public void setShrinkMotionSpecResource(@AnimatorRes int i2) {
        setShrinkMotionSpec(c.e.a.b.a.g.b(getContext(), i2));
    }

    @Override // android.widget.TextView
    public void setTextColor(int i2) {
        super.setTextColor(i2);
        k();
    }

    public ExtendedFloatingActionButton(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.extendedFloatingActionButtonStyle);
    }

    public static class ExtendedFloatingActionButtonBehavior<T extends ExtendedFloatingActionButton> extends CoordinatorLayout.Behavior<T> {
        public Rect a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f2236b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f2237c;

        public ExtendedFloatingActionButtonBehavior() {
            this.f2236b = false;
            this.f2237c = true;
        }

        public static boolean a(@NonNull View view) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.LayoutParams) {
                return ((CoordinatorLayout.LayoutParams) layoutParams).getBehavior() instanceof BottomSheetBehavior;
            }
            return false;
        }

        public final boolean b(@NonNull View view, @NonNull ExtendedFloatingActionButton extendedFloatingActionButton) {
            return (this.f2236b || this.f2237c) && ((CoordinatorLayout.LayoutParams) extendedFloatingActionButton.getLayoutParams()).getAnchorId() == view.getId();
        }

        public final boolean c(CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, @NonNull ExtendedFloatingActionButton extendedFloatingActionButton) {
            if (!b(appBarLayout, extendedFloatingActionButton)) {
                return false;
            }
            if (this.a == null) {
                this.a = new Rect();
            }
            Rect rect = this.a;
            c.e.a.b.q.b.a(coordinatorLayout, appBarLayout, rect);
            if (rect.bottom <= appBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
                ExtendedFloatingActionButton.i(extendedFloatingActionButton, this.f2237c ? extendedFloatingActionButton.x : extendedFloatingActionButton.A);
                return true;
            }
            ExtendedFloatingActionButton.i(extendedFloatingActionButton, this.f2237c ? extendedFloatingActionButton.y : extendedFloatingActionButton.z);
            return true;
        }

        public final boolean d(@NonNull View view, @NonNull ExtendedFloatingActionButton extendedFloatingActionButton) {
            if (!b(view, extendedFloatingActionButton)) {
                return false;
            }
            if (view.getTop() < (extendedFloatingActionButton.getHeight() / 2) + ((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.LayoutParams) extendedFloatingActionButton.getLayoutParams())).topMargin) {
                ExtendedFloatingActionButton.i(extendedFloatingActionButton, this.f2237c ? extendedFloatingActionButton.x : extendedFloatingActionButton.A);
                return true;
            }
            ExtendedFloatingActionButton.i(extendedFloatingActionButton, this.f2237c ? extendedFloatingActionButton.y : extendedFloatingActionButton.z);
            return true;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean getInsetDodgeRect(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull Rect rect) {
            return super.getInsetDodgeRect(coordinatorLayout, (ExtendedFloatingActionButton) view, rect);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public void onAttachedToLayoutParams(@NonNull CoordinatorLayout.LayoutParams layoutParams) {
            if (layoutParams.dodgeInsetEdges == 0) {
                layoutParams.dodgeInsetEdges = 80;
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, @NonNull View view, View view2) {
            ExtendedFloatingActionButton extendedFloatingActionButton = (ExtendedFloatingActionButton) view;
            if (view2 instanceof AppBarLayout) {
                c(coordinatorLayout, (AppBarLayout) view2, extendedFloatingActionButton);
                return false;
            }
            if (!a(view2)) {
                return false;
            }
            d(view2, extendedFloatingActionButton);
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean onLayoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, int i2) {
            ExtendedFloatingActionButton extendedFloatingActionButton = (ExtendedFloatingActionButton) view;
            List<View> dependencies = coordinatorLayout.getDependencies(extendedFloatingActionButton);
            int size = dependencies.size();
            for (int i3 = 0; i3 < size; i3++) {
                View view2 = dependencies.get(i3);
                if (!(view2 instanceof AppBarLayout)) {
                    if (a(view2) && d(view2, extendedFloatingActionButton)) {
                        break;
                    }
                } else {
                    if (c(coordinatorLayout, (AppBarLayout) view2, extendedFloatingActionButton)) {
                        break;
                    }
                }
            }
            coordinatorLayout.onLayoutChild(extendedFloatingActionButton, i2);
            return true;
        }

        public ExtendedFloatingActionButtonBehavior(@NonNull Context context, @Nullable AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ExtendedFloatingActionButton_Behavior_Layout);
            this.f2236b = typedArrayObtainStyledAttributes.getBoolean(R$styleable.ExtendedFloatingActionButton_Behavior_Layout_behavior_autoHide, false);
            this.f2237c = typedArrayObtainStyledAttributes.getBoolean(R$styleable.ExtendedFloatingActionButton_Behavior_Layout_behavior_autoShrink, true);
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public ExtendedFloatingActionButton(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        int i3 = q;
        super(c.e.a.b.b0.a.a.a(context, attributeSet, i2, i3), attributeSet, i2);
        this.v = 0;
        c.e.a.b.p.a aVar = new c.e.a.b.p.a();
        this.w = aVar;
        j jVar = new j(aVar);
        this.z = jVar;
        h hVar = new h(aVar);
        this.A = hVar;
        this.F = true;
        this.G = false;
        this.H = false;
        Context context2 = getContext();
        this.E = new ExtendedFloatingActionButtonBehavior(context2, attributeSet);
        TypedArray typedArrayD = c.e.a.b.q.g.d(context2, attributeSet, R$styleable.ExtendedFloatingActionButton, i2, i3, new int[0]);
        c.e.a.b.a.g gVarA = c.e.a.b.a.g.a(context2, typedArrayD, R$styleable.ExtendedFloatingActionButton_showMotionSpec);
        c.e.a.b.a.g gVarA2 = c.e.a.b.a.g.a(context2, typedArrayD, R$styleable.ExtendedFloatingActionButton_hideMotionSpec);
        c.e.a.b.a.g gVarA3 = c.e.a.b.a.g.a(context2, typedArrayD, R$styleable.ExtendedFloatingActionButton_extendMotionSpec);
        c.e.a.b.a.g gVarA4 = c.e.a.b.a.g.a(context2, typedArrayD, R$styleable.ExtendedFloatingActionButton_shrinkMotionSpec);
        this.B = typedArrayD.getDimensionPixelSize(R$styleable.ExtendedFloatingActionButton_collapsedSize, -1);
        this.C = ViewCompat.getPaddingStart(this);
        this.D = ViewCompat.getPaddingEnd(this);
        c.e.a.b.p.a aVar2 = new c.e.a.b.p.a();
        g gVar = new g(aVar2, new a(), true);
        this.y = gVar;
        g gVar2 = new g(aVar2, new b(), false);
        this.x = gVar2;
        jVar.f1056f = gVarA;
        hVar.f1056f = gVarA2;
        gVar.f1056f = gVarA3;
        gVar2.f1056f = gVarA4;
        typedArrayD.recycle();
        setShapeAppearanceModel(c.e.a.b.w.l.c(context2, attributeSet, i2, i3, c.e.a.b.w.l.a).a());
        k();
    }

    @Override // android.widget.TextView
    public void setTextColor(@NonNull ColorStateList colorStateList) {
        super.setTextColor(colorStateList);
        k();
    }
}

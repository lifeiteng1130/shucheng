package com.google.android.material.appbar;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.appcompat.R;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.math.MathUtils;
import androidx.core.util.ObjectsCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import c.e.a.b.b.e;
import c.e.a.b.b.i;
import c.e.a.b.q.g;
import com.google.android.material.R$attr;
import com.google.android.material.R$id;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.appbar.AppBarLayout;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class CollapsingToolbarLayout extends FrameLayout {
    public static final int a = R$style.Widget_Design_CollapsingToolbar;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f1982b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f1983c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public ViewGroup f1984d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    public View f1985e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f1986f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f1987g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f1988h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f1989i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f1990j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Rect f1991k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @NonNull
    public final c.e.a.b.q.a f1992l;
    public boolean m;
    public boolean n;

    @Nullable
    public Drawable o;

    @Nullable
    public Drawable p;
    public int q;
    public boolean r;
    public ValueAnimator s;
    public long t;
    public int u;
    public AppBarLayout.c v;
    public int w;

    @Nullable
    public WindowInsetsCompat x;

    public class a implements OnApplyWindowInsetsListener {
        public a() {
        }

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public WindowInsetsCompat onApplyWindowInsets(View view, @NonNull WindowInsetsCompat windowInsetsCompat) {
            CollapsingToolbarLayout collapsingToolbarLayout = CollapsingToolbarLayout.this;
            Objects.requireNonNull(collapsingToolbarLayout);
            WindowInsetsCompat windowInsetsCompat2 = ViewCompat.getFitsSystemWindows(collapsingToolbarLayout) ? windowInsetsCompat : null;
            if (!ObjectsCompat.equals(collapsingToolbarLayout.x, windowInsetsCompat2)) {
                collapsingToolbarLayout.x = windowInsetsCompat2;
                collapsingToolbarLayout.requestLayout();
            }
            return windowInsetsCompat.consumeSystemWindowInsets();
        }
    }

    public class c implements AppBarLayout.c {
        public c() {
        }

        @Override // com.google.android.material.appbar.AppBarLayout.b
        public void a(AppBarLayout appBarLayout, int i2) {
            CollapsingToolbarLayout collapsingToolbarLayout = CollapsingToolbarLayout.this;
            collapsingToolbarLayout.w = i2;
            WindowInsetsCompat windowInsetsCompat = collapsingToolbarLayout.x;
            int systemWindowInsetTop = windowInsetsCompat != null ? windowInsetsCompat.getSystemWindowInsetTop() : 0;
            int childCount = CollapsingToolbarLayout.this.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = CollapsingToolbarLayout.this.getChildAt(i3);
                b bVar = (b) childAt.getLayoutParams();
                i iVarD = CollapsingToolbarLayout.d(childAt);
                int i4 = bVar.a;
                if (i4 == 1) {
                    iVarD.b(MathUtils.clamp(-i2, 0, CollapsingToolbarLayout.this.c(childAt)));
                } else if (i4 == 2) {
                    iVarD.b(Math.round((-i2) * bVar.f1993b));
                }
            }
            CollapsingToolbarLayout.this.f();
            CollapsingToolbarLayout collapsingToolbarLayout2 = CollapsingToolbarLayout.this;
            if (collapsingToolbarLayout2.p != null && systemWindowInsetTop > 0) {
                ViewCompat.postInvalidateOnAnimation(collapsingToolbarLayout2);
            }
            CollapsingToolbarLayout.this.f1992l.w(Math.abs(i2) / ((CollapsingToolbarLayout.this.getHeight() - ViewCompat.getMinimumHeight(CollapsingToolbarLayout.this)) - systemWindowInsetTop));
        }
    }

    public CollapsingToolbarLayout(@NonNull Context context) {
        this(context, null);
    }

    public static int b(@NonNull View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            return view.getMeasuredHeight();
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        return view.getMeasuredHeight() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    @NonNull
    public static i d(@NonNull View view) {
        int i2 = R$id.view_offset_helper;
        i iVar = (i) view.getTag(i2);
        if (iVar != null) {
            return iVar;
        }
        i iVar2 = new i(view);
        view.setTag(i2, iVar2);
        return iVar2;
    }

    public final void a() {
        if (this.f1982b) {
            ViewGroup viewGroup = null;
            this.f1984d = null;
            this.f1985e = null;
            int i2 = this.f1983c;
            if (i2 != -1) {
                ViewGroup viewGroup2 = (ViewGroup) findViewById(i2);
                this.f1984d = viewGroup2;
                if (viewGroup2 != null) {
                    ViewParent parent = viewGroup2.getParent();
                    View view = viewGroup2;
                    while (parent != this && parent != null) {
                        if (parent instanceof View) {
                            view = (View) parent;
                        }
                        parent = parent.getParent();
                        view = view;
                    }
                    this.f1985e = view;
                }
            }
            if (this.f1984d == null) {
                int childCount = getChildCount();
                int i3 = 0;
                while (true) {
                    if (i3 >= childCount) {
                        break;
                    }
                    View childAt = getChildAt(i3);
                    if ((childAt instanceof Toolbar) || (childAt instanceof android.widget.Toolbar)) {
                        viewGroup = (ViewGroup) childAt;
                        break;
                    }
                    i3++;
                }
                this.f1984d = viewGroup;
            }
            e();
            this.f1982b = false;
        }
    }

    public final int c(@NonNull View view) {
        return ((getHeight() - d(view).f913b) - view.getHeight()) - ((FrameLayout.LayoutParams) ((b) view.getLayoutParams())).bottomMargin;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof b;
    }

    @Override // android.view.View
    public void draw(@NonNull Canvas canvas) {
        Drawable drawable;
        super.draw(canvas);
        a();
        if (this.f1984d == null && (drawable = this.o) != null && this.q > 0) {
            drawable.mutate().setAlpha(this.q);
            this.o.draw(canvas);
        }
        if (this.m && this.n) {
            this.f1992l.g(canvas);
        }
        if (this.p == null || this.q <= 0) {
            return;
        }
        WindowInsetsCompat windowInsetsCompat = this.x;
        int systemWindowInsetTop = windowInsetsCompat != null ? windowInsetsCompat.getSystemWindowInsetTop() : 0;
        if (systemWindowInsetTop > 0) {
            this.p.setBounds(0, -this.w, getWidth(), systemWindowInsetTop - this.w);
            this.p.mutate().setAlpha(this.q);
            this.p.draw(canvas);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0018, code lost:
    
        r3 = true;
     */
    /* JADX WARN: Removed duplicated region for block: B:17:0x001d  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x002d  */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean drawChild(android.graphics.Canvas r5, android.view.View r6, long r7) {
        /*
            r4 = this;
            android.graphics.drawable.Drawable r0 = r4.o
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L2d
            int r3 = r4.q
            if (r3 <= 0) goto L2d
            android.view.View r3 = r4.f1985e
            if (r3 == 0) goto L14
            if (r3 != r4) goto L11
            goto L14
        L11:
            if (r6 != r3) goto L1a
            goto L18
        L14:
            android.view.ViewGroup r3 = r4.f1984d
            if (r6 != r3) goto L1a
        L18:
            r3 = 1
            goto L1b
        L1a:
            r3 = 0
        L1b:
            if (r3 == 0) goto L2d
            android.graphics.drawable.Drawable r0 = r0.mutate()
            int r3 = r4.q
            r0.setAlpha(r3)
            android.graphics.drawable.Drawable r0 = r4.o
            r0.draw(r5)
            r0 = 1
            goto L2e
        L2d:
            r0 = 0
        L2e:
            boolean r5 = super.drawChild(r5, r6, r7)
            if (r5 != 0) goto L38
            if (r0 == 0) goto L37
            goto L38
        L37:
            r1 = 0
        L38:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.CollapsingToolbarLayout.drawChild(android.graphics.Canvas, android.view.View, long):boolean");
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.p;
        boolean zY = false;
        if (drawable != null && drawable.isStateful()) {
            zY = false | drawable.setState(drawableState);
        }
        Drawable drawable2 = this.o;
        if (drawable2 != null && drawable2.isStateful()) {
            zY |= drawable2.setState(drawableState);
        }
        c.e.a.b.q.a aVar = this.f1992l;
        if (aVar != null) {
            zY |= aVar.y(drawableState);
        }
        if (zY) {
            invalidate();
        }
    }

    public final void e() {
        View view;
        if (!this.m && (view = this.f1986f) != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.f1986f);
            }
        }
        if (!this.m || this.f1984d == null) {
            return;
        }
        if (this.f1986f == null) {
            this.f1986f = new View(getContext());
        }
        if (this.f1986f.getParent() == null) {
            this.f1984d.addView(this.f1986f, -1, -1);
        }
    }

    public final void f() {
        if (this.o == null && this.p == null) {
            return;
        }
        setScrimsShown(getHeight() + this.w < getScrimVisibleHeightTrigger());
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new b(-1, -1);
    }

    public int getCollapsedTitleGravity() {
        return this.f1992l.f1099h;
    }

    @NonNull
    public Typeface getCollapsedTitleTypeface() {
        Typeface typeface = this.f1992l.s;
        return typeface != null ? typeface : Typeface.DEFAULT;
    }

    @Nullable
    public Drawable getContentScrim() {
        return this.o;
    }

    public int getExpandedTitleGravity() {
        return this.f1992l.f1098g;
    }

    public int getExpandedTitleMarginBottom() {
        return this.f1990j;
    }

    public int getExpandedTitleMarginEnd() {
        return this.f1989i;
    }

    public int getExpandedTitleMarginStart() {
        return this.f1987g;
    }

    public int getExpandedTitleMarginTop() {
        return this.f1988h;
    }

    @NonNull
    public Typeface getExpandedTitleTypeface() {
        Typeface typeface = this.f1992l.t;
        return typeface != null ? typeface : Typeface.DEFAULT;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int getMaxLines() {
        return this.f1992l.Y;
    }

    public int getScrimAlpha() {
        return this.q;
    }

    public long getScrimAnimationDuration() {
        return this.t;
    }

    public int getScrimVisibleHeightTrigger() {
        int i2 = this.u;
        if (i2 >= 0) {
            return i2;
        }
        WindowInsetsCompat windowInsetsCompat = this.x;
        int systemWindowInsetTop = windowInsetsCompat != null ? windowInsetsCompat.getSystemWindowInsetTop() : 0;
        int minimumHeight = ViewCompat.getMinimumHeight(this);
        return minimumHeight > 0 ? Math.min((minimumHeight * 2) + systemWindowInsetTop, getHeight()) : getHeight() / 3;
    }

    @Nullable
    public Drawable getStatusBarScrim() {
        return this.p;
    }

    @Nullable
    public CharSequence getTitle() {
        if (this.m) {
            return this.f1992l.x;
        }
        return null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Object parent = getParent();
        if (parent instanceof AppBarLayout) {
            ViewCompat.setFitsSystemWindows(this, ViewCompat.getFitsSystemWindows((View) parent));
            if (this.v == null) {
                this.v = new c();
            }
            ((AppBarLayout) parent).addOnOffsetChangedListener(this.v);
            ViewCompat.requestApplyInsets(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        ViewParent parent = getParent();
        AppBarLayout.c cVar = this.v;
        if (cVar != null && (parent instanceof AppBarLayout)) {
            ((AppBarLayout) parent).removeOnOffsetChangedListener(cVar);
        }
        super.onDetachedFromWindow();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        View view;
        int titleMarginBottom;
        int titleMarginStart;
        int titleMarginEnd;
        int titleMarginTop;
        super.onLayout(z, i2, i3, i4, i5);
        WindowInsetsCompat windowInsetsCompat = this.x;
        if (windowInsetsCompat != null) {
            int systemWindowInsetTop = windowInsetsCompat.getSystemWindowInsetTop();
            int childCount = getChildCount();
            for (int i6 = 0; i6 < childCount; i6++) {
                View childAt = getChildAt(i6);
                if (!ViewCompat.getFitsSystemWindows(childAt) && childAt.getTop() < systemWindowInsetTop) {
                    ViewCompat.offsetTopAndBottom(childAt, systemWindowInsetTop);
                }
            }
        }
        int childCount2 = getChildCount();
        for (int i7 = 0; i7 < childCount2; i7++) {
            i iVarD = d(getChildAt(i7));
            iVarD.f913b = iVarD.a.getTop();
            iVarD.f914c = iVarD.a.getLeft();
        }
        if (this.m && (view = this.f1986f) != null) {
            boolean z2 = ViewCompat.isAttachedToWindow(view) && this.f1986f.getVisibility() == 0;
            this.n = z2;
            if (z2) {
                boolean z3 = ViewCompat.getLayoutDirection(this) == 1;
                View view2 = this.f1985e;
                if (view2 == null) {
                    view2 = this.f1984d;
                }
                int iC = c(view2);
                c.e.a.b.q.b.a(this, this.f1986f, this.f1991k);
                ViewGroup viewGroup = this.f1984d;
                if (viewGroup instanceof Toolbar) {
                    Toolbar toolbar = (Toolbar) viewGroup;
                    titleMarginStart = toolbar.getTitleMarginStart();
                    titleMarginEnd = toolbar.getTitleMarginEnd();
                    titleMarginTop = toolbar.getTitleMarginTop();
                    titleMarginBottom = toolbar.getTitleMarginBottom();
                } else if (Build.VERSION.SDK_INT < 24 || !(viewGroup instanceof android.widget.Toolbar)) {
                    titleMarginBottom = 0;
                    titleMarginStart = 0;
                    titleMarginEnd = 0;
                    titleMarginTop = 0;
                } else {
                    android.widget.Toolbar toolbar2 = (android.widget.Toolbar) viewGroup;
                    titleMarginStart = toolbar2.getTitleMarginStart();
                    titleMarginEnd = toolbar2.getTitleMarginEnd();
                    titleMarginTop = toolbar2.getTitleMarginTop();
                    titleMarginBottom = toolbar2.getTitleMarginBottom();
                }
                c.e.a.b.q.a aVar = this.f1992l;
                Rect rect = this.f1991k;
                int i8 = rect.left + (z3 ? titleMarginEnd : titleMarginStart);
                int i9 = rect.top + iC + titleMarginTop;
                int i10 = rect.right;
                if (!z3) {
                    titleMarginStart = titleMarginEnd;
                }
                int i11 = i10 - titleMarginStart;
                int i12 = (rect.bottom + iC) - titleMarginBottom;
                if (!c.e.a.b.q.a.n(aVar.f1096e, i8, i9, i11, i12)) {
                    aVar.f1096e.set(i8, i9, i11, i12);
                    aVar.E = true;
                    aVar.l();
                }
                c.e.a.b.q.a aVar2 = this.f1992l;
                int i13 = z3 ? this.f1989i : this.f1987g;
                int i14 = this.f1991k.top + this.f1988h;
                int i15 = (i4 - i2) - (z3 ? this.f1987g : this.f1989i);
                int i16 = (i5 - i3) - this.f1990j;
                if (!c.e.a.b.q.a.n(aVar2.f1095d, i13, i14, i15, i16)) {
                    aVar2.f1095d.set(i13, i14, i15, i16);
                    aVar2.E = true;
                    aVar2.l();
                }
                this.f1992l.m();
            }
        }
        if (this.f1984d != null && this.m && TextUtils.isEmpty(this.f1992l.x)) {
            ViewGroup viewGroup2 = this.f1984d;
            setTitle(viewGroup2 instanceof Toolbar ? ((Toolbar) viewGroup2).getTitle() : viewGroup2 instanceof android.widget.Toolbar ? ((android.widget.Toolbar) viewGroup2).getTitle() : null);
        }
        f();
        int childCount3 = getChildCount();
        for (int i17 = 0; i17 < childCount3; i17++) {
            d(getChildAt(i17)).a();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        a();
        super.onMeasure(i2, i3);
        int mode = View.MeasureSpec.getMode(i3);
        WindowInsetsCompat windowInsetsCompat = this.x;
        int systemWindowInsetTop = windowInsetsCompat != null ? windowInsetsCompat.getSystemWindowInsetTop() : 0;
        if (mode == 0 && systemWindowInsetTop > 0) {
            super.onMeasure(i2, View.MeasureSpec.makeMeasureSpec(getMeasuredHeight() + systemWindowInsetTop, BasicMeasure.EXACTLY));
        }
        ViewGroup viewGroup = this.f1984d;
        if (viewGroup != null) {
            View view = this.f1985e;
            if (view == null || view == this) {
                setMinimumHeight(b(viewGroup));
            } else {
                setMinimumHeight(b(view));
            }
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        Drawable drawable = this.o;
        if (drawable != null) {
            drawable.setBounds(0, 0, i2, i3);
        }
    }

    public void setCollapsedTitleGravity(int i2) {
        c.e.a.b.q.a aVar = this.f1992l;
        if (aVar.f1099h != i2) {
            aVar.f1099h = i2;
            aVar.m();
        }
    }

    public void setCollapsedTitleTextAppearance(@StyleRes int i2) {
        this.f1992l.o(i2);
    }

    public void setCollapsedTitleTextColor(@ColorInt int i2) {
        setCollapsedTitleTextColor(ColorStateList.valueOf(i2));
    }

    public void setCollapsedTitleTypeface(@Nullable Typeface typeface) {
        this.f1992l.r(typeface);
    }

    public void setContentScrim(@Nullable Drawable drawable) {
        Drawable drawable2 = this.o;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            Drawable drawableMutate = drawable != null ? drawable.mutate() : null;
            this.o = drawableMutate;
            if (drawableMutate != null) {
                drawableMutate.setBounds(0, 0, getWidth(), getHeight());
                this.o.setCallback(this);
                this.o.setAlpha(this.q);
            }
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    public void setContentScrimColor(@ColorInt int i2) {
        setContentScrim(new ColorDrawable(i2));
    }

    public void setContentScrimResource(@DrawableRes int i2) {
        setContentScrim(ContextCompat.getDrawable(getContext(), i2));
    }

    public void setExpandedTitleColor(@ColorInt int i2) {
        setExpandedTitleTextColor(ColorStateList.valueOf(i2));
    }

    public void setExpandedTitleGravity(int i2) {
        c.e.a.b.q.a aVar = this.f1992l;
        if (aVar.f1098g != i2) {
            aVar.f1098g = i2;
            aVar.m();
        }
    }

    public void setExpandedTitleMarginBottom(int i2) {
        this.f1990j = i2;
        requestLayout();
    }

    public void setExpandedTitleMarginEnd(int i2) {
        this.f1989i = i2;
        requestLayout();
    }

    public void setExpandedTitleMarginStart(int i2) {
        this.f1987g = i2;
        requestLayout();
    }

    public void setExpandedTitleMarginTop(int i2) {
        this.f1988h = i2;
        requestLayout();
    }

    public void setExpandedTitleTextAppearance(@StyleRes int i2) {
        this.f1992l.s(i2);
    }

    public void setExpandedTitleTextColor(@NonNull ColorStateList colorStateList) {
        c.e.a.b.q.a aVar = this.f1992l;
        if (aVar.f1102k != colorStateList) {
            aVar.f1102k = colorStateList;
            aVar.m();
        }
    }

    public void setExpandedTitleTypeface(@Nullable Typeface typeface) {
        this.f1992l.v(typeface);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setMaxLines(int i2) {
        c.e.a.b.q.a aVar = this.f1992l;
        if (i2 != aVar.Y) {
            aVar.Y = i2;
            aVar.f();
            aVar.m();
        }
    }

    public void setScrimAlpha(int i2) {
        ViewGroup viewGroup;
        if (i2 != this.q) {
            if (this.o != null && (viewGroup = this.f1984d) != null) {
                ViewCompat.postInvalidateOnAnimation(viewGroup);
            }
            this.q = i2;
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    public void setScrimAnimationDuration(@IntRange(from = 0) long j2) {
        this.t = j2;
    }

    public void setScrimVisibleHeightTrigger(@IntRange(from = 0) int i2) {
        if (this.u != i2) {
            this.u = i2;
            f();
        }
    }

    public void setScrimsShown(boolean z) {
        boolean z2 = ViewCompat.isLaidOut(this) && !isInEditMode();
        if (this.r != z) {
            if (z2) {
                int i2 = z ? 255 : 0;
                a();
                ValueAnimator valueAnimator = this.s;
                if (valueAnimator == null) {
                    ValueAnimator valueAnimator2 = new ValueAnimator();
                    this.s = valueAnimator2;
                    valueAnimator2.setDuration(this.t);
                    this.s.setInterpolator(i2 > this.q ? c.e.a.b.a.a.f840c : c.e.a.b.a.a.f841d);
                    this.s.addUpdateListener(new e(this));
                } else if (valueAnimator.isRunning()) {
                    this.s.cancel();
                }
                this.s.setIntValues(this.q, i2);
                this.s.start();
            } else {
                setScrimAlpha(z ? 255 : 0);
            }
            this.r = z;
        }
    }

    public void setStatusBarScrim(@Nullable Drawable drawable) {
        Drawable drawable2 = this.p;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            Drawable drawableMutate = drawable != null ? drawable.mutate() : null;
            this.p = drawableMutate;
            if (drawableMutate != null) {
                if (drawableMutate.isStateful()) {
                    this.p.setState(getDrawableState());
                }
                DrawableCompat.setLayoutDirection(this.p, ViewCompat.getLayoutDirection(this));
                this.p.setVisible(getVisibility() == 0, false);
                this.p.setCallback(this);
                this.p.setAlpha(this.q);
            }
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    public void setStatusBarScrimColor(@ColorInt int i2) {
        setStatusBarScrim(new ColorDrawable(i2));
    }

    public void setStatusBarScrimResource(@DrawableRes int i2) {
        setStatusBarScrim(ContextCompat.getDrawable(getContext(), i2));
    }

    public void setTitle(@Nullable CharSequence charSequence) {
        this.f1992l.z(charSequence);
        setContentDescription(getTitle());
    }

    public void setTitleEnabled(boolean z) {
        if (z != this.m) {
            this.m = z;
            setContentDescription(getTitle());
            e();
            requestLayout();
        }
    }

    @Override // android.view.View
    public void setVisibility(int i2) {
        super.setVisibility(i2);
        boolean z = i2 == 0;
        Drawable drawable = this.p;
        if (drawable != null && drawable.isVisible() != z) {
            this.p.setVisible(z, false);
        }
        Drawable drawable2 = this.o;
        if (drawable2 == null || drawable2.isVisible() == z) {
            return;
        }
        this.o.setVisible(z, false);
    }

    @Override // android.view.View
    public boolean verifyDrawable(@NonNull Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.o || drawable == this.p;
    }

    public CollapsingToolbarLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.collapsingToolbarLayoutStyle);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateDefaultLayoutParams() {
        return new b(-1, -1);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new b(getContext(), attributeSet);
    }

    public void setCollapsedTitleTextColor(@NonNull ColorStateList colorStateList) {
        c.e.a.b.q.a aVar = this.f1992l;
        if (aVar.f1103l != colorStateList) {
            aVar.f1103l = colorStateList;
            aVar.m();
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public CollapsingToolbarLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        int i3;
        int i4 = a;
        super(c.e.a.b.b0.a.a.a(context, attributeSet, i2, i4), attributeSet, i2);
        this.f1982b = true;
        this.f1991k = new Rect();
        this.u = -1;
        Context context2 = getContext();
        c.e.a.b.q.a aVar = new c.e.a.b.q.a(this);
        this.f1992l = aVar;
        aVar.I = c.e.a.b.a.a.f842e;
        aVar.m();
        TypedArray typedArrayD = g.d(context2, attributeSet, R$styleable.CollapsingToolbarLayout, i2, i4, new int[0]);
        aVar.u(typedArrayD.getInt(R$styleable.CollapsingToolbarLayout_expandedTitleGravity, 8388691));
        aVar.q(typedArrayD.getInt(R$styleable.CollapsingToolbarLayout_collapsedTitleGravity, 8388627));
        int dimensionPixelSize = typedArrayD.getDimensionPixelSize(R$styleable.CollapsingToolbarLayout_expandedTitleMargin, 0);
        this.f1990j = dimensionPixelSize;
        this.f1989i = dimensionPixelSize;
        this.f1988h = dimensionPixelSize;
        this.f1987g = dimensionPixelSize;
        int i5 = R$styleable.CollapsingToolbarLayout_expandedTitleMarginStart;
        if (typedArrayD.hasValue(i5)) {
            this.f1987g = typedArrayD.getDimensionPixelSize(i5, 0);
        }
        int i6 = R$styleable.CollapsingToolbarLayout_expandedTitleMarginEnd;
        if (typedArrayD.hasValue(i6)) {
            this.f1989i = typedArrayD.getDimensionPixelSize(i6, 0);
        }
        int i7 = R$styleable.CollapsingToolbarLayout_expandedTitleMarginTop;
        if (typedArrayD.hasValue(i7)) {
            this.f1988h = typedArrayD.getDimensionPixelSize(i7, 0);
        }
        int i8 = R$styleable.CollapsingToolbarLayout_expandedTitleMarginBottom;
        if (typedArrayD.hasValue(i8)) {
            this.f1990j = typedArrayD.getDimensionPixelSize(i8, 0);
        }
        this.m = typedArrayD.getBoolean(R$styleable.CollapsingToolbarLayout_titleEnabled, true);
        setTitle(typedArrayD.getText(R$styleable.CollapsingToolbarLayout_title));
        aVar.s(R$style.TextAppearance_Design_CollapsingToolbar_Expanded);
        aVar.o(R.style.TextAppearance_AppCompat_Widget_ActionBar_Title);
        int i9 = R$styleable.CollapsingToolbarLayout_expandedTitleTextAppearance;
        if (typedArrayD.hasValue(i9)) {
            aVar.s(typedArrayD.getResourceId(i9, 0));
        }
        int i10 = R$styleable.CollapsingToolbarLayout_collapsedTitleTextAppearance;
        if (typedArrayD.hasValue(i10)) {
            aVar.o(typedArrayD.getResourceId(i10, 0));
        }
        this.u = typedArrayD.getDimensionPixelSize(R$styleable.CollapsingToolbarLayout_scrimVisibleHeightTrigger, -1);
        int i11 = R$styleable.CollapsingToolbarLayout_maxLines;
        if (typedArrayD.hasValue(i11) && (i3 = typedArrayD.getInt(i11, 1)) != aVar.Y) {
            aVar.Y = i3;
            aVar.f();
            aVar.m();
        }
        this.t = typedArrayD.getInt(R$styleable.CollapsingToolbarLayout_scrimAnimationDuration, 600);
        setContentScrim(typedArrayD.getDrawable(R$styleable.CollapsingToolbarLayout_contentScrim));
        setStatusBarScrim(typedArrayD.getDrawable(R$styleable.CollapsingToolbarLayout_statusBarScrim));
        this.f1983c = typedArrayD.getResourceId(R$styleable.CollapsingToolbarLayout_toolbarId, -1);
        typedArrayD.recycle();
        setWillNotDraw(false);
        ViewCompat.setOnApplyWindowInsetsListener(this, new a());
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new b(layoutParams);
    }

    public static class b extends FrameLayout.LayoutParams {
        public int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f1993b;

        public b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.a = 0;
            this.f1993b = 0.5f;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.CollapsingToolbarLayout_Layout);
            this.a = typedArrayObtainStyledAttributes.getInt(R$styleable.CollapsingToolbarLayout_Layout_layout_collapseMode, 0);
            this.f1993b = typedArrayObtainStyledAttributes.getFloat(R$styleable.CollapsingToolbarLayout_Layout_layout_collapseParallaxMultiplier, 0.5f);
            typedArrayObtainStyledAttributes.recycle();
        }

        public b(int i2, int i3) {
            super(i2, i3);
            this.a = 0;
            this.f1993b = 0.5f;
        }

        public b(@NonNull ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.a = 0;
            this.f1993b = 0.5f;
        }
    }
}

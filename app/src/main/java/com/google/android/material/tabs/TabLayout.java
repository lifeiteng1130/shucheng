package com.google.android.material.tabs;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.BoolRes;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.TooltipCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.util.Pools;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.PointerIconCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.widget.TextViewCompat;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$layout;
import com.google.android.material.R$string;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.shape.MaterialShapeDrawable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
@ViewPager.DecorView
public class TabLayout extends HorizontalScrollView {
    public static final int a = R$style.Widget_Design_TabLayout;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Pools.Pool<g> f2404b = new Pools.SynchronizedPool(16);
    public int A;
    public int B;
    public boolean C;
    public boolean D;
    public int E;
    public boolean F;
    public c.e.a.b.z.b G;

    @Nullable
    public c H;
    public final ArrayList<c> I;

    @Nullable
    public c J;
    public ValueAnimator K;

    @Nullable
    public ViewPager O;

    @Nullable
    public PagerAdapter P;
    public DataSetObserver Q;
    public TabLayoutOnPageChangeListener R;
    public b S;
    public boolean T;
    public final Pools.Pool<TabView> U;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList<g> f2405c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public g f2406d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NonNull
    public final f f2407e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f2408f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f2409g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f2410h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f2411i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f2412j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ColorStateList f2413k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ColorStateList f2414l;
    public ColorStateList m;

    @NonNull
    public Drawable n;
    public int o;
    public PorterDuff.Mode p;
    public float q;
    public float r;
    public final int s;
    public int t;
    public final int u;
    public final int v;
    public final int w;
    public int x;
    public int y;
    public int z;

    public @interface LabelVisibility {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface Mode {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface TabGravity {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface TabIndicatorAnimationMode {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface TabIndicatorGravity {
    }

    public static class TabLayoutOnPageChangeListener implements ViewPager.OnPageChangeListener {

        @NonNull
        public final WeakReference<TabLayout> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f2415b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f2416c;

        public TabLayoutOnPageChangeListener(TabLayout tabLayout) {
            this.a = new WeakReference<>(tabLayout);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i2) {
            this.f2415b = this.f2416c;
            this.f2416c = i2;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i2, float f2, int i3) {
            TabLayout tabLayout = this.a.get();
            if (tabLayout != null) {
                int i4 = this.f2416c;
                tabLayout.m(i2, f2, i4 != 2 || this.f2415b == 1, (i4 == 2 && this.f2415b == 0) ? false : true);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i2) {
            TabLayout tabLayout = this.a.get();
            if (tabLayout == null || tabLayout.getSelectedTabPosition() == i2 || i2 >= tabLayout.getTabCount()) {
                return;
            }
            int i3 = this.f2416c;
            tabLayout.k(tabLayout.g(i2), i3 == 0 || (i3 == 2 && this.f2415b == 0));
        }
    }

    public final class TabView extends LinearLayout {
        public static final /* synthetic */ int a = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public g f2417b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public TextView f2418c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public ImageView f2419d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @Nullable
        public View f2420e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @Nullable
        public BadgeDrawable f2421f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @Nullable
        public View f2422g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        @Nullable
        public TextView f2423h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        @Nullable
        public ImageView f2424i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        @Nullable
        public Drawable f2425j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f2426k;

        public TabView(@NonNull Context context) {
            super(context);
            this.f2426k = 2;
            g(context);
            ViewCompat.setPaddingRelative(this, TabLayout.this.f2408f, TabLayout.this.f2409g, TabLayout.this.f2410h, TabLayout.this.f2411i);
            setGravity(17);
            setOrientation(!TabLayout.this.C ? 1 : 0);
            setClickable(true);
            ViewCompat.setPointerIcon(this, PointerIconCompat.getSystemIcon(getContext(), PointerIconCompat.TYPE_HAND));
        }

        @Nullable
        private BadgeDrawable getBadge() {
            return this.f2421f;
        }

        @NonNull
        private BadgeDrawable getOrCreateBadge() {
            if (this.f2421f == null) {
                Context context = getContext();
                int i2 = BadgeDrawable.f1995b;
                int i3 = BadgeDrawable.a;
                BadgeDrawable badgeDrawable = new BadgeDrawable(context);
                int[] iArr = R$styleable.Badge;
                c.e.a.b.q.g.a(context, null, i2, i3);
                c.e.a.b.q.g.b(context, null, iArr, i2, i3, new int[0]);
                TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(null, iArr, i2, i3);
                badgeDrawable.j(typedArrayObtainStyledAttributes.getInt(R$styleable.Badge_maxCharacterCount, 4));
                int i4 = R$styleable.Badge_number;
                if (typedArrayObtainStyledAttributes.hasValue(i4)) {
                    badgeDrawable.k(typedArrayObtainStyledAttributes.getInt(i4, 0));
                }
                badgeDrawable.g(c.b.a.m.f.a2(context, typedArrayObtainStyledAttributes, R$styleable.Badge_backgroundColor).getDefaultColor());
                int i5 = R$styleable.Badge_badgeTextColor;
                if (typedArrayObtainStyledAttributes.hasValue(i5)) {
                    badgeDrawable.i(c.b.a.m.f.a2(context, typedArrayObtainStyledAttributes, i5).getDefaultColor());
                }
                badgeDrawable.h(typedArrayObtainStyledAttributes.getInt(R$styleable.Badge_badgeGravity, 8388661));
                badgeDrawable.f2003j.f2015k = typedArrayObtainStyledAttributes.getDimensionPixelOffset(R$styleable.Badge_horizontalOffset, 0);
                badgeDrawable.m();
                badgeDrawable.f2003j.f2016l = typedArrayObtainStyledAttributes.getDimensionPixelOffset(R$styleable.Badge_verticalOffset, 0);
                badgeDrawable.m();
                typedArrayObtainStyledAttributes.recycle();
                this.f2421f = badgeDrawable;
            }
            d();
            BadgeDrawable badgeDrawable2 = this.f2421f;
            if (badgeDrawable2 != null) {
                return badgeDrawable2;
            }
            throw new IllegalStateException("Unable to create badge");
        }

        public final boolean a() {
            return this.f2421f != null;
        }

        public final void b(@Nullable View view) {
            if (a() && view != null) {
                setClipChildren(false);
                setClipToPadding(false);
                ViewGroup viewGroup = (ViewGroup) getParent();
                if (viewGroup != null) {
                    viewGroup.setClipChildren(false);
                    viewGroup.setClipToPadding(false);
                }
                c.e.a.b.c.a.a(this.f2421f, view, null);
                this.f2420e = view;
            }
        }

        public final void c() {
            if (a()) {
                setClipChildren(true);
                setClipToPadding(true);
                ViewGroup viewGroup = (ViewGroup) getParent();
                if (viewGroup != null) {
                    viewGroup.setClipChildren(true);
                    viewGroup.setClipToPadding(true);
                }
                View view = this.f2420e;
                if (view != null) {
                    c.e.a.b.c.a.b(this.f2421f, view);
                    this.f2420e = null;
                }
            }
        }

        public final void d() {
            g gVar;
            g gVar2;
            if (a()) {
                if (this.f2422g != null) {
                    c();
                    return;
                }
                ImageView imageView = this.f2419d;
                if (imageView != null && (gVar2 = this.f2417b) != null && gVar2.a != null) {
                    if (this.f2420e == imageView) {
                        e(imageView);
                        return;
                    } else {
                        c();
                        b(this.f2419d);
                        return;
                    }
                }
                if (this.f2418c == null || (gVar = this.f2417b) == null) {
                    c();
                    return;
                }
                Objects.requireNonNull(gVar);
                View view = this.f2420e;
                TextView textView = this.f2418c;
                if (view == textView) {
                    e(textView);
                } else {
                    c();
                    b(this.f2418c);
                }
            }
        }

        @Override // android.view.ViewGroup, android.view.View
        public void drawableStateChanged() {
            super.drawableStateChanged();
            int[] drawableState = getDrawableState();
            Drawable drawable = this.f2425j;
            boolean state = false;
            if (drawable != null && drawable.isStateful()) {
                state = false | this.f2425j.setState(drawableState);
            }
            if (state) {
                invalidate();
                TabLayout.this.invalidate();
            }
        }

        public final void e(@NonNull View view) {
            if (a() && view == this.f2420e) {
                c.e.a.b.c.a.c(this.f2421f, view, null);
            }
        }

        public final void f() {
            Drawable drawable;
            g gVar = this.f2417b;
            Drawable drawableMutate = null;
            View view = gVar != null ? gVar.f2439e : null;
            if (view != null) {
                ViewParent parent = view.getParent();
                if (parent != this) {
                    if (parent != null) {
                        ((ViewGroup) parent).removeView(view);
                    }
                    addView(view);
                }
                this.f2422g = view;
                TextView textView = this.f2418c;
                if (textView != null) {
                    textView.setVisibility(8);
                }
                ImageView imageView = this.f2419d;
                if (imageView != null) {
                    imageView.setVisibility(8);
                    this.f2419d.setImageDrawable(null);
                }
                TextView textView2 = (TextView) view.findViewById(R.id.text1);
                this.f2423h = textView2;
                if (textView2 != null) {
                    this.f2426k = TextViewCompat.getMaxLines(textView2);
                }
                this.f2424i = (ImageView) view.findViewById(R.id.icon);
            } else {
                View view2 = this.f2422g;
                if (view2 != null) {
                    removeView(view2);
                    this.f2422g = null;
                }
                this.f2423h = null;
                this.f2424i = null;
            }
            boolean z = false;
            if (this.f2422g == null) {
                if (this.f2419d == null) {
                    ImageView imageView2 = (ImageView) LayoutInflater.from(getContext()).inflate(R$layout.design_layout_tab_icon, (ViewGroup) this, false);
                    this.f2419d = imageView2;
                    addView(imageView2, 0);
                }
                if (gVar != null && (drawable = gVar.a) != null) {
                    drawableMutate = DrawableCompat.wrap(drawable).mutate();
                }
                if (drawableMutate != null) {
                    DrawableCompat.setTintList(drawableMutate, TabLayout.this.f2414l);
                    PorterDuff.Mode mode = TabLayout.this.p;
                    if (mode != null) {
                        DrawableCompat.setTintMode(drawableMutate, mode);
                    }
                }
                if (this.f2418c == null) {
                    TextView textView3 = (TextView) LayoutInflater.from(getContext()).inflate(R$layout.design_layout_tab_text, (ViewGroup) this, false);
                    this.f2418c = textView3;
                    addView(textView3);
                    this.f2426k = TextViewCompat.getMaxLines(this.f2418c);
                }
                TextViewCompat.setTextAppearance(this.f2418c, TabLayout.this.f2412j);
                ColorStateList colorStateList = TabLayout.this.f2413k;
                if (colorStateList != null) {
                    this.f2418c.setTextColor(colorStateList);
                }
                h(this.f2418c, this.f2419d);
                d();
                ImageView imageView3 = this.f2419d;
                if (imageView3 != null) {
                    imageView3.addOnLayoutChangeListener(new c.e.a.b.z.c(this, imageView3));
                }
                TextView textView4 = this.f2418c;
                if (textView4 != null) {
                    textView4.addOnLayoutChangeListener(new c.e.a.b.z.c(this, textView4));
                }
            } else {
                TextView textView5 = this.f2423h;
                if (textView5 != null || this.f2424i != null) {
                    h(textView5, this.f2424i);
                }
            }
            if (gVar != null && !TextUtils.isEmpty(gVar.f2437c)) {
                setContentDescription(gVar.f2437c);
            }
            if (gVar != null) {
                TabLayout tabLayout = gVar.f2440f;
                if (tabLayout == null) {
                    throw new IllegalArgumentException("Tab not attached to a TabLayout");
                }
                if (tabLayout.getSelectedTabPosition() == gVar.f2438d) {
                    z = true;
                }
            }
            setSelected(z);
        }

        public final void g(Context context) {
            int i2 = TabLayout.this.s;
            if (i2 != 0) {
                Drawable drawable = AppCompatResources.getDrawable(context, i2);
                this.f2425j = drawable;
                if (drawable != null && drawable.isStateful()) {
                    this.f2425j.setState(getDrawableState());
                }
            } else {
                this.f2425j = null;
            }
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(0);
            Drawable rippleDrawable = gradientDrawable;
            if (TabLayout.this.m != null) {
                GradientDrawable gradientDrawable2 = new GradientDrawable();
                gradientDrawable2.setCornerRadius(1.0E-5f);
                gradientDrawable2.setColor(-1);
                ColorStateList colorStateListA = c.e.a.b.u.a.a(TabLayout.this.m);
                boolean z = TabLayout.this.F;
                GradientDrawable gradientDrawable3 = gradientDrawable;
                if (z) {
                    gradientDrawable3 = null;
                }
                rippleDrawable = new RippleDrawable(colorStateListA, gradientDrawable3, z ? null : gradientDrawable2);
            }
            ViewCompat.setBackground(this, rippleDrawable);
            TabLayout.this.invalidate();
        }

        public int getContentHeight() {
            View[] viewArr = {this.f2418c, this.f2419d, this.f2422g};
            int iMax = 0;
            int iMin = 0;
            boolean z = false;
            for (int i2 = 0; i2 < 3; i2++) {
                View view = viewArr[i2];
                if (view != null && view.getVisibility() == 0) {
                    iMin = z ? Math.min(iMin, view.getTop()) : view.getTop();
                    iMax = z ? Math.max(iMax, view.getBottom()) : view.getBottom();
                    z = true;
                }
            }
            return iMax - iMin;
        }

        public int getContentWidth() {
            View[] viewArr = {this.f2418c, this.f2419d, this.f2422g};
            int iMax = 0;
            int iMin = 0;
            boolean z = false;
            for (int i2 = 0; i2 < 3; i2++) {
                View view = viewArr[i2];
                if (view != null && view.getVisibility() == 0) {
                    iMin = z ? Math.min(iMin, view.getLeft()) : view.getLeft();
                    iMax = z ? Math.max(iMax, view.getRight()) : view.getRight();
                    z = true;
                }
            }
            return iMax - iMin;
        }

        @Nullable
        public g getTab() {
            return this.f2417b;
        }

        public final void h(@Nullable TextView textView, @Nullable ImageView imageView) {
            Drawable drawable;
            g gVar = this.f2417b;
            Drawable drawableMutate = (gVar == null || (drawable = gVar.a) == null) ? null : DrawableCompat.wrap(drawable).mutate();
            g gVar2 = this.f2417b;
            CharSequence charSequence = gVar2 != null ? gVar2.f2436b : null;
            if (imageView != null) {
                if (drawableMutate != null) {
                    imageView.setImageDrawable(drawableMutate);
                    imageView.setVisibility(0);
                    setVisibility(0);
                } else {
                    imageView.setVisibility(8);
                    imageView.setImageDrawable(null);
                }
            }
            boolean z = !TextUtils.isEmpty(charSequence);
            if (textView != null) {
                if (z) {
                    textView.setText(charSequence);
                    Objects.requireNonNull(this.f2417b);
                    textView.setVisibility(0);
                    setVisibility(0);
                } else {
                    textView.setVisibility(8);
                    textView.setText((CharSequence) null);
                }
            }
            if (imageView != null) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) imageView.getLayoutParams();
                int iW1 = (z && imageView.getVisibility() == 0) ? (int) c.b.a.m.f.w1(getContext(), 8) : 0;
                if (TabLayout.this.C) {
                    if (iW1 != MarginLayoutParamsCompat.getMarginEnd(marginLayoutParams)) {
                        MarginLayoutParamsCompat.setMarginEnd(marginLayoutParams, iW1);
                        marginLayoutParams.bottomMargin = 0;
                        imageView.setLayoutParams(marginLayoutParams);
                        imageView.requestLayout();
                    }
                } else if (iW1 != marginLayoutParams.bottomMargin) {
                    marginLayoutParams.bottomMargin = iW1;
                    MarginLayoutParamsCompat.setMarginEnd(marginLayoutParams, 0);
                    imageView.setLayoutParams(marginLayoutParams);
                    imageView.requestLayout();
                }
            }
            g gVar3 = this.f2417b;
            CharSequence charSequence2 = gVar3 != null ? gVar3.f2437c : null;
            if (!z) {
                charSequence = charSequence2;
            }
            TooltipCompat.setTooltipText(this, charSequence);
        }

        @Override // android.view.View
        public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            BadgeDrawable badgeDrawable = this.f2421f;
            if (badgeDrawable != null && badgeDrawable.isVisible()) {
                accessibilityNodeInfo.setContentDescription(((Object) getContentDescription()) + ", " + ((Object) this.f2421f.c()));
            }
            AccessibilityNodeInfoCompat accessibilityNodeInfoCompatWrap = AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfo);
            accessibilityNodeInfoCompatWrap.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(0, 1, this.f2417b.f2438d, 1, false, isSelected()));
            if (isSelected()) {
                accessibilityNodeInfoCompatWrap.setClickable(false);
                accessibilityNodeInfoCompatWrap.removeAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLICK);
            }
            accessibilityNodeInfoCompatWrap.setRoleDescription(getResources().getString(R$string.item_view_role_description));
        }

        /* JADX WARN: Removed duplicated region for block: B:31:0x0096  */
        @Override // android.widget.LinearLayout, android.view.View
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void onMeasure(int r8, int r9) {
            /*
                r7 = this;
                int r0 = android.view.View.MeasureSpec.getSize(r8)
                int r1 = android.view.View.MeasureSpec.getMode(r8)
                com.google.android.material.tabs.TabLayout r2 = com.google.android.material.tabs.TabLayout.this
                int r2 = r2.getTabMaxWidth()
                if (r2 <= 0) goto L1e
                if (r1 == 0) goto L14
                if (r0 <= r2) goto L1e
            L14:
                com.google.android.material.tabs.TabLayout r8 = com.google.android.material.tabs.TabLayout.this
                int r8 = r8.t
                r0 = -2147483648(0xffffffff80000000, float:-0.0)
                int r8 = android.view.View.MeasureSpec.makeMeasureSpec(r8, r0)
            L1e:
                super.onMeasure(r8, r9)
                android.widget.TextView r0 = r7.f2418c
                if (r0 == 0) goto La6
                com.google.android.material.tabs.TabLayout r0 = com.google.android.material.tabs.TabLayout.this
                float r0 = r0.q
                int r1 = r7.f2426k
                android.widget.ImageView r2 = r7.f2419d
                r3 = 1
                if (r2 == 0) goto L38
                int r2 = r2.getVisibility()
                if (r2 != 0) goto L38
                r1 = 1
                goto L46
            L38:
                android.widget.TextView r2 = r7.f2418c
                if (r2 == 0) goto L46
                int r2 = r2.getLineCount()
                if (r2 <= r3) goto L46
                com.google.android.material.tabs.TabLayout r0 = com.google.android.material.tabs.TabLayout.this
                float r0 = r0.r
            L46:
                android.widget.TextView r2 = r7.f2418c
                float r2 = r2.getTextSize()
                android.widget.TextView r4 = r7.f2418c
                int r4 = r4.getLineCount()
                android.widget.TextView r5 = r7.f2418c
                int r5 = androidx.core.widget.TextViewCompat.getMaxLines(r5)
                int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                if (r2 != 0) goto L60
                if (r5 < 0) goto La6
                if (r1 == r5) goto La6
            L60:
                com.google.android.material.tabs.TabLayout r5 = com.google.android.material.tabs.TabLayout.this
                int r5 = r5.B
                r6 = 0
                if (r5 != r3) goto L97
                if (r2 <= 0) goto L97
                if (r4 != r3) goto L97
                android.widget.TextView r2 = r7.f2418c
                android.text.Layout r2 = r2.getLayout()
                if (r2 == 0) goto L96
                float r4 = r2.getLineWidth(r6)
                android.text.TextPaint r2 = r2.getPaint()
                float r2 = r2.getTextSize()
                float r2 = r0 / r2
                float r2 = r2 * r4
                int r4 = r7.getMeasuredWidth()
                int r5 = r7.getPaddingLeft()
                int r4 = r4 - r5
                int r5 = r7.getPaddingRight()
                int r4 = r4 - r5
                float r4 = (float) r4
                int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r2 <= 0) goto L97
            L96:
                r3 = 0
            L97:
                if (r3 == 0) goto La6
                android.widget.TextView r2 = r7.f2418c
                r2.setTextSize(r6, r0)
                android.widget.TextView r0 = r7.f2418c
                r0.setMaxLines(r1)
                super.onMeasure(r8, r9)
            La6:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.tabs.TabLayout.TabView.onMeasure(int, int):void");
        }

        @Override // android.view.View
        public boolean performClick() {
            boolean zPerformClick = super.performClick();
            if (this.f2417b == null) {
                return zPerformClick;
            }
            if (!zPerformClick) {
                playSoundEffect(0);
            }
            this.f2417b.a();
            return true;
        }

        @Override // android.view.View
        public void setSelected(boolean z) {
            if (isSelected() != z) {
            }
            super.setSelected(z);
            TextView textView = this.f2418c;
            if (textView != null) {
                textView.setSelected(z);
            }
            ImageView imageView = this.f2419d;
            if (imageView != null) {
                imageView.setSelected(z);
            }
            View view = this.f2422g;
            if (view != null) {
                view.setSelected(z);
            }
        }

        public void setTab(@Nullable g gVar) {
            if (gVar != this.f2417b) {
                this.f2417b = gVar;
                f();
            }
        }
    }

    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
            TabLayout.this.scrollTo(((Integer) valueAnimator.getAnimatedValue()).intValue(), 0);
        }
    }

    public class b implements ViewPager.OnAdapterChangeListener {
        public boolean a;

        public b() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnAdapterChangeListener
        public void onAdapterChanged(@NonNull ViewPager viewPager, @Nullable PagerAdapter pagerAdapter, @Nullable PagerAdapter pagerAdapter2) {
            TabLayout tabLayout = TabLayout.this;
            if (tabLayout.O == viewPager) {
                tabLayout.l(pagerAdapter2, this.a);
            }
        }
    }

    @Deprecated
    public interface c<T extends g> {
        void K(T t);

        void m(T t);

        void x(T t);
    }

    public interface d extends c<g> {
    }

    public class e extends DataSetObserver {
        public e() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            TabLayout.this.i();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            TabLayout.this.i();
        }
    }

    public class f extends LinearLayout {
        public ValueAnimator a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f2429b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f2430c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f2431d;

        public class a implements ValueAnimator.AnimatorUpdateListener {
            public final /* synthetic */ View a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ View f2433b;

            public a(View view, View view2) {
                this.a = view;
                this.f2433b = view2;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
                f.this.c(this.a, this.f2433b, valueAnimator.getAnimatedFraction());
            }
        }

        public class b extends AnimatorListenerAdapter {
            public final /* synthetic */ int a;

            public b(int i2) {
                this.a = i2;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                f.this.f2429b = this.a;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                f.this.f2429b = this.a;
            }
        }

        public f(Context context) {
            super(context);
            this.f2429b = -1;
            this.f2431d = -1;
            setWillNotDraw(false);
        }

        public final void a() {
            View childAt = getChildAt(this.f2429b);
            TabLayout tabLayout = TabLayout.this;
            c.e.a.b.z.b bVar = tabLayout.G;
            Drawable drawable = tabLayout.n;
            Objects.requireNonNull(bVar);
            RectF rectFA = c.e.a.b.z.b.a(tabLayout, childAt);
            drawable.setBounds((int) rectFA.left, drawable.getBounds().top, (int) rectFA.right, drawable.getBounds().bottom);
        }

        public void b(int i2) {
            Rect bounds = TabLayout.this.n.getBounds();
            TabLayout.this.n.setBounds(bounds.left, 0, bounds.right, i2);
            requestLayout();
        }

        public final void c(View view, View view2, float f2) {
            if (view != null && view.getWidth() > 0) {
                TabLayout tabLayout = TabLayout.this;
                tabLayout.G.b(tabLayout, view, view2, f2, tabLayout.n);
            } else {
                Drawable drawable = TabLayout.this.n;
                drawable.setBounds(-1, drawable.getBounds().top, -1, TabLayout.this.n.getBounds().bottom);
            }
            ViewCompat.postInvalidateOnAnimation(this);
        }

        public final void d(boolean z, int i2, int i3) {
            View childAt = getChildAt(this.f2429b);
            View childAt2 = getChildAt(i2);
            if (childAt2 == null) {
                a();
                return;
            }
            a aVar = new a(childAt, childAt2);
            if (!z) {
                this.a.removeAllUpdateListeners();
                this.a.addUpdateListener(aVar);
                return;
            }
            ValueAnimator valueAnimator = new ValueAnimator();
            this.a = valueAnimator;
            valueAnimator.setInterpolator(c.e.a.b.a.a.f839b);
            valueAnimator.setDuration(i3);
            valueAnimator.setFloatValues(0.0f, 1.0f);
            valueAnimator.addUpdateListener(aVar);
            valueAnimator.addListener(new b(i2));
            valueAnimator.start();
        }

        @Override // android.view.View
        public void draw(@NonNull Canvas canvas) {
            int iHeight = TabLayout.this.n.getBounds().height();
            if (iHeight < 0) {
                iHeight = TabLayout.this.n.getIntrinsicHeight();
            }
            int i2 = TabLayout.this.A;
            int height = 0;
            if (i2 == 0) {
                height = getHeight() - iHeight;
                iHeight = getHeight();
            } else if (i2 == 1) {
                height = (getHeight() - iHeight) / 2;
                iHeight = (getHeight() + iHeight) / 2;
            } else if (i2 != 2) {
                iHeight = i2 != 3 ? 0 : getHeight();
            }
            if (TabLayout.this.n.getBounds().width() > 0) {
                Rect bounds = TabLayout.this.n.getBounds();
                TabLayout.this.n.setBounds(bounds.left, height, bounds.right, iHeight);
                TabLayout tabLayout = TabLayout.this;
                Drawable drawableWrap = tabLayout.n;
                if (tabLayout.o != 0) {
                    drawableWrap = DrawableCompat.wrap(drawableWrap);
                    if (Build.VERSION.SDK_INT == 21) {
                        drawableWrap.setColorFilter(TabLayout.this.o, PorterDuff.Mode.SRC_IN);
                    } else {
                        DrawableCompat.setTint(drawableWrap, TabLayout.this.o);
                    }
                }
                drawableWrap.draw(canvas);
            }
            super.draw(canvas);
        }

        @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
        public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
            super.onLayout(z, i2, i3, i4, i5);
            ValueAnimator valueAnimator = this.a;
            if (valueAnimator == null || !valueAnimator.isRunning()) {
                a();
            } else {
                d(false, this.f2429b, -1);
            }
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onMeasure(int i2, int i3) {
            super.onMeasure(i2, i3);
            if (View.MeasureSpec.getMode(i2) != 1073741824) {
                return;
            }
            TabLayout tabLayout = TabLayout.this;
            boolean z = true;
            if (tabLayout.y == 1 || tabLayout.B == 2) {
                int childCount = getChildCount();
                int iMax = 0;
                for (int i4 = 0; i4 < childCount; i4++) {
                    View childAt = getChildAt(i4);
                    if (childAt.getVisibility() == 0) {
                        iMax = Math.max(iMax, childAt.getMeasuredWidth());
                    }
                }
                if (iMax <= 0) {
                    return;
                }
                if (iMax * childCount <= getMeasuredWidth() - (((int) c.b.a.m.f.w1(getContext(), 16)) * 2)) {
                    boolean z2 = false;
                    for (int i5 = 0; i5 < childCount; i5++) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) getChildAt(i5).getLayoutParams();
                        if (layoutParams.width != iMax || layoutParams.weight != 0.0f) {
                            layoutParams.width = iMax;
                            layoutParams.weight = 0.0f;
                            z2 = true;
                        }
                    }
                    z = z2;
                } else {
                    TabLayout tabLayout2 = TabLayout.this;
                    tabLayout2.y = 0;
                    tabLayout2.q(false);
                }
                if (z) {
                    super.onMeasure(i2, i3);
                }
            }
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onRtlPropertiesChanged(int i2) {
            super.onRtlPropertiesChanged(i2);
            if (Build.VERSION.SDK_INT >= 23 || this.f2431d == i2) {
                return;
            }
            requestLayout();
            this.f2431d = i2;
        }
    }

    public static class g {

        @Nullable
        public Drawable a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        public CharSequence f2436b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Nullable
        public CharSequence f2437c;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @Nullable
        public View f2439e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @Nullable
        public TabLayout f2440f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @NonNull
        public TabView f2441g;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f2438d = -1;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f2442h = -1;

        public void a() {
            TabLayout tabLayout = this.f2440f;
            if (tabLayout == null) {
                throw new IllegalArgumentException("Tab not attached to a TabLayout");
            }
            tabLayout.k(this, true);
        }

        @NonNull
        public g b(@StringRes int i2) {
            TabLayout tabLayout = this.f2440f;
            if (tabLayout == null) {
                throw new IllegalArgumentException("Tab not attached to a TabLayout");
            }
            c(tabLayout.getResources().getText(i2));
            return this;
        }

        @NonNull
        public g c(@Nullable CharSequence charSequence) {
            if (TextUtils.isEmpty(this.f2437c) && !TextUtils.isEmpty(charSequence)) {
                this.f2441g.setContentDescription(charSequence);
            }
            this.f2436b = charSequence;
            d();
            return this;
        }

        public void d() {
            TabView tabView = this.f2441g;
            if (tabView != null) {
                tabView.f();
            }
        }
    }

    public static class h implements d {
        public final ViewPager a;

        public h(ViewPager viewPager) {
            this.a = viewPager;
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void K(g gVar) {
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void m(g gVar) {
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void x(@NonNull g gVar) {
            this.a.setCurrentItem(gVar.f2438d);
        }
    }

    public TabLayout(@NonNull Context context) {
        this(context, null);
    }

    @Dimension(unit = 0)
    private int getDefaultHeight() {
        int size = this.f2405c.size();
        boolean z = false;
        int i2 = 0;
        while (true) {
            if (i2 < size) {
                g gVar = this.f2405c.get(i2);
                if (gVar != null && gVar.a != null && !TextUtils.isEmpty(gVar.f2436b)) {
                    z = true;
                    break;
                }
                i2++;
            } else {
                break;
            }
        }
        return (!z || this.C) ? 48 : 72;
    }

    private int getTabMinWidth() {
        int i2 = this.u;
        if (i2 != -1) {
            return i2;
        }
        int i3 = this.B;
        if (i3 == 0 || i3 == 2) {
            return this.w;
        }
        return 0;
    }

    private int getTabScrollRange() {
        return Math.max(0, ((this.f2407e.getWidth() - getWidth()) - getPaddingLeft()) - getPaddingRight());
    }

    private void setSelectedTabView(int i2) {
        int childCount = this.f2407e.getChildCount();
        if (i2 < childCount) {
            int i3 = 0;
            while (i3 < childCount) {
                View childAt = this.f2407e.getChildAt(i3);
                boolean z = true;
                childAt.setSelected(i3 == i2);
                if (i3 != i2) {
                    z = false;
                }
                childAt.setActivated(z);
                i3++;
            }
        }
    }

    public void a(@NonNull g gVar, boolean z) {
        int size = this.f2405c.size();
        if (gVar.f2440f != this) {
            throw new IllegalArgumentException("Tab belongs to a different TabLayout.");
        }
        gVar.f2438d = size;
        this.f2405c.add(size, gVar);
        int size2 = this.f2405c.size();
        while (true) {
            size++;
            if (size >= size2) {
                break;
            } else {
                this.f2405c.get(size).f2438d = size;
            }
        }
        TabView tabView = gVar.f2441g;
        tabView.setSelected(false);
        tabView.setActivated(false);
        f fVar = this.f2407e;
        int i2 = gVar.f2438d;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        p(layoutParams);
        fVar.addView(tabView, i2, layoutParams);
        if (z) {
            gVar.a();
        }
    }

    public void addOnTabSelectedListener(@NonNull d dVar) {
        addOnTabSelectedListener((c) dVar);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view) {
        b(view);
    }

    public final void b(View view) {
        if (!(view instanceof TabItem)) {
            throw new IllegalArgumentException("Only TabItem instances can be added to TabLayout");
        }
        TabItem tabItem = (TabItem) view;
        g gVarH = h();
        CharSequence charSequence = tabItem.a;
        if (charSequence != null) {
            gVarH.c(charSequence);
        }
        Drawable drawable = tabItem.f2402b;
        if (drawable != null) {
            gVarH.a = drawable;
            TabLayout tabLayout = gVarH.f2440f;
            if (tabLayout.y == 1 || tabLayout.B == 2) {
                tabLayout.q(true);
            }
            gVarH.d();
        }
        int i2 = tabItem.f2403c;
        if (i2 != 0) {
            gVarH.f2439e = LayoutInflater.from(gVarH.f2441g.getContext()).inflate(i2, (ViewGroup) gVarH.f2441g, false);
            gVarH.d();
        }
        if (!TextUtils.isEmpty(tabItem.getContentDescription())) {
            gVarH.f2437c = tabItem.getContentDescription();
            gVarH.d();
        }
        a(gVarH, this.f2405c.isEmpty());
    }

    public final void c(int i2) {
        boolean z;
        if (i2 == -1) {
            return;
        }
        if (getWindowToken() != null && ViewCompat.isLaidOut(this)) {
            f fVar = this.f2407e;
            int childCount = fVar.getChildCount();
            int i3 = 0;
            while (true) {
                if (i3 >= childCount) {
                    z = false;
                    break;
                } else {
                    if (fVar.getChildAt(i3).getWidth() <= 0) {
                        z = true;
                        break;
                    }
                    i3++;
                }
            }
            if (!z) {
                int scrollX = getScrollX();
                int iE = e(i2, 0.0f);
                if (scrollX != iE) {
                    f();
                    this.K.setIntValues(scrollX, iE);
                    this.K.start();
                }
                f fVar2 = this.f2407e;
                int i4 = this.z;
                ValueAnimator valueAnimator = fVar2.a;
                if (valueAnimator != null && valueAnimator.isRunning()) {
                    fVar2.a.cancel();
                }
                fVar2.d(true, i2, i4);
                return;
            }
        }
        m(i2, 0.0f, true, true);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x003a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void d() {
        /*
            r4 = this;
            int r0 = r4.B
            r1 = 2
            r2 = 0
            if (r0 == 0) goto Lb
            if (r0 != r1) goto L9
            goto Lb
        L9:
            r0 = 0
            goto L14
        Lb:
            int r0 = r4.x
            int r3 = r4.f2408f
            int r0 = r0 - r3
            int r0 = java.lang.Math.max(r2, r0)
        L14:
            com.google.android.material.tabs.TabLayout$f r3 = r4.f2407e
            androidx.core.view.ViewCompat.setPaddingRelative(r3, r0, r2, r2, r2)
            int r0 = r4.B
            r2 = 1
            if (r0 == 0) goto L2b
            if (r0 == r2) goto L23
            if (r0 == r1) goto L23
            goto L42
        L23:
            int r0 = r4.y
            com.google.android.material.tabs.TabLayout$f r0 = r4.f2407e
            r0.setGravity(r2)
            goto L42
        L2b:
            int r0 = r4.y
            if (r0 == 0) goto L3a
            if (r0 == r2) goto L34
            if (r0 == r1) goto L3a
            goto L42
        L34:
            com.google.android.material.tabs.TabLayout$f r0 = r4.f2407e
            r0.setGravity(r2)
            goto L42
        L3a:
            com.google.android.material.tabs.TabLayout$f r0 = r4.f2407e
            r1 = 8388611(0x800003, float:1.1754948E-38)
            r0.setGravity(r1)
        L42:
            r4.q(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.tabs.TabLayout.d():void");
    }

    public final int e(int i2, float f2) {
        int i3 = this.B;
        if (i3 != 0 && i3 != 2) {
            return 0;
        }
        View childAt = this.f2407e.getChildAt(i2);
        int i4 = i2 + 1;
        View childAt2 = i4 < this.f2407e.getChildCount() ? this.f2407e.getChildAt(i4) : null;
        int width = childAt != null ? childAt.getWidth() : 0;
        int width2 = childAt2 != null ? childAt2.getWidth() : 0;
        int left = ((width / 2) + childAt.getLeft()) - (getWidth() / 2);
        int i5 = (int) ((width + width2) * 0.5f * f2);
        return ViewCompat.getLayoutDirection(this) == 0 ? left + i5 : left - i5;
    }

    public final void f() {
        if (this.K == null) {
            ValueAnimator valueAnimator = new ValueAnimator();
            this.K = valueAnimator;
            valueAnimator.setInterpolator(c.e.a.b.a.a.f839b);
            this.K.setDuration(this.z);
            this.K.addUpdateListener(new a());
        }
    }

    @Nullable
    public g g(int i2) {
        if (i2 < 0 || i2 >= getTabCount()) {
            return null;
        }
        return this.f2405c.get(i2);
    }

    public int getSelectedTabPosition() {
        g gVar = this.f2406d;
        if (gVar != null) {
            return gVar.f2438d;
        }
        return -1;
    }

    public int getTabCount() {
        return this.f2405c.size();
    }

    public int getTabGravity() {
        return this.y;
    }

    @Nullable
    public ColorStateList getTabIconTint() {
        return this.f2414l;
    }

    public int getTabIndicatorAnimationMode() {
        return this.E;
    }

    public int getTabIndicatorGravity() {
        return this.A;
    }

    public int getTabMaxWidth() {
        return this.t;
    }

    public int getTabMode() {
        return this.B;
    }

    @Nullable
    public ColorStateList getTabRippleColor() {
        return this.m;
    }

    @NonNull
    public Drawable getTabSelectedIndicator() {
        return this.n;
    }

    @Nullable
    public ColorStateList getTabTextColors() {
        return this.f2413k;
    }

    @NonNull
    public g h() {
        g gVarAcquire = f2404b.acquire();
        if (gVarAcquire == null) {
            gVarAcquire = new g();
        }
        gVarAcquire.f2440f = this;
        Pools.Pool<TabView> pool = this.U;
        TabView tabViewAcquire = pool != null ? pool.acquire() : null;
        if (tabViewAcquire == null) {
            tabViewAcquire = new TabView(getContext());
        }
        tabViewAcquire.setTab(gVarAcquire);
        tabViewAcquire.setFocusable(true);
        tabViewAcquire.setMinimumWidth(getTabMinWidth());
        if (TextUtils.isEmpty(gVarAcquire.f2437c)) {
            tabViewAcquire.setContentDescription(gVarAcquire.f2436b);
        } else {
            tabViewAcquire.setContentDescription(gVarAcquire.f2437c);
        }
        gVarAcquire.f2441g = tabViewAcquire;
        int i2 = gVarAcquire.f2442h;
        if (i2 != -1) {
            tabViewAcquire.setId(i2);
        }
        return gVarAcquire;
    }

    public void i() {
        int currentItem;
        j();
        PagerAdapter pagerAdapter = this.P;
        if (pagerAdapter != null) {
            int count = pagerAdapter.getCount();
            for (int i2 = 0; i2 < count; i2++) {
                g gVarH = h();
                gVarH.c(this.P.getPageTitle(i2));
                a(gVarH, false);
            }
            ViewPager viewPager = this.O;
            if (viewPager == null || count <= 0 || (currentItem = viewPager.getCurrentItem()) == getSelectedTabPosition() || currentItem >= getTabCount()) {
                return;
            }
            k(g(currentItem), true);
        }
    }

    public void j() {
        int childCount = this.f2407e.getChildCount();
        while (true) {
            childCount--;
            if (childCount < 0) {
                break;
            }
            TabView tabView = (TabView) this.f2407e.getChildAt(childCount);
            this.f2407e.removeViewAt(childCount);
            if (tabView != null) {
                tabView.setTab(null);
                tabView.setSelected(false);
                this.U.release(tabView);
            }
            requestLayout();
        }
        Iterator<g> it = this.f2405c.iterator();
        while (it.hasNext()) {
            g next = it.next();
            it.remove();
            next.f2440f = null;
            next.f2441g = null;
            next.a = null;
            next.f2442h = -1;
            next.f2436b = null;
            next.f2437c = null;
            next.f2438d = -1;
            next.f2439e = null;
            f2404b.release(next);
        }
        this.f2406d = null;
    }

    public void k(@Nullable g gVar, boolean z) {
        g gVar2 = this.f2406d;
        if (gVar2 == gVar) {
            if (gVar2 != null) {
                for (int size = this.I.size() - 1; size >= 0; size--) {
                    this.I.get(size).m(gVar);
                }
                c(gVar.f2438d);
                return;
            }
            return;
        }
        int i2 = gVar != null ? gVar.f2438d : -1;
        if (z) {
            if ((gVar2 == null || gVar2.f2438d == -1) && i2 != -1) {
                m(i2, 0.0f, true, true);
            } else {
                c(i2);
            }
            if (i2 != -1) {
                setSelectedTabView(i2);
            }
        }
        this.f2406d = gVar;
        if (gVar2 != null) {
            for (int size2 = this.I.size() - 1; size2 >= 0; size2--) {
                this.I.get(size2).K(gVar2);
            }
        }
        if (gVar != null) {
            for (int size3 = this.I.size() - 1; size3 >= 0; size3--) {
                this.I.get(size3).x(gVar);
            }
        }
    }

    public void l(@Nullable PagerAdapter pagerAdapter, boolean z) {
        DataSetObserver dataSetObserver;
        PagerAdapter pagerAdapter2 = this.P;
        if (pagerAdapter2 != null && (dataSetObserver = this.Q) != null) {
            pagerAdapter2.unregisterDataSetObserver(dataSetObserver);
        }
        this.P = pagerAdapter;
        if (z && pagerAdapter != null) {
            if (this.Q == null) {
                this.Q = new e();
            }
            pagerAdapter.registerDataSetObserver(this.Q);
        }
        i();
    }

    public void m(int i2, float f2, boolean z, boolean z2) {
        int iRound = Math.round(i2 + f2);
        if (iRound < 0 || iRound >= this.f2407e.getChildCount()) {
            return;
        }
        if (z2) {
            f fVar = this.f2407e;
            ValueAnimator valueAnimator = fVar.a;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                fVar.a.cancel();
            }
            fVar.f2429b = i2;
            fVar.f2430c = f2;
            fVar.c(fVar.getChildAt(i2), fVar.getChildAt(fVar.f2429b + 1), fVar.f2430c);
        }
        ValueAnimator valueAnimator2 = this.K;
        if (valueAnimator2 != null && valueAnimator2.isRunning()) {
            this.K.cancel();
        }
        scrollTo(e(i2, f2), 0);
        if (z) {
            setSelectedTabView(iRound);
        }
    }

    public final void n(@Nullable ViewPager viewPager, boolean z, boolean z2) {
        ViewPager viewPager2 = this.O;
        if (viewPager2 != null) {
            TabLayoutOnPageChangeListener tabLayoutOnPageChangeListener = this.R;
            if (tabLayoutOnPageChangeListener != null) {
                viewPager2.removeOnPageChangeListener(tabLayoutOnPageChangeListener);
            }
            b bVar = this.S;
            if (bVar != null) {
                this.O.removeOnAdapterChangeListener(bVar);
            }
        }
        c cVar = this.J;
        if (cVar != null) {
            removeOnTabSelectedListener(cVar);
            this.J = null;
        }
        if (viewPager != null) {
            this.O = viewPager;
            if (this.R == null) {
                this.R = new TabLayoutOnPageChangeListener(this);
            }
            TabLayoutOnPageChangeListener tabLayoutOnPageChangeListener2 = this.R;
            tabLayoutOnPageChangeListener2.f2416c = 0;
            tabLayoutOnPageChangeListener2.f2415b = 0;
            viewPager.addOnPageChangeListener(tabLayoutOnPageChangeListener2);
            h hVar = new h(viewPager);
            this.J = hVar;
            addOnTabSelectedListener((c) hVar);
            PagerAdapter adapter = viewPager.getAdapter();
            if (adapter != null) {
                l(adapter, z);
            }
            if (this.S == null) {
                this.S = new b();
            }
            b bVar2 = this.S;
            bVar2.a = z;
            viewPager.addOnAdapterChangeListener(bVar2);
            m(viewPager.getCurrentItem(), 0.0f, true, true);
        } else {
            this.O = null;
            l(null, false);
        }
        this.T = z2;
    }

    public final void o() {
        int size = this.f2405c.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.f2405c.get(i2).d();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Drawable background = getBackground();
        if (background instanceof MaterialShapeDrawable) {
            c.b.a.m.f.e5(this, (MaterialShapeDrawable) background);
        }
        if (this.O == null) {
            ViewParent parent = getParent();
            if (parent instanceof ViewPager) {
                n((ViewPager) parent, true, true);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.T) {
            setupWithViewPager(null);
            this.T = false;
        }
    }

    @Override // android.view.View
    public void onDraw(@NonNull Canvas canvas) {
        TabView tabView;
        Drawable drawable;
        for (int i2 = 0; i2 < this.f2407e.getChildCount(); i2++) {
            View childAt = this.f2407e.getChildAt(i2);
            if ((childAt instanceof TabView) && (drawable = (tabView = (TabView) childAt).f2425j) != null) {
                drawable.setBounds(tabView.getLeft(), tabView.getTop(), tabView.getRight(), tabView.getBottom());
                tabView.f2425j.draw(canvas);
            }
        }
        super.onDraw(canvas);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfo).setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(1, getTabCount(), false, 1));
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0082  */
    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onMeasure(int r7, int r8) {
        /*
            r6 = this;
            android.content.Context r0 = r6.getContext()
            int r1 = r6.getDefaultHeight()
            float r0 = c.b.a.m.f.w1(r0, r1)
            int r0 = java.lang.Math.round(r0)
            int r1 = android.view.View.MeasureSpec.getMode(r8)
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = 1073741824(0x40000000, float:2.0)
            r4 = 0
            r5 = 1
            if (r1 == r2) goto L2e
            if (r1 == 0) goto L1f
            goto L41
        L1f:
            int r8 = r6.getPaddingTop()
            int r8 = r8 + r0
            int r0 = r6.getPaddingBottom()
            int r0 = r0 + r8
            int r8 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r3)
            goto L41
        L2e:
            int r1 = r6.getChildCount()
            if (r1 != r5) goto L41
            int r1 = android.view.View.MeasureSpec.getSize(r8)
            if (r1 < r0) goto L41
            android.view.View r1 = r6.getChildAt(r4)
            r1.setMinimumHeight(r0)
        L41:
            int r0 = android.view.View.MeasureSpec.getSize(r7)
            int r1 = android.view.View.MeasureSpec.getMode(r7)
            if (r1 == 0) goto L5f
            int r1 = r6.v
            if (r1 <= 0) goto L50
            goto L5d
        L50:
            float r0 = (float) r0
            android.content.Context r1 = r6.getContext()
            r2 = 56
            float r1 = c.b.a.m.f.w1(r1, r2)
            float r0 = r0 - r1
            int r1 = (int) r0
        L5d:
            r6.t = r1
        L5f:
            super.onMeasure(r7, r8)
            int r7 = r6.getChildCount()
            if (r7 != r5) goto Lad
            android.view.View r7 = r6.getChildAt(r4)
            int r0 = r6.B
            if (r0 == 0) goto L82
            if (r0 == r5) goto L76
            r1 = 2
            if (r0 == r1) goto L82
            goto L8d
        L76:
            int r0 = r7.getMeasuredWidth()
            int r1 = r6.getMeasuredWidth()
            if (r0 == r1) goto L8d
        L80:
            r4 = 1
            goto L8d
        L82:
            int r0 = r7.getMeasuredWidth()
            int r1 = r6.getMeasuredWidth()
            if (r0 >= r1) goto L8d
            goto L80
        L8d:
            if (r4 == 0) goto Lad
            int r0 = r6.getPaddingTop()
            int r1 = r6.getPaddingBottom()
            int r1 = r1 + r0
            android.view.ViewGroup$LayoutParams r0 = r7.getLayoutParams()
            int r0 = r0.height
            int r8 = android.widget.HorizontalScrollView.getChildMeasureSpec(r8, r1, r0)
            int r0 = r6.getMeasuredWidth()
            int r0 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r3)
            r7.measure(r0, r8)
        Lad:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.tabs.TabLayout.onMeasure(int, int):void");
    }

    public final void p(@NonNull LinearLayout.LayoutParams layoutParams) {
        if (this.B == 1 && this.y == 0) {
            layoutParams.width = 0;
            layoutParams.weight = 1.0f;
        } else {
            layoutParams.width = -2;
            layoutParams.weight = 0.0f;
        }
    }

    public void q(boolean z) {
        for (int i2 = 0; i2 < this.f2407e.getChildCount(); i2++) {
            View childAt = this.f2407e.getChildAt(i2);
            childAt.setMinimumWidth(getTabMinWidth());
            p((LinearLayout.LayoutParams) childAt.getLayoutParams());
            if (z) {
                childAt.requestLayout();
            }
        }
    }

    public void removeOnTabSelectedListener(@NonNull d dVar) {
        removeOnTabSelectedListener((c) dVar);
    }

    @Override // android.view.View
    @RequiresApi(21)
    public void setElevation(float f2) {
        super.setElevation(f2);
        c.b.a.m.f.d5(this, f2);
    }

    public void setInlineLabel(boolean z) {
        if (this.C != z) {
            this.C = z;
            for (int i2 = 0; i2 < this.f2407e.getChildCount(); i2++) {
                View childAt = this.f2407e.getChildAt(i2);
                if (childAt instanceof TabView) {
                    TabView tabView = (TabView) childAt;
                    tabView.setOrientation(!TabLayout.this.C ? 1 : 0);
                    TextView textView = tabView.f2423h;
                    if (textView == null && tabView.f2424i == null) {
                        tabView.h(tabView.f2418c, tabView.f2419d);
                    } else {
                        tabView.h(textView, tabView.f2424i);
                    }
                }
            }
            d();
        }
    }

    public void setInlineLabelResource(@BoolRes int i2) {
        setInlineLabel(getResources().getBoolean(i2));
    }

    @Deprecated
    public void setOnTabSelectedListener(@Nullable d dVar) {
        setOnTabSelectedListener((c) dVar);
    }

    public void setScrollAnimatorListener(Animator.AnimatorListener animatorListener) {
        f();
        this.K.addListener(animatorListener);
    }

    public void setSelectedTabIndicator(@Nullable Drawable drawable) {
        if (this.n != drawable) {
            if (drawable == null) {
                drawable = new GradientDrawable();
            }
            this.n = drawable;
        }
    }

    public void setSelectedTabIndicatorColor(@ColorInt int i2) {
        this.o = i2;
    }

    public void setSelectedTabIndicatorGravity(int i2) {
        if (this.A != i2) {
            this.A = i2;
            ViewCompat.postInvalidateOnAnimation(this.f2407e);
        }
    }

    @Deprecated
    public void setSelectedTabIndicatorHeight(int i2) {
        this.f2407e.b(i2);
    }

    public void setTabGravity(int i2) {
        if (this.y != i2) {
            this.y = i2;
            d();
        }
    }

    public void setTabIconTint(@Nullable ColorStateList colorStateList) {
        if (this.f2414l != colorStateList) {
            this.f2414l = colorStateList;
            o();
        }
    }

    public void setTabIconTintResource(@ColorRes int i2) {
        setTabIconTint(AppCompatResources.getColorStateList(getContext(), i2));
    }

    public void setTabIndicatorAnimationMode(int i2) {
        this.E = i2;
        if (i2 == 0) {
            this.G = new c.e.a.b.z.b();
        } else {
            if (i2 == 1) {
                this.G = new c.e.a.b.z.a();
                return;
            }
            throw new IllegalArgumentException(i2 + " is not a valid TabIndicatorAnimationMode");
        }
    }

    public void setTabIndicatorFullWidth(boolean z) {
        this.D = z;
        ViewCompat.postInvalidateOnAnimation(this.f2407e);
    }

    public void setTabMode(int i2) {
        if (i2 != this.B) {
            this.B = i2;
            d();
        }
    }

    public void setTabRippleColor(@Nullable ColorStateList colorStateList) {
        if (this.m != colorStateList) {
            this.m = colorStateList;
            for (int i2 = 0; i2 < this.f2407e.getChildCount(); i2++) {
                View childAt = this.f2407e.getChildAt(i2);
                if (childAt instanceof TabView) {
                    Context context = getContext();
                    int i3 = TabView.a;
                    ((TabView) childAt).g(context);
                }
            }
        }
    }

    public void setTabRippleColorResource(@ColorRes int i2) {
        setTabRippleColor(AppCompatResources.getColorStateList(getContext(), i2));
    }

    public void setTabTextColors(@Nullable ColorStateList colorStateList) {
        if (this.f2413k != colorStateList) {
            this.f2413k = colorStateList;
            o();
        }
    }

    @Deprecated
    public void setTabsFromPagerAdapter(@Nullable PagerAdapter pagerAdapter) {
        l(pagerAdapter, false);
    }

    public void setUnboundedRipple(boolean z) {
        if (this.F != z) {
            this.F = z;
            for (int i2 = 0; i2 < this.f2407e.getChildCount(); i2++) {
                View childAt = this.f2407e.getChildAt(i2);
                if (childAt instanceof TabView) {
                    Context context = getContext();
                    int i3 = TabView.a;
                    ((TabView) childAt).g(context);
                }
            }
        }
    }

    public void setUnboundedRippleResource(@BoolRes int i2) {
        setUnboundedRipple(getResources().getBoolean(i2));
    }

    public void setupWithViewPager(@Nullable ViewPager viewPager) {
        n(viewPager, true, false);
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return getTabScrollRange() > 0;
    }

    public TabLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.tabStyle);
    }

    @Deprecated
    public void addOnTabSelectedListener(@Nullable c cVar) {
        if (this.I.contains(cVar)) {
            return;
        }
        this.I.add(cVar);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view, int i2) {
        b(view);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return generateDefaultLayoutParams();
    }

    @Deprecated
    public void removeOnTabSelectedListener(@Nullable c cVar) {
        this.I.remove(cVar);
    }

    @Deprecated
    public void setOnTabSelectedListener(@Nullable c cVar) {
        c cVar2 = this.H;
        if (cVar2 != null) {
            removeOnTabSelectedListener(cVar2);
        }
        this.H = cVar;
        if (cVar != null) {
            addOnTabSelectedListener(cVar);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public TabLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        int i3 = a;
        super(c.e.a.b.b0.a.a.a(context, attributeSet, i2, i3), attributeSet, i2);
        this.f2405c = new ArrayList<>();
        this.n = new GradientDrawable();
        this.o = 0;
        this.t = Integer.MAX_VALUE;
        this.I = new ArrayList<>();
        this.U = new Pools.SimplePool(12);
        Context context2 = getContext();
        setHorizontalScrollBarEnabled(false);
        f fVar = new f(context2);
        this.f2407e = fVar;
        super.addView(fVar, 0, new FrameLayout.LayoutParams(-2, -1));
        int[] iArr = R$styleable.TabLayout;
        int i4 = R$styleable.TabLayout_tabTextAppearance;
        TypedArray typedArrayD = c.e.a.b.q.g.d(context2, attributeSet, iArr, i2, i3, i4);
        if (getBackground() instanceof ColorDrawable) {
            ColorDrawable colorDrawable = (ColorDrawable) getBackground();
            MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable();
            materialShapeDrawable.q(ColorStateList.valueOf(colorDrawable.getColor()));
            materialShapeDrawable.f2333c.f2343b = new c.e.a.b.n.a(context2);
            materialShapeDrawable.C();
            materialShapeDrawable.p(ViewCompat.getElevation(this));
            ViewCompat.setBackground(this, materialShapeDrawable);
        }
        setSelectedTabIndicator(c.b.a.m.f.n2(context2, typedArrayD, R$styleable.TabLayout_tabIndicator));
        setSelectedTabIndicatorColor(typedArrayD.getColor(R$styleable.TabLayout_tabIndicatorColor, 0));
        fVar.b(typedArrayD.getDimensionPixelSize(R$styleable.TabLayout_tabIndicatorHeight, -1));
        setSelectedTabIndicatorGravity(typedArrayD.getInt(R$styleable.TabLayout_tabIndicatorGravity, 0));
        setTabIndicatorFullWidth(typedArrayD.getBoolean(R$styleable.TabLayout_tabIndicatorFullWidth, true));
        setTabIndicatorAnimationMode(typedArrayD.getInt(R$styleable.TabLayout_tabIndicatorAnimationMode, 0));
        int dimensionPixelSize = typedArrayD.getDimensionPixelSize(R$styleable.TabLayout_tabPadding, 0);
        this.f2411i = dimensionPixelSize;
        this.f2410h = dimensionPixelSize;
        this.f2409g = dimensionPixelSize;
        this.f2408f = dimensionPixelSize;
        this.f2408f = typedArrayD.getDimensionPixelSize(R$styleable.TabLayout_tabPaddingStart, dimensionPixelSize);
        this.f2409g = typedArrayD.getDimensionPixelSize(R$styleable.TabLayout_tabPaddingTop, this.f2409g);
        this.f2410h = typedArrayD.getDimensionPixelSize(R$styleable.TabLayout_tabPaddingEnd, this.f2410h);
        this.f2411i = typedArrayD.getDimensionPixelSize(R$styleable.TabLayout_tabPaddingBottom, this.f2411i);
        int resourceId = typedArrayD.getResourceId(i4, R$style.TextAppearance_Design_Tab);
        this.f2412j = resourceId;
        TypedArray typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(resourceId, androidx.appcompat.R.styleable.TextAppearance);
        try {
            this.q = typedArrayObtainStyledAttributes.getDimensionPixelSize(androidx.appcompat.R.styleable.TextAppearance_android_textSize, 0);
            this.f2413k = c.b.a.m.f.a2(context2, typedArrayObtainStyledAttributes, androidx.appcompat.R.styleable.TextAppearance_android_textColor);
            typedArrayObtainStyledAttributes.recycle();
            int i5 = R$styleable.TabLayout_tabTextColor;
            if (typedArrayD.hasValue(i5)) {
                this.f2413k = c.b.a.m.f.a2(context2, typedArrayD, i5);
            }
            int i6 = R$styleable.TabLayout_tabSelectedTextColor;
            if (typedArrayD.hasValue(i6)) {
                this.f2413k = new ColorStateList(new int[][]{HorizontalScrollView.SELECTED_STATE_SET, HorizontalScrollView.EMPTY_STATE_SET}, new int[]{typedArrayD.getColor(i6, 0), this.f2413k.getDefaultColor()});
            }
            this.f2414l = c.b.a.m.f.a2(context2, typedArrayD, R$styleable.TabLayout_tabIconTint);
            this.p = c.b.a.m.f.j4(typedArrayD.getInt(R$styleable.TabLayout_tabIconTintMode, -1), null);
            this.m = c.b.a.m.f.a2(context2, typedArrayD, R$styleable.TabLayout_tabRippleColor);
            this.z = typedArrayD.getInt(R$styleable.TabLayout_tabIndicatorAnimationDuration, 300);
            this.u = typedArrayD.getDimensionPixelSize(R$styleable.TabLayout_tabMinWidth, -1);
            this.v = typedArrayD.getDimensionPixelSize(R$styleable.TabLayout_tabMaxWidth, -1);
            this.s = typedArrayD.getResourceId(R$styleable.TabLayout_tabBackground, 0);
            this.x = typedArrayD.getDimensionPixelSize(R$styleable.TabLayout_tabContentStart, 0);
            this.B = typedArrayD.getInt(R$styleable.TabLayout_tabMode, 1);
            this.y = typedArrayD.getInt(R$styleable.TabLayout_tabGravity, 0);
            this.C = typedArrayD.getBoolean(R$styleable.TabLayout_tabInlineLabel, false);
            this.F = typedArrayD.getBoolean(R$styleable.TabLayout_tabUnboundedRipple, false);
            typedArrayD.recycle();
            Resources resources = getResources();
            this.r = resources.getDimensionPixelSize(R$dimen.design_tab_text_size_2line);
            this.w = resources.getDimensionPixelSize(R$dimen.design_tab_scrollable_min_width);
            d();
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        b(view);
    }

    public void setSelectedTabIndicator(@DrawableRes int i2) {
        if (i2 != 0) {
            setSelectedTabIndicator(AppCompatResources.getDrawable(getContext(), i2));
        } else {
            setSelectedTabIndicator((Drawable) null);
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        b(view);
    }
}

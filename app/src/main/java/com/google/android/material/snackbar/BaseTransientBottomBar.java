package com.google.android.material.snackbar;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import android.widget.FrameLayout;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import c.e.a.b.y.i;
import c.e.a.b.y.j;
import c.e.a.b.y.k;
import c.e.a.b.y.l;
import c.e.a.b.y.m;
import c.e.a.b.y.n;
import c.e.a.b.y.o;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$layout;
import com.google.android.material.R$styleable;
import com.google.android.material.behavior.SwipeDismissBehavior;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseTransientBottomBar<B extends BaseTransientBottomBar<B>> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final ViewGroup f2376d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Context f2377e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final SnackbarBaseLayout f2378f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final n f2379g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f2380h;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    public Rect f2382j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f2383k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f2384l;
    public int m;
    public int n;
    public int o;

    @Nullable
    public final AccessibilityManager p;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int[] f2374b = {R$attr.snackbarStyle};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f2375c = BaseTransientBottomBar.class.getSimpleName();

    @NonNull
    public static final Handler a = new Handler(Looper.getMainLooper(), new a());

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @RequiresApi(29)
    public final Runnable f2381i = new b();

    @NonNull
    public o.b q = new e();

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface AnimationMode {
    }

    public static class Behavior extends SwipeDismissBehavior<View> {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        @NonNull
        public final f f2385i = new f(this);

        @Override // com.google.android.material.behavior.SwipeDismissBehavior
        public boolean a(View view) {
            Objects.requireNonNull(this.f2385i);
            return view instanceof SnackbarBaseLayout;
        }

        @Override // com.google.android.material.behavior.SwipeDismissBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean onInterceptTouchEvent(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull MotionEvent motionEvent) {
            f fVar = this.f2385i;
            Objects.requireNonNull(fVar);
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked != 0) {
                if (actionMasked == 1 || actionMasked == 3) {
                    o.b().f(fVar.a);
                }
            } else if (coordinatorLayout.isPointInChildBounds(view, (int) motionEvent.getX(), (int) motionEvent.getY())) {
                o.b().e(fVar.a);
            }
            return super.onInterceptTouchEvent(coordinatorLayout, view, motionEvent);
        }
    }

    @IntRange(from = 1)
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface Duration {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static class SnackbarBaseLayout extends FrameLayout {
        public static final View.OnTouchListener a = new a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public h f2386b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public g f2387c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f2388d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final float f2389e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final float f2390f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public ColorStateList f2391g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public PorterDuff.Mode f2392h;

        public static class a implements View.OnTouchListener {
            @Override // android.view.View.OnTouchListener
            @SuppressLint({"ClickableViewAccessibility"})
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        }

        public SnackbarBaseLayout(@NonNull Context context, AttributeSet attributeSet) {
            Drawable drawableWrap;
            super(c.e.a.b.b0.a.a.a(context, attributeSet, 0, 0), attributeSet);
            Context context2 = getContext();
            TypedArray typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, R$styleable.SnackbarLayout);
            if (typedArrayObtainStyledAttributes.hasValue(R$styleable.SnackbarLayout_elevation)) {
                ViewCompat.setElevation(this, typedArrayObtainStyledAttributes.getDimensionPixelSize(r1, 0));
            }
            this.f2388d = typedArrayObtainStyledAttributes.getInt(R$styleable.SnackbarLayout_animationMode, 0);
            this.f2389e = typedArrayObtainStyledAttributes.getFloat(R$styleable.SnackbarLayout_backgroundOverlayColorAlpha, 1.0f);
            setBackgroundTintList(c.b.a.m.f.a2(context2, typedArrayObtainStyledAttributes, R$styleable.SnackbarLayout_backgroundTint));
            setBackgroundTintMode(c.b.a.m.f.j4(typedArrayObtainStyledAttributes.getInt(R$styleable.SnackbarLayout_backgroundTintMode, -1), PorterDuff.Mode.SRC_IN));
            this.f2390f = typedArrayObtainStyledAttributes.getFloat(R$styleable.SnackbarLayout_actionTextColorAlpha, 1.0f);
            typedArrayObtainStyledAttributes.recycle();
            setOnTouchListener(a);
            setFocusable(true);
            if (getBackground() == null) {
                float dimension = getResources().getDimension(R$dimen.mtrl_snackbar_background_corner_radius);
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setShape(0);
                gradientDrawable.setCornerRadius(dimension);
                gradientDrawable.setColor(c.b.a.m.f.M3(c.b.a.m.f.Z1(this, R$attr.colorSurface), c.b.a.m.f.Z1(this, R$attr.colorOnSurface), getBackgroundOverlayColorAlpha()));
                if (this.f2391g != null) {
                    drawableWrap = DrawableCompat.wrap(gradientDrawable);
                    DrawableCompat.setTintList(drawableWrap, this.f2391g);
                } else {
                    drawableWrap = DrawableCompat.wrap(gradientDrawable);
                }
                ViewCompat.setBackground(this, drawableWrap);
            }
        }

        public float getActionTextColorAlpha() {
            return this.f2390f;
        }

        public int getAnimationMode() {
            return this.f2388d;
        }

        public float getBackgroundOverlayColorAlpha() {
            return this.f2389e;
        }

        @Override // android.view.ViewGroup, android.view.View
        public void onAttachedToWindow() {
            WindowInsets rootWindowInsets;
            super.onAttachedToWindow();
            g gVar = this.f2387c;
            if (gVar != null) {
                k kVar = (k) gVar;
                Objects.requireNonNull(kVar);
                if (Build.VERSION.SDK_INT >= 29 && (rootWindowInsets = kVar.a.f2378f.getRootWindowInsets()) != null) {
                    kVar.a.n = rootWindowInsets.getMandatorySystemGestureInsets().bottom;
                    kVar.a.h();
                }
            }
            ViewCompat.requestApplyInsets(this);
        }

        @Override // android.view.ViewGroup, android.view.View
        public void onDetachedFromWindow() {
            boolean z;
            super.onDetachedFromWindow();
            g gVar = this.f2387c;
            if (gVar != null) {
                k kVar = (k) gVar;
                BaseTransientBottomBar baseTransientBottomBar = kVar.a;
                Objects.requireNonNull(baseTransientBottomBar);
                o oVarB = o.b();
                o.b bVar = baseTransientBottomBar.q;
                synchronized (oVarB.f1287b) {
                    z = oVarB.c(bVar) || oVarB.d(bVar);
                }
                if (z) {
                    BaseTransientBottomBar.a.post(new j(kVar));
                }
            }
        }

        @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
            super.onLayout(z, i2, i3, i4, i5);
            h hVar = this.f2386b;
            if (hVar != null) {
                l lVar = (l) hVar;
                lVar.a.f2378f.setOnLayoutChangeListener(null);
                lVar.a.g();
            }
        }

        public void setAnimationMode(int i2) {
            this.f2388d = i2;
        }

        @Override // android.view.View
        public void setBackground(@Nullable Drawable drawable) {
            setBackgroundDrawable(drawable);
        }

        @Override // android.view.View
        public void setBackgroundDrawable(@Nullable Drawable drawable) {
            if (drawable != null && this.f2391g != null) {
                drawable = DrawableCompat.wrap(drawable.mutate());
                DrawableCompat.setTintList(drawable, this.f2391g);
                DrawableCompat.setTintMode(drawable, this.f2392h);
            }
            super.setBackgroundDrawable(drawable);
        }

        @Override // android.view.View
        public void setBackgroundTintList(@Nullable ColorStateList colorStateList) {
            this.f2391g = colorStateList;
            if (getBackground() != null) {
                Drawable drawableWrap = DrawableCompat.wrap(getBackground().mutate());
                DrawableCompat.setTintList(drawableWrap, colorStateList);
                DrawableCompat.setTintMode(drawableWrap, this.f2392h);
                if (drawableWrap != getBackground()) {
                    super.setBackgroundDrawable(drawableWrap);
                }
            }
        }

        @Override // android.view.View
        public void setBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
            this.f2392h = mode;
            if (getBackground() != null) {
                Drawable drawableWrap = DrawableCompat.wrap(getBackground().mutate());
                DrawableCompat.setTintMode(drawableWrap, mode);
                if (drawableWrap != getBackground()) {
                    super.setBackgroundDrawable(drawableWrap);
                }
            }
        }

        public void setOnAttachStateChangeListener(g gVar) {
            this.f2387c = gVar;
        }

        @Override // android.view.View
        public void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
            setOnTouchListener(onClickListener != null ? null : a);
            super.setOnClickListener(onClickListener);
        }

        public void setOnLayoutChangeListener(h hVar) {
            this.f2386b = hVar;
        }
    }

    public static class a implements Handler.Callback {
        @Override // android.os.Handler.Callback
        public boolean handleMessage(@NonNull Message message) {
            int i2 = message.what;
            if (i2 == 0) {
                BaseTransientBottomBar baseTransientBottomBar = (BaseTransientBottomBar) message.obj;
                baseTransientBottomBar.f2378f.setOnAttachStateChangeListener(new k(baseTransientBottomBar));
                if (baseTransientBottomBar.f2378f.getParent() == null) {
                    ViewGroup.LayoutParams layoutParams = baseTransientBottomBar.f2378f.getLayoutParams();
                    if (layoutParams instanceof CoordinatorLayout.LayoutParams) {
                        CoordinatorLayout.LayoutParams layoutParams2 = (CoordinatorLayout.LayoutParams) layoutParams;
                        Behavior behavior = new Behavior();
                        f fVar = behavior.f2385i;
                        Objects.requireNonNull(fVar);
                        fVar.a = baseTransientBottomBar.q;
                        behavior.setListener(new m(baseTransientBottomBar));
                        layoutParams2.setBehavior(behavior);
                        layoutParams2.insetEdge = 80;
                    }
                    baseTransientBottomBar.o = 0;
                    baseTransientBottomBar.h();
                    baseTransientBottomBar.f2378f.setVisibility(4);
                    baseTransientBottomBar.f2376d.addView(baseTransientBottomBar.f2378f);
                }
                if (ViewCompat.isLaidOut(baseTransientBottomBar.f2378f)) {
                    baseTransientBottomBar.g();
                } else {
                    baseTransientBottomBar.f2378f.setOnLayoutChangeListener(new l(baseTransientBottomBar));
                }
                return true;
            }
            if (i2 != 1) {
                return false;
            }
            BaseTransientBottomBar baseTransientBottomBar2 = (BaseTransientBottomBar) message.obj;
            int i3 = message.arg1;
            if (!baseTransientBottomBar2.f() || baseTransientBottomBar2.f2378f.getVisibility() != 0) {
                baseTransientBottomBar2.d(i3);
            } else if (baseTransientBottomBar2.f2378f.getAnimationMode() == 1) {
                ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
                valueAnimatorOfFloat.setInterpolator(c.e.a.b.a.a.a);
                valueAnimatorOfFloat.addUpdateListener(new c.e.a.b.y.d(baseTransientBottomBar2));
                valueAnimatorOfFloat.setDuration(75L);
                valueAnimatorOfFloat.addListener(new c.e.a.b.y.c(baseTransientBottomBar2, i3));
                valueAnimatorOfFloat.start();
            } else {
                ValueAnimator valueAnimator = new ValueAnimator();
                valueAnimator.setIntValues(0, baseTransientBottomBar2.c());
                valueAnimator.setInterpolator(c.e.a.b.a.a.f839b);
                valueAnimator.setDuration(250L);
                valueAnimator.addListener(new c.e.a.b.y.h(baseTransientBottomBar2, i3));
                valueAnimator.addUpdateListener(new i(baseTransientBottomBar2));
                valueAnimator.start();
            }
            return true;
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Context context;
            BaseTransientBottomBar baseTransientBottomBar = BaseTransientBottomBar.this;
            if (baseTransientBottomBar.f2378f == null || (context = baseTransientBottomBar.f2377e) == null) {
                return;
            }
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            DisplayMetrics displayMetrics = new DisplayMetrics();
            windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
            int i2 = displayMetrics.heightPixels;
            BaseTransientBottomBar baseTransientBottomBar2 = BaseTransientBottomBar.this;
            int[] iArr = new int[2];
            baseTransientBottomBar2.f2378f.getLocationOnScreen(iArr);
            int height = (i2 - (baseTransientBottomBar2.f2378f.getHeight() + iArr[1])) + ((int) BaseTransientBottomBar.this.f2378f.getTranslationY());
            BaseTransientBottomBar baseTransientBottomBar3 = BaseTransientBottomBar.this;
            if (height >= baseTransientBottomBar3.n) {
                return;
            }
            ViewGroup.LayoutParams layoutParams = baseTransientBottomBar3.f2378f.getLayoutParams();
            if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
                Handler handler = BaseTransientBottomBar.a;
                String str = BaseTransientBottomBar.f2375c;
                return;
            }
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            int i3 = marginLayoutParams.bottomMargin;
            BaseTransientBottomBar baseTransientBottomBar4 = BaseTransientBottomBar.this;
            marginLayoutParams.bottomMargin = (baseTransientBottomBar4.n - height) + i3;
            baseTransientBottomBar4.f2378f.requestLayout();
        }
    }

    public class c implements OnApplyWindowInsetsListener {
        public c() {
        }

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        @NonNull
        public WindowInsetsCompat onApplyWindowInsets(View view, @NonNull WindowInsetsCompat windowInsetsCompat) {
            BaseTransientBottomBar.this.f2383k = windowInsetsCompat.getSystemWindowInsetBottom();
            BaseTransientBottomBar.this.f2384l = windowInsetsCompat.getSystemWindowInsetLeft();
            BaseTransientBottomBar.this.m = windowInsetsCompat.getSystemWindowInsetRight();
            BaseTransientBottomBar.this.h();
            return windowInsetsCompat;
        }
    }

    public class d extends AccessibilityDelegateCompat {
        public d() {
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.addAction(1048576);
            accessibilityNodeInfoCompat.setDismissable(true);
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public boolean performAccessibilityAction(View view, int i2, Bundle bundle) {
            if (i2 != 1048576) {
                return super.performAccessibilityAction(view, i2, bundle);
            }
            BaseTransientBottomBar.this.a();
            return true;
        }
    }

    public class e implements o.b {
        public e() {
        }

        @Override // c.e.a.b.y.o.b
        public void a(int i2) {
            Handler handler = BaseTransientBottomBar.a;
            handler.sendMessage(handler.obtainMessage(1, i2, 0, BaseTransientBottomBar.this));
        }

        @Override // c.e.a.b.y.o.b
        public void show() {
            Handler handler = BaseTransientBottomBar.a;
            handler.sendMessage(handler.obtainMessage(0, BaseTransientBottomBar.this));
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static class f {
        public o.b a;

        public f(@NonNull SwipeDismissBehavior<?> swipeDismissBehavior) {
            swipeDismissBehavior.f2024f = SwipeDismissBehavior.b(0.0f, 0.1f, 1.0f);
            swipeDismissBehavior.f2025g = SwipeDismissBehavior.b(0.0f, 0.6f, 1.0f);
            swipeDismissBehavior.f2022d = 0;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public interface g {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public interface h {
    }

    public BaseTransientBottomBar(@NonNull Context context, @NonNull ViewGroup viewGroup, @NonNull View view, @NonNull n nVar) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("Transient bottom bar must have non-null parent");
        }
        if (view == null) {
            throw new IllegalArgumentException("Transient bottom bar must have non-null content");
        }
        if (nVar == null) {
            throw new IllegalArgumentException("Transient bottom bar must have non-null callback");
        }
        this.f2376d = viewGroup;
        this.f2379g = nVar;
        this.f2377e = context;
        c.e.a.b.q.g.c(context, c.e.a.b.q.g.a, "Theme.AppCompat");
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(context);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(f2374b);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, -1);
        typedArrayObtainStyledAttributes.recycle();
        SnackbarBaseLayout snackbarBaseLayout = (SnackbarBaseLayout) layoutInflaterFrom.inflate(resourceId != -1 ? R$layout.mtrl_layout_snackbar : R$layout.design_layout_snackbar, viewGroup, false);
        this.f2378f = snackbarBaseLayout;
        if (view instanceof SnackbarContentLayout) {
            SnackbarContentLayout snackbarContentLayout = (SnackbarContentLayout) view;
            float actionTextColorAlpha = snackbarBaseLayout.getActionTextColorAlpha();
            if (actionTextColorAlpha != 1.0f) {
                snackbarContentLayout.f2394b.setTextColor(c.b.a.m.f.M3(c.b.a.m.f.Z1(snackbarContentLayout, R$attr.colorSurface), snackbarContentLayout.f2394b.getCurrentTextColor(), actionTextColorAlpha));
            }
        }
        snackbarBaseLayout.addView(view);
        ViewGroup.LayoutParams layoutParams = snackbarBaseLayout.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            this.f2382j = new Rect(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
        }
        ViewCompat.setAccessibilityLiveRegion(snackbarBaseLayout, 1);
        ViewCompat.setImportantForAccessibility(snackbarBaseLayout, 1);
        ViewCompat.setFitsSystemWindows(snackbarBaseLayout, true);
        ViewCompat.setOnApplyWindowInsetsListener(snackbarBaseLayout, new c());
        ViewCompat.setAccessibilityDelegate(snackbarBaseLayout, new d());
        this.p = (AccessibilityManager) context.getSystemService("accessibility");
    }

    public void a() {
        b(3);
    }

    public void b(int i2) {
        o oVarB = o.b();
        o.b bVar = this.q;
        synchronized (oVarB.f1287b) {
            if (oVarB.c(bVar)) {
                oVarB.a(oVarB.f1289d, i2);
            } else if (oVarB.d(bVar)) {
                oVarB.a(oVarB.f1290e, i2);
            }
        }
    }

    public final int c() {
        int height = this.f2378f.getHeight();
        ViewGroup.LayoutParams layoutParams = this.f2378f.getLayoutParams();
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? height + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin : height;
    }

    public void d(int i2) {
        o oVarB = o.b();
        o.b bVar = this.q;
        synchronized (oVarB.f1287b) {
            if (oVarB.c(bVar)) {
                oVarB.f1289d = null;
                if (oVarB.f1290e != null) {
                    oVarB.h();
                }
            }
        }
        ViewParent parent = this.f2378f.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.f2378f);
        }
    }

    public void e() {
        o oVarB = o.b();
        o.b bVar = this.q;
        synchronized (oVarB.f1287b) {
            if (oVarB.c(bVar)) {
                oVarB.g(oVarB.f1289d);
            }
        }
    }

    public boolean f() {
        AccessibilityManager accessibilityManager = this.p;
        if (accessibilityManager == null) {
            return true;
        }
        List<AccessibilityServiceInfo> enabledAccessibilityServiceList = accessibilityManager.getEnabledAccessibilityServiceList(1);
        return enabledAccessibilityServiceList != null && enabledAccessibilityServiceList.isEmpty();
    }

    public final void g() {
        if (f()) {
            this.f2378f.post(new c.e.a.b.y.a(this));
            return;
        }
        if (this.f2378f.getParent() != null) {
            this.f2378f.setVisibility(0);
        }
        e();
    }

    public final void h() {
        Rect rect;
        ViewGroup.LayoutParams layoutParams = this.f2378f.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams) || (rect = this.f2382j) == null) {
            return;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        marginLayoutParams.bottomMargin = rect.bottom + this.f2383k;
        marginLayoutParams.leftMargin = rect.left + this.f2384l;
        marginLayoutParams.rightMargin = rect.right + this.m;
        this.f2378f.requestLayout();
        if (Build.VERSION.SDK_INT >= 29) {
            boolean z = false;
            if (this.n > 0) {
                ViewGroup.LayoutParams layoutParams2 = this.f2378f.getLayoutParams();
                if ((layoutParams2 instanceof CoordinatorLayout.LayoutParams) && (((CoordinatorLayout.LayoutParams) layoutParams2).getBehavior() instanceof SwipeDismissBehavior)) {
                    z = true;
                }
            }
            if (z) {
                this.f2378f.removeCallbacks(this.f2381i);
                this.f2378f.post(this.f2381i);
            }
        }
    }
}

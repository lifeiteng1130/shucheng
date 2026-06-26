package com.google.android.material.behavior;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* JADX INFO: loaded from: classes.dex */
public class HideBottomViewOnScrollBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {
    public int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f2017b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f2018c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public ViewPropertyAnimator f2019d;

    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            HideBottomViewOnScrollBehavior.this.f2019d = null;
        }
    }

    public HideBottomViewOnScrollBehavior() {
        this.a = 0;
        this.f2017b = 2;
        this.f2018c = 0;
    }

    public final void a(@NonNull V v, int i2, long j2, TimeInterpolator timeInterpolator) {
        this.f2019d = v.animate().translationY(i2).setInterpolator(timeInterpolator).setDuration(j2).setListener(new a());
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, int i2) {
        this.a = v.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) v.getLayoutParams()).bottomMargin;
        return super.onLayoutChild(coordinatorLayout, v, i2);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onNestedScroll(CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull View view, int i2, int i3, int i4, int i5, int i6, @NonNull int[] iArr) {
        if (i3 > 0) {
            if (this.f2017b == 1) {
                return;
            }
            ViewPropertyAnimator viewPropertyAnimator = this.f2019d;
            if (viewPropertyAnimator != null) {
                viewPropertyAnimator.cancel();
                v.clearAnimation();
            }
            this.f2017b = 1;
            a(v, this.a + this.f2018c, 175L, c.e.a.b.a.a.f840c);
            return;
        }
        if (i3 >= 0 || this.f2017b == 2) {
            return;
        }
        ViewPropertyAnimator viewPropertyAnimator2 = this.f2019d;
        if (viewPropertyAnimator2 != null) {
            viewPropertyAnimator2.cancel();
            v.clearAnimation();
        }
        this.f2017b = 2;
        a(v, 0, 225L, c.e.a.b.a.a.f841d);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull View view, @NonNull View view2, int i2, int i3) {
        return i2 == 2;
    }

    public HideBottomViewOnScrollBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = 0;
        this.f2017b = 2;
        this.f2018c = 0;
    }
}

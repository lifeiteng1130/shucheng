package c.e.a.b.b;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.math.MathUtils;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.appbar.AppBarLayout;

/* JADX INFO: compiled from: HeaderScrollingViewBehavior.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class g extends h<View> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Rect f908c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Rect f909d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f910e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f911f;

    public g() {
        this.f908c = new Rect();
        this.f909d = new Rect();
        this.f910e = 0;
    }

    @Override // c.e.a.b.b.h
    public void b(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, int i2) {
        AppBarLayout appBarLayoutD = ((AppBarLayout.ScrollingViewBehavior) this).d(coordinatorLayout.getDependencies(view));
        if (appBarLayoutD == null) {
            coordinatorLayout.onLayoutChild(view, i2);
            this.f910e = 0;
            return;
        }
        CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) view.getLayoutParams();
        Rect rect = this.f908c;
        rect.set(coordinatorLayout.getPaddingLeft() + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin, appBarLayoutD.getBottom() + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, (coordinatorLayout.getWidth() - coordinatorLayout.getPaddingRight()) - ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, ((appBarLayoutD.getBottom() + coordinatorLayout.getHeight()) - coordinatorLayout.getPaddingBottom()) - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin);
        WindowInsetsCompat lastWindowInsets = coordinatorLayout.getLastWindowInsets();
        if (lastWindowInsets != null && ViewCompat.getFitsSystemWindows(coordinatorLayout) && !ViewCompat.getFitsSystemWindows(view)) {
            rect.left = lastWindowInsets.getSystemWindowInsetLeft() + rect.left;
            rect.right -= lastWindowInsets.getSystemWindowInsetRight();
        }
        Rect rect2 = this.f909d;
        int i3 = layoutParams.gravity;
        GravityCompat.apply(i3 == 0 ? 8388659 : i3, view.getMeasuredWidth(), view.getMeasuredHeight(), rect, rect2, i2);
        int iC = c(appBarLayoutD);
        view.layout(rect2.left, rect2.top - iC, rect2.right, rect2.bottom - iC);
        this.f910e = rect2.top - appBarLayoutD.getBottom();
    }

    public final int c(View view) {
        int i2;
        if (this.f911f == 0) {
            return 0;
        }
        float f2 = 0.0f;
        if (view instanceof AppBarLayout) {
            AppBarLayout appBarLayout = (AppBarLayout) view;
            int totalScrollRange = appBarLayout.getTotalScrollRange();
            int downNestedPreScrollRange = appBarLayout.getDownNestedPreScrollRange();
            CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) appBarLayout.getLayoutParams()).getBehavior();
            int iC = behavior instanceof AppBarLayout.BaseBehavior ? ((AppBarLayout.BaseBehavior) behavior).c() : 0;
            if ((downNestedPreScrollRange == 0 || totalScrollRange + iC > downNestedPreScrollRange) && (i2 = totalScrollRange - downNestedPreScrollRange) != 0) {
                f2 = 1.0f + (iC / i2);
            }
        }
        int i3 = this.f911f;
        return MathUtils.clamp((int) (f2 * i3), 0, i3);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onMeasureChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, int i2, int i3, int i4, int i5) {
        WindowInsetsCompat lastWindowInsets;
        int i6 = view.getLayoutParams().height;
        if (i6 != -1 && i6 != -2) {
            return false;
        }
        AppBarLayout appBarLayoutD = ((AppBarLayout.ScrollingViewBehavior) this).d(coordinatorLayout.getDependencies(view));
        if (appBarLayoutD == null) {
            return false;
        }
        int size = View.MeasureSpec.getSize(i4);
        if (size <= 0) {
            size = coordinatorLayout.getHeight();
        } else if (ViewCompat.getFitsSystemWindows(appBarLayoutD) && (lastWindowInsets = coordinatorLayout.getLastWindowInsets()) != null) {
            size += lastWindowInsets.getSystemWindowInsetBottom() + lastWindowInsets.getSystemWindowInsetTop();
        }
        coordinatorLayout.onMeasureChild(view, i2, i3, View.MeasureSpec.makeMeasureSpec((size + appBarLayoutD.getTotalScrollRange()) - appBarLayoutD.getMeasuredHeight(), i6 == -1 ? BasicMeasure.EXACTLY : Integer.MIN_VALUE), i5);
        return true;
    }

    public g(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f908c = new Rect();
        this.f909d = new Rect();
        this.f910e = 0;
    }
}

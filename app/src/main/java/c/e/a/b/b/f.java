package c.e.a.b.b;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.OverScroller;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import com.google.android.material.appbar.AppBarLayout;
import java.lang.ref.WeakReference;
import java.util.Objects;

/* JADX INFO: compiled from: HeaderBehavior.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class f<V extends View> extends h<V> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public Runnable f899c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public OverScroller f900d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f901e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f902f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f903g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f904h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    public VelocityTracker f905i;

    /* JADX INFO: compiled from: HeaderBehavior.java */
    public class a implements Runnable {
        public final CoordinatorLayout a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final V f906b;

        public a(CoordinatorLayout coordinatorLayout, V v) {
            this.a = coordinatorLayout;
            this.f906b = v;
        }

        @Override // java.lang.Runnable
        public void run() {
            OverScroller overScroller;
            if (this.f906b == null || (overScroller = f.this.f900d) == null) {
                return;
            }
            if (overScroller.computeScrollOffset()) {
                f fVar = f.this;
                fVar.e(this.a, this.f906b, fVar.f900d.getCurrY());
                ViewCompat.postOnAnimation(this.f906b, this);
                return;
            }
            f fVar2 = f.this;
            CoordinatorLayout coordinatorLayout = this.a;
            V v = this.f906b;
            AppBarLayout.BaseBehavior baseBehavior = (AppBarLayout.BaseBehavior) fVar2;
            Objects.requireNonNull(baseBehavior);
            AppBarLayout appBarLayout = (AppBarLayout) v;
            baseBehavior.m(coordinatorLayout, appBarLayout);
            if (appBarLayout.f1975l) {
                appBarLayout.d(appBarLayout.e(baseBehavior.i(coordinatorLayout)));
            }
        }
    }

    public f() {
        this.f902f = -1;
        this.f904h = -1;
    }

    public abstract int c();

    public final int d(CoordinatorLayout coordinatorLayout, V v, int i2, int i3, int i4) {
        return f(coordinatorLayout, v, c() - i2, i3, i4);
    }

    public int e(CoordinatorLayout coordinatorLayout, V v, int i2) {
        return f(coordinatorLayout, v, i2, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public abstract int f(CoordinatorLayout coordinatorLayout, V v, int i2, int i3, int i4);

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onInterceptTouchEvent(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull MotionEvent motionEvent) {
        View view;
        int iFindPointerIndex;
        if (this.f904h < 0) {
            this.f904h = ViewConfiguration.get(coordinatorLayout.getContext()).getScaledTouchSlop();
        }
        if (motionEvent.getActionMasked() == 2 && this.f901e) {
            int i2 = this.f902f;
            if (i2 == -1 || (iFindPointerIndex = motionEvent.findPointerIndex(i2)) == -1) {
                return false;
            }
            int y = (int) motionEvent.getY(iFindPointerIndex);
            if (Math.abs(y - this.f903g) > this.f904h) {
                this.f903g = y;
                return true;
            }
        }
        if (motionEvent.getActionMasked() == 0) {
            this.f902f = -1;
            int x = (int) motionEvent.getX();
            int y2 = (int) motionEvent.getY();
            WeakReference<View> weakReference = ((AppBarLayout.BaseBehavior) this).p;
            boolean z = (weakReference == null || ((view = weakReference.get()) != null && view.isShown() && !view.canScrollVertically(-1))) && coordinatorLayout.isPointInChildBounds(v, x, y2);
            this.f901e = z;
            if (z) {
                this.f903g = y2;
                this.f902f = motionEvent.getPointerId(0);
                if (this.f905i == null) {
                    this.f905i = VelocityTracker.obtain();
                }
                OverScroller overScroller = this.f900d;
                if (overScroller != null && !overScroller.isFinished()) {
                    this.f900d.abortAnimation();
                    return true;
                }
            }
        }
        VelocityTracker velocityTracker = this.f905i;
        if (velocityTracker != null) {
            velocityTracker.addMovement(motionEvent);
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00ee A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:49:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(@androidx.annotation.NonNull androidx.coordinatorlayout.widget.CoordinatorLayout r21, @androidx.annotation.NonNull V r22, @androidx.annotation.NonNull android.view.MotionEvent r23) {
        /*
            Method dump skipped, instruction units count: 243
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c.e.a.b.b.f.onTouchEvent(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, android.view.MotionEvent):boolean");
    }

    public f(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f902f = -1;
        this.f904h = -1;
    }
}

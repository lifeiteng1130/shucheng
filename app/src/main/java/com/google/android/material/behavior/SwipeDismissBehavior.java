package com.google.android.material.behavior;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.widget.ViewDragHelper;
import c.e.a.b.y.m;
import c.e.a.b.y.o;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class SwipeDismissBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {
    public ViewDragHelper a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f2020b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f2021c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f2022d = 2;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f2023e = 0.5f;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f2024f = 0.0f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f2025g = 0.5f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ViewDragHelper.Callback f2026h = new a();

    public class a extends ViewDragHelper.Callback {
        public int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f2027b = -1;

        public a() {
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int clampViewPositionHorizontal(@NonNull View view, int i2, int i3) {
            int width;
            int width2;
            int width3;
            boolean z = ViewCompat.getLayoutDirection(view) == 1;
            int i4 = SwipeDismissBehavior.this.f2022d;
            if (i4 == 0) {
                if (z) {
                    width = this.a - view.getWidth();
                    width2 = this.a;
                } else {
                    width = this.a;
                    width3 = view.getWidth();
                    width2 = width3 + width;
                }
            } else if (i4 != 1) {
                width = this.a - view.getWidth();
                width2 = view.getWidth() + this.a;
            } else if (z) {
                width = this.a;
                width3 = view.getWidth();
                width2 = width3 + width;
            } else {
                width = this.a - view.getWidth();
                width2 = this.a;
            }
            return Math.min(Math.max(width, i2), width2);
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int clampViewPositionVertical(@NonNull View view, int i2, int i3) {
            return view.getTop();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int getViewHorizontalDragRange(@NonNull View view) {
            return view.getWidth();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewCaptured(@NonNull View view, int i2) {
            this.f2027b = i2;
            this.a = view.getLeft();
            ViewParent parent = view.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewDragStateChanged(int i2) {
            b bVar = SwipeDismissBehavior.this.f2020b;
            if (bVar != null) {
                m mVar = (m) bVar;
                Objects.requireNonNull(mVar);
                if (i2 == 0) {
                    o.b().f(mVar.a.q);
                } else if (i2 == 1 || i2 == 2) {
                    o.b().e(mVar.a.q);
                }
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewPositionChanged(@NonNull View view, int i2, int i3, int i4, int i5) {
            float width = (view.getWidth() * SwipeDismissBehavior.this.f2024f) + this.a;
            float width2 = (view.getWidth() * SwipeDismissBehavior.this.f2025g) + this.a;
            float f2 = i2;
            if (f2 <= width) {
                view.setAlpha(1.0f);
            } else if (f2 >= width2) {
                view.setAlpha(0.0f);
            } else {
                view.setAlpha(SwipeDismissBehavior.b(0.0f, 1.0f - ((f2 - width) / (width2 - width)), 1.0f));
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x002a  */
        /* JADX WARN: Removed duplicated region for block: B:18:0x002c  */
        @Override // androidx.customview.widget.ViewDragHelper.Callback
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void onViewReleased(@androidx.annotation.NonNull android.view.View r8, float r9, float r10) {
            /*
                r7 = this;
                r10 = -1
                r7.f2027b = r10
                int r10 = r8.getWidth()
                r0 = 0
                r1 = 0
                r2 = 1
                int r3 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
                if (r3 == 0) goto L3a
                int r4 = androidx.core.view.ViewCompat.getLayoutDirection(r8)
                if (r4 != r2) goto L16
                r4 = 1
                goto L17
            L16:
                r4 = 0
            L17:
                com.google.android.material.behavior.SwipeDismissBehavior r5 = com.google.android.material.behavior.SwipeDismissBehavior.this
                int r5 = r5.f2022d
                r6 = 2
                if (r5 != r6) goto L1f
                goto L2a
            L1f:
                if (r5 != 0) goto L2e
                if (r4 == 0) goto L28
                int r9 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
                if (r9 >= 0) goto L2c
                goto L2a
            L28:
                if (r3 <= 0) goto L2c
            L2a:
                r9 = 1
                goto L57
            L2c:
                r9 = 0
                goto L57
            L2e:
                if (r5 != r2) goto L2c
                if (r4 == 0) goto L35
                if (r3 <= 0) goto L2c
                goto L39
            L35:
                int r9 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
                if (r9 >= 0) goto L2c
            L39:
                goto L2a
            L3a:
                int r9 = r8.getLeft()
                int r0 = r7.a
                int r9 = r9 - r0
                int r0 = r8.getWidth()
                float r0 = (float) r0
                com.google.android.material.behavior.SwipeDismissBehavior r3 = com.google.android.material.behavior.SwipeDismissBehavior.this
                float r3 = r3.f2023e
                float r0 = r0 * r3
                int r0 = java.lang.Math.round(r0)
                int r9 = java.lang.Math.abs(r9)
                if (r9 < r0) goto L2c
                goto L2a
            L57:
                if (r9 == 0) goto L66
                int r9 = r8.getLeft()
                int r0 = r7.a
                if (r9 >= r0) goto L63
                int r0 = r0 - r10
                goto L64
            L63:
                int r0 = r0 + r10
            L64:
                r1 = 1
                goto L68
            L66:
                int r0 = r7.a
            L68:
                com.google.android.material.behavior.SwipeDismissBehavior r9 = com.google.android.material.behavior.SwipeDismissBehavior.this
                androidx.customview.widget.ViewDragHelper r9 = r9.a
                int r10 = r8.getTop()
                boolean r9 = r9.settleCapturedViewAt(r0, r10)
                if (r9 == 0) goto L81
                com.google.android.material.behavior.SwipeDismissBehavior$c r9 = new com.google.android.material.behavior.SwipeDismissBehavior$c
                com.google.android.material.behavior.SwipeDismissBehavior r10 = com.google.android.material.behavior.SwipeDismissBehavior.this
                r9.<init>(r8, r1)
                androidx.core.view.ViewCompat.postOnAnimation(r8, r9)
                goto L8e
            L81:
                if (r1 == 0) goto L8e
                com.google.android.material.behavior.SwipeDismissBehavior r9 = com.google.android.material.behavior.SwipeDismissBehavior.this
                com.google.android.material.behavior.SwipeDismissBehavior$b r9 = r9.f2020b
                if (r9 == 0) goto L8e
                c.e.a.b.y.m r9 = (c.e.a.b.y.m) r9
                r9.a(r8)
            L8e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.behavior.SwipeDismissBehavior.a.onViewReleased(android.view.View, float, float):void");
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public boolean tryCaptureView(View view, int i2) {
            int i3 = this.f2027b;
            return (i3 == -1 || i3 == i2) && SwipeDismissBehavior.this.a(view);
        }
    }

    public interface b {
    }

    public class c implements Runnable {
        public final View a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f2029b;

        public c(View view, boolean z) {
            this.a = view;
            this.f2029b = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            b bVar;
            ViewDragHelper viewDragHelper = SwipeDismissBehavior.this.a;
            if (viewDragHelper != null && viewDragHelper.continueSettling(true)) {
                ViewCompat.postOnAnimation(this.a, this);
            } else {
                if (!this.f2029b || (bVar = SwipeDismissBehavior.this.f2020b) == null) {
                    return;
                }
                ((m) bVar).a(this.a);
            }
        }
    }

    public static float b(float f2, float f3, float f4) {
        return Math.min(Math.max(f2, f3), f4);
    }

    public boolean a(@NonNull View view) {
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onInterceptTouchEvent(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull MotionEvent motionEvent) {
        boolean zIsPointInChildBounds = this.f2021c;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            zIsPointInChildBounds = coordinatorLayout.isPointInChildBounds(v, (int) motionEvent.getX(), (int) motionEvent.getY());
            this.f2021c = zIsPointInChildBounds;
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.f2021c = false;
        }
        if (!zIsPointInChildBounds) {
            return false;
        }
        if (this.a == null) {
            this.a = ViewDragHelper.create(coordinatorLayout, this.f2026h);
        }
        return this.a.shouldInterceptTouchEvent(motionEvent);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, int i2) {
        boolean zOnLayoutChild = super.onLayoutChild(coordinatorLayout, v, i2);
        if (ViewCompat.getImportantForAccessibility(v) == 0) {
            ViewCompat.setImportantForAccessibility(v, 1);
            ViewCompat.removeAccessibilityAction(v, 1048576);
            if (a(v)) {
                ViewCompat.replaceAccessibilityAction(v, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_DISMISS, null, new c.e.a.b.d.a(this));
            }
        }
        return zOnLayoutChild;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onTouchEvent(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        ViewDragHelper viewDragHelper = this.a;
        if (viewDragHelper == null) {
            return false;
        }
        viewDragHelper.processTouchEvent(motionEvent);
        return true;
    }

    public void setListener(@Nullable b bVar) {
        this.f2020b = bVar;
    }
}

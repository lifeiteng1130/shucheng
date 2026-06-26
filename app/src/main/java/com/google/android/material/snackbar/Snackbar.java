package com.google.android.material.snackbar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import c.e.a.b.y.n;
import c.e.a.b.y.o;
import com.google.android.material.R$attr;
import com.google.android.material.snackbar.BaseTransientBottomBar;

/* JADX INFO: loaded from: classes.dex */
public class Snackbar extends BaseTransientBottomBar<Snackbar> {
    public static final int[] r = {R$attr.snackbarButtonStyle, R$attr.snackbarTextViewStyle};

    @Nullable
    public final AccessibilityManager s;
    public boolean t;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final class SnackbarLayout extends BaseTransientBottomBar.SnackbarBaseLayout {
        public SnackbarLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        @Override // android.widget.FrameLayout, android.view.View
        public void onMeasure(int i2, int i3) {
            super.onMeasure(i2, i3);
            int childCount = getChildCount();
            int measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt = getChildAt(i4);
                if (childAt.getLayoutParams().width == -1) {
                    childAt.measure(View.MeasureSpec.makeMeasureSpec(measuredWidth, BasicMeasure.EXACTLY), View.MeasureSpec.makeMeasureSpec(childAt.getMeasuredHeight(), BasicMeasure.EXACTLY));
                }
            }
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.SnackbarBaseLayout, android.view.View
        public /* bridge */ /* synthetic */ void setBackground(@Nullable Drawable drawable) {
            super.setBackground(drawable);
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.SnackbarBaseLayout, android.view.View
        public /* bridge */ /* synthetic */ void setBackgroundDrawable(@Nullable Drawable drawable) {
            super.setBackgroundDrawable(drawable);
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.SnackbarBaseLayout, android.view.View
        public /* bridge */ /* synthetic */ void setBackgroundTintList(@Nullable ColorStateList colorStateList) {
            super.setBackgroundTintList(colorStateList);
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.SnackbarBaseLayout, android.view.View
        public /* bridge */ /* synthetic */ void setBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
            super.setBackgroundTintMode(mode);
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.SnackbarBaseLayout, android.view.View
        public /* bridge */ /* synthetic */ void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
            super.setOnClickListener(onClickListener);
        }

        public SnackbarLayout(Context context) {
            super(context, null);
        }
    }

    public class a implements View.OnClickListener {
        public final /* synthetic */ View.OnClickListener a;

        public a(View.OnClickListener onClickListener) {
            this.a = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.a.onClick(view);
            Snackbar.this.b(1);
        }
    }

    public Snackbar(@NonNull Context context, @NonNull ViewGroup viewGroup, @NonNull View view, @NonNull n nVar) {
        super(context, viewGroup, view, nVar);
        this.s = (AccessibilityManager) viewGroup.getContext().getSystemService("accessibility");
    }

    @NonNull
    public static Snackbar k(@NonNull View view, @StringRes int i2, int i3) {
        return l(view, view.getResources().getText(i2), i3);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x001e  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x002c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x002a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:38:? A[LOOP:0: B:3:0x0002->B:38:?, LOOP_END, SYNTHETIC] */
    @androidx.annotation.NonNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.google.android.material.snackbar.Snackbar l(@androidx.annotation.NonNull android.view.View r8, @androidx.annotation.NonNull java.lang.CharSequence r9, int r10) {
        /*
            r0 = 0
            r1 = r0
        L2:
            boolean r2 = r8 instanceof androidx.coordinatorlayout.widget.CoordinatorLayout
            if (r2 == 0) goto L9
            android.view.ViewGroup r8 = (android.view.ViewGroup) r8
            goto L2d
        L9:
            boolean r2 = r8 instanceof android.widget.FrameLayout
            if (r2 == 0) goto L1c
            int r1 = r8.getId()
            r2 = 16908290(0x1020002, float:2.3877235E-38)
            if (r1 != r2) goto L19
            android.view.ViewGroup r8 = (android.view.ViewGroup) r8
            goto L2d
        L19:
            r1 = r8
            android.view.ViewGroup r1 = (android.view.ViewGroup) r1
        L1c:
            if (r8 == 0) goto L2a
            android.view.ViewParent r8 = r8.getParent()
            boolean r2 = r8 instanceof android.view.View
            if (r2 == 0) goto L29
            android.view.View r8 = (android.view.View) r8
            goto L2a
        L29:
            r8 = r0
        L2a:
            if (r8 != 0) goto L2
            r8 = r1
        L2d:
            if (r8 == 0) goto L69
            android.content.Context r0 = r8.getContext()
            android.view.LayoutInflater r1 = android.view.LayoutInflater.from(r0)
            int[] r2 = com.google.android.material.snackbar.Snackbar.r
            android.content.res.TypedArray r2 = r0.obtainStyledAttributes(r2)
            r3 = -1
            r4 = 0
            int r5 = r2.getResourceId(r4, r3)
            r6 = 1
            int r7 = r2.getResourceId(r6, r3)
            r2.recycle()
            if (r5 == r3) goto L50
            if (r7 == r3) goto L50
            goto L51
        L50:
            r6 = 0
        L51:
            if (r6 == 0) goto L56
            int r2 = com.google.android.material.R$layout.mtrl_layout_snackbar_include
            goto L58
        L56:
            int r2 = com.google.android.material.R$layout.design_layout_snackbar_include
        L58:
            android.view.View r1 = r1.inflate(r2, r8, r4)
            com.google.android.material.snackbar.SnackbarContentLayout r1 = (com.google.android.material.snackbar.SnackbarContentLayout) r1
            com.google.android.material.snackbar.Snackbar r2 = new com.google.android.material.snackbar.Snackbar
            r2.<init>(r0, r8, r1, r1)
            r2.n(r9)
            r2.f2380h = r10
            return r2
        L69:
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            java.lang.String r9 = "No suitable parent found from the given view. Please provide a valid view."
            r8.<init>(r9)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.snackbar.Snackbar.l(android.view.View, java.lang.CharSequence, int):com.google.android.material.snackbar.Snackbar");
    }

    @Override // com.google.android.material.snackbar.BaseTransientBottomBar
    public void a() {
        b(3);
    }

    public int i() {
        int i2 = this.f2380h;
        if (i2 == -2) {
            return -2;
        }
        if (Build.VERSION.SDK_INT >= 29) {
            return this.s.getRecommendedTimeoutMillis(i2, (this.t ? 4 : 0) | 1 | 2);
        }
        if (this.t && this.s.isTouchExplorationEnabled()) {
            return -2;
        }
        return i2;
    }

    public boolean j() {
        boolean zC;
        o oVarB = o.b();
        o.b bVar = this.q;
        synchronized (oVarB.f1287b) {
            zC = oVarB.c(bVar);
        }
        return zC;
    }

    @NonNull
    public Snackbar m(@Nullable CharSequence charSequence, @Nullable View.OnClickListener onClickListener) {
        Button actionView = ((SnackbarContentLayout) this.f2378f.getChildAt(0)).getActionView();
        if (TextUtils.isEmpty(charSequence) || onClickListener == null) {
            actionView.setVisibility(8);
            actionView.setOnClickListener(null);
            this.t = false;
        } else {
            this.t = true;
            actionView.setVisibility(0);
            actionView.setText(charSequence);
            actionView.setOnClickListener(new a(onClickListener));
        }
        return this;
    }

    @NonNull
    public Snackbar n(@NonNull CharSequence charSequence) {
        ((SnackbarContentLayout) this.f2378f.getChildAt(0)).getMessageView().setText(charSequence);
        return this;
    }

    public void o() {
        o oVarB = o.b();
        int i2 = i();
        o.b bVar = this.q;
        synchronized (oVarB.f1287b) {
            if (oVarB.c(bVar)) {
                o.c cVar = oVarB.f1289d;
                cVar.f1291b = i2;
                oVarB.f1288c.removeCallbacksAndMessages(cVar);
                oVarB.g(oVarB.f1289d);
                return;
            }
            if (oVarB.d(bVar)) {
                oVarB.f1290e.f1291b = i2;
            } else {
                oVarB.f1290e = new o.c(i2, bVar);
            }
            o.c cVar2 = oVarB.f1289d;
            if (cVar2 == null || !oVarB.a(cVar2, 4)) {
                oVarB.f1289d = null;
                oVarB.h();
            }
        }
    }
}

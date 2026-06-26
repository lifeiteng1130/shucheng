package com.google.android.material.progressindicator;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ProgressBar;
import androidx.annotation.AttrRes;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.annotation.VisibleForTesting;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import c.b.a.m.f;
import c.e.a.b.q.g;
import c.e.a.b.s.b;
import c.e.a.b.s.j;
import c.e.a.b.s.k;
import com.google.android.material.R$attr;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseProgressIndicator<S extends c.e.a.b.s.b> extends ProgressBar {
    public static final int a = R$style.Widget_MaterialComponents_ProgressIndicator;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public S f2314b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f2315c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f2316d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f2317e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f2318f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public c.e.a.b.s.a f2319g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f2320h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f2321i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Runnable f2322j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Runnable f2323k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Animatable2Compat.AnimationCallback f2324l;
    public final Animatable2Compat.AnimationCallback m;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface HideAnimationBehavior {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface ShowAnimationBehavior {
    }

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            BaseProgressIndicator baseProgressIndicator = BaseProgressIndicator.this;
            if (baseProgressIndicator.f2318f > 0) {
                SystemClock.uptimeMillis();
            }
            baseProgressIndicator.setVisibility(0);
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            BaseProgressIndicator baseProgressIndicator = BaseProgressIndicator.this;
            int i2 = BaseProgressIndicator.a;
            boolean z = false;
            ((j) baseProgressIndicator.getCurrentDrawable()).g(false, false, true);
            if ((baseProgressIndicator.getProgressDrawable() == null || !baseProgressIndicator.getProgressDrawable().isVisible()) && (baseProgressIndicator.getIndeterminateDrawable() == null || !baseProgressIndicator.getIndeterminateDrawable().isVisible())) {
                z = true;
            }
            if (z) {
                baseProgressIndicator.setVisibility(4);
            }
            Objects.requireNonNull(BaseProgressIndicator.this);
        }
    }

    public class c extends Animatable2Compat.AnimationCallback {
        public c() {
        }

        @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat.AnimationCallback
        public void onAnimationEnd(Drawable drawable) {
            BaseProgressIndicator.this.setIndeterminate(false);
            BaseProgressIndicator.this.c(0, false);
            BaseProgressIndicator baseProgressIndicator = BaseProgressIndicator.this;
            baseProgressIndicator.c(baseProgressIndicator.f2315c, baseProgressIndicator.f2316d);
        }
    }

    public class d extends Animatable2Compat.AnimationCallback {
        public d() {
        }

        @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat.AnimationCallback
        public void onAnimationEnd(Drawable drawable) {
            super.onAnimationEnd(drawable);
            BaseProgressIndicator baseProgressIndicator = BaseProgressIndicator.this;
            if (baseProgressIndicator.f2320h) {
                return;
            }
            baseProgressIndicator.setVisibility(baseProgressIndicator.f2321i);
        }
    }

    public BaseProgressIndicator(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i2, @StyleRes int i3) {
        super(c.e.a.b.b0.a.a.a(context, attributeSet, i2, a), attributeSet, i2);
        this.f2320h = false;
        this.f2321i = 4;
        this.f2322j = new a();
        this.f2323k = new b();
        this.f2324l = new c();
        this.m = new d();
        Context context2 = getContext();
        this.f2314b = (S) b(context2, attributeSet);
        TypedArray typedArrayD = g.d(context2, attributeSet, R$styleable.BaseProgressIndicator, i2, i3, new int[0]);
        typedArrayD.getInt(R$styleable.BaseProgressIndicator_showDelay, -1);
        this.f2318f = Math.min(typedArrayD.getInt(R$styleable.BaseProgressIndicator_minHideDelay, -1), 1000);
        typedArrayD.recycle();
        this.f2319g = new c.e.a.b.s.a();
        this.f2317e = true;
    }

    @Nullable
    private k<S> getCurrentDrawingDelegate() {
        if (isIndeterminate()) {
            if (getIndeterminateDrawable() == null) {
                return null;
            }
            return getIndeterminateDrawable().f2326l;
        }
        if (getProgressDrawable() == null) {
            return null;
        }
        return getProgressDrawable().m;
    }

    public void a(boolean z) {
        if (this.f2317e) {
            ((j) getCurrentDrawable()).g(d(), false, z);
        }
    }

    public abstract S b(@NonNull Context context, @NonNull AttributeSet attributeSet);

    public void c(int i2, boolean z) {
        if (!isIndeterminate()) {
            super.setProgress(i2);
            if (getProgressDrawable() == null || z) {
                return;
            }
            getProgressDrawable().jumpToCurrentState();
            return;
        }
        if (getProgressDrawable() != null) {
            this.f2315c = i2;
            this.f2316d = z;
            this.f2320h = true;
            if (!getIndeterminateDrawable().isVisible() || this.f2319g.a(getContext().getContentResolver()) == 0.0f) {
                this.f2324l.onAnimationEnd(getIndeterminateDrawable());
            } else {
                getIndeterminateDrawable().m.e();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0022, code lost:
    
        r0 = true;
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x002d A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean d() {
        /*
            r4 = this;
            boolean r0 = androidx.core.view.ViewCompat.isAttachedToWindow(r4)
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L32
            int r0 = r4.getWindowVisibility()
            if (r0 != 0) goto L32
            r0 = r4
        Lf:
            int r3 = r0.getVisibility()
            if (r3 == 0) goto L16
            goto L24
        L16:
            android.view.ViewParent r0 = r0.getParent()
            if (r0 != 0) goto L26
            int r0 = r4.getWindowVisibility()
            if (r0 != 0) goto L24
        L22:
            r0 = 1
            goto L2b
        L24:
            r0 = 0
            goto L2b
        L26:
            boolean r3 = r0 instanceof android.view.View
            if (r3 != 0) goto L2f
            goto L22
        L2b:
            if (r0 == 0) goto L32
            r1 = 1
            goto L32
        L2f:
            android.view.View r0 = (android.view.View) r0
            goto Lf
        L32:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.progressindicator.BaseProgressIndicator.d():boolean");
    }

    @Override // android.widget.ProgressBar
    @Nullable
    public Drawable getCurrentDrawable() {
        return isIndeterminate() ? getIndeterminateDrawable() : getProgressDrawable();
    }

    public int getHideAnimationBehavior() {
        return this.f2314b.f1136f;
    }

    @NonNull
    public int[] getIndicatorColor() {
        return this.f2314b.f1133c;
    }

    public int getShowAnimationBehavior() {
        return this.f2314b.f1135e;
    }

    @ColorInt
    public int getTrackColor() {
        return this.f2314b.f1134d;
    }

    @Px
    public int getTrackCornerRadius() {
        return this.f2314b.f1132b;
    }

    @Px
    public int getTrackThickness() {
        return this.f2314b.a;
    }

    @Override // android.view.View
    public void invalidate() {
        super.invalidate();
        if (getCurrentDrawable() != null) {
            getCurrentDrawable().invalidateSelf();
        }
    }

    @Override // android.widget.ProgressBar, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (getProgressDrawable() != null && getIndeterminateDrawable() != null) {
            getIndeterminateDrawable().m.d(this.f2324l);
        }
        if (getProgressDrawable() != null) {
            getProgressDrawable().registerAnimationCallback(this.m);
        }
        if (getIndeterminateDrawable() != null) {
            getIndeterminateDrawable().registerAnimationCallback(this.m);
        }
        if (d()) {
            if (this.f2318f > 0) {
                SystemClock.uptimeMillis();
            }
            setVisibility(0);
        }
    }

    @Override // android.widget.ProgressBar, android.view.View
    public void onDetachedFromWindow() {
        removeCallbacks(this.f2323k);
        removeCallbacks(this.f2322j);
        ((j) getCurrentDrawable()).d();
        if (getIndeterminateDrawable() != null) {
            getIndeterminateDrawable().unregisterAnimationCallback(this.m);
            getIndeterminateDrawable().m.g();
        }
        if (getProgressDrawable() != null) {
            getProgressDrawable().unregisterAnimationCallback(this.m);
        }
        super.onDetachedFromWindow();
    }

    @Override // android.widget.ProgressBar, android.view.View
    public synchronized void onDraw(@NonNull Canvas canvas) {
        int iSave = canvas.save();
        if (getPaddingLeft() != 0 || getPaddingTop() != 0) {
            canvas.translate(getPaddingLeft(), getPaddingTop());
        }
        if (getPaddingRight() != 0 || getPaddingBottom() != 0) {
            canvas.clipRect(0, 0, getWidth() - (getPaddingLeft() + getPaddingRight()), getHeight() - (getPaddingTop() + getPaddingBottom()));
        }
        getCurrentDrawable().draw(canvas);
        canvas.restoreToCount(iSave);
    }

    @Override // android.widget.ProgressBar, android.view.View
    public synchronized void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        k<S> currentDrawingDelegate = getCurrentDrawingDelegate();
        if (currentDrawingDelegate == null) {
            return;
        }
        int iE = currentDrawingDelegate.e();
        int iD = currentDrawingDelegate.d();
        setMeasuredDimension(iE < 0 ? getMeasuredWidth() : iE + getPaddingLeft() + getPaddingRight(), iD < 0 ? getMeasuredHeight() : iD + getPaddingTop() + getPaddingBottom());
    }

    @Override // android.view.View
    public void onVisibilityChanged(@NonNull View view, int i2) {
        super.onVisibilityChanged(view, i2);
        a(i2 == 0);
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i2) {
        super.onWindowVisibilityChanged(i2);
        a(false);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @VisibleForTesting
    public void setAnimatorDurationScaleProvider(@NonNull c.e.a.b.s.a aVar) {
        this.f2319g = aVar;
        if (getProgressDrawable() != null) {
            getProgressDrawable().f1155d = aVar;
        }
        if (getIndeterminateDrawable() != null) {
            getIndeterminateDrawable().f1155d = aVar;
        }
    }

    public void setHideAnimationBehavior(int i2) {
        this.f2314b.f1136f = i2;
        invalidate();
    }

    @Override // android.widget.ProgressBar
    public synchronized void setIndeterminate(boolean z) {
        if (z == isIndeterminate()) {
            return;
        }
        if (d() && z) {
            throw new IllegalStateException("Cannot switch to indeterminate mode while the progress indicator is visible.");
        }
        j jVar = (j) getCurrentDrawable();
        if (jVar != null) {
            jVar.d();
        }
        super.setIndeterminate(z);
        j jVar2 = (j) getCurrentDrawable();
        if (jVar2 != null) {
            jVar2.g(d(), false, false);
        }
        this.f2320h = false;
    }

    @Override // android.widget.ProgressBar
    public void setIndeterminateDrawable(@Nullable Drawable drawable) {
        if (drawable == null) {
            super.setIndeterminateDrawable(null);
        } else {
            if (!(drawable instanceof IndeterminateDrawable)) {
                throw new IllegalArgumentException("Cannot set framework drawable as indeterminate drawable.");
            }
            ((j) drawable).d();
            super.setIndeterminateDrawable(drawable);
        }
    }

    public void setIndicatorColor(@ColorInt int... iArr) {
        if (iArr.length == 0) {
            iArr = new int[]{f.Y1(getContext(), R$attr.colorPrimary, -1)};
        }
        if (Arrays.equals(getIndicatorColor(), iArr)) {
            return;
        }
        this.f2314b.f1133c = iArr;
        getIndeterminateDrawable().m.c();
        invalidate();
    }

    @Override // android.widget.ProgressBar
    public synchronized void setProgress(int i2) {
        if (isIndeterminate()) {
            return;
        }
        c(i2, false);
    }

    @Override // android.widget.ProgressBar
    public void setProgressDrawable(@Nullable Drawable drawable) {
        if (drawable == null) {
            super.setProgressDrawable(null);
        } else {
            if (!(drawable instanceof DeterminateDrawable)) {
                throw new IllegalArgumentException("Cannot set framework drawable as progress drawable.");
            }
            DeterminateDrawable determinateDrawable = (DeterminateDrawable) drawable;
            determinateDrawable.d();
            super.setProgressDrawable(determinateDrawable);
            determinateDrawable.setLevel((int) ((getProgress() / getMax()) * 10000.0f));
        }
    }

    public void setShowAnimationBehavior(int i2) {
        this.f2314b.f1135e = i2;
        invalidate();
    }

    public void setTrackColor(@ColorInt int i2) {
        S s = this.f2314b;
        if (s.f1134d != i2) {
            s.f1134d = i2;
            invalidate();
        }
    }

    public void setTrackCornerRadius(@Px int i2) {
        S s = this.f2314b;
        if (s.f1132b != i2) {
            s.f1132b = Math.min(i2, s.a / 2);
        }
    }

    public void setTrackThickness(@Px int i2) {
        S s = this.f2314b;
        if (s.a != i2) {
            s.a = i2;
            requestLayout();
        }
    }

    public void setVisibilityAfterHide(int i2) {
        if (i2 != 0 && i2 != 4 && i2 != 8) {
            throw new IllegalArgumentException("The component's visibility must be one of VISIBLE, INVISIBLE, and GONE defined in View.");
        }
        this.f2321i = i2;
    }

    @Override // android.widget.ProgressBar
    @Nullable
    public IndeterminateDrawable<S> getIndeterminateDrawable() {
        return (IndeterminateDrawable) super.getIndeterminateDrawable();
    }

    @Override // android.widget.ProgressBar
    @Nullable
    public DeterminateDrawable<S> getProgressDrawable() {
        return (DeterminateDrawable) super.getProgressDrawable();
    }
}

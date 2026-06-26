package com.google.android.material.progressindicator;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.view.ViewCompat;
import c.e.a.b.s.b;
import c.e.a.b.s.m;
import c.e.a.b.s.o;
import c.e.a.b.s.q;
import c.e.a.b.s.r;
import com.google.android.material.R$attr;
import com.google.android.material.R$style;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes.dex */
public final class LinearProgressIndicator extends BaseProgressIndicator<r> {
    public static final int n = R$style.Widget_MaterialComponents_LinearProgressIndicator;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface IndeterminateAnimationType {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface IndicatorDirection {
    }

    public LinearProgressIndicator(@NonNull Context context) {
        this(context, null);
    }

    @Override // com.google.android.material.progressindicator.BaseProgressIndicator
    public b b(@NonNull Context context, @NonNull AttributeSet attributeSet) {
        return new r(context, attributeSet);
    }

    @Override // com.google.android.material.progressindicator.BaseProgressIndicator
    public void c(int i2, boolean z) {
        S s = this.f2314b;
        if (s != 0 && ((r) s).f1185g == 0 && isIndeterminate()) {
            return;
        }
        super.c(i2, z);
    }

    public int getIndeterminateAnimationType() {
        return ((r) this.f2314b).f1185g;
    }

    public int getIndicatorDirection() {
        return ((r) this.f2314b).f1186h;
    }

    @Override // android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        S s = this.f2314b;
        r rVar = (r) s;
        boolean z2 = true;
        if (((r) s).f1186h != 1 && ((ViewCompat.getLayoutDirection(this) != 1 || ((r) this.f2314b).f1186h != 2) && (ViewCompat.getLayoutDirection(this) != 0 || ((r) this.f2314b).f1186h != 3))) {
            z2 = false;
        }
        rVar.f1187i = z2;
    }

    @Override // android.widget.ProgressBar, android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        int paddingRight = i2 - (getPaddingRight() + getPaddingLeft());
        int paddingBottom = i3 - (getPaddingBottom() + getPaddingTop());
        IndeterminateDrawable<r> indeterminateDrawable = getIndeterminateDrawable();
        if (indeterminateDrawable != null) {
            indeterminateDrawable.setBounds(0, 0, paddingRight, paddingBottom);
        }
        DeterminateDrawable<r> progressDrawable = getProgressDrawable();
        if (progressDrawable != null) {
            progressDrawable.setBounds(0, 0, paddingRight, paddingBottom);
        }
    }

    public void setIndeterminateAnimationType(int i2) {
        if (((r) this.f2314b).f1185g == i2) {
            return;
        }
        if (d() && isIndeterminate()) {
            throw new IllegalStateException("Cannot change indeterminate animation type while the progress indicator is show in indeterminate mode.");
        }
        r rVar = (r) this.f2314b;
        rVar.f1185g = i2;
        rVar.a();
        if (i2 == 0) {
            IndeterminateDrawable<r> indeterminateDrawable = getIndeterminateDrawable();
            o oVar = new o((r) this.f2314b);
            indeterminateDrawable.m = oVar;
            oVar.a = indeterminateDrawable;
        } else {
            IndeterminateDrawable<r> indeterminateDrawable2 = getIndeterminateDrawable();
            q qVar = new q(getContext(), (r) this.f2314b);
            indeterminateDrawable2.m = qVar;
            qVar.a = indeterminateDrawable2;
        }
        invalidate();
    }

    @Override // com.google.android.material.progressindicator.BaseProgressIndicator
    public void setIndicatorColor(@NonNull int... iArr) {
        super.setIndicatorColor(iArr);
        ((r) this.f2314b).a();
    }

    public void setIndicatorDirection(int i2) {
        S s = this.f2314b;
        ((r) s).f1186h = i2;
        r rVar = (r) s;
        boolean z = true;
        if (i2 != 1 && ((ViewCompat.getLayoutDirection(this) != 1 || ((r) this.f2314b).f1186h != 2) && (ViewCompat.getLayoutDirection(this) != 0 || i2 != 3))) {
            z = false;
        }
        rVar.f1187i = z;
        invalidate();
    }

    @Override // com.google.android.material.progressindicator.BaseProgressIndicator
    public void setTrackCornerRadius(int i2) {
        super.setTrackCornerRadius(i2);
        ((r) this.f2314b).a();
        invalidate();
    }

    public LinearProgressIndicator(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.linearProgressIndicatorStyle);
    }

    public LinearProgressIndicator(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i2) {
        super(context, attributeSet, i2, n);
        Context context2 = getContext();
        r rVar = (r) this.f2314b;
        setIndeterminateDrawable(new IndeterminateDrawable(context2, rVar, new m(rVar), rVar.f1185g == 0 ? new o(rVar) : new q(context2, rVar)));
        Context context3 = getContext();
        r rVar2 = (r) this.f2314b;
        setProgressDrawable(new DeterminateDrawable(context3, rVar2, new m(rVar2)));
    }
}

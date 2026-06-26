package com.google.android.material.progressindicator;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import c.e.a.b.s.b;
import c.e.a.b.s.c;
import c.e.a.b.s.f;
import c.e.a.b.s.g;
import com.google.android.material.R$attr;
import com.google.android.material.R$style;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes.dex */
public final class CircularProgressIndicator extends BaseProgressIndicator<g> {
    public static final int n = R$style.Widget_MaterialComponents_CircularProgressIndicator;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface IndicatorDirection {
    }

    public CircularProgressIndicator(@NonNull Context context) {
        this(context, null);
    }

    @Override // com.google.android.material.progressindicator.BaseProgressIndicator
    public b b(@NonNull Context context, @NonNull AttributeSet attributeSet) {
        return new g(context, attributeSet);
    }

    public int getIndicatorDirection() {
        return ((g) this.f2314b).f1152i;
    }

    @Px
    public int getIndicatorInset() {
        return ((g) this.f2314b).f1151h;
    }

    @Px
    public int getIndicatorSize() {
        return ((g) this.f2314b).f1150g;
    }

    public void setIndicatorDirection(int i2) {
        ((g) this.f2314b).f1152i = i2;
        invalidate();
    }

    public void setIndicatorInset(@Px int i2) {
        S s = this.f2314b;
        if (((g) s).f1151h != i2) {
            ((g) s).f1151h = i2;
            invalidate();
        }
    }

    public void setIndicatorSize(@Px int i2) {
        S s = this.f2314b;
        if (((g) s).f1150g != i2) {
            ((g) s).f1150g = i2;
            ((g) s).a();
            invalidate();
        }
    }

    @Override // com.google.android.material.progressindicator.BaseProgressIndicator
    public void setTrackThickness(int i2) {
        super.setTrackThickness(i2);
        ((g) this.f2314b).a();
    }

    public CircularProgressIndicator(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.circularProgressIndicatorStyle);
    }

    public CircularProgressIndicator(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i2) {
        super(context, attributeSet, i2, n);
        Context context2 = getContext();
        g gVar = (g) this.f2314b;
        setIndeterminateDrawable(new IndeterminateDrawable(context2, gVar, new c(gVar), new f(gVar)));
        Context context3 = getContext();
        g gVar2 = (g) this.f2314b;
        setProgressDrawable(new DeterminateDrawable(context3, gVar2, new c(gVar2)));
    }
}

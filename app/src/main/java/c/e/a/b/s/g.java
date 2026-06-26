package c.e.a.b.s;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$styleable;
import com.google.android.material.progressindicator.CircularProgressIndicator;

/* JADX INFO: compiled from: CircularProgressIndicatorSpec.java */
/* JADX INFO: loaded from: classes.dex */
public final class g extends b {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Px
    public int f1150g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Px
    public int f1151h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f1152i;

    /* JADX WARN: Illegal instructions before constructor call */
    public g(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        int i2 = R$attr.circularProgressIndicatorStyle;
        int i3 = CircularProgressIndicator.n;
        super(context, attributeSet, i2, i3);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R$dimen.mtrl_progress_circular_size_medium);
        int dimensionPixelSize2 = context.getResources().getDimensionPixelSize(R$dimen.mtrl_progress_circular_inset_medium);
        int[] iArr = R$styleable.CircularProgressIndicator;
        c.e.a.b.q.g.a(context, attributeSet, i2, i3);
        c.e.a.b.q.g.b(context, attributeSet, iArr, i2, i3, new int[0]);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i2, i3);
        this.f1150g = c.b.a.m.f.l2(context, typedArrayObtainStyledAttributes, R$styleable.CircularProgressIndicator_indicatorSize, dimensionPixelSize);
        this.f1151h = c.b.a.m.f.l2(context, typedArrayObtainStyledAttributes, R$styleable.CircularProgressIndicator_indicatorInset, dimensionPixelSize2);
        this.f1152i = typedArrayObtainStyledAttributes.getInt(R$styleable.CircularProgressIndicator_indicatorDirectionCircular, 0);
        typedArrayObtainStyledAttributes.recycle();
        a();
    }

    @Override // c.e.a.b.s.b
    public void a() {
        if (this.f1150g >= this.a * 2) {
            return;
        }
        StringBuilder sbR = c.a.a.a.a.r("The indicatorSize (");
        sbR.append(this.f1150g);
        sbR.append(" px) cannot be less than twice of the trackThickness (");
        throw new IllegalArgumentException(c.a.a.a.a.o(sbR, this.a, " px)."));
    }
}

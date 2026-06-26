package c.e.a.b.s;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.R$attr;
import com.google.android.material.R$styleable;
import com.google.android.material.progressindicator.LinearProgressIndicator;

/* JADX INFO: compiled from: LinearProgressIndicatorSpec.java */
/* JADX INFO: loaded from: classes.dex */
public final class r extends b {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f1185g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f1186h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f1187i;

    /* JADX WARN: Illegal instructions before constructor call */
    public r(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        int i2 = R$attr.linearProgressIndicatorStyle;
        int i3 = LinearProgressIndicator.n;
        super(context, attributeSet, i2, i3);
        int[] iArr = R$styleable.LinearProgressIndicator;
        c.e.a.b.q.g.a(context, attributeSet, i2, i3);
        c.e.a.b.q.g.b(context, attributeSet, iArr, i2, i3, new int[0]);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i2, i3);
        this.f1185g = typedArrayObtainStyledAttributes.getInt(R$styleable.LinearProgressIndicator_indeterminateAnimationType, 1);
        this.f1186h = typedArrayObtainStyledAttributes.getInt(R$styleable.LinearProgressIndicator_indicatorDirectionLinear, 0);
        typedArrayObtainStyledAttributes.recycle();
        a();
        this.f1187i = this.f1186h == 1;
    }

    @Override // c.e.a.b.s.b
    public void a() {
        if (this.f1185g == 0) {
            if (this.f1132b > 0) {
                throw new IllegalArgumentException("Rounded corners are not supported in contiguous indeterminate animation.");
            }
            if (this.f1133c.length < 3) {
                throw new IllegalArgumentException("Contiguous indeterminate animation must be used with 3 or more indicator colors.");
            }
        }
    }
}

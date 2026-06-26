package c.e.a.b.s;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.annotation.AttrRes;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.StyleRes;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$styleable;

/* JADX INFO: compiled from: BaseProgressIndicatorSpec.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class b {

    @Px
    public int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Px
    public int f1132b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public int[] f1133c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @ColorInt
    public int f1134d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f1135e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f1136f;

    public b(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i2, @StyleRes int i3) {
        this.f1133c = new int[0];
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R$dimen.mtrl_progress_track_thickness);
        int[] iArr = R$styleable.BaseProgressIndicator;
        c.e.a.b.q.g.a(context, attributeSet, i2, i3);
        c.e.a.b.q.g.b(context, attributeSet, iArr, i2, i3, new int[0]);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i2, i3);
        this.a = c.b.a.m.f.l2(context, typedArrayObtainStyledAttributes, R$styleable.BaseProgressIndicator_trackThickness, dimensionPixelSize);
        this.f1132b = Math.min(c.b.a.m.f.l2(context, typedArrayObtainStyledAttributes, R$styleable.BaseProgressIndicator_trackCornerRadius, 0), this.a / 2);
        this.f1135e = typedArrayObtainStyledAttributes.getInt(R$styleable.BaseProgressIndicator_showAnimationBehavior, 0);
        this.f1136f = typedArrayObtainStyledAttributes.getInt(R$styleable.BaseProgressIndicator_hideAnimationBehavior, 0);
        int i4 = R$styleable.BaseProgressIndicator_indicatorColor;
        if (!typedArrayObtainStyledAttributes.hasValue(i4)) {
            this.f1133c = new int[]{c.b.a.m.f.Y1(context, R$attr.colorPrimary, -1)};
        } else if (typedArrayObtainStyledAttributes.peekValue(i4).type != 1) {
            this.f1133c = new int[]{typedArrayObtainStyledAttributes.getColor(i4, -1)};
        } else {
            int[] intArray = context.getResources().getIntArray(typedArrayObtainStyledAttributes.getResourceId(i4, -1));
            this.f1133c = intArray;
            if (intArray.length == 0) {
                throw new IllegalArgumentException("indicatorColors cannot be empty when indicatorColor is not used.");
            }
        }
        int i5 = R$styleable.BaseProgressIndicator_trackColor;
        if (typedArrayObtainStyledAttributes.hasValue(i5)) {
            this.f1134d = typedArrayObtainStyledAttributes.getColor(i5, -1);
        } else {
            this.f1134d = this.f1133c[0];
            TypedArray typedArrayObtainStyledAttributes2 = context.getTheme().obtainStyledAttributes(new int[]{R.attr.disabledAlpha});
            float f2 = typedArrayObtainStyledAttributes2.getFloat(0, 0.2f);
            typedArrayObtainStyledAttributes2.recycle();
            this.f1134d = c.b.a.m.f.W0(this.f1134d, (int) (f2 * 255.0f));
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public abstract void a();
}

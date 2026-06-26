package com.google.android.material.textview;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleableRes;
import androidx.appcompat.widget.AppCompatTextView;
import c.b.a.m.f;
import c.e.a.b.b0.a.a;
import com.google.android.material.R$attr;
import com.google.android.material.R$styleable;

/* JADX INFO: loaded from: classes.dex */
public class MaterialTextView extends AppCompatTextView {
    public MaterialTextView(@NonNull Context context) {
        this(context, null);
    }

    public static int b(@NonNull Context context, @NonNull TypedArray typedArray, @NonNull @StyleableRes int... iArr) {
        int iL2 = -1;
        for (int i2 = 0; i2 < iArr.length && iL2 < 0; i2++) {
            iL2 = f.l2(context, typedArray, iArr[i2], -1);
        }
        return iL2;
    }

    public final void a(@NonNull Resources.Theme theme, int i2) {
        TypedArray typedArrayObtainStyledAttributes = theme.obtainStyledAttributes(i2, R$styleable.MaterialTextAppearance);
        int iB = b(getContext(), typedArrayObtainStyledAttributes, R$styleable.MaterialTextAppearance_android_lineHeight, R$styleable.MaterialTextAppearance_lineHeight);
        typedArrayObtainStyledAttributes.recycle();
        if (iB >= 0) {
            setLineHeight(iB);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView
    public void setTextAppearance(@NonNull Context context, int i2) {
        super.setTextAppearance(context, i2);
        if (f.M4(context, R$attr.textAppearanceLineHeightEnabled, true)) {
            a(context.getTheme(), i2);
        }
    }

    public MaterialTextView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.textViewStyle);
    }

    public MaterialTextView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(a.a(context, attributeSet, i2, 0), attributeSet, i2);
        Context context2 = getContext();
        if (f.M4(context2, R$attr.textAppearanceLineHeightEnabled, true)) {
            Resources.Theme theme = context2.getTheme();
            int[] iArr = R$styleable.MaterialTextView;
            TypedArray typedArrayObtainStyledAttributes = theme.obtainStyledAttributes(attributeSet, iArr, i2, 0);
            int iB = b(context2, typedArrayObtainStyledAttributes, R$styleable.MaterialTextView_android_lineHeight, R$styleable.MaterialTextView_lineHeight);
            typedArrayObtainStyledAttributes.recycle();
            if (iB != -1) {
                return;
            }
            TypedArray typedArrayObtainStyledAttributes2 = theme.obtainStyledAttributes(attributeSet, iArr, i2, 0);
            int resourceId = typedArrayObtainStyledAttributes2.getResourceId(R$styleable.MaterialTextView_android_textAppearance, -1);
            typedArrayObtainStyledAttributes2.recycle();
            if (resourceId != -1) {
                a(theme, resourceId);
            }
        }
    }
}

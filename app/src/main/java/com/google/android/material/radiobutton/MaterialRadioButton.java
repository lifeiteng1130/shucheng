package com.google.android.material.radiobutton;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.core.widget.CompoundButtonCompat;
import c.b.a.m.f;
import c.e.a.b.b0.a.a;
import c.e.a.b.q.g;
import com.google.android.material.R$attr;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;

/* JADX INFO: loaded from: classes.dex */
public class MaterialRadioButton extends AppCompatRadioButton {
    public static final int a = R$style.Widget_MaterialComponents_CompoundButton_RadioButton;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int[][] f2327b = {new int[]{R.attr.state_enabled, R.attr.state_checked}, new int[]{R.attr.state_enabled, -16842912}, new int[]{-16842910, R.attr.state_checked}, new int[]{-16842910, -16842912}};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public ColorStateList f2328c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f2329d;

    public MaterialRadioButton(@NonNull Context context) {
        this(context, null);
    }

    private ColorStateList getMaterialThemeColorsTintList() {
        if (this.f2328c == null) {
            int iZ1 = f.Z1(this, R$attr.colorControlActivated);
            int iZ12 = f.Z1(this, R$attr.colorOnSurface);
            int iZ13 = f.Z1(this, R$attr.colorSurface);
            int[][] iArr = f2327b;
            int[] iArr2 = new int[iArr.length];
            iArr2[0] = f.M3(iZ13, iZ1, 1.0f);
            iArr2[1] = f.M3(iZ13, iZ12, 0.54f);
            iArr2[2] = f.M3(iZ13, iZ12, 0.38f);
            iArr2[3] = f.M3(iZ13, iZ12, 0.38f);
            this.f2328c = new ColorStateList(iArr, iArr2);
        }
        return this.f2328c;
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f2329d && CompoundButtonCompat.getButtonTintList(this) == null) {
            setUseMaterialThemeColors(true);
        }
    }

    public void setUseMaterialThemeColors(boolean z) {
        this.f2329d = z;
        if (z) {
            CompoundButtonCompat.setButtonTintList(this, getMaterialThemeColorsTintList());
        } else {
            CompoundButtonCompat.setButtonTintList(this, null);
        }
    }

    public MaterialRadioButton(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.radioButtonStyle);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public MaterialRadioButton(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        int i3 = a;
        super(a.a(context, attributeSet, i2, i3), attributeSet, i2);
        Context context2 = getContext();
        TypedArray typedArrayD = g.d(context2, attributeSet, R$styleable.MaterialRadioButton, i2, i3, new int[0]);
        int i4 = R$styleable.MaterialRadioButton_buttonTint;
        if (typedArrayD.hasValue(i4)) {
            CompoundButtonCompat.setButtonTintList(this, f.a2(context2, typedArrayD, i4));
        }
        this.f2329d = typedArrayD.getBoolean(R$styleable.MaterialRadioButton_useMaterialThemeColors, false);
        typedArrayD.recycle();
    }
}

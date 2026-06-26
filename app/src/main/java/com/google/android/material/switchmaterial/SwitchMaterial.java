package com.google.android.material.switchmaterial;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SwitchCompat;
import c.b.a.m.f;
import c.e.a.b.n.a;
import c.e.a.b.q.g;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;

/* JADX INFO: loaded from: classes.dex */
public class SwitchMaterial extends SwitchCompat {
    public static final int a = R$style.Widget_MaterialComponents_CompoundButton_Switch;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int[][] f2397b = {new int[]{R.attr.state_enabled, R.attr.state_checked}, new int[]{R.attr.state_enabled, -16842912}, new int[]{-16842910, R.attr.state_checked}, new int[]{-16842910, -16842912}};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final a f2398c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public ColorStateList f2399d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    public ColorStateList f2400e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f2401f;

    public SwitchMaterial(@NonNull Context context) {
        this(context, null);
    }

    private ColorStateList getMaterialThemeColorsThumbTintList() {
        if (this.f2399d == null) {
            int iZ1 = f.Z1(this, R$attr.colorSurface);
            int iZ12 = f.Z1(this, R$attr.colorControlActivated);
            float dimension = getResources().getDimension(R$dimen.mtrl_switch_thumb_elevation);
            if (this.f2398c.a) {
                dimension += f.I2(this);
            }
            int iA = this.f2398c.a(iZ1, dimension);
            int[][] iArr = f2397b;
            int[] iArr2 = new int[iArr.length];
            iArr2[0] = f.M3(iZ1, iZ12, 1.0f);
            iArr2[1] = iA;
            iArr2[2] = f.M3(iZ1, iZ12, 0.38f);
            iArr2[3] = iA;
            this.f2399d = new ColorStateList(iArr, iArr2);
        }
        return this.f2399d;
    }

    private ColorStateList getMaterialThemeColorsTrackTintList() {
        if (this.f2400e == null) {
            int[][] iArr = f2397b;
            int[] iArr2 = new int[iArr.length];
            int iZ1 = f.Z1(this, R$attr.colorSurface);
            int iZ12 = f.Z1(this, R$attr.colorControlActivated);
            int iZ13 = f.Z1(this, R$attr.colorOnSurface);
            iArr2[0] = f.M3(iZ1, iZ12, 0.54f);
            iArr2[1] = f.M3(iZ1, iZ13, 0.32f);
            iArr2[2] = f.M3(iZ1, iZ12, 0.12f);
            iArr2[3] = f.M3(iZ1, iZ13, 0.12f);
            this.f2400e = new ColorStateList(iArr, iArr2);
        }
        return this.f2400e;
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f2401f && getThumbTintList() == null) {
            setThumbTintList(getMaterialThemeColorsThumbTintList());
        }
        if (this.f2401f && getTrackTintList() == null) {
            setTrackTintList(getMaterialThemeColorsTrackTintList());
        }
    }

    public void setUseMaterialThemeColors(boolean z) {
        this.f2401f = z;
        if (z) {
            setThumbTintList(getMaterialThemeColorsThumbTintList());
            setTrackTintList(getMaterialThemeColorsTrackTintList());
        } else {
            setThumbTintList(null);
            setTrackTintList(null);
        }
    }

    public SwitchMaterial(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.switchStyle);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public SwitchMaterial(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        int i3 = a;
        super(c.e.a.b.b0.a.a.a(context, attributeSet, i2, i3), attributeSet, i2);
        Context context2 = getContext();
        this.f2398c = new a(context2);
        TypedArray typedArrayD = g.d(context2, attributeSet, R$styleable.SwitchMaterial, i2, i3, new int[0]);
        this.f2401f = typedArrayD.getBoolean(R$styleable.SwitchMaterial_useMaterialThemeColors, false);
        typedArrayD.recycle();
    }
}

package com.jaredrummler.android.colorpicker;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.AttributeSet;
import androidx.annotation.ColorInt;
import androidx.constraintlayout.motion.widget.Key;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.preference.Preference;
import androidx.preference.PreferenceViewHolder;
import c.f.a.a.f;
import com.jaredrummler.android.colorpicker.ColorPickerDialog;

/* JADX INFO: loaded from: classes.dex */
public class ColorPreferenceCompat extends Preference implements f {
    public a a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f2605b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f2606c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @ColorPickerDialog.DialogType
    public int f2607d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f2608e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f2609f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f2610g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f2611h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f2612i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f2613j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int[] f2614k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f2615l;

    public interface a {
        void a(String str, int i2);
    }

    public ColorPreferenceCompat(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2605b = ViewCompat.MEASURED_STATE_MASK;
        setPersistent(true);
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.ColorPreference);
        this.f2606c = typedArrayObtainStyledAttributes.getBoolean(R$styleable.ColorPreference_cpv_showDialog, true);
        this.f2607d = typedArrayObtainStyledAttributes.getInt(R$styleable.ColorPreference_cpv_dialogType, 1);
        this.f2608e = typedArrayObtainStyledAttributes.getInt(R$styleable.ColorPreference_cpv_colorShape, 1);
        this.f2609f = typedArrayObtainStyledAttributes.getBoolean(R$styleable.ColorPreference_cpv_allowPresets, true);
        this.f2610g = typedArrayObtainStyledAttributes.getBoolean(R$styleable.ColorPreference_cpv_allowCustom, true);
        this.f2611h = typedArrayObtainStyledAttributes.getBoolean(R$styleable.ColorPreference_cpv_showAlphaSlider, false);
        this.f2612i = typedArrayObtainStyledAttributes.getBoolean(R$styleable.ColorPreference_cpv_showColorShades, true);
        this.f2613j = typedArrayObtainStyledAttributes.getInt(R$styleable.ColorPreference_cpv_previewSize, 0);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(R$styleable.ColorPreference_cpv_colorPresets, 0);
        this.f2615l = typedArrayObtainStyledAttributes.getResourceId(R$styleable.ColorPreference_cpv_dialogTitle, R$string.cpv_default_title);
        if (resourceId != 0) {
            this.f2614k = getContext().getResources().getIntArray(resourceId);
        } else {
            this.f2614k = ColorPickerDialog.a;
        }
        if (this.f2608e == 1) {
            setWidgetLayoutResource(this.f2613j == 1 ? R$layout.cpv_preference_circle_large : R$layout.cpv_preference_circle);
        } else {
            setWidgetLayoutResource(this.f2613j == 1 ? R$layout.cpv_preference_square_large : R$layout.cpv_preference_square);
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public FragmentActivity a() {
        Context context = getContext();
        if (context instanceof FragmentActivity) {
            return (FragmentActivity) context;
        }
        if (context instanceof ContextWrapper) {
            Context baseContext = ((ContextWrapper) context).getBaseContext();
            if (baseContext instanceof FragmentActivity) {
                return (FragmentActivity) baseContext;
            }
        }
        throw new IllegalStateException("Error getting activity from context");
    }

    @Override // c.f.a.a.f
    public void d0(int i2) {
    }

    @Override // c.f.a.a.f
    public void i0(int i2, @ColorInt int i3) {
        this.f2605b = i3;
        persistInt(i3);
        notifyChanged();
        callChangeListener(Integer.valueOf(i3));
    }

    @Override // androidx.preference.Preference
    public void onAttached() {
        super.onAttached();
        if (this.f2606c) {
            FragmentManager supportFragmentManager = a().getSupportFragmentManager();
            StringBuilder sbR = c.a.a.a.a.r("color_");
            sbR.append(getKey());
            ColorPickerDialog colorPickerDialog = (ColorPickerDialog) supportFragmentManager.findFragmentByTag(sbR.toString());
            if (colorPickerDialog != null) {
                colorPickerDialog.f2567b = this;
            }
        }
    }

    @Override // androidx.preference.Preference
    public void onBindViewHolder(PreferenceViewHolder preferenceViewHolder) {
        super.onBindViewHolder(preferenceViewHolder);
        ColorPanelView colorPanelView = (ColorPanelView) preferenceViewHolder.itemView.findViewById(R$id.cpv_preference_preview_color_panel);
        if (colorPanelView != null) {
            colorPanelView.setColor(this.f2605b);
        }
    }

    @Override // androidx.preference.Preference
    public void onClick() {
        super.onClick();
        a aVar = this.a;
        if (aVar != null) {
            aVar.a((String) getTitle(), this.f2605b);
            return;
        }
        if (this.f2606c) {
            int[] iArr = ColorPickerDialog.a;
            int i2 = R$string.cpv_presets;
            int i3 = R$string.cpv_custom;
            int i4 = R$string.cpv_select;
            int[] iArr2 = ColorPickerDialog.a;
            int i5 = this.f2607d;
            int i6 = this.f2615l;
            int i7 = this.f2608e;
            int[] iArr3 = this.f2614k;
            boolean z = this.f2609f;
            boolean z2 = this.f2610g;
            boolean z3 = this.f2611h;
            boolean z4 = this.f2612i;
            int i8 = this.f2605b;
            ColorPickerDialog colorPickerDialog = new ColorPickerDialog();
            Bundle bundle = new Bundle();
            bundle.putInt("id", 0);
            bundle.putInt("dialogType", i5);
            bundle.putInt("color", i8);
            bundle.putIntArray("presets", iArr3);
            bundle.putBoolean(Key.ALPHA, z3);
            bundle.putBoolean("allowCustom", z2);
            bundle.putBoolean("allowPresets", z);
            bundle.putInt("dialogTitle", i6);
            bundle.putBoolean("showColorShades", z4);
            bundle.putInt("colorShape", i7);
            bundle.putInt("presetsButtonText", i2);
            bundle.putInt("customButtonText", i3);
            bundle.putInt("selectedButtonText", i4);
            colorPickerDialog.setArguments(bundle);
            colorPickerDialog.f2567b = this;
            FragmentTransaction fragmentTransactionBeginTransaction = a().getSupportFragmentManager().beginTransaction();
            StringBuilder sbR = c.a.a.a.a.r("color_");
            sbR.append(getKey());
            fragmentTransactionBeginTransaction.add(colorPickerDialog, sbR.toString()).commitAllowingStateLoss();
        }
    }

    @Override // androidx.preference.Preference
    public Object onGetDefaultValue(TypedArray typedArray, int i2) {
        return Integer.valueOf(typedArray.getInteger(i2, ViewCompat.MEASURED_STATE_MASK));
    }

    @Override // androidx.preference.Preference
    public void onSetInitialValue(Object obj) {
        super.onSetInitialValue(obj);
        if (!(obj instanceof Integer)) {
            this.f2605b = getPersistedInt(ViewCompat.MEASURED_STATE_MASK);
            return;
        }
        int iIntValue = ((Integer) obj).intValue();
        this.f2605b = iIntValue;
        persistInt(iIntValue);
    }

    public void setOnShowDialogListener(a aVar) {
        this.a = aVar;
    }
}

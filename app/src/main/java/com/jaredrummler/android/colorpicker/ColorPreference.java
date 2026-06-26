package com.jaredrummler.android.colorpicker;

import android.content.res.TypedArray;
import android.preference.Preference;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.core.view.ViewCompat;
import c.f.a.a.f;

/* JADX INFO: loaded from: classes.dex */
public class ColorPreference extends Preference implements f {
    public a a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f2604b;

    public interface a {
        void a(String str, int i2);
    }

    @Override // c.f.a.a.f
    public void d0(int i2) {
    }

    @Override // c.f.a.a.f
    public void i0(int i2, @ColorInt int i3) {
        this.f2604b = i3;
        persistInt(i3);
        notifyChanged();
        callChangeListener(Integer.valueOf(i3));
    }

    @Override // android.preference.Preference
    public void onAttachedToActivity() {
        super.onAttachedToActivity();
    }

    @Override // android.preference.Preference
    public void onBindView(View view) {
        super.onBindView(view);
        ColorPanelView colorPanelView = (ColorPanelView) view.findViewById(R$id.cpv_preference_preview_color_panel);
        if (colorPanelView != null) {
            colorPanelView.setColor(this.f2604b);
        }
    }

    @Override // android.preference.Preference
    public void onClick() {
        super.onClick();
        a aVar = this.a;
        if (aVar != null) {
            aVar.a((String) getTitle(), this.f2604b);
        }
    }

    @Override // android.preference.Preference
    public Object onGetDefaultValue(TypedArray typedArray, int i2) {
        return Integer.valueOf(typedArray.getInteger(i2, ViewCompat.MEASURED_STATE_MASK));
    }

    @Override // android.preference.Preference
    public void onSetInitialValue(boolean z, Object obj) {
        if (z) {
            this.f2604b = getPersistedInt(ViewCompat.MEASURED_STATE_MASK);
            return;
        }
        int iIntValue = ((Integer) obj).intValue();
        this.f2604b = iIntValue;
        persistInt(iIntValue);
    }

    public void setOnShowDialogListener(a aVar) {
        this.a = aVar;
    }
}

package c.e.a.b.c0;

import com.google.android.material.R$id;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.timepicker.TimePickerView;

/* JADX INFO: compiled from: TimePickerView.java */
/* JADX INFO: loaded from: classes.dex */
public class k implements MaterialButtonToggleGroup.e {
    public final /* synthetic */ TimePickerView a;

    public k(TimePickerView timePickerView) {
        this.a = timePickerView;
    }

    @Override // com.google.android.material.button.MaterialButtonToggleGroup.e
    public void a(MaterialButtonToggleGroup materialButtonToggleGroup, int i2, boolean z) {
        int i3 = i2 == R$id.material_clock_period_pm_button ? 1 : 0;
        TimePickerView.c cVar = this.a.f2506g;
        if (cVar == null || !z) {
            return;
        }
        ((f) cVar).f923e.f(i3);
    }
}

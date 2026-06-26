package c.e.a.b.c0;

import com.google.android.material.R$id;
import com.google.android.material.button.MaterialButtonToggleGroup;

/* JADX INFO: compiled from: TimePickerTextInputPresenter.java */
/* JADX INFO: loaded from: classes.dex */
public class j implements MaterialButtonToggleGroup.e {
    public final /* synthetic */ i a;

    public j(i iVar) {
        this.a = iVar;
    }

    @Override // com.google.android.material.button.MaterialButtonToggleGroup.e
    public void a(MaterialButtonToggleGroup materialButtonToggleGroup, int i2, boolean z) {
        this.a.f930b.f(i2 == R$id.material_clock_period_pm_button ? 1 : 0);
    }
}

package c.e.a.b.l;

import android.view.View;
import com.google.android.material.datepicker.MaterialDatePicker;

/* JADX INFO: compiled from: MaterialDatePicker.java */
/* JADX INFO: loaded from: classes.dex */
public class m implements View.OnClickListener {
    public final /* synthetic */ MaterialDatePicker a;

    public m(MaterialDatePicker materialDatePicker) {
        this.a = materialDatePicker;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        MaterialDatePicker materialDatePicker = this.a;
        materialDatePicker.r.setEnabled(materialDatePicker.f2202g.E());
        this.a.p.toggle();
        MaterialDatePicker materialDatePicker2 = this.a;
        materialDatePicker2.S(materialDatePicker2.p);
        this.a.Q();
    }
}

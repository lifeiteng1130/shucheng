package c.e.a.b.l;

import android.view.View;
import com.google.android.material.datepicker.MaterialCalendar;

/* JADX INFO: compiled from: MaterialCalendar.java */
/* JADX INFO: loaded from: classes.dex */
public class i implements View.OnClickListener {
    public final /* synthetic */ MaterialCalendar a;

    public i(MaterialCalendar materialCalendar) {
        this.a = materialCalendar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        MaterialCalendar materialCalendar = this.a;
        MaterialCalendar.e eVar = materialCalendar.f2188g;
        MaterialCalendar.e eVar2 = MaterialCalendar.e.YEAR;
        if (eVar == eVar2) {
            materialCalendar.R(MaterialCalendar.e.DAY);
        } else if (eVar == MaterialCalendar.e.DAY) {
            materialCalendar.R(eVar2);
        }
    }
}

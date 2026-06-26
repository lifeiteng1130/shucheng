package c.e.a.b.l;

import android.view.View;
import com.google.android.material.datepicker.CalendarConstraints;
import com.google.android.material.datepicker.MaterialCalendar;
import com.google.android.material.datepicker.Month;
import com.google.android.material.datepicker.YearGridAdapter;

/* JADX INFO: compiled from: YearGridAdapter.java */
/* JADX INFO: loaded from: classes.dex */
public class v implements View.OnClickListener {
    public final /* synthetic */ int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ YearGridAdapter f1043b;

    public v(YearGridAdapter yearGridAdapter, int i2) {
        this.f1043b = yearGridAdapter;
        this.a = i2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Month monthD = Month.d(this.a, this.f1043b.a.f2187f.f2211b);
        CalendarConstraints calendarConstraints = this.f1043b.a.f2186e;
        if (monthD.compareTo(calendarConstraints.a) < 0) {
            monthD = calendarConstraints.a;
        } else if (monthD.compareTo(calendarConstraints.f2170b) > 0) {
            monthD = calendarConstraints.f2170b;
        }
        this.f1043b.a.Q(monthD);
        this.f1043b.a.R(MaterialCalendar.e.DAY);
    }
}

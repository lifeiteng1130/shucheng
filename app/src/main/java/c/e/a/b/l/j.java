package c.e.a.b.l;

import android.view.View;
import com.google.android.material.datepicker.MaterialCalendar;
import com.google.android.material.datepicker.MonthsPagerAdapter;

/* JADX INFO: compiled from: MaterialCalendar.java */
/* JADX INFO: loaded from: classes.dex */
public class j implements View.OnClickListener {
    public final /* synthetic */ MonthsPagerAdapter a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MaterialCalendar f1033b;

    public j(MaterialCalendar materialCalendar, MonthsPagerAdapter monthsPagerAdapter) {
        this.f1033b = materialCalendar;
        this.a = monthsPagerAdapter;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int iFindFirstVisibleItemPosition = this.f1033b.O().findFirstVisibleItemPosition() + 1;
        if (iFindFirstVisibleItemPosition < this.f1033b.f2191j.getAdapter().getItemCount()) {
            this.f1033b.Q(this.a.d(iFindFirstVisibleItemPosition));
        }
    }
}

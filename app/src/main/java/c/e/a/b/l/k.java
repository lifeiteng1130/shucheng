package c.e.a.b.l;

import android.view.View;
import com.google.android.material.datepicker.MaterialCalendar;
import com.google.android.material.datepicker.MonthsPagerAdapter;

/* JADX INFO: compiled from: MaterialCalendar.java */
/* JADX INFO: loaded from: classes.dex */
public class k implements View.OnClickListener {
    public final /* synthetic */ MonthsPagerAdapter a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MaterialCalendar f1034b;

    public k(MaterialCalendar materialCalendar, MonthsPagerAdapter monthsPagerAdapter) {
        this.f1034b = materialCalendar;
        this.a = monthsPagerAdapter;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int iFindLastVisibleItemPosition = this.f1034b.O().findLastVisibleItemPosition() - 1;
        if (iFindLastVisibleItemPosition >= 0) {
            this.f1034b.Q(this.a.d(iFindLastVisibleItemPosition));
        }
    }
}

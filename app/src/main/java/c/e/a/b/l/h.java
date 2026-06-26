package c.e.a.b.l;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.datepicker.MaterialCalendar;
import com.google.android.material.datepicker.MonthsPagerAdapter;

/* JADX INFO: compiled from: MaterialCalendar.java */
/* JADX INFO: loaded from: classes.dex */
public class h extends RecyclerView.OnScrollListener {
    public final /* synthetic */ MonthsPagerAdapter a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MaterialButton f1031b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ MaterialCalendar f1032c;

    public h(MaterialCalendar materialCalendar, MonthsPagerAdapter monthsPagerAdapter, MaterialButton materialButton) {
        this.f1032c = materialCalendar;
        this.a = monthsPagerAdapter;
        this.f1031b = materialButton;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i2) {
        if (i2 == 0) {
            recyclerView.announceForAccessibility(this.f1031b.getText());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrolled(@NonNull RecyclerView recyclerView, int i2, int i3) {
        int iFindFirstVisibleItemPosition = i2 < 0 ? this.f1032c.O().findFirstVisibleItemPosition() : this.f1032c.O().findLastVisibleItemPosition();
        this.f1032c.f2187f = this.a.d(iFindFirstVisibleItemPosition);
        MaterialButton materialButton = this.f1031b;
        MonthsPagerAdapter monthsPagerAdapter = this.a;
        materialButton.setText(monthsPagerAdapter.f2217b.a.i(iFindFirstVisibleItemPosition).h(monthsPagerAdapter.a));
    }
}

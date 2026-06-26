package c.e.a.b.l;

import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.google.android.material.datepicker.CalendarConstraints;
import com.google.android.material.datepicker.DateSelector;
import com.google.android.material.datepicker.MaterialCalendarGridView;
import com.google.android.material.datepicker.Month;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: compiled from: MonthAdapter.java */
/* JADX INFO: loaded from: classes.dex */
public class o extends BaseAdapter {
    public static final int a = u.i().getMaximum(4);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Month f1035b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final DateSelector<?> f1036c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Collection<Long> f1037d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public b f1038e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final CalendarConstraints f1039f;

    public o(Month month, DateSelector<?> dateSelector, CalendarConstraints calendarConstraints) {
        this.f1035b = month;
        this.f1036c = dateSelector;
        this.f1039f = calendarConstraints;
        this.f1037d = dateSelector.F();
    }

    public int a(int i2) {
        return b() + (i2 - 1);
    }

    public int b() {
        return this.f1035b.f();
    }

    @Override // android.widget.Adapter
    @Nullable
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public Long getItem(int i2) {
        if (i2 < this.f1035b.f() || i2 > d()) {
            return null;
        }
        Month month = this.f1035b;
        return Long.valueOf(month.g((i2 - month.f()) + 1));
    }

    public int d() {
        return (this.f1035b.f() + this.f1035b.f2214e) - 1;
    }

    public final void e(@Nullable TextView textView, long j2) {
        a aVar;
        if (textView == null) {
            return;
        }
        boolean z = false;
        if (this.f1039f.f2171c.c(j2)) {
            textView.setEnabled(true);
            Iterator<Long> it = this.f1036c.F().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if (u.a(j2) == u.a(it.next().longValue())) {
                    z = true;
                    break;
                }
            }
            aVar = z ? this.f1038e.f1012b : u.h().getTimeInMillis() == j2 ? this.f1038e.f1013c : this.f1038e.a;
        } else {
            textView.setEnabled(false);
            aVar = this.f1038e.f1017g;
        }
        aVar.b(textView);
    }

    public final void f(MaterialCalendarGridView materialCalendarGridView, long j2) {
        if (Month.e(j2).equals(this.f1035b)) {
            Calendar calendarD = u.d(this.f1035b.a);
            calendarD.setTimeInMillis(j2);
            e((TextView) materialCalendarGridView.getChildAt(materialCalendarGridView.getAdapter().a(calendarD.get(5)) - materialCalendarGridView.getFirstVisiblePosition()), j2);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return b() + this.f1035b.f2214e;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return i2 / this.f1035b.f2213d;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x00d9  */
    @Override // android.widget.Adapter
    @androidx.annotation.NonNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.view.View getView(int r7, @androidx.annotation.Nullable android.view.View r8, @androidx.annotation.NonNull android.view.ViewGroup r9) {
        /*
            Method dump skipped, instruction units count: 240
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c.e.a.b.l.o.getView(int, android.view.View, android.view.ViewGroup):android.view.View");
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return true;
    }
}

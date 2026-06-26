package c.e.a.b.l;

import android.annotation.SuppressLint;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.R$layout;
import com.google.android.material.R$string;
import java.util.Calendar;
import java.util.Locale;

/* JADX INFO: compiled from: DaysOfWeekAdapter.java */
/* JADX INFO: loaded from: classes.dex */
public class e extends BaseAdapter {
    public static final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final Calendar f1026b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f1027c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f1028d;

    static {
        a = Build.VERSION.SDK_INT >= 26 ? 4 : 1;
    }

    public e() {
        Calendar calendarI = u.i();
        this.f1026b = calendarI;
        this.f1027c = calendarI.getMaximum(7);
        this.f1028d = calendarI.getFirstDayOfWeek();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f1027c;
    }

    @Override // android.widget.Adapter
    @Nullable
    public Object getItem(int i2) {
        int i3 = this.f1027c;
        if (i2 >= i3) {
            return null;
        }
        int i4 = i2 + this.f1028d;
        if (i4 > i3) {
            i4 -= i3;
        }
        return Integer.valueOf(i4);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return 0L;
    }

    @Override // android.widget.Adapter
    @Nullable
    @SuppressLint({"WrongConstant"})
    public View getView(int i2, @Nullable View view, @NonNull ViewGroup viewGroup) {
        TextView textView = (TextView) view;
        if (view == null) {
            textView = (TextView) LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.mtrl_calendar_day_of_week, viewGroup, false);
        }
        Calendar calendar = this.f1026b;
        int i3 = i2 + this.f1028d;
        int i4 = this.f1027c;
        if (i3 > i4) {
            i3 -= i4;
        }
        calendar.set(7, i3);
        textView.setText(this.f1026b.getDisplayName(7, a, textView.getResources().getConfiguration().locale));
        textView.setContentDescription(String.format(viewGroup.getContext().getString(R$string.mtrl_picker_day_of_week_column_header), this.f1026b.getDisplayName(7, 2, Locale.getDefault())));
        return textView;
    }
}

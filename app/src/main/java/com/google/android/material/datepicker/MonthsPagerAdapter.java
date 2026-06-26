package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import c.e.a.b.l.o;
import c.e.a.b.l.p;
import com.google.android.material.R$dimen;
import com.google.android.material.R$id;
import com.google.android.material.R$layout;
import com.google.android.material.datepicker.MaterialCalendar;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class MonthsPagerAdapter extends RecyclerView.Adapter<ViewHolder> {
    public final Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final CalendarConstraints f2217b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final DateSelector<?> f2218c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final MaterialCalendar.f f2219d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f2220e;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final MaterialCalendarGridView f2221b;

        public ViewHolder(@NonNull LinearLayout linearLayout, boolean z) {
            super(linearLayout);
            TextView textView = (TextView) linearLayout.findViewById(R$id.month_title);
            this.a = textView;
            ViewCompat.setAccessibilityHeading(textView, true);
            this.f2221b = (MaterialCalendarGridView) linearLayout.findViewById(R$id.month_grid);
            if (z) {
                return;
            }
            textView.setVisibility(8);
        }
    }

    public MonthsPagerAdapter(@NonNull Context context, DateSelector<?> dateSelector, @NonNull CalendarConstraints calendarConstraints, MaterialCalendar.f fVar) {
        Month month = calendarConstraints.a;
        Month month2 = calendarConstraints.f2170b;
        Month month3 = calendarConstraints.f2172d;
        if (month.compareTo(month3) > 0) {
            throw new IllegalArgumentException("firstPage cannot be after currentPage");
        }
        if (month3.compareTo(month2) > 0) {
            throw new IllegalArgumentException("currentPage cannot be after lastPage");
        }
        int i2 = o.a;
        int i3 = MaterialCalendar.f2183b;
        Resources resources = context.getResources();
        int i4 = R$dimen.mtrl_calendar_day_height;
        int dimensionPixelSize = i2 * resources.getDimensionPixelSize(i4);
        int dimensionPixelSize2 = MaterialDatePicker.O(context) ? context.getResources().getDimensionPixelSize(i4) : 0;
        this.a = context;
        this.f2220e = dimensionPixelSize + dimensionPixelSize2;
        this.f2217b = calendarConstraints;
        this.f2218c = dateSelector;
        this.f2219d = fVar;
        setHasStableIds(true);
    }

    @NonNull
    public Month d(int i2) {
        return this.f2217b.a.i(i2);
    }

    public int e(@NonNull Month month) {
        return this.f2217b.a.j(month);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f2217b.f2174f;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i2) {
        return this.f2217b.a.i(i2).a.getTimeInMillis();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i2) {
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        Month monthI = this.f2217b.a.i(i2);
        viewHolder2.a.setText(monthI.h(viewHolder2.itemView.getContext()));
        MaterialCalendarGridView materialCalendarGridView = (MaterialCalendarGridView) viewHolder2.f2221b.findViewById(R$id.month_grid);
        if (materialCalendarGridView.getAdapter() == null || !monthI.equals(materialCalendarGridView.getAdapter().f1035b)) {
            o oVar = new o(monthI, this.f2218c, this.f2217b);
            materialCalendarGridView.setNumColumns(monthI.f2213d);
            materialCalendarGridView.setAdapter((ListAdapter) oVar);
        } else {
            materialCalendarGridView.invalidate();
            o adapter = materialCalendarGridView.getAdapter();
            Iterator<Long> it = adapter.f1037d.iterator();
            while (it.hasNext()) {
                adapter.f(materialCalendarGridView, it.next().longValue());
            }
            DateSelector<?> dateSelector = adapter.f1036c;
            if (dateSelector != null) {
                Iterator<Long> it2 = dateSelector.F().iterator();
                while (it2.hasNext()) {
                    adapter.f(materialCalendarGridView, it2.next().longValue());
                }
                adapter.f1037d = adapter.f1036c.F();
            }
        }
        materialCalendarGridView.setOnItemClickListener(new p(this, materialCalendarGridView));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.mtrl_calendar_month_labeled, viewGroup, false);
        if (!MaterialDatePicker.O(viewGroup.getContext())) {
            return new ViewHolder(linearLayout, false);
        }
        linearLayout.setLayoutParams(new RecyclerView.LayoutParams(-1, this.f2220e));
        return new ViewHolder(linearLayout, true);
    }
}

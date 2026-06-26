package com.google.android.material.datepicker;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import c.e.a.b.l.a;
import c.e.a.b.l.b;
import c.e.a.b.l.u;
import c.e.a.b.l.v;
import com.google.android.material.R$layout;
import com.google.android.material.R$string;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class YearGridAdapter extends RecyclerView.Adapter<ViewHolder> {
    public final MaterialCalendar<?> a;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView a;

        public ViewHolder(TextView textView) {
            super(textView);
            this.a = textView;
        }
    }

    public YearGridAdapter(MaterialCalendar<?> materialCalendar) {
        this.a = materialCalendar;
    }

    public int d(int i2) {
        return i2 - this.a.f2186e.a.f2212c;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.a.f2186e.f2173e;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i2) {
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        int i3 = this.a.f2186e.a.f2212c + i2;
        String string = viewHolder2.a.getContext().getString(R$string.mtrl_picker_navigate_to_year_description);
        viewHolder2.a.setText(String.format(Locale.getDefault(), "%d", Integer.valueOf(i3)));
        viewHolder2.a.setContentDescription(String.format(string, Integer.valueOf(i3)));
        b bVar = this.a.f2189h;
        Calendar calendarH = u.h();
        a aVar = calendarH.get(1) == i3 ? bVar.f1016f : bVar.f1014d;
        Iterator<Long> it = this.a.f2185d.F().iterator();
        while (it.hasNext()) {
            calendarH.setTimeInMillis(it.next().longValue());
            if (calendarH.get(1) == i3) {
                aVar = bVar.f1015e;
            }
        }
        aVar.b(viewHolder2.a);
        viewHolder2.a.setOnClickListener(new v(this, i3));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
        return new ViewHolder((TextView) LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.mtrl_calendar_year, viewGroup, false));
    }
}

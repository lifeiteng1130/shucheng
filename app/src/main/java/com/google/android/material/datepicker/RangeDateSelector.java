package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.util.Pair;
import c.b.a.m.f;
import c.e.a.b.l.q;
import c.e.a.b.l.u;
import c.e.a.b.q.j;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$id;
import com.google.android.material.R$layout;
import com.google.android.material.R$string;
import com.google.android.material.textfield.TextInputLayout;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class RangeDateSelector implements DateSelector<Pair<Long, Long>> {
    public static final Parcelable.Creator<RangeDateSelector> CREATOR = new c();
    public String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public Long f2222b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public Long f2223c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public Long f2224d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    public Long f2225e = null;

    public class a extends c.e.a.b.l.c {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ TextInputLayout f2226g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ TextInputLayout f2227h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ q f2228i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, DateFormat dateFormat, TextInputLayout textInputLayout, CalendarConstraints calendarConstraints, TextInputLayout textInputLayout2, TextInputLayout textInputLayout3, q qVar) {
            super(str, dateFormat, textInputLayout, calendarConstraints);
            this.f2226g = textInputLayout2;
            this.f2227h = textInputLayout3;
            this.f2228i = qVar;
        }

        @Override // c.e.a.b.l.c
        public void a() {
            RangeDateSelector rangeDateSelector = RangeDateSelector.this;
            rangeDateSelector.f2224d = null;
            RangeDateSelector.b(rangeDateSelector, this.f2226g, this.f2227h, this.f2228i);
        }

        @Override // c.e.a.b.l.c
        public void b(@Nullable Long l2) {
            RangeDateSelector rangeDateSelector = RangeDateSelector.this;
            rangeDateSelector.f2224d = l2;
            RangeDateSelector.b(rangeDateSelector, this.f2226g, this.f2227h, this.f2228i);
        }
    }

    public class b extends c.e.a.b.l.c {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ TextInputLayout f2230g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ TextInputLayout f2231h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ q f2232i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String str, DateFormat dateFormat, TextInputLayout textInputLayout, CalendarConstraints calendarConstraints, TextInputLayout textInputLayout2, TextInputLayout textInputLayout3, q qVar) {
            super(str, dateFormat, textInputLayout, calendarConstraints);
            this.f2230g = textInputLayout2;
            this.f2231h = textInputLayout3;
            this.f2232i = qVar;
        }

        @Override // c.e.a.b.l.c
        public void a() {
            RangeDateSelector rangeDateSelector = RangeDateSelector.this;
            rangeDateSelector.f2225e = null;
            RangeDateSelector.b(rangeDateSelector, this.f2230g, this.f2231h, this.f2232i);
        }

        @Override // c.e.a.b.l.c
        public void b(@Nullable Long l2) {
            RangeDateSelector rangeDateSelector = RangeDateSelector.this;
            rangeDateSelector.f2225e = l2;
            RangeDateSelector.b(rangeDateSelector, this.f2230g, this.f2231h, this.f2232i);
        }
    }

    public static class c implements Parcelable.Creator<RangeDateSelector> {
        @Override // android.os.Parcelable.Creator
        @NonNull
        public RangeDateSelector createFromParcel(@NonNull Parcel parcel) {
            RangeDateSelector rangeDateSelector = new RangeDateSelector();
            rangeDateSelector.f2222b = (Long) parcel.readValue(Long.class.getClassLoader());
            rangeDateSelector.f2223c = (Long) parcel.readValue(Long.class.getClassLoader());
            return rangeDateSelector;
        }

        @Override // android.os.Parcelable.Creator
        @NonNull
        public RangeDateSelector[] newArray(int i2) {
            return new RangeDateSelector[i2];
        }
    }

    public static void b(RangeDateSelector rangeDateSelector, TextInputLayout textInputLayout, TextInputLayout textInputLayout2, q qVar) {
        Long l2 = rangeDateSelector.f2224d;
        if (l2 == null || rangeDateSelector.f2225e == null) {
            if (textInputLayout.getError() != null && rangeDateSelector.a.contentEquals(textInputLayout.getError())) {
                textInputLayout.setError(null);
            }
            if (textInputLayout2.getError() != null && " ".contentEquals(textInputLayout2.getError())) {
                textInputLayout2.setError(null);
            }
            qVar.a();
            return;
        }
        if (!rangeDateSelector.d(l2.longValue(), rangeDateSelector.f2225e.longValue())) {
            textInputLayout.setError(rangeDateSelector.a);
            textInputLayout2.setError(" ");
            qVar.a();
        } else {
            Long l3 = rangeDateSelector.f2224d;
            rangeDateSelector.f2222b = l3;
            Long l4 = rangeDateSelector.f2225e;
            rangeDateSelector.f2223c = l4;
            qVar.b(new Pair(l3, l4));
        }
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public int C(@NonNull Context context) {
        Resources resources = context.getResources();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        return f.N4(context, Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels) > resources.getDimensionPixelSize(R$dimen.mtrl_calendar_maximum_default_fullscreen_minor_axis) ? R$attr.materialCalendarTheme : R$attr.materialCalendarFullscreenTheme, MaterialDatePicker.class.getCanonicalName());
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public boolean E() {
        Long l2 = this.f2222b;
        return (l2 == null || this.f2223c == null || !d(l2.longValue(), this.f2223c.longValue())) ? false : true;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    @NonNull
    public Collection<Long> F() {
        ArrayList arrayList = new ArrayList();
        Long l2 = this.f2222b;
        if (l2 != null) {
            arrayList.add(l2);
        }
        Long l3 = this.f2223c;
        if (l3 != null) {
            arrayList.add(l3);
        }
        return arrayList;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    @NonNull
    public Pair<Long, Long> H() {
        return new Pair<>(this.f2222b, this.f2223c);
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public void L(long j2) {
        Long l2 = this.f2222b;
        if (l2 == null) {
            this.f2222b = Long.valueOf(j2);
        } else if (this.f2223c == null && d(l2.longValue(), j2)) {
            this.f2223c = Long.valueOf(j2);
        } else {
            this.f2223c = null;
            this.f2222b = Long.valueOf(j2);
        }
    }

    @Override // com.google.android.material.datepicker.DateSelector
    @NonNull
    public String a(@NonNull Context context) {
        Pair pairCreate;
        Resources resources = context.getResources();
        Long l2 = this.f2222b;
        if (l2 == null && this.f2223c == null) {
            return resources.getString(R$string.mtrl_picker_range_header_unselected);
        }
        Long l3 = this.f2223c;
        if (l3 == null) {
            return resources.getString(R$string.mtrl_picker_range_header_only_start_selected, f.g2(l2.longValue()));
        }
        if (l2 == null) {
            return resources.getString(R$string.mtrl_picker_range_header_only_end_selected, f.g2(l3.longValue()));
        }
        if (l2 == null && l3 == null) {
            pairCreate = Pair.create(null, null);
        } else if (l2 == null) {
            pairCreate = Pair.create(null, f.h2(l3.longValue(), null));
        } else if (l3 == null) {
            pairCreate = Pair.create(f.h2(l2.longValue(), null), null);
        } else {
            Calendar calendarH = u.h();
            Calendar calendarI = u.i();
            calendarI.setTimeInMillis(l2.longValue());
            Calendar calendarI2 = u.i();
            calendarI2.setTimeInMillis(l3.longValue());
            pairCreate = calendarI.get(1) == calendarI2.get(1) ? calendarI.get(1) == calendarH.get(1) ? Pair.create(f.B2(l2.longValue(), Locale.getDefault()), f.B2(l3.longValue(), Locale.getDefault())) : Pair.create(f.B2(l2.longValue(), Locale.getDefault()), f.d3(l3.longValue(), Locale.getDefault())) : Pair.create(f.d3(l2.longValue(), Locale.getDefault()), f.d3(l3.longValue(), Locale.getDefault()));
        }
        return resources.getString(R$string.mtrl_picker_range_header_selected, pairCreate.first, pairCreate.second);
    }

    public final boolean d(long j2, long j3) {
        return j2 <= j3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    @NonNull
    public Collection<Pair<Long, Long>> t() {
        if (this.f2222b == null || this.f2223c == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Pair(this.f2222b, this.f2223c));
        return arrayList;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i2) {
        parcel.writeValue(this.f2222b);
        parcel.writeValue(this.f2223c);
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public View z(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle, CalendarConstraints calendarConstraints, @NonNull q<Pair<Long, Long>> qVar) {
        View viewInflate = layoutInflater.inflate(R$layout.mtrl_picker_text_input_date_range, viewGroup, false);
        TextInputLayout textInputLayout = (TextInputLayout) viewInflate.findViewById(R$id.mtrl_picker_text_input_range_start);
        TextInputLayout textInputLayout2 = (TextInputLayout) viewInflate.findViewById(R$id.mtrl_picker_text_input_range_end);
        EditText editText = textInputLayout.getEditText();
        EditText editText2 = textInputLayout2.getEditText();
        if (f.v3()) {
            editText.setInputType(17);
            editText2.setInputType(17);
        }
        this.a = viewInflate.getResources().getString(R$string.mtrl_picker_invalid_range);
        SimpleDateFormat simpleDateFormatE = u.e();
        Long l2 = this.f2222b;
        if (l2 != null) {
            editText.setText(simpleDateFormatE.format(l2));
            this.f2224d = this.f2222b;
        }
        Long l3 = this.f2223c;
        if (l3 != null) {
            editText2.setText(simpleDateFormatE.format(l3));
            this.f2225e = this.f2223c;
        }
        String strF = u.f(viewInflate.getResources(), simpleDateFormatE);
        textInputLayout.setPlaceholderText(strF);
        textInputLayout2.setPlaceholderText(strF);
        editText.addTextChangedListener(new a(strF, simpleDateFormatE, textInputLayout, calendarConstraints, textInputLayout, textInputLayout2, qVar));
        editText2.addTextChangedListener(new b(strF, simpleDateFormatE, textInputLayout2, calendarConstraints, textInputLayout, textInputLayout2, qVar));
        editText.requestFocus();
        editText.post(new j(editText));
        return viewInflate;
    }
}

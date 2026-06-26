package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.util.Pair;
import c.b.a.m.f;
import c.e.a.b.l.c;
import c.e.a.b.l.q;
import c.e.a.b.l.u;
import c.e.a.b.q.j;
import com.google.android.material.R$attr;
import com.google.android.material.R$id;
import com.google.android.material.R$layout;
import com.google.android.material.R$string;
import com.google.android.material.textfield.TextInputLayout;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class SingleDateSelector implements DateSelector<Long> {
    public static final Parcelable.Creator<SingleDateSelector> CREATOR = new b();

    @Nullable
    public Long a;

    public class a extends c {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ q f2234g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, DateFormat dateFormat, TextInputLayout textInputLayout, CalendarConstraints calendarConstraints, q qVar) {
            super(str, dateFormat, textInputLayout, calendarConstraints);
            this.f2234g = qVar;
        }

        @Override // c.e.a.b.l.c
        public void a() {
            this.f2234g.a();
        }

        @Override // c.e.a.b.l.c
        public void b(@Nullable Long l2) {
            if (l2 == null) {
                SingleDateSelector.this.a = null;
            } else {
                SingleDateSelector.this.a = Long.valueOf(l2.longValue());
            }
            this.f2234g.b(SingleDateSelector.this.a);
        }
    }

    public static class b implements Parcelable.Creator<SingleDateSelector> {
        @Override // android.os.Parcelable.Creator
        @NonNull
        public SingleDateSelector createFromParcel(@NonNull Parcel parcel) {
            SingleDateSelector singleDateSelector = new SingleDateSelector();
            singleDateSelector.a = (Long) parcel.readValue(Long.class.getClassLoader());
            return singleDateSelector;
        }

        @Override // android.os.Parcelable.Creator
        @NonNull
        public SingleDateSelector[] newArray(int i2) {
            return new SingleDateSelector[i2];
        }
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public int C(Context context) {
        return f.N4(context, R$attr.materialCalendarTheme, MaterialDatePicker.class.getCanonicalName());
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public boolean E() {
        return this.a != null;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    @NonNull
    public Collection<Long> F() {
        ArrayList arrayList = new ArrayList();
        Long l2 = this.a;
        if (l2 != null) {
            arrayList.add(l2);
        }
        return arrayList;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    @Nullable
    public Long H() {
        return this.a;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public void L(long j2) {
        this.a = Long.valueOf(j2);
    }

    @Override // com.google.android.material.datepicker.DateSelector
    @NonNull
    public String a(@NonNull Context context) {
        Resources resources = context.getResources();
        Long l2 = this.a;
        if (l2 == null) {
            return resources.getString(R$string.mtrl_picker_date_header_unselected);
        }
        return resources.getString(R$string.mtrl_picker_date_header_selected, f.d3(l2.longValue(), Locale.getDefault()));
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    @NonNull
    public Collection<Pair<Long, Long>> t() {
        return new ArrayList();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i2) {
        parcel.writeValue(this.a);
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public View z(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle, CalendarConstraints calendarConstraints, @NonNull q<Long> qVar) {
        View viewInflate = layoutInflater.inflate(R$layout.mtrl_picker_text_input_date, viewGroup, false);
        TextInputLayout textInputLayout = (TextInputLayout) viewInflate.findViewById(R$id.mtrl_picker_text_input_date);
        EditText editText = textInputLayout.getEditText();
        if (f.v3()) {
            editText.setInputType(17);
        }
        SimpleDateFormat simpleDateFormatE = u.e();
        String strF = u.f(viewInflate.getResources(), simpleDateFormatE);
        textInputLayout.setPlaceholderText(strF);
        Long l2 = this.a;
        if (l2 != null) {
            editText.setText(simpleDateFormatE.format(l2));
        }
        editText.addTextChangedListener(new a(strF, simpleDateFormatE, textInputLayout, calendarConstraints, qVar));
        editText.requestFocus();
        editText.post(new j(editText));
        return viewInflate;
    }
}

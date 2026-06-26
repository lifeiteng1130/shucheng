package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.core.util.Preconditions;
import com.google.android.material.datepicker.CalendarConstraints;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class CompositeDateValidator implements CalendarConstraints.DateValidator {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final d f2181c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final List<CalendarConstraints.DateValidator> f2182d;
    public static final d a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final d f2180b = new b();
    public static final Parcelable.Creator<CompositeDateValidator> CREATOR = new c();

    public static class a implements d {
        @Override // com.google.android.material.datepicker.CompositeDateValidator.d
        public boolean a(@NonNull List<CalendarConstraints.DateValidator> list, long j2) {
            for (CalendarConstraints.DateValidator dateValidator : list) {
                if (dateValidator != null && dateValidator.c(j2)) {
                    return true;
                }
            }
            return false;
        }

        @Override // com.google.android.material.datepicker.CompositeDateValidator.d
        public int getId() {
            return 1;
        }
    }

    public static class b implements d {
        @Override // com.google.android.material.datepicker.CompositeDateValidator.d
        public boolean a(@NonNull List<CalendarConstraints.DateValidator> list, long j2) {
            for (CalendarConstraints.DateValidator dateValidator : list) {
                if (dateValidator != null && !dateValidator.c(j2)) {
                    return false;
                }
            }
            return true;
        }

        @Override // com.google.android.material.datepicker.CompositeDateValidator.d
        public int getId() {
            return 2;
        }
    }

    public static class c implements Parcelable.Creator<CompositeDateValidator> {
        @Override // android.os.Parcelable.Creator
        @NonNull
        public CompositeDateValidator createFromParcel(@NonNull Parcel parcel) {
            ArrayList arrayList = parcel.readArrayList(CalendarConstraints.DateValidator.class.getClassLoader());
            int i2 = parcel.readInt();
            d dVar = (i2 != 2 && i2 == 1) ? CompositeDateValidator.a : CompositeDateValidator.f2180b;
            return new CompositeDateValidator((List) Preconditions.checkNotNull(arrayList), dVar, null);
        }

        @Override // android.os.Parcelable.Creator
        @NonNull
        public CompositeDateValidator[] newArray(int i2) {
            return new CompositeDateValidator[i2];
        }
    }

    public interface d {
        boolean a(@NonNull List<CalendarConstraints.DateValidator> list, long j2);

        int getId();
    }

    public CompositeDateValidator(List list, d dVar, a aVar) {
        this.f2182d = list;
        this.f2181c = dVar;
    }

    @Override // com.google.android.material.datepicker.CalendarConstraints.DateValidator
    public boolean c(long j2) {
        return this.f2181c.a(this.f2182d, j2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CompositeDateValidator)) {
            return false;
        }
        CompositeDateValidator compositeDateValidator = (CompositeDateValidator) obj;
        return this.f2182d.equals(compositeDateValidator.f2182d) && this.f2181c.getId() == compositeDateValidator.f2181c.getId();
    }

    public int hashCode() {
        return this.f2182d.hashCode();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i2) {
        parcel.writeList(this.f2182d);
        parcel.writeInt(this.f2181c.getId());
    }
}

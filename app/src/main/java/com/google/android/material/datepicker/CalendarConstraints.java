package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.ObjectsCompat;
import c.e.a.b.l.u;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class CalendarConstraints implements Parcelable {
    public static final Parcelable.Creator<CalendarConstraints> CREATOR = new a();

    @NonNull
    public final Month a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final Month f2170b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final DateValidator f2171c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public Month f2172d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f2173e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f2174f;

    public interface DateValidator extends Parcelable {
        boolean c(long j2);
    }

    public static class a implements Parcelable.Creator<CalendarConstraints> {
        @Override // android.os.Parcelable.Creator
        @NonNull
        public CalendarConstraints createFromParcel(@NonNull Parcel parcel) {
            return new CalendarConstraints((Month) parcel.readParcelable(Month.class.getClassLoader()), (Month) parcel.readParcelable(Month.class.getClassLoader()), (DateValidator) parcel.readParcelable(DateValidator.class.getClassLoader()), (Month) parcel.readParcelable(Month.class.getClassLoader()), null);
        }

        @Override // android.os.Parcelable.Creator
        @NonNull
        public CalendarConstraints[] newArray(int i2) {
            return new CalendarConstraints[i2];
        }
    }

    public static final class b {
        public static final long a = u.a(Month.d(1900, 0).f2215f);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final long f2175b = u.a(Month.d(2100, 11).f2215f);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f2176c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f2177d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Long f2178e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public DateValidator f2179f;

        public b(@NonNull CalendarConstraints calendarConstraints) {
            this.f2176c = a;
            this.f2177d = f2175b;
            this.f2179f = new DateValidatorPointForward(Long.MIN_VALUE);
            this.f2176c = calendarConstraints.a.f2215f;
            this.f2177d = calendarConstraints.f2170b.f2215f;
            this.f2178e = Long.valueOf(calendarConstraints.f2172d.f2215f);
            this.f2179f = calendarConstraints.f2171c;
        }
    }

    public CalendarConstraints(Month month, Month month2, DateValidator dateValidator, Month month3, a aVar) {
        this.a = month;
        this.f2170b = month2;
        this.f2172d = month3;
        this.f2171c = dateValidator;
        if (month3 != null && month.a.compareTo(month3.a) > 0) {
            throw new IllegalArgumentException("start Month cannot be after current Month");
        }
        if (month3 != null && month3.a.compareTo(month2.a) > 0) {
            throw new IllegalArgumentException("current Month cannot be after end Month");
        }
        this.f2174f = month.j(month2) + 1;
        this.f2173e = (month2.f2212c - month.f2212c) + 1;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CalendarConstraints)) {
            return false;
        }
        CalendarConstraints calendarConstraints = (CalendarConstraints) obj;
        return this.a.equals(calendarConstraints.a) && this.f2170b.equals(calendarConstraints.f2170b) && ObjectsCompat.equals(this.f2172d, calendarConstraints.f2172d) && this.f2171c.equals(calendarConstraints.f2171c);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.a, this.f2170b, this.f2172d, this.f2171c});
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeParcelable(this.a, 0);
        parcel.writeParcelable(this.f2170b, 0);
        parcel.writeParcelable(this.f2172d, 0);
        parcel.writeParcelable(this.f2171c, 0);
    }
}

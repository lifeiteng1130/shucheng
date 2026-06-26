package com.google.android.material.datepicker;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.format.DateUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.e.a.b.l.u;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes.dex */
public final class Month implements Comparable<Month>, Parcelable {
    public static final Parcelable.Creator<Month> CREATOR = new a();

    @NonNull
    public final Calendar a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f2211b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f2212c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f2213d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f2214e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f2215f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    public String f2216g;

    public static class a implements Parcelable.Creator<Month> {
        @Override // android.os.Parcelable.Creator
        @NonNull
        public Month createFromParcel(@NonNull Parcel parcel) {
            return Month.d(parcel.readInt(), parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        @NonNull
        public Month[] newArray(int i2) {
            return new Month[i2];
        }
    }

    public Month(@NonNull Calendar calendar) {
        calendar.set(5, 1);
        Calendar calendarD = u.d(calendar);
        this.a = calendarD;
        this.f2211b = calendarD.get(2);
        this.f2212c = calendarD.get(1);
        this.f2213d = calendarD.getMaximum(7);
        this.f2214e = calendarD.getActualMaximum(5);
        this.f2215f = calendarD.getTimeInMillis();
    }

    @NonNull
    public static Month d(int i2, int i3) {
        Calendar calendarI = u.i();
        calendarI.set(1, i2);
        calendarI.set(2, i3);
        return new Month(calendarI);
    }

    @NonNull
    public static Month e(long j2) {
        Calendar calendarI = u.i();
        calendarI.setTimeInMillis(j2);
        return new Month(calendarI);
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public int compareTo(@NonNull Month month) {
        return this.a.compareTo(month.a);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Month)) {
            return false;
        }
        Month month = (Month) obj;
        return this.f2211b == month.f2211b && this.f2212c == month.f2212c;
    }

    public int f() {
        int firstDayOfWeek = this.a.get(7) - this.a.getFirstDayOfWeek();
        return firstDayOfWeek < 0 ? firstDayOfWeek + this.f2213d : firstDayOfWeek;
    }

    public long g(int i2) {
        Calendar calendarD = u.d(this.a);
        calendarD.set(5, i2);
        return calendarD.getTimeInMillis();
    }

    @NonNull
    public String h(Context context) {
        if (this.f2216g == null) {
            long timeInMillis = this.a.getTimeInMillis();
            this.f2216g = DateUtils.formatDateTime(context, timeInMillis - ((long) TimeZone.getDefault().getOffset(timeInMillis)), 36);
        }
        return this.f2216g;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f2211b), Integer.valueOf(this.f2212c)});
    }

    @NonNull
    public Month i(int i2) {
        Calendar calendarD = u.d(this.a);
        calendarD.add(2, i2);
        return new Month(calendarD);
    }

    public int j(@NonNull Month month) {
        if (!(this.a instanceof GregorianCalendar)) {
            throw new IllegalArgumentException("Only Gregorian calendars are supported.");
        }
        return (month.f2211b - this.f2211b) + ((month.f2212c - this.f2212c) * 12);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i2) {
        parcel.writeInt(this.f2212c);
        parcel.writeInt(this.f2211b);
    }
}

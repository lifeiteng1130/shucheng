package com.google.android.material.timepicker;

import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable;
import c.e.a.b.c0.d;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class TimeModel implements Parcelable {
    public static final Parcelable.Creator<TimeModel> CREATOR = new a();
    public final d a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f2495b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f2496c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f2497d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f2498e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f2499f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f2500g;

    public static class a implements Parcelable.Creator<TimeModel> {
        @Override // android.os.Parcelable.Creator
        public TimeModel createFromParcel(Parcel parcel) {
            return new TimeModel(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        public TimeModel[] newArray(int i2) {
            return new TimeModel[i2];
        }
    }

    public TimeModel() {
        this(0, 0, 10, 0);
    }

    public static String b(Resources resources, CharSequence charSequence, String str) {
        return String.format(resources.getConfiguration().locale, str, Integer.valueOf(Integer.parseInt(String.valueOf(charSequence))));
    }

    public int d() {
        if (this.f2496c == 1) {
            return this.f2497d % 24;
        }
        int i2 = this.f2497d;
        if (i2 % 12 == 0) {
            return 12;
        }
        return this.f2500g == 1 ? i2 - 12 : i2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void e(int i2) {
        if (this.f2496c == 1) {
            this.f2497d = i2;
        } else {
            this.f2497d = (i2 % 12) + (this.f2500g != 1 ? 0 : 12);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TimeModel)) {
            return false;
        }
        TimeModel timeModel = (TimeModel) obj;
        return this.f2497d == timeModel.f2497d && this.f2498e == timeModel.f2498e && this.f2496c == timeModel.f2496c && this.f2499f == timeModel.f2499f;
    }

    public void f(int i2) {
        if (i2 != this.f2500g) {
            this.f2500g = i2;
            int i3 = this.f2497d;
            if (i3 < 12 && i2 == 1) {
                this.f2497d = i3 + 12;
            } else {
                if (i3 < 12 || i2 != 0) {
                    return;
                }
                this.f2497d = i3 - 12;
            }
        }
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f2496c), Integer.valueOf(this.f2497d), Integer.valueOf(this.f2498e), Integer.valueOf(this.f2499f)});
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f2497d);
        parcel.writeInt(this.f2498e);
        parcel.writeInt(this.f2499f);
        parcel.writeInt(this.f2496c);
    }

    public TimeModel(int i2, int i3, int i4, int i5) {
        this.f2497d = i2;
        this.f2498e = i3;
        this.f2499f = i4;
        this.f2496c = i5;
        this.f2500g = i2 >= 12 ? 1 : 0;
        this.a = new d(59);
        this.f2495b = new d(i5 == 1 ? 24 : 12);
    }
}

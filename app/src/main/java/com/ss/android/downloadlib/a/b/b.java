package com.ss.android.downloadlib.a.b;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: AidlMsg.java */
/* JADX INFO: loaded from: classes.dex */
public class b implements Parcelable {
    public static final Parcelable.Creator<b> CREATOR = new Parcelable.Creator<b>() { // from class: com.ss.android.downloadlib.a.b.b.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public b createFromParcel(Parcel parcel) {
            return new b(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public b[] newArray(int i2) {
            return new b[i2];
        }
    };
    public int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f2984b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f2985c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f2986d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f2987e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f2988f;

    public b() {
        this.f2985c = "";
        this.f2987e = "";
        this.f2988f = "";
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            b bVar = (b) obj;
            if (this.a == bVar.a && this.f2984b == bVar.f2984b) {
                String str = this.f2985c;
                if (str != null) {
                    return str.equals(bVar.f2985c);
                }
                if (bVar.f2985c == null) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        int i2 = ((this.a * 31) + this.f2984b) * 31;
        String str = this.f2985c;
        return i2 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.a);
        parcel.writeInt(this.f2984b);
        parcel.writeString(this.f2985c);
        parcel.writeString(this.f2987e);
        parcel.writeString(this.f2988f);
        parcel.writeInt(this.f2986d);
    }

    public b(Parcel parcel) {
        this.f2985c = "";
        this.f2987e = "";
        this.f2988f = "";
        this.a = parcel.readInt();
        this.f2984b = parcel.readInt();
        this.f2985c = parcel.readString();
        this.f2987e = parcel.readString();
        this.f2988f = parcel.readString();
        this.f2986d = parcel.readInt();
    }
}

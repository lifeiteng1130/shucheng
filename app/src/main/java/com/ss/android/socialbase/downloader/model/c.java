package com.ss.android.socialbase.downloader.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import org.slf4j.helpers.MessageFormatter;

/* JADX INFO: compiled from: HttpHeader.java */
/* JADX INFO: loaded from: classes.dex */
public class c implements Parcelable, Comparable {
    public static final Parcelable.Creator<c> CREATOR = new Parcelable.Creator<c>() { // from class: com.ss.android.socialbase.downloader.model.c.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public c createFromParcel(Parcel parcel) {
            return new c(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public c[] newArray(int i2) {
            return new c[i2];
        }
    };
    private final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f3856b;

    public c(String str, String str2) {
        this.a = str;
        this.f3856b = str2;
    }

    public String a() {
        return this.a;
    }

    public String b() {
        return this.f3856b;
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        if (!(obj instanceof c)) {
            return 1;
        }
        c cVar = (c) obj;
        if (TextUtils.equals(this.a, cVar.a())) {
            return 0;
        }
        String str = this.a;
        if (str == null) {
            return -1;
        }
        int iCompareTo = str.compareTo(cVar.a());
        if (iCompareTo > 0) {
            return 1;
        }
        return iCompareTo < 0 ? -1 : 0;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        c cVar = (c) obj;
        return TextUtils.equals(this.a, cVar.a) && TextUtils.equals(this.f3856b, cVar.f3856b);
    }

    public int hashCode() {
        String str = this.a;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.f3856b;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbR = c.a.a.a.a.r("HttpHeader{name='");
        c.a.a.a.a.y(sbR, this.a, '\'', ", value='");
        sbR.append(this.f3856b);
        sbR.append('\'');
        sbR.append(MessageFormatter.DELIM_STOP);
        return sbR.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.a);
        parcel.writeString(this.f3856b);
    }

    public c(Parcel parcel) {
        this.a = parcel.readString();
        this.f3856b = parcel.readString();
    }
}

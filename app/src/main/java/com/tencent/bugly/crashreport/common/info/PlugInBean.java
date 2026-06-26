package com.tencent.bugly.crashreport.common.info;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes.dex */
public class PlugInBean implements Parcelable {
    public static final Parcelable.Creator<PlugInBean> CREATOR = new c();
    public final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f4091b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f4092c;

    public PlugInBean(String str, String str2, String str3) {
        this.a = str;
        this.f4091b = str2;
        this.f4092c = str3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuilder sbR = c.a.a.a.a.r("plid:");
        sbR.append(this.a);
        sbR.append(" plV:");
        sbR.append(this.f4091b);
        sbR.append(" plUUID:");
        sbR.append(this.f4092c);
        return sbR.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.a);
        parcel.writeString(this.f4091b);
        parcel.writeString(this.f4092c);
    }

    public PlugInBean(Parcel parcel) {
        this.a = parcel.readString();
        this.f4091b = parcel.readString();
        this.f4092c = parcel.readString();
    }
}

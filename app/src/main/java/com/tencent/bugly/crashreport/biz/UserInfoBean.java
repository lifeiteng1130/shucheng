package com.tencent.bugly.crashreport.biz;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.os.EnvironmentCompat;
import com.tencent.bugly.proguard.ca;
import java.util.Map;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes.dex */
public class UserInfoBean implements Parcelable {
    public static final Parcelable.Creator<UserInfoBean> CREATOR = new g();
    public long a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f4059b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f4060c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f4061d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f4062e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f4063f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f4064g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f4065h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f4066i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f4067j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f4068k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f4069l;
    public String m;
    public String n;
    public int o;
    public int p;
    public int q;
    public Map<String, String> r;
    public Map<String, String> s;

    public UserInfoBean() {
        this.f4068k = 0L;
        this.f4069l = false;
        this.m = EnvironmentCompat.MEDIA_UNKNOWN;
        this.p = -1;
        this.q = -1;
        this.r = null;
        this.s = null;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f4059b);
        parcel.writeString(this.f4060c);
        parcel.writeString(this.f4061d);
        parcel.writeLong(this.f4062e);
        parcel.writeLong(this.f4063f);
        parcel.writeLong(this.f4064g);
        parcel.writeLong(this.f4065h);
        parcel.writeLong(this.f4066i);
        parcel.writeString(this.f4067j);
        parcel.writeLong(this.f4068k);
        parcel.writeByte(this.f4069l ? (byte) 1 : (byte) 0);
        parcel.writeString(this.m);
        parcel.writeInt(this.p);
        parcel.writeInt(this.q);
        ca.b(parcel, this.r);
        ca.b(parcel, this.s);
        parcel.writeString(this.n);
        parcel.writeInt(this.o);
    }

    public UserInfoBean(Parcel parcel) {
        this.f4068k = 0L;
        this.f4069l = false;
        this.m = EnvironmentCompat.MEDIA_UNKNOWN;
        this.p = -1;
        this.q = -1;
        this.r = null;
        this.s = null;
        this.f4059b = parcel.readInt();
        this.f4060c = parcel.readString();
        this.f4061d = parcel.readString();
        this.f4062e = parcel.readLong();
        this.f4063f = parcel.readLong();
        this.f4064g = parcel.readLong();
        this.f4065h = parcel.readLong();
        this.f4066i = parcel.readLong();
        this.f4067j = parcel.readString();
        this.f4068k = parcel.readLong();
        this.f4069l = parcel.readByte() == 1;
        this.m = parcel.readString();
        this.p = parcel.readInt();
        this.q = parcel.readInt();
        this.r = ca.b(parcel);
        this.s = ca.b(parcel);
        this.n = parcel.readString();
        this.o = parcel.readInt();
    }
}

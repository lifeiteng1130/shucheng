package com.tencent.bugly.crashreport.common.strategy;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.bugly.proguard.ca;
import java.util.Map;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes.dex */
public class StrategyBean implements Parcelable {
    public static final Parcelable.Creator<StrategyBean> CREATOR = new a();
    public static String a = "https://android.bugly.qq.com/rqd/async";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f4108b = "https://android.bugly.qq.com/rqd/async";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f4109c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f4110d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f4111e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f4112f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f4113g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f4114h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f4115i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f4116j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f4117k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f4118l;
    public boolean m;
    public boolean n;
    public long o;
    public long p;
    public String q;
    public String r;
    public String s;
    public Map<String, String> t;
    public int u;
    public long v;
    public long w;

    public StrategyBean() {
        this.f4110d = -1L;
        this.f4111e = -1L;
        this.f4112f = true;
        this.f4113g = true;
        this.f4114h = true;
        this.f4115i = true;
        this.f4116j = false;
        this.f4117k = true;
        this.f4118l = true;
        this.m = true;
        this.n = true;
        this.p = 30000L;
        this.q = a;
        this.r = f4108b;
        this.u = 10;
        this.v = 300000L;
        this.w = -1L;
        this.f4111e = System.currentTimeMillis();
        StringBuilder sbU = c.a.a.a.a.u("S(", "@L@L", "@)");
        f4109c = sbU.toString();
        sbU.setLength(0);
        sbU.append("*^");
        sbU.append("@K#K");
        sbU.append("@!");
        this.s = sbU.toString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeLong(this.f4111e);
        parcel.writeByte(this.f4112f ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f4113g ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f4114h ? (byte) 1 : (byte) 0);
        parcel.writeString(this.q);
        parcel.writeString(this.r);
        parcel.writeString(this.s);
        ca.b(parcel, this.t);
        parcel.writeByte(this.f4115i ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f4116j ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.m ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.n ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.p);
        parcel.writeByte(this.f4117k ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f4118l ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.o);
        parcel.writeInt(this.u);
        parcel.writeLong(this.v);
        parcel.writeLong(this.w);
    }

    public StrategyBean(Parcel parcel) {
        this.f4110d = -1L;
        this.f4111e = -1L;
        boolean z = true;
        this.f4112f = true;
        this.f4113g = true;
        this.f4114h = true;
        this.f4115i = true;
        this.f4116j = false;
        this.f4117k = true;
        this.f4118l = true;
        this.m = true;
        this.n = true;
        this.p = 30000L;
        this.q = a;
        this.r = f4108b;
        this.u = 10;
        this.v = 300000L;
        this.w = -1L;
        try {
            f4109c = "S(@L@L@)";
            this.f4111e = parcel.readLong();
            this.f4112f = parcel.readByte() == 1;
            this.f4113g = parcel.readByte() == 1;
            this.f4114h = parcel.readByte() == 1;
            this.q = parcel.readString();
            this.r = parcel.readString();
            this.s = parcel.readString();
            this.t = ca.b(parcel);
            this.f4115i = parcel.readByte() == 1;
            this.f4116j = parcel.readByte() == 1;
            this.m = parcel.readByte() == 1;
            this.n = parcel.readByte() == 1;
            this.p = parcel.readLong();
            this.f4117k = parcel.readByte() == 1;
            if (parcel.readByte() != 1) {
                z = false;
            }
            this.f4118l = z;
            this.o = parcel.readLong();
            this.u = parcel.readInt();
            this.v = parcel.readLong();
            this.w = parcel.readLong();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}

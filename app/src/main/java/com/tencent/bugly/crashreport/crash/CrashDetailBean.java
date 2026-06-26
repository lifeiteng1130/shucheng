package com.tencent.bugly.crashreport.crash;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.bugly.crashreport.common.info.PlugInBean;
import com.tencent.bugly.proguard.ca;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes.dex */
public class CrashDetailBean implements Parcelable, Comparable<CrashDetailBean> {
    public static final Parcelable.Creator<CrashDetailBean> CREATOR = new c();
    public String A;
    public String B;
    public long C;
    public long D;
    public long E;
    public long F;
    public long G;
    public long H;
    public String I;
    public String J;
    public String K;
    public String L;
    public String M;
    public long N;
    public boolean O;
    public Map<String, String> P;
    public Map<String, String> Q;
    public int R;
    public int S;
    public Map<String, String> T;
    public Map<String, String> U;
    public byte[] V;
    public String W;
    public String X;
    public long a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f4130b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f4131c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f4132d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f4133e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f4134f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f4135g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Map<String, PlugInBean> f4136h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Map<String, PlugInBean> f4137i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f4138j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f4139k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f4140l;
    public String m;
    public String n;
    public String o;
    public String p;
    public String q;
    public long r;
    public String s;
    public int t;
    public String u;
    public String v;
    public String w;
    public String x;
    public byte[] y;
    public Map<String, String> z;

    public CrashDetailBean() {
        this.a = -1L;
        this.f4130b = 0;
        this.f4131c = UUID.randomUUID().toString();
        this.f4132d = false;
        this.f4133e = "";
        this.f4134f = "";
        this.f4135g = "";
        this.f4136h = null;
        this.f4137i = null;
        this.f4138j = false;
        this.f4139k = false;
        this.f4140l = 0;
        this.m = "";
        this.n = "";
        this.o = "";
        this.p = "";
        this.q = "";
        this.r = -1L;
        this.s = null;
        this.t = 0;
        this.u = "";
        this.v = "";
        this.w = null;
        this.x = null;
        this.y = null;
        this.z = null;
        this.A = "";
        this.B = "";
        this.C = -1L;
        this.D = -1L;
        this.E = -1L;
        this.F = -1L;
        this.G = -1L;
        this.H = -1L;
        this.I = "";
        this.J = "";
        this.K = "";
        this.L = "";
        this.M = "";
        this.N = -1L;
        this.O = false;
        this.P = null;
        this.Q = null;
        this.R = -1;
        this.S = -1;
        this.T = null;
        this.U = null;
        this.V = null;
        this.W = null;
        this.X = null;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(CrashDetailBean crashDetailBean) {
        if (crashDetailBean == null) {
            return 1;
        }
        long j2 = this.r - crashDetailBean.r;
        if (j2 > 0) {
            return 1;
        }
        return j2 < 0 ? -1 : 0;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f4130b);
        parcel.writeString(this.f4131c);
        parcel.writeByte(this.f4132d ? (byte) 1 : (byte) 0);
        parcel.writeString(this.f4133e);
        parcel.writeString(this.f4134f);
        parcel.writeString(this.f4135g);
        parcel.writeByte(this.f4138j ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f4139k ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.f4140l);
        parcel.writeString(this.m);
        parcel.writeString(this.n);
        parcel.writeString(this.o);
        parcel.writeString(this.p);
        parcel.writeString(this.q);
        parcel.writeLong(this.r);
        parcel.writeString(this.s);
        parcel.writeInt(this.t);
        parcel.writeString(this.u);
        parcel.writeString(this.v);
        parcel.writeString(this.w);
        ca.b(parcel, this.z);
        parcel.writeString(this.A);
        parcel.writeString(this.B);
        parcel.writeLong(this.C);
        parcel.writeLong(this.D);
        parcel.writeLong(this.E);
        parcel.writeLong(this.F);
        parcel.writeLong(this.G);
        parcel.writeLong(this.H);
        parcel.writeString(this.I);
        parcel.writeString(this.J);
        parcel.writeString(this.K);
        parcel.writeString(this.L);
        parcel.writeString(this.M);
        parcel.writeLong(this.N);
        parcel.writeByte(this.O ? (byte) 1 : (byte) 0);
        ca.b(parcel, this.P);
        ca.a(parcel, this.f4136h);
        ca.a(parcel, this.f4137i);
        parcel.writeInt(this.R);
        parcel.writeInt(this.S);
        ca.b(parcel, this.T);
        ca.b(parcel, this.U);
        parcel.writeByteArray(this.V);
        parcel.writeByteArray(this.y);
        parcel.writeString(this.W);
        parcel.writeString(this.X);
        parcel.writeString(this.x);
    }

    public CrashDetailBean(Parcel parcel) {
        this.a = -1L;
        this.f4130b = 0;
        this.f4131c = UUID.randomUUID().toString();
        this.f4132d = false;
        this.f4133e = "";
        this.f4134f = "";
        this.f4135g = "";
        this.f4136h = null;
        this.f4137i = null;
        this.f4138j = false;
        this.f4139k = false;
        this.f4140l = 0;
        this.m = "";
        this.n = "";
        this.o = "";
        this.p = "";
        this.q = "";
        this.r = -1L;
        this.s = null;
        this.t = 0;
        this.u = "";
        this.v = "";
        this.w = null;
        this.x = null;
        this.y = null;
        this.z = null;
        this.A = "";
        this.B = "";
        this.C = -1L;
        this.D = -1L;
        this.E = -1L;
        this.F = -1L;
        this.G = -1L;
        this.H = -1L;
        this.I = "";
        this.J = "";
        this.K = "";
        this.L = "";
        this.M = "";
        this.N = -1L;
        this.O = false;
        this.P = null;
        this.Q = null;
        this.R = -1;
        this.S = -1;
        this.T = null;
        this.U = null;
        this.V = null;
        this.W = null;
        this.X = null;
        this.f4130b = parcel.readInt();
        this.f4131c = parcel.readString();
        this.f4132d = parcel.readByte() == 1;
        this.f4133e = parcel.readString();
        this.f4134f = parcel.readString();
        this.f4135g = parcel.readString();
        this.f4138j = parcel.readByte() == 1;
        this.f4139k = parcel.readByte() == 1;
        this.f4140l = parcel.readInt();
        this.m = parcel.readString();
        this.n = parcel.readString();
        this.o = parcel.readString();
        this.p = parcel.readString();
        this.q = parcel.readString();
        this.r = parcel.readLong();
        this.s = parcel.readString();
        this.t = parcel.readInt();
        this.u = parcel.readString();
        this.v = parcel.readString();
        this.w = parcel.readString();
        this.z = ca.b(parcel);
        this.A = parcel.readString();
        this.B = parcel.readString();
        this.C = parcel.readLong();
        this.D = parcel.readLong();
        this.E = parcel.readLong();
        this.F = parcel.readLong();
        this.G = parcel.readLong();
        this.H = parcel.readLong();
        this.I = parcel.readString();
        this.J = parcel.readString();
        this.K = parcel.readString();
        this.L = parcel.readString();
        this.M = parcel.readString();
        this.N = parcel.readLong();
        this.O = parcel.readByte() == 1;
        this.P = ca.b(parcel);
        this.f4136h = ca.a(parcel);
        this.f4137i = ca.a(parcel);
        this.R = parcel.readInt();
        this.S = parcel.readInt();
        this.T = ca.b(parcel);
        this.U = ca.b(parcel);
        this.V = parcel.createByteArray();
        this.y = parcel.createByteArray();
        this.W = parcel.readString();
        this.X = parcel.readString();
        this.x = parcel.readString();
    }
}

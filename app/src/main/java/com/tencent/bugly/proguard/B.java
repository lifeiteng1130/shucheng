package com.tencent.bugly.proguard;

import androidx.core.app.NotificationCompat;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes.dex */
public final class B extends AbstractC0320m implements Cloneable {
    public static C0331y a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static C0330x f4244b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static C0330x f4245c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Map<String, String> f4246d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ boolean f4247e = true;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f4248f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f4249g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f4250h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f4251i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public C0331y f4252j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public C0330x f4253k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public byte f4254l;
    public int m;
    public long n;
    public C0330x o;
    public String p;
    public Map<String, String> q;
    public String r;
    public int s;
    public long t;
    public int u;

    public B() {
        this.f4248f = "";
        this.f4249g = "";
        this.f4250h = 0L;
        this.f4251i = 0;
        this.f4252j = null;
        this.f4253k = null;
        this.f4254l = (byte) 0;
        this.m = 0;
        this.n = 0L;
        this.o = null;
        this.p = "";
        this.q = null;
        this.r = "";
        this.s = 0;
        this.t = 0L;
        this.u = 0;
    }

    public C0330x a() {
        return this.f4253k;
    }

    public long b() {
        return this.f4250h;
    }

    public Map<String, String> c() {
        return this.q;
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            if (f4247e) {
                return null;
            }
            throw new AssertionError();
        }
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        B b2 = (B) obj;
        return C0321n.a(this.f4248f, b2.f4248f) && C0321n.a(this.f4249g, b2.f4249g) && C0321n.a(this.f4250h, b2.f4250h) && C0321n.a(this.f4251i, b2.f4251i) && C0321n.a(this.f4252j, b2.f4252j) && C0321n.a(this.f4253k, b2.f4253k) && C0321n.a(this.f4254l, b2.f4254l) && C0321n.a(this.m, b2.m) && C0321n.a(this.n, b2.n) && C0321n.a(this.o, b2.o) && C0321n.a(this.p, b2.p) && C0321n.a(this.q, b2.q) && C0321n.a(this.r, b2.r) && C0321n.a(this.s, b2.s) && C0321n.a(this.t, b2.t) && C0321n.a(this.u, b2.u);
    }

    public int hashCode() {
        try {
            throw new Exception("Need define key first!");
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    @Override // com.tencent.bugly.proguard.AbstractC0320m
    public void a(C0319l c0319l) {
        c0319l.a(this.f4248f, 0);
        c0319l.a(this.f4249g, 1);
        c0319l.a(this.f4250h, 2);
        c0319l.a(this.f4251i, 3);
        c0319l.a((AbstractC0320m) this.f4252j, 4);
        c0319l.a((AbstractC0320m) this.f4253k, 5);
        c0319l.a(this.f4254l, 6);
        c0319l.a(this.m, 7);
        c0319l.a(this.n, 8);
        C0330x c0330x = this.o;
        if (c0330x != null) {
            c0319l.a((AbstractC0320m) c0330x, 9);
        }
        String str = this.p;
        if (str != null) {
            c0319l.a(str, 10);
        }
        Map<String, String> map = this.q;
        if (map != null) {
            c0319l.a((Map) map, 11);
        }
        String str2 = this.r;
        if (str2 != null) {
            c0319l.a(str2, 12);
        }
        c0319l.a(this.s, 13);
        c0319l.a(this.t, 14);
        c0319l.a(this.u, 15);
    }

    public B(String str, String str2, long j2, int i2, C0331y c0331y, C0330x c0330x, byte b2, int i3, long j3, C0330x c0330x2, String str3, Map<String, String> map, String str4, int i4, long j4, int i5) {
        this.f4248f = "";
        this.f4249g = "";
        this.f4250h = 0L;
        this.f4251i = 0;
        this.f4252j = null;
        this.f4253k = null;
        this.f4254l = (byte) 0;
        this.m = 0;
        this.n = 0L;
        this.o = null;
        this.p = "";
        this.q = null;
        this.r = "";
        this.s = 0;
        this.t = 0L;
        this.u = 0;
        this.f4248f = str;
        this.f4249g = str2;
        this.f4250h = j2;
        this.f4251i = i2;
        this.f4252j = c0331y;
        this.f4253k = c0330x;
        this.f4254l = b2;
        this.m = i3;
        this.n = j3;
        this.o = c0330x2;
        this.p = str3;
        this.q = map;
        this.r = str4;
        this.s = i4;
        this.t = j4;
        this.u = i5;
    }

    @Override // com.tencent.bugly.proguard.AbstractC0320m
    public void a(C0318k c0318k) {
        this.f4248f = c0318k.a(0, true);
        this.f4249g = c0318k.a(1, true);
        this.f4250h = c0318k.a(this.f4250h, 2, true);
        this.f4251i = c0318k.a(this.f4251i, 3, true);
        if (a == null) {
            a = new C0331y();
        }
        this.f4252j = (C0331y) c0318k.a((AbstractC0320m) a, 4, true);
        if (f4244b == null) {
            f4244b = new C0330x();
        }
        this.f4253k = (C0330x) c0318k.a((AbstractC0320m) f4244b, 5, true);
        this.f4254l = c0318k.a(this.f4254l, 6, true);
        this.m = c0318k.a(this.m, 7, false);
        this.n = c0318k.a(this.n, 8, false);
        if (f4245c == null) {
            f4245c = new C0330x();
        }
        this.o = (C0330x) c0318k.a((AbstractC0320m) f4245c, 9, false);
        this.p = c0318k.a(10, false);
        if (f4246d == null) {
            HashMap map = new HashMap();
            f4246d = map;
            map.put("", "");
        }
        this.q = (Map) c0318k.a(f4246d, 11, false);
        this.r = c0318k.a(12, false);
        this.s = c0318k.a(this.s, 13, false);
        this.t = c0318k.a(this.t, 14, false);
        this.u = c0318k.a(this.u, 15, false);
    }

    @Override // com.tencent.bugly.proguard.AbstractC0320m
    public void a(StringBuilder sb, int i2) {
        C0316i c0316i = new C0316i(sb, i2);
        c0316i.a(this.f4248f, "title");
        c0316i.a(this.f4249g, "newFeature");
        c0316i.a(this.f4250h, "publishTime");
        c0316i.a(this.f4251i, "publishType");
        c0316i.a((AbstractC0320m) this.f4252j, "appBasicInfo");
        c0316i.a((AbstractC0320m) this.f4253k, "apkBaseInfo");
        c0316i.a(this.f4254l, "updateStrategy");
        c0316i.a(this.m, "popTimes");
        c0316i.a(this.n, "popInterval");
        c0316i.a((AbstractC0320m) this.o, "diffApkInfo");
        c0316i.a(this.p, "netType");
        c0316i.a((Map) this.q, "reserved");
        c0316i.a(this.r, "strategyId");
        c0316i.a(this.s, NotificationCompat.CATEGORY_STATUS);
        c0316i.a(this.t, "updateTime");
        c0316i.a(this.u, "updateType");
    }
}

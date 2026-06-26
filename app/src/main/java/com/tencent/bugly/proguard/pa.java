package com.tencent.bugly.proguard;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes.dex */
public final class pa extends AbstractC0320m {
    public static byte[] a = {0};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Map<String, String> f4408b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f4409c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f4410d = "";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f4411e = "";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f4412f = "";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f4413g = "";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f4414h = "";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f4415i = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public byte[] f4416j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f4417k = "";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f4418l = "";
    public Map<String, String> m = null;
    public String n = "";
    public long o = 0;
    public String p = "";
    public String q = "";
    public String r = "";
    public long s = 0;
    public String t = "";
    public String u = "";
    public String v = "";
    public String w = "";
    public String x = "";
    public String y = "";
    public String z = "";

    static {
        HashMap map = new HashMap();
        f4408b = map;
        map.put("", "");
    }

    @Override // com.tencent.bugly.proguard.AbstractC0320m
    public void a(C0319l c0319l) {
        c0319l.a(this.f4409c, 0);
        c0319l.a(this.f4410d, 1);
        c0319l.a(this.f4411e, 2);
        c0319l.a(this.f4412f, 3);
        String str = this.f4413g;
        if (str != null) {
            c0319l.a(str, 4);
        }
        c0319l.a(this.f4414h, 5);
        c0319l.a(this.f4415i, 6);
        c0319l.a(this.f4416j, 7);
        String str2 = this.f4417k;
        if (str2 != null) {
            c0319l.a(str2, 8);
        }
        String str3 = this.f4418l;
        if (str3 != null) {
            c0319l.a(str3, 9);
        }
        Map<String, String> map = this.m;
        if (map != null) {
            c0319l.a((Map) map, 10);
        }
        String str4 = this.n;
        if (str4 != null) {
            c0319l.a(str4, 11);
        }
        c0319l.a(this.o, 12);
        String str5 = this.p;
        if (str5 != null) {
            c0319l.a(str5, 13);
        }
        String str6 = this.q;
        if (str6 != null) {
            c0319l.a(str6, 14);
        }
        String str7 = this.r;
        if (str7 != null) {
            c0319l.a(str7, 15);
        }
        c0319l.a(this.s, 16);
        String str8 = this.t;
        if (str8 != null) {
            c0319l.a(str8, 17);
        }
        String str9 = this.u;
        if (str9 != null) {
            c0319l.a(str9, 18);
        }
        String str10 = this.v;
        if (str10 != null) {
            c0319l.a(str10, 19);
        }
        String str11 = this.w;
        if (str11 != null) {
            c0319l.a(str11, 20);
        }
        String str12 = this.x;
        if (str12 != null) {
            c0319l.a(str12, 21);
        }
        String str13 = this.y;
        if (str13 != null) {
            c0319l.a(str13, 22);
        }
        String str14 = this.z;
        if (str14 != null) {
            c0319l.a(str14, 23);
        }
    }

    @Override // com.tencent.bugly.proguard.AbstractC0320m
    public void a(C0318k c0318k) {
        this.f4409c = c0318k.a(this.f4409c, 0, true);
        this.f4410d = c0318k.a(1, true);
        this.f4411e = c0318k.a(2, true);
        this.f4412f = c0318k.a(3, true);
        this.f4413g = c0318k.a(4, false);
        this.f4414h = c0318k.a(5, true);
        this.f4415i = c0318k.a(this.f4415i, 6, true);
        this.f4416j = c0318k.a(a, 7, true);
        this.f4417k = c0318k.a(8, false);
        this.f4418l = c0318k.a(9, false);
        this.m = (Map) c0318k.a(f4408b, 10, false);
        this.n = c0318k.a(11, false);
        this.o = c0318k.a(this.o, 12, false);
        this.p = c0318k.a(13, false);
        this.q = c0318k.a(14, false);
        this.r = c0318k.a(15, false);
        this.s = c0318k.a(this.s, 16, false);
        this.t = c0318k.a(17, false);
        this.u = c0318k.a(18, false);
        this.v = c0318k.a(19, false);
        this.w = c0318k.a(20, false);
        this.x = c0318k.a(21, false);
        this.y = c0318k.a(22, false);
        this.z = c0318k.a(23, false);
    }
}

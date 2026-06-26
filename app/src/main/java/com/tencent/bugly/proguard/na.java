package com.tencent.bugly.proguard;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes.dex */
public final class na extends AbstractC0320m {
    public static Map<String, String> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static la f4396b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static ka f4397c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static ArrayList<ka> f4398d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static ArrayList<ka> f4399e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static ArrayList<ma> f4400f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static Map<String, String> f4401g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static Map<String, String> f4402h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f4403i = "";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f4404j = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f4405k = "";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f4406l = "";
    public String m = "";
    public String n = "";
    public String o = "";
    public Map<String, String> p = null;
    public String q = "";
    public la r = null;
    public int s = 0;
    public String t = "";
    public String u = "";
    public ka v = null;
    public ArrayList<ka> w = null;
    public ArrayList<ka> x = null;
    public ArrayList<ma> y = null;
    public Map<String, String> z = null;
    public Map<String, String> A = null;
    public String B = "";
    public boolean C = true;

    static {
        HashMap map = new HashMap();
        a = map;
        map.put("", "");
        f4396b = new la();
        f4397c = new ka();
        f4398d = new ArrayList<>();
        f4398d.add(new ka());
        f4399e = new ArrayList<>();
        f4399e.add(new ka());
        f4400f = new ArrayList<>();
        f4400f.add(new ma());
        HashMap map2 = new HashMap();
        f4401g = map2;
        map2.put("", "");
        HashMap map3 = new HashMap();
        f4402h = map3;
        map3.put("", "");
    }

    @Override // com.tencent.bugly.proguard.AbstractC0320m
    public void a(C0319l c0319l) {
        c0319l.a(this.f4403i, 0);
        c0319l.a(this.f4404j, 1);
        c0319l.a(this.f4405k, 2);
        String str = this.f4406l;
        if (str != null) {
            c0319l.a(str, 3);
        }
        String str2 = this.m;
        if (str2 != null) {
            c0319l.a(str2, 4);
        }
        String str3 = this.n;
        if (str3 != null) {
            c0319l.a(str3, 5);
        }
        String str4 = this.o;
        if (str4 != null) {
            c0319l.a(str4, 6);
        }
        Map<String, String> map = this.p;
        if (map != null) {
            c0319l.a((Map) map, 7);
        }
        String str5 = this.q;
        if (str5 != null) {
            c0319l.a(str5, 8);
        }
        la laVar = this.r;
        if (laVar != null) {
            c0319l.a((AbstractC0320m) laVar, 9);
        }
        c0319l.a(this.s, 10);
        String str6 = this.t;
        if (str6 != null) {
            c0319l.a(str6, 11);
        }
        String str7 = this.u;
        if (str7 != null) {
            c0319l.a(str7, 12);
        }
        ka kaVar = this.v;
        if (kaVar != null) {
            c0319l.a((AbstractC0320m) kaVar, 13);
        }
        ArrayList<ka> arrayList = this.w;
        if (arrayList != null) {
            c0319l.a((Collection) arrayList, 14);
        }
        ArrayList<ka> arrayList2 = this.x;
        if (arrayList2 != null) {
            c0319l.a((Collection) arrayList2, 15);
        }
        ArrayList<ma> arrayList3 = this.y;
        if (arrayList3 != null) {
            c0319l.a((Collection) arrayList3, 16);
        }
        Map<String, String> map2 = this.z;
        if (map2 != null) {
            c0319l.a((Map) map2, 17);
        }
        Map<String, String> map3 = this.A;
        if (map3 != null) {
            c0319l.a((Map) map3, 18);
        }
        String str8 = this.B;
        if (str8 != null) {
            c0319l.a(str8, 19);
        }
        c0319l.a(this.C, 20);
    }

    @Override // com.tencent.bugly.proguard.AbstractC0320m
    public void a(C0318k c0318k) {
        this.f4403i = c0318k.a(0, true);
        this.f4404j = c0318k.a(this.f4404j, 1, true);
        this.f4405k = c0318k.a(2, true);
        this.f4406l = c0318k.a(3, false);
        this.m = c0318k.a(4, false);
        this.n = c0318k.a(5, false);
        this.o = c0318k.a(6, false);
        this.p = (Map) c0318k.a(a, 7, false);
        this.q = c0318k.a(8, false);
        this.r = (la) c0318k.a((AbstractC0320m) f4396b, 9, false);
        this.s = c0318k.a(this.s, 10, false);
        this.t = c0318k.a(11, false);
        this.u = c0318k.a(12, false);
        this.v = (ka) c0318k.a((AbstractC0320m) f4397c, 13, false);
        this.w = (ArrayList) c0318k.a(f4398d, 14, false);
        this.x = (ArrayList) c0318k.a(f4399e, 15, false);
        this.y = (ArrayList) c0318k.a(f4400f, 16, false);
        this.z = (Map) c0318k.a(f4401g, 17, false);
        this.A = (Map) c0318k.a(f4402h, 18, false);
        this.B = c0318k.a(19, false);
        this.C = c0318k.a(this.C, 20, false);
    }
}

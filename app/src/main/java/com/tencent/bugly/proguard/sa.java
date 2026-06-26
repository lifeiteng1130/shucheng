package com.tencent.bugly.proguard;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes.dex */
public final class sa extends AbstractC0320m implements Cloneable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Map<String, String> f4438b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f4440d = true;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f4441e = true;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f4442f = true;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f4443g = "";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f4444h = "";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ra f4445i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Map<String, String> f4446j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f4447k = 0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f4448l = "";
    public String m = "";
    public int n = 0;
    public int o = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ boolean f4439c = true;
    public static ra a = new ra();

    static {
        HashMap map = new HashMap();
        f4438b = map;
        map.put("", "");
    }

    @Override // com.tencent.bugly.proguard.AbstractC0320m
    public void a(C0319l c0319l) {
        c0319l.a(this.f4440d, 0);
        c0319l.a(this.f4441e, 1);
        c0319l.a(this.f4442f, 2);
        String str = this.f4443g;
        if (str != null) {
            c0319l.a(str, 3);
        }
        String str2 = this.f4444h;
        if (str2 != null) {
            c0319l.a(str2, 4);
        }
        ra raVar = this.f4445i;
        if (raVar != null) {
            c0319l.a((AbstractC0320m) raVar, 5);
        }
        Map<String, String> map = this.f4446j;
        if (map != null) {
            c0319l.a((Map) map, 6);
        }
        c0319l.a(this.f4447k, 7);
        String str3 = this.f4448l;
        if (str3 != null) {
            c0319l.a(str3, 8);
        }
        String str4 = this.m;
        if (str4 != null) {
            c0319l.a(str4, 9);
        }
        c0319l.a(this.n, 10);
        c0319l.a(this.o, 11);
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            if (f4439c) {
                return null;
            }
            throw new AssertionError();
        }
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        sa saVar = (sa) obj;
        return C0321n.a(this.f4440d, saVar.f4440d) && C0321n.a(this.f4441e, saVar.f4441e) && C0321n.a(this.f4442f, saVar.f4442f) && C0321n.a(this.f4443g, saVar.f4443g) && C0321n.a(this.f4444h, saVar.f4444h) && C0321n.a(this.f4445i, saVar.f4445i) && C0321n.a(this.f4446j, saVar.f4446j) && C0321n.a(this.f4447k, saVar.f4447k) && C0321n.a(this.f4448l, saVar.f4448l) && C0321n.a(this.m, saVar.m) && C0321n.a(this.n, saVar.n) && C0321n.a(this.o, saVar.o);
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
    public void a(C0318k c0318k) {
        this.f4440d = c0318k.a(this.f4440d, 0, true);
        this.f4441e = c0318k.a(this.f4441e, 1, true);
        this.f4442f = c0318k.a(this.f4442f, 2, true);
        this.f4443g = c0318k.a(3, false);
        this.f4444h = c0318k.a(4, false);
        this.f4445i = (ra) c0318k.a((AbstractC0320m) a, 5, false);
        this.f4446j = (Map) c0318k.a(f4438b, 6, false);
        this.f4447k = c0318k.a(this.f4447k, 7, false);
        this.f4448l = c0318k.a(8, false);
        this.m = c0318k.a(9, false);
        this.n = c0318k.a(this.n, 10, false);
        this.o = c0318k.a(this.o, 11, false);
    }

    @Override // com.tencent.bugly.proguard.AbstractC0320m
    public void a(StringBuilder sb, int i2) {
        C0316i c0316i = new C0316i(sb, i2);
        c0316i.a(this.f4440d, "enable");
        c0316i.a(this.f4441e, "enableUserInfo");
        c0316i.a(this.f4442f, "enableQuery");
        c0316i.a(this.f4443g, "url");
        c0316i.a(this.f4444h, "expUrl");
        c0316i.a((AbstractC0320m) this.f4445i, "security");
        c0316i.a((Map) this.f4446j, "valueMap");
        c0316i.a(this.f4447k, "strategylastUpdateTime");
        c0316i.a(this.f4448l, "httpsUrl");
        c0316i.a(this.m, "httpsExpUrl");
        c0316i.a(this.n, "eventRecordCount");
        c0316i.a(this.o, "eventTimeInterval");
    }
}

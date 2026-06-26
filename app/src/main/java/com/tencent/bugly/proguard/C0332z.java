package com.tencent.bugly.proguard;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: renamed from: com.tencent.bugly.proguard.z, reason: case insensitive filesystem */
/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes.dex */
public final class C0332z extends AbstractC0320m implements Cloneable {
    public static C0331y a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Map<String, String> f4483b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ boolean f4484c = true;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f4485d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f4486e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public byte f4487f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f4488g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public C0331y f4489h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f4490i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f4491j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Map<String, String> f4492k;

    public C0332z() {
        this.f4485d = "";
        this.f4486e = 0L;
        this.f4487f = (byte) 0;
        this.f4488g = 0L;
        this.f4489h = null;
        this.f4490i = "";
        this.f4491j = 0;
        this.f4492k = null;
    }

    @Override // com.tencent.bugly.proguard.AbstractC0320m
    public void a(C0319l c0319l) {
        c0319l.a(this.f4485d, 0);
        c0319l.a(this.f4486e, 1);
        c0319l.a(this.f4487f, 2);
        c0319l.a(this.f4488g, 3);
        C0331y c0331y = this.f4489h;
        if (c0331y != null) {
            c0319l.a((AbstractC0320m) c0331y, 4);
        }
        String str = this.f4490i;
        if (str != null) {
            c0319l.a(str, 5);
        }
        c0319l.a(this.f4491j, 6);
        Map<String, String> map = this.f4492k;
        if (map != null) {
            c0319l.a((Map) map, 7);
        }
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            if (f4484c) {
                return null;
            }
            throw new AssertionError();
        }
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        C0332z c0332z = (C0332z) obj;
        return C0321n.a(this.f4485d, c0332z.f4485d) && C0321n.a(this.f4486e, c0332z.f4486e) && C0321n.a(this.f4487f, c0332z.f4487f) && C0321n.a(this.f4488g, c0332z.f4488g) && C0321n.a(this.f4489h, c0332z.f4489h) && C0321n.a(this.f4490i, c0332z.f4490i) && C0321n.a(this.f4491j, c0332z.f4491j) && C0321n.a(this.f4492k, c0332z.f4492k);
    }

    public int hashCode() {
        try {
            throw new Exception("Need define key first!");
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public C0332z(String str, long j2, byte b2, long j3, C0331y c0331y, String str2, int i2, Map<String, String> map) {
        this.f4485d = "";
        this.f4486e = 0L;
        this.f4487f = (byte) 0;
        this.f4488g = 0L;
        this.f4489h = null;
        this.f4490i = "";
        this.f4491j = 0;
        this.f4492k = null;
        this.f4485d = str;
        this.f4486e = j2;
        this.f4487f = b2;
        this.f4488g = j3;
        this.f4489h = c0331y;
        this.f4490i = str2;
        this.f4491j = i2;
        this.f4492k = map;
    }

    @Override // com.tencent.bugly.proguard.AbstractC0320m
    public void a(C0318k c0318k) {
        this.f4485d = c0318k.a(0, true);
        this.f4486e = c0318k.a(this.f4486e, 1, true);
        this.f4487f = c0318k.a(this.f4487f, 2, true);
        this.f4488g = c0318k.a(this.f4488g, 3, false);
        if (a == null) {
            a = new C0331y();
        }
        this.f4489h = (C0331y) c0318k.a((AbstractC0320m) a, 4, false);
        this.f4490i = c0318k.a(5, false);
        this.f4491j = c0318k.a(this.f4491j, 6, false);
        if (f4483b == null) {
            HashMap map = new HashMap();
            f4483b = map;
            map.put("", "");
        }
        this.f4492k = (Map) c0318k.a(f4483b, 7, false);
    }

    @Override // com.tencent.bugly.proguard.AbstractC0320m
    public void a(StringBuilder sb, int i2) {
        C0316i c0316i = new C0316i(sb, i2);
        c0316i.a(this.f4485d, "eventType");
        c0316i.a(this.f4486e, "eventTime");
        c0316i.a(this.f4487f, "eventResult");
        c0316i.a(this.f4488g, "eventElapse");
        c0316i.a((AbstractC0320m) this.f4489h, "destAppInfo");
        c0316i.a(this.f4490i, "strategyId");
        c0316i.a(this.f4491j, "updateType");
        c0316i.a((Map) this.f4492k, "reserved");
    }
}

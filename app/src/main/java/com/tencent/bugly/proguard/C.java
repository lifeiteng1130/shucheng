package com.tencent.bugly.proguard;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes.dex */
public final class C extends AbstractC0320m implements Cloneable {
    public static Map<String, String> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ boolean f4255b = true;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f4256c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f4257d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f4258e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Map<String, String> f4259f;

    public C() {
        this.f4256c = 0;
        this.f4257d = "";
        this.f4258e = 0L;
        this.f4259f = null;
    }

    @Override // com.tencent.bugly.proguard.AbstractC0320m
    public void a(C0319l c0319l) {
        c0319l.a(this.f4256c, 0);
        String str = this.f4257d;
        if (str != null) {
            c0319l.a(str, 1);
        }
        c0319l.a(this.f4258e, 2);
        Map<String, String> map = this.f4259f;
        if (map != null) {
            c0319l.a((Map) map, 3);
        }
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            if (f4255b) {
                return null;
            }
            throw new AssertionError();
        }
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        C c2 = (C) obj;
        return C0321n.a(this.f4256c, c2.f4256c) && C0321n.a(this.f4257d, c2.f4257d) && C0321n.a(this.f4258e, c2.f4258e) && C0321n.a(this.f4259f, c2.f4259f);
    }

    public int hashCode() {
        try {
            throw new Exception("Need define key first!");
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public C(int i2, String str, long j2, Map<String, String> map) {
        this.f4256c = 0;
        this.f4257d = "";
        this.f4258e = 0L;
        this.f4259f = null;
        this.f4256c = i2;
        this.f4257d = str;
        this.f4258e = j2;
        this.f4259f = map;
    }

    @Override // com.tencent.bugly.proguard.AbstractC0320m
    public void a(C0318k c0318k) {
        this.f4256c = c0318k.a(this.f4256c, 0, false);
        this.f4257d = c0318k.a(1, false);
        this.f4258e = c0318k.a(this.f4258e, 2, false);
        if (a == null) {
            HashMap map = new HashMap();
            a = map;
            map.put("", "");
        }
        this.f4259f = (Map) c0318k.a(a, 3, false);
    }

    @Override // com.tencent.bugly.proguard.AbstractC0320m
    public void a(StringBuilder sb, int i2) {
        C0316i c0316i = new C0316i(sb, i2);
        c0316i.a(this.f4256c, "flag");
        c0316i.a(this.f4257d, "localStrategyId");
        c0316i.a(this.f4258e, "localStrategyTime");
        c0316i.a((Map) this.f4259f, "reserved");
    }
}

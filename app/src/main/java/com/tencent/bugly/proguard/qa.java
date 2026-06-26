package com.tencent.bugly.proguard;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes.dex */
public final class qa extends AbstractC0320m {
    public static byte[] a = {0};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Map<String, String> f4420b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public byte f4421c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f4422d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public byte[] f4423e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f4424f = "";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f4425g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f4426h = "";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f4427i = "";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Map<String, String> f4428j = null;

    static {
        HashMap map = new HashMap();
        f4420b = map;
        map.put("", "");
    }

    @Override // com.tencent.bugly.proguard.AbstractC0320m
    public void a(C0319l c0319l) {
        c0319l.a(this.f4421c, 0);
        c0319l.a(this.f4422d, 1);
        byte[] bArr = this.f4423e;
        if (bArr != null) {
            c0319l.a(bArr, 2);
        }
        String str = this.f4424f;
        if (str != null) {
            c0319l.a(str, 3);
        }
        c0319l.a(this.f4425g, 4);
        String str2 = this.f4426h;
        if (str2 != null) {
            c0319l.a(str2, 5);
        }
        String str3 = this.f4427i;
        if (str3 != null) {
            c0319l.a(str3, 6);
        }
        Map<String, String> map = this.f4428j;
        if (map != null) {
            c0319l.a((Map) map, 7);
        }
    }

    @Override // com.tencent.bugly.proguard.AbstractC0320m
    public void a(C0318k c0318k) {
        this.f4421c = c0318k.a(this.f4421c, 0, true);
        this.f4422d = c0318k.a(this.f4422d, 1, true);
        this.f4423e = c0318k.a(a, 2, false);
        this.f4424f = c0318k.a(3, false);
        this.f4425g = c0318k.a(this.f4425g, 4, false);
        this.f4426h = c0318k.a(5, false);
        this.f4427i = c0318k.a(6, false);
        this.f4428j = (Map) c0318k.a(f4420b, 7, false);
    }
}

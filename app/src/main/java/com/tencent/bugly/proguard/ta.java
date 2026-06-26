package com.tencent.bugly.proguard;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes.dex */
public final class ta extends AbstractC0320m {
    public static Map<String, String> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f4449b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public byte f4450c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f4451d = "";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f4452e = "";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f4453f = "";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Map<String, String> f4454g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f4455h = "";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f4456i = true;

    static {
        HashMap map = new HashMap();
        a = map;
        map.put("", "");
    }

    @Override // com.tencent.bugly.proguard.AbstractC0320m
    public void a(C0319l c0319l) {
        c0319l.a(this.f4449b, 0);
        c0319l.a(this.f4450c, 1);
        String str = this.f4451d;
        if (str != null) {
            c0319l.a(str, 2);
        }
        String str2 = this.f4452e;
        if (str2 != null) {
            c0319l.a(str2, 3);
        }
        String str3 = this.f4453f;
        if (str3 != null) {
            c0319l.a(str3, 4);
        }
        Map<String, String> map = this.f4454g;
        if (map != null) {
            c0319l.a((Map) map, 5);
        }
        String str4 = this.f4455h;
        if (str4 != null) {
            c0319l.a(str4, 6);
        }
        c0319l.a(this.f4456i, 7);
    }

    @Override // com.tencent.bugly.proguard.AbstractC0320m
    public void a(C0318k c0318k) {
        this.f4449b = c0318k.a(this.f4449b, 0, true);
        this.f4450c = c0318k.a(this.f4450c, 1, true);
        this.f4451d = c0318k.a(2, false);
        this.f4452e = c0318k.a(3, false);
        this.f4453f = c0318k.a(4, false);
        this.f4454g = (Map) c0318k.a(a, 5, false);
        this.f4455h = c0318k.a(6, false);
        this.f4456i = c0318k.a(this.f4456i, 7, false);
    }
}

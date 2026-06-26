package com.tencent.bugly.crashreport.crash.h5;

import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes.dex */
public class a {
    public String a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f4199b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f4200c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f4201d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f4202e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f4203f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f4204g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f4205h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f4206i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f4207j = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f4208k = 0;

    public Map<String, String> a() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        String str = this.a;
        if (str != null) {
            linkedHashMap.put("[JS] projectRoot", str);
        }
        String str2 = this.f4199b;
        if (str2 != null) {
            linkedHashMap.put("[JS] context", str2);
        }
        String str3 = this.f4200c;
        if (str3 != null) {
            linkedHashMap.put("[JS] url", str3);
        }
        String str4 = this.f4201d;
        if (str4 != null) {
            linkedHashMap.put("[JS] userAgent", str4);
        }
        String str5 = this.f4206i;
        if (str5 != null) {
            linkedHashMap.put("[JS] file", str5);
        }
        long j2 = this.f4207j;
        if (j2 != 0) {
            linkedHashMap.put("[JS] lineNumber", Long.toString(j2));
        }
        return linkedHashMap;
    }
}

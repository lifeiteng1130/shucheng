package com.efs.sdk.base.a.a;

import android.text.TextUtils;
import com.efs.sdk.base.BuildConfig;
import com.efs.sdk.base.a.h.f;
import com.umeng.analytics.pro.ai;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes.dex */
public final class c {
    public String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f1758b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f1759c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f1760d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f1761e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f1762f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public byte f1763g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f1764h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f1765i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f1766j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f1767k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f1768l = 0;

    public static c a() {
        c cVar = new c();
        cVar.a = com.efs.sdk.base.a.d.a.a().a;
        cVar.f1758b = com.efs.sdk.base.a.d.a.a().f1775b;
        cVar.f1767k = com.efs.sdk.base.a.d.a.a().f1781h;
        cVar.f1766j = BuildConfig.VERSION_NAME;
        cVar.f1759c = f.a(com.efs.sdk.base.a.d.a.a().f1776c);
        cVar.f1765i = String.valueOf(com.efs.sdk.base.a.c.a.c.a().f1793d.a);
        return cVar;
    }

    public final String b() {
        a.a();
        String strValueOf = String.valueOf(a.b() / 1000);
        String strA = com.efs.sdk.base.a.h.c.b.a(com.efs.sdk.base.a.h.c.a.a(c.a.a.a.a.p(new StringBuilder(), this.f1767k, strValueOf), this.f1758b));
        TreeMap treeMap = new TreeMap();
        treeMap.put("app", this.a);
        treeMap.put("sd", strA);
        if (!TextUtils.isEmpty(this.f1760d)) {
            treeMap.put("cp", this.f1760d);
        }
        if (this.f1763g != 0) {
            treeMap.put("de", String.valueOf(this.f1761e));
            treeMap.put("type", this.f1764h);
            String str = this.f1762f;
            if (TextUtils.isEmpty(str)) {
                a.a();
                long jB = a.b();
                str = String.format(Locale.SIMPLIFIED_CHINESE, "%d%04d", Long.valueOf(jB), Integer.valueOf(new Random(jB).nextInt(10000)));
            }
            treeMap.put("seq", str);
        }
        treeMap.put("cver", this.f1765i);
        treeMap.put(ai.x, "android");
        treeMap.put("sver", this.f1765i);
        treeMap.put("tm", strValueOf);
        treeMap.put("ver", this.f1759c);
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for (Map.Entry entry : treeMap.entrySet()) {
            String str2 = ((String) entry.getKey()) + "=" + ((String) entry.getValue());
            sb2.append(str2);
            sb.append(str2);
            sb.append("&");
        }
        String strA2 = com.efs.sdk.base.a.h.c.b.a(sb2.toString() + this.f1758b);
        sb.append("sign=");
        sb.append(strA2);
        return com.efs.sdk.base.a.h.c.b.b(sb.toString());
    }
}

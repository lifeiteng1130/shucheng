package com.tencent.bugly.proguard;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes.dex */
public final class ua extends AbstractC0320m implements Cloneable {
    public static ArrayList<ta> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Map<String, String> f4457b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public byte f4458c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f4459d = "";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f4460e = "";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ArrayList<ta> f4461f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Map<String, String> f4462g = null;

    @Override // com.tencent.bugly.proguard.AbstractC0320m
    public void a(C0319l c0319l) {
        c0319l.a(this.f4458c, 0);
        String str = this.f4459d;
        if (str != null) {
            c0319l.a(str, 1);
        }
        String str2 = this.f4460e;
        if (str2 != null) {
            c0319l.a(str2, 2);
        }
        ArrayList<ta> arrayList = this.f4461f;
        if (arrayList != null) {
            c0319l.a((Collection) arrayList, 3);
        }
        Map<String, String> map = this.f4462g;
        if (map != null) {
            c0319l.a((Map) map, 4);
        }
    }

    @Override // com.tencent.bugly.proguard.AbstractC0320m
    public void a(StringBuilder sb, int i2) {
    }

    @Override // com.tencent.bugly.proguard.AbstractC0320m
    public void a(C0318k c0318k) {
        this.f4458c = c0318k.a(this.f4458c, 0, true);
        this.f4459d = c0318k.a(1, false);
        this.f4460e = c0318k.a(2, false);
        if (a == null) {
            a = new ArrayList<>();
            a.add(new ta());
        }
        this.f4461f = (ArrayList) c0318k.a(a, 3, false);
        if (f4457b == null) {
            HashMap map = new HashMap();
            f4457b = map;
            map.put("", "");
        }
        this.f4462g = (Map) c0318k.a(f4457b, 4, false);
    }
}

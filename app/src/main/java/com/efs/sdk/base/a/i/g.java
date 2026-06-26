package com.efs.sdk.base.a.i;

import com.efs.sdk.base.a.i.f;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public final class g extends com.efs.sdk.base.a.i.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ConcurrentHashMap<String, a> f1860b = new ConcurrentHashMap<>(10);

    public static class a {
        public String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f1861b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f1862c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public AtomicInteger f1863d = new AtomicInteger(0);

        public a(String str, String str2, String str3) {
            this.a = str;
            this.f1861b = str2;
            this.f1862c = str3;
        }
    }

    public final void a(String str, String str2, String str3) {
        String str4 = str + "_" + str2 + "_" + str3.trim();
        if (!this.f1860b.containsKey(str4) || this.f1860b.get(str4) == null) {
            this.f1860b.putIfAbsent(str4, new a(str, str2, str3));
        }
        ((a) this.f1860b.get(str4)).f1863d.incrementAndGet();
    }

    @Override // com.efs.sdk.base.a.i.a
    public final void a() {
        try {
            if (this.a != null) {
                Iterator it = this.f1860b.entrySet().iterator();
                while (it.hasNext()) {
                    a aVar = (a) ((Map.Entry) it.next()).getValue();
                    int i2 = aVar.f1863d.get();
                    if (i2 > 0) {
                        com.efs.sdk.base.a.d.a aVar2 = this.a;
                        String str = aVar.a;
                        String str2 = aVar.f1861b;
                        String str3 = aVar.f1862c;
                        b bVar = new b("efs_core", "req_succ_rate", f.a.a.a.f1851c);
                        bVar.put("rep_code", str);
                        bVar.put("px_code", str2);
                        bVar.put("path", str3);
                        bVar.put("cnt", Integer.valueOf(i2));
                        aVar2.a(bVar);
                        aVar.f1863d.addAndGet(i2 * (-1));
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }
}

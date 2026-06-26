package com.efs.sdk.base.a.e;

import androidx.annotation.NonNull;
import com.efs.sdk.base.http.HttpResponse;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public final class a implements c {
    @Override // com.efs.sdk.base.a.e.c
    @NonNull
    public final HttpResponse a(com.efs.sdk.base.a.f.b bVar, boolean z) {
        HttpResponse httpResponseA;
        com.efs.sdk.base.a.a.c cVarA = com.efs.sdk.base.a.a.c.a();
        com.efs.sdk.base.a.f.a aVar = bVar.a;
        cVarA.f1760d = aVar.f1825d;
        cVarA.f1761e = aVar.f1826e;
        cVarA.f1763g = aVar.f1823b;
        cVarA.f1764h = aVar.a;
        cVarA.f1768l = bVar.a();
        String strA = com.efs.sdk.base.a.c.a.c.a().a(false);
        int i2 = bVar.a.f1824c;
        if (i2 == 0) {
            com.efs.sdk.base.a.a.a aVarA = com.efs.sdk.base.a.a.a.a();
            byte[] bArr = bVar.f1830c;
            boolean z2 = bVar.f1829b.f1832b;
            String strB = cVarA.b();
            String strA2 = com.efs.sdk.base.a.a.a.a(strA, cVarA);
            if (aVarA.a) {
                com.efs.sdk.base.a.h.d.a("efs.px.api", "upload buffer file, url is ".concat(String.valueOf(strA2)));
            }
            HashMap map = new HashMap(1);
            map.put("wpk-header", strB);
            com.efs.sdk.base.a.h.b.d dVarA = new com.efs.sdk.base.a.h.b.d(strA2).a(map);
            com.efs.sdk.base.a.h.b.b bVar2 = dVarA.a;
            bVar2.f1839c = bArr;
            bVar2.f1843g = true;
            com.efs.sdk.base.a.h.b.d dVarA2 = dVarA.a("type", cVarA.f1764h);
            StringBuilder sb = new StringBuilder();
            sb.append(cVarA.f1768l);
            httpResponseA = dVarA2.a("size", sb.toString()).a("flow_limit", Boolean.toString(z2)).a(com.efs.sdk.base.a.a.d.a()).a().b();
        } else {
            httpResponseA = 1 == i2 ? com.efs.sdk.base.a.a.a.a().a(strA, cVarA, bVar.f1831d, bVar.f1829b.f1832b) : new HttpResponse();
        }
        if (httpResponseA.succ && z) {
            com.efs.sdk.base.a.h.b.b(bVar.f1831d);
        }
        return httpResponseA;
    }
}

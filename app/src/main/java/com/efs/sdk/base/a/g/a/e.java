package com.efs.sdk.base.a.g.a;

import com.efs.sdk.base.a.i.f;
import com.efs.sdk.base.http.HttpResponse;

/* JADX INFO: loaded from: classes.dex */
public final class e extends a {
    @Override // com.efs.sdk.base.a.g.a.a
    public final void a(com.efs.sdk.base.a.f.b bVar) {
        HttpResponse httpResponseA;
        if (!bVar.f1829b.a) {
            b(bVar);
            return;
        }
        com.efs.sdk.base.a.e.d dVarA = com.efs.sdk.base.a.e.d.a();
        if (!bVar.f1829b.f1832b || com.efs.sdk.base.a.e.b.a().a(bVar.a.a, bVar.a())) {
            f.a.a.f1858c.b();
            f.a.a.f1858c.c();
            httpResponseA = dVarA.f1814b.a(bVar, false);
        } else {
            httpResponseA = new HttpResponse();
            httpResponseA.data = "flow_limit";
        }
        bVar.f1829b.f1833c = httpResponseA;
        b(bVar);
    }
}

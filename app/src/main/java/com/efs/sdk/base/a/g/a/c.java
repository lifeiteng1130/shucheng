package com.efs.sdk.base.a.g.a;

import com.efs.sdk.base.Constants;

/* JADX INFO: loaded from: classes.dex */
public final class c extends a {
    private static boolean c(com.efs.sdk.base.a.f.b bVar) {
        if (!bVar.b()) {
            com.efs.sdk.base.a.f.a aVar = bVar.a;
            if ((1 != aVar.f1823b || bVar.f1829b.a) && 1 != aVar.f1824c) {
                return false;
            }
        }
        return true;
    }

    @Override // com.efs.sdk.base.a.g.a.a
    public final void a(com.efs.sdk.base.a.f.b bVar) {
        if (c(bVar)) {
            b(bVar);
            return;
        }
        byte[] bArrA = com.efs.sdk.base.a.h.c.a(bVar.f1830c);
        if (bArrA == null) {
            com.efs.sdk.base.a.h.d.a("efs.base", "gzip error", null);
            b(bVar);
        } else {
            bVar.a(bArrA);
            bVar.a(Constants.CP_GZIP);
            b(bVar);
        }
    }
}

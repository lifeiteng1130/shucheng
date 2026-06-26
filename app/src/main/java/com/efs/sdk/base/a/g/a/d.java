package com.efs.sdk.base.a.g.a;

import com.efs.sdk.base.processor.action.ILogEncryptAction;

/* JADX INFO: loaded from: classes.dex */
public final class d extends a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ILogEncryptAction f1834b;

    public d() {
        if (com.efs.sdk.base.a.d.a.a().m == null) {
            this.f1834b = new com.efs.sdk.base.a.g.b();
        } else {
            this.f1834b = com.efs.sdk.base.a.d.a.a().m;
        }
    }

    private static boolean c(com.efs.sdk.base.a.f.b bVar) {
        if (!bVar.c() && !"wa".equals(bVar.a.a)) {
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
        byte[] bArrEncrypt = this.f1834b.encrypt(com.efs.sdk.base.a.d.a.a().f1775b, bVar.f1830c);
        if (bArrEncrypt != null) {
            bVar.a(bArrEncrypt);
            bVar.a(this.f1834b.getDeVal());
        }
        b(bVar);
    }
}

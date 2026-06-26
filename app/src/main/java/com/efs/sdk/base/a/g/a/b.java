package com.efs.sdk.base.a.g.a;

import com.efs.sdk.base.a.b.a;
import com.efs.sdk.base.a.i.f;

/* JADX INFO: loaded from: classes.dex */
public final class b extends a {
    @Override // com.efs.sdk.base.a.g.a.a
    public final void a(com.efs.sdk.base.a.f.b bVar) {
        com.efs.sdk.base.a.b.e eVarA;
        byte[] bArr;
        if (bVar.f1829b.a) {
            b(bVar);
            return;
        }
        com.efs.sdk.base.a.b.a aVar = a.b.a;
        if ("wa".equals(bVar.a.a) || com.efs.sdk.base.a.b.c.a().a) {
            com.efs.sdk.base.a.f.a aVar2 = bVar.a;
            if ((aVar2.f1824c == 0 && ((bArr = bVar.f1830c) == null || bArr.length == 0)) || (eVarA = aVar.f1770c.a(aVar2.f1823b)) == null) {
                return;
            }
            eVarA.a(bVar);
            return;
        }
        if (!aVar.a) {
            com.efs.sdk.base.a.i.f fVar = f.a.a;
            int i2 = com.efs.sdk.base.a.c.a.c.a().f1793d.a;
            if (fVar.f1857b != null || com.efs.sdk.base.a.d.a.a().f1777d) {
                fVar.f1857b.a(fVar.a("disk_limit", i2));
            }
        }
        aVar.a = true;
    }
}

package com.efs.sdk.base.a.g.a;

/* JADX INFO: loaded from: classes.dex */
public final class f extends a {
    @Override // com.efs.sdk.base.a.g.a.a
    public final void a(com.efs.sdk.base.a.f.b bVar) {
        Double d2;
        com.efs.sdk.base.a.c.a.c cVarA = com.efs.sdk.base.a.c.a.c.a();
        String str = bVar.a.a;
        com.efs.sdk.base.a.c.a.b bVar2 = cVarA.f1793d;
        if (com.efs.sdk.base.a.c.a.c.a.nextDouble() * 100.0d <= ((!bVar2.f1788d.containsKey(str) || (d2 = bVar2.f1788d.get(str)) == null) ? 100.0d : d2.doubleValue())) {
            b(bVar);
        }
    }
}

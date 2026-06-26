package e.b.a.p;

import androidx.annotation.NonNull;
import e.b.a.i;
import e.b.a.p.q;
import k.c.d.t;

/* JADX INFO: compiled from: CorePlugin.java */
/* JADX INFO: loaded from: classes3.dex */
public class o implements i.c<k.c.d.r> {
    @Override // e.b.a.i.c
    public void a(@NonNull e.b.a.i iVar, @NonNull k.c.d.s sVar) {
        k.c.d.r rVar = (k.c.d.r) sVar;
        e.b.a.j jVar = (e.b.a.j) iVar;
        int iC = jVar.c();
        jVar.g(rVar);
        k.c.d.a aVar = (k.c.d.a) rVar.a;
        if (aVar instanceof t) {
            t tVar = (t) aVar;
            int i2 = tVar.f8736g;
            q.a.b(jVar.f5981b, q.a.ORDERED);
            q.f5992c.b(jVar.f5981b, Integer.valueOf(i2));
            tVar.f8736g++;
        } else {
            q.a.b(jVar.f5981b, q.a.BULLET);
            e.b.a.k<Integer> kVar = q.f5991b;
            e.b.a.m mVar = jVar.f5981b;
            int i3 = 0;
            for (k.c.d.s sVarC = rVar.c(); sVarC != null; sVarC = sVarC.c()) {
                if (sVarC instanceof k.c.d.r) {
                    i3++;
                }
            }
            kVar.b(mVar, Integer.valueOf(i3));
        }
        jVar.e(rVar, iC);
        if (rVar.f8735e != null) {
            jVar.b();
        }
    }
}

package e.b.a.p;

import androidx.annotation.NonNull;
import e.b.a.i;
import e.b.a.s.m.a;
import java.util.Objects;

/* JADX INFO: compiled from: CorePlugin.java */
/* JADX INFO: loaded from: classes3.dex */
public class n implements i.c<k.c.d.m> {
    @Override // e.b.a.i.c
    public void a(@NonNull e.b.a.i iVar, @NonNull k.c.d.s sVar) {
        k.c.d.m mVar = (k.c.d.m) sVar;
        e.b.a.j jVar = (e.b.a.j) iVar;
        e.b.a.n nVar = ((e.b.a.h) jVar.a.f5974g).a.get(k.c.d.m.class);
        if (nVar == null) {
            jVar.g(mVar);
            return;
        }
        int iC = jVar.c();
        jVar.g(mVar);
        if (iC == jVar.c()) {
            jVar.f5982c.a.append((char) 65532);
        }
        e.b.a.e eVar = jVar.a;
        boolean z = mVar.a instanceof k.c.d.o;
        e.b.a.s.m.a aVar = eVar.f5972e;
        String str = mVar.f8723f;
        Objects.requireNonNull((a.b) aVar);
        e.b.a.m mVar2 = jVar.f5981b;
        e.b.a.s.h.a.b(mVar2, str);
        e.b.a.s.h.f6114b.b(mVar2, Boolean.valueOf(z));
        e.b.a.s.h.f6115c.b(mVar2, null);
        jVar.d(iC, nVar.a(eVar, mVar2));
    }
}

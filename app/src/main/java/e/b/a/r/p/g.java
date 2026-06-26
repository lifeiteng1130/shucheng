package e.b.a.r.p;

import androidx.annotation.NonNull;
import e.b.a.n;
import e.b.a.o;
import e.b.a.p.q;
import e.b.a.r.e;
import java.util.Arrays;
import java.util.Collection;
import k.c.d.r;

/* JADX INFO: compiled from: ListHandler.java */
/* JADX INFO: loaded from: classes3.dex */
public class g extends e.b.a.r.l {
    @Override // e.b.a.r.l
    public void a(@NonNull e.b.a.i iVar, @NonNull e.b.a.r.i iVar2, @NonNull e.b.a.r.e eVar) {
        if (eVar.c()) {
            e.a aVarB = eVar.b();
            boolean zEquals = "ol".equals(aVarB.name());
            boolean zEquals2 = "ul".equals(aVarB.name());
            if (zEquals || zEquals2) {
                e.b.a.j jVar = (e.b.a.j) iVar;
                e.b.a.e eVar2 = jVar.a;
                e.b.a.m mVar = jVar.f5981b;
                n nVar = ((e.b.a.h) eVar2.f5974g).a.get(r.class);
                int i2 = 0;
                e.a aVarA = aVarB;
                while (true) {
                    aVarA = aVarA.a();
                    if (aVarA == null) {
                        break;
                    } else if ("ul".equals(aVarA.name()) || "ol".equals(aVarA.name())) {
                        i2++;
                    }
                }
                int i3 = 1;
                for (e.a aVar : aVarB.e()) {
                    e.b.a.r.l.c(iVar, iVar2, aVar);
                    if (nVar != null && "li".equals(aVar.name())) {
                        if (zEquals) {
                            q.a.b(mVar, q.a.ORDERED);
                            q.f5992c.b(mVar, Integer.valueOf(i3));
                            i3++;
                        } else {
                            q.a.b(mVar, q.a.BULLET);
                            q.f5991b.b(mVar, Integer.valueOf(i2));
                        }
                        o.c(jVar.f5982c, nVar.a(eVar2, mVar), aVar.start(), aVar.f());
                    }
                }
            }
        }
    }

    @Override // e.b.a.r.l
    @NonNull
    public Collection<String> b() {
        return Arrays.asList("ol", "ul");
    }
}

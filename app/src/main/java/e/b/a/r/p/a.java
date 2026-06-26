package e.b.a.r.p;

import androidx.annotation.NonNull;
import e.b.a.n;
import e.b.a.o;
import java.util.Collection;
import java.util.Collections;

/* JADX INFO: compiled from: BlockquoteHandler.java */
/* JADX INFO: loaded from: classes3.dex */
public class a extends e.b.a.r.l {
    @Override // e.b.a.r.l
    public void a(@NonNull e.b.a.i iVar, @NonNull e.b.a.r.i iVar2, @NonNull e.b.a.r.e eVar) {
        if (eVar.c()) {
            e.b.a.r.l.c(iVar, iVar2, eVar.b());
        }
        e.b.a.j jVar = (e.b.a.j) iVar;
        e.b.a.e eVar2 = jVar.a;
        n nVar = ((e.b.a.h) eVar2.f5974g).a.get(k.c.d.b.class);
        if (nVar != null) {
            o.c(jVar.f5982c, nVar.a(eVar2, jVar.f5981b), eVar.start(), eVar.f());
        }
    }

    @Override // e.b.a.r.l
    @NonNull
    public Collection<String> b() {
        return Collections.singleton("blockquote");
    }
}

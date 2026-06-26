package e.b.a.r.p;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import e.b.a.o;

/* JADX INFO: compiled from: SimpleTagHandler.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class h extends e.b.a.r.l {
    @Override // e.b.a.r.l
    public void a(@NonNull e.b.a.i iVar, @NonNull e.b.a.r.i iVar2, @NonNull e.b.a.r.e eVar) {
        if (eVar.c()) {
            e.b.a.r.l.c(iVar, iVar2, eVar.b());
        }
        e.b.a.j jVar = (e.b.a.j) iVar;
        Object objD = d(jVar.a, jVar.f5981b, eVar);
        if (objD != null) {
            o.c(jVar.f5982c, objD, eVar.start(), eVar.f());
        }
    }

    @Nullable
    public abstract Object d(@NonNull e.b.a.e eVar, @NonNull e.b.a.m mVar, @NonNull e.b.a.r.e eVar2);
}

package f.z;

import f.c0.b.p;
import f.c0.c.j;
import f.c0.c.k;
import f.z.e;
import f.z.f;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: CoroutineContext.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class g extends k implements p<f, f.a, f> {
    public static final g INSTANCE = new g();

    public g() {
        super(2);
    }

    @Override // f.c0.b.p
    @NotNull
    public final f invoke(@NotNull f fVar, @NotNull f.a aVar) {
        c cVar;
        j.e(fVar, "acc");
        j.e(aVar, "element");
        f fVarMinusKey = fVar.minusKey(aVar.getKey());
        h hVar = h.INSTANCE;
        if (fVarMinusKey == hVar) {
            return aVar;
        }
        int i2 = e.L;
        e.a aVar2 = e.a.a;
        e eVar = (e) fVarMinusKey.get(aVar2);
        if (eVar == null) {
            cVar = new c(fVarMinusKey, aVar);
        } else {
            f fVarMinusKey2 = fVarMinusKey.minusKey(aVar2);
            if (fVarMinusKey2 == hVar) {
                return new c(aVar, eVar);
            }
            cVar = new c(new c(fVarMinusKey2, aVar), eVar);
        }
        return cVar;
    }
}

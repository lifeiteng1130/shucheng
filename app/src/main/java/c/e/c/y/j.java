package c.e.c.y;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: MultiFormatUPCEANReader.java */
/* JADX INFO: loaded from: classes.dex */
public final class j extends k {
    public final p[] a;

    public j(Map<c.e.c.e, ?> map) {
        Collection collection = map == null ? null : (Collection) map.get(c.e.c.e.POSSIBLE_FORMATS);
        ArrayList arrayList = new ArrayList();
        if (collection != null) {
            if (collection.contains(c.e.c.a.EAN_13)) {
                arrayList.add(new e());
            } else if (collection.contains(c.e.c.a.UPC_A)) {
                arrayList.add(new l());
            }
            if (collection.contains(c.e.c.a.EAN_8)) {
                arrayList.add(new f());
            }
            if (collection.contains(c.e.c.a.UPC_E)) {
                arrayList.add(new q());
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.add(new e());
            arrayList.add(new f());
            arrayList.add(new q());
        }
        this.a = (p[]) arrayList.toArray(new p[arrayList.size()]);
    }

    @Override // c.e.c.y.k, c.e.c.n
    public void b() {
        for (p pVar : this.a) {
            Objects.requireNonNull(pVar);
        }
    }

    @Override // c.e.c.y.k
    public c.e.c.p c(int i2, c.e.c.v.a aVar, Map<c.e.c.e, ?> map) throws c.e.c.k {
        int[] iArrN = p.n(aVar);
        for (p pVar : this.a) {
            try {
                c.e.c.p pVarL = pVar.l(i2, aVar, iArrN, map);
                boolean z = pVarL.f1357d == c.e.c.a.EAN_13 && pVarL.a.charAt(0) == '0';
                Collection collection = map == null ? null : (Collection) map.get(c.e.c.e.POSSIBLE_FORMATS);
                boolean z2 = collection == null || collection.contains(c.e.c.a.UPC_A);
                if (!z || !z2) {
                    return pVarL;
                }
                c.e.c.p pVar2 = new c.e.c.p(pVarL.a.substring(1), pVarL.f1355b, pVarL.f1356c, c.e.c.a.UPC_A);
                pVar2.a(pVarL.f1358e);
                return pVar2;
            } catch (c.e.c.o unused) {
            }
        }
        throw c.e.c.k.getNotFoundInstance();
    }
}

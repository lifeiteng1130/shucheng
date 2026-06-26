package c.e.c;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/* JADX INFO: compiled from: MultiFormatReader.java */
/* JADX INFO: loaded from: classes.dex */
public final class j implements n {
    public Map<e, ?> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public n[] f1346b;

    @Override // c.e.c.n
    public p a(c cVar, Map<e, ?> map) {
        d(map);
        return c(cVar);
    }

    @Override // c.e.c.n
    public void b() {
        n[] nVarArr = this.f1346b;
        if (nVarArr != null) {
            for (n nVar : nVarArr) {
                nVar.b();
            }
        }
    }

    public final p c(c cVar) throws k {
        n[] nVarArr = this.f1346b;
        if (nVarArr != null) {
            for (n nVar : nVarArr) {
                try {
                    return nVar.a(cVar, this.a);
                } catch (o unused) {
                }
            }
        }
        throw k.getNotFoundInstance();
    }

    public void d(Map<e, ?> map) {
        this.a = map;
        boolean z = map != null && map.containsKey(e.TRY_HARDER);
        Collection collection = map == null ? null : (Collection) map.get(e.POSSIBLE_FORMATS);
        ArrayList arrayList = new ArrayList();
        if (collection != null) {
            boolean z2 = collection.contains(a.UPC_A) || collection.contains(a.UPC_E) || collection.contains(a.EAN_13) || collection.contains(a.EAN_8) || collection.contains(a.CODABAR) || collection.contains(a.CODE_39) || collection.contains(a.CODE_93) || collection.contains(a.CODE_128) || collection.contains(a.ITF) || collection.contains(a.RSS_14) || collection.contains(a.RSS_EXPANDED);
            if (z2 && !z) {
                arrayList.add(new c.e.c.y.i(map));
            }
            if (collection.contains(a.QR_CODE)) {
                arrayList.add(new c.e.c.a0.a());
            }
            if (collection.contains(a.DATA_MATRIX)) {
                arrayList.add(new c.e.c.w.a());
            }
            if (collection.contains(a.AZTEC)) {
                arrayList.add(new c.e.c.u.b());
            }
            if (collection.contains(a.PDF_417)) {
                arrayList.add(new c.e.c.z.b());
            }
            if (collection.contains(a.MAXICODE)) {
                arrayList.add(new c.e.c.x.a());
            }
            if (z2 && z) {
                arrayList.add(new c.e.c.y.i(map));
            }
        }
        if (arrayList.isEmpty()) {
            if (!z) {
                arrayList.add(new c.e.c.y.i(map));
            }
            arrayList.add(new c.e.c.a0.a());
            arrayList.add(new c.e.c.w.a());
            arrayList.add(new c.e.c.u.b());
            arrayList.add(new c.e.c.z.b());
            arrayList.add(new c.e.c.x.a());
            if (z) {
                arrayList.add(new c.e.c.y.i(map));
            }
        }
        this.f1346b = (n[]) arrayList.toArray(new n[arrayList.size()]);
    }
}

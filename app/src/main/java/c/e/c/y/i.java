package c.e.c.y;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/* JADX INFO: compiled from: MultiFormatOneDReader.java */
/* JADX INFO: loaded from: classes.dex */
public final class i extends k {
    public final k[] a;

    public i(Map<c.e.c.e, ?> map) {
        Collection collection = map == null ? null : (Collection) map.get(c.e.c.e.POSSIBLE_FORMATS);
        boolean z = (map == null || map.get(c.e.c.e.ASSUME_CODE_39_CHECK_DIGIT) == null) ? false : true;
        ArrayList arrayList = new ArrayList();
        if (collection != null) {
            if (collection.contains(c.e.c.a.EAN_13) || collection.contains(c.e.c.a.UPC_A) || collection.contains(c.e.c.a.EAN_8) || collection.contains(c.e.c.a.UPC_E)) {
                arrayList.add(new j(map));
            }
            if (collection.contains(c.e.c.a.CODE_39)) {
                arrayList.add(new c(z));
            }
            if (collection.contains(c.e.c.a.CODE_93)) {
                arrayList.add(new d());
            }
            if (collection.contains(c.e.c.a.CODE_128)) {
                arrayList.add(new b());
            }
            if (collection.contains(c.e.c.a.ITF)) {
                arrayList.add(new h());
            }
            if (collection.contains(c.e.c.a.CODABAR)) {
                arrayList.add(new a());
            }
            if (collection.contains(c.e.c.a.RSS_14)) {
                arrayList.add(new c.e.c.y.r.e());
            }
            if (collection.contains(c.e.c.a.RSS_EXPANDED)) {
                arrayList.add(new c.e.c.y.r.f.c());
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.add(new j(map));
            arrayList.add(new c(false));
            arrayList.add(new a());
            arrayList.add(new d());
            arrayList.add(new b());
            arrayList.add(new h());
            arrayList.add(new c.e.c.y.r.e());
            arrayList.add(new c.e.c.y.r.f.c());
        }
        this.a = (k[]) arrayList.toArray(new k[arrayList.size()]);
    }

    @Override // c.e.c.y.k, c.e.c.n
    public void b() {
        for (k kVar : this.a) {
            kVar.b();
        }
    }

    @Override // c.e.c.y.k
    public c.e.c.p c(int i2, c.e.c.v.a aVar, Map<c.e.c.e, ?> map) throws c.e.c.k {
        for (k kVar : this.a) {
            try {
                return kVar.c(i2, aVar, map);
            } catch (c.e.c.o unused) {
            }
        }
        throw c.e.c.k.getNotFoundInstance();
    }
}

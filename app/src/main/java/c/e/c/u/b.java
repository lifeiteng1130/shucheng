package c.e.c.u;

import c.e.c.c;
import c.e.c.e;
import c.e.c.g;
import c.e.c.k;
import c.e.c.n;
import c.e.c.p;
import c.e.c.q;
import c.e.c.r;
import c.e.c.s;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: AztecReader.java */
/* JADX INFO: loaded from: classes.dex */
public final class b implements n {
    @Override // c.e.c.n
    public p a(c cVar, Map<e, ?> map) throws k, g {
        r[] rVarArr;
        r[] rVarArr2;
        g gVar;
        s sVar;
        c.e.c.u.d.a aVar = new c.e.c.u.d.a(cVar.a());
        c.e.c.v.e eVarA = null;
        try {
            a aVarA = aVar.a(false);
            rVarArr = aVarA.f1390b;
            try {
                rVarArr2 = rVarArr;
                gVar = null;
                eVarA = new c.e.c.u.c.a().a(aVarA);
                e = null;
            } catch (g e2) {
                e = e2;
                rVarArr2 = rVarArr;
                gVar = e;
                e = null;
            } catch (k e3) {
                e = e3;
                rVarArr2 = rVarArr;
                gVar = null;
            }
        } catch (g e4) {
            e = e4;
            rVarArr = null;
        } catch (k e5) {
            e = e5;
            rVarArr = null;
        }
        if (eVarA == null) {
            try {
                a aVarA2 = aVar.a(true);
                rVarArr2 = aVarA2.f1390b;
                eVarA = new c.e.c.u.c.a().a(aVarA2);
            } catch (g | k e6) {
                if (e != null) {
                    throw e;
                }
                if (gVar != null) {
                    throw gVar;
                }
                throw e6;
            }
        }
        r[] rVarArr3 = rVarArr2;
        if (map != null && (sVar = (s) map.get(e.NEED_RESULT_POINT_CALLBACK)) != null) {
            for (r rVar : rVarArr3) {
                sVar.a(rVar);
            }
        }
        p pVar = new p(eVarA.f1384c, eVarA.a, eVarA.f1383b, rVarArr3, c.e.c.a.AZTEC, System.currentTimeMillis());
        List<byte[]> list = eVarA.f1385d;
        if (list != null) {
            pVar.b(q.BYTE_SEGMENTS, list);
        }
        String str = eVarA.f1386e;
        if (str != null) {
            pVar.b(q.ERROR_CORRECTION_LEVEL, str);
        }
        return pVar;
    }

    @Override // c.e.c.n
    public void b() {
    }
}

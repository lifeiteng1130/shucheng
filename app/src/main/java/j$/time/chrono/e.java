package j$.time.chrono;

import j$.time.temporal.l;
import j$.time.temporal.m;
import j$.time.temporal.n;
import j$.time.temporal.p;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class e {
    public static int a(f fVar, f fVar2) {
        int iCompare = Long.compare(fVar.u(), fVar2.u());
        if (iCompare != 0) {
            return iCompare;
        }
        int iX = fVar.b().x() - fVar2.b().x();
        if (iX != 0) {
            return iX;
        }
        int iCompareTo = fVar.q().compareTo(fVar2.q());
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        int iCompareTo2 = fVar.k().g().compareTo(fVar2.k().g());
        return iCompareTo2 == 0 ? fVar.a().compareTo(fVar2.a()) : iCompareTo2;
    }

    public static int b(f fVar, l lVar) {
        if (!(lVar instanceof j$.time.temporal.h)) {
            return j$.time.a.f(fVar, lVar);
        }
        int iOrdinal = ((j$.time.temporal.h) lVar).ordinal();
        if (iOrdinal != 28) {
            return iOrdinal != 29 ? fVar.q().h(lVar) : fVar.f().y();
        }
        throw new p("Invalid field 'InstantSeconds' for get() method, use getLong() instead");
    }

    public static Object c(f fVar, n nVar) {
        int i2 = m.a;
        return (nVar == j$.time.temporal.g.a || nVar == j$.time.temporal.d.a) ? fVar.k() : nVar == j$.time.temporal.c.a ? fVar.f() : nVar == j$.time.temporal.f.a ? fVar.b() : nVar == j$.time.temporal.b.a ? fVar.a() : nVar == j$.time.temporal.e.a ? j$.time.temporal.i.NANOS : nVar.a(fVar);
    }

    public static long d(f fVar) {
        return ((fVar.c().m() * 86400) + ((long) fVar.b().C())) - ((long) fVar.f().y());
    }
}

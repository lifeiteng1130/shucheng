package j$.time;

import j$.time.temporal.m;
import j$.time.temporal.n;
import j$.time.temporal.p;
import j$.time.temporal.q;

/* JADX INFO: loaded from: classes2.dex */
public enum d implements j$.time.temporal.k {
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY;

    private static final d[] a = values();

    public static d v(int i2) {
        if (i2 >= 1 && i2 <= 7) {
            return a[i2 - 1];
        }
        throw new c("Invalid value for DayOfWeek: " + i2);
    }

    @Override // j$.time.temporal.k
    public boolean d(j$.time.temporal.l lVar) {
        return lVar instanceof j$.time.temporal.h ? lVar == j$.time.temporal.h.DAY_OF_WEEK : lVar != null && lVar.n(this);
    }

    @Override // j$.time.temporal.k
    public int h(j$.time.temporal.l lVar) {
        return lVar == j$.time.temporal.h.DAY_OF_WEEK ? t() : a.f(this, lVar);
    }

    @Override // j$.time.temporal.k
    public q j(j$.time.temporal.l lVar) {
        return lVar == j$.time.temporal.h.DAY_OF_WEEK ? lVar.h() : a.k(this, lVar);
    }

    @Override // j$.time.temporal.k
    public long l(j$.time.temporal.l lVar) {
        if (lVar == j$.time.temporal.h.DAY_OF_WEEK) {
            return t();
        }
        if (!(lVar instanceof j$.time.temporal.h)) {
            return lVar.l(this);
        }
        throw new p("Unsupported field: " + lVar);
    }

    @Override // j$.time.temporal.k
    public Object n(n nVar) {
        int i2 = m.a;
        return nVar == j$.time.temporal.e.a ? j$.time.temporal.i.DAYS : a.j(this, nVar);
    }

    public int t() {
        return ordinal() + 1;
    }
}

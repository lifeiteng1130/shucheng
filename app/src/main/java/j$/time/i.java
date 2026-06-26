package j$.time;

import j$.time.temporal.m;
import j$.time.temporal.n;
import j$.time.temporal.p;
import j$.time.temporal.q;
import java.io.Serializable;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class i implements Comparable<i>, Serializable, Serializable {
    private final f a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final j f7877b;

    static {
        f.a.t(j.f7882f);
        f.f7831b.t(j.f7881e);
    }

    private i(f fVar, j jVar) {
        Objects.requireNonNull(fVar, "dateTime");
        this.a = fVar;
        Objects.requireNonNull(jVar, "offset");
        this.f7877b = jVar;
    }

    public static i t(f fVar, j jVar) {
        return new i(fVar, jVar);
    }

    public g b() {
        return this.a.b();
    }

    @Override // java.lang.Comparable
    public int compareTo(i iVar) {
        int iCompare;
        i iVar2 = iVar;
        if (this.f7877b.equals(iVar2.f7877b)) {
            iCompare = this.a.compareTo(iVar2.a);
        } else {
            iCompare = Long.compare(u(), iVar2.u());
            if (iCompare == 0) {
                iCompare = b().x() - iVar2.b().x();
            }
        }
        return iCompare == 0 ? this.a.compareTo(iVar2.a) : iCompare;
    }

    public boolean d(j$.time.temporal.l lVar) {
        return (lVar instanceof j$.time.temporal.h) || (lVar != null && lVar.n(this));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return this.a.equals(iVar.a) && this.f7877b.equals(iVar.f7877b);
    }

    public int h(j$.time.temporal.l lVar) {
        if (!(lVar instanceof j$.time.temporal.h)) {
            return a.f(this, lVar);
        }
        int iOrdinal = ((j$.time.temporal.h) lVar).ordinal();
        if (iOrdinal != 28) {
            return iOrdinal != 29 ? this.a.h(lVar) : this.f7877b.y();
        }
        throw new p("Invalid field 'InstantSeconds' for get() method, use getLong() instead");
    }

    public int hashCode() {
        return this.a.hashCode() ^ this.f7877b.hashCode();
    }

    public q j(j$.time.temporal.l lVar) {
        return lVar instanceof j$.time.temporal.h ? (lVar == j$.time.temporal.h.INSTANT_SECONDS || lVar == j$.time.temporal.h.OFFSET_SECONDS) ? lVar.h() : this.a.j(lVar) : lVar.t(this);
    }

    public long l(j$.time.temporal.l lVar) {
        if (!(lVar instanceof j$.time.temporal.h)) {
            return lVar.l(this);
        }
        int iOrdinal = ((j$.time.temporal.h) lVar).ordinal();
        return iOrdinal != 28 ? iOrdinal != 29 ? this.a.l(lVar) : this.f7877b.y() : u();
    }

    public Object n(n nVar) {
        int i2 = m.a;
        if (nVar == j$.time.temporal.c.a || nVar == j$.time.temporal.g.a) {
            return this.f7877b;
        }
        if (nVar == j$.time.temporal.d.a) {
            return null;
        }
        return nVar == j$.time.temporal.a.a ? this.a.C() : nVar == j$.time.temporal.f.a ? b() : nVar == j$.time.temporal.b.a ? j$.time.chrono.i.a : nVar == j$.time.temporal.e.a ? j$.time.temporal.i.NANOS : nVar.a(this);
    }

    public String toString() {
        return this.a.toString() + this.f7877b.toString();
    }

    public long u() {
        f fVar = this.a;
        j jVar = this.f7877b;
        Objects.requireNonNull(fVar);
        return a.l(fVar, jVar);
    }

    public f v() {
        return this.a;
    }
}

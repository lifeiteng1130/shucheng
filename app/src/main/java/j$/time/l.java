package j$.time;

import j$.time.temporal.m;
import j$.time.temporal.n;
import j$.time.temporal.p;
import j$.time.temporal.q;
import java.io.Serializable;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class l implements j$.time.chrono.f<e>, Serializable, Serializable {
    private final f a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final j f7887b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ZoneId f7888c;

    private l(f fVar, j jVar, ZoneId zoneId) {
        this.a = fVar;
        this.f7887b = jVar;
        this.f7888c = zoneId;
    }

    public static l t(Instant instant, ZoneId zoneId) {
        Objects.requireNonNull(instant, "instant");
        Objects.requireNonNull(zoneId, "zone");
        long jW = instant.w();
        int iX = instant.x();
        j jVarC = zoneId.t().c(Instant.z(jW, iX));
        return new l(f.A(jW, iX, jVarC), jVarC, zoneId);
    }

    @Override // j$.time.chrono.f
    public j$.time.chrono.h a() {
        Objects.requireNonNull((e) c());
        return j$.time.chrono.i.a;
    }

    @Override // j$.time.chrono.f
    public g b() {
        return this.a.b();
    }

    @Override // j$.time.chrono.f
    public j$.time.chrono.b c() {
        return this.a.C();
    }

    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(j$.time.chrono.f<?> fVar) {
        return j$.time.chrono.e.a(this, fVar);
    }

    public boolean d(j$.time.temporal.l lVar) {
        return (lVar instanceof j$.time.temporal.h) || (lVar != null && lVar.n(this));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof l)) {
            return false;
        }
        l lVar = (l) obj;
        return this.a.equals(lVar.a) && this.f7887b.equals(lVar.f7887b) && this.f7888c.equals(lVar.f7888c);
    }

    @Override // j$.time.chrono.f
    public j f() {
        return this.f7887b;
    }

    public int h(j$.time.temporal.l lVar) {
        if (!(lVar instanceof j$.time.temporal.h)) {
            return j$.time.chrono.e.b(this, lVar);
        }
        int iOrdinal = ((j$.time.temporal.h) lVar).ordinal();
        if (iOrdinal != 28) {
            return iOrdinal != 29 ? this.a.h(lVar) : this.f7887b.y();
        }
        throw new p("Invalid field 'InstantSeconds' for get() method, use getLong() instead");
    }

    public int hashCode() {
        return (this.a.hashCode() ^ this.f7887b.hashCode()) ^ Integer.rotateLeft(this.f7888c.hashCode(), 3);
    }

    public q j(j$.time.temporal.l lVar) {
        return lVar instanceof j$.time.temporal.h ? (lVar == j$.time.temporal.h.INSTANT_SECONDS || lVar == j$.time.temporal.h.OFFSET_SECONDS) ? lVar.h() : this.a.j(lVar) : lVar.t(this);
    }

    @Override // j$.time.chrono.f
    public ZoneId k() {
        return this.f7888c;
    }

    public long l(j$.time.temporal.l lVar) {
        if (!(lVar instanceof j$.time.temporal.h)) {
            return lVar.l(this);
        }
        int iOrdinal = ((j$.time.temporal.h) lVar).ordinal();
        return iOrdinal != 28 ? iOrdinal != 29 ? this.a.l(lVar) : this.f7887b.y() : j$.time.chrono.e.d(this);
    }

    public Object n(n nVar) {
        int i2 = m.a;
        return nVar == j$.time.temporal.a.a ? this.a.C() : j$.time.chrono.e.c(this, nVar);
    }

    @Override // j$.time.chrono.f
    public j$.time.chrono.c q() {
        return this.a;
    }

    public String toString() {
        String str = this.a.toString() + this.f7887b.toString();
        if (this.f7887b == this.f7888c) {
            return str;
        }
        return str + '[' + this.f7888c.toString() + ']';
    }

    @Override // j$.time.chrono.f
    public /* synthetic */ long u() {
        return j$.time.chrono.e.d(this);
    }

    public f v() {
        return this.a;
    }
}

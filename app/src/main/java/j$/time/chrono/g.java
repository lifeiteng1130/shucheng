package j$.time.chrono;

import j$.time.Instant;
import j$.time.ZoneId;
import j$.time.chrono.b;
import j$.time.j;
import j$.time.temporal.l;
import j$.time.temporal.n;
import j$.time.temporal.q;
import java.io.Serializable;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
final class g<D extends b> implements f<D>, Serializable {
    private final transient d a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final transient j f7824b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final transient ZoneId f7825c;

    private g(d dVar, j jVar, ZoneId zoneId) {
        Objects.requireNonNull(dVar, "dateTime");
        this.a = dVar;
        this.f7824b = jVar;
        this.f7825c = zoneId;
    }

    static g t(h hVar, Instant instant, ZoneId zoneId) {
        j jVarC = zoneId.t().c(instant);
        Objects.requireNonNull(jVarC, "offset");
        return new g((d) hVar.o(j$.time.f.A(instant.w(), instant.x(), jVarC)), jVarC, zoneId);
    }

    @Override // j$.time.chrono.f
    public h a() {
        c();
        throw null;
    }

    @Override // j$.time.chrono.f
    public j$.time.g b() {
        return ((d) q()).b();
    }

    @Override // j$.time.chrono.f
    public b c() {
        return ((d) q()).c();
    }

    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(f<?> fVar) {
        return e.a(this, fVar);
    }

    public boolean d(l lVar) {
        return (lVar instanceof j$.time.temporal.h) || (lVar != null && lVar.n(this));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof f) && e.a(this, (f) obj) == 0;
    }

    @Override // j$.time.chrono.f
    public j f() {
        return this.f7824b;
    }

    public /* synthetic */ int h(l lVar) {
        return e.b(this, lVar);
    }

    public int hashCode() {
        Objects.requireNonNull(this.a);
        throw null;
    }

    public q j(l lVar) {
        return lVar instanceof j$.time.temporal.h ? (lVar == j$.time.temporal.h.INSTANT_SECONDS || lVar == j$.time.temporal.h.OFFSET_SECONDS) ? lVar.h() : ((d) q()).j(lVar) : lVar.t(this);
    }

    @Override // j$.time.chrono.f
    public ZoneId k() {
        return this.f7825c;
    }

    public long l(l lVar) {
        if (!(lVar instanceof j$.time.temporal.h)) {
            return lVar.l(this);
        }
        int iOrdinal = ((j$.time.temporal.h) lVar).ordinal();
        return iOrdinal != 28 ? iOrdinal != 29 ? ((d) q()).l(lVar) : f().y() : u();
    }

    public /* synthetic */ Object n(n nVar) {
        return e.c(this, nVar);
    }

    @Override // j$.time.chrono.f
    public c q() {
        return this.a;
    }

    public String toString() {
        Objects.requireNonNull(this.a);
        throw null;
    }

    @Override // j$.time.chrono.f
    public /* synthetic */ long u() {
        return e.d(this);
    }
}

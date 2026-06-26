package j$.time;

import j$.time.temporal.m;
import j$.time.temporal.n;
import j$.time.temporal.q;
import java.io.Serializable;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class f implements j$.time.chrono.c<e>, Serializable, Serializable {
    public static final f a = z(e.a, g.a);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final f f7831b = z(e.f7827b, g.f7870b);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final e f7832c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final g f7833d;

    private f(e eVar, g gVar) {
        this.f7832c = eVar;
        this.f7833d = gVar;
    }

    public static f A(long j2, int i2, j jVar) {
        Objects.requireNonNull(jVar, "offset");
        long j3 = i2;
        j$.time.temporal.h.NANO_OF_SECOND.x(j3);
        long jY = j2 + ((long) jVar.y());
        return new f(e.C(a.y(jY, 86400L)), g.A((((long) ((int) a.x(jY, 86400L))) * 1000000000) + j3));
    }

    public static f v(j$.time.temporal.k kVar) {
        if (kVar instanceof f) {
            return (f) kVar;
        }
        if (kVar instanceof l) {
            return ((l) kVar).v();
        }
        if (kVar instanceof i) {
            return ((i) kVar).v();
        }
        try {
            return new f(e.v(kVar), g.v(kVar));
        } catch (c e2) {
            throw new c("Unable to obtain LocalDateTime from TemporalAccessor: " + kVar + " of type " + kVar.getClass().getName(), e2);
        }
    }

    public static f y(int i2, int i3, int i4, int i5, int i6) {
        return new f(e.B(i2, i3, i4), g.z(i5, i6));
    }

    public static f z(e eVar, g gVar) {
        Objects.requireNonNull(eVar, "date");
        Objects.requireNonNull(gVar, "time");
        return new f(eVar, gVar);
    }

    public /* synthetic */ long B(j jVar) {
        return a.l(this, jVar);
    }

    public e C() {
        return this.f7832c;
    }

    @Override // j$.time.chrono.c
    public j$.time.chrono.h a() {
        Objects.requireNonNull(this.f7832c);
        return j$.time.chrono.i.a;
    }

    @Override // j$.time.chrono.c
    public g b() {
        return this.f7833d;
    }

    @Override // j$.time.chrono.c
    public j$.time.chrono.b c() {
        return this.f7832c;
    }

    public boolean d(j$.time.temporal.l lVar) {
        if (!(lVar instanceof j$.time.temporal.h)) {
            return lVar != null && lVar.n(this);
        }
        j$.time.temporal.h hVar = (j$.time.temporal.h) lVar;
        return hVar.v() || hVar.j();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return this.f7832c.equals(fVar.f7832c) && this.f7833d.equals(fVar.f7833d);
    }

    public int h(j$.time.temporal.l lVar) {
        return lVar instanceof j$.time.temporal.h ? ((j$.time.temporal.h) lVar).j() ? this.f7833d.h(lVar) : this.f7832c.h(lVar) : a.f(this, lVar);
    }

    public int hashCode() {
        return this.f7832c.hashCode() ^ this.f7833d.hashCode();
    }

    public q j(j$.time.temporal.l lVar) {
        if (!(lVar instanceof j$.time.temporal.h)) {
            return lVar.t(this);
        }
        if (!((j$.time.temporal.h) lVar).j()) {
            return this.f7832c.j(lVar);
        }
        g gVar = this.f7833d;
        Objects.requireNonNull(gVar);
        return a.k(gVar, lVar);
    }

    public long l(j$.time.temporal.l lVar) {
        return lVar instanceof j$.time.temporal.h ? ((j$.time.temporal.h) lVar).j() ? this.f7833d.l(lVar) : this.f7832c.l(lVar) : lVar.l(this);
    }

    public Object n(n nVar) {
        int i2 = m.a;
        return nVar == j$.time.temporal.a.a ? this.f7832c : a.i(this, nVar);
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public int compareTo(j$.time.chrono.c cVar) {
        if (!(cVar instanceof f)) {
            return a.d(this, cVar);
        }
        f fVar = (f) cVar;
        int iT = this.f7832c.t(fVar.f7832c);
        return iT == 0 ? this.f7833d.compareTo(fVar.f7833d) : iT;
    }

    public i t(j jVar) {
        return i.t(this, jVar);
    }

    public String toString() {
        return this.f7832c.toString() + 'T' + this.f7833d.toString();
    }

    public int w() {
        return this.f7833d.y();
    }

    public int x() {
        return this.f7832c.z();
    }
}

package j$.time.chrono;

import j$.time.chrono.b;
import j$.time.temporal.l;
import j$.time.temporal.n;
import j$.time.temporal.q;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
final class d<D extends b> implements c<D>, Serializable, Serializable {
    @Override // j$.time.chrono.c
    public h a() {
        throw null;
    }

    @Override // j$.time.chrono.c
    public j$.time.g b() {
        return null;
    }

    @Override // j$.time.chrono.c
    public b c() {
        return null;
    }

    public boolean d(l lVar) {
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
        return (obj instanceof c) && j$.time.a.d(this, (c) obj) == 0;
    }

    public int h(l lVar) {
        if (!(lVar instanceof j$.time.temporal.h)) {
            return j(lVar).a(l(lVar), lVar);
        }
        ((j$.time.temporal.h) lVar).j();
        throw null;
    }

    public int hashCode() {
        throw null;
    }

    public q j(l lVar) {
        if (!(lVar instanceof j$.time.temporal.h)) {
            return lVar.t(this);
        }
        ((j$.time.temporal.h) lVar).j();
        throw null;
    }

    public long l(l lVar) {
        if (!(lVar instanceof j$.time.temporal.h)) {
            return lVar.l(this);
        }
        ((j$.time.temporal.h) lVar).j();
        throw null;
    }

    public /* synthetic */ Object n(n nVar) {
        return j$.time.a.i(this, nVar);
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: p */
    public /* synthetic */ int compareTo(c cVar) {
        return j$.time.a.d(this, cVar);
    }

    public String toString() {
        throw null;
    }
}

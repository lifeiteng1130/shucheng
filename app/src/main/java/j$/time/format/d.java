package j$.time.format;

import j$.time.ZoneId;
import j$.time.temporal.k;
import j$.time.temporal.l;
import j$.time.temporal.m;
import j$.time.temporal.n;
import j$.time.temporal.q;

/* JADX INFO: loaded from: classes2.dex */
class d implements k {
    final /* synthetic */ j$.time.chrono.b a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ k f7860b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ j$.time.chrono.h f7861c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ ZoneId f7862d;

    d(j$.time.chrono.b bVar, k kVar, j$.time.chrono.h hVar, ZoneId zoneId) {
        this.a = bVar;
        this.f7860b = kVar;
        this.f7861c = hVar;
        this.f7862d = zoneId;
    }

    @Override // j$.time.temporal.k
    public boolean d(l lVar) {
        return (this.a == null || !lVar.v()) ? this.f7860b.d(lVar) : this.a.d(lVar);
    }

    @Override // j$.time.temporal.k
    public /* synthetic */ int h(l lVar) {
        return j$.time.a.f(this, lVar);
    }

    @Override // j$.time.temporal.k
    public q j(l lVar) {
        return ((this.a == null || !lVar.v()) ? this.f7860b : this.a).j(lVar);
    }

    @Override // j$.time.temporal.k
    public long l(l lVar) {
        return ((this.a == null || !lVar.v()) ? this.f7860b : this.a).l(lVar);
    }

    @Override // j$.time.temporal.k
    public Object n(n nVar) {
        int i2 = m.a;
        return nVar == j$.time.temporal.b.a ? this.f7861c : nVar == j$.time.temporal.d.a ? this.f7862d : nVar == j$.time.temporal.e.a ? this.f7860b.n(nVar) : nVar.a(this);
    }
}

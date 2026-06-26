package k.c.c;

import k.c.d.u;

/* JADX INFO: compiled from: ListItemParser.java */
/* JADX INFO: loaded from: classes3.dex */
public class q extends k.c.e.g.a {
    public final k.c.d.r a = new k.c.d.r();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f8703b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f8704c;

    public q(int i2) {
        this.f8703b = i2;
    }

    @Override // k.c.e.g.a, k.c.e.g.c
    public boolean b() {
        return true;
    }

    @Override // k.c.e.g.c
    public b c(k.c.e.g.f fVar) {
        if (((h) fVar).f8666j) {
            if (this.a.f8732b == null) {
                return null;
            }
            h hVar = (h) fVar;
            k.c.d.a aVarG = hVar.h().g();
            this.f8704c = (aVarG instanceof u) || (aVarG instanceof k.c.d.r);
            return b.b(hVar.f8663g);
        }
        h hVar2 = (h) fVar;
        int i2 = hVar2.f8665i;
        int i3 = this.f8703b;
        if (i2 >= i3) {
            return b.a(hVar2.f8661e + i3);
        }
        return null;
    }

    @Override // k.c.e.g.a, k.c.e.g.c
    public boolean d(k.c.d.a aVar) {
        if (!this.f8704c) {
            return true;
        }
        k.c.d.a aVar2 = (k.c.d.a) this.a.a;
        if (!(aVar2 instanceof k.c.d.q)) {
            return true;
        }
        ((k.c.d.q) aVar2).f8731f = false;
        return true;
    }

    @Override // k.c.e.g.c
    public k.c.d.a g() {
        return this.a;
    }
}

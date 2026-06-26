package k.c.c.u;

import k.c.c.f;
import k.c.d.g;
import k.c.d.s;
import k.c.d.w;
import k.c.d.x;

/* JADX INFO: compiled from: EmphasisDelimiterProcessor.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class b implements k.c.e.h.a {
    public final char a;

    public b(char c2) {
        this.a = c2;
    }

    @Override // k.c.e.h.a
    public int a(f fVar, f fVar2) {
        if (fVar.f8653d || fVar2.f8652c) {
            int i2 = fVar2.f8657h;
            if (i2 % 3 != 0 && (fVar.f8657h + i2) % 3 == 0) {
                return 0;
            }
        }
        return (fVar.f8656g < 2 || fVar2.f8656g < 2) ? 1 : 2;
    }

    @Override // k.c.e.h.a
    public void b(x xVar, x xVar2, int i2) {
        String strValueOf = String.valueOf(this.a);
        s gVar = i2 == 1 ? new g(strValueOf) : new w(c.a.a.a.a.i(strValueOf, strValueOf));
        s sVar = xVar.f8735e;
        while (sVar != null && sVar != xVar2) {
            s sVar2 = sVar.f8735e;
            gVar.b(sVar);
            sVar = sVar2;
        }
        gVar.f();
        s sVar3 = xVar.f8735e;
        gVar.f8735e = sVar3;
        if (sVar3 != null) {
            sVar3.f8734d = gVar;
        }
        gVar.f8734d = xVar;
        xVar.f8735e = gVar;
        s sVar4 = xVar.a;
        gVar.a = sVar4;
        if (gVar.f8735e == null) {
            sVar4.f8733c = gVar;
        }
    }

    @Override // k.c.e.h.a
    public char c() {
        return this.a;
    }

    @Override // k.c.e.h.a
    public int d() {
        return 1;
    }

    @Override // k.c.e.h.a
    public char e() {
        return this.a;
    }
}

package k.c.c;

import java.util.LinkedList;
import java.util.ListIterator;
import k.c.d.x;

/* JADX INFO: compiled from: StaggeredDelimiterProcessor.java */
/* JADX INFO: loaded from: classes3.dex */
public class s implements k.c.e.h.a {
    public final char a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f8706b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public LinkedList<k.c.e.h.a> f8707c = new LinkedList<>();

    public s(char c2) {
        this.a = c2;
    }

    @Override // k.c.e.h.a
    public int a(f fVar, f fVar2) {
        return g(fVar.f8656g).a(fVar, fVar2);
    }

    @Override // k.c.e.h.a
    public void b(x xVar, x xVar2, int i2) {
        g(i2).b(xVar, xVar2, i2);
    }

    @Override // k.c.e.h.a
    public char c() {
        return this.a;
    }

    @Override // k.c.e.h.a
    public int d() {
        return this.f8706b;
    }

    @Override // k.c.e.h.a
    public char e() {
        return this.a;
    }

    public void f(k.c.e.h.a aVar) {
        boolean z;
        int iD;
        int iD2 = aVar.d();
        ListIterator<k.c.e.h.a> listIterator = this.f8707c.listIterator();
        do {
            if (listIterator.hasNext()) {
                iD = listIterator.next().d();
                if (iD2 > iD) {
                    listIterator.previous();
                    listIterator.add(aVar);
                    z = true;
                }
            } else {
                z = false;
            }
            if (z) {
                return;
            }
            this.f8707c.add(aVar);
            this.f8706b = iD2;
            return;
        } while (iD2 != iD);
        StringBuilder sbR = c.a.a.a.a.r("Cannot add two delimiter processors for char '");
        sbR.append(this.a);
        sbR.append("' and minimum length ");
        sbR.append(iD2);
        throw new IllegalArgumentException(sbR.toString());
    }

    public final k.c.e.h.a g(int i2) {
        for (k.c.e.h.a aVar : this.f8707c) {
            if (aVar.d() <= i2) {
                return aVar;
            }
        }
        return this.f8707c.getFirst();
    }
}

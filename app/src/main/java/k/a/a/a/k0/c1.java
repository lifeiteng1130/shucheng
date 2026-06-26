package k.a.a.a.k0;

import java.util.BitSet;
import java.util.Objects;
import k.a.a.a.k0.h1;

/* JADX INFO: compiled from: ProfilingATNSimulator.java */
/* JADX INFO: loaded from: classes3.dex */
public class c1 extends t0 {
    public final v[] m;
    public int n;
    public int o;
    public int p;
    public int q;
    public int r;

    /* JADX WARN: Illegal instructions before constructor call */
    public c1(k.a.a.a.w wVar) {
        a aVar = wVar.getInterpreter().f8423b;
        super(wVar, aVar, wVar.getInterpreter().f8454f, wVar.getInterpreter().f8424c);
        int size = aVar.f8375b.size();
        this.n = size;
        this.m = new v[size];
        for (int i2 = 0; i2 < this.n; i2++) {
            this.m[i2] = new v(i2);
        }
    }

    @Override // k.a.a.a.k0.t0
    public int b(k.a.a.a.g0 g0Var, int i2, k.a.a.a.y yVar) {
        try {
            this.o = -1;
            this.p = -1;
            this.q = i2;
            long jNanoTime = System.nanoTime();
            int iB = super.b(g0Var, i2, yVar);
            long jNanoTime2 = System.nanoTime();
            v[] vVarArr = this.m;
            v vVar = vVarArr[i2];
            vVar.f8463c = (jNanoTime2 - jNanoTime) + vVar.f8463c;
            vVarArr[i2].f8462b++;
            int i3 = (this.o - this.f8458j) + 1;
            long j2 = i3;
            vVarArr[i2].f8464d += j2;
            vVarArr[i2].f8465e = vVarArr[i2].f8465e == 0 ? j2 : Math.min(vVarArr[i2].f8465e, j2);
            v[] vVarArr2 = this.m;
            if (j2 > vVarArr2[i2].f8466f) {
                vVarArr2[i2].f8466f = j2;
                Objects.requireNonNull(vVarArr2[i2]);
            }
            int i4 = this.p;
            if (i4 >= 0) {
                int i5 = (i4 - this.f8458j) + 1;
                v[] vVarArr3 = this.m;
                long j3 = i5;
                vVarArr3[i2].f8467g += j3;
                vVarArr3[i2].f8468h = vVarArr3[i2].f8468h == 0 ? j3 : Math.min(vVarArr3[i2].f8468h, j3);
                v[] vVarArr4 = this.m;
                if (j3 > vVarArr4[i2].f8469i) {
                    vVarArr4[i2].f8469i = j3;
                    Objects.requireNonNull(vVarArr4[i2]);
                }
            }
            return iB;
        } finally {
            this.q = -1;
        }
    }

    @Override // k.a.a.a.k0.t0
    public c h(c cVar, int i2, boolean z) {
        if (z) {
            this.p = this.f8457i.index();
        }
        c cVarH = super.h(cVar, i2, z);
        if (z) {
            v[] vVarArr = this.m;
            int i3 = this.q;
            vVarArr[i3].q++;
            if (cVarH == null) {
                vVarArr[i3].f8471k.add(new z(i3, cVar, this.f8457i, this.f8458j, this.p, true));
            }
        } else {
            v[] vVarArr2 = this.m;
            int i4 = this.q;
            vVarArr2[i4].n++;
            if (cVarH == null) {
                vVarArr2[i4].f8471k.add(new z(i4, cVar, this.f8457i, this.f8458j, this.o, false));
            }
        }
        return cVarH;
    }

    @Override // k.a.a.a.k0.t0
    public k.a.a.a.l0.d j(k.a.a.a.l0.b bVar, k.a.a.a.l0.d dVar, int i2) {
        return super.j(bVar, dVar, i2);
    }

    @Override // k.a.a.a.k0.t0
    public boolean l(h1 h1Var, k.a.a.a.y yVar, int i2, boolean z) {
        boolean zC = h1Var.c(this.f8453e, yVar);
        if (!(h1Var instanceof h1.d)) {
            int i3 = this.p;
            if (!(i3 >= 0)) {
                i3 = this.o;
            }
            int i4 = i3;
            v[] vVarArr = this.m;
            int i5 = this.q;
            vVarArr[i5].m.add(new x0(i5, this.f8457i, this.f8458j, i4, h1Var, zC, i2, z));
        }
        return zC;
    }

    @Override // k.a.a.a.k0.t0
    public k.a.a.a.l0.d o(k.a.a.a.l0.d dVar, int i2) {
        this.o = this.f8457i.index();
        k.a.a.a.l0.d dVarO = super.o(dVar, i2);
        if (dVarO != null) {
            v[] vVarArr = this.m;
            int i3 = this.q;
            vVarArr[i3].o++;
            if (dVarO == h.a) {
                vVarArr[i3].f8471k.add(new z(i3, dVar.f8487b, this.f8457i, this.f8458j, this.o, false));
            }
        }
        return dVarO;
    }

    @Override // k.a.a.a.k0.t0
    public void s(k.a.a.a.l0.b bVar, k.a.a.a.l0.d dVar, int i2, int i3, boolean z, BitSet bitSet, c cVar) {
        int iNextSetBit = bitSet.nextSetBit(0);
        if (cVar.f8395h && iNextSetBit != this.r) {
            v[] vVarArr = this.m;
            int i4 = this.q;
            vVarArr[i4].f8470j.add(new t(i4, cVar, this.f8457i, i2, i3));
        }
        v[] vVarArr2 = this.m;
        int i5 = this.q;
        vVarArr2[i5].f8472l.add(new m(i5, cVar, bitSet, this.f8457i, i2, i3, cVar.f8395h));
        super.s(bVar, dVar, i2, i3, z, bitSet, cVar);
    }

    @Override // k.a.a.a.k0.t0
    public void t(k.a.a.a.l0.b bVar, BitSet bitSet, c cVar, int i2, int i3) {
        if (bitSet != null) {
            this.r = bitSet.nextSetBit(0);
        } else {
            this.r = cVar.c().nextSetBit(0);
        }
        this.m[this.q].p++;
        super.t(bVar, bitSet, cVar, i2, i3);
    }

    @Override // k.a.a.a.k0.t0
    public void u(k.a.a.a.l0.b bVar, int i2, c cVar, int i3, int i4) {
        if (i2 != this.r) {
            v[] vVarArr = this.m;
            int i5 = this.q;
            vVarArr[i5].f8470j.add(new t(i5, cVar, this.f8457i, i3, i4));
        }
        super.u(bVar, i2, cVar, i3, i4);
    }
}

package k.a.a.a.k0;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import k.a.a.a.l0.d;

/* JADX INFO: compiled from: ParserATNSimulator.java */
/* JADX INFO: loaded from: classes3.dex */
public class t0 extends h {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final boolean f8452d = Boolean.parseBoolean(System.getenv("TURN_OFF_LR_LOOP_ENTRY_BRANCH_OPT"));

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final k.a.a.a.w f8453e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final k.a.a.a.l0.b[] f8454f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public b1 f8455g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public k.a.a.a.m0.c<z0, z0, z0> f8456h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public k.a.a.a.g0 f8457i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f8458j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public k.a.a.a.y f8459k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public k.a.a.a.l0.b f8460l;

    public t0(k.a.a.a.w wVar, a aVar, k.a.a.a.l0.b[] bVarArr, a1 a1Var) {
        super(aVar, a1Var);
        this.f8455g = b1.LL;
        this.f8453e = wVar;
        this.f8454f = bVarArr;
    }

    public static int q(c cVar) {
        int i2 = 0;
        for (b bVar : cVar) {
            if (i2 == 0) {
                i2 = bVar.f8383b;
            } else if (bVar.f8383b != i2) {
                return 0;
            }
        }
        return i2;
    }

    @Override // k.a.a.a.k0.h
    public void a() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int b(k.a.a.a.g0 g0Var, int i2, k.a.a.a.y yVar) {
        k.a.a.a.l0.d dVarD;
        this.f8457i = g0Var;
        this.f8458j = g0Var.index();
        this.f8459k = yVar;
        k.a.a.a.l0.b bVar = this.f8454f[i2];
        this.f8460l = bVar;
        int iD = g0Var.d();
        int i3 = this.f8458j;
        try {
            if (bVar.f8485e) {
                int precedence = this.f8453e.getPrecedence();
                if (!bVar.f8485e) {
                    throw new IllegalStateException("Only precedence DFAs may contain a precedence start state.");
                }
                dVarD = (precedence < 0 || precedence >= bVar.f8482b.f8488c.length) ? null : bVar.f8482b.f8488c[precedence];
            } else {
                dVarD = bVar.f8482b;
            }
            if (dVarD == null) {
                if (yVar == null) {
                    yVar = k.a.a.a.c0.EMPTY;
                }
                c cVarI = i(bVar.f8484d, k.a.a.a.c0.EMPTY, false);
                if (bVar.f8485e) {
                    bVar.f8482b.f8487b = cVarI;
                    dVarD = d(bVar, new k.a.a.a.l0.d(e(cVarI)));
                    bVar.a(this.f8453e.getPrecedence(), dVarD);
                } else {
                    dVarD = d(bVar, new k.a.a.a.l0.d(cVarI));
                    bVar.f8482b = dVarD;
                }
            }
            return m(bVar, dVarD, g0Var, i3, yVar);
        } finally {
            this.f8456h = null;
            this.f8460l = null;
            g0Var.a(i3);
            g0Var.h(iD);
        }
    }

    public k.a.a.a.l0.d c(k.a.a.a.l0.b bVar, k.a.a.a.l0.d dVar, int i2, k.a.a.a.l0.d dVar2) {
        if (dVar2 == null) {
            return null;
        }
        k.a.a.a.l0.d dVarD = d(bVar, dVar2);
        if (i2 < -1 || i2 > this.f8423b.f8379f) {
            return dVarD;
        }
        synchronized (dVar) {
            if (dVar.f8488c == null) {
                dVar.f8488c = new k.a.a.a.l0.d[this.f8423b.f8379f + 1 + 1];
            }
            dVar.f8488c[i2 + 1] = dVarD;
        }
        return dVarD;
    }

    public k.a.a.a.l0.d d(k.a.a.a.l0.b bVar, k.a.a.a.l0.d dVar) {
        if (dVar == h.a) {
            return dVar;
        }
        synchronized (bVar.a) {
            k.a.a.a.l0.d dVar2 = bVar.a.get(dVar);
            if (dVar2 != null) {
                return dVar2;
            }
            dVar.a = bVar.a.size();
            c cVar = dVar.f8487b;
            if (!cVar.a) {
                cVar.d(this);
                c cVar2 = dVar.f8487b;
                cVar2.a = true;
                cVar2.f8389b = null;
            }
            bVar.a.put(dVar, dVar);
            return dVar;
        }
    }

    public c e(c cVar) {
        z0 z0Var;
        h1 h1VarD;
        HashMap map = new HashMap();
        c cVar2 = new c(cVar.f8395h);
        for (b bVar : cVar) {
            if (bVar.f8383b == 1 && (h1VarD = bVar.f8386e.d(this.f8453e, this.f8459k)) != null) {
                map.put(Integer.valueOf(bVar.a.f8432b), bVar.f8384c);
                if (h1VarD != bVar.f8386e) {
                    cVar2.b(new b(bVar, bVar.a, bVar.f8384c, h1VarD), this.f8456h);
                } else {
                    cVar2.b(bVar, this.f8456h);
                }
            }
        }
        for (b bVar2 : cVar) {
            if (bVar2.f8383b != 1 && (bVar2.c() || (z0Var = (z0) map.get(Integer.valueOf(bVar2.a.f8432b))) == null || !z0Var.equals(bVar2.f8384c))) {
                cVar2.b(bVar2, this.f8456h);
            }
        }
        return cVar2;
    }

    public void f(b bVar, c cVar, Set<b> set, boolean z, boolean z2, int i2, boolean z3) {
        if (bVar.a instanceof f1) {
            if (!bVar.f8384c.f()) {
                for (int i3 = 0; i3 < bVar.f8384c.h(); i3++) {
                    if (bVar.f8384c.d(i3) != Integer.MAX_VALUE) {
                        b bVar2 = new b(this.f8423b.a.get(bVar.f8384c.d(i3)), bVar.f8383b, bVar.f8384c.c(i3), bVar.f8386e);
                        bVar2.f8385d = bVar.f8385d;
                        f(bVar2, cVar, set, z, z2, i2 - 1, z3);
                    } else if (z2) {
                        cVar.b(new b(bVar, bVar.a, z0.a, bVar.f8386e), this.f8456h);
                    } else {
                        g(bVar, cVar, set, z, z2, i2, z3);
                    }
                }
                return;
            }
            if (z2) {
                cVar.b(bVar, this.f8456h);
                return;
            }
        }
        g(bVar, cVar, set, z, z2, i2, z3);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0108  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void g(k.a.a.a.k0.b r17, k.a.a.a.k0.c r18, java.util.Set<k.a.a.a.k0.b> r19, boolean r20, boolean r21, int r22, boolean r23) {
        /*
            Method dump skipped, instruction units count: 624
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: k.a.a.a.k0.t0.g(k.a.a.a.k0.b, k.a.a.a.k0.c, java.util.Set, boolean, boolean, int, boolean):void");
    }

    public c h(c cVar, int i2, boolean z) {
        if (this.f8456h == null) {
            this.f8456h = new k.a.a.a.m0.c<>();
        }
        c cVar2 = new c(z);
        Iterator<b> it = cVar.iterator();
        ArrayList arrayList = null;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            b next = it.next();
            i iVar = next.a;
            if (!(iVar instanceof f1)) {
                int iB = iVar.b();
                for (int i3 = 0; i3 < iB; i3++) {
                    o1 o1VarD = next.a.d(i3);
                    i iVar2 = o1VarD.d(i2, 0, this.f8423b.f8379f) ? o1VarD.f8448b : null;
                    if (iVar2 != null) {
                        cVar2.b(new b(next, iVar2, next.f8384c, next.f8386e), this.f8456h);
                    }
                }
            } else if (z || i2 == -1) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(next);
            }
        }
        c cVar3 = (arrayList != null || i2 == -1 || (cVar2.size() != 1 && q(cVar2) == 0)) ? null : cVar2;
        if (cVar3 == null) {
            c cVar4 = new c(z);
            HashSet hashSet = new HashSet();
            boolean z2 = i2 == -1;
            Iterator<b> it2 = cVar2.iterator();
            while (it2.hasNext()) {
                f(it2.next(), cVar4, hashSet, false, z, 0, z2);
                cVar4 = cVar4;
            }
            cVar3 = cVar4;
        }
        if (i2 == -1) {
            boolean z3 = cVar3 == cVar2;
            if (!b1.allConfigsInRuleStopStates(cVar3)) {
                c cVar5 = new c(cVar3.f8395h);
                for (b bVar : cVar3) {
                    i iVar3 = bVar.a;
                    if (iVar3 instanceof f1) {
                        cVar5.b(bVar, this.f8456h);
                    } else if (z3 && iVar3.f8434d && this.f8423b.e(iVar3).d(-2)) {
                        cVar5.b(new b(bVar, this.f8423b.f8377d[bVar.a.f8433c]), this.f8456h);
                    }
                }
                cVar3 = cVar5;
            }
        }
        if (arrayList != null && (!z || !b1.hasConfigInRuleStopState(cVar3))) {
            Iterator it3 = arrayList.iterator();
            while (it3.hasNext()) {
                cVar3.b((b) it3.next(), this.f8456h);
            }
        }
        if (cVar3.isEmpty()) {
            return null;
        }
        return cVar3;
    }

    public c i(i iVar, k.a.a.a.c0 c0Var, boolean z) {
        z0 z0VarA = z0.a(this.f8423b, c0Var);
        c cVar = new c(z);
        int i2 = 0;
        while (i2 < iVar.b()) {
            int i3 = i2 + 1;
            f(new b(iVar.d(i2).f8448b, i3, z0VarA), cVar, new HashSet(), true, z, 0, false);
            i2 = i3;
        }
        return cVar;
    }

    public k.a.a.a.l0.d j(k.a.a.a.l0.b bVar, k.a.a.a.l0.d dVar, int i2) {
        BitSet bitSet;
        c cVarH = h(dVar.f8487b, i2, false);
        if (cVarH == null) {
            k.a.a.a.l0.d dVar2 = h.a;
            c(bVar, dVar, i2, dVar2);
            return dVar2;
        }
        k.a.a.a.l0.d dVar3 = new k.a.a.a.l0.d(cVarH);
        int iQ = q(cVarH);
        if (iQ != 0) {
            dVar3.f8489d = true;
            dVar3.f8487b.f8391d = iQ;
            dVar3.f8490e = iQ;
        } else if (b1.hasSLLConflictTerminatingPrediction(this.f8455g, cVarH)) {
            dVar3.f8487b.f8392e = b1.getAlts(b1.getConflictingAltSubsets(cVarH));
            dVar3.f8492g = true;
            dVar3.f8489d = true;
            dVar3.f8490e = dVar3.f8487b.f8392e.nextSetBit(0);
        }
        if (dVar3.f8489d && dVar3.f8487b.f8393f) {
            int iB = this.f8423b.b(bVar.f8483c).b();
            c cVar = dVar3.f8487b;
            if (cVar.f8391d != 0) {
                bitSet = new BitSet();
                bitSet.set(cVar.f8391d);
            } else {
                bitSet = cVar.f8392e;
            }
            h1[] h1VarArr = new h1[iB + 1];
            for (b bVar2 : dVar3.f8487b) {
                if (bitSet.get(bVar2.f8383b)) {
                    int i3 = bVar2.f8383b;
                    h1VarArr[i3] = h1.e(h1VarArr[i3], bVar2.f8386e);
                }
            }
            int i4 = 0;
            for (int i5 = 1; i5 <= iB; i5++) {
                if (h1VarArr[i5] == null) {
                    h1VarArr[i5] = h1.a;
                } else if (h1VarArr[i5] != h1.a) {
                    i4++;
                }
            }
            if (i4 == 0) {
                h1VarArr = null;
            }
            if (h1VarArr != null) {
                ArrayList arrayList = new ArrayList();
                boolean z = false;
                for (int i6 = 1; i6 < h1VarArr.length; i6++) {
                    h1 h1Var = h1VarArr[i6];
                    if (bitSet != null && bitSet.get(i6)) {
                        arrayList.add(new d.a(h1Var, i6));
                    }
                    if (h1Var != h1.a) {
                        z = true;
                    }
                }
                dVar3.f8493h = z ? (d.a[]) arrayList.toArray(new d.a[arrayList.size()]) : null;
                dVar3.f8490e = 0;
            } else {
                dVar3.f8490e = bitSet.nextSetBit(0);
            }
            if (dVar3.f8493h != null) {
                dVar3.f8490e = 0;
            }
        }
        return c(bVar, dVar, i2, dVar3);
    }

    public BitSet k(d.a[] aVarArr, k.a.a.a.y yVar, boolean z) {
        BitSet bitSet = new BitSet();
        for (d.a aVar : aVarArr) {
            h1 h1Var = aVar.a;
            if (h1Var == h1.a) {
                bitSet.set(aVar.f8494b);
                if (!z) {
                    break;
                }
            } else {
                if (l(h1Var, yVar, aVar.f8494b, false)) {
                    bitSet.set(aVar.f8494b);
                    if (!z) {
                        break;
                    }
                } else {
                    continue;
                }
            }
        }
        return bitSet;
    }

    public boolean l(h1 h1Var, k.a.a.a.y yVar, int i2, boolean z) {
        return h1Var.c(this.f8453e, yVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x00b5, code lost:
    
        r10 = r2;
        r11 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00cb, code lost:
    
        if (r5.f8391d == 0) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00cd, code lost:
    
        u(r17, r10, r5, r20, r19.index());
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00de, code lost:
    
        s(r17, r12, r20, r19.index(), r11, r5.c(), r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00f5, code lost:
    
        return r10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int m(k.a.a.a.l0.b r17, k.a.a.a.l0.d r18, k.a.a.a.g0 r19, int r20, k.a.a.a.y r21) {
        /*
            Method dump skipped, instruction units count: 333
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: k.a.a.a.k0.t0.m(k.a.a.a.l0.b, k.a.a.a.l0.d, k.a.a.a.g0, int, k.a.a.a.y):int");
    }

    public int n(c cVar) {
        k.a.a.a.m0.i iVar = new k.a.a.a.m0.i(new int[0]);
        for (b bVar : cVar) {
            if (bVar.b() > 0 || ((bVar.a instanceof f1) && bVar.f8384c.e())) {
                iVar.a(bVar.f8383b);
            }
        }
        if (iVar.k() == 0) {
            return 0;
        }
        return iVar.f();
    }

    public k.a.a.a.l0.d o(k.a.a.a.l0.d dVar, int i2) {
        int i3;
        k.a.a.a.l0.d[] dVarArr = dVar.f8488c;
        if (dVarArr == null || (i3 = i2 + 1) < 0 || i3 >= dVarArr.length) {
            return null;
        }
        return dVarArr[i3];
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int p(c cVar, k.a.a.a.y yVar) {
        int iN;
        c cVar2 = new c(cVar.f8395h);
        c cVar3 = new c(cVar.f8395h);
        for (b bVar : cVar) {
            h1 h1Var = bVar.f8386e;
            if (h1Var == h1.a) {
                cVar2.b(bVar, null);
            } else if (l(h1Var, yVar, bVar.f8383b, cVar.f8395h)) {
                cVar2.b(bVar, null);
            } else {
                cVar3.b(bVar, null);
            }
        }
        k.a.a.a.m0.k kVar = new k.a.a.a.m0.k(cVar2, cVar3);
        c cVar4 = (c) kVar.a;
        c cVar5 = (c) kVar.f8516b;
        int iN2 = n(cVar4);
        if (iN2 != 0) {
            return iN2;
        }
        if (cVar5.size() <= 0 || (iN = n(cVar5)) == 0) {
            return 0;
        }
        return iN;
    }

    public k.a.a.a.v r(k.a.a.a.g0 g0Var, k.a.a.a.y yVar, c cVar, int i2) {
        return new k.a.a.a.v(this.f8453e, g0Var, g0Var.get(i2), g0Var.c(1), cVar, yVar);
    }

    public void s(k.a.a.a.l0.b bVar, k.a.a.a.l0.d dVar, int i2, int i3, boolean z, BitSet bitSet, c cVar) {
        k.a.a.a.w wVar = this.f8453e;
        if (wVar != null) {
            wVar.getErrorListenerDispatch().reportAmbiguity(this.f8453e, bVar, i2, i3, z, bitSet, cVar);
        }
    }

    public void t(k.a.a.a.l0.b bVar, BitSet bitSet, c cVar, int i2, int i3) {
        k.a.a.a.w wVar = this.f8453e;
        if (wVar != null) {
            wVar.getErrorListenerDispatch().reportAttemptingFullContext(this.f8453e, bVar, i2, i3, bitSet, cVar);
        }
    }

    public void u(k.a.a.a.l0.b bVar, int i2, c cVar, int i3, int i4) {
        k.a.a.a.w wVar = this.f8453e;
        if (wVar != null) {
            wVar.getErrorListenerDispatch().reportContextSensitivity(this.f8453e, bVar, i3, i4, i2, cVar);
        }
    }
}

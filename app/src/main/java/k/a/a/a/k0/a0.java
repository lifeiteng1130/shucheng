package k.a.a.a.k0;

import java.util.BitSet;
import java.util.Set;

/* JADX INFO: compiled from: LL1Analyzer.java */
/* JADX INFO: loaded from: classes3.dex */
public class a0 {
    public final a a;

    public a0(a aVar) {
        this.a = aVar;
    }

    public void a(i iVar, i iVar2, z0 z0Var, k.a.a.a.m0.i iVar3, Set<b> set, BitSet bitSet, boolean z, boolean z2) {
        int i2;
        int i3;
        g1 g1Var;
        if (set.add(new b(iVar, 0, z0Var))) {
            if (iVar == iVar2) {
                if (z0Var == null) {
                    iVar3.a(-2);
                    return;
                } else if (z0Var.f() && z2) {
                    iVar3.a(-1);
                    return;
                }
            }
            if (iVar instanceof f1) {
                if (z0Var == null) {
                    iVar3.a(-2);
                    return;
                }
                if (z0Var.f() && z2) {
                    iVar3.a(-1);
                    return;
                }
                if (z0Var != z0.a) {
                    boolean z3 = bitSet.get(iVar.f8433c);
                    try {
                        bitSet.clear(iVar.f8433c);
                        for (int i4 = 0; i4 < z0Var.h(); i4++) {
                            a(this.a.a.get(z0Var.d(i4)), iVar2, z0Var.c(i4), iVar3, set, bitSet, z, z2);
                        }
                        if (z3) {
                            return;
                        } else {
                            return;
                        }
                    } finally {
                        if (z3) {
                            bitSet.set(iVar.f8433c);
                        }
                    }
                }
            }
            int i5 = 0;
            for (int iB = iVar.b(); i5 < iB; iB = i3) {
                o1 o1VarD = iVar.d(i5);
                if (o1VarD.getClass() == g1.class) {
                    g1 g1Var2 = (g1) o1VarD;
                    if (bitSet.get(g1Var2.f8448b.f8433c)) {
                        i2 = i5;
                        i3 = iB;
                    } else {
                        j1 j1VarI = j1.i(z0Var, g1Var2.f8422d.f8432b);
                        try {
                            bitSet.set(((g1) o1VarD).f8448b.f8433c);
                            g1Var = g1Var2;
                            i2 = i5;
                            i3 = iB;
                        } catch (Throwable th) {
                            th = th;
                            g1Var = g1Var2;
                        }
                        try {
                            a(o1VarD.f8448b, iVar2, j1VarI, iVar3, set, bitSet, z, z2);
                            bitSet.clear(g1Var.f8448b.f8433c);
                        } catch (Throwable th2) {
                            th = th2;
                            bitSet.clear(g1Var.f8448b.f8433c);
                            throw th;
                        }
                    }
                } else {
                    i2 = i5;
                    i3 = iB;
                    if (o1VarD instanceof k) {
                        if (z) {
                            a(o1VarD.f8448b, iVar2, z0Var, iVar3, set, bitSet, z, z2);
                        } else {
                            iVar3.a(0);
                        }
                    } else if (o1VarD.b()) {
                        a(o1VarD.f8448b, iVar2, z0Var, iVar3, set, bitSet, z, z2);
                    } else if (o1VarD.getClass() == p1.class) {
                        iVar3.c(k.a.a.a.m0.i.h(1, this.a.f8379f));
                    } else {
                        k.a.a.a.m0.i iVarC = o1VarD.c();
                        if (iVarC != null) {
                            if (o1VarD instanceof q0) {
                                k.a.a.a.m0.i iVarH = k.a.a.a.m0.i.h(1, this.a.f8379f);
                                if (iVarH.g()) {
                                    iVarC = null;
                                    iVar3.c(iVarC);
                                } else {
                                    if (iVarC.g()) {
                                        iVarC = new k.a.a.a.m0.i(new int[0]);
                                        iVarC.c(iVarH);
                                    } else {
                                        iVarC = k.a.a.a.m0.i.l(iVarH, iVarC);
                                    }
                                    iVar3.c(iVarC);
                                }
                            } else {
                                iVar3.c(iVarC);
                            }
                        }
                        i5 = i2 + 1;
                    }
                }
                i5 = i2 + 1;
            }
        }
    }
}

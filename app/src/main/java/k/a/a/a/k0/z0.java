package k.a.a.a.k0;

import java.util.IdentityHashMap;

/* JADX INFO: compiled from: PredictionContext.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class z0 {
    public static final x a = new x();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f8480b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f8481c;

    public z0(int i2) {
        f8480b++;
        this.f8481c = i2;
    }

    public static z0 a(a aVar, k.a.a.a.c0 c0Var) {
        if (c0Var == null) {
            c0Var = k.a.a.a.c0.EMPTY;
        }
        k.a.a.a.c0 c0Var2 = c0Var.parent;
        return (c0Var2 == null || c0Var == k.a.a.a.c0.EMPTY) ? a : j1.i(a(aVar, c0Var2), ((g1) aVar.a.get(c0Var.invokingState).d(0)).f8422d.f8432b);
    }

    public static z0 b(z0 z0Var, a1 a1Var, IdentityHashMap<z0, z0> identityHashMap) {
        if (z0Var.f()) {
            return z0Var;
        }
        z0 z0Var2 = identityHashMap.get(z0Var);
        if (z0Var2 != null) {
            return z0Var2;
        }
        z0 z0Var3 = a1Var.a.get(z0Var);
        if (z0Var3 != null) {
            identityHashMap.put(z0Var, z0Var3);
            return z0Var3;
        }
        z0[] z0VarArr = new z0[z0Var.h()];
        boolean z = false;
        for (int i2 = 0; i2 < z0VarArr.length; i2++) {
            z0 z0VarB = b(z0Var.c(i2), a1Var, identityHashMap);
            if (z || z0VarB != z0Var.c(i2)) {
                if (!z) {
                    z0VarArr = new z0[z0Var.h()];
                    for (int i3 = 0; i3 < z0Var.h(); i3++) {
                        z0VarArr[i3] = z0Var.c(i3);
                    }
                    z = true;
                }
                z0VarArr[i2] = z0VarB;
            }
        }
        if (!z) {
            a1Var.a(z0Var);
            identityHashMap.put(z0Var, z0Var);
            return z0Var;
        }
        z0 z0VarI = z0VarArr.length == 0 ? a : z0VarArr.length == 1 ? j1.i(z0VarArr[0], z0Var.d(0)) : new n(z0VarArr, ((n) z0Var).f8446e);
        a1Var.a(z0VarI);
        identityHashMap.put(z0VarI, z0VarI);
        identityHashMap.put(z0Var, z0VarI);
        return z0VarI;
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0089  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static k.a.a.a.k0.z0 g(k.a.a.a.k0.z0 r16, k.a.a.a.k0.z0 r17, boolean r18, k.a.a.a.m0.c<k.a.a.a.k0.z0, k.a.a.a.k0.z0, k.a.a.a.k0.z0> r19) {
        /*
            Method dump skipped, instruction units count: 635
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: k.a.a.a.k0.z0.g(k.a.a.a.k0.z0, k.a.a.a.k0.z0, boolean, k.a.a.a.m0.c):k.a.a.a.k0.z0");
    }

    public abstract z0 c(int i2);

    public abstract int d(int i2);

    public boolean e() {
        return d(h() - 1) == Integer.MAX_VALUE;
    }

    public abstract boolean equals(Object obj);

    public boolean f() {
        return this == a;
    }

    public abstract int h();

    public final int hashCode() {
        return this.f8481c;
    }
}

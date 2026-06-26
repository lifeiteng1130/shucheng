package k.a.a.a.k0;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;

/* JADX INFO: compiled from: ATN.java */
/* JADX INFO: loaded from: classes3.dex */
public class a {
    public final List<i> a = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<w> f8375b = new ArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public e1[] f8376c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public f1[] f8377d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final j f8378e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f8379f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int[] f8380g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public d0[] f8381h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List<n1> f8382i;

    public a(j jVar, int i2) {
        new LinkedHashMap();
        this.f8382i = new ArrayList();
        this.f8378e = jVar;
        this.f8379f = i2;
    }

    public void a(i iVar) {
        if (iVar != null) {
            iVar.a = this;
            iVar.f8432b = this.a.size();
        }
        this.a.add(iVar);
    }

    public w b(int i2) {
        if (this.f8375b.isEmpty()) {
            return null;
        }
        return this.f8375b.get(i2);
    }

    public k.a.a.a.m0.i c(int i2, k.a.a.a.c0 c0Var) {
        if (i2 < 0 || i2 >= this.a.size()) {
            throw new IllegalArgumentException("Invalid state number.");
        }
        k.a.a.a.m0.i iVarE = e(this.a.get(i2));
        if (!iVarE.d(-2)) {
            return iVarE;
        }
        k.a.a.a.m0.i iVar = new k.a.a.a.m0.i(new int[0]);
        iVar.c(iVarE);
        iVar.i(-2);
        while (c0Var != null && c0Var.invokingState >= 0 && iVarE.d(-2)) {
            iVarE = e(((g1) this.a.get(c0Var.invokingState).d(0)).f8422d);
            iVar.c(iVarE);
            iVar.i(-2);
            c0Var = c0Var.parent;
        }
        if (iVarE.d(-2)) {
            iVar.a(-1);
        }
        return iVar;
    }

    public int d() {
        return this.f8375b.size();
    }

    public k.a.a.a.m0.i e(i iVar) {
        k.a.a.a.m0.i iVar2 = iVar.f8436f;
        if (iVar2 != null) {
            return iVar2;
        }
        k.a.a.a.m0.i iVarF = f(iVar, null);
        iVar.f8436f = iVarF;
        iVarF.j(true);
        return iVar.f8436f;
    }

    public k.a.a.a.m0.i f(i iVar, k.a.a.a.c0 c0Var) {
        a0 a0Var = new a0(this);
        k.a.a.a.m0.i iVar2 = new k.a.a.a.m0.i(new int[0]);
        a0Var.a(iVar, null, c0Var != null ? z0.a(iVar.a, c0Var) : null, iVar2, new HashSet(), new BitSet(), true, true);
        return iVar2;
    }
}

package k.a.a.a.k0;

import java.util.Iterator;

/* JADX INFO: compiled from: LexerATNSimulator.java */
/* JADX INFO: loaded from: classes3.dex */
public class c0 extends h {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static int f8397d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final k.a.a.a.s f8398e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f8399f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f8400g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f8401h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final k.a.a.a.l0.b[] f8402i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f8403j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final a f8404k;

    /* JADX INFO: compiled from: LexerATNSimulator.java */
    public static class a {
        public int a = -1;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f8405b = 0;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f8406c = -1;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public k.a.a.a.l0.d f8407d;
    }

    public c0(k.a.a.a.s sVar, k.a.a.a.k0.a aVar, k.a.a.a.l0.b[] bVarArr, a1 a1Var) {
        super(aVar, a1Var);
        this.f8399f = -1;
        this.f8400g = 1;
        this.f8401h = 0;
        this.f8403j = 0;
        this.f8404k = new a();
        this.f8402i = bVarArr;
        this.f8398e = sVar;
    }

    @Override // k.a.a.a.k0.h
    public void a() {
        a aVar = this.f8404k;
        aVar.a = -1;
        aVar.f8405b = 0;
        aVar.f8406c = -1;
        aVar.f8407d = null;
        this.f8399f = -1;
        this.f8400g = 1;
        this.f8401h = 0;
        this.f8403j = 0;
    }

    public void b(k.a.a.a.l0.d dVar, int i2, k.a.a.a.l0.d dVar2) {
        if (i2 < 0 || i2 > 127) {
            return;
        }
        synchronized (dVar) {
            if (dVar.f8488c == null) {
                dVar.f8488c = new k.a.a.a.l0.d[128];
            }
            dVar.f8488c[i2 + 0] = dVar2;
        }
    }

    public k.a.a.a.l0.d c(c cVar) {
        b next;
        k.a.a.a.l0.d dVar = new k.a.a.a.l0.d(cVar);
        Iterator<b> it = cVar.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (next.a instanceof f1) {
                break;
            }
        }
        if (next != null) {
            dVar.f8489d = true;
            dVar.f8491f = ((b0) next).f8387f;
            dVar.f8490e = this.f8423b.f8380g[next.a.f8433c];
        }
        k.a.a.a.l0.b bVar = this.f8402i[this.f8403j];
        synchronized (bVar.a) {
            k.a.a.a.l0.d dVar2 = bVar.a.get(dVar);
            if (dVar2 != null) {
                return dVar2;
            }
            dVar.a = bVar.a.size();
            cVar.a = true;
            cVar.f8389b = null;
            dVar.f8487b = cVar;
            bVar.a.put(dVar, dVar);
            return dVar;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:79:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x018e A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r12v0 */
    /* JADX WARN: Type inference failed for: r12v3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean d(k.a.a.a.g r17, k.a.a.a.k0.b0 r18, k.a.a.a.k0.c r19, boolean r20, boolean r21, boolean r22) {
        /*
            Method dump skipped, instruction units count: 430
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: k.a.a.a.k0.c0.d(k.a.a.a.g, k.a.a.a.k0.b0, k.a.a.a.k0.c, boolean, boolean, boolean):boolean");
    }

    public void e(k.a.a.a.g gVar) {
        if (gVar.b(1) == 10) {
            this.f8400g++;
            this.f8401h = 0;
        } else {
            this.f8401h++;
        }
        gVar.g();
    }

    public int f(k.a.a.a.g gVar, k.a.a.a.l0.d dVar) throws Throwable {
        k.a.a.a.s sVar;
        boolean z;
        int i2;
        int i3;
        b bVar;
        int i4;
        int i5;
        k.a.a.a.l0.d dVar2 = dVar;
        if (dVar2.f8489d) {
            a aVar = this.f8404k;
            aVar.a = gVar.index();
            aVar.f8405b = this.f8400g;
            aVar.f8406c = this.f8401h;
            aVar.f8407d = dVar2;
        }
        int iB = gVar.b(1);
        while (true) {
            k.a.a.a.l0.d[] dVarArr = dVar2.f8488c;
            k.a.a.a.l0.d dVar3 = (dVarArr == null || iB < 0 || iB > 127) ? null : dVarArr[iB + 0];
            int i6 = 0;
            if (dVar3 == null) {
                r0 r0Var = new r0();
                int i7 = 0;
                for (b bVar2 : dVar2.f8487b) {
                    boolean z2 = bVar2.f8383b == i7;
                    if (!z2 || !((b0) bVar2).f8388g) {
                        int iB2 = bVar2.a.b();
                        int i8 = 0;
                        while (true) {
                            if (i8 >= iB2) {
                                break;
                            }
                            o1 o1VarD = bVar2.a.d(i8);
                            i iVar = o1VarD.d(iB, i6, k.a.a.a.s.MAX_CHAR_VALUE) ? o1VarD.f8448b : null;
                            if (iVar != null) {
                                b0 b0Var = (b0) bVar2;
                                e0 e0Var = b0Var.f8387f;
                                if (e0Var != null) {
                                    int iIndex = gVar.index() - this.f8399f;
                                    int i9 = 0;
                                    d0[] d0VarArr = null;
                                    while (true) {
                                        d0[] d0VarArr2 = e0Var.a;
                                        i5 = i8;
                                        if (i9 >= d0VarArr2.length) {
                                            break;
                                        }
                                        if (d0VarArr2[i9].a()) {
                                            d0[] d0VarArr3 = e0Var.a;
                                            if (!(d0VarArr3[i9] instanceof i0)) {
                                                if (d0VarArr == null) {
                                                    d0VarArr = (d0[]) d0VarArr3.clone();
                                                }
                                                d0VarArr[i9] = new i0(iIndex, e0Var.a[i9]);
                                            }
                                        }
                                        i9++;
                                        i8 = i5;
                                    }
                                    if (d0VarArr != null) {
                                        e0Var = new e0(d0VarArr);
                                    }
                                } else {
                                    i5 = i8;
                                }
                                i2 = i5;
                                i3 = iB2;
                                bVar = bVar2;
                                i4 = i7;
                                if (d(gVar, new b0(b0Var, iVar, e0Var), r0Var, z2, true, iB == -1)) {
                                    i7 = bVar.f8383b;
                                    break;
                                }
                            } else {
                                i2 = i8;
                                i3 = iB2;
                                bVar = bVar2;
                                i4 = i7;
                            }
                            i8 = i2 + 1;
                            i7 = i4;
                            bVar2 = bVar;
                            iB2 = i3;
                            i6 = 0;
                        }
                        i6 = 0;
                    }
                }
                if (r0Var.isEmpty()) {
                    if (!r0Var.f8393f) {
                        b(dVar2, iB, h.a);
                    }
                    dVar3 = h.a;
                } else {
                    boolean z3 = r0Var.f8393f;
                    r0Var.f8393f = false;
                    k.a.a.a.l0.d dVarC = c(r0Var);
                    if (!z3) {
                        b(dVar2, iB, dVarC);
                    }
                    dVar3 = dVarC;
                }
            }
            if (dVar3 == h.a) {
                break;
            }
            if (iB != -1) {
                e(gVar);
            }
            if (dVar3.f8489d) {
                a aVar2 = this.f8404k;
                aVar2.a = gVar.index();
                aVar2.f8405b = this.f8400g;
                aVar2.f8406c = this.f8401h;
                aVar2.f8407d = dVar3;
                if (iB == -1) {
                    break;
                }
            }
            iB = gVar.b(1);
            dVar2 = dVar3;
        }
        a aVar3 = this.f8404k;
        c cVar = dVar2.f8487b;
        k.a.a.a.l0.d dVar4 = aVar3.f8407d;
        if (dVar4 == null) {
            if (iB == -1 && gVar.index() == this.f8399f) {
                return -1;
            }
            throw new k.a.a.a.t(this.f8398e, gVar, this.f8399f, cVar);
        }
        e0 e0Var2 = dVar4.f8491f;
        int i10 = this.f8399f;
        int i11 = aVar3.a;
        int i12 = aVar3.f8405b;
        int i13 = aVar3.f8406c;
        gVar.a(i11);
        this.f8400g = i12;
        this.f8401h = i13;
        if (e0Var2 != null && (sVar = this.f8398e) != null) {
            int iIndex2 = gVar.index();
            try {
                d0[] d0VarArr4 = e0Var2.a;
                int length = d0VarArr4.length;
                boolean z4 = false;
                for (int i14 = 0; i14 < length; i14++) {
                    try {
                        d0 d0Var = d0VarArr4[i14];
                        if (d0Var instanceof i0) {
                            int i15 = ((i0) d0Var).a + i10;
                            gVar.a(i15);
                            d0Var = ((i0) d0Var).f8437b;
                            z4 = i15 != iIndex2;
                        } else if (d0Var.a()) {
                            gVar.a(iIndex2);
                        }
                        d0Var.b(sVar);
                    } catch (Throwable th) {
                        th = th;
                        z = z4;
                        if (z) {
                            gVar.a(iIndex2);
                        }
                        throw th;
                    }
                }
                if (z4) {
                    gVar.a(iIndex2);
                }
            } catch (Throwable th2) {
                th = th2;
                z = false;
            }
        }
        return aVar3.f8407d.f8490e;
    }

    public int g(k.a.a.a.g gVar, int i2) {
        f8397d++;
        this.f8403j = i2;
        int iD = gVar.d();
        try {
            this.f8399f = gVar.index();
            a aVar = this.f8404k;
            aVar.a = -1;
            aVar.f8405b = 0;
            aVar.f8406c = -1;
            aVar.f8407d = null;
            k.a.a.a.l0.b bVar = this.f8402i[i2];
            return bVar.f8482b == null ? h(gVar) : f(gVar, bVar.f8482b);
        } finally {
            gVar.h(iD);
        }
    }

    public int h(k.a.a.a.g gVar) {
        n1 n1Var = this.f8423b.f8382i.get(this.f8403j);
        x xVar = z0.a;
        r0 r0Var = new r0();
        int i2 = 0;
        while (i2 < n1Var.b()) {
            int i3 = i2 + 1;
            d(gVar, new b0(n1Var.d(i2).f8448b, i3, xVar), r0Var, false, false, false);
            i2 = i3;
        }
        boolean z = r0Var.f8393f;
        r0Var.f8393f = false;
        k.a.a.a.l0.d dVarC = c(r0Var);
        if (!z) {
            this.f8402i[this.f8403j].f8482b = dVarC;
        }
        return f(gVar, dVarC);
    }
}

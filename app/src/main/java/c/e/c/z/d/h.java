package c.e.c.z.d;

/* JADX INFO: compiled from: DetectionResultRowIndicatorColumn.java */
/* JADX INFO: loaded from: classes.dex */
public final class h extends g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f1546c;

    public h(c cVar, boolean z) {
        super(cVar);
        this.f1546c = z;
    }

    public a c() {
        d[] dVarArr = this.f1545b;
        b bVar = new b();
        b bVar2 = new b();
        b bVar3 = new b();
        b bVar4 = new b();
        for (d dVar : dVarArr) {
            if (dVar != null) {
                dVar.b();
                int i2 = dVar.f1538d % 30;
                int i3 = dVar.f1539e;
                if (!this.f1546c) {
                    i3 += 2;
                }
                int i4 = i3 % 3;
                if (i4 == 0) {
                    bVar2.b((i2 * 3) + 1);
                } else if (i4 == 1) {
                    bVar4.b(i2 / 3);
                    bVar3.b(i2 % 3);
                } else if (i4 == 2) {
                    bVar.b(i2 + 1);
                }
            }
        }
        if (bVar.a().length == 0 || bVar2.a().length == 0 || bVar3.a().length == 0 || bVar4.a().length == 0 || bVar.a()[0] <= 0 || bVar2.a()[0] + bVar3.a()[0] < 3 || bVar2.a()[0] + bVar3.a()[0] > 90) {
            return null;
        }
        a aVar = new a(bVar.a()[0], bVar2.a()[0], bVar3.a()[0], bVar4.a()[0]);
        d(dVarArr, aVar);
        return aVar;
    }

    public final void d(d[] dVarArr, a aVar) {
        for (int i2 = 0; i2 < dVarArr.length; i2++) {
            d dVar = dVarArr[i2];
            if (dVarArr[i2] != null) {
                int i3 = dVar.f1538d % 30;
                int i4 = dVar.f1539e;
                if (i4 > aVar.f1527e) {
                    dVarArr[i2] = null;
                } else {
                    if (!this.f1546c) {
                        i4 += 2;
                    }
                    int i5 = i4 % 3;
                    if (i5 != 0) {
                        if (i5 != 1) {
                            if (i5 == 2 && i3 + 1 != aVar.a) {
                                dVarArr[i2] = null;
                            }
                        } else if (i3 / 3 != aVar.f1524b || i3 % 3 != aVar.f1526d) {
                            dVarArr[i2] = null;
                        }
                    } else if ((i3 * 3) + 1 != aVar.f1525c) {
                        dVarArr[i2] = null;
                    }
                }
            }
        }
    }

    @Override // c.e.c.z.d.g
    public String toString() {
        return "IsLeft: " + this.f1546c + '\n' + super.toString();
    }
}

package c.e.c.z.d;

import c.e.c.r;
import java.util.Formatter;

/* JADX INFO: compiled from: DetectionResult.java */
/* JADX INFO: loaded from: classes.dex */
public final class f {
    public final a a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g[] f1542b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public c f1543c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f1544d;

    public f(a aVar, c cVar) {
        this.a = aVar;
        int i2 = aVar.a;
        this.f1544d = i2;
        this.f1543c = cVar;
        this.f1542b = new g[i2 + 2];
    }

    public static int b(int i2, int i3, d dVar) {
        if (dVar.a()) {
            return i3;
        }
        if (!(i2 != -1 && dVar.f1537c == (i2 % 3) * 3)) {
            return i3 + 1;
        }
        dVar.f1539e = i2;
        return 0;
    }

    public final void a(g gVar) {
        int i2;
        if (gVar != null) {
            h hVar = (h) gVar;
            a aVar = this.a;
            d[] dVarArr = hVar.f1545b;
            for (d dVar : dVarArr) {
                if (dVar != null) {
                    dVar.b();
                }
            }
            hVar.d(dVarArr, aVar);
            c cVar = hVar.a;
            boolean z = hVar.f1546c;
            r rVar = z ? cVar.f1528b : cVar.f1530d;
            r rVar2 = z ? cVar.f1529c : cVar.f1531e;
            int iB = hVar.b((int) rVar.f1359b);
            int iB2 = hVar.b((int) rVar2.f1359b);
            int i3 = -1;
            int i4 = 0;
            int i5 = 1;
            while (iB < iB2) {
                if (dVarArr[iB] != null) {
                    d dVar2 = dVarArr[iB];
                    int i6 = dVar2.f1539e;
                    int i7 = i6 - i3;
                    if (i7 == 0) {
                        i4++;
                    } else {
                        if (i7 == 1) {
                            int iMax = Math.max(i5, i4);
                            i2 = dVar2.f1539e;
                            i5 = iMax;
                        } else if (i7 < 0 || i6 >= aVar.f1527e || i7 > iB) {
                            dVarArr[iB] = null;
                        } else {
                            if (i5 > 2) {
                                i7 *= i5 - 2;
                            }
                            boolean z2 = i7 >= iB;
                            for (int i8 = 1; i8 <= i7 && !z2; i8++) {
                                z2 = dVarArr[iB - i8] != null;
                            }
                            if (z2) {
                                dVarArr[iB] = null;
                            } else {
                                i2 = dVar2.f1539e;
                            }
                        }
                        i3 = i2;
                        i4 = 1;
                    }
                }
                iB++;
            }
        }
    }

    public String toString() {
        g[] gVarArr = this.f1542b;
        g gVar = gVarArr[0];
        if (gVar == null) {
            gVar = gVarArr[this.f1544d + 1];
        }
        Formatter formatter = new Formatter();
        for (int i2 = 0; i2 < gVar.f1545b.length; i2++) {
            try {
                formatter.format("CW %3d:", Integer.valueOf(i2));
                for (int i3 = 0; i3 < this.f1544d + 2; i3++) {
                    g[] gVarArr2 = this.f1542b;
                    if (gVarArr2[i3] == null) {
                        formatter.format("    |   ", new Object[0]);
                    } else {
                        d dVar = gVarArr2[i3].f1545b[i2];
                        if (dVar == null) {
                            formatter.format("    |   ", new Object[0]);
                        } else {
                            formatter.format(" %3d|%3d", Integer.valueOf(dVar.f1539e), Integer.valueOf(dVar.f1538d));
                        }
                    }
                }
                formatter.format("%n", new Object[0]);
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    try {
                        formatter.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                    throw th2;
                }
            }
        }
        String string = formatter.toString();
        formatter.close();
        return string;
    }
}

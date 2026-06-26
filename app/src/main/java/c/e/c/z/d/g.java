package c.e.c.z.d;

import java.util.Formatter;

/* JADX INFO: compiled from: DetectionResultColumn.java */
/* JADX INFO: loaded from: classes.dex */
public class g {
    public final c a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d[] f1545b;

    public g(c cVar) {
        this.a = new c(cVar);
        this.f1545b = new d[(cVar.f1535i - cVar.f1534h) + 1];
    }

    public final d a(int i2) {
        d dVar;
        d dVar2;
        d dVar3 = this.f1545b[i2 - this.a.f1534h];
        if (dVar3 != null) {
            return dVar3;
        }
        for (int i3 = 1; i3 < 5; i3++) {
            int i4 = i2 - this.a.f1534h;
            int i5 = i4 - i3;
            if (i5 >= 0 && (dVar2 = this.f1545b[i5]) != null) {
                return dVar2;
            }
            int i6 = i4 + i3;
            d[] dVarArr = this.f1545b;
            if (i6 < dVarArr.length && (dVar = dVarArr[i6]) != null) {
                return dVar;
            }
        }
        return null;
    }

    public final int b(int i2) {
        return i2 - this.a.f1534h;
    }

    public String toString() {
        Formatter formatter = new Formatter();
        try {
            int i2 = 0;
            for (d dVar : this.f1545b) {
                if (dVar == null) {
                    formatter.format("%3d:    |   %n", Integer.valueOf(i2));
                    i2++;
                } else {
                    formatter.format("%3d: %3d|%3d%n", Integer.valueOf(i2), Integer.valueOf(dVar.f1539e), Integer.valueOf(dVar.f1538d));
                    i2++;
                }
            }
            String string = formatter.toString();
            formatter.close();
            return string;
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
}

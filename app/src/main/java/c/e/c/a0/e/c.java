package c.e.c.a0.e;

import c.e.c.a0.c.f;
import c.e.c.a0.c.j;
import c.e.c.t;

/* JADX INFO: compiled from: Encoder.java */
/* JADX INFO: loaded from: classes.dex */
public final class c {
    public static final int[] a = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 36, -1, -1, -1, 37, 38, -1, -1, -1, -1, 39, 40, -1, 41, 42, 43, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 44, -1, -1, -1, -1, -1, -1, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, -1, -1, -1, -1, -1};

    public static j a(int i2, f fVar) throws t {
        for (int i3 = 1; i3 <= 40; i3++) {
            j jVarD = j.d(i3);
            if (c(i2, jVarD, fVar)) {
                return jVarD;
            }
        }
        throw new t("Data too big");
    }

    public static int b(int i2) {
        int[] iArr = a;
        if (i2 < iArr.length) {
            return iArr[i2];
        }
        return -1;
    }

    public static boolean c(int i2, j jVar, f fVar) {
        int i3 = jVar.f1316f;
        j.b bVar = jVar.f1315e[fVar.ordinal()];
        return i3 - (bVar.a() * bVar.a) >= (i2 + 7) / 8;
    }
}

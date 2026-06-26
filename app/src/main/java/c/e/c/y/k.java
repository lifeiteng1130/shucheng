package c.e.c.y;

import c.e.c.r;
import java.util.Arrays;
import java.util.Map;

/* JADX INFO: compiled from: OneDReader.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class k implements c.e.c.n {
    public static float e(int[] iArr, int[] iArr2, float f2) {
        int length = iArr.length;
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            i2 += iArr[i4];
            i3 += iArr2[i4];
        }
        if (i2 < i3) {
            return Float.POSITIVE_INFINITY;
        }
        float f3 = i2;
        float f4 = f3 / i3;
        float f5 = f2 * f4;
        float f6 = 0.0f;
        for (int i5 = 0; i5 < length; i5++) {
            float f7 = iArr2[i5] * f4;
            float f8 = iArr[i5];
            float f9 = f8 > f7 ? f8 - f7 : f7 - f8;
            if (f9 > f5) {
                return Float.POSITIVE_INFINITY;
            }
            f6 += f9;
        }
        return f6 / f3;
    }

    public static void f(c.e.c.v.a aVar, int i2, int[] iArr) throws c.e.c.k {
        int length = iArr.length;
        int i3 = 0;
        Arrays.fill(iArr, 0, length, 0);
        int i4 = aVar.f1375b;
        if (i2 >= i4) {
            throw c.e.c.k.getNotFoundInstance();
        }
        boolean z = !aVar.e(i2);
        while (i2 < i4) {
            if (aVar.e(i2) == z) {
                i3++;
                if (i3 == length) {
                    break;
                }
                iArr[i3] = 1;
                z = !z;
            } else {
                iArr[i3] = iArr[i3] + 1;
            }
            i2++;
        }
        if (i3 != length) {
            if (i3 != length - 1 || i2 != i4) {
                throw c.e.c.k.getNotFoundInstance();
            }
        }
    }

    public static void g(c.e.c.v.a aVar, int i2, int[] iArr) throws c.e.c.k {
        int length = iArr.length;
        boolean zE = aVar.e(i2);
        while (i2 > 0 && length >= 0) {
            i2--;
            if (aVar.e(i2) != zE) {
                length--;
                zE = !zE;
            }
        }
        if (length >= 0) {
            throw c.e.c.k.getNotFoundInstance();
        }
        f(aVar, i2 + 1, iArr);
    }

    @Override // c.e.c.n
    public c.e.c.p a(c.e.c.c cVar, Map<c.e.c.e, ?> map) throws c.e.c.k {
        try {
            return d(cVar, map);
        } catch (c.e.c.k e2) {
            if (!(map != null && map.containsKey(c.e.c.e.TRY_HARDER)) || !cVar.a.a.c()) {
                throw e2;
            }
            c.e.c.b bVarA = cVar.a.a(cVar.a.a.d());
            c.e.c.p pVarD = d(new c.e.c.c(bVarA), map);
            Map<c.e.c.q, Object> map2 = pVarD.f1358e;
            int iIntValue = 270;
            if (map2 != null) {
                c.e.c.q qVar = c.e.c.q.ORIENTATION;
                if (map2.containsKey(qVar)) {
                    iIntValue = (((Integer) map2.get(qVar)).intValue() + 270) % 360;
                }
            }
            pVarD.b(c.e.c.q.ORIENTATION, Integer.valueOf(iIntValue));
            r[] rVarArr = pVarD.f1356c;
            if (rVarArr != null) {
                int i2 = bVarA.a.f1345b;
                for (int i3 = 0; i3 < rVarArr.length; i3++) {
                    rVarArr[i3] = new r((i2 - rVarArr[i3].f1359b) - 1.0f, rVarArr[i3].a);
                }
            }
            return pVarD;
        }
    }

    @Override // c.e.c.n
    public void b() {
    }

    public abstract c.e.c.p c(int i2, c.e.c.v.a aVar, Map<c.e.c.e, ?> map);

    /* JADX WARN: Removed duplicated region for block: B:37:0x0077  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final c.e.c.p d(c.e.c.c r20, java.util.Map<c.e.c.e, ?> r21) throws c.e.c.k {
        /*
            Method dump skipped, instruction units count: 223
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c.e.c.y.k.d(c.e.c.c, java.util.Map):c.e.c.p");
    }
}

package c.e.c.y;

import c.e.c.r;
import java.util.Map;

/* JADX INFO: compiled from: ITFReader.java */
/* JADX INFO: loaded from: classes.dex */
public final class h extends k {
    public static final int[] a = {6, 8, 10, 12, 14};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int[] f1460b = {1, 1, 1, 1};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int[][] f1461c = {new int[]{1, 1, 2}, new int[]{1, 1, 3}};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int[][] f1462d = {new int[]{1, 1, 2, 2, 1}, new int[]{2, 1, 1, 1, 2}, new int[]{1, 2, 1, 1, 2}, new int[]{2, 2, 1, 1, 1}, new int[]{1, 1, 2, 1, 2}, new int[]{2, 1, 2, 1, 1}, new int[]{1, 2, 2, 1, 1}, new int[]{1, 1, 1, 2, 2}, new int[]{2, 1, 1, 2, 1}, new int[]{1, 2, 1, 2, 1}, new int[]{1, 1, 3, 3, 1}, new int[]{3, 1, 1, 1, 3}, new int[]{1, 3, 1, 1, 3}, new int[]{3, 3, 1, 1, 1}, new int[]{1, 1, 3, 1, 3}, new int[]{3, 1, 3, 1, 1}, new int[]{1, 3, 3, 1, 1}, new int[]{1, 1, 1, 3, 3}, new int[]{3, 1, 1, 3, 1}, new int[]{1, 3, 1, 3, 1}};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f1463e = -1;

    public static int h(int[] iArr) throws c.e.c.k {
        int length = f1462d.length;
        float f2 = 0.38f;
        int i2 = -1;
        for (int i3 = 0; i3 < length; i3++) {
            float fE = k.e(iArr, f1462d[i3], 0.5f);
            if (fE < f2) {
                i2 = i3;
                f2 = fE;
            } else if (fE == f2) {
                i2 = -1;
            }
        }
        if (i2 >= 0) {
            return i2 % 10;
        }
        throw c.e.c.k.getNotFoundInstance();
    }

    public static int[] i(c.e.c.v.a aVar, int i2, int[] iArr) throws c.e.c.k {
        int length = iArr.length;
        int[] iArr2 = new int[length];
        int i3 = aVar.f1375b;
        int i4 = i2;
        boolean z = false;
        int i5 = 0;
        while (i2 < i3) {
            if (aVar.e(i2) != z) {
                iArr2[i5] = iArr2[i5] + 1;
            } else {
                if (i5 != length - 1) {
                    i5++;
                } else {
                    if (k.e(iArr2, iArr, 0.5f) < 0.38f) {
                        return new int[]{i4, i2};
                    }
                    i4 += iArr2[0] + iArr2[1];
                    int i6 = i5 - 1;
                    System.arraycopy(iArr2, 2, iArr2, 0, i6);
                    iArr2[i6] = 0;
                    iArr2[i5] = 0;
                    i5 = i6;
                }
                iArr2[i5] = 1;
                z = !z;
            }
            i2++;
        }
        throw c.e.c.k.getNotFoundInstance();
    }

    @Override // c.e.c.y.k
    public c.e.c.p c(int i2, c.e.c.v.a aVar, Map<c.e.c.e, ?> map) throws c.e.c.k, c.e.c.g {
        int[] iArrI;
        boolean z;
        int i3 = aVar.f1375b;
        int iF = aVar.f(0);
        if (iF == i3) {
            throw c.e.c.k.getNotFoundInstance();
        }
        int[] iArrI2 = i(aVar, iF, f1460b);
        this.f1463e = (iArrI2[1] - iArrI2[0]) / 4;
        j(aVar, iArrI2[0]);
        aVar.j();
        try {
            int i4 = aVar.f1375b;
            int iF2 = aVar.f(0);
            if (iF2 == i4) {
                throw c.e.c.k.getNotFoundInstance();
            }
            try {
                iArrI = i(aVar, iF2, f1461c[0]);
            } catch (c.e.c.k unused) {
                iArrI = i(aVar, iF2, f1461c[1]);
            }
            j(aVar, iArrI[0]);
            int i5 = iArrI[0];
            int i6 = aVar.f1375b;
            iArrI[0] = i6 - iArrI[1];
            iArrI[1] = i6 - i5;
            aVar.j();
            StringBuilder sb = new StringBuilder(20);
            int i7 = iArrI2[1];
            int i8 = iArrI[0];
            int[] iArr = new int[10];
            int[] iArr2 = new int[5];
            int[] iArr3 = new int[5];
            while (i7 < i8) {
                k.f(aVar, i7, iArr);
                for (int i9 = 0; i9 < 5; i9++) {
                    int i10 = i9 * 2;
                    iArr2[i9] = iArr[i10];
                    iArr3[i9] = iArr[i10 + 1];
                }
                sb.append((char) (h(iArr2) + 48));
                sb.append((char) (h(iArr3) + 48));
                for (int i11 = 0; i11 < 10; i11++) {
                    i7 += iArr[i11];
                }
            }
            String string = sb.toString();
            int[] iArr4 = map != null ? (int[]) map.get(c.e.c.e.ALLOWED_LENGTHS) : null;
            if (iArr4 == null) {
                iArr4 = a;
            }
            int length = string.length();
            int length2 = iArr4.length;
            int i12 = 0;
            int i13 = 0;
            while (true) {
                if (i12 >= length2) {
                    z = false;
                    break;
                }
                int i14 = iArr4[i12];
                if (length == i14) {
                    z = true;
                    break;
                }
                if (i14 > i13) {
                    i13 = i14;
                }
                i12++;
            }
            if (!z && length > i13) {
                z = true;
            }
            if (!z) {
                throw c.e.c.g.getFormatInstance();
            }
            float f2 = i2;
            return new c.e.c.p(string, null, new r[]{new r(iArrI2[1], f2), new r(iArrI[0], f2)}, c.e.c.a.ITF);
        } catch (Throwable th) {
            aVar.j();
            throw th;
        }
    }

    public final void j(c.e.c.v.a aVar, int i2) throws c.e.c.k {
        int i3 = this.f1463e * 10;
        if (i3 >= i2) {
            i3 = i2;
        }
        while (true) {
            i2--;
            if (i3 <= 0 || i2 < 0 || aVar.e(i2)) {
                break;
            } else {
                i3--;
            }
        }
        if (i3 != 0) {
            throw c.e.c.k.getNotFoundInstance();
        }
    }
}

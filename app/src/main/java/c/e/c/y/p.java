package c.e.c.y;

import c.e.c.r;
import c.e.c.s;
import java.util.Arrays;
import java.util.Map;

/* JADX INFO: compiled from: UPCEANReader.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class p extends k {
    public static final int[] a = {1, 1, 1};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int[] f1470b = {1, 1, 1, 1, 1};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int[][] f1471c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int[][] f1472d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final StringBuilder f1473e = new StringBuilder(20);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final o f1474f = new o();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final g f1475g = new g();

    static {
        int[][] iArr = {new int[]{3, 2, 1, 1}, new int[]{2, 2, 2, 1}, new int[]{2, 1, 2, 2}, new int[]{1, 4, 1, 1}, new int[]{1, 1, 3, 2}, new int[]{1, 2, 3, 1}, new int[]{1, 1, 1, 4}, new int[]{1, 3, 1, 2}, new int[]{1, 2, 1, 3}, new int[]{3, 1, 1, 2}};
        f1471c = iArr;
        int[][] iArr2 = new int[20][];
        f1472d = iArr2;
        System.arraycopy(iArr, 0, iArr2, 0, 10);
        for (int i2 = 10; i2 < 20; i2++) {
            int[] iArr3 = f1471c[i2 - 10];
            int[] iArr4 = new int[iArr3.length];
            for (int i3 = 0; i3 < iArr3.length; i3++) {
                iArr4[i3] = iArr3[(iArr3.length - i3) - 1];
            }
            f1472d[i2] = iArr4;
        }
    }

    public static int i(c.e.c.v.a aVar, int[] iArr, int i2, int[][] iArr2) {
        k.f(aVar, i2, iArr);
        int length = iArr2.length;
        float f2 = 0.48f;
        int i3 = -1;
        for (int i4 = 0; i4 < length; i4++) {
            float fE = k.e(iArr, iArr2[i4], 0.7f);
            if (fE < f2) {
                i3 = i4;
                f2 = fE;
            }
        }
        if (i3 >= 0) {
            return i3;
        }
        throw c.e.c.k.getNotFoundInstance();
    }

    public static int[] m(c.e.c.v.a aVar, int i2, boolean z, int[] iArr, int[] iArr2) {
        int i3 = aVar.f1375b;
        int iG = z ? aVar.g(i2) : aVar.f(i2);
        int length = iArr.length;
        boolean z2 = z;
        int i4 = 0;
        int i5 = iG;
        while (iG < i3) {
            if (aVar.e(iG) != z2) {
                iArr2[i4] = iArr2[i4] + 1;
            } else {
                if (i4 != length - 1) {
                    i4++;
                } else {
                    if (k.e(iArr2, iArr, 0.7f) < 0.48f) {
                        return new int[]{i5, iG};
                    }
                    i5 += iArr2[0] + iArr2[1];
                    int i6 = i4 - 1;
                    System.arraycopy(iArr2, 2, iArr2, 0, i6);
                    iArr2[i6] = 0;
                    iArr2[i4] = 0;
                    i4 = i6;
                }
                iArr2[i4] = 1;
                z2 = !z2;
            }
            iG++;
        }
        throw c.e.c.k.getNotFoundInstance();
    }

    public static int[] n(c.e.c.v.a aVar) {
        int[] iArr = new int[a.length];
        int[] iArrM = null;
        boolean zI = false;
        int i2 = 0;
        while (!zI) {
            int[] iArr2 = a;
            Arrays.fill(iArr, 0, iArr2.length, 0);
            iArrM = m(aVar, i2, false, iArr2, iArr);
            int i3 = iArrM[0];
            int i4 = iArrM[1];
            int i5 = i3 - (i4 - i3);
            if (i5 >= 0) {
                zI = aVar.i(i5, i3, false);
            }
            i2 = i4;
        }
        return iArrM;
    }

    @Override // c.e.c.y.k
    public c.e.c.p c(int i2, c.e.c.v.a aVar, Map<c.e.c.e, ?> map) {
        return l(i2, aVar, n(aVar), map);
    }

    public boolean h(String str) throws c.e.c.g {
        int length = str.length();
        if (length == 0) {
            return false;
        }
        int i2 = length - 1;
        int iDigit = Character.digit(str.charAt(i2), 10);
        CharSequence charSequenceSubSequence = str.subSequence(0, i2);
        int length2 = charSequenceSubSequence.length();
        int i3 = 0;
        for (int i4 = length2 - 1; i4 >= 0; i4 -= 2) {
            int iCharAt = charSequenceSubSequence.charAt(i4) - '0';
            if (iCharAt < 0 || iCharAt > 9) {
                throw c.e.c.g.getFormatInstance();
            }
            i3 += iCharAt;
        }
        int i5 = i3 * 3;
        while (true) {
            length2 -= 2;
            if (length2 < 0) {
                return (1000 - i5) % 10 == iDigit;
            }
            int iCharAt2 = charSequenceSubSequence.charAt(length2) - '0';
            if (iCharAt2 < 0 || iCharAt2 > 9) {
                break;
            }
            i5 += iCharAt2;
        }
        throw c.e.c.g.getFormatInstance();
    }

    public int[] j(c.e.c.v.a aVar, int i2) {
        int[] iArr = a;
        return m(aVar, i2, false, iArr, new int[iArr.length]);
    }

    public abstract int k(c.e.c.v.a aVar, int[] iArr, StringBuilder sb);

    public c.e.c.p l(int i2, c.e.c.v.a aVar, int[] iArr, Map<c.e.c.e, ?> map) throws c.e.c.k, c.e.c.g, c.e.c.d {
        int length;
        boolean z;
        String str = null;
        s sVar = map == null ? null : (s) map.get(c.e.c.e.NEED_RESULT_POINT_CALLBACK);
        if (sVar != null) {
            sVar.a(new r((iArr[0] + iArr[1]) / 2.0f, i2));
        }
        StringBuilder sb = this.f1473e;
        sb.setLength(0);
        int iK = k(aVar, iArr, sb);
        if (sVar != null) {
            sVar.a(new r(iK, i2));
        }
        int[] iArrJ = j(aVar, iK);
        if (sVar != null) {
            sVar.a(new r((iArrJ[0] + iArrJ[1]) / 2.0f, i2));
        }
        int i3 = iArrJ[1];
        int i4 = (i3 - iArrJ[0]) + i3;
        if (i4 >= aVar.f1375b || !aVar.i(i3, i4, false)) {
            throw c.e.c.k.getNotFoundInstance();
        }
        String string = sb.toString();
        if (string.length() < 8) {
            throw c.e.c.g.getFormatInstance();
        }
        if (!h(string)) {
            throw c.e.c.d.getChecksumInstance();
        }
        c.e.c.a aVarO = o();
        float f2 = i2;
        c.e.c.p pVar = new c.e.c.p(string, null, new r[]{new r((iArr[1] + iArr[0]) / 2.0f, f2), new r((iArrJ[1] + iArrJ[0]) / 2.0f, f2)}, aVarO);
        try {
            c.e.c.p pVarA = this.f1474f.a(i2, aVar, iArrJ[1]);
            pVar.b(c.e.c.q.UPC_EAN_EXTENSION, pVarA.a);
            pVar.a(pVarA.f1358e);
            r[] rVarArr = pVarA.f1356c;
            r[] rVarArr2 = pVar.f1356c;
            if (rVarArr2 == null) {
                pVar.f1356c = rVarArr;
            } else if (rVarArr != null && rVarArr.length > 0) {
                r[] rVarArr3 = new r[rVarArr2.length + rVarArr.length];
                System.arraycopy(rVarArr2, 0, rVarArr3, 0, rVarArr2.length);
                System.arraycopy(rVarArr, 0, rVarArr3, rVarArr2.length, rVarArr.length);
                pVar.f1356c = rVarArr3;
            }
            length = pVarA.a.length();
        } catch (c.e.c.o unused) {
            length = 0;
        }
        int[] iArr2 = map == null ? null : (int[]) map.get(c.e.c.e.ALLOWED_EAN_EXTENSIONS);
        if (iArr2 != null) {
            int length2 = iArr2.length;
            int i5 = 0;
            while (true) {
                if (i5 >= length2) {
                    z = false;
                    break;
                }
                if (length == iArr2[i5]) {
                    z = true;
                    break;
                }
                i5++;
            }
            if (!z) {
                throw c.e.c.k.getNotFoundInstance();
            }
        }
        if (aVarO == c.e.c.a.EAN_13 || aVarO == c.e.c.a.UPC_A) {
            g gVar = this.f1475g;
            gVar.b();
            int i6 = Integer.parseInt(string.substring(0, 3));
            int size = gVar.a.size();
            int i7 = 0;
            while (true) {
                if (i7 < size) {
                    int[] iArr3 = gVar.a.get(i7);
                    int i8 = iArr3[0];
                    if (i6 < i8) {
                        break;
                    }
                    if (iArr3.length != 1) {
                        i8 = iArr3[1];
                    }
                    if (i6 <= i8) {
                        str = gVar.f1459b.get(i7);
                        break;
                    }
                    i7++;
                } else {
                    break;
                }
            }
            if (str != null) {
                pVar.b(c.e.c.q.POSSIBLE_COUNTRY, str);
            }
        }
        return pVar;
    }

    public abstract c.e.c.a o();
}

package c.e.c.y;

import c.e.c.r;
import java.util.EnumMap;

/* JADX INFO: compiled from: UPCEANExtensionSupport.java */
/* JADX INFO: loaded from: classes.dex */
public final class o {
    public static final int[] a = {1, 1, 2};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final m f1468b = new m();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final n f1469c = new n();

    public c.e.c.p a(int i2, c.e.c.v.a aVar, int i3) throws c.e.c.k {
        EnumMap enumMap;
        int[] iArr = a;
        int[] iArrM = p.m(aVar, i3, false, iArr, new int[iArr.length]);
        try {
            return this.f1469c.a(i2, aVar, iArrM);
        } catch (c.e.c.o unused) {
            m mVar = this.f1468b;
            StringBuilder sb = mVar.f1465b;
            sb.setLength(0);
            int[] iArr2 = mVar.a;
            iArr2[0] = 0;
            iArr2[1] = 0;
            iArr2[2] = 0;
            iArr2[3] = 0;
            int i4 = aVar.f1375b;
            int iG = iArrM[1];
            int i5 = 0;
            for (int i6 = 0; i6 < 2 && iG < i4; i6++) {
                int i7 = p.i(aVar, iArr2, iG, p.f1472d);
                sb.append((char) ((i7 % 10) + 48));
                for (int i8 : iArr2) {
                    iG += i8;
                }
                if (i7 >= 10) {
                    i5 |= 1 << (1 - i6);
                }
                if (i6 != 1) {
                    iG = aVar.g(aVar.f(iG));
                }
            }
            if (sb.length() != 2) {
                throw c.e.c.k.getNotFoundInstance();
            }
            if (Integer.parseInt(sb.toString()) % 4 != i5) {
                throw c.e.c.k.getNotFoundInstance();
            }
            String string = sb.toString();
            if (string.length() != 2) {
                enumMap = null;
            } else {
                enumMap = new EnumMap(c.e.c.q.class);
                enumMap.put(c.e.c.q.ISSUE_NUMBER, Integer.valueOf(string));
            }
            float f2 = i2;
            c.e.c.p pVar = new c.e.c.p(string, null, new r[]{new r((iArrM[0] + iArrM[1]) / 2.0f, f2), new r(iG, f2)}, c.e.c.a.UPC_EAN_EXTENSION);
            if (enumMap != null) {
                pVar.a(enumMap);
            }
            return pVar;
        }
    }
}

package c.e.c.y.r;

import c.e.c.k;
import c.e.c.p;
import c.e.c.r;
import c.e.c.s;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.mozilla.javascript.Token;

/* JADX INFO: compiled from: RSS14Reader.java */
/* JADX INFO: loaded from: classes.dex */
public final class e extends a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int[] f1489g = {1, 10, 34, 70, 126};

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int[] f1490h = {4, 20, 48, 81};

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int[] f1491i = {0, Token.DEBUGGER, 961, 2015, 2715};

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int[] f1492j = {0, 336, 1036, 1516};

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int[] f1493k = {8, 6, 4, 3, 1};

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int[] f1494l = {2, 4, 6, 8};
    public static final int[][] m = {new int[]{3, 8, 2, 1}, new int[]{3, 5, 5, 1}, new int[]{3, 3, 7, 1}, new int[]{3, 1, 9, 1}, new int[]{2, 7, 4, 1}, new int[]{2, 5, 6, 1}, new int[]{2, 3, 8, 1}, new int[]{1, 5, 7, 1}, new int[]{1, 3, 9, 1}};
    public final List<d> n = new ArrayList();
    public final List<d> o = new ArrayList();

    public static void l(Collection<d> collection, d dVar) {
        if (dVar == null) {
            return;
        }
        boolean z = false;
        Iterator<d> it = collection.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            d next = it.next();
            if (next.a == dVar.a) {
                next.f1488d++;
                z = true;
                break;
            }
        }
        if (z) {
            return;
        }
        collection.add(dVar);
    }

    @Override // c.e.c.y.k, c.e.c.n
    public void b() {
        this.n.clear();
        this.o.clear();
    }

    @Override // c.e.c.y.k
    public p c(int i2, c.e.c.v.a aVar, Map<c.e.c.e, ?> map) throws k {
        l(this.n, n(aVar, false, i2, map));
        aVar.j();
        l(this.o, n(aVar, true, i2, map));
        aVar.j();
        for (d dVar : this.n) {
            if (dVar.f1488d > 1) {
                for (d dVar2 : this.o) {
                    if (dVar2.f1488d > 1) {
                        int i3 = ((dVar2.f1484b * 16) + dVar.f1484b) % 79;
                        int i4 = (dVar.f1487c.a * 9) + dVar2.f1487c.a;
                        if (i4 > 72) {
                            i4--;
                        }
                        if (i4 > 8) {
                            i4--;
                        }
                        if (i3 == i4) {
                            String strValueOf = String.valueOf((((long) dVar.a) * 4537077) + ((long) dVar2.a));
                            StringBuilder sb = new StringBuilder(14);
                            for (int length = 13 - strValueOf.length(); length > 0; length--) {
                                sb.append('0');
                            }
                            sb.append(strValueOf);
                            int i5 = 0;
                            for (int i6 = 0; i6 < 13; i6++) {
                                int iCharAt = sb.charAt(i6) - '0';
                                if ((i6 & 1) == 0) {
                                    iCharAt *= 3;
                                }
                                i5 += iCharAt;
                            }
                            int i7 = 10 - (i5 % 10);
                            if (i7 == 10) {
                                i7 = 0;
                            }
                            sb.append(i7);
                            r[] rVarArr = dVar.f1487c.f1486c;
                            r[] rVarArr2 = dVar2.f1487c.f1486c;
                            return new p(sb.toString(), null, new r[]{rVarArr[0], rVarArr[1], rVarArr2[0], rVarArr2[1]}, c.e.c.a.RSS_14);
                        }
                    }
                }
            }
        }
        throw k.getNotFoundInstance();
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x00b0 A[PHI: r6 r7
  0x00b0: PHI (r6v6 boolean) = (r6v3 boolean), (r6v20 boolean) binds: [B:52:0x00ae, B:38:0x0094] A[DONT_GENERATE, DONT_INLINE]
  0x00b0: PHI (r7v11 boolean) = (r7v7 boolean), (r7v20 boolean) binds: [B:52:0x00ae, B:38:0x0094] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00b2 A[PHI: r6 r7
  0x00b2: PHI (r6v16 boolean) = (r6v3 boolean), (r6v20 boolean) binds: [B:52:0x00ae, B:38:0x0094] A[DONT_GENERATE, DONT_INLINE]
  0x00b2: PHI (r7v18 boolean) = (r7v7 boolean), (r7v20 boolean) binds: [B:52:0x00ae, B:38:0x0094] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final c.e.c.y.r.b m(c.e.c.v.a r13, c.e.c.y.r.c r14, boolean r15) throws c.e.c.k {
        /*
            Method dump skipped, instruction units count: 466
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c.e.c.y.r.e.m(c.e.c.v.a, c.e.c.y.r.c, boolean):c.e.c.y.r.b");
    }

    public final d n(c.e.c.v.a aVar, boolean z, int i2, Map<c.e.c.e, ?> map) {
        try {
            c cVarP = p(aVar, i2, z, o(aVar, z));
            s sVar = map == null ? null : (s) map.get(c.e.c.e.NEED_RESULT_POINT_CALLBACK);
            if (sVar != null) {
                float f2 = (r1[0] + r1[1]) / 2.0f;
                if (z) {
                    f2 = (aVar.f1375b - 1) - f2;
                }
                sVar.a(new r(f2, i2));
            }
            b bVarM = m(aVar, cVarP, true);
            b bVarM2 = m(aVar, cVarP, false);
            return new d((bVarM.a * 1597) + bVarM2.a, (bVarM2.f1484b * 4) + bVarM.f1484b, cVarP);
        } catch (k unused) {
            return null;
        }
    }

    public final int[] o(c.e.c.v.a aVar, boolean z) throws k {
        int[] iArr = this.a;
        iArr[0] = 0;
        iArr[1] = 0;
        iArr[2] = 0;
        iArr[3] = 0;
        int i2 = aVar.f1375b;
        int i3 = 0;
        boolean z2 = false;
        while (i3 < i2) {
            z2 = !aVar.e(i3);
            if (z == z2) {
                break;
            }
            i3++;
        }
        int i4 = i3;
        int i5 = 0;
        while (i3 < i2) {
            if (aVar.e(i3) != z2) {
                iArr[i5] = iArr[i5] + 1;
            } else {
                if (i5 != 3) {
                    i5++;
                } else {
                    if (a.j(iArr)) {
                        return new int[]{i4, i3};
                    }
                    i4 += iArr[0] + iArr[1];
                    iArr[0] = iArr[2];
                    iArr[1] = iArr[3];
                    iArr[2] = 0;
                    iArr[3] = 0;
                    i5--;
                }
                iArr[i5] = 1;
                z2 = !z2;
            }
            i3++;
        }
        throw k.getNotFoundInstance();
    }

    public final c p(c.e.c.v.a aVar, int i2, boolean z, int[] iArr) throws k {
        int i3;
        int i4;
        boolean zE = aVar.e(iArr[0]);
        int i5 = iArr[0] - 1;
        while (i5 >= 0 && zE != aVar.e(i5)) {
            i5--;
        }
        int i6 = i5 + 1;
        int i7 = iArr[0] - i6;
        int[] iArr2 = this.a;
        System.arraycopy(iArr2, 0, iArr2, 1, iArr2.length - 1);
        iArr2[0] = i7;
        int iK = a.k(iArr2, m);
        int i8 = iArr[1];
        if (z) {
            int i9 = aVar.f1375b;
            i3 = (i9 - 1) - i8;
            i4 = (i9 - 1) - i6;
        } else {
            i3 = i8;
            i4 = i6;
        }
        return new c(iK, new int[]{i6, iArr[1]}, i4, i3, i2);
    }
}

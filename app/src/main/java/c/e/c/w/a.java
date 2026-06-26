package c.e.c.w;

import c.e.c.c;
import c.e.c.e;
import c.e.c.g;
import c.e.c.k;
import c.e.c.n;
import c.e.c.p;
import c.e.c.q;
import c.e.c.r;
import c.e.c.v.b;
import c.e.c.w.b.d;
import c.e.c.w.c.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: DataMatrixReader.java */
/* JADX INFO: loaded from: classes.dex */
public final class a implements n {
    public static final r[] a = new r[0];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f1423b = new d();

    @Override // c.e.c.n
    public p a(c cVar, Map<e, ?> map) throws k, g, c.e.c.d {
        b bVarD;
        r[] rVarArr;
        c.e.c.v.e eVarA;
        if (map == null || !map.containsKey(e.PURE_BARCODE)) {
            c.e.c.w.c.a aVar = new c.e.c.w.c.a(cVar.a());
            r[] rVarArrB = aVar.f1440b.b();
            r rVar = rVarArrB[0];
            r rVar2 = rVarArrB[1];
            r rVar3 = rVarArrB[2];
            r rVar4 = rVarArrB[3];
            ArrayList arrayList = new ArrayList(4);
            arrayList.add(aVar.e(rVar, rVar2));
            arrayList.add(aVar.e(rVar, rVar3));
            arrayList.add(aVar.e(rVar2, rVar4));
            arrayList.add(aVar.e(rVar3, rVar4));
            Collections.sort(arrayList, new a.c(null));
            a.b bVar = (a.b) arrayList.get(0);
            a.b bVar2 = (a.b) arrayList.get(1);
            HashMap map2 = new HashMap();
            c.e.c.w.c.a.b(map2, bVar.a);
            c.e.c.w.c.a.b(map2, bVar.f1441b);
            c.e.c.w.c.a.b(map2, bVar2.a);
            c.e.c.w.c.a.b(map2, bVar2.f1441b);
            r rVar5 = null;
            r rVar6 = null;
            r rVar7 = null;
            for (Map.Entry entry : map2.entrySet()) {
                r rVar8 = (r) entry.getKey();
                if (((Integer) entry.getValue()).intValue() == 2) {
                    rVar6 = rVar8;
                } else if (rVar5 == null) {
                    rVar5 = rVar8;
                } else {
                    rVar7 = rVar8;
                }
            }
            if (rVar5 == null || rVar6 == null || rVar7 == null) {
                throw k.getNotFoundInstance();
            }
            r[] rVarArr2 = {rVar5, rVar6, rVar7};
            r.b(rVarArr2);
            r rVar9 = rVarArr2[0];
            r rVar10 = rVarArr2[1];
            r rVar11 = rVarArr2[2];
            if (map2.containsKey(rVar)) {
                rVar = !map2.containsKey(rVar2) ? rVar2 : !map2.containsKey(rVar3) ? rVar3 : rVar4;
            }
            int i2 = aVar.e(rVar11, rVar).f1442c;
            int i3 = aVar.e(rVar9, rVar).f1442c;
            if ((i2 & 1) == 1) {
                i2++;
            }
            int i4 = i2 + 2;
            if ((i3 & 1) == 1) {
                i3++;
            }
            int i5 = i3 + 2;
            if (i4 * 4 >= i5 * 7 || i5 * 4 >= i4 * 7) {
                float fA = c.e.c.w.c.a.a(rVar10, rVar9) / i4;
                int iA = c.e.c.w.c.a.a(rVar11, rVar);
                float f2 = rVar.a;
                float f3 = iA;
                float f4 = (f2 - rVar11.a) / f3;
                float f5 = rVar.f1359b;
                r rVar12 = new r((f4 * fA) + f2, (fA * ((f5 - rVar11.f1359b) / f3)) + f5);
                float fA2 = c.e.c.w.c.a.a(rVar10, rVar11) / i5;
                int iA2 = c.e.c.w.c.a.a(rVar9, rVar);
                float f6 = rVar.a;
                float f7 = iA2;
                float f8 = (f6 - rVar9.a) / f7;
                float f9 = rVar.f1359b;
                r rVar13 = new r((f8 * fA2) + f6, (fA2 * ((f9 - rVar9.f1359b) / f7)) + f9);
                if (aVar.c(rVar12)) {
                    if (!aVar.c(rVar13) || Math.abs(i5 - aVar.e(rVar9, rVar12).f1442c) + Math.abs(i4 - aVar.e(rVar11, rVar12).f1442c) <= Math.abs(i5 - aVar.e(rVar9, rVar13).f1442c) + Math.abs(i4 - aVar.e(rVar11, rVar13).f1442c)) {
                        rVar13 = rVar12;
                    }
                } else if (!aVar.c(rVar13)) {
                    rVar13 = null;
                }
                if (rVar13 != null) {
                    rVar = rVar13;
                }
                int i6 = aVar.e(rVar11, rVar).f1442c;
                int i7 = aVar.e(rVar9, rVar).f1442c;
                if ((i6 & 1) == 1) {
                    i6++;
                }
                int i8 = i6;
                if ((i7 & 1) == 1) {
                    i7++;
                }
                bVarD = c.e.c.w.c.a.d(aVar.a, rVar11, rVar10, rVar9, rVar, i8, i7);
            } else {
                float fMin = Math.min(i5, i4);
                float fA3 = c.e.c.w.c.a.a(rVar10, rVar9) / fMin;
                int iA3 = c.e.c.w.c.a.a(rVar11, rVar);
                float f10 = rVar.a;
                float f11 = iA3;
                float f12 = (f10 - rVar11.a) / f11;
                float f13 = rVar.f1359b;
                r rVar14 = new r((f12 * fA3) + f10, (fA3 * ((f13 - rVar11.f1359b) / f11)) + f13);
                float fA4 = c.e.c.w.c.a.a(rVar10, rVar11) / fMin;
                int iA4 = c.e.c.w.c.a.a(rVar9, rVar);
                float f14 = rVar.a;
                float f15 = iA4;
                float f16 = (f14 - rVar9.a) / f15;
                float f17 = rVar.f1359b;
                r rVar15 = new r((f16 * fA4) + f14, (fA4 * ((f17 - rVar9.f1359b) / f15)) + f17);
                if (aVar.c(rVar14)) {
                    if (!aVar.c(rVar15) || Math.abs(aVar.e(rVar11, rVar14).f1442c - aVar.e(rVar9, rVar14).f1442c) <= Math.abs(aVar.e(rVar11, rVar15).f1442c - aVar.e(rVar9, rVar15).f1442c)) {
                        rVar15 = rVar14;
                    }
                } else if (!aVar.c(rVar15)) {
                    rVar15 = null;
                }
                if (rVar15 != null) {
                    rVar = rVar15;
                }
                int iMax = Math.max(aVar.e(rVar11, rVar).f1442c, aVar.e(rVar9, rVar).f1442c) + 1;
                if ((iMax & 1) == 1) {
                    iMax++;
                }
                int i9 = iMax;
                bVarD = c.e.c.w.c.a.d(aVar.a, rVar11, rVar10, rVar9, rVar, i9, i9);
            }
            rVarArr = new r[]{rVar11, rVar10, rVar9, rVar};
            eVarA = this.f1423b.a(bVarD);
        } else {
            b bVarA = cVar.a();
            int[] iArrE = bVarA.e();
            int[] iArrC = bVarA.c();
            if (iArrE == null || iArrC == null) {
                throw k.getNotFoundInstance();
            }
            int i10 = bVarA.a;
            int i11 = iArrE[0];
            int i12 = iArrE[1];
            while (i11 < i10 && bVarA.b(i11, i12)) {
                i11++;
            }
            if (i11 == i10) {
                throw k.getNotFoundInstance();
            }
            int i13 = i11 - iArrE[0];
            if (i13 == 0) {
                throw k.getNotFoundInstance();
            }
            int i14 = iArrE[1];
            int i15 = iArrC[1];
            int i16 = iArrE[0];
            int i17 = ((iArrC[0] - i16) + 1) / i13;
            int i18 = ((i15 - i14) + 1) / i13;
            if (i17 <= 0 || i18 <= 0) {
                throw k.getNotFoundInstance();
            }
            int i19 = i13 / 2;
            int i20 = i14 + i19;
            int i21 = i16 + i19;
            b bVar3 = new b(i17, i18);
            for (int i22 = 0; i22 < i18; i22++) {
                int i23 = (i22 * i13) + i20;
                for (int i24 = 0; i24 < i17; i24++) {
                    if (bVarA.b((i24 * i13) + i21, i23)) {
                        bVar3.f(i24, i22);
                    }
                }
            }
            eVarA = this.f1423b.a(bVar3);
            rVarArr = a;
        }
        p pVar = new p(eVarA.f1384c, eVarA.a, rVarArr, c.e.c.a.DATA_MATRIX);
        List<byte[]> list = eVarA.f1385d;
        if (list != null) {
            pVar.b(q.BYTE_SEGMENTS, list);
        }
        String str = eVarA.f1386e;
        if (str != null) {
            pVar.b(q.ERROR_CORRECTION_LEVEL, str);
        }
        return pVar;
    }

    @Override // c.e.c.n
    public void b() {
    }
}

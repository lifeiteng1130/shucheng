package c.e.c.z.d;

import c.e.c.r;

/* JADX INFO: compiled from: PDF417ScanningDecoder.java */
/* JADX INFO: loaded from: classes.dex */
public final class j {
    public static final c.e.c.z.d.k.a a = new c.e.c.z.d.k.a();

    public static c a(h hVar) {
        int[] iArr;
        int i2;
        r rVar;
        r rVar2;
        r rVar3;
        r rVar4;
        if (hVar == null) {
            return null;
        }
        a aVarC = hVar.c();
        if (aVarC == null) {
            iArr = null;
        } else {
            c cVar = hVar.a;
            boolean z = hVar.f1546c;
            r rVar5 = z ? cVar.f1528b : cVar.f1530d;
            r rVar6 = z ? cVar.f1529c : cVar.f1531e;
            int iB = hVar.b((int) rVar6.f1359b);
            d[] dVarArr = hVar.f1545b;
            int i3 = -1;
            int i4 = 0;
            int iMax = 1;
            for (int iB2 = hVar.b((int) rVar5.f1359b); iB2 < iB; iB2++) {
                if (dVarArr[iB2] != null) {
                    d dVar = dVarArr[iB2];
                    dVar.b();
                    int i5 = dVar.f1539e;
                    int i6 = i5 - i3;
                    if (i6 == 0) {
                        i4++;
                    } else {
                        if (i6 == 1) {
                            iMax = Math.max(iMax, i4);
                            i3 = dVar.f1539e;
                        } else if (i5 >= aVarC.f1527e) {
                            dVarArr[iB2] = null;
                        } else {
                            i3 = i5;
                        }
                        i4 = 1;
                    }
                }
            }
            int i7 = aVarC.f1527e;
            iArr = new int[i7];
            for (d dVar2 : hVar.f1545b) {
                if (dVar2 != null && (i2 = dVar2.f1539e) < i7) {
                    iArr[i2] = iArr[i2] + 1;
                }
            }
        }
        if (iArr == null) {
            return null;
        }
        int iMax2 = -1;
        for (int i8 : iArr) {
            iMax2 = Math.max(iMax2, i8);
        }
        int i9 = 0;
        for (int i10 : iArr) {
            i9 += iMax2 - i10;
            if (i10 > 0) {
                break;
            }
        }
        d[] dVarArr2 = hVar.f1545b;
        for (int i11 = 0; i9 > 0 && dVarArr2[i11] == null; i11++) {
            i9--;
        }
        int i12 = 0;
        for (int length = iArr.length - 1; length >= 0; length--) {
            i12 += iMax2 - iArr[length];
            if (iArr[length] > 0) {
                break;
            }
        }
        for (int length2 = dVarArr2.length - 1; i12 > 0 && dVarArr2[length2] == null; length2--) {
            i12--;
        }
        c cVar2 = hVar.a;
        boolean z2 = hVar.f1546c;
        r rVar7 = cVar2.f1528b;
        r rVar8 = cVar2.f1529c;
        r rVar9 = cVar2.f1530d;
        r rVar10 = cVar2.f1531e;
        if (i9 <= 0) {
            rVar = rVar7;
            rVar2 = rVar9;
        } else {
            r rVar11 = z2 ? rVar7 : rVar9;
            r rVar12 = new r(rVar11.a, ((int) rVar11.f1359b) - i9 >= 0 ? r10 : 0);
            if (z2) {
                rVar7 = rVar12;
                rVar = rVar7;
                rVar2 = rVar9;
            } else {
                rVar = rVar7;
                rVar2 = rVar12;
            }
        }
        if (i12 <= 0) {
            rVar3 = rVar8;
            rVar4 = rVar10;
        } else {
            r rVar13 = z2 ? rVar8 : rVar10;
            int i13 = ((int) rVar13.f1359b) + i12;
            int i14 = cVar2.a.f1376b;
            if (i13 >= i14) {
                i13 = i14 - 1;
            }
            r rVar14 = new r(rVar13.a, i13);
            if (z2) {
                rVar8 = rVar14;
                rVar3 = rVar8;
                rVar4 = rVar10;
            } else {
                rVar4 = rVar14;
                rVar3 = rVar8;
            }
        }
        return new c(cVar2.a, rVar, rVar3, rVar2, rVar4);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:177:0x03f2. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:178:0x03f5. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:163:0x03ad A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:256:0x03c4 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:112:0x0294 -> B:113:0x0295). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not found exit edge by exit block: B:173:0x03db
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.checkLoopExits(LoopRegionMaker.java:226)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeLoopRegion(LoopRegionMaker.java:196)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:63)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:89)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:96)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:125)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:89)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeEndlessLoop(LoopRegionMaker.java:282)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:65)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:89)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:102)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.addCases(SwitchRegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.process(SwitchRegionMaker.java:71)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:112)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:96)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:125)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:89)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:96)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:96)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:96)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:96)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeMthRegion(RegionMaker.java:48)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:25)
        */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static c.e.c.v.e b(int[] r25, int r26, int[] r27) {
        /*
            Method dump skipped, instruction units count: 1272
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c.e.c.z.d.j.b(int[], int, int[]):c.e.c.v.e");
    }

    /* JADX WARN: Code restructure failed: missing block: B:115:0x0032, code lost:
    
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x0032, code lost:
    
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x0032, code lost:
    
        continue;
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x001f  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x004c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static c.e.c.z.d.d c(c.e.c.v.b r18, int r19, int r20, boolean r21, int r22, int r23, int r24, int r25) {
        /*
            Method dump skipped, instruction units count: 370
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c.e.c.z.d.j.c(c.e.c.v.b, int, int, boolean, int, int, int, int):c.e.c.z.d.d");
    }

    public static h d(c.e.c.v.b bVar, c cVar, r rVar, boolean z, int i2, int i3) {
        h hVar = new h(cVar, z);
        int i4 = 0;
        while (i4 < 2) {
            int i5 = i4 == 0 ? 1 : -1;
            int i6 = (int) rVar.a;
            for (int i7 = (int) rVar.f1359b; i7 <= cVar.f1535i && i7 >= cVar.f1534h; i7 += i5) {
                d dVarC = c(bVar, 0, bVar.a, z, i6, i7, i2, i3);
                if (dVarC != null) {
                    hVar.f1545b[i7 - hVar.a.f1534h] = dVarC;
                    i6 = z ? dVarC.a : dVarC.f1536b;
                }
            }
            i4++;
        }
        return hVar;
    }

    public static boolean e(f fVar, int i2) {
        return i2 >= 0 && i2 <= fVar.f1544d + 1;
    }
}

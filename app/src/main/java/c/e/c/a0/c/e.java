package c.e.c.a0.c;

import androidx.exifinterface.media.ExifInterface;
import c.e.c.a0.c.j;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: compiled from: Decoder.java */
/* JADX INFO: loaded from: classes.dex */
public final class e {
    public final c.e.c.v.m.c a = new c.e.c.v.m.c(c.e.c.v.m.a.f1413e);

    public c.e.c.v.e a(c.e.c.v.b bVar, Map<c.e.c.e, ?> map) throws c.e.c.g, c.e.c.d {
        c.e.c.d dVar;
        a aVar = new a(bVar);
        try {
            return b(aVar, map);
        } catch (c.e.c.d e2) {
            dVar = e2;
            e = null;
            try {
                aVar.e();
                aVar.f1305b = null;
                aVar.f1306c = null;
                aVar.f1307d = true;
                aVar.d();
                aVar.c();
                aVar.b();
                c.e.c.v.e eVarB = b(aVar, map);
                eVarB.f1387f = new i(true);
                return eVarB;
            } catch (c.e.c.d | c.e.c.g unused) {
                if (e != null) {
                    throw e;
                }
                throw dVar;
            }
        } catch (c.e.c.g e3) {
            e = e3;
            dVar = null;
            aVar.e();
            aVar.f1305b = null;
            aVar.f1306c = null;
            aVar.f1307d = true;
            aVar.d();
            aVar.c();
            aVar.b();
            c.e.c.v.e eVarB2 = b(aVar, map);
            eVarB2.f1387f = new i(true);
            return eVarB2;
        }
    }

    public final c.e.c.v.e b(a aVar, Map<c.e.c.e, ?> map) throws c.e.c.g, c.e.c.d {
        h hVarForBits;
        int iB;
        int i2;
        int i3;
        c.e.c.v.b bVar;
        j jVarD = aVar.d();
        f fVar = aVar.c().f1310b;
        g gVarC = aVar.c();
        j jVarD2 = aVar.d();
        c cVar = c.values()[gVarC.f1311c];
        c.e.c.v.b bVar2 = aVar.a;
        int i4 = bVar2.f1376b;
        cVar.unmaskBitMatrix(bVar2, i4);
        int iC = jVarD2.c();
        c.e.c.v.b bVar3 = new c.e.c.v.b(iC, iC);
        int i5 = 0;
        bVar3.g(0, 0, 9, 9);
        int i6 = iC - 8;
        bVar3.g(i6, 0, 8, 9);
        bVar3.g(0, i6, 9, 8);
        int length = jVarD2.f1314d.length;
        for (int i7 = 0; i7 < length; i7++) {
            int i8 = jVarD2.f1314d[i7] - 2;
            for (int i9 = 0; i9 < length; i9++) {
                if ((i7 != 0 || (i9 != 0 && i9 != length - 1)) && (i7 != length - 1 || i9 != 0)) {
                    bVar3.g(jVarD2.f1314d[i9] - 2, i8, 5, 5);
                }
            }
        }
        int i10 = iC - 17;
        int i11 = 6;
        bVar3.g(6, 9, 1, i10);
        bVar3.g(9, 6, i10, 1);
        if (jVarD2.f1313c > 6) {
            int i12 = iC - 11;
            bVar3.g(i12, 0, 3, 6);
            bVar3.g(0, i12, 6, 3);
        }
        int i13 = jVarD2.f1316f;
        byte[] bArr = new byte[i13];
        int i14 = i4 - 1;
        int i15 = i14;
        int i16 = 0;
        boolean z = true;
        int i17 = 0;
        int i18 = 0;
        while (true) {
            int i19 = 2;
            if (i15 <= 0) {
                break;
            }
            if (i15 == i11) {
                i15--;
            }
            int i20 = 0;
            while (i20 < i4) {
                int i21 = z ? i14 - i20 : i20;
                while (i5 < i19) {
                    int i22 = i15 - i5;
                    if (bVar3.b(i22, i21)) {
                        bVar = bVar3;
                    } else {
                        int i23 = i17 + 1;
                        int i24 = i18 << 1;
                        bVar = bVar3;
                        int i25 = aVar.a.b(i22, i21) ? i24 | 1 : i24;
                        if (i23 == 8) {
                            bArr[i16] = (byte) i25;
                            i16++;
                            i17 = 0;
                            i18 = 0;
                        } else {
                            i18 = i25;
                            i17 = i23;
                        }
                    }
                    i5++;
                    bVar3 = bVar;
                    i19 = 2;
                }
                i20++;
                i5 = 0;
                i19 = 2;
            }
            z = !z;
            i15 -= 2;
            i5 = 0;
            i11 = 6;
        }
        if (i16 != jVarD2.f1316f) {
            throw c.e.c.g.getFormatInstance();
        }
        if (i13 != jVarD.f1316f) {
            throw new IllegalArgumentException();
        }
        j.b bVar4 = jVarD.f1315e[fVar.ordinal()];
        j.a[] aVarArr = bVar4.f1318b;
        int i26 = 0;
        for (j.a aVar2 : aVarArr) {
            i26 += aVar2.a;
        }
        b[] bVarArr = new b[i26];
        int i27 = 0;
        for (j.a aVar3 : aVarArr) {
            int i28 = 0;
            while (i28 < aVar3.a) {
                int i29 = aVar3.f1317b;
                bVarArr[i27] = new b(i29, new byte[bVar4.a + i29]);
                i28++;
                i27++;
            }
        }
        int length2 = bVarArr[0].f1308b.length;
        int i30 = i26 - 1;
        while (i30 >= 0 && bVarArr[i30].f1308b.length != length2) {
            i30--;
        }
        int i31 = i30 + 1;
        int i32 = length2 - bVar4.a;
        int i33 = 0;
        for (int i34 = 0; i34 < i32; i34++) {
            int i35 = 0;
            while (i35 < i27) {
                bVarArr[i35].f1308b[i34] = bArr[i33];
                i35++;
                i33++;
            }
        }
        int i36 = i31;
        while (i36 < i27) {
            bVarArr[i36].f1308b[i32] = bArr[i33];
            i36++;
            i33++;
        }
        int length3 = bVarArr[0].f1308b.length;
        while (i32 < length3) {
            int i37 = 0;
            while (i37 < i27) {
                bVarArr[i37].f1308b[i37 < i31 ? i32 : i32 + 1] = bArr[i33];
                i37++;
                i33++;
            }
            i32++;
        }
        int i38 = 0;
        for (int i39 = 0; i39 < i26; i39++) {
            i38 += bVarArr[i39].a;
        }
        byte[] bArr2 = new byte[i38];
        int i40 = 0;
        for (int i41 = 0; i41 < i26; i41++) {
            b bVar5 = bVarArr[i41];
            byte[] bArr3 = bVar5.f1308b;
            int i42 = bVar5.a;
            int length4 = bArr3.length;
            int[] iArr = new int[length4];
            for (int i43 = 0; i43 < length4; i43++) {
                iArr[i43] = bArr3[i43] & ExifInterface.MARKER;
            }
            try {
                this.a.a(iArr, bArr3.length - i42);
                for (int i44 = 0; i44 < i42; i44++) {
                    bArr3[i44] = (byte) iArr[i44];
                }
                int i45 = 0;
                while (i45 < i42) {
                    bArr2[i40] = bArr3[i45];
                    i45++;
                    i40++;
                }
            } catch (c.e.c.v.m.e unused) {
                throw c.e.c.d.getChecksumInstance();
            }
        }
        char[] cArr = d.a;
        c.e.c.v.c cVar2 = new c.e.c.v.c(bArr2);
        StringBuilder sb = new StringBuilder(50);
        ArrayList arrayList = new ArrayList(1);
        int iB2 = -1;
        int iB3 = -1;
        boolean z2 = false;
        c.e.c.v.d characterSetECIByValue = null;
        do {
            try {
                hVarForBits = cVar2.a() < 4 ? h.TERMINATOR : h.forBits(cVar2.b(4));
                int iOrdinal = hVarForBits.ordinal();
                if (iOrdinal != 0) {
                    if (iOrdinal == 3) {
                        if (cVar2.a() < 16) {
                            throw c.e.c.g.getFormatInstance();
                        }
                        iB2 = cVar2.b(8);
                        iB3 = cVar2.b(8);
                    } else if (iOrdinal == 5) {
                        int iB4 = cVar2.b(8);
                        if ((iB4 & 128) == 0) {
                            i3 = iB4 & 127;
                        } else {
                            if ((iB4 & 192) == 128) {
                                iB = cVar2.b(8);
                                i2 = (iB4 & 63) << 8;
                            } else {
                                if ((iB4 & 224) != 192) {
                                    throw c.e.c.g.getFormatInstance();
                                }
                                iB = cVar2.b(16);
                                i2 = (iB4 & 31) << 16;
                            }
                            i3 = i2 | iB;
                        }
                        characterSetECIByValue = c.e.c.v.d.getCharacterSetECIByValue(i3);
                        if (characterSetECIByValue == null) {
                            throw c.e.c.g.getFormatInstance();
                        }
                    } else if (iOrdinal == 7 || iOrdinal == 8) {
                        z2 = true;
                    } else if (iOrdinal != 9) {
                        int iB5 = cVar2.b(hVarForBits.getCharacterCountBits(jVarD));
                        int iOrdinal2 = hVarForBits.ordinal();
                        if (iOrdinal2 == 1) {
                            d.e(cVar2, sb, iB5);
                        } else if (iOrdinal2 == 2) {
                            d.a(cVar2, sb, iB5, z2);
                        } else if (iOrdinal2 == 4) {
                            d.b(cVar2, sb, iB5, characterSetECIByValue, arrayList, map);
                        } else {
                            if (iOrdinal2 != 6) {
                                throw c.e.c.g.getFormatInstance();
                            }
                            d.d(cVar2, sb, iB5);
                        }
                    } else {
                        int iB6 = cVar2.b(4);
                        int iB7 = cVar2.b(hVarForBits.getCharacterCountBits(jVarD));
                        if (iB6 == 1) {
                            d.c(cVar2, sb, iB7);
                        }
                    }
                }
            } catch (IllegalArgumentException unused2) {
                throw c.e.c.g.getFormatInstance();
            }
        } while (hVarForBits != h.TERMINATOR);
        return new c.e.c.v.e(bArr2, sb.toString(), arrayList.isEmpty() ? null : arrayList, fVar.toString(), iB2, iB3);
    }
}

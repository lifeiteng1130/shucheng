package k.e.a;

import androidx.exifinterface.media.ExifInterface;
import java.util.Objects;
import okio.Utf8;

/* JADX INFO: loaded from: classes3.dex */
public class d {
    public final byte[] a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int[] f8819b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String[] f8820c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f8821d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f8822e;

    public d(byte[] bArr) {
        int length = bArr.length;
        this.a = bArr;
        if (r(6) > 52) {
            throw new IllegalArgumentException();
        }
        int iT = t(8);
        this.f8819b = new int[iT];
        this.f8820c = new String[iT];
        int i2 = 0;
        int i3 = 10;
        int i4 = 1;
        while (i4 < iT) {
            int i5 = i3 + 1;
            this.f8819b[i4] = i5;
            byte b2 = bArr[i3];
            int iT2 = 5;
            if (b2 == 1) {
                iT2 = t(i5) + 3;
                if (iT2 > i2) {
                    i2 = iT2;
                }
            } else if (b2 == 15) {
                iT2 = 4;
            } else if (b2 != 18 && b2 != 3 && b2 != 4) {
                if (b2 != 5 && b2 != 6) {
                    switch (b2) {
                        case 9:
                        case 10:
                        case 11:
                        case 12:
                            break;
                        default:
                            iT2 = 3;
                            break;
                    }
                } else {
                    iT2 = 9;
                    i4++;
                }
            }
            i3 += iT2;
            i4++;
        }
        this.f8821d = i2;
        this.f8822e = i3;
    }

    public final int a(int i2, boolean z, boolean z2, g gVar) {
        int iE;
        int i3;
        int i4;
        char[] cArr = gVar.f8835c;
        n[] nVarArr = gVar.f8840h;
        if (z) {
            int i5 = i2 + 1;
            i3 = this.a[i2] & ExifInterface.MARKER;
            iE = i5;
        } else {
            gVar.f8843k = -1;
            iE = i2;
            i3 = 255;
        }
        gVar.q = 0;
        if (i3 < 64) {
            gVar.o = 3;
            gVar.s = 0;
        } else if (i3 < 128) {
            i3 -= 64;
            iE = e(gVar.t, 0, iE, cArr, nVarArr);
            gVar.o = 4;
            gVar.s = 1;
        } else {
            int iT = t(iE);
            iE += 2;
            if (i3 == 247) {
                int iE2 = e(gVar.t, 0, iE, cArr, nVarArr);
                gVar.o = 4;
                gVar.s = 1;
                iE = iE2;
            } else {
                if (i3 >= 248 && i3 < 251) {
                    gVar.o = 2;
                    int i6 = 251 - i3;
                    gVar.q = i6;
                    i4 = gVar.p - i6;
                } else if (i3 == 251) {
                    gVar.o = 3;
                    gVar.s = 0;
                } else if (i3 < 255) {
                    int i7 = i3 - 251;
                    int i8 = z2 ? gVar.p : 0;
                    int i9 = i7;
                    while (i9 > 0) {
                        iE = e(gVar.r, i8, iE, cArr, nVarArr);
                        i9--;
                        i8++;
                    }
                    gVar.o = 1;
                    gVar.q = i7;
                    i4 = gVar.p + i7;
                } else {
                    gVar.o = 0;
                    int iT2 = t(iE);
                    int iE3 = iE + 2;
                    gVar.q = iT2;
                    gVar.p = iT2;
                    int i10 = 0;
                    while (iT2 > 0) {
                        iE3 = e(gVar.r, i10, iE3, cArr, nVarArr);
                        iT2--;
                        i10++;
                    }
                    int iT3 = t(iE3);
                    iE = iE3 + 2;
                    gVar.s = iT3;
                    int i11 = 0;
                    while (iT3 > 0) {
                        iE = e(gVar.t, i11, iE, cArr, nVarArr);
                        iT3--;
                        i11++;
                    }
                }
                gVar.p = i4;
                gVar.s = 0;
            }
            i3 = iT;
        }
        int i12 = i3 + 1 + gVar.f8843k;
        gVar.f8843k = i12;
        p(i12, nVarArr);
        return iE;
    }

    /* JADX WARN: Removed duplicated region for block: B:99:0x0216  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int b(int r12, char[] r13, java.lang.String r14, k.e.a.a r15) {
        /*
            Method dump skipped, instruction units count: 630
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: k.e.a.d.b(int, char[], java.lang.String, k.e.a.a):int");
    }

    public final int c(int i2, char[] cArr, boolean z, a aVar) {
        int iT = t(i2);
        int iB = i2 + 2;
        if (z) {
            while (iT > 0) {
                iB = b(iB + 2, cArr, s(iB, cArr), aVar);
                iT--;
            }
        } else {
            while (iT > 0) {
                iB = b(iB, cArr, null, aVar);
                iT--;
            }
        }
        if (aVar != null) {
            aVar.g();
        }
        return iB;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0076  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int d(k.e.a.g r9, int r10) {
        /*
            r8 = this;
            int r0 = r8.o(r10)
            int r1 = r0 >>> 24
            r2 = 1
            if (r1 == 0) goto L76
            if (r1 == r2) goto L76
            r3 = 64
            r4 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            if (r1 == r3) goto L30
            r3 = 65
            if (r1 == r3) goto L30
            switch(r1) {
                case 19: goto L22;
                case 20: goto L22;
                case 21: goto L22;
                case 22: goto L76;
                default: goto L18;
            }
        L18:
            switch(r1) {
                case 71: goto L25;
                case 72: goto L25;
                case 73: goto L25;
                case 74: goto L25;
                case 75: goto L25;
                default: goto L1b;
            }
        L1b:
            r3 = 67
            if (r1 >= r3) goto L2c
            r4 = -256(0xffffffffffffff00, float:NaN)
            goto L2c
        L22:
            r0 = r0 & r4
            int r10 = r10 + r2
            goto L7b
        L25:
            r1 = -16776961(0xffffffffff0000ff, float:-1.7014636E38)
            r0 = r0 & r1
            int r10 = r10 + 4
            goto L7b
        L2c:
            r0 = r0 & r4
            int r10 = r10 + 3
            goto L7b
        L30:
            r0 = r0 & r4
            int r1 = r10 + 1
            int r1 = r8.t(r1)
            k.e.a.n[] r3 = new k.e.a.n[r1]
            r9.f8844l = r3
            k.e.a.n[] r3 = new k.e.a.n[r1]
            r9.m = r3
            int[] r3 = new int[r1]
            r9.n = r3
            int r10 = r10 + 3
            r3 = 0
        L46:
            if (r3 >= r1) goto L7b
            int r4 = r8.t(r10)
            int r5 = r10 + 2
            int r5 = r8.t(r5)
            k.e.a.n[] r6 = r9.f8844l
            k.e.a.n[] r7 = r9.f8840h
            k.e.a.n r7 = r8.p(r4, r7)
            r6[r3] = r7
            k.e.a.n[] r6 = r9.m
            int r4 = r4 + r5
            k.e.a.n[] r5 = r9.f8840h
            k.e.a.n r4 = r8.p(r4, r5)
            r6[r3] = r4
            int[] r4 = r9.n
            int r5 = r10 + 4
            int r5 = r8.t(r5)
            r4[r3] = r5
            int r10 = r10 + 6
            int r3 = r3 + 1
            goto L46
        L76:
            r1 = -65536(0xffffffffffff0000, float:NaN)
            r0 = r0 & r1
            int r10 = r10 + 2
        L7b:
            int r1 = r8.l(r10)
            r9.f8841i = r0
            if (r1 != 0) goto L85
            r0 = 0
            goto L8c
        L85:
            k.e.a.s r0 = new k.e.a.s
            byte[] r3 = r8.a
            r0.<init>(r3, r10)
        L8c:
            r9.f8842j = r0
            int r10 = r10 + r2
            int r1 = r1 * 2
            int r1 = r1 + r10
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: k.e.a.d.d(k.e.a.g, int):int");
    }

    public final int e(Object[] objArr, int i2, int i3, char[] cArr, n[] nVarArr) {
        int i4 = i3 + 1;
        switch (this.a[i3] & ExifInterface.MARKER) {
            case 0:
                objArr[i2] = q.a;
                return i4;
            case 1:
                objArr[i2] = q.f8903b;
                return i4;
            case 2:
                objArr[i2] = q.f8904c;
                return i4;
            case 3:
                objArr[i2] = q.f8905d;
                return i4;
            case 4:
                objArr[i2] = q.f8906e;
                return i4;
            case 5:
                objArr[i2] = q.f8907f;
                return i4;
            case 6:
                objArr[i2] = q.f8908g;
                return i4;
            case 7:
                objArr[i2] = m(i4, cArr);
                break;
            default:
                objArr[i2] = p(t(i4), nVarArr);
                break;
        }
        return i4 + 2;
    }

    public final String f(int i2, int i3, char[] cArr) {
        int i4;
        int i5 = i3 + i2;
        byte[] bArr = this.a;
        int i6 = 0;
        char c2 = 0;
        char c3 = 0;
        while (i2 < i5) {
            int i7 = i2 + 1;
            byte b2 = bArr[i2];
            if (c2 == 0) {
                int i8 = b2 & ExifInterface.MARKER;
                if (i8 < 128) {
                    cArr[i6] = (char) i8;
                    i6++;
                } else if (i8 >= 224 || i8 <= 191) {
                    c3 = (char) (i8 & 15);
                    c2 = 2;
                } else {
                    i4 = i8 & 31;
                    c3 = (char) i4;
                    c2 = 1;
                }
            } else if (c2 == 1) {
                cArr[i6] = (char) ((b2 & Utf8.REPLACEMENT_BYTE) | (c3 << 6));
                i6++;
                c2 = 0;
            } else if (c2 == 2) {
                i4 = (b2 & Utf8.REPLACEMENT_BYTE) | (c3 << 6);
                c3 = (char) i4;
                c2 = 1;
            }
            i2 = i7;
        }
        return new String(cArr, 0, i6);
    }

    public final b g(b[] bVarArr, String str, int i2, int i3, char[] cArr, int i4, n[] nVarArr) {
        for (int i5 = 0; i5 < bVarArr.length; i5++) {
            if (bVarArr[i5].a.equals(str)) {
                return bVarArr[i5].d(this, i2, i3);
            }
        }
        b bVar = new b(str);
        byte[] bArr = new byte[i3];
        bVar.f8816b = bArr;
        System.arraycopy(this.a, i2, bArr, 0, i3);
        return bVar;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:217:0x0523. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:269:0x0797  */
    /* JADX WARN: Removed duplicated region for block: B:270:0x079c  */
    /* JADX WARN: Removed duplicated region for block: B:273:0x07dc  */
    /* JADX WARN: Removed duplicated region for block: B:276:0x07fb  */
    /* JADX WARN: Removed duplicated region for block: B:341:0x09b7  */
    /* JADX WARN: Removed duplicated region for block: B:342:0x09d1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void h(k.e.a.o r46, k.e.a.g r47, int r48) {
        /*
            Method dump skipped, instruction units count: 2998
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: k.e.a.d.h(k.e.a.o, k.e.a.g, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x005d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int[] i(k.e.a.o r21, k.e.a.g r22, int r23, boolean r24) {
        /*
            Method dump skipped, instruction units count: 230
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: k.e.a.d.i(k.e.a.o, k.e.a.g, int, boolean):int[]");
    }

    public void j(e eVar, int i2) {
        String str;
        String[] strArr;
        String str2;
        b bVar;
        e eVar2;
        String str3;
        int i3;
        int i4;
        String str4;
        String str5;
        int i5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        String str13;
        String str14;
        String str15;
        int i6;
        String str16;
        String str17;
        int i7;
        int i8;
        int i9;
        String str18;
        int i10;
        String str19;
        String str20;
        String str21;
        String str22;
        String str23;
        String str24;
        String str25;
        String str26;
        String str27;
        int i11;
        int i12;
        int i13;
        b[] bVarArr = new b[0];
        int i14 = this.f8822e;
        char[] cArr = new char[this.f8821d];
        g gVar = new g();
        gVar.a = bVarArr;
        gVar.f8834b = i2;
        gVar.f8835c = cArr;
        int iT = t(i14);
        String strM = m(i14 + 2, cArr);
        String strM2 = m(i14 + 4, cArr);
        int iT2 = t(i14 + 6);
        String[] strArr2 = new String[iT2];
        int i15 = i14 + 8;
        for (int i16 = 0; i16 < iT2; i16++) {
            strArr2[i16] = m(i15, cArr);
            i15 += 2;
        }
        int i17 = this.f8822e;
        int iT3 = (t(i17 + 6) * 2) + i17 + 8;
        for (int iT4 = t(iT3); iT4 > 0; iT4--) {
            for (int iT5 = t(iT3 + 8); iT5 > 0; iT5--) {
                iT3 += o(iT3 + 12) + 6;
            }
            iT3 += 8;
        }
        int iO = iT3 + 2;
        for (int iT6 = t(iO); iT6 > 0; iT6--) {
            for (int iT7 = t(iO + 8); iT7 > 0; iT7--) {
                iO += o(iO + 12) + 6;
            }
            iO += 8;
        }
        int i18 = iO + 2;
        int iO2 = i18;
        int i19 = iT;
        int iT8 = t(i18);
        String strF = null;
        String strS = null;
        int i20 = 0;
        b bVar2 = null;
        String strS2 = null;
        String strS3 = null;
        String str28 = null;
        String strS4 = null;
        int i21 = 0;
        int i22 = 0;
        int i23 = 0;
        int i24 = 0;
        while (true) {
            str = "RuntimeInvisibleAnnotations";
            strArr = strArr2;
            str2 = strS2;
            bVar = bVar2;
            if (iT8 <= 0) {
                break;
            }
            String strS5 = s(iO2 + 2, cArr);
            String str29 = strF;
            if ("SourceFile".equals(strS5)) {
                strS2 = s(iO2 + 8, cArr);
            } else {
                if ("InnerClasses".equals(strS5)) {
                    i24 = iO2 + 8;
                } else if ("EnclosingMethod".equals(strS5)) {
                    String strM3 = m(iO2 + 8, cArr);
                    int iT9 = t(iO2 + 10);
                    if (iT9 != 0) {
                        strS4 = s(this.f8819b[iT9], cArr);
                        strS = s(this.f8819b[iT9] + 2, cArr);
                    }
                    str28 = strM3;
                } else if ("Signature".equals(strS5)) {
                    strS3 = s(iO2 + 8, cArr);
                } else if ("RuntimeVisibleAnnotations".equals(strS5)) {
                    i20 = iO2 + 8;
                    strS2 = str2;
                } else if ("RuntimeVisibleTypeAnnotations".equals(strS5)) {
                    i22 = iO2 + 8;
                } else {
                    if ("Deprecated".equals(strS5)) {
                        i13 = i19 | 131072;
                    } else if ("Synthetic".equals(strS5)) {
                        i13 = i19 | 266240;
                    } else if ("SourceDebugExtension".equals(strS5)) {
                        int iO3 = o(iO2 + 4);
                        strF = f(iO2 + 8, iO3, new char[iO3]);
                        strS2 = str2;
                        bVar2 = bVar;
                        iO2 = o(iO2 + 4) + 6 + iO2;
                        iT8--;
                        strArr2 = strArr;
                    } else if ("RuntimeInvisibleAnnotations".equals(strS5)) {
                        i21 = iO2 + 8;
                    } else if ("RuntimeInvisibleTypeAnnotations".equals(strS5)) {
                        i23 = iO2 + 8;
                    } else if ("BootstrapMethods".equals(strS5)) {
                        int iT10 = t(iO2 + 8);
                        int[] iArr = new int[iT10];
                        int iT11 = iO2 + 10;
                        for (int i25 = 0; i25 < iT10; i25++) {
                            iArr[i25] = iT11;
                            iT11 += (t(iT11 + 2) + 2) << 1;
                        }
                        gVar.f8836d = iArr;
                    } else {
                        b bVarG = g(bVarArr, strS5, iO2 + 8, o(iO2 + 4), cArr, -1, null);
                        bVarG.f8817c = bVar;
                        bVar2 = bVarG;
                        strF = str29;
                        strS = strS;
                        i20 = i20;
                        strS2 = str2;
                        iO2 = o(iO2 + 4) + 6 + iO2;
                        iT8--;
                        strArr2 = strArr;
                    }
                    i19 = i13;
                }
                strF = str29;
                strS2 = str2;
                bVar2 = bVar;
                iO2 = o(iO2 + 4) + 6 + iO2;
                iT8--;
                strArr2 = strArr;
            }
            strF = str29;
            bVar2 = bVar;
            iO2 = o(iO2 + 4) + 6 + iO2;
            iT8--;
            strArr2 = strArr;
        }
        String str30 = strF;
        String str31 = strS;
        int i26 = i20;
        int i27 = i19;
        String str32 = "RuntimeInvisibleTypeAnnotations";
        String str33 = "Signature";
        String str34 = "RuntimeVisibleAnnotations";
        String str35 = "RuntimeVisibleTypeAnnotations";
        eVar.a(o(this.f8819b[1] - 7), i27, strM, strS3, strM2, strArr);
        String str36 = "Deprecated";
        if ((i2 & 2) != 0 || (str2 == null && str30 == null)) {
            eVar2 = eVar;
            str3 = "Synthetic";
        } else {
            eVar2 = eVar;
            str3 = "Synthetic";
            f fVar = (f) eVar2;
            if (str2 != null) {
                fVar.t = fVar.v(str2);
            }
            if (str30 != null) {
                c cVar = new c();
                cVar.d(str30, 0, Integer.MAX_VALUE);
                fVar.u = cVar;
            }
        }
        String str37 = str28;
        if (str37 != null) {
            f fVar2 = (f) eVar2;
            fVar2.v = fVar2.l(str37).a;
            String str38 = strS4;
            if (str38 != null && str31 != null) {
                fVar2.w = fVar2.u(str38, str31);
            }
        }
        if (i26 != 0) {
            int iC = i26 + 2;
            for (int iT12 = t(i26); iT12 > 0; iT12--) {
                iC = c(iC + 2, cArr, true, eVar2.b(s(iC, cArr), true));
            }
        }
        int i28 = i21;
        if (i28 != 0) {
            int iC2 = i28 + 2;
            for (int iT13 = t(i28); iT13 > 0; iT13--) {
                iC2 = c(iC2 + 2, cArr, true, eVar2.b(s(iC2, cArr), false));
            }
        }
        int i29 = i22;
        if (i29 != 0) {
            int iC3 = i29 + 2;
            for (int iT14 = t(i29); iT14 > 0; iT14--) {
                int iD = d(gVar, iC3);
                iC3 = c(iD + 2, cArr, true, eVar2.d(gVar.f8841i, gVar.f8842j, s(iD, cArr), true));
            }
        }
        int i30 = i23;
        if (i30 != 0) {
            int iC4 = i30 + 2;
            for (int iT15 = t(i30); iT15 > 0; iT15--) {
                int iD2 = d(gVar, iC4);
                iC4 = c(iD2 + 2, cArr, true, eVar2.d(gVar.f8841i, gVar.f8842j, s(iD2, cArr), false));
            }
        }
        b bVar3 = bVar;
        while (bVar3 != null) {
            b bVar4 = bVar3.f8817c;
            bVar3.f8817c = null;
            f fVar3 = (f) eVar2;
            bVar3.f8817c = fVar3.B;
            fVar3.B = bVar3;
            bVar3 = bVar4;
        }
        int i31 = i24;
        if (i31 != 0) {
            int i32 = i31 + 2;
            int iT16 = t(i31);
            int i33 = i32;
            while (iT16 > 0) {
                String strM4 = m(i33, cArr);
                String strM5 = m(i33 + 2, cArr);
                String strS6 = s(i33 + 4, cArr);
                int iT17 = t(i33 + 6);
                f fVar4 = (f) eVar2;
                if (fVar4.D == null) {
                    fVar4.D = new c();
                }
                m mVarL = fVar4.l(strM4);
                if (mVarL.f8875c == 0) {
                    fVar4.C++;
                    fVar4.D.i(mVarL.a);
                    fVar4.D.i(strM5 == null ? 0 : fVar4.l(strM5).a);
                    fVar4.D.i(strS6 == null ? 0 : fVar4.v(strS6));
                    fVar4.D.i(iT17);
                    mVarL.f8875c = fVar4.C;
                }
                i33 += 8;
                iT16--;
                eVar2 = eVar;
            }
        }
        int i34 = (iT2 * 2) + this.f8822e + 10;
        int iT18 = t(i34 - 2);
        while (iT18 > 0) {
            char[] cArr2 = gVar.f8835c;
            int iT19 = t(i34);
            String strS7 = s(i34 + 2, cArr2);
            String strS8 = s(i34 + 4, cArr2);
            int i35 = i34 + 6;
            int i36 = iT19;
            int iT20 = t(i35);
            int iO4 = i35;
            int i37 = 0;
            int i38 = 0;
            int i39 = 0;
            int i40 = 0;
            b bVar5 = null;
            String strS9 = null;
            Object objN = null;
            while (iT20 > 0) {
                String strS10 = s(iO4 + 2, cArr2);
                if ("ConstantValue".equals(strS10)) {
                    int iT21 = t(iO4 + 8);
                    if (iT21 == 0) {
                        str18 = str34;
                        objN = null;
                        i10 = i40;
                        str19 = str35;
                        str22 = str18;
                        str23 = str3;
                        str20 = str36;
                        str25 = str19;
                        str26 = str33;
                        str27 = str32;
                        i40 = i10;
                        str24 = str;
                    } else {
                        objN = n(iT21, cArr2);
                        str18 = str34;
                        i10 = i40;
                        str19 = str35;
                        str22 = str18;
                        str23 = str3;
                        str20 = str36;
                        str25 = str19;
                        str26 = str33;
                        str27 = str32;
                        i40 = i10;
                        str24 = str;
                    }
                } else {
                    if (str33.equals(strS10)) {
                        strS9 = s(iO4 + 8, cArr2);
                    } else {
                        if (str36.equals(strS10)) {
                            i12 = 131072;
                        } else if (str3.equals(strS10)) {
                            i12 = 266240;
                        } else {
                            str18 = str34;
                            if (str18.equals(strS10)) {
                                i37 = iO4 + 8;
                                i10 = i40;
                                str19 = str35;
                                str22 = str18;
                                str23 = str3;
                                str20 = str36;
                                str25 = str19;
                                str26 = str33;
                                str27 = str32;
                                i40 = i10;
                                str24 = str;
                            } else {
                                i10 = i40;
                                str19 = str35;
                                if (str19.equals(strS10)) {
                                    i39 = iO4 + 8;
                                    i11 = i10;
                                    str20 = str36;
                                    str21 = str32;
                                } else if (str.equals(strS10)) {
                                    i38 = iO4 + 8;
                                    str22 = str18;
                                    str23 = str3;
                                    str20 = str36;
                                    str25 = str19;
                                    str26 = str33;
                                    str27 = str32;
                                    i40 = i10;
                                    str24 = str;
                                } else {
                                    str20 = str36;
                                    str21 = str32;
                                    if (str21.equals(strS10)) {
                                        i11 = iO4 + 8;
                                    } else {
                                        str22 = str18;
                                        str23 = str3;
                                        str24 = str;
                                        str25 = str19;
                                        str26 = str33;
                                        str27 = str21;
                                        b bVarG2 = g(gVar.a, strS10, iO4 + 8, o(iO4 + 4), cArr2, -1, null);
                                        bVarG2.f8817c = bVar5;
                                        bVar5 = bVarG2;
                                        i40 = i10;
                                        i37 = i37;
                                        i38 = i38;
                                        i39 = i39;
                                    }
                                }
                                str22 = str18;
                                str23 = str3;
                                str27 = str21;
                                str25 = str19;
                                str24 = str;
                                str26 = str33;
                                i40 = i11;
                            }
                        }
                        i36 |= i12;
                    }
                    str18 = str34;
                    i10 = i40;
                    str19 = str35;
                    str22 = str18;
                    str23 = str3;
                    str20 = str36;
                    str25 = str19;
                    str26 = str33;
                    str27 = str32;
                    i40 = i10;
                    str24 = str;
                }
                iO4 = o(iO4 + 4) + 6 + iO4;
                iT20--;
                str33 = str26;
                str = str24;
                str36 = str20;
                str34 = str22;
                str3 = str23;
                str32 = str27;
                str35 = str25;
            }
            String str39 = str3;
            int i41 = i38;
            int i42 = i39;
            String str40 = str36;
            String str41 = str33;
            String str42 = str32;
            String str43 = str34;
            String str44 = str35;
            String str45 = str;
            int i43 = i40;
            i34 = iO4 + 2;
            i iVar = new i((f) eVar, i36, strS7, strS8, strS9, objN);
            if (i37 != 0) {
                int iC5 = i37 + 2;
                for (int iT22 = t(i37); iT22 > 0; iT22--) {
                    iC5 = c(iC5 + 2, cArr2, true, iVar.a(s(iC5, cArr2), true));
                }
            }
            if (i41 != 0) {
                int iC6 = i41 + 2;
                for (int iT23 = t(i41); iT23 > 0; iT23--) {
                    iC6 = c(iC6 + 2, cArr2, true, iVar.a(s(iC6, cArr2), false));
                }
            }
            if (i42 != 0) {
                int iC7 = i42 + 2;
                for (int iT24 = t(i42); iT24 > 0; iT24--) {
                    int iD3 = d(gVar, iC7);
                    iC7 = c(iD3 + 2, cArr2, true, iVar.b(gVar.f8841i, gVar.f8842j, s(iD3, cArr2), true));
                }
            }
            if (i43 != 0) {
                int iC8 = i43 + 2;
                for (int iT25 = t(i43); iT25 > 0; iT25--) {
                    int iD4 = d(gVar, iC8);
                    iC8 = c(iD4 + 2, cArr2, true, iVar.b(gVar.f8841i, gVar.f8842j, s(iD4, cArr2), false));
                }
            }
            while (bVar5 != null) {
                b bVar6 = bVar5.f8817c;
                bVar5.f8817c = null;
                bVar5.f8817c = iVar.f8857l;
                iVar.f8857l = bVar5;
                bVar5 = bVar6;
            }
            iT18--;
            str33 = str41;
            str = str45;
            str36 = str40;
            str34 = str43;
            str3 = str39;
            str32 = str42;
            str35 = str44;
        }
        String str46 = str3;
        String str47 = str36;
        String str48 = str33;
        String str49 = str32;
        String str50 = str34;
        String str51 = str35;
        String str52 = str;
        int i44 = i34 + 2;
        int iT26 = t(i44 - 2);
        while (iT26 > 0) {
            char[] cArr3 = gVar.f8835c;
            gVar.f8837e = t(i44);
            gVar.f8838f = s(i44 + 2, cArr3);
            gVar.f8839g = s(i44 + 4, cArr3);
            int i45 = i44 + 6;
            int iT27 = t(i45);
            int iO5 = i45;
            int i46 = 0;
            int i47 = 0;
            int i48 = 0;
            int i49 = 0;
            int i50 = 0;
            b bVar7 = null;
            int i51 = 0;
            int i52 = 0;
            int i53 = 0;
            String strS11 = null;
            String[] strArr3 = null;
            int i54 = 0;
            while (iT27 > 0) {
                String strS12 = s(iO5 + 2, cArr3);
                int i55 = i46;
                if ("Code".equals(strS12)) {
                    if ((gVar.f8834b & 1) == 0) {
                        i53 = iO5 + 8;
                        str15 = str48;
                        str14 = str47;
                        str12 = str50;
                        str13 = str46;
                        str17 = str49;
                        str16 = str51;
                        i46 = i55;
                        i6 = iT26;
                        iO5 = o(iO5 + 4) + 6 + iO5;
                        iT27--;
                        iT26 = i6;
                        str49 = str17;
                        str47 = str14;
                        str48 = str15;
                        str51 = str16;
                        str46 = str13;
                        str50 = str12;
                    } else {
                        i3 = i47;
                        i4 = i48;
                        str4 = str48;
                        str5 = str47;
                        str7 = str50;
                        str8 = str46;
                        i5 = i52;
                        str6 = str51;
                    }
                } else if ("Exceptions".equals(strS12)) {
                    int iT28 = t(iO5 + 8);
                    String[] strArr4 = new String[iT28];
                    i3 = i47;
                    i4 = i48;
                    int i56 = iO5 + 10;
                    for (int i57 = 0; i57 < iT28; i57++) {
                        strArr4[i57] = m(i56, cArr3);
                        i56 += 2;
                    }
                    strArr3 = strArr4;
                    str4 = str48;
                    str5 = str47;
                    str7 = str50;
                    str8 = str46;
                    i5 = i52;
                    str6 = str51;
                } else {
                    i3 = i47;
                    i4 = i48;
                    str4 = str48;
                    if (str4.equals(strS12)) {
                        strS11 = s(iO5 + 8, cArr3);
                        i5 = i52;
                        str5 = str47;
                        str7 = str50;
                        str6 = str51;
                    } else {
                        str5 = str47;
                        if (str5.equals(strS12)) {
                            i8 = gVar.f8837e;
                            i5 = i52;
                            str7 = str50;
                            str8 = str46;
                            str6 = str51;
                            i9 = 131072;
                        } else {
                            String str53 = str50;
                            if (str53.equals(strS12)) {
                                str7 = str53;
                                i5 = i52;
                                i46 = iO5 + 8;
                                str11 = str49;
                                str9 = str51;
                                i6 = iT26;
                                str12 = str7;
                                str16 = str9;
                                str13 = str46;
                                int i58 = i3;
                                str14 = str5;
                                i47 = i58;
                                int i59 = i4;
                                str15 = str4;
                                i48 = i59;
                                int i60 = i5;
                                str17 = str11;
                                i52 = i60;
                                iO5 = o(iO5 + 4) + 6 + iO5;
                                iT27--;
                                iT26 = i6;
                                str49 = str17;
                                str47 = str14;
                                str48 = str15;
                                str51 = str16;
                                str46 = str13;
                                str50 = str12;
                            } else {
                                i5 = i52;
                                str6 = str51;
                                if (str6.equals(strS12)) {
                                    i49 = iO5 + 8;
                                    str7 = str53;
                                } else {
                                    str7 = str53;
                                    if ("AnnotationDefault".equals(strS12)) {
                                        i4 = iO5 + 8;
                                    } else {
                                        str8 = str46;
                                        if (str8.equals(strS12)) {
                                            i8 = gVar.f8837e;
                                            i9 = 266240;
                                        } else {
                                            str9 = str6;
                                            str10 = str52;
                                            if (str10.equals(strS12)) {
                                                i7 = iO5 + 8;
                                                str46 = str8;
                                                str52 = str10;
                                                i3 = i7;
                                                str11 = str49;
                                                i46 = i55;
                                                i6 = iT26;
                                                str12 = str7;
                                                str16 = str9;
                                                str13 = str46;
                                                int i582 = i3;
                                                str14 = str5;
                                                i47 = i582;
                                                int i592 = i4;
                                                str15 = str4;
                                                i48 = i592;
                                                int i602 = i5;
                                                str17 = str11;
                                                i52 = i602;
                                                iO5 = o(iO5 + 4) + 6 + iO5;
                                                iT27--;
                                                iT26 = i6;
                                                str49 = str17;
                                                str47 = str14;
                                                str48 = str15;
                                                str51 = str16;
                                                str46 = str13;
                                                str50 = str12;
                                            } else {
                                                str52 = str10;
                                                str11 = str49;
                                                if (str11.equals(strS12)) {
                                                    i50 = iO5 + 8;
                                                    str46 = str8;
                                                } else {
                                                    str46 = str8;
                                                    if ("RuntimeVisibleParameterAnnotations".equals(strS12)) {
                                                        i51 = iO5 + 8;
                                                    } else if ("RuntimeInvisibleParameterAnnotations".equals(strS12)) {
                                                        i5 = iO5 + 8;
                                                    } else if ("MethodParameters".equals(strS12)) {
                                                        i54 = iO5 + 8;
                                                    } else {
                                                        str12 = str7;
                                                        str13 = str46;
                                                        str14 = str5;
                                                        str15 = str4;
                                                        i6 = iT26;
                                                        str16 = str9;
                                                        str17 = str11;
                                                        b bVarG3 = g(gVar.a, strS12, iO5 + 8, o(iO5 + 4), cArr3, -1, null);
                                                        bVarG3.f8817c = bVar7;
                                                        bVar7 = bVarG3;
                                                        i51 = i51;
                                                        i52 = i5;
                                                        i49 = i49;
                                                        i53 = i53;
                                                        i46 = i55;
                                                        i47 = i3;
                                                        i48 = i4;
                                                        i50 = i50;
                                                        iO5 = o(iO5 + 4) + 6 + iO5;
                                                        iT27--;
                                                        iT26 = i6;
                                                        str49 = str17;
                                                        str47 = str14;
                                                        str48 = str15;
                                                        str51 = str16;
                                                        str46 = str13;
                                                        str50 = str12;
                                                    }
                                                }
                                                i46 = i55;
                                                i6 = iT26;
                                                str12 = str7;
                                                str16 = str9;
                                                str13 = str46;
                                                int i5822 = i3;
                                                str14 = str5;
                                                i47 = i5822;
                                                int i5922 = i4;
                                                str15 = str4;
                                                i48 = i5922;
                                                int i6022 = i5;
                                                str17 = str11;
                                                i52 = i6022;
                                                iO5 = o(iO5 + 4) + 6 + iO5;
                                                iT27--;
                                                iT26 = i6;
                                                str49 = str17;
                                                str47 = str14;
                                                str48 = str15;
                                                str51 = str16;
                                                str46 = str13;
                                                str50 = str12;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        gVar.f8837e = i8 | i9;
                    }
                    str9 = str6;
                    str10 = str52;
                    i7 = i3;
                    str8 = str46;
                    str46 = str8;
                    str52 = str10;
                    i3 = i7;
                    str11 = str49;
                    i46 = i55;
                    i6 = iT26;
                    str12 = str7;
                    str16 = str9;
                    str13 = str46;
                    int i58222 = i3;
                    str14 = str5;
                    i47 = i58222;
                    int i59222 = i4;
                    str15 = str4;
                    i48 = i59222;
                    int i60222 = i5;
                    str17 = str11;
                    i52 = i60222;
                    iO5 = o(iO5 + 4) + 6 + iO5;
                    iT27--;
                    iT26 = i6;
                    str49 = str17;
                    str47 = str14;
                    str48 = str15;
                    str51 = str16;
                    str46 = str13;
                    str50 = str12;
                }
                str9 = str6;
                str10 = str52;
                i7 = i3;
                str46 = str8;
                str52 = str10;
                i3 = i7;
                str11 = str49;
                i46 = i55;
                i6 = iT26;
                str12 = str7;
                str16 = str9;
                str13 = str46;
                int i582222 = i3;
                str14 = str5;
                i47 = i582222;
                int i592222 = i4;
                str15 = str4;
                i48 = i592222;
                int i602222 = i5;
                str17 = str11;
                i52 = i602222;
                iO5 = o(iO5 + 4) + 6 + iO5;
                iT27--;
                iT26 = i6;
                str49 = str17;
                str47 = str14;
                str48 = str15;
                str51 = str16;
                str46 = str13;
                str50 = str12;
            }
            int i61 = i46;
            int i62 = i47;
            int i63 = i48;
            int i64 = i49;
            int i65 = i50;
            int i66 = iT26;
            int i67 = i53;
            String str54 = str48;
            String str55 = str47;
            String str56 = str50;
            String str57 = str46;
            String str58 = str49;
            String str59 = str51;
            int i68 = i51;
            int i69 = i52;
            b bVar8 = bVar7;
            i44 = iO5 + 2;
            o oVarC = eVar.c(gVar.f8837e, gVar.f8838f, gVar.f8839g, strS11, strArr3);
            p pVar = (p) oVarC;
            Objects.requireNonNull(pVar.f8893c);
            if (i54 != 0) {
                int i70 = this.a[i54] & ExifInterface.MARKER;
                int i71 = i54 + 1;
                while (i70 > 0) {
                    String strS13 = s(i71, cArr3);
                    int iT29 = t(i71 + 2);
                    if (pVar.G == null) {
                        pVar.G = new c();
                    }
                    pVar.F++;
                    c cVar2 = pVar.G;
                    cVar2.i(strS13 == null ? 0 : pVar.f8893c.v(strS13));
                    cVar2.i(iT29);
                    i70--;
                    i71 += 4;
                }
            }
            if (i63 != 0) {
                c cVar3 = new c();
                pVar.f8901k = cVar3;
                a aVar = new a(pVar.f8893c, false, cVar3, null, 0);
                b(i63, cArr3, null, aVar);
                aVar.g();
            }
            if (i61 != 0) {
                int iC9 = i61 + 2;
                for (int iT30 = t(i61); iT30 > 0; iT30--) {
                    iC9 = c(iC9 + 2, cArr3, true, oVarC.a(s(iC9, cArr3), true));
                }
            }
            if (i62 != 0) {
                int iC10 = i62 + 2;
                for (int iT31 = t(i62); iT31 > 0; iT31--) {
                    iC10 = c(iC10 + 2, cArr3, true, oVarC.a(s(iC10, cArr3), false));
                }
            }
            if (i64 != 0) {
                int iC11 = i64 + 2;
                for (int iT32 = t(i64); iT32 > 0; iT32--) {
                    int iD5 = d(gVar, iC11);
                    iC11 = c(iD5 + 2, cArr3, true, oVarC.s(gVar.f8841i, gVar.f8842j, s(iD5, cArr3), true));
                }
            }
            if (i65 != 0) {
                int iC12 = i65 + 2;
                for (int iT33 = t(i65); iT33 > 0; iT33--) {
                    int iD6 = d(gVar, iC12);
                    iC12 = c(iD6 + 2, cArr3, true, oVarC.s(gVar.f8841i, gVar.f8842j, s(iD6, cArr3), false));
                }
            }
            if (i68 != 0) {
                k(oVarC, gVar, i68, true);
            }
            if (i69 != 0) {
                k(oVarC, gVar, i69, false);
            }
            while (bVar8 != null) {
                b bVar9 = bVar8.f8817c;
                bVar8.f8817c = null;
                bVar8.f8817c = pVar.s;
                pVar.s = bVar8;
                bVar8 = bVar9;
            }
            if (i67 != 0) {
                h(oVarC, gVar, i67);
            }
            iT26 = i66 - 1;
            str49 = str58;
            str47 = str55;
            str48 = str54;
            str51 = str59;
            str46 = str57;
            str50 = str56;
        }
    }

    public final void k(o oVar, g gVar, int i2, boolean z) {
        int iC = i2 + 1;
        int i3 = this.a[i2] & ExifInterface.MARKER;
        int length = r.c(gVar.f8839g).length - i3;
        int i4 = 0;
        while (i4 < length) {
            oVar.q(i4, "Ljava/lang/Synthetic;", false).g();
            i4++;
        }
        char[] cArr = gVar.f8835c;
        while (i4 < i3 + length) {
            iC += 2;
            for (int iT = t(iC); iT > 0; iT--) {
                iC = c(iC + 2, cArr, true, oVar.q(i4, s(iC, cArr), z));
            }
            i4++;
        }
    }

    public int l(int i2) {
        return this.a[i2] & ExifInterface.MARKER;
    }

    public String m(int i2, char[] cArr) {
        return s(this.f8819b[t(i2)], cArr);
    }

    public Object n(int i2, char[] cArr) {
        int i3 = this.f8819b[i2];
        byte b2 = this.a[i3 - 1];
        if (b2 == 16) {
            return r.a(s(i3, cArr).toCharArray(), 0);
        }
        switch (b2) {
            case 3:
                return new Integer(o(i3));
            case 4:
                return new Float(Float.intBitsToFloat(o(i3)));
            case 5:
                return new Long(q(i3));
            case 6:
                return new Double(Double.longBitsToDouble(q(i3)));
            case 7:
                char[] charArray = s(i3, cArr).toCharArray();
                return new r(charArray[0] == '[' ? 9 : 10, charArray, 0, charArray.length);
            case 8:
                return s(i3, cArr);
            default:
                int iL = l(i3);
                int[] iArr = this.f8819b;
                int i4 = iArr[t(i3 + 1)];
                String strM = m(i4, cArr);
                int i5 = iArr[t(i4 + 2)];
                return new k(iL, strM, s(i5, cArr), s(i5 + 2, cArr));
        }
    }

    public int o(int i2) {
        byte[] bArr = this.a;
        return (bArr[i2 + 3] & ExifInterface.MARKER) | ((bArr[i2] & ExifInterface.MARKER) << 24) | ((bArr[i2 + 1] & ExifInterface.MARKER) << 16) | ((bArr[i2 + 2] & ExifInterface.MARKER) << 8);
    }

    public n p(int i2, n[] nVarArr) {
        if (nVarArr[i2] == null) {
            nVarArr[i2] = new n();
        }
        return nVarArr[i2];
    }

    public long q(int i2) {
        return (((long) o(i2)) << 32) | (((long) o(i2 + 4)) & 4294967295L);
    }

    public short r(int i2) {
        byte[] bArr = this.a;
        return (short) ((bArr[i2 + 1] & ExifInterface.MARKER) | ((bArr[i2] & ExifInterface.MARKER) << 8));
    }

    public String s(int i2, char[] cArr) {
        int iT = t(i2);
        if (i2 == 0 || iT == 0) {
            return null;
        }
        String[] strArr = this.f8820c;
        String str = strArr[iT];
        if (str != null) {
            return str;
        }
        int i3 = this.f8819b[iT];
        String strF = f(i3 + 2, t(i3), cArr);
        strArr[iT] = strF;
        return strF;
    }

    public int t(int i2) {
        byte[] bArr = this.a;
        return (bArr[i2 + 1] & ExifInterface.MARKER) | ((bArr[i2] & ExifInterface.MARKER) << 8);
    }
}

package c.e.c.u.d;

import c.b.a.m.f;
import c.e.c.k;
import c.e.c.r;
import c.e.c.v.b;
import c.e.c.v.j;
import c.e.c.v.m.c;
import c.e.c.v.m.e;

/* JADX INFO: compiled from: Detector.java */
/* JADX INFO: loaded from: classes.dex */
public final class a {
    public static final int[] a = {3808, 476, 2107, 1799};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f1368b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f1369c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f1370d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f1371e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f1372f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f1373g;

    /* JADX INFO: renamed from: c.e.c.u.d.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: Detector.java */
    public static final class C0051a {
        public final int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f1374b;

        public C0051a(int i2, int i3) {
            this.a = i2;
            this.f1374b = i3;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("<");
            sb.append(this.a);
            sb.append(' ');
            return c.a.a.a.a.n(sb, this.f1374b, '>');
        }
    }

    public a(b bVar) {
        this.f1368b = bVar;
    }

    public static r[] b(r[] rVarArr, int i2, int i3) {
        float f2 = i3 / (i2 * 2.0f);
        float f3 = rVarArr[0].a - rVarArr[2].a;
        float f4 = rVarArr[0].f1359b - rVarArr[2].f1359b;
        float f5 = (rVarArr[0].a + rVarArr[2].a) / 2.0f;
        float f6 = (rVarArr[0].f1359b + rVarArr[2].f1359b) / 2.0f;
        float f7 = f3 * f2;
        float f8 = f4 * f2;
        r rVar = new r(f5 + f7, f6 + f8);
        r rVar2 = new r(f5 - f7, f6 - f8);
        float f9 = rVarArr[1].a - rVarArr[3].a;
        float f10 = rVarArr[1].f1359b - rVarArr[3].f1359b;
        float f11 = (rVarArr[1].a + rVarArr[3].a) / 2.0f;
        float f12 = (rVarArr[1].f1359b + rVarArr[3].f1359b) / 2.0f;
        float f13 = f9 * f2;
        float f14 = f2 * f10;
        return new r[]{rVar, new r(f11 + f13, f12 + f14), rVar2, new r(f11 - f13, f12 - f14)};
    }

    public c.e.c.u.a a(boolean z) throws k {
        r rVar;
        r rVar2;
        r rVar3;
        r rVar4;
        r rVar5;
        r rVar6;
        r rVar7;
        r rVar8;
        int i2;
        long j2;
        int i3;
        C0051a c0051a;
        int i4 = 2;
        int i5 = -1;
        int i6 = 1;
        try {
            b bVar = this.f1368b;
            r[] rVarArrB = new c.e.c.v.l.a(bVar, 10, bVar.a / 2, bVar.f1376b / 2).b();
            rVar4 = rVarArrB[0];
            rVar3 = rVarArrB[1];
            rVar2 = rVarArrB[2];
            rVar = rVarArrB[3];
        } catch (k unused) {
            b bVar2 = this.f1368b;
            int i7 = bVar2.a / 2;
            int i8 = bVar2.f1376b / 2;
            int i9 = i8 - 7;
            int i10 = i7 + 7 + 1;
            int i11 = i10;
            int i12 = i9;
            while (true) {
                i12--;
                if (!f(i11, i12) || this.f1368b.b(i11, i12)) {
                    break;
                }
                i11++;
            }
            int i13 = i11 - 1;
            int i14 = i12 + 1;
            while (f(i13, i14) && !this.f1368b.b(i13, i14)) {
                i13++;
            }
            int i15 = i13 - 1;
            while (f(i15, i14) && !this.f1368b.b(i15, i14)) {
                i14--;
            }
            r rVar9 = new r(i15, i14 + 1);
            int i16 = i8 + 7;
            int i17 = i16;
            while (true) {
                i17++;
                if (!f(i10, i17) || this.f1368b.b(i10, i17)) {
                    break;
                }
                i10++;
            }
            int i18 = i10 - 1;
            int i19 = i17 - 1;
            while (f(i18, i19) && !this.f1368b.b(i18, i19)) {
                i18++;
            }
            int i20 = i18 - 1;
            while (f(i20, i19) && !this.f1368b.b(i20, i19)) {
                i19++;
            }
            r rVar10 = new r(i20, i19 - 1);
            int i21 = i7 - 7;
            int i22 = i21 - 1;
            while (true) {
                i16++;
                if (!f(i22, i16) || this.f1368b.b(i22, i16)) {
                    break;
                }
                i22--;
            }
            int i23 = i22 + 1;
            int i24 = i16 - 1;
            while (f(i23, i24) && !this.f1368b.b(i23, i24)) {
                i23--;
            }
            int i25 = i23 + 1;
            while (f(i25, i24) && !this.f1368b.b(i25, i24)) {
                i24++;
            }
            r rVar11 = new r(i25, i24 - 1);
            do {
                i21--;
                i9--;
                if (!f(i21, i9)) {
                    break;
                }
            } while (!this.f1368b.b(i21, i9));
            int i26 = i21 + 1;
            int i27 = i9 + 1;
            while (f(i26, i27) && !this.f1368b.b(i26, i27)) {
                i26--;
            }
            int i28 = i26 + 1;
            while (f(i28, i27) && !this.f1368b.b(i28, i27)) {
                i27--;
            }
            rVar = new r(i28, i27 + 1);
            rVar2 = rVar11;
            rVar3 = rVar10;
            rVar4 = rVar9;
        }
        int iR4 = f.R4((((rVar4.a + rVar.a) + rVar3.a) + rVar2.a) / 4.0f);
        int iR42 = f.R4((((rVar4.f1359b + rVar.f1359b) + rVar3.f1359b) + rVar2.f1359b) / 4.0f);
        try {
            r[] rVarArrB2 = new c.e.c.v.l.a(this.f1368b, 15, iR4, iR42).b();
            rVar6 = rVarArrB2[0];
            rVar8 = rVarArrB2[1];
            rVar7 = rVarArrB2[2];
            rVar5 = rVarArrB2[3];
        } catch (k unused2) {
            int i29 = iR42 - 7;
            int i30 = iR4 + 7 + 1;
            int i31 = i30;
            int i32 = i29;
            while (true) {
                i32--;
                if (!f(i31, i32) || this.f1368b.b(i31, i32)) {
                    break;
                }
                i31++;
            }
            int i33 = i31 - 1;
            int i34 = i32 + 1;
            while (f(i33, i34) && !this.f1368b.b(i33, i34)) {
                i33++;
            }
            int i35 = i33 - 1;
            while (f(i35, i34) && !this.f1368b.b(i35, i34)) {
                i34--;
            }
            r rVar12 = new r(i35, i34 + 1);
            int i36 = iR42 + 7;
            int i37 = i36;
            while (true) {
                i37++;
                if (!f(i30, i37) || this.f1368b.b(i30, i37)) {
                    break;
                }
                i30++;
            }
            int i38 = i30 - 1;
            int i39 = i37 - 1;
            while (f(i38, i39) && !this.f1368b.b(i38, i39)) {
                i38++;
            }
            int i40 = i38 - 1;
            while (f(i40, i39) && !this.f1368b.b(i40, i39)) {
                i39++;
            }
            r rVar13 = new r(i40, i39 - 1);
            int i41 = iR4 - 7;
            int i42 = i41 - 1;
            while (true) {
                i36++;
                if (!f(i42, i36) || this.f1368b.b(i42, i36)) {
                    break;
                }
                i42--;
            }
            int i43 = i42 + 1;
            int i44 = i36 - 1;
            while (f(i43, i44) && !this.f1368b.b(i43, i44)) {
                i43--;
            }
            int i45 = i43 + 1;
            while (f(i45, i44) && !this.f1368b.b(i45, i44)) {
                i44++;
            }
            r rVar14 = new r(i45, i44 - 1);
            do {
                i41--;
                i29--;
                if (!f(i41, i29)) {
                    break;
                }
            } while (!this.f1368b.b(i41, i29));
            int i46 = i41 + 1;
            int i47 = i29 + 1;
            while (f(i46, i47) && !this.f1368b.b(i46, i47)) {
                i46--;
            }
            int i48 = i46 + 1;
            while (f(i48, i47) && !this.f1368b.b(i48, i47)) {
                i47--;
            }
            rVar5 = new r(i48, i47 + 1);
            rVar6 = rVar12;
            rVar7 = rVar14;
            rVar8 = rVar13;
        }
        C0051a c0051a2 = new C0051a(f.R4((((rVar6.a + rVar5.a) + rVar8.a) + rVar7.a) / 4.0f), f.R4((((rVar6.f1359b + rVar5.f1359b) + rVar8.f1359b) + rVar7.f1359b) / 4.0f));
        this.f1372f = 1;
        C0051a c0051a3 = c0051a2;
        C0051a c0051a4 = c0051a3;
        C0051a c0051a5 = c0051a4;
        boolean z2 = true;
        while (this.f1372f < 9) {
            C0051a c0051aE = e(c0051a2, z2, i6, i5);
            C0051a c0051aE2 = e(c0051a3, z2, i6, i6);
            C0051a c0051aE3 = e(c0051a4, z2, i5, i6);
            C0051a c0051aE4 = e(c0051a5, z2, i5, i5);
            if (this.f1372f > i4) {
                double dS1 = (f.s1(c0051aE4.a, c0051aE4.f1374b, c0051aE.a, c0051aE.f1374b) * this.f1372f) / (f.s1(c0051a5.a, c0051a5.f1374b, c0051a2.a, c0051a2.f1374b) * (this.f1372f + i4));
                if (dS1 < 0.75d || dS1 > 1.25d) {
                    break;
                }
                C0051a c0051a6 = new C0051a(c0051aE.a - 3, c0051aE.f1374b + 3);
                C0051a c0051a7 = new C0051a(c0051aE2.a - 3, c0051aE2.f1374b - 3);
                C0051a c0051a8 = new C0051a(c0051aE3.a + 3, c0051aE3.f1374b - 3);
                c0051a = c0051aE;
                C0051a c0051a9 = new C0051a(c0051aE4.a + 3, c0051aE4.f1374b + 3);
                int iC = c(c0051a9, c0051a6);
                if (!(iC != 0 && c(c0051a6, c0051a7) == iC && c(c0051a7, c0051a8) == iC && c(c0051a8, c0051a9) == iC)) {
                    break;
                }
            } else {
                c0051a = c0051aE;
            }
            z2 = !z2;
            this.f1372f++;
            c0051a5 = c0051aE4;
            c0051a3 = c0051aE2;
            c0051a4 = c0051aE3;
            c0051a2 = c0051a;
            i4 = 2;
            i5 = -1;
            i6 = 1;
        }
        int i49 = this.f1372f;
        if (i49 != 5 && i49 != 7) {
            throw k.getNotFoundInstance();
        }
        this.f1369c = i49 == 5;
        int i50 = i49 * 2;
        r[] rVarArrB3 = b(new r[]{new r(c0051a2.a + 0.5f, c0051a2.f1374b - 0.5f), new r(c0051a3.a + 0.5f, c0051a3.f1374b + 0.5f), new r(c0051a4.a - 0.5f, c0051a4.f1374b + 0.5f), new r(c0051a5.a - 0.5f, c0051a5.f1374b - 0.5f)}, i50 - 3, i50);
        if (z) {
            r rVar15 = rVarArrB3[0];
            rVarArrB3[0] = rVarArrB3[2];
            rVarArrB3[2] = rVar15;
        }
        if (!g(rVarArrB3[0]) || !g(rVarArrB3[1]) || !g(rVarArrB3[2]) || !g(rVarArrB3[3])) {
            throw k.getNotFoundInstance();
        }
        int i51 = this.f1372f * 2;
        int[] iArr = {h(rVarArrB3[0], rVarArrB3[1], i51), h(rVarArrB3[1], rVarArrB3[2], i51), h(rVarArrB3[2], rVarArrB3[3], i51), h(rVarArrB3[3], rVarArrB3[0], i51)};
        int i52 = 0;
        for (int i53 = 0; i53 < 4; i53++) {
            int i54 = iArr[i53];
            i52 = (i52 << 3) + ((i54 >> (i51 - 2)) << 1) + (i54 & 1);
        }
        int i55 = ((i52 & 1) << 11) + (i52 >> 1);
        for (int i56 = 0; i56 < 4; i56++) {
            if (Integer.bitCount(a[i56] ^ i55) <= 2) {
                this.f1373g = i56;
                long j3 = 0;
                for (int i57 = 0; i57 < 4; i57++) {
                    int i58 = iArr[(this.f1373g + i57) % 4];
                    if (this.f1369c) {
                        j2 = j3 << 7;
                        i3 = (i58 >> 1) & 127;
                    } else {
                        j2 = j3 << 10;
                        i3 = ((i58 >> 1) & 31) + ((i58 >> 2) & 992);
                    }
                    j3 = j2 + ((long) i3);
                }
                int i59 = 7;
                if (this.f1369c) {
                    i2 = 2;
                } else {
                    i2 = 4;
                    i59 = 10;
                }
                int i60 = i59 - i2;
                int[] iArr2 = new int[i59];
                while (true) {
                    i59--;
                    if (i59 < 0) {
                        try {
                            break;
                        } catch (e unused3) {
                            throw k.getNotFoundInstance();
                        }
                    }
                    iArr2[i59] = ((int) j3) & 15;
                    j3 >>= 4;
                }
                new c(c.e.c.v.m.a.f1412d).a(iArr2, i60);
                int i61 = 0;
                for (int i62 = 0; i62 < i2; i62++) {
                    i61 = (i61 << 4) + iArr2[i62];
                }
                if (this.f1369c) {
                    this.f1370d = (i61 >> 6) + 1;
                    this.f1371e = (i61 & 63) + 1;
                } else {
                    this.f1370d = (i61 >> 11) + 1;
                    this.f1371e = (i61 & 2047) + 1;
                }
                b bVar3 = this.f1368b;
                int i63 = this.f1373g;
                r rVar16 = rVarArrB3[i63 % 4];
                r rVar17 = rVarArrB3[(i63 + 1) % 4];
                r rVar18 = rVarArrB3[(i63 + 2) % 4];
                r rVar19 = rVarArrB3[(i63 + 3) % 4];
                c.e.c.v.f fVar = c.e.c.v.f.a;
                int iD = d();
                float f2 = iD / 2.0f;
                float f3 = this.f1372f;
                float f4 = f2 - f3;
                float f5 = f2 + f3;
                return new c.e.c.u.a(fVar.a(bVar3, iD, iD, j.a(f4, f4, f5, f4, f5, f5, f4, f5, rVar16.a, rVar16.f1359b, rVar17.a, rVar17.f1359b, rVar18.a, rVar18.f1359b, rVar19.a, rVar19.f1359b)), b(rVarArrB3, this.f1372f * 2, d()), this.f1369c, this.f1371e, this.f1370d);
            }
        }
        throw k.getNotFoundInstance();
    }

    public final int c(C0051a c0051a, C0051a c0051a2) {
        float fS1 = f.s1(c0051a.a, c0051a.f1374b, c0051a2.a, c0051a2.f1374b);
        int i2 = c0051a2.a;
        int i3 = c0051a.a;
        float f2 = (i2 - i3) / fS1;
        int i4 = c0051a2.f1374b;
        int i5 = c0051a.f1374b;
        float f3 = (i4 - i5) / fS1;
        float f4 = i3;
        float f5 = i5;
        boolean zB = this.f1368b.b(i3, i5);
        int iCeil = (int) Math.ceil(fS1);
        int i6 = 0;
        for (int i7 = 0; i7 < iCeil; i7++) {
            f4 += f2;
            f5 += f3;
            if (this.f1368b.b(f.R4(f4), f.R4(f5)) != zB) {
                i6++;
            }
        }
        float f6 = i6 / fS1;
        if (f6 <= 0.1f || f6 >= 0.9f) {
            return (f6 <= 0.1f) == zB ? 1 : -1;
        }
        return 0;
    }

    public final int d() {
        if (this.f1369c) {
            return (this.f1370d * 4) + 11;
        }
        int i2 = this.f1370d;
        if (i2 <= 4) {
            return (i2 * 4) + 15;
        }
        return ((((i2 - 4) / 8) + 1) * 2) + (i2 * 4) + 15;
    }

    public final C0051a e(C0051a c0051a, boolean z, int i2, int i3) {
        int i4 = c0051a.a + i2;
        int i5 = c0051a.f1374b;
        while (true) {
            i5 += i3;
            if (!f(i4, i5) || this.f1368b.b(i4, i5) != z) {
                break;
            }
            i4 += i2;
        }
        int i6 = i4 - i2;
        int i7 = i5 - i3;
        while (f(i6, i7) && this.f1368b.b(i6, i7) == z) {
            i6 += i2;
        }
        int i8 = i6 - i2;
        while (f(i8, i7) && this.f1368b.b(i8, i7) == z) {
            i7 += i3;
        }
        return new C0051a(i8, i7 - i3);
    }

    public final boolean f(int i2, int i3) {
        if (i2 < 0) {
            return false;
        }
        b bVar = this.f1368b;
        return i2 < bVar.a && i3 > 0 && i3 < bVar.f1376b;
    }

    public final boolean g(r rVar) {
        return f(f.R4(rVar.a), f.R4(rVar.f1359b));
    }

    public final int h(r rVar, r rVar2, int i2) {
        float fR1 = f.r1(rVar.a, rVar.f1359b, rVar2.a, rVar2.f1359b);
        float f2 = fR1 / i2;
        float f3 = rVar.a;
        float f4 = rVar.f1359b;
        float f5 = ((rVar2.a - f3) * f2) / fR1;
        float f6 = ((rVar2.f1359b - f4) * f2) / fR1;
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            float f7 = i4;
            if (this.f1368b.b(f.R4((f7 * f5) + f3), f.R4((f7 * f6) + f4))) {
                i3 |= 1 << ((i2 - i4) - 1);
            }
        }
        return i3;
    }
}

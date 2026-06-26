package c.e.c.a0.d;

import c.e.c.k;
import c.e.c.r;
import c.e.c.s;

/* JADX INFO: compiled from: Detector.java */
/* JADX INFO: loaded from: classes.dex */
public class c {
    public final c.e.c.v.b a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public s f1328b;

    public c(c.e.c.v.b bVar) {
        this.a = bVar;
    }

    public final float a(r rVar, r rVar2) {
        float fD = d((int) rVar.a, (int) rVar.f1359b, (int) rVar2.a, (int) rVar2.f1359b);
        float fD2 = d((int) rVar2.a, (int) rVar2.f1359b, (int) rVar.a, (int) rVar.f1359b);
        return Float.isNaN(fD) ? fD2 / 7.0f : Float.isNaN(fD2) ? fD / 7.0f : (fD + fD2) / 14.0f;
    }

    public final a b(float f2, int i2, int i3, float f3) {
        a aVarC;
        a aVarC2;
        int i4 = (int) (f3 * f2);
        int iMax = Math.max(0, i2 - i4);
        int iMin = Math.min(this.a.a - 1, i2 + i4) - iMax;
        float f4 = 3.0f * f2;
        if (iMin < f4) {
            throw k.getNotFoundInstance();
        }
        int iMax2 = Math.max(0, i3 - i4);
        int iMin2 = Math.min(this.a.f1376b - 1, i3 + i4) - iMax2;
        if (iMin2 < f4) {
            throw k.getNotFoundInstance();
        }
        b bVar = new b(this.a, iMax, iMax2, iMin, iMin2, f2, this.f1328b);
        int i5 = bVar.f1321c;
        int i6 = bVar.f1324f;
        int i7 = bVar.f1323e + i5;
        int i8 = (i6 / 2) + bVar.f1322d;
        int[] iArr = new int[3];
        for (int i9 = 0; i9 < i6; i9++) {
            int i10 = ((i9 & 1) == 0 ? (i9 + 1) / 2 : -((i9 + 1) / 2)) + i8;
            iArr[0] = 0;
            iArr[1] = 0;
            iArr[2] = 0;
            int i11 = i5;
            while (i11 < i7 && !bVar.a.b(i11, i10)) {
                i11++;
            }
            int i12 = 0;
            while (i11 < i7) {
                if (!bVar.a.b(i11, i10)) {
                    if (i12 == 1) {
                        i12++;
                    }
                    iArr[i12] = iArr[i12] + 1;
                } else if (i12 == 1) {
                    iArr[1] = iArr[1] + 1;
                } else if (i12 != 2) {
                    i12++;
                    iArr[i12] = iArr[i12] + 1;
                } else {
                    if (bVar.b(iArr) && (aVarC2 = bVar.c(iArr, i10, i11)) != null) {
                        return aVarC2;
                    }
                    iArr[0] = iArr[2];
                    iArr[1] = 1;
                    iArr[2] = 0;
                    i12 = 1;
                }
                i11++;
            }
            if (bVar.b(iArr) && (aVarC = bVar.c(iArr, i10, i7)) != null) {
                return aVarC;
            }
        }
        if (bVar.f1320b.isEmpty()) {
            throw k.getNotFoundInstance();
        }
        return bVar.f1320b.get(0);
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x0084, code lost:
    
        if (r15 != 2) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x008c, code lost:
    
        return c.b.a.m.f.s1(r19, r6, r1, r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x008d, code lost:
    
        return Float.NaN;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final float c(int r18, int r19, int r20, int r21) {
        /*
            r17 = this;
            int r0 = r21 - r19
            int r0 = java.lang.Math.abs(r0)
            int r1 = r20 - r18
            int r1 = java.lang.Math.abs(r1)
            r3 = 1
            if (r0 <= r1) goto L11
            r0 = 1
            goto L12
        L11:
            r0 = 0
        L12:
            if (r0 == 0) goto L1d
            r4 = r18
            r1 = r19
            r6 = r20
            r5 = r21
            goto L25
        L1d:
            r1 = r18
            r4 = r19
            r5 = r20
            r6 = r21
        L25:
            int r7 = r5 - r1
            int r7 = java.lang.Math.abs(r7)
            int r8 = r6 - r4
            int r8 = java.lang.Math.abs(r8)
            int r9 = -r7
            r10 = 2
            int r9 = r9 / r10
            r11 = -1
            if (r1 >= r5) goto L39
            r12 = 1
            goto L3a
        L39:
            r12 = -1
        L3a:
            if (r4 >= r6) goto L3d
            r11 = 1
        L3d:
            int r5 = r5 + r12
            r13 = r1
            r14 = r4
            r15 = 0
        L41:
            if (r13 == r5) goto L7f
            if (r0 == 0) goto L47
            r2 = r14
            goto L48
        L47:
            r2 = r13
        L48:
            if (r0 == 0) goto L4c
            r10 = r13
            goto L4d
        L4c:
            r10 = r14
        L4d:
            if (r15 != r3) goto L57
            r3 = r17
            r16 = r0
            r19 = r5
            r0 = 1
            goto L5e
        L57:
            r3 = r17
            r16 = r0
            r19 = r5
            r0 = 0
        L5e:
            c.e.c.v.b r5 = r3.a
            boolean r2 = r5.b(r2, r10)
            if (r0 != r2) goto L70
            r0 = 2
            if (r15 != r0) goto L6e
            float r0 = c.b.a.m.f.s1(r13, r14, r1, r4)
            return r0
        L6e:
            int r15 = r15 + 1
        L70:
            int r9 = r9 + r8
            if (r9 <= 0) goto L77
            if (r14 == r6) goto L83
            int r14 = r14 + r11
            int r9 = r9 - r7
        L77:
            int r13 = r13 + r12
            r5 = r19
            r0 = r16
            r3 = 1
            r10 = 2
            goto L41
        L7f:
            r3 = r17
            r19 = r5
        L83:
            r0 = 2
            if (r15 != r0) goto L8d
            r5 = r19
            float r0 = c.b.a.m.f.s1(r5, r6, r1, r4)
            return r0
        L8d:
            r0 = 2143289344(0x7fc00000, float:NaN)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: c.e.c.a0.d.c.c(int, int, int, int):float");
    }

    public final float d(int i2, int i3, int i4, int i5) {
        float f2;
        float f3;
        float fC = c(i2, i3, i4, i5);
        int i6 = i2 - (i4 - i2);
        int i7 = 0;
        if (i6 < 0) {
            f2 = i2 / (i2 - i6);
            i6 = 0;
        } else {
            int i8 = this.a.a;
            if (i6 >= i8) {
                float f4 = ((i8 - 1) - i2) / (i6 - i2);
                int i9 = i8 - 1;
                f2 = f4;
                i6 = i9;
            } else {
                f2 = 1.0f;
            }
        }
        float f5 = i3;
        int i10 = (int) (f5 - ((i5 - i3) * f2));
        if (i10 < 0) {
            f3 = f5 / (i3 - i10);
        } else {
            int i11 = this.a.f1376b;
            if (i10 >= i11) {
                f3 = ((i11 - 1) - i3) / (i10 - i3);
                i7 = i11 - 1;
            } else {
                i7 = i10;
                f3 = 1.0f;
            }
        }
        return (c(i2, i3, (int) (((i6 - i2) * f3) + i2), i7) + fC) - 1.0f;
    }
}

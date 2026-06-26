package c.e.c.z.e;

import c.e.c.r;
import c.e.c.v.b;
import java.util.Arrays;

/* JADX INFO: compiled from: Detector.java */
/* JADX INFO: loaded from: classes.dex */
public final class a {
    public static final int[] a = {0, 4, 1, 5};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int[] f1552b = {6, 2, 7, 3};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int[] f1553c = {8, 1, 1, 1, 1, 1, 1, 3};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int[] f1554d = {7, 1, 1, 3, 1, 1, 1, 2, 1};

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0068, code lost:
    
        if (r12 == false) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x006a, code lost:
    
        r1 = r7.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0072, code lost:
    
        if (r1.hasNext() == false) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0074, code lost:
    
        r2 = (c.e.c.r[]) r1.next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x007c, code lost:
    
        if (r2[1] == null) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x007e, code lost:
    
        r10 = (int) java.lang.Math.max(r10, r2[1].f1359b);
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x008a, code lost:
    
        if (r2[3] == null) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x008c, code lost:
    
        r10 = java.lang.Math.max(r10, (int) r2[3].f1359b);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.util.List<c.e.c.r[]> a(boolean r17, c.e.c.v.b r18) {
        /*
            r6 = r18
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            r8 = 1
            r9 = 0
            r10 = 0
        La:
            r11 = 0
            r12 = 0
        Lc:
            int r13 = r6.f1376b
            if (r10 >= r13) goto Lbc
            int r14 = r6.a
            r0 = 8
            c.e.c.r[] r15 = new c.e.c.r[r0]
            int[] r5 = c.e.c.z.e.a.f1553c
            r0 = r18
            r1 = r13
            r2 = r14
            r3 = r10
            r4 = r11
            c.e.c.r[] r0 = c(r0, r1, r2, r3, r4, r5)
            int[] r1 = c.e.c.z.e.a.a
            r2 = 0
        L25:
            int r3 = r1.length
            if (r2 >= r3) goto L31
            r3 = r1[r2]
            r4 = r0[r2]
            r15[r3] = r4
            int r2 = r2 + 1
            goto L25
        L31:
            r16 = 4
            r0 = r15[r16]
            if (r0 == 0) goto L44
            r0 = r15[r16]
            float r0 = r0.a
            int r0 = (int) r0
            r1 = r15[r16]
            float r1 = r1.f1359b
            int r1 = (int) r1
            r4 = r0
            r3 = r1
            goto L46
        L44:
            r3 = r10
            r4 = r11
        L46:
            int[] r5 = c.e.c.z.e.a.f1554d
            r0 = r18
            r1 = r13
            r2 = r14
            c.e.c.r[] r0 = c(r0, r1, r2, r3, r4, r5)
            int[] r1 = c.e.c.z.e.a.f1552b
            r2 = 0
        L53:
            int r3 = r1.length
            if (r2 >= r3) goto L5f
            r3 = r1[r2]
            r4 = r0[r2]
            r15[r3] = r4
            int r2 = r2 + 1
            goto L53
        L5f:
            r0 = r15[r9]
            if (r0 != 0) goto L9b
            r0 = 3
            r1 = r15[r0]
            if (r1 != 0) goto L9b
            if (r12 == 0) goto Lbc
            java.util.Iterator r1 = r7.iterator()
        L6e:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L97
            java.lang.Object r2 = r1.next()
            c.e.c.r[] r2 = (c.e.c.r[]) r2
            r3 = r2[r8]
            if (r3 == 0) goto L88
            float r3 = (float) r10
            r4 = r2[r8]
            float r4 = r4.f1359b
            float r3 = java.lang.Math.max(r3, r4)
            int r10 = (int) r3
        L88:
            r3 = r2[r0]
            if (r3 == 0) goto L6e
            r2 = r2[r0]
            float r2 = r2.f1359b
            int r2 = (int) r2
            int r2 = java.lang.Math.max(r10, r2)
            r10 = r2
            goto L6e
        L97:
            int r10 = r10 + 5
            goto La
        L9b:
            r7.add(r15)
            if (r17 == 0) goto Lbc
            r0 = 2
            r1 = r15[r0]
            if (r1 == 0) goto Laf
            r1 = r15[r0]
            float r1 = r1.a
            int r11 = (int) r1
            r0 = r15[r0]
            float r0 = r0.f1359b
            goto Lb8
        Laf:
            r0 = r15[r16]
            float r0 = r0.a
            int r11 = (int) r0
            r0 = r15[r16]
            float r0 = r0.f1359b
        Lb8:
            int r10 = (int) r0
            r12 = 1
            goto Lc
        Lbc:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: c.e.c.z.e.a.a(boolean, c.e.c.v.b):java.util.List");
    }

    public static int[] b(b bVar, int i2, int i3, int i4, boolean z, int[] iArr, int[] iArr2) {
        Arrays.fill(iArr2, 0, iArr2.length, 0);
        int i5 = 0;
        while (bVar.b(i2, i3) && i2 > 0) {
            int i6 = i5 + 1;
            if (i5 >= 3) {
                break;
            }
            i2--;
            i5 = i6;
        }
        int length = iArr.length;
        boolean z2 = z;
        int i7 = 0;
        int i8 = i2;
        while (i2 < i4) {
            if (bVar.b(i2, i3) != z2) {
                iArr2[i7] = iArr2[i7] + 1;
            } else {
                if (i7 != length - 1) {
                    i7++;
                } else {
                    if (d(iArr2, iArr, 0.8f) < 0.42f) {
                        return new int[]{i8, i2};
                    }
                    i8 += iArr2[0] + iArr2[1];
                    int i9 = i7 - 1;
                    System.arraycopy(iArr2, 2, iArr2, 0, i9);
                    iArr2[i9] = 0;
                    iArr2[i7] = 0;
                    i7 = i9;
                }
                iArr2[i7] = 1;
                z2 = !z2;
            }
            i2++;
        }
        if (i7 != length - 1 || d(iArr2, iArr, 0.8f) >= 0.42f) {
            return null;
        }
        return new int[]{i8, i2 - 1};
    }

    public static r[] c(b bVar, int i2, int i3, int i4, int i5, int[] iArr) {
        boolean z;
        int i6;
        int i7;
        int i8;
        r[] rVarArr = new r[4];
        int[] iArr2 = new int[iArr.length];
        int i9 = i4;
        while (true) {
            if (i9 >= i2) {
                z = false;
                break;
            }
            int[] iArrB = b(bVar, i5, i9, i3, false, iArr, iArr2);
            if (iArrB != null) {
                int i10 = i9;
                int[] iArr3 = iArrB;
                int i11 = i10;
                while (true) {
                    if (i11 <= 0) {
                        i8 = i11;
                        break;
                    }
                    int i12 = i11 - 1;
                    int[] iArrB2 = b(bVar, i5, i12, i3, false, iArr, iArr2);
                    if (iArrB2 == null) {
                        i8 = i12 + 1;
                        break;
                    }
                    iArr3 = iArrB2;
                    i11 = i12;
                }
                float f2 = i8;
                rVarArr[0] = new r(iArr3[0], f2);
                rVarArr[1] = new r(iArr3[1], f2);
                i9 = i8;
                z = true;
            } else {
                i9 += 5;
            }
        }
        int i13 = i9 + 1;
        if (z) {
            int[] iArr4 = {(int) rVarArr[0].a, (int) rVarArr[1].a};
            int i14 = i13;
            int i15 = 0;
            while (true) {
                if (i14 >= i2) {
                    i6 = i15;
                    i7 = i14;
                    break;
                }
                i6 = i15;
                i7 = i14;
                int[] iArrB3 = b(bVar, iArr4[0], i14, i3, false, iArr, iArr2);
                if (iArrB3 != null && Math.abs(iArr4[0] - iArrB3[0]) < 5 && Math.abs(iArr4[1] - iArrB3[1]) < 5) {
                    iArr4 = iArrB3;
                    i15 = 0;
                } else {
                    if (i6 > 25) {
                        break;
                    }
                    i15 = i6 + 1;
                }
                i14 = i7 + 1;
            }
            i13 = i7 - (i6 + 1);
            float f3 = i13;
            rVarArr[2] = new r(iArr4[0], f3);
            rVarArr[3] = new r(iArr4[1], f3);
        }
        if (i13 - i9 < 10) {
            Arrays.fill(rVarArr, (Object) null);
        }
        return rVarArr;
    }

    public static float d(int[] iArr, int[] iArr2, float f2) {
        int length = iArr.length;
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            i2 += iArr[i4];
            i3 += iArr2[i4];
        }
        if (i2 < i3) {
            return Float.POSITIVE_INFINITY;
        }
        float f3 = i2;
        float f4 = f3 / i3;
        float f5 = f2 * f4;
        float f6 = 0.0f;
        for (int i5 = 0; i5 < length; i5++) {
            float f7 = iArr2[i5] * f4;
            float f8 = iArr[i5];
            float f9 = f8 > f7 ? f8 - f7 : f7 - f8;
            if (f9 > f5) {
                return Float.POSITIVE_INFINITY;
            }
            f6 += f9;
        }
        return f6 / f3;
    }
}

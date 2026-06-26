package k.e.a;

import org.jsoup.nodes.Attributes;

/* JADX INFO: loaded from: classes3.dex */
public final class j {
    public static final int[] a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public n f8858b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int[] f8859c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int[] f8860d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int[] f8861e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int[] f8862f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f8863g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f8864h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int[] f8865i;

    static {
        int[] iArr = new int[202];
        for (int i2 = 0; i2 < 202; i2++) {
            iArr[i2] = "EFFFFFFFFGGFFFGGFFFEEFGFGFEEEEEEEEEEEEEEEEEEEEDEDEDDDDDCDCDEEEEEEEEEEEEEEEEEEEEBABABBBBDCFFFGGGEDCDCDCDCDCDCDCDCDCDCEEEEDDDDDDDCDCDCEFEFDDEEFFDEDEEEBDDBBDDDDDDCCCCCCCCEFEDDDCDCDEEEEEEEEEEFEEEEEEDDEEDDEE".charAt(i2) - 'E';
        }
        a = iArr;
    }

    public static boolean h(f fVar, int i2, int[] iArr, int i3) {
        int iMin;
        int i4 = i2;
        int i5 = iArr[i3];
        if (i5 == i4) {
            return false;
        }
        if ((268435455 & i4) == 16777221) {
            if (i5 == 16777221) {
                return false;
            }
            i4 = 16777221;
        }
        if (i5 == 0) {
            iArr[i3] = i4;
            return true;
        }
        int i6 = i5 & 267386880;
        int iR = 16777216;
        if (i6 == 24117248 || (i5 & (-268435456)) != 0) {
            if (i4 == 16777221) {
                return false;
            }
            String strReplace = "java/lang/Object";
            if ((i4 & (-1048576)) != ((-1048576) & i5)) {
                int i7 = i4 & 267386880;
                if (i7 == 24117248 || (i4 & (-268435456)) != 0) {
                    int i8 = i4 & (-268435456);
                    int i9 = ((i8 == 0 || i7 == 24117248) ? 0 : -268435456) + i8;
                    int i10 = i5 & (-268435456);
                    iMin = Math.min(i9, ((i10 == 0 || i6 == 24117248) ? 0 : -268435456) + i10);
                    iR = iMin | 24117248 | fVar.r("java/lang/Object");
                }
            } else if (i6 == 24117248) {
                int i11 = (i4 & (-268435456)) | 24117248;
                int i12 = i4 & 1048575;
                int i13 = 1048575 & i5;
                m mVar = fVar.f8829h;
                mVar.f8874b = 32;
                mVar.f8876d = ((long) i12) | (((long) i13) << 32);
                mVar.f8880h = (i12 + 32 + i13) & Integer.MAX_VALUE;
                m mVarO = fVar.o(mVar);
                if (mVarO == null) {
                    m[] mVarArr = fVar.f8832k;
                    String str = mVarArr[i12].f8877e;
                    String str2 = mVarArr[i13].f8877e;
                    m mVar2 = fVar.f8829h;
                    ClassLoader classLoader = f.class.getClassLoader();
                    try {
                        Class<?> cls = Class.forName(str.replace(Attributes.InternalPrefix, '.'), false, classLoader);
                        Class<?> cls2 = Class.forName(str2.replace(Attributes.InternalPrefix, '.'), false, classLoader);
                        if (cls.isAssignableFrom(cls2)) {
                            strReplace = str;
                        } else if (cls2.isAssignableFrom(cls)) {
                            strReplace = str2;
                        } else if (!cls.isInterface() && !cls2.isInterface()) {
                            do {
                                cls = cls.getSuperclass();
                            } while (!cls.isAssignableFrom(cls2));
                            strReplace = cls.getName().replace('.', Attributes.InternalPrefix);
                        }
                        mVar2.f8875c = fVar.r(strReplace);
                        mVarO = new m(0, fVar.f8829h);
                        fVar.q(mVarO);
                    } catch (Exception e2) {
                        throw new RuntimeException(e2.toString());
                    }
                }
                iR = i11 | mVarO.f8875c;
            } else {
                iMin = (i5 & (-268435456)) - 268435456;
                iR = iMin | 24117248 | fVar.r("java/lang/Object");
            }
        } else if (i5 == 16777221) {
            if ((i4 & 267386880) != 24117248 && (i4 & (-268435456)) == 0) {
                i4 = 16777216;
            }
            iR = i4;
        }
        if (i5 == iR) {
            return false;
        }
        iArr[i3] = iR;
        return true;
    }

    public static int i(f fVar, String str) {
        int iIndexOf = str.charAt(0) == '(' ? str.indexOf(41) + 1 : 0;
        char cCharAt = str.charAt(iIndexOf);
        int iR = 16777218;
        if (cCharAt == 'F') {
            return 16777218;
        }
        if (cCharAt == 'L') {
            return fVar.r(str.substring(iIndexOf + 1, str.length() - 1)) | 24117248;
        }
        if (cCharAt != 'S') {
            if (cCharAt == 'V') {
                return 0;
            }
            if (cCharAt != 'Z' && cCharAt != 'I') {
                if (cCharAt == 'J') {
                    return 16777220;
                }
                switch (cCharAt) {
                    case 'B':
                    case 'C':
                        break;
                    case 'D':
                        return 16777219;
                    default:
                        int i2 = iIndexOf + 1;
                        while (str.charAt(i2) == '[') {
                            i2++;
                        }
                        char cCharAt2 = str.charAt(i2);
                        if (cCharAt2 != 'F') {
                            if (cCharAt2 == 'S') {
                                iR = 16777228;
                            } else if (cCharAt2 == 'Z') {
                                iR = 16777225;
                            } else if (cCharAt2 == 'I') {
                                iR = 16777217;
                            } else if (cCharAt2 != 'J') {
                                switch (cCharAt2) {
                                    case 'B':
                                        iR = 16777226;
                                        break;
                                    case 'C':
                                        iR = 16777227;
                                        break;
                                    case 'D':
                                        iR = 16777219;
                                        break;
                                    default:
                                        iR = fVar.r(str.substring(i2 + 1, str.length() - 1)) | 24117248;
                                        break;
                                }
                            } else {
                                iR = 16777220;
                            }
                        }
                        return ((i2 - iIndexOf) << 28) | iR;
                }
            }
        }
        return 16777217;
    }

    public final int a() {
        int i2 = this.f8863g;
        if (i2 > 0) {
            int[] iArr = this.f8862f;
            int i3 = i2 - 1;
            this.f8863g = i3;
            return iArr[i3];
        }
        n nVar = this.f8858b;
        int i4 = nVar.f8886f - 1;
        nVar.f8886f = i4;
        return 50331648 | (-i4);
    }

    public final int b(int i2) {
        int[] iArr = this.f8861e;
        if (iArr == null || i2 >= iArr.length) {
            return i2 | 33554432;
        }
        int i3 = iArr[i2];
        if (i3 != 0) {
            return i3;
        }
        int i4 = i2 | 33554432;
        iArr[i2] = i4;
        return i4;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x004d A[LOOP:0: B:10:0x0022->B:21:0x004d, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x004c A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int c(k.e.a.f r7, int r8) {
        /*
            r6 = this;
            r0 = 24117248(0x1700000, float:4.4081038E-38)
            r1 = 16777222(0x1000006, float:2.3509904E-38)
            if (r8 != r1) goto Lf
            java.lang.String r1 = r7.o
        L9:
            int r7 = r7.r(r1)
            r7 = r7 | r0
            goto L21
        Lf:
            r1 = -1048576(0xfffffffffff00000, float:NaN)
            r1 = r1 & r8
            r2 = 25165824(0x1800000, float:4.7019774E-38)
            if (r1 != r2) goto L50
            k.e.a.m[] r1 = r7.f8832k
            r2 = 1048575(0xfffff, float:1.469367E-39)
            r2 = r2 & r8
            r1 = r1[r2]
            java.lang.String r1 = r1.f8877e
            goto L9
        L21:
            r0 = 0
        L22:
            int r1 = r6.f8864h
            if (r0 >= r1) goto L50
            int[] r1 = r6.f8865i
            r1 = r1[r0]
            r2 = -268435456(0xfffffffff0000000, float:-1.58456325E29)
            r2 = r2 & r1
            r3 = 251658240(0xf000000, float:6.3108872E-30)
            r3 = r3 & r1
            r4 = 33554432(0x2000000, float:9.403955E-38)
            r5 = 8388607(0x7fffff, float:1.1754942E-38)
            if (r3 != r4) goto L3e
            int[] r3 = r6.f8859c
            r1 = r1 & r5
            r1 = r3[r1]
        L3c:
            int r1 = r1 + r2
            goto L4a
        L3e:
            r4 = 50331648(0x3000000, float:3.761582E-37)
            if (r3 != r4) goto L4a
            int[] r3 = r6.f8860d
            int r4 = r3.length
            r1 = r1 & r5
            int r4 = r4 - r1
            r1 = r3[r4]
            goto L3c
        L4a:
            if (r8 != r1) goto L4d
            return r7
        L4d:
            int r0 = r0 + 1
            goto L22
        L50:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: k.e.a.j.c(k.e.a.f, int):int");
    }

    public final void d(int i2, int i3) {
        if (this.f8861e == null) {
            this.f8861e = new int[10];
        }
        int length = this.f8861e.length;
        if (i2 >= length) {
            int[] iArr = new int[Math.max(i2 + 1, length * 2)];
            System.arraycopy(this.f8861e, 0, iArr, 0, length);
            this.f8861e = iArr;
        }
        this.f8861e[i2] = i3;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x004b, code lost:
    
        if (r1.charAt(0) == '[') goto L14;
     */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0245  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0249  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x024d  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0254  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0216  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x021a  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x021e  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0222  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void e(int r17, int r18, k.e.a.f r19, k.e.a.m r20) {
        /*
            Method dump skipped, instruction units count: 970
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: k.e.a.j.e(int, int, k.e.a.f, k.e.a.m):void");
    }

    public final void f(String str) {
        char cCharAt = str.charAt(0);
        if (cCharAt == '(') {
            k((r.d(str) >> 2) - 1);
        } else if (cCharAt == 'J' || cCharAt == 'D') {
            k(2);
        } else {
            k(1);
        }
    }

    public final void g(f fVar, String str) {
        int i2 = i(fVar, str);
        if (i2 != 0) {
            j(i2);
            if (i2 == 16777220 || i2 == 16777219) {
                j(16777216);
            }
        }
    }

    public final void j(int i2) {
        if (this.f8862f == null) {
            this.f8862f = new int[10];
        }
        int length = this.f8862f.length;
        int i3 = this.f8863g;
        if (i3 >= length) {
            int[] iArr = new int[Math.max(i3 + 1, length * 2)];
            System.arraycopy(this.f8862f, 0, iArr, 0, length);
            this.f8862f = iArr;
        }
        int[] iArr2 = this.f8862f;
        int i4 = this.f8863g;
        int i5 = i4 + 1;
        this.f8863g = i5;
        iArr2[i4] = i2;
        n nVar = this.f8858b;
        int i6 = nVar.f8886f + i5;
        if (i6 > nVar.f8887g) {
            nVar.f8887g = i6;
        }
    }

    public final void k(int i2) {
        int i3 = this.f8863g;
        if (i3 >= i2) {
            this.f8863g = i3 - i2;
            return;
        }
        this.f8858b.f8886f -= i2 - i3;
        this.f8863g = 0;
    }
}

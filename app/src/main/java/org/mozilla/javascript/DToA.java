package org.mozilla.javascript;

import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes3.dex */
public class DToA {
    private static final int Bias = 1023;
    private static final int Bletch = 16;
    private static final int Bndry_mask = 1048575;
    public static final int DTOSTR_EXPONENTIAL = 3;
    public static final int DTOSTR_FIXED = 2;
    public static final int DTOSTR_PRECISION = 4;
    public static final int DTOSTR_STANDARD = 0;
    public static final int DTOSTR_STANDARD_EXPONENTIAL = 1;
    private static final int Exp_11 = 1072693248;
    private static final int Exp_mask = 2146435072;
    private static final int Exp_mask_shifted = 2047;
    private static final int Exp_msk1 = 1048576;
    private static final long Exp_msk1L = 4503599627370496L;
    private static final int Exp_shift = 20;
    private static final int Exp_shift1 = 20;
    private static final int Exp_shiftL = 52;
    private static final int Frac_mask = 1048575;
    private static final int Frac_mask1 = 1048575;
    private static final long Frac_maskL = 4503599627370495L;
    private static final int Int_max = 14;
    private static final int Log2P = 1;
    private static final int P = 53;
    private static final int Quick_max = 14;
    private static final int Sign_bit = Integer.MIN_VALUE;
    private static final int Ten_pmax = 22;
    private static final int n_bigtens = 5;
    private static final double[] tens = {1.0d, 10.0d, 100.0d, 1000.0d, 10000.0d, 100000.0d, 1000000.0d, 1.0E7d, 1.0E8d, 1.0E9d, 1.0E10d, 1.0E11d, 1.0E12d, 1.0E13d, 1.0E14d, 1.0E15d, 1.0E16d, 1.0E17d, 1.0E18d, 1.0E19d, 1.0E20d, 1.0E21d, 1.0E22d};
    private static final double[] bigtens = {1.0E16d, 1.0E32d, 1.0E64d, 1.0E128d, 1.0E256d};
    private static final int[] dtoaModes = {0, 0, 3, 2, 2};

    private static char BASEDIGIT(int i2) {
        return (char) (i2 >= 10 ? i2 + 87 : i2 + 48);
    }

    /* JADX WARN: Code restructure failed: missing block: B:353:0x05ee, code lost:
    
        if (r13 <= 0) goto L368;
     */
    /* JADX WARN: Code restructure failed: missing block: B:354:0x05f0, code lost:
    
        r3 = r11.shiftLeft(1).compareTo(r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:355:0x05f9, code lost:
    
        if (r3 > 0) goto L360;
     */
    /* JADX WARN: Code restructure failed: missing block: B:356:0x05fb, code lost:
    
        if (r3 != 0) goto L368;
     */
    /* JADX WARN: Code restructure failed: missing block: B:358:0x05ff, code lost:
    
        if ((r8 & 1) == 1) goto L360;
     */
    /* JADX WARN: Code restructure failed: missing block: B:359:0x0601, code lost:
    
        if (r45 == false) goto L368;
     */
    /* JADX WARN: Code restructure failed: missing block: B:360:0x0603, code lost:
    
        r0 = (char) (r8 + 1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:361:0x0608, code lost:
    
        if (r8 != '9') goto L367;
     */
    /* JADX WARN: Code restructure failed: missing block: B:362:0x060a, code lost:
    
        r48.append('9');
     */
    /* JADX WARN: Code restructure failed: missing block: B:363:0x0611, code lost:
    
        if (roundOff(r48) == false) goto L365;
     */
    /* JADX WARN: Code restructure failed: missing block: B:364:0x0613, code lost:
    
        r2 = r2 + 1;
        r48.append('1');
     */
    /* JADX WARN: Code restructure failed: missing block: B:366:0x061c, code lost:
    
        return r2 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:367:0x061d, code lost:
    
        r4 = 1;
        r8 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:368:0x0620, code lost:
    
        r4 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:369:0x0621, code lost:
    
        r48.append(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:370:0x0625, code lost:
    
        return r2 + r4;
     */
    /* JADX WARN: Removed duplicated region for block: B:112:0x020f  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0237  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x023b  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x030e  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x031b  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x031f  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x03d0  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x0418  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x0428  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x042b  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x0435  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x0455  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x0461  */
    /* JADX WARN: Removed duplicated region for block: B:254:0x048b  */
    /* JADX WARN: Removed duplicated region for block: B:258:0x049b  */
    /* JADX WARN: Removed duplicated region for block: B:263:0x04aa  */
    /* JADX WARN: Removed duplicated region for block: B:264:0x04b3  */
    /* JADX WARN: Removed duplicated region for block: B:267:0x04b9  */
    /* JADX WARN: Removed duplicated region for block: B:270:0x04be  */
    /* JADX WARN: Removed duplicated region for block: B:272:0x04c4  */
    /* JADX WARN: Removed duplicated region for block: B:275:0x04cb  */
    /* JADX WARN: Removed duplicated region for block: B:277:0x04d1  */
    /* JADX WARN: Removed duplicated region for block: B:280:0x04d9  */
    /* JADX WARN: Removed duplicated region for block: B:286:0x04f6  */
    /* JADX WARN: Removed duplicated region for block: B:288:0x04fa  */
    /* JADX WARN: Removed duplicated region for block: B:303:0x052d  */
    /* JADX WARN: Removed duplicated region for block: B:371:0x0626  */
    /* JADX WARN: Removed duplicated region for block: B:377:0x0649 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:383:0x0656  */
    /* JADX WARN: Removed duplicated region for block: B:385:0x065c  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0150  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int JS_dtoa(double r42, int r44, boolean r45, int r46, boolean[] r47, java.lang.StringBuilder r48) {
        /*
            Method dump skipped, instruction units count: 1651
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.DToA.JS_dtoa(double, int, boolean, int, boolean[], java.lang.StringBuilder):int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:75:0x0120, code lost:
    
        if (r9 > 0) goto L80;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String JS_dtobasestr(int r11, double r12) {
        /*
            Method dump skipped, instruction units count: 334
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.DToA.JS_dtobasestr(int, double):java.lang.String");
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x005f A[LOOP:0: B:41:0x005f->B:75:?, LOOP_START] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0083  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void JS_dtostr(java.lang.StringBuilder r11, int r12, int r13, double r14) {
        /*
            Method dump skipped, instruction units count: 202
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.DToA.JS_dtostr(java.lang.StringBuilder, int, int, double):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0058  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.math.BigInteger d2b(double r8, int[] r10, int[] r11) {
        /*
            long r8 = java.lang.Double.doubleToLongBits(r8)
            r0 = 32
            long r1 = r8 >>> r0
            int r2 = (int) r1
            int r9 = (int) r8
            r8 = 1048575(0xfffff, float:1.469367E-39)
            r8 = r8 & r2
            r1 = 2147483647(0x7fffffff, float:NaN)
            r1 = r1 & r2
            int r1 = r1 >>> 20
            if (r1 == 0) goto L19
            r2 = 1048576(0x100000, float:1.469368E-39)
            r8 = r8 | r2
        L19:
            r2 = 1
            r3 = 4
            r4 = 0
            if (r9 == 0) goto L3d
            r5 = 8
            byte[] r5 = new byte[r5]
            int r6 = lo0bits(r9)
            int r9 = r9 >>> r6
            if (r6 == 0) goto L33
            int r7 = 32 - r6
            int r7 = r8 << r7
            r9 = r9 | r7
            stuffBits(r5, r3, r9)
            int r8 = r8 >> r6
            goto L36
        L33:
            stuffBits(r5, r3, r9)
        L36:
            stuffBits(r5, r4, r8)
            if (r8 == 0) goto L49
            r9 = 2
            goto L4a
        L3d:
            byte[] r5 = new byte[r3]
            int r9 = lo0bits(r8)
            int r8 = r8 >>> r9
            stuffBits(r5, r4, r8)
            int r6 = r9 + 32
        L49:
            r9 = 1
        L4a:
            if (r1 == 0) goto L58
            int r1 = r1 + (-1023)
            int r1 = r1 + (-52)
            int r1 = r1 + r6
            r10[r4] = r1
            int r8 = 53 - r6
            r11[r4] = r8
            goto L69
        L58:
            int r1 = r1 + (-1023)
            int r1 = r1 + (-52)
            int r1 = r1 + r2
            int r1 = r1 + r6
            r10[r4] = r1
            int r9 = r9 * 32
            int r8 = hi0bits(r8)
            int r9 = r9 - r8
            r11[r4] = r9
        L69:
            java.math.BigInteger r8 = new java.math.BigInteger
            r8.<init>(r5)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.DToA.d2b(double, int[], int[]):java.math.BigInteger");
    }

    private static int hi0bits(int i2) {
        int i3;
        if (((-65536) & i2) == 0) {
            i2 <<= 16;
            i3 = 16;
        } else {
            i3 = 0;
        }
        if (((-16777216) & i2) == 0) {
            i3 += 8;
            i2 <<= 8;
        }
        if (((-268435456) & i2) == 0) {
            i3 += 4;
            i2 <<= 4;
        }
        if (((-1073741824) & i2) == 0) {
            i3 += 2;
            i2 <<= 2;
        }
        if ((Integer.MIN_VALUE & i2) == 0) {
            i3++;
            if ((i2 & BasicMeasure.EXACTLY) == 0) {
                return 32;
            }
        }
        return i3;
    }

    private static int lo0bits(int i2) {
        int i3 = 0;
        if ((i2 & 7) != 0) {
            if ((i2 & 1) != 0) {
                return 0;
            }
            return (i2 & 2) != 0 ? 1 : 2;
        }
        if ((65535 & i2) == 0) {
            i2 >>>= 16;
            i3 = 16;
        }
        if ((i2 & 255) == 0) {
            i3 += 8;
            i2 >>>= 8;
        }
        if ((i2 & 15) == 0) {
            i3 += 4;
            i2 >>>= 4;
        }
        if ((i2 & 3) == 0) {
            i3 += 2;
            i2 >>>= 2;
        }
        if ((i2 & 1) == 0) {
            i3++;
            if (((i2 >>> 1) & 1) == 0) {
                return 32;
            }
        }
        return i3;
    }

    public static BigInteger pow5mult(BigInteger bigInteger, int i2) {
        return bigInteger.multiply(BigInteger.valueOf(5L).pow(i2));
    }

    public static boolean roundOff(StringBuilder sb) {
        int length = sb.length();
        while (length != 0) {
            length--;
            char cCharAt = sb.charAt(length);
            if (cCharAt != '9') {
                sb.setCharAt(length, (char) (cCharAt + 1));
                sb.setLength(length + 1);
                return false;
            }
        }
        sb.setLength(0);
        return true;
    }

    public static double setWord0(double d2, int i2) {
        return Double.longBitsToDouble((Double.doubleToLongBits(d2) & 4294967295L) | (((long) i2) << 32));
    }

    private static void stripTrailingZeroes(StringBuilder sb) {
        int i2;
        int length = sb.length();
        while (true) {
            i2 = length - 1;
            if (length <= 0 || sb.charAt(i2) != '0') {
                break;
            } else {
                length = i2;
            }
        }
        sb.setLength(i2 + 1);
    }

    private static void stuffBits(byte[] bArr, int i2, int i3) {
        bArr[i2] = (byte) (i3 >> 24);
        bArr[i2 + 1] = (byte) (i3 >> 16);
        bArr[i2 + 2] = (byte) (i3 >> 8);
        bArr[i2 + 3] = (byte) i3;
    }

    public static int word0(double d2) {
        return (int) (Double.doubleToLongBits(d2) >> 32);
    }

    public static int word1(double d2) {
        return (int) Double.doubleToLongBits(d2);
    }
}

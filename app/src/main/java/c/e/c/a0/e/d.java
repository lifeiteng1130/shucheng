package c.e.c.a0.e;

import c.e.c.t;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Token;

/* JADX INFO: compiled from: MatrixUtil.java */
/* JADX INFO: loaded from: classes.dex */
public final class d {
    public static final int[][] a = {new int[]{1, 1, 1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 0, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 0, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1, 1, 1}};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int[][] f1340b = {new int[]{1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 0, 1, 0, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1}};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int[][] f1341c = {new int[]{-1, -1, -1, -1, -1, -1, -1}, new int[]{6, 18, -1, -1, -1, -1, -1}, new int[]{6, 22, -1, -1, -1, -1, -1}, new int[]{6, 26, -1, -1, -1, -1, -1}, new int[]{6, 30, -1, -1, -1, -1, -1}, new int[]{6, 34, -1, -1, -1, -1, -1}, new int[]{6, 22, 38, -1, -1, -1, -1}, new int[]{6, 24, 42, -1, -1, -1, -1}, new int[]{6, 26, 46, -1, -1, -1, -1}, new int[]{6, 28, 50, -1, -1, -1, -1}, new int[]{6, 30, 54, -1, -1, -1, -1}, new int[]{6, 32, 58, -1, -1, -1, -1}, new int[]{6, 34, 62, -1, -1, -1, -1}, new int[]{6, 26, 46, 66, -1, -1, -1}, new int[]{6, 26, 48, 70, -1, -1, -1}, new int[]{6, 26, 50, 74, -1, -1, -1}, new int[]{6, 30, 54, 78, -1, -1, -1}, new int[]{6, 30, 56, 82, -1, -1, -1}, new int[]{6, 30, 58, 86, -1, -1, -1}, new int[]{6, 34, 62, 90, -1, -1, -1}, new int[]{6, 28, 50, 72, 94, -1, -1}, new int[]{6, 26, 50, 74, 98, -1, -1}, new int[]{6, 30, 54, 78, 102, -1, -1}, new int[]{6, 28, 54, 80, 106, -1, -1}, new int[]{6, 32, 58, 84, 110, -1, -1}, new int[]{6, 30, 58, 86, 114, -1, -1}, new int[]{6, 34, 62, 90, 118, -1, -1}, new int[]{6, 26, 50, 74, 98, 122, -1}, new int[]{6, 30, 54, 78, 102, 126, -1}, new int[]{6, 26, 52, 78, 104, 130, -1}, new int[]{6, 30, 56, 82, 108, Token.EXPR_VOID, -1}, new int[]{6, 34, 60, 86, 112, Token.TYPEOFNAME, -1}, new int[]{6, 30, 58, 86, 114, Token.LOCAL_BLOCK, -1}, new int[]{6, 34, 62, 90, 118, Token.XML, -1}, new int[]{6, 30, 54, 78, 102, 126, 150}, new int[]{6, 24, 50, 76, 102, 128, 154}, new int[]{6, 28, 54, 80, 106, Token.TARGET, 158}, new int[]{6, 32, 58, 84, 110, Token.JSR, Token.COMMENT}, new int[]{6, 26, 54, 82, 110, Token.TYPEOFNAME, 166}, new int[]{6, 30, 58, 86, 114, Token.LOCAL_BLOCK, Context.VERSION_1_7}};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int[][] f1342d = {new int[]{8, 0}, new int[]{8, 1}, new int[]{8, 2}, new int[]{8, 3}, new int[]{8, 4}, new int[]{8, 5}, new int[]{8, 7}, new int[]{8, 8}, new int[]{7, 8}, new int[]{5, 8}, new int[]{4, 8}, new int[]{3, 8}, new int[]{2, 8}, new int[]{1, 8}, new int[]{0, 8}};

    /* JADX WARN: Removed duplicated region for block: B:105:0x0237  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x023a  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x023e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void a(c.e.c.v.a r20, c.e.c.a0.c.f r21, c.e.c.a0.c.j r22, int r23, c.e.c.a0.e.b r24) throws c.e.c.t {
        /*
            Method dump skipped, instruction units count: 720
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c.e.c.a0.e.d.a(c.e.c.v.a, c.e.c.a0.c.f, c.e.c.a0.c.j, int, c.e.c.a0.e.b):void");
    }

    public static int b(int i2, int i3) {
        if (i3 == 0) {
            throw new IllegalArgumentException("0 polynomial");
        }
        int iF = f(i3);
        int iF2 = i2 << (iF - 1);
        while (f(iF2) >= iF) {
            iF2 ^= i3 << (f(iF2) - iF);
        }
        return iF2;
    }

    public static void c(int i2, int i3, b bVar) throws t {
        for (int i4 = 0; i4 < 8; i4++) {
            int i5 = i2 + i4;
            if (!g(bVar.a(i5, i3))) {
                throw new t();
            }
            bVar.b(i5, i3, 0);
        }
    }

    public static void d(int i2, int i3, b bVar) {
        for (int i4 = 0; i4 < 7; i4++) {
            int[] iArr = a[i4];
            for (int i5 = 0; i5 < 7; i5++) {
                bVar.b(i2 + i5, i3 + i4, iArr[i5]);
            }
        }
    }

    public static void e(int i2, int i3, b bVar) throws t {
        for (int i4 = 0; i4 < 7; i4++) {
            int i5 = i3 + i4;
            if (!g(bVar.a[i5][i2])) {
                throw new t();
            }
            bVar.a[i5][i2] = (byte) 0;
        }
    }

    public static int f(int i2) {
        return 32 - Integer.numberOfLeadingZeros(i2);
    }

    public static boolean g(int i2) {
        return i2 == -1;
    }
}

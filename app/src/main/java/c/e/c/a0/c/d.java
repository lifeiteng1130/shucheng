package c.e.c.a0.c;

import java.io.UnsupportedEncodingException;

/* JADX INFO: compiled from: DecodedBitStreamParser.java */
/* JADX INFO: loaded from: classes.dex */
public final class d {
    public static final char[] a = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ $%*+-./:".toCharArray();

    /* JADX WARN: Removed duplicated region for block: B:26:0x006a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void a(c.e.c.v.c r3, java.lang.StringBuilder r4, int r5, boolean r6) throws c.e.c.g {
        /*
            int r0 = r4.length()
        L4:
            r1 = 1
            if (r5 <= r1) goto L2d
            int r1 = r3.a()
            r2 = 11
            if (r1 < r2) goto L28
            int r1 = r3.b(r2)
            int r2 = r1 / 45
            char r2 = f(r2)
            r4.append(r2)
            int r1 = r1 % 45
            char r1 = f(r1)
            r4.append(r1)
            int r5 = r5 + (-2)
            goto L4
        L28:
            c.e.c.g r3 = c.e.c.g.getFormatInstance()
            throw r3
        L2d:
            if (r5 != r1) goto L47
            int r5 = r3.a()
            r2 = 6
            if (r5 < r2) goto L42
            int r3 = r3.b(r2)
            char r3 = f(r3)
            r4.append(r3)
            goto L47
        L42:
            c.e.c.g r3 = c.e.c.g.getFormatInstance()
            throw r3
        L47:
            if (r6 == 0) goto L72
        L49:
            int r3 = r4.length()
            if (r0 >= r3) goto L72
            char r3 = r4.charAt(r0)
            r5 = 37
            if (r3 != r5) goto L6f
            int r3 = r4.length()
            int r3 = r3 - r1
            if (r0 >= r3) goto L6a
            int r3 = r0 + 1
            char r6 = r4.charAt(r3)
            if (r6 != r5) goto L6a
            r4.deleteCharAt(r3)
            goto L6f
        L6a:
            r3 = 29
            r4.setCharAt(r0, r3)
        L6f:
            int r0 = r0 + 1
            goto L49
        L72:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: c.e.c.a0.c.d.a(c.e.c.v.c, java.lang.StringBuilder, int, boolean):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:128:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00a2 A[PHI: r10 r20
  0x00a2: PHI (r10v6 int) = (r10v1 int), (r10v5 int), (r10v1 int) binds: [B:37:0x0085, B:45:0x009d, B:32:0x0078] A[DONT_GENERATE, DONT_INLINE]
  0x00a2: PHI (r20v6 byte[]) = (r20v5 byte[]), (r20v5 byte[]), (r20v7 byte[]) binds: [B:37:0x0085, B:45:0x009d, B:32:0x0078] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x010f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void b(c.e.c.v.c r21, java.lang.StringBuilder r22, int r23, c.e.c.v.d r24, java.util.Collection<byte[]> r25, java.util.Map<c.e.c.e, ?> r26) throws c.e.c.g {
        /*
            Method dump skipped, instruction units count: 382
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c.e.c.a0.c.d.b(c.e.c.v.c, java.lang.StringBuilder, int, c.e.c.v.d, java.util.Collection, java.util.Map):void");
    }

    public static void c(c.e.c.v.c cVar, StringBuilder sb, int i2) throws c.e.c.g {
        if (i2 * 13 > cVar.a()) {
            throw c.e.c.g.getFormatInstance();
        }
        byte[] bArr = new byte[i2 * 2];
        int i3 = 0;
        while (i2 > 0) {
            int iB = cVar.b(13);
            int i4 = (iB % 96) | ((iB / 96) << 8);
            int i5 = i4 + (i4 < 959 ? 41377 : 42657);
            bArr[i3] = (byte) (i5 >> 8);
            bArr[i3 + 1] = (byte) i5;
            i3 += 2;
            i2--;
        }
        try {
            sb.append(new String(bArr, "GB2312"));
        } catch (UnsupportedEncodingException unused) {
            throw c.e.c.g.getFormatInstance();
        }
    }

    public static void d(c.e.c.v.c cVar, StringBuilder sb, int i2) throws c.e.c.g {
        if (i2 * 13 > cVar.a()) {
            throw c.e.c.g.getFormatInstance();
        }
        byte[] bArr = new byte[i2 * 2];
        int i3 = 0;
        while (i2 > 0) {
            int iB = cVar.b(13);
            int i4 = (iB % 192) | ((iB / 192) << 8);
            int i5 = i4 + (i4 < 7936 ? 33088 : 49472);
            bArr[i3] = (byte) (i5 >> 8);
            bArr[i3 + 1] = (byte) i5;
            i3 += 2;
            i2--;
        }
        try {
            sb.append(new String(bArr, "SJIS"));
        } catch (UnsupportedEncodingException unused) {
            throw c.e.c.g.getFormatInstance();
        }
    }

    public static void e(c.e.c.v.c cVar, StringBuilder sb, int i2) throws c.e.c.g {
        while (i2 >= 3) {
            if (cVar.a() < 10) {
                throw c.e.c.g.getFormatInstance();
            }
            int iB = cVar.b(10);
            if (iB >= 1000) {
                throw c.e.c.g.getFormatInstance();
            }
            sb.append(f(iB / 100));
            sb.append(f((iB / 10) % 10));
            sb.append(f(iB % 10));
            i2 -= 3;
        }
        if (i2 == 2) {
            if (cVar.a() < 7) {
                throw c.e.c.g.getFormatInstance();
            }
            int iB2 = cVar.b(7);
            if (iB2 >= 100) {
                throw c.e.c.g.getFormatInstance();
            }
            sb.append(f(iB2 / 10));
            sb.append(f(iB2 % 10));
            return;
        }
        if (i2 == 1) {
            if (cVar.a() < 4) {
                throw c.e.c.g.getFormatInstance();
            }
            int iB3 = cVar.b(4);
            if (iB3 >= 10) {
                throw c.e.c.g.getFormatInstance();
            }
            sb.append(f(iB3));
        }
    }

    public static char f(int i2) throws c.e.c.g {
        char[] cArr = a;
        if (i2 < cArr.length) {
            return cArr[i2];
        }
        throw c.e.c.g.getFormatInstance();
    }
}

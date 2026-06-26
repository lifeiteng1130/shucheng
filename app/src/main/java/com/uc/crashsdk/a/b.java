package com.uc.crashsdk.a;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.mozilla.javascript.Token;

/* JADX INFO: compiled from: ProGuard */
/* JADX INFO: loaded from: classes.dex */
public final class b {
    private static final int[] a = {126, Token.DOTQUERY, 115, 241, 101, 198, 215, Token.EXPR_VOID};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int[] f4504b = {Token.CATCH, 185, 233, 226, Token.EMPTY, Token.LOCAL_BLOCK, 151, 176};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int[] f4505c = {238, 185, 233, 179, Token.EMPTY, Token.LOCAL_BLOCK, 151, Token.LAST_TOKEN};

    public static String a(String str) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        File file = new File(str);
        FileInputStream fileInputStream3 = null;
        if (!file.exists()) {
            return null;
        }
        try {
            fileInputStream2 = new FileInputStream(file);
        } catch (Exception e2) {
            e = e2;
            fileInputStream = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            byte[] bArr = new byte[(int) file.length()];
            fileInputStream2.read(bArr);
            g.a(fileInputStream2);
            byte[] bArrA = a(bArr, a);
            if (bArrA == null || bArrA.length <= 0) {
                g.a((Closeable) null);
                return null;
            }
            int length = bArrA.length - 1;
            String str2 = bArrA[length] == 10 ? new String(bArrA, 0, length) : new String(bArrA);
            g.a((Closeable) null);
            return str2;
        } catch (Exception e3) {
            fileInputStream = fileInputStream2;
            e = e3;
            try {
                g.a(e);
                g.a(fileInputStream);
                return null;
            } catch (Throwable th2) {
                th = th2;
                fileInputStream3 = fileInputStream;
                g.a(fileInputStream3);
                throw th;
            }
        } catch (Throwable th3) {
            fileInputStream3 = fileInputStream2;
            th = th3;
            g.a(fileInputStream3);
            throw th;
        }
    }

    private static byte[] b(byte[] bArr, int[] iArr) {
        if (bArr != null && iArr != null && iArr.length == 8) {
            int length = bArr.length;
            try {
                byte[] bArr2 = new byte[length + 2];
                byte b2 = 0;
                for (int i2 = 0; i2 < length; i2++) {
                    byte b3 = bArr[i2];
                    bArr2[i2] = (byte) (iArr[i2 % 8] ^ b3);
                    b2 = (byte) (b2 ^ b3);
                }
                bArr2[length] = (byte) (iArr[0] ^ b2);
                bArr2[length + 1] = (byte) (iArr[1] ^ b2);
                return bArr2;
            } catch (Exception e2) {
                g.a(e2);
            }
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0022, code lost:
    
        r1 = com.uc.crashsdk.a.g.e(r0);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String a(java.lang.String r7, java.lang.String r8, boolean r9) {
        /*
            if (r9 != 0) goto L3
            return r7
        L3:
            boolean r0 = com.uc.crashsdk.a.g.a(r7)
            if (r0 == 0) goto La
            return r7
        La:
            java.io.File r0 = new java.io.File
            r0.<init>(r7)
            boolean r1 = r0.exists()
            if (r1 == 0) goto La8
            long r1 = r0.length()
            r3 = 3145728(0x300000, double:1.554196E-317)
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 <= 0) goto L22
            goto La8
        L22:
            byte[] r1 = com.uc.crashsdk.a.g.e(r0)
            if (r1 == 0) goto La8
            int r2 = r1.length
            if (r2 > 0) goto L2d
            goto La8
        L2d:
            r2 = 1
            if (r9 == 0) goto L78
            r9 = 0
            java.io.ByteArrayOutputStream r3 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Throwable -> L49
            r3.<init>()     // Catch: java.lang.Throwable -> L49
            java.util.zip.GZIPOutputStream r4 = new java.util.zip.GZIPOutputStream     // Catch: java.lang.Throwable -> L44
            r4.<init>(r3)     // Catch: java.lang.Throwable -> L44
            r4.write(r1)     // Catch: java.lang.Throwable -> L42
            r3.flush()     // Catch: java.lang.Throwable -> L42
            goto L50
        L42:
            r9 = move-exception
            goto L4d
        L44:
            r4 = move-exception
            r6 = r4
            r4 = r9
            r9 = r6
            goto L4d
        L49:
            r3 = move-exception
            r4 = r9
            r9 = r3
            r3 = r4
        L4d:
            com.uc.crashsdk.a.g.a(r9)     // Catch: java.lang.Throwable -> L70
        L50:
            com.uc.crashsdk.a.g.a(r3)
            com.uc.crashsdk.a.g.a(r4)
            byte[] r1 = r3.toByteArray()     // Catch: java.lang.Throwable -> L5c
            r9 = 1
            goto L61
        L5c:
            r9 = move-exception
            com.uc.crashsdk.a.g.a(r9)
            r9 = 0
        L61:
            if (r9 == 0) goto L6f
            if (r1 == 0) goto L6f
            int r9 = r1.length
            if (r9 > 0) goto L69
            goto L6f
        L69:
            java.lang.String r8 = c.a.a.a.a.i(r7, r8)
            r9 = 1
            goto L7a
        L6f:
            return r7
        L70:
            r7 = move-exception
            com.uc.crashsdk.a.g.a(r3)
            com.uc.crashsdk.a.g.a(r4)
            throw r7
        L78:
            r9 = 0
            r8 = r7
        L7a:
            if (r9 == 0) goto La8
            java.lang.String r9 = r0.getName()
            boolean r9 = r8.equals(r9)
            if (r9 == 0) goto L8e
            java.lang.String r9 = ".tmp"
            java.lang.String r9 = c.a.a.a.a.i(r8, r9)
            r3 = 1
            goto L90
        L8e:
            r3 = 0
            r9 = r8
        L90:
            java.io.File r4 = new java.io.File
            r4.<init>(r9)
            boolean r9 = com.uc.crashsdk.a.g.a(r4, r1)
            if (r9 != 0) goto L9d
            r2 = 0
            goto La5
        L9d:
            if (r3 == 0) goto La5
            r0.delete()
            r4.renameTo(r0)
        La5:
            if (r2 == 0) goto La8
            return r8
        La8:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.a.b.a(java.lang.String, java.lang.String, boolean):java.lang.String");
    }

    private static byte[] a(byte[] bArr, int[] iArr) {
        if (bArr.length - 0 >= 2 && iArr != null && iArr.length == 8) {
            int length = (bArr.length - 2) - 0;
            try {
                byte[] bArr2 = new byte[length];
                byte b2 = 0;
                for (int i2 = 0; i2 < length; i2++) {
                    byte b3 = (byte) (bArr[i2 + 0] ^ iArr[i2 % 8]);
                    bArr2[i2] = b3;
                    b2 = (byte) (b2 ^ b3);
                }
                if (bArr[length + 0] == ((byte) ((iArr[0] ^ b2) & 255)) && bArr[length + 1 + 0] == ((byte) ((iArr[1] ^ b2) & 255))) {
                    return bArr2;
                }
                return null;
            } catch (Exception e2) {
                g.a(e2);
            }
        }
        return null;
    }

    public static boolean a(String str, String str2) {
        FileOutputStream fileOutputStream;
        try {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            fileOutputStream = new FileOutputStream(file);
        } catch (Throwable th) {
            g.a(th);
            fileOutputStream = null;
        }
        boolean z = false;
        if (fileOutputStream == null) {
            return false;
        }
        byte[] bArrB = b(str2.getBytes(), a);
        if (bArrB == null) {
            return false;
        }
        try {
            fileOutputStream.write(bArrB);
            z = true;
        } finally {
            try {
            } finally {
            }
        }
        return z;
    }
}

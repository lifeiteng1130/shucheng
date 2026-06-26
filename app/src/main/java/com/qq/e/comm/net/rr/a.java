package com.qq.e.comm.net.rr;

import android.annotation.TargetApi;
import android.util.Base64;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Cipher f2863b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Cipher f2864c;
    private static final byte[] a = {91, -62};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f2865d = String.format("AES/%s/PKCS7Padding", "ECB");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final byte[] f2866e = Base64.decode("4M3PpUC4Vu1uMp+Y0Mxd+vfc6v4ggJAINfgTlH74pis=", 0);

    /* JADX INFO: renamed from: com.qq.e.comm.net.rr.a$a, reason: collision with other inner class name */
    public static class C0071a extends Exception {
        public C0071a(String str, Throwable th) {
            super(str, th);
        }
    }

    public static class b extends Exception {
        public b(String str, Throwable th) {
            super(str, th);
        }
    }

    private static byte[] a(byte[] bArr) throws C0071a {
        Cipher cipher;
        synchronized (a.class) {
            cipher = f2864c;
            if (cipher == null) {
                try {
                    cipher = Cipher.getInstance(f2865d);
                    cipher.init(2, new SecretKeySpec(f2866e, "AES"));
                    f2864c = cipher;
                } catch (Exception e2) {
                    throw new C0071a("Fail To Init Cipher", e2);
                }
            }
        }
        try {
            return cipher.doFinal(bArr);
        } catch (Exception e3) {
            throw new C0071a("Exception While dencrypt byte array", e3);
        }
    }

    private static byte[] b(byte[] bArr) throws C0071a {
        Cipher cipher;
        synchronized (a.class) {
            cipher = f2863b;
            if (cipher == null) {
                try {
                    cipher = Cipher.getInstance(f2865d);
                    cipher.init(1, new SecretKeySpec(f2866e, "AES"));
                    f2863b = cipher;
                } catch (Exception e2) {
                    throw new C0071a("Fail To Init Cipher", e2);
                }
            }
        }
        try {
            return cipher.doFinal(bArr);
        } catch (Exception e3) {
            throw new C0071a("Exception While encrypt byte array", e3);
        }
    }

    public static byte[] c(byte[] bArr) throws b {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        try {
            dataOutputStream.write(a);
            dataOutputStream.writeByte(1);
            dataOutputStream.writeByte(2);
            dataOutputStream.write(b(f(bArr)));
            dataOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e2) {
            throw new b("Exception while packaging byte array", e2);
        }
    }

    @TargetApi(9)
    public static byte[] d(byte[] bArr) throws b {
        if (bArr == null || bArr.length < 4) {
            throw new b("S2SS Package FormatError", null);
        }
        try {
            byte[] bArr2 = new byte[4];
            new DataInputStream(new ByteArrayInputStream(bArr)).read(bArr2);
            byte[] bArr3 = a;
            if (bArr3[0] == bArr2[0] && bArr3[1] == bArr2[1] && 1 == bArr2[2] && 2 == bArr2[3]) {
                return e(a(Arrays.copyOfRange(bArr, 4, bArr.length)));
            }
            throw new b("S2SS Package Magic/Version FormatError", null);
        } catch (Exception e2) {
            throw new b("Exception while packaging byte array", e2);
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(8:7|(2:43|8)|(5:44|9|(1:11)(1:51)|30|52)|12|46|13|30|52) */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0037, code lost:
    
        r6 = e;
     */
    /* JADX WARN: Not initialized variable reg: 3, insn: 0x0056: MOVE (r0 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]), block:B:32:0x0055 */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0059 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static byte[] e(byte[] r6) throws java.lang.Throwable {
        /*
            r0 = 0
            if (r6 == 0) goto L68
            int r1 = r6.length
            if (r1 != 0) goto L7
            goto L68
        L7:
            java.io.ByteArrayInputStream r1 = new java.io.ByteArrayInputStream
            r1.<init>(r6)
            java.io.ByteArrayOutputStream r6 = new java.io.ByteArrayOutputStream
            r6.<init>()
            r2 = 1024(0x400, float:1.435E-42)
            byte[] r2 = new byte[r2]
            java.util.zip.GZIPInputStream r3 = new java.util.zip.GZIPInputStream     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L3d
            r3.<init>(r1)     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L3d
        L1a:
            int r4 = r3.read(r2)     // Catch: java.lang.Exception -> L39 java.lang.Throwable -> L54
            r5 = -1
            if (r4 == r5) goto L26
            r5 = 0
            r6.write(r2, r5, r4)     // Catch: java.lang.Exception -> L39 java.lang.Throwable -> L54
            goto L1a
        L26:
            r6.flush()     // Catch: java.lang.Exception -> L39 java.lang.Throwable -> L54
            byte[] r0 = r6.toByteArray()     // Catch: java.lang.Exception -> L39 java.lang.Throwable -> L54
            r3.close()     // Catch: java.lang.Exception -> L37
            r1.close()     // Catch: java.lang.Exception -> L37
            r6.close()     // Catch: java.lang.Exception -> L37
            goto L52
        L37:
            r6 = move-exception
            goto L4f
        L39:
            r2 = move-exception
            goto L3f
        L3b:
            r2 = move-exception
            goto L57
        L3d:
            r2 = move-exception
            r3 = r0
        L3f:
            r2.printStackTrace()     // Catch: java.lang.Throwable -> L54
            if (r3 == 0) goto L47
            r3.close()     // Catch: java.lang.Exception -> L4e
        L47:
            r1.close()     // Catch: java.lang.Exception -> L4e
            r6.close()     // Catch: java.lang.Exception -> L4e
            goto L52
        L4e:
            r6 = move-exception
        L4f:
            r6.printStackTrace()
        L52:
            r6 = r0
            goto L68
        L54:
            r0 = move-exception
            r2 = r0
            r0 = r3
        L57:
            if (r0 == 0) goto L5c
            r0.close()     // Catch: java.lang.Exception -> L63
        L5c:
            r1.close()     // Catch: java.lang.Exception -> L63
            r6.close()     // Catch: java.lang.Exception -> L63
            goto L67
        L63:
            r6 = move-exception
            r6.printStackTrace()
        L67:
            throw r2
        L68:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.net.rr.a.e(byte[]):byte[]");
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x0043 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static byte[] f(byte[] r3) throws java.lang.Throwable {
        /*
            r0 = 0
            if (r3 == 0) goto L4f
            int r1 = r3.length
            if (r1 != 0) goto L7
            goto L4f
        L7:
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream
            r1.<init>()
            java.util.zip.GZIPOutputStream r2 = new java.util.zip.GZIPOutputStream     // Catch: java.lang.Throwable -> L29 java.lang.Exception -> L2b
            r2.<init>(r1)     // Catch: java.lang.Throwable -> L29 java.lang.Exception -> L2b
            r2.write(r3)     // Catch: java.lang.Exception -> L27 java.lang.Throwable -> L3f
            r2.finish()     // Catch: java.lang.Exception -> L27 java.lang.Throwable -> L3f
            byte[] r3 = r1.toByteArray()     // Catch: java.lang.Exception -> L27 java.lang.Throwable -> L3f
            r2.close()     // Catch: java.lang.Exception -> L22
            r1.close()     // Catch: java.lang.Exception -> L22
            goto L4f
        L22:
            r0 = move-exception
            r0.printStackTrace()
            goto L4f
        L27:
            r3 = move-exception
            goto L2d
        L29:
            r3 = move-exception
            goto L41
        L2b:
            r3 = move-exception
            r2 = r0
        L2d:
            r3.printStackTrace()     // Catch: java.lang.Throwable -> L3f
            if (r2 == 0) goto L35
            r2.close()     // Catch: java.lang.Exception -> L39
        L35:
            r1.close()     // Catch: java.lang.Exception -> L39
            goto L3d
        L39:
            r3 = move-exception
            r3.printStackTrace()
        L3d:
            r3 = r0
            goto L4f
        L3f:
            r3 = move-exception
            r0 = r2
        L41:
            if (r0 == 0) goto L46
            r0.close()     // Catch: java.lang.Exception -> L4a
        L46:
            r1.close()     // Catch: java.lang.Exception -> L4a
            goto L4e
        L4a:
            r0 = move-exception
            r0.printStackTrace()
        L4e:
            throw r3
        L4f:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.net.rr.a.f(byte[]):byte[]");
    }
}

package e.a.a.h;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: EncoderUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class k {

    @NotNull
    public static final k a = new k();

    @Nullable
    public final byte[] a(@Nullable byte[] bArr, @Nullable byte[] bArr2, @Nullable String str, @Nullable byte[] bArr3) {
        f.c0.c.j.c(str);
        return d(bArr, bArr2, "AES", str, bArr3, false);
    }

    @Nullable
    public final byte[] b(@Nullable byte[] bArr, @Nullable byte[] bArr2, @Nullable String str, @Nullable byte[] bArr3) {
        f.c0.c.j.c(str);
        return d(bArr, bArr2, "AES", str, bArr3, true);
    }

    @NotNull
    public final String c(@NotNull String str) {
        f.c0.c.j.e(str, "src");
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        int i2 = 0;
        while (i2 < length) {
            char cCharAt = str.charAt(i2);
            i2++;
            if (!('0' <= cCharAt && cCharAt <= '9')) {
                if (!('A' <= cCharAt && cCharAt <= 'Z')) {
                    if (!('a' <= cCharAt && cCharAt <= 'z')) {
                        sb.append(cCharAt < 16 ? "%0" : cCharAt < 256 ? "%" : "%u");
                        c.b.a.m.f.N0(16);
                        String string = Integer.toString(cCharAt, 16);
                        f.c0.c.j.d(string, "java.lang.Integer.toStri…(this, checkRadix(radix))");
                        sb.append(string);
                    }
                }
            }
            sb.append(cCharAt);
        }
        String string2 = sb.toString();
        f.c0.c.j.d(string2, "tmp.toString()");
        return string2;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x003a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final byte[] d(byte[] r4, byte[] r5, java.lang.String r6, java.lang.String r7, byte[] r8, boolean r9) {
        /*
            r3 = this;
            if (r4 == 0) goto L47
            int r0 = r4.length
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L9
            r0 = 1
            goto La
        L9:
            r0 = 0
        La:
            if (r0 != 0) goto L47
            if (r5 == 0) goto L47
            int r0 = r5.length
            if (r0 != 0) goto L13
            r0 = 1
            goto L14
        L13:
            r0 = 0
        L14:
            if (r0 == 0) goto L17
            goto L47
        L17:
            javax.crypto.spec.SecretKeySpec r0 = new javax.crypto.spec.SecretKeySpec     // Catch: java.lang.Throwable -> L43
            r0.<init>(r5, r6)     // Catch: java.lang.Throwable -> L43
            javax.crypto.Cipher r5 = javax.crypto.Cipher.getInstance(r7)     // Catch: java.lang.Throwable -> L43
            r6 = 2
            if (r8 == 0) goto L37
            int r7 = r8.length     // Catch: java.lang.Throwable -> L43
            if (r7 != 0) goto L27
            r1 = 1
        L27:
            if (r1 == 0) goto L2a
            goto L37
        L2a:
            javax.crypto.spec.IvParameterSpec r7 = new javax.crypto.spec.IvParameterSpec     // Catch: java.lang.Throwable -> L43
            r7.<init>(r8)     // Catch: java.lang.Throwable -> L43
            if (r9 == 0) goto L32
            goto L33
        L32:
            r2 = 2
        L33:
            r5.init(r2, r0, r7)     // Catch: java.lang.Throwable -> L43
            goto L3e
        L37:
            if (r9 == 0) goto L3a
            goto L3b
        L3a:
            r2 = 2
        L3b:
            r5.init(r2, r0)     // Catch: java.lang.Throwable -> L43
        L3e:
            byte[] r4 = r5.doFinal(r4)     // Catch: java.lang.Throwable -> L43
            goto L48
        L43:
            r4 = move-exception
            r4.printStackTrace()
        L47:
            r4 = 0
        L48:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: e.a.a.h.k.d(byte[], byte[], java.lang.String, java.lang.String, byte[], boolean):byte[]");
    }
}

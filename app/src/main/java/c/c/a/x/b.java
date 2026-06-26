package c.c.a.x;

/* JADX INFO: loaded from: classes.dex */
public final class b {
    public static final char[] a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x002c: MOVE (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:13:0x002c */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0050 A[LOOP:0: B:34:0x004e->B:35:0x0050, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x003d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:58:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String a(java.io.File r7) throws java.lang.Throwable {
        /*
            r0 = 0
            if (r7 != 0) goto L5
        L3:
            r7 = r0
            goto L41
        L5:
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L32 java.io.IOException -> L34 java.security.NoSuchAlgorithmException -> L36
            r1.<init>(r7)     // Catch: java.lang.Throwable -> L32 java.io.IOException -> L34 java.security.NoSuchAlgorithmException -> L36
            java.lang.String r7 = "MD5"
            java.security.MessageDigest r7 = java.security.MessageDigest.getInstance(r7)     // Catch: java.lang.Throwable -> L2b java.io.IOException -> L2e java.security.NoSuchAlgorithmException -> L30
            java.security.DigestInputStream r2 = new java.security.DigestInputStream     // Catch: java.lang.Throwable -> L2b java.io.IOException -> L2e java.security.NoSuchAlgorithmException -> L30
            r2.<init>(r1, r7)     // Catch: java.lang.Throwable -> L2b java.io.IOException -> L2e java.security.NoSuchAlgorithmException -> L30
            r7 = 262144(0x40000, float:3.67342E-40)
            byte[] r7 = new byte[r7]     // Catch: java.lang.Throwable -> L2b java.io.IOException -> L2e java.security.NoSuchAlgorithmException -> L30
        L19:
            int r3 = r2.read(r7)     // Catch: java.lang.Throwable -> L2b java.io.IOException -> L2e java.security.NoSuchAlgorithmException -> L30
            if (r3 > 0) goto L19
            java.security.MessageDigest r7 = r2.getMessageDigest()     // Catch: java.lang.Throwable -> L2b java.io.IOException -> L2e java.security.NoSuchAlgorithmException -> L30
            byte[] r7 = r7.digest()     // Catch: java.lang.Throwable -> L2b java.io.IOException -> L2e java.security.NoSuchAlgorithmException -> L30
            r1.close()     // Catch: java.io.IOException -> L41
            goto L41
        L2b:
            r7 = move-exception
            r0 = r1
            goto L72
        L2e:
            r7 = move-exception
            goto L38
        L30:
            r7 = move-exception
            goto L38
        L32:
            r7 = move-exception
            goto L72
        L34:
            r7 = move-exception
            goto L37
        L36:
            r7 = move-exception
        L37:
            r1 = r0
        L38:
            r7.printStackTrace()     // Catch: java.lang.Throwable -> L2b
            if (r1 == 0) goto L3
            r1.close()     // Catch: java.io.IOException -> L3
            goto L3
        L41:
            if (r7 != 0) goto L44
            goto L71
        L44:
            int r1 = r7.length
            if (r1 > 0) goto L48
            goto L71
        L48:
            int r0 = r1 << 1
            char[] r0 = new char[r0]
            r2 = 0
            r3 = 0
        L4e:
            if (r2 >= r1) goto L6b
            int r4 = r3 + 1
            char[] r5 = c.c.a.x.b.a
            r6 = r7[r2]
            int r6 = r6 >>> 4
            r6 = r6 & 15
            char r6 = r5[r6]
            r0[r3] = r6
            int r3 = r4 + 1
            r6 = r7[r2]
            r6 = r6 & 15
            char r5 = r5[r6]
            r0[r4] = r5
            int r2 = r2 + 1
            goto L4e
        L6b:
            java.lang.String r7 = new java.lang.String
            r7.<init>(r0)
            r0 = r7
        L71:
            return r0
        L72:
            if (r0 == 0) goto L77
            r0.close()     // Catch: java.io.IOException -> L77
        L77:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: c.c.a.x.b.a(java.io.File):java.lang.String");
    }
}

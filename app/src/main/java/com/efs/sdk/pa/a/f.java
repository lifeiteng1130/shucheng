package com.efs.sdk.pa.a;

import com.efs.sdk.pa.PAMsgListener;
import java.io.BufferedOutputStream;

/* JADX INFO: loaded from: classes.dex */
public final class f implements d {
    public PAMsgListener a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f1901b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f1902c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public BufferedOutputStream f1903d;

    /* JADX WARN: Removed duplicated region for block: B:13:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x007e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static com.efs.sdk.pa.b b(java.lang.String r9, long r10, long r12) {
        /*
            java.lang.String r0 = ")"
            java.lang.String r1 = "{"
            java.lang.String r2 = "("
            r3 = 0
            if (r9 != 0) goto La
            return r3
        La:
            com.efs.sdk.pa.b r4 = new com.efs.sdk.pa.b
            r4.<init>()
            java.lang.String r5 = ":"
            int r5 = r9.indexOf(r5)     // Catch: java.lang.Exception -> Lac
            java.lang.String r6 = ""
            r7 = -1
            if (r5 == r7) goto L2b
            int r5 = r5 + 2
            int r8 = r9.length()     // Catch: java.lang.Exception -> Lac
            if (r5 >= r8) goto L2b
            int r8 = r9.length()     // Catch: java.lang.Exception -> Lac
            java.lang.String r5 = r9.substring(r5, r8)     // Catch: java.lang.Exception -> Lac
            goto L2c
        L2b:
            r5 = r6
        L2c:
            r4.a = r5     // Catch: java.lang.Exception -> Lac
            boolean r5 = r9.contains(r2)     // Catch: java.lang.Exception -> Lac
            java.lang.String r8 = "}"
            if (r5 == 0) goto L57
            boolean r5 = r9.contains(r0)     // Catch: java.lang.Exception -> Lac
            if (r5 == 0) goto L57
            int r1 = r9.indexOf(r2)     // Catch: java.lang.Exception -> Lac
            int r0 = r9.indexOf(r0)     // Catch: java.lang.Exception -> Lac
            if (r1 == r7) goto L7e
            if (r0 == r7) goto L7e
            int r1 = r1 + 1
            int r2 = r9.length()     // Catch: java.lang.Exception -> Lac
            if (r1 >= r2) goto L7e
            if (r0 <= r1) goto L7e
            java.lang.String r0 = r9.substring(r1, r0)     // Catch: java.lang.Exception -> Lac
            goto L7f
        L57:
            boolean r0 = r9.contains(r1)     // Catch: java.lang.Exception -> Lac
            if (r0 == 0) goto L7e
            boolean r0 = r9.contains(r8)     // Catch: java.lang.Exception -> Lac
            if (r0 == 0) goto L7e
            int r0 = r9.indexOf(r1)     // Catch: java.lang.Exception -> Lac
            int r1 = r9.indexOf(r8)     // Catch: java.lang.Exception -> Lac
            if (r0 == r7) goto L7e
            if (r1 == r7) goto L7e
            int r0 = r0 + 1
            int r2 = r9.length()     // Catch: java.lang.Exception -> Lac
            if (r0 >= r2) goto L7e
            if (r1 <= r0) goto L7e
            java.lang.String r0 = r9.substring(r0, r1)     // Catch: java.lang.Exception -> Lac
            goto L7f
        L7e:
            r0 = r6
        L7f:
            r4.f1905b = r0     // Catch: java.lang.Exception -> Lac
            java.lang.String r0 = "null"
            boolean r0 = r9.contains(r0)     // Catch: java.lang.Exception -> Lac
            if (r0 != 0) goto La5
            boolean r0 = r9.contains(r8)     // Catch: java.lang.Exception -> Lac
            if (r0 == 0) goto La5
            int r0 = r9.lastIndexOf(r8)     // Catch: java.lang.Exception -> Lac
            if (r0 == r7) goto La5
            int r0 = r0 + 1
            int r1 = r9.length()     // Catch: java.lang.Exception -> Lac
            if (r0 >= r1) goto La5
            int r1 = r9.length()     // Catch: java.lang.Exception -> Lac
            java.lang.String r6 = r9.substring(r0, r1)     // Catch: java.lang.Exception -> Lac
        La5:
            r4.f1906c = r6     // Catch: java.lang.Exception -> Lac
            r4.f1907d = r10
            r4.f1908e = r12
            return r4
        Lac:
            r9 = move-exception
            r9.printStackTrace()
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.efs.sdk.pa.a.f.b(java.lang.String, long, long):com.efs.sdk.pa.b");
    }

    @Override // com.efs.sdk.pa.a.d
    public final void a(String str, long j2, long j3) {
        com.efs.sdk.pa.b bVarB = b(str, j2, j3);
        if (bVarB != null) {
            if (this.f1901b) {
                bVarB.toString();
            }
            if (this.f1902c != null) {
                try {
                    this.f1903d.write((bVarB.toString() + "\n").getBytes());
                } catch (Exception unused) {
                }
            }
            this.a.msg(bVarB);
        }
    }
}

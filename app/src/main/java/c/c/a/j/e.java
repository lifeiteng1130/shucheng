package c.c.a.j;

import android.content.pm.Signature;
import androidx.annotation.RequiresApi;
import java.security.cert.Certificate;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(api = 21)
public final class e {
    public static p a(String str) throws r {
        Signature[] signatureArr;
        int[] iArr;
        try {
            try {
                d dVarM = c.b.a.m.f.m(str);
                Signature[] signatureArrB = b(new Certificate[][]{dVarM.a});
                c cVar = dVarM.f758b;
                if (cVar != null) {
                    int size = cVar.a.size();
                    signatureArr = new Signature[size];
                    iArr = new int[dVarM.f758b.f757b.size()];
                    for (int i2 = 0; i2 < size; i2++) {
                        signatureArr[i2] = new Signature(dVarM.f758b.a.get(i2).getEncoded());
                        iArr[i2] = dVarM.f758b.f757b.get(i2).intValue();
                    }
                } else {
                    signatureArr = null;
                    iArr = null;
                }
                return new p(signatureArrB, 3, signatureArr, iArr);
            } catch (o unused) {
                return new p(b(c.b.a.m.f.k(str).a), 2, null, null);
            } catch (Exception e2) {
                throw new r(4, "Failed to collect certificates from " + str + " using APK Signature Scheme v3", e2);
            }
        } catch (o unused2) {
            return a.a(str);
        } catch (Exception e3) {
            throw new r(4, "Failed to collect certificates from " + str + " using APK Signature Scheme v2", e3);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x005e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.content.pm.Signature[] b(java.security.cert.Certificate[][] r10) {
        /*
            int r0 = r10.length
            android.content.pm.Signature[] r0 = new android.content.pm.Signature[r0]
            r1 = 0
            r2 = 0
        L5:
            int r3 = r10.length
            if (r2 >= r3) goto L9a
            int r3 = android.os.Build.VERSION.SDK_INT
            r4 = 28
            r5 = 1
            if (r3 > r4) goto L11
            r3 = 1
            goto L12
        L11:
            r3 = 0
        L12:
            if (r3 == 0) goto L87
            java.lang.Class<android.content.pm.Signature> r3 = android.content.pm.Signature.class
            java.lang.Class[] r4 = new java.lang.Class[r5]
            java.lang.Class<java.security.cert.Certificate[]> r6 = java.security.cert.Certificate[].class
            r4[r1] = r6
            java.lang.reflect.Method r6 = c.c.a.a.b.a.f686c
            if (r6 == 0) goto L54
            java.lang.Object[] r7 = new java.lang.Object[r5]     // Catch: java.lang.Throwable -> L2b
            r7[r1] = r4     // Catch: java.lang.Throwable -> L2b
            java.lang.Object r6 = r6.invoke(r3, r7)     // Catch: java.lang.Throwable -> L2b
            java.lang.reflect.Constructor r6 = (java.lang.reflect.Constructor) r6     // Catch: java.lang.Throwable -> L2b
            goto L55
        L2b:
            r6 = move-exception
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "DoubleReflector"
            r7.<init>(r8)
            r8 = 2
            java.lang.Object[] r8 = new java.lang.Object[r8]
            java.lang.String r9 = r3.getName()
            r8[r1] = r9
            java.lang.Integer r9 = java.lang.Integer.valueOf(r5)
            r8[r5] = r9
            java.lang.String r9 = "getConstructor %s<init>%s failed !!!"
            java.lang.String r8 = java.lang.String.format(r9, r8)
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            java.lang.String r8 = "Zeus"
            com.bytedance.pangle.log.ZeusLogger.w(r8, r7, r6)
        L54:
            r6 = 0
        L55:
            if (r6 == 0) goto L58
            goto L5c
        L58:
            java.lang.reflect.Constructor r6 = c.c.a.a.a.a.a(r3, r4)
        L5c:
            if (r6 == 0) goto L61
            r6.setAccessible(r5)
        L61:
            if (r6 == 0) goto L96
            boolean r3 = r6.isAccessible()
            if (r3 == 0) goto L96
            java.lang.Object[] r3 = new java.lang.Object[r5]     // Catch: java.lang.reflect.InvocationTargetException -> L78 java.lang.IllegalAccessException -> L7d java.lang.InstantiationException -> L82
            r4 = r10[r2]     // Catch: java.lang.reflect.InvocationTargetException -> L78 java.lang.IllegalAccessException -> L7d java.lang.InstantiationException -> L82
            r3[r1] = r4     // Catch: java.lang.reflect.InvocationTargetException -> L78 java.lang.IllegalAccessException -> L7d java.lang.InstantiationException -> L82
            java.lang.Object r3 = r6.newInstance(r3)     // Catch: java.lang.reflect.InvocationTargetException -> L78 java.lang.IllegalAccessException -> L7d java.lang.InstantiationException -> L82
            android.content.pm.Signature r3 = (android.content.pm.Signature) r3     // Catch: java.lang.reflect.InvocationTargetException -> L78 java.lang.IllegalAccessException -> L7d java.lang.InstantiationException -> L82
            r0[r2] = r3     // Catch: java.lang.reflect.InvocationTargetException -> L78 java.lang.IllegalAccessException -> L7d java.lang.InstantiationException -> L82
            goto L96
        L78:
            r3 = move-exception
            r3.printStackTrace()
            goto L96
        L7d:
            r3 = move-exception
            r3.printStackTrace()
            goto L96
        L82:
            r3 = move-exception
            r3.printStackTrace()
            goto L96
        L87:
            android.content.pm.Signature r3 = new android.content.pm.Signature
            r4 = r10[r2]
            r4 = r4[r1]
            byte[] r4 = r4.getEncoded()
            r3.<init>(r4)
            r0[r2] = r3
        L96:
            int r2 = r2 + 1
            goto L5
        L9a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: c.c.a.j.e.b(java.security.cert.Certificate[][]):android.content.pm.Signature[]");
    }
}

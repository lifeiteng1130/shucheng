package com.umeng.analytics.pro;

import com.umeng.analytics.pro.bj;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: TDeserializer.java */
/* JADX INFO: loaded from: classes.dex */
public class at {
    private final bp a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final cc f4714b;

    public at() {
        this(new bj.a());
    }

    private bk j(byte[] bArr, ax axVar, ax... axVarArr) {
        this.f4714b.a(bArr);
        int length = axVarArr.length + 1;
        ax[] axVarArr2 = new ax[length];
        int i2 = 0;
        axVarArr2[0] = axVar;
        int i3 = 0;
        while (i3 < axVarArr.length) {
            int i4 = i3 + 1;
            axVarArr2[i4] = axVarArr[i3];
            i3 = i4;
        }
        this.a.j();
        bk bkVarL = null;
        while (i2 < length) {
            bkVarL = this.a.l();
            if (bkVarL.f4761b == 0 || bkVarL.f4762c > axVarArr2[i2].a()) {
                return null;
            }
            if (bkVarL.f4762c != axVarArr2[i2].a()) {
                bs.a(this.a, bkVarL.f4761b);
                this.a.m();
            } else {
                i2++;
                if (i2 < length) {
                    this.a.j();
                }
            }
        }
        return bkVarL;
    }

    public void a(aq aqVar, byte[] bArr) {
        try {
            this.f4714b.a(bArr);
            aqVar.read(this.a);
        } finally {
            this.f4714b.e();
            this.a.B();
        }
    }

    public Byte b(byte[] bArr, ax axVar, ax... axVarArr) {
        return (Byte) a((byte) 3, bArr, axVar, axVarArr);
    }

    public Double c(byte[] bArr, ax axVar, ax... axVarArr) {
        return (Double) a((byte) 4, bArr, axVar, axVarArr);
    }

    public Short d(byte[] bArr, ax axVar, ax... axVarArr) {
        return (Short) a((byte) 6, bArr, axVar, axVarArr);
    }

    public Integer e(byte[] bArr, ax axVar, ax... axVarArr) {
        return (Integer) a((byte) 8, bArr, axVar, axVarArr);
    }

    public Long f(byte[] bArr, ax axVar, ax... axVarArr) {
        return (Long) a((byte) 10, bArr, axVar, axVarArr);
    }

    public String g(byte[] bArr, ax axVar, ax... axVarArr) {
        return (String) a((byte) 11, bArr, axVar, axVarArr);
    }

    public ByteBuffer h(byte[] bArr, ax axVar, ax... axVarArr) {
        return (ByteBuffer) a((byte) 100, bArr, axVar, axVarArr);
    }

    public Short i(byte[] bArr, ax axVar, ax... axVarArr) {
        Short shValueOf;
        try {
            try {
                if (j(bArr, axVar, axVarArr) != null) {
                    this.a.j();
                    shValueOf = Short.valueOf(this.a.l().f4762c);
                } else {
                    shValueOf = null;
                }
                return shValueOf;
            } catch (Exception e2) {
                throw new aw(e2);
            }
        } finally {
            this.f4714b.e();
            this.a.B();
        }
    }

    public at(br brVar) {
        cc ccVar = new cc();
        this.f4714b = ccVar;
        this.a = brVar.a(ccVar);
    }

    public void a(aq aqVar, String str, String str2) {
        try {
            try {
                a(aqVar, str.getBytes(str2));
            } catch (UnsupportedEncodingException unused) {
                throw new aw("JVM DOES NOT SUPPORT ENCODING: " + str2);
            }
        } finally {
            this.a.B();
        }
    }

    public void a(aq aqVar, byte[] bArr, ax axVar, ax... axVarArr) {
        try {
            try {
                if (j(bArr, axVar, axVarArr) != null) {
                    aqVar.read(this.a);
                }
            } catch (Exception e2) {
                throw new aw(e2);
            }
        } finally {
            this.f4714b.e();
            this.a.B();
        }
    }

    public Boolean a(byte[] bArr, ax axVar, ax... axVarArr) {
        return (Boolean) a((byte) 2, bArr, axVar, axVarArr);
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x009e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.lang.Object a(byte r1, byte[] r2, com.umeng.analytics.pro.ax r3, com.umeng.analytics.pro.ax... r4) {
        /*
            r0 = this;
            com.umeng.analytics.pro.bk r2 = r0.j(r2, r3, r4)     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            if (r2 == 0) goto L9e
            r3 = 2
            if (r1 == r3) goto L8f
            r3 = 3
            if (r1 == r3) goto L80
            r3 = 4
            if (r1 == r3) goto L71
            r3 = 6
            if (r1 == r3) goto L62
            r3 = 8
            if (r1 == r3) goto L53
            r3 = 100
            r4 = 11
            if (r1 == r3) goto L48
            r3 = 10
            if (r1 == r3) goto L39
            if (r1 == r4) goto L24
            goto L9e
        L24:
            byte r1 = r2.f4761b     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            if (r1 != r4) goto L9e
            com.umeng.analytics.pro.bp r1 = r0.a     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            java.lang.String r1 = r1.z()     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
        L2e:
            com.umeng.analytics.pro.cc r2 = r0.f4714b
            r2.e()
            com.umeng.analytics.pro.bp r2 = r0.a
            r2.B()
            return r1
        L39:
            byte r1 = r2.f4761b     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            if (r1 != r3) goto L9e
            com.umeng.analytics.pro.bp r1 = r0.a     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            long r1 = r1.x()     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            java.lang.Long r1 = java.lang.Long.valueOf(r1)     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            goto L2e
        L48:
            byte r1 = r2.f4761b     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            if (r1 != r4) goto L9e
            com.umeng.analytics.pro.bp r1 = r0.a     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            java.nio.ByteBuffer r1 = r1.A()     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            goto L2e
        L53:
            byte r1 = r2.f4761b     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            if (r1 != r3) goto L9e
            com.umeng.analytics.pro.bp r1 = r0.a     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            int r1 = r1.w()     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            goto L2e
        L62:
            byte r1 = r2.f4761b     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            if (r1 != r3) goto L9e
            com.umeng.analytics.pro.bp r1 = r0.a     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            short r1 = r1.v()     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            java.lang.Short r1 = java.lang.Short.valueOf(r1)     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            goto L2e
        L71:
            byte r1 = r2.f4761b     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            if (r1 != r3) goto L9e
            com.umeng.analytics.pro.bp r1 = r0.a     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            double r1 = r1.y()     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            java.lang.Double r1 = java.lang.Double.valueOf(r1)     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            goto L2e
        L80:
            byte r1 = r2.f4761b     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            if (r1 != r3) goto L9e
            com.umeng.analytics.pro.bp r1 = r0.a     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            byte r1 = r1.u()     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            java.lang.Byte r1 = java.lang.Byte.valueOf(r1)     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            goto L2e
        L8f:
            byte r1 = r2.f4761b     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            if (r1 != r3) goto L9e
            com.umeng.analytics.pro.bp r1 = r0.a     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            boolean r1 = r1.t()     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            goto L2e
        L9e:
            r1 = 0
            goto L2e
        La0:
            r1 = move-exception
            goto La9
        La2:
            r1 = move-exception
            com.umeng.analytics.pro.aw r2 = new com.umeng.analytics.pro.aw     // Catch: java.lang.Throwable -> La0
            r2.<init>(r1)     // Catch: java.lang.Throwable -> La0
            throw r2     // Catch: java.lang.Throwable -> La0
        La9:
            com.umeng.analytics.pro.cc r2 = r0.f4714b
            r2.e()
            com.umeng.analytics.pro.bp r2 = r0.a
            r2.B()
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.at.a(byte, byte[], com.umeng.analytics.pro.ax, com.umeng.analytics.pro.ax[]):java.lang.Object");
    }

    public void a(aq aqVar, String str) {
        a(aqVar, str.getBytes());
    }
}

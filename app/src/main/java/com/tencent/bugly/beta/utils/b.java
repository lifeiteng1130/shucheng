package com.tencent.bugly.beta.utils;

import java.io.IOException;
import java.util.HashMap;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes.dex */
public class b {
    private String a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f4028c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f4029d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final HashMap<Long, String> f4031f;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private a f4027b = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f4030e = null;

    public b(String str, long j2, long j3) {
        this.a = null;
        this.f4028c = 0L;
        this.f4029d = 0L;
        HashMap<Long, String> map = new HashMap<>();
        this.f4031f = map;
        map.put(1L, "armeabi-v4");
        map.put(2L, "armeabi-v4t");
        map.put(3L, "armeabi-v5t");
        map.put(4L, "armeabi-v5te");
        map.put(5L, "armeabi-v5tej");
        map.put(6L, "armeabi-v6");
        map.put(7L, "armeabi-v6kz");
        map.put(8L, "armeabi-v6t2");
        map.put(9L, "armeabi-v6k");
        map.put(10L, "armeabi-v7a");
        map.put(11L, "armeabi-v6-m");
        map.put(12L, "armeabi-v6s-m");
        map.put(13L, "armeabi-v7e-m");
        map.put(14L, "armeabi-v8a");
        this.a = str;
        this.f4028c = j2;
        this.f4029d = j3;
    }

    private boolean a() {
        return 0 != this.f4029d;
    }

    private synchronized void b() {
        a aVar = this.f4027b;
        if (aVar == null) {
            return;
        }
        if (aVar.a()) {
            this.f4027b = null;
        }
    }

    private synchronized boolean c() {
        if (!a()) {
            return false;
        }
        if (this.f4027b != null) {
            b();
        }
        try {
            a aVar = new a(this.a, this.f4028c);
            this.f4027b = aVar;
            return aVar.b(this.f4029d);
        } catch (Exception e2) {
            e2.getMessage();
            return false;
        }
    }

    private boolean d() {
        if (!c()) {
            b();
            return false;
        }
        e();
        b();
        return true;
    }

    private synchronized boolean e() {
        try {
            if (65 != this.f4027b.f()) {
                return false;
            }
            long jG = this.f4027b.g();
            String strG = g();
            if (strG != null && strG.equals("aeabi")) {
                long length = jG - ((long) strG.length());
                while (length > 0) {
                    long jF = this.f4027b.f();
                    long jG2 = this.f4027b.g() - 5;
                    if (1 == jF) {
                        return a(jG2);
                    }
                    this.f4027b.b(jG2);
                }
                return true;
            }
            return false;
        } catch (IOException e2) {
            e2.getMessage();
            return false;
        }
    }

    private synchronized String f() {
        StringBuilder sb;
        sb = new StringBuilder();
        while (true) {
            try {
                char cB = (char) this.f4027b.b();
                if (cB != 0) {
                    sb.append(cB);
                }
            } catch (IOException e2) {
                e2.getMessage();
                return null;
            }
        }
        return sb.toString();
    }

    private String g() {
        return f();
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x004b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0001 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private synchronized boolean a(long r5) {
        /*
            r4 = this;
            monitor-enter(r4)
        L1:
            r0 = 0
            r2 = 0
            int r3 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
            if (r3 <= 0) goto L64
            com.tencent.bugly.beta.utils.a r0 = r4.f4027b     // Catch: java.lang.Throwable -> L5a java.io.IOException -> L5c
            long r0 = a(r0)     // Catch: java.lang.Throwable -> L5a java.io.IOException -> L5c
            int r1 = (int) r0     // Catch: java.lang.Throwable -> L5a java.io.IOException -> L5c
            r0 = 34
            if (r1 == r0) goto L54
            r0 = 36
            if (r1 == r0) goto L54
            r0 = 38
            if (r1 == r0) goto L54
            r0 = 42
            if (r1 == r0) goto L54
            r0 = 44
            if (r1 == r0) goto L54
            r0 = 70
            if (r1 == r0) goto L54
            switch(r1) {
                case 4: goto L45;
                case 5: goto L45;
                case 6: goto L2e;
                case 7: goto L54;
                case 8: goto L54;
                case 9: goto L54;
                case 10: goto L54;
                case 11: goto L54;
                case 12: goto L54;
                case 13: goto L54;
                case 14: goto L54;
                case 15: goto L54;
                case 16: goto L54;
                case 17: goto L54;
                case 18: goto L54;
                case 19: goto L54;
                case 20: goto L54;
                case 21: goto L54;
                case 22: goto L54;
                case 23: goto L54;
                case 24: goto L54;
                case 25: goto L54;
                case 26: goto L54;
                case 27: goto L54;
                case 28: goto L54;
                case 29: goto L54;
                case 30: goto L54;
                case 31: goto L54;
                case 32: goto L45;
                default: goto L2a;
            }     // Catch: java.lang.Throwable -> L5a java.io.IOException -> L5c
        L2a:
            switch(r1) {
                case 64: goto L54;
                case 65: goto L45;
                case 66: goto L54;
                case 67: goto L45;
                case 68: goto L54;
                default: goto L2d;
            }     // Catch: java.lang.Throwable -> L5a java.io.IOException -> L5c
        L2d:
            goto L52
        L2e:
            com.tencent.bugly.beta.utils.a r5 = r4.f4027b     // Catch: java.lang.Throwable -> L5a java.io.IOException -> L5c
            long r5 = a(r5)     // Catch: java.lang.Throwable -> L5a java.io.IOException -> L5c
            java.util.HashMap<java.lang.Long, java.lang.String> r0 = r4.f4031f     // Catch: java.lang.Throwable -> L5a java.io.IOException -> L5c
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch: java.lang.Throwable -> L5a java.io.IOException -> L5c
            java.lang.Object r5 = r0.get(r5)     // Catch: java.lang.Throwable -> L5a java.io.IOException -> L5c
            java.lang.String r5 = (java.lang.String) r5     // Catch: java.lang.Throwable -> L5a java.io.IOException -> L5c
            r4.f4030e = r5     // Catch: java.lang.Throwable -> L5a java.io.IOException -> L5c
            r5 = 1
            monitor-exit(r4)
            return r5
        L45:
            java.lang.String r0 = r4.f()     // Catch: java.lang.Throwable -> L5a java.io.IOException -> L5c
            if (r0 == 0) goto L1
            int r0 = r0.length()     // Catch: java.lang.Throwable -> L5a java.io.IOException -> L5c
            long r0 = (long) r0
            long r5 = r5 - r0
            goto L1
        L52:
            monitor-exit(r4)
            return r2
        L54:
            com.tencent.bugly.beta.utils.a r0 = r4.f4027b     // Catch: java.lang.Throwable -> L5a java.io.IOException -> L5c
            a(r0)     // Catch: java.lang.Throwable -> L5a java.io.IOException -> L5c
            goto L1
        L5a:
            r5 = move-exception
            goto L62
        L5c:
            r5 = move-exception
            r5.getMessage()     // Catch: java.lang.Throwable -> L5a
            monitor-exit(r4)
            return r2
        L62:
            monitor-exit(r4)
            throw r5
        L64:
            monitor-exit(r4)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.beta.utils.b.a(long):boolean");
    }

    public static String a(String str, long j2, long j3) {
        b bVar = new b(str, j2, j3);
        if (bVar.d()) {
            return bVar.f4030e;
        }
        return null;
    }

    public static synchronized long a(a aVar) {
        long j2;
        byte b2;
        long j3 = 0;
        j2 = 0;
        do {
            b2 = aVar.b();
            j2 |= (((long) b2) & 127) << ((int) j3);
            j3 += 7;
        } while ((b2 & 128) != 0);
        return j2;
    }
}

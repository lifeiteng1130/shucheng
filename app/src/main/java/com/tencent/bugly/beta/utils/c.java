package com.tencent.bugly.beta.utils;

import com.tencent.bugly.proguard.X;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Vector;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes.dex */
public class c {
    private static HashMap<Long, String> a = new HashMap<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f4033c;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.tencent.bugly.beta.utils.a f4032b = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f4034d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f4035e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private HashMap<String, b> f4036f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private byte[] f4037g = new byte[16];

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f4038h = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private long f4039i = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f4040j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private long f4041k = 0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private long f4042l = 0;
    private long m = 0;
    private long n = 0;
    private long o = 0;
    private long p = 0;
    private long q = 0;
    private long r = 0;
    private long s = 0;
    private long t = 0;
    private long u = 0;

    /* JADX INFO: compiled from: BUGLY */
    public static class a {
        private long a = -1;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private long f4043b = 0;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private long f4044c = 0;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private long f4045d = -1;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private long f4046e = -1;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private long f4047f = 0;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private long f4048g = 0;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private long f4049h = 0;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private long f4050i = 0;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private long f4051j = 0;

        public long a() {
            return this.f4045d;
        }

        public long b() {
            return this.f4051j;
        }

        public long c() {
            return this.a;
        }

        public long d() {
            return this.f4046e;
        }

        public long e() {
            return this.f4047f;
        }

        public synchronized void f(long j2) {
            this.f4048g = j2;
        }

        public synchronized void g(long j2) {
            this.a = j2;
        }

        public synchronized void h(long j2) {
            this.f4046e = j2;
        }

        public synchronized void i(long j2) {
            this.f4047f = j2;
        }

        public synchronized void j(long j2) {
            this.f4043b = j2;
        }

        public synchronized void a(long j2) {
            this.f4045d = j2;
        }

        public synchronized void b(long j2) {
            this.f4050i = j2;
        }

        public synchronized void c(long j2) {
            this.f4051j = j2;
        }

        public synchronized void d(long j2) {
            this.f4044c = j2;
        }

        public synchronized void e(long j2) {
            this.f4049h = j2;
        }
    }

    /* JADX INFO: compiled from: BUGLY */
    public static class b {
        private String a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private long f4052b = -1;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private long f4053c = -1;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private long f4054d = 0;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private long f4055e = 0;

        public long a() {
            return this.f4053c;
        }

        public synchronized void b(long j2) {
            this.f4055e = j2;
        }

        public synchronized void c(long j2) {
            this.f4053c = j2;
        }

        public synchronized void d(long j2) {
            this.f4054d = j2;
        }

        public synchronized void a(String str) {
            this.a = str;
        }

        public synchronized void a(long j2) {
            this.f4052b = j2;
        }
    }

    public c(String str) {
        this.f4033c = null;
        this.f4033c = str;
        a.put(3L, "x86");
        a.put(7L, "x86");
        a.put(8L, "mips");
        a.put(10L, "mips");
        a.put(40L, "armeabi");
        a.put(62L, "x86_64");
        a.put(183L, "arm64-v8a");
    }

    private long b(byte b2) {
        if (1 == b2) {
            return 32L;
        }
        return 2 == b2 ? 64L : 0L;
    }

    private synchronized void b() {
        com.tencent.bugly.beta.utils.a aVar = this.f4032b;
        if (aVar == null) {
            return;
        }
        if (aVar.a()) {
            this.f4032b = null;
        }
    }

    private String c() {
        return this.f4040j;
    }

    private long d() {
        return this.n;
    }

    private long e() {
        return this.t;
    }

    private long f() {
        return this.u;
    }

    private synchronized boolean g() {
        if (this.f4032b != null) {
            b();
        }
        try {
            this.f4032b = new com.tencent.bugly.beta.utils.a(this.f4033c, this.f4035e);
        } catch (Exception e2) {
            e2.getMessage();
            return false;
        }
        return true;
    }

    private synchronized boolean h() {
        if (this.f4032b != null) {
            b();
        }
        try {
            this.f4032b = new com.tencent.bugly.beta.utils.a(this.f4033c);
        } catch (Exception e2) {
            e2.getMessage();
            return false;
        }
        return true;
    }

    private boolean i() {
        if (!h()) {
            return false;
        }
        if (j()) {
            b();
            return true;
        }
        b();
        return false;
    }

    private synchronized boolean j() {
        if (!k()) {
            return false;
        }
        try {
            this.f4038h = this.f4032b.i();
            long jI = this.f4032b.i();
            this.f4039i = jI;
            this.f4040j = a(jI, this.f4034d);
            this.f4041k = this.f4032b.g();
            long j2 = this.f4034d;
            if (32 == j2) {
                long jG = this.f4032b.g();
                this.f4041k = jG;
                this.f4042l = jG;
                this.m = this.f4032b.g();
                this.n = this.f4032b.g();
            } else {
                if (64 != j2) {
                    return false;
                }
                long jH = this.f4032b.h();
                this.f4041k = jH;
                this.f4042l = jH;
                this.m = this.f4032b.h();
                this.n = this.f4032b.h();
            }
            this.o = this.f4032b.g();
            this.p = this.f4032b.i();
            this.q = this.f4032b.i();
            this.r = this.f4032b.i();
            this.s = this.f4032b.i();
            this.t = this.f4032b.i();
            this.u = this.f4032b.i();
            return true;
        } catch (IOException e2) {
            e2.getMessage();
            return false;
        }
    }

    private synchronized boolean k() {
        if (!this.f4032b.a(this.f4037g)) {
            return false;
        }
        if (!a(this.f4037g)) {
            return false;
        }
        long jB = b(this.f4037g[4]);
        this.f4034d = jB;
        if (0 == jB) {
            byte b2 = this.f4037g[4];
            return false;
        }
        long jA = a(this.f4037g[5]);
        this.f4035e = jA;
        if (com.tencent.bugly.beta.utils.a.a == jA) {
            byte b3 = this.f4037g[5];
            return false;
        }
        this.f4032b.a(jA);
        return true;
    }

    private synchronized a l() {
        a aVar = new a();
        try {
            aVar.g(this.f4032b.g());
            aVar.j(this.f4032b.g());
            long j2 = this.f4034d;
            if (32 == j2) {
                aVar.d(this.f4032b.g());
                aVar.a(this.f4032b.g());
                aVar.h(this.f4032b.g());
                aVar.i(this.f4032b.g());
            } else {
                if (64 != j2) {
                    return null;
                }
                aVar.d(this.f4032b.h());
                aVar.a(this.f4032b.h());
                aVar.h(this.f4032b.h());
                aVar.i(this.f4032b.h());
            }
            aVar.f(this.f4032b.g());
            aVar.e(this.f4032b.g());
            long j3 = this.f4034d;
            if (32 == j3) {
                aVar.b(this.f4032b.g());
                aVar.c(this.f4032b.g());
            } else {
                if (64 != j3) {
                    return null;
                }
                aVar.b(this.f4032b.h());
                aVar.c(this.f4032b.h());
            }
            return aVar;
        } catch (IOException e2) {
            e2.getMessage();
            return null;
        }
    }

    private synchronized boolean m() {
        HashMap<String, b> mapA;
        mapA = a(d(), e(), f());
        this.f4036f = mapA;
        return mapA != null;
    }

    public synchronized String a() {
        if (!i()) {
            return null;
        }
        String strC = c();
        if (!strC.equals("armeabi")) {
            return strC;
        }
        if (!m()) {
            return strC;
        }
        b bVar = this.f4036f.get(".ARM.attributes");
        if (bVar == null) {
            return strC;
        }
        return com.tencent.bugly.beta.utils.b.a(this.f4033c, this.f4035e, bVar.a());
    }

    private synchronized HashMap<String, b> b(long j2, long j3) {
        if (j2 > 0 && j3 > 0) {
            Vector<a> vector = new Vector();
            for (int i2 = 0; i2 < j2; i2++) {
                vector.add(l());
            }
            a aVar = (a) vector.get((int) j3);
            long length = new File(this.f4033c).length();
            X.a("File length = %d", Long.valueOf(length));
            if (aVar.d() >= length) {
                X.e("The SO file is invalid or has a shell.", new Object[0]);
                return null;
            }
            d dVar = new d(this.f4033c, aVar.d(), aVar.e());
            HashMap<String, b> map = new HashMap<>();
            for (a aVar2 : vector) {
                String strA = dVar.a(aVar2.c());
                b bVar = new b();
                bVar.a(strA);
                bVar.a(aVar2.a());
                bVar.c(aVar2.d());
                bVar.d(aVar2.e());
                bVar.b(aVar2.b());
                map.put(strA, bVar);
            }
            dVar.a();
            return map;
        }
        X.e("The SO file is invalid or has a shell.", new Object[0]);
        return null;
    }

    private static String a(long j2, long j3) {
        String str = a.get(Long.valueOf(j2));
        return (64 == j3 && str.equals("mips")) ? "mips64" : str;
    }

    private static boolean a(byte[] bArr) {
        return bArr.length >= 3 && 127 == bArr[0] && 69 == bArr[1] && 76 == bArr[2] && 70 == bArr[3];
    }

    private long a(byte b2) {
        if (1 == b2) {
            return com.tencent.bugly.beta.utils.a.f4018c;
        }
        if (2 == b2) {
            return com.tencent.bugly.beta.utils.a.f4017b;
        }
        return com.tencent.bugly.beta.utils.a.a;
    }

    private synchronized HashMap<String, b> a(long j2, long j3, long j4) {
        if (!g()) {
            b();
            return null;
        }
        if (!this.f4032b.b(j2)) {
            b();
            return null;
        }
        HashMap<String, b> mapB = b(j3, j4);
        b();
        return mapB;
    }
}

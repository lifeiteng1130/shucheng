package com.ss.android.socialbase.downloader.i;

/* JADX INFO: compiled from: DownloadStenographer.java */
/* JADX INFO: loaded from: classes.dex */
public class e {
    private a a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private a f3718b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f3719c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f3720d = 10;

    /* JADX INFO: compiled from: DownloadStenographer.java */
    public static class a {
        public long a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f3721b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public a f3722c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public a f3723d;

        private a() {
        }
    }

    public boolean a(long j2, long j3) {
        synchronized (this) {
            a aVar = this.a;
            if (aVar != null) {
                if (j2 >= aVar.a && j3 >= aVar.f3721b) {
                    a aVar2 = aVar.f3722c;
                    if (aVar2 != null && j3 - aVar2.f3721b < 1000) {
                        aVar.a = j2;
                        aVar.f3721b = j3;
                        return true;
                    }
                }
                return false;
            }
            a aVarA = a();
            aVarA.a = j2;
            aVarA.f3721b = j3;
            if (aVar != null) {
                aVarA.f3722c = aVar;
                aVar.f3723d = aVarA;
            }
            this.a = aVarA;
            return true;
        }
    }

    public long b(long j2, long j3) {
        synchronized (this) {
            a aVar = this.a;
            if (aVar == null) {
                return -1L;
            }
            a aVarA = a(j2);
            if (aVarA == null) {
                return -1L;
            }
            long j4 = aVar.a - aVarA.a;
            long j5 = j3 - aVarA.f3721b;
            if (j4 < 0 || j5 <= 0) {
                return -1L;
            }
            return j4 / j5;
        }
    }

    private a a() {
        a aVar;
        int i2 = this.f3719c;
        if (i2 >= this.f3720d && (aVar = this.f3718b) != null) {
            a aVar2 = aVar.f3723d;
            aVar.f3723d = null;
            this.f3718b = aVar2;
            if (aVar2 != null) {
                aVar2.f3722c = null;
            }
            return aVar;
        }
        this.f3719c = i2 + 1;
        return new a();
    }

    private a a(long j2) {
        a aVar = this.a;
        a aVar2 = null;
        while (aVar != null && aVar.f3721b > j2) {
            aVar2 = aVar;
            aVar = aVar.f3722c;
        }
        return (aVar == null || aVar2 == null || aVar == aVar2 || j2 - aVar.f3721b >= aVar2.f3721b - j2) ? aVar2 : aVar;
    }
}

package com.ss.android.socialbase.downloader.f;

import android.text.TextUtils;
import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

/* JADX INFO: compiled from: SegmentReader.java */
/* JADX INFO: loaded from: classes.dex */
public class m implements Runnable {
    private Thread A;
    private volatile boolean B;
    private int C;
    private int D;
    private int E;
    private long F;
    private int G;
    private boolean H;
    private BaseException I;
    private boolean J;
    private boolean K;
    private com.ss.android.socialbase.downloader.i.e L;
    public volatile i a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public q f3655b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f3656c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile long f3657d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile long f3658e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile long f3659f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile long f3660g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f3661h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f3662i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f3663j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final f f3664k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final c f3665l;
    private final DownloadInfo m;
    private final com.ss.android.socialbase.downloader.g.a n;
    private com.ss.android.socialbase.downloader.network.i o;
    private com.ss.android.socialbase.downloader.model.d p;
    private long r;
    private volatile long s;
    private volatile long t;
    private volatile long v;
    private Future w;
    private volatile boolean x;
    private volatile boolean y;
    private volatile boolean z;
    private final List<i> q = new ArrayList();
    private volatile long u = -1;

    public m(DownloadInfo downloadInfo, k kVar, c cVar, q qVar, int i2) {
        this.m = downloadInfo;
        this.f3664k = kVar;
        this.f3665l = cVar;
        this.n = com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId());
        this.f3655b = qVar;
        this.f3656c = i2;
    }

    private boolean a(i iVar) {
        k();
        while (true) {
            try {
                b(iVar);
                d(iVar);
                return true;
            } catch (j e2) {
                this.I = e2;
                throw e2;
            } catch (Throwable th) {
                try {
                    com.ss.android.socialbase.downloader.c.a.e("SegmentReader", "download: e = " + th + ", threadIndex = " + this.f3656c + ", reconnect = " + this.y + ", closed = " + this.x);
                    if (this.x) {
                        return false;
                    }
                    if (this.y) {
                        this.y = false;
                        try {
                            Thread.interrupted();
                        } catch (Throwable th2) {
                            th2.printStackTrace();
                        }
                        if (this.z) {
                            this.z = false;
                            throw new j(5, "download");
                        }
                    } else {
                        th.printStackTrace();
                        BaseException e3 = null;
                        if (th instanceof BaseException) {
                            e3 = th;
                        } else {
                            try {
                                com.ss.android.socialbase.downloader.i.f.a((Throwable) th, "download");
                            } catch (BaseException e4) {
                                e3 = e4;
                            }
                        }
                        if (e3 == null || !a(iVar, e3)) {
                            return false;
                        }
                    }
                } finally {
                    i();
                }
            }
        }
        return false;
    }

    private void b(i iVar) {
        c(iVar);
        this.f3664k.a(this, iVar, this.f3655b, this.p);
        this.f3655b.c();
    }

    private void c(i iVar) {
        String strReplaceFirst;
        com.ss.android.socialbase.downloader.network.i iVarA;
        try {
            try {
                try {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    this.f3658e = 0L;
                    this.f3657d = jCurrentTimeMillis;
                    this.r = iVar.e();
                    this.t = iVar.f();
                    if (this.t > 0 && this.r > this.t) {
                        throw new j(6, "createConn, " + iVar);
                    }
                    this.L = new com.ss.android.socialbase.downloader.i.e();
                    List<com.ss.android.socialbase.downloader.model.c> listA = com.ss.android.socialbase.downloader.i.f.a(this.m.getExtraHeaders(), this.m.geteTag(), this.r, this.t);
                    listA.add(new com.ss.android.socialbase.downloader.model.c("Segment-Index", String.valueOf(iVar.g())));
                    listA.add(new com.ss.android.socialbase.downloader.model.c("Thread-Index", String.valueOf(this.f3656c)));
                    com.ss.android.socialbase.downloader.i.f.a(listA, this.m);
                    com.ss.android.socialbase.downloader.i.f.b(listA, this.m);
                    strReplaceFirst = this.f3655b.a;
                    if (this.H && !TextUtils.isEmpty(strReplaceFirst) && strReplaceFirst.startsWith("https")) {
                        strReplaceFirst = strReplaceFirst.replaceFirst("https", "http");
                    }
                    String str = this.f3655b.f3667b;
                    com.ss.android.socialbase.downloader.c.a.c("SegmentReader", "createConnectionBegin: url = " + strReplaceFirst + ", ip = " + str + ", segment = " + iVar + ", threadIndex = " + this.f3656c);
                    this.f3661h = strReplaceFirst;
                    this.f3662i = str;
                    iVarA = com.ss.android.socialbase.downloader.downloader.c.a(this.m.isNeedDefaultHttpServiceBackUp(), this.m.getMaxBytes(), strReplaceFirst, str, listA, 0, jCurrentTimeMillis - this.F > 3000 && this.n.b("monitor_download_connect") > 0, this.m);
                } catch (Throwable th) {
                    com.ss.android.socialbase.downloader.i.f.a(th, "createConn");
                }
                if (iVarA == null) {
                    throw new BaseException(1022, new IOException("download can't continue, chunk connection is null"));
                }
                this.o = iVarA;
                this.p = new com.ss.android.socialbase.downloader.model.d(strReplaceFirst, iVarA);
                if (this.x) {
                    throw new p("createConn");
                }
                if (iVarA instanceof com.ss.android.socialbase.downloader.network.a) {
                    this.f3663j = ((com.ss.android.socialbase.downloader.network.a) iVarA).e();
                }
                this.f3658e = System.currentTimeMillis();
            } catch (BaseException e2) {
                throw e2;
            }
        } catch (Throwable th2) {
            this.f3658e = System.currentTimeMillis();
            throw th2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:116:0x0216  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0223  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x0398  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x03a5  */
    /* JADX WARN: Removed duplicated region for block: B:258:0x0176 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x017d A[Catch: all -> 0x0271, BaseException -> 0x0276, TryCatch #24 {BaseException -> 0x0276, all -> 0x0271, blocks: (B:84:0x016b, B:86:0x0176, B:87:0x017d, B:89:0x0183, B:91:0x0189, B:94:0x0192, B:95:0x0196), top: B:252:0x016b }] */
    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:75:0x0159
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1182)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void d(com.ss.android.socialbase.downloader.f.i r32) {
        /*
            Method dump skipped, instruction units count: 995
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.f.m.d(com.ss.android.socialbase.downloader.f.i):void");
    }

    private void i() {
        this.F = this.f3657d;
        this.f3657d = -1L;
        this.f3658e = -1L;
        this.f3659f = -1L;
        this.f3660g = -1L;
        j();
    }

    private void j() {
        com.ss.android.socialbase.downloader.network.i iVar = this.o;
        if (iVar != null) {
            try {
                com.ss.android.socialbase.downloader.c.a.c("SegmentReader", "closeConnection: thread = " + this.f3656c);
                iVar.d();
                iVar.c();
            } catch (Throwable unused) {
            }
        }
    }

    private void k() {
        this.H = false;
        l();
    }

    private void l() {
        this.D = this.f3655b.f3669d ? this.m.getRetryCount() : this.m.getBackUpUrlRetryCount();
        this.E = 0;
    }

    private long m() {
        long j2 = this.s;
        this.s = 0L;
        return j2 <= 0 ? RecyclerView.FOREVER_NS : j2;
    }

    public void e() {
        StringBuilder sbR = c.a.a.a.a.r("close: threadIndex = ");
        sbR.append(this.f3656c);
        com.ss.android.socialbase.downloader.c.a.c("SegmentReader", sbR.toString());
        synchronized (this) {
            this.x = true;
            this.B = true;
        }
        j();
        Future future = this.w;
        if (future != null) {
            this.w = null;
            try {
                future.cancel(true);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public void f() {
        a(false);
    }

    public boolean g() {
        return this.J;
    }

    public long h() {
        return this.r;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x007b, code lost:
    
        r6.a = null;
        r2 = r6.f3664k;
     */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void run() {
        /*
            Method dump skipped, instruction units count: 254
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.f.m.run():void");
    }

    public long b() {
        long jC;
        synchronized (this.f3664k) {
            jC = this.v + c();
        }
        return jC;
    }

    public void b(boolean z) {
        this.J = z;
    }

    public void b(long j2) {
        long j3 = this.u;
        com.ss.android.socialbase.downloader.i.e eVar = this.L;
        if (j3 < 0 || eVar == null) {
            return;
        }
        eVar.a(j3, j2);
    }

    public boolean a(q qVar) {
        int i2 = this.G;
        if (i2 >= 30) {
            return false;
        }
        this.G = i2 + 1;
        q qVar2 = this.f3655b;
        if (qVar2 != null) {
            qVar2.b(this);
        }
        qVar.a(this);
        this.f3655b = qVar;
        l();
        return true;
    }

    private boolean a(i iVar, BaseException baseException) {
        com.ss.android.socialbase.downloader.c.a.e("SegmentReader", "handleDownloadFailed:  e = " + baseException + ", curRetryCount = " + this.E + ", retryCount = " + this.D);
        this.I = baseException;
        this.f3655b.b();
        this.f3664k.a(this, this.f3655b, iVar, baseException, this.E, this.D);
        int i2 = this.E;
        if (i2 < this.D) {
            this.E = i2 + 1;
            return true;
        }
        if (a(baseException)) {
            return true;
        }
        this.f3664k.a(this, this.f3655b, iVar, baseException);
        return false;
    }

    public long c() {
        synchronized (this.f3664k) {
            long j2 = this.u;
            long j3 = this.r;
            if (j3 < 0 || j2 <= j3) {
                return 0L;
            }
            return j2 - j3;
        }
    }

    private boolean a(BaseException baseException) {
        if (!com.ss.android.socialbase.downloader.i.f.c(baseException)) {
            return false;
        }
        String str = this.f3655b.a;
        if (TextUtils.isEmpty(str) || !str.startsWith("https") || !this.m.isNeedHttpsToHttpRetry() || this.H) {
            return false;
        }
        this.H = true;
        l();
        return true;
    }

    public void c(boolean z) {
        this.K = z;
    }

    private a a(c cVar, InputStream inputStream) throws Throwable {
        int i2;
        a aVarB = cVar.b();
        try {
            i2 = inputStream.read(aVarB.a);
        } catch (Throwable th) {
            th = th;
            i2 = -1;
        }
        try {
            if (i2 != -1) {
                aVarB.f3610c = i2;
                if (i2 == -1) {
                    cVar.a(aVarB);
                }
                return aVarB;
            }
            throw new BaseException(1073, "probe");
        } catch (Throwable th2) {
            th = th2;
            if (i2 == -1) {
                cVar.a(aVarB);
            }
            throw th;
        }
    }

    public boolean a(long j2) {
        long j3 = this.t;
        if (j2 <= 0 && j3 > 0) {
            return false;
        }
        if (j2 > j3 && j3 > 0) {
            return false;
        }
        this.s = j2;
        this.B = true;
        return true;
    }

    public void a() {
        q qVar = this.f3655b;
        try {
            synchronized (this.f3664k) {
                long jC = c();
                if (jC > 0) {
                    this.v += jC;
                    qVar.a(jC);
                }
                this.u = -1L;
            }
        } catch (Throwable unused) {
        }
    }

    public void a(boolean z) {
        StringBuilder sbR = c.a.a.a.a.r("reconnect: threadIndex = ");
        sbR.append(this.f3656c);
        com.ss.android.socialbase.downloader.c.a.c("SegmentReader", sbR.toString());
        synchronized (this) {
            this.z = z;
            this.y = true;
            this.B = true;
        }
        j();
        Thread thread = this.A;
        if (thread != null) {
            try {
                thread.interrupt();
            } catch (Throwable unused) {
            }
        }
    }

    public void a(Future future) {
        this.w = future;
    }

    public long a(long j2, long j3) {
        com.ss.android.socialbase.downloader.i.e eVar = this.L;
        if (eVar == null) {
            return -1L;
        }
        return eVar.b(j2, j3);
    }

    public long d() {
        return this.u;
    }
}

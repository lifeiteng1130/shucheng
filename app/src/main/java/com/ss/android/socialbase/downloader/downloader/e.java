package com.ss.android.socialbase.downloader.downloader;

import android.os.SystemClock;
import android.support.v4.media.session.PlaybackStateCompat;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.InputStream;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: DownloadResponseHandler.java */
/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f3571b = "ResponseHandler";
    private long A;
    private long B;
    private long C;
    private long D;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final DownloadInfo f3572c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f3573d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final com.ss.android.socialbase.downloader.model.b f3574e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final com.ss.android.socialbase.downloader.network.i f3575f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private j f3576g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private com.ss.android.socialbase.downloader.impls.k f3577h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private t f3578i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private com.ss.android.socialbase.downloader.model.e f3579j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private BaseException f3580k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private volatile boolean f3581l;
    private volatile boolean m;
    private final com.ss.android.socialbase.downloader.h.f n;
    private long o;
    private long p;
    private volatile long q;
    private volatile long r;
    private final boolean s;
    private final com.ss.android.socialbase.downloader.g.a t;
    private final com.ss.android.socialbase.downloader.a.a u;
    private final boolean v;
    private final long w;
    private final long x;
    private final boolean y;
    private boolean z;
    public boolean a = false;
    private volatile long E = 0;
    private volatile long F = 0;

    public e(DownloadInfo downloadInfo, String str, com.ss.android.socialbase.downloader.network.i iVar, com.ss.android.socialbase.downloader.model.b bVar, com.ss.android.socialbase.downloader.h.f fVar) {
        this.f3572c = downloadInfo;
        this.f3573d = str;
        j jVarX = c.x();
        this.f3576g = jVarX;
        if (jVarX instanceof com.ss.android.socialbase.downloader.impls.d) {
            com.ss.android.socialbase.downloader.impls.d dVar = (com.ss.android.socialbase.downloader.impls.d) jVarX;
            this.f3577h = dVar.a();
            this.f3578i = dVar.f();
        }
        this.f3575f = iVar;
        this.f3574e = bVar;
        this.n = fVar;
        long jN = bVar.n();
        this.o = jN;
        this.p = jN;
        if (bVar.d()) {
            this.r = bVar.q();
        } else {
            this.r = bVar.c(false);
        }
        this.q = bVar.p();
        this.u = com.ss.android.socialbase.downloader.a.a.a();
        com.ss.android.socialbase.downloader.g.a aVarA = com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId());
        this.t = aVarA;
        boolean z = aVarA.a("sync_strategy", 0) == 1;
        this.v = z;
        if (z) {
            long jA = aVarA.a("sync_interval_ms_fg", 5000);
            long jA2 = aVarA.a("sync_interval_ms_bg", 1000);
            this.w = Math.max(jA, 500L);
            this.x = Math.max(jA2, 500L);
        } else {
            this.w = 0L;
            this.x = 0L;
        }
        this.y = aVarA.b("monitor_rw") == 1;
        this.s = com.ss.android.socialbase.downloader.i.a.a(65536);
    }

    private boolean b(long j2, long j3) {
        return j2 > PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH && j3 > 500;
    }

    private boolean f() {
        return this.f3581l || this.m;
    }

    private void g() {
        ExecutorService executorServiceL;
        if (this.f3575f == null || (executorServiceL = c.l()) == null) {
            return;
        }
        executorServiceL.execute(new Runnable() { // from class: com.ss.android.socialbase.downloader.downloader.e.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    e.this.f3575f.d();
                } catch (Throwable unused) {
                }
            }
        });
    }

    private void h() {
        boolean z;
        long jNanoTime = this.y ? System.nanoTime() : 0L;
        try {
            this.f3579j.a();
            z = true;
        } catch (Exception unused) {
            z = false;
        }
        if (z) {
            this.f3572c.updateRealDownloadTime(true);
            boolean z2 = this.f3572c.getChunkCount() > 1;
            m mVarA = com.ss.android.socialbase.downloader.impls.l.a(com.ss.android.socialbase.downloader.i.f.b());
            if (z2) {
                a(this.f3578i);
                if (mVarA != null) {
                    mVarA.c(this.f3572c);
                } else {
                    this.f3578i.a(this.f3572c.getId(), this.f3572c.getCurBytes());
                }
            } else if (mVarA != null) {
                mVarA.c(this.f3572c);
            } else {
                this.f3578i.a(this.f3574e.k(), this.o);
            }
            this.E = this.o;
        }
        if (this.y) {
            this.C += System.nanoTime() - jNanoTime;
        }
    }

    public void b() {
        if (this.f3581l) {
            return;
        }
        this.f3581l = true;
        g();
    }

    public void c() {
        if (this.m) {
            return;
        }
        synchronized (this.n) {
            this.m = true;
        }
        g();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:176:0x02e1 A[Catch: all -> 0x04db, TRY_ENTER, TryCatch #26 {all -> 0x04db, blocks: (B:176:0x02e1, B:177:0x02e8, B:206:0x0361, B:208:0x0367, B:209:0x036a, B:250:0x0456, B:251:0x0458, B:255:0x045f, B:257:0x047f, B:285:0x04cf, B:287:0x04d5, B:288:0x04d8, B:289:0x04da), top: B:351:0x002b, inners: #28 }] */
    /* JADX WARN: Removed duplicated region for block: B:179:0x0304  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x0361 A[Catch: all -> 0x04db, TRY_ENTER, TryCatch #26 {all -> 0x04db, blocks: (B:176:0x02e1, B:177:0x02e8, B:206:0x0361, B:208:0x0367, B:209:0x036a, B:250:0x0456, B:251:0x0458, B:255:0x045f, B:257:0x047f, B:285:0x04cf, B:287:0x04d5, B:288:0x04d8, B:289:0x04da), top: B:351:0x002b, inners: #28 }] */
    /* JADX WARN: Removed duplicated region for block: B:235:0x03e8 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:236:0x03e9  */
    /* JADX WARN: Type inference failed for: r32v0 */
    /* JADX WARN: Type inference failed for: r32v10 */
    /* JADX WARN: Type inference failed for: r32v11 */
    /* JADX WARN: Type inference failed for: r32v12 */
    /* JADX WARN: Type inference failed for: r32v13 */
    /* JADX WARN: Type inference failed for: r32v14 */
    /* JADX WARN: Type inference failed for: r32v15 */
    /* JADX WARN: Type inference failed for: r32v16 */
    /* JADX WARN: Type inference failed for: r32v17 */
    /* JADX WARN: Type inference failed for: r32v18 */
    /* JADX WARN: Type inference failed for: r32v2 */
    /* JADX WARN: Type inference failed for: r32v3, types: [long] */
    /* JADX WARN: Type inference failed for: r32v6 */
    /* JADX WARN: Type inference failed for: r32v7 */
    /* JADX WARN: Type inference failed for: r32v8 */
    /* JADX WARN: Type inference failed for: r32v9 */
    /* JADX WARN: Type inference failed for: r6v0, types: [long] */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v12 */
    /* JADX WARN: Type inference failed for: r6v13 */
    /* JADX WARN: Type inference failed for: r6v14 */
    /* JADX WARN: Type inference failed for: r6v16 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v22 */
    /* JADX WARN: Type inference failed for: r6v23 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v35 */
    /* JADX WARN: Type inference failed for: r6v36 */
    /* JADX WARN: Type inference failed for: r6v37 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5, types: [int] */
    /* JADX WARN: Type inference failed for: r6v6, types: [int] */
    /* JADX WARN: Type inference failed for: r6v7, types: [int] */
    /* JADX WARN: Type inference failed for: r6v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void d() throws com.ss.android.socialbase.downloader.exception.BaseException {
        /*
            Method dump skipped, instruction units count: 1380
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.downloader.e.d():void");
    }

    public long e() {
        return this.E;
    }

    public long a() {
        return this.o;
    }

    public void a(long j2, long j3, long j4) {
        this.o = j2;
        this.p = j2;
        this.q = j3;
        this.r = j4;
    }

    public void a(long j2, long j3) {
        this.q = j2;
        this.r = j3;
    }

    private com.ss.android.socialbase.downloader.e.b a(InputStream inputStream) {
        int iH = c.H();
        if (this.t.a("rw_concurrent", 0) == 1 && this.f3572c.getChunkCount() == 1 && this.f3572c.getTotalBytes() > 20971520) {
            try {
                com.ss.android.socialbase.downloader.e.a aVar = new com.ss.android.socialbase.downloader.e.a(inputStream, iH, this.t.a("rw_concurrent_max_buffer_count", 4));
                this.z = true;
                return aVar;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        com.ss.android.socialbase.downloader.e.c cVar = new com.ss.android.socialbase.downloader.e.c(inputStream, iH);
        this.z = false;
        return cVar;
    }

    private void a(boolean z) {
        long jUptimeMillis = SystemClock.uptimeMillis();
        long j2 = jUptimeMillis - this.F;
        if (this.v) {
            if (j2 > (this.u.b() ? this.w : this.x)) {
                h();
                this.F = jUptimeMillis;
                return;
            }
            return;
        }
        long j3 = this.o - this.E;
        if (z || b(j3, j2)) {
            h();
            this.F = jUptimeMillis;
        }
    }

    private void a(j jVar) {
        com.ss.android.socialbase.downloader.model.b bVarE;
        com.ss.android.socialbase.downloader.model.b bVar;
        if (jVar == null) {
            return;
        }
        m mVarA = null;
        boolean z = jVar instanceof com.ss.android.socialbase.downloader.b.e;
        if (z && (mVarA = com.ss.android.socialbase.downloader.impls.l.a(com.ss.android.socialbase.downloader.i.f.b())) == null) {
            return;
        }
        m mVar = mVarA;
        if (this.f3574e.d()) {
            bVarE = this.f3574e.e();
        } else {
            bVarE = this.f3574e;
        }
        com.ss.android.socialbase.downloader.model.b bVar2 = bVarE;
        if (bVar2 != null) {
            bVar2.b(this.o);
            if (z && mVar != null) {
                mVar.a(bVar2.k(), bVar2.s(), bVar2.b(), this.o);
                bVar = bVar2;
            } else {
                bVar = bVar2;
                jVar.a(bVar2.k(), bVar2.s(), bVar2.b(), this.o);
            }
            if (bVar.h()) {
                boolean z2 = false;
                if (bVar.i()) {
                    long j2 = bVar.j();
                    if (j2 > this.o) {
                        if (z && mVar != null) {
                            mVar.a(bVar.k(), bVar.b(), j2);
                        } else {
                            jVar.a(bVar.k(), bVar.b(), j2);
                        }
                        z2 = true;
                    }
                }
                if (z2) {
                    return;
                }
                if (z && mVar != null) {
                    mVar.a(bVar.k(), bVar.b(), this.o);
                    return;
                } else {
                    jVar.a(bVar.k(), bVar.b(), this.o);
                    return;
                }
            }
            return;
        }
        if (this.f3574e.d()) {
            if (z && mVar != null) {
                mVar.a(this.f3574e.k(), this.f3574e.s(), this.o);
            } else {
                jVar.a(this.f3574e.k(), this.f3574e.s(), this.o);
            }
        }
    }
}

package com.ss.android.socialbase.downloader.h;

import com.ss.android.socialbase.downloader.downloader.j;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.network.i;

/* JADX INFO: compiled from: DownloadChunkRunnable.java */
/* JADX INFO: loaded from: classes.dex */
public class b implements Runnable {
    private static final String a = b.class.getSimpleName();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.ss.android.socialbase.downloader.model.b f3688b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.ss.android.socialbase.downloader.model.b f3689c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private com.ss.android.socialbase.downloader.downloader.e f3690d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final DownloadTask f3691e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private DownloadInfo f3692f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final f f3693g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private i f3694h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private j f3695i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private volatile boolean f3696j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private volatile boolean f3697k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f3698l;

    public b(com.ss.android.socialbase.downloader.model.b bVar, DownloadTask downloadTask, f fVar) {
        this.f3698l = false;
        this.f3689c = bVar;
        this.f3691e = downloadTask;
        if (downloadTask != null) {
            this.f3692f = downloadTask.getDownloadInfo();
        }
        this.f3693g = fVar;
        this.f3695i = com.ss.android.socialbase.downloader.downloader.c.x();
        this.f3689c.a(this);
    }

    private String c() {
        return this.f3692f.getConnectionUrl();
    }

    private void d() {
        i iVar = this.f3694h;
        if (iVar != null) {
            iVar.d();
            this.f3694h = null;
        }
    }

    private boolean e() {
        return this.f3696j || this.f3697k;
    }

    public void a(long j2, long j3) {
        com.ss.android.socialbase.downloader.downloader.e eVar = this.f3690d;
        if (eVar == null) {
            return;
        }
        eVar.a(j2, j3);
    }

    public void b() {
        this.f3697k = true;
        com.ss.android.socialbase.downloader.downloader.e eVar = this.f3690d;
        if (eVar != null) {
            eVar.c();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0017, code lost:
    
        r3.f3688b.a(false);
     */
    @Override // java.lang.Runnable
    @android.annotation.SuppressLint({"DefaultLocale"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void run() {
        /*
            r3 = this;
            r0 = 10
            android.os.Process.setThreadPriority(r0)
            com.ss.android.socialbase.downloader.model.b r0 = r3.f3689c
            r3.f3688b = r0
        L9:
            r0 = 0
            com.ss.android.socialbase.downloader.model.b r1 = r3.f3688b     // Catch: java.lang.Throwable -> L5d
            r1.a(r3)     // Catch: java.lang.Throwable -> L5d
            com.ss.android.socialbase.downloader.model.b r1 = r3.f3688b     // Catch: java.lang.Throwable -> L5d
            boolean r1 = r3.a(r1)     // Catch: java.lang.Throwable -> L5d
            if (r1 != 0) goto L1d
            com.ss.android.socialbase.downloader.model.b r1 = r3.f3688b     // Catch: java.lang.Throwable -> L5d
            r1.a(r0)     // Catch: java.lang.Throwable -> L5d
            goto L4d
        L1d:
            com.ss.android.socialbase.downloader.model.b r1 = r3.f3688b     // Catch: java.lang.Throwable -> L5d
            r1.a(r0)     // Catch: java.lang.Throwable -> L5d
            boolean r1 = r3.e()     // Catch: java.lang.Throwable -> L5d
            if (r1 == 0) goto L29
            goto L4d
        L29:
            com.ss.android.socialbase.downloader.h.f r1 = r3.f3693g     // Catch: java.lang.Throwable -> L5d
            com.ss.android.socialbase.downloader.model.b r2 = r3.f3688b     // Catch: java.lang.Throwable -> L5d
            int r2 = r2.s()     // Catch: java.lang.Throwable -> L5d
            com.ss.android.socialbase.downloader.model.b r1 = r1.a(r2)     // Catch: java.lang.Throwable -> L5d
            r3.f3688b = r1     // Catch: java.lang.Throwable -> L5d
            boolean r1 = r3.e()     // Catch: java.lang.Throwable -> L5d
            if (r1 != 0) goto L4d
            com.ss.android.socialbase.downloader.model.b r1 = r3.f3688b     // Catch: java.lang.Throwable -> L5d
            if (r1 != 0) goto L42
            goto L4d
        L42:
            r1 = 50
            java.lang.Thread.sleep(r1)     // Catch: java.lang.Throwable -> L48
            goto L9
        L48:
            r1 = move-exception
            r1.printStackTrace()     // Catch: java.lang.Throwable -> L5d
            goto L9
        L4d:
            com.ss.android.socialbase.downloader.model.b r1 = r3.f3688b
            if (r1 == 0) goto L54
            r1.a(r0)
        L54:
            r3.d()
            com.ss.android.socialbase.downloader.h.f r0 = r3.f3693g
            r0.a(r3)
            return
        L5d:
            r1 = move-exception
            com.ss.android.socialbase.downloader.model.b r2 = r3.f3688b
            if (r2 == 0) goto L65
            r2.a(r0)
        L65:
            r3.d()
            com.ss.android.socialbase.downloader.h.f r0 = r3.f3693g
            r0.a(r3)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.h.b.run():void");
    }

    /* JADX WARN: Removed duplicated region for block: B:124:0x01ba A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:139:0x01dc A[Catch: all -> 0x029f, TRY_ENTER, TryCatch #16 {all -> 0x029f, blocks: (B:135:0x01d2, B:139:0x01dc, B:141:0x01e2, B:144:0x01eb, B:146:0x01f3, B:148:0x01f9, B:152:0x0204, B:154:0x0208, B:156:0x0210, B:158:0x0221, B:167:0x0247, B:169:0x024d, B:171:0x025a, B:175:0x0262, B:170:0x0254, B:161:0x022e, B:162:0x023a, B:177:0x026d, B:179:0x0275, B:181:0x027d, B:183:0x0285, B:185:0x028d, B:188:0x0296, B:122:0x01b4, B:126:0x01be, B:129:0x01c5), top: B:214:0x01d2, inners: #10 }] */
    /* JADX WARN: Removed duplicated region for block: B:206:0x01be A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:220:0x00fb A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:224:0x01d8 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00ff A[Catch: all -> 0x01b2, BaseException -> 0x01ce, TRY_ENTER, TryCatch #3 {BaseException -> 0x01ce, blocks: (B:22:0x004f, B:26:0x0059, B:30:0x0064, B:62:0x00f5, B:66:0x00ff, B:68:0x0103, B:79:0x0131, B:51:0x00db), top: B:198:0x004f }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean a(com.ss.android.socialbase.downloader.model.b r31) {
        /*
            Method dump skipped, instruction units count: 676
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.h.b.a(com.ss.android.socialbase.downloader.model.b):boolean");
    }

    public b(com.ss.android.socialbase.downloader.model.b bVar, DownloadTask downloadTask, i iVar, f fVar) {
        this(bVar, downloadTask, fVar);
        this.f3694h = iVar;
    }

    private void a(com.ss.android.socialbase.downloader.model.b bVar, long j2) {
        com.ss.android.socialbase.downloader.model.b bVarE = bVar.d() ? bVar.e() : bVar;
        if (bVarE != null) {
            if (bVarE.h()) {
                this.f3695i.a(bVarE.k(), bVarE.b(), j2);
            }
            bVarE.b(j2);
            this.f3695i.a(bVarE.k(), bVarE.s(), bVarE.b(), j2);
            return;
        }
        if (bVar.d()) {
            this.f3695i.a(bVar.k(), bVar.s(), j2);
        }
    }

    public void a() {
        this.f3696j = true;
        com.ss.android.socialbase.downloader.downloader.e eVar = this.f3690d;
        if (eVar != null) {
            eVar.b();
        }
    }
}

package com.ss.android.socialbase.downloader.f;

import android.support.v4.media.session.PlaybackStateCompat;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.IOException;
import java.io.SyncFailedException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: MultiSegmentWriter.java */
/* JADX INFO: loaded from: classes.dex */
public class g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final DownloadInfo f3623c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final com.ss.android.socialbase.downloader.g.a f3625e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final com.ss.android.socialbase.downloader.h.f f3626f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final c f3627g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private BaseException f3628h;
    private final boolean m;
    private final long n;
    private final long o;
    private final boolean p;
    private long q;
    private final List<l> a = new LinkedList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<l> f3622b = new ArrayList();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private volatile boolean f3629i = false;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private volatile boolean f3630j = false;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private volatile boolean f3631k = false;
    private volatile long r = 0;
    private volatile long s = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.ss.android.socialbase.downloader.downloader.j f3624d = com.ss.android.socialbase.downloader.downloader.c.x();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final com.ss.android.socialbase.downloader.a.a f3632l = com.ss.android.socialbase.downloader.a.a.a();

    public g(DownloadInfo downloadInfo, com.ss.android.socialbase.downloader.h.f fVar, c cVar) {
        this.f3623c = downloadInfo;
        this.f3626f = fVar;
        this.f3627g = cVar;
        com.ss.android.socialbase.downloader.g.a aVarA = com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId());
        this.f3625e = aVarA;
        boolean z = aVarA.a("sync_strategy", 0) == 1;
        this.m = z;
        if (z) {
            long jA = aVarA.a("sync_interval_ms_fg", 5000);
            long jA2 = aVarA.a("sync_interval_ms_bg", 1000);
            this.n = Math.max(jA, 500L);
            this.o = Math.max(jA2, 500L);
        } else {
            this.n = 0L;
            this.o = 0L;
        }
        this.p = aVarA.b("monitor_rw") == 1;
    }

    private boolean a(long j2, long j3) {
        return j2 > PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH && j3 > 500;
    }

    private void b(List<l> list) throws SyncFailedException {
        Iterator<l> it = list.iterator();
        while (it.hasNext()) {
            it.next().c();
        }
    }

    private void c() {
        boolean z = this.p;
        long jNanoTime = z ? System.nanoTime() : 0L;
        DownloadInfo downloadInfo = this.f3623c;
        com.ss.android.socialbase.downloader.downloader.j jVar = this.f3624d;
        List<l> list = this.a;
        List<l> list2 = this.f3622b;
        Map<Long, i> mapL = jVar.l(downloadInfo.getId());
        if (mapL == null) {
            mapL = new HashMap<>(4);
        }
        boolean z2 = false;
        synchronized (this) {
            a(list);
            try {
                b(list);
                z2 = true;
            } catch (Throwable th) {
                th.printStackTrace();
            }
            a(list, mapL);
            if (list2.size() > 0) {
                c(list2);
                list.removeAll(list2);
                list2.clear();
            }
        }
        if (z2) {
            downloadInfo.updateRealDownloadTime(true);
            jVar.a(downloadInfo.getId(), mapL);
            jVar.a(downloadInfo);
            this.r = downloadInfo.getCurBytes();
        }
        if (z) {
            this.q += System.nanoTime() - jNanoTime;
        }
    }

    public void a(l lVar) {
        synchronized (this) {
            this.a.add(lVar);
        }
    }

    public void b() {
        this.f3630j = true;
        this.f3629i = true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:63:0x00ba, code lost:
    
        if (r13 <= 0) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00bd, code lost:
    
        r3.b(r13);
     */
    /* JADX WARN: Removed duplicated region for block: B:129:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x01f5 A[Catch: all -> 0x03d9, TryCatch #28 {all -> 0x03d9, blocks: (B:158:0x01f1, B:160:0x01f5, B:163:0x01fb, B:165:0x0201, B:166:0x0204, B:167:0x021a, B:204:0x029e, B:205:0x02a0, B:244:0x0327, B:246:0x0331, B:248:0x0335, B:285:0x03b7, B:287:0x03bd, B:288:0x03c0, B:289:0x03d8), top: B:359:0x0027, inners: #24 }] */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0201 A[Catch: all -> 0x03d9, TryCatch #28 {all -> 0x03d9, blocks: (B:158:0x01f1, B:160:0x01f5, B:163:0x01fb, B:165:0x0201, B:166:0x0204, B:167:0x021a, B:204:0x029e, B:205:0x02a0, B:244:0x0327, B:246:0x0331, B:248:0x0335, B:285:0x03b7, B:287:0x03bd, B:288:0x03c0, B:289:0x03d8), top: B:359:0x0027, inners: #24 }] */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0221  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x0248  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x02a3  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x02ca  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x0331 A[Catch: all -> 0x03d9, TryCatch #28 {all -> 0x03d9, blocks: (B:158:0x01f1, B:160:0x01f5, B:163:0x01fb, B:165:0x0201, B:166:0x0204, B:167:0x021a, B:204:0x029e, B:205:0x02a0, B:244:0x0327, B:246:0x0331, B:248:0x0335, B:285:0x03b7, B:287:0x03bd, B:288:0x03c0, B:289:0x03d8), top: B:359:0x0027, inners: #24 }] */
    /* JADX WARN: Removed duplicated region for block: B:287:0x03bd A[Catch: all -> 0x03d9, TryCatch #28 {all -> 0x03d9, blocks: (B:158:0x01f1, B:160:0x01f5, B:163:0x01fb, B:165:0x0201, B:166:0x0204, B:167:0x021a, B:204:0x029e, B:205:0x02a0, B:244:0x0327, B:246:0x0331, B:248:0x0335, B:285:0x03b7, B:287:0x03bd, B:288:0x03c0, B:289:0x03d8), top: B:359:0x0027, inners: #24 }] */
    /* JADX WARN: Removed duplicated region for block: B:300:0x03ed  */
    /* JADX WARN: Removed duplicated region for block: B:310:0x0415  */
    /* JADX WARN: Removed duplicated region for block: B:339:0x022b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:341:0x02ad A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:343:0x0364 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:345:0x00e5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:366:0x0417 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:370:0x03f7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:376:0x024a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:378:0x02cc A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(com.ss.android.socialbase.downloader.f.d r31) {
        /*
            Method dump skipped, instruction units count: 1133
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.f.g.a(com.ss.android.socialbase.downloader.f.d):void");
    }

    private void c(List<l> list) {
        Iterator<l> it = list.iterator();
        while (it.hasNext()) {
            it.next().d();
        }
    }

    private void a(long j2, boolean z) {
        long j3 = j2 - this.s;
        if (this.m) {
            if (j3 > (this.f3632l.b() ? this.n : this.o)) {
                c();
                this.s = j2;
                return;
            }
            return;
        }
        long curBytes = this.f3623c.getCurBytes() - this.r;
        if (z || a(curBytes, j3)) {
            c();
            this.s = j2;
        }
    }

    private void a(e eVar) {
        synchronized (this) {
            this.f3622b.add((l) eVar);
        }
    }

    private void a(List<l> list) throws IOException {
        Iterator<l> it = list.iterator();
        while (it.hasNext()) {
            it.next().b();
        }
    }

    private void a(List<l> list, Map<Long, i> map) {
        Iterator<l> it = list.iterator();
        while (it.hasNext()) {
            i iVarE = it.next().e();
            i iVar = map.get(Long.valueOf(iVarE.c()));
            if (iVar == null) {
                map.put(Long.valueOf(iVarE.c()), new i(iVarE));
            } else {
                iVar.a(iVarE.d());
                iVar.c(iVarE.f());
            }
        }
    }

    public void a() {
        this.f3631k = true;
        this.f3629i = true;
    }
}

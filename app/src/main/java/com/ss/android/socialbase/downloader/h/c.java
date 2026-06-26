package com.ss.android.socialbase.downloader.h;

import android.os.Handler;
import android.os.Process;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.PointerIconCompat;
import com.ss.android.socialbase.downloader.depend.IDownloadInterceptor;
import com.ss.android.socialbase.downloader.depend.q;
import com.ss.android.socialbase.downloader.depend.r;
import com.ss.android.socialbase.downloader.depend.w;
import com.ss.android.socialbase.downloader.depend.x;
import com.ss.android.socialbase.downloader.downloader.j;
import com.ss.android.socialbase.downloader.downloader.s;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.f.k;
import com.ss.android.socialbase.downloader.f.n;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.model.b;
import com.ss.android.socialbase.downloader.network.i;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import javax.net.ssl.SSLHandshakeException;
import org.json.JSONObject;

/* JADX INFO: compiled from: DownloadRunnable.java */
/* JADX INFO: loaded from: classes.dex */
public class c implements f, Runnable {
    private static final String a = c.class.getSimpleName();
    private r A;
    private String E;
    private long G;
    private long H;
    private final com.ss.android.socialbase.downloader.g.a I;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Future f3699b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final DownloadTask f3700c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private AtomicInteger f3702e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private volatile com.ss.android.socialbase.downloader.downloader.e f3704g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f3705h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f3706i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f3707j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f3708k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f3709l;
    private final AtomicBoolean m;
    private final j o;
    private DownloadInfo p;
    private com.ss.android.socialbase.downloader.downloader.h q;
    private final com.ss.android.socialbase.downloader.downloader.h r;
    private com.ss.android.socialbase.downloader.downloader.g s;
    private final com.ss.android.socialbase.downloader.downloader.g t;
    private s u;
    private final com.ss.android.socialbase.downloader.downloader.f v;
    private volatile BaseException w;
    private i x;
    private com.ss.android.socialbase.downloader.network.g y;
    private w z;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile boolean f3701d = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ArrayList<b> f3703f = new ArrayList<>();
    private volatile com.ss.android.socialbase.downloader.constants.h n = com.ss.android.socialbase.downloader.constants.h.RUN_STATUS_NONE;
    private volatile int B = 5;
    private boolean C = false;
    private boolean D = false;
    private boolean F = false;
    private int J = 0;
    private volatile k K = null;

    public c(DownloadTask downloadTask, Handler handler) {
        this.f3700c = downloadTask;
        if (downloadTask != null) {
            this.p = downloadTask.getDownloadInfo();
            this.q = downloadTask.getChunkStrategy();
            this.s = downloadTask.getChunkAdjustCalculator();
            this.z = downloadTask.getForbiddenHandler();
            this.A = downloadTask.getDiskSpaceHandler();
            this.u = a(downloadTask);
            this.I = com.ss.android.socialbase.downloader.g.a.a(this.p.getId());
        } else {
            this.I = com.ss.android.socialbase.downloader.g.a.c();
        }
        h();
        this.o = com.ss.android.socialbase.downloader.downloader.c.x();
        this.r = com.ss.android.socialbase.downloader.downloader.c.I();
        this.t = com.ss.android.socialbase.downloader.downloader.c.K();
        this.v = new com.ss.android.socialbase.downloader.downloader.f(downloadTask, handler);
        this.m = new AtomicBoolean(true);
    }

    private long A() {
        return this.u.a(this.p.getCurRetryTimeInTotal(), this.p.getTotalRetryCount());
    }

    private void B() throws com.ss.android.socialbase.downloader.exception.i, BaseException {
        com.ss.android.socialbase.downloader.impls.a aVarC;
        int id = this.p.getId();
        int iA = com.ss.android.socialbase.downloader.downloader.c.a(this.p);
        if (this.p.isDownloaded() && !this.p.isExpiredRedownload() && !this.F) {
            throw new BaseException(PointerIconCompat.TYPE_VERTICAL_TEXT, "file has downloaded");
        }
        DownloadInfo downloadInfoB = this.o.b(iA);
        if (downloadInfoB == null || (aVarC = com.ss.android.socialbase.downloader.downloader.c.C()) == null || downloadInfoB.getId() == id || !downloadInfoB.equalsTask(this.p)) {
            return;
        }
        if (aVarC.a(downloadInfoB.getId())) {
            this.o.f(id);
            throw new BaseException(InputDeviceCompat.SOURCE_GAMEPAD, "another same task is downloading");
        }
        List<com.ss.android.socialbase.downloader.model.b> listC = this.o.c(iA);
        com.ss.android.socialbase.downloader.i.f.a(this.p);
        this.o.f(iA);
        if (downloadInfoB.isBreakpointAvailable()) {
            this.p.copyFromCacheData(downloadInfoB, false);
            this.o.a(this.p);
            if (listC != null) {
                for (com.ss.android.socialbase.downloader.model.b bVar : listC) {
                    bVar.b(id);
                    this.o.a(bVar);
                }
            }
            throw new com.ss.android.socialbase.downloader.exception.i("retry task because id generator changed");
        }
    }

    private boolean C() {
        DownloadInfo downloadInfo = this.p;
        if (downloadInfo == null || downloadInfo.isExpiredRedownload()) {
            return false;
        }
        return (!this.f3706i || this.p.getChunkCount() > 1) && !this.p.isChunkDowngradeRetryUsed() && this.f3707j && !this.f3709l;
    }

    private void D() throws com.ss.android.socialbase.downloader.exception.d {
        long jD;
        int iA;
        try {
            jD = com.ss.android.socialbase.downloader.i.f.d(this.p.getTempPath());
        } catch (BaseException unused) {
            jD = 0;
        }
        String str = a;
        StringBuilder sbR = c.a.a.a.a.r("checkSpaceOverflowInProgress: available = ");
        sbR.append(com.ss.android.socialbase.downloader.i.f.a(jD));
        sbR.append("MB");
        com.ss.android.socialbase.downloader.c.a.c(str, sbR.toString());
        if (jD > 0) {
            long totalBytes = this.p.getTotalBytes() - this.p.getCurBytes();
            if (jD < totalBytes && (iA = com.ss.android.socialbase.downloader.g.a.a(this.p.getId()).a("space_fill_min_keep_mb", 100)) > 0) {
                long j2 = jD - (((long) iA) * PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED);
                StringBuilder sbS = c.a.a.a.a.s("checkSpaceOverflowInProgress: minKeep  = ", iA, "MB, canDownload = ");
                sbS.append(com.ss.android.socialbase.downloader.i.f.a(j2));
                sbS.append("MB");
                com.ss.android.socialbase.downloader.c.a.c(str, sbS.toString());
                if (j2 > 0) {
                    this.G = j2 + PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED + this.p.getCurBytes();
                    return;
                } else {
                    this.G = 0L;
                    throw new com.ss.android.socialbase.downloader.exception.d(jD, totalBytes);
                }
            }
        }
        this.G = 0L;
    }

    private void E() throws com.ss.android.socialbase.downloader.exception.f {
        if (this.p.isOnlyWifi() && !com.ss.android.socialbase.downloader.i.f.a(com.ss.android.socialbase.downloader.downloader.c.N(), "android.permission.ACCESS_NETWORK_STATE")) {
            throw new com.ss.android.socialbase.downloader.exception.f(PointerIconCompat.TYPE_ZOOM_OUT, String.format("download task need permission:%s", "android.permission.ACCESS_NETWORK_STATE"));
        }
        if (!this.p.isDownloadWithWifiValid()) {
            throw new com.ss.android.socialbase.downloader.exception.c();
        }
        if (!this.p.isPauseReserveWithWifiValid()) {
            throw new com.ss.android.socialbase.downloader.exception.e();
        }
    }

    private void F() throws BaseException {
        if (TextUtils.isEmpty(this.p.getSavePath())) {
            throw new BaseException(1028, "download savePath can not be empty");
        }
        if (TextUtils.isEmpty(this.p.getName())) {
            throw new BaseException(1029, "download name can not be empty");
        }
        File file = new File(this.p.getSavePath());
        if (file.exists()) {
            if (file.isDirectory()) {
                return;
            }
            if (!com.ss.android.socialbase.downloader.i.d.b(this.p)) {
                StringBuilder sbR = c.a.a.a.a.r("download savePath is not a directory:");
                sbR.append(this.p.getSavePath());
                throw new BaseException(1031, sbR.toString());
            }
            file.delete();
            if (file.mkdirs() || file.exists()) {
                return;
            }
            StringBuilder sbR2 = c.a.a.a.a.r("download savePath is not directory:path=");
            sbR2.append(this.p.getSavePath());
            throw new BaseException(1031, sbR2.toString());
        }
        boolean zMkdirs = file.mkdirs();
        if (zMkdirs || file.exists()) {
            return;
        }
        int i2 = 0;
        if (com.ss.android.socialbase.downloader.g.a.a(this.p.getId()).a("opt_mkdir_failed", 0) != 1) {
            StringBuilder sbR3 = c.a.a.a.a.r("download savePath directory can not created:");
            sbR3.append(this.p.getSavePath());
            throw new BaseException(1030, sbR3.toString());
        }
        while (!zMkdirs) {
            int i3 = i2 + 1;
            if (i2 >= 3) {
                break;
            }
            try {
                Thread.sleep(10L);
                zMkdirs = file.mkdirs();
                i2 = i3;
            } catch (InterruptedException unused) {
            }
        }
        if (zMkdirs || file.exists()) {
            return;
        }
        if (com.ss.android.socialbase.downloader.i.f.d(this.p.getSavePath()) < 16384) {
            StringBuilder sbR4 = c.a.a.a.a.r("download savePath directory can not created:");
            sbR4.append(this.p.getSavePath());
            throw new BaseException(PointerIconCompat.TYPE_CELL, sbR4.toString());
        }
        StringBuilder sbR5 = c.a.a.a.a.r("download savePath directory can not created:");
        sbR5.append(this.p.getSavePath());
        throw new BaseException(1030, sbR5.toString());
    }

    private void G() {
        long jF = com.ss.android.socialbase.downloader.i.f.f(this.p);
        long curBytes = this.p.getCurBytes();
        if (jF != curBytes) {
            com.ss.android.socialbase.downloader.c.a.d(a, "checkTaskCanResume: offset = " + jF + ", curBytes = " + curBytes);
        }
        this.p.setCurBytes(jF);
        boolean z = jF > 0;
        this.f3706i = z;
        if (z || this.F) {
            return;
        }
        com.ss.android.socialbase.downloader.c.a.c(a, "checkTaskCanResume: deleteAllDownloadFiles");
        this.o.d(this.p.getId());
        this.o.m(this.p.getId());
        com.ss.android.socialbase.downloader.i.f.a(this.p);
    }

    private void H() {
        String str = a;
        StringBuilder sbR = c.a.a.a.a.r("clearCurrentDownloadData::");
        sbR.append(Log.getStackTraceString(new Throwable()));
        com.ss.android.socialbase.downloader.c.a.d(str, sbR.toString());
        try {
            this.o.d(this.p.getId());
            this.o.m(this.p.getId());
            com.ss.android.socialbase.downloader.i.f.a(this.p);
            this.f3706i = false;
            this.p.resetDataForEtagEndure("");
            this.o.a(this.p);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void I() {
        try {
            for (b bVar : (ArrayList) this.f3703f.clone()) {
                if (bVar != null) {
                    bVar.b();
                }
            }
        } catch (Throwable th) {
            String str = a;
            StringBuilder sbR = c.a.a.a.a.r("cancelAllChunkRunnable: ");
            sbR.append(th.toString());
            com.ss.android.socialbase.downloader.c.a.c(str, sbR.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J() {
        com.ss.android.socialbase.downloader.impls.a aVarC;
        if (v() || (aVarC = com.ss.android.socialbase.downloader.downloader.c.C()) == null) {
            return;
        }
        aVarC.l(this.p.getId());
    }

    private boolean K() {
        return false;
    }

    private void h() {
        DownloadInfo downloadInfo = this.p;
        if (downloadInfo == null) {
            return;
        }
        int retryCount = downloadInfo.getRetryCount() - this.p.getCurRetryTime();
        if (retryCount < 0) {
            retryCount = 0;
        }
        AtomicInteger atomicInteger = this.f3702e;
        if (atomicInteger == null) {
            this.f3702e = new AtomicInteger(retryCount);
        } else {
            atomicInteger.set(retryCount);
        }
    }

    private boolean i() {
        int status = this.p.getStatus();
        if (status == 1 || this.p.canSkipStatusHandler()) {
            return true;
        }
        if (status == -2 || status == -4) {
            return false;
        }
        b(new BaseException(1000, c.a.a.a.a.G("The download Task can't start, because its status is not prepare:", status)));
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00ab A[Catch: all -> 0x00e8, TryCatch #6 {all -> 0x00e8, blocks: (B:56:0x00a7, B:58:0x00ab, B:60:0x00af, B:73:0x00e7), top: B:84:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00f5 A[Catch: SQLiteException -> 0x00fd, TRY_LEAVE, TryCatch #11 {SQLiteException -> 0x00fd, blocks: (B:77:0x00ed, B:79:0x00f5), top: B:90:0x00ed }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void j() throws com.ss.android.socialbase.downloader.exception.a {
        /*
            Method dump skipped, instruction units count: 258
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.h.c.j():void");
    }

    private void k() {
        Process.setThreadPriority(10);
        try {
            DownloadInfo downloadInfo = this.p;
            if (downloadInfo != null && this.H > 0) {
                downloadInfo.increaseDownloadPrepareTime(System.currentTimeMillis() - this.H);
            }
        } catch (Throwable unused) {
        }
        try {
            IDownloadInterceptor interceptor = this.f3700c.getInterceptor();
            if (interceptor != null) {
                if (interceptor.intercepte()) {
                    this.v.e();
                    return;
                }
            }
        } finally {
        }
        if (!i()) {
            x monitorDepend = this.f3700c.getMonitorDepend();
            DownloadInfo downloadInfo2 = this.p;
            BaseException baseException = new BaseException(PointerIconCompat.TYPE_HELP, "task status is invalid");
            DownloadInfo downloadInfo3 = this.p;
            com.ss.android.socialbase.downloader.d.a.a(monitorDepend, downloadInfo2, baseException, downloadInfo3 != null ? downloadInfo3.getStatus() : 0);
            return;
        }
        while (true) {
            l();
            if (!this.C) {
                return;
            }
            if (this.B > 0) {
                this.B--;
            } else {
                if (this.p.getCurBytes() != this.p.getTotalBytes()) {
                    com.ss.android.socialbase.downloader.c.a.b(a, this.p.getErrorBytesLog());
                    com.ss.android.socialbase.downloader.downloader.f fVar = this.v;
                    StringBuilder sbR = c.a.a.a.a.r("current bytes is not equals to total bytes, bytes invalid retry status is : ");
                    sbR.append(this.p.getByteInvalidRetryStatus());
                    fVar.a(new com.ss.android.socialbase.downloader.exception.f(1027, sbR.toString()));
                    return;
                }
                if (this.p.getCurBytes() <= 0) {
                    com.ss.android.socialbase.downloader.c.a.b(a, this.p.getErrorBytesLog());
                    com.ss.android.socialbase.downloader.downloader.f fVar2 = this.v;
                    StringBuilder sbR2 = c.a.a.a.a.r("curBytes is 0, bytes invalid retry status is : ");
                    sbR2.append(this.p.getByteInvalidRetryStatus());
                    fVar2.a(new com.ss.android.socialbase.downloader.exception.f(1026, sbR2.toString()));
                    return;
                }
                if (this.p.getTotalBytes() <= 0) {
                    com.ss.android.socialbase.downloader.c.a.b(a, this.p.getErrorBytesLog());
                    com.ss.android.socialbase.downloader.downloader.f fVar3 = this.v;
                    StringBuilder sbR3 = c.a.a.a.a.r("TotalBytes is 0, bytes invalid retry status is : ");
                    sbR3.append(this.p.getByteInvalidRetryStatus());
                    fVar3.a(new com.ss.android.socialbase.downloader.exception.f(1044, sbR3.toString()));
                    return;
                }
            }
        }
    }

    private void l() {
        boolean z;
        List<com.ss.android.socialbase.downloader.model.b> listC;
        try {
            this.n = com.ss.android.socialbase.downloader.constants.h.RUN_STATUS_NONE;
            this.p.updateStartDownloadTime();
            this.p.resetRealStartDownloadTime();
            long jCurrentTimeMillis = System.currentTimeMillis();
            this.p.setFirstSpeedTime(-1L);
            try {
                j();
                z = false;
            } catch (com.ss.android.socialbase.downloader.exception.a e2) {
                com.ss.android.socialbase.downloader.c.a.b(a, "file exist " + e2.a());
                this.E = e2.a();
                z = true;
            }
            if (!this.C) {
                this.v.b();
            }
            this.C = false;
            if (v()) {
                return;
            }
            if (!TextUtils.isEmpty(this.E) && z) {
                if (this.p.isExpiredRedownload()) {
                    this.F = com.ss.android.socialbase.downloader.i.f.d(this.p);
                }
                if (!this.F) {
                    m();
                    return;
                }
            }
            while (!v()) {
                try {
                    try {
                        try {
                            try {
                                F();
                                B();
                                E();
                                listC = this.o.c(this.p.getId());
                                G();
                            } catch (Throwable th) {
                                com.ss.android.socialbase.downloader.c.a.d(a, "downloadInner: throwable =  " + th);
                                if (this.n != com.ss.android.socialbase.downloader.constants.h.RUN_STATUS_PAUSE) {
                                    b(new BaseException(1045, th));
                                }
                            }
                        } catch (com.ss.android.socialbase.downloader.exception.i e3) {
                            try {
                                com.ss.android.socialbase.downloader.c.a.d(a, "downloadInner: retry throwable for " + e3.a());
                                if (this.n != com.ss.android.socialbase.downloader.constants.h.RUN_STATUS_PAUSE) {
                                    AtomicInteger atomicInteger = this.f3702e;
                                    if (atomicInteger != null && atomicInteger.get() > 0) {
                                        this.p.updateCurRetryTime(this.f3702e.decrementAndGet());
                                        this.p.setStatus(5);
                                    } else if (this.f3702e == null) {
                                        b(new BaseException(1043, "retry for Throwable, but retain retry time is NULL, last error is" + e3.a()));
                                    } else if (this.p.trySwitchToNextBackupUrl()) {
                                        this.p.setStatus(5);
                                        this.f3702e.set(this.p.getRetryCount());
                                        this.p.updateCurRetryTime(this.f3702e.get());
                                    } else {
                                        b(new BaseException(PointerIconCompat.TYPE_ZOOM_IN, String.format("retry for Throwable, but retry Time %s all used, last error is %s", String.valueOf(this.p.getRetryCount()), e3.a())));
                                    }
                                    s();
                                }
                            } catch (Throwable th2) {
                                s();
                                throw th2;
                            }
                        }
                    } catch (com.ss.android.socialbase.downloader.exception.a unused) {
                        m();
                    }
                } catch (BaseException e4) {
                    com.ss.android.socialbase.downloader.c.a.d(a, "downloadInner: baseException = " + e4);
                    if (this.n != com.ss.android.socialbase.downloader.constants.h.RUN_STATUS_PAUSE) {
                        if (e4.getErrorCode() != 1025 && e4.getErrorCode() != 1009) {
                            if (a(e4)) {
                                if (com.ss.android.socialbase.downloader.i.f.a(e4)) {
                                    H();
                                }
                                if (a(e4, 0L) == com.ss.android.socialbase.downloader.exception.h.RETURN) {
                                    s();
                                    return;
                                }
                                s();
                            } else {
                                b(e4);
                            }
                        }
                        this.n = com.ss.android.socialbase.downloader.constants.h.RUN_STATUS_END_RIGHT_NOW;
                        s();
                        return;
                    }
                }
                if (n()) {
                    com.ss.android.socialbase.downloader.c.a.c(a, "downloadSegments return");
                    s();
                    return;
                }
                String connectionUrl = this.p.getConnectionUrl();
                if (v()) {
                    s();
                    return;
                }
                long jE = this.f3706i ? com.ss.android.socialbase.downloader.i.f.e(this.p) : 0L;
                com.ss.android.socialbase.downloader.model.b bVarA = a(this.p, jE);
                List<com.ss.android.socialbase.downloader.model.c> listA = a(bVarA);
                com.ss.android.socialbase.downloader.i.f.a(listA, this.p);
                com.ss.android.socialbase.downloader.i.f.b(listA, this.p);
                this.p.setPreconnectLevel(0);
                long jCurrentTimeMillis2 = System.currentTimeMillis();
                try {
                    a(connectionUrl, listA, jE);
                    this.p.increaseAllConnectTime(System.currentTimeMillis() - jCurrentTimeMillis2);
                    if (v()) {
                        s();
                        return;
                    }
                    long totalBytes = this.p.getTotalBytes();
                    a(totalBytes);
                    int iA = a(totalBytes, listC);
                    if (v()) {
                        s();
                        return;
                    }
                    if (iA <= 0) {
                        throw new BaseException(1032, "chunkCount is 0");
                    }
                    boolean z2 = iA == 1;
                    this.f3705h = z2;
                    if (z2) {
                        if (this.x == null) {
                            try {
                                jCurrentTimeMillis2 = System.currentTimeMillis();
                                a(connectionUrl, listA);
                                this.p.increaseAllConnectTime(System.currentTimeMillis() - jCurrentTimeMillis2);
                            } finally {
                            }
                        }
                        if (v()) {
                            s();
                            return;
                        } else {
                            this.p.setFirstSpeedTime(System.currentTimeMillis() - jCurrentTimeMillis);
                            o();
                            a(bVarA, connectionUrl, this.x);
                        }
                    } else {
                        if (!this.p.isNeedReuseFirstConnection()) {
                            r();
                        }
                        if (v()) {
                            s();
                            return;
                        }
                        o();
                        this.p.setFirstSpeedTime(System.currentTimeMillis() - jCurrentTimeMillis);
                        if (this.f3706i) {
                            a(iA, listC);
                        } else {
                            a(totalBytes, iA);
                        }
                    }
                    s();
                    return;
                } finally {
                }
            }
        } finally {
            p();
        }
    }

    private void m() {
        com.ss.android.socialbase.downloader.c.a.b(a, "finishWithFileExist");
        if (com.ss.android.socialbase.downloader.g.a.c().b("fix_end_for_file_exist_error", true)) {
            if (this.E.equals(this.p.getName())) {
                this.n = com.ss.android.socialbase.downloader.constants.h.RUN_STATUS_END_RIGHT_NOW;
                return;
            } else {
                this.n = com.ss.android.socialbase.downloader.constants.h.RUN_STATUS_END_FOR_FILE_EXIST;
                return;
            }
        }
        if (this.E.equals(this.p.getTargetFilePath())) {
            this.n = com.ss.android.socialbase.downloader.constants.h.RUN_STATUS_END_RIGHT_NOW;
        } else {
            this.n = com.ss.android.socialbase.downloader.constants.h.RUN_STATUS_END_FOR_FILE_EXIST;
        }
    }

    private boolean n() {
        if (this.p.isExpiredRedownload() || this.p.getChunkCount() != 1 || this.p.getThrottleNetSpeed() > 0) {
            return false;
        }
        JSONObject jSONObjectD = com.ss.android.socialbase.downloader.g.a.a(this.p.getId()).d("segment_config");
        List<com.ss.android.socialbase.downloader.f.i> listN = this.o.n(this.p.getId());
        if (this.p.getCurBytes() > 0) {
            if (listN == null || listN.isEmpty()) {
                return false;
            }
            if (jSONObjectD == null) {
                jSONObjectD = new JSONObject();
            }
        }
        if (jSONObjectD == null) {
            return false;
        }
        this.K = new k(this.p, n.a(jSONObjectD), this);
        if (!v()) {
            return this.K.a(listN);
        }
        com.ss.android.socialbase.downloader.c.a.c(a, "downloadSegments: is stopped by user");
        if (this.n == com.ss.android.socialbase.downloader.constants.h.RUN_STATUS_CANCELED) {
            this.K.a();
        } else {
            this.K.b();
        }
        return true;
    }

    private void o() {
        if (com.ss.android.socialbase.downloader.g.a.a(this.p.getId()).a("reset_retain_retry_times", 0) != 1 || this.J >= 3) {
            return;
        }
        this.f3702e.set(this.p.isBackUpUrlUsed() ? this.p.getBackUpUrlRetryCount() : this.p.getRetryCount());
        this.J++;
    }

    private void p() {
        boolean zW;
        boolean z;
        String str = a;
        StringBuilder sbR = c.a.a.a.a.r("endDownloadRunnable::runStatus=");
        sbR.append(this.n);
        com.ss.android.socialbase.downloader.c.a.b(str, sbR.toString());
        boolean z2 = (this.n == com.ss.android.socialbase.downloader.constants.h.RUN_STATUS_PAUSE || this.n == com.ss.android.socialbase.downloader.constants.h.RUN_STATUS_CANCELED) ? false : true;
        try {
            zW = w();
            z = false;
        } catch (Exception e2) {
            if (e2 instanceof BaseException) {
                this.v.a((BaseException) e2);
            } else {
                this.v.a(new BaseException(1046, e2));
            }
            zW = true;
            z = true;
        }
        if (!zW && !z) {
            this.C = true;
            com.ss.android.socialbase.downloader.c.a.b(a, "jump to restart");
            return;
        }
        this.m.set(false);
        if (z2) {
            try {
                com.ss.android.socialbase.downloader.impls.a aVarC = com.ss.android.socialbase.downloader.downloader.c.C();
                if (aVarC != null) {
                    aVarC.a(this);
                }
            } catch (Throwable th) {
                th.printStackTrace();
                x monitorDepend = this.f3700c.getMonitorDepend();
                DownloadInfo downloadInfo = this.p;
                BaseException baseException = new BaseException(PointerIconCompat.TYPE_HORIZONTAL_DOUBLE_ARROW, com.ss.android.socialbase.downloader.i.f.b(th, "removeDownloadRunnable"));
                DownloadInfo downloadInfo2 = this.p;
                com.ss.android.socialbase.downloader.d.a.a(monitorDepend, downloadInfo, baseException, downloadInfo2 != null ? downloadInfo2.getStatus() : 0);
            }
        }
    }

    private void q() {
        com.ss.android.socialbase.downloader.network.g gVar = this.y;
        if (gVar != null) {
            gVar.c();
            this.y = null;
        }
    }

    private void r() {
        i iVar = this.x;
        if (iVar != null) {
            iVar.d();
            this.x = null;
        }
    }

    private void s() {
        q();
        r();
    }

    private void t() throws BaseException {
        if (this.f3704g != null) {
            if (this.n == com.ss.android.socialbase.downloader.constants.h.RUN_STATUS_CANCELED) {
                this.p.setStatus(-4);
                this.f3704g.c();
            } else if (this.n != com.ss.android.socialbase.downloader.constants.h.RUN_STATUS_PAUSE) {
                this.f3704g.d();
            } else {
                this.p.setStatus(-2);
                this.f3704g.b();
            }
        }
    }

    private boolean u() {
        return this.n == com.ss.android.socialbase.downloader.constants.h.RUN_STATUS_CANCELED || this.n == com.ss.android.socialbase.downloader.constants.h.RUN_STATUS_PAUSE;
    }

    private boolean v() {
        if (!u() && this.p.getStatus() != -2) {
            return false;
        }
        if (u()) {
            return true;
        }
        if (this.p.getStatus() == -2) {
            this.n = com.ss.android.socialbase.downloader.constants.h.RUN_STATUS_PAUSE;
            return true;
        }
        if (this.p.getStatus() != -4) {
            return true;
        }
        this.n = com.ss.android.socialbase.downloader.constants.h.RUN_STATUS_CANCELED;
        return true;
    }

    private boolean w() {
        if (this.n == com.ss.android.socialbase.downloader.constants.h.RUN_STATUS_ERROR) {
            this.v.a(this.w);
        } else if (this.n == com.ss.android.socialbase.downloader.constants.h.RUN_STATUS_CANCELED) {
            this.v.c();
        } else if (this.n == com.ss.android.socialbase.downloader.constants.h.RUN_STATUS_PAUSE) {
            this.v.d();
        } else if (this.n == com.ss.android.socialbase.downloader.constants.h.RUN_STATUS_END_RIGHT_NOW) {
            try {
                this.v.g();
            } catch (BaseException e2) {
                this.v.a(e2);
            }
        } else if (this.n == com.ss.android.socialbase.downloader.constants.h.RUN_STATUS_END_FOR_FILE_EXIST) {
            try {
                this.v.a(this.E);
            } catch (BaseException e3) {
                this.v.a(e3);
            }
        } else {
            if (this.n == com.ss.android.socialbase.downloader.constants.h.RUN_STATUS_ALL_CHUNK_RETRY_WITH_RESET) {
                this.v.a(this.w, false);
                return false;
            }
            if (this.n == com.ss.android.socialbase.downloader.constants.h.RUN_STATUS_WAITING_ASYNC_HANDLER) {
                return true;
            }
            com.ss.android.socialbase.downloader.constants.h hVar = this.n;
            com.ss.android.socialbase.downloader.constants.h hVar2 = com.ss.android.socialbase.downloader.constants.h.RUN_STATUS_RETRY_DELAY;
            if (hVar == hVar2 && !x()) {
                com.ss.android.socialbase.downloader.c.a.b(a, "doTaskStatusHandle retryDelay");
                z();
                return this.n == hVar2;
            }
            try {
                if (!y()) {
                    return false;
                }
                this.v.f();
                com.ss.android.socialbase.downloader.impls.r.a().d();
            } catch (Throwable th) {
                b(new BaseException(PointerIconCompat.TYPE_TEXT, com.ss.android.socialbase.downloader.i.f.b(th, "doTaskStatusHandle onComplete")));
            }
        }
        return true;
    }

    private boolean x() {
        if (this.p.getChunkCount() <= 1) {
            return this.p.getCurBytes() > 0 && this.p.getCurBytes() == this.p.getTotalBytes();
        }
        List<com.ss.android.socialbase.downloader.model.b> listC = this.o.c(this.p.getId());
        if (listC == null || listC.size() <= 1) {
            return false;
        }
        for (com.ss.android.socialbase.downloader.model.b bVar : listC) {
            if (bVar == null || !bVar.i()) {
                return false;
            }
        }
        return true;
    }

    private boolean y() {
        if (this.p.isChunked()) {
            DownloadInfo downloadInfo = this.p;
            downloadInfo.setTotalBytes(downloadInfo.getCurBytes());
        }
        String str = a;
        StringBuilder sbR = c.a.a.a.a.r("checkCompletedByteValid: downloadInfo.getCurBytes() = ");
        sbR.append(this.p.getCurBytes());
        sbR.append(",  downloadInfo.getTotalBytes() = ");
        sbR.append(this.p.getTotalBytes());
        com.ss.android.socialbase.downloader.c.a.c(str, sbR.toString());
        if (this.p.getCurBytes() > 0) {
            if (this.p.isIgnoreDataVerify()) {
                return true;
            }
            if (this.p.getTotalBytes() > 0 && this.p.getCurBytes() == this.p.getTotalBytes()) {
                return true;
            }
        }
        this.p.setByteInvalidRetryStatus(com.ss.android.socialbase.downloader.constants.b.BYTE_INVALID_RETRY_STATUS_RESTART);
        this.p.reset();
        this.o.a(this.p);
        this.o.d(this.p.getId());
        this.o.m(this.p.getId());
        com.ss.android.socialbase.downloader.i.f.a(this.p);
        return false;
    }

    private void z() {
        this.n = com.ss.android.socialbase.downloader.constants.h.RUN_STATUS_NONE;
    }

    public void b() {
        com.ss.android.socialbase.downloader.constants.h hVar = com.ss.android.socialbase.downloader.constants.h.RUN_STATUS_CANCELED;
        this.n = hVar;
        if (this.K != null) {
            this.K.a();
        }
        if (this.f3704g != null) {
            this.f3704g.c();
        }
        if (this.K == null && this.f3704g == null) {
            s();
            this.n = hVar;
            p();
        }
        I();
    }

    public DownloadTask c() {
        return this.f3700c;
    }

    public boolean d() {
        return this.m.get();
    }

    public int e() {
        DownloadInfo downloadInfo = this.p;
        if (downloadInfo != null) {
            return downloadInfo.getId();
        }
        return 0;
    }

    public void f() {
        this.H = System.currentTimeMillis();
        this.v.a();
    }

    public Future g() {
        return this.f3699b;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.ss.android.socialbase.downloader.downloader.c.a(this.f3700c, 3);
        try {
            com.ss.android.socialbase.downloader.network.b.a().b();
            k();
            com.ss.android.socialbase.downloader.network.b.a().c();
            com.ss.android.socialbase.downloader.downloader.c.b(this.f3700c, 3);
        } catch (Throwable th) {
            com.ss.android.socialbase.downloader.network.b.a().c();
            throw th;
        }
    }

    private boolean d(BaseException baseException) {
        AtomicInteger atomicInteger = this.f3702e;
        boolean z = true;
        if (atomicInteger == null) {
            StringBuilder sbR = c.a.a.a.a.r("retry for exception, but retain retry time is null, last error is :");
            sbR.append(baseException.getErrorMessage());
            b(new BaseException(1043, sbR.toString()));
            return true;
        }
        if (atomicInteger.get() <= 0 || (baseException != null && baseException.getErrorCode() == 1070)) {
            if (this.p.trySwitchToNextBackupUrl()) {
                this.f3702e.set(this.p.getBackUpUrlRetryCount());
                this.p.updateCurRetryTime(this.f3702e.get());
            } else {
                if (baseException == null || ((baseException.getErrorCode() != 1011 && (baseException.getCause() == null || !(baseException.getCause() instanceof SSLHandshakeException))) || !this.p.canReplaceHttpForRetry())) {
                    b(new BaseException(baseException.getErrorCode(), String.format("retry for exception, but current retry time : %s , retry Time %s all used, last error is %s", String.valueOf(this.f3702e), String.valueOf(this.p.getRetryCount()), baseException.getErrorMessage())));
                    return true;
                }
                this.f3702e.set(this.p.getRetryCount());
                this.p.updateCurRetryTime(this.f3702e.get());
                this.p.setHttpsToHttpRetryUsed(true);
            }
            z = false;
        }
        if (this.n != com.ss.android.socialbase.downloader.constants.h.RUN_STATUS_RETRY_DELAY && z) {
            this.p.updateCurRetryTime(this.f3702e.decrementAndGet());
        }
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.h.f
    public void c(BaseException baseException) {
        DownloadInfo downloadInfo = this.p;
        if (downloadInfo != null) {
            downloadInfo.setChunkDowngradeRetryUsed(true);
        }
        a(baseException, false);
    }

    public void a() {
        com.ss.android.socialbase.downloader.constants.h hVar = com.ss.android.socialbase.downloader.constants.h.RUN_STATUS_PAUSE;
        this.n = hVar;
        if (this.K != null) {
            this.K.b();
        }
        if (this.f3704g != null) {
            this.f3704g.b();
        }
        if (this.K == null && this.f3704g == null) {
            s();
            this.n = hVar;
            p();
        }
        try {
            for (b bVar : (ArrayList) this.f3703f.clone()) {
                if (bVar != null) {
                    bVar.a();
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void c(long j2) {
        i iVar = this.x;
        if (iVar != null && (iVar instanceof com.ss.android.socialbase.downloader.network.a)) {
            try {
                ((com.ss.android.socialbase.downloader.network.a) iVar).a(j2);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private void b(String str, List<com.ss.android.socialbase.downloader.model.c> list, long j2) {
        com.ss.android.socialbase.downloader.network.a.c cVarA;
        boolean z = true;
        if (this.p.getChunkCount() == 1 && (cVarA = com.ss.android.socialbase.downloader.network.a.a.a().a(str, list)) != null) {
            this.y = cVarA;
            this.p.setPreconnectLevel(1);
        }
        if (this.y == null && !this.D && this.p.isHeadConnectionAvailable()) {
            try {
                int iB = this.I.b("net_lib_strategy");
                if (this.I.a("monitor_download_connect", 0) <= 0) {
                    z = false;
                }
                this.y = com.ss.android.socialbase.downloader.downloader.c.a(str, list, iB, z, this.p);
            } catch (Throwable th) {
                this.p.setHeadConnectionException(com.ss.android.socialbase.downloader.i.f.j(th));
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x005e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private int a(long r7, java.util.List<com.ss.android.socialbase.downloader.model.b> r9) {
        /*
            r6 = this;
            boolean r0 = r6.C()
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L5e
            boolean r0 = r6.f3706i
            if (r0 == 0) goto L1a
            if (r9 == 0) goto L13
            int r9 = r9.size()
            goto L5c
        L13:
            com.ss.android.socialbase.downloader.model.DownloadInfo r9 = r6.p
            int r9 = r9.getChunkCount()
            goto L5c
        L1a:
            com.ss.android.socialbase.downloader.downloader.h r9 = r6.q
            if (r9 == 0) goto L23
            int r9 = r9.a(r7)
            goto L29
        L23:
            com.ss.android.socialbase.downloader.downloader.h r9 = r6.r
            int r9 = r9.a(r7)
        L29:
            com.ss.android.socialbase.downloader.network.k r0 = com.ss.android.socialbase.downloader.network.k.a()
            com.ss.android.socialbase.downloader.network.l r0 = r0.b()
            java.lang.String r3 = com.ss.android.socialbase.downloader.h.c.a
            java.lang.Object[] r4 = new java.lang.Object[r2]
            java.lang.String r5 = r0.name()
            r4[r1] = r5
            java.lang.String r5 = "NetworkQuality is : %s"
            java.lang.String r4 = java.lang.String.format(r5, r4)
            com.ss.android.socialbase.downloader.c.a.b(r3, r4)
            com.ss.android.socialbase.downloader.model.DownloadInfo r3 = r6.p
            java.lang.String r4 = r0.name()
            r3.setNetworkQuality(r4)
            com.ss.android.socialbase.downloader.downloader.g r3 = r6.s
            if (r3 == 0) goto L56
            int r9 = r3.a(r9, r0)
            goto L5c
        L56:
            com.ss.android.socialbase.downloader.downloader.g r3 = r6.t
            int r9 = r3.a(r9, r0)
        L5c:
            if (r9 > 0) goto L5f
        L5e:
            r9 = 1
        L5f:
            boolean r0 = com.ss.android.socialbase.downloader.c.a.a()
            if (r0 == 0) goto L88
            java.lang.String r0 = com.ss.android.socialbase.downloader.h.c.a
            r3 = 3
            java.lang.Object[] r3 = new java.lang.Object[r3]
            java.lang.String r4 = java.lang.String.valueOf(r9)
            r3[r1] = r4
            com.ss.android.socialbase.downloader.model.DownloadInfo r1 = r6.p
            java.lang.String r1 = r1.getName()
            r3[r2] = r1
            r1 = 2
            java.lang.String r7 = java.lang.String.valueOf(r7)
            r3[r1] = r7
            java.lang.String r7 = "chunk count : %s for %s contentLen:%s"
            java.lang.String r7 = java.lang.String.format(r7, r3)
            com.ss.android.socialbase.downloader.c.a.b(r0, r7)
        L88:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.h.c.a(long, java.util.List):int");
    }

    @Override // com.ss.android.socialbase.downloader.h.f
    public boolean b(long j2) throws com.ss.android.socialbase.downloader.exception.d {
        if (this.G > 0 && this.p.getCurBytes() > this.G) {
            D();
        }
        return this.v.a(j2);
    }

    @Override // com.ss.android.socialbase.downloader.h.f
    public void b(BaseException baseException) {
        String str = a;
        StringBuilder sbR = c.a.a.a.a.r("onError:");
        sbR.append(baseException.getMessage());
        com.ss.android.socialbase.downloader.c.a.b(str, sbR.toString());
        this.n = com.ss.android.socialbase.downloader.constants.h.RUN_STATUS_ERROR;
        this.w = baseException;
        I();
    }

    private void a(String str, List<com.ss.android.socialbase.downloader.model.c> list, long j2) throws com.ss.android.socialbase.downloader.exception.i, BaseException {
        b(str, list, j2);
        com.ss.android.socialbase.downloader.network.g gVar = this.y;
        if (gVar != null) {
            try {
                a(str, gVar, j2);
            } catch (Throwable unused) {
                this.D = true;
            }
        }
        if (this.y == null || this.D) {
            a(str, list);
            a(str, this.x, j2);
        }
    }

    private void a(String str, List<com.ss.android.socialbase.downloader.model.c> list) throws BaseException {
        i iVarA;
        if (this.x != null) {
            return;
        }
        com.ss.android.socialbase.downloader.network.a.d dVarB = this.p.getChunkCount() == 1 ? com.ss.android.socialbase.downloader.network.a.a.a().b(str, list) : null;
        try {
            if (dVarB != null) {
                a(this.x);
                this.p.setPreconnectLevel(2);
                this.x = dVarB;
            } else {
                try {
                    iVarA = com.ss.android.socialbase.downloader.downloader.c.a(this.p.isNeedDefaultHttpServiceBackUp(), this.p.getMaxBytes(), str, null, list, this.I.b("net_lib_strategy"), this.I.a("monitor_download_connect", 0) > 0, this.p);
                    this.x = iVarA;
                } catch (BaseException e2) {
                    throw e2;
                } catch (Throwable th) {
                    if (this.p.isExpiredRedownload() && com.ss.android.socialbase.downloader.i.f.g(th) && com.ss.android.socialbase.downloader.i.f.c(list)) {
                        com.ss.android.socialbase.downloader.c.a.b(a, "dcache=execepiton responseCode=304 lastModified not changed, use local file.. old cacheControl=" + this.p.getCacheControl());
                        long jI = com.ss.android.socialbase.downloader.i.f.i(this.p.getCacheControl());
                        if (jI <= 0) {
                            jI = com.ss.android.socialbase.downloader.g.a.a(this.p.getId()).a("default_304_max_age", 300);
                        }
                        this.p.setCacheExpiredTime((jI * 1000) + System.currentTimeMillis());
                        throw new com.ss.android.socialbase.downloader.exception.a(this.E);
                    }
                    if (com.ss.android.socialbase.downloader.i.f.f(th)) {
                        a("", "http code 416");
                    } else if (com.ss.android.socialbase.downloader.i.f.e(th)) {
                        a("", "http code 412");
                    } else {
                        com.ss.android.socialbase.downloader.i.f.a(th, "CreateFirstConnection");
                    }
                    iVarA = this.x;
                }
                a(iVarA);
            }
            if (this.x == null) {
                throw new BaseException(1022, new IOException("download can't continue, firstConnection is null"));
            }
        } catch (Throwable th2) {
            a(this.x);
            throw th2;
        }
    }

    public static com.ss.android.socialbase.downloader.model.b a(DownloadInfo downloadInfo, long j2) {
        return new b.a(downloadInfo.getId()).a(-1).a(0L).e(j2).b(j2).c(0L).d(downloadInfo.getTotalBytes() - j2).a();
    }

    private List<com.ss.android.socialbase.downloader.model.c> a(com.ss.android.socialbase.downloader.model.b bVar) {
        List<com.ss.android.socialbase.downloader.model.c> listA = com.ss.android.socialbase.downloader.i.f.a(this.p.getExtraHeaders(), this.p.geteTag(), bVar);
        if (this.p.isExpiredRedownload() && this.F && this.p.getLastModified() != null) {
            listA.add(new com.ss.android.socialbase.downloader.model.c("if-modified-since", this.p.getLastModified()));
            listA.add(new com.ss.android.socialbase.downloader.model.c("download-tc21-1-15", "download-tc21-1-15"));
            String str = a;
            StringBuilder sbR = c.a.a.a.a.r("dcache::add head IF_MODIFIED_SINCE=");
            sbR.append(this.p.getLastModified());
            com.ss.android.socialbase.downloader.c.a.b(str, sbR.toString());
        }
        return listA;
    }

    private void a(int i2, List<com.ss.android.socialbase.downloader.model.b> list) throws BaseException {
        if (list.size() == i2) {
            a(list, this.p.getTotalBytes());
            return;
        }
        throw new BaseException(1033, new IllegalArgumentException());
    }

    private void a(long j2, int i2) throws BaseException {
        long j3 = j2 / ((long) i2);
        int id = this.p.getId();
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        long j4 = 0;
        while (i3 < i2) {
            com.ss.android.socialbase.downloader.model.b bVarA = new b.a(id).a(i3).a(j4).e(j4).b(j4).c(i3 == i2 + (-1) ? 0L : (j4 + j3) - 1).a();
            arrayList.add(bVarA);
            this.o.a(bVarA);
            j4 += j3;
            i3++;
        }
        this.p.setChunkCount(i2);
        this.o.a(id, i2);
        a(arrayList, j2);
    }

    private void a(List<com.ss.android.socialbase.downloader.model.b> list, long j2) throws BaseException {
        long jP;
        for (com.ss.android.socialbase.downloader.model.b bVar : list) {
            if (bVar != null) {
                if (bVar.p() == 0) {
                    jP = j2 - bVar.n();
                } else {
                    jP = (bVar.p() - bVar.n()) + 1;
                }
                if (jP > 0) {
                    bVar.a(jP);
                    if (this.p.isNeedReuseFirstConnection() && this.x != null && (!this.p.isHeadConnectionAvailable() || this.D)) {
                        if (bVar.s() == 0) {
                            this.f3703f.add(new b(bVar, this.f3700c, this.x, this));
                        } else if (bVar.s() > 0) {
                            this.f3703f.add(new b(bVar, this.f3700c, this));
                        }
                    } else {
                        this.f3703f.add(new b(bVar, this.f3700c, this));
                    }
                }
            }
        }
        if (com.ss.android.socialbase.downloader.i.a.a(64)) {
            ArrayList arrayList = new ArrayList(this.f3703f.size());
            for (b bVar2 : this.f3703f) {
                if (this.n == com.ss.android.socialbase.downloader.constants.h.RUN_STATUS_CANCELED) {
                    bVar2.b();
                } else if (this.n == com.ss.android.socialbase.downloader.constants.h.RUN_STATUS_PAUSE) {
                    bVar2.a();
                } else {
                    arrayList.add(bVar2);
                }
            }
            try {
                List<Future> listD = com.ss.android.socialbase.downloader.impls.e.d(arrayList);
                for (Runnable runnableE = (Runnable) arrayList.remove(0); runnableE != null; runnableE = com.ss.android.socialbase.downloader.impls.e.e(listD)) {
                    if (v()) {
                        return;
                    }
                    try {
                        runnableE.run();
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
                if (listD == null || listD.isEmpty()) {
                    return;
                }
                for (Future future : listD) {
                    if (future != null && !future.isDone()) {
                        try {
                            future.get();
                        } catch (Throwable unused) {
                        }
                    }
                }
                return;
            } catch (Throwable unused2) {
                return;
            }
        }
        ArrayList arrayList2 = new ArrayList(this.f3703f.size());
        for (b bVar3 : this.f3703f) {
            if (this.n == com.ss.android.socialbase.downloader.constants.h.RUN_STATUS_CANCELED) {
                bVar3.b();
            } else if (this.n == com.ss.android.socialbase.downloader.constants.h.RUN_STATUS_PAUSE) {
                bVar3.a();
            } else {
                arrayList2.add(Executors.callable(bVar3));
            }
        }
        if (v()) {
            return;
        }
        try {
            com.ss.android.socialbase.downloader.impls.e.c(arrayList2);
        } catch (InterruptedException e2) {
            throw new BaseException(PointerIconCompat.TYPE_GRAB, e2);
        }
    }

    private void a(com.ss.android.socialbase.downloader.model.b bVar, String str, i iVar) throws BaseException {
        bVar.a(this.p.getTotalBytes() - bVar.n());
        this.p.setChunkCount(1);
        this.o.a(this.p.getId(), 1);
        this.f3704g = new com.ss.android.socialbase.downloader.downloader.e(this.p, str, iVar, bVar, this);
        t();
    }

    /* JADX WARN: Can't wrap try/catch for region: R(11:81|6|7|(9:9|(1:11)|12|(2:14|(4:16|(2:18|(1:20)(2:21|22))(1:23)|24|(3:26|(1:28)|49))(2:29|(1:31)(4:32|(1:34)(1:35)|36|37)))|84|50|51|72|73)(2:38|(4:40|(1:42)(1:43)|44|45)(2:46|(2:76|77)))|48|49|84|50|51|72|73) */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x016e, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0170, code lost:
    
        com.ss.android.socialbase.downloader.c.a.e(com.ss.android.socialbase.downloader.h.c.a, "checkSpaceOverflow: setLength1 e = " + r0 + ", mustSetLength = " + r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0192, code lost:
    
        if (r5 >= r24) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x019e, code lost:
    
        r7.b(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x01a2, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x01a4, code lost:
    
        com.ss.android.socialbase.downloader.c.a.e(com.ss.android.socialbase.downloader.h.c.a, "checkSpaceOverflow: setLength2 ex = " + r0 + ", mustSetLength = " + r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x01c0, code lost:
    
        if (r4 == false) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x01c8, code lost:
    
        throw new com.ss.android.socialbase.downloader.exception.BaseException(1040, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x01c9, code lost:
    
        if (r4 != false) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x01da, code lost:
    
        throw new com.ss.android.socialbase.downloader.exception.BaseException(1040, r0);
     */
    @Override // com.ss.android.socialbase.downloader.h.f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(long r24) throws com.ss.android.socialbase.downloader.exception.BaseException {
        /*
            Method dump skipped, instruction units count: 492
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.h.c.a(long):void");
    }

    private boolean a(int i2, String str, String str2) {
        if (i2 == 412) {
            return true;
        }
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || str.equals(str2) || !(this.f3708k || this.f3707j)) {
            return (i2 == 201 || i2 == 416) && this.p.getCurBytes() > 0;
        }
        return true;
    }

    private void a(String str, String str2) throws com.ss.android.socialbase.downloader.exception.i {
        this.o.d(this.p.getId());
        this.o.m(this.p.getId());
        com.ss.android.socialbase.downloader.i.f.a(this.p);
        this.f3706i = false;
        this.p.resetDataForEtagEndure(str);
        this.o.a(this.p);
        throw new com.ss.android.socialbase.downloader.exception.i(str2);
    }

    @Override // com.ss.android.socialbase.downloader.h.f
    public void a(String str, com.ss.android.socialbase.downloader.network.g gVar, long j2) throws com.ss.android.socialbase.downloader.exception.i, BaseException {
        com.ss.android.socialbase.downloader.network.g gVar2;
        long jB;
        if (gVar == null) {
            return;
        }
        try {
            com.ss.android.socialbase.downloader.model.d dVar = new com.ss.android.socialbase.downloader.model.d(str, gVar);
            int i2 = dVar.f3858c;
            String strD = dVar.d();
            if (TextUtils.isEmpty(this.p.getMimeType()) && !TextUtils.isEmpty(strD)) {
                this.p.setMimeType(strD);
            }
            boolean zB = dVar.b();
            this.f3707j = zB;
            this.p.setSupportPartial(zB);
            this.f3708k = dVar.a();
            String str2 = this.p.geteTag();
            String strC = dVar.c();
            String strF = dVar.f();
            String strG = dVar.g();
            String str3 = a;
            com.ss.android.socialbase.downloader.c.a.b(str3, "dcache=responseCode=" + i2 + " last_modified=" + strF + " CACHE_CONTROL=" + strG + " max-age=" + dVar.k() + " isDeleteCacheIfCheckFailed=" + this.p.isDeleteCacheIfCheckFailed());
            StringBuilder sb = new StringBuilder();
            sb.append("dcache=firstOffset=");
            sb.append(j2);
            sb.append(" cur=");
            sb.append(strF);
            sb.append(" before=");
            sb.append(this.p.getLastModified());
            sb.append(" cur=");
            String str4 = strC;
            sb.append(dVar.j());
            sb.append(" before=");
            sb.append(this.p.getTotalBytes());
            com.ss.android.socialbase.downloader.c.a.b(str3, sb.toString());
            if (!TextUtils.isEmpty(strG)) {
                this.p.setCacheControl(strG);
                if (dVar.k() > 0) {
                    this.p.setCacheExpiredTime(System.currentTimeMillis() + (dVar.k() * 1000));
                }
            }
            if (this.p.isExpiredRedownload() && this.F && !TextUtils.isEmpty(this.E)) {
                boolean z = false;
                if (i2 == 304 || ((!TextUtils.isEmpty(this.p.getLastModified()) || !this.p.isDeleteCacheIfCheckFailed()) && TextUtils.equals(strF, this.p.getLastModified()))) {
                    z = true;
                }
                if (!z) {
                    com.ss.android.socialbase.downloader.i.f.a(this.p);
                } else {
                    com.ss.android.socialbase.downloader.c.a.b(str3, "dcache=responseCode=" + i2 + " lastModified not changed, use local file  " + strF);
                    throw new com.ss.android.socialbase.downloader.exception.a(this.E);
                }
            }
            if (j2 > 0 && this.p.isExpiredRedownload() && !TextUtils.equals(strF, this.p.getLastModified())) {
                com.ss.android.socialbase.downloader.c.a.b(str3, "dcache cdn file change, so retry");
                a("", "cdn file changed");
            }
            if (!TextUtils.isEmpty(strF)) {
                this.p.setLastModified(strF);
            }
            if (a(i2, str2, str4)) {
                gVar2 = gVar;
                if (gVar2 instanceof i) {
                    if (!TextUtils.isEmpty(str2) && str2.equals(str4)) {
                        str4 = "";
                    }
                    a(str4, "eTag of server file changed");
                } else {
                    throw new com.ss.android.socialbase.downloader.exception.b(PointerIconCompat.TYPE_HAND, i2, "");
                }
            } else {
                gVar2 = gVar;
            }
            if (!this.f3707j && !this.f3708k) {
                if (i2 == 403) {
                    throw new BaseException(1047, "response code error : 403");
                }
                throw new com.ss.android.socialbase.downloader.exception.b(1004, i2, "response code error : " + i2);
            }
            if (this.f3708k && j2 > 0) {
                if (gVar2 instanceof i) {
                    a("", "http head request not support");
                } else {
                    throw new BaseException(1004, "isResponseFromBegin but firstOffset > 0");
                }
            }
            long jH = dVar.h();
            if (!(gVar2 instanceof i) && jH < 0 && com.ss.android.socialbase.downloader.i.d.a(this.p)) {
                throw new BaseException(1004, "");
            }
            String strA = TextUtils.isEmpty(this.p.getName()) ? com.ss.android.socialbase.downloader.i.f.a(gVar2, this.p.getUrl()) : "";
            boolean zI = dVar.i();
            this.f3709l = zI;
            if (!zI && jH == 0 && !(gVar2 instanceof i)) {
                throw new BaseException(1004, "");
            }
            if (zI) {
                jB = -1;
            } else {
                String strB = com.ss.android.socialbase.downloader.i.f.b(gVar2, "Content-Range");
                com.ss.android.socialbase.downloader.c.a.c(str3, "firstConnection: contentRange = " + strB);
                if (!TextUtils.isEmpty(strB) && this.I.b("fix_get_total_bytes", true)) {
                    jB = com.ss.android.socialbase.downloader.i.f.b(strB);
                    com.ss.android.socialbase.downloader.c.a.c(str3, "firstConnection: 1 totalLength = " + jB);
                } else {
                    long j3 = j2 + jH;
                    com.ss.android.socialbase.downloader.c.a.e(str3, "firstConnection: 2 totalLength = " + j3 + ", contentLength = " + jH);
                    jB = j3;
                }
            }
            if (v()) {
                return;
            }
            if (this.p.getExpectFileLength() > 0 && com.ss.android.socialbase.downloader.g.a.a(this.p.getId()).b("force_check_file_length") == 1 && this.p.getExpectFileLength() != jB) {
                throw new BaseException(1070, "expectFileLength = " + this.p.getExpectFileLength() + " , totalLength = " + jB);
            }
            this.v.a(jB, str4, strA);
        } catch (BaseException e2) {
            throw e2;
        } catch (com.ss.android.socialbase.downloader.exception.i e3) {
            throw e3;
        } catch (Throwable th) {
            com.ss.android.socialbase.downloader.i.f.a(th, "HandleFirstConnection");
        }
    }

    @Override // com.ss.android.socialbase.downloader.h.f
    public void a(b bVar) {
        if (this.f3705h) {
            return;
        }
        synchronized (this) {
            this.f3703f.remove(bVar);
        }
    }

    @Override // com.ss.android.socialbase.downloader.h.f
    public boolean a(BaseException baseException) {
        if (this.K != null && com.ss.android.socialbase.downloader.i.f.i(baseException) && this.f3702e.get() < this.p.getRetryCount()) {
            return false;
        }
        if (com.ss.android.socialbase.downloader.i.f.b(baseException)) {
            if (this.f3705h && !this.f3701d) {
                com.ss.android.socialbase.downloader.i.f.a(this.p);
                this.f3701d = true;
            }
            return true;
        }
        AtomicInteger atomicInteger = this.f3702e;
        if ((atomicInteger == null || atomicInteger.get() <= 0) && !this.p.hasNextBackupUrl()) {
            if (baseException == null) {
                return false;
            }
            if ((baseException.getErrorCode() != 1011 && (baseException.getCause() == null || !(baseException.getCause() instanceof SSLHandshakeException))) || !this.p.canReplaceHttpForRetry()) {
                return false;
            }
        }
        return !(baseException instanceof com.ss.android.socialbase.downloader.exception.f);
    }

    @Override // com.ss.android.socialbase.downloader.h.f
    public void a(BaseException baseException, boolean z) {
        com.ss.android.socialbase.downloader.c.a.b(a, "onAllChunkRetryWithReset");
        this.n = com.ss.android.socialbase.downloader.constants.h.RUN_STATUS_ALL_CHUNK_RETRY_WITH_RESET;
        this.w = baseException;
        I();
        if (z ? d(baseException) : false) {
            return;
        }
        H();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<String> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        this.p.setForbiddenBackupUrls(list, this.n == com.ss.android.socialbase.downloader.constants.h.RUN_STATUS_WAITING_ASYNC_HANDLER);
        com.ss.android.socialbase.downloader.impls.a aVarC = com.ss.android.socialbase.downloader.downloader.c.C();
        if (aVarC != null) {
            aVarC.l(this.p.getId());
        }
    }

    @Override // com.ss.android.socialbase.downloader.h.f
    public com.ss.android.socialbase.downloader.exception.h a(com.ss.android.socialbase.downloader.model.b bVar, BaseException baseException, long j2) {
        if (u()) {
            return com.ss.android.socialbase.downloader.exception.h.RETURN;
        }
        if (baseException != null && (baseException.getErrorCode() == 1047 || com.ss.android.socialbase.downloader.i.f.h(baseException))) {
            return a(baseException, j2);
        }
        this.w = baseException;
        this.p.increaseCurBytes(-j2);
        this.o.a(this.p);
        if (d(baseException)) {
            return com.ss.android.socialbase.downloader.exception.h.RETURN;
        }
        com.ss.android.socialbase.downloader.downloader.f fVar = this.v;
        com.ss.android.socialbase.downloader.constants.h hVar = this.n;
        com.ss.android.socialbase.downloader.constants.h hVar2 = com.ss.android.socialbase.downloader.constants.h.RUN_STATUS_RETRY_DELAY;
        fVar.a(bVar, baseException, hVar == hVar2);
        if (this.n != hVar2 && this.p.isNeedRetryDelay()) {
            long jA = A();
            if (jA > 0) {
                com.ss.android.socialbase.downloader.c.a.c(a, "onSingleChunkRetry with delay time " + jA);
                try {
                    Thread.sleep(jA);
                } catch (Throwable th) {
                    String str = a;
                    StringBuilder sbR = c.a.a.a.a.r("onSingleChunkRetry:");
                    sbR.append(th.getMessage());
                    com.ss.android.socialbase.downloader.c.a.d(str, sbR.toString());
                }
            }
        }
        return com.ss.android.socialbase.downloader.exception.h.CONTINUE;
    }

    @Override // com.ss.android.socialbase.downloader.h.f
    public com.ss.android.socialbase.downloader.exception.h a(BaseException baseException, long j2) {
        long totalBytes;
        long jA;
        boolean z;
        this.w = baseException;
        this.p.increaseCurBytes(-j2);
        this.o.a(this.p);
        if (u()) {
            return com.ss.android.socialbase.downloader.exception.h.RETURN;
        }
        if (baseException != null && baseException.getErrorCode() == 1047) {
            if (this.z != null && !this.p.isForbiddenRetryed()) {
                com.ss.android.socialbase.downloader.depend.b bVar = new com.ss.android.socialbase.downloader.depend.b() { // from class: com.ss.android.socialbase.downloader.h.c.1
                    @Override // com.ss.android.socialbase.downloader.depend.b, com.ss.android.socialbase.downloader.depend.v
                    public void a(List<String> list) {
                        super.a(list);
                        c.this.a(list);
                    }
                };
                boolean zA = this.z.a(bVar);
                this.p.setForbiddenRetryed();
                if (zA) {
                    if (!bVar.a()) {
                        I();
                        this.v.h();
                        this.n = com.ss.android.socialbase.downloader.constants.h.RUN_STATUS_WAITING_ASYNC_HANDLER;
                        return com.ss.android.socialbase.downloader.exception.h.RETURN;
                    }
                    z = true;
                }
            } else if (d(baseException)) {
                return com.ss.android.socialbase.downloader.exception.h.RETURN;
            }
            z = false;
        } else if (com.ss.android.socialbase.downloader.i.f.h(baseException)) {
            if (this.A == null) {
                b(baseException);
                return com.ss.android.socialbase.downloader.exception.h.RETURN;
            }
            final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            q qVar = new q() { // from class: com.ss.android.socialbase.downloader.h.c.2
                @Override // com.ss.android.socialbase.downloader.depend.q
                public void a() {
                    synchronized (c.this) {
                        atomicBoolean.set(true);
                        c.this.J();
                    }
                }
            };
            if (baseException instanceof com.ss.android.socialbase.downloader.exception.d) {
                com.ss.android.socialbase.downloader.exception.d dVar = (com.ss.android.socialbase.downloader.exception.d) baseException;
                jA = dVar.a();
                totalBytes = dVar.b();
            } else {
                totalBytes = this.p.getTotalBytes();
                jA = -1;
            }
            synchronized (this) {
                if (this.A.a(jA, totalBytes, qVar)) {
                    if (!com.ss.android.socialbase.downloader.g.a.a(this.p.getId()).b("not_delete_when_clean_space", false)) {
                        y();
                    }
                    if (!atomicBoolean.get()) {
                        com.ss.android.socialbase.downloader.constants.h hVar = this.n;
                        com.ss.android.socialbase.downloader.constants.h hVar2 = com.ss.android.socialbase.downloader.constants.h.RUN_STATUS_WAITING_ASYNC_HANDLER;
                        if (hVar != hVar2) {
                            this.n = hVar2;
                            I();
                            this.v.h();
                        }
                        return com.ss.android.socialbase.downloader.exception.h.RETURN;
                    }
                    if (d(baseException)) {
                        return com.ss.android.socialbase.downloader.exception.h.RETURN;
                    }
                    z = true;
                } else {
                    if (this.n == com.ss.android.socialbase.downloader.constants.h.RUN_STATUS_WAITING_ASYNC_HANDLER) {
                        return com.ss.android.socialbase.downloader.exception.h.RETURN;
                    }
                    b(baseException);
                    return com.ss.android.socialbase.downloader.exception.h.RETURN;
                }
            }
        } else {
            if (d(baseException)) {
                return com.ss.android.socialbase.downloader.exception.h.RETURN;
            }
            z = false;
        }
        if (!z && K()) {
            I();
        }
        com.ss.android.socialbase.downloader.downloader.f fVar = this.v;
        com.ss.android.socialbase.downloader.constants.h hVar3 = this.n;
        com.ss.android.socialbase.downloader.constants.h hVar4 = com.ss.android.socialbase.downloader.constants.h.RUN_STATUS_RETRY_DELAY;
        fVar.a(baseException, hVar3 == hVar4);
        return this.n == hVar4 ? com.ss.android.socialbase.downloader.exception.h.RETURN : com.ss.android.socialbase.downloader.exception.h.CONTINUE;
    }

    @Override // com.ss.android.socialbase.downloader.h.f
    public synchronized com.ss.android.socialbase.downloader.model.b a(int i2) {
        com.ss.android.socialbase.downloader.model.b bVarA;
        if (this.p.getChunkCount() < 2) {
            return null;
        }
        List<com.ss.android.socialbase.downloader.model.b> listC = this.o.c(this.p.getId());
        if (listC != null && !listC.isEmpty()) {
            for (int i3 = 0; i3 < listC.size(); i3++) {
                com.ss.android.socialbase.downloader.model.b bVar = listC.get(i3);
                if (bVar != null && (bVarA = a(bVar, i2)) != null) {
                    return bVarA;
                }
            }
            return null;
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.h.f
    public void a(com.ss.android.socialbase.downloader.network.g gVar) {
        boolean z;
        if (gVar != null) {
            try {
                int iB = gVar.b();
                this.p.setHttpStatusCode(iB);
                this.p.setHttpStatusMessage(com.ss.android.socialbase.downloader.i.b.a(iB));
                z = true;
            } catch (Throwable th) {
                th.printStackTrace();
                z = false;
            }
        } else {
            z = false;
        }
        if (z) {
            return;
        }
        this.p.setHttpStatusCode(-1);
        this.p.setHttpStatusMessage("");
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00e1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private com.ss.android.socialbase.downloader.model.b a(com.ss.android.socialbase.downloader.model.b r9, int r10) {
        /*
            Method dump skipped, instruction units count: 303
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.h.c.a(com.ss.android.socialbase.downloader.model.b, int):com.ss.android.socialbase.downloader.model.b");
    }

    private s a(DownloadTask downloadTask) {
        s retryDelayTimeCalculator = downloadTask.getRetryDelayTimeCalculator();
        if (retryDelayTimeCalculator != null) {
            return retryDelayTimeCalculator;
        }
        DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
        if (downloadInfo != null) {
            String retryDelayTimeArray = downloadInfo.getRetryDelayTimeArray();
            if (!TextUtils.isEmpty(retryDelayTimeArray)) {
                return new com.ss.android.socialbase.downloader.impls.q(retryDelayTimeArray);
            }
        }
        return com.ss.android.socialbase.downloader.downloader.c.L();
    }

    public void a(Future future) {
        this.f3699b = future;
    }
}

package com.ss.android.socialbase.downloader.downloader;

import android.content.Context;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteFullException;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import androidx.core.view.PointerIconCompat;
import com.ss.android.socialbase.downloader.constants.DownloadStatus;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.ai;
import com.ss.android.socialbase.downloader.depend.x;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: DownloadStatusHandler.java */
/* JADX INFO: loaded from: classes.dex */
public class f {
    private static final String a = "f";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f3582b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private DownloadInfo f3583c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final j f3584d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Handler f3585e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private DownloadTask f3586f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private SparseArray<IDownloadListener> f3587g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private SparseArray<IDownloadListener> f3588h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private SparseArray<IDownloadListener> f3589i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f3590j = false;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private volatile long f3591k = 0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final AtomicLong f3592l = new AtomicLong();
    private boolean m = false;
    private int n;
    private long o;
    private com.ss.android.socialbase.downloader.depend.n p;
    private x q;

    public f(DownloadTask downloadTask, Handler handler) {
        this.f3586f = downloadTask;
        j();
        this.f3585e = handler;
        this.f3584d = c.x();
        DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
        if (downloadInfo != null) {
            this.f3582b = com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId()).a("fix_start_with_file_exist_update_error");
        } else {
            this.f3582b = false;
        }
    }

    private void j() {
        DownloadTask downloadTask = this.f3586f;
        if (downloadTask != null) {
            this.f3583c = downloadTask.getDownloadInfo();
            this.f3587g = this.f3586f.getDownloadListeners(com.ss.android.socialbase.downloader.constants.f.MAIN);
            this.f3589i = this.f3586f.getDownloadListeners(com.ss.android.socialbase.downloader.constants.f.NOTIFICATION);
            this.f3588h = this.f3586f.getDownloadListeners(com.ss.android.socialbase.downloader.constants.f.SUB);
            this.p = this.f3586f.getDepend();
            this.q = this.f3586f.getMonitorDepend();
        }
    }

    private void k() {
        ExecutorService executorServiceL = c.l();
        if (executorServiceL != null) {
            executorServiceL.execute(new Runnable() { // from class: com.ss.android.socialbase.downloader.downloader.f.1
                @Override // java.lang.Runnable
                public void run() {
                    f.this.f3584d.i(f.this.f3583c.getId());
                    f.this.a(1, (BaseException) null);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        try {
            com.ss.android.socialbase.downloader.c.a.b(a, "saveFileAsTargetName onSuccess");
            try {
                m();
                this.f3583c.setFirstSuccess(false);
                this.f3583c.setSuccessByCache(false);
                a(-3, (BaseException) null);
                this.f3584d.c(this.f3583c.getId(), this.f3583c.getTotalBytes());
                this.f3584d.d(this.f3583c.getId());
                this.f3584d.m(this.f3583c.getId());
            } catch (BaseException e2) {
                a(e2);
            }
        } catch (Throwable th) {
            a(new BaseException(PointerIconCompat.TYPE_TEXT, com.ss.android.socialbase.downloader.i.f.b(th, "onCompleted")));
        }
    }

    private void m() throws BaseException {
        List<com.ss.android.socialbase.downloader.depend.m> downloadCompleteHandlers = this.f3586f.getDownloadCompleteHandlers();
        if (downloadCompleteHandlers.isEmpty()) {
            return;
        }
        DownloadInfo downloadInfo = this.f3583c;
        a(11, (BaseException) null);
        this.f3584d.a(downloadInfo);
        for (com.ss.android.socialbase.downloader.depend.m mVar : downloadCompleteHandlers) {
            try {
                if (mVar.b(downloadInfo)) {
                    mVar.a(downloadInfo);
                    this.f3584d.a(downloadInfo);
                }
            } catch (BaseException e2) {
                throw e2;
            } catch (Throwable th) {
                throw new BaseException(1071, th);
            }
        }
    }

    public void d() {
        this.f3583c.setStatus(-2);
        try {
            this.f3584d.d(this.f3583c.getId(), this.f3583c.getCurBytes());
        } catch (SQLiteException e2) {
            e2.printStackTrace();
        }
        a(-2, (BaseException) null);
    }

    public void e() {
        this.f3583c.setStatus(-7);
        try {
            this.f3584d.j(this.f3583c.getId());
        } catch (SQLiteException e2) {
            e2.printStackTrace();
        }
        a(-7, (BaseException) null);
    }

    public void f() {
        this.f3583c.setFirstDownload(false);
        if (!this.f3583c.isIgnoreDataVerify() && this.f3583c.getCurBytes() != this.f3583c.getTotalBytes()) {
            com.ss.android.socialbase.downloader.c.a.b(a, this.f3583c.getErrorBytesLog());
            StringBuilder sbR = c.a.a.a.a.r("current bytes is not equals to total bytes, bytes changed with process : ");
            sbR.append(this.f3583c.getByteInvalidRetryStatus());
            a(new com.ss.android.socialbase.downloader.exception.f(1027, sbR.toString()));
            return;
        }
        if (this.f3583c.getCurBytes() <= 0) {
            com.ss.android.socialbase.downloader.c.a.b(a, this.f3583c.getErrorBytesLog());
            StringBuilder sbR2 = c.a.a.a.a.r("curBytes is 0, bytes changed with process : ");
            sbR2.append(this.f3583c.getByteInvalidRetryStatus());
            a(new com.ss.android.socialbase.downloader.exception.f(1026, sbR2.toString()));
            return;
        }
        if (!this.f3583c.isIgnoreDataVerify() && this.f3583c.getTotalBytes() <= 0) {
            com.ss.android.socialbase.downloader.c.a.b(a, this.f3583c.getErrorBytesLog());
            StringBuilder sbR3 = c.a.a.a.a.r("TotalBytes is 0, bytes changed with process : ");
            sbR3.append(this.f3583c.getByteInvalidRetryStatus());
            a(new com.ss.android.socialbase.downloader.exception.f(1044, sbR3.toString()));
            return;
        }
        String str = a;
        StringBuilder sbR4 = c.a.a.a.a.r("");
        sbR4.append(this.f3583c.getName());
        sbR4.append(" onCompleted start save file as target name");
        com.ss.android.socialbase.downloader.c.a.b(str, sbR4.toString());
        x monitorDepend = this.q;
        DownloadTask downloadTask = this.f3586f;
        if (downloadTask != null) {
            monitorDepend = downloadTask.getMonitorDepend();
        }
        com.ss.android.socialbase.downloader.i.f.a(this.f3583c, monitorDepend, new ai() { // from class: com.ss.android.socialbase.downloader.downloader.f.2
            @Override // com.ss.android.socialbase.downloader.depend.ai
            public void a() {
                f.this.l();
            }

            @Override // com.ss.android.socialbase.downloader.depend.ai
            public void a(BaseException baseException) {
                String str2 = f.a;
                StringBuilder sbR5 = c.a.a.a.a.r("saveFileAsTargetName onFailed : ");
                sbR5.append(baseException != null ? baseException.getErrorMessage() : "");
                com.ss.android.socialbase.downloader.c.a.b(str2, sbR5.toString());
                f.this.a(baseException);
            }
        });
    }

    public void g() {
        if (!this.f3582b) {
            m();
            com.ss.android.socialbase.downloader.c.a.b(a, "onCompleteForFileExist");
            this.f3583c.setSuccessByCache(true);
            a(-3, (BaseException) null);
            this.f3584d.c(this.f3583c.getId(), this.f3583c.getTotalBytes());
            this.f3584d.d(this.f3583c.getId());
            this.f3584d.m(this.f3583c.getId());
            return;
        }
        m();
        com.ss.android.socialbase.downloader.c.a.b(a, "onCompleteForFileExist");
        this.f3583c.setSuccessByCache(true);
        a(-3, (BaseException) null);
        this.f3584d.c(this.f3583c.getId(), this.f3583c.getTotalBytes());
        this.f3584d.d(this.f3583c.getId());
        this.f3584d.a(this.f3583c);
        this.f3584d.m(this.f3583c.getId());
    }

    public void h() {
        this.f3583c.setStatus(8);
        this.f3583c.setAsyncHandleStatus(com.ss.android.socialbase.downloader.constants.a.ASYNC_HANDLE_WAITING);
        com.ss.android.socialbase.downloader.impls.a aVarC = c.C();
        if (aVarC != null) {
            aVarC.a(this.f3583c.getId(), this.f3586f.getHashCodeForSameTask(), 8);
        }
    }

    public void b() {
        if (this.f3583c.canSkipStatusHandler()) {
            this.f3583c.changeSkipStatus();
            return;
        }
        this.f3584d.g(this.f3583c.getId());
        if (this.f3583c.isFirstDownload()) {
            a(6, (BaseException) null);
        }
        a(2, (BaseException) null);
    }

    public void c() {
        a(-4, (BaseException) null);
    }

    private BaseException c(BaseException baseException) {
        Context contextN;
        if (com.ss.android.socialbase.downloader.g.a.a(this.f3583c.getId()).a("download_failed_check_net", 1) != 1 || !com.ss.android.socialbase.downloader.i.f.i(baseException) || (contextN = c.N()) == null || com.ss.android.socialbase.downloader.i.f.c(contextN)) {
            return baseException;
        }
        return new BaseException(this.f3583c.isOnlyWifi() ? PointerIconCompat.TYPE_ALL_SCROLL : 1049, baseException.getErrorMessage());
    }

    public void a() {
        if (this.f3583c.canSkipStatusHandler()) {
            return;
        }
        this.f3583c.setStatus(1);
        k();
    }

    public void a(long j2, String str, String str2) {
        this.f3583c.setTotalBytes(j2);
        this.f3583c.seteTag(str);
        if (!TextUtils.isEmpty(str2) && TextUtils.isEmpty(this.f3583c.getName())) {
            this.f3583c.setName(str2);
        }
        try {
            this.f3584d.a(this.f3583c.getId(), j2, str, str2);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        a(3, (BaseException) null);
        this.o = this.f3583c.getMinByteIntervalForPostToMainThread(j2);
        this.n = this.f3583c.getMinProgressTimeMsInterval();
        this.f3590j = true;
        com.ss.android.socialbase.downloader.impls.r.a().e();
    }

    private void b(BaseException baseException) {
        String str = "handleError::" + baseException + " \r\n" + Log.getStackTraceString(new Throwable());
        if (baseException != null && baseException.getCause() != null && (baseException.getCause() instanceof SQLiteFullException)) {
            try {
                this.f3584d.f(this.f3583c.getId());
            } catch (SQLiteException e2) {
                e2.printStackTrace();
            }
        } else {
            try {
                try {
                    this.f3584d.b(this.f3583c.getId(), this.f3583c.getCurBytes());
                } catch (SQLiteException unused) {
                    this.f3584d.f(this.f3583c.getId());
                }
            } catch (SQLiteException e3) {
                e3.printStackTrace();
            }
        }
        BaseException baseExceptionC = c(baseException);
        this.f3583c.setFailedException(baseExceptionC);
        a(baseExceptionC instanceof com.ss.android.socialbase.downloader.exception.e ? -2 : -1, baseExceptionC);
        if (com.ss.android.socialbase.downloader.g.a.a(this.f3583c.getId()).a("retry_schedule", 0) > 0) {
            com.ss.android.socialbase.downloader.impls.r.a().a(this.f3583c);
        }
    }

    public boolean a(long j2) {
        this.f3592l.addAndGet(j2);
        this.f3583c.increaseCurBytes(j2);
        long jUptimeMillis = SystemClock.uptimeMillis();
        return a(jUptimeMillis, b(jUptimeMillis));
    }

    private boolean b(long j2) {
        boolean z = true;
        if (!this.m) {
            this.m = true;
            return true;
        }
        long j3 = j2 - this.f3591k;
        if (this.f3592l.get() < this.o && j3 < this.n) {
            z = false;
        }
        if (z) {
            this.f3591k = j2;
            this.f3592l.set(0L);
        }
        return z;
    }

    public void a(BaseException baseException, boolean z) {
        this.f3583c.setFirstDownload(false);
        this.f3592l.set(0L);
        b(baseException, z);
    }

    public void a(com.ss.android.socialbase.downloader.model.b bVar, BaseException baseException, boolean z) {
        this.f3583c.setFirstDownload(false);
        this.f3592l.set(0L);
        this.f3584d.h(this.f3583c.getId());
        a(z ? 10 : 9, baseException, true);
    }

    private void b(BaseException baseException, boolean z) {
        this.f3584d.h(this.f3583c.getId());
        a(z ? 7 : 5, baseException);
    }

    public void a(BaseException baseException) {
        this.f3583c.setFirstDownload(false);
        b(baseException);
    }

    public void a(String str) {
        String str2 = a;
        StringBuilder sbU = c.a.a.a.a.u("onCompleteForFileExist existTargetFileName is ", str, " but curName is ");
        sbU.append(this.f3583c.getName());
        com.ss.android.socialbase.downloader.c.a.b(str2, sbU.toString());
        if (this.f3582b) {
            com.ss.android.socialbase.downloader.i.f.a(this.f3583c, str);
            m();
            this.f3583c.setSuccessByCache(true);
            a(-3, (BaseException) null);
            this.f3584d.a(this.f3583c);
            return;
        }
        this.f3584d.a(this.f3583c);
        com.ss.android.socialbase.downloader.i.f.a(this.f3583c, str);
        this.f3583c.setSuccessByCache(true);
        m();
        a(-3, (BaseException) null);
    }

    private boolean a(long j2, boolean z) {
        boolean z2 = false;
        if (this.f3583c.getCurBytes() == this.f3583c.getTotalBytes()) {
            try {
                this.f3584d.a(this.f3583c.getId(), this.f3583c.getCurBytes());
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return false;
        }
        if (this.f3590j) {
            this.f3590j = false;
            this.f3583c.setStatus(4);
        }
        if (this.f3583c.isNeedPostProgress() && z) {
            z2 = true;
        }
        a(4, (BaseException) null, z2);
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, BaseException baseException) {
        a(i2, baseException, true);
    }

    private void a(int i2, BaseException baseException, boolean z) {
        SparseArray<IDownloadListener> sparseArray;
        SparseArray<IDownloadListener> sparseArray2;
        int status = this.f3583c.getStatus();
        if (status == -3 && i2 == 4) {
            return;
        }
        j();
        if (i2 != 4 && DownloadStatus.isRealTimeUploadStatus(i2)) {
            this.f3583c.updateRealDownloadTime(false);
            if (DownloadStatus.isTimeUploadStatus(i2)) {
                this.f3583c.updateDownloadTime();
            }
        }
        if (!this.f3583c.isAddListenerToSameTask()) {
            com.ss.android.socialbase.downloader.d.a.a(this.f3586f, baseException, i2);
        }
        if (i2 == 6) {
            this.f3583c.setStatus(2);
        } else if (i2 == -6) {
            this.f3583c.setStatus(-3);
        } else {
            this.f3583c.setStatus(i2);
        }
        if (status == -3 || status == -1) {
            if (this.f3583c.getRetryDelayStatus() == com.ss.android.socialbase.downloader.constants.g.DELAY_RETRY_DOWNLOADING) {
                this.f3583c.setRetryDelayStatus(com.ss.android.socialbase.downloader.constants.g.DELAY_RETRY_DOWNLOADED);
            }
            if (this.f3583c.getAsyncHandleStatus() == com.ss.android.socialbase.downloader.constants.a.ASYNC_HANDLE_DOWNLOADING) {
                this.f3583c.setAsyncHandleStatus(com.ss.android.socialbase.downloader.constants.a.ASYNC_HANDLE_DOWNLOADED);
            }
            if (this.f3583c.getByteInvalidRetryStatus() == com.ss.android.socialbase.downloader.constants.b.BYTE_INVALID_RETRY_STATUS_DOWNLOADING) {
                this.f3583c.setByteInvalidRetryStatus(com.ss.android.socialbase.downloader.constants.b.BYTE_INVALID_RETRY_STATUS_DOWNLOADED);
            }
        }
        com.ss.android.socialbase.downloader.i.c.a(i2, this.f3588h, true, this.f3583c, baseException);
        if (i2 == -4) {
            return;
        }
        if (z && this.f3585e != null && (((sparseArray = this.f3587g) != null && sparseArray.size() > 0) || ((sparseArray2 = this.f3589i) != null && sparseArray2.size() > 0 && (this.f3583c.canShowNotification() || this.f3583c.isAutoInstallWithoutNotification())))) {
            this.f3585e.obtainMessage(i2, this.f3583c.getId(), this.f3586f.getHashCodeForSameTask(), baseException).sendToTarget();
            return;
        }
        com.ss.android.socialbase.downloader.impls.a aVarC = c.C();
        if (aVarC != null) {
            aVarC.a(this.f3583c.getId(), this.f3586f.getHashCodeForSameTask(), i2);
        }
    }
}

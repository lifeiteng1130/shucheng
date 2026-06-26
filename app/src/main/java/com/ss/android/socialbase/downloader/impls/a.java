package com.ss.android.socialbase.downloader.impls;

import android.database.sqlite.SQLiteException;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.core.view.PointerIconCompat;
import com.ss.android.socialbase.downloader.constants.DownloadStatus;
import com.ss.android.socialbase.downloader.constants.EnqueueType;
import com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.af;
import com.ss.android.socialbase.downloader.depend.x;
import com.ss.android.socialbase.downloader.depend.z;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.h.h;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;

/* JADX INFO: compiled from: AbsDownloadEngine.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class a implements h.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final SparseArray<DownloadTask> f3751b = new SparseArray<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final SparseArray<DownloadTask> f3752c = new SparseArray<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final SparseArray<DownloadTask> f3753d = new SparseArray<>();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final SparseArray<DownloadTask> f3754e = new SparseArray<>();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final SparseArray<DownloadTask> f3755f = new SparseArray<>();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final SparseArray<SparseArray<DownloadTask>> f3756g = new SparseArray<>();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final com.ss.android.socialbase.downloader.i.h<Integer, DownloadTask> f3757h = new com.ss.android.socialbase.downloader.i.h<>();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final SparseArray<Long> f3758i = new SparseArray<>();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final LinkedBlockingDeque<DownloadTask> f3759j = new LinkedBlockingDeque<>();
    public final com.ss.android.socialbase.downloader.h.h a = new com.ss.android.socialbase.downloader.h.h(Looper.getMainLooper(), this);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final com.ss.android.socialbase.downloader.downloader.j f3760k = com.ss.android.socialbase.downloader.downloader.c.x();

    private void c(DownloadTask downloadTask) {
        DownloadInfo downloadInfo;
        if (downloadTask == null || (downloadInfo = downloadTask.getDownloadInfo()) == null) {
            return;
        }
        try {
            if (this.f3759j.isEmpty()) {
                a(downloadTask, true);
                this.f3759j.put(downloadTask);
                return;
            }
            if (downloadInfo.getEnqueueType() != EnqueueType.ENQUEUE_TAIL) {
                DownloadTask first = this.f3759j.getFirst();
                if (first.getDownloadId() == downloadTask.getDownloadId() && a(downloadTask.getDownloadId())) {
                    return;
                }
                e(first.getDownloadId());
                a(downloadTask, true);
                if (first.getDownloadId() != downloadTask.getDownloadId()) {
                    this.f3759j.putFirst(downloadTask);
                    return;
                }
                return;
            }
            if (this.f3759j.getFirst().getDownloadId() == downloadTask.getDownloadId() && a(downloadTask.getDownloadId())) {
                return;
            }
            Iterator<DownloadTask> it = this.f3759j.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                DownloadTask next = it.next();
                if (next != null && next.getDownloadId() == downloadTask.getDownloadId()) {
                    it.remove();
                    break;
                }
            }
            this.f3759j.put(downloadTask);
            new com.ss.android.socialbase.downloader.downloader.f(downloadTask, this.a).a();
        } catch (InterruptedException unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DownloadTask o(int i2) {
        DownloadTask downloadTask = this.f3751b.get(i2);
        if (downloadTask != null) {
            return downloadTask;
        }
        DownloadTask downloadTask2 = this.f3753d.get(i2);
        if (downloadTask2 != null) {
            return downloadTask2;
        }
        DownloadTask downloadTask3 = this.f3752c.get(i2);
        if (downloadTask3 != null) {
            return downloadTask3;
        }
        DownloadTask downloadTask4 = this.f3754e.get(i2);
        return downloadTask4 == null ? this.f3755f.get(i2) : downloadTask4;
    }

    private void p(int i2) {
        DownloadTask first;
        if (this.f3759j.isEmpty()) {
            return;
        }
        DownloadTask first2 = this.f3759j.getFirst();
        if (first2 != null && first2.getDownloadId() == i2) {
            this.f3759j.poll();
        }
        if (this.f3759j.isEmpty() || (first = this.f3759j.getFirst()) == null) {
            return;
        }
        a(first, true);
    }

    public abstract List<Integer> a();

    public abstract void a(int i2, long j2);

    public abstract void a(int i2, DownloadTask downloadTask);

    public abstract void a(com.ss.android.socialbase.downloader.h.c cVar);

    public abstract boolean a(int i2);

    public abstract void b(int i2);

    public abstract com.ss.android.socialbase.downloader.h.c c(int i2);

    public synchronized DownloadInfo d(int i2) {
        DownloadInfo downloadInfoB;
        DownloadTask downloadTask;
        downloadInfoB = this.f3760k.b(i2);
        if (downloadInfoB == null && (downloadTask = this.f3751b.get(i2)) != null) {
            downloadInfoB = downloadTask.getDownloadInfo();
        }
        return downloadInfoB;
    }

    public synchronized boolean e(int i2) {
        com.ss.android.socialbase.downloader.c.a.b("AbsDownloadEngine", "pause id=" + i2);
        DownloadInfo downloadInfoB = this.f3760k.b(i2);
        if (downloadInfoB != null && downloadInfoB.getStatus() == 11) {
            return false;
        }
        synchronized (this.f3751b) {
            b(i2);
        }
        if (downloadInfoB == null) {
            DownloadTask downloadTask = this.f3751b.get(i2);
            if (downloadTask != null) {
                new com.ss.android.socialbase.downloader.downloader.f(downloadTask, this.a).d();
                return true;
            }
        } else {
            a(downloadInfoB);
            if (downloadInfoB.getStatus() == 1) {
                DownloadTask downloadTask2 = this.f3751b.get(i2);
                if (downloadTask2 != null) {
                    new com.ss.android.socialbase.downloader.downloader.f(downloadTask2, this.a).d();
                    return true;
                }
            } else if (DownloadStatus.isDownloading(downloadInfoB.getStatus())) {
                downloadInfoB.setStatus(-2);
                return true;
            }
        }
        return false;
    }

    public synchronized boolean f(int i2) {
        DownloadTask downloadTask = this.f3751b.get(i2);
        if (downloadTask != null) {
            DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
            if (downloadInfo != null) {
                downloadInfo.setDownloadFromReserveWifi(false);
            }
            a(downloadTask);
        } else {
            g(i2);
        }
        return true;
    }

    public synchronized boolean g(int i2) {
        DownloadTask downloadTask = this.f3753d.get(i2);
        if (downloadTask == null) {
            downloadTask = this.f3754e.get(i2);
        }
        if (downloadTask == null) {
            return false;
        }
        DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
        if (downloadInfo != null) {
            downloadInfo.setDownloadFromReserveWifi(false);
        }
        a(downloadTask);
        return true;
    }

    public synchronized af h(int i2) {
        DownloadTask downloadTask = this.f3751b.get(i2);
        if (downloadTask != null) {
            return downloadTask.getNotificationClickCallback();
        }
        DownloadTask downloadTask2 = this.f3752c.get(i2);
        if (downloadTask2 != null) {
            return downloadTask2.getNotificationClickCallback();
        }
        DownloadTask downloadTask3 = this.f3753d.get(i2);
        if (downloadTask3 != null) {
            return downloadTask3.getNotificationClickCallback();
        }
        DownloadTask downloadTask4 = this.f3754e.get(i2);
        if (downloadTask4 != null) {
            return downloadTask4.getNotificationClickCallback();
        }
        DownloadTask downloadTask5 = this.f3755f.get(i2);
        if (downloadTask5 == null) {
            return null;
        }
        return downloadTask5.getNotificationClickCallback();
    }

    public synchronized z i(int i2) {
        DownloadTask downloadTask = this.f3751b.get(i2);
        if (downloadTask != null) {
            return downloadTask.getNotificationEventListener();
        }
        DownloadTask downloadTask2 = this.f3752c.get(i2);
        if (downloadTask2 != null) {
            return downloadTask2.getNotificationEventListener();
        }
        DownloadTask downloadTask3 = this.f3753d.get(i2);
        if (downloadTask3 != null) {
            return downloadTask3.getNotificationEventListener();
        }
        DownloadTask downloadTask4 = this.f3754e.get(i2);
        if (downloadTask4 != null) {
            return downloadTask4.getNotificationEventListener();
        }
        DownloadTask downloadTask5 = this.f3755f.get(i2);
        if (downloadTask5 == null) {
            return null;
        }
        return downloadTask5.getNotificationEventListener();
    }

    public synchronized IDownloadFileUriProvider j(int i2) {
        DownloadTask downloadTask = this.f3751b.get(i2);
        if (downloadTask != null) {
            return downloadTask.getFileUriProvider();
        }
        DownloadTask downloadTask2 = this.f3752c.get(i2);
        if (downloadTask2 != null) {
            return downloadTask2.getFileUriProvider();
        }
        DownloadTask downloadTask3 = this.f3753d.get(i2);
        if (downloadTask3 != null) {
            return downloadTask3.getFileUriProvider();
        }
        DownloadTask downloadTask4 = this.f3754e.get(i2);
        if (downloadTask4 != null) {
            return downloadTask4.getFileUriProvider();
        }
        DownloadTask downloadTask5 = this.f3755f.get(i2);
        if (downloadTask5 == null) {
            return null;
        }
        return downloadTask5.getFileUriProvider();
    }

    public synchronized boolean k(int i2) {
        DownloadInfo downloadInfo;
        DownloadTask downloadTask = this.f3754e.get(i2);
        if (downloadTask != null && (downloadInfo = downloadTask.getDownloadInfo()) != null) {
            if (downloadInfo.canStartRetryDelayTask()) {
                a(downloadTask, false);
            }
            return true;
        }
        DownloadInfo downloadInfoB = this.f3760k.b(i2);
        if (downloadInfoB != null && downloadInfoB.canStartRetryDelayTask()) {
            a(new DownloadTask(downloadInfoB), false);
        }
        return false;
    }

    public synchronized boolean l(int i2) {
        DownloadInfo downloadInfo;
        DownloadTask downloadTask = this.f3755f.get(i2);
        if (downloadTask == null || (downloadInfo = downloadTask.getDownloadInfo()) == null) {
            return false;
        }
        if (downloadInfo.canReStartAsyncTask()) {
            a(downloadTask);
        }
        return true;
    }

    public synchronized void m(int i2) {
        DownloadInfo downloadInfo;
        DownloadTask downloadTask = this.f3751b.get(i2);
        if (downloadTask != null && (downloadInfo = downloadTask.getDownloadInfo()) != null) {
            downloadInfo.setForceIgnoreRecommendSize(true);
            a(downloadTask);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized boolean n(int r2) {
        /*
            r1 = this;
            monitor-enter(r1)
            if (r2 == 0) goto L18
            android.util.SparseArray<com.ss.android.socialbase.downloader.model.DownloadTask> r0 = r1.f3751b     // Catch: java.lang.Throwable -> L15
            java.lang.Object r0 = r0.get(r2)     // Catch: java.lang.Throwable -> L15
            if (r0 != 0) goto L13
            android.util.SparseArray<com.ss.android.socialbase.downloader.model.DownloadTask> r0 = r1.f3753d     // Catch: java.lang.Throwable -> L15
            java.lang.Object r2 = r0.get(r2)     // Catch: java.lang.Throwable -> L15
            if (r2 == 0) goto L18
        L13:
            r2 = 1
            goto L19
        L15:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        L18:
            r2 = 0
        L19:
            monitor-exit(r1)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.impls.a.n(int):boolean");
    }

    private void b(DownloadTask downloadTask) {
        int hashCodeForSameTask = downloadTask.getHashCodeForSameTask();
        if (hashCodeForSameTask == 0 && downloadTask.isAutoSetHashCodeForSameTask()) {
            hashCodeForSameTask = downloadTask.autoCalAndGetHashCodeForSameTask();
        }
        if (hashCodeForSameTask == 0) {
            return;
        }
        SparseArray<DownloadTask> sparseArray = this.f3756g.get(downloadTask.getDownloadId());
        if (sparseArray == null) {
            sparseArray = new SparseArray<>();
            this.f3756g.put(downloadTask.getDownloadId(), sparseArray);
        }
        StringBuilder sbR = c.a.a.a.a.r("tryCacheSameTaskWithListenerHashCode id:");
        sbR.append(downloadTask.getDownloadId());
        sbR.append(" listener hasCode:");
        sbR.append(hashCodeForSameTask);
        com.ss.android.socialbase.downloader.c.a.b("AbsDownloadEngine", sbR.toString());
        sparseArray.put(hashCodeForSameTask, downloadTask);
    }

    private void a(DownloadTask downloadTask, boolean z) {
        DownloadInfo downloadInfo;
        int status;
        DownloadInfo downloadInfo2;
        DownloadTask downloadTaskRemove;
        if (downloadTask == null || (downloadInfo = downloadTask.getDownloadInfo()) == null) {
            return;
        }
        if (downloadInfo.isEntityInvalid()) {
            x monitorDepend = downloadTask.getMonitorDepend();
            StringBuilder sbR = c.a.a.a.a.r("downloadInfo is Invalid, url is ");
            sbR.append(downloadInfo.getUrl());
            sbR.append(" name is ");
            sbR.append(downloadInfo.getName());
            sbR.append(" savePath is ");
            sbR.append(downloadInfo.getSavePath());
            com.ss.android.socialbase.downloader.d.a.a(monitorDepend, downloadInfo, new BaseException(PointerIconCompat.TYPE_HELP, sbR.toString()), downloadInfo.getStatus());
            return;
        }
        boolean z2 = false;
        if (com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId()).a("no_net_opt", 0) == 1 && !com.ss.android.socialbase.downloader.i.f.c(com.ss.android.socialbase.downloader.downloader.c.N()) && !downloadInfo.isFirstDownload()) {
            new com.ss.android.socialbase.downloader.downloader.f(downloadTask, this.a).a(new BaseException(1049, "network_not_available"));
            return;
        }
        int id = downloadInfo.getId();
        if (z) {
            a(downloadInfo);
        }
        if (this.f3753d.get(id) != null) {
            this.f3753d.remove(id);
        }
        if (this.f3752c.get(id) != null) {
            this.f3752c.remove(id);
        }
        if (this.f3754e.get(id) != null) {
            this.f3754e.remove(id);
        }
        if (this.f3755f.get(id) != null) {
            this.f3755f.remove(id);
        }
        if (a(id) && !downloadInfo.canReStartAsyncTask()) {
            com.ss.android.socialbase.downloader.c.a.b("AbsDownloadEngine", "another task with same id is downloading when tryDownload");
            downloadTask.addListenerToDownloadingSameTask();
            com.ss.android.socialbase.downloader.d.a.a(downloadTask.getMonitorDepend(), downloadInfo, new BaseException(PointerIconCompat.TYPE_HELP, "downloadInfo is isDownloading and addListenerToSameTask is false"), downloadInfo.getStatus());
            return;
        }
        com.ss.android.socialbase.downloader.c.a.b("AbsDownloadEngine", "no downloading task :" + id);
        if (downloadInfo.canReStartAsyncTask()) {
            downloadInfo.setAsyncHandleStatus(com.ss.android.socialbase.downloader.constants.a.ASYNC_HANDLE_RESTART);
        }
        if (com.ss.android.socialbase.downloader.i.a.a(32768) && (downloadTaskRemove = this.f3757h.remove(Integer.valueOf(id))) != null) {
            downloadTask.copyListenerFromPendingTask(downloadTaskRemove);
        }
        long jUptimeMillis = SystemClock.uptimeMillis();
        DownloadTask downloadTask2 = this.f3751b.get(id);
        if (downloadTask2 == null || (downloadInfo2 = downloadTask2.getDownloadInfo()) == null) {
            status = 0;
        } else {
            status = downloadInfo2.getStatus();
            if (DownloadStatus.isDownloading(status)) {
                z2 = true;
            }
        }
        com.ss.android.socialbase.downloader.c.a.b("AbsDownloadEngine", "can add listener " + z2 + " , oldTaskStatus is :" + status);
        if (z2) {
            downloadTask.addListenerToDownloadingSameTask();
            return;
        }
        b(downloadTask);
        this.f3751b.put(id, downloadTask);
        this.f3758i.put(id, Long.valueOf(jUptimeMillis));
        a(id, downloadTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void d(int i2, boolean z) {
        com.ss.android.socialbase.downloader.c.a.b("AbsDownloadEngine", "clearDownloadDataInSubThread::id=" + i2 + " deleteTargetFile=" + z);
        try {
            DownloadInfo downloadInfoB = this.f3760k.b(i2);
            if (downloadInfoB != null) {
                if (z) {
                    com.ss.android.socialbase.downloader.i.f.a(downloadInfoB);
                } else {
                    com.ss.android.socialbase.downloader.i.f.c(downloadInfoB.getTempPath(), downloadInfoB.getTempName());
                }
                downloadInfoB.erase();
            }
            try {
                this.f3760k.f(i2);
            } catch (SQLiteException e2) {
                e2.printStackTrace();
            }
            a(i2, 0, -4);
            if (this.f3753d.get(i2) != null) {
                this.f3753d.remove(i2);
            }
            if (this.f3752c.get(i2) != null) {
                this.f3752c.remove(i2);
            }
            this.f3757h.remove(Integer.valueOf(i2));
            com.ss.android.socialbase.downloader.g.a.b(i2);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public synchronized void b(List<String> list) {
        DownloadInfo downloadInfo;
        try {
            if (!com.ss.android.socialbase.downloader.i.f.b(com.ss.android.socialbase.downloader.downloader.c.N())) {
                return;
            }
            for (int i2 = 0; i2 < this.f3751b.size(); i2++) {
                DownloadTask downloadTask = this.f3751b.get(this.f3751b.keyAt(i2));
                if (downloadTask != null && (downloadInfo = downloadTask.getDownloadInfo()) != null && downloadInfo.getMimeType() != null && list.contains(downloadInfo.getMimeType()) && b(downloadInfo)) {
                    downloadInfo.setAutoResumed(true);
                    downloadInfo.setShowNotificationForNetworkResumed(true);
                    a(downloadTask);
                    downloadInfo.setDownloadFromReserveWifi(true);
                    com.ss.android.socialbase.downloader.downloader.r reserveWifiStatusListener = Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.c.N()).getReserveWifiStatusListener();
                    if (reserveWifiStatusListener != null) {
                        reserveWifiStatusListener.a(downloadInfo, 5, 2);
                    }
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void c(final int i2, final boolean z) {
        DownloadInfo downloadInfoB = this.f3760k.b(i2);
        if (downloadInfoB != null) {
            a(downloadInfoB);
        }
        this.a.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.a.4
            @Override // java.lang.Runnable
            public void run() {
                com.ss.android.socialbase.downloader.notification.b.a().f(i2);
            }
        });
        com.ss.android.socialbase.downloader.downloader.c.a(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.a.5
            @Override // java.lang.Runnable
            public void run() {
                a.this.c(i2);
                a.this.e(i2, z);
            }
        }, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(int i2, boolean z) {
        try {
            DownloadInfo downloadInfoB = this.f3760k.b(i2);
            if (downloadInfoB != null) {
                com.ss.android.socialbase.downloader.i.f.a(downloadInfoB, z);
                downloadInfoB.erase();
            }
            try {
                this.f3760k.d(i2);
                this.f3760k.a(downloadInfoB);
            } catch (SQLiteException e2) {
                e2.printStackTrace();
            }
            if (this.f3753d.get(i2) != null) {
                this.f3753d.remove(i2);
            }
            if (this.f3752c.get(i2) != null) {
                this.f3752c.remove(i2);
            }
            this.f3757h.remove(Integer.valueOf(i2));
            com.ss.android.socialbase.downloader.g.a.b(i2);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private boolean b(DownloadInfo downloadInfo) {
        if (downloadInfo != null && downloadInfo.statusInPause()) {
            return downloadInfo.isPauseReserveOnWifi();
        }
        return false;
    }

    public void b() {
        List<Integer> listA = a();
        if (listA == null) {
            return;
        }
        Iterator<Integer> it = listA.iterator();
        while (it.hasNext()) {
            e(it.next().intValue());
        }
    }

    public void b(final int i2, final boolean z) {
        DownloadInfo downloadInfoB = this.f3760k.b(i2);
        if (downloadInfoB != null) {
            a(downloadInfoB);
        }
        this.a.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.a.2
            @Override // java.lang.Runnable
            public void run() {
                com.ss.android.socialbase.downloader.notification.b.a().f(i2);
            }
        });
        com.ss.android.socialbase.downloader.downloader.c.a(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.a.3
            @Override // java.lang.Runnable
            public void run() {
                DownloadTask downloadTaskO;
                if (a.this.c(i2) == null && (downloadTaskO = a.this.o(i2)) != null) {
                    DownloadInfo downloadInfo = downloadTaskO.getDownloadInfo();
                    SparseArray<IDownloadListener> downloadListeners = downloadTaskO.getDownloadListeners(com.ss.android.socialbase.downloader.constants.f.SUB);
                    if (downloadListeners != null) {
                        synchronized (downloadListeners) {
                            for (int i3 = 0; i3 < downloadListeners.size(); i3++) {
                                IDownloadListener iDownloadListener = downloadListeners.get(downloadListeners.keyAt(i3));
                                if (iDownloadListener != null) {
                                    iDownloadListener.onCanceled(downloadInfo);
                                }
                            }
                        }
                    }
                }
                a.this.d(i2, z);
            }
        }, false);
    }

    public synchronized void b(int i2, int i3, IDownloadListener iDownloadListener, com.ss.android.socialbase.downloader.constants.f fVar, boolean z) {
        a(i2, i3, iDownloadListener, fVar, z, true);
    }

    public List<DownloadInfo> b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Iterator<Integer> it = a().iterator();
        ArrayList arrayList = new ArrayList();
        while (it.hasNext()) {
            DownloadInfo downloadInfoD = d(it.next().intValue());
            if (downloadInfoD != null && str.equals(downloadInfoD.getMimeType())) {
                arrayList.add(downloadInfoD);
            }
        }
        return arrayList;
    }

    public synchronized void a(DownloadTask downloadTask) {
        if (downloadTask == null) {
            return;
        }
        DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
        if (downloadInfo == null) {
            return;
        }
        downloadInfo.setDownloadFromReserveWifi(false);
        if (downloadInfo.getEnqueueType() != EnqueueType.ENQUEUE_NONE) {
            c(downloadTask);
        } else {
            a(downloadTask, true);
        }
    }

    public void b(int i2, long j2) {
        DownloadInfo downloadInfoB = this.f3760k.b(i2);
        if (downloadInfoB != null) {
            downloadInfoB.setThrottleNetSpeed(j2);
        }
        a(i2, j2);
    }

    public synchronized List<DownloadInfo> a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        List<DownloadInfo> listA = this.f3760k.a(str);
        if (listA != null && !listA.isEmpty()) {
            return listA;
        }
        ArrayList arrayList = new ArrayList();
        int size = this.f3751b.size();
        for (int i2 = 0; i2 < size; i2++) {
            DownloadTask downloadTaskValueAt = this.f3751b.valueAt(i2);
            if (downloadTaskValueAt != null && downloadTaskValueAt.getDownloadInfo() != null && str.equals(downloadTaskValueAt.getDownloadInfo().getUrl())) {
                arrayList.add(downloadTaskValueAt.getDownloadInfo());
            }
        }
        return arrayList;
    }

    public synchronized boolean a(int i2, boolean z) {
        DownloadTask downloadTaskO = this.f3751b.get(i2);
        if (downloadTaskO == null && com.ss.android.socialbase.downloader.i.a.a(65536)) {
            downloadTaskO = o(i2);
        }
        if (downloadTaskO != null) {
            if (!com.ss.android.socialbase.downloader.g.a.a(i2).b("fix_on_cancel_call_twice", true)) {
                new com.ss.android.socialbase.downloader.downloader.f(downloadTaskO, this.a).c();
            }
            final DownloadInfo downloadInfo = downloadTaskO.getDownloadInfo();
            final SparseArray<IDownloadListener> downloadListeners = downloadTaskO.getDownloadListeners(com.ss.android.socialbase.downloader.constants.f.MAIN);
            final SparseArray<IDownloadListener> downloadListeners2 = downloadTaskO.getDownloadListeners(com.ss.android.socialbase.downloader.constants.f.NOTIFICATION);
            this.a.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.a.1
                @Override // java.lang.Runnable
                public void run() {
                    SparseArray sparseArray;
                    SparseArray sparseArray2 = downloadListeners;
                    if (sparseArray2 != null) {
                        synchronized (sparseArray2) {
                            for (int i3 = 0; i3 < downloadListeners.size(); i3++) {
                                IDownloadListener iDownloadListener = (IDownloadListener) downloadListeners.get(downloadListeners.keyAt(i3));
                                if (iDownloadListener != null) {
                                    iDownloadListener.onCanceled(downloadInfo);
                                }
                            }
                        }
                    }
                    DownloadInfo downloadInfo2 = downloadInfo;
                    if (downloadInfo2 == null || !downloadInfo2.canShowNotification() || (sparseArray = downloadListeners2) == null) {
                        return;
                    }
                    synchronized (sparseArray) {
                        for (int i4 = 0; i4 < downloadListeners2.size(); i4++) {
                            IDownloadListener iDownloadListener2 = (IDownloadListener) downloadListeners2.get(downloadListeners2.keyAt(i4));
                            if (iDownloadListener2 != null) {
                                iDownloadListener2.onCanceled(downloadInfo);
                            }
                        }
                    }
                }
            });
        }
        DownloadInfo downloadInfoB = this.f3760k.b(i2);
        if (com.ss.android.socialbase.downloader.i.a.a(65536)) {
            if (downloadInfoB != null) {
                downloadInfoB.setStatus(-4);
            }
        } else if (downloadInfoB != null && DownloadStatus.isDownloading(downloadInfoB.getStatus())) {
            downloadInfoB.setStatus(-4);
        }
        b(i2, z);
        return true;
    }

    private void a(DownloadInfo downloadInfo) {
        if (downloadInfo != null) {
            try {
                if (downloadInfo.getStatus() == 7 || downloadInfo.getRetryDelayStatus() != com.ss.android.socialbase.downloader.constants.g.DELAY_RETRY_NONE) {
                    downloadInfo.setStatus(5);
                    downloadInfo.setRetryDelayStatus(com.ss.android.socialbase.downloader.constants.g.DELAY_RETRY_NONE);
                    com.ss.android.socialbase.downloader.c.a.b("AbsDownloadEngine", "cancelAlarm");
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public synchronized void a(int i2, z zVar) {
        DownloadTask downloadTask = this.f3751b.get(i2);
        if (downloadTask != null) {
            downloadTask.setNotificationEventListener(zVar);
        }
    }

    public synchronized void a(List<String> list) {
        DownloadInfo downloadInfo;
        try {
            boolean zB = com.ss.android.socialbase.downloader.i.a.a(1048576) ? com.ss.android.socialbase.downloader.i.f.b(com.ss.android.socialbase.downloader.downloader.c.N()) : true;
            for (int i2 = 0; i2 < this.f3753d.size(); i2++) {
                DownloadTask downloadTask = this.f3753d.get(this.f3753d.keyAt(i2));
                if (downloadTask != null && (downloadInfo = downloadTask.getDownloadInfo()) != null && downloadInfo.getMimeType() != null && list.contains(downloadInfo.getMimeType()) && (!downloadInfo.isOnlyWifi() || zB)) {
                    downloadInfo.setAutoResumed(true);
                    downloadInfo.setShowNotificationForNetworkResumed(true);
                    a(downloadTask);
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public synchronized void a(int i2, int i3, IDownloadListener iDownloadListener, com.ss.android.socialbase.downloader.constants.f fVar, boolean z) {
        DownloadTask downloadTaskO = o(i2);
        if (downloadTaskO == null) {
            downloadTaskO = this.f3757h.get(Integer.valueOf(i2));
        }
        if (downloadTaskO != null) {
            downloadTaskO.removeDownloadListener(i3, iDownloadListener, fVar, z);
        }
    }

    public synchronized void a(int i2, int i3, final IDownloadListener iDownloadListener, com.ss.android.socialbase.downloader.constants.f fVar, boolean z, boolean z2) {
        DownloadInfo downloadInfoB;
        DownloadTask downloadTaskO = o(i2);
        if (downloadTaskO != null) {
            downloadTaskO.addDownloadListener(i3, iDownloadListener, fVar, z);
            final DownloadInfo downloadInfo = downloadTaskO.getDownloadInfo();
            if (z2 && downloadInfo != null && !a(i2) && (fVar == com.ss.android.socialbase.downloader.constants.f.MAIN || fVar == com.ss.android.socialbase.downloader.constants.f.NOTIFICATION)) {
                boolean z3 = true;
                if (fVar == com.ss.android.socialbase.downloader.constants.f.NOTIFICATION && !downloadInfo.canShowNotification()) {
                    z3 = false;
                }
                if (z3) {
                    this.a.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.a.6
                        @Override // java.lang.Runnable
                        public void run() {
                            if (iDownloadListener != null) {
                                if (downloadInfo.getStatus() == -3) {
                                    iDownloadListener.onSuccessed(downloadInfo);
                                } else if (downloadInfo.getStatus() == -1) {
                                    iDownloadListener.onFailed(downloadInfo, new BaseException(1000, "try add listener for failed task"));
                                }
                            }
                        }
                    });
                }
            }
        } else if (com.ss.android.socialbase.downloader.i.a.a(32768) && (downloadInfoB = this.f3760k.b(i2)) != null && downloadInfoB.getStatus() != -3) {
            DownloadTask downloadTask = this.f3757h.get(Integer.valueOf(i2));
            if (downloadTask == null) {
                downloadTask = new DownloadTask(downloadInfoB);
                this.f3757h.put(Integer.valueOf(i2), downloadTask);
            }
            downloadTask.addDownloadListener(i3, iDownloadListener, fVar, z);
        }
    }

    private void a(int i2, BaseException baseException, DownloadTask downloadTask) {
        if (downloadTask != null) {
            DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
            SparseArray<IDownloadListener> downloadListeners = downloadTask.getDownloadListeners(com.ss.android.socialbase.downloader.constants.f.MAIN);
            SparseArray<IDownloadListener> downloadListeners2 = downloadTask.getDownloadListeners(com.ss.android.socialbase.downloader.constants.f.NOTIFICATION);
            boolean z = downloadTask.canShowNotification() || downloadInfo.isAutoInstallWithoutNotification();
            com.ss.android.socialbase.downloader.i.c.a(i2, downloadListeners, true, downloadInfo, baseException);
            com.ss.android.socialbase.downloader.i.c.a(i2, downloadListeners2, z, downloadInfo, baseException);
        }
    }

    private void a(int i2, int i3) {
        com.ss.android.socialbase.downloader.c.a.b("AbsDownloadEngine", "removeTask id: " + i2 + " listener hasCode: " + i3);
        if (i3 == 0) {
            this.f3751b.remove(i2);
            this.f3756g.remove(i2);
            return;
        }
        SparseArray<DownloadTask> sparseArray = this.f3756g.get(i2);
        if (sparseArray != null) {
            sparseArray.remove(i3);
            com.ss.android.socialbase.downloader.c.a.b("AbsDownloadEngine", "after downloadTaskWithListenerMap removeTask taskArray.size: " + sparseArray.size());
            if (sparseArray.size() == 0) {
                this.f3751b.remove(i2);
                this.f3756g.remove(i2);
                return;
            }
            return;
        }
        this.f3751b.remove(i2);
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x007e A[Catch: all -> 0x009d, TryCatch #0 {, blocks: (B:18:0x0019, B:20:0x0023, B:22:0x002b, B:23:0x0030, B:24:0x0034, B:26:0x003e, B:28:0x0046, B:29:0x004b, B:30:0x004e, B:31:0x0052, B:32:0x0066, B:33:0x006d, B:34:0x007e, B:36:0x0088, B:38:0x0090, B:39:0x0095, B:40:0x0098), top: B:46:0x0002 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized void a(int r2, int r3, int r4) {
        /*
            r1 = this;
            monitor-enter(r1)
            r0 = -7
            if (r4 == r0) goto L7e
            r0 = -6
            if (r4 == r0) goto L6d
            r0 = -4
            if (r4 == r0) goto L66
            r0 = -3
            if (r4 == r0) goto L52
            r0 = -1
            if (r4 == r0) goto L7e
            r0 = 7
            if (r4 == r0) goto L34
            r3 = 8
            if (r4 == r3) goto L19
            goto L9b
        L19:
            android.util.SparseArray<com.ss.android.socialbase.downloader.model.DownloadTask> r3 = r1.f3751b     // Catch: java.lang.Throwable -> L9d
            java.lang.Object r3 = r3.get(r2)     // Catch: java.lang.Throwable -> L9d
            com.ss.android.socialbase.downloader.model.DownloadTask r3 = (com.ss.android.socialbase.downloader.model.DownloadTask) r3     // Catch: java.lang.Throwable -> L9d
            if (r3 == 0) goto L30
            android.util.SparseArray<com.ss.android.socialbase.downloader.model.DownloadTask> r4 = r1.f3755f     // Catch: java.lang.Throwable -> L9d
            java.lang.Object r4 = r4.get(r2)     // Catch: java.lang.Throwable -> L9d
            if (r4 != 0) goto L30
            android.util.SparseArray<com.ss.android.socialbase.downloader.model.DownloadTask> r4 = r1.f3755f     // Catch: java.lang.Throwable -> L9d
            r4.put(r2, r3)     // Catch: java.lang.Throwable -> L9d
        L30:
            r1.p(r2)     // Catch: java.lang.Throwable -> L9d
            goto L9b
        L34:
            android.util.SparseArray<com.ss.android.socialbase.downloader.model.DownloadTask> r4 = r1.f3751b     // Catch: java.lang.Throwable -> L9d
            java.lang.Object r4 = r4.get(r2)     // Catch: java.lang.Throwable -> L9d
            com.ss.android.socialbase.downloader.model.DownloadTask r4 = (com.ss.android.socialbase.downloader.model.DownloadTask) r4     // Catch: java.lang.Throwable -> L9d
            if (r4 == 0) goto L4e
            android.util.SparseArray<com.ss.android.socialbase.downloader.model.DownloadTask> r0 = r1.f3754e     // Catch: java.lang.Throwable -> L9d
            java.lang.Object r0 = r0.get(r2)     // Catch: java.lang.Throwable -> L9d
            if (r0 != 0) goto L4b
            android.util.SparseArray<com.ss.android.socialbase.downloader.model.DownloadTask> r0 = r1.f3754e     // Catch: java.lang.Throwable -> L9d
            r0.put(r2, r4)     // Catch: java.lang.Throwable -> L9d
        L4b:
            r1.a(r2, r3)     // Catch: java.lang.Throwable -> L9d
        L4e:
            r1.p(r2)     // Catch: java.lang.Throwable -> L9d
            goto L9b
        L52:
            android.util.SparseArray<com.ss.android.socialbase.downloader.model.DownloadTask> r4 = r1.f3751b     // Catch: java.lang.Throwable -> L9d
            java.lang.Object r4 = r4.get(r2)     // Catch: java.lang.Throwable -> L9d
            com.ss.android.socialbase.downloader.model.DownloadTask r4 = (com.ss.android.socialbase.downloader.model.DownloadTask) r4     // Catch: java.lang.Throwable -> L9d
            android.util.SparseArray<com.ss.android.socialbase.downloader.model.DownloadTask> r0 = r1.f3752c     // Catch: java.lang.Throwable -> L9d
            r0.put(r2, r4)     // Catch: java.lang.Throwable -> L9d
            r1.a(r2, r3)     // Catch: java.lang.Throwable -> L9d
            r1.p(r2)     // Catch: java.lang.Throwable -> L9d
            goto L9b
        L66:
            r1.a(r2, r3)     // Catch: java.lang.Throwable -> L9d
            r1.p(r2)     // Catch: java.lang.Throwable -> L9d
            goto L9b
        L6d:
            android.util.SparseArray<com.ss.android.socialbase.downloader.model.DownloadTask> r4 = r1.f3751b     // Catch: java.lang.Throwable -> L9d
            java.lang.Object r4 = r4.get(r2)     // Catch: java.lang.Throwable -> L9d
            com.ss.android.socialbase.downloader.model.DownloadTask r4 = (com.ss.android.socialbase.downloader.model.DownloadTask) r4     // Catch: java.lang.Throwable -> L9d
            android.util.SparseArray<com.ss.android.socialbase.downloader.model.DownloadTask> r0 = r1.f3752c     // Catch: java.lang.Throwable -> L9d
            r0.put(r2, r4)     // Catch: java.lang.Throwable -> L9d
            r1.a(r2, r3)     // Catch: java.lang.Throwable -> L9d
            goto L9b
        L7e:
            android.util.SparseArray<com.ss.android.socialbase.downloader.model.DownloadTask> r4 = r1.f3751b     // Catch: java.lang.Throwable -> L9d
            java.lang.Object r4 = r4.get(r2)     // Catch: java.lang.Throwable -> L9d
            com.ss.android.socialbase.downloader.model.DownloadTask r4 = (com.ss.android.socialbase.downloader.model.DownloadTask) r4     // Catch: java.lang.Throwable -> L9d
            if (r4 == 0) goto L98
            android.util.SparseArray<com.ss.android.socialbase.downloader.model.DownloadTask> r0 = r1.f3753d     // Catch: java.lang.Throwable -> L9d
            java.lang.Object r0 = r0.get(r2)     // Catch: java.lang.Throwable -> L9d
            if (r0 != 0) goto L95
            android.util.SparseArray<com.ss.android.socialbase.downloader.model.DownloadTask> r0 = r1.f3753d     // Catch: java.lang.Throwable -> L9d
            r0.put(r2, r4)     // Catch: java.lang.Throwable -> L9d
        L95:
            r1.a(r2, r3)     // Catch: java.lang.Throwable -> L9d
        L98:
            r1.p(r2)     // Catch: java.lang.Throwable -> L9d
        L9b:
            monitor-exit(r1)
            return
        L9d:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.impls.a.a(int, int, int):void");
    }

    @Override // com.ss.android.socialbase.downloader.h.h.a
    public void a(Message message) {
        int i2 = message.arg1;
        int i3 = message.arg2;
        com.ss.android.socialbase.downloader.c.a.b("AbsDownloadEngine", "handleMsg id: " + i2 + " listener hasCode: " + i3);
        Object obj = message.obj;
        DownloadTask downloadTask = null;
        BaseException baseException = obj instanceof Exception ? (BaseException) obj : null;
        synchronized (this) {
            if (i3 == 0) {
                downloadTask = this.f3751b.get(i2);
            } else {
                SparseArray<DownloadTask> sparseArray = this.f3756g.get(i2);
                if (sparseArray != null) {
                    downloadTask = sparseArray.get(i3);
                }
            }
            if (downloadTask == null) {
                return;
            }
            a(message.what, baseException, downloadTask);
            a(i2, i3, message.what);
        }
    }
}

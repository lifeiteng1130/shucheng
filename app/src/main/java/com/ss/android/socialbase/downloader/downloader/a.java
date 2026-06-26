package com.ss.android.socialbase.downloader.downloader;

import android.app.Notification;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: AbsDownloadServiceHandler.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class a implements o {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f3548e = "a";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f3550c;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private WeakReference<Service> f3552f;
    public final SparseArray<List<DownloadTask>> a = new SparseArray<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f3549b = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile boolean f3551d = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Handler f3553g = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Runnable f3554h = new Runnable() { // from class: com.ss.android.socialbase.downloader.downloader.a.1
        @Override // java.lang.Runnable
        public void run() {
            if (com.ss.android.socialbase.downloader.c.a.a()) {
                com.ss.android.socialbase.downloader.c.a.b(a.f3548e, "tryDownload: 2 try");
            }
            if (a.this.f3549b) {
                return;
            }
            if (com.ss.android.socialbase.downloader.c.a.a()) {
                com.ss.android.socialbase.downloader.c.a.b(a.f3548e, "tryDownload: 2 error");
            }
            a.this.startService(c.N(), null);
        }
    };

    @Override // com.ss.android.socialbase.downloader.downloader.o
    public void a(Intent intent, int i2, int i3) {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.o
    public void a(n nVar) {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.o
    public void a(WeakReference weakReference) {
        this.f3552f = weakReference;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.o
    public boolean b() {
        String str = f3548e;
        StringBuilder sbR = c.a.a.a.a.r("isServiceForeground = ");
        sbR.append(this.f3550c);
        com.ss.android.socialbase.downloader.c.a.c(str, sbR.toString());
        return this.f3550c;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.o
    public void c() {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.o
    public void c(DownloadTask downloadTask) {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.o
    public void d() {
        this.f3549b = false;
    }

    public void e() {
        SparseArray<List<DownloadTask>> sparseArrayClone;
        synchronized (this.a) {
            com.ss.android.socialbase.downloader.c.a.b(f3548e, "resumePendingTask pendingTasks.size:" + this.a.size());
            sparseArrayClone = this.a.clone();
            this.a.clear();
        }
        com.ss.android.socialbase.downloader.impls.a aVarC = c.C();
        if (aVarC != null) {
            for (int i2 = 0; i2 < sparseArrayClone.size(); i2++) {
                List<DownloadTask> list = sparseArrayClone.get(sparseArrayClone.keyAt(i2));
                if (list != null) {
                    for (DownloadTask downloadTask : list) {
                        String str = f3548e;
                        StringBuilder sbR = c.a.a.a.a.r("resumePendingTask key:");
                        sbR.append(downloadTask.getDownloadId());
                        com.ss.android.socialbase.downloader.c.a.b(str, sbR.toString());
                        aVarC.a(downloadTask);
                    }
                }
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.o
    public void startService() {
        if (this.f3549b) {
            return;
        }
        if (com.ss.android.socialbase.downloader.c.a.a()) {
            com.ss.android.socialbase.downloader.c.a.b(f3548e, "startService");
        }
        startService(c.N(), null);
    }

    public void startService(Context context, ServiceConnection serviceConnection) {
    }

    public void stopService(Context context, ServiceConnection serviceConnection) {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.o
    public boolean a() {
        return this.f3549b;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.o
    public IBinder a(Intent intent) {
        com.ss.android.socialbase.downloader.c.a.b(f3548e, "onBind Abs");
        return new Binder();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.o
    public void b(DownloadTask downloadTask) {
        if (downloadTask == null) {
            return;
        }
        if (!this.f3549b) {
            if (com.ss.android.socialbase.downloader.c.a.a()) {
                com.ss.android.socialbase.downloader.c.a.b(f3548e, "tryDownload but service is not alive");
            }
            if (com.ss.android.socialbase.downloader.i.a.a(262144)) {
                a(downloadTask);
                if (!this.f3551d) {
                    if (com.ss.android.socialbase.downloader.c.a.a()) {
                        com.ss.android.socialbase.downloader.c.a.b(f3548e, "tryDownload: 1");
                    }
                    startService(c.N(), null);
                    this.f3551d = true;
                    return;
                }
                this.f3553g.removeCallbacks(this.f3554h);
                this.f3553g.postDelayed(this.f3554h, 10L);
                return;
            }
            a(downloadTask);
            startService(c.N(), null);
            return;
        }
        String str = f3548e;
        com.ss.android.socialbase.downloader.c.a.b(str, "tryDownload when isServiceAlive");
        e();
        com.ss.android.socialbase.downloader.impls.a aVarC = c.C();
        if (aVarC != null) {
            StringBuilder sbR = c.a.a.a.a.r("tryDownload current task: ");
            sbR.append(downloadTask.getDownloadId());
            com.ss.android.socialbase.downloader.c.a.b(str, sbR.toString());
            aVarC.a(downloadTask);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.o
    public void a(int i2, Notification notification) {
        WeakReference<Service> weakReference = this.f3552f;
        if (weakReference != null && weakReference.get() != null) {
            String str = f3548e;
            StringBuilder sbS = c.a.a.a.a.s("startForeground  id = ", i2, ", service = ");
            sbS.append(this.f3552f.get());
            sbS.append(",  isServiceAlive = ");
            sbS.append(this.f3549b);
            com.ss.android.socialbase.downloader.c.a.c(str, sbS.toString());
            try {
                this.f3552f.get().startForeground(i2, notification);
                this.f3550c = true;
                return;
            } catch (Exception e2) {
                e2.printStackTrace();
                return;
            }
        }
        com.ss.android.socialbase.downloader.c.a.d(f3548e, "startForeground: downloadService is null, do nothing!");
    }

    @Override // com.ss.android.socialbase.downloader.downloader.o
    public void a(boolean z) {
        WeakReference<Service> weakReference = this.f3552f;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        String str = f3548e;
        StringBuilder sbR = c.a.a.a.a.r("stopForeground  service = ");
        sbR.append(this.f3552f.get());
        sbR.append(",  isServiceAlive = ");
        sbR.append(this.f3549b);
        com.ss.android.socialbase.downloader.c.a.c(str, sbR.toString());
        try {
            this.f3550c = false;
            this.f3552f.get().stopForeground(z);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void a(DownloadTask downloadTask) {
        if (downloadTask == null) {
            return;
        }
        int downloadId = downloadTask.getDownloadId();
        synchronized (this.a) {
            String str = f3548e;
            com.ss.android.socialbase.downloader.c.a.b(str, "pendDownloadTask pendingTasks.size:" + this.a.size() + " downloadId:" + downloadId);
            List<DownloadTask> arrayList = this.a.get(downloadId);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                this.a.put(downloadId, arrayList);
            }
            com.ss.android.socialbase.downloader.c.a.b(str, "before pendDownloadTask taskArray.size:" + arrayList.size());
            arrayList.add(downloadTask);
            com.ss.android.socialbase.downloader.c.a.b(str, "after pendDownloadTask pendingTasks.size:" + this.a.size());
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.o
    public void a(int i2) {
        com.ss.android.socialbase.downloader.c.a.a(i2);
    }
}

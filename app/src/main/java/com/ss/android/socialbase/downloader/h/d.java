package com.ss.android.socialbase.downloader.h;

import android.util.SparseArray;
import androidx.core.view.PointerIconCompat;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: DownloadThreadPool.java */
/* JADX INFO: loaded from: classes.dex */
public class d {
    private static ExecutorService a = new ThreadPoolExecutor(2, 2, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new a("Download_OP_Thread"));

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f3712c = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile SparseArray<c> f3711b = new SparseArray<>();

    public static void a(Runnable runnable) {
        a.execute(runnable);
    }

    private void b() {
        try {
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < this.f3711b.size(); i2++) {
                int iKeyAt = this.f3711b.keyAt(i2);
                if (!this.f3711b.get(iKeyAt).d()) {
                    arrayList.add(Integer.valueOf(iKeyAt));
                }
            }
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                try {
                    Integer num = (Integer) arrayList.get(i3);
                    if (num != null) {
                        this.f3711b.remove(num.intValue());
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public void c(int i2) {
        synchronized (d.class) {
            b();
            c cVar = this.f3711b.get(i2);
            if (cVar != null) {
                cVar.a();
                c(cVar);
                this.f3711b.remove(i2);
            }
        }
    }

    public void a(c cVar) {
        cVar.f();
        synchronized (d.class) {
            int i2 = this.f3712c;
            if (i2 >= 500) {
                b();
                this.f3712c = 0;
            } else {
                this.f3712c = i2 + 1;
            }
            this.f3711b.put(cVar.e(), cVar);
        }
        DownloadTask downloadTaskC = cVar.c();
        try {
            ExecutorService executorServiceP = com.ss.android.socialbase.downloader.downloader.c.p();
            if (downloadTaskC != null && downloadTaskC.getDownloadInfo() != null) {
                if ("mime_type_plg".equals(downloadTaskC.getDownloadInfo().getMimeType()) && com.ss.android.socialbase.downloader.g.a.c().a("divide_plugin", 1) == 1) {
                    downloadTaskC.getDownloadInfo().safePutToDBJsonData("executor_group", 3);
                }
                int executorGroup = downloadTaskC.getDownloadInfo().getExecutorGroup();
                if (executorGroup == 3) {
                    executorServiceP = com.ss.android.socialbase.downloader.downloader.c.n();
                } else if (executorGroup == 4) {
                    executorServiceP = com.ss.android.socialbase.downloader.downloader.c.o();
                }
            }
            if (executorServiceP == null) {
                com.ss.android.socialbase.downloader.d.a.a(downloadTaskC.getMonitorDepend(), downloadTaskC.getDownloadInfo(), new BaseException(PointerIconCompat.TYPE_HELP, "execute failed cpu thread executor service is null"), downloadTaskC.getDownloadInfo() != null ? downloadTaskC.getDownloadInfo().getStatus() : 0);
            } else if (com.ss.android.socialbase.downloader.g.a.a(cVar.e()).b("pause_with_interrupt", false)) {
                cVar.a(executorServiceP.submit(cVar));
            } else {
                executorServiceP.execute(cVar);
            }
        } catch (Exception e2) {
            if (downloadTaskC != null) {
                com.ss.android.socialbase.downloader.d.a.a(downloadTaskC.getMonitorDepend(), downloadTaskC.getDownloadInfo(), new BaseException(PointerIconCompat.TYPE_HELP, com.ss.android.socialbase.downloader.i.f.b(e2, "DownloadThreadPoolExecute")), downloadTaskC.getDownloadInfo() != null ? downloadTaskC.getDownloadInfo().getStatus() : 0);
            }
            e2.printStackTrace();
        } catch (OutOfMemoryError e3) {
            if (downloadTaskC != null) {
                com.ss.android.socialbase.downloader.d.a.a(downloadTaskC.getMonitorDepend(), downloadTaskC.getDownloadInfo(), new BaseException(PointerIconCompat.TYPE_HELP, "execute OOM"), downloadTaskC.getDownloadInfo() != null ? downloadTaskC.getDownloadInfo().getStatus() : 0);
            }
            e3.printStackTrace();
        }
    }

    private void c(c cVar) {
        Future futureG;
        if (cVar == null) {
            return;
        }
        try {
            ExecutorService executorServiceP = com.ss.android.socialbase.downloader.downloader.c.p();
            DownloadTask downloadTaskC = cVar.c();
            if (downloadTaskC != null && downloadTaskC.getDownloadInfo() != null) {
                int executorGroup = downloadTaskC.getDownloadInfo().getExecutorGroup();
                if (executorGroup == 3) {
                    executorServiceP = com.ss.android.socialbase.downloader.downloader.c.n();
                } else if (executorGroup == 4) {
                    executorServiceP = com.ss.android.socialbase.downloader.downloader.c.o();
                }
            }
            if (executorServiceP == null || !(executorServiceP instanceof ThreadPoolExecutor)) {
                return;
            }
            ((ThreadPoolExecutor) executorServiceP).remove(cVar);
            if (!com.ss.android.socialbase.downloader.g.a.a(cVar.e()).b("pause_with_interrupt", false) || (futureG = cVar.g()) == null) {
                return;
            }
            futureG.cancel(true);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void b(c cVar) {
        if (cVar == null) {
            return;
        }
        synchronized (d.class) {
            try {
                if (com.ss.android.socialbase.downloader.i.a.a(524288)) {
                    int iIndexOfValue = this.f3711b.indexOfValue(cVar);
                    if (iIndexOfValue >= 0) {
                        this.f3711b.removeAt(iIndexOfValue);
                    }
                } else {
                    this.f3711b.remove(cVar.e());
                }
            } finally {
            }
        }
    }

    public c b(int i2) {
        synchronized (d.class) {
            b();
            c cVar = this.f3711b.get(i2);
            if (cVar == null) {
                return null;
            }
            cVar.b();
            c(cVar);
            this.f3711b.remove(i2);
            return cVar;
        }
    }

    public boolean a(int i2) {
        synchronized (d.class) {
            boolean z = false;
            if (this.f3711b != null && this.f3711b.size() > 0) {
                c cVar = this.f3711b.get(i2);
                if (cVar != null && cVar.d()) {
                    z = true;
                }
                return z;
            }
            return false;
        }
    }

    public List<Integer> a() {
        ArrayList arrayList;
        synchronized (d.class) {
            b();
            arrayList = new ArrayList();
            for (int i2 = 0; i2 < this.f3711b.size(); i2++) {
                c cVar = this.f3711b.get(this.f3711b.keyAt(i2));
                if (cVar != null) {
                    arrayList.add(Integer.valueOf(cVar.e()));
                }
            }
        }
        return arrayList;
    }

    public void a(int i2, long j2) {
        c cVar = this.f3711b.get(i2);
        if (cVar != null) {
            cVar.c(j2);
        }
    }
}

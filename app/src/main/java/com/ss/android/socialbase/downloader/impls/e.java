package com.ss.android.socialbase.downloader.impls;

import com.ss.android.socialbase.downloader.constants.DownloadStatus;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: compiled from: DefaultDownloadEngine.java */
/* JADX INFO: loaded from: classes.dex */
public class e extends a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static com.ss.android.socialbase.downloader.h.d f3779b;

    public e() {
        f3779b = new com.ss.android.socialbase.downloader.h.d();
    }

    public static void c(List<Callable<Object>> list) throws InterruptedException {
        ExecutorService executorServiceQ = com.ss.android.socialbase.downloader.downloader.c.q();
        if (executorServiceQ != null) {
            executorServiceQ.invokeAll(list);
        }
    }

    public static List<Future> d(List<Runnable> list) {
        ExecutorService executorServiceQ = com.ss.android.socialbase.downloader.downloader.c.q();
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<Runnable> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(executorServiceQ.submit(it.next()));
        }
        return arrayList;
    }

    public static Runnable e(List<Future> list) {
        BlockingQueue<Runnable> queue;
        Runnable runnable;
        if (list != null && !list.isEmpty()) {
            try {
                ExecutorService executorServiceQ = com.ss.android.socialbase.downloader.downloader.c.q();
                if ((executorServiceQ instanceof ThreadPoolExecutor) && (queue = ((ThreadPoolExecutor) executorServiceQ).getQueue()) != null && !queue.isEmpty()) {
                    Iterator<Future> it = list.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            runnable = null;
                            break;
                        }
                        Future next = it.next();
                        if ((next instanceof Runnable) && queue.remove(next)) {
                            runnable = (Runnable) next;
                            break;
                        }
                    }
                    if (runnable != null) {
                        list.remove(runnable);
                        return runnable;
                    }
                }
            } catch (Throwable th) {
                StringBuilder sbR = c.a.a.a.a.r("getUnstartedTask() error: ");
                sbR.append(th.toString());
                com.ss.android.socialbase.downloader.c.a.d("DefaultDownloadEngine", sbR.toString());
            }
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.impls.a
    public boolean a(int i2) {
        DownloadInfo downloadInfoD;
        com.ss.android.socialbase.downloader.h.d dVar = f3779b;
        if (dVar == null || !dVar.a(i2) || (downloadInfoD = d(i2)) == null) {
            return false;
        }
        if (DownloadStatus.isDownloading(downloadInfoD.getStatus())) {
            return true;
        }
        b(i2);
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.impls.a
    public void b(int i2) {
        com.ss.android.socialbase.downloader.h.d dVar = f3779b;
        if (dVar == null) {
            return;
        }
        dVar.c(i2);
    }

    @Override // com.ss.android.socialbase.downloader.impls.a
    public com.ss.android.socialbase.downloader.h.c c(int i2) {
        com.ss.android.socialbase.downloader.h.d dVar = f3779b;
        if (dVar == null) {
            return null;
        }
        return dVar.b(i2);
    }

    @Override // com.ss.android.socialbase.downloader.impls.a
    public void a(com.ss.android.socialbase.downloader.h.c cVar) {
        com.ss.android.socialbase.downloader.h.d dVar = f3779b;
        if (dVar == null) {
            return;
        }
        dVar.b(cVar);
    }

    @Override // com.ss.android.socialbase.downloader.impls.a
    public void a(int i2, DownloadTask downloadTask) {
        if (downloadTask == null) {
            return;
        }
        com.ss.android.socialbase.downloader.c.a.b("DownloadTask", "start doDownload for task : " + i2);
        f3779b.a(new com.ss.android.socialbase.downloader.h.c(downloadTask, this.a));
    }

    @Override // com.ss.android.socialbase.downloader.impls.a
    public List<Integer> a() {
        return f3779b.a();
    }

    @Override // com.ss.android.socialbase.downloader.impls.a
    public void a(int i2, long j2) {
        com.ss.android.socialbase.downloader.h.d dVar = f3779b;
        if (dVar == null) {
            return;
        }
        dVar.a(i2, j2);
    }
}

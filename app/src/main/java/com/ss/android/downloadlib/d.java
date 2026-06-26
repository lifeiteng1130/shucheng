package com.ss.android.downloadlib;

import android.content.SharedPreferences;
import android.util.SparseArray;
import com.ss.android.downloadlib.addownload.j;
import com.ss.android.downloadlib.g.l;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: DownloadComponentManager.java */
/* JADX INFO: loaded from: classes.dex */
public class d {
    private ExecutorService a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ExecutorService f3211b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ScheduledExecutorService f3212c;

    /* JADX INFO: compiled from: DownloadComponentManager.java */
    public static class a {
        private static d a = new d();
    }

    public static d a() {
        return a.a;
    }

    public void b(Runnable runnable) {
        b(runnable, false);
    }

    public ExecutorService c() {
        if (this.f3211b == null) {
            synchronized (d.class) {
                if (this.f3211b == null) {
                    this.f3211b = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 30L, TimeUnit.SECONDS, new SynchronousQueue(), new com.ss.android.socialbase.downloader.h.a(g.class.getName() + "-IOThreadPool"));
                }
            }
        }
        return this.f3211b;
    }

    public ScheduledExecutorService d() {
        if (this.f3212c == null) {
            synchronized (d.class) {
                if (this.f3212c == null) {
                    this.f3212c = new ScheduledThreadPoolExecutor(0, new com.ss.android.socialbase.downloader.h.a(g.class.getName() + "-ScheduledThreadPool"));
                }
            }
        }
        return this.f3212c;
    }

    public void e() {
        a(new Runnable() { // from class: com.ss.android.downloadlib.d.1
            @Override // java.lang.Runnable
            public void run() {
                synchronized (d.class) {
                    try {
                        String[] strArr = {"sp_ad_download_event", "sp_download_finish_cache", "sp_delay_operation_info", "sp_ttdownloader_md5", "sp_name_installed_app", "misc_config", "sp_ad_install_back_dialog", "sp_ttdownloader_clean", "sp_order_download", "sp_a_b_c", "sp_ah_config", "sp_download_info", "sp_appdownloader"};
                        for (int i2 = 0; i2 < 13; i2++) {
                            SharedPreferences sharedPreferences = j.getContext().getSharedPreferences(strArr[i2], 0);
                            if (sharedPreferences != null) {
                                sharedPreferences.edit().clear().apply();
                            }
                        }
                        com.ss.android.socialbase.downloader.downloader.j jVarX = com.ss.android.socialbase.downloader.downloader.c.x();
                        if (!(jVarX instanceof com.ss.android.socialbase.downloader.impls.d)) {
                            return;
                        }
                        SparseArray<DownloadInfo> sparseArrayA = ((com.ss.android.socialbase.downloader.impls.d) jVarX).a().a();
                        for (int size = sparseArrayA.size() - 1; size >= 0; size--) {
                            DownloadInfo downloadInfo = sparseArrayA.get(sparseArrayA.keyAt(size));
                            if (downloadInfo != null) {
                                Downloader.getInstance(j.getContext()).clearDownloadData(downloadInfo.getId());
                            }
                        }
                    } catch (Throwable unused) {
                    }
                }
            }
        });
    }

    private d() {
    }

    public void a(Runnable runnable) {
        a(runnable, false);
    }

    public void b(Runnable runnable, boolean z) {
        if (runnable == null) {
            return;
        }
        if (!z || l.a()) {
            c().execute(runnable);
        } else {
            runnable.run();
        }
    }

    public void a(Runnable runnable, boolean z) {
        if (runnable == null) {
            return;
        }
        if (z && !l.a()) {
            runnable.run();
        } else {
            b().execute(runnable);
        }
    }

    public ExecutorService b() {
        if (this.a == null) {
            synchronized (d.class) {
                if (this.a == null) {
                    this.a = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 30L, TimeUnit.SECONDS, new SynchronousQueue(), new com.ss.android.socialbase.downloader.h.a(g.class.getName() + "-CPUThreadPool"));
                }
            }
        }
        return this.a;
    }

    public void a(Runnable runnable, long j2) {
        try {
            d().schedule(runnable, j2, TimeUnit.MILLISECONDS);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}

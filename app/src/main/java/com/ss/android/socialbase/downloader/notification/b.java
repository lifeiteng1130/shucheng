package com.ss.android.socialbase.downloader.notification;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteException;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.downloader.c;
import com.ss.android.socialbase.downloader.downloader.j;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: DownloadNotificationManager.java */
/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile b f3939c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Object f3940e = new Object();
    private final long a = 1000;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<Integer, Long> f3941b = new HashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Set<String> f3942d = new HashSet();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final SparseArray<a> f3943f = new SparseArray<>();

    private b() {
    }

    public static b a() {
        if (f3939c == null) {
            synchronized (b.class) {
                if (f3939c == null) {
                    f3939c = new b();
                }
            }
        }
        return f3939c;
    }

    public static boolean b(int i2) {
        return i2 == 1 || i2 == 3;
    }

    public static boolean c(DownloadInfo downloadInfo) {
        return downloadInfo.isDownloadOverStatus() && b(downloadInfo.getNotificationVisibility());
    }

    public void b(DownloadInfo downloadInfo) {
        if (c(downloadInfo)) {
            f(downloadInfo.getId());
        }
    }

    public a d(int i2) {
        a aVar;
        if (i2 == 0) {
            return null;
        }
        synchronized (this.f3943f) {
            aVar = this.f3943f.get(i2);
            if (aVar != null) {
                this.f3943f.remove(i2);
                com.ss.android.socialbase.downloader.c.a.a("removeNotificationId " + i2);
            }
        }
        return aVar;
    }

    public a e(int i2) {
        a aVar;
        if (i2 == 0) {
            return null;
        }
        synchronized (this.f3943f) {
            aVar = this.f3943f.get(i2);
        }
        return aVar;
    }

    public void f(int i2) {
        d(i2);
        if (i2 != 0) {
            a().c(i2);
        }
    }

    public void c(int i2) {
        Context contextN = c.N();
        if (contextN == null || i2 == 0) {
            return;
        }
        try {
            Intent intent = new Intent(contextN, (Class<?>) DownloadNotificationService.class);
            intent.setAction("android.ss.intent.action.DOWNLOAD_NOTIFICATION_CANCEL");
            intent.putExtra("DOWNLOAD_NOTIFICATION_BUNDLE_EXTRA_ID", i2);
            contextN.startService(intent);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public SparseArray<a> b() {
        SparseArray<a> sparseArray;
        synchronized (this.f3943f) {
            sparseArray = this.f3943f;
        }
        return sparseArray;
    }

    public void a(int i2) {
        DownloadInfo downloadInfo = Downloader.getInstance(c.N()).getDownloadInfo(i2);
        if (downloadInfo == null) {
            return;
        }
        a(downloadInfo);
        b(downloadInfo);
    }

    public void a(DownloadInfo downloadInfo) {
        j jVarX = c.x();
        if (jVarX != null && downloadInfo.isDownloadOverStatus()) {
            downloadInfo.setNotificationVisibility(3);
            try {
                jVarX.a(downloadInfo);
            } catch (SQLiteException e2) {
                e2.printStackTrace();
            }
        }
    }

    public void a(int i2, int i3, Notification notification) {
        Context contextN = c.N();
        if (contextN == null || i2 == 0 || notification == null) {
            return;
        }
        if (i3 == 4) {
            synchronized (this.f3941b) {
                Long l2 = this.f3941b.get(Integer.valueOf(i2));
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (l2 != null && Math.abs(jCurrentTimeMillis - l2.longValue()) < 1000) {
                    return;
                } else {
                    this.f3941b.put(Integer.valueOf(i2), Long.valueOf(jCurrentTimeMillis));
                }
            }
        }
        try {
            Intent intent = new Intent(contextN, (Class<?>) DownloadNotificationService.class);
            intent.setAction("android.ss.intent.action.DOWNLOAD_NOTIFICATION_NOTIFY");
            intent.putExtra("DOWNLOAD_NOTIFICATION_EXTRA_STATUS", i3);
            intent.putExtra("DOWNLOAD_NOTIFICATION_BUNDLE_EXTRA_ID", i2);
            intent.putExtra("DOWNLOAD_NOTIFICATION_BUNDLE_EXTRA", notification);
            contextN.startService(intent);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void a(a aVar) {
        if (aVar == null) {
            return;
        }
        synchronized (this.f3943f) {
            this.f3943f.put(aVar.a(), aVar);
        }
    }
}

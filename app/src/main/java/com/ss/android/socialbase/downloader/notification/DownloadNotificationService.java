package com.ss.android.socialbase.downloader.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.IBinder;
import android.text.TextUtils;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.constants.e;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.downloader.c;
import com.ss.android.socialbase.downloader.downloader.d;
import com.ss.android.socialbase.downloader.downloader.m;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.h.g;
import com.ss.android.socialbase.downloader.i.f;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class DownloadNotificationService extends Service {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static volatile long f3918f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static volatile long f3919g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static boolean f3920h;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private g f3922j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final SparseArray<Notification> f3923k = new SparseArray<>(2);
    private static final String a = DownloadNotificationService.class.getSimpleName();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static int f3914b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static int f3915c = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static boolean f3916d = true;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static boolean f3917e = false;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static long f3921i = 900;

    private void d() {
        if (this.f3922j == null) {
            g gVar = new g("DownloaderNotifyThread");
            this.f3922j = gVar;
            gVar.a();
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        d();
        c.a(this);
        com.ss.android.socialbase.downloader.g.a aVarC = com.ss.android.socialbase.downloader.g.a.c();
        int iA = aVarC.a("download_service_foreground", 0);
        if ((iA == 1 || iA == 3) && f3914b == -1) {
            f3914b = 0;
        }
        if ((iA == 2 || iA == 3) && f3915c == -1) {
            f3915c = 0;
        }
        f3917e = aVarC.b("non_going_notification_foreground", false);
        f3920h = aVarC.b("notify_too_fast", false);
        long jA = aVarC.a("notification_time_window", 900L);
        f3921i = jA;
        if (jA < 0 || jA > 1200) {
            f3921i = 900L;
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        g gVar = this.f3922j;
        if (gVar != null) {
            try {
                gVar.b();
            } catch (Throwable unused) {
            }
            this.f3922j = null;
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i2, int i3) {
        a(intent);
        return 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(NotificationManager notificationManager, int i2, Notification notification) {
        if (a(i2, notification)) {
            try {
                boolean z = false;
                boolean z2 = d.a().a(i2) == 1 && !f.c();
                if ((!z2 && f3914b == 0) || (z2 && f3915c == 0)) {
                    z = true;
                }
                if (z) {
                    m mVarC = d.a().c(i2);
                    if (mVarC.g() && !mVarC.b()) {
                        com.ss.android.socialbase.downloader.c.a.c(a, "doNotify, startForeground, ======== id = " + i2 + ", isIndependentProcess = " + z2);
                        if (z2) {
                            f3915c = i2;
                        } else {
                            f3914b = i2;
                        }
                        mVarC.a(i2, notification);
                    } else {
                        com.ss.android.socialbase.downloader.c.a.c(a, "doNotify: canStartForeground = true, but proxy can not startForeground, isIndependentProcess = " + z2);
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        } else if ((f3914b == i2 || f3915c == i2) && f3917e && (notification.flags & 2) == 0) {
            b(notificationManager, i2);
        }
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (f3918f < jCurrentTimeMillis) {
                f3918f = jCurrentTimeMillis;
            }
            notificationManager.notify(i2, notification);
        } catch (Throwable unused) {
        }
    }

    private void a(final Intent intent) {
        g gVar;
        if (intent == null) {
            return;
        }
        final String action = intent.getAction();
        if (TextUtils.isEmpty(action) || (gVar = this.f3922j) == null) {
            return;
        }
        gVar.a(new Runnable() { // from class: com.ss.android.socialbase.downloader.notification.DownloadNotificationService.1
            @Override // java.lang.Runnable
            public void run() {
                ConnectivityManager connectivityManager;
                NetworkInfo activeNetworkInfo;
                final NotificationManager notificationManager = (NotificationManager) DownloadNotificationService.this.getSystemService("notification");
                final int intExtra = intent.getIntExtra("DOWNLOAD_NOTIFICATION_BUNDLE_EXTRA_ID", 0);
                if (!action.equals("android.ss.intent.action.DOWNLOAD_NOTIFICATION_NOTIFY")) {
                    if (action.equals("android.ss.intent.action.DOWNLOAD_NOTIFICATION_CANCEL")) {
                        if (intExtra != 0) {
                            DownloadNotificationService.this.b(notificationManager, intExtra);
                            return;
                        }
                        return;
                    }
                    if (!action.equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                        if (action.equals("android.intent.action.MEDIA_UNMOUNTED") || action.equals("android.intent.action.MEDIA_REMOVED") || action.equals("android.intent.action.MEDIA_BAD_REMOVAL") || action.equals("android.intent.action.MEDIA_EJECT")) {
                            try {
                                Downloader.getInstance(DownloadNotificationService.this).pauseAll();
                                return;
                            } catch (Exception e2) {
                                e2.printStackTrace();
                                return;
                            }
                        }
                        return;
                    }
                    try {
                        if (f.a((Context) DownloadNotificationService.this, "android.permission.ACCESS_NETWORK_STATE") && (connectivityManager = (ConnectivityManager) DownloadNotificationService.this.getSystemService("connectivity")) != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null && activeNetworkInfo.isConnected()) {
                            ArrayList arrayList = new ArrayList();
                            if (!TextUtils.isEmpty(e.a)) {
                                arrayList.add(e.a);
                            }
                            arrayList.add("mime_type_plg");
                            Context applicationContext = DownloadNotificationService.this.getApplicationContext();
                            if (applicationContext != null) {
                                Downloader.getInstance(applicationContext).restartAllFailedDownloadTasks(arrayList);
                                Downloader.getInstance(applicationContext).restartAllPauseReserveOnWifiDownloadTasks(arrayList);
                                return;
                            }
                            return;
                        }
                        return;
                    } catch (Exception e3) {
                        e3.printStackTrace();
                        return;
                    }
                }
                final Notification notification = (Notification) intent.getParcelableExtra("DOWNLOAD_NOTIFICATION_BUNDLE_EXTRA");
                int intExtra2 = intent.getIntExtra("DOWNLOAD_NOTIFICATION_EXTRA_STATUS", 0);
                if (intExtra == 0 || notification == null || notificationManager == null) {
                    return;
                }
                if (intExtra2 != 4) {
                    if (intExtra2 != -2 && intExtra2 != -3) {
                        if (DownloadNotificationService.f3920h) {
                            DownloadNotificationService.this.a(notificationManager, intExtra, notification);
                            return;
                        } else {
                            DownloadNotificationService.this.b(notificationManager, intExtra, notification);
                            return;
                        }
                    }
                    if (DownloadNotificationService.f3920h) {
                        DownloadNotificationService.this.a(notificationManager, intExtra, notification);
                        return;
                    } else {
                        if (DownloadNotificationService.this.f3922j != null) {
                            DownloadNotificationService.this.f3922j.a(new Runnable() { // from class: com.ss.android.socialbase.downloader.notification.DownloadNotificationService.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    DownloadNotificationService.this.b(notificationManager, intExtra, notification);
                                }
                            }, intExtra2 == -2 ? 50L : 200L);
                            return;
                        }
                        return;
                    }
                }
                if (Downloader.getInstance(c.N()).isDownloading(intExtra)) {
                    DownloadInfo downloadInfo = Downloader.getInstance(c.N()).getDownloadInfo(intExtra);
                    if (!DownloadNotificationService.f3920h) {
                        if (downloadInfo == null || !downloadInfo.canNotifyProgress()) {
                            return;
                        }
                        DownloadNotificationService.this.b(notificationManager, intExtra, notification);
                        downloadInfo.setLastNotifyProgressTime();
                        return;
                    }
                    if (downloadInfo == null || !downloadInfo.canNotifyProgress() || System.currentTimeMillis() - DownloadNotificationService.f3919g <= DownloadNotificationService.f3921i) {
                        return;
                    }
                    DownloadNotificationService.this.b(notificationManager, intExtra, notification);
                    downloadInfo.setLastNotifyProgressTime();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final NotificationManager notificationManager, final int i2, Notification notification) {
        synchronized (this.f3923k) {
            int iIndexOfKey = this.f3923k.indexOfKey(i2);
            if (iIndexOfKey >= 0 && iIndexOfKey < this.f3923k.size()) {
                this.f3923k.setValueAt(iIndexOfKey, notification);
                return;
            }
            long jCurrentTimeMillis = f3921i - (System.currentTimeMillis() - f3918f);
            if (jCurrentTimeMillis <= 0) {
                jCurrentTimeMillis = 0;
            }
            if (jCurrentTimeMillis > 20000) {
                jCurrentTimeMillis = 20000;
            }
            long jCurrentTimeMillis2 = System.currentTimeMillis() + jCurrentTimeMillis;
            f3919g = jCurrentTimeMillis2;
            f3918f = jCurrentTimeMillis2;
            if (jCurrentTimeMillis <= 0) {
                b(notificationManager, i2, notification);
            } else if (this.f3922j != null) {
                synchronized (this.f3923k) {
                    this.f3923k.put(i2, notification);
                }
                this.f3922j.a(new Runnable() { // from class: com.ss.android.socialbase.downloader.notification.DownloadNotificationService.2
                    @Override // java.lang.Runnable
                    public void run() {
                        DownloadNotificationService.this.a(notificationManager, i2);
                    }
                }, jCurrentTimeMillis);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(NotificationManager notificationManager, int i2) {
        Notification notification;
        synchronized (this.f3923k) {
            notification = this.f3923k.get(i2);
            this.f3923k.remove(i2);
        }
        if (notification != null) {
            b(notificationManager, i2, notification);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(NotificationManager notificationManager, int i2) {
        boolean z;
        a aVarValueAt;
        int iA;
        int i3 = f3914b;
        if (i3 != i2 && f3915c != i2) {
            try {
                notificationManager.cancel(i2);
                return;
            } catch (Throwable unused) {
                return;
            }
        }
        boolean z2 = true;
        if (i3 == i2) {
            f3914b = 0;
            z = false;
        } else {
            f3915c = 0;
            z = true;
        }
        try {
            m mVarC = d.a().c(i2);
            if (!mVarC.b()) {
                f3916d = false;
                com.ss.android.socialbase.downloader.c.a.d(a, "try to stopForeground when is not Foreground, id = " + i2 + ", isIndependentProcess = " + z);
            }
            com.ss.android.socialbase.downloader.c.a.c(a, "doCancel, ========== stopForeground id = " + i2 + ", isIndependentProcess = " + z);
            mVarC.a(false, true);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        try {
            notificationManager.cancel(i2);
        } catch (Throwable unused2) {
        }
        if (f3916d) {
            try {
                SparseArray<a> sparseArrayB = b.a().b();
                if (sparseArrayB != null) {
                    for (int size = sparseArrayB.size() - 1; size >= 0; size--) {
                        aVarValueAt = sparseArrayB.valueAt(size);
                        if (aVarValueAt != null && (iA = aVarValueAt.a()) != i2 && iA != f3914b && iA != f3915c && aVarValueAt.i()) {
                            if ((d.a().a(aVarValueAt.a()) == 1 && !f.c()) == z) {
                                break;
                            }
                        }
                    }
                    aVarValueAt = null;
                } else {
                    aVarValueAt = null;
                }
                if (aVarValueAt != null) {
                    int iA2 = aVarValueAt.a();
                    try {
                        notificationManager.cancel(iA2);
                    } catch (Throwable th2) {
                        th2.printStackTrace();
                    }
                    if (Downloader.getInstance(this).getStatus(iA2) != 1) {
                        z2 = false;
                    }
                    com.ss.android.socialbase.downloader.c.a.c(a, "doCancel, updateNotification id = " + iA2);
                    aVarValueAt.a((BaseException) null, z2);
                }
            } catch (Throwable th3) {
                th3.printStackTrace();
            }
        }
    }

    private boolean a(int i2, Notification notification) {
        int i3;
        int i4;
        if (!f3916d || (i3 = f3914b) == i2 || (i4 = f3915c) == i2) {
            return false;
        }
        if (i3 != 0 && i4 != 0) {
            return false;
        }
        if (f3917e && (notification.flags & 2) == 0) {
            return false;
        }
        return Build.VERSION.SDK_INT < 26 || !TextUtils.isEmpty(notification.getChannelId());
    }
}

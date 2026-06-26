package com.tencent.bugly.beta.ui;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.res.Resources;
import android.os.Build;
import androidx.core.app.NotificationCompat;
import com.tencent.bugly.beta.Beta;
import com.tencent.bugly.beta.download.BetaReceiver;
import com.tencent.bugly.beta.download.DownloadTask;
import com.tencent.bugly.beta.global.a;
import com.tencent.bugly.beta.global.e;
import com.tencent.bugly.proguard.B;
import com.tencent.bugly.proguard.X;
import java.util.Locale;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes.dex */
public class BetaNotifyManager {
    private static final String CHANNEL_DESCRIPTION = "bugly upgrade";
    private static final String CHANNEL_ID = "001";
    private static final String CHANNEL_NAME = "bugly_upgrade";
    private static final int NOTIFICATION_DOWNLOAD_ID = 1000;
    private static final int NOTIFICATION_UPGRADE_ID = 1001;
    private static final long NOTIFY_LEN = 307200;
    public static final int REQUEST_CODE_DOWNLOAD = 1;
    public static final int REQUEST_CODE_UPGRADE = 2;
    public static BetaNotifyManager instance = new BetaNotifyManager();
    public BaseFrag fragment;
    private long lastLen;
    private NotificationCompat.Builder mBuilder;
    private Notification mNotification;
    public B strategy;
    public DownloadTask task;
    private boolean hasNotification = true;
    private Context mContext = e.f3983b.v;
    public String intentFilter = this.mContext.getPackageName() + ".beta.DOWNLOAD_NOTIFY";
    private NotificationManager mManager = (NotificationManager) this.mContext.getSystemService("notification");

    private BetaNotifyManager() {
        this.mContext.registerReceiver(new BetaReceiver(), new IntentFilter(this.intentFilter));
        adaptNotificationChannel();
    }

    private void adaptNotificationChannel() {
        if (Build.VERSION.SDK_INT >= 26) {
            NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID, CHANNEL_NAME, 2);
            notificationChannel.setDescription(CHANNEL_DESCRIPTION);
            notificationChannel.enableVibration(false);
            notificationChannel.setVibrationPattern(new long[]{0});
            this.mManager.createNotificationChannel(notificationChannel);
        }
    }

    public void initNotify(DownloadTask downloadTask) {
        ApplicationInfo applicationInfo;
        this.task = downloadTask;
        this.lastLen = downloadTask.getSavedLength();
        boolean zIsNeededNotify = downloadTask.isNeededNotify();
        this.hasNotification = zIsNeededNotify;
        if (zIsNeededNotify && e.f3983b.T) {
            this.mManager.cancel(1000);
            Intent intent = new Intent(this.intentFilter);
            intent.putExtra("request", 1);
            if (this.mBuilder == null) {
                if (Build.VERSION.SDK_INT >= 26) {
                    try {
                        this.mBuilder = new NotificationCompat.Builder(this.mContext, CHANNEL_ID);
                    } catch (Throwable unused) {
                        this.mBuilder = new NotificationCompat.Builder(this.mContext);
                    }
                } else {
                    this.mBuilder = new NotificationCompat.Builder(this.mContext);
                }
            }
            NotificationCompat.Builder contentTitle = this.mBuilder.setTicker(Beta.strNotificationDownloading + e.f3983b.B).setContentTitle(e.f3983b.B);
            Locale locale = Locale.getDefault();
            Object[] objArr = new Object[2];
            objArr[0] = Beta.strNotificationDownloading;
            objArr[1] = Integer.valueOf((int) (this.task.getTotalLength() != 0 ? (this.task.getSavedLength() * 100) / this.task.getTotalLength() : 0L));
            contentTitle.setContentText(String.format(locale, "%s %d%%", objArr)).setContentIntent(PendingIntent.getBroadcast(this.mContext, 1, intent, 268435456)).setAutoCancel(false);
            e eVar = e.f3983b;
            int i2 = eVar.f3990i;
            if (i2 > 0) {
                this.mBuilder.setSmallIcon(i2);
            } else {
                PackageInfo packageInfo = eVar.C;
                if (packageInfo != null && (applicationInfo = packageInfo.applicationInfo) != null) {
                    this.mBuilder.setSmallIcon(applicationInfo.icon);
                }
            }
            try {
                if (e.f3983b.f3991j > 0 && this.mContext.getResources().getDrawable(e.f3983b.f3991j) != null) {
                    this.mBuilder.setLargeIcon(a.a(this.mContext.getResources().getDrawable(e.f3983b.f3991j)));
                }
            } catch (Resources.NotFoundException e2) {
                StringBuilder sbR = c.a.a.a.a.r("[initNotify] ");
                sbR.append(e2.getMessage());
                X.b(BetaNotifyManager.class, sbR.toString(), new Object[0]);
            }
            Notification notificationBuild = this.mBuilder.build();
            this.mNotification = notificationBuild;
            this.mManager.notify(1000, notificationBuild);
        }
    }

    public void postDownloadNotify() {
        DownloadTask downloadTask;
        if (this.hasNotification && (downloadTask = this.task) != null && e.f3983b.T) {
            if (downloadTask.getSavedLength() - this.lastLen > NOTIFY_LEN || this.task.getStatus() == 1 || this.task.getStatus() == 5 || this.task.getStatus() == 3) {
                this.lastLen = this.task.getSavedLength();
                if (this.task.getStatus() == 1) {
                    this.mBuilder.setAutoCancel(true).setContentText(Beta.strNotificationClickToInstall).setContentTitle(String.format("%s %s", e.f3983b.B, Beta.strNotificationDownloadSucc));
                } else if (this.task.getStatus() == 5) {
                    this.mBuilder.setAutoCancel(false).setContentText(Beta.strNotificationClickToRetry).setContentTitle(String.format("%s %s", e.f3983b.B, Beta.strNotificationDownloadError));
                } else {
                    if (this.task.getStatus() == 2) {
                        NotificationCompat.Builder contentTitle = this.mBuilder.setContentTitle(e.f3983b.B);
                        Locale locale = Locale.getDefault();
                        Object[] objArr = new Object[2];
                        objArr[0] = Beta.strNotificationDownloading;
                        objArr[1] = Integer.valueOf((int) (this.task.getTotalLength() != 0 ? (this.task.getSavedLength() * 100) / this.task.getTotalLength() : 0L));
                        contentTitle.setContentText(String.format(locale, "%s %d%%", objArr)).setAutoCancel(false);
                    } else if (this.task.getStatus() == 3) {
                        NotificationCompat.Builder contentTitle2 = this.mBuilder.setContentTitle(e.f3983b.B);
                        Locale locale2 = Locale.getDefault();
                        Object[] objArr2 = new Object[2];
                        objArr2[0] = Beta.strNotificationClickToContinue;
                        objArr2[1] = Integer.valueOf((int) (this.task.getTotalLength() != 0 ? (this.task.getSavedLength() * 100) / this.task.getTotalLength() : 0L));
                        contentTitle2.setContentText(String.format(locale2, "%s %d%%", objArr2)).setAutoCancel(false);
                    }
                }
                Notification notificationBuild = this.mBuilder.build();
                this.mNotification = notificationBuild;
                this.mManager.notify(1000, notificationBuild);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x00a4 A[Catch: all -> 0x00f5, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x001d, B:13:0x0039, B:12:0x002f, B:14:0x0042, B:16:0x00a4, B:22:0x00b9, B:24:0x00bf, B:26:0x00cf, B:27:0x00e6, B:17:0x00aa, B:19:0x00ae, B:21:0x00b2, B:8:0x0023, B:10:0x0029), top: B:33:0x0001, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00aa A[Catch: all -> 0x00f5, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x001d, B:13:0x0039, B:12:0x002f, B:14:0x0042, B:16:0x00a4, B:22:0x00b9, B:24:0x00bf, B:26:0x00cf, B:27:0x00e6, B:17:0x00aa, B:19:0x00ae, B:21:0x00b2, B:8:0x0023, B:10:0x0029), top: B:33:0x0001, inners: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized void postUpgradeNotify(com.tencent.bugly.proguard.B r8, com.tencent.bugly.beta.ui.BaseFrag r9) {
        /*
            Method dump skipped, instruction units count: 248
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.beta.ui.BetaNotifyManager.postUpgradeNotify(com.tencent.bugly.proguard.B, com.tencent.bugly.beta.ui.BaseFrag):void");
    }
}

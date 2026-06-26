package com.ss.android.socialbase.appdownloader;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.os.IBinder;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.ss.android.socialbase.appdownloader.view.DownloadTaskDeleteActivity;
import com.ss.android.socialbase.downloader.depend.af;
import com.ss.android.socialbase.downloader.depend.z;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.File;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class DownloadHandlerService extends Service {
    private static final String a = DownloadHandlerService.class.getSimpleName();

    private boolean a(Intent intent) {
        if (intent == null) {
            return false;
        }
        String action = intent.getAction();
        if (TextUtils.isEmpty(action)) {
            return false;
        }
        int intExtra = intent.getIntExtra("extra_click_download_ids", 0);
        intent.getIntExtra("extra_click_download_type", 0);
        com.ss.android.socialbase.appdownloader.c.d dVarB = d.j().b();
        z downloadNotificationEventListener = Downloader.getInstance(this).getDownloadNotificationEventListener(intExtra);
        if (intent.getBooleanExtra("extra_from_notification", false) && com.ss.android.socialbase.downloader.g.a.a(intExtra).b("notification_opt_2") == 1) {
            com.ss.android.socialbase.downloader.notification.b.a().f(intExtra);
        }
        DownloadInfo downloadInfo = Downloader.getInstance(this).getDownloadInfo(intExtra);
        if (downloadInfo == null) {
            return false;
        }
        if (action.equals("android.ss.intent.action.DOWNLOAD_CLICK_CONTENT")) {
            a(downloadInfo, dVarB, downloadNotificationEventListener);
        } else if (action.equals("android.ss.intent.action.DOWNLOAD_OPEN")) {
            a(this, downloadInfo, dVarB, downloadNotificationEventListener);
        } else if (action.equals("android.ss.intent.action.DOWNLOAD_CLICK_BTN")) {
            if (downloadInfo.getStatus() == 0) {
                return false;
            }
            a(this, downloadInfo, dVarB, downloadNotificationEventListener);
            if (downloadInfo.isDownloadOverStatus() && com.ss.android.socialbase.downloader.g.a.a(intExtra).a("no_hide_notification", 0) == 0) {
                if (!(com.ss.android.socialbase.downloader.g.a.a(intExtra).b("enable_notification_ui") >= 2 && downloadInfo.getStatus() == -1)) {
                    com.ss.android.socialbase.downloader.notification.b.a().a(intExtra);
                    com.ss.android.socialbase.downloader.notification.b.a().f(intExtra);
                }
            }
        } else if (action.equals("android.ss.intent.action.DOWNLOAD_DELETE")) {
            b(downloadInfo, dVarB, downloadNotificationEventListener);
        } else if (action.equals("android.ss.intent.action.DOWNLOAD_HIDE")) {
            com.ss.android.socialbase.downloader.notification.b.a().a(intExtra);
        } else if (action.equals("android.intent.action.BOOT_COMPLETED") || action.equals("android.intent.action.MEDIA_MOUNTED")) {
            com.ss.android.socialbase.downloader.downloader.c.l().execute(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.DownloadHandlerService.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(AdBaseConstants.MIME_APK);
                        arrayList.add("mime_type_plg");
                        Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.c.N()).restartAllFailedDownloadTasks(arrayList);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            });
            return true;
        }
        return false;
    }

    private void b(@NonNull DownloadInfo downloadInfo, com.ss.android.socialbase.appdownloader.c.d dVar, z zVar) {
        int id = downloadInfo.getId();
        Intent intent = new Intent(this, (Class<?>) DownloadTaskDeleteActivity.class);
        intent.putExtra("extra_click_download_ids", id);
        intent.addFlags(268435456);
        startActivity(intent);
        com.ss.android.socialbase.downloader.notification.b.a().a(id);
        downloadInfo.updateDownloadTime();
        if (dVar != null) {
            dVar.a(id, 7, "", downloadInfo.getStatus(), downloadInfo.getDownloadTime());
        }
        if (zVar != null) {
            zVar.a(7, downloadInfo, "", "");
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        com.ss.android.socialbase.downloader.downloader.c.a(this);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i2, int i3) {
        super.onStartCommand(intent, i2, i3);
        if (com.ss.android.socialbase.downloader.c.a.a()) {
            com.ss.android.socialbase.downloader.c.a.b(a, "onStartCommand");
        }
        a(intent);
        stopSelf();
        return 2;
    }

    private static void a(Context context, DownloadInfo downloadInfo) {
        if (com.ss.android.socialbase.downloader.i.f.b(context.getApplicationContext()) && downloadInfo.isPauseReserveOnWifi()) {
            downloadInfo.stopPauseReserveOnWifi();
        }
    }

    private static void a(Context context, final com.ss.android.socialbase.appdownloader.c.d dVar, final DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return;
        }
        final z downloadNotificationEventListener = Downloader.getInstance(context).getDownloadNotificationEventListener(downloadInfo.getId());
        if (dVar == null && downloadNotificationEventListener == null) {
            return;
        }
        com.ss.android.socialbase.downloader.downloader.c.l().execute(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.DownloadHandlerService.2
            @Override // java.lang.Runnable
            public void run() {
                File file;
                PackageInfo packageInfoA;
                try {
                    file = new File(downloadInfo.getSavePath(), downloadInfo.getName());
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                if (file.exists()) {
                    try {
                        String str = (com.ss.android.socialbase.downloader.downloader.c.N() == null || (packageInfoA = c.a(downloadInfo, file)) == null) ? "" : packageInfoA.packageName;
                        com.ss.android.socialbase.appdownloader.c.d dVar2 = dVar;
                        if (dVar2 != null) {
                            dVar2.a(downloadInfo.getId(), 3, str, -3, downloadInfo.getDownloadTime());
                        }
                        z zVar = downloadNotificationEventListener;
                        if (zVar != null) {
                            zVar.a(3, downloadInfo, str, "");
                            return;
                        }
                        return;
                    } catch (Exception e3) {
                        e3.printStackTrace();
                        return;
                    }
                    e2.printStackTrace();
                }
            }
        });
    }

    private void a(@NonNull DownloadInfo downloadInfo, com.ss.android.socialbase.appdownloader.c.d dVar, z zVar) {
        boolean zA;
        int id = downloadInfo.getId();
        af afVarM = com.ss.android.socialbase.downloader.downloader.d.a().m(id);
        if (afVarM != null) {
            try {
                zA = afVarM.a(downloadInfo);
            } catch (Throwable th) {
                th.printStackTrace();
                zA = false;
            }
        } else {
            zA = false;
        }
        if (zA) {
            return;
        }
        Intent intent = new Intent(this, (Class<?>) DownloadTaskDeleteActivity.class);
        intent.putExtra("extra_click_download_ids", id);
        intent.addFlags(268435456);
        startActivity(intent);
        com.ss.android.socialbase.downloader.notification.b.a().a(id);
        downloadInfo.updateDownloadTime();
        if (dVar != null) {
            dVar.a(id, 7, "", downloadInfo.getStatus(), downloadInfo.getDownloadTime());
        }
        if (zVar != null) {
            zVar.a(7, downloadInfo, "", "");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0020  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void a(android.content.Context r2, int r3, boolean r4) {
        /*
            r0 = 0
            if (r4 == 0) goto L20
            com.ss.android.socialbase.downloader.downloader.d r4 = com.ss.android.socialbase.downloader.downloader.d.a()
            com.ss.android.socialbase.downloader.depend.af r4 = r4.m(r3)
            if (r4 == 0) goto L20
            com.ss.android.socialbase.downloader.downloader.Downloader r1 = com.ss.android.socialbase.downloader.downloader.Downloader.getInstance(r2)     // Catch: java.lang.Throwable -> L1c
            com.ss.android.socialbase.downloader.model.DownloadInfo r1 = r1.getDownloadInfo(r3)     // Catch: java.lang.Throwable -> L1c
            if (r1 == 0) goto L20
            boolean r4 = r4.b(r1)     // Catch: java.lang.Throwable -> L1c
            goto L21
        L1c:
            r4 = move-exception
            r4.printStackTrace()
        L20:
            r4 = 0
        L21:
            if (r4 == 0) goto L24
            return
        L24:
            r4 = 1
            int r3 = com.ss.android.socialbase.appdownloader.c.a(r2, r3, r4)
            if (r3 != 0) goto L34
            java.lang.String r3 = "Open Fail!"
            android.widget.Toast r2 = android.widget.Toast.makeText(r2, r3, r0)
            r2.show()
        L34:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.appdownloader.DownloadHandlerService.a(android.content.Context, int, boolean):void");
    }

    public static void a(Context context, DownloadInfo downloadInfo, com.ss.android.socialbase.appdownloader.c.d dVar, z zVar) {
        com.ss.android.socialbase.downloader.notification.a aVarE;
        int id = downloadInfo.getId();
        af afVarM = com.ss.android.socialbase.downloader.downloader.d.a().m(id);
        if (AdBaseConstants.MIME_APK.equals(downloadInfo.getMimeType()) && afVarM != null && c.a(context, downloadInfo) && afVarM.c(downloadInfo)) {
        }
        boolean z = false;
        switch (downloadInfo.getStatus()) {
            case -4:
            case -1:
                if (com.ss.android.socialbase.downloader.g.a.a(id).b("enable_notification_ui") >= 2 && downloadInfo.isOnlyWifi()) {
                    downloadInfo.setOnlyWifi(false);
                }
                Downloader.getInstance(context).restart(id);
                break;
            case -3:
                a(com.ss.android.socialbase.downloader.downloader.c.N(), id, true);
                a(context, dVar, downloadInfo);
                if (com.ss.android.socialbase.downloader.g.a.a(id).a("notification_click_install_auto_cancel", 1) != 0 || (aVarE = com.ss.android.socialbase.downloader.notification.b.a().e(id)) == null) {
                    z = true;
                } else {
                    aVarE.g();
                    aVarE.a(-3, null, false, true);
                }
                if (z) {
                    com.ss.android.socialbase.downloader.notification.b.a().a(id);
                }
                break;
            case -2:
                if (com.ss.android.socialbase.downloader.downloader.d.a().e(id)) {
                    Downloader.getInstance(context).resume(id);
                } else {
                    c.a(downloadInfo, true, false);
                }
                if (dVar != null) {
                    dVar.a(id, 6, "", downloadInfo.getStatus(), downloadInfo.getDownloadTime());
                }
                if (zVar != null) {
                    zVar.a(6, downloadInfo, "", "");
                }
                break;
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                Downloader.getInstance(context).pause(id);
                a(context, downloadInfo);
                if (dVar != null) {
                    dVar.a(id, 5, "", downloadInfo.getStatus(), downloadInfo.getDownloadTime());
                }
                if (zVar != null) {
                    zVar.a(5, downloadInfo, "", "");
                }
                break;
        }
    }
}

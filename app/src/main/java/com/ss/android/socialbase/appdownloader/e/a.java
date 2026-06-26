package com.ss.android.socialbase.appdownloader.e;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.widget.RemoteViews;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.ss.android.socialbase.appdownloader.DownloadHandlerService;
import com.ss.android.socialbase.appdownloader.e;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* JADX INFO: compiled from: AppNotificationItem.java */
/* JADX INFO: loaded from: classes.dex */
public class a extends com.ss.android.socialbase.downloader.notification.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f3345b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Resources f3346c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f3347d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f3348e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f3349f;

    public a(Context context, int i2, String str, String str2, String str3, String str4) {
        super(i2, str);
        this.f3348e = str2;
        this.f3347d = str3;
        this.f3349f = str4;
        Context applicationContext = context.getApplicationContext();
        this.f3345b = applicationContext;
        this.f3346c = applicationContext.getResources();
    }

    /* JADX WARN: Removed duplicated region for block: B:175:0x04c8  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x04d0  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x04f5  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x050b  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x054f  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x0553  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x055d  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x0588  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x058e  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x0598  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x05b0  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x05b7  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x05c1  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0137  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private android.app.Notification b(com.ss.android.socialbase.downloader.exception.BaseException r26, boolean r27) {
        /*
            Method dump skipped, instruction units count: 1479
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.appdownloader.e.a.b(com.ss.android.socialbase.downloader.exception.BaseException, boolean):android.app.Notification");
    }

    private RemoteViews j() {
        RemoteViews remoteViews = new RemoteViews(this.f3345b.getPackageName(), e.a());
        try {
            if (com.ss.android.socialbase.appdownloader.c.a(this.f3345b)) {
                remoteViews.setInt(e.f(), "setBackgroundColor", this.f3345b.getResources().getColor(e.r()));
            }
        } catch (Throwable unused) {
        }
        return remoteViews;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:13:0x0044
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1182)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    private androidx.core.app.NotificationCompat.Builder k() {
        /*
            r3 = this;
            com.ss.android.socialbase.appdownloader.d r0 = com.ss.android.socialbase.appdownloader.d.j()
            java.lang.String r0 = r0.i()
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 26
            if (r1 >= r2) goto L16
            androidx.core.app.NotificationCompat$Builder r0 = new androidx.core.app.NotificationCompat$Builder
            android.content.Context r1 = r3.f3345b
            r0.<init>(r1)
            goto L4b
        L16:
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 == 0) goto L22
            android.content.Context r0 = r3.f3345b
            java.lang.String r0 = com.ss.android.socialbase.appdownloader.c.b(r0)
        L22:
            com.ss.android.socialbase.appdownloader.d r1 = com.ss.android.socialbase.appdownloader.d.j()     // Catch: java.lang.NoSuchMethodError -> L44
            com.ss.android.socialbase.appdownloader.c.m r1 = r1.k()     // Catch: java.lang.NoSuchMethodError -> L44
            if (r1 == 0) goto L3b
            com.ss.android.socialbase.appdownloader.d r1 = com.ss.android.socialbase.appdownloader.d.j()     // Catch: java.lang.NoSuchMethodError -> L44
            com.ss.android.socialbase.appdownloader.c.m r1 = r1.k()     // Catch: java.lang.NoSuchMethodError -> L44
            android.content.Context r2 = r3.f3345b     // Catch: java.lang.NoSuchMethodError -> L44
            androidx.core.app.NotificationCompat$Builder r0 = r1.a(r2, r0)     // Catch: java.lang.NoSuchMethodError -> L44
            goto L4b
        L3b:
            androidx.core.app.NotificationCompat$Builder r1 = new androidx.core.app.NotificationCompat$Builder     // Catch: java.lang.NoSuchMethodError -> L44
            android.content.Context r2 = r3.f3345b     // Catch: java.lang.NoSuchMethodError -> L44
            r1.<init>(r2, r0)     // Catch: java.lang.NoSuchMethodError -> L44
            r0 = r1
            goto L4b
        L44:
            androidx.core.app.NotificationCompat$Builder r0 = new androidx.core.app.NotificationCompat$Builder
            android.content.Context r1 = r3.f3345b
            r0.<init>(r1)
        L4b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.appdownloader.e.a.k():androidx.core.app.NotificationCompat$Builder");
    }

    @Override // com.ss.android.socialbase.downloader.notification.a
    public void a(DownloadInfo downloadInfo) {
        super.a(downloadInfo);
        this.f3348e = downloadInfo.getSavePath();
        this.f3347d = downloadInfo.getName();
        this.f3349f = downloadInfo.getExtra();
    }

    @Override // com.ss.android.socialbase.downloader.notification.a
    public void a(BaseException baseException, boolean z) {
        if (this.f3345b == null) {
            return;
        }
        try {
            Notification notificationB = b(baseException, z);
            this.a = notificationB;
            a(notificationB);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private boolean a(BaseException baseException, com.ss.android.socialbase.downloader.g.a aVar, DownloadInfo downloadInfo) {
        return baseException != null && (baseException.getErrorCode() == 1013 || baseException.getErrorCode() == 1049) && downloadInfo != null && AdBaseConstants.MIME_APK.contains(downloadInfo.getMimeType()) && aVar.a("notification_text_opt", 0) == 1;
    }

    private int a(int i2, int i3) {
        if (com.ss.android.socialbase.downloader.g.a.a(i3).b("notification_opt_2") == 1) {
            return e.v();
        }
        if (i2 == 1 || i2 == 4) {
            return e.t();
        }
        if (i2 == 2) {
            return e.u();
        }
        if (i2 == 3) {
            return e.v();
        }
        return 0;
    }

    private PendingIntent a(String str, int i2, int i3) {
        Intent intent = new Intent(this.f3345b, (Class<?>) DownloadHandlerService.class);
        intent.setAction(str);
        intent.putExtra("extra_click_download_ids", i3);
        intent.putExtra("extra_click_download_type", i2);
        intent.putExtra("extra_from_notification", true);
        return PendingIntent.getService(this.f3345b, i3, intent, 134217728);
    }

    private int a(int i2) {
        if (com.ss.android.socialbase.downloader.g.a.a(i2).b("enable_notification_ui") >= 1) {
            return e.h();
        }
        return e.g();
    }
}

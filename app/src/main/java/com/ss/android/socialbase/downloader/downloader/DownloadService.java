package com.ss.android.socialbase.downloader.downloader;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes.dex */
public class DownloadService extends Service {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f3544b = DownloadService.class.getSimpleName();
    public o a;

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        String str = f3544b;
        StringBuilder sbR = c.a.a.a.a.r("onBind downloadServiceHandler != null:");
        sbR.append(this.a != null);
        com.ss.android.socialbase.downloader.c.a.b(str, sbR.toString());
        o oVar = this.a;
        if (oVar != null) {
            return oVar.a(intent);
        }
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        c.a(this);
        o oVarY = c.y();
        this.a = oVarY;
        oVarY.a(new WeakReference(this));
    }

    @Override // android.app.Service
    public void onDestroy() {
        if (com.ss.android.socialbase.downloader.c.a.a()) {
            com.ss.android.socialbase.downloader.c.a.b(f3544b, "Service onDestroy");
        }
        o oVar = this.a;
        if (oVar != null) {
            oVar.d();
            this.a = null;
        }
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(final Intent intent, final int i2, final int i3) {
        if (com.ss.android.socialbase.downloader.c.a.a()) {
            com.ss.android.socialbase.downloader.c.a.b(f3544b, "DownloadService onStartCommand");
        }
        this.a.c();
        ExecutorService executorServiceL = c.l();
        if (executorServiceL != null) {
            executorServiceL.execute(new Runnable() { // from class: com.ss.android.socialbase.downloader.downloader.DownloadService.1
                @Override // java.lang.Runnable
                public void run() {
                    o oVar = DownloadService.this.a;
                    if (oVar != null) {
                        oVar.a(intent, i2, i3);
                    }
                }
            });
        }
        return c.j() ? 2 : 3;
    }
}

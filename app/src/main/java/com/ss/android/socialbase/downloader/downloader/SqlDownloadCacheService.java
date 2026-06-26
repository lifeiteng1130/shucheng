package com.ss.android.socialbase.downloader.downloader;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.IBinder;

/* JADX INFO: loaded from: classes.dex */
public class SqlDownloadCacheService extends Service {
    private static final String a = SqlDownloadCacheService.class.getSimpleName();

    public static void a(Context context, ServiceConnection serviceConnection) {
        if (context != null) {
            try {
                Intent intent = new Intent(context, (Class<?>) SqlDownloadCacheService.class);
                if (serviceConnection != null) {
                    context.bindService(intent, serviceConnection, 1);
                }
                context.startService(intent);
            } catch (Throwable unused) {
            }
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        j jVarX = c.x();
        t tVarF = jVarX instanceof com.ss.android.socialbase.downloader.impls.d ? ((com.ss.android.socialbase.downloader.impls.d) jVarX).f() : jVarX instanceof t ? (t) jVarX : null;
        return tVarF instanceof IBinder ? (IBinder) tVarF : new Binder();
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        c.a(getApplicationContext());
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i2, int i3) {
        int iOnStartCommand = super.onStartCommand(intent, i2, i3);
        if (c.j()) {
            return 2;
        }
        return iOnStartCommand;
    }
}

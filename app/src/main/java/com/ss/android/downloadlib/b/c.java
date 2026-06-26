package com.ss.android.downloadlib.b;

import android.os.Build;
import androidx.annotation.NonNull;
import com.ss.android.downloadlib.g.l;
import com.ss.android.socialbase.downloader.a.a;

/* JADX INFO: compiled from: AppInstallOptimiseHelper.java */
/* JADX INFO: loaded from: classes.dex */
public class c {
    public static void a(final com.ss.android.downloadad.api.a.b bVar, @NonNull final com.ss.android.downloadlib.guide.install.a aVar) {
        boolean zB = com.ss.android.socialbase.downloader.a.a.a().b();
        if (!zB && Build.VERSION.SDK_INT >= 29) {
            l.b();
        }
        boolean zB2 = com.ss.android.socialbase.downloader.a.a.a().b();
        if (!zB && zB2 && bVar != null) {
            bVar.l(true);
        }
        aVar.a();
        com.ss.android.socialbase.downloader.c.a.b("AppInstallOptimiseHelper", "AppInstallOptimiseHelper-->isAppForegroundSecond:::" + zB2);
        if (zB2) {
            return;
        }
        com.ss.android.socialbase.downloader.a.a.a().a(new a.InterfaceC0092a() { // from class: com.ss.android.downloadlib.b.c.1
            @Override // com.ss.android.socialbase.downloader.a.a.InterfaceC0092a
            public void b() {
                com.ss.android.socialbase.downloader.c.a.b("AppInstallOptimiseHelper", "AppInstallOptimiseHelper-->onAppForeground");
                com.ss.android.socialbase.downloader.a.a.a().b(this);
                if (l.b(bVar)) {
                    return;
                }
                bVar.m(true);
                com.ss.android.downloadlib.d.a.a().a("install_delay_invoke", bVar);
                aVar.a();
            }

            @Override // com.ss.android.socialbase.downloader.a.a.InterfaceC0092a
            public void c() {
            }
        });
    }
}

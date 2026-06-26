package com.ss.android.downloadlib.b;

import androidx.camera.core.FocusMeteringAction;
import com.ss.android.socialbase.downloader.a.a;

/* JADX INFO: compiled from: AppLinkMonitor.java */
/* JADX INFO: loaded from: classes.dex */
public class e implements a.InterfaceC0092a {
    private long a;

    /* JADX INFO: compiled from: AppLinkMonitor.java */
    public static class a {
        private static e a = new e();
    }

    @Override // com.ss.android.socialbase.downloader.a.a.InterfaceC0092a
    public void b() {
        this.a = System.currentTimeMillis();
    }

    @Override // com.ss.android.socialbase.downloader.a.a.InterfaceC0092a
    public void c() {
    }

    private e() {
        this.a = 0L;
        com.ss.android.socialbase.downloader.a.a.a().a(this);
    }

    public static e a() {
        return a.a;
    }

    public void b(d dVar) {
        if (dVar == null) {
            return;
        }
        a(dVar, com.ss.android.downloadlib.addownload.j.i().optInt("check_an_result_delay", 1200) > 0 ? r1 : 1200);
    }

    public void a(final d dVar, final long j2) {
        if (dVar == null) {
            return;
        }
        com.ss.android.downloadlib.d.a().a(new Runnable() { // from class: com.ss.android.downloadlib.b.e.1
            @Override // java.lang.Runnable
            public void run() {
                if (!com.ss.android.socialbase.downloader.a.a.a().c() || System.currentTimeMillis() - e.this.a <= j2) {
                    dVar.a(true);
                } else {
                    dVar.a(false);
                }
            }
        }, j2);
    }

    public void a(d dVar) {
        a(dVar, FocusMeteringAction.DEFAULT_AUTOCANCEL_DURATION);
    }
}

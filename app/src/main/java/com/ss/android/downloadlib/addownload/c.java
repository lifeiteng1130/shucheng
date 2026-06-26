package com.ss.android.downloadlib.addownload;

import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import j$.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: AdQuickAppManager.java */
/* JADX INFO: loaded from: classes.dex */
public class c {
    private static String a = "c";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile c f3063b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ConcurrentHashMap<Long, Runnable> f3064c;

    public c() {
        this.f3064c = null;
        this.f3064c = new ConcurrentHashMap<>();
    }

    public static c a() {
        if (f3063b == null) {
            synchronized (c.class) {
                if (f3063b == null) {
                    f3063b = new c();
                }
            }
        }
        return f3063b;
    }

    public long b() {
        return j.i().optLong("quick_app_check_internal", 1200L);
    }

    public void a(e eVar, boolean z, int i2, DownloadModel downloadModel) {
        if (downloadModel instanceof AdDownloadModel) {
            ((AdDownloadModel) downloadModel).setFunnelType(3);
        }
        long id = downloadModel.getId();
        if (i2 == 4) {
            if (!z) {
                a(id, false, 2);
                eVar.b(false);
                return;
            } else {
                a(id, true, 2);
                return;
            }
        }
        if (i2 == 5) {
            if (!z) {
                a(id, false, 1);
                eVar.c(false);
                return;
            } else {
                a(id, true, 1);
                return;
            }
        }
        if (i2 != 7) {
            return;
        }
        Runnable runnable = (Runnable) this.f3064c.remove(Long.valueOf(id));
        if (z) {
            com.ss.android.downloadlib.d.a.a().a(id, 1);
            a(id, true, 1);
        } else {
            if (runnable != null) {
                com.ss.android.downloadlib.f.a().b().post(runnable);
            }
            a(id, false, 1);
        }
    }

    private void a(long j2, boolean z, int i2) {
        com.ss.android.downloadlib.d.a.a().a(j2, z, i2);
        if (z) {
            j.t().a(null, null, null, null, null, 3);
        }
    }

    public void a(final e eVar, final int i2, final DownloadModel downloadModel) {
        com.ss.android.downloadlib.b.e.a().a(new com.ss.android.downloadlib.b.d() { // from class: com.ss.android.downloadlib.addownload.c.1
            @Override // com.ss.android.downloadlib.b.d
            public void a(boolean z) {
                c.this.a(eVar, z, i2, downloadModel);
            }
        }, b());
    }

    public static boolean a(DownloadInfo downloadInfo) {
        return downloadInfo == null || downloadInfo.getStatus() == 0 || downloadInfo.getStatus() == -4;
    }
}

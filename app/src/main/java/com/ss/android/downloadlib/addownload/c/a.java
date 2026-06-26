package com.ss.android.downloadlib.addownload.c;

import androidx.camera.core.FocusMeteringAction;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.ss.android.downloadlib.addownload.j;
import com.ss.android.downloadlib.g.k;
import com.ss.android.downloadlib.g.l;
import com.ss.android.socialbase.downloader.depend.q;
import com.ss.android.socialbase.downloader.depend.r;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* JADX INFO: compiled from: AppDownloadDiskSpaceHandler.java */
/* JADX INFO: loaded from: classes.dex */
public class a implements r {
    private int a;

    private long b(com.ss.android.socialbase.downloader.g.a aVar) {
        long jA = aVar.a("clear_space_sleep_time", 0L);
        if (jA <= 0) {
            return 0L;
        }
        if (jA > FocusMeteringAction.DEFAULT_AUTOCANCEL_DURATION) {
            jA = 5000;
        }
        k.b("AppDownloadDiskSpaceHandler", "waiting for space clear, sleepTime = " + jA, null);
        try {
            Thread.sleep(jA);
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        }
        k.b("AppDownloadDiskSpaceHandler", "waiting end!", null);
        return jA;
    }

    public void a(int i2) {
        this.a = i2;
    }

    @Override // com.ss.android.socialbase.downloader.depend.r
    public boolean a(long j2, long j3, q qVar) {
        long j4;
        com.ss.android.socialbase.downloader.g.a aVarA = com.ss.android.socialbase.downloader.g.a.a(this.a);
        if (!a(aVarA)) {
            return false;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        d.a().c();
        long jA = l.a(0L);
        a();
        long jA2 = l.a(0L);
        long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
        if (jA2 < j3) {
            long jB = b(aVarA);
            if (jB > 0) {
                jA2 = l.a(0L);
            }
            j4 = jB;
        } else {
            j4 = 0;
        }
        k.b("AppDownloadDiskSpaceHandler", "cleanUpDisk, byteRequired = " + j3 + ", byteAvailableAfter = " + jA2 + ", cleaned = " + (jA2 - jA), null);
        long j5 = jA2;
        a(jA, jA2, j3, jCurrentTimeMillis2, j4);
        if (j5 < j3) {
            return false;
        }
        if (qVar == null) {
            return true;
        }
        qVar.a();
        return true;
    }

    private boolean a(com.ss.android.socialbase.downloader.g.a aVar) {
        if (aVar.a("clear_space_use_disk_handler", 0) != 1) {
            return false;
        }
        return System.currentTimeMillis() - d.a().b() >= aVar.a("clear_space_min_time_interval", TTAdConstant.AD_MAX_EVENT_TIME);
    }

    private void a() {
        com.ss.android.download.api.config.e eVarO = j.o();
        if (eVarO != null) {
            eVarO.a();
        }
        c.a();
        c.b();
    }

    private void a(long j2, long j3, long j4, long j5, long j6) {
        DownloadInfo downloadInfo = Downloader.getInstance(j.getContext()).getDownloadInfo(this.a);
        if (downloadInfo == null) {
            return;
        }
        try {
            com.ss.android.downloadlib.a.a().a(downloadInfo, j2, j3, j4, j5, j6, j3 > j4);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}

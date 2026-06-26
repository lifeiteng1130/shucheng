package com.ss.android.downloadlib;

import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.qq.e.comm.constants.ErrorCode;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.downloadlib.addownload.j;
import com.ss.android.downloadlib.g.k;
import com.ss.android.downloadlib.g.l;
import com.ss.android.socialbase.appdownloader.c.h;
import com.ss.android.socialbase.downloader.a.a;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import org.json.JSONObject;

/* JADX INFO: compiled from: BaseDownloadMonitorListener.java */
/* JADX INFO: loaded from: classes.dex */
public class c implements h {
    private static String a = "c";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Handler f3191b = new Handler(Looper.getMainLooper());

    @Override // com.ss.android.socialbase.appdownloader.c.h
    public void a(DownloadInfo downloadInfo, BaseException baseException, int i2) {
        final DownloadModel downloadModelA;
        if (downloadInfo == null) {
            return;
        }
        if (i2 == -1 && baseException != null) {
            JSONObject jSONObject = new JSONObject();
            com.ss.android.downloadlib.g.f.c(downloadInfo, jSONObject);
            a.a(jSONObject, downloadInfo);
            k.a("download_failed", jSONObject.toString());
        }
        com.ss.android.downloadad.api.a.b bVarA = com.ss.android.downloadlib.addownload.b.f.a().a(downloadInfo);
        if (bVarA == null) {
            return;
        }
        try {
            if (i2 != -1) {
                if (i2 == -3) {
                    a.a(downloadInfo, bVarA);
                    return;
                }
                if (i2 == 2001) {
                    a.a().a(downloadInfo, bVarA, ErrorCode.INIT_ERROR);
                    return;
                } else {
                    if (i2 == 11) {
                        a.a().a(downloadInfo, bVarA, RecyclerView.MAX_SCROLL_DURATION);
                        if (bVarA.S()) {
                            return;
                        }
                        a(downloadInfo, bVarA);
                        return;
                    }
                    return;
                }
            }
            BaseException baseException2 = null;
            if (baseException != null) {
                if (com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId()).a("toast_without_network", 0) == 1 && baseException.getErrorCode() == 1049) {
                    this.f3191b.post(new Runnable() { // from class: com.ss.android.downloadlib.c.1
                        @Override // java.lang.Runnable
                        public void run() {
                            j.c().a(5, j.getContext(), null, "无网络，请检查网络设置", null, 0);
                        }
                    });
                }
                if (com.ss.android.socialbase.downloader.i.f.h(baseException)) {
                    if (j.l() != null) {
                        j.l().a(bVarA.b());
                    }
                    com.ss.android.downloadlib.d.a.a().a("download_failed_for_space", bVarA);
                    if (!bVarA.Q()) {
                        com.ss.android.downloadlib.d.a.a().a("download_can_restart", bVarA);
                        a(downloadInfo);
                    }
                    if ((j.l() == null || !j.l().d()) && (downloadModelA = com.ss.android.downloadlib.addownload.b.f.a().a(bVarA.b())) != null && downloadModelA.isShowToast()) {
                        final com.ss.android.socialbase.downloader.g.a aVarA = com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId());
                        if (aVarA.a("show_no_enough_space_toast", 0) == 1) {
                            this.f3191b.post(new Runnable() { // from class: com.ss.android.downloadlib.c.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    j.c().a(2, j.getContext(), downloadModelA, aVarA.a("no_enough_space_toast_text", "您的存储空间不足，请清理后再试"), null, 0);
                                }
                            });
                        }
                    }
                }
                baseException2 = new BaseException(baseException.getErrorCode(), l.a(baseException.getMessage(), j.i().optInt("exception_msg_length", 500)));
            }
            com.ss.android.downloadlib.d.a.a().b(downloadInfo, baseException2);
            f.a().a(downloadInfo, baseException, "");
        } catch (Exception e2) {
            j.s().a(e2, "onAppDownloadMonitorSend");
        }
    }

    private void a(final DownloadInfo downloadInfo, final com.ss.android.downloadad.api.a.b bVar) {
        final long jA = l.a(Environment.getDataDirectory(), -1L);
        long jMin = Math.min(524288000L, l.a(Environment.getDataDirectory()) / 10);
        final long totalBytes = downloadInfo.getTotalBytes();
        final double d2 = (totalBytes * 2.5d) + jMin;
        if (jA > -1 && totalBytes > -1) {
            double d3 = jA;
            if (d3 < d2 && d2 - d3 > com.ss.android.downloadlib.addownload.d.b()) {
                com.ss.android.downloadlib.addownload.d.a(downloadInfo.getId());
            }
        }
        com.ss.android.socialbase.downloader.a.a.a().a(new a.InterfaceC0092a() { // from class: com.ss.android.downloadlib.c.3
            @Override // com.ss.android.socialbase.downloader.a.a.InterfaceC0092a
            public void b() {
                if (l.b(bVar)) {
                    com.ss.android.socialbase.downloader.a.a.a().b(this);
                    return;
                }
                long j2 = jA;
                if (j2 <= -1 || totalBytes <= -1 || j2 >= d2) {
                    return;
                }
                com.ss.android.downloadlib.d.a.a().a("clean_space_install", com.ss.android.downloadlib.addownload.d.a("install_no_enough_space"), bVar);
                if (com.ss.android.downloadlib.addownload.d.a(downloadInfo, ((long) d2) - jA)) {
                    com.ss.android.socialbase.downloader.a.a.a().b(this);
                    bVar.g(true);
                }
            }

            @Override // com.ss.android.socialbase.downloader.a.a.InterfaceC0092a
            public void c() {
            }
        });
    }

    private void a(@NonNull DownloadInfo downloadInfo) {
        if (com.ss.android.downloadlib.g.e.f(downloadInfo.getId())) {
            d.a().b(new com.ss.android.downloadlib.addownload.c.b(downloadInfo));
        }
    }
}

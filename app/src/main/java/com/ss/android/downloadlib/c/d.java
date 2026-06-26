package com.ss.android.downloadlib.c;

import androidx.annotation.WorkerThread;
import androidx.camera.core.FocusMeteringAction;
import com.ss.android.downloadlib.addownload.b.i;
import com.ss.android.downloadlib.addownload.j;
import com.ss.android.downloadlib.g.l;
import com.ss.android.socialbase.downloader.depend.k;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: AppDownloadLaunchResumeListener.java */
/* JADX INFO: loaded from: classes.dex */
public class d implements com.ss.android.socialbase.appdownloader.c.g, k {
    @Override // com.ss.android.socialbase.downloader.depend.k
    public void a() {
    }

    @Override // com.ss.android.socialbase.appdownloader.c.g
    public void a(DownloadInfo downloadInfo, boolean z) {
        if (downloadInfo == null) {
            return;
        }
        a(downloadInfo, downloadInfo.getRealStatus(), z);
    }

    @Override // com.ss.android.socialbase.appdownloader.c.g
    public void a(List<DownloadInfo> list) {
    }

    @Override // com.ss.android.socialbase.downloader.depend.k
    public void b() {
        com.ss.android.downloadlib.d.a().a(new Runnable() { // from class: com.ss.android.downloadlib.c.d.1
            @Override // java.lang.Runnable
            public void run() {
                DownloadInfo downloadInfo;
                int spIntVal;
                com.ss.android.downloadlib.addownload.b.f.a().b();
                for (com.ss.android.downloadad.api.a.b bVar : com.ss.android.downloadlib.addownload.b.f.a().c().values()) {
                    int iS = bVar.s();
                    if (iS != 0) {
                        com.ss.android.socialbase.downloader.g.a aVarA = com.ss.android.socialbase.downloader.g.a.a(iS);
                        if (aVarA.b("notification_opt_2") == 1 && (downloadInfo = Downloader.getInstance(j.getContext()).getDownloadInfo(iS)) != null) {
                            if (l.b(bVar) && !l.c(bVar.e())) {
                                int spIntVal2 = downloadInfo.getSpIntVal("restart_notify_open_app_count");
                                if (spIntVal2 < aVarA.a("noti_open_restart_times", 1)) {
                                    h.a().e(bVar);
                                    downloadInfo.setSpValue("restart_notify_open_app_count", String.valueOf(spIntVal2 + 1));
                                }
                            } else if (downloadInfo.getRealStatus() == -2) {
                                int spIntVal3 = downloadInfo.getSpIntVal("restart_notify_continue_count");
                                if (spIntVal3 < aVarA.a("noti_continue_restart_times", 1)) {
                                    h.a().a(bVar);
                                    downloadInfo.setSpValue("restart_notify_continue_count", String.valueOf(spIntVal3 + 1));
                                }
                            } else if (downloadInfo.getRealStatus() == -3 && com.ss.android.socialbase.downloader.i.f.c(downloadInfo) && !l.b(bVar) && (spIntVal = downloadInfo.getSpIntVal("restart_notify_install_count")) < aVarA.a("noti_install_restart_times", 1)) {
                                h.a().c(bVar);
                                downloadInfo.setSpValue("restart_notify_install_count", String.valueOf(spIntVal + 1));
                            }
                        }
                    }
                }
            }
        }, FocusMeteringAction.DEFAULT_AUTOCANCEL_DURATION);
    }

    @WorkerThread
    public void a(DownloadInfo downloadInfo, int i2, boolean z) {
        com.ss.android.downloadlib.addownload.b.f.a().b();
        com.ss.android.downloadad.api.a.b bVarA = com.ss.android.downloadlib.addownload.b.f.a().a(downloadInfo);
        if (bVarA == null) {
            return;
        }
        try {
            if (z) {
                bVarA.c(downloadInfo.getFailedResumeCount());
            } else if (bVarA.D() == -1) {
                return;
            } else {
                bVarA.c(-1);
            }
            i.a().a(bVarA);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("download_id", downloadInfo.getId());
            jSONObject.put("name", downloadInfo.getName());
            jSONObject.put("url", downloadInfo.getUrl());
            jSONObject.put("download_time", downloadInfo.getDownloadTime());
            jSONObject.put("download_status", i2);
            jSONObject.put("cur_bytes", downloadInfo.getCurBytes());
            jSONObject.put("total_bytes", downloadInfo.getTotalBytes());
            int i3 = 1;
            jSONObject.put("only_wifi", downloadInfo.isOnlyWifi() ? 1 : 0);
            jSONObject.put("chunk_count", downloadInfo.getChunkCount());
            if (!z) {
                i3 = 2;
            }
            jSONObject.put("launch_resumed", i3);
            jSONObject.put("failed_resume_count", downloadInfo.getFailedResumeCount());
            com.ss.android.downloadlib.d.a.a().a("embeded_ad", "download_uncompleted", jSONObject, bVarA);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}

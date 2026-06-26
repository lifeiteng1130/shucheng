package com.ss.android.downloadlib.c;

import com.ss.android.downloadlib.addownload.j;
import com.ss.android.downloadlib.g.l;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import org.json.JSONObject;

/* JADX INFO: compiled from: InnerEventListenerImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class e implements com.ss.android.socialbase.downloader.d.c {
    @Override // com.ss.android.socialbase.downloader.d.c
    public void a(int i2, String str, JSONObject jSONObject) {
        com.ss.android.downloadad.api.a.b bVarA;
        DownloadInfo downloadInfo = Downloader.getInstance(j.getContext()).getDownloadInfo(i2);
        if (downloadInfo == null || (bVarA = com.ss.android.downloadlib.addownload.b.f.a().a(downloadInfo)) == null) {
            return;
        }
        if ("install_view_result".equals(str)) {
            jSONObject = l.a(jSONObject);
            com.ss.android.downloadlib.a.a(jSONObject, downloadInfo);
            l.a(jSONObject, "model_id", Long.valueOf(bVarA.b()));
        }
        com.ss.android.downloadlib.d.a.a().b(str, jSONObject, bVarA);
    }

    @Override // com.ss.android.socialbase.downloader.d.c
    public void b(int i2, String str, JSONObject jSONObject) {
        com.ss.android.downloadad.api.a.b bVarA;
        DownloadInfo downloadInfo = Downloader.getInstance(j.getContext()).getDownloadInfo(i2);
        if (downloadInfo == null || (bVarA = com.ss.android.downloadlib.addownload.b.f.a().a(downloadInfo)) == null) {
            return;
        }
        com.ss.android.downloadlib.d.a.a().a(str, jSONObject, bVarA);
    }
}

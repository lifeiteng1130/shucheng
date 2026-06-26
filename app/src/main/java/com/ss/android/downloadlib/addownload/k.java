package com.ss.android.downloadlib.addownload;

import com.ss.android.socialbase.downloader.downloader.r;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: ReserveWifiStatusImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class k implements r {
    @Override // com.ss.android.socialbase.downloader.downloader.r
    public void a(DownloadInfo downloadInfo, int i2, int i3) {
        com.ss.android.downloadad.api.a.b bVarA = com.ss.android.downloadlib.addownload.b.f.a().a(downloadInfo);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("reserve_wifi_source", Integer.valueOf(i3));
            jSONObject.putOpt("reserve_wifi_status", Integer.valueOf(i2));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        com.ss.android.downloadlib.d.a.a().a("pause_reserve_wifi", jSONObject, bVarA);
    }
}

package com.ss.android.downloadlib.addownload.d;

import android.content.Context;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import com.ss.android.downloadlib.addownload.i;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: DownloadPercentInterceptor.java */
/* JADX INFO: loaded from: classes.dex */
public class b implements d {
    private static com.ss.android.downloadlib.addownload.a.c a;

    public static com.ss.android.downloadlib.addownload.a.c a() {
        return a;
    }

    @Override // com.ss.android.downloadlib.addownload.d.d
    public boolean a(final com.ss.android.downloadad.api.a.b bVar, int i2, final c cVar) {
        DownloadInfo downloadInfoA;
        if (bVar == null || bVar.ad() || !a(bVar) || (downloadInfoA = com.ss.android.downloadlib.g.a((Context) null).a(bVar.a())) == null) {
            return false;
        }
        long curBytes = downloadInfoA.getCurBytes();
        long totalBytes = downloadInfoA.getTotalBytes();
        if (curBytes > 0 && totalBytes > 0) {
            int iA = i.a(downloadInfoA.getId(), (int) ((curBytes * 100) / totalBytes));
            if (iA > a(bVar.s())) {
                a = new com.ss.android.downloadlib.addownload.a.c() { // from class: com.ss.android.downloadlib.addownload.d.b.1
                    @Override // com.ss.android.downloadlib.addownload.a.c
                    public void a() {
                        com.ss.android.downloadlib.addownload.a.c unused = b.a = null;
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.putOpt("pause_optimise_type", "download_percent");
                            jSONObject.putOpt("pause_optimise_action", "confirm");
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                        com.ss.android.downloadlib.d.a.a().a("pause_optimise", jSONObject, bVar);
                    }

                    @Override // com.ss.android.downloadlib.addownload.a.c
                    public void b() {
                        com.ss.android.downloadlib.addownload.a.c unused = b.a = null;
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.putOpt("pause_optimise_type", "download_percent");
                            jSONObject.putOpt("pause_optimise_action", "cancel");
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                        com.ss.android.downloadlib.d.a.a().a("pause_optimise", jSONObject, bVar);
                        cVar.a(bVar);
                    }
                };
                TTDelegateActivity.b(bVar, String.format("已下载%s%%，即将下载完成，是否继续下载？", Integer.valueOf(iA)), "继续", "暂停");
                bVar.o(true);
                return true;
            }
        }
        return false;
    }

    private int a(int i2) {
        return com.ss.android.socialbase.downloader.g.a.a(i2).a("pause_optimise_download_percent", 50);
    }

    private boolean a(com.ss.android.downloadad.api.a.a aVar) {
        return com.ss.android.downloadlib.g.e.a(aVar).a("pause_optimise_download_percent_switch", 0) == 1 && aVar.q();
    }
}

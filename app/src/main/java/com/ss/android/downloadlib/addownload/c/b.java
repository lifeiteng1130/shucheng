package com.ss.android.downloadlib.addownload.c;

import com.ss.android.downloadlib.addownload.b.f;
import com.ss.android.downloadlib.addownload.b.i;
import com.ss.android.downloadlib.addownload.j;
import com.ss.android.downloadlib.g.l;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.umeng.commonsdk.statistics.SdkVersion;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: CleanSpaceTask.java */
/* JADX INFO: loaded from: classes.dex */
public class b implements Runnable {
    private DownloadInfo a;

    public b(DownloadInfo downloadInfo) {
        this.a = downloadInfo;
    }

    @Override // java.lang.Runnable
    public void run() {
        final com.ss.android.downloadad.api.a.b bVarA;
        if (this.a == null || (bVarA = f.a().a(this.a)) == null) {
            return;
        }
        com.ss.android.downloadlib.d.a.a().a("cleanspace_task", bVarA);
        long jLongValue = Double.valueOf((com.ss.android.downloadlib.g.e.a(this.a.getId()) + 1.0d) * this.a.getTotalBytes()).longValue() - this.a.getCurBytes();
        long jA = l.a(0L);
        if (j.l() != null) {
            j.l().e();
        }
        c.a();
        c.b();
        if (com.ss.android.downloadlib.g.e.g(bVarA.s())) {
            c.a(j.getContext());
        }
        long jA2 = l.a(0L);
        if (jA2 >= jLongValue) {
            bVarA.l(SdkVersion.MINI_VERSION);
            i.a().a(bVarA);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("quite_clean_size", Long.valueOf(jA2 - jA));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            com.ss.android.downloadlib.d.a.a().a("cleanspace_download_after_quite_clean", jSONObject, bVarA);
            Downloader.getInstance(j.getContext()).restart(this.a.getId());
            return;
        }
        if (j.l() != null) {
            bVarA.d(false);
            d.a().a(bVarA.a(), new e() { // from class: com.ss.android.downloadlib.addownload.c.b.1
            });
            if (j.l().a(this.a.getId(), this.a.getUrl(), true, jLongValue)) {
                bVarA.e(true);
                return;
            }
            return;
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.putOpt("show_dialog_result", 3);
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
        com.ss.android.downloadlib.d.a.a().a("cleanspace_window_show", jSONObject2, bVarA);
    }
}

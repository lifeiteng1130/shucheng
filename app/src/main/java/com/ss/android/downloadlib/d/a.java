package com.ss.android.downloadlib.d;

import android.os.Build;
import androidx.annotation.NonNull;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.model.c;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.android.downloadlib.addownload.b.e;
import com.ss.android.downloadlib.addownload.b.f;
import com.ss.android.downloadlib.addownload.b.i;
import com.ss.android.downloadlib.addownload.j;
import com.ss.android.downloadlib.g.l;
import com.ss.android.socialbase.appdownloader.e.d;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.umeng.analytics.pro.ai;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: AdEventHandler.java */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: com.ss.android.downloadlib.d.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AdEventHandler.java */
    public static class C0083a {
        private static a a = new a();
    }

    public static a a() {
        return C0083a.a;
    }

    public void b(long j2, int i2) {
        a(j2, i2, (DownloadInfo) null);
    }

    private a() {
    }

    public void a(long j2, int i2) {
        e eVarE = f.a().e(j2);
        if (eVarE.x()) {
            com.ss.android.downloadlib.e.c.a().a("sendClickEvent ModelBox notValid");
            return;
        }
        if (eVarE.f3053c.isEnableClickEvent()) {
            int i3 = 1;
            DownloadEventConfig downloadEventConfig = eVarE.f3053c;
            String clickItemTag = i2 == 1 ? downloadEventConfig.getClickItemTag() : downloadEventConfig.getClickButtonTag();
            String strA = l.a(eVarE.f3053c.getClickLabel(), "click");
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("download_click_type", Integer.valueOf(i2));
                jSONObject.putOpt("permission_notification", Integer.valueOf(d.a() ? 1 : 2));
                if (!com.ss.android.socialbase.downloader.i.f.c(j.getContext())) {
                    i3 = 2;
                }
                jSONObject.putOpt("network_available", Integer.valueOf(i3));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            a(clickItemTag, strA, jSONObject, eVarE);
            if (!"click".equals(strA) || eVarE.f3052b == null) {
                return;
            }
            c.a().a(j2, eVarE.f3052b.getLogExtra());
        }
    }

    public void b(DownloadInfo downloadInfo, BaseException baseException) {
        if (downloadInfo == null) {
            return;
        }
        com.ss.android.downloadad.api.a.b bVarA = f.a().a(downloadInfo);
        if (bVarA == null) {
            com.ss.android.downloadlib.e.c.a().a("sendDownloadFailedEvent nativeModel null");
            return;
        }
        if (bVarA.f2947c.get()) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            com.ss.android.downloadlib.g.f.c(downloadInfo, jSONObject);
            com.ss.android.downloadlib.a.a(jSONObject, downloadInfo);
            if (baseException != null) {
                jSONObject.putOpt("fail_status", Integer.valueOf(baseException.getErrorCode()));
                jSONObject.putOpt("fail_msg", baseException.getErrorMessage());
                bVarA.d(baseException.getErrorCode());
                bVarA.a(baseException.getErrorMessage());
            }
            bVarA.y();
            jSONObject.put("download_failed_times", bVarA.x());
            if (downloadInfo.getTotalBytes() > 0) {
                jSONObject.put("download_percent", downloadInfo.getCurBytes() / downloadInfo.getTotalBytes());
            }
            int i2 = 1;
            jSONObject.put("has_send_download_failed_finally", bVarA.f2948d.get() ? 1 : 2);
            com.ss.android.downloadlib.g.f.a(bVarA, jSONObject);
            if (!bVarA.V()) {
                i2 = 2;
            }
            jSONObject.put("is_update_download", i2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        a(bVarA.j(), "download_failed", jSONObject, bVarA);
        i.a().a(bVarA);
    }

    public void a(long j2, int i2, DownloadInfo downloadInfo) {
        e eVarE = f.a().e(j2);
        if (eVarE.x()) {
            com.ss.android.downloadlib.e.c.a().a("sendEvent ModelBox notValid");
            return;
        }
        String strA = null;
        JSONObject jSONObject = new JSONObject();
        l.a(jSONObject, "download_scene", Integer.valueOf(eVarE.t()));
        if (i2 == 1) {
            strA = l.a(eVarE.f3053c.getStorageDenyLabel(), "storage_deny");
        } else if (i2 == 2) {
            strA = l.a(eVarE.f3053c.getClickStartLabel(), "click_start");
            com.ss.android.downloadlib.g.f.a(downloadInfo, jSONObject);
        } else if (i2 == 3) {
            strA = l.a(eVarE.f3053c.getClickPauseLabel(), "click_pause");
            com.ss.android.downloadlib.g.f.b(downloadInfo, jSONObject);
        } else if (i2 == 4) {
            strA = l.a(eVarE.f3053c.getClickContinueLabel(), "click_continue");
            com.ss.android.downloadlib.g.f.c(downloadInfo, jSONObject);
        } else if (i2 == 5) {
            if (downloadInfo != null) {
                try {
                    com.ss.android.downloadlib.g.f.a(jSONObject, downloadInfo.getId());
                    com.ss.android.downloadlib.a.b(jSONObject, downloadInfo);
                } catch (Throwable unused) {
                }
            }
            strA = l.a(eVarE.f3053c.getClickInstallLabel(), "click_install");
        }
        a(null, strA, jSONObject, 0L, 1, eVarE);
    }

    public void b(String str, com.ss.android.downloadad.api.a.a aVar) {
        a((String) null, str, aVar);
    }

    public void b(String str, JSONObject jSONObject, com.ss.android.downloadad.api.a.a aVar) {
        a((String) null, str, jSONObject, aVar);
    }

    public void a(String str, int i2, e eVar) {
        a(null, str, null, i2, 0, eVar);
    }

    public void a(long j2, boolean z, int i2) {
        e eVarE = f.a().e(j2);
        if (eVarE.x()) {
            com.ss.android.downloadlib.e.c.a().a("sendQuickAppEvent ModelBox notValid");
            return;
        }
        if (eVarE.f3052b.getQuickAppModel() == null) {
            return;
        }
        DownloadModel downloadModel = eVarE.f3052b;
        if (downloadModel instanceof AdDownloadModel) {
            ((AdDownloadModel) downloadModel).setFunnelType(3);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("download_click_type", Integer.valueOf(i2));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        b(z ? "deeplink_quickapp_success" : "deeplink_quickapp_failed", jSONObject, eVarE);
    }

    public void a(long j2, BaseException baseException) {
        e eVarE = f.a().e(j2);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("download_time", 0);
            if (baseException != null) {
                jSONObject.putOpt("fail_status", Integer.valueOf(baseException.getErrorCode()));
                jSONObject.putOpt("fail_msg", baseException.getErrorMessage());
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        b("download_failed", jSONObject, eVarE);
    }

    public void a(DownloadInfo downloadInfo) {
        com.ss.android.downloadad.api.a.b bVarA = f.a().a(downloadInfo);
        if (bVarA == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            com.ss.android.downloadlib.g.f.c(downloadInfo, jSONObject);
            bVarA.a(System.currentTimeMillis());
            a(bVarA.j(), "download_resume", jSONObject, bVarA);
            i.a().a(bVarA);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void a(JSONObject jSONObject, @NonNull com.ss.android.downloadad.api.a.b bVar) {
        a(bVar.j(), "install_finish", jSONObject, bVar);
    }

    public void a(DownloadInfo downloadInfo, BaseException baseException) {
        com.ss.android.downloadad.api.a.b bVarA;
        if (downloadInfo == null || (bVarA = f.a().a(downloadInfo)) == null || bVarA.f2947c.get()) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            com.ss.android.downloadlib.a.a(jSONObject, downloadInfo);
            jSONObject.putOpt("fail_status", Integer.valueOf(bVarA.E()));
            jSONObject.putOpt("fail_msg", bVarA.F());
            jSONObject.put("download_failed_times", bVarA.x());
            if (downloadInfo.getTotalBytes() > 0) {
                jSONObject.put("download_percent", downloadInfo.getCurBytes() / downloadInfo.getTotalBytes());
            }
            jSONObject.put("download_status", downloadInfo.getRealStatus());
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (bVarA.H() > 0) {
                jSONObject.put("time_from_start_download", jCurrentTimeMillis - bVarA.H());
            }
            if (bVarA.B() > 0) {
                jSONObject.put("time_from_download_resume", jCurrentTimeMillis - bVarA.B());
            }
            int i2 = 1;
            jSONObject.put("is_update_download", bVarA.V() ? 1 : 2);
            jSONObject.put("can_show_notification", d.a() ? 1 : 2);
            if (!bVarA.f2948d.get()) {
                i2 = 2;
            }
            jSONObject.put("has_send_download_failed_finally", i2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        a(bVarA.j(), "download_cancel", jSONObject, bVarA);
    }

    public void a(String str, com.ss.android.downloadad.api.a.a aVar) {
        a(str, (JSONObject) null, aVar);
    }

    public void a(String str, JSONObject jSONObject, long j2) {
        com.ss.android.downloadad.api.a.a aVarD = f.a().d(j2);
        if (aVarD != null) {
            a(str, jSONObject, aVarD);
            return;
        }
        e eVarE = f.a().e(j2);
        if (eVarE.x()) {
            com.ss.android.downloadlib.e.c.a().a("sendUnityEvent ModelBox notValid");
        } else {
            a(str, jSONObject, eVarE);
        }
    }

    public void a(String str, JSONObject jSONObject, com.ss.android.downloadad.api.a.a aVar) {
        JSONObject jSONObject2 = new JSONObject();
        l.a(jSONObject2, "unity_label", str);
        a("embeded_ad", "ttdownloader_unity", l.a(jSONObject, jSONObject2), aVar);
    }

    public void a(String str, @NonNull DownloadModel downloadModel, @NonNull DownloadEventConfig downloadEventConfig, @NonNull DownloadController downloadController) {
        b(str, new e(downloadModel.getId(), downloadModel, downloadEventConfig, downloadController));
    }

    public void a(String str, long j2) {
        com.ss.android.downloadad.api.a.b bVarD = f.a().d(j2);
        if (bVarD != null) {
            b(str, bVarD);
        } else {
            b(str, f.a().e(j2));
        }
    }

    public void a(String str, String str2, com.ss.android.downloadad.api.a.a aVar) {
        a(str, str2, (JSONObject) null, aVar);
    }

    public void a(String str, String str2, JSONObject jSONObject, com.ss.android.downloadad.api.a.a aVar) {
        a(str, str2, jSONObject, 0L, 0, aVar);
    }

    private void a(String str, String str2, JSONObject jSONObject, long j2, int i2, com.ss.android.downloadad.api.a.a aVar) {
        if (aVar == null) {
            com.ss.android.downloadlib.e.c.a().a("onEvent data null");
            return;
        }
        if ((aVar instanceof e) && ((e) aVar).x()) {
            com.ss.android.downloadlib.e.c.a().a("onEvent ModelBox notValid");
            return;
        }
        try {
            c.a aVarC = new c.a().a(l.a(str, aVar.j(), "embeded_ad")).b(str2).b(aVar.c()).a(aVar.b()).c(aVar.d());
            if (j2 <= 0) {
                j2 = aVar.l();
            }
            c.a aVarA = aVarC.b(j2).d(aVar.i()).a(aVar.n()).a(l.a(a(aVar), jSONObject)).b(aVar.k()).a(aVar.o());
            if (i2 <= 0) {
                i2 = 2;
            }
            a(aVarA.a(i2).a(aVar.m()).a());
        } catch (Exception e2) {
            com.ss.android.downloadlib.e.c.a().a(e2, "onEvent");
        }
    }

    private JSONObject a(com.ss.android.downloadad.api.a.a aVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            l.a(aVar.g(), jSONObject);
            l.a(aVar.p(), jSONObject);
            jSONObject.putOpt("download_url", aVar.a());
            jSONObject.putOpt(ai.o, aVar.e());
            jSONObject.putOpt("android_int", Integer.valueOf(Build.VERSION.SDK_INT));
            jSONObject.putOpt("rom_name", com.ss.android.socialbase.appdownloader.f.d.g());
            jSONObject.putOpt("rom_version", com.ss.android.socialbase.appdownloader.f.d.h());
            jSONObject.putOpt("ttdownloader", 1);
            jSONObject.putOpt("funnel_type", Integer.valueOf(aVar.h()));
            if (aVar.h() == 2) {
                com.ss.android.downloadlib.g.f.b(jSONObject, aVar);
            }
        } catch (Exception e2) {
            j.s().a(e2, "getBaseJson");
        }
        return jSONObject;
    }

    private void a(com.ss.android.download.api.model.c cVar) {
        if (j.a() == null) {
            return;
        }
        if (cVar.m()) {
            j.a().a(cVar);
        } else {
            j.a().b(cVar);
        }
    }
}

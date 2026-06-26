package com.ss.android.downloadlib.addownload;

import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.downloadlib.g.m;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import org.json.JSONObject;

/* JADX INFO: compiled from: AdDelayTaskManager.java */
/* JADX INFO: loaded from: classes.dex */
public class a implements m.a {
    private static final String a = "a";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static a f2995b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private m f2996c = new m(Looper.getMainLooper(), this);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f2997d;

    private a() {
    }

    public static a a() {
        if (f2995b == null) {
            synchronized (a.class) {
                if (f2995b == null) {
                    f2995b = new a();
                }
            }
        }
        return f2995b;
    }

    public void a(@NonNull DownloadInfo downloadInfo, long j2, long j3, String str, String str2, String str3, String str4) {
        com.ss.android.downloadlib.addownload.b.a aVar = new com.ss.android.downloadlib.addownload.b.a(downloadInfo.getId(), j2, j3, str, str2, str3, str4);
        if (com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId()).a("back_miui_silent_install", 1) == 0 && ((com.ss.android.socialbase.appdownloader.f.d.l() || com.ss.android.socialbase.appdownloader.f.d.m()) && com.ss.android.socialbase.downloader.i.j.a(j.getContext(), "com.miui.securitycore", "com.miui.enterprise.service.EntInstallService"))) {
            if (com.ss.android.socialbase.downloader.i.f.a(downloadInfo.getTempCacheData().get("extra_silent_install_succeed"), false)) {
                Message messageObtainMessage = this.f2996c.obtainMessage(200, aVar);
                messageObtainMessage.arg1 = 2;
                this.f2996c.sendMessageDelayed(messageObtainMessage, r1.a("check_silent_install_interval", BaseConstants.Time.MINUTE));
                return;
            }
            com.ss.android.downloadad.api.a.b bVarD = com.ss.android.downloadlib.addownload.b.f.a().d(aVar.f3022b);
            JSONObject jSONObject = new JSONObject();
            int i2 = -1;
            try {
                jSONObject.put("ttdownloader_type", "miui_silent_install");
                jSONObject.put("ttdownloader_message", "miui_silent_install_failed: has not started service");
                i2 = 5;
            } catch (Exception unused) {
            }
            j.f().a(null, new BaseException(i2, jSONObject.toString()), i2);
            com.ss.android.downloadlib.d.a.a().a("embeded_ad", "ah_result", jSONObject, bVarD);
        }
        if (com.ss.android.downloadlib.g.e.c()) {
            long jCurrentTimeMillis = System.currentTimeMillis() - this.f2997d;
            long jD = com.ss.android.downloadlib.g.e.d();
            if (jCurrentTimeMillis < com.ss.android.downloadlib.g.e.e()) {
                long jE = com.ss.android.downloadlib.g.e.e() - jCurrentTimeMillis;
                jD += jE;
                this.f2997d = System.currentTimeMillis() + jE;
            } else {
                this.f2997d = System.currentTimeMillis();
            }
            m mVar = this.f2996c;
            mVar.sendMessageDelayed(mVar.obtainMessage(200, aVar), jD);
        }
    }

    private void a(com.ss.android.downloadlib.addownload.b.a aVar, int i2) {
        if (j.k() == null || j.k().a() || aVar == null) {
            return;
        }
        if (2 == i2) {
            com.ss.android.downloadad.api.a.b bVarD = com.ss.android.downloadlib.addownload.b.f.a().d(aVar.f3022b);
            JSONObject jSONObject = new JSONObject();
            int i3 = -1;
            try {
                jSONObject.put("ttdownloader_type", "miui_silent_install");
                if (com.ss.android.downloadlib.g.l.d(j.getContext(), aVar.f3024d)) {
                    jSONObject.put("ttdownloader_message", "miui_silent_install_succeed");
                    i3 = 4;
                } else {
                    jSONObject.put("ttdownloader_message", "miui_silent_install_failed: has started service");
                    i3 = 5;
                }
            } catch (Exception unused) {
            }
            j.f().a(null, new BaseException(i3, jSONObject.toString()), i3);
            com.ss.android.downloadlib.d.a.a().a("embeded_ad", "ah_result", jSONObject, bVarD);
        }
        if (com.ss.android.downloadlib.g.l.d(j.getContext(), aVar.f3024d)) {
            com.ss.android.downloadlib.d.a.a().a("delayinstall_installed", aVar.f3022b);
            return;
        }
        if (!com.ss.android.downloadlib.g.l.a(aVar.f3027g)) {
            com.ss.android.downloadlib.d.a.a().a("delayinstall_file_lost", aVar.f3022b);
        } else if (com.ss.android.downloadlib.addownload.a.a.a().a(aVar.f3024d)) {
            com.ss.android.downloadlib.d.a.a().a("delayinstall_conflict_with_back_dialog", aVar.f3022b);
        } else {
            com.ss.android.downloadlib.d.a.a().a("delayinstall_install_start", aVar.f3022b);
            com.ss.android.socialbase.appdownloader.d.a(j.getContext(), (int) aVar.a);
        }
    }

    @Override // com.ss.android.downloadlib.g.m.a
    public void a(Message message) {
        if (message.what != 200) {
            return;
        }
        a((com.ss.android.downloadlib.addownload.b.a) message.obj, message.arg1);
    }
}

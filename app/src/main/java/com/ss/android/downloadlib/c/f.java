package com.ss.android.downloadlib.c;

import android.content.Context;
import androidx.core.view.PointerIconCompat;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.ss.android.downloadlib.addownload.j;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import org.json.JSONObject;

/* JADX INFO: compiled from: NewDownloadCompletedEventDispatcher.java */
/* JADX INFO: loaded from: classes.dex */
public class f implements com.ss.android.socialbase.appdownloader.c.d {
    private Context a;

    public f(Context context) {
        this.a = context.getApplicationContext();
    }

    @Override // com.ss.android.socialbase.appdownloader.c.d
    public void a(Context context, String str) {
        com.ss.android.downloadlib.a.a().a(str);
    }

    @Override // com.ss.android.socialbase.appdownloader.c.d
    public void a(int i2, int i3, String str, int i4, long j2) {
        DownloadInfo downloadInfo;
        com.ss.android.downloadad.api.a.b bVarA;
        Context context = this.a;
        if (context == null || (downloadInfo = Downloader.getInstance(context).getDownloadInfo(i2)) == null || downloadInfo.getStatus() == 0 || (bVarA = com.ss.android.downloadlib.addownload.b.f.a().a(downloadInfo)) == null) {
            return;
        }
        if (i3 == 1) {
            com.ss.android.downloadlib.a.a(downloadInfo, bVarA);
            if (AdBaseConstants.MIME_APK.equals(downloadInfo.getMimeType())) {
                com.ss.android.downloadlib.addownload.a.a().a(downloadInfo, bVarA.b(), bVarA.l(), bVarA.e(), downloadInfo.getTitle(), bVarA.d(), downloadInfo.getTargetFilePath());
                return;
            }
            return;
        }
        if (i3 == 3) {
            com.ss.android.downloadlib.d.a.a().a("download_notification", "download_notification_install", com.ss.android.downloadlib.a.b(new JSONObject(), downloadInfo), bVarA);
            return;
        }
        if (i3 == 5) {
            com.ss.android.downloadlib.d.a.a().a("download_notification", "download_notification_pause", bVarA);
        } else if (i3 == 6) {
            com.ss.android.downloadlib.d.a.a().a("download_notification", "download_notification_continue", bVarA);
        } else {
            if (i3 != 7) {
                return;
            }
            com.ss.android.downloadlib.d.a.a().a("download_notification", "download_notification_click", bVarA);
        }
    }

    @Override // com.ss.android.socialbase.appdownloader.c.d
    public boolean a(int i2, boolean z) {
        if (j.n() != null) {
            return j.n().a(z);
        }
        return false;
    }

    @Override // com.ss.android.socialbase.appdownloader.c.d
    public void a(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return;
        }
        com.ss.android.downloadlib.f.a().a(downloadInfo);
        if (com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId()).a("report_download_cancel", 1) == 1) {
            com.ss.android.downloadlib.d.a.a().a(downloadInfo, new BaseException(PointerIconCompat.TYPE_NO_DROP, ""));
        } else {
            com.ss.android.downloadlib.d.a.a().b(downloadInfo, new BaseException(PointerIconCompat.TYPE_NO_DROP, ""));
        }
    }

    @Override // com.ss.android.socialbase.appdownloader.c.d
    public void a(int i2, int i3, String str, String str2, String str3) {
        DownloadInfo downloadInfo;
        Context context = this.a;
        if (context == null || (downloadInfo = Downloader.getInstance(context).getDownloadInfo(i2)) == null || downloadInfo.getStatus() != -3) {
            return;
        }
        downloadInfo.setPackageName(str2);
        com.ss.android.downloadlib.addownload.b.a().a(this.a, downloadInfo);
    }

    @Override // com.ss.android.socialbase.appdownloader.c.d
    public boolean a() {
        return com.ss.android.downloadlib.addownload.b.a().b();
    }
}

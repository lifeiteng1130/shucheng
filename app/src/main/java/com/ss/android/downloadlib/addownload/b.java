package com.ss.android.downloadlib.addownload;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.File;

/* JADX INFO: compiled from: AdDownloadSecurityManager.java */
/* JADX INFO: loaded from: classes.dex */
public class b {
    private static volatile b a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Handler f3020b = null;

    public static b a() {
        if (a == null) {
            synchronized (b.class) {
                if (a == null) {
                    a = new b();
                }
            }
        }
        return a;
    }

    public boolean b() {
        return j.i().optInt("forbid_invalidte_download_file_install", 0) == 1;
    }

    public void a(Context context, DownloadInfo downloadInfo) {
        if (b() && downloadInfo != null) {
            try {
                File file = new File(downloadInfo.getSavePath(), downloadInfo.getName());
                if (file.isFile() && file.exists()) {
                    file.delete();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if (this.f3020b == null) {
                this.f3020b = new Handler(Looper.getMainLooper());
            }
            final String url = downloadInfo.getUrl();
            Downloader.getInstance(context).clearDownloadData(downloadInfo.getId());
            this.f3020b.post(new Runnable() { // from class: com.ss.android.downloadlib.addownload.b.1
                @Override // java.lang.Runnable
                public void run() {
                    j.c().a(3, j.getContext(), null, "下载失败，请重试！", null, 0);
                    e eVarA = com.ss.android.downloadlib.f.a().a(url);
                    if (eVarA != null) {
                        eVarA.g();
                    }
                }
            });
        }
    }
}

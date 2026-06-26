package com.ss.android.socialbase.downloader.depend;

import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* JADX INFO: compiled from: AbsDownloadExtListener.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class a extends AbsDownloadListener implements s {
    private static final String a = "a";

    public void a(DownloadInfo downloadInfo) {
        if (!com.ss.android.socialbase.downloader.c.a.a() || downloadInfo == null) {
            return;
        }
        String str = a;
        StringBuilder sbR = c.a.a.a.a.r(" onWaitingDownloadCompleteHandler -- ");
        sbR.append(downloadInfo.getName());
        com.ss.android.socialbase.downloader.c.a.b(str, sbR.toString());
    }
}

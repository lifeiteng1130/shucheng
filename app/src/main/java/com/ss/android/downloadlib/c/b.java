package com.ss.android.downloadlib.c;

import android.content.pm.PackageInfo;
import com.ss.android.downloadlib.addownload.j;
import com.ss.android.socialbase.downloader.depend.m;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* JADX INFO: compiled from: ApkParseManager.java */
/* JADX INFO: loaded from: classes.dex */
public class b implements m {
    @Override // com.ss.android.socialbase.downloader.depend.m
    public void a(DownloadInfo downloadInfo) {
        PackageInfo packageInfoA = com.ss.android.socialbase.appdownloader.c.a(j.getContext(), downloadInfo, downloadInfo.getSavePath(), downloadInfo.getName());
        if (packageInfoA != null) {
            downloadInfo.setAppVersionCode(packageInfoA.versionCode);
        }
    }

    @Override // com.ss.android.socialbase.downloader.depend.m
    public boolean b(DownloadInfo downloadInfo) {
        return downloadInfo != null && com.ss.android.downloadlib.g.e.b() && downloadInfo.getPackageInfo() == null;
    }
}

package com.ss.android.downloadlib.c;

import com.ss.android.download.api.config.l;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.ss.android.downloadlib.addownload.j;
import com.ss.android.socialbase.downloader.depend.m;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.File;

/* JADX INFO: compiled from: ApkUpdateManager.java */
/* JADX INFO: loaded from: classes.dex */
public class c implements m {
    @Override // com.ss.android.socialbase.downloader.depend.m
    public void a(DownloadInfo downloadInfo) {
        l lVarJ = j.j();
        if (downloadInfo == null || lVarJ == null) {
            return;
        }
        String packageName = downloadInfo.getPackageName();
        String targetFilePath = downloadInfo.getTargetFilePath();
        File fileA = a(packageName, targetFilePath);
        com.ss.android.downloadad.api.a.b bVarA = com.ss.android.downloadlib.addownload.b.f.a().a(downloadInfo);
        lVarJ.a(packageName, targetFilePath, fileA, bVarA != null ? com.ss.android.downloadlib.g.l.a(bVarA.g()) : null);
        downloadInfo.setMimeType(AdBaseConstants.MIME_APK);
        downloadInfo.setName(fileA.getName());
        downloadInfo.setMd5(null);
    }

    @Override // com.ss.android.socialbase.downloader.depend.m
    public boolean b(DownloadInfo downloadInfo) {
        if (downloadInfo != null) {
            return com.ss.android.download.api.c.b.a(com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId()), downloadInfo.getMimeType());
        }
        return false;
    }

    private File a(String str, String str2) {
        File file = new File(str2);
        String name = file.getName();
        int iLastIndexOf = name.lastIndexOf(46);
        if (iLastIndexOf > 0) {
            str = name.substring(0, iLastIndexOf);
        }
        return new File(file.getParent(), c.a.a.a.a.i(str, ".apk"));
    }
}

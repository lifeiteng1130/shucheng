package com.ss.android.socialbase.downloader.depend;

import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* JADX INFO: compiled from: AbsNotificationListener.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class d extends AbsDownloadListener implements s {
    private void a(int i2, DownloadInfo downloadInfo, BaseException baseException, boolean z) {
        if (downloadInfo == null || !downloadInfo.canShowNotification() || i2 == 4) {
            return;
        }
        com.ss.android.socialbase.downloader.notification.a aVarE = com.ss.android.socialbase.downloader.notification.b.a().e(downloadInfo.getId());
        if (aVarE == null) {
            aVarE = a();
        }
        aVarE.b(downloadInfo.getTotalBytes());
        if (i2 == -3) {
            aVarE.a(downloadInfo.getTotalBytes());
        } else {
            aVarE.a(downloadInfo.getCurBytes());
        }
        aVarE.a(i2, baseException, z);
    }

    private void b(DownloadInfo downloadInfo) {
        if (downloadInfo == null || !downloadInfo.canShowNotification()) {
            return;
        }
        com.ss.android.socialbase.downloader.notification.a aVarE = com.ss.android.socialbase.downloader.notification.b.a().e(downloadInfo.getId());
        if (aVarE != null) {
            aVarE.a(downloadInfo);
        } else {
            com.ss.android.socialbase.downloader.notification.b.a().a(a());
        }
    }

    private void c(DownloadInfo downloadInfo) {
        if (downloadInfo != null && downloadInfo.canShowNotification() && downloadInfo.getStatus() == 4) {
            com.ss.android.socialbase.downloader.notification.a aVarE = com.ss.android.socialbase.downloader.notification.b.a().e(downloadInfo.getId());
            if (aVarE == null) {
                aVarE = a();
            }
            aVarE.a(downloadInfo.getCurBytes(), downloadInfo.getTotalBytes());
        }
    }

    public abstract com.ss.android.socialbase.downloader.notification.a a();

    @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onFailed(DownloadInfo downloadInfo, BaseException baseException) {
        super.onFailed(downloadInfo, baseException);
        a(-1, downloadInfo, baseException, false);
    }

    @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onPause(DownloadInfo downloadInfo) {
        super.onPause(downloadInfo);
        a(-2, downloadInfo, null, false);
    }

    @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onPrepare(DownloadInfo downloadInfo) {
        super.onPrepare(downloadInfo);
        b(downloadInfo);
        a(1, downloadInfo, null, true);
    }

    @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onProgress(DownloadInfo downloadInfo) {
        super.onProgress(downloadInfo);
        c(downloadInfo);
    }

    @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onStart(DownloadInfo downloadInfo) {
        super.onStart(downloadInfo);
        a(2, downloadInfo, null, false);
    }

    @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onSuccessed(DownloadInfo downloadInfo) {
        super.onSuccessed(downloadInfo);
        a(-3, downloadInfo, null, false);
    }

    @Override // com.ss.android.socialbase.downloader.depend.s
    public void a(DownloadInfo downloadInfo) {
        if (downloadInfo == null || downloadInfo.isAutoInstallWithoutNotification()) {
            return;
        }
        a(11, downloadInfo, null, true);
    }
}

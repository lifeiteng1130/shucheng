package com.ss.android.socialbase.downloader.depend;

import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* JADX INFO: loaded from: classes.dex */
public abstract class AbsDownloadListener implements IDownloadListener {
    private static final String TAG = "AbsDownloadListener";

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onCanceled(DownloadInfo downloadInfo) {
        if (!com.ss.android.socialbase.downloader.c.a.a() || downloadInfo == null) {
            return;
        }
        String str = TAG;
        StringBuilder sbR = c.a.a.a.a.r(" onCanceled -- ");
        sbR.append(downloadInfo.getName());
        com.ss.android.socialbase.downloader.c.a.b(str, sbR.toString());
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onFailed(DownloadInfo downloadInfo, BaseException baseException) {
        if (!com.ss.android.socialbase.downloader.c.a.a() || downloadInfo == null) {
            return;
        }
        String str = TAG;
        Object[] objArr = new Object[2];
        objArr[0] = downloadInfo.getName();
        objArr[1] = baseException != null ? baseException.getErrorMessage() : "unkown";
        com.ss.android.socialbase.downloader.c.a.b(str, String.format("onFailed on %s because of : %s", objArr));
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onFirstStart(DownloadInfo downloadInfo) {
        if (!com.ss.android.socialbase.downloader.c.a.a() || downloadInfo == null) {
            return;
        }
        String str = TAG;
        StringBuilder sbR = c.a.a.a.a.r(" onFirstStart -- ");
        sbR.append(downloadInfo.getName());
        com.ss.android.socialbase.downloader.c.a.b(str, sbR.toString());
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onFirstSuccess(DownloadInfo downloadInfo) {
        if (!com.ss.android.socialbase.downloader.c.a.a() || downloadInfo == null) {
            return;
        }
        String str = TAG;
        StringBuilder sbR = c.a.a.a.a.r(" onFirstSuccess -- ");
        sbR.append(downloadInfo.getName());
        com.ss.android.socialbase.downloader.c.a.b(str, sbR.toString());
    }

    public void onIntercept(DownloadInfo downloadInfo) {
        if (!com.ss.android.socialbase.downloader.c.a.a() || downloadInfo == null) {
            return;
        }
        String str = TAG;
        StringBuilder sbR = c.a.a.a.a.r(" onIntercept -- ");
        sbR.append(downloadInfo.getName());
        com.ss.android.socialbase.downloader.c.a.b(str, sbR.toString());
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onPause(DownloadInfo downloadInfo) {
        if (!com.ss.android.socialbase.downloader.c.a.a() || downloadInfo == null) {
            return;
        }
        String str = TAG;
        StringBuilder sbR = c.a.a.a.a.r(" onPause -- ");
        sbR.append(downloadInfo.getName());
        com.ss.android.socialbase.downloader.c.a.b(str, sbR.toString());
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onPrepare(DownloadInfo downloadInfo) {
        if (!com.ss.android.socialbase.downloader.c.a.a() || downloadInfo == null) {
            return;
        }
        String str = TAG;
        StringBuilder sbR = c.a.a.a.a.r(" onPrepare -- ");
        sbR.append(downloadInfo.getName());
        com.ss.android.socialbase.downloader.c.a.b(str, sbR.toString());
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onProgress(DownloadInfo downloadInfo) {
        if (!com.ss.android.socialbase.downloader.c.a.a() || downloadInfo == null || downloadInfo.getTotalBytes() == 0) {
            return;
        }
        com.ss.android.socialbase.downloader.c.a.b(TAG, String.format("onProgress %s %.2f%%", downloadInfo.getName(), Float.valueOf((downloadInfo.getCurBytes() / downloadInfo.getTotalBytes()) * 100.0f)));
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onRetry(DownloadInfo downloadInfo, BaseException baseException) {
        if (!com.ss.android.socialbase.downloader.c.a.a() || downloadInfo == null) {
            return;
        }
        String str = TAG;
        Object[] objArr = new Object[2];
        objArr[0] = downloadInfo.getName();
        objArr[1] = baseException != null ? baseException.getErrorMessage() : "unkown";
        com.ss.android.socialbase.downloader.c.a.b(str, String.format("onRetry on %s because of : %s", objArr));
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onRetryDelay(DownloadInfo downloadInfo, BaseException baseException) {
        if (!com.ss.android.socialbase.downloader.c.a.a() || downloadInfo == null) {
            return;
        }
        String str = TAG;
        Object[] objArr = new Object[2];
        objArr[0] = downloadInfo.getName();
        objArr[1] = baseException != null ? baseException.getErrorMessage() : "unkown";
        com.ss.android.socialbase.downloader.c.a.b(str, String.format("onRetryDelay on %s because of : %s", objArr));
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onStart(DownloadInfo downloadInfo) {
        if (!com.ss.android.socialbase.downloader.c.a.a() || downloadInfo == null) {
            return;
        }
        String str = TAG;
        StringBuilder sbR = c.a.a.a.a.r(" onStart -- ");
        sbR.append(downloadInfo.getName());
        com.ss.android.socialbase.downloader.c.a.b(str, sbR.toString());
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onSuccessed(DownloadInfo downloadInfo) {
        if (!com.ss.android.socialbase.downloader.c.a.a() || downloadInfo == null) {
            return;
        }
        String str = TAG;
        StringBuilder sbR = c.a.a.a.a.r(" onSuccessed -- ");
        sbR.append(downloadInfo.getName());
        sbR.append(" ");
        sbR.append(downloadInfo.isSuccessByCache());
        com.ss.android.socialbase.downloader.c.a.b(str, sbR.toString());
    }
}

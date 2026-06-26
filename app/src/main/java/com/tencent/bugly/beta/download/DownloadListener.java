package com.tencent.bugly.beta.download;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes.dex */
public interface DownloadListener {
    void onCompleted(DownloadTask downloadTask);

    void onFailed(DownloadTask downloadTask, int i2, String str);

    void onReceive(DownloadTask downloadTask);
}

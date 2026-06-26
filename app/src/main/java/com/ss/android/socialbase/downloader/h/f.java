package com.ss.android.socialbase.downloader.h;

import com.ss.android.socialbase.downloader.exception.BaseException;

/* JADX INFO: compiled from: IDownloadRunnableCallback.java */
/* JADX INFO: loaded from: classes.dex */
public interface f {
    com.ss.android.socialbase.downloader.exception.h a(BaseException baseException, long j2);

    com.ss.android.socialbase.downloader.exception.h a(com.ss.android.socialbase.downloader.model.b bVar, BaseException baseException, long j2);

    com.ss.android.socialbase.downloader.model.b a(int i2);

    void a(long j2);

    void a(BaseException baseException, boolean z);

    void a(b bVar);

    void a(com.ss.android.socialbase.downloader.network.g gVar);

    void a(String str, com.ss.android.socialbase.downloader.network.g gVar, long j2);

    boolean a(BaseException baseException);

    void b(BaseException baseException);

    boolean b(long j2);

    void c(BaseException baseException);
}

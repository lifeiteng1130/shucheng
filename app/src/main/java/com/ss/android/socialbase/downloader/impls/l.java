package com.ss.android.socialbase.downloader.impls;

/* JADX INFO: compiled from: DownloadProxy.java */
/* JADX INFO: loaded from: classes.dex */
public class l {
    private static volatile com.ss.android.socialbase.downloader.downloader.m a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile com.ss.android.socialbase.downloader.downloader.m f3791b;

    public static com.ss.android.socialbase.downloader.downloader.m a(boolean z) {
        if (z && com.ss.android.socialbase.downloader.downloader.c.S()) {
            if (f3791b == null) {
                synchronized (l.class) {
                    if (f3791b == null) {
                        f3791b = com.ss.android.socialbase.downloader.downloader.c.T().b();
                    }
                }
            }
            return f3791b;
        }
        if (a == null) {
            synchronized (l.class) {
                if (a == null) {
                    a = new p();
                }
            }
        }
        return a;
    }
}

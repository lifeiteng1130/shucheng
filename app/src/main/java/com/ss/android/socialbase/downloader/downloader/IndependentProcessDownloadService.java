package com.ss.android.socialbase.downloader.downloader;

import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public class IndependentProcessDownloadService extends DownloadService {
    @Override // com.ss.android.socialbase.downloader.downloader.DownloadService, android.app.Service
    public void onCreate() {
        super.onCreate();
        c.a(this);
        if (c.T() == null) {
            c.a(new v());
        }
        o oVarZ = c.z();
        this.a = oVarZ;
        oVarZ.a(new WeakReference(this));
    }
}

package com.ss.android.socialbase.downloader.depend;

import java.util.List;

/* JADX INFO: compiled from: AbsDownloadForbiddenCallback.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class b implements v {
    private boolean a = false;

    @Override // com.ss.android.socialbase.downloader.depend.v
    public void a(List<String> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        this.a = true;
    }

    @Override // com.ss.android.socialbase.downloader.depend.v
    public boolean a() {
        return this.a;
    }
}

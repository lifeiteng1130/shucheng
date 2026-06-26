package com.ss.android.socialbase.downloader.exception;

/* JADX INFO: compiled from: DownloadTTNetException.java */
/* JADX INFO: loaded from: classes.dex */
public class g extends BaseException {
    public g(int i2, String str) {
        super(i2, str);
    }

    public g a(String str) {
        setExtraInfo(str);
        return this;
    }

    public String a() {
        return getExtraInfo();
    }
}

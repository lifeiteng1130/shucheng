package com.ss.android.socialbase.downloader.exception;

/* JADX INFO: compiled from: DownloadHttpException.java */
/* JADX INFO: loaded from: classes.dex */
public class b extends BaseException {
    private final int a;

    public b(int i2, int i3, String str) {
        super(i2, str);
        this.a = i3;
    }

    public int a() {
        return this.a;
    }
}

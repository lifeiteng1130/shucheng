package com.ss.android.socialbase.downloader.exception;

/* JADX INFO: compiled from: RetryThrowable.java */
/* JADX INFO: loaded from: classes.dex */
public class i extends Throwable {
    private String a;

    public i(String str) {
        super(str);
        this.a = str;
    }

    public String a() {
        return this.a;
    }
}

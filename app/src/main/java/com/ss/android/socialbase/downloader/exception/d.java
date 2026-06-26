package com.ss.android.socialbase.downloader.exception;

import androidx.core.view.PointerIconCompat;

/* JADX INFO: compiled from: DownloadOutOfSpaceException.java */
/* JADX INFO: loaded from: classes.dex */
public class d extends BaseException {
    private final long a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f3606b;

    public d(long j2, long j3) {
        super(PointerIconCompat.TYPE_CELL, String.format("space is not enough required space is : %s but available space is :%s", String.valueOf(j3), String.valueOf(j2)));
        this.a = j2;
        this.f3606b = j3;
    }

    public long a() {
        return this.a;
    }

    public long b() {
        return this.f3606b;
    }
}

package com.qq.e.comm.util;

/* JADX INFO: loaded from: classes.dex */
public class AdError {
    private int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f2867b;

    public AdError() {
    }

    public AdError(int i2, String str) {
        this.a = i2;
        this.f2867b = str;
    }

    public int getErrorCode() {
        return this.a;
    }

    public String getErrorMsg() {
        return this.f2867b;
    }
}

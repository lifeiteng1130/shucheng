package com.qq.e.comm.managers.status;

import androidx.core.os.EnvironmentCompat;

/* JADX INFO: loaded from: classes.dex */
public enum NetworkType {
    UNKNOWN(0, 1, EnvironmentCompat.MEDIA_UNKNOWN),
    WIFI(1, 2, "wifi"),
    NET_2G(2, 4, "2g"),
    NET_3G(3, 8, "3g"),
    NET_4G(4, 16, "4g");

    private int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f2846b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f2847c;

    NetworkType(int i2, int i3, String str) {
        this.a = i2;
        this.f2846b = i3;
        this.f2847c = str;
    }

    public int getConnValue() {
        return this.a;
    }

    public String getNameValue() {
        return this.f2847c;
    }

    public int getPermValue() {
        return this.f2846b;
    }
}

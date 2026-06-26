package com.efs.sdk.base.a.f;

import com.efs.sdk.base.Constants;

/* JADX INFO: loaded from: classes.dex */
public final class a {
    public String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public byte f1823b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f1824c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f1825d = Constants.CP_NONE;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f1826e = 1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f1827f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f1828g = 1;

    public a(String str, byte b2) {
        this.f1823b = (byte) 2;
        this.a = str;
        if (b2 <= 0 || 3 < b2) {
            throw new IllegalArgumentException("log protocol flag invalid : ".concat(String.valueOf((int) b2)));
        }
        this.f1823b = b2;
    }
}

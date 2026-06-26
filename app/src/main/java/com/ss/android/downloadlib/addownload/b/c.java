package com.ss.android.downloadlib.addownload.b;

import org.json.JSONObject;

/* JADX INFO: compiled from: DownloadInstallInfo.java */
/* JADX INFO: loaded from: classes.dex */
public class c {
    public static int a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f3037b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static int f3038c = 2;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f3039d = a;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f3040e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private JSONObject f3041f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f3042g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f3043h = "";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f3044i = "";

    public boolean a() {
        return this.f3039d == f3037b;
    }

    public int b() {
        return this.f3042g;
    }

    public c a(int i2) {
        this.f3039d = i2;
        return this;
    }

    public c b(int i2) {
        this.f3042g = i2;
        return this;
    }
}

package com.ss.android.downloadlib.addownload.b;

/* JADX INFO: compiled from: OpenAppResult.java */
/* JADX INFO: loaded from: classes.dex */
public class g {
    private int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f3059b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f3060c;

    public g(int i2) {
        this(i2, 0, null);
    }

    public int a() {
        return this.f3059b;
    }

    public String b() {
        return this.f3060c;
    }

    public int getType() {
        return this.a;
    }

    public g(int i2, int i3) {
        this(i2, i3, null);
    }

    public g(int i2, String str) {
        this(i2, 0, str);
    }

    public g(int i2, int i3, String str) {
        this.a = i2;
        this.f3059b = i3;
        this.f3060c = str;
    }
}

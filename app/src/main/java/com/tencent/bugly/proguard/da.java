package com.tencent.bugly.proguard;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes.dex */
public class da implements Runnable {
    private final Handler a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f4357b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f4358c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f4359d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f4360e = true;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f4361f;

    public da(Handler handler, String str, long j2) {
        this.a = handler;
        this.f4357b = str;
        this.f4358c = j2;
        this.f4359d = j2;
    }

    public int a() {
        if (this.f4360e) {
            return 0;
        }
        return SystemClock.uptimeMillis() - this.f4361f < this.f4358c ? 1 : 3;
    }

    public Looper b() {
        return this.a.getLooper();
    }

    public String c() {
        return this.f4357b;
    }

    public boolean d() {
        return !this.f4360e && SystemClock.uptimeMillis() > this.f4361f + this.f4358c;
    }

    public void e() {
        this.f4358c = this.f4359d;
    }

    public void f() {
        if (this.f4360e) {
            this.f4360e = false;
            this.f4361f = SystemClock.uptimeMillis();
            this.a.post(this);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f4360e = true;
        e();
    }

    public void a(long j2) {
        this.f4358c = j2;
    }
}

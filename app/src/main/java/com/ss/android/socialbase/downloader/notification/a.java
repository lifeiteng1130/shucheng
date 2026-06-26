package com.ss.android.socialbase.downloader.notification;

import android.app.Notification;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* JADX INFO: compiled from: AbsNotificationItem.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class a {
    public Notification a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f3931b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f3932c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f3933d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f3934e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f3935f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f3936g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f3937h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f3938i;

    public a(int i2, String str) {
        this.f3931b = i2;
        this.f3934e = str;
    }

    public abstract void a(BaseException baseException, boolean z);

    public void a(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return;
        }
        this.f3931b = downloadInfo.getId();
        this.f3934e = downloadInfo.getTitle();
    }

    public long b() {
        return this.f3932c;
    }

    public long c() {
        return this.f3933d;
    }

    public String d() {
        return this.f3934e;
    }

    public int e() {
        return this.f3935f;
    }

    public long f() {
        if (this.f3936g == 0) {
            this.f3936g = System.currentTimeMillis();
        }
        return this.f3936g;
    }

    public synchronized void g() {
        this.f3937h++;
    }

    public int h() {
        return this.f3937h;
    }

    public boolean i() {
        return this.f3938i;
    }

    public void b(long j2) {
        this.f3933d = j2;
    }

    public int a() {
        return this.f3931b;
    }

    public void a(long j2) {
        this.f3932c = j2;
    }

    public void a(int i2, BaseException baseException, boolean z) {
        a(i2, baseException, z, false);
    }

    public void a(int i2, BaseException baseException, boolean z, boolean z2) {
        if (z2 || this.f3935f != i2) {
            this.f3935f = i2;
            a(baseException, z);
        }
    }

    public void a(long j2, long j3) {
        this.f3932c = j2;
        this.f3933d = j3;
        this.f3935f = 4;
        a((BaseException) null, false);
    }

    public void a(Notification notification) {
        if (this.f3931b == 0 || notification == null) {
            return;
        }
        b.a().a(this.f3931b, this.f3935f, notification);
    }

    public void a(boolean z) {
        this.f3938i = z;
    }
}

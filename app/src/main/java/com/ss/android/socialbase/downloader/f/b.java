package com.ss.android.socialbase.downloader.f;

import androidx.annotation.NonNull;

/* JADX INFO: compiled from: BufferQueue.java */
/* JADX INFO: loaded from: classes.dex */
public class b implements c, d, e {
    private final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f3612b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Object f3613c = new Object();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Object f3614d = new Object();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private a f3615e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private a f3616f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private a f3617g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private a f3618h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private a f3619i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private volatile boolean f3620j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f3621k;

    public b(int i2, int i3) {
        i2 = i2 < 64 ? 64 : i2;
        i3 = i3 < 8192 ? 8192 : i3;
        this.a = i2;
        this.f3612b = i3;
    }

    @Override // com.ss.android.socialbase.downloader.f.d
    @NonNull
    public a a() {
        a aVar;
        a aVar2 = this.f3619i;
        if (aVar2 != null) {
            this.f3619i = aVar2.f3611d;
            aVar2.f3611d = null;
            return aVar2;
        }
        synchronized (this.f3614d) {
            aVar = this.f3617g;
            while (aVar == null) {
                if (this.f3620j) {
                    throw new p("read");
                }
                this.f3614d.wait();
                aVar = this.f3617g;
            }
            this.f3619i = aVar.f3611d;
            this.f3618h = null;
            this.f3617g = null;
            aVar.f3611d = null;
        }
        return aVar;
    }

    @Override // com.ss.android.socialbase.downloader.f.c
    @NonNull
    public a b() {
        synchronized (this.f3613c) {
            if (this.f3620j) {
                throw new p("obtain");
            }
            a aVar = this.f3615e;
            if (aVar == null) {
                int i2 = this.f3621k;
                if (i2 < this.a) {
                    this.f3621k = i2 + 1;
                    return new a(this.f3612b);
                }
                do {
                    this.f3613c.wait();
                    if (this.f3620j) {
                        throw new p("obtain");
                    }
                    aVar = this.f3615e;
                } while (aVar == null);
            }
            this.f3615e = aVar.f3611d;
            if (aVar == this.f3616f) {
                this.f3616f = null;
            }
            aVar.f3611d = null;
            return aVar;
        }
    }

    public void c() {
        this.f3620j = true;
        synchronized (this.f3613c) {
            this.f3613c.notifyAll();
        }
        synchronized (this.f3614d) {
            this.f3614d.notifyAll();
        }
    }

    @Override // com.ss.android.socialbase.downloader.f.c
    public void a(@NonNull a aVar) {
        synchronized (this.f3613c) {
            a aVar2 = this.f3616f;
            if (aVar2 == null) {
                this.f3616f = aVar;
                this.f3615e = aVar;
            } else {
                aVar2.f3611d = aVar;
                this.f3616f = aVar;
            }
            this.f3613c.notify();
        }
    }

    @Override // com.ss.android.socialbase.downloader.f.e
    public void b(@NonNull a aVar) {
        synchronized (this.f3614d) {
            a aVar2 = this.f3618h;
            if (aVar2 == null) {
                this.f3618h = aVar;
                this.f3617g = aVar;
                this.f3614d.notify();
            } else {
                aVar2.f3611d = aVar;
                this.f3618h = aVar;
            }
        }
    }
}

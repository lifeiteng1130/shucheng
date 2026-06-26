package com.ss.android.socialbase.downloader.e;

import android.os.Process;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.f.p;
import com.ss.android.socialbase.downloader.i.f;
import java.io.InputStream;
import java.util.concurrent.Future;

/* JADX INFO: compiled from: AsyncStreamReader.java */
/* JADX INFO: loaded from: classes.dex */
public class a implements b {
    private final InputStream a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f3594b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f3595c;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private com.ss.android.socialbase.downloader.f.a f3598f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private com.ss.android.socialbase.downloader.f.a f3599g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private com.ss.android.socialbase.downloader.f.a f3600h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private com.ss.android.socialbase.downloader.f.a f3601i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private com.ss.android.socialbase.downloader.f.a f3602j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private com.ss.android.socialbase.downloader.f.a f3603k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private volatile boolean f3604l;
    private volatile boolean m;
    private volatile Throwable n;
    private volatile Future o;
    private int p;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Object f3596d = new Object();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Object f3597e = new Object();
    private final Runnable q = new Runnable() { // from class: com.ss.android.socialbase.downloader.e.a.1
        @Override // java.lang.Runnable
        public void run() {
            com.ss.android.socialbase.downloader.f.a aVarD;
            Process.setThreadPriority(10);
            do {
                try {
                    aVarD = a.this.d();
                    aVarD.f3610c = a.this.a.read(aVarD.a);
                    a.this.c(aVarD);
                } catch (Throwable th) {
                    try {
                        a.this.n = th;
                        th.printStackTrace();
                        synchronized (a.this.f3597e) {
                            a.this.m = true;
                            a.this.f3597e.notify();
                            f.a(a.this.a);
                            return;
                        }
                    } catch (Throwable th2) {
                        synchronized (a.this.f3597e) {
                            a.this.m = true;
                            a.this.f3597e.notify();
                            f.a(a.this.a);
                            throw th2;
                        }
                    }
                }
            } while (aVarD.f3610c != -1);
            synchronized (a.this.f3597e) {
                a.this.m = true;
                a.this.f3597e.notify();
            }
            f.a(a.this.a);
        }
    };

    public a(InputStream inputStream, int i2, int i3) {
        this.a = inputStream;
        this.f3594b = i2;
        if (i3 < 1) {
            i3 = 1;
        } else if (i3 > 64) {
            i3 = 64;
        }
        this.f3595c = i3;
        c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.ss.android.socialbase.downloader.f.a d() throws p {
        int i2;
        com.ss.android.socialbase.downloader.f.a aVar = this.f3600h;
        if (aVar != null) {
            if (this.f3604l) {
                throw new p("");
            }
            this.f3600h = aVar.f3611d;
            aVar.f3611d = null;
            return aVar;
        }
        synchronized (this.f3596d) {
            if (this.f3604l) {
                throw new p("");
            }
            com.ss.android.socialbase.downloader.f.a aVar2 = this.f3598f;
            if (aVar2 == null && (i2 = this.p) < this.f3595c) {
                this.p = i2 + 1;
                return new com.ss.android.socialbase.downloader.f.a(this.f3594b);
            }
            while (aVar2 == null) {
                this.f3596d.wait();
                if (this.f3604l) {
                    throw new p("");
                }
                aVar2 = this.f3598f;
            }
            this.f3600h = aVar2.f3611d;
            this.f3599g = null;
            this.f3598f = null;
            aVar2.f3611d = null;
            return aVar2;
        }
    }

    private com.ss.android.socialbase.downloader.f.a e() {
        com.ss.android.socialbase.downloader.f.a aVar;
        com.ss.android.socialbase.downloader.f.a aVar2 = this.f3603k;
        if (aVar2 != null) {
            this.f3603k = aVar2.f3611d;
            aVar2.f3611d = null;
            return aVar2;
        }
        synchronized (this.f3597e) {
            aVar = this.f3601i;
            if (aVar == null) {
                do {
                    if (this.m) {
                        f();
                    }
                    this.f3597e.wait();
                    aVar = this.f3601i;
                } while (aVar == null);
            }
            this.f3603k = aVar.f3611d;
            this.f3602j = null;
            this.f3601i = null;
            aVar.f3611d = null;
        }
        return aVar;
    }

    private void f() throws BaseException {
        Throwable th = this.n;
        if (th != null) {
            if (th instanceof p) {
                throw new BaseException(1068, "async reader closed!");
            }
            f.a(th, "async_read");
        }
        throw new BaseException(1069, "async reader terminated!");
    }

    private void c() {
        this.o = com.ss.android.socialbase.downloader.downloader.c.q().submit(this.q);
    }

    @Override // com.ss.android.socialbase.downloader.e.b
    public void b() {
        synchronized (this.f3596d) {
            this.f3604l = true;
            this.f3596d.notify();
        }
        Future future = this.o;
        if (future != null) {
            try {
                future.cancel(true);
            } catch (Throwable unused) {
            }
            this.o = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.ss.android.socialbase.downloader.f.a aVar) {
        synchronized (this.f3597e) {
            com.ss.android.socialbase.downloader.f.a aVar2 = this.f3602j;
            if (aVar2 == null) {
                this.f3602j = aVar;
                this.f3601i = aVar;
                this.f3597e.notify();
            } else {
                aVar2.f3611d = aVar;
                this.f3602j = aVar;
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.e.b
    public com.ss.android.socialbase.downloader.f.a a() {
        return e();
    }

    @Override // com.ss.android.socialbase.downloader.e.b
    public void a(com.ss.android.socialbase.downloader.f.a aVar) {
        b(aVar);
    }

    private void b(com.ss.android.socialbase.downloader.f.a aVar) {
        synchronized (this.f3596d) {
            com.ss.android.socialbase.downloader.f.a aVar2 = this.f3599g;
            if (aVar2 == null) {
                this.f3599g = aVar;
                this.f3598f = aVar;
                this.f3596d.notify();
            } else {
                aVar2.f3611d = aVar;
                this.f3599g = aVar;
            }
        }
    }
}

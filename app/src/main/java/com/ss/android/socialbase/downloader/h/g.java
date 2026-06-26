package com.ss.android.socialbase.downloader.h;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: compiled from: ThreadWithHandler.java */
/* JADX INFO: loaded from: classes.dex */
public class g {
    private Object a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Queue<b> f3713b = new ConcurrentLinkedQueue();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private a f3714c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Handler f3715d;

    /* JADX INFO: compiled from: ThreadWithHandler.java */
    public class a extends HandlerThread {
        public a(String str) {
            super(str);
        }

        @Override // android.os.HandlerThread
        public void onLooperPrepared() {
            super.onLooperPrepared();
            Looper looper = getLooper();
            synchronized (g.this.a) {
                g.this.f3715d = new Handler(looper);
            }
            while (!g.this.f3713b.isEmpty()) {
                b bVar = (b) g.this.f3713b.poll();
                g.this.f3715d.postDelayed(bVar.a, bVar.f3716b);
            }
        }
    }

    /* JADX INFO: compiled from: ThreadWithHandler.java */
    public class b {
        public Runnable a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f3716b;

        public b(Runnable runnable, long j2) {
            this.a = runnable;
            this.f3716b = j2;
        }
    }

    public g(String str) {
        this.f3714c = new a(str);
    }

    public void b() {
        this.f3714c.quit();
    }

    public void a() {
        this.f3714c.start();
    }

    public void a(Runnable runnable) {
        a(runnable, 0L);
    }

    public void a(Runnable runnable, long j2) {
        if (this.f3715d == null) {
            synchronized (this.a) {
                if (this.f3715d == null) {
                    this.f3713b.add(new b(runnable, j2));
                    return;
                }
            }
        }
        this.f3715d.postDelayed(runnable, j2);
    }
}

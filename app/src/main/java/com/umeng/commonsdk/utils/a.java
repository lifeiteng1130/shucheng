package com.umeng.commonsdk.utils;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;

/* JADX INFO: compiled from: CountDownTimer.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int f5411e = 1;
    private final long a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f5412b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f5413c;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private HandlerThread f5415f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Handler f5416g;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f5414d = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Handler.Callback f5417h = new Handler.Callback() { // from class: com.umeng.commonsdk.utils.a.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            synchronized (a.this) {
                if (a.this.f5414d) {
                    return true;
                }
                long jElapsedRealtime = a.this.f5413c - SystemClock.elapsedRealtime();
                if (jElapsedRealtime <= 0) {
                    a.this.c();
                    if (a.this.f5415f != null) {
                        a.this.f5415f.quit();
                    }
                } else if (jElapsedRealtime < a.this.f5412b) {
                    a.this.f5416g.sendMessageDelayed(a.this.f5416g.obtainMessage(1), jElapsedRealtime);
                } else {
                    long jElapsedRealtime2 = SystemClock.elapsedRealtime();
                    a.this.a(jElapsedRealtime);
                    long jElapsedRealtime3 = (jElapsedRealtime2 + a.this.f5412b) - SystemClock.elapsedRealtime();
                    while (jElapsedRealtime3 < 0) {
                        jElapsedRealtime3 += a.this.f5412b;
                    }
                    a.this.f5416g.sendMessageDelayed(a.this.f5416g.obtainMessage(1), jElapsedRealtime3);
                }
                return false;
            }
        }
    };

    public a(long j2, long j3) {
        this.a = j2;
        this.f5412b = j3;
        if (d()) {
            this.f5416g = new Handler(this.f5417h);
            return;
        }
        HandlerThread handlerThread = new HandlerThread("CountDownTimerThread");
        this.f5415f = handlerThread;
        handlerThread.start();
        this.f5416g = new Handler(this.f5415f.getLooper(), this.f5417h);
    }

    public abstract void a(long j2);

    public abstract void c();

    private boolean d() {
        return Looper.getMainLooper().getThread().equals(Thread.currentThread());
    }

    public final synchronized void a() {
        this.f5414d = true;
        this.f5416g.removeMessages(1);
    }

    public final synchronized a b() {
        this.f5414d = false;
        if (this.a <= 0) {
            c();
            return this;
        }
        this.f5413c = SystemClock.elapsedRealtime() + this.a;
        Handler handler = this.f5416g;
        handler.sendMessage(handler.obtainMessage(1));
        return this;
    }
}

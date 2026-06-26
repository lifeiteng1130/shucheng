package com.ss.android.socialbase.downloader.network;

import android.net.TrafficStats;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: DeviceBandwidthSampler.java */
/* JADX INFO: loaded from: classes.dex */
public class b {
    public static volatile boolean a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f3884b = "b";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static long f3885g = -1;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static volatile b f3886h;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final k f3887c = k.a();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final AtomicInteger f3888d = new AtomicInteger();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final a f3889e = new a(com.ss.android.socialbase.downloader.h.e.a());

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f3890f;

    /* JADX INFO: compiled from: DeviceBandwidthSampler.java */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        public void a() {
            sendEmptyMessage(1);
        }

        public void b() {
            removeMessages(1);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 1) {
                return;
            }
            b.this.f();
            sendEmptyMessageDelayed(1, 1000L);
        }
    }

    private b() {
    }

    public static b a() {
        if (f3886h == null) {
            synchronized (b.class) {
                if (f3886h == null) {
                    f3886h = new b();
                }
            }
        }
        return f3886h;
    }

    public static long d() {
        return TrafficStats.getTotalRxBytes() - TrafficStats.getMobileRxBytes();
    }

    public static void e() {
        a = com.ss.android.socialbase.downloader.i.f.b(com.ss.android.socialbase.downloader.downloader.c.N());
    }

    public void b() {
        try {
            com.ss.android.socialbase.downloader.c.a.c(f3884b, "startSampling: mSamplingCounter = " + this.f3888d);
            if (this.f3888d.getAndIncrement() == 0) {
                this.f3889e.a();
                this.f3890f = SystemClock.uptimeMillis();
            }
        } catch (Throwable unused) {
        }
    }

    public void c() {
        try {
            com.ss.android.socialbase.downloader.c.a.c(f3884b, "stopSampling: mSamplingCounter = " + this.f3888d);
            if (this.f3888d.decrementAndGet() == 0) {
                this.f3889e.b();
                g();
            }
        } catch (Throwable unused) {
        }
    }

    public void f() {
        try {
            e();
            long jD = a ? d() : TrafficStats.getMobileRxBytes();
            long j2 = f3885g;
            long j3 = jD - j2;
            if (j2 >= 0) {
                synchronized (this) {
                    long jUptimeMillis = SystemClock.uptimeMillis();
                    this.f3887c.a(j3, jUptimeMillis - this.f3890f);
                    this.f3890f = jUptimeMillis;
                }
            }
            f3885g = jD;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void g() {
        f();
        f3885g = -1L;
    }
}

package com.tencent.bugly.proguard;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes.dex */
public class W {
    private static final AtomicInteger a = new AtomicInteger(1);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static W f4327b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ScheduledExecutorService f4328c;

    public W() {
        this.f4328c = null;
        ScheduledExecutorService scheduledExecutorServiceNewScheduledThreadPool = Executors.newScheduledThreadPool(3, new V(this));
        this.f4328c = scheduledExecutorServiceNewScheduledThreadPool;
        if (scheduledExecutorServiceNewScheduledThreadPool == null || scheduledExecutorServiceNewScheduledThreadPool.isShutdown()) {
            X.e("[AsyncTaskHandler] ScheduledExecutorService is not valiable!", new Object[0]);
        }
    }

    public static synchronized W c() {
        if (f4327b == null) {
            f4327b = new W();
        }
        return f4327b;
    }

    public synchronized void b() {
        ScheduledExecutorService scheduledExecutorService = this.f4328c;
        if (scheduledExecutorService != null && !scheduledExecutorService.isShutdown()) {
            X.a("[AsyncTaskHandler] Close async handler.", new Object[0]);
            this.f4328c.shutdownNow();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x000d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized boolean d() {
        /*
            r1 = this;
            monitor-enter(r1)
            java.util.concurrent.ScheduledExecutorService r0 = r1.f4328c     // Catch: java.lang.Throwable -> L10
            if (r0 == 0) goto Ld
            boolean r0 = r0.isShutdown()     // Catch: java.lang.Throwable -> L10
            if (r0 != 0) goto Ld
            r0 = 1
            goto Le
        Ld:
            r0 = 0
        Le:
            monitor-exit(r1)
            return r0
        L10:
            r0 = move-exception
            monitor-exit(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.W.d():boolean");
    }

    public synchronized boolean a(Runnable runnable, long j2) {
        if (!d()) {
            X.e("[AsyncTaskHandler] Async handler was closed, should not post task.", new Object[0]);
            return false;
        }
        if (runnable == null) {
            X.e("[AsyncTaskHandler] Task input is null.", new Object[0]);
            return false;
        }
        if (j2 <= 0) {
            j2 = 0;
        }
        X.a("[AsyncTaskHandler] Post a delay(time: %dms) task: %s", Long.valueOf(j2), runnable.getClass().getName());
        try {
            this.f4328c.schedule(runnable, j2, TimeUnit.MILLISECONDS);
            return true;
        } catch (Throwable th) {
            if (com.tencent.bugly.b.f3960c) {
                th.printStackTrace();
            }
            return false;
        }
    }

    public synchronized boolean a(Runnable runnable) {
        if (!d()) {
            X.e("[AsyncTaskHandler] Async handler was closed, should not post task.", new Object[0]);
            return false;
        }
        if (runnable == null) {
            X.e("[AsyncTaskHandler] Task input is null.", new Object[0]);
            return false;
        }
        X.a("[AsyncTaskHandler] Post a normal task: %s", runnable.getClass().getName());
        try {
            this.f4328c.execute(runnable);
            return true;
        } catch (Throwable th) {
            if (com.tencent.bugly.b.f3960c) {
                th.printStackTrace();
            }
            return false;
        }
    }
}

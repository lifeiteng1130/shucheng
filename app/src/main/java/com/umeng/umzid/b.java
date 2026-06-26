package com.umeng.umzid;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes3.dex */
public class b {
    public static volatile ScheduledThreadPoolExecutor a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static ThreadFactory f5450b = new a();

    public static class a implements ThreadFactory {
        public AtomicInteger a = new AtomicInteger(0);

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            StringBuilder sbR = c.a.a.a.a.r("ZIDThreadPoolExecutor");
            sbR.append(this.a.addAndGet(1));
            thread.setName(sbR.toString());
            return thread;
        }
    }

    public static ScheduledThreadPoolExecutor a() {
        if (a == null) {
            synchronized (b.class) {
                if (a == null) {
                    a = new ScheduledThreadPoolExecutor(Runtime.getRuntime().availableProcessors() * 4, f5450b);
                }
            }
        }
        return a;
    }

    public static void a(Runnable runnable) {
        try {
            a().execute(runnable);
        } catch (Throwable unused) {
        }
    }
}

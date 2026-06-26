package com.ss.android.socialbase.downloader.h;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: DefaultThreadFactory.java */
/* JADX INFO: loaded from: classes.dex */
public class a implements ThreadFactory {
    private final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AtomicInteger f3686b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f3687c;

    public a(String str) {
        this(str, false);
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable, this.a + "-" + this.f3686b.incrementAndGet());
        if (!this.f3687c) {
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            if (thread.getPriority() != 5) {
                thread.setPriority(5);
            }
        }
        return thread;
    }

    public a(String str, boolean z) {
        this.f3686b = new AtomicInteger();
        this.a = str;
        this.f3687c = z;
    }
}

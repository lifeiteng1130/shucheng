package com.tencent.bugly.proguard;

import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes.dex */
public class S implements Runnable {
    public final /* synthetic */ int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LinkedBlockingQueue f4303b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ T f4304c;

    public S(T t, int i2, LinkedBlockingQueue linkedBlockingQueue) {
        this.f4304c = t;
        this.a = i2;
        this.f4303b = linkedBlockingQueue;
    }

    @Override // java.lang.Runnable
    public void run() {
        Runnable runnable;
        for (int i2 = 0; i2 < this.a && (runnable = (Runnable) this.f4303b.poll()) != null; i2++) {
            runnable.run();
        }
    }
}

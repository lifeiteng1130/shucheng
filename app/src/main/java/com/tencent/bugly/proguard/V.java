package com.tencent.bugly.proguard;

import java.util.concurrent.ThreadFactory;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes.dex */
public class V implements ThreadFactory {
    public final /* synthetic */ W a;

    public V(W w) {
        this.a = w;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable);
        StringBuilder sbR = c.a.a.a.a.r("BuglyThread-");
        sbR.append(W.a.getAndIncrement());
        thread.setName(sbR.toString());
        return thread;
    }
}

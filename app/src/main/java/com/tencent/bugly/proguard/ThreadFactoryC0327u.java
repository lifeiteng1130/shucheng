package com.tencent.bugly.proguard;

import java.util.concurrent.ThreadFactory;

/* JADX INFO: renamed from: com.tencent.bugly.proguard.u, reason: case insensitive filesystem */
/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes.dex */
public class ThreadFactoryC0327u implements ThreadFactory {
    public final /* synthetic */ C0328v a;

    public ThreadFactoryC0327u(C0328v c0328v) {
        this.a = c0328v;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable);
        thread.setName("BETA_SDK_DOWNLOAD");
        return thread;
    }
}

package com.tencent.bugly.crashreport.crash;

import com.tencent.bugly.proguard.X;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes.dex */
public class a implements Runnable {
    public final /* synthetic */ BuglyBroadcastReceiver a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ BuglyBroadcastReceiver f4141b;

    public a(BuglyBroadcastReceiver buglyBroadcastReceiver, BuglyBroadcastReceiver buglyBroadcastReceiver2) {
        this.f4141b = buglyBroadcastReceiver;
        this.a = buglyBroadcastReceiver2;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            X.c(BuglyBroadcastReceiver.a.getClass(), "Register broadcast receiver of Bugly.", new Object[0]);
            synchronized (this.a) {
                this.f4141b.f4127c.registerReceiver(BuglyBroadcastReceiver.a, this.f4141b.f4126b, "com.tencent.bugly.BuglyBroadcastReceiver.permission", null);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}

package com.tencent.bugly.proguard;

/* JADX INFO: renamed from: com.tencent.bugly.proguard.q, reason: case insensitive filesystem */
/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes.dex */
public class RunnableC0324q implements Runnable {
    public final /* synthetic */ C0330x a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ r f4419b;

    public RunnableC0324q(r rVar, C0330x c0330x) {
        this.f4419b = rVar;
        this.a = c0330x;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.tencent.bugly.beta.global.e.f3983b.Y.onPatchReceived(this.a.a());
    }
}

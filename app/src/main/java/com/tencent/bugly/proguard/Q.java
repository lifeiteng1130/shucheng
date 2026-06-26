package com.tencent.bugly.proguard;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes.dex */
public class Q implements Runnable {
    public final /* synthetic */ Runnable a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ T f4302b;

    public Q(T t, Runnable runnable) {
        this.f4302b = t;
        this.a = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.run();
        synchronized (this.f4302b.f4313j) {
            T.b(this.f4302b);
        }
    }
}

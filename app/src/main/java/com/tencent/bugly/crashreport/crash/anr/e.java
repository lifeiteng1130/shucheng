package com.tencent.bugly.crashreport.crash.anr;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes.dex */
public class e implements Runnable {
    public final /* synthetic */ h a;

    public e(h hVar) {
        this.a = hVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.d();
    }
}

package com.tencent.bugly.crashreport.crash;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes.dex */
public class i implements Runnable {
    public final /* synthetic */ k a;

    public i(k kVar) {
        this.a = kVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.b();
    }
}

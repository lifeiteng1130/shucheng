package com.tencent.bugly.crashreport.crash.anr;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes.dex */
public class b implements Runnable {
    public final /* synthetic */ String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c f4151b;

    public b(c cVar, String str) {
        this.f4151b = cVar;
        this.a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f4151b.a.a(this.a);
    }
}

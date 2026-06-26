package com.tencent.bugly.beta.upgrade;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes.dex */
public class c implements Runnable {
    public final /* synthetic */ boolean a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d f4005b;

    public c(d dVar, boolean z) {
        this.f4005b = dVar;
        this.a = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f4005b.a(this.a);
    }
}

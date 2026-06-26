package com.tencent.bugly.proguard;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes.dex */
public class G implements Runnable {
    public final /* synthetic */ int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ H f4272b;

    public G(H h2, int i2) {
        this.f4272b = h2;
        this.a = i2;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean zB = this.f4272b.b(this.a);
        this.f4272b.f4277f.edit().putBoolean(this.a + "_" + this.f4272b.f4275d, !zB).commit();
    }
}

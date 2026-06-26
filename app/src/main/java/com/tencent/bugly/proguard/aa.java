package com.tencent.bugly.proguard;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes.dex */
public class aa implements Runnable {
    public final /* synthetic */ String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f4333b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f4334c;

    public aa(String str, String str2, String str3) {
        this.a = str;
        this.f4333b = str2;
        this.f4334c = str3;
    }

    @Override // java.lang.Runnable
    public void run() {
        ba.d(this.a, this.f4333b, this.f4334c);
    }
}

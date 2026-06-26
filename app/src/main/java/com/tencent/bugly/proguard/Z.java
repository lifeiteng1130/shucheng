package com.tencent.bugly.proguard;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes.dex */
public class Z implements Runnable {
    public final /* synthetic */ String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f4331b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f4332c;

    public Z(String str, String str2, String str3) {
        this.a = str;
        this.f4331b = str2;
        this.f4332c = str3;
    }

    @Override // java.lang.Runnable
    public void run() {
        ba.f(this.a, this.f4331b, this.f4332c);
    }
}

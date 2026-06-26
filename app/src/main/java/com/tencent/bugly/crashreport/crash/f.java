package com.tencent.bugly.crashreport.crash;

import com.tencent.bugly.proguard.X;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes.dex */
public class f implements Runnable {
    public final /* synthetic */ boolean a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Thread f4178b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Throwable f4179c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f4180d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ byte[] f4181e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ boolean f4182f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ h f4183g;

    public f(h hVar, boolean z, Thread thread, Throwable th, String str, byte[] bArr, boolean z2) {
        this.f4183g = hVar;
        this.a = z;
        this.f4178b = thread;
        this.f4179c = th;
        this.f4180d = str;
        this.f4181e = bArr;
        this.f4182f = z2;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            X.a("post a throwable %b", Boolean.valueOf(this.a));
            this.f4183g.s.b(this.f4178b, this.f4179c, false, this.f4180d, this.f4181e);
            if (this.f4182f) {
                X.c("clear user datas", new Object[0]);
                com.tencent.bugly.crashreport.common.info.a.a(this.f4183g.q).a();
            }
        } catch (Throwable th) {
            if (!X.a(th)) {
                th.printStackTrace();
            }
            X.b("java catch error: %s", this.f4179c.toString());
        }
    }
}

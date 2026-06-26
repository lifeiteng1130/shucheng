package com.tencent.bugly.crashreport.crash;

import com.tencent.bugly.proguard.X;
import java.util.Map;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes.dex */
public class j implements Runnable {
    public final /* synthetic */ Thread a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f4210b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f4211c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f4212d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ String f4213e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Map f4214f;

    public j(Thread thread, int i2, String str, String str2, String str3, Map map) {
        this.a = thread;
        this.f4210b = i2;
        this.f4211c = str;
        this.f4212d = str2;
        this.f4213e = str3;
        this.f4214f = map;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (k.a == null) {
                X.b("[ExtraCrashManager] Extra crash manager has not been initialized.", new Object[0]);
            } else {
                k.a.b(this.a, this.f4210b, this.f4211c, this.f4212d, this.f4213e, this.f4214f);
            }
        } catch (Throwable th) {
            if (!X.a(th)) {
                th.printStackTrace();
            }
            X.b("[ExtraCrashManager] Crash error %s %s %s", this.f4211c, this.f4212d, this.f4213e);
        }
    }
}

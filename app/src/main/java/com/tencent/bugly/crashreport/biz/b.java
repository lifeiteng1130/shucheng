package com.tencent.bugly.crashreport.biz;

import com.tencent.bugly.proguard.X;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes.dex */
public class b implements Runnable {
    public final /* synthetic */ c a;

    public b(c cVar) {
        this.a = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.a.c();
        } catch (Throwable th) {
            X.b(th);
        }
    }
}

package com.tencent.bugly.crashreport.biz;

import android.content.Context;
import com.tencent.bugly.BuglyStrategy;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes.dex */
public class d implements Runnable {
    public final /* synthetic */ Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ BuglyStrategy f4077b;

    public d(Context context, BuglyStrategy buglyStrategy) {
        this.a = context;
        this.f4077b = buglyStrategy;
    }

    @Override // java.lang.Runnable
    public void run() {
        f.c(this.a, this.f4077b);
    }
}

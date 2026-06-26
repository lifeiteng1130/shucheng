package com.umeng.analytics.pro;

import com.umeng.analytics.AnalyticsConfig;
import java.lang.Thread;

/* JADX INFO: compiled from: CrashHandler.java */
/* JADX INFO: loaded from: classes.dex */
public class o implements Thread.UncaughtExceptionHandler {
    private Thread.UncaughtExceptionHandler a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private s f4944b;

    public o() {
        if (Thread.getDefaultUncaughtExceptionHandler() == this) {
            return;
        }
        this.a = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    public void a(s sVar) {
        this.f4944b = sVar;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        a(th);
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.a;
        if (uncaughtExceptionHandler == null || uncaughtExceptionHandler == Thread.getDefaultUncaughtExceptionHandler()) {
            return;
        }
        this.a.uncaughtException(thread, th);
    }

    private void a(Throwable th) {
        if (AnalyticsConfig.CATCH_EXCEPTION) {
            this.f4944b.a(th);
        } else {
            this.f4944b.a(null);
        }
    }
}

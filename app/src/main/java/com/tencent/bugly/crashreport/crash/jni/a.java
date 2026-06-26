package com.tencent.bugly.crashreport.crash.jni;

import androidx.room.RoomDatabase;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.proguard.X;
import com.tencent.bugly.proguard.ca;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes.dex */
public class a implements Runnable {
    public final /* synthetic */ NativeCrashHandler a;

    public a(NativeCrashHandler nativeCrashHandler) {
        this.a = nativeCrashHandler;
    }

    @Override // java.lang.Runnable
    public void run() throws Throwable {
        if (!ca.a(this.a.f4219f, "native_record_lock", 10000L)) {
            X.c("[Native] Failed to lock file for handling native crash record.", new Object[0]);
            return;
        }
        if (!NativeCrashHandler.f4218e) {
            this.a.a(RoomDatabase.MAX_BIND_PARAMETER_CNT, "false");
        }
        CrashDetailBean crashDetailBeanA = c.a(this.a.f4219f, this.a.f4223j, this.a.f4222i);
        if (crashDetailBeanA != null) {
            X.c("[Native] Get crash from native record.", new Object[0]);
            if (!this.a.p.c(crashDetailBeanA)) {
                this.a.p.a(crashDetailBeanA, 3000L, false);
            }
            c.a(false, this.a.f4223j);
        }
        this.a.b();
        ca.b(this.a.f4219f, "native_record_lock");
    }
}

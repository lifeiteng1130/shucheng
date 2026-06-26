package com.tencent.bugly.crashreport.biz;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import androidx.core.os.EnvironmentCompat;
import com.tencent.bugly.proguard.X;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes.dex */
public class e implements Application.ActivityLifecycleCallbacks {
    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        String name = activity != null ? activity.getClass().getName() : EnvironmentCompat.MEDIA_UNKNOWN;
        if (f.f4088l == null || f.f4088l.getName().equals(name)) {
            X.a(">>> %s onCreated <<<", name);
            com.tencent.bugly.crashreport.common.info.a aVarM = com.tencent.bugly.crashreport.common.info.a.m();
            if (aVarM != null) {
                aVarM.na.add(f.b(name, "onCreated"));
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        String name = activity != null ? activity.getClass().getName() : EnvironmentCompat.MEDIA_UNKNOWN;
        if (f.f4088l == null || f.f4088l.getName().equals(name)) {
            X.a(">>> %s onDestroyed <<<", name);
            com.tencent.bugly.crashreport.common.info.a aVarM = com.tencent.bugly.crashreport.common.info.a.m();
            if (aVarM != null) {
                aVarM.na.add(f.b(name, "onDestroyed"));
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        String name = activity != null ? activity.getClass().getName() : EnvironmentCompat.MEDIA_UNKNOWN;
        if (f.f4088l == null || f.f4088l.getName().equals(name)) {
            X.a(">>> %s onPaused <<<", name);
            com.tencent.bugly.crashreport.common.info.a aVarM = com.tencent.bugly.crashreport.common.info.a.m();
            if (aVarM == null) {
                return;
            }
            aVarM.na.add(f.b(name, "onPaused"));
            aVarM.a(false);
            long jCurrentTimeMillis = System.currentTimeMillis();
            aVarM.Y = jCurrentTimeMillis;
            aVarM.Z = jCurrentTimeMillis - aVarM.X;
            long unused = f.f4083g = jCurrentTimeMillis;
            if (aVarM.Z < 0) {
                aVarM.Z = 0L;
            }
            if (activity != null) {
                aVarM.W = "background";
            } else {
                aVarM.W = EnvironmentCompat.MEDIA_UNKNOWN;
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        String name = activity != null ? activity.getClass().getName() : EnvironmentCompat.MEDIA_UNKNOWN;
        if (f.f4088l == null || f.f4088l.getName().equals(name)) {
            X.a(">>> %s onResumed <<<", name);
            com.tencent.bugly.crashreport.common.info.a aVarM = com.tencent.bugly.crashreport.common.info.a.m();
            if (aVarM == null) {
                return;
            }
            aVarM.na.add(f.b(name, "onResumed"));
            aVarM.a(true);
            aVarM.W = name;
            long jCurrentTimeMillis = System.currentTimeMillis();
            aVarM.X = jCurrentTimeMillis;
            aVarM.aa = jCurrentTimeMillis - f.f4084h;
            long j2 = aVarM.X - f.f4083g;
            if (j2 > (f.f4081e > 0 ? f.f4081e : f.f4080d)) {
                aVarM.F();
                f.i();
                X.c("[session] launch app one times (app in background %d seconds and over %d seconds)", Long.valueOf(j2 / 1000), Long.valueOf(f.f4080d / 1000));
                if (f.f4082f % f.f4078b == 0) {
                    f.f4085i.a(4, f.m, 0L);
                    return;
                }
                f.f4085i.a(4, false, 0L);
                long jCurrentTimeMillis2 = System.currentTimeMillis();
                if (jCurrentTimeMillis2 - f.f4086j > f.f4079c) {
                    long unused = f.f4086j = jCurrentTimeMillis2;
                    X.c("add a timer to upload hot start user info", new Object[0]);
                    if (f.m) {
                        f.f4085i.a(f.f4079c);
                    }
                }
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
    }
}

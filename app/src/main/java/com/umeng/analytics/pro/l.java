package com.umeng.analytics.pro;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.umeng.commonsdk.debug.UMRTLog;
import java.util.ArrayList;

/* JADX INFO: compiled from: BackgroundMonitor.java */
/* JADX INFO: loaded from: classes.dex */
public class l implements Application.ActivityLifecycleCallbacks {
    private static l a = new l();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f4908b = 3000;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f4909c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f4910d = true;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Handler f4911e = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private ArrayList<m> f4912f = new ArrayList<>();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private a f4913g = new a();

    /* JADX INFO: compiled from: BackgroundMonitor.java */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!l.this.f4909c || !l.this.f4910d) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> still foreground.");
                return;
            }
            l.this.f4909c = false;
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> went background.");
            for (int i2 = 0; i2 < l.this.f4912f.size(); i2++) {
                ((m) l.this.f4912f.get(i2)).n();
            }
        }
    }

    private l() {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        this.f4910d = true;
        a aVar = this.f4913g;
        if (aVar != null) {
            this.f4911e.removeCallbacks(aVar);
            this.f4911e.postDelayed(this.f4913g, 3000L);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        this.f4910d = false;
        this.f4909c = true;
        a aVar = this.f4913g;
        if (aVar != null) {
            this.f4911e.removeCallbacks(aVar);
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

    public synchronized void b(m mVar) {
        if (mVar != null) {
            for (int i2 = 0; i2 < this.f4912f.size(); i2++) {
                if (this.f4912f.get(i2) == mVar) {
                    this.f4912f.remove(i2);
                }
            }
        }
    }

    public static void a(Context context) {
        if (context instanceof Application) {
            ((Application) context).registerActivityLifecycleCallbacks(a);
        }
    }

    public static l a() {
        return a;
    }

    public synchronized void a(m mVar) {
        if (mVar != null) {
            this.f4912f.add(mVar);
        }
    }
}

package com.ss.android.socialbase.downloader.a;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.MainThread;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: AppStatusManager.java */
/* JADX INFO: loaded from: classes.dex */
public class a {
    private Application a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private c f3429b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List<InterfaceC0092a> f3430c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f3431d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private WeakReference<Activity> f3432e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private volatile int f3433f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private volatile boolean f3434g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Application.ActivityLifecycleCallbacks f3435h;

    /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AppStatusManager.java */
    public interface InterfaceC0092a {
        @MainThread
        void b();

        @MainThread
        void c();
    }

    /* JADX INFO: compiled from: AppStatusManager.java */
    public static class b {
        private static final a a = new a();
    }

    /* JADX INFO: compiled from: AppStatusManager.java */
    public interface c {
    }

    private Object[] d() {
        Object[] array;
        synchronized (this.f3430c) {
            array = this.f3430c.size() > 0 ? this.f3430c.toArray() : null;
        }
        return array;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.f3433f = 1;
        Object[] objArrD = d();
        if (objArrD != null) {
            for (Object obj : objArrD) {
                ((InterfaceC0092a) obj).b();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        this.f3433f = 0;
        Object[] objArrD = d();
        if (objArrD != null) {
            for (Object obj : objArrD) {
                ((InterfaceC0092a) obj).c();
            }
        }
    }

    private boolean g() {
        try {
            Application application = this.a;
            if (application == null) {
                return false;
            }
            ActivityManager activityManager = (ActivityManager) application.getSystemService("activity");
            String packageName = application.getPackageName();
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
            if (runningAppProcesses != null && !runningAppProcesses.isEmpty()) {
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                    if (runningAppProcessInfo.importance == 100 && TextUtils.equals(runningAppProcessInfo.processName, packageName)) {
                        return true;
                    }
                }
                return false;
            }
            return false;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    private a() {
        this.f3430c = new ArrayList();
        this.f3433f = -1;
        this.f3434g = false;
        this.f3435h = new Application.ActivityLifecycleCallbacks() { // from class: com.ss.android.socialbase.downloader.a.a.1
            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityCreated(Activity activity, Bundle bundle) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPaused(Activity activity) {
                a.this.f3434g = true;
                if (a.this.f3431d != 0 || activity == null) {
                    return;
                }
                a.this.f3431d = activity.hashCode();
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityResumed(Activity activity) {
                int i2 = a.this.f3431d;
                a.this.f3434g = false;
                a.this.f3431d = activity != null ? activity.hashCode() : i2;
                if (i2 == 0) {
                    a.this.e();
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStarted(Activity activity) {
                a.this.f3432e = new WeakReference(activity);
                int i2 = a.this.f3431d;
                a.this.f3431d = activity != null ? activity.hashCode() : i2;
                a.this.f3434g = false;
                if (i2 == 0) {
                    a.this.e();
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity) {
                if (activity != null && activity.hashCode() == a.this.f3431d) {
                    a.this.f3431d = 0;
                    a.this.f();
                }
                a.this.f3434g = false;
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v2, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4 */
    public boolean b() {
        int i2 = this.f3433f;
        ?? r0 = i2;
        if (i2 == -1) {
            ?? G = g();
            this.f3433f = G;
            r0 = G;
        }
        return r0 == 1;
    }

    public boolean c() {
        return b() && !this.f3434g;
    }

    public static a a() {
        return b.a;
    }

    public void b(InterfaceC0092a interfaceC0092a) {
        synchronized (this.f3430c) {
            this.f3430c.remove(interfaceC0092a);
        }
    }

    public void a(Context context) {
        if (this.a == null && (context instanceof Application)) {
            synchronized (this) {
                if (this.a == null) {
                    Application application = (Application) context;
                    this.a = application;
                    application.registerActivityLifecycleCallbacks(this.f3435h);
                }
            }
        }
    }

    public void a(c cVar) {
        this.f3429b = cVar;
    }

    public void a(InterfaceC0092a interfaceC0092a) {
        if (interfaceC0092a == null) {
            return;
        }
        synchronized (this.f3430c) {
            if (!this.f3430c.contains(interfaceC0092a)) {
                this.f3430c.add(interfaceC0092a);
            }
        }
    }
}

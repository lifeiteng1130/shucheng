package com.uc.crashsdk;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: ProGuard */
/* JADX INFO: loaded from: classes.dex */
public final class c implements Application.ActivityLifecycleCallbacks {
    private boolean a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f4561b = false;

    private void a(Activity activity, int i2) {
        if (1 == i2) {
            String unused = b.ac = activity.getComponentName().flattenToShortString();
        } else {
            String unused2 = b.ac = "";
        }
        b.A();
        if (g.J()) {
            b.L();
            synchronized (b.aa) {
                b.aa.put(activity, Integer.valueOf(i2));
                a(i2);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        a(activity, 2);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        if (g.J()) {
            b.L();
            synchronized (b.aa) {
                b.aa.remove(activity);
                a(2);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        a(activity, 2);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        a(activity, 1);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        a(activity, 1);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        a(activity, 2);
    }

    private void a(int i2) {
        if (e.t()) {
            com.uc.crashsdk.a.a.a("crashsdk", "[LifeCycle] ignore state change while crashing");
            return;
        }
        boolean z = true;
        boolean z2 = 1 == i2;
        if (z2) {
            z = z2;
        } else {
            Iterator it = b.aa.entrySet().iterator();
            while (it.hasNext()) {
                Object value = ((Map.Entry) it.next()).getValue();
                if (value != null && ((Integer) value).intValue() == 1) {
                    break;
                }
            }
            z = z2;
        }
        if (this.a != z) {
            b.b(z);
            this.a = z;
        }
        boolean zIsEmpty = b.aa.isEmpty();
        if (this.f4561b != zIsEmpty) {
            if (zIsEmpty) {
                b.t();
            }
            this.f4561b = zIsEmpty;
        }
    }
}

package c.c.a.h;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class b {
    public static b a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f712b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f713c = true;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public List<c.c.a.h.a> f714d = new ArrayList();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f715e = false;

    public class a implements Application.ActivityLifecycleCallbacks {
        public a() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityDestroyed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityPaused(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityResumed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStarted(Activity activity) {
            b bVar = b.this;
            if (bVar.f712b == 0) {
                bVar.f713c = false;
                if (!bVar.f715e) {
                    Iterator<c.c.a.h.a> it = bVar.f714d.iterator();
                    while (it.hasNext()) {
                        it.next().b();
                    }
                    b.this.f715e = true;
                }
                Iterator<c.c.a.h.a> it2 = b.this.f714d.iterator();
                while (it2.hasNext()) {
                    it2.next().a();
                }
            }
            b.this.f712b++;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStopped(Activity activity) {
            b bVar = b.this;
            int i2 = bVar.f712b - 1;
            bVar.f712b = i2;
            if (i2 == 0) {
                bVar.f713c = true;
                Iterator<c.c.a.h.a> it = bVar.f714d.iterator();
                while (it.hasNext()) {
                    it.next();
                }
            }
        }
    }

    public static b a() {
        if (a == null) {
            synchronized (b.class) {
                if (a == null) {
                    a = new b();
                }
            }
        }
        return a;
    }
}

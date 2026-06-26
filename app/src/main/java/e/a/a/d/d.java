package e.a.a.d;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import io.legado.app.model.AdsConfig;
import io.legado.app.ui.welcome.SplashActivity;
import io.legado.app.ui.welcome.WelcomeActivity;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ActivityHelp.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d implements Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f5515b;

    @NotNull
    public static final d a = new d();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public static final List<WeakReference<Activity>> f5516c = new ArrayList();

    public final boolean a(@NotNull Class<?> cls) {
        f.c0.c.j.e(cls, "activityClass");
        Iterator<T> it = f5516c.iterator();
        while (it.hasNext()) {
            Activity activity = (Activity) ((WeakReference) it.next()).get();
            if (f.c0.c.j.a(activity == null ? null : activity.getClass(), cls)) {
                return true;
            }
        }
        return false;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(@NotNull Activity activity, @Nullable Bundle bundle) {
        Locale locale;
        f.c0.c.j.e(activity, "activity");
        f.c0.c.j.e(activity, "activity");
        f5516c.add(new WeakReference<>(activity));
        f.c0.c.j.e(activity, com.umeng.analytics.pro.c.R);
        boolean z = false;
        if (Build.VERSION.SDK_INT >= 24) {
            locale = activity.getResources().getConfiguration().getLocales().get(0);
            f.c0.c.j.d(locale, "context.resources.configuration.locales[0]");
        } else {
            locale = activity.getResources().getConfiguration().locale;
            f.c0.c.j.d(locale, "context.resources.configuration.locale");
        }
        String language = locale.getLanguage();
        String country = locale.getCountry();
        Locale localeA = e.a.a.h.t.a(activity);
        String language2 = localeA.getLanguage();
        String country2 = localeA.getCountry();
        if (f.c0.c.j.a(language, language2) && f.c0.c.j.a(country, country2)) {
            z = true;
        }
        if (z) {
            return;
        }
        e.a.a.h.t.b(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(@NotNull Activity activity) {
        f.c0.c.j.e(activity, "activity");
        f.c0.c.j.e(activity, "activity");
        for (WeakReference<Activity> weakReference : f5516c) {
            if (weakReference.get() != null && weakReference.get() == activity) {
                f5516c.remove(weakReference);
                return;
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(@NotNull Activity activity) {
        f.c0.c.j.e(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(@NotNull Activity activity) {
        f.c0.c.j.e(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(@NotNull Activity activity, @NotNull Bundle bundle) {
        f.c0.c.j.e(activity, "activity");
        f.c0.c.j.e(bundle, "outState");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(@NotNull Activity activity) {
        f.c0.c.j.e(activity, "activity");
        int i2 = f5515b + 1;
        f5515b = i2;
        if ((activity instanceof WelcomeActivity) || (activity instanceof SplashActivity) || i2 != 1) {
            return;
        }
        AdsConfig adsConfigC = e.a.a.d.w.c.c(activity);
        long jCurrentTimeMillis = System.currentTimeMillis();
        f.c0.c.j.e(activity, "<this>");
        f.c0.c.j.e("splashLastTime", "key");
        if (jCurrentTimeMillis - c.b.a.m.f.i2(activity).getLong("splashLastTime", jCurrentTimeMillis) >= adsConfigC.getHotSplashTime() * ((long) 1000) && adsConfigC.getEnableAds() && e.a.a.d.w.c.b(adsConfigC) && adsConfigC.getEnableHotSplash()) {
            Intent intent = new Intent(activity, (Class<?>) SplashActivity.class);
            intent.addFlags(268435456);
            intent.putExtra("from", 1);
            activity.startActivity(intent);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(@NotNull Activity activity) {
        f.c0.c.j.e(activity, "activity");
        int i2 = f5515b - 1;
        f5515b = i2;
        if (i2 == 0) {
            c.b.a.m.f.q4(activity, "splashLastTime", System.currentTimeMillis());
        }
    }
}

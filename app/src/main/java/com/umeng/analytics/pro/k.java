package com.umeng.analytics.pro;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import com.umeng.analytics.MobclickAgent;
import com.umeng.analytics.pro.d;
import com.umeng.analytics.pro.h;
import com.umeng.analytics.vshelper.PageNameMonitor;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.utils.UMUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: AutoViewPageTracker.java */
/* JADX INFO: loaded from: classes.dex */
public class k {
    public static String a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f4903c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f4904d;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public com.umeng.analytics.vshelper.a f4905g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Application.ActivityLifecycleCallbacks f4906h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Map<String, Long> f4907i;
    private boolean m;
    private int n;
    private int o;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static JSONArray f4900j = new JSONArray();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static Object f4901k = new Object();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static Application f4902l = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static MobclickAgent.PageMode f4897b = MobclickAgent.PageMode.AUTO;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static String f4898e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static int f4899f = -1;
    private static boolean p = true;
    private static Object q = new Object();

    /* JADX INFO: compiled from: AutoViewPageTracker.java */
    public static class a {
        private static final k a = new k();

        private a() {
        }
    }

    public static /* synthetic */ int a(k kVar) {
        int i2 = kVar.o;
        kVar.o = i2 - 1;
        return i2;
    }

    public static /* synthetic */ int b(k kVar) {
        int i2 = kVar.n;
        kVar.n = i2 - 1;
        return i2;
    }

    public static /* synthetic */ int e(k kVar) {
        int i2 = kVar.o;
        kVar.o = i2 + 1;
        return i2;
    }

    public static /* synthetic */ int f(k kVar) {
        int i2 = kVar.n;
        kVar.n = i2 + 1;
        return i2;
    }

    private k() {
        this.f4907i = new HashMap();
        this.m = false;
        this.f4903c = false;
        this.f4904d = false;
        this.n = 0;
        this.o = 0;
        this.f4905g = PageNameMonitor.getInstance();
        this.f4906h = new Application.ActivityLifecycleCallbacks() { // from class: com.umeng.analytics.pro.k.1
            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityCreated(Activity activity, Bundle bundle) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPaused(Activity activity) {
                if (FieldManager.allow(com.umeng.commonsdk.utils.b.F)) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> onActivityPaused: FirstResumeTrigger enabled.");
                    synchronized (k.q) {
                        if (k.p) {
                            return;
                        }
                    }
                } else {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> onActivityPaused: FirstResumeTrigger disabled.");
                }
                if (k.f4897b != MobclickAgent.PageMode.AUTO) {
                    return;
                }
                k.this.c(activity);
                com.umeng.analytics.b.a().i();
                k.this.f4903c = false;
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityResumed(Activity activity) {
                if (!FieldManager.allow(com.umeng.commonsdk.utils.b.F)) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> onActivityResumed: FirstResumeTrigger disabled.");
                    k.this.a(activity);
                    return;
                }
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> onActivityResumed: FirstResumeTrigger enabled.");
                synchronized (k.q) {
                    if (k.p) {
                        boolean unused = k.p = false;
                    }
                }
                k.this.a(activity);
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStarted(Activity activity) {
                if (activity != null) {
                    if (k.this.n <= 0) {
                        if (k.f4898e == null) {
                            k.f4898e = UUID.randomUUID().toString();
                        }
                        if (k.f4899f == -1) {
                            k.f4899f = activity.isTaskRoot() ? 1 : 0;
                        }
                        if (k.f4899f == 0 && UMUtils.isMainProgress(activity)) {
                            HashMap map = new HashMap();
                            map.put("activityName", activity.toString());
                            map.put("pid", Integer.valueOf(Process.myPid()));
                            map.put("isMainProcess", Integer.valueOf(UMUtils.isMainProgress(activity) ? 1 : 0));
                            com.umeng.analytics.b bVarA = com.umeng.analytics.b.a();
                            if (bVarA != null) {
                                bVarA.a((Context) activity, "$$_onUMengEnterForegroundInitError", (Map<String, Object>) map);
                            }
                            k.f4899f = -2;
                            if (UMConfigure.isDebugLog()) {
                                UMLog.mutlInfo(2, i.ar);
                            }
                        } else if (k.f4899f == 1 || !UMUtils.isMainProgress(activity)) {
                            HashMap map2 = new HashMap();
                            map2.put("pairUUID", k.f4898e);
                            map2.put("pid", Integer.valueOf(Process.myPid()));
                            map2.put("isMainProcess", Integer.valueOf(UMUtils.isMainProgress(activity) ? 1 : 0));
                            map2.put("activityName", activity.toString());
                            if (com.umeng.analytics.b.a() != null) {
                                com.umeng.analytics.b.a().a((Context) activity, "$$_onUMengEnterForeground", (Map<String, Object>) map2);
                            }
                        }
                    }
                    if (k.this.o < 0) {
                        k.e(k.this);
                    } else {
                        k.f(k.this);
                    }
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity) {
                MobclickAgent.PageMode pageMode = k.f4897b;
                MobclickAgent.PageMode pageMode2 = MobclickAgent.PageMode.AUTO;
                if (activity != null) {
                    if (activity.isChangingConfigurations()) {
                        k.a(k.this);
                        return;
                    }
                    k.b(k.this);
                    if (k.this.n <= 0) {
                        if (k.f4899f == 0 && UMUtils.isMainProgress(activity)) {
                            return;
                        }
                        int i2 = k.f4899f;
                        if (i2 == 1 || (i2 == 0 && !UMUtils.isMainProgress(activity))) {
                            HashMap map = new HashMap();
                            map.put("pairUUID", k.f4898e);
                            map.put("reason", "Normal");
                            map.put("pid", Integer.valueOf(Process.myPid()));
                            map.put("isMainProcess", Integer.valueOf(UMUtils.isMainProgress(activity) ? 1 : 0));
                            map.put("activityName", activity.toString());
                            com.umeng.analytics.b bVarA = com.umeng.analytics.b.a();
                            if (bVarA != null) {
                                bVarA.a((Context) activity, "$$_onUMengEnterBackground", (Map<String, Object>) map);
                            }
                            if (k.f4898e != null) {
                                k.f4898e = null;
                            }
                        }
                    }
                }
            }
        };
        synchronized (this) {
            if (f4902l != null) {
                f();
            }
        }
    }

    private void f() {
        if (this.m) {
            return;
        }
        this.m = true;
        if (f4902l != null) {
            f4902l.registerActivityLifecycleCallbacks(this.f4906h);
        }
    }

    public void c() {
        c((Activity) null);
        b();
    }

    public void b(Context context) {
        synchronized (q) {
            if (p) {
                p = false;
                Activity globleActivity = DeviceConfig.getGlobleActivity(context);
                if (globleActivity == null) {
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> init触发onResume: 无前台Activity，直接退出。");
                    return;
                }
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> init触发onResume: 补救成功，前台Activity名：" + globleActivity.getLocalClassName());
                a(globleActivity);
                return;
            }
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> init触发onResume: firstResumeCall = false，直接返回。");
        }
    }

    public static void c(Context context) {
        String string;
        if (context != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                synchronized (f4901k) {
                    string = f4900j.toString();
                    f4900j = new JSONArray();
                }
                if (string.length() > 0) {
                    jSONObject.put(d.C0127d.a.f4844c, new JSONArray(string));
                    h.a(context).a(t.a().c(), jSONObject, h.a.AUTOPAGE);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public boolean a() {
        return this.m;
    }

    public static synchronized k a(Context context) {
        if (f4902l == null && context != null) {
            if (context instanceof Activity) {
                f4902l = ((Activity) context).getApplication();
            } else if (context instanceof Application) {
                f4902l = (Application) context;
            }
        }
        return a.a;
    }

    public static void a(Context context, String str) {
        if (f4899f == 1 && UMUtils.isMainProgress(context)) {
            HashMap map = new HashMap();
            map.put("pairUUID", f4898e);
            map.put("reason", str);
            if (f4898e != null) {
                f4898e = null;
            }
            if (context != null) {
                map.put("pid", Integer.valueOf(Process.myPid()));
                map.put("isMainProcess", Integer.valueOf(UMUtils.isMainProgress(context) ? 1 : 0));
                map.put("Context", context.toString());
                com.umeng.analytics.b.a().a(context, "$$_onUMengEnterBackground", (Map<String, Object>) map);
            }
        }
    }

    public void b() {
        this.m = false;
        if (f4902l != null) {
            f4902l.unregisterActivityLifecycleCallbacks(this.f4906h);
            f4902l = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Activity activity) {
        long j2;
        long j3;
        try {
            synchronized (this.f4907i) {
                if (a == null && activity != null) {
                    a = activity.getPackageName() + "." + activity.getLocalClassName();
                }
                j2 = 0;
                if (TextUtils.isEmpty(a) || !this.f4907i.containsKey(a)) {
                    j3 = 0;
                } else {
                    long jLongValue = this.f4907i.get(a).longValue();
                    long jCurrentTimeMillis = System.currentTimeMillis() - jLongValue;
                    this.f4907i.remove(a);
                    j2 = jCurrentTimeMillis;
                    j3 = jLongValue;
                }
            }
            synchronized (f4901k) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(c.v, a);
                    jSONObject.put("duration", j2);
                    jSONObject.put(c.x, j3);
                    jSONObject.put("type", 0);
                    f4900j.put(jSONObject);
                } catch (Throwable unused) {
                }
            }
        } catch (Throwable unused2) {
        }
    }

    private void b(Activity activity) {
        a = activity.getPackageName() + "." + activity.getLocalClassName();
        synchronized (this.f4907i) {
            this.f4907i.put(a, Long.valueOf(System.currentTimeMillis()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Activity activity) {
        if (f4897b == MobclickAgent.PageMode.AUTO && activity != null) {
            String str = activity.getPackageName() + "." + activity.getLocalClassName();
            this.f4905g.activityResume(str);
            if (this.f4903c) {
                this.f4903c = false;
                if (!TextUtils.isEmpty(a)) {
                    if (a.equals(str)) {
                        return;
                    }
                    b(activity);
                    synchronized (q) {
                        com.umeng.analytics.b.a().h();
                    }
                    return;
                }
                a = str;
                return;
            }
            b(activity);
            synchronized (q) {
                com.umeng.analytics.b.a().h();
            }
        }
    }
}

package com.tencent.bugly.crashreport.biz;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.Context;
import androidx.core.os.EnvironmentCompat;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.proguard.W;
import com.tencent.bugly.proguard.X;
import com.tencent.bugly.proguard.ca;
import java.util.List;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes.dex */
public class f {
    public static boolean a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static int f4078b = 10;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static long f4079c = 300000;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static long f4080d = 30000;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static long f4081e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static int f4082f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static long f4083g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static long f4084h = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static c f4085i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static long f4086j = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static Application.ActivityLifecycleCallbacks f4087k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static Class<?> f4088l = null;
    private static boolean m = true;

    public static /* synthetic */ int i() {
        int i2 = f4082f;
        f4082f = i2 + 1;
        return i2;
    }

    public static void l() {
        c cVar = f4085i;
        if (cVar != null) {
            cVar.a(2, false, 0L);
        }
    }

    private static void m() {
        com.tencent.bugly.crashreport.common.info.a aVarM = com.tencent.bugly.crashreport.common.info.a.m();
        if (aVarM == null) {
            return;
        }
        String className = null;
        boolean z = false;
        for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
            if (stackTraceElement.getMethodName().equals("onCreate")) {
                className = stackTraceElement.getClassName();
            }
            if (stackTraceElement.getClassName().equals("android.app.Activity")) {
                z = true;
            }
        }
        if (className == null) {
            className = EnvironmentCompat.MEDIA_UNKNOWN;
        } else if (z) {
            aVarM.a(true);
        } else {
            className = "background";
        }
        aVarM.W = className;
    }

    private static void n() {
        f4084h = System.currentTimeMillis();
        f4085i.a(1, false, 0L);
        X.c("[session] launch app, new start", new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(Context context, BuglyStrategy buglyStrategy) {
        boolean zIsEnableUserInfo;
        boolean zRecordUserInfoOnceADay;
        boolean z = false;
        if (buglyStrategy != null) {
            zRecordUserInfoOnceADay = buglyStrategy.recordUserInfoOnceADay();
            zIsEnableUserInfo = buglyStrategy.isEnableUserInfo();
        } else {
            zIsEnableUserInfo = true;
            zRecordUserInfoOnceADay = false;
        }
        if (!zRecordUserInfoOnceADay) {
            z = zIsEnableUserInfo;
        } else if (!b(context)) {
            return;
        }
        m();
        if (z) {
            c(context);
        }
        if (m) {
            n();
            f4085i.a();
            f4085i.b(21600000L);
        }
    }

    @TargetApi(14)
    private static void d(Context context) {
        Application application = context.getApplicationContext() instanceof Application ? (Application) context.getApplicationContext() : null;
        if (application == null) {
            return;
        }
        try {
            Application.ActivityLifecycleCallbacks activityLifecycleCallbacks = f4087k;
            if (activityLifecycleCallbacks != null) {
                application.unregisterActivityLifecycleCallbacks(activityLifecycleCallbacks);
            }
        } catch (Exception e2) {
            if (X.b(e2)) {
                return;
            }
            e2.printStackTrace();
        }
    }

    private static boolean b(Context context) {
        com.tencent.bugly.crashreport.common.info.a aVarA = com.tencent.bugly.crashreport.common.info.a.a(context);
        List<UserInfoBean> listA = f4085i.a(aVarA.f4099h);
        if (listA == null) {
            return true;
        }
        for (int i2 = 0; i2 < listA.size(); i2++) {
            UserInfoBean userInfoBean = listA.get(i2);
            if (userInfoBean.n.equals(aVarA.E) && userInfoBean.f4059b == 1) {
                long jB = ca.b();
                if (jB <= 0) {
                    return true;
                }
                if (userInfoBean.f4062e >= jB) {
                    if (userInfoBean.f4063f <= 0) {
                        f4085i.b();
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public static void a(StrategyBean strategyBean, boolean z) {
        c cVar = f4085i;
        if (cVar != null && !z) {
            cVar.b();
        }
        if (strategyBean == null) {
            return;
        }
        long j2 = strategyBean.p;
        if (j2 > 0) {
            f4080d = j2;
        }
        int i2 = strategyBean.u;
        if (i2 > 0) {
            f4078b = i2;
        }
        long j3 = strategyBean.v;
        if (j3 > 0) {
            f4079c = j3;
        }
    }

    public static void c(long j2) {
        if (j2 < 0) {
            j2 = com.tencent.bugly.crashreport.common.strategy.c.b().c().p;
        }
        f4081e = j2;
    }

    public static void a(Context context) {
        if (!a || context == null) {
            return;
        }
        d(context);
        a = false;
    }

    @TargetApi(14)
    private static void c(Context context) {
        Application application = context.getApplicationContext() instanceof Application ? (Application) context.getApplicationContext() : null;
        if (application == null) {
            return;
        }
        try {
            if (f4087k == null) {
                f4087k = new e();
            }
            application.registerActivityLifecycleCallbacks(f4087k);
        } catch (Exception e2) {
            if (X.b(e2)) {
                return;
            }
            e2.printStackTrace();
        }
    }

    public static void b(Context context, BuglyStrategy buglyStrategy) {
        long appReportDelay;
        if (a) {
            return;
        }
        boolean z = com.tencent.bugly.crashreport.common.info.a.a(context).f4101j;
        m = z;
        f4085i = new c(context, z);
        a = true;
        if (buglyStrategy != null) {
            f4088l = buglyStrategy.getUserInfoActivity();
            appReportDelay = buglyStrategy.getAppReportDelay();
        } else {
            appReportDelay = 0;
        }
        if (appReportDelay <= 0) {
            c(context, buglyStrategy);
        } else {
            W.c().a(new d(context, buglyStrategy), appReportDelay);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String b(String str, String str2) {
        return ca.a() + "  " + str + "  " + str2 + "\n";
    }
}

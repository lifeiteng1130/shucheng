package com.tencent.bugly;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.bugly.crashreport.biz.f;
import com.tencent.bugly.crashreport.common.strategy.c;
import com.tencent.bugly.proguard.H;
import com.tencent.bugly.proguard.I;
import com.tencent.bugly.proguard.J;
import com.tencent.bugly.proguard.T;
import com.tencent.bugly.proguard.X;
import com.tencent.bugly.proguard.ba;
import com.tencent.bugly.proguard.ca;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes.dex */
public class b {
    public static boolean a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static List<a> f3959b = new ArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f3960c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static J f3961d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static boolean f3962e;

    private static boolean a(com.tencent.bugly.crashreport.common.info.a aVar) {
        List<String> list = aVar.P;
        return list != null && list.contains("bugly");
    }

    public static synchronized void a(Context context) {
        a(context, (BuglyStrategy) null);
    }

    public static synchronized void a(Context context, BuglyStrategy buglyStrategy) {
        if (f3962e) {
            X.e("[init] initial Multi-times, ignore this.", new Object[0]);
            return;
        }
        if (context == null) {
            return;
        }
        com.tencent.bugly.crashreport.common.info.a aVarA = com.tencent.bugly.crashreport.common.info.a.a(context);
        if (a(aVarA)) {
            a = false;
            return;
        }
        String strE = aVarA.e();
        if (strE == null) {
            return;
        }
        a(context, strE, aVarA.ba, buglyStrategy);
    }

    public static synchronized void a(Context context, String str, boolean z, BuglyStrategy buglyStrategy) {
        if (f3962e) {
            X.e("[init] initial Multi-times, ignore this.", new Object[0]);
            return;
        }
        if (context == null) {
            return;
        }
        if (str == null) {
            return;
        }
        f3962e = true;
        if (z) {
            f3960c = true;
            X.f4330c = true;
            X.e("Bugly debug模式开启，请在发布时把isDebug关闭。 -- Running in debug model for 'isDebug' is enabled. Please disable it when you release.", new Object[0]);
            X.b("--------------------------------------------------------------------------------------------", new Object[0]);
            X.e("Bugly debug模式将有以下行为特性 -- The following list shows the behaviour of debug model: ", new Object[0]);
            X.e("[1] 输出详细的Bugly SDK的Log -- More detailed log of Bugly SDK will be output to logcat;", new Object[0]);
            X.e("[2] 每一条Crash都会被立即上报 -- Every crash caught by Bugly will be uploaded immediately.", new Object[0]);
            X.e("[3] 自定义日志将会在Logcat中输出 -- Custom log will be output to logcat.", new Object[0]);
            X.b("--------------------------------------------------------------------------------------------", new Object[0]);
            X.d("[init] Open debug mode of Bugly.", new Object[0]);
        }
        X.c(" crash report start initializing...", new Object[0]);
        X.d("[init] Bugly start initializing...", new Object[0]);
        X.c("[init] Bugly complete version: v%s", "3.4.12(1.5.23)");
        Context contextA = ca.a(context);
        com.tencent.bugly.crashreport.common.info.a aVarA = com.tencent.bugly.crashreport.common.info.a.a(contextA);
        aVarA.E();
        ba.a(contextA);
        f3961d = J.a(contextA, f3959b);
        T.a(contextA);
        c cVarA = c.a(contextA, f3959b);
        H hA = H.a(contextA);
        if (a(aVarA)) {
            a = false;
            return;
        }
        aVarA.c(str);
        X.c("[param] Set APP ID:%s", str);
        a(buglyStrategy, aVarA);
        for (int i2 = 0; i2 < f3959b.size(); i2++) {
            try {
                if (hA.a(f3959b.get(i2).id)) {
                    f3959b.get(i2).init(contextA, z, buglyStrategy);
                }
            } catch (Throwable th) {
                if (!X.b(th)) {
                    th.printStackTrace();
                }
            }
        }
        f.b(contextA, buglyStrategy);
        cVarA.a(buglyStrategy != null ? buglyStrategy.getAppReportDelay() : 0L);
        X.d("[init] Bugly initialization finished.", new Object[0]);
    }

    private static void a(BuglyStrategy buglyStrategy, com.tencent.bugly.crashreport.common.info.a aVar) {
        byte[] bArr;
        if (buglyStrategy == null) {
            return;
        }
        String appVersion = buglyStrategy.getAppVersion();
        if (!TextUtils.isEmpty(appVersion)) {
            if (appVersion.length() > 100) {
                String strSubstring = appVersion.substring(0, 100);
                X.e("appVersion %s length is over limit %d substring to %s", appVersion, 100, strSubstring);
                appVersion = strSubstring;
            }
            aVar.E = appVersion;
            X.c("[param] Set App version: %s", buglyStrategy.getAppVersion());
        }
        try {
            if (buglyStrategy.isReplaceOldChannel()) {
                String appChannel = buglyStrategy.getAppChannel();
                if (!TextUtils.isEmpty(appChannel)) {
                    if (appChannel.length() > 100) {
                        String strSubstring2 = appChannel.substring(0, 100);
                        X.e("appChannel %s length is over limit %d substring to %s", appChannel, 100, strSubstring2);
                        appChannel = strSubstring2;
                    }
                    f3961d.a(556, "app_channel", appChannel.getBytes(), (I) null, false);
                    aVar.I = appChannel;
                }
            } else {
                Map<String, byte[]> mapA = f3961d.a(556, (I) null, true);
                if (mapA != null && (bArr = mapA.get("app_channel")) != null) {
                    aVar.I = new String(bArr);
                }
            }
            X.c("[param] Set App channel: %s", aVar.I);
        } catch (Exception e2) {
            if (f3960c) {
                e2.printStackTrace();
            }
        }
        String appPackageName = buglyStrategy.getAppPackageName();
        if (!TextUtils.isEmpty(appPackageName)) {
            if (appPackageName.length() > 100) {
                String strSubstring3 = appPackageName.substring(0, 100);
                X.e("appPackageName %s length is over limit %d substring to %s", appPackageName, 100, strSubstring3);
                appPackageName = strSubstring3;
            }
            aVar.f4098g = appPackageName;
            X.c("[param] Set App package: %s", buglyStrategy.getAppPackageName());
        }
        String deviceID = buglyStrategy.getDeviceID();
        if (deviceID != null) {
            if (deviceID.length() > 100) {
                String strSubstring4 = deviceID.substring(0, 100);
                X.e("deviceId %s length is over limit %d substring to %s", deviceID, 100, strSubstring4);
                deviceID = strSubstring4;
            }
            aVar.d(deviceID);
            X.c("[param] Set device ID: %s", deviceID);
        }
        aVar.f4101j = buglyStrategy.isUploadProcess();
        ba.f4336c = buglyStrategy.isBuglyLogUpload();
    }

    public static synchronized void a(a aVar) {
        if (!f3959b.contains(aVar)) {
            f3959b.add(aVar);
        }
    }
}

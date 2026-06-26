package com.tencent.bugly;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.bugly.beta.Beta;
import com.tencent.bugly.crashreport.CrashReport;
import com.tencent.bugly.proguard.I;
import com.tencent.bugly.proguard.J;
import com.tencent.bugly.proguard.ca;
import java.util.Map;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes.dex */
public class Bugly {
    private static boolean a = false;
    public static Context applicationContext = null;
    public static boolean enable = true;

    public static synchronized String getAppChannel() {
        byte[] bArr;
        com.tencent.bugly.crashreport.common.info.a aVarM = com.tencent.bugly.crashreport.common.info.a.m();
        if (aVarM == null) {
            return null;
        }
        if (TextUtils.isEmpty(aVarM.I)) {
            J jA = J.a();
            if (jA == null) {
                return aVarM.I;
            }
            Map<String, byte[]> mapA = jA.a(556, (I) null, true);
            if (mapA != null && (bArr = mapA.get("app_channel")) != null) {
                return new String(bArr);
            }
        }
        return aVarM.I;
    }

    public static void init(Context context, String str, boolean z) {
        init(context, str, z, null);
    }

    public static void putUserData(Context context, String str, String str2) {
        CrashReport.putUserData(context, str, str2);
    }

    public static void setAppChannel(Context context, String str) {
        CrashReport.setAppChannel(context, str);
    }

    public static void setIsDevelopmentDevice(Context context, boolean z) {
        CrashReport.setIsDevelopmentDevice(context, z);
    }

    public static void setUserId(Context context, String str) {
        CrashReport.setUserId(context, str);
    }

    public static void setUserTag(Context context, int i2) {
        CrashReport.setUserSceneTag(context, i2);
    }

    public static synchronized void init(Context context, String str, boolean z, BuglyStrategy buglyStrategy) {
        if (a) {
            return;
        }
        a = true;
        Context contextA = ca.a(context);
        applicationContext = contextA;
        if (contextA == null) {
            return;
        }
        b.a(CrashModule.getInstance());
        b.a(Beta.getInstance());
        b.a = enable;
        b.a(applicationContext, str, z, buglyStrategy);
    }
}

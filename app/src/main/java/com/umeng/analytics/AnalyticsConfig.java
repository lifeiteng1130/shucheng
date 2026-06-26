package com.umeng.analytics;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.analytics.pro.i;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.commonsdk.utils.UMUtils;

/* JADX INFO: loaded from: classes.dex */
public class AnalyticsConfig {
    public static boolean CATCH_EXCEPTION = false;
    public static boolean CHANGE_CATCH_EXCEPTION_NOTALLOW = true;
    public static boolean CLEAR_EKV_BL = false;
    public static boolean CLEAR_EKV_WL = false;
    public static String GPU_RENDERER = "";
    public static String GPU_VENDER = "";
    public static double[] a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f4607b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static String f4608c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static String f4609d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static int f4610e = 0;
    public static boolean enable = true;
    public static long kContinueSessionMillis = 30000;
    public static String mWrapperType;
    public static String mWrapperVersion;

    public static void a(String str) {
        f4608c = str;
    }

    public static String getAppkey(Context context) {
        return UMUtils.getAppkey(context);
    }

    public static String getChannel(Context context) {
        return UMUtils.getChannel(context);
    }

    public static String getGameSdkVersion(Context context) {
        try {
            Class<?> cls = Class.forName("com.umeng.analytics.game.GameSdkVersion");
            return (String) cls.getDeclaredField("SDK_VERSION").get(cls);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static double[] getLocation() {
        return a;
    }

    public static String getSecretKey(Context context) {
        if (TextUtils.isEmpty(f4609d)) {
            f4609d = com.umeng.common.b.a(context).c();
        }
        return f4609d;
    }

    public static int getVerticalType(Context context) {
        if (f4610e == 0) {
            f4610e = com.umeng.common.b.a(context).d();
        }
        return f4610e;
    }

    public static void a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            UMLog.aq(i.A, 0, "\\|");
        } else {
            f4609d = str;
            com.umeng.common.b.a(context).a(f4609d);
        }
    }

    public static void a(Context context, int i2) {
        f4610e = i2;
        com.umeng.common.b.a(context).a(f4610e);
    }
}

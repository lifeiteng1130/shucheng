package com.umeng.commonsdk.internal.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Environment;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.view.inputmethod.InputMethodInfo;
import android.view.inputmethod.InputMethodManager;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.statistics.common.HelperUtils;
import com.umeng.commonsdk.statistics.common.ULog;
import java.io.File;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.json.JSONArray;

/* JADX INFO: compiled from: ApplicationLayerUtil.java */
/* JADX INFO: loaded from: classes3.dex */
public class a {

    /* JADX INFO: renamed from: com.umeng.commonsdk.internal.utils.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ApplicationLayerUtil.java */
    public static class C0132a {
        public String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f5162b;
    }

    /* JADX INFO: compiled from: ApplicationLayerUtil.java */
    public static class b {
        public int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f5163b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f5164c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f5165d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f5166e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f5167f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f5168g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public String f5169h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f5170i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f5171j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f5172k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public long f5173l;
    }

    public static long a(Context context, String str) {
        if (context == null) {
            return 0L;
        }
        try {
            return context.getPackageManager().getPackageInfo(str, 0).firstInstallTime;
        } catch (PackageManager.NameNotFoundException e2) {
            UMCrashManager.reportCrash(context, e2);
            ULog.e("getAppFirstInstallTime" + e2.getMessage());
            return 0L;
        }
    }

    public static long b(Context context, String str) {
        if (context == null) {
            return 0L;
        }
        try {
            return context.getPackageManager().getPackageInfo(str, 0).lastUpdateTime;
        } catch (PackageManager.NameNotFoundException e2) {
            UMCrashManager.reportCrash(context, e2);
            ULog.e("getAppLastUpdateTime:" + e2.getMessage());
            return 0L;
        }
    }

    public static String c(Context context, String str) {
        try {
            return context.getPackageManager().getInstallerPackageName(str);
        } catch (Exception e2) {
            UMCrashManager.reportCrash(context, e2);
            ULog.e("getAppInstaller:" + e2.getMessage());
            return null;
        }
    }

    public static int d(Context context, String str) {
        if (context == null) {
            return 0;
        }
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getPackageInfo(str, 0).applicationInfo;
            if (applicationInfo != null) {
                return applicationInfo.uid;
            }
            return 0;
        } catch (PackageManager.NameNotFoundException e2) {
            UMCrashManager.reportCrash(context, e2);
            ULog.e("getAppUid:" + e2.getMessage());
            return 0;
        }
    }

    public static void e(Context context) {
        if (context == null) {
            return;
        }
        f.b(context);
    }

    public static int f(Context context) {
        WifiManager wifiManager;
        if (context == null || !DeviceConfig.checkPermission(context, "android.permission.ACCESS_WIFI_STATE") || (wifiManager = (WifiManager) context.getSystemService("wifi")) == null) {
            return -1;
        }
        return wifiManager.getWifiState();
    }

    public static int g(Context context) {
        if (context == null) {
            return 0;
        }
        Resources resources = context.getResources();
        return resources.getDimensionPixelSize(resources.getIdentifier("status_bar_height", "dimen", "android"));
    }

    public static int h(Context context) {
        if (context == null) {
            return 0;
        }
        Resources resources = context.getResources();
        return resources.getDimensionPixelSize(resources.getIdentifier("navigation_bar_height", "dimen", "android"));
    }

    public static DisplayMetrics i(Context context) {
        if (context == null) {
            return null;
        }
        return context.getResources().getDisplayMetrics();
    }

    public static List<InputMethodInfo> j(Context context) {
        InputMethodManager inputMethodManager;
        if (context == null || (inputMethodManager = (InputMethodManager) context.getSystemService("input_method")) == null) {
            return null;
        }
        return inputMethodManager.getInputMethodList();
    }

    public static List<C0132a> k(Context context) {
        String[] list;
        if (context == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        try {
            File file = new File(Environment.getExternalStorageDirectory() + "/Android/data/");
            if (file.isDirectory() && (list = file.list()) != null && list.length > 0) {
                for (String str : list) {
                    if (str != null && !str.startsWith(".")) {
                        C0132a c0132a = new C0132a();
                        c0132a.a = str;
                        c0132a.f5162b = e(context, str);
                        arrayList.add(c0132a);
                    }
                }
            }
        } catch (Exception e2) {
            StringBuilder sbR = c.a.a.a.a.r("getAppList:");
            sbR.append(e2.getMessage());
            ULog.e(sbR.toString());
        }
        return arrayList;
    }

    public static ActivityManager.MemoryInfo l(Context context) {
        ActivityManager activityManager;
        if (context == null || (activityManager = (ActivityManager) context.getSystemService("activity")) == null) {
            return null;
        }
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        return memoryInfo;
    }

    public static String m(Context context) {
        if (context == null) {
        }
        return null;
    }

    public static String n(Context context) {
        return null;
    }

    private static String e(Context context, String str) {
        if (context == null) {
            return null;
        }
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(str, 128);
            if (applicationInfo != null) {
                return (String) applicationInfo.loadLabel(context.getPackageManager());
            }
            return null;
        } catch (Exception e2) {
            StringBuilder sbR = c.a.a.a.a.r("getLabel:");
            sbR.append(e2.getMessage());
            ULog.e(sbR.toString());
            return null;
        }
    }

    public static void c(Context context) {
        WifiInfo wifiInfoB;
        if (context == null || (wifiInfoB = b(context)) == null) {
            return;
        }
        b bVar = new b();
        bVar.a = wifiInfoB.describeContents();
        bVar.f5163b = wifiInfoB.getBSSID();
        bVar.f5164c = wifiInfoB.getSSID();
        bVar.f5165d = wifiInfoB.getFrequency();
        boolean z = true;
        if (wifiInfoB.getHiddenSSID()) {
            bVar.f5166e = 1;
        } else {
            bVar.f5166e = 0;
        }
        if (FieldManager.allow(com.umeng.commonsdk.utils.b.H)) {
            bVar.f5167f = wifiInfoB.getIpAddress();
        }
        bVar.f5168g = wifiInfoB.getLinkSpeed();
        bVar.f5169h = DeviceConfig.getMac(context);
        bVar.f5170i = wifiInfoB.getNetworkId();
        bVar.f5171j = wifiInfoB.getRssi();
        bVar.f5172k = f(context);
        bVar.f5173l = System.currentTimeMillis();
        try {
            JSONArray jSONArrayA = f.a(context);
            if (jSONArrayA == null || jSONArrayA.length() <= 0) {
                z = false;
            } else {
                for (int i2 = 0; i2 < jSONArrayA.length(); i2++) {
                    String strOptString = jSONArrayA.optJSONObject(i2).optString("ssid", null);
                    if (strOptString != null && strOptString.equals(bVar.f5164c)) {
                        break;
                    }
                }
                z = false;
            }
            if (z) {
                return;
            }
            f.a(context, bVar);
        } catch (Exception e2) {
            StringBuilder sbR = c.a.a.a.a.r("wifiChange:");
            sbR.append(e2.getMessage());
            ULog.e(sbR.toString());
        }
    }

    public static boolean a() {
        return h.a();
    }

    public static String b() {
        return new SimpleDateFormat().format(new Date());
    }

    public static String e() {
        try {
            Method declaredMethod = Build.class.getDeclaredMethod("getString", String.class);
            declaredMethod.setAccessible(true);
            String string = declaredMethod.invoke(null, "net.hostname").toString();
            return (string == null || string.equalsIgnoreCase("")) ? string : HelperUtils.getUmengMD5(string);
        } catch (Exception e2) {
            StringBuilder sbR = c.a.a.a.a.r("getHostName:");
            sbR.append(e2.getMessage());
            ULog.e(sbR.toString());
            return null;
        }
    }

    public static float a(Context context) {
        if (context == null) {
            return 0.0f;
        }
        Configuration configuration = new Configuration();
        try {
            configuration.updateFrom(context.getResources().getConfiguration());
            return configuration.fontScale;
        } catch (Exception e2) {
            StringBuilder sbR = c.a.a.a.a.r("getFontSize:");
            sbR.append(e2.getMessage());
            ULog.e(sbR.toString());
            return 0.0f;
        }
    }

    public static JSONArray d(Context context) {
        if (context == null) {
            return null;
        }
        return f.a(context);
    }

    public static WifiInfo b(Context context) {
        WifiManager wifiManager;
        if (context == null || !DeviceConfig.checkPermission(context, "android.permission.ACCESS_WIFI_STATE") || (wifiManager = (WifiManager) context.getSystemService("wifi")) == null) {
            return null;
        }
        return wifiManager.getConnectionInfo();
    }

    public static long d() {
        return System.currentTimeMillis() - SystemClock.elapsedRealtime();
    }

    public static String c() {
        return g.a("df");
    }
}

package com.umeng.commonsdk.internal.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.os.EnvironmentCompat;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.common.ULog;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.json.JSONObject;

/* JADX INFO: compiled from: UMProbe.java */
/* JADX INFO: loaded from: classes3.dex */
public class k {
    public static final String a = "UM_PROBE_DATA";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f5209b = "_dsk_s";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f5210c = "_thm_z";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f5211d = "_gdf_r";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static Object f5212e = new Object();

    public static void b(final Context context) {
        if (c(context)) {
            return;
        }
        final String[] strArr = {EnvironmentCompat.MEDIA_UNKNOWN, EnvironmentCompat.MEDIA_UNKNOWN, EnvironmentCompat.MEDIA_UNKNOWN};
        new Thread() { // from class: com.umeng.commonsdk.internal.utils.k.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                super.run();
                try {
                    strArr[0] = k.c();
                    strArr[1] = k.a();
                    strArr[2] = k.b();
                    ULog.i("diskType = " + strArr[0] + "; ThremalZone = " + strArr[1] + "; GoldFishRc = " + strArr[2]);
                    k.b(context, strArr);
                } catch (Throwable th) {
                    UMCrashManager.reportCrash(context, th);
                }
            }
        }.start();
    }

    public static boolean c(Context context) {
        SharedPreferences sharedPreferences;
        return (context == null || (sharedPreferences = context.getApplicationContext().getSharedPreferences(a, 0)) == null || TextUtils.isEmpty(sharedPreferences.getString(f5209b, ""))) ? false : true;
    }

    public static String a(Context context) {
        try {
            SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(a, 0);
            if (sharedPreferences == null) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            synchronized (f5212e) {
                jSONObject.put(f5209b, sharedPreferences.getString(f5209b, ""));
                jSONObject.put(f5210c, sharedPreferences.getString(f5210c, ""));
                jSONObject.put(f5211d, sharedPreferences.getString(f5211d, ""));
            }
            return jSONObject.toString();
        } catch (Exception e2) {
            UMCrashManager.reportCrash(context, e2);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Context context, String[] strArr) {
        SharedPreferences sharedPreferences;
        if (context == null || (sharedPreferences = context.getApplicationContext().getSharedPreferences(a, 0)) == null) {
            return;
        }
        synchronized (f5212e) {
            sharedPreferences.edit().putString(f5209b, strArr[0]).putString(f5210c, strArr[1]).putString(f5211d, strArr[2]).commit();
        }
    }

    public static String c() {
        String str;
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        try {
            bufferedReader = new BufferedReader(new FileReader("/proc/diskstats"));
            while (true) {
                try {
                    String line = bufferedReader.readLine();
                    str = "mtd";
                    if (line == null) {
                        str = EnvironmentCompat.MEDIA_UNKNOWN;
                        break;
                    }
                    if (line.contains("mmcblk")) {
                        str = "mmcblk";
                        break;
                    }
                    if (line.contains("sda")) {
                        str = "sda";
                        break;
                    }
                    if (line.contains("mtd")) {
                        break;
                    }
                } catch (Throwable unused) {
                    bufferedReader2 = bufferedReader;
                    str = "noper";
                    bufferedReader = bufferedReader2;
                }
            }
        } catch (Throwable unused2) {
        }
        if (bufferedReader != null) {
            try {
                bufferedReader.close();
            } catch (Throwable unused3) {
            }
        }
        return str;
    }

    public static String b() {
        int iA;
        try {
            iA = a("ls /", "goldfish");
        } catch (Throwable unused) {
            iA = -1;
        }
        return iA > 0 ? "goldfish" : iA < 0 ? "noper" : EnvironmentCompat.MEDIA_UNKNOWN;
    }

    public static int a(String str, String str2) throws IOException {
        int i2;
        if (Build.VERSION.SDK_INT > 28) {
            return -1;
        }
        Process processExec = Runtime.getRuntime().exec(str);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(processExec.getInputStream()));
        while (true) {
            String line = bufferedReader.readLine();
            if (line == null) {
                i2 = -1;
                break;
            }
            if (line.contains(str2)) {
                i2 = 1;
                break;
            }
        }
        try {
            if (processExec.waitFor() != 0) {
                return -1;
            }
            return i2;
        } catch (InterruptedException unused) {
            return -1;
        }
    }

    public static String a() {
        int iA;
        try {
            iA = a("ls /sys/class/thermal", "thermal_zone");
        } catch (Throwable unused) {
            iA = -1;
        }
        return iA > 0 ? "thermal_zone" : iA < 0 ? "noper" : EnvironmentCompat.MEDIA_UNKNOWN;
    }
}

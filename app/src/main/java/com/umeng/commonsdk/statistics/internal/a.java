package com.umeng.commonsdk.statistics.internal;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.umeng.analytics.pro.ai;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.common.HelperUtils;
import com.umeng.commonsdk.utils.UMUtils;
import h.a.a.a.w;

/* JADX INFO: compiled from: HeaderHelper.java */
/* JADX INFO: loaded from: classes3.dex */
public class a {
    private static Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f5312b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f5313c;

    /* JADX INFO: renamed from: com.umeng.commonsdk.statistics.internal.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: HeaderHelper.java */
    public static class C0134a {
        private static final a a = new a();

        private C0134a() {
        }
    }

    public static a a(Context context) {
        if (a == null && context != null) {
            a = context.getApplicationContext();
        }
        return C0134a.a;
    }

    private void e(String str) {
        try {
            this.f5312b = str.replaceAll("&=", " ").replaceAll("&&", " ").replaceAll("==", w.DEFAULT_PATH_SEPARATOR) + w.DEFAULT_PATH_SEPARATOR + "Android" + w.DEFAULT_PATH_SEPARATOR + Build.DISPLAY + w.DEFAULT_PATH_SEPARATOR + Build.MODEL + w.DEFAULT_PATH_SEPARATOR + Build.VERSION.RELEASE + " " + HelperUtils.getUmengMD5(UMUtils.getAppkey(a));
        } catch (Throwable th) {
            UMCrashManager.reportCrash(a, th);
        }
    }

    private void f(String str) {
        try {
            String str2 = str.split("&&")[0];
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            String[] strArrSplit = str2.split("&=");
            StringBuilder sb = new StringBuilder();
            sb.append(ai.aN);
            for (String str3 : strArrSplit) {
                if (!TextUtils.isEmpty(str3)) {
                    String strSubstring = str3.substring(0, 2);
                    if (strSubstring.endsWith("=")) {
                        strSubstring = strSubstring.replace("=", "");
                    }
                    sb.append(strSubstring);
                }
            }
            this.f5313c = sb.toString();
        } catch (Throwable th) {
            UMCrashManager.reportCrash(a, th);
        }
    }

    public boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith(ai.aF);
    }

    public boolean c(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith(ai.aB);
    }

    public void d(String str) {
        String strSubstring = str.substring(0, str.indexOf(95));
        f(strSubstring);
        e(strSubstring);
    }

    private a() {
        this.f5312b = null;
        this.f5313c = null;
    }

    public String b() {
        return this.f5312b;
    }

    public boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith(ai.at);
    }

    public String a() {
        return this.f5313c;
    }
}

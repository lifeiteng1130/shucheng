package com.ss.android.downloadlib.g;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.text.TextUtils;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import org.json.JSONObject;

/* JADX INFO: compiled from: AntiHijackUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: com.ss.android.downloadlib.g.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AntiHijackUtils.java */
    public static class C0084a implements InvocationHandler {
        private Object a;

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) {
            try {
                if ("startActivity".contains(method.getName())) {
                    a.a(objArr);
                }
            } catch (Throwable unused) {
            }
            return method.invoke(this.a, objArr);
        }

        private C0084a(Object obj) {
            this.a = obj;
        }
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return com.ss.android.a.c.a(new File(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c() {
        try {
            Field declaredField = Build.VERSION.SDK_INT < 26 ? Class.forName("android.app.ActivityManagerNative").getDeclaredField("gDefault") : Class.forName("android.app.ActivityManager").getDeclaredField("IActivityManagerSingleton");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(null);
            Field declaredField2 = Class.forName("android.util.Singleton").getDeclaredField("mInstance");
            declaredField2.setAccessible(true);
            Object obj2 = declaredField2.get(obj);
            if (obj2 == null) {
                return;
            }
            declaredField2.set(obj, Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{Class.forName("android.app.IActivityManager")}, new C0084a(obj2)));
        } catch (Throwable unused) {
        }
    }

    public static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            ApplicationInfo applicationInfo = com.ss.android.downloadlib.addownload.j.getContext().getPackageManager().getApplicationInfo(str, 0);
            if (applicationInfo != null) {
                return applicationInfo.sourceDir;
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public static int a(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return 5;
        }
        return com.ss.android.a.c.a(str, new File(str2));
    }

    public static void a() {
        if (com.ss.android.downloadlib.addownload.j.i().optInt("hook", 0) != 1) {
            return;
        }
        com.ss.android.downloadlib.d.a().a(new Runnable() { // from class: com.ss.android.downloadlib.g.a.1
            @Override // java.lang.Runnable
            public void run() {
                com.ss.android.socialbase.appdownloader.f.d.g();
                a.c();
            }
        }, 10000L);
    }

    public static void a(Object[] objArr) {
        if (com.ss.android.downloadlib.addownload.j.i().optInt("hook", 0) == 1 && (objArr[1] instanceof String) && (objArr[2] instanceof Intent)) {
            Intent intent = (Intent) objArr[2];
            if ("android.intent.action.VIEW".equals(intent.getAction()) && com.ss.android.socialbase.downloader.constants.e.a.equals(intent.getType())) {
                if (com.ss.android.socialbase.appdownloader.f.d.c()) {
                    String strOptString = com.ss.android.downloadlib.addownload.j.i().optString("hook_vivo_arg", "com.android.settings");
                    if ("null".equals(strOptString)) {
                        return;
                    }
                    objArr[1] = strOptString;
                    return;
                }
                if (com.ss.android.socialbase.appdownloader.f.d.d()) {
                    JSONObject jSONObjectI = com.ss.android.downloadlib.addownload.j.i();
                    StringBuilder sbR = c.a.a.a.a.r("com.");
                    sbR.append(com.ss.android.socialbase.downloader.constants.e.f3504c);
                    sbR.append(".market");
                    String strOptString2 = jSONObjectI.optString("hook_kllk_arg1", sbR.toString());
                    if (!"null".equals(strOptString2)) {
                        objArr[1] = strOptString2;
                    }
                    String strOptString3 = com.ss.android.downloadlib.addownload.j.i().optString("hook_kllk_arg2", "com.android.browser");
                    JSONObject jSONObjectI2 = com.ss.android.downloadlib.addownload.j.i();
                    StringBuilder sbR2 = c.a.a.a.a.r("m.store.");
                    sbR2.append(com.ss.android.socialbase.downloader.constants.e.f3504c);
                    sbR2.append("mobile.com");
                    String strOptString4 = jSONObjectI2.optString("hook_kllk_arg3", sbR2.toString());
                    intent.putExtra(com.ss.android.socialbase.downloader.constants.e.f3504c + "_extra_pkg_name", strOptString3);
                    intent.putExtra("refererHost", strOptString4);
                    if (com.ss.android.downloadlib.addownload.j.i().optInt("hook_kllk_arg4", 0) == 1) {
                        Intent intent2 = new Intent();
                        intent2.putExtra(com.ss.android.socialbase.downloader.constants.e.f3504c + "_extra_pkg_name", strOptString3);
                        intent2.putExtra("refererHost", strOptString4);
                        intent.putExtra("android.intent.extra.INTENT", intent2);
                        return;
                    }
                    return;
                }
                if (com.ss.android.socialbase.appdownloader.f.d.a()) {
                    String strOptString5 = com.ss.android.downloadlib.addownload.j.i().optString("hook_huawei_arg1", "com.huawei.appmarket");
                    if (!"null".equals(strOptString5)) {
                        objArr[1] = strOptString5;
                    }
                    intent.putExtra("caller_package", com.ss.android.downloadlib.addownload.j.i().optString("hook_huawei_arg2", "com.huawei.appmarket"));
                }
            }
        }
    }
}

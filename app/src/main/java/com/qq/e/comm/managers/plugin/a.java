package com.qq.e.comm.managers.plugin;

import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public class a {
    private static Method a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f2799b = false;

    public static void a(Throwable th, String str) {
        try {
            Exception exc = new Exception("插件错误：" + str, th);
            if (f2799b) {
                return;
            }
            if (a == null) {
                Method declaredMethod = Class.forName("com.tencent.bugly.crashreport.CrashReport").getDeclaredMethod("postCatchedException", Throwable.class);
                a = declaredMethod;
                declaredMethod.setAccessible(true);
            }
            a.invoke(null, exc);
        } catch (Throwable unused) {
            f2799b = true;
        }
    }
}

package com.tencent.bugly.proguard;

import java.util.Locale;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes.dex */
public class X {
    public static String a = "CrashReportInfo";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f4329b = "CrashReport";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f4330c = false;

    private static boolean a(int i2, String str, Object... objArr) {
        if (!f4330c) {
            return false;
        }
        f(str, objArr);
        return i2 == 0 || i2 == 1 || i2 == 2 || i2 == 3 || i2 == 5;
    }

    public static boolean b(Throwable th) {
        return a(2, th);
    }

    public static boolean c(String str, Object... objArr) {
        return a(0, str, objArr);
    }

    public static boolean d(String str, Object... objArr) {
        return a(5, str, objArr);
    }

    public static boolean e(String str, Object... objArr) {
        return a(2, str, objArr);
    }

    private static String f(String str, Object... objArr) {
        return str == null ? "null" : (objArr == null || objArr.length == 0) ? str : String.format(Locale.US, str, objArr);
    }

    public static boolean b(String str, Object... objArr) {
        return a(3, str, objArr);
    }

    public static boolean c(Class cls, String str, Object... objArr) {
        return a(0, String.format(Locale.US, "[%s] %s", cls.getSimpleName(), str), objArr);
    }

    private static boolean a(int i2, Throwable th) {
        if (f4330c) {
            return a(i2, ca.b(th), new Object[0]);
        }
        return false;
    }

    public static boolean b(Class cls, String str, Object... objArr) {
        return a(3, String.format(Locale.US, "[%s] %s", cls.getSimpleName(), str), objArr);
    }

    public static boolean a(String str, Object... objArr) {
        return a(1, str, objArr);
    }

    public static boolean a(Class cls, String str, Object... objArr) {
        return a(1, String.format(Locale.US, "[%s] %s", cls.getSimpleName(), str), objArr);
    }

    public static boolean a(Throwable th) {
        return a(3, th);
    }
}

package com.umeng.umzid;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes3.dex */
public class c {
    public static String a(Context context) {
        SharedPreferences sharedPreferencesA;
        if (context == null || (sharedPreferencesA = a.a(context)) == null) {
            return null;
        }
        return sharedPreferencesA.getString("aaid", null);
    }

    public static void a(Context context, String str) {
        SharedPreferences sharedPreferencesA;
        SharedPreferences.Editor editorEdit;
        if (context == null || str == null || TextUtils.isEmpty(str) || (sharedPreferencesA = a.a(context)) == null || (editorEdit = sharedPreferencesA.edit()) == null) {
            return;
        }
        editorEdit.putString("mac", str).commit();
    }

    public static String b(Context context) {
        SharedPreferences sharedPreferencesA;
        return (context == null || (sharedPreferencesA = a.a(context)) == null) ? "" : sharedPreferencesA.getString("zdata", null);
    }

    public static void b(Context context, String str) {
        SharedPreferences sharedPreferencesA;
        SharedPreferences.Editor editorEdit;
        if (context == null || str == null || TextUtils.isEmpty(str) || (sharedPreferencesA = a.a(context)) == null || (editorEdit = sharedPreferencesA.edit()) == null) {
            return;
        }
        editorEdit.putString("oaid", str).commit();
    }

    public static String c(Context context) {
        try {
            Class<?> cls = Class.forName("com.umeng.commonsdk.statistics.common.DeviceConfig");
            Method declaredMethod = cls.getDeclaredMethod("getMac", Context.class);
            if (declaredMethod != null) {
                declaredMethod.setAccessible(true);
                Object objInvoke = declaredMethod.invoke(cls, context);
                if (objInvoke != null && (objInvoke instanceof String)) {
                    return (String) objInvoke;
                }
            }
        } catch (Throwable unused) {
        }
        return "";
    }

    public static void c(Context context, String str) {
        SharedPreferences sharedPreferencesA;
        SharedPreferences.Editor editorEdit;
        if (context == null || TextUtils.isEmpty(str) || (sharedPreferencesA = a.a(context)) == null || (editorEdit = sharedPreferencesA.edit()) == null) {
            return;
        }
        editorEdit.putString("resetToken", str).commit();
    }

    public static String d(Context context) {
        try {
            Class<?> cls = Class.forName("com.umeng.commonsdk.statistics.common.DeviceConfig");
            Method declaredMethod = cls.getDeclaredMethod("getOaid", Context.class);
            if (declaredMethod != null) {
                declaredMethod.setAccessible(true);
                Object objInvoke = declaredMethod.invoke(cls, context);
                if (objInvoke != null && (objInvoke instanceof String)) {
                    return (String) objInvoke;
                }
            }
        } catch (Throwable unused) {
        }
        return "";
    }

    public static void d(Context context, String str) {
        SharedPreferences sharedPreferencesA;
        SharedPreferences.Editor editorEdit;
        if (context == null || TextUtils.isEmpty(str) || (sharedPreferencesA = a.a(context)) == null || (editorEdit = sharedPreferencesA.edit()) == null) {
            return;
        }
        editorEdit.putString("uabc", str).commit();
    }

    public static void e(Context context, String str) {
        SharedPreferences sharedPreferencesA;
        SharedPreferences.Editor editorEdit;
        if (context == null || str == null || TextUtils.isEmpty(str) || (sharedPreferencesA = a.a(context)) == null || (editorEdit = sharedPreferencesA.edit()) == null) {
            return;
        }
        editorEdit.putString("aaid", str).commit();
    }

    public static void f(Context context, String str) {
        SharedPreferences sharedPreferencesA;
        SharedPreferences.Editor editorEdit;
        if (context == null || str == null || TextUtils.isEmpty(str) || (sharedPreferencesA = a.a(context)) == null || (editorEdit = sharedPreferencesA.edit()) == null) {
            return;
        }
        editorEdit.putString("zdata", str).commit();
    }
}

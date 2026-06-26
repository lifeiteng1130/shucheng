package com.umeng.commonsdk.internal.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

/* JADX INFO: compiled from: UMInternalUtils.java */
/* JADX INFO: loaded from: classes3.dex */
public class j {
    private static final String a = "um_pri";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f5207b = "um_common_strength";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f5208c = "um_common_battery";

    public static String a(Context context) {
        SharedPreferences sharedPreferences;
        if (context == null || (sharedPreferences = context.getApplicationContext().getSharedPreferences(a, 0)) == null) {
            return null;
        }
        return sharedPreferences.getString(f5208c, null);
    }

    public static void a(Context context, String str) {
        SharedPreferences sharedPreferences;
        if (context == null || TextUtils.isEmpty(str) || (sharedPreferences = context.getApplicationContext().getSharedPreferences(a, 0)) == null) {
            return;
        }
        sharedPreferences.edit().putString(f5208c, str).commit();
    }
}

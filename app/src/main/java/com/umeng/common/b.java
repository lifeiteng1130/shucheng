package com.umeng.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;

/* JADX INFO: compiled from: SPHelper.java */
/* JADX INFO: loaded from: classes.dex */
public final class b {
    private static b a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Context f5058b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static String f5059c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f5060d = "mobclick_agent_user_";

    /* JADX INFO: compiled from: SPHelper.java */
    public static final class a {
        private static final b a = new b();

        private a() {
        }
    }

    public static synchronized b a(Context context) {
        if (f5058b == null && context != null) {
            f5058b = context.getApplicationContext();
        }
        if (f5058b != null) {
            f5059c = context.getPackageName();
        }
        return a.a;
    }

    private SharedPreferences e() {
        Context context = f5058b;
        if (context == null) {
            return null;
        }
        StringBuilder sbR = c.a.a.a.a.r(f5060d);
        sbR.append(f5059c);
        return context.getSharedPreferences(sbR.toString(), 0);
    }

    public void b() {
        SharedPreferences sharedPreferencesE = e();
        if (sharedPreferencesE != null) {
            sharedPreferencesE.edit().remove("au_p").remove("au_u").commit();
        }
    }

    public String c() {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f5058b);
        if (sharedPreferences != null) {
            return sharedPreferences.getString("st", null);
        }
        return null;
    }

    public int d() {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f5058b);
        if (sharedPreferences != null) {
            return sharedPreferences.getInt("vt", 0);
        }
        return 0;
    }

    public void a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        SharedPreferences.Editor editorEdit = e().edit();
        editorEdit.putString("au_p", str);
        editorEdit.putString("au_u", str2);
        editorEdit.commit();
    }

    public String[] a() {
        SharedPreferences sharedPreferencesE = e();
        if (sharedPreferencesE == null) {
            return null;
        }
        String string = sharedPreferencesE.getString("au_p", null);
        String string2 = sharedPreferencesE.getString("au_u", null);
        if (TextUtils.isEmpty(string) || TextUtils.isEmpty(string2)) {
            return null;
        }
        return new String[]{string, string2};
    }

    public void a(String str) {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f5058b);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putString("st", str).commit();
        }
    }

    public void a(int i2) {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f5058b);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putInt("vt", i2).commit();
        }
    }
}

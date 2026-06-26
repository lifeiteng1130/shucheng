package com.umeng.commonsdk.internal.utils;

import android.content.Context;
import android.content.SharedPreferences;
import com.umeng.commonsdk.internal.utils.a;
import com.umeng.commonsdk.statistics.common.ULog;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: InfoPreference.java */
/* JADX INFO: loaded from: classes3.dex */
public class f {
    private static final String a = "info";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f5194b = "a_dc";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f5195c = "bssid";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f5196d = "ssid";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f5197e = "a_fcy";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f5198f = "a_hssid";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final String f5199g = "a_ip";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final String f5200h = "a_ls";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final String f5201i = "a_mac";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final String f5202j = "a_nid";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final String f5203k = "rssi";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final String f5204l = "sta";
    private static final String m = "ts";
    private static final String n = "wifiinfo";
    private static final String o = "ua";

    public static JSONArray a(Context context) {
        String string;
        try {
            SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(a, 0);
            if (sharedPreferences == null || (string = sharedPreferences.getString(n, null)) == null) {
                return null;
            }
            return new JSONArray(string);
        } catch (Exception e2) {
            ULog.e(e2.getMessage());
            return null;
        }
    }

    public static void b(Context context) {
        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(a, 0);
        if (sharedPreferences != null) {
            sharedPreferences.edit().remove(n).commit();
        }
    }

    public static String c(Context context) {
        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(a, 0);
        if (sharedPreferences != null) {
            return sharedPreferences.getString(o, null);
        }
        return null;
    }

    public static void a(Context context, a.b bVar) {
        JSONArray jSONArray;
        try {
            SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(a, 0);
            String string = null;
            if (sharedPreferences != null) {
                String string2 = sharedPreferences.getString(n, null);
                if (string2 == null) {
                    jSONArray = new JSONArray();
                } else {
                    jSONArray = new JSONArray(string2);
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(f5194b, bVar.a);
                jSONObject.put(f5195c, bVar.f5163b);
                jSONObject.put(f5196d, bVar.f5164c);
                jSONObject.put(f5197e, bVar.f5165d);
                jSONObject.put(f5198f, bVar.f5166e);
                jSONObject.put(f5199g, bVar.f5167f);
                jSONObject.put(f5200h, bVar.f5168g);
                jSONObject.put(f5201i, bVar.f5169h);
                jSONObject.put(f5202j, bVar.f5170i);
                jSONObject.put(f5203k, bVar.f5171j);
                jSONObject.put(f5204l, bVar.f5172k);
                jSONObject.put("ts", bVar.f5173l);
                jSONArray.put(jSONObject);
                string = jSONArray.toString();
            }
            if (string != null) {
                sharedPreferences.edit().putString(n, string).commit();
            }
        } catch (Exception e2) {
            ULog.e(e2.getMessage());
        }
    }

    public static void a(Context context, String str) {
        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(a, 0);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putString(o, str).commit();
        }
    }
}

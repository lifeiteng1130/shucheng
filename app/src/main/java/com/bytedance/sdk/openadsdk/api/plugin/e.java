package com.bytedance.sdk.openadsdk.api.plugin;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.AdConfig;
import com.bytedance.sdk.openadsdk.TTAdManager;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTCustomController;
import com.bytedance.sdk.openadsdk.api.plugin.g;
import com.qq.e.comm.pi.ACTD;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: PluginReporter.java */
/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static SharedPreferences f1720b;
    private static ScheduledExecutorService a = Executors.newSingleThreadScheduledExecutor(new g.a("tt_pangle_thread_pl_report"));

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile boolean f1721c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Map<String, String> f1722d = new HashMap();

    private static void c(final String str, final JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        TTAdManager adManager = TTAdSdk.getAdManager();
        if (adManager == null) {
            if (f1721c) {
                return;
            }
            a.execute(new Runnable() { // from class: com.bytedance.sdk.openadsdk.api.plugin.e.1
                @Override // java.lang.Runnable
                public void run() {
                    e.b(e.d(str, jSONObject));
                }
            });
        } else {
            Bundle bundle = new Bundle();
            bundle.putInt("action", 1);
            bundle.putString("event_name", str);
            bundle.putString("event_extra", jSONObject.toString());
            adManager.getExtra(Bundle.class, bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static JSONObject d(String str, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        try {
            jSONObject.put("os_api", Build.VERSION.SDK_INT);
            jSONObject.put("support_abi", Arrays.toString(Build.SUPPORTED_ABIS));
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("ad_sdk_version", "4.0.1.1");
            jSONObject3.put("plugin_version", "4.0.1.1");
            jSONObject3.put("timestamp", System.currentTimeMillis() / 1000);
            jSONObject3.put("is_plugin", true);
            jSONObject3.put("event_extra", jSONObject.toString());
            jSONObject3.put("type", str);
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put("model", Build.MODEL);
            jSONObject4.put("vendor", Build.MANUFACTURER);
            jSONObject4.put("imei", f1722d.get("imei"));
            jSONObject4.put("oaid", f1722d.get("oaid"));
            jSONObject3.put("device_info", jSONObject4);
            jSONArray.put(jSONObject3);
            jSONObject2.put("stats_list", jSONArray);
        } catch (JSONException unused) {
        }
        return jSONObject2;
    }

    public static void a(Context context) {
        f1720b = context.getSharedPreferences("tt_sdk_settings", 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String b(JSONObject jSONObject) {
        SharedPreferences sharedPreferences = f1720b;
        return com.bytedance.sdk.openadsdk.api.a.c.a().a(true, String.format("https://%s%s", sharedPreferences != null ? sharedPreferences.getString("url_alog", "pangolin.snssdk.com") : "pangolin.snssdk.com", "/api/ad/union/sdk/stats/batch/"), com.bytedance.sdk.openadsdk.api.b.b.a(jSONObject).toString().getBytes());
    }

    public static final void a(int i2, String str, long j2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("duration", Long.valueOf(j2));
            jSONObject.putOpt("code", Integer.valueOf(i2));
            jSONObject.putOpt("message", str);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        c("plugin_load_failed", jSONObject);
    }

    public static void b(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        try {
            String string = bundle.getString("event_name");
            String string2 = bundle.getString("event_extra");
            b(d(string, TextUtils.isEmpty(string2) ? new JSONObject() : new JSONObject(string2)));
        } catch (Exception unused) {
        }
    }

    public static void a(String str, JSONObject jSONObject) {
        c(c.a.a.a.a.i("zeus_", str), jSONObject);
    }

    public static void a() {
        if (f1721c) {
            return;
        }
        try {
            f1721c = true;
            a.shutdown();
        } catch (Throwable unused) {
        }
    }

    public static void a(final Bundle bundle) {
        if (f1721c) {
            return;
        }
        a.execute(new Runnable() { // from class: com.bytedance.sdk.openadsdk.api.plugin.e.2
            @Override // java.lang.Runnable
            public void run() {
                e.b(bundle);
            }
        });
    }

    public static void a(AdConfig adConfig) {
        if (adConfig == null) {
            return;
        }
        f1722d.put(ACTD.APPID_KEY, adConfig.getAppId());
        TTCustomController customController = adConfig.getCustomController();
        if (customController != null) {
            try {
                f1722d.put("oaid", customController.getDevOaid());
                f1722d.put("imei", customController.getDevImei());
            } catch (Exception unused) {
            }
        }
    }
}

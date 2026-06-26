package com.ss.android.socialbase.appdownloader;

import android.text.TextUtils;
import org.json.JSONObject;

/* JADX INFO: compiled from: AhAttempt.java */
/* JADX INFO: loaded from: classes.dex */
public class a {
    public String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f3294b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f3295c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f3296d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f3297e;

    public String a() {
        return b().toString();
    }

    public JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        a(jSONObject);
        return jSONObject;
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("ah_plan_type", this.a);
            jSONObject.put("error_code", String.valueOf(this.f3294b));
            jSONObject.put("error_msg", this.f3295c);
            jSONObject.put("real_device_plan", this.f3296d);
            jSONObject.put("device_plans", this.f3297e);
        } catch (Throwable unused) {
        }
    }

    public static a a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        a aVar = new a();
        try {
            JSONObject jSONObject = new JSONObject(str);
            aVar.f3297e = jSONObject.optString("device_plans", null);
            aVar.f3296d = jSONObject.optString("real_device_plan", null);
            aVar.f3295c = jSONObject.optString("error_msg", null);
            aVar.a = jSONObject.optString("ah_plan_type", null);
            String strOptString = jSONObject.optString("error_code");
            if (TextUtils.isEmpty(strOptString)) {
                aVar.f3294b = -1;
            } else {
                aVar.f3294b = Integer.parseInt(strOptString);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return aVar;
    }
}

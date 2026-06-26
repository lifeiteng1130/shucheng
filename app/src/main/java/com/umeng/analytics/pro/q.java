package com.umeng.analytics.pro;

import android.content.Context;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.service.UMGlobalContext;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: DefconProcesser.java */
/* JADX INFO: loaded from: classes.dex */
public class q {
    private static final int a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f4945b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f4946c = 2;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f4947d = 3;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final long f4948e;

    /* JADX INFO: compiled from: DefconProcesser.java */
    public static class a {
        public static final q a = new q();

        private a() {
        }
    }

    public static q a() {
        return a.a;
    }

    private JSONArray c() {
        JSONArray jSONArray = new JSONArray();
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", x.a().d(UMGlobalContext.getAppContext(null)));
            jSONObject.put(c.p, jCurrentTimeMillis);
            jSONArray.put(jSONObject);
        } catch (JSONException unused) {
        }
        return jSONArray;
    }

    public void b(JSONObject jSONObject, Context context) {
        int iA = a(context);
        if (iA == 1) {
            if (jSONObject.has(c.L)) {
                jSONObject.remove(c.L);
            }
            if (jSONObject.has(c.n)) {
                try {
                    JSONArray jSONArray = jSONObject.getJSONArray(c.n);
                    int length = jSONArray.length();
                    for (int i2 = 0; i2 < length; i2++) {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                        if (jSONObject2.has(c.au)) {
                            jSONObject2.remove(c.au);
                        }
                        if (jSONObject2.has(c.av)) {
                            jSONObject2.remove(c.av);
                        }
                    }
                } catch (JSONException unused) {
                }
            }
            h.a(context).a(false, true);
            return;
        }
        if (iA == 2) {
            if (jSONObject.has(c.L)) {
                jSONObject.remove(c.L);
            }
            if (jSONObject.has(c.n)) {
                jSONObject.remove(c.n);
            }
            try {
                jSONObject.put(c.n, c());
            } catch (Exception unused2) {
            }
            h.a(context).a(false, true);
            return;
        }
        if (iA == 3) {
            if (jSONObject.has(c.L)) {
                jSONObject.remove(c.L);
            }
            jSONObject.remove(c.n);
            h.a(context).a(false, true);
        }
    }

    private q() {
        this.f4948e = 60000L;
    }

    public int a(Context context) {
        return Integer.valueOf(UMEnvelopeBuild.imprintProperty(context, "defcon", String.valueOf(0))).intValue();
    }

    private void a(JSONObject jSONObject, boolean z) {
        if (!z && jSONObject.has(c.n)) {
            jSONObject.remove(c.n);
        }
        if (jSONObject.has(c.L)) {
            jSONObject.remove(c.L);
        }
        if (jSONObject.has(c.O)) {
            jSONObject.remove(c.O);
        }
        if (jSONObject.has("ekv")) {
            jSONObject.remove("ekv");
        }
        if (jSONObject.has(c.T)) {
            jSONObject.remove(c.T);
        }
        if (jSONObject.has(c.L)) {
            jSONObject.remove(c.L);
        }
        if (jSONObject.has("userlevel")) {
            jSONObject.remove("userlevel");
        }
    }

    public void a(JSONObject jSONObject, Context context) {
        int iA = a(context);
        if (iA == 1) {
            a(jSONObject, true);
            h.a(context).b(false, true);
        } else {
            if (iA == 2) {
                jSONObject.remove(c.n);
                try {
                    jSONObject.put(c.n, b());
                } catch (Exception unused) {
                }
                a(jSONObject, true);
                h.a(context).b(false, true);
                return;
            }
            if (iA == 3) {
                a(jSONObject, false);
                h.a(context).b(false, true);
            }
        }
    }

    private JSONArray b() {
        JSONArray jSONArray = new JSONArray();
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", x.a().a(UMGlobalContext.getAppContext(null)));
            jSONObject.put(c.p, jCurrentTimeMillis);
            jSONObject.put(c.q, jCurrentTimeMillis + 60000);
            jSONObject.put("duration", 60000L);
            jSONArray.put(jSONObject);
        } catch (JSONException unused) {
        }
        return jSONArray;
    }
}

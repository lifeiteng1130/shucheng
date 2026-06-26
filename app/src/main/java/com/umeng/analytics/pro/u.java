package com.umeng.analytics.pro;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.analytics.CoreProtocol;
import com.umeng.analytics.pro.h;
import com.umeng.analytics.vshelper.PageNameMonitor;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.service.UMGlobalContext;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: ViewPageTracker.java */
/* JADX INFO: loaded from: classes.dex */
public class u {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f4967c = 5;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static JSONArray f4968d = new JSONArray();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static Object f4969e = new Object();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Map<String, Long> f4971f = new HashMap();
    public Stack<String> a = new Stack<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.umeng.analytics.vshelper.a f4970b = PageNameMonitor.getInstance();

    public static void a(Context context) {
        String string;
        if (context != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                synchronized (f4969e) {
                    string = f4968d.toString();
                    f4968d = new JSONArray();
                }
                if (string.length() > 0) {
                    jSONObject.put("__a", new JSONArray(string));
                    if (jSONObject.length() > 0) {
                        h.a(context).a(t.a().c(), jSONObject, h.a.PAGE);
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    public int a() {
        return 2;
    }

    public void b(String str) {
        Long l2;
        Context appContext;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (!this.f4971f.containsKey(str)) {
            if (UMConfigure.isDebugLog() && this.a.size() == 0) {
                UMLog.aq(i.G, 0, "\\|", new String[]{"@"}, new String[]{str}, null, null);
                return;
            }
            return;
        }
        synchronized (this.f4971f) {
            l2 = this.f4971f.get(str);
        }
        if (l2 == null) {
            return;
        }
        if (UMConfigure.isDebugLog() && this.a.size() > 0 && str.equals(this.a.peek())) {
            this.a.pop();
        }
        long jCurrentTimeMillis = System.currentTimeMillis() - l2.longValue();
        synchronized (f4969e) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(c.v, str);
                jSONObject.put("duration", jCurrentTimeMillis);
                jSONObject.put(c.x, l2);
                jSONObject.put("type", a());
                f4968d.put(jSONObject);
                if (f4968d.length() >= 5 && (appContext = UMGlobalContext.getAppContext(null)) != null) {
                    UMWorkDispatch.sendEvent(appContext, 4099, CoreProtocol.getInstance(appContext), null);
                }
            } catch (Throwable unused) {
            }
        }
        if (!UMConfigure.isDebugLog() || this.a.size() == 0) {
            return;
        }
        UMLog.aq(i.E, 0, "\\|", new String[]{"@"}, new String[]{str}, null, null);
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (UMConfigure.isDebugLog() && this.a.size() != 0) {
            UMLog.aq(i.F, 0, "\\|", new String[]{"@"}, new String[]{this.a.peek()}, null, null);
        }
        this.f4970b.customPageBegin(str);
        synchronized (this.f4971f) {
            this.f4971f.put(str, Long.valueOf(System.currentTimeMillis()));
            if (UMConfigure.isDebugLog()) {
                this.a.push(str);
            }
        }
    }

    public void b() {
        String key;
        synchronized (this.f4971f) {
            key = null;
            long j2 = 0;
            for (Map.Entry<String, Long> entry : this.f4971f.entrySet()) {
                if (entry.getValue().longValue() > j2) {
                    long jLongValue = entry.getValue().longValue();
                    key = entry.getKey();
                    j2 = jLongValue;
                }
            }
        }
        if (key != null) {
            b(key);
        }
    }
}

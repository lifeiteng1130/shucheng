package com.tencent.bugly.crashreport.crash.h5;

import android.webkit.JavascriptInterface;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.tencent.bugly.crashreport.CrashReport;
import com.tencent.bugly.crashreport.inner.InnerApi;
import com.tencent.bugly.proguard.X;
import com.tencent.bugly.proguard.ca;
import com.umeng.analytics.pro.ai;
import com.umeng.analytics.pro.c;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes.dex */
public class H5JavaScriptInterface {
    private static HashSet<Integer> a = new HashSet<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f4195b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Thread f4196c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f4197d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Map<String, String> f4198e = null;

    private H5JavaScriptInterface() {
    }

    private static String a(Thread thread) {
        if (thread == null) {
            return null;
        }
        StringBuilder sbR = c.a.a.a.a.r("\n");
        for (int i2 = 2; i2 < thread.getStackTrace().length; i2++) {
            StackTraceElement stackTraceElement = thread.getStackTrace()[i2];
            if (!stackTraceElement.toString().contains("crashreport")) {
                sbR.append(stackTraceElement.toString());
                sbR.append("\n");
            }
        }
        return sbR.toString();
    }

    public static H5JavaScriptInterface getInstance(CrashReport.WebViewInterface webViewInterface) {
        if (webViewInterface == null || a.contains(Integer.valueOf(webViewInterface.hashCode()))) {
            return null;
        }
        H5JavaScriptInterface h5JavaScriptInterface = new H5JavaScriptInterface();
        a.add(Integer.valueOf(webViewInterface.hashCode()));
        Thread threadCurrentThread = Thread.currentThread();
        h5JavaScriptInterface.f4196c = threadCurrentThread;
        h5JavaScriptInterface.f4197d = a(threadCurrentThread);
        h5JavaScriptInterface.f4198e = a(webViewInterface);
        return h5JavaScriptInterface;
    }

    @JavascriptInterface
    public void printLog(String str) {
        X.e("Log from js: %s", str);
    }

    @JavascriptInterface
    public void reportJSException(String str) {
        if (str == null) {
            X.e("Payload from JS is null.", new Object[0]);
            return;
        }
        String strC = ca.c(str.getBytes());
        String str2 = this.f4195b;
        if (str2 != null && str2.equals(strC)) {
            X.e("Same payload from js. Please check whether you've injected bugly.js more than one times.", new Object[0]);
            return;
        }
        this.f4195b = strC;
        X.e("Handling JS exception ...", new Object[0]);
        a aVarA = a(str);
        if (aVarA == null) {
            X.e("Failed to parse payload.", new Object[0]);
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.putAll(aVarA.a());
        linkedHashMap.putAll(this.f4198e);
        linkedHashMap.put("Java Stack", this.f4197d);
        a(aVarA, this.f4196c, linkedHashMap);
    }

    private static Map<String, String> a(CrashReport.WebViewInterface webViewInterface) {
        HashMap map = new HashMap();
        StringBuilder sbR = c.a.a.a.a.r("");
        sbR.append((Object) webViewInterface.getContentDescription());
        map.put("[WebView] ContentDescription", sbR.toString());
        return map;
    }

    private a a(String str) {
        String string;
        if (str != null && str.length() > 0) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                a aVar = new a();
                String string2 = jSONObject.getString("projectRoot");
                aVar.a = string2;
                if (string2 == null) {
                    return null;
                }
                String string3 = jSONObject.getString(c.R);
                aVar.f4199b = string3;
                if (string3 == null) {
                    return null;
                }
                String string4 = jSONObject.getString("url");
                aVar.f4200c = string4;
                if (string4 == null) {
                    return null;
                }
                String string5 = jSONObject.getString(TTDownloadField.TT_USERAGENT);
                aVar.f4201d = string5;
                if (string5 == null) {
                    return null;
                }
                String string6 = jSONObject.getString(ai.N);
                aVar.f4202e = string6;
                if (string6 == null) {
                    return null;
                }
                String string7 = jSONObject.getString("name");
                aVar.f4203f = string7;
                if (string7 == null || string7.equals("null") || (string = jSONObject.getString("stacktrace")) == null) {
                    return null;
                }
                int iIndexOf = string.indexOf("\n");
                if (iIndexOf < 0) {
                    X.e("H5 crash stack's format is wrong!", new Object[0]);
                    return null;
                }
                aVar.f4205h = string.substring(iIndexOf + 1);
                String strSubstring = string.substring(0, iIndexOf);
                aVar.f4204g = strSubstring;
                int iIndexOf2 = strSubstring.indexOf(":");
                if (iIndexOf2 > 0) {
                    aVar.f4204g = aVar.f4204g.substring(iIndexOf2 + 1);
                }
                aVar.f4206i = jSONObject.getString("file");
                if (aVar.f4203f == null) {
                    return null;
                }
                long j2 = jSONObject.getLong("lineNumber");
                aVar.f4207j = j2;
                if (j2 < 0) {
                    return null;
                }
                long j3 = jSONObject.getLong("columnNumber");
                aVar.f4208k = j3;
                if (j3 < 0) {
                    return null;
                }
                X.c("H5 crash information is following: ", new Object[0]);
                StringBuilder sb = new StringBuilder();
                sb.append("[projectRoot]: ");
                sb.append(aVar.a);
                X.c(sb.toString(), new Object[0]);
                StringBuilder sb2 = new StringBuilder();
                sb2.append("[context]: ");
                sb2.append(aVar.f4199b);
                X.c(sb2.toString(), new Object[0]);
                StringBuilder sb3 = new StringBuilder();
                sb3.append("[url]: ");
                sb3.append(aVar.f4200c);
                X.c(sb3.toString(), new Object[0]);
                StringBuilder sb4 = new StringBuilder();
                sb4.append("[userAgent]: ");
                sb4.append(aVar.f4201d);
                X.c(sb4.toString(), new Object[0]);
                StringBuilder sb5 = new StringBuilder();
                sb5.append("[language]: ");
                sb5.append(aVar.f4202e);
                X.c(sb5.toString(), new Object[0]);
                StringBuilder sb6 = new StringBuilder();
                sb6.append("[name]: ");
                sb6.append(aVar.f4203f);
                X.c(sb6.toString(), new Object[0]);
                StringBuilder sb7 = new StringBuilder();
                sb7.append("[message]: ");
                sb7.append(aVar.f4204g);
                X.c(sb7.toString(), new Object[0]);
                StringBuilder sb8 = new StringBuilder();
                sb8.append("[stacktrace]: \n");
                sb8.append(aVar.f4205h);
                X.c(sb8.toString(), new Object[0]);
                StringBuilder sb9 = new StringBuilder();
                sb9.append("[file]: ");
                sb9.append(aVar.f4206i);
                X.c(sb9.toString(), new Object[0]);
                StringBuilder sb10 = new StringBuilder();
                sb10.append("[lineNumber]: ");
                sb10.append(aVar.f4207j);
                X.c(sb10.toString(), new Object[0]);
                StringBuilder sb11 = new StringBuilder();
                sb11.append("[columnNumber]: ");
                sb11.append(aVar.f4208k);
                X.c(sb11.toString(), new Object[0]);
                return aVar;
            } catch (Throwable th) {
                if (!X.b(th)) {
                    th.printStackTrace();
                }
            }
        }
        return null;
    }

    private static void a(a aVar, Thread thread, Map<String, String> map) {
        if (aVar != null) {
            InnerApi.postH5CrashAsync(thread, aVar.f4203f, aVar.f4204g, aVar.f4205h, map);
        }
    }
}

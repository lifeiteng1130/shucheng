package com.umeng.analytics.pro;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.analytics.CoreProtocol;
import com.umeng.analytics.pro.n;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.common.HelperUtils;
import com.umeng.commonsdk.statistics.common.MLog;
import com.umeng.commonsdk.statistics.common.ULog;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import com.umeng.commonsdk.utils.UMUtils;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.antlr.v4.runtime.tree.xpath.XPath;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: EventTracker.java */
/* JADX INFO: loaded from: classes.dex */
public class r {
    private static final String a = "fs_lc_tl_uapp";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f4949f = "-1";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static Context f4950g;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f4951b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f4952c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f4953d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f4954e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private JSONObject f4955h;

    /* JADX INFO: compiled from: EventTracker.java */
    public static class a {
        private static final r a = new r();

        private a() {
        }
    }

    public static r a(Context context) {
        if (f4950g == null && context != null) {
            f4950g = context.getApplicationContext();
        }
        return a.a;
    }

    private void b(Context context) {
        try {
            String string = PreferenceWrapper.getDefault(context).getString(a, null);
            if (!TextUtils.isEmpty(string)) {
                this.f4955h = new JSONObject(string);
            }
            a();
        } catch (Exception unused) {
        }
    }

    private void c(Context context) {
        try {
            if (this.f4955h != null) {
                PreferenceWrapper.getDefault(f4950g).edit().putString(a, this.f4955h.toString()).commit();
            }
        } catch (Throwable unused) {
        }
    }

    private r() {
        this.f4951b = 128;
        this.f4952c = 256;
        this.f4953d = 1024;
        this.f4954e = 10;
        this.f4955h = null;
        if (0 == 0) {
            try {
                b(f4950g);
            } catch (Throwable unused) {
            }
        }
    }

    private boolean c(String str) {
        if (str == null) {
            return true;
        }
        try {
            return str.trim().getBytes().length <= 1024;
        } catch (Exception unused) {
            return false;
        }
    }

    public void a(String str, String str2, long j2, int i2, String str3) {
        String strA;
        try {
            if (a(str) && b(str2)) {
                if (Arrays.asList(c.aG).contains(str)) {
                    MLog.e("key is " + str + ", please check key, illegal");
                    UMLog.aq(i.m, 0, "\\|");
                    return;
                }
                long jCurrentTimeMillis = System.currentTimeMillis();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("id", str);
                jSONObject.put("ts", jCurrentTimeMillis);
                if (j2 > 0) {
                    jSONObject.put(c.W, j2);
                }
                jSONObject.put("__t", h.a);
                if (!TextUtils.isEmpty(str2)) {
                    jSONObject.put(str, str2);
                }
                if (UMUtils.isMainProgress(f4950g)) {
                    strA = x.a().d(UMGlobalContext.getAppContext(f4950g));
                } else {
                    strA = x.a().a(UMGlobalContext.getAppContext(f4950g), jCurrentTimeMillis);
                }
                if (TextUtils.isEmpty(strA)) {
                    strA = f4949f;
                }
                jSONObject.put("__i", strA);
                if (!TextUtils.isEmpty(str3)) {
                    try {
                        JSONObject jSONObject2 = new JSONObject(str3);
                        if (jSONObject2.length() > 0) {
                            jSONObject.put(c.au, jSONObject2);
                        }
                    } catch (JSONException unused) {
                    }
                }
                jSONObject.put("ds", 0);
                jSONObject.put("pn", UMGlobalContext.getInstance(f4950g).getProcessName(f4950g));
                a();
                JSONObject jSONObject3 = this.f4955h;
                if (jSONObject3 != null && jSONObject3.has(str) && !((Boolean) this.f4955h.get(str)).booleanValue()) {
                    jSONObject.put(c.Y, 1);
                    this.f4955h.put(str, true);
                    c(f4950g);
                }
                Context context = f4950g;
                UMWorkDispatch.sendEvent(context, 4097, CoreProtocol.getInstance(context), jSONObject);
                return;
            }
            UMLog.aq(i.f4896l, 0, "\\|");
        } catch (Throwable unused2) {
        }
    }

    private boolean b(String str) {
        if (str == null) {
            return true;
        }
        try {
            if (str.trim().getBytes().length <= 256) {
                return true;
            }
        } catch (Exception unused) {
        }
        MLog.e("value is " + str + ", please check value, illegal");
        return false;
    }

    private boolean b(Map<String, Object> map) {
        if (map != null) {
            try {
                if (!map.isEmpty()) {
                    for (Map.Entry<String, Object> entry : map.entrySet()) {
                        if (!a(entry.getKey())) {
                            UMLog.aq(i.f4892h, 0, "\\|");
                            return false;
                        }
                        if (entry.getValue() == null) {
                            UMLog.aq(i.f4893i, 0, "\\|");
                            return false;
                        }
                        if (entry.getValue() instanceof String) {
                            if (c.aE.equals(entry.getKey())) {
                                if (!c(entry.getValue().toString())) {
                                    UMLog.aq(i.P, 0, "\\|");
                                    return false;
                                }
                            } else if ("_$!url".equals(entry.getKey())) {
                                if (!c(entry.getValue().toString())) {
                                    UMLog.aq("url参数长度超过限制。|参数url长度不能超过1024字符。", 0, "\\|");
                                    return false;
                                }
                            } else if (!b(entry.getValue().toString())) {
                                UMLog.aq(i.f4894j, 0, "\\|");
                                return false;
                            }
                        }
                    }
                    return true;
                }
            } catch (Exception unused) {
                return true;
            }
        }
        UMLog.aq(i.f4891g, 0, "\\|");
        return false;
    }

    public void a(String str, Map<String, Object> map, long j2, String str2, boolean z) {
        String strA;
        try {
            if (!a(str)) {
                UMLog.aq(i.f4890f, 0, "\\|");
                return;
            }
            if (b(map)) {
                if (map.size() > 100) {
                    MLog.e("map size is " + map.size() + ", please check");
                    return;
                }
                if (Arrays.asList(c.aG).contains(str)) {
                    MLog.e("key is " + str + ", please check key, illegal");
                    UMLog.aq(i.f4886b, 0, "\\|");
                    return;
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("id", str);
                jSONObject.put("ts", System.currentTimeMillis());
                if (j2 > 0) {
                    jSONObject.put(c.W, j2);
                }
                jSONObject.put("__t", h.a);
                ULog.i("befort ekv map, event is " + jSONObject.toString());
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    if (!Arrays.asList(c.aG).contains(entry.getKey())) {
                        Object value = entry.getValue();
                        if (!(value instanceof String) && !(value instanceof Integer) && !(value instanceof Long) && !(value instanceof Short) && !(value instanceof Float) && !(value instanceof Double)) {
                            if (value.getClass().isArray()) {
                                if (value instanceof int[]) {
                                    int[] iArr = (int[]) value;
                                    if (iArr.length > 10) {
                                        MLog.e("please check key or value, size overlength!");
                                        return;
                                    }
                                    JSONArray jSONArray = new JSONArray();
                                    for (int i2 : iArr) {
                                        jSONArray.put(i2);
                                    }
                                    jSONObject.put(entry.getKey(), jSONArray);
                                } else if (value instanceof double[]) {
                                    double[] dArr = (double[]) value;
                                    if (dArr.length > 10) {
                                        MLog.e("please check key or value, size overlength!");
                                        return;
                                    }
                                    JSONArray jSONArray2 = new JSONArray();
                                    for (double d2 : dArr) {
                                        jSONArray2.put(d2);
                                    }
                                    jSONObject.put(entry.getKey(), jSONArray2);
                                } else if (value instanceof long[]) {
                                    long[] jArr = (long[]) value;
                                    if (jArr.length > 10) {
                                        MLog.e("please check key or value, size overlength!");
                                        return;
                                    }
                                    JSONArray jSONArray3 = new JSONArray();
                                    for (long j3 : jArr) {
                                        jSONArray3.put(j3);
                                    }
                                    jSONObject.put(entry.getKey(), jSONArray3);
                                } else if (value instanceof float[]) {
                                    float[] fArr = (float[]) value;
                                    if (fArr.length > 10) {
                                        MLog.e("please check key or value, size overlength!");
                                        return;
                                    }
                                    JSONArray jSONArray4 = new JSONArray();
                                    for (float f2 : fArr) {
                                        jSONArray4.put(f2);
                                    }
                                    jSONObject.put(entry.getKey(), jSONArray4);
                                } else if (value instanceof short[]) {
                                    short[] sArr = (short[]) value;
                                    if (sArr.length > 10) {
                                        MLog.e("please check key or value, size overlength!");
                                        return;
                                    }
                                    JSONArray jSONArray5 = new JSONArray();
                                    for (short s : sArr) {
                                        jSONArray5.put((int) s);
                                    }
                                    jSONObject.put(entry.getKey(), jSONArray5);
                                } else if (value instanceof String[]) {
                                    String[] strArr = (String[]) value;
                                    if (strArr.length > 10) {
                                        MLog.e("please check key or value, size overlength!");
                                        return;
                                    }
                                    JSONArray jSONArray6 = new JSONArray();
                                    for (int i3 = 0; i3 < strArr.length; i3++) {
                                        if (strArr[i3] == null) {
                                            MLog.e("please check array, null item!");
                                            return;
                                        } else {
                                            if (!b(strArr[i3])) {
                                                return;
                                            }
                                            jSONArray6.put(strArr[i3]);
                                        }
                                    }
                                    jSONObject.put(entry.getKey(), jSONArray6);
                                } else {
                                    MLog.e("please check key or value, illegal type!");
                                    return;
                                }
                            } else {
                                MLog.e("please check key or value, illegal type!");
                                return;
                            }
                        } else {
                            jSONObject.put(entry.getKey(), value);
                        }
                    } else {
                        UMLog.aq(i.f4889e, 0, "\\|");
                        return;
                    }
                }
                if (UMUtils.isMainProgress(f4950g)) {
                    strA = x.a().d(UMGlobalContext.getAppContext(f4950g));
                } else {
                    strA = x.a().a(UMGlobalContext.getAppContext(f4950g), jSONObject.getLong("ts"));
                }
                if (TextUtils.isEmpty(strA)) {
                    strA = f4949f;
                }
                jSONObject.put("__i", strA);
                if (!TextUtils.isEmpty(str2)) {
                    try {
                        JSONObject jSONObject2 = new JSONObject(str2);
                        if (jSONObject2.length() > 0) {
                            jSONObject.put(c.au, jSONObject2);
                        }
                    } catch (JSONException unused) {
                    }
                }
                jSONObject.put("ds", 0);
                jSONObject.put("pn", UMGlobalContext.getInstance(f4950g).getProcessName(f4950g));
                a();
                JSONObject jSONObject3 = this.f4955h;
                if (jSONObject3 != null && jSONObject3.has(str) && !((Boolean) this.f4955h.get(str)).booleanValue()) {
                    jSONObject.put(c.Y, 1);
                    this.f4955h.put(str, true);
                    c(f4950g);
                }
                ULog.i("----->>>>>ekv event json is " + jSONObject.toString());
                if (!z) {
                    Context context = f4950g;
                    UMWorkDispatch.sendEvent(context, 4097, CoreProtocol.getInstance(context), jSONObject);
                } else {
                    Context context2 = f4950g;
                    UMWorkDispatch.sendEvent(context2, n.a.n, CoreProtocol.getInstance(context2), jSONObject);
                }
            }
        } catch (Throwable unused2) {
        }
    }

    public void a(String str, Map<String, Object> map, String str2) {
        try {
            if (a(str)) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("id", str);
                jSONObject.put("ts", System.currentTimeMillis());
                jSONObject.put(c.W, 0);
                jSONObject.put("__t", h.f4869b);
                ULog.i("befort gkv map, event is " + jSONObject.toString());
                Iterator<Map.Entry<String, Object>> it = map.entrySet().iterator();
                for (int i2 = 0; i2 < 10 && it.hasNext(); i2++) {
                    Map.Entry<String, Object> next = it.next();
                    if (!c.Y.equals(next.getKey()) && !c.W.equals(next.getKey()) && !"id".equals(next.getKey()) && !"ts".equals(next.getKey())) {
                        Object value = next.getValue();
                        if ((value instanceof String) || (value instanceof Integer) || (value instanceof Long)) {
                            jSONObject.put(next.getKey(), value);
                        }
                    }
                }
                String strD = x.a().d(UMGlobalContext.getAppContext(f4950g));
                if (TextUtils.isEmpty(strD)) {
                    strD = f4949f;
                }
                jSONObject.put("__i", strD);
                if (!TextUtils.isEmpty(str2)) {
                    try {
                        JSONObject jSONObject2 = new JSONObject(str2);
                        if (jSONObject2.length() > 0) {
                            jSONObject.put(c.au, jSONObject2);
                        }
                    } catch (JSONException unused) {
                    }
                }
                jSONObject.put("ds", 0);
                jSONObject.put("pn", UMGlobalContext.getInstance(f4950g).getProcessName(f4950g));
                ULog.i("----->>>>>gkv event json is " + jSONObject.toString());
                Context context = f4950g;
                UMWorkDispatch.sendEvent(context, 4098, CoreProtocol.getInstance(context), jSONObject);
            }
        } catch (Throwable unused2) {
        }
    }

    private void a() {
        try {
            String strImprintProperty = UMEnvelopeBuild.imprintProperty(f4950g, "track_list", "");
            if (TextUtils.isEmpty(strImprintProperty)) {
                return;
            }
            String[] strArrSplit = strImprintProperty.split(XPath.NOT);
            JSONObject jSONObject = new JSONObject();
            int i2 = 0;
            if (this.f4955h != null) {
                for (String str : strArrSplit) {
                    String strSubStr = HelperUtils.subStr(str, 128);
                    if (this.f4955h.has(strSubStr)) {
                        jSONObject.put(strSubStr, this.f4955h.get(strSubStr));
                    }
                }
            }
            this.f4955h = new JSONObject();
            if (strArrSplit.length >= 10) {
                while (i2 < 10) {
                    a(strArrSplit[i2], jSONObject);
                    i2++;
                }
            } else {
                while (i2 < strArrSplit.length) {
                    a(strArrSplit[i2], jSONObject);
                    i2++;
                }
            }
            c(f4950g);
        } catch (Exception unused) {
        }
    }

    private void a(String str, JSONObject jSONObject) {
        String strSubStr = HelperUtils.subStr(str, 128);
        if (jSONObject.has(strSubStr)) {
            a(strSubStr, ((Boolean) jSONObject.get(strSubStr)).booleanValue());
        } else {
            a(strSubStr, false);
        }
    }

    private void a(String str, boolean z) {
        try {
            if (c.Y.equals(str) || c.W.equals(str) || "id".equals(str) || "ts".equals(str) || this.f4955h.has(str)) {
                return;
            }
            this.f4955h.put(str, z);
        } catch (Exception unused) {
        }
    }

    public void a(List<String> list) {
        if (list != null) {
            try {
                if (list.size() > 0) {
                    a();
                    JSONObject jSONObject = this.f4955h;
                    if (jSONObject == null) {
                        this.f4955h = new JSONObject();
                        int size = list.size();
                        for (int i2 = 0; i2 < size; i2++) {
                            JSONObject jSONObject2 = this.f4955h;
                            if (jSONObject2 == null) {
                                this.f4955h = new JSONObject();
                            } else if (jSONObject2.length() >= 5) {
                                break;
                            }
                            String str = list.get(i2);
                            if (!TextUtils.isEmpty(str)) {
                                a(HelperUtils.subStr(str, 128), false);
                            }
                        }
                        c(f4950g);
                        return;
                    }
                    if (jSONObject.length() >= 5) {
                        MLog.d("already setFistLaunchEvent, igone.");
                        return;
                    }
                    for (int i3 = 0; i3 < list.size(); i3++) {
                        if (this.f4955h.length() >= 5) {
                            MLog.d(" add setFistLaunchEvent over.");
                            return;
                        }
                        a(HelperUtils.subStr(list.get(i3), 128), false);
                    }
                    c(f4950g);
                    return;
                }
            } catch (Exception unused) {
                return;
            }
        }
        UMLog.aq(i.ak, 0, "\\|");
    }

    private JSONObject a(Map<String, Object> map) {
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                try {
                    String key = entry.getKey();
                    if (key != null) {
                        String strSubStr = HelperUtils.subStr(key, 128);
                        Object value = entry.getValue();
                        if (value != null) {
                            int i2 = 0;
                            if (value.getClass().isArray()) {
                                if (value instanceof int[]) {
                                    int[] iArr = (int[]) value;
                                    JSONArray jSONArray = new JSONArray();
                                    while (i2 < iArr.length) {
                                        jSONArray.put(iArr[i2]);
                                        i2++;
                                    }
                                    jSONObject.put(strSubStr, jSONArray);
                                } else if (value instanceof double[]) {
                                    double[] dArr = (double[]) value;
                                    JSONArray jSONArray2 = new JSONArray();
                                    while (i2 < dArr.length) {
                                        jSONArray2.put(dArr[i2]);
                                        i2++;
                                    }
                                    jSONObject.put(strSubStr, jSONArray2);
                                } else if (value instanceof long[]) {
                                    long[] jArr = (long[]) value;
                                    JSONArray jSONArray3 = new JSONArray();
                                    while (i2 < jArr.length) {
                                        jSONArray3.put(jArr[i2]);
                                        i2++;
                                    }
                                    jSONObject.put(strSubStr, jSONArray3);
                                } else if (value instanceof float[]) {
                                    float[] fArr = (float[]) value;
                                    JSONArray jSONArray4 = new JSONArray();
                                    while (i2 < fArr.length) {
                                        jSONArray4.put(fArr[i2]);
                                        i2++;
                                    }
                                    jSONObject.put(strSubStr, jSONArray4);
                                } else if (value instanceof short[]) {
                                    short[] sArr = (short[]) value;
                                    JSONArray jSONArray5 = new JSONArray();
                                    while (i2 < sArr.length) {
                                        jSONArray5.put((int) sArr[i2]);
                                        i2++;
                                    }
                                    jSONObject.put(strSubStr, jSONArray5);
                                }
                            } else if (value instanceof List) {
                                List list = (List) value;
                                JSONArray jSONArray6 = new JSONArray();
                                while (i2 < list.size()) {
                                    Object obj = list.get(i2);
                                    if ((obj instanceof String) || (obj instanceof Long) || (obj instanceof Integer) || (obj instanceof Float) || (obj instanceof Double) || (obj instanceof Short)) {
                                        jSONArray6.put(list.get(i2));
                                    }
                                    i2++;
                                }
                                if (jSONArray6.length() > 0) {
                                    jSONObject.put(strSubStr, jSONArray6);
                                }
                            } else if (value instanceof String) {
                                jSONObject.put(strSubStr, HelperUtils.subStr(value.toString(), 256));
                            } else if (!(value instanceof Long) && !(value instanceof Integer) && !(value instanceof Float) && !(value instanceof Double) && !(value instanceof Short)) {
                                MLog.e("The param has not support type. please check !");
                            } else {
                                jSONObject.put(strSubStr, value);
                            }
                        }
                    }
                } catch (Exception e2) {
                    MLog.e(e2);
                }
            }
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private boolean a(String str) {
        if (str != null) {
            try {
                int length = str.trim().getBytes().length;
                if (length > 0 && length <= 128) {
                    return true;
                }
            } catch (Exception unused) {
            }
        }
        MLog.e("key is " + str + ", please check key, illegal");
        return false;
    }
}

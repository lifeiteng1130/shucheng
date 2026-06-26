package com.umeng.analytics.pro;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.camera.core.FocusMeteringAction;
import com.umeng.analytics.AnalyticsConfig;
import com.umeng.analytics.CoreProtocol;
import com.umeng.analytics.process.UMProcessDBHelper;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.framework.UMFrUtils;
import com.umeng.commonsdk.framework.UMLogDataProtocol;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.SdkVersion;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.statistics.common.HelperUtils;
import com.umeng.commonsdk.statistics.common.MLog;
import com.umeng.commonsdk.statistics.common.ReportPolicy;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import com.umeng.commonsdk.statistics.internal.StatTracer;
import com.umeng.commonsdk.statistics.noise.ABTest;
import com.umeng.commonsdk.statistics.noise.Defcon;
import com.umeng.commonsdk.utils.JSONArraySortUtil;
import com.umeng.commonsdk.utils.UMUtils;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: CoreProtocolImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class n {
    private static Context a = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final String f4914l = "first_activate_time";
    private static final String m = "ana_is_f";
    private static final String n = "thtstart";
    private static final String o = "dstk_last_time";
    private static final String p = "dstk_cnt";
    private static final String q = "gkvc";
    private static final String r = "ekvc";
    private static final String t = "-1";
    private static final String x = "com.umeng.umcrash.UMCrashUtils";
    private static Class<?> y;
    private static Method z;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private c f4915b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private SharedPreferences f4916c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f4917d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f4918e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f4919f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private JSONArray f4920g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f4921h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f4922i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f4923j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private long f4924k;
    private final long s;
    private boolean u;
    private boolean v;
    private Object w;

    /* JADX INFO: compiled from: CoreProtocolImpl.java */
    public static class a {
        public static final int A = 8211;
        public static final int B = 8212;
        public static final int C = 8213;
        public static final int a = 4097;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int f4925b = 4098;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final int f4926c = 4099;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final int f4927d = 4100;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final int f4928e = 4101;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final int f4929f = 4102;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final int f4930g = 4103;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final int f4931h = 4104;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final int f4932i = 4105;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final int f4933j = 4106;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static final int f4934k = 4352;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static final int f4935l = 4353;
        public static final int m = 4354;
        public static final int n = 4355;
        public static final int o = 4356;
        public static final int p = 8193;
        public static final int q = 8194;
        public static final int r = 8195;
        public static final int s = 8196;
        public static final int t = 8197;
        public static final int u = 8199;
        public static final int v = 8200;
        public static final int w = 8201;
        public static final int x = 8208;
        public static final int y = 8209;
        public static final int z = 8210;
    }

    /* JADX INFO: compiled from: CoreProtocolImpl.java */
    public static class b {
        private static final n a = new n();

        private b() {
        }
    }

    static {
        h();
    }

    public static n a(Context context) {
        if (a == null && context != null) {
            a = context.getApplicationContext();
        }
        return b.a;
    }

    private void b(JSONObject jSONObject) {
        JSONObject jSONObjectF;
        if (h.a(UMGlobalContext.getAppContext(a)).c() || (jSONObjectF = h.a(UMGlobalContext.getAppContext(a)).f()) == null) {
            return;
        }
        String strOptString = jSONObjectF.optString("__av");
        String strOptString2 = jSONObjectF.optString("__vc");
        try {
            if (TextUtils.isEmpty(strOptString)) {
                jSONObject.put("app_version", UMUtils.getAppVersionName(a));
            } else {
                jSONObject.put("app_version", strOptString);
            }
            if (TextUtils.isEmpty(strOptString2)) {
                jSONObject.put("version_code", UMUtils.getAppVersionCode(a));
            } else {
                jSONObject.put("version_code", strOptString2);
            }
        } catch (Throwable unused) {
        }
    }

    private void e(Object obj) {
        try {
            JSONObject jSONObject = (JSONObject) obj;
            if (2050 == jSONObject.getInt("__t")) {
                if (!a(this.f4924k, this.f4922i)) {
                    return;
                } else {
                    this.f4922i++;
                }
            } else if (2049 == jSONObject.getInt("__t")) {
                if (!a(this.f4924k, this.f4923j)) {
                    return;
                } else {
                    this.f4923j++;
                }
            }
            if (this.f4920g.length() >= this.f4919f) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>>*** 超过10个事件，事件落库。");
                h.a(a).a(this.f4920g);
                this.f4920g = new JSONArray();
            }
            if (this.f4924k == 0) {
                this.f4924k = System.currentTimeMillis();
            }
            this.f4920g.put(jSONObject);
        } catch (Throwable th) {
            MLog.e(th);
        }
    }

    private void f(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObjectOptJSONObject2;
        try {
            if (!jSONObject.getJSONObject("header").has(com.umeng.analytics.pro.c.aB)) {
                if (jSONObject.has("content")) {
                    jSONObject = jSONObject.getJSONObject("content");
                }
                if (jSONObject.has("analytics") && (jSONObjectOptJSONObject = jSONObject.optJSONObject("analytics")) != null && jSONObjectOptJSONObject.length() > 0 && jSONObjectOptJSONObject.has(com.umeng.analytics.pro.c.n)) {
                    h.a(a).a(true, false);
                }
                h.a(a).b();
                return;
            }
            if (jSONObject.has("content")) {
                jSONObject = jSONObject.getJSONObject("content");
            }
            if (jSONObject.has("analytics")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("analytics");
                if (jSONObject2.has(com.umeng.analytics.pro.c.n) && (jSONObjectOptJSONObject2 = jSONObject2.getJSONArray(com.umeng.analytics.pro.c.n).optJSONObject(0)) != null) {
                    String strOptString = jSONObjectOptJSONObject2.optString("id");
                    if (!TextUtils.isEmpty(strOptString)) {
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> removeAllInstantData: really delete instant session data");
                        h.a(a).b(strOptString);
                    }
                }
            }
            h.a(a).b();
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> removeAllInstantData: send INSTANT_SESSION_START_CONTINUE event because OVERSIZE.");
            Context context = a;
            UMWorkDispatch.sendEvent(context, a.f4935l, CoreProtocol.getInstance(context), null);
        } catch (Exception unused) {
        }
    }

    private static void h() {
        try {
            Class<?> cls = Class.forName(x);
            y = cls;
            Method declaredMethod = cls.getDeclaredMethod("setPuidAndProvider", String.class, String.class);
            if (declaredMethod != null) {
                z = declaredMethod;
            }
        } catch (Throwable unused) {
        }
    }

    private void i() {
        JSONObject jSONObjectB = b(UMEnvelopeBuild.maxDataSpace(a));
        if (jSONObjectB == null || jSONObjectB.length() < 1) {
            return;
        }
        JSONObject jSONObject = (JSONObject) jSONObjectB.opt("header");
        JSONObject jSONObject2 = (JSONObject) jSONObjectB.opt("content");
        if (a == null || jSONObject == null || jSONObject2 == null) {
            return;
        }
        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> constructInstantMessage: request build envelope.");
        JSONObject jSONObjectBuildEnvelopeWithExtHeader = UMEnvelopeBuild.buildEnvelopeWithExtHeader(a, jSONObject, jSONObject2);
        if (jSONObjectBuildEnvelopeWithExtHeader != null) {
            try {
                if (jSONObjectBuildEnvelopeWithExtHeader.has("exception")) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "Build envelope error code: " + jSONObjectBuildEnvelopeWithExtHeader.getInt("exception"));
                }
            } catch (Throwable unused) {
            }
            if (UMConfigure.isDebugLog()) {
                e(jSONObjectBuildEnvelopeWithExtHeader);
            }
            b((Object) jSONObjectBuildEnvelopeWithExtHeader);
        }
    }

    private void j() {
        JSONObject jSONObjectBuildEnvelopeWithExtHeader;
        JSONObject jSONObjectA = a(UMEnvelopeBuild.maxDataSpace(a));
        if (jSONObjectA == null || jSONObjectA.length() < 1) {
            return;
        }
        JSONObject jSONObject = (JSONObject) jSONObjectA.opt("header");
        JSONObject jSONObject2 = (JSONObject) jSONObjectA.opt("content");
        Context context = a;
        if (context == null || jSONObject == null || jSONObject2 == null || (jSONObjectBuildEnvelopeWithExtHeader = UMEnvelopeBuild.buildEnvelopeWithExtHeader(context, jSONObject, jSONObject2)) == null) {
            return;
        }
        try {
            if (jSONObjectBuildEnvelopeWithExtHeader.has("exception")) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "Build envelope error code: " + jSONObjectBuildEnvelopeWithExtHeader.getInt("exception"));
            }
        } catch (Throwable unused) {
        }
        if (UMConfigure.isDebugLog()) {
            d(jSONObjectBuildEnvelopeWithExtHeader);
        }
        a((Object) jSONObjectBuildEnvelopeWithExtHeader);
    }

    private JSONObject k() {
        JSONObject jSONObjectL = l();
        if (jSONObjectL != null) {
            try {
                jSONObjectL.put("st", SdkVersion.MINI_VERSION);
            } catch (Throwable unused) {
            }
        }
        return jSONObjectL;
    }

    private JSONObject l() {
        String str;
        JSONObject jSONObject = new JSONObject();
        try {
            if (AnalyticsConfig.mWrapperType != null && (str = AnalyticsConfig.mWrapperVersion) != null) {
                jSONObject.put("wrapper_version", str);
                jSONObject.put("wrapper_type", AnalyticsConfig.mWrapperType);
            }
            int verticalType = AnalyticsConfig.getVerticalType(a);
            jSONObject.put(com.umeng.analytics.pro.c.f4798i, verticalType);
            String str2 = "9.3.8";
            if (verticalType == 1) {
                String gameSdkVersion = AnalyticsConfig.getGameSdkVersion(a);
                if (!TextUtils.isEmpty(gameSdkVersion)) {
                    str2 = gameSdkVersion;
                }
                jSONObject.put("sdk_version", str2);
            } else {
                jSONObject.put("sdk_version", "9.3.8");
            }
            String strMD5 = HelperUtils.MD5(AnalyticsConfig.getSecretKey(a));
            if (!TextUtils.isEmpty(strMD5)) {
                jSONObject.put("secret", strMD5);
            }
            String strImprintProperty = UMEnvelopeBuild.imprintProperty(a, "pr_ve", null);
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(a);
            String strImprintProperty2 = UMEnvelopeBuild.imprintProperty(a, com.umeng.analytics.pro.c.an, "");
            if (!TextUtils.isEmpty(strImprintProperty2)) {
                if (AnalyticsConfig.CLEAR_EKV_BL) {
                    jSONObject.put(com.umeng.analytics.pro.c.ap, "");
                } else {
                    jSONObject.put(com.umeng.analytics.pro.c.ap, strImprintProperty2);
                }
            }
            String strImprintProperty3 = UMEnvelopeBuild.imprintProperty(a, com.umeng.analytics.pro.c.ao, "");
            if (!TextUtils.isEmpty(strImprintProperty3)) {
                if (AnalyticsConfig.CLEAR_EKV_WL) {
                    jSONObject.put(com.umeng.analytics.pro.c.aq, "");
                } else {
                    jSONObject.put(com.umeng.analytics.pro.c.aq, strImprintProperty3);
                }
            }
            jSONObject.put(com.umeng.analytics.pro.c.ah, "1.0.0");
            if (s()) {
                jSONObject.put(com.umeng.analytics.pro.c.aj, SdkVersion.MINI_VERSION);
                if (sharedPreferences != null) {
                    sharedPreferences.edit().putLong(m, 0L).commit();
                }
            }
            jSONObject.put(com.umeng.analytics.pro.c.f4801l, m());
            jSONObject.put(com.umeng.analytics.pro.c.m, n());
            if (sharedPreferences != null) {
                String string = sharedPreferences.getString("vers_name", "");
                if (!TextUtils.isEmpty(string)) {
                    String str3 = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date(System.currentTimeMillis()));
                    if (TextUtils.isEmpty(strImprintProperty)) {
                        jSONObject.put(com.umeng.analytics.pro.c.f4801l, sharedPreferences.getString("vers_pre_version", "0"));
                        jSONObject.put(com.umeng.analytics.pro.c.m, sharedPreferences.getString("vers_date", str3));
                    }
                    sharedPreferences.edit().putString("pre_version", string).putString("cur_version", DeviceConfig.getAppVersionName(a)).putString("pre_date", str3).remove("vers_name").remove("vers_code").remove("vers_date").remove("vers_pre_version").commit();
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return jSONObject;
    }

    private String m() {
        String strImprintProperty = null;
        try {
            strImprintProperty = UMEnvelopeBuild.imprintProperty(a, "pr_ve", null);
            if (TextUtils.isEmpty(strImprintProperty)) {
                if (!TextUtils.isEmpty(this.f4917d)) {
                    return this.f4917d;
                }
                if (this.f4916c == null) {
                    this.f4916c = PreferenceWrapper.getDefault(a);
                }
                String string = this.f4916c.getString("pre_version", "");
                String appVersionName = DeviceConfig.getAppVersionName(a);
                if (TextUtils.isEmpty(string)) {
                    this.f4916c.edit().putString("pre_version", "0").putString("cur_version", appVersionName).commit();
                    strImprintProperty = "0";
                } else {
                    String string2 = this.f4916c.getString("cur_version", "");
                    if (appVersionName.equals(string2)) {
                        strImprintProperty = string;
                    } else {
                        this.f4916c.edit().putString("pre_version", string2).putString("cur_version", appVersionName).commit();
                        strImprintProperty = string2;
                    }
                }
            }
        } catch (Throwable unused) {
        }
        this.f4917d = strImprintProperty;
        return strImprintProperty;
    }

    private String n() {
        String strImprintProperty = null;
        try {
            strImprintProperty = UMEnvelopeBuild.imprintProperty(a, "ud_da", null);
            if (TextUtils.isEmpty(strImprintProperty)) {
                if (!TextUtils.isEmpty(this.f4918e)) {
                    return this.f4918e;
                }
                if (this.f4916c == null) {
                    this.f4916c = PreferenceWrapper.getDefault(a);
                }
                String string = this.f4916c.getString("pre_date", "");
                if (TextUtils.isEmpty(string)) {
                    string = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date(System.currentTimeMillis()));
                    this.f4916c.edit().putString("pre_date", string).commit();
                } else {
                    String str = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date(System.currentTimeMillis()));
                    if (!string.equals(str)) {
                        this.f4916c.edit().putString("pre_date", str).commit();
                        strImprintProperty = str;
                    }
                }
                strImprintProperty = string;
            }
        } catch (Throwable unused) {
        }
        this.f4918e = strImprintProperty;
        return strImprintProperty;
    }

    private void o() {
        try {
            this.f4922i = 0;
            this.f4923j = 0;
            this.f4924k = System.currentTimeMillis();
            PreferenceWrapper.getDefault(a).edit().putLong(o, System.currentTimeMillis()).putInt(p, 0).commit();
        } catch (Throwable unused) {
        }
    }

    private boolean p() {
        try {
            if (!TextUtils.isEmpty(t.a().b())) {
                b(a);
            }
            if (this.f4920g.length() <= 0) {
                return false;
            }
            for (int i2 = 0; i2 < this.f4920g.length(); i2++) {
                JSONObject jSONObjectOptJSONObject = this.f4920g.optJSONObject(i2);
                if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.length() > 0) {
                    String strOptString = jSONObjectOptJSONObject.optString("__i");
                    if (TextUtils.isEmpty(strOptString) || t.equals(strOptString)) {
                        return false;
                    }
                }
            }
            return true;
        } catch (Throwable unused) {
            return true;
        }
    }

    private void q() {
        if (this.f4920g.length() > 0) {
            JSONArray jSONArray = new JSONArray();
            for (int i2 = 0; i2 < this.f4920g.length(); i2++) {
                try {
                    JSONObject jSONObject = this.f4920g.getJSONObject(i2);
                    if (jSONObject == null || jSONObject.length() <= 0) {
                        jSONArray.put(jSONObject);
                    } else {
                        String strOptString = jSONObject.optString("__i");
                        boolean zIsEmpty = TextUtils.isEmpty(strOptString);
                        String str = t;
                        if (zIsEmpty || t.equals(strOptString)) {
                            String strB = t.a().b();
                            if (!TextUtils.isEmpty(strB)) {
                                str = strB;
                            }
                            jSONObject.put("__i", str);
                        }
                        jSONArray.put(jSONObject);
                    }
                } catch (Throwable unused) {
                }
            }
            this.f4920g = jSONArray;
        }
    }

    private void r() {
        Context context;
        SharedPreferences sharedPreferences;
        try {
            if (!s() || (context = a) == null || (sharedPreferences = PreferenceWrapper.getDefault(context)) == null || sharedPreferences.getLong(f4914l, 0L) != 0) {
                return;
            }
            sharedPreferences.edit().putLong(f4914l, System.currentTimeMillis()).commit();
        } catch (Throwable unused) {
        }
    }

    private boolean s() {
        SharedPreferences sharedPreferences;
        try {
            Context context = a;
            if (context == null || (sharedPreferences = PreferenceWrapper.getDefault(context)) == null) {
                return false;
            }
            return sharedPreferences.getLong(m, -1L) != 0;
        } catch (Throwable unused) {
            return false;
        }
    }

    public void b() {
    }

    public void c() {
        b(a);
        d();
        a(true);
    }

    public void d() {
        try {
            if (this.f4920g.length() > 0) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>>*** flushMemoryData: 事件落库。");
                h.a(a).a(this.f4920g);
                this.f4920g = new JSONArray();
            }
            PreferenceWrapper.getDefault(a).edit().putLong(n, this.f4924k).putInt(q, this.f4922i).putInt(r, this.f4923j).commit();
        } catch (Throwable unused) {
        }
    }

    private n() {
        this.f4915b = null;
        this.f4916c = null;
        this.f4917d = null;
        this.f4918e = null;
        this.f4919f = 10;
        this.f4920g = new JSONArray();
        this.f4921h = 5000;
        this.f4922i = 0;
        this.f4923j = 0;
        this.f4924k = 0L;
        this.s = 28800000L;
        this.u = false;
        this.v = false;
        this.w = new Object();
        try {
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(a);
            this.f4924k = sharedPreferences.getLong(n, 0L);
            this.f4922i = sharedPreferences.getInt(q, 0);
            this.f4923j = sharedPreferences.getInt(r, 0);
            this.f4915b = new c();
        } catch (Throwable unused) {
        }
    }

    private void g(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        try {
            if (jSONObject.getJSONObject("header").has(com.umeng.analytics.pro.c.aB)) {
                if (jSONObject.has("content")) {
                    jSONObject = jSONObject.getJSONObject("content");
                }
                if (jSONObject.has("analytics")) {
                    if (!jSONObject.getJSONObject("analytics").has(com.umeng.analytics.pro.c.n)) {
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> Error, Should not go to this branch.");
                        return;
                    }
                    h.a(a).i();
                    h.a(a).h();
                    h.a(a).b(true, false);
                    h.a(a).a();
                    return;
                }
                return;
            }
            if (jSONObject.has("content")) {
                jSONObject = jSONObject.getJSONObject("content");
            }
            if (jSONObject.has("analytics") && (jSONObjectOptJSONObject = jSONObject.optJSONObject("analytics")) != null && jSONObjectOptJSONObject.length() > 0) {
                if (jSONObjectOptJSONObject.has(com.umeng.analytics.pro.c.n)) {
                    h.a(a).b(true, false);
                }
                if (jSONObjectOptJSONObject.has("ekv") || jSONObjectOptJSONObject.has(com.umeng.analytics.pro.c.T)) {
                    h.a(a).h();
                }
                if (jSONObjectOptJSONObject.has(com.umeng.analytics.pro.c.O)) {
                    h.a(a).i();
                }
            }
            h.a(a).a();
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: compiled from: CoreProtocolImpl.java */
    public static class c {
        private ReportPolicy.ReportStrategy a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f4936b = -1;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f4937c = -1;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f4938d = -1;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f4939e = -1;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private ABTest f4940f;

        public c() {
            this.f4940f = null;
            this.f4940f = ABTest.getService(n.a);
        }

        public void a() {
            try {
                int[] iArrA = a(-1, -1);
                this.f4936b = iArrA[0];
                this.f4937c = iArrA[1];
            } catch (Throwable unused) {
            }
        }

        public void b() {
            int iA;
            Defcon service = Defcon.getService(n.a);
            if (service.isOpen()) {
                ReportPolicy.ReportStrategy reportStrategy = this.a;
                this.a = (reportStrategy instanceof ReportPolicy.DefconPolicy) && reportStrategy.isValid() ? this.a : new ReportPolicy.DefconPolicy(StatTracer.getInstance(n.a), service);
            } else {
                boolean z = Integer.valueOf(UMEnvelopeBuild.imprintProperty(n.a, "integrated_test", n.t)).intValue() == 1;
                if (UMConfigure.isDebugLog() && z && !MLog.DEBUG) {
                    UMLog.mutlInfo(i.K, 3, "\\|", null, null);
                }
                if (MLog.DEBUG && z) {
                    this.a = new ReportPolicy.DebugPolicy(StatTracer.getInstance(n.a));
                } else if (this.f4940f.isInTest() && "RPT".equals(this.f4940f.getTestName())) {
                    if (this.f4940f.getTestPolicy() == 6) {
                        if (Integer.valueOf(UMEnvelopeBuild.imprintProperty(n.a, "test_report_interval", n.t)).intValue() != -1) {
                            iA = a(90000);
                        } else {
                            iA = this.f4937c;
                            if (iA <= 0) {
                                iA = this.f4939e;
                            }
                        }
                    } else {
                        iA = 0;
                    }
                    this.a = b(this.f4940f.getTestPolicy(), iA);
                } else {
                    int i2 = this.f4938d;
                    int i3 = this.f4939e;
                    int i4 = this.f4936b;
                    if (i4 != -1) {
                        i3 = this.f4937c;
                        i2 = i4;
                    }
                    this.a = b(i2, i3);
                }
            }
            if (UMConfigure.isDebugLog()) {
                try {
                    ReportPolicy.ReportStrategy reportStrategy2 = this.a;
                    if (reportStrategy2 instanceof ReportPolicy.ReportAtLaunch) {
                        UMLog.mutlInfo(i.I, 3, "", null, null);
                    } else if (reportStrategy2 instanceof ReportPolicy.ReportByInterval) {
                        UMLog.mutlInfo(i.J, 3, "", new String[]{"@"}, new String[]{String.valueOf(((ReportPolicy.ReportByInterval) reportStrategy2).getReportInterval() / 1000)});
                    } else if (reportStrategy2 instanceof ReportPolicy.DebugPolicy) {
                        UMLog.mutlInfo(i.L, 3, "", null, null);
                    } else if (reportStrategy2 instanceof ReportPolicy.ReportQuasiRealtime) {
                        String[] strArr = {String.valueOf(((ReportPolicy.ReportQuasiRealtime) reportStrategy2).getReportInterval() / 1000)};
                        UMLog uMLog = UMConfigure.umDebugLog;
                        UMLog.mutlInfo(i.M, 3, "", new String[]{"@"}, strArr);
                    } else {
                        boolean z2 = reportStrategy2 instanceof ReportPolicy.DefconPolicy;
                    }
                } catch (Throwable unused) {
                }
            }
        }

        public ReportPolicy.ReportStrategy c() {
            b();
            return this.a;
        }

        public int[] a(int i2, int i3) {
            int iIntValue = Integer.valueOf(UMEnvelopeBuild.imprintProperty(n.a, "report_policy", n.t)).intValue();
            int iIntValue2 = Integer.valueOf(UMEnvelopeBuild.imprintProperty(n.a, "report_interval", n.t)).intValue();
            if (iIntValue == -1 || !ReportPolicy.isValid(iIntValue)) {
                return new int[]{i2, i3};
            }
            if (6 == iIntValue) {
                if (iIntValue2 == -1 || iIntValue2 < 90 || iIntValue2 > 86400) {
                    iIntValue2 = 90;
                }
                return new int[]{iIntValue, iIntValue2 * 1000};
            }
            if (11 != iIntValue) {
                return new int[]{i2, i3};
            }
            if (iIntValue2 == -1 || iIntValue2 < 15 || iIntValue2 > 3600) {
                iIntValue2 = 15;
            }
            return new int[]{iIntValue, iIntValue2 * 1000};
        }

        public int a(int i2) {
            int iIntValue = Integer.valueOf(UMEnvelopeBuild.imprintProperty(n.a, "test_report_interval", n.t)).intValue();
            return (iIntValue == -1 || iIntValue < 90 || iIntValue > 86400) ? i2 : iIntValue * 1000;
        }

        private ReportPolicy.ReportStrategy b(int i2, int i3) {
            if (i2 == 0) {
                ReportPolicy.ReportStrategy reportStrategy = this.a;
                return reportStrategy instanceof ReportPolicy.ReportRealtime ? reportStrategy : new ReportPolicy.ReportRealtime();
            }
            if (i2 == 1) {
                ReportPolicy.ReportStrategy reportStrategy2 = this.a;
                return reportStrategy2 instanceof ReportPolicy.ReportAtLaunch ? reportStrategy2 : new ReportPolicy.ReportAtLaunch();
            }
            if (i2 == 4) {
                ReportPolicy.ReportStrategy reportStrategy3 = this.a;
                return reportStrategy3 instanceof ReportPolicy.ReportDaily ? reportStrategy3 : new ReportPolicy.ReportDaily(StatTracer.getInstance(n.a));
            }
            if (i2 == 5) {
                ReportPolicy.ReportStrategy reportStrategy4 = this.a;
                return reportStrategy4 instanceof ReportPolicy.ReportWifiOnly ? reportStrategy4 : new ReportPolicy.ReportWifiOnly(n.a);
            }
            if (i2 == 6) {
                ReportPolicy.ReportStrategy reportStrategy5 = this.a;
                if (reportStrategy5 instanceof ReportPolicy.ReportByInterval) {
                    ((ReportPolicy.ReportByInterval) reportStrategy5).setReportInterval(i3);
                    return reportStrategy5;
                }
                return new ReportPolicy.ReportByInterval(StatTracer.getInstance(n.a), i3);
            }
            if (i2 == 8) {
                ReportPolicy.ReportStrategy reportStrategy6 = this.a;
                return reportStrategy6 instanceof ReportPolicy.SmartPolicy ? reportStrategy6 : new ReportPolicy.SmartPolicy(StatTracer.getInstance(n.a));
            }
            if (i2 != 11) {
                ReportPolicy.ReportStrategy reportStrategy7 = this.a;
                return reportStrategy7 instanceof ReportPolicy.ReportAtLaunch ? reportStrategy7 : new ReportPolicy.ReportAtLaunch();
            }
            ReportPolicy.ReportStrategy reportStrategy8 = this.a;
            if (reportStrategy8 instanceof ReportPolicy.ReportQuasiRealtime) {
                ((ReportPolicy.ReportQuasiRealtime) reportStrategy8).setReportInterval(i3);
                return reportStrategy8;
            }
            ReportPolicy.ReportQuasiRealtime reportQuasiRealtime = new ReportPolicy.ReportQuasiRealtime();
            reportQuasiRealtime.setReportInterval(i3);
            return reportQuasiRealtime;
        }
    }

    private void c(JSONObject jSONObject) {
        try {
            if (!h.a(a).e()) {
                JSONObject jSONObjectG = h.a(a).g();
                if (jSONObjectG != null) {
                    String strOptString = jSONObjectG.optString("__av");
                    String strOptString2 = jSONObjectG.optString("__vc");
                    if (TextUtils.isEmpty(strOptString)) {
                        jSONObject.put("app_version", UMUtils.getAppVersionName(a));
                    } else {
                        jSONObject.put("app_version", strOptString);
                    }
                    if (TextUtils.isEmpty(strOptString2)) {
                        jSONObject.put("version_code", UMUtils.getAppVersionCode(a));
                        return;
                    } else {
                        jSONObject.put("version_code", strOptString2);
                        return;
                    }
                }
                return;
            }
            jSONObject.put("app_version", UMUtils.getAppVersionName(a));
            jSONObject.put("version_code", UMUtils.getAppVersionCode(a));
        } catch (Throwable unused) {
        }
    }

    public void a() {
        if (a != null) {
            synchronized (this.w) {
                if (this.u) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> network is now available, rebuild instant session data packet.");
                    Context context = a;
                    UMWorkDispatch.sendEvent(context, a.f4935l, CoreProtocol.getInstance(context), null);
                }
            }
            synchronized (this.w) {
                if (this.v) {
                    Context context2 = a;
                    UMWorkDispatch.sendEvent(context2, a.m, CoreProtocol.getInstance(context2), null);
                }
            }
        }
    }

    /* JADX INFO: compiled from: CoreProtocolImpl.java */
    public static class d {
        private Map<String, Object> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f4941b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f4942c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private long f4943d;

        private d() {
            this.a = null;
            this.f4941b = null;
            this.f4942c = null;
            this.f4943d = 0L;
        }

        public Map<String, Object> a() {
            return this.a;
        }

        public String b() {
            return this.f4942c;
        }

        public String c() {
            return this.f4941b;
        }

        public long d() {
            return this.f4943d;
        }

        public d(String str, Map<String, Object> map, String str2, long j2) {
            this.a = null;
            this.f4941b = null;
            this.f4942c = null;
            this.f4943d = 0L;
            this.a = map;
            this.f4941b = str;
            this.f4943d = j2;
            this.f4942c = str2;
        }
    }

    private void h(Object obj) {
        try {
            JSONObject jSONObject = (JSONObject) obj;
            if (jSONObject == null || jSONObject.length() <= 0 || !jSONObject.has("__ii")) {
                return;
            }
            String strOptString = jSONObject.optString("__ii");
            jSONObject.remove("__ii");
            if (TextUtils.isEmpty(strOptString)) {
                return;
            }
            h.a(a).a(strOptString, obj.toString(), 2);
        } catch (Throwable unused) {
        }
    }

    private void d(JSONObject jSONObject) {
        String str;
        JSONObject jSONObject2;
        if (jSONObject == null) {
            return;
        }
        try {
            if (jSONObject.length() <= 0) {
                return;
            }
            JSONObject jSONObject3 = new JSONObject();
            if (jSONObject.has("analytics")) {
                JSONObject jSONObject4 = jSONObject.getJSONObject("analytics");
                if (jSONObject4.has("ekv")) {
                    str = "version_code";
                    jSONObject3.put("ekv", jSONObject4.getJSONArray("ekv"));
                    if (jSONObject3.length() > 0) {
                        MLog.d("事件:" + jSONObject3.toString());
                        jSONObject3 = new JSONObject();
                    }
                } else {
                    str = "version_code";
                }
                if (jSONObject4.has(com.umeng.analytics.pro.c.T)) {
                    jSONObject3.put(com.umeng.analytics.pro.c.T, jSONObject4.getJSONArray(com.umeng.analytics.pro.c.T));
                    if (jSONObject3.length() > 0) {
                        MLog.d("游戏事件:" + jSONObject3.toString());
                        jSONObject3 = new JSONObject();
                    }
                }
                if (jSONObject4.has(com.umeng.analytics.pro.c.O)) {
                    jSONObject3.put(com.umeng.analytics.pro.c.O, jSONObject4.getJSONArray(com.umeng.analytics.pro.c.O));
                    if (jSONObject3.length() > 0) {
                        MLog.d("错误:" + jSONObject3.toString());
                        jSONObject3 = new JSONObject();
                    }
                }
                if (jSONObject4.has(com.umeng.analytics.pro.c.n)) {
                    JSONArray jSONArray = jSONObject4.getJSONArray(com.umeng.analytics.pro.c.n);
                    JSONArray jSONArray2 = new JSONArray();
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        JSONObject jSONObject5 = jSONArray.getJSONObject(i2);
                        if (jSONObject5 != null && jSONObject5.length() > 0) {
                            if (jSONObject5.has(com.umeng.analytics.pro.c.u)) {
                                jSONObject5.remove(com.umeng.analytics.pro.c.u);
                            }
                            jSONArray2.put(jSONObject5);
                        }
                    }
                    jSONObject3.put(com.umeng.analytics.pro.c.n, jSONArray2);
                    if (jSONObject3.length() > 0) {
                        MLog.d("会话:" + jSONObject3.toString());
                        jSONObject3 = new JSONObject();
                    }
                }
                if (jSONObject4.has(com.umeng.analytics.pro.c.I)) {
                    jSONObject3.put(com.umeng.analytics.pro.c.I, jSONObject4.getJSONObject(com.umeng.analytics.pro.c.I));
                }
                if (jSONObject4.has(com.umeng.analytics.pro.c.L)) {
                    jSONObject3.put(com.umeng.analytics.pro.c.L, jSONObject4.getJSONObject(com.umeng.analytics.pro.c.L));
                    if (jSONObject3.length() > 0) {
                        MLog.d("账号:" + jSONObject3.toString());
                        jSONObject3 = new JSONObject();
                    }
                }
            } else {
                str = "version_code";
            }
            if (jSONObject.has("dplus")) {
                jSONObject3.put("dplus", jSONObject.getJSONObject("dplus"));
            }
            if (jSONObject.has("header") && jSONObject.has("header") && (jSONObject2 = jSONObject.getJSONObject("header")) != null && jSONObject2.length() > 0) {
                if (jSONObject2.has("sdk_version")) {
                    jSONObject3.put("sdk_version", jSONObject2.getString("sdk_version"));
                }
                if (jSONObject2.has("device_id")) {
                    jSONObject3.put("device_id", jSONObject2.getString("device_id"));
                }
                if (jSONObject2.has("device_model")) {
                    jSONObject3.put("device_model", jSONObject2.getString("device_model"));
                }
                String str2 = str;
                if (jSONObject2.has(str2)) {
                    jSONObject3.put("version", jSONObject2.getInt(str2));
                }
                if (jSONObject2.has("appkey")) {
                    jSONObject3.put("appkey", jSONObject2.getString("appkey"));
                }
                if (jSONObject2.has("channel")) {
                    jSONObject3.put("channel", jSONObject2.getString("channel"));
                }
                if (jSONObject3.length() > 0) {
                    MLog.d("基础信息:" + jSONObject3.toString());
                    jSONObject3 = new JSONObject();
                }
            }
            jSONObject3.length();
        } catch (Throwable th) {
            MLog.e(th);
        }
    }

    public JSONObject b(long j2) {
        if (TextUtils.isEmpty(x.a().d(UMGlobalContext.getAppContext(a)))) {
            return null;
        }
        JSONObject jSONObjectB = h.a(UMGlobalContext.getAppContext(a)).b(false);
        String[] strArrA = com.umeng.analytics.c.a(a);
        if (strArrA != null && !TextUtils.isEmpty(strArrA[0]) && !TextUtils.isEmpty(strArrA[1])) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(com.umeng.analytics.pro.c.M, strArrA[0]);
                jSONObject.put(com.umeng.analytics.pro.c.N, strArrA[1]);
                if (jSONObject.length() > 0) {
                    jSONObjectB.put(com.umeng.analytics.pro.c.L, jSONObject);
                }
            } catch (Throwable unused) {
            }
        }
        int iA = q.a().a(a);
        if (jSONObjectB.length() == 1 && jSONObjectB.optJSONObject(com.umeng.analytics.pro.c.L) != null && iA != 3) {
            return null;
        }
        q.a().b(jSONObjectB, a);
        if (jSONObjectB.length() <= 0 && iA != 3) {
            return null;
        }
        JSONObject jSONObjectK = k();
        if (jSONObjectK != null) {
            b(jSONObjectK);
        }
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            if (iA == 3) {
                jSONObject3.put("analytics", new JSONObject());
            } else if (jSONObjectB.length() > 0) {
                jSONObject3.put("analytics", jSONObjectB);
            }
            if (jSONObjectK != null && jSONObjectK.length() > 0) {
                jSONObject2.put("header", jSONObjectK);
            }
            if (jSONObject3.length() > 0) {
                jSONObject2.put("content", jSONObject3);
            }
            return b(jSONObject2, j2);
        } catch (Throwable unused2) {
            return jSONObject2;
        }
    }

    private boolean c(boolean z2) {
        if (s()) {
            return true;
        }
        if (this.f4915b == null) {
            this.f4915b = new c();
        }
        this.f4915b.a();
        ReportPolicy.ReportStrategy reportStrategyC = this.f4915b.c();
        boolean zShouldSendMessage = reportStrategyC.shouldSendMessage(z2);
        if (zShouldSendMessage) {
            if (((reportStrategyC instanceof ReportPolicy.ReportByInterval) || (reportStrategyC instanceof ReportPolicy.DebugPolicy) || (reportStrategyC instanceof ReportPolicy.ReportQuasiRealtime)) && p()) {
                d();
            }
            if ((reportStrategyC instanceof ReportPolicy.DefconPolicy) && p()) {
                d();
            }
            if (UMConfigure.isDebugLog()) {
                StringBuilder sbR = c.a.a.a.a.r("数据发送策略 : ");
                sbR.append(reportStrategyC.getClass().getSimpleName());
                MLog.d(sbR.toString());
            }
        }
        return zShouldSendMessage;
    }

    private void e(JSONObject jSONObject) {
        JSONObject jSONObject2;
        if (jSONObject == null) {
            return;
        }
        try {
            if (jSONObject.length() <= 0) {
                return;
            }
            JSONObject jSONObject3 = new JSONObject();
            if (jSONObject.has("analytics")) {
                JSONObject jSONObject4 = jSONObject.getJSONObject("analytics");
                if (jSONObject4.has(com.umeng.analytics.pro.c.n)) {
                    JSONArray jSONArray = jSONObject4.getJSONArray(com.umeng.analytics.pro.c.n);
                    JSONArray jSONArray2 = new JSONArray();
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        JSONObject jSONObject5 = jSONArray.getJSONObject(i2);
                        if (jSONObject5 != null && jSONObject5.length() > 0) {
                            jSONArray2.put(jSONObject5);
                        }
                    }
                    jSONObject3.put(com.umeng.analytics.pro.c.n, jSONArray2);
                    if (jSONObject3.length() > 0) {
                        MLog.d("本次启动会话:" + jSONObject3.toString());
                        jSONObject3 = new JSONObject();
                    }
                }
                if (jSONObject4.has(com.umeng.analytics.pro.c.L)) {
                    jSONObject3.put(com.umeng.analytics.pro.c.L, jSONObject4.getJSONObject(com.umeng.analytics.pro.c.L));
                    if (jSONObject3.length() > 0) {
                        MLog.d("本次启动账号:" + jSONObject3.toString());
                        jSONObject3 = new JSONObject();
                    }
                }
            }
            if (jSONObject.has("header") && jSONObject.has("header") && (jSONObject2 = jSONObject.getJSONObject("header")) != null && jSONObject2.length() > 0) {
                if (jSONObject2.has("sdk_version")) {
                    jSONObject3.put("sdk_version", jSONObject2.getString("sdk_version"));
                }
                if (jSONObject2.has("device_id")) {
                    jSONObject3.put("device_id", jSONObject2.getString("device_id"));
                }
                if (jSONObject2.has("device_model")) {
                    jSONObject3.put("device_model", jSONObject2.getString("device_model"));
                }
                if (jSONObject2.has("version_code")) {
                    jSONObject3.put("version", jSONObject2.getInt("version_code"));
                }
                if (jSONObject2.has("appkey")) {
                    jSONObject3.put("appkey", jSONObject2.getString("appkey"));
                }
                if (jSONObject2.has("channel")) {
                    jSONObject3.put("channel", jSONObject2.getString("channel"));
                }
                if (jSONObject3.length() > 0) {
                    MLog.d("本次启动基础信息:" + jSONObject3.toString());
                    jSONObject3 = new JSONObject();
                }
            }
            jSONObject3.length();
        } catch (Throwable th) {
            MLog.e(th);
        }
    }

    private void a(String str, String str2) {
        Method method;
        Class<?> cls = y;
        if (cls == null || (method = z) == null) {
            return;
        }
        try {
            method.invoke(cls, str, str2);
        } catch (Throwable unused) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> reflect call setPuidAndProvider method of crash lib failed.");
        }
    }

    public void a(Object obj, int i2) {
        if (AnalyticsConfig.enable) {
            if (i2 != 8213) {
                try {
                    switch (i2) {
                        case 4097:
                            if (UMUtils.isMainProgress(a)) {
                                if (obj != null) {
                                    e(obj);
                                }
                                if (t.equals(((JSONObject) obj).optString("__i"))) {
                                    return;
                                }
                                a(false);
                                return;
                            }
                            UMProcessDBHelper.getInstance(a).insertEventsInSubProcess(UMFrUtils.getSubProcessName(a), new JSONArray().put(obj));
                            return;
                        case 4098:
                            if (obj != null) {
                                e(obj);
                            }
                            if (t.equals(((JSONObject) obj).optString("__i"))) {
                                return;
                            }
                            a(false);
                            return;
                        case 4099:
                            u.a(a);
                            return;
                        case a.f4927d /* 4100 */:
                            k.c(a);
                            return;
                        case a.f4928e /* 4101 */:
                            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> PROFILE_SIGNIN");
                            a((Object) null, true);
                            g(obj);
                            return;
                        case a.f4929f /* 4102 */:
                            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> PROFILE_SIGNOFF");
                            a((Object) null, true);
                            f(obj);
                            return;
                        case a.f4930g /* 4103 */:
                            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> START_SESSION");
                            t.a().a(a, obj);
                            synchronized (this.w) {
                                this.v = true;
                                break;
                            }
                            return;
                        case a.f4931h /* 4104 */:
                            t.a().c(a, obj);
                            return;
                        case a.f4932i /* 4105 */:
                            d();
                            return;
                        case a.f4933j /* 4106 */:
                            h(obj);
                            return;
                        default:
                            switch (i2) {
                                case 4352:
                                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> INSTANT_SESSION_START");
                                    t.a().b(a, obj);
                                    synchronized (this.w) {
                                        this.u = true;
                                        break;
                                    }
                                    return;
                                case a.f4935l /* 4353 */:
                                    a(obj, true);
                                    return;
                                case a.m /* 4354 */:
                                    c();
                                    return;
                                case a.n /* 4355 */:
                                    if (!UMUtils.isMainProgress(a)) {
                                        UMProcessDBHelper.getInstance(a).insertEventsInSubProcess(UMFrUtils.getSubProcessName(a), new JSONArray().put(obj));
                                        return;
                                    } else {
                                        if (obj != null) {
                                            e(obj);
                                            d();
                                            return;
                                        }
                                        return;
                                    }
                                case a.o /* 4356 */:
                                    if (obj == null || y == null || z == null) {
                                        return;
                                    }
                                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> PROFILE_CHANGE_NOTIFY");
                                    String string = "";
                                    String string2 = "";
                                    if (obj instanceof JSONObject) {
                                        JSONObject jSONObject = (JSONObject) obj;
                                        if (jSONObject.has("uid") && jSONObject.has(com.umeng.analytics.pro.c.M)) {
                                            string = jSONObject.getString(com.umeng.analytics.pro.c.M);
                                            string2 = jSONObject.getString("uid");
                                        }
                                        a(string2, string);
                                        return;
                                    }
                                    return;
                                default:
                                    switch (i2) {
                                        case a.r /* 8195 */:
                                            com.umeng.analytics.b.a().a(obj);
                                            return;
                                        case a.s /* 8196 */:
                                            com.umeng.analytics.b.a().m();
                                            return;
                                        case a.t /* 8197 */:
                                            com.umeng.analytics.b.a().k();
                                            return;
                                        default:
                                            switch (i2) {
                                                case a.u /* 8199 */:
                                                case a.v /* 8200 */:
                                                    com.umeng.analytics.b.a().b(obj);
                                                    return;
                                                case a.w /* 8201 */:
                                                    com.umeng.analytics.b.a().b((Object) null);
                                                    return;
                                                default:
                                                    switch (i2) {
                                                        case a.x /* 8208 */:
                                                            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> receive DELAY_BUILD_ENVELOPE event.");
                                                            Context context = a;
                                                            UMWorkDispatch.sendEvent(context, a.y, CoreProtocol.getInstance(context), null);
                                                            Context context2 = a;
                                                            UMWorkDispatch.sendEvent(context2, a.m, CoreProtocol.getInstance(context2), null);
                                                            return;
                                                        case a.y /* 8209 */:
                                                            a(obj, false);
                                                            return;
                                                        case a.z /* 8210 */:
                                                            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> recv BUILD_ENVELOPE_IMMEDIATELY.");
                                                            if (!UMUtils.isMainProgress(a) || (this.f4915b.c() instanceof ReportPolicy.ReportQuasiRealtime)) {
                                                                return;
                                                            }
                                                            a(true);
                                                            return;
                                                        default:
                                                            return;
                                                    }
                                            }
                                    }
                            }
                    }
                } catch (Throwable unused) {
                    return;
                }
            }
            if (FieldManager.allow(com.umeng.commonsdk.utils.b.E)) {
                if (DeviceConfig.getGlobleActivity(a) != null) {
                    t.b(a);
                }
                Context context3 = a;
                UMWorkDispatch.sendEventEx(context3, a.C, CoreProtocol.getInstance(context3), null, FocusMeteringAction.DEFAULT_AUTOCANCEL_DURATION);
            }
        }
    }

    private void g(Object obj) {
        try {
            b(a);
            d();
            JSONObject jSONObject = (JSONObject) obj;
            if (jSONObject != null && jSONObject.length() > 0) {
                String string = jSONObject.getString(com.umeng.analytics.pro.c.M);
                String string2 = jSONObject.getString("uid");
                long j2 = jSONObject.getLong("ts");
                String[] strArrA = com.umeng.analytics.c.a(a);
                if (strArrA != null && string.equals(strArrA[0]) && string2.equals(strArrA[1])) {
                    return;
                }
                t.a().a(a, j2);
                String strC = x.a().c(a);
                boolean zB = t.a().b(a, j2, false);
                com.umeng.analytics.c.a(a, string, string2);
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> onProfileSignIn: force generate new session: session id = " + strC);
                t.a().a(a, j2, true);
                if (zB) {
                    t.a().b(a, j2);
                }
            }
        } catch (Throwable unused) {
        }
    }

    public long f() {
        SharedPreferences sharedPreferences;
        long jCurrentTimeMillis = 0;
        try {
            Context context = a;
            if (context == null || (sharedPreferences = PreferenceWrapper.getDefault(context)) == null) {
                return 0L;
            }
            long j2 = sharedPreferences.getLong(f4914l, 0L);
            if (j2 == 0) {
                try {
                    jCurrentTimeMillis = System.currentTimeMillis();
                    sharedPreferences.edit().putLong(f4914l, jCurrentTimeMillis).commit();
                    return jCurrentTimeMillis;
                } catch (Throwable unused) {
                }
            }
            return j2;
        } catch (Throwable unused2) {
            return jCurrentTimeMillis;
        }
    }

    public void c(Object obj) {
        b(a);
        d();
        if (d(false)) {
            j();
        }
    }

    private void f(Object obj) {
        try {
            JSONObject jSONObject = (JSONObject) obj;
            if (jSONObject != null && jSONObject.length() > 0) {
                long j2 = jSONObject.getLong("ts");
                b(a);
                d();
                String[] strArrA = com.umeng.analytics.c.a(a);
                if (strArrA == null || TextUtils.isEmpty(strArrA[0]) || TextUtils.isEmpty(strArrA[1])) {
                    return;
                }
                t.a().a(a, j2);
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> onProfileSignIn: force generate new session: session id = " + x.a().c(a));
                boolean zB = t.a().b(a, j2, false);
                com.umeng.analytics.c.b(a);
                t.a().a(a, j2, true);
                if (zB) {
                    t.a().b(a, j2);
                }
            }
        } catch (Throwable th) {
            if (MLog.DEBUG) {
                MLog.e(" Excepthon  in  onProfileSignOff", th);
            }
        }
    }

    private JSONObject b(JSONObject jSONObject, long j2) {
        try {
            if (p.a(jSONObject) <= j2) {
                return jSONObject;
            }
            jSONObject = null;
            h.a(a).a(true, false);
            h.a(a).b();
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> Instant session packet overload !!! ");
            return null;
        } catch (Throwable unused) {
            return jSONObject;
        }
    }

    public JSONObject b(boolean z2) {
        JSONArray jSONArray;
        JSONArray jSONArray2;
        JSONObject jSONObjectA = null;
        try {
            jSONObjectA = h.a(a).a(z2);
            if (jSONObjectA == null) {
                jSONObjectA = new JSONObject();
            } else {
                try {
                    boolean zHas = jSONObjectA.has(com.umeng.analytics.pro.c.n);
                    jSONObjectA = jSONObjectA;
                    if (zHas) {
                        JSONArray jSONArray3 = jSONObjectA.getJSONArray(com.umeng.analytics.pro.c.n);
                        JSONArray jSONArray4 = new JSONArray();
                        int i2 = 0;
                        while (i2 < jSONArray3.length()) {
                            JSONObject jSONObject = (JSONObject) jSONArray3.get(i2);
                            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(com.umeng.analytics.pro.c.t);
                            JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray(com.umeng.analytics.pro.c.u);
                            if (jSONArrayOptJSONArray == null && jSONArrayOptJSONArray2 != null) {
                                jSONObject.put(com.umeng.analytics.pro.c.t, jSONArrayOptJSONArray2);
                                jSONObject.remove(com.umeng.analytics.pro.c.u);
                            }
                            if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray2 != null) {
                                ArrayList arrayList = new ArrayList();
                                for (int i3 = 0; i3 < jSONArrayOptJSONArray.length(); i3++) {
                                    arrayList.add((JSONObject) jSONArrayOptJSONArray.get(i3));
                                }
                                for (int i4 = 0; i4 < jSONArrayOptJSONArray2.length(); i4++) {
                                    arrayList.add((JSONObject) jSONArrayOptJSONArray2.get(i4));
                                }
                                JSONArraySortUtil jSONArraySortUtil = new JSONArraySortUtil();
                                jSONArraySortUtil.setCompareKey(com.umeng.analytics.pro.c.x);
                                Collections.sort(arrayList, jSONArraySortUtil);
                                JSONArray jSONArray5 = new JSONArray();
                                Iterator it = arrayList.iterator();
                                while (it.hasNext()) {
                                    jSONArray5.put((JSONObject) it.next());
                                }
                                jSONObject.put(com.umeng.analytics.pro.c.t, jSONArray5);
                                jSONObject.remove(com.umeng.analytics.pro.c.u);
                            }
                            if (jSONObject.has(com.umeng.analytics.pro.c.t)) {
                                JSONArray jSONArrayOptJSONArray3 = jSONObject.optJSONArray(com.umeng.analytics.pro.c.t);
                                int i5 = 0;
                                while (i5 < jSONArrayOptJSONArray3.length()) {
                                    JSONObject jSONObject2 = jSONArrayOptJSONArray3.getJSONObject(i5);
                                    if (jSONObject2.has(com.umeng.analytics.pro.c.x)) {
                                        jSONArray2 = jSONArray3;
                                        jSONObject2.put("ts", jSONObject2.getLong(com.umeng.analytics.pro.c.x));
                                        jSONObject2.remove(com.umeng.analytics.pro.c.x);
                                    } else {
                                        jSONArray2 = jSONArray3;
                                    }
                                    i5++;
                                    jSONArray3 = jSONArray2;
                                }
                                jSONArray = jSONArray3;
                                jSONObject.put(com.umeng.analytics.pro.c.t, jSONArrayOptJSONArray3);
                                jSONObject.put(com.umeng.analytics.pro.c.z, jSONArrayOptJSONArray3.length());
                            } else {
                                jSONArray = jSONArray3;
                                jSONObject.put(com.umeng.analytics.pro.c.z, 0);
                            }
                            jSONArray4.put(jSONObject);
                            i2++;
                            jSONArray3 = jSONArray;
                        }
                        jSONObjectA.put(com.umeng.analytics.pro.c.n, jSONArray4);
                        jSONObjectA = jSONObjectA;
                    }
                } catch (Exception e2) {
                    MLog.e("merge pages error");
                    e2.printStackTrace();
                    jSONObjectA = jSONObjectA;
                }
            }
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(a);
            if (sharedPreferences != null) {
                String string = sharedPreferences.getString("userlevel", "");
                if (!TextUtils.isEmpty(string)) {
                    jSONObjectA.put("userlevel", string);
                }
            }
            String[] strArrA = com.umeng.analytics.c.a(a);
            if (strArrA != null && !TextUtils.isEmpty(strArrA[0]) && !TextUtils.isEmpty(strArrA[1])) {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put(com.umeng.analytics.pro.c.M, strArrA[0]);
                jSONObject3.put(com.umeng.analytics.pro.c.N, strArrA[1]);
                if (jSONObject3.length() > 0) {
                    jSONObjectA.put(com.umeng.analytics.pro.c.L, jSONObject3);
                }
            }
            if (ABTest.getService(a).isInTest()) {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put(ABTest.getService(a).getTestName(), ABTest.getService(a).getGroupInfo());
                jSONObjectA.put(com.umeng.analytics.pro.c.K, jSONObject4);
            }
            q.a().a(jSONObjectA, a);
        } catch (Throwable unused) {
        }
        return jSONObjectA;
    }

    public void e() {
        if (d(false)) {
            j();
        }
    }

    public void d(Object obj) {
        r();
        m();
        n();
        a(true);
    }

    private boolean d(boolean z2) {
        if (this.f4915b == null) {
            this.f4915b = new c();
        }
        ReportPolicy.ReportStrategy reportStrategyC = this.f4915b.c();
        if (!(reportStrategyC instanceof ReportPolicy.DefconPolicy)) {
            return true;
        }
        if (z2) {
            return ((ReportPolicy.DefconPolicy) reportStrategyC).shouldSendMessageByInstant();
        }
        return reportStrategyC.shouldSendMessage(false);
    }

    public void b(Object obj) {
        if (obj != null) {
            try {
                JSONObject jSONObject = (JSONObject) obj;
                if (jSONObject.length() > 0 && (!jSONObject.has("exception") || 101 != jSONObject.getInt("exception"))) {
                    f(jSONObject);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public void a(boolean z2) {
        if (c(z2)) {
            if (!(this.f4915b.c() instanceof ReportPolicy.ReportQuasiRealtime)) {
                if (UMEnvelopeBuild.isReadyBuild(a, UMLogDataProtocol.UMBusinessType.U_APP)) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> constructMessage()");
                    j();
                    return;
                }
                return;
            }
            if (z2) {
                if (UMEnvelopeBuild.isOnline(a)) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> send session start in policy ReportQuasiRealtime.");
                    j();
                    return;
                }
                return;
            }
            if (UMEnvelopeBuild.isReadyBuild(a, UMLogDataProtocol.UMBusinessType.U_APP)) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> send normal data in policy ReportQuasiRealtime.");
                j();
            }
        }
    }

    public void b(Context context) {
        try {
            h.a(context).d();
            q();
        } catch (Throwable unused) {
        }
    }

    private boolean a(JSONArray jSONArray) {
        int length = jSONArray.length();
        List listAsList = Arrays.asList("$$_onUMengEnterForeground", "$$_onUMengEnterBackground", "$$_onUMengEnterForegroundInitError");
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            try {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i3);
                if (jSONObjectOptJSONObject != null && listAsList.contains(jSONObjectOptJSONObject.optString("id"))) {
                    i2++;
                }
            } catch (Throwable unused) {
            }
        }
        return i2 >= length;
    }

    private boolean a(JSONObject jSONObject) {
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("ekv");
        int length = jSONArrayOptJSONArray.length();
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            try {
                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i3);
                Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
                while (itKeys.hasNext()) {
                    JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject.optJSONArray(itKeys.next());
                    if (jSONArrayOptJSONArray2 != null && a(jSONArrayOptJSONArray2)) {
                        i2++;
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return i2 >= length;
    }

    public JSONObject a(long j2) {
        if (TextUtils.isEmpty(x.a().d(a))) {
            return null;
        }
        JSONObject jSONObjectB = b(false);
        int iA = q.a().a(a);
        if (jSONObjectB.length() > 0) {
            if (jSONObjectB.length() == 1) {
                if (jSONObjectB.optJSONObject(com.umeng.analytics.pro.c.L) != null && iA != 3) {
                    return null;
                }
                if (!TextUtils.isEmpty(jSONObjectB.optString("userlevel")) && iA != 3) {
                    return null;
                }
            } else if (jSONObjectB.length() == 2 && jSONObjectB.optJSONObject(com.umeng.analytics.pro.c.L) != null && !TextUtils.isEmpty(jSONObjectB.optString("userlevel")) && iA != 3) {
                return null;
            }
            String strOptString = jSONObjectB.optString(com.umeng.analytics.pro.c.n);
            String strOptString2 = jSONObjectB.optString(com.umeng.analytics.pro.c.T);
            String strOptString3 = jSONObjectB.optString("ekv");
            if (TextUtils.isEmpty(strOptString) && TextUtils.isEmpty(strOptString2) && !TextUtils.isEmpty(strOptString3) && a(jSONObjectB)) {
                return null;
            }
        } else if (iA != 3) {
            return null;
        }
        JSONObject jSONObjectL = l();
        if (jSONObjectL != null) {
            c(jSONObjectL);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            if (iA == 3) {
                jSONObject2.put("analytics", new JSONObject());
            } else if (jSONObjectB.length() > 0) {
                jSONObject2.put("analytics", jSONObjectB);
            }
            if (jSONObjectL != null && jSONObjectL.length() > 0) {
                jSONObject.put("header", jSONObjectL);
            }
            if (jSONObject2.length() > 0) {
                jSONObject.put("content", jSONObject2);
            }
            return a(jSONObject, j2);
        } catch (Throwable unused) {
            return jSONObject;
        }
    }

    private JSONObject a(JSONObject jSONObject, long j2) {
        try {
            if (p.a(jSONObject) <= j2) {
                return jSONObject;
            }
            JSONObject jSONObject2 = jSONObject.getJSONObject("header");
            jSONObject2.put(com.umeng.analytics.pro.c.aB, p.a(jSONObject));
            jSONObject.put("header", jSONObject2);
            return p.a(a, j2, jSONObject);
        } catch (Throwable unused) {
            return jSONObject;
        }
    }

    private boolean a(long j2, int i2) {
        if (j2 == 0) {
            return true;
        }
        if (System.currentTimeMillis() - j2 <= 28800000) {
            return i2 < 5000;
        }
        o();
        return true;
    }

    public void a(Object obj) {
        if (obj != null) {
            try {
                JSONObject jSONObject = (JSONObject) obj;
                if (jSONObject.length() > 0 && (!jSONObject.has("exception") || 101 != jSONObject.getInt("exception"))) {
                    g(jSONObject);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public void a(Object obj, boolean z2) {
        if (z2) {
            if (d(true)) {
                i();
            }
        } else if (UMEnvelopeBuild.isOnline(a) && d(true)) {
            i();
        }
    }
}

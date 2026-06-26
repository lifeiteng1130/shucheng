package com.umeng.analytics.pro;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.umeng.analytics.AnalyticsConfig;
import com.umeng.analytics.CoreProtocol;
import com.umeng.analytics.pro.d;
import com.umeng.analytics.pro.h;
import com.umeng.analytics.pro.n;
import com.umeng.analytics.pro.x;
import com.umeng.analytics.process.UMProcessDBDatasSender;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.AnalyticsConstants;
import com.umeng.commonsdk.statistics.common.MLog;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import com.umeng.commonsdk.utils.UMUtils;
import java.lang.reflect.Method;
import org.json.JSONObject;

/* JADX INFO: compiled from: SessionTracker.java */
/* JADX INFO: loaded from: classes.dex */
public class t implements x.a {
    public static final String a = "session_start_time";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f4956b = "session_end_time";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f4957c = "session_id";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f4958d = "pre_session_id";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f4959e = "a_start_time";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f4960f = "a_end_time";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f4961g = "fg_count";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static String f4962h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static Context f4963i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static boolean f4964j = false;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static long f4965k = 0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static boolean f4966l = true;
    private static long m;

    /* JADX INFO: compiled from: SessionTracker.java */
    public static class a {
        private static final t a = new t();

        private a() {
        }
    }

    public static t a() {
        return a.a;
    }

    public static void b(Context context) {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f4963i);
        if (sharedPreferences != null) {
            long j2 = sharedPreferences.getLong(f4961g, 0L);
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            if (editorEdit != null) {
                editorEdit.putLong(f4961g, j2 + 1);
                editorEdit.commit();
            }
        }
    }

    private void d(Context context) {
        try {
            SharedPreferences.Editor editorEdit = PreferenceWrapper.getDefault(context).edit();
            editorEdit.putLong(f4961g, 0L);
            editorEdit.commit();
        } catch (Throwable unused) {
        }
    }

    private String e(Context context) {
        if (f4963i == null && context != null) {
            f4963i = context.getApplicationContext();
        }
        String strD = x.a().d(f4963i);
        try {
            f(context);
            n.a(f4963i).d((Object) null);
        } catch (Throwable unused) {
        }
        return strD;
    }

    private void f(Context context) {
        n.a(context).b(context);
        n.a(context).d();
    }

    public void c(Context context, Object obj) {
        try {
            if (f4963i == null && context != null) {
                f4963i = context.getApplicationContext();
            }
            long jLongValue = ((Long) obj).longValue();
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(context);
            if (sharedPreferences == null) {
                return;
            }
            if (sharedPreferences.getLong(f4959e, 0L) == 0) {
                MLog.e("onPause called before onResume");
                return;
            }
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> onEndSessionInternal: write activity end time = " + jLongValue);
            editorEdit.putLong(f4960f, jLongValue);
            editorEdit.putLong(f4956b, jLongValue);
            editorEdit.commit();
        } catch (Throwable unused) {
        }
    }

    private t() {
        x.a().a(this);
    }

    public static long a(Context context) {
        try {
            return PreferenceWrapper.getDefault(context).getLong(f4961g, 0L);
        } catch (Throwable unused) {
            return 0L;
        }
    }

    public void a(Context context, long j2) {
        SharedPreferences.Editor editorEdit;
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f4963i);
        if (sharedPreferences == null || (editorEdit = sharedPreferences.edit()) == null) {
            return;
        }
        editorEdit.putLong(a, j2);
        editorEdit.commit();
    }

    public void b(Context context, Object obj) {
        long jLongValue;
        try {
            if (f4963i == null) {
                f4963i = UMGlobalContext.getAppContext(context);
            }
            if (obj == null) {
                jLongValue = System.currentTimeMillis();
            } else {
                jLongValue = ((Long) obj).longValue();
            }
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f4963i);
            if (sharedPreferences == null) {
                return;
            }
            f4965k = sharedPreferences.getLong(f4960f, 0L);
            UMRTLog.i(UMRTLog.RTLOG_TAG, "------>>> lastActivityEndTime: " + f4965k);
            String string = sharedPreferences.getString(c.az, "");
            String appVersionName = UMUtils.getAppVersionName(f4963i);
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            if (editorEdit == null) {
                return;
            }
            if (!TextUtils.isEmpty(string) && !string.equals(appVersionName)) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> requestNewInstantSessionIf: version upgrade");
                editorEdit.putLong(a, jLongValue);
                editorEdit.commit();
                n.a(f4963i).a((Object) null, true);
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> force generate new session: session id = " + x.a().c(f4963i));
                f4964j = true;
                a(f4963i, jLongValue, true);
                return;
            }
            if (x.a().e(f4963i)) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> More then 30 sec from last session.");
                f4964j = true;
                editorEdit.putLong(a, jLongValue);
                editorEdit.commit();
                a(f4963i, jLongValue, false);
                return;
            }
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> less then 30 sec from last session, do nothing.");
            f4964j = false;
        } catch (Throwable unused) {
        }
    }

    public void a(Context context, Object obj) {
        SharedPreferences.Editor editorEdit;
        try {
            if (f4963i == null && context != null) {
                f4963i = context.getApplicationContext();
            }
            long jLongValue = ((Long) obj).longValue();
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f4963i);
            if (sharedPreferences == null || (editorEdit = sharedPreferences.edit()) == null) {
                return;
            }
            String string = sharedPreferences.getString(c.az, "");
            String appVersionName = UMUtils.getAppVersionName(f4963i);
            if (TextUtils.isEmpty(string)) {
                editorEdit.putInt("versioncode", Integer.parseInt(UMUtils.getAppVersionCode(context)));
                editorEdit.putString(c.az, appVersionName);
                editorEdit.commit();
            } else if (!string.equals(appVersionName)) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> onStartSessionInternal: upgrade version: " + string + "-> " + appVersionName);
                int i2 = sharedPreferences.getInt("versioncode", 0);
                String string2 = sharedPreferences.getString("pre_date", "");
                String string3 = sharedPreferences.getString("pre_version", "");
                String string4 = sharedPreferences.getString(c.az, "");
                editorEdit.putInt("versioncode", Integer.parseInt(UMUtils.getAppVersionCode(context)));
                editorEdit.putString(c.az, appVersionName);
                editorEdit.putString("vers_date", string2);
                editorEdit.putString("vers_pre_version", string3);
                editorEdit.putString("cur_version", string4);
                editorEdit.putInt("vers_code", i2);
                editorEdit.putString("vers_name", string);
                editorEdit.commit();
                if (f4966l) {
                    f4966l = false;
                }
                if (f4964j) {
                    f4964j = false;
                    b(f4963i, jLongValue, true);
                    b(f4963i, jLongValue);
                    return;
                }
                return;
            }
            if (f4964j) {
                f4964j = false;
                if (f4966l) {
                    f4966l = false;
                }
                f4962h = e(context);
                MLog.d("创建新会话: " + f4962h);
                UMRTLog.i(UMRTLog.RTLOG_TAG, "mSessionChanged flag has been set, Start new session: " + f4962h);
                return;
            }
            f4962h = sharedPreferences.getString("session_id", null);
            editorEdit.putLong(f4959e, jLongValue);
            editorEdit.putLong(f4960f, 0L);
            editorEdit.commit();
            MLog.d("延续上一个会话: " + f4962h);
            UMRTLog.i(UMRTLog.RTLOG_TAG, "Extend current session: " + f4962h);
            if (f4966l) {
                f4966l = false;
                if (FieldManager.allow(com.umeng.commonsdk.utils.b.E)) {
                    Context context2 = f4963i;
                    UMWorkDispatch.sendEventEx(context2, n.a.C, CoreProtocol.getInstance(context2), null, 0L);
                }
            }
            f(context);
            n.a(f4963i).a(false);
        } catch (Throwable unused) {
        }
    }

    public String c(Context context) {
        try {
            if (f4962h == null) {
                return PreferenceWrapper.getDefault(context).getString("session_id", null);
            }
        } catch (Throwable unused) {
        }
        return f4962h;
    }

    public String c() {
        return c(f4963i);
    }

    public boolean b(Context context, long j2, boolean z) {
        String strA;
        long j3;
        boolean z2 = false;
        try {
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(context);
            if (sharedPreferences == null || (strA = x.a().a(f4963i)) == null) {
                return false;
            }
            long j4 = sharedPreferences.getLong(f4959e, 0L);
            long j5 = sharedPreferences.getLong(f4960f, 0L);
            if (j4 > 0 && j5 == 0) {
                z2 = true;
                if (z) {
                    j3 = f4965k;
                    if (j3 == 0) {
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "------>>> lastActivityEndTime = 0, In-app upgrade, use currentTime: = " + j2);
                        j3 = j2;
                    } else {
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "------>>> lastActivityEndTime != 0, app upgrade, use lastActivityEndTime: = " + f4965k);
                    }
                    c(f4963i, Long.valueOf(j3));
                } else {
                    c(f4963i, Long.valueOf(j2));
                    j3 = j2;
                }
                JSONObject jSONObject = new JSONObject();
                if (z) {
                    jSONObject.put(d.C0127d.a.f4848g, j3);
                } else {
                    jSONObject.put(d.C0127d.a.f4848g, j2);
                }
                JSONObject jSONObjectB = com.umeng.analytics.b.a().b();
                if (jSONObjectB != null && jSONObjectB.length() > 0) {
                    jSONObject.put("__sp", jSONObjectB);
                }
                JSONObject jSONObjectC = com.umeng.analytics.b.a().c();
                if (jSONObjectC != null && jSONObjectC.length() > 0) {
                    jSONObject.put("__pp", jSONObjectC);
                }
                if (FieldManager.allow(com.umeng.commonsdk.utils.b.E)) {
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>>*** foregroundCount = " + m);
                    jSONObject.put(d.C0127d.a.f4849h, m);
                    m = 0L;
                } else {
                    jSONObject.put(d.C0127d.a.f4849h, 0L);
                }
                h.a(context).a(strA, jSONObject, h.a.END);
                n.a(f4963i).e();
            }
        } catch (Throwable unused) {
        }
        return z2;
    }

    public void b(Context context, long j2) {
        if (PreferenceWrapper.getDefault(context) == null) {
            return;
        }
        try {
            n.a(f4963i).c((Object) null);
        } catch (Throwable unused) {
        }
    }

    public String a(Context context, long j2, boolean z) {
        String strB = x.a().b(context);
        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> onInstantSessionInternal: current session id = " + strB);
        if (TextUtils.isEmpty(strB)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("__e", j2);
            JSONObject jSONObjectB = com.umeng.analytics.b.a().b();
            if (jSONObjectB != null && jSONObjectB.length() > 0) {
                jSONObject.put("__sp", jSONObjectB);
            }
            JSONObject jSONObjectC = com.umeng.analytics.b.a().c();
            if (jSONObjectC != null && jSONObjectC.length() > 0) {
                jSONObject.put("__pp", jSONObjectC);
            }
            h.a(context).a(strB, jSONObject, h.a.INSTANTSESSIONBEGIN);
            n.a(context).a(jSONObject, z);
        } catch (Throwable unused) {
        }
        return strB;
    }

    public String b() {
        return f4962h;
    }

    @Override // com.umeng.analytics.pro.x.a
    public void a(String str, String str2, long j2, long j3, long j4) {
        a(f4963i, str2, j2, j3, j4);
        UMRTLog.i(UMRTLog.RTLOG_TAG, "saveSessionToDB: complete");
        if (AnalyticsConstants.SUB_PROCESS_EVENT) {
            Context context = f4963i;
            UMWorkDispatch.sendEvent(context, UMProcessDBDatasSender.UM_PROCESS_EVENT_KEY, UMProcessDBDatasSender.getInstance(context), Long.valueOf(System.currentTimeMillis()));
        }
    }

    @Override // com.umeng.analytics.pro.x.a
    public void a(String str, long j2, long j3, long j4) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        a(str, j2);
    }

    private void a(Context context, String str, long j2, long j3, long j4) {
        if (TextUtils.isEmpty(f4962h)) {
            f4962h = x.a().a(f4963i);
        }
        if (TextUtils.isEmpty(str) || str.equals(f4962h)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(d.C0127d.a.f4848g, j3);
            jSONObject.put(d.C0127d.a.f4849h, j4);
            JSONObject jSONObjectB = com.umeng.analytics.b.a().b();
            if (jSONObjectB != null && jSONObjectB.length() > 0) {
                jSONObject.put("__sp", jSONObjectB);
            }
            JSONObject jSONObjectC = com.umeng.analytics.b.a().c();
            if (jSONObjectC != null && jSONObjectC.length() > 0) {
                jSONObject.put("__pp", jSONObjectC);
            }
            h.a(context).a(f4962h, jSONObject, h.a.END);
        } catch (Exception unused) {
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("__e", j2);
            h.a(context).a(str, jSONObject2, h.a.BEGIN);
            if (FieldManager.allow(com.umeng.commonsdk.utils.b.E)) {
                m = j4;
                d(context);
                Context context2 = f4963i;
                UMWorkDispatch.sendEventEx(context2, n.a.C, CoreProtocol.getInstance(context2), null, 0L);
            }
        } catch (Exception unused2) {
        }
        f4962h = str;
    }

    private void a(String str, long j2) {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f4963i);
        if (sharedPreferences == null) {
            return;
        }
        long j3 = sharedPreferences.getLong(f4956b, 0L);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("__ii", str);
            jSONObject.put("__e", j2);
            jSONObject.put(d.C0127d.a.f4848g, j3);
            double[] location = AnalyticsConfig.getLocation();
            if (location != null) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(c.C, location[0]);
                jSONObject2.put(c.D, location[1]);
                jSONObject2.put("ts", System.currentTimeMillis());
                jSONObject.put(d.C0127d.a.f4846e, jSONObject2);
            }
            Class<?> cls = Class.forName("android.net.TrafficStats");
            Class<?> cls2 = Integer.TYPE;
            Method method = cls.getMethod("getUidRxBytes", cls2);
            Method method2 = cls.getMethod("getUidTxBytes", cls2);
            int i2 = f4963i.getApplicationInfo().uid;
            if (i2 == -1) {
                return;
            }
            long jLongValue = ((Long) method.invoke(null, Integer.valueOf(i2))).longValue();
            long jLongValue2 = ((Long) method2.invoke(null, Integer.valueOf(i2))).longValue();
            if (jLongValue > 0 && jLongValue2 > 0) {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put(c.H, jLongValue);
                jSONObject3.put(c.G, jLongValue2);
                jSONObject.put(d.C0127d.a.f4845d, jSONObject3);
            }
            h.a(f4963i).a(str, jSONObject, h.a.NEWSESSION);
            u.a(f4963i);
            k.c(f4963i);
        } catch (Throwable unused) {
        }
    }
}

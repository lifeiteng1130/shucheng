package com.bytedance.pangle.log;

import android.text.TextUtils;
import androidx.annotation.Keep;
import c.a.a.a.a;
import c.c.a.q;

/* JADX INFO: loaded from: classes.dex */
@Keep
public class ZeusLogger {
    public static final String TAG = "Zeus";
    public static final String TAG_ACTIVITY = "Zeus/activity";
    public static final String TAG_DOWNLOAD = "Zeus/download";
    public static final String TAG_INIT = "Zeus/init";
    public static final String TAG_INSTALL = "Zeus/install";
    public static final String TAG_LOAD = "Zeus/load";
    public static final String TAG_PAM = "Zeus/pam";
    public static final String TAG_PPM = "Zeus/ppm";
    public static final String TAG_PROVIDER = "Zeus/provider";
    public static final String TAG_RECEIVER = "Zeus/receiver";
    public static final String TAG_REPORTER = "Zeus/reporter";
    public static final String TAG_RESOURCES = "Zeus/resources";
    public static final String TAG_SERVER = "Zeus/server";
    public static final String TAG_SERVICE = "Zeus/service";
    public static final String TAG_SO = "Zeus/so";
    private static boolean sDebug = true;
    private static boolean sEnableTrace = false;

    public static void d(String str) {
        d(null, str);
    }

    public static void e(String str, String str2) {
        e(str, str2, null, null);
    }

    private static String getTraceInfo() {
        try {
            StackTraceElement[] stackTrace = new Throwable().getStackTrace();
            StackTraceElement stackTraceElement = null;
            int i2 = 1;
            while (true) {
                if (i2 >= stackTrace.length) {
                    break;
                }
                if (!TextUtils.equals(stackTrace[i2].getClassName(), ZeusLogger.class.getName())) {
                    stackTraceElement = stackTrace[i2];
                    break;
                }
                i2++;
            }
            if (stackTraceElement == null) {
                return "\t\t[No Trace Info]";
            }
            return "\t\t[" + stackTraceElement.toString() + "]";
        } catch (Exception e2) {
            e2.printStackTrace();
            return "\t\t[No Trace Info]";
        }
    }

    public static void i(String str) {
        i(null, str);
    }

    public static boolean isDebug() {
        return sDebug;
    }

    public static boolean isEnableTrace() {
        return sEnableTrace;
    }

    private static String prefixTraceInfo(String str) {
        if (!sEnableTrace) {
            return str;
        }
        StringBuilder sbR = a.r(str);
        sbR.append(getTraceInfo());
        return sbR.toString();
    }

    public static void setDebug(boolean z) {
        sDebug = z;
    }

    public static void setEnableTrace(boolean z) {
        sEnableTrace = z;
    }

    public static void v(String str) {
        v(null, str);
    }

    public static void w(String str) {
        w(null, str);
    }

    public static void d(String str, String str2) {
        i(str, str2);
    }

    public static void e(String str, String str2, String str3) {
        e(str, str2, str3, null);
    }

    public static void i(String str, String str2) {
        String strPrefixTraceInfo = prefixTraceInfo(str2);
        if (sDebug || q.a().f779c.getLogger() == null) {
            return;
        }
        q.a().f779c.getLogger().i(str, strPrefixTraceInfo);
    }

    public static void v(String str, String str2) {
        String strPrefixTraceInfo = prefixTraceInfo(str2);
        if (sDebug || q.a().f779c.getLogger() == null) {
            return;
        }
        q.a().f779c.getLogger().v(str, strPrefixTraceInfo);
    }

    public static void w(String str, String str2) {
        String strPrefixTraceInfo = prefixTraceInfo(str2);
        if (sDebug || q.a().f779c.getLogger() == null) {
            return;
        }
        q.a().f779c.getLogger().w(str, strPrefixTraceInfo);
    }

    public static void e(String str, String str2, Throwable th) {
        e(str, str2, null, th);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0042 A[Catch: JSONException -> 0x0040, TryCatch #0 {JSONException -> 0x0040, blocks: (B:10:0x0030, B:12:0x0038, B:16:0x0047, B:18:0x004d, B:19:0x0052, B:15:0x0042), top: B:24:0x0030 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void e(java.lang.String r4, java.lang.String r5, java.lang.String r6, java.lang.Throwable r7) {
        /*
            java.lang.String r5 = prefixTraceInfo(r5)
            boolean r0 = com.bytedance.pangle.log.ZeusLogger.sDebug
            if (r0 == 0) goto L9
            goto L22
        L9:
            c.c.a.q r0 = c.c.a.q.a()
            com.bytedance.pangle.ZeusParam r0 = r0.f779c
            com.bytedance.pangle.log.IZeusLogger r0 = r0.getLogger()
            if (r0 == 0) goto L22
            c.c.a.q r0 = c.c.a.q.a()
            com.bytedance.pangle.ZeusParam r0 = r0.f779c
            com.bytedance.pangle.log.IZeusLogger r0 = r0.getLogger()
            r0.e(r4, r5, r7)
        L22:
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>()
            org.json.JSONObject r1 = new org.json.JSONObject
            r1.<init>()
            java.lang.String r2 = "log_tag"
            if (r4 == 0) goto L42
            java.lang.String r3 = "Zeus"
            boolean r3 = r4.startsWith(r3)     // Catch: org.json.JSONException -> L40
            if (r3 == 0) goto L42
            java.lang.String r4 = c.b.a.m.f.t(r4)     // Catch: org.json.JSONException -> L40
            r0.putOpt(r2, r4)     // Catch: org.json.JSONException -> L40
            goto L47
        L40:
            r4 = move-exception
            goto L65
        L42:
            java.lang.String r4 = "other"
            r0.putOpt(r2, r4)     // Catch: org.json.JSONException -> L40
        L47:
            boolean r4 = android.text.TextUtils.isEmpty(r6)     // Catch: org.json.JSONException -> L40
            if (r4 != 0) goto L52
            java.lang.String r4 = "plugin_package_name"
            r0.putOpt(r4, r6)     // Catch: org.json.JSONException -> L40
        L52:
            java.lang.String r4 = "message"
            java.lang.String r5 = c.b.a.m.f.t(r5)     // Catch: org.json.JSONException -> L40
            r1.putOpt(r4, r5)     // Catch: org.json.JSONException -> L40
            java.lang.String r4 = "throwable"
            java.lang.String r5 = c.b.a.m.f.u(r7)     // Catch: org.json.JSONException -> L40
            r1.putOpt(r4, r5)     // Catch: org.json.JSONException -> L40
            goto L68
        L65:
            r4.printStackTrace()
        L68:
            r4 = 0
            java.lang.String r5 = "zeus_error"
            c.b.a.m.f.I(r5, r0, r4, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.pangle.log.ZeusLogger.e(java.lang.String, java.lang.String, java.lang.String, java.lang.Throwable):void");
    }

    public static void w(String str, String str2, Throwable th) {
        String strPrefixTraceInfo = prefixTraceInfo(str2);
        if (sDebug || q.a().f779c.getLogger() == null) {
            return;
        }
        q.a().f779c.getLogger().w(str, strPrefixTraceInfo, th);
    }
}

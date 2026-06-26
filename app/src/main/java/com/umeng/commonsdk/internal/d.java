package com.umeng.commonsdk.internal;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.inputmethod.InputMethodInfo;
import androidx.camera.core.FocusMeteringAction;
import androidx.core.os.EnvironmentCompat;
import com.umeng.analytics.pro.ai;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.framework.UMLogDataProtocol;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.internal.utils.a;
import com.umeng.commonsdk.internal.utils.d;
import com.umeng.commonsdk.internal.utils.j;
import com.umeng.commonsdk.internal.utils.k;
import com.umeng.commonsdk.statistics.UMServerURL;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.statistics.common.ULog;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: UMInternalManager.java */
/* JADX INFO: loaded from: classes3.dex */
public class d {
    public static void a(Context context) {
        try {
            ULog.i("walle", "[internal] workEvent send envelope");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(ai.aK, a.f5143e);
            JSONObject jSONObjectBuildEnvelopeWithExtHeader = UMEnvelopeBuild.buildEnvelopeWithExtHeader(context, jSONObject, d(context), UMServerURL.PATH_ANALYTICS, ai.aA, a.f5143e);
            if (jSONObjectBuildEnvelopeWithExtHeader == null || jSONObjectBuildEnvelopeWithExtHeader.has("exception")) {
                return;
            }
            ULog.i("walle", "[internal] workEvent send envelope back, result is ok");
            com.umeng.commonsdk.internal.utils.a.e(context);
        } catch (Exception e2) {
            UMCrashManager.reportCrash(context, e2);
        }
    }

    public static void b(Context context) {
        ULog.i("walle", "[internal] begin by stateful--->>>");
        if (context != null) {
            j(context);
        }
    }

    public static void c(Context context) {
        ULog.i("walle", "[internal] begin by stateful--->>>");
        if (context == null || !UMEnvelopeBuild.getTransmissionSendFlag()) {
            return;
        }
        j(context);
    }

    public static JSONObject d(Context context) throws Throwable {
        JSONArray jSONArrayH;
        JSONArray jSONArrayK;
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        if (context != null) {
            Context applicationContext = context.getApplicationContext();
            try {
                if (FieldManager.allow(com.umeng.commonsdk.utils.b.I) && (jSONArrayK = k(applicationContext)) != null && jSONArrayK.length() > 0) {
                    jSONObject2.put("rs", jSONArrayK);
                }
            } catch (Exception e2) {
                UMCrashManager.reportCrash(applicationContext, e2);
            }
            try {
                JSONArray jSONArrayL = l(applicationContext);
                if (jSONArrayL != null && jSONArrayL.length() > 0) {
                    jSONObject2.put("by", jSONArrayL);
                }
            } catch (Exception e3) {
                UMCrashManager.reportCrash(applicationContext, e3);
            }
            try {
                a(applicationContext, jSONObject2);
            } catch (Exception e4) {
                UMCrashManager.reportCrash(applicationContext, e4);
            }
            try {
                b(applicationContext, jSONObject2);
            } catch (Exception e5) {
                UMCrashManager.reportCrash(applicationContext, e5);
            }
            try {
                JSONObject jSONObjectA = a();
                if (jSONObjectA != null && jSONObjectA.length() > 0) {
                    jSONObject2.put("build", jSONObjectA);
                }
            } catch (Exception e6) {
                UMCrashManager.reportCrash(applicationContext, e6);
            }
            try {
                JSONObject jSONObjectE = e(applicationContext);
                if (jSONObjectE != null && jSONObjectE.length() > 0) {
                    jSONObject2.put("scr", jSONObjectE);
                }
            } catch (Exception e7) {
                UMCrashManager.reportCrash(applicationContext, e7);
            }
            try {
                JSONObject jSONObjectF = f(applicationContext);
                if (jSONObjectF != null && jSONObjectF.length() > 0) {
                    jSONObject2.put("sinfo", jSONObjectF);
                }
            } catch (Exception e8) {
                UMCrashManager.reportCrash(applicationContext, e8);
            }
            try {
                JSONObject jSONObject3 = new JSONObject();
                JSONArray jSONArrayD = com.umeng.commonsdk.internal.utils.a.d(applicationContext);
                if (jSONArrayD != null && jSONArrayD.length() > 0) {
                    try {
                        jSONObject3.put("wl", jSONArrayD);
                    } catch (JSONException unused) {
                    }
                }
                jSONObject2.put("winfo", jSONObject3);
            } catch (Exception e9) {
                UMCrashManager.reportCrash(applicationContext, e9);
            }
            try {
                JSONArray jSONArrayG = g(applicationContext);
                if (jSONArrayG != null && jSONArrayG.length() > 0) {
                    jSONObject2.put("input", jSONArrayG);
                }
            } catch (Exception e10) {
                UMCrashManager.reportCrash(applicationContext, e10);
            }
            try {
                if (FieldManager.allow(com.umeng.commonsdk.utils.b.af) && (jSONArrayH = h(applicationContext)) != null && jSONArrayH.length() > 0) {
                    jSONObject2.put("appls", jSONArrayH);
                }
            } catch (Exception e11) {
                UMCrashManager.reportCrash(applicationContext, e11);
            }
            try {
                JSONObject jSONObjectI = i(applicationContext);
                if (jSONObjectI != null && jSONObjectI.length() > 0) {
                    jSONObject2.put("mem", jSONObjectI);
                }
            } catch (Exception e12) {
                UMCrashManager.reportCrash(applicationContext, e12);
            }
            try {
                JSONObject jSONObjectB = b();
                if (jSONObjectB != null && jSONObjectB.length() > 0) {
                    jSONObject2.put(ai.w, jSONObjectB);
                }
            } catch (Exception unused2) {
            }
            try {
                jSONObject.put(ai.as, jSONObject2);
            } catch (JSONException e13) {
                UMCrashManager.reportCrash(applicationContext, e13);
            }
        }
        return jSONObject;
    }

    public static JSONObject e(Context context) {
        DisplayMetrics displayMetrics;
        JSONObject jSONObject = new JSONObject();
        if (context != null) {
            try {
                jSONObject.put("a_st_h", com.umeng.commonsdk.internal.utils.a.g(context));
                jSONObject.put("a_nav_h", com.umeng.commonsdk.internal.utils.a.h(context));
                if (context.getResources() != null && (displayMetrics = context.getResources().getDisplayMetrics()) != null) {
                    jSONObject.put("a_den", displayMetrics.density);
                    jSONObject.put("a_dpi", displayMetrics.densityDpi);
                }
            } catch (Exception e2) {
                UMCrashManager.reportCrash(context, e2);
            }
        }
        return jSONObject;
    }

    public static JSONObject f(Context context) {
        JSONObject jSONObject = new JSONObject();
        if (context != null) {
            Context applicationContext = context.getApplicationContext();
            String packageName = applicationContext.getPackageName();
            try {
                jSONObject.put("a_fit", com.umeng.commonsdk.internal.utils.a.a(applicationContext, packageName));
                jSONObject.put("a_alut", com.umeng.commonsdk.internal.utils.a.b(applicationContext, packageName));
                jSONObject.put("a_c", com.umeng.commonsdk.internal.utils.a.c(applicationContext, packageName));
                jSONObject.put("a_uid", com.umeng.commonsdk.internal.utils.a.d(applicationContext, packageName));
                if (com.umeng.commonsdk.internal.utils.a.a()) {
                    jSONObject.put("a_root", 1);
                } else {
                    jSONObject.put("a_root", 0);
                }
                jSONObject.put("tf", com.umeng.commonsdk.internal.utils.a.b());
                jSONObject.put("s_fs", com.umeng.commonsdk.internal.utils.a.a(applicationContext));
                jSONObject.put("a_meid", DeviceConfig.getMeid(applicationContext));
                jSONObject.put("a_imsi", DeviceConfig.getImsi(applicationContext));
                jSONObject.put("st", com.umeng.commonsdk.internal.utils.a.d());
                String simICCID = DeviceConfig.getSimICCID(applicationContext);
                if (!TextUtils.isEmpty(simICCID)) {
                    try {
                        jSONObject.put("a_iccid", simICCID);
                    } catch (Exception unused) {
                    }
                }
                String secondSimIMEi = DeviceConfig.getSecondSimIMEi(applicationContext);
                if (!TextUtils.isEmpty(secondSimIMEi)) {
                    try {
                        jSONObject.put("a_simei", secondSimIMEi);
                    } catch (Exception unused2) {
                    }
                }
                jSONObject.put("hn", com.umeng.commonsdk.internal.utils.a.e());
                jSONObject.put("ts", System.currentTimeMillis());
            } catch (Exception e2) {
                UMCrashManager.reportCrash(applicationContext, e2);
            }
        }
        return jSONObject;
    }

    public static JSONArray g(Context context) {
        Context applicationContext;
        List<InputMethodInfo> listJ;
        JSONArray jSONArray = new JSONArray();
        if (context != null && (listJ = com.umeng.commonsdk.internal.utils.a.j((applicationContext = context.getApplicationContext()))) != null) {
            for (InputMethodInfo inputMethodInfo : listJ) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("a_id", inputMethodInfo.getId());
                    jSONObject.put("a_pn", inputMethodInfo.getPackageName());
                    jSONObject.put("ts", System.currentTimeMillis());
                    jSONArray.put(jSONObject);
                } catch (Throwable th) {
                    UMCrashManager.reportCrash(applicationContext, th);
                }
            }
        }
        return jSONArray;
    }

    public static JSONArray h(Context context) {
        Context applicationContext;
        List<a.C0132a> listK;
        JSONArray jSONArray = new JSONArray();
        if (context != null && (listK = com.umeng.commonsdk.internal.utils.a.k((applicationContext = context.getApplicationContext()))) != null && !listK.isEmpty()) {
            for (a.C0132a c0132a : listK) {
                if (c0132a != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("a_pn", c0132a.a);
                        jSONObject.put("a_la", c0132a.f5162b);
                        jSONObject.put("ts", System.currentTimeMillis());
                        jSONArray.put(jSONObject);
                    } catch (Exception e2) {
                        UMCrashManager.reportCrash(applicationContext, e2);
                    }
                }
            }
        }
        return jSONArray;
    }

    public static JSONObject i(Context context) {
        Context applicationContext;
        ActivityManager.MemoryInfo memoryInfoL;
        JSONObject jSONObject = new JSONObject();
        if (context != null && (memoryInfoL = com.umeng.commonsdk.internal.utils.a.l((applicationContext = context.getApplicationContext()))) != null) {
            try {
                jSONObject.put(ai.aF, memoryInfoL.totalMem);
                jSONObject.put("f", memoryInfoL.availMem);
                jSONObject.put("ts", System.currentTimeMillis());
            } catch (Exception e2) {
                UMCrashManager.reportCrash(applicationContext, e2);
            }
        }
        return jSONObject;
    }

    private static void j(Context context) {
        try {
            if (UMEnvelopeBuild.isReadyBuild(context, UMLogDataProtocol.UMBusinessType.U_INTERNAL)) {
                UMWorkDispatch.sendEvent(context, a.f5144f, b.a(context).a(), null);
            }
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 冷启动：5秒后触发2号数据仓遗留信封检查动作。");
            UMWorkDispatch.sendEvent(context, a.v, b.a(context).a(), null, FocusMeteringAction.DEFAULT_AUTOCANCEL_DURATION);
        } catch (Throwable th) {
            UMCrashManager.reportCrash(context, th);
        }
    }

    private static JSONArray k(Context context) {
        List<ActivityManager.RunningServiceInfo> runningServices;
        JSONArray jSONArray = null;
        jSONArray = null;
        if (context == null) {
            return null;
        }
        try {
            ActivityManager activityManager = (ActivityManager) context.getApplicationContext().getSystemService("activity");
            if (activityManager == null || (runningServices = activityManager.getRunningServices(Integer.MAX_VALUE)) == null || runningServices.isEmpty()) {
                return null;
            }
            int i2 = 0;
            while (i2 < runningServices.size()) {
                if (runningServices.get(i2) != null && runningServices.get(i2).service != null && runningServices.get(i2).service.getClassName() != null && runningServices.get(i2).service.getPackageName() != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("sn", runningServices.get(i2).service.getClassName().toString());
                        jSONObject.put("pn", runningServices.get(i2).service.getPackageName().toString());
                        jSONArray = jSONArray;
                        if (jSONArray == null) {
                            jSONArray = new JSONArray();
                        }
                        jSONArray.put(jSONObject);
                    } catch (JSONException unused) {
                    }
                }
                i2++;
                jSONArray = jSONArray;
            }
            if (jSONArray == null) {
                return jSONArray;
            }
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("ts", System.currentTimeMillis());
                jSONObject2.put("ls", jSONArray);
            } catch (JSONException unused2) {
            }
            JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject3.put("sers", jSONObject2);
            } catch (JSONException unused3) {
            }
            JSONArray jSONArray2 = new JSONArray();
            try {
                jSONArray2.put(jSONObject3);
                return jSONArray2;
            } catch (Throwable th) {
                th = th;
                jSONArray = jSONArray2;
            }
        } catch (Throwable th2) {
            th = th2;
        }
        UMCrashManager.reportCrash(context, th);
        return jSONArray;
    }

    private static JSONArray l(Context context) {
        JSONArray jSONArray = new JSONArray();
        String strA = j.a(context);
        if (!TextUtils.isEmpty(strA)) {
            try {
                jSONArray.put(new JSONObject(strA));
            } catch (Exception unused) {
            }
        }
        return jSONArray;
    }

    private static JSONObject b() throws Throwable {
        try {
            d.a aVarA = com.umeng.commonsdk.internal.utils.d.a();
            if (aVarA == null) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("pro", aVarA.a);
                jSONObject.put("pla", aVarA.f5181b);
                jSONObject.put("cpus", aVarA.f5182c);
                jSONObject.put("fea", aVarA.f5183d);
                jSONObject.put("imp", aVarA.f5184e);
                jSONObject.put("arc", aVarA.f5185f);
                jSONObject.put("var", aVarA.f5186g);
                jSONObject.put("par", aVarA.f5187h);
                jSONObject.put("rev", aVarA.f5188i);
                jSONObject.put("har", aVarA.f5189j);
                jSONObject.put("rev", aVarA.f5190k);
                jSONObject.put("ser", aVarA.f5191l);
                jSONObject.put("cur_cpu", com.umeng.commonsdk.internal.utils.d.d());
                jSONObject.put("max_cpu", com.umeng.commonsdk.internal.utils.d.b());
                jSONObject.put("min_cpu", com.umeng.commonsdk.internal.utils.d.c());
                jSONObject.put("ts", System.currentTimeMillis());
            } catch (Exception unused) {
            }
            return jSONObject;
        } catch (Exception unused2) {
            return null;
        }
    }

    private static void a(Context context, JSONObject jSONObject) {
        PackageManager packageManager;
        if (context == null || (packageManager = context.getApplicationContext().getPackageManager()) == null) {
            return;
        }
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        a(jSONObject, "gp", packageManager.hasSystemFeature("android.hardware.location.gps"));
        a(jSONObject, "to", packageManager.hasSystemFeature("android.hardware.touchscreen"));
        a(jSONObject, "mo", packageManager.hasSystemFeature("android.hardware.telephony"));
        a(jSONObject, "ca", packageManager.hasSystemFeature("android.hardware.camera"));
        a(jSONObject, "fl", packageManager.hasSystemFeature("android.hardware.camera.flash"));
    }

    private static void a(JSONObject jSONObject, String str, boolean z) {
        if (jSONObject == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            if (z) {
                jSONObject.put(str, 1);
            } else {
                jSONObject.put(str, 0);
            }
        } catch (Exception unused) {
        }
    }

    public static JSONObject a() {
        JSONArray jSONArray;
        int i2;
        int i3;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("a_pr", Build.PRODUCT);
            jSONObject.put("a_bl", Build.BOOTLOADER);
            jSONObject.put("a_rv", Build.getRadioVersion());
            jSONObject.put("a_fp", Build.FINGERPRINT);
            jSONObject.put("a_hw", Build.HARDWARE);
            jSONObject.put("a_host", Build.HOST);
            jSONArray = new JSONArray();
            i2 = 0;
            i3 = 0;
        } catch (Exception unused) {
        }
        while (true) {
            String[] strArr = Build.SUPPORTED_32_BIT_ABIS;
            if (i3 >= strArr.length) {
                break;
            }
            jSONArray.put(strArr[i3]);
            i3++;
            return jSONObject;
        }
        if (jSONArray.length() > 0) {
            jSONObject.put("a_s32", jSONArray);
        }
        JSONArray jSONArray2 = new JSONArray();
        int i4 = 0;
        while (true) {
            String[] strArr2 = Build.SUPPORTED_64_BIT_ABIS;
            if (i4 >= strArr2.length) {
                break;
            }
            jSONArray2.put(strArr2[i4]);
            i4++;
            return jSONObject;
        }
        if (jSONArray2.length() > 0) {
            jSONObject.put("a_s64", jSONArray2);
        }
        JSONArray jSONArray3 = new JSONArray();
        while (true) {
            String[] strArr3 = Build.SUPPORTED_ABIS;
            if (i2 >= strArr3.length) {
                break;
            }
            jSONArray3.put(strArr3[i2]);
            i2++;
            return jSONObject;
        }
        if (jSONArray3.length() > 0) {
            jSONObject.put("a_sa", jSONArray3);
        }
        jSONObject.put("a_ta", Build.TAGS);
        jSONObject.put("a_uk", EnvironmentCompat.MEDIA_UNKNOWN);
        jSONObject.put("a_user", Build.USER);
        jSONObject.put("a_cpu1", Build.CPU_ABI);
        jSONObject.put("a_cpu2", Build.CPU_ABI2);
        jSONObject.put("a_ra", Build.RADIO);
        if (Build.VERSION.SDK_INT >= 23) {
            jSONObject.put("a_bos", Build.VERSION.BASE_OS);
            jSONObject.put("a_pre", Build.VERSION.PREVIEW_SDK_INT);
            jSONObject.put("a_sp", Build.VERSION.SECURITY_PATCH);
        }
        jSONObject.put("a_cn", Build.VERSION.CODENAME);
        jSONObject.put("a_intl", Build.VERSION.INCREMENTAL);
        return jSONObject;
    }

    private static void b(Context context, JSONObject jSONObject) {
        if (context != null) {
            String strA = k.a(context);
            if (TextUtils.isEmpty(strA)) {
                return;
            }
            try {
                JSONObject jSONObject2 = new JSONObject(strA);
                if (jSONObject == null) {
                    jSONObject = new JSONObject();
                }
                if (jSONObject2.has(k.f5211d)) {
                    jSONObject.put(k.f5211d, jSONObject2.opt(k.f5211d));
                }
                if (jSONObject2.has(k.f5210c)) {
                    jSONObject.put(k.f5210c, jSONObject2.opt(k.f5210c));
                }
                if (jSONObject2.has(k.f5209b)) {
                    jSONObject.put(k.f5209b, jSONObject2.opt(k.f5209b));
                }
            } catch (Exception unused) {
            }
        }
    }
}

package com.umeng.umcrash;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.efs.sdk.base.EfsReporter;
import com.efs.sdk.pa.PAFactory;
import com.efs.sdk.pa.config.IEfsReporter;
import com.efs.sdk.pa.config.PackageLevel;
import com.uc.crashsdk.export.CrashApi;
import com.uc.crashsdk.export.CustomLogInfo;
import com.uc.crashsdk.export.ICrashClient;
import com.uc.crashsdk.export.LogType;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class UMCrash {
    public static final String KEY_APM_DEFAULT_SECRET = "NEej8y@anWa*8hep";
    public static final String KEY_APM_ROOT_NAME = "UApm";
    public static final String KEY_CALLBACK_PAGE_ACTION = "um_action_log";
    public static final String KEY_CALLBACK_UMID = "um_umid";
    private static final String KEY_CALLBACK_USER_STRING = "um_user_string";
    public static final String KEY_HEADER_APPKEY = "um_app_key";
    public static final String KEY_HEADER_CARRIER = "um_app_carrier";
    public static final String KEY_HEADER_CHANNEL = "um_app_channel";
    public static final String KEY_HEADER_CRASH_VERSION = "um_crash_sdk_version";
    public static final String KEY_HEADER_OS = "um_os";
    public static final String KEY_HEADER_PROVIDER = "um_app_provider";
    public static final String KEY_HEADER_PUID = "um_app_puid";
    public static final String KEY_HEADER_START_TIME = "um_app_start_time";
    public static final String KEY_HEADER_UMID = "um_umid_header";
    private static final int KEY_MAX_LENGTH = 256;
    private static final String TAG = "UMCrash";
    private static String crashSdkVersion = "1.2.0";
    private static boolean enableANRLog = true;
    private static boolean enableNativeLog = true;
    private static boolean enableUnexpLog = false;
    private static boolean isDebug = true;
    private static boolean isEncrypt = false;
    private static boolean isIntl = false;
    private static boolean isZip = true;
    private static Context mContext;
    private static UMCrashCallback mUMCrashCallback;
    public static EfsReporter sReporter;
    private static Object pageArrayLock = new Object();
    private static ArrayList<String> mArrayList = new ArrayList<>(10);
    private static boolean isPA = false;

    public static class CrashClientImpl implements ICrashClient {
        private CrashClientImpl() {
        }

        @Override // com.uc.crashsdk.export.ICrashClient
        public void onAddCrashStats(String str, int i2, int i3) {
        }

        @Override // com.uc.crashsdk.export.ICrashClient
        public File onBeforeUploadLog(File file) {
            return file;
        }

        @Override // com.uc.crashsdk.export.ICrashClient
        public void onClientProcessLogGenerated(String str, File file, String str2) {
        }

        @Override // com.uc.crashsdk.export.ICrashClient
        public void onCrashRestarting(boolean z) {
        }

        @Override // com.uc.crashsdk.export.ICrashClient
        public String onGetCallbackInfo(String str, boolean z) {
            String strOnCallback;
            String string = null;
            if (!UMCrash.KEY_CALLBACK_PAGE_ACTION.equals(str)) {
                if (UMCrash.KEY_CALLBACK_UMID.equals(str)) {
                    return UMCrash.getUMID(UMCrash.mContext);
                }
                if (!UMCrash.KEY_CALLBACK_USER_STRING.equals(str) || UMCrash.mUMCrashCallback == null || (strOnCallback = UMCrash.mUMCrashCallback.onCallback()) == null) {
                    return null;
                }
                return strOnCallback.trim().getBytes().length > 256 ? UMCrashUtils.splitByByte(strOnCallback, 256) : strOnCallback;
            }
            try {
                synchronized (UMCrash.pageArrayLock) {
                    if (UMCrash.mArrayList != null && UMCrash.mArrayList.size() > 0) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("source", 0);
                        jSONObject.put("action_name", "page_view");
                        JSONArray jSONArray = new JSONArray();
                        for (int i2 = 0; i2 < UMCrash.mArrayList.size(); i2++) {
                            String str2 = (String) UMCrash.mArrayList.get(i2);
                            if (str2 != null) {
                                JSONObject jSONObject2 = new JSONObject();
                                jSONObject2.put("name", str2);
                                jSONArray.put(jSONObject2);
                            }
                        }
                        jSONObject.put("action_parameter", jSONArray);
                        string = jSONObject.toString();
                        if (UMCrash.isDebug) {
                            String unused = UMCrash.TAG;
                        }
                    }
                }
            } catch (Throwable unused2) {
            }
            return string;
        }

        @Override // com.uc.crashsdk.export.ICrashClient
        public void onLogGenerated(File file, String str) {
        }
    }

    public static void enableANRLog(boolean z) {
        enableANRLog = z;
    }

    public static void enableNativeLog(boolean z) {
        enableNativeLog = z;
    }

    public static void enableUnexpLog(boolean z) {
        enableUnexpLog = z;
    }

    public static void generateCustomLog(Throwable th, String str) {
        if (th == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            CustomLogInfo customLogInfoBuild = new UMCustomLogInfoBuilder(str).stack(th).build();
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add(KEY_CALLBACK_UMID);
            arrayList.add(KEY_CALLBACK_PAGE_ACTION);
            customLogInfoBuild.mCallbacks = arrayList;
            CrashApi crashApi = CrashApi.getInstance();
            if (crashApi == null) {
                return;
            }
            crashApi.generateCustomLog(customLogInfoBuild);
        } catch (Throwable unused) {
        }
    }

    public static String getUMAPMFlag() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("version", 0);
            jSONObject.put("crash", 1);
            if (enableNativeLog) {
                jSONObject.put("crashNative", 1);
            } else {
                jSONObject.put("crashNative", 0);
            }
            if (enableANRLog) {
                jSONObject.put(LogType.ANR_TYPE, 1);
            } else {
                jSONObject.put(LogType.ANR_TYPE, 0);
            }
            if (isPA) {
                jSONObject.put("pa", 1);
            } else {
                jSONObject.put("pa", 0);
            }
        } catch (Throwable unused) {
        }
        return jSONObject.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized String getUMID(Context context) {
        Class<?> cls;
        Method method;
        String string = null;
        if (context == null) {
            return null;
        }
        try {
            cls = Class.forName("com.umeng.commonsdk.UMConfigure");
        } catch (ClassNotFoundException unused) {
            cls = null;
        }
        if (cls != null) {
            try {
                method = cls.getMethod("getUMIDString", Context.class);
            } catch (NoSuchMethodException unused2) {
                method = null;
            }
            if (method != null) {
                try {
                    Object objInvoke = method.invoke(null, context);
                    if (objInvoke != null) {
                        string = objInvoke.toString();
                    }
                } catch (IllegalAccessException | InvocationTargetException unused3) {
                }
            }
        }
        return string;
    }

    public static void init(Context context, String str, String str2) {
        if (context == null || str == null) {
            return;
        }
        mContext = context;
        try {
            Bundle bundle = new Bundle();
            bundle.putBoolean("mDebug", isDebug);
            bundle.putBoolean("mEncryptLog", isEncrypt);
            bundle.putBoolean("mZipLog", isZip);
            bundle.putBoolean("enableNativeLog", enableNativeLog);
            bundle.putBoolean("enableANRLog", enableANRLog);
            bundle.putBoolean("enableUnexpLog", enableUnexpLog);
            bundle.putBoolean("mIsInternational", isIntl);
            CrashApi crashApiCreateInstanceEx = CrashApi.createInstanceEx(context, str, isDebug, bundle, new CrashClientImpl());
            if (crashApiCreateInstanceEx != null) {
                crashApiCreateInstanceEx.addHeaderInfo(KEY_HEADER_APPKEY, str);
                crashApiCreateInstanceEx.addHeaderInfo(KEY_HEADER_CHANNEL, str2);
                crashApiCreateInstanceEx.addHeaderInfo(KEY_HEADER_OS, "android");
                crashApiCreateInstanceEx.addHeaderInfo(KEY_HEADER_CRASH_VERSION, crashSdkVersion);
                crashApiCreateInstanceEx.addHeaderInfo(KEY_HEADER_UMID, getUMID(context));
                try {
                    String[] activeUser = UMCrashUtils.getActiveUser(context);
                    if (activeUser != null && activeUser.length == 2) {
                        crashApiCreateInstanceEx.addHeaderInfo(KEY_HEADER_PUID, activeUser[0]);
                        crashApiCreateInstanceEx.addHeaderInfo(KEY_HEADER_PROVIDER, activeUser[1]);
                    }
                } catch (Throwable unused) {
                    crashApiCreateInstanceEx.addHeaderInfo(KEY_HEADER_PUID, "");
                    crashApiCreateInstanceEx.addHeaderInfo(KEY_HEADER_PROVIDER, "");
                }
                crashApiCreateInstanceEx.addHeaderInfo(KEY_HEADER_CARRIER, UMCrashUtils.getNetworkOperatorName(context));
                if (context instanceof Application) {
                    ((Application) context).registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() { // from class: com.umeng.umcrash.UMCrash.1
                        @Override // android.app.Application.ActivityLifecycleCallbacks
                        public void onActivityCreated(Activity activity, Bundle bundle2) {
                        }

                        @Override // android.app.Application.ActivityLifecycleCallbacks
                        public void onActivityDestroyed(Activity activity) {
                        }

                        @Override // android.app.Application.ActivityLifecycleCallbacks
                        public void onActivityPaused(Activity activity) {
                        }

                        @Override // android.app.Application.ActivityLifecycleCallbacks
                        public void onActivityResumed(Activity activity) {
                            synchronized (UMCrash.pageArrayLock) {
                                if (UMCrash.mArrayList != null) {
                                    if (UMCrash.mArrayList.size() >= 10) {
                                        UMCrash.mArrayList.remove(0);
                                    }
                                    UMCrash.mArrayList.add(activity.getLocalClassName() + "-" + System.currentTimeMillis());
                                }
                            }
                        }

                        @Override // android.app.Application.ActivityLifecycleCallbacks
                        public void onActivitySaveInstanceState(Activity activity, Bundle bundle2) {
                        }

                        @Override // android.app.Application.ActivityLifecycleCallbacks
                        public void onActivityStarted(Activity activity) {
                        }

                        @Override // android.app.Application.ActivityLifecycleCallbacks
                        public void onActivityStopped(Activity activity) {
                        }
                    });
                    crashApiCreateInstanceEx.registerInfoCallback(KEY_CALLBACK_UMID, 1048593);
                    crashApiCreateInstanceEx.registerInfoCallback(KEY_CALLBACK_PAGE_ACTION, 1048593);
                }
            }
        } catch (Throwable unused2) {
        }
        try {
            HashMap map = new HashMap(1);
            map.put(KEY_HEADER_UMID, getUMID(context));
            map.put(KEY_HEADER_CHANNEL, str2);
            map.put(KEY_HEADER_CARRIER, UMCrashUtils.getNetworkOperatorName(context));
            map.put(KEY_HEADER_OS, "android");
            EfsReporter efsReporterBuild = new EfsReporter.Builder(context.getApplicationContext(), str, KEY_APM_DEFAULT_SECRET).debug(isDebug).efsDirRootName(KEY_APM_ROOT_NAME).printLogDetail(isDebug).intl(isIntl).build();
            sReporter = efsReporterBuild;
            efsReporterBuild.addPublicParams(map);
            PAFactory.Builder builder = new PAFactory.Builder(context.getApplicationContext(), new IEfsReporter() { // from class: com.umeng.umcrash.UMCrash.2
                @Override // com.efs.sdk.pa.config.IEfsReporter
                public EfsReporter getReporter() {
                    return UMCrash.sReporter;
                }
            });
            builder.packageLevel(PackageLevel.RELEASE);
            PAFactory pAFactoryBuild = builder.build();
            pAFactoryBuild.getPaInstance().start();
            isPA = pAFactoryBuild.getConfigManager().enableTracer();
        } catch (Throwable unused3) {
        }
    }

    public static void registerUMCrashCallback(UMCrashCallback uMCrashCallback) {
        if (uMCrashCallback != null) {
            mUMCrashCallback = uMCrashCallback;
            if (CrashApi.getInstance() != null) {
                CrashApi.getInstance().registerInfoCallback(KEY_CALLBACK_USER_STRING, 1048593);
            }
        }
    }

    public static void setDebug(boolean z) {
        isDebug = z;
    }

    private static void useIntlServices(boolean z) {
        isIntl = z;
        boolean z2 = isDebug;
    }

    public static void generateCustomLog(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        try {
            CustomLogInfo customLogInfo = new CustomLogInfo(null, "exception");
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add(KEY_CALLBACK_UMID);
            arrayList.add(KEY_CALLBACK_PAGE_ACTION);
            customLogInfo.mCallbacks = arrayList;
            HashMap map = new HashMap(20);
            map.put(UMCustomLogInfoBuilder.LOG_KEY_CT, "exception");
            map.put(UMCustomLogInfoBuilder.LOG_KEY_AC, str2);
            StringBuffer stringBuffer = new StringBuffer();
            for (Map.Entry entry : map.entrySet()) {
                stringBuffer.append((String) entry.getKey());
                stringBuffer.append(":");
                stringBuffer.append((String) entry.getValue());
                stringBuffer.append("\n");
            }
            String str3 = "Exception message:\nBack traces starts.\n" + str + "\nBack traces ends.";
            if (!TextUtils.isEmpty(str3)) {
                stringBuffer.append(str3);
                stringBuffer.append("\n");
            }
            customLogInfo.mData = stringBuffer;
            CrashApi crashApi = CrashApi.getInstance();
            if (crashApi == null) {
                return;
            }
            crashApi.generateCustomLog(customLogInfo);
        } catch (Throwable unused) {
        }
    }
}

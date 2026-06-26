package com.uc.crashsdk.export;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.webkit.ValueCallback;
import com.uc.crashsdk.JNIBridge;
import com.uc.crashsdk.a.a;
import com.uc.crashsdk.a.d;
import com.uc.crashsdk.a.h;
import com.uc.crashsdk.b;
import com.uc.crashsdk.e;
import com.uc.crashsdk.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: ProGuard */
/* JADX INFO: loaded from: classes.dex */
public class CrashApi {
    private static CrashApi a = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static boolean f4589c = true;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static boolean f4590d = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f4591b;

    private CrashApi(Context context, CustomInfo customInfo, VersionInfo versionInfo, ICrashClient iCrashClient, boolean z, boolean z2, boolean z3) {
        this.f4591b = false;
        Context contextA = a(context);
        b(contextA);
        b.f4555g = z2;
        b.f4556h = z3;
        if (b.I()) {
            b(contextA);
            a(contextA, customInfo, versionInfo, iCrashClient);
            if (z) {
                a();
            }
            if (b.f4555g && e.d("libcrashsdk.so")) {
                b.f4554f = true;
                b();
                return;
            }
            return;
        }
        if (customInfo == null || versionInfo == null) {
            a.d("crashsdk", "VersionInfo and CustomInfo can not be null!");
            throw null;
        }
        g.a(customInfo);
        try {
            e.a(e.d(customInfo.mIsInternational), true);
            a(contextA, customInfo, versionInfo, iCrashClient);
        } catch (Throwable th) {
            a(th);
        }
        if (z) {
            try {
                a();
            } catch (Throwable th2) {
                a(th2);
            }
        }
        try {
            b.J();
            h.a();
            d.a();
            com.uc.crashsdk.a.g.j();
        } catch (Throwable th3) {
            com.uc.crashsdk.a.g.a(th3);
        }
        try {
            if (!b.a(contextA)) {
                a.d("crashsdk", "registerLifecycleCallbacks failed!");
            }
        } catch (Throwable th4) {
            com.uc.crashsdk.a.g.a(th4);
        }
        try {
            com.uc.crashsdk.a.n();
            try {
                e.z();
            } catch (Throwable th5) {
                com.uc.crashsdk.a.g.b(th5);
            }
            e.A();
        } catch (Throwable th6) {
            com.uc.crashsdk.a.g.a(th6);
        }
        try {
            if (g.r() && b.C() && !this.f4591b) {
                e.F();
                this.f4591b = true;
            }
        } catch (Throwable th7) {
            com.uc.crashsdk.a.g.b(th7);
        }
    }

    private static void a() {
        if (b.a) {
            a.b("Has enabled java log!");
            return;
        }
        e.r();
        e.n();
        b.a = true;
    }

    private static void b() {
        synchronized (b.f4553e) {
            if (b.f4555g && b.f4554f) {
                if (b.f4550b) {
                    a.b("Has enabled native log!");
                    return;
                }
                c();
                e.C();
                b.f4550b = true;
                JNIBridge.cmd(6);
                g.d();
            }
        }
    }

    private static void c() {
        if (b.f4552d) {
            return;
        }
        g.b();
        JNIBridge.cmd(5);
        g.c();
        b.f4552d = true;
    }

    public static synchronized CrashApi createInstance(Context context, CustomInfo customInfo, VersionInfo versionInfo, ICrashClient iCrashClient, boolean z, boolean z2, boolean z3) {
        if (a == null) {
            a = new CrashApi(context, customInfo, versionInfo, iCrashClient, z, z2, z3);
        }
        return a;
    }

    public static CrashApi createInstanceEx(Context context, String str, boolean z) {
        return createInstanceEx(context, str, z, null);
    }

    public static CrashApi getInstance() {
        return a;
    }

    public int addCachedInfo(String str, String str2) {
        if (str == null || str2 == null) {
            throw null;
        }
        return com.uc.crashsdk.a.b(str, str2);
    }

    public int addDumpFile(DumpFileInfo dumpFileInfo) {
        String str;
        Objects.requireNonNull(dumpFileInfo);
        String str2 = dumpFileInfo.mCategory;
        if (str2 == null || (str = dumpFileInfo.mFileTobeDump) == null) {
            throw null;
        }
        int i2 = dumpFileInfo.mLogType;
        if ((1048849 & i2) == 0) {
            return 0;
        }
        return com.uc.crashsdk.a.a(str2, str, dumpFileInfo.mIsEncrypted, dumpFileInfo.mWriteCategory, i2, dumpFileInfo.mDeleteAfterDump);
    }

    public void addHeaderInfo(String str, String str2) {
        Objects.requireNonNull(str);
        com.uc.crashsdk.a.a(str, str2);
    }

    public boolean addStatInfo(String str, String str2) {
        if (a("addStatInfo")) {
            return false;
        }
        if (com.uc.crashsdk.a.g.a(str)) {
            throw null;
        }
        if (str.length() > 24) {
            throw new IllegalArgumentException("key is too long!");
        }
        if (str2 != null && str2.length() > 512) {
            str2 = str2.substring(0, 512);
        }
        return h.a(str, str2);
    }

    public void crashSoLoaded() {
        if (a("crashSoLoaded")) {
            return;
        }
        b.f4554f = true;
        b();
        synchronized (b.f4553e) {
            if (b.f4556h && b.f4554f && !b.f4551c) {
                if (!b.f4552d) {
                    c();
                    g.d();
                }
                e.w();
                b.f4551c = true;
            }
        }
        com.uc.crashsdk.a.n();
        e.l();
    }

    public int createCachedInfo(String str, int i2, int i3) {
        Objects.requireNonNull(str);
        if (i2 <= 0) {
            throw new IllegalArgumentException("capacity must > 0!");
        }
        if ((1048849 & i3) == 0) {
            return 0;
        }
        return com.uc.crashsdk.a.a(str, i2, i3);
    }

    public void disableLog(int i2) {
        synchronized (b.f4553e) {
            b.b(i2);
            if (LogType.isForJava(i2) && b.a) {
                e.s();
                b.a = false;
            }
            if (LogType.isForNative(i2)) {
                if (b.f4550b) {
                    JNIBridge.cmd(9);
                    b.f4550b = false;
                } else {
                    b.f4555g = false;
                }
            }
            if (LogType.isForANR(i2)) {
                b.a(false);
            }
            if (LogType.isForUnexp(i2)) {
                if (!b.f4551c) {
                    b.f4556h = false;
                } else if (e.y()) {
                    b.f4551c = false;
                }
            }
        }
    }

    public boolean generateCustomLog(CustomLogInfo customLogInfo) {
        String str;
        StringBuilder sb;
        Objects.requireNonNull(customLogInfo);
        if (customLogInfo.mData == null || (str = customLogInfo.mLogType) == null) {
            throw new NullPointerException("mData or mLogType is null!");
        }
        if (str.contains("_") || customLogInfo.mLogType.contains(" ")) {
            throw new IllegalArgumentException("mLogType can not contain char '_' and ' '");
        }
        ArrayList<Integer> arrayList = customLogInfo.mDumpTids;
        if (arrayList == null || arrayList.size() <= 0) {
            sb = null;
        } else {
            sb = new StringBuilder();
            Iterator<Integer> it = customLogInfo.mDumpTids.iterator();
            while (it.hasNext()) {
                sb.append(it.next().intValue());
                sb.append(" ");
            }
        }
        long j2 = customLogInfo.mAddHeader ? 1L : 0L;
        if (customLogInfo.mAddFooter) {
            j2 |= 2;
        }
        if (customLogInfo.mAddLogcat) {
            j2 |= 4;
        }
        if (customLogInfo.mAddThreadsDump) {
            j2 |= 8;
        }
        if (customLogInfo.mAddBuildId) {
            j2 |= 16;
        }
        if (customLogInfo.mUploadNow) {
            j2 |= 32;
        }
        return e.a(customLogInfo.mData, customLogInfo.mLogType, j2, customLogInfo.mDumpFiles, customLogInfo.mCallbacks, customLogInfo.mCachedInfos, sb != null ? sb.toString() : null);
    }

    public boolean generateTraces(String str, long j2) {
        if (a("generateTraces")) {
            return false;
        }
        if (b.f4552d) {
            return JNIBridge.nativeCmd(12, j2, str, null) == 1;
        }
        a.d("crashsdk", "Crash so is not loaded!");
        return false;
    }

    public String getCrashLogUploadUrl() {
        if (a("getCrashLogUploadUrl")) {
            return null;
        }
        return e.k();
    }

    public ParcelFileDescriptor getHostFd() {
        return e.D();
    }

    public ParcelFileDescriptor getIsolatedHostFd() {
        return e.D();
    }

    public int getLastExitType() {
        if (a("getLastExitType")) {
            return 1;
        }
        return b.F();
    }

    public int getLastExitTypeEx() {
        if (a("getLastExitTypeEx")) {
            return 1;
        }
        return b.G();
    }

    public Throwable getUncaughtException() {
        return e.u();
    }

    public int getUnexpReason() {
        if (a("getUnexpReason")) {
            return 100;
        }
        return e.v();
    }

    public void onExit() {
        b.t();
    }

    public boolean registerCallback(int i2, ValueCallback<Bundle> valueCallback) {
        Objects.requireNonNull(valueCallback);
        if (i2 == 1) {
            return com.uc.crashsdk.d.a(valueCallback);
        }
        if (i2 == 2) {
            return com.uc.crashsdk.d.c(valueCallback);
        }
        if (i2 == 3) {
            return com.uc.crashsdk.d.d(valueCallback);
        }
        if (i2 == 4) {
            return com.uc.crashsdk.d.b(valueCallback);
        }
        throw new IllegalArgumentException("Unknown event type: " + i2);
    }

    public int registerInfoCallback(String str, int i2) {
        Objects.requireNonNull(str);
        if ((1048849 & i2) == 0) {
            return 0;
        }
        return com.uc.crashsdk.a.a(str, i2, null, 0L, 0);
    }

    public int registerThread(int i2, String str) {
        return com.uc.crashsdk.a.a(i2, str);
    }

    public int reportCrashStats(boolean z) {
        if (a("reportCrashStats")) {
            return 0;
        }
        return e.b(z, true);
    }

    public int resetCrashStats(boolean z) {
        if (a("resetCrashStats")) {
            return 0;
        }
        return e.e(z);
    }

    public void setForeground(boolean z) {
        b.b(z);
    }

    public boolean setHostFd(ParcelFileDescriptor parcelFileDescriptor) {
        return e.a(parcelFileDescriptor);
    }

    public boolean setIsolatedHostFd(ParcelFileDescriptor parcelFileDescriptor) {
        return e.a(parcelFileDescriptor);
    }

    public void setNewInstall() {
        if (a("setNewInstall")) {
            return;
        }
        b.s();
    }

    public int updateCustomInfo(CustomInfo customInfo) {
        Objects.requireNonNull(customInfo);
        return g.b(customInfo);
    }

    public boolean updateUnexpInfo() {
        if (a("updateUnexpInfo")) {
            return false;
        }
        return com.uc.crashsdk.a.a(true);
    }

    public void updateVersionInfo(VersionInfo versionInfo) {
        Objects.requireNonNull(versionInfo);
        g.a(versionInfo);
    }

    public void uploadCrashLogs() {
        if (a("uploadCrashLogs")) {
            return;
        }
        e.a(false, true);
    }

    public static CrashApi createInstanceEx(Context context, String str, boolean z, Bundle bundle) {
        return createInstanceEx(context, str, z, bundle, null);
    }

    public static CrashApi createInstanceEx(Context context, String str, boolean z, Bundle bundle, ICrashClient iCrashClient) {
        CrashApi crashApi = a;
        if (crashApi != null) {
            return crashApi;
        }
        if (bundle == null) {
            bundle = new Bundle();
        }
        f4589c = bundle.getBoolean("useApplicationContext", true);
        Context contextA = a(context);
        b(contextA);
        CustomInfo customInfo = new CustomInfo(str);
        customInfo.mEnableStatReport = true;
        customInfo.mZipLog = true;
        customInfo.mPrintStackInfos = z;
        CustomInfo customInfoA = g.a(customInfo, bundle);
        VersionInfo versionInfoA = g.a(bundle);
        boolean z2 = bundle.getBoolean("enableJavaLog", true);
        boolean z3 = bundle.getBoolean("enableNativeLog", true);
        boolean z4 = bundle.getBoolean("enableUnexpLog", b.C());
        boolean z5 = bundle.getBoolean("enableANRLog", true);
        CrashApi crashApiCreateInstance = createInstance(contextA, customInfoA, versionInfoA, iCrashClient, z2, z3, z4);
        b.a(z5);
        if (z3 || z4) {
            if (e.d("libcrashsdk.so")) {
                crashApiCreateInstance.crashSoLoaded();
            } else {
                a.d("crashsdk", "load libcrashsdk.so failed!");
            }
        }
        int i2 = bundle.getInt("uploadLogDelaySeconds", 15);
        if (i2 >= 0 && b.C()) {
            e.b(i2);
        }
        return crashApiCreateInstance;
    }

    public int registerInfoCallback(String str, int i2, Callable<String> callable) {
        if (str == null || callable == null) {
            throw null;
        }
        if ((1048849 & i2) == 0) {
            return 0;
        }
        return com.uc.crashsdk.a.a(str, i2, callable, 0L, 0);
    }

    public int updateCustomInfo(Bundle bundle) {
        Objects.requireNonNull(bundle);
        return updateCustomInfo(g.a((CustomInfo) null, bundle));
    }

    public void updateVersionInfo(Bundle bundle) {
        Objects.requireNonNull(bundle);
        updateVersionInfo(g.a(bundle));
    }

    private static void a(Context context, CustomInfo customInfo, VersionInfo versionInfo, ICrashClient iCrashClient) {
        com.uc.crashsdk.d.a(iCrashClient);
        g.a(customInfo, versionInfo);
        if (b.I()) {
            return;
        }
        e.o();
        e.a(context);
        e.b(context);
    }

    public int addDumpFile(String str, String str2, int i2, Bundle bundle) {
        DumpFileInfo dumpFileInfo = new DumpFileInfo(str, str2, i2);
        if (bundle != null) {
            dumpFileInfo.mIsEncrypted = bundle.getBoolean("mIsEncrypted", dumpFileInfo.mIsEncrypted);
            dumpFileInfo.mWriteCategory = bundle.getBoolean("mWriteCategory", dumpFileInfo.mWriteCategory);
            dumpFileInfo.mDeleteAfterDump = bundle.getBoolean("mDeleteAfterDump", dumpFileInfo.mDeleteAfterDump);
        }
        return addDumpFile(dumpFileInfo);
    }

    private static Context a(Context context) {
        if (context != null) {
            if (!f4589c || (context instanceof Application) || ((context = context.getApplicationContext()) != null && (context instanceof Application))) {
                return context;
            }
            a.d("crashsdk", "Can not get Application context from given context!");
            throw new IllegalArgumentException("Can not get Application context from given context!");
        }
        a.d("crashsdk", "context can not be null!");
        throw null;
    }

    private static void b(Context context) {
        try {
            if (f4590d) {
                return;
            }
            com.uc.crashsdk.a.g.a(context);
            com.uc.crashsdk.a.a = context.getPackageName();
            f4590d = true;
        } catch (Throwable th) {
            a(th);
        }
    }

    private static void a(Throwable th) {
        new e().a(Thread.currentThread(), th, true);
    }

    public boolean generateCustomLog(StringBuffer stringBuffer, String str, Bundle bundle) {
        CustomLogInfo customLogInfo = new CustomLogInfo(stringBuffer, str);
        if (bundle != null) {
            customLogInfo.mAddHeader = bundle.getBoolean("mAddHeader", customLogInfo.mAddHeader);
            customLogInfo.mAddFooter = bundle.getBoolean("mAddFooter", customLogInfo.mAddFooter);
            customLogInfo.mAddLogcat = bundle.getBoolean("mAddLogcat", customLogInfo.mAddLogcat);
            customLogInfo.mUploadNow = bundle.getBoolean("mUploadNow", customLogInfo.mUploadNow);
            customLogInfo.mAddThreadsDump = bundle.getBoolean("mAddThreadsDump", customLogInfo.mAddThreadsDump);
            customLogInfo.mAddBuildId = bundle.getBoolean("mAddBuildId", customLogInfo.mAddBuildId);
            customLogInfo.mDumpFiles = bundle.getStringArrayList("mDumpFiles");
            customLogInfo.mCallbacks = bundle.getStringArrayList("mCallbacks");
            customLogInfo.mCachedInfos = bundle.getStringArrayList("mCachedInfos");
            customLogInfo.mDumpTids = bundle.getIntegerArrayList("mDumpTids");
        }
        return generateCustomLog(customLogInfo);
    }

    private static boolean a(String str) {
        if (!b.I()) {
            return false;
        }
        a.d("crashsdk", "Can not call '" + str + "' in isolated process!");
        return true;
    }
}

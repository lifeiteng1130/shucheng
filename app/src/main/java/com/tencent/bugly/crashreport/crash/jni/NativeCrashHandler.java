package com.tencent.bugly.crashreport.crash.jni;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import androidx.room.RoomDatabase;
import com.tencent.bugly.crashreport.crash.e;
import com.tencent.bugly.crashreport.crash.h;
import com.tencent.bugly.proguard.W;
import com.tencent.bugly.proguard.X;
import com.tencent.bugly.proguard.ca;
import com.umeng.commonsdk.statistics.SdkVersion;
import java.io.File;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes.dex */
public class NativeCrashHandler implements com.tencent.bugly.crashreport.b {
    private static NativeCrashHandler a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static int f4215b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static boolean f4216c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static boolean f4217d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static boolean f4218e = true;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Context f4219f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final com.tencent.bugly.crashreport.common.info.a f4220g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final W f4221h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private NativeExceptionHandler f4222i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f4223j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final boolean f4224k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f4225l = false;
    private boolean m = false;
    private boolean n = false;
    private boolean o = false;
    private e p;

    @SuppressLint({"SdCardPath"})
    public NativeCrashHandler(Context context, com.tencent.bugly.crashreport.common.info.a aVar, e eVar, com.tencent.bugly.crashreport.common.strategy.c cVar, W w, boolean z, String str) {
        this.f4219f = ca.a(context);
        try {
            if (ca.b(str)) {
                str = context.getDir("bugly", 0).getAbsolutePath();
            }
        } catch (Throwable unused) {
            str = c.a.a.a.a.k("/data/data/", com.tencent.bugly.crashreport.common.info.a.a(context).f4098g, "/app_bugly");
        }
        this.p = eVar;
        this.f4223j = str;
        this.f4220g = aVar;
        this.f4221h = w;
        this.f4224k = z;
        this.f4222i = new b(context, aVar, eVar, com.tencent.bugly.crashreport.common.strategy.c.b());
    }

    public static synchronized NativeCrashHandler getInstance(Context context, com.tencent.bugly.crashreport.common.info.a aVar, e eVar, com.tencent.bugly.crashreport.common.strategy.c cVar, W w, boolean z, String str) {
        if (a == null) {
            a = new NativeCrashHandler(context, aVar, eVar, cVar, w, z, str);
        }
        return a;
    }

    public static boolean isShouldHandleInJava() {
        return f4218e;
    }

    public static void setShouldHandleInJava(boolean z) {
        f4218e = z;
        NativeCrashHandler nativeCrashHandler = a;
        if (nativeCrashHandler != null) {
            nativeCrashHandler.a(RoomDatabase.MAX_BIND_PARAMETER_CNT, "" + z);
        }
    }

    @Override // com.tencent.bugly.crashreport.b
    public boolean appendLogToNative(String str, String str2, String str3) {
        if ((this.f4225l || this.m) && f4216c && str != null && str2 != null && str3 != null) {
            try {
                if (this.m) {
                    return appendNativeLog(str, str2, str3);
                }
                Boolean bool = (Boolean) ca.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "appendNativeLog", null, new Class[]{String.class, String.class, String.class}, new Object[]{str, str2, str3});
                if (bool != null) {
                    return bool.booleanValue();
                }
                return false;
            } catch (UnsatisfiedLinkError unused) {
                f4216c = false;
            } catch (Throwable th) {
                if (!X.b(th)) {
                    th.printStackTrace();
                }
                return false;
            }
        }
        return false;
    }

    public native boolean appendNativeLog(String str, String str2, String str3);

    public native boolean appendWholeNativeLog(String str);

    public void checkUploadRecordCrash() {
        this.f4221h.a(new a(this));
    }

    public void dumpAnrNativeStack() {
        a(19, SdkVersion.MINI_VERSION);
    }

    public void enableCatchAnrTrace() {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 > 30 || i2 < 23) {
            return;
        }
        f4215b |= 2;
    }

    public boolean filterSigabrtSysLog() {
        return a(998, "true");
    }

    public synchronized String getDumpFilePath() {
        return this.f4223j;
    }

    @Override // com.tencent.bugly.crashreport.b
    public String getLogFromNative() {
        if ((!this.f4225l && !this.m) || !f4216c) {
            return null;
        }
        try {
            return this.m ? getNativeLog() : (String) ca.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "getNativeLog", null, null, null);
        } catch (UnsatisfiedLinkError unused) {
            f4216c = false;
            return null;
        } catch (Throwable th) {
            if (!X.b(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    public NativeExceptionHandler getNativeExceptionHandler() {
        return this.f4222i;
    }

    public native String getNativeKeyValueList();

    public native String getNativeLog();

    public boolean isEnableCatchAnrTrace() {
        return (f4215b & 2) == 2;
    }

    public synchronized boolean isUserOpened() {
        return this.o;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x002f A[Catch: all -> 0x0041, TRY_LEAVE, TryCatch #0 {, blocks: (B:5:0x0005, B:7:0x000b, B:8:0x0018, B:10:0x0024, B:14:0x002b, B:16:0x002f), top: B:22:0x0005 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized void onStrategyChanged(com.tencent.bugly.crashreport.common.strategy.StrategyBean r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            r0 = 0
            r1 = 1
            if (r4 == 0) goto L18
            boolean r4 = r4.f4112f     // Catch: java.lang.Throwable -> L41
            boolean r2 = r3.n     // Catch: java.lang.Throwable -> L41
            if (r4 == r2) goto L18
            java.lang.Object[] r2 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L41
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)     // Catch: java.lang.Throwable -> L41
            r2[r0] = r4     // Catch: java.lang.Throwable -> L41
            java.lang.String r4 = "server native changed to %b"
            com.tencent.bugly.proguard.X.e(r4, r2)     // Catch: java.lang.Throwable -> L41
        L18:
            com.tencent.bugly.crashreport.common.strategy.c r4 = com.tencent.bugly.crashreport.common.strategy.c.b()     // Catch: java.lang.Throwable -> L41
            com.tencent.bugly.crashreport.common.strategy.StrategyBean r4 = r4.c()     // Catch: java.lang.Throwable -> L41
            boolean r4 = r4.f4112f     // Catch: java.lang.Throwable -> L41
            if (r4 == 0) goto L2a
            boolean r4 = r3.o     // Catch: java.lang.Throwable -> L41
            if (r4 == 0) goto L2a
            r4 = 1
            goto L2b
        L2a:
            r4 = 0
        L2b:
            boolean r2 = r3.n     // Catch: java.lang.Throwable -> L41
            if (r4 == r2) goto L3f
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L41
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r4)     // Catch: java.lang.Throwable -> L41
            r1[r0] = r2     // Catch: java.lang.Throwable -> L41
            java.lang.String r0 = "native changed to %b"
            com.tencent.bugly.proguard.X.c(r0, r1)     // Catch: java.lang.Throwable -> L41
            r3.b(r4)     // Catch: java.lang.Throwable -> L41
        L3f:
            monitor-exit(r3)
            return
        L41:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler.onStrategyChanged(com.tencent.bugly.crashreport.common.strategy.StrategyBean):void");
    }

    public boolean putKeyValueToNative(String str, String str2) {
        if ((this.f4225l || this.m) && f4216c && str != null && str2 != null) {
            try {
                if (this.m) {
                    return putNativeKeyValue(str, str2);
                }
                Boolean bool = (Boolean) ca.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "putNativeKeyValue", null, new Class[]{String.class, String.class}, new Object[]{str, str2});
                if (bool != null) {
                    return bool.booleanValue();
                }
                return false;
            } catch (UnsatisfiedLinkError unused) {
                f4216c = false;
            } catch (Throwable th) {
                if (!X.b(th)) {
                    th.printStackTrace();
                }
                return false;
            }
        }
        return false;
    }

    public native boolean putNativeKeyValue(String str, String str2);

    public native String regist(String str, boolean z, int i2);

    public void removeEmptyNativeRecordFiles() {
        c.b(this.f4223j);
    }

    public native String removeNativeKeyValue(String str);

    public synchronized void setDumpFilePath(String str) {
        this.f4223j = str;
    }

    public boolean setNativeAppChannel(String str) {
        return a(12, str);
    }

    public boolean setNativeAppPackage(String str) {
        return a(13, str);
    }

    public boolean setNativeAppVersion(String str) {
        return a(10, str);
    }

    public native void setNativeInfo(int i2, String str);

    @Override // com.tencent.bugly.crashreport.b
    public boolean setNativeIsAppForeground(boolean z) {
        return a(14, z ? "true" : "false");
    }

    public boolean setNativeLaunchTime(long j2) {
        try {
            return a(15, String.valueOf(j2));
        } catch (NumberFormatException e2) {
            if (X.b(e2)) {
                return false;
            }
            e2.printStackTrace();
            return false;
        }
    }

    public boolean setNativeUserId(String str) {
        return a(11, str);
    }

    public synchronized void setUserOpened(boolean z) {
        c(z);
        boolean zIsUserOpened = isUserOpened();
        com.tencent.bugly.crashreport.common.strategy.c cVarB = com.tencent.bugly.crashreport.common.strategy.c.b();
        if (cVarB != null) {
            zIsUserOpened = zIsUserOpened && cVarB.c().f4112f;
        }
        if (zIsUserOpened != this.n) {
            X.c("native changed to %b", Boolean.valueOf(zIsUserOpened));
            b(zIsUserOpened);
        }
    }

    public synchronized void startNativeMonitor() {
        if (!this.m && !this.f4225l) {
            String str = "Bugly";
            boolean z = !ca.b(this.f4220g.L);
            if (h.f4184b) {
                boolean zA = a(z ? this.f4220g.L : "Bugly-rqd", z);
                this.m = zA;
                if (!zA && !z) {
                    this.f4225l = a("NativeRQD", false);
                }
            } else {
                String str2 = this.f4220g.L;
                if (z) {
                    str = str2;
                }
                this.m = a(str, z);
            }
            if (this.m || this.f4225l) {
                a(this.f4224k);
                if (f4216c) {
                    setNativeAppVersion(this.f4220g.E);
                    setNativeAppChannel(this.f4220g.I);
                    setNativeAppPackage(this.f4220g.f4098g);
                    setNativeUserId(this.f4220g.y());
                    setNativeIsAppForeground(this.f4220g.C());
                    setNativeLaunchTime(this.f4220g.f4095d);
                }
                return;
            }
            return;
        }
        a(this.f4224k);
    }

    public native void testCrash();

    public void testNativeCrash() {
        if (this.m) {
            testCrash();
        } else {
            X.e("[Native] Bugly SO file has not been load.", new Object[0]);
        }
    }

    public native String unregist();

    public void b() {
        long jB = ca.b() - h.f4189g;
        long jB2 = ca.b() + 86400000;
        File file = new File(this.f4223j);
        if (file.exists() && file.isDirectory()) {
            try {
                File[] fileArrListFiles = file.listFiles();
                if (fileArrListFiles != null && fileArrListFiles.length != 0) {
                    int i2 = 0;
                    int i3 = 0;
                    for (File file2 : fileArrListFiles) {
                        long jLastModified = file2.lastModified();
                        if (jLastModified < jB || jLastModified >= jB2) {
                            X.c("[Native] Delete record file: %s", file2.getAbsolutePath());
                            i2++;
                            if (file2.delete()) {
                                i3++;
                            }
                        }
                    }
                    X.a("[Native] Number of record files overdue: %d, has deleted: %d", Integer.valueOf(i2), Integer.valueOf(i3));
                }
            } catch (Throwable th) {
                X.b(th);
            }
        }
    }

    public synchronized void c() {
        if (!this.n) {
            X.e("[Native] Native crash report has already unregistered.", new Object[0]);
            return;
        }
        try {
        } catch (Throwable unused) {
            X.a("[Native] Failed to close native crash report.", new Object[0]);
        }
        if (unregist() != null) {
            X.c("[Native] Successfully closed native crash report.", new Object[0]);
            this.n = false;
            return;
        }
        try {
            ca.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "enableHandler", null, new Class[]{Boolean.TYPE}, new Object[]{Boolean.FALSE});
            this.n = false;
            X.c("[Native] Successfully closed native crash report.", new Object[0]);
            return;
        } catch (Throwable unused2) {
            X.a("[Native] Failed to close native crash report.", new Object[0]);
            this.m = false;
            this.f4225l = false;
            return;
        }
    }

    private static void a(String str) {
        X.a("[Native] Check extra jni for Bugly NDK v%s", str);
        String strReplace = "2.1.1".replace(".", "");
        String strReplace2 = "2.3.0".replace(".", "");
        String strReplace3 = str.replace(".", "");
        if (strReplace3.length() == 2) {
            strReplace3 = c.a.a.a.a.i(strReplace3, "0");
        } else if (strReplace3.length() == 1) {
            strReplace3 = c.a.a.a.a.i(strReplace3, "00");
        }
        try {
            if (Integer.parseInt(strReplace3) >= Integer.parseInt(strReplace)) {
                f4216c = true;
            }
            if (Integer.parseInt(strReplace3) >= Integer.parseInt(strReplace2)) {
                f4217d = true;
            }
        } catch (Throwable unused) {
        }
        if (f4217d) {
            X.c("[Native] Info setting jni can be accessed.", new Object[0]);
        } else {
            X.e("[Native] Info setting jni can not be accessed.", new Object[0]);
        }
        if (f4216c) {
            X.c("[Native] Extra jni can be accessed.", new Object[0]);
        } else {
            X.e("[Native] Extra jni can not be accessed.", new Object[0]);
        }
    }

    public static synchronized NativeCrashHandler getInstance() {
        return a;
    }

    public void testNativeCrash(boolean z, boolean z2, boolean z3) {
        a(16, "" + z);
        a(17, "" + z2);
        a(18, "" + z3);
        testNativeCrash();
    }

    private synchronized void c(boolean z) {
        if (this.o != z) {
            X.c("user change native %b", Boolean.valueOf(z));
            this.o = z;
        }
    }

    public synchronized void b(boolean z) {
        if (z) {
            startNativeMonitor();
        } else {
            c();
        }
    }

    public synchronized void a(boolean z) {
        if (this.n) {
            X.e("[Native] Native crash report has already registered.", new Object[0]);
            return;
        }
        if (this.m) {
            try {
                String strRegist = regist(this.f4223j, z, f4215b);
                if (strRegist != null) {
                    X.c("[Native] Native Crash Report enable.", new Object[0]);
                    a(strRegist);
                    this.f4220g.M = strRegist;
                    String strConcat = "-".concat(strRegist);
                    if (!h.f4184b && !this.f4220g.f4103l.contains(strConcat)) {
                        com.tencent.bugly.crashreport.common.info.a aVar = this.f4220g;
                        aVar.f4103l = aVar.f4103l.concat("-").concat(this.f4220g.M);
                    }
                    X.c("comInfo.sdkVersion %s", this.f4220g.f4103l);
                    this.n = true;
                    return;
                }
            } catch (Throwable unused) {
                X.a("[Native] Failed to load Bugly SO file.", new Object[0]);
            }
        } else if (this.f4225l) {
            try {
                Class cls = Integer.TYPE;
                Class[] clsArr = {String.class, String.class, cls, cls};
                Object[] objArr = new Object[4];
                objArr[0] = this.f4223j;
                objArr[1] = com.tencent.bugly.crashreport.common.info.b.a(this.f4219f, false);
                objArr[2] = Integer.valueOf(z ? 1 : 5);
                objArr[3] = 1;
                String str = (String) ca.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "registNativeExceptionHandler2", null, clsArr, objArr);
                if (str == null) {
                    str = (String) ca.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "registNativeExceptionHandler", null, new Class[]{String.class, String.class, cls}, new Object[]{this.f4223j, com.tencent.bugly.crashreport.common.info.b.a(this.f4219f, false), Integer.valueOf(com.tencent.bugly.crashreport.common.info.a.m().d())});
                }
                if (str != null) {
                    this.n = true;
                    this.f4220g.M = str;
                    Boolean bool = (Boolean) ca.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "checkExtraJni", null, new Class[]{String.class}, new Object[]{str});
                    if (bool != null) {
                        f4216c = bool.booleanValue();
                    }
                    ca.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "enableHandler", null, new Class[]{Boolean.TYPE}, new Object[]{Boolean.TRUE});
                    ca.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "setLogMode", null, new Class[]{cls}, new Object[]{Integer.valueOf(z ? 1 : 5)});
                    return;
                }
            } catch (Throwable unused2) {
            }
        }
        this.m = false;
        this.f4225l = false;
    }

    private boolean a(String str, boolean z) {
        boolean z2;
        try {
            X.c("[Native] Trying to load so: %s", str);
            if (z) {
                System.load(str);
            } else {
                System.loadLibrary(str);
            }
        } catch (Throwable th) {
            th = th;
            z2 = false;
        }
        try {
            X.c("[Native] Successfully loaded SO: %s", str);
            return true;
        } catch (Throwable th2) {
            th = th2;
            z2 = true;
            X.e(th.getMessage(), new Object[0]);
            X.e("[Native] Failed to load so: %s", str);
            return z2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(int i2, String str) {
        if (this.m && f4217d) {
            try {
                setNativeInfo(i2, str);
                return true;
            } catch (UnsatisfiedLinkError unused) {
                f4217d = false;
            } catch (Throwable th) {
                if (!X.b(th)) {
                    th.printStackTrace();
                }
                return false;
            }
        }
        return false;
    }
}

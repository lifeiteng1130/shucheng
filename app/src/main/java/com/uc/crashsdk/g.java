package com.uc.crashsdk;

import android.os.Build;
import android.os.Bundle;
import androidx.recyclerview.widget.RecyclerView;
import com.uc.crashsdk.export.CustomInfo;
import com.uc.crashsdk.export.VersionInfo;
import java.io.File;
import java.lang.reflect.Field;
import java.util.zip.ZipFile;

/* JADX INFO: compiled from: ProGuard */
/* JADX INFO: loaded from: classes.dex */
public class g {
    public static RuntimeException a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static RuntimeException f4597b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ boolean f4598c = true;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static CustomInfo f4599d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static VersionInfo f4600e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static String f4602g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static String f4603h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static String f4604i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static String f4605j;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Object f4601f = new Object();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final Object f4606k = new Object();

    public static long A() {
        return f4599d.mMaxUploadBytesPerDay;
    }

    public static int B() {
        return f4599d.mMaxUploadBuiltinLogCountPerDay;
    }

    public static int C() {
        return f4599d.mMaxUploadCustomLogCountPerDay;
    }

    public static int D() {
        return f4599d.mMaxCustomLogCountPerTypePerDay;
    }

    public static int E() {
        return f4599d.mInfoUpdateInterval;
    }

    public static int F() {
        return f4599d.mInfoSaveFrequency;
    }

    public static int G() {
        return f4599d.mReservedJavaFileHandleCount;
    }

    public static int H() {
        return f4599d.mFdDumpMinLimit;
    }

    public static int I() {
        return f4599d.mThreadsDumpMinLimit;
    }

    public static boolean J() {
        return f4599d.mAutoDetectLifeCycle;
    }

    public static boolean K() {
        return f4599d.mMonitorBattery;
    }

    public static int L() {
        return f4599d.mAnrTraceStrategy;
    }

    public static boolean M() {
        CustomInfo customInfo = f4599d;
        return customInfo == null || customInfo.mDebug;
    }

    public static boolean N() {
        CustomInfo customInfo = f4599d;
        return customInfo == null || customInfo.mPrintStackInfos;
    }

    public static boolean O() {
        return f4599d.mEnableStatReport;
    }

    public static boolean P() {
        return f4599d.mIsInternational;
    }

    public static boolean Q() {
        return f4599d.mAddPvForNewDay;
    }

    public static String R() {
        return com.uc.crashsdk.a.g.a(f4600e.mVersion) ? a.a() : a(f4600e.mVersion);
    }

    public static String S() {
        return com.uc.crashsdk.a.g.a(f4600e.mSubVersion) ? "release" : f4600e.mSubVersion;
    }

    public static String T() {
        return com.uc.crashsdk.a.g.a(f4600e.mBuildId) ? X() : a(f4600e.mBuildId);
    }

    public static String U() {
        if (f4603h == null) {
            f4603h = com.uc.crashsdk.a.g.b() + File.separatorChar + f4599d.mTagFilesFolderName + File.separatorChar;
        }
        return f4603h;
    }

    public static String V() {
        if (f4604i == null) {
            f4604i = com.uc.crashsdk.a.g.b() + File.separatorChar + f4599d.mCrashLogsFolderName + File.separatorChar;
        }
        return f4604i;
    }

    public static String W() {
        if (f4605j == null) {
            if (com.uc.crashsdk.a.g.a(f4599d.mLogsBackupPathName)) {
                StringBuilder sbR = c.a.a.a.a.r(com.uc.crashsdk.a.g.b() + File.separatorChar + "msdb" + File.separatorChar);
                sbR.append(File.separatorChar);
                sbR.append(f4599d.mCrashLogsFolderName);
                sbR.append(File.separatorChar);
                f4605j = sbR.toString();
            } else {
                String strTrim = f4599d.mLogsBackupPathName.trim();
                String str = File.separator;
                if (!strTrim.endsWith(str)) {
                    strTrim = c.a.a.a.a.i(strTrim, str);
                }
                f4605j = strTrim;
            }
        }
        return f4605j;
    }

    private static String X() {
        ZipFile zipFile;
        Throwable th;
        String str = f4602g;
        if (str != null) {
            return str;
        }
        try {
            try {
                zipFile = new ZipFile(com.uc.crashsdk.a.g.c());
                try {
                    f4602g = Long.toHexString(zipFile.getEntry("classes.dex").getCrc());
                    com.uc.crashsdk.a.a.a("crashsdk", "version unique build id: " + f4602g);
                    zipFile.close();
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        f4602g = "";
                        com.uc.crashsdk.a.g.a(th);
                        if (zipFile != null) {
                            zipFile.close();
                        }
                        return f4602g;
                    } catch (Throwable th3) {
                        if (zipFile != null) {
                            try {
                                zipFile.close();
                            } catch (Throwable unused) {
                            }
                        }
                        throw th3;
                    }
                }
            } catch (Throwable unused2) {
            }
        } catch (Throwable th4) {
            zipFile = null;
            th = th4;
        }
        return f4602g;
    }

    private static void Y() {
        if (b.f4552d) {
            JNIBridge.nativeSet(24, 1L, a.f4493b, null);
        }
    }

    public static void a(CustomInfo customInfo, VersionInfo versionInfo) {
        CustomInfo customInfo2 = new CustomInfo(customInfo);
        f4599d = customInfo2;
        c(customInfo2);
        if (!f4599d.mZipLog) {
            a = new RuntimeException("initialize set mZipLog to false, info.mZipLog: " + customInfo.mZipLog);
        }
        if (f4599d.mEncryptLog) {
            f4597b = new RuntimeException("initialize set mEncryptLog to true, info.mEncryptLog: " + customInfo.mEncryptLog);
        }
        f4600e = new VersionInfo(versionInfo);
        if (b.I()) {
            return;
        }
        try {
            a();
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
        }
    }

    public static void b() {
        JNIBridge.set(103, com.uc.crashsdk.a.g.b());
        JNIBridge.set(104, f4599d.mTagFilesFolderName);
        JNIBridge.set(105, f4599d.mCrashLogsFolderName);
        JNIBridge.set(106, W());
        JNIBridge.set(107, e.h());
        JNIBridge.set(108, b.a());
        JNIBridge.set(109, R());
        JNIBridge.set(110, S());
        JNIBridge.set(111, T());
        JNIBridge.set(112, "210105150455");
        JNIBridge.set(116, Build.MODEL);
        JNIBridge.set(117, Build.VERSION.RELEASE);
        JNIBridge.set(118, e.p());
        JNIBridge.set(5, f4599d.mCallNativeDefaultHandler);
        JNIBridge.set(6, f4599d.mDumpUserSolibBuildId);
        JNIBridge.set(7, f4599d.mReservedNativeMemoryBytes);
        JNIBridge.set(100, f4599d.mNativeCrashLogFileName);
        JNIBridge.set(101, f4599d.mUnexpCrashLogFileName);
        JNIBridge.set(102, f4599d.mAppId);
    }

    private static void c(CustomInfo customInfo) {
        if (customInfo.mZippedLogExtension == null) {
            customInfo.mZippedLogExtension = "";
        }
        if (customInfo.mZippedLogExtension.equals(".tmp")) {
            throw new IllegalArgumentException("mZippedLogExtension can not be '.tmp'!");
        }
        if (customInfo.mOmitJavaCrash) {
            customInfo.mCallJavaDefaultHandler = false;
        }
        if (customInfo.mOmitNativeCrash) {
            customInfo.mCallNativeDefaultHandler = false;
        }
        long jB = e.b();
        if (jB >= 1) {
            customInfo.mMaxBuiltinLogFilesCount = 200;
            customInfo.mMaxCustomLogFilesCount = 100;
            customInfo.mMaxUploadBytesPerDay = 268435456L;
            customInfo.mMaxUploadBuiltinLogCountPerDay = RecyclerView.MAX_SCROLL_DURATION;
            customInfo.mMaxUploadCustomLogCountPerDay = RecyclerView.MAX_SCROLL_DURATION;
            customInfo.mMaxCustomLogCountPerTypePerDay = 100;
            customInfo.mMaxAnrLogCountPerProcess = 100;
            customInfo.mAnrTraceStrategy = 2;
            if (jB >= 2) {
                customInfo.mSyncUploadSetupCrashLogs = true;
                customInfo.mSyncUploadLogs = true;
                if (jB >= 3) {
                    customInfo.mBackupLogs = true;
                    customInfo.mPrintStackInfos = true;
                    customInfo.mDebug = true;
                }
            }
        }
    }

    public static void d() {
        JNIBridge.set(23, f4599d.mIsInternational);
        if (b.E()) {
            JNIBridge.set(34, true);
        }
        if (e.i()) {
            JNIBridge.set(1, true);
        }
        JNIBridge.set(10, f4599d.mFdDumpMinLimit);
        JNIBridge.nativeCmd(3, f4599d.mReservedNativeFileHandleCount, null, null);
        JNIBridge.nativeSetForeground(b.y());
        JNIBridge.set(2, b.C());
        a.e();
        a.g();
        a.i();
        a.k();
        JNIBridge.set(113, a.a);
        JNIBridge.cmd(1);
        JNIBridge.set(22, f4599d.mThreadsDumpMinLimit);
        JNIBridge.set(122, a.a());
        JNIBridge.set(33, a.c());
        Y();
        b.H();
        b.A();
        com.uc.crashsdk.a.g.k();
    }

    public static String e() {
        return f4599d.mAppId;
    }

    public static boolean f() {
        if (com.uc.crashsdk.a.g.b(f4599d.mJavaCrashLogFileName) || com.uc.crashsdk.a.g.b(f4599d.mNativeCrashLogFileName)) {
            return true;
        }
        return com.uc.crashsdk.a.g.b(f4599d.mUnexpCrashLogFileName);
    }

    public static String g() {
        return f4599d.mJavaCrashLogFileName;
    }

    public static int h() {
        return f4599d.mCrashRestartInterval;
    }

    public static boolean i() {
        return f4599d.mCallJavaDefaultHandler;
    }

    public static boolean j() {
        return f4599d.mDumpHprofDataForJavaOOM;
    }

    public static boolean k() {
        return f4599d.mRenameFileToDefaultName;
    }

    public static int l() {
        return f4599d.mMaxBuiltinLogFilesCount;
    }

    public static int m() {
        return f4599d.mMaxCustomLogFilesCount;
    }

    public static int n() {
        return f4599d.mMaxJavaLogcatLineCount;
    }

    public static int o() {
        return f4599d.mUnexpDelayMillSeconds;
    }

    public static int p() {
        return f4599d.mUnexpSubTypes;
    }

    public static boolean q() {
        return f4599d.mBackupLogs;
    }

    public static boolean r() {
        return f4599d.mSyncUploadSetupCrashLogs;
    }

    public static boolean s() {
        return f4599d.mSyncUploadLogs;
    }

    public static boolean t() {
        return f4599d.mOmitJavaCrash;
    }

    public static boolean u() {
        return f4599d.mAutoDeleteOldVersionStats;
    }

    public static boolean v() {
        return f4599d.mZipLog;
    }

    public static String w() {
        return f4599d.mZippedLogExtension;
    }

    public static boolean x() {
        return f4599d.mEncryptLog;
    }

    public static int y() {
        return f4599d.mLogMaxBytesLimit;
    }

    public static int z() {
        return f4599d.mLogMaxUploadBytesLimit;
    }

    public static void a(CustomInfo customInfo) {
        boolean z = f4598c;
        if (!z && customInfo.mTagFilesFolderName == null) {
            throw new AssertionError();
        }
        if (!z && customInfo.mCrashLogsFolderName == null) {
            throw new AssertionError();
        }
        if (customInfo.mTagFilesFolderName.equals(customInfo.mCrashLogsFolderName)) {
            throw new IllegalArgumentException("mTagFilesFolderName and mCrashLogsFolderName can not be set to the same!");
        }
    }

    public static void a(VersionInfo versionInfo) {
        synchronized (f4601f) {
            f4600e = new VersionInfo(versionInfo);
            e.c();
            if (b.f4552d) {
                JNIBridge.set(109, R());
                JNIBridge.set(110, S());
                JNIBridge.set(111, T());
                JNIBridge.set(112, "210105150455");
                JNIBridge.cmd(2);
            }
        }
    }

    public static void a() {
        b.v();
        b.u();
        if (f4599d.mBackupLogs) {
            File file = new File(W());
            if (file.exists()) {
                return;
            }
            file.mkdirs();
        }
    }

    public static int b(CustomInfo customInfo) {
        int i2;
        int i3;
        boolean z;
        boolean z2;
        synchronized (f4606k) {
            i2 = 0;
            if (customInfo != null) {
                c(customInfo);
                if (f4599d == null) {
                    f4599d = new CustomInfo();
                }
                CustomInfo customInfo2 = f4599d;
                boolean z3 = true;
                if (a(customInfo.mAppId, customInfo2.mAppId)) {
                    i3 = 0;
                    z = false;
                } else {
                    String str = customInfo.mAppId;
                    customInfo2.mAppId = str;
                    if (b.f4552d) {
                        JNIBridge.set(102, str);
                    }
                    i3 = 1;
                    z = true;
                }
                if (!a(customInfo.mJavaCrashLogFileName, customInfo2.mJavaCrashLogFileName)) {
                    customInfo2.mJavaCrashLogFileName = customInfo.mJavaCrashLogFileName;
                    i3++;
                }
                if (!a(customInfo.mNativeCrashLogFileName, customInfo2.mNativeCrashLogFileName)) {
                    String str2 = customInfo.mNativeCrashLogFileName;
                    customInfo2.mNativeCrashLogFileName = str2;
                    if (b.f4552d) {
                        JNIBridge.set(100, str2);
                    }
                    i3++;
                    z = true;
                }
                if (!a(customInfo.mUnexpCrashLogFileName, customInfo2.mUnexpCrashLogFileName)) {
                    String str3 = customInfo.mUnexpCrashLogFileName;
                    customInfo2.mUnexpCrashLogFileName = str3;
                    if (b.f4552d) {
                        JNIBridge.set(101, str3);
                    }
                    i3++;
                    z = true;
                }
                if (z) {
                    e.c();
                    if (b.f4552d) {
                        JNIBridge.cmd(2);
                    }
                }
                boolean z4 = customInfo2.mPrintStackInfos;
                boolean z5 = customInfo.mPrintStackInfos;
                if (z4 != z5) {
                    customInfo2.mPrintStackInfos = z5;
                    if (b.f4552d) {
                        JNIBridge.set(11, z5);
                    }
                    i3++;
                }
                boolean z6 = customInfo2.mDebug;
                boolean z7 = customInfo.mDebug;
                if (z6 != z7) {
                    customInfo2.mDebug = z7;
                    if (b.f4552d) {
                        JNIBridge.set(18, z7);
                    }
                    i3++;
                }
                boolean z8 = customInfo2.mBackupLogs;
                boolean z9 = customInfo.mBackupLogs;
                if (z8 != z9) {
                    customInfo2.mBackupLogs = z9;
                    if (b.f4552d) {
                        JNIBridge.set(12, z9);
                    }
                    i3++;
                }
                boolean z10 = customInfo2.mOmitNativeCrash;
                boolean z11 = customInfo.mOmitNativeCrash;
                if (z10 != z11) {
                    customInfo2.mOmitNativeCrash = z11;
                    if (b.f4552d) {
                        JNIBridge.set(21, z11);
                    }
                    i3++;
                }
                int i4 = customInfo2.mCrashRestartInterval;
                int i5 = customInfo.mCrashRestartInterval;
                if (i4 != i5) {
                    customInfo2.mCrashRestartInterval = i5;
                    if (b.f4552d) {
                        JNIBridge.set(13, i5);
                    }
                    if (customInfo2.mCrashRestartInterval >= 0) {
                        b.J();
                    }
                    i3++;
                }
                int i6 = customInfo2.mMaxBuiltinLogFilesCount;
                int i7 = customInfo.mMaxBuiltinLogFilesCount;
                if (i6 != i7) {
                    customInfo2.mMaxBuiltinLogFilesCount = i7;
                    if (b.f4552d) {
                        JNIBridge.set(14, i7);
                    }
                    i3++;
                }
                int i8 = customInfo2.mMaxNativeLogcatLineCount;
                int i9 = customInfo.mMaxNativeLogcatLineCount;
                if (i8 != i9) {
                    customInfo2.mMaxNativeLogcatLineCount = i9;
                    if (b.f4552d) {
                        JNIBridge.set(15, i9);
                    }
                    i3++;
                }
                int i10 = customInfo2.mMaxJavaLogcatLineCount;
                int i11 = customInfo.mMaxJavaLogcatLineCount;
                if (i10 != i11) {
                    customInfo2.mMaxJavaLogcatLineCount = i11;
                    i3++;
                }
                int i12 = customInfo2.mMaxUnexpLogcatLineCount;
                int i13 = customInfo.mMaxUnexpLogcatLineCount;
                if (i12 != i13) {
                    customInfo2.mMaxUnexpLogcatLineCount = i13;
                    if (b.f4552d) {
                        JNIBridge.set(16, i13);
                    }
                    i3++;
                }
                int i14 = customInfo2.mMaxAnrLogcatLineCount;
                int i15 = customInfo.mMaxAnrLogcatLineCount;
                if (i14 != i15) {
                    customInfo2.mMaxAnrLogcatLineCount = i15;
                    if (b.f4552d) {
                        JNIBridge.set(31, i15);
                    }
                    i3++;
                }
                boolean z12 = customInfo2.mZipLog;
                boolean z13 = customInfo.mZipLog;
                if (z12 != z13) {
                    customInfo2.mZipLog = z13;
                    if (!z13) {
                        com.uc.crashsdk.a.a.d("DEBUG", "updateCustomInfoImpl set mZipLog to false");
                        a = new RuntimeException("updateCustomInfoImpl set mZipLog to false");
                    }
                    i3++;
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (a(customInfo.mZippedLogExtension, customInfo2.mZippedLogExtension)) {
                    z3 = z2;
                } else {
                    customInfo2.mZippedLogExtension = customInfo.mZippedLogExtension;
                    i3++;
                }
                if (z3 && b.f4552d) {
                    JNIBridge.nativeSet(3, customInfo2.mZipLog ? 1L : 0L, customInfo2.mZippedLogExtension, null);
                }
                int i16 = customInfo2.mLogMaxBytesLimit;
                int i17 = customInfo.mLogMaxBytesLimit;
                if (i16 != i17) {
                    customInfo2.mLogMaxBytesLimit = i17;
                    if (b.f4552d) {
                        JNIBridge.set(4, i17);
                    }
                    i3++;
                }
                boolean z14 = customInfo2.mEncryptLog;
                boolean z15 = customInfo.mEncryptLog;
                if (z14 != z15) {
                    customInfo2.mEncryptLog = z15;
                    if (z15) {
                        com.uc.crashsdk.a.a.d("DEBUG", "updateCustomInfoImpl set mEncryptLog to true");
                        f4597b = new RuntimeException("updateCustomInfoImpl set mEncryptLog to true");
                    }
                    i3++;
                }
                boolean z16 = customInfo2.mSyncUploadSetupCrashLogs;
                boolean z17 = customInfo.mSyncUploadSetupCrashLogs;
                if (z16 != z17) {
                    customInfo2.mSyncUploadSetupCrashLogs = z17;
                    i3++;
                }
                boolean z18 = customInfo2.mSyncUploadLogs;
                boolean z19 = customInfo.mSyncUploadLogs;
                if (z18 != z19) {
                    customInfo2.mSyncUploadLogs = z19;
                    i3++;
                }
                int i18 = customInfo2.mMaxCustomLogFilesCount;
                int i19 = customInfo.mMaxCustomLogFilesCount;
                if (i18 != i19) {
                    customInfo2.mMaxCustomLogFilesCount = i19;
                    i3++;
                }
                boolean z20 = customInfo2.mOmitJavaCrash;
                boolean z21 = customInfo.mOmitJavaCrash;
                if (z20 != z21) {
                    customInfo2.mOmitJavaCrash = z21;
                    i3++;
                }
                int i20 = customInfo2.mLogMaxUploadBytesLimit;
                int i21 = customInfo.mLogMaxUploadBytesLimit;
                if (i20 != i21) {
                    customInfo2.mLogMaxUploadBytesLimit = i21;
                    i3++;
                }
                long j2 = customInfo2.mMaxUploadBytesPerDay;
                long j3 = customInfo.mMaxUploadBytesPerDay;
                if (j2 != j3) {
                    customInfo2.mMaxUploadBytesPerDay = j3;
                    i3++;
                }
                int i22 = customInfo2.mMaxUploadBuiltinLogCountPerDay;
                int i23 = customInfo.mMaxUploadBuiltinLogCountPerDay;
                if (i22 != i23) {
                    customInfo2.mMaxUploadBuiltinLogCountPerDay = i23;
                    i3++;
                }
                int i24 = customInfo2.mMaxUploadCustomLogCountPerDay;
                int i25 = customInfo.mMaxUploadCustomLogCountPerDay;
                if (i24 != i25) {
                    customInfo2.mMaxUploadCustomLogCountPerDay = i25;
                    i3++;
                }
                int i26 = customInfo2.mMaxCustomLogCountPerTypePerDay;
                int i27 = customInfo.mMaxCustomLogCountPerTypePerDay;
                if (i26 != i27) {
                    customInfo2.mMaxCustomLogCountPerTypePerDay = i27;
                    i3++;
                }
                int i28 = customInfo2.mMaxAnrLogCountPerProcess;
                int i29 = customInfo.mMaxAnrLogCountPerProcess;
                if (i28 != i29) {
                    customInfo2.mMaxAnrLogCountPerProcess = i29;
                    if (b.f4552d) {
                        JNIBridge.set(32, f4599d.mMaxAnrLogCountPerProcess);
                    }
                    i3++;
                }
                boolean z22 = customInfo2.mCallJavaDefaultHandler;
                boolean z23 = customInfo.mCallJavaDefaultHandler;
                if (z22 != z23) {
                    customInfo2.mCallJavaDefaultHandler = z23;
                    i3++;
                }
                boolean z24 = customInfo2.mCallNativeDefaultHandler;
                boolean z25 = customInfo.mCallNativeDefaultHandler;
                if (z24 != z25) {
                    customInfo2.mCallNativeDefaultHandler = z25;
                    i3++;
                    if (b.f4552d) {
                        JNIBridge.set(5, f4599d.mCallNativeDefaultHandler);
                    }
                }
                boolean z26 = customInfo2.mDumpUserSolibBuildId;
                boolean z27 = customInfo.mDumpUserSolibBuildId;
                if (z26 != z27) {
                    customInfo2.mDumpUserSolibBuildId = z27;
                    i3++;
                    if (b.f4552d) {
                        JNIBridge.set(6, f4599d.mDumpUserSolibBuildId);
                    }
                }
                boolean z28 = customInfo2.mDumpHprofDataForJavaOOM;
                boolean z29 = customInfo.mDumpHprofDataForJavaOOM;
                if (z28 != z29) {
                    customInfo2.mDumpHprofDataForJavaOOM = z29;
                    i3++;
                }
                boolean z30 = customInfo2.mRenameFileToDefaultName;
                boolean z31 = customInfo.mRenameFileToDefaultName;
                if (z30 != z31) {
                    customInfo2.mRenameFileToDefaultName = z31;
                    i3++;
                }
                boolean z32 = customInfo2.mAutoDeleteOldVersionStats;
                boolean z33 = customInfo.mAutoDeleteOldVersionStats;
                if (z32 != z33) {
                    customInfo2.mAutoDeleteOldVersionStats = z33;
                    i3++;
                }
                int i30 = customInfo2.mFdDumpMinLimit;
                int i31 = customInfo.mFdDumpMinLimit;
                if (i30 != i31) {
                    customInfo2.mFdDumpMinLimit = i31;
                    if (b.f4552d) {
                        JNIBridge.set(10, i31);
                    }
                    i3++;
                }
                int i32 = customInfo2.mThreadsDumpMinLimit;
                int i33 = customInfo.mThreadsDumpMinLimit;
                if (i32 != i33) {
                    customInfo2.mThreadsDumpMinLimit = i33;
                    if (b.f4552d) {
                        JNIBridge.set(22, i33);
                    }
                    i3++;
                }
                int i34 = customInfo2.mInfoUpdateInterval;
                int i35 = customInfo.mInfoUpdateInterval;
                if (i34 != i35) {
                    if (i34 <= 0 && i35 > 0) {
                        a.a(false);
                    }
                    customInfo2.mInfoUpdateInterval = customInfo.mInfoUpdateInterval;
                    i3++;
                }
                int i36 = customInfo2.mInfoSaveFrequency;
                int i37 = customInfo.mInfoSaveFrequency;
                if (i36 != i37) {
                    customInfo2.mInfoSaveFrequency = i37;
                    i3++;
                }
                long j4 = customInfo2.mDisableBackgroundSignals;
                long j5 = customInfo.mDisableBackgroundSignals;
                if (j4 != j5) {
                    customInfo2.mDisableBackgroundSignals = j5;
                    if (b.f4552d) {
                        JNIBridge.set(9, j5);
                    }
                    i3++;
                }
                boolean z34 = customInfo2.mEnableStatReport;
                boolean z35 = customInfo.mEnableStatReport;
                if (z34 != z35) {
                    customInfo2.mEnableStatReport = z35;
                    if (z35) {
                        e.A();
                    }
                    i3++;
                }
                boolean z36 = customInfo2.mIsInternational;
                boolean z37 = customInfo.mIsInternational;
                if (z36 != z37) {
                    customInfo2.mIsInternational = z37;
                    if (b.f4552d) {
                        JNIBridge.set(23, z37);
                    }
                    i3++;
                }
                boolean z38 = customInfo2.mAutoDetectLifeCycle;
                boolean z39 = customInfo.mAutoDetectLifeCycle;
                if (z38 != z39) {
                    customInfo2.mAutoDetectLifeCycle = z39;
                    if (z39) {
                        b.z();
                    }
                    i3++;
                }
                boolean z40 = customInfo2.mMonitorBattery;
                boolean z41 = customInfo.mMonitorBattery;
                if (z40 != z41) {
                    customInfo2.mMonitorBattery = z41;
                    e.c(b.y());
                    i3++;
                }
                int i38 = customInfo2.mUnexpSubTypes;
                int i39 = customInfo.mUnexpSubTypes;
                if (i38 != i39) {
                    customInfo2.mUnexpSubTypes = i39;
                    i3++;
                }
                i2 = i3;
            }
        }
        return i2;
    }

    public static void c() {
        JNIBridge.set(11, N());
        JNIBridge.set(12, f4599d.mBackupLogs);
        JNIBridge.set(13, f4599d.mCrashRestartInterval);
        JNIBridge.set(14, f4599d.mMaxBuiltinLogFilesCount);
        JNIBridge.set(15, f4599d.mMaxNativeLogcatLineCount);
        JNIBridge.set(16, f4599d.mMaxUnexpLogcatLineCount);
        JNIBridge.set(31, f4599d.mMaxAnrLogcatLineCount);
        JNIBridge.set(18, M());
        JNIBridge.set(20, Build.VERSION.SDK_INT);
        JNIBridge.set(21, f4599d.mOmitNativeCrash);
        JNIBridge.set(32, f4599d.mMaxAnrLogCountPerProcess);
        JNIBridge.set(8, f4599d.mDisableSignals);
        JNIBridge.set(9, f4599d.mDisableBackgroundSignals);
        CustomInfo customInfo = f4599d;
        JNIBridge.nativeSet(3, customInfo.mZipLog ? 1L : 0L, customInfo.mZippedLogExtension, null);
        JNIBridge.set(4, f4599d.mLogMaxBytesLimit);
        JNIBridge.set(119, Build.FINGERPRINT);
    }

    private static String a(String str) {
        return (str == null || !str.contains("_")) ? str : str.replaceAll("_", "-");
    }

    public static CustomInfo a(CustomInfo customInfo, Bundle bundle) {
        if (customInfo == null) {
            CustomInfo customInfo2 = f4599d;
            if (customInfo2 == null) {
                customInfo = new CustomInfo();
            } else {
                customInfo = new CustomInfo(customInfo2);
            }
        }
        Field[] fields = customInfo.getClass().getFields();
        for (String str : bundle.keySet()) {
            for (Field field : fields) {
                if (field.getName().equals(str)) {
                    Object obj = bundle.get(str);
                    try {
                        field.set(customInfo, obj);
                    } catch (Exception e2) {
                        com.uc.crashsdk.a.g.a(e2);
                        StringBuilder sb = new StringBuilder("Field ");
                        sb.append(str);
                        sb.append(" must be a ");
                        sb.append(field.getType().getName());
                        sb.append(", but give a ");
                        sb.append(obj != null ? obj.getClass().getName() : "(null)");
                        throw new IllegalArgumentException(sb.toString());
                    }
                }
            }
        }
        return customInfo;
    }

    public static VersionInfo a(Bundle bundle) {
        VersionInfo versionInfo;
        VersionInfo versionInfo2 = f4600e;
        if (versionInfo2 == null) {
            versionInfo = new VersionInfo();
        } else {
            versionInfo = new VersionInfo(versionInfo2);
        }
        String string = bundle.getString("mVersion");
        if (!com.uc.crashsdk.a.g.a(string)) {
            versionInfo.mVersion = string;
        }
        String string2 = bundle.getString("mSubVersion");
        if (!com.uc.crashsdk.a.g.a(string2)) {
            versionInfo.mSubVersion = string2;
        }
        String string3 = bundle.getString("mBuildId");
        if (!com.uc.crashsdk.a.g.a(string3)) {
            versionInfo.mBuildId = string3;
        }
        String string4 = bundle.getString("crver");
        if (!com.uc.crashsdk.a.g.a(string4)) {
            a.f4493b = string4;
            Y();
        }
        return versionInfo;
    }

    private static boolean a(String str, String str2) {
        if (str == str2) {
            return true;
        }
        if (str == null || str2 == null) {
            return false;
        }
        return str.equals(str2);
    }
}

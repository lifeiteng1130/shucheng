package com.uc.crashsdk;

import android.os.Looper;
import android.os.Process;
import com.uc.crashsdk.export.LogType;
import com.umeng.commonsdk.statistics.SdkVersion;
import java.io.File;
import java.util.Locale;

/* JADX INFO: compiled from: ProGuard */
/* JADX INFO: loaded from: classes.dex */
public class JNIBridge {
    private static int addCachedInfo(String str, String str2) {
        return a.b(str, str2);
    }

    private static int addDumpFile(String str, String str2, boolean z, boolean z2, int i2, boolean z3) {
        return a.a(str, str2, z, z2, i2, z3);
    }

    private static void addHeaderInfo(String str, String str2) {
        a.a(str, str2);
    }

    public static long cmd(int i2) {
        return nativeCmd(i2, 0L, null, null);
    }

    private static int createCachedInfo(String str, int i2, int i3) {
        return a.a(str, i2, i3);
    }

    private static boolean generateCustomLog(String str, String str2, long j2, String str3, String str4, String str5, String str6) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        return e.a(stringBuffer, str2, j2, a.c(str3), a.c(str4), a.c(str5), str6);
    }

    public static String getCallbackInfo(String str, boolean z) {
        return a.a(str, z);
    }

    private static String getDatasForClientJavaLog(int i2, String str) {
        boolean zEquals = "$all$".equals(str);
        if (i2 == 1) {
            return zEquals ? a.h() : a.a(str);
        }
        if (i2 == 2) {
            return zEquals ? a.j() : a.a(str, true);
        }
        if (i2 == 3) {
            return zEquals ? a.l() : a.b(str);
        }
        if (i2 == 4) {
            return e.c(str) ? SdkVersion.MINI_VERSION : "0";
        }
        return null;
    }

    private static String getJavaStackTrace(Thread thread, int i2) {
        if (i2 != 0 && i2 == Process.myPid()) {
            thread = Looper.getMainLooper().getThread();
        }
        if (thread != null) {
            return e.a(thread.getStackTrace(), "getJavaStackTrace").toString();
        }
        return null;
    }

    public static native boolean nativeAddCachedInfo(String str, String str2);

    public static native int nativeAddCallbackInfo(String str, int i2, long j2, int i3);

    public static native int nativeAddDumpFile(String str, String str2, boolean z, boolean z2, int i2, boolean z3);

    public static native void nativeAddHeaderInfo(String str, String str2);

    public static native boolean nativeChangeState(String str, String str2, boolean z);

    public static native void nativeClientCloseConnection(long j2);

    public static native long nativeClientCreateConnection(String str, String str2, String str3, int i2);

    public static native int nativeClientWriteData(long j2, String str);

    public static native void nativeCloseFile(int i2);

    public static native long nativeCmd(int i2, long j2, String str, Object[] objArr);

    public static native void nativeCrash(int i2, int i3);

    public static native int nativeCreateCachedInfo(String str, int i2, int i3);

    public static native String nativeDumpThreads(String str, long j2);

    public static native int nativeGenerateUnexpLog(long j2, int i2);

    public static native String nativeGet(int i2, long j2, String str);

    public static native String nativeGetCallbackInfo(String str, long j2, int i2, boolean z);

    public static native boolean nativeIsCrashing();

    public static native boolean nativeLockFile(int i2, boolean z);

    public static native int nativeLog(int i2, String str, String str2);

    public static native int nativeOpenFile(String str);

    public static native long nativeSet(int i2, long j2, String str, Object[] objArr);

    public static native void nativeSetForeground(boolean z);

    private static void onCrashLogGenerated(String str, String str2, String str3, boolean z) {
        boolean zEquals = e.h().equals(str2);
        boolean zEquals2 = LogType.NATIVE_TYPE.equals(str3);
        if (!e.E()) {
            if (zEquals && zEquals2) {
                try {
                    f.c(true);
                } catch (Throwable th) {
                    com.uc.crashsdk.a.g.a(th);
                }
            }
            str = e.a(str);
        }
        d.a(str, str2, str3);
        if (e.E()) {
            return;
        }
        if (z || (!zEquals && g.s())) {
            e.a(false, false);
        } else if (zEquals) {
            e.b(zEquals2);
        }
    }

    private static void onCrashRestarting() {
        d.a(false);
        b.K();
    }

    private static void onKillProcess(String str, int i2, int i3) {
        String str2 = "onKillProcess. SIG: " + i3;
        if (e.a()) {
            com.uc.crashsdk.a.a.b("crashsdk", str2);
        } else {
            com.uc.crashsdk.a.a.a("crashsdk", str2);
        }
        StringBuilder sbE = e.e("onKillProcess");
        Locale locale = Locale.US;
        sbE.insert(0, String.format(locale, "State in disk: '%s'\n", b.m()));
        sbE.insert(0, String.format(locale, "SIG: %d, fg: %s, exiting: %s, main process: %s, time: %s\n", Integer.valueOf(i3), Boolean.valueOf(b.y()), Boolean.valueOf(b.r()), Boolean.valueOf(b.C()), e.m()));
        sbE.insert(0, String.format(locale, "Kill PID: %d (%s) by pid: %d (%s) tid: %d (%s)\n", Integer.valueOf(i2), e.a(i2), Integer.valueOf(Process.myPid()), e.a(Process.myPid()), Integer.valueOf(Process.myTid()), Thread.currentThread().getName()));
        String string = sbE.toString();
        if (e.a()) {
            com.uc.crashsdk.a.a.b("crashsdk", string);
        } else {
            com.uc.crashsdk.a.a.a("crashsdk", string);
        }
        if (b.I()) {
            return;
        }
        com.uc.crashsdk.a.g.a(new File(str), string.getBytes());
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private static String onNativeEvent(int i2, long j2, Object[] objArr) {
        switch (i2) {
            case 1:
                return String.valueOf(Runtime.getRuntime().maxMemory());
            case 2:
                return e.d();
            case 3:
                if (objArr != null && objArr.length == 2 && (objArr[0] instanceof String) && (objArr[1] instanceof String)) {
                    return e.a((String) objArr[0], (String) objArr[1]);
                }
                return null;
            case 4:
                return e.g();
            case 5:
                a.a(true);
                return null;
            case 6:
                return com.uc.crashsdk.a.g.d();
            case 7:
                com.uc.crashsdk.a.f.a(2, new com.uc.crashsdk.a.e(102), 8000L);
                e.q();
                return null;
            default:
                return null;
        }
    }

    private static int onPreClientCustomLog(String str, String str2, boolean z) {
        g.a();
        e.a(false);
        if (e.a(str, str2, z)) {
            return 0;
        }
        e.b(str, str2, z);
        return 1;
    }

    private static int registerCurrentThread(String str, int i2) {
        return a.a(i2, str);
    }

    private static int registerInfoCallback(String str, int i2, long j2, int i3) {
        return a.a(str, i2, null, j2, i3);
    }

    public static long set(int i2, boolean z) {
        return nativeSet(i2, z ? 1L : 0L, null, null);
    }

    public static long cmd(int i2, String str) {
        return nativeCmd(i2, 0L, str, null);
    }

    public static long set(int i2, long j2) {
        return nativeSet(i2, j2, null, null);
    }

    public static long set(int i2, String str) {
        return nativeSet(i2, 0L, str, null);
    }
}

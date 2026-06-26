package com.tencent.bugly.beta.tinker;

import android.util.Log;
import com.tencent.tinker.lib.util.TinkerLog;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes.dex */
public class TinkerLogger implements TinkerLog.TinkerLogImp {
    public static final int LEVEL_DEBUG = 1;
    public static final int LEVEL_ERROR = 4;
    public static final int LEVEL_INFO = 2;
    public static final int LEVEL_NONE = 5;
    public static final int LEVEL_VERBOSE = 0;
    public static final int LEVEL_WARNING = 3;
    private static final String TAG = "Tinker.TinkerLogger";
    private static int level;

    public static int getLogLevel() {
        return level;
    }

    public static void setLevel(int i2) {
        level = i2;
    }

    public void d(String str, String str2, Object... objArr) {
        if (level > 1 || objArr == null) {
            return;
        }
        String.format(str2, objArr);
    }

    public void e(String str, String str2, Object... objArr) {
        if (level > 4 || objArr == null) {
            return;
        }
        String.format(str2, objArr);
    }

    public void i(String str, String str2, Object... objArr) {
        if (level > 2 || objArr == null) {
            return;
        }
        String.format(str2, objArr);
    }

    public void printErrStackTrace(String str, Throwable th, String str2, Object... objArr) {
        if (objArr != null) {
            String.format(str2, objArr);
        }
        Log.getStackTraceString(th);
    }

    public void v(String str, String str2, Object... objArr) {
        if (level > 0 || objArr == null) {
            return;
        }
        String.format(str2, objArr);
    }

    public void w(String str, String str2, Object... objArr) {
        if (level > 3 || objArr == null) {
            return;
        }
        String.format(str2, objArr);
    }
}

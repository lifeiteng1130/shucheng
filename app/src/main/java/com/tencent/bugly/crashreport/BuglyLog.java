package com.tencent.bugly.crashreport;

import androidx.exifinterface.media.ExifInterface;
import com.tencent.bugly.proguard.ba;
import org.mozilla.javascript.optimizer.OptRuntime;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes.dex */
public class BuglyLog {
    public static void d(String str, String str2) {
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "null";
        }
        boolean z = com.tencent.bugly.b.f3960c;
        ba.c("D", str, str2);
    }

    public static void e(String str, String str2) {
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "null";
        }
        boolean z = com.tencent.bugly.b.f3960c;
        ba.c(ExifInterface.LONGITUDE_EAST, str, str2);
    }

    public static void i(String str, String str2) {
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "null";
        }
        boolean z = com.tencent.bugly.b.f3960c;
        ba.c(OptRuntime.GeneratorState.resumptionPoint_TYPE, str, str2);
    }

    public static void setCache(int i2) {
        ba.a(i2);
    }

    public static void v(String str, String str2) {
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "null";
        }
        boolean z = com.tencent.bugly.b.f3960c;
        ba.c(ExifInterface.GPS_MEASUREMENT_INTERRUPTED, str, str2);
    }

    public static void w(String str, String str2) {
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "null";
        }
        boolean z = com.tencent.bugly.b.f3960c;
        ba.c(ExifInterface.LONGITUDE_WEST, str, str2);
    }

    public static void e(String str, String str2, Throwable th) {
        if (str == null) {
            str = "";
        }
        boolean z = com.tencent.bugly.b.f3960c;
        ba.a(ExifInterface.LONGITUDE_EAST, str, th);
    }
}

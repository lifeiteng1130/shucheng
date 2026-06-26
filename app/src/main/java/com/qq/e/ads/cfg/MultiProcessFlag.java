package com.qq.e.ads.cfg;

import com.qq.e.comm.util.GDTLogger;

/* JADX INFO: loaded from: classes.dex */
public class MultiProcessFlag {
    private static boolean a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f2655b;

    public static boolean isMultiProcess() {
        return a;
    }

    public static void setMultiProcess(boolean z) {
        if (f2655b) {
            GDTLogger.w("MultiProcessFlag已经设置过，再次设置无效");
        } else {
            f2655b = true;
            a = z;
        }
    }
}

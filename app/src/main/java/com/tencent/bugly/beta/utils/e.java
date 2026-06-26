package com.tencent.bugly.beta.utils;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes.dex */
public class e {
    private static Handler a;

    private static Handler a() {
        if (a == null && Looper.getMainLooper() != null) {
            a = new Handler(Looper.getMainLooper());
        }
        return a;
    }

    public static void b(Runnable runnable) {
        if (a() != null) {
            a.removeCallbacks(runnable);
        }
    }

    public static void a(Runnable runnable) {
        if (a() != null) {
            a.post(runnable);
        }
    }

    public static void a(Runnable runnable, long j2) {
        if (a() != null) {
            a.postDelayed(runnable, j2);
        }
    }
}

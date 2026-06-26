package com.umeng.analytics.pro;

import android.content.Context;
import android.os.Looper;

/* JADX INFO: compiled from: OpenDeviceId.java */
/* JADX INFO: loaded from: classes.dex */
public class z {
    private static y a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f4976b = false;

    public static synchronized String a(Context context) {
        try {
            if (context == null) {
                throw new RuntimeException("Context is null");
            }
            if (Looper.myLooper() == Looper.getMainLooper()) {
                throw new IllegalStateException("Cannot be called from the main thread");
            }
            b(context);
            y yVar = a;
            if (yVar != null) {
                try {
                    return yVar.a(context);
                } catch (Exception unused) {
                }
            }
            return null;
        } catch (Throwable th) {
            throw th;
        }
    }

    private static void b(Context context) {
        if (a != null || f4976b) {
            return;
        }
        synchronized (z.class) {
            if (a == null && !f4976b) {
                a = aa.a(context);
                f4976b = true;
            }
        }
    }
}

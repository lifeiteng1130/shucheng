package com.jeremyliao.liveeventbus.utils;

import android.annotation.SuppressLint;
import android.app.Application;

/* JADX INFO: loaded from: classes.dex */
public final class AppUtils {

    @SuppressLint({"StaticFieldLeak"})
    private static volatile Application sApplication;

    public static Application getApplicationContext() {
        if (sApplication == null) {
            synchronized (AppUtils.class) {
                if (sApplication == null) {
                    try {
                        sApplication = (Application) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            }
        }
        return sApplication;
    }
}

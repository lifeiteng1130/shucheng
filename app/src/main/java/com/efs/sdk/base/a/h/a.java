package com.efs.sdk.base.a.h;

import android.content.Context;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public class a {
    private static String a = "efs";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static File f1836b;

    public static void a(String str) {
        a = str;
    }

    public static File b(Context context, String str) {
        return new File(g(context, str), "efs_config");
    }

    public static File c(Context context, String str) {
        return new File(g(context, str), "efs_flow");
    }

    public static File d(Context context, String str) {
        File file = new File(g(context, str), "ready");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static File e(Context context, String str) {
        File file = new File(d(context, str), String.valueOf(g.a()));
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static File f(Context context, String str) {
        File file = new File(g(context, str), "upload");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    private static File g(Context context, String str) {
        if (f1836b == null) {
            synchronized (a.class) {
                if (f1836b == null) {
                    f1836b = a(context);
                }
            }
        }
        File file = new File(f1836b, str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static File a(Context context) {
        File dir = context.getDir(a, 0);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        return dir;
    }

    public static File a(Context context, String str) {
        return new File(g(context, str), "efs_cst");
    }
}

package com.qq.e.comm.managers.plugin;

import android.content.Context;
import com.qq.e.comm.util.SystemUtil;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public class h {
    private static String a = SystemUtil.buildNewPathByProcessName("e_qq_com_plugin");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f2808b = SystemUtil.buildNewPathByProcessName("e_qq_com_dex");

    public static File a(Context context) {
        return context.getDir(f2808b, 0);
    }

    public static File b(Context context) {
        return new File(context.getDir(a, 0), "update_lc");
    }

    public static File c(Context context) {
        return new File(context.getDir(a, 0), "gdt_plugin.next");
    }

    public static File d(Context context) {
        return new File(context.getDir(a, 0), "gdt_plugin.next.sig");
    }

    public static File e(Context context) {
        return new File(context.getDir(a, 0), "gdt_plugin.jar");
    }

    public static File f(Context context) {
        return new File(context.getDir(a, 0), "gdt_plugin.jar.sig");
    }

    public static File g(Context context) {
        return new File(context.getDir(a, 0), "gdt_plugin.tmp");
    }

    public static File h(Context context) {
        return new File(context.getDir(a, 0), "gdt_plugin.tmp.sig");
    }
}

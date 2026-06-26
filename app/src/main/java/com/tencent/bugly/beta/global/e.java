package com.tencent.bugly.beta.global;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.util.DisplayMetrics;
import com.tencent.bugly.beta.UpgradeInfo;
import com.tencent.bugly.beta.download.DownloadListener;
import com.tencent.bugly.beta.interfaces.BetaPatchListener;
import com.tencent.bugly.beta.ui.UILifecycleListener;
import com.tencent.bugly.beta.upgrade.BetaUploadStrategy;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes.dex */
public class e {
    public static int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static e f3983b = new e();
    public PackageInfo C;
    public SharedPreferences D;
    public DisplayMetrics E;
    public BetaUploadStrategy H;
    public File I;
    public File J;
    public File K;
    public BetaPatchListener Y;
    public boolean fa;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f3990i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f3991j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f3992k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f3993l;
    public int m;
    public UILifecycleListener<UpgradeInfo> n;
    public File o;
    public int r;
    public com.tencent.bugly.beta.download.c s;
    public DownloadListener t;
    public File u;
    public Context v;
    public File w;
    public String x;
    public String y;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f3984c = 3000;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f3985d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f3986e = true;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f3987f = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f3988g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f3989h = true;
    public final List<Class<? extends Activity>> p = new ArrayList();
    public final List<Class<? extends Activity>> q = new ArrayList();
    public int z = Integer.MIN_VALUE;
    public String A = "";
    public String B = "";
    public boolean F = true;
    public boolean G = false;
    public String L = "";
    public String M = "";
    public String N = "";
    public String O = "";
    public boolean P = false;
    public int Q = 0;
    public String R = "";
    public boolean S = false;
    public boolean T = true;
    public boolean U = false;
    public boolean V = false;
    public boolean W = true;
    public boolean X = true;
    public boolean Z = false;
    public boolean aa = true;
    public boolean ba = false;
    public final List<String> ca = new ArrayList();
    public boolean da = false;
    public boolean ea = false;

    /* JADX WARN: Removed duplicated region for block: B:36:0x00ed A[Catch: all -> 0x01ff, TryCatch #2 {, blocks: (B:3:0x0001, B:4:0x000f, B:6:0x0023, B:7:0x0027, B:9:0x002f, B:10:0x0035, B:12:0x0049, B:14:0x004d, B:15:0x0053, B:17:0x0057, B:19:0x0061, B:25:0x0072, B:27:0x0083, B:29:0x0089, B:30:0x0092, B:32:0x00ad, B:35:0x00b4, B:37:0x0110, B:44:0x0126, B:46:0x0130, B:48:0x0138, B:50:0x0140, B:52:0x0148, B:76:0x0197, B:78:0x01d5, B:79:0x01da, B:81:0x01e0, B:82:0x01e8, B:84:0x01f6, B:73:0x018e, B:75:0x0194, B:54:0x0150, B:56:0x0154, B:58:0x015e, B:60:0x0168, B:62:0x016e, B:64:0x0172, B:66:0x0178, B:68:0x017c, B:70:0x0186, B:36:0x00ed, B:22:0x0069, B:24:0x006f), top: B:94:0x0001, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0150 A[Catch: Exception -> 0x018d, all -> 0x01ff, TRY_LEAVE, TryCatch #0 {Exception -> 0x018d, blocks: (B:44:0x0126, B:46:0x0130, B:48:0x0138, B:50:0x0140, B:52:0x0148, B:54:0x0150, B:56:0x0154, B:58:0x015e, B:60:0x0168, B:62:0x016e, B:64:0x0172, B:66:0x0178, B:68:0x017c, B:70:0x0186), top: B:90:0x0126, outer: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0197 A[Catch: all -> 0x01ff, TryCatch #2 {, blocks: (B:3:0x0001, B:4:0x000f, B:6:0x0023, B:7:0x0027, B:9:0x002f, B:10:0x0035, B:12:0x0049, B:14:0x004d, B:15:0x0053, B:17:0x0057, B:19:0x0061, B:25:0x0072, B:27:0x0083, B:29:0x0089, B:30:0x0092, B:32:0x00ad, B:35:0x00b4, B:37:0x0110, B:44:0x0126, B:46:0x0130, B:48:0x0138, B:50:0x0140, B:52:0x0148, B:76:0x0197, B:78:0x01d5, B:79:0x01da, B:81:0x01e0, B:82:0x01e8, B:84:0x01f6, B:73:0x018e, B:75:0x0194, B:54:0x0150, B:56:0x0154, B:58:0x015e, B:60:0x0168, B:62:0x016e, B:64:0x0172, B:66:0x0178, B:68:0x017c, B:70:0x0186, B:36:0x00ed, B:22:0x0069, B:24:0x006f), top: B:94:0x0001, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01d5 A[Catch: all -> 0x01ff, TryCatch #2 {, blocks: (B:3:0x0001, B:4:0x000f, B:6:0x0023, B:7:0x0027, B:9:0x002f, B:10:0x0035, B:12:0x0049, B:14:0x004d, B:15:0x0053, B:17:0x0057, B:19:0x0061, B:25:0x0072, B:27:0x0083, B:29:0x0089, B:30:0x0092, B:32:0x00ad, B:35:0x00b4, B:37:0x0110, B:44:0x0126, B:46:0x0130, B:48:0x0138, B:50:0x0140, B:52:0x0148, B:76:0x0197, B:78:0x01d5, B:79:0x01da, B:81:0x01e0, B:82:0x01e8, B:84:0x01f6, B:73:0x018e, B:75:0x0194, B:54:0x0150, B:56:0x0154, B:58:0x015e, B:60:0x0168, B:62:0x016e, B:64:0x0172, B:66:0x0178, B:68:0x017c, B:70:0x0186, B:36:0x00ed, B:22:0x0069, B:24:0x006f), top: B:94:0x0001, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01e0 A[Catch: all -> 0x01ff, TryCatch #2 {, blocks: (B:3:0x0001, B:4:0x000f, B:6:0x0023, B:7:0x0027, B:9:0x002f, B:10:0x0035, B:12:0x0049, B:14:0x004d, B:15:0x0053, B:17:0x0057, B:19:0x0061, B:25:0x0072, B:27:0x0083, B:29:0x0089, B:30:0x0092, B:32:0x00ad, B:35:0x00b4, B:37:0x0110, B:44:0x0126, B:46:0x0130, B:48:0x0138, B:50:0x0140, B:52:0x0148, B:76:0x0197, B:78:0x01d5, B:79:0x01da, B:81:0x01e0, B:82:0x01e8, B:84:0x01f6, B:73:0x018e, B:75:0x0194, B:54:0x0150, B:56:0x0154, B:58:0x015e, B:60:0x0168, B:62:0x016e, B:64:0x0172, B:66:0x0178, B:68:0x017c, B:70:0x0186, B:36:0x00ed, B:22:0x0069, B:24:0x006f), top: B:94:0x0001, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01f6 A[Catch: all -> 0x01ff, TRY_LEAVE, TryCatch #2 {, blocks: (B:3:0x0001, B:4:0x000f, B:6:0x0023, B:7:0x0027, B:9:0x002f, B:10:0x0035, B:12:0x0049, B:14:0x004d, B:15:0x0053, B:17:0x0057, B:19:0x0061, B:25:0x0072, B:27:0x0083, B:29:0x0089, B:30:0x0092, B:32:0x00ad, B:35:0x00b4, B:37:0x0110, B:44:0x0126, B:46:0x0130, B:48:0x0138, B:50:0x0140, B:52:0x0148, B:76:0x0197, B:78:0x01d5, B:79:0x01da, B:81:0x01e0, B:82:0x01e8, B:84:0x01f6, B:73:0x018e, B:75:0x0194, B:54:0x0150, B:56:0x0154, B:58:0x015e, B:60:0x0168, B:62:0x016e, B:64:0x0172, B:66:0x0178, B:68:0x017c, B:70:0x0186, B:36:0x00ed, B:22:0x0069, B:24:0x006f), top: B:94:0x0001, inners: #0, #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized void a(android.content.Context r9) {
        /*
            Method dump skipped, instruction units count: 514
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.beta.global.e.a(android.content.Context):void");
    }
}

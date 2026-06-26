package com.tencent.bugly.crashreport.common.info;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import android.provider.Settings;
import com.tencent.bugly.proguard.X;
import com.tencent.bugly.proguard.ca;
import h.a.a.a.w;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes.dex */
public class b {
    private static final String[] a = {"/su", "/su/bin/su", "/sbin/su", "/data/local/xbin/su", "/data/local/bin/su", "/data/local/su", "/system/xbin/su", "/system/bin/su", "/system/sd/xbin/su", "/system/bin/failsafe/su", "/system/bin/cufsdosck", "/system/xbin/cufsdosck", "/system/bin/cufsmgr", "/system/xbin/cufsmgr", "/system/bin/cufaevdd", "/system/xbin/cufaevdd", "/system/bin/conbb", "/system/xbin/conbb"};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String[] f4104b = {"com.ami.duosupdater.ui", "com.ami.launchmetro", "com.ami.syncduosservices", "com.bluestacks.home", "com.bluestacks.windowsfilemanager", "com.bluestacks.settings", "com.bluestacks.bluestackslocationprovider", "com.bluestacks.appsettings", "com.bluestacks.bstfolder", "com.bluestacks.BstCommandProcessor", "com.bluestacks.s2p", "com.bluestacks.setup", "com.kaopu001.tiantianserver", "com.kpzs.helpercenter", "com.kaopu001.tiantianime", "com.android.development_settings", "com.android.development", "com.android.customlocale2", "com.genymotion.superuser", "com.genymotion.clipboardproxy", "com.uc.xxzs.keyboard", "com.uc.xxzs", "com.blue.huang17.agent", "com.blue.huang17.launcher", "com.blue.huang17.ime", "com.microvirt.guide", "com.microvirt.market", "com.microvirt.memuime", "cn.itools.vm.launcher", "cn.itools.vm.proxy", "cn.itools.vm.softkeyboard", "cn.itools.avdmarket", "com.syd.IME", "com.bignox.app.store.hd", "com.bignox.launcher", "com.bignox.app.phone", "com.bignox.app.noxservice", "com.android.noxpush", "com.haimawan.push", "me.haima.helpcenter", "com.windroy.launcher", "com.windroy.superuser", "com.windroy.launcher", "com.windroy.ime", "com.android.flysilkworm", "com.android.emu.inputservice", "com.tiantian.ime", "com.microvirt.launcher", "me.le8.androidassist", "com.vphone.helper", "com.vphone.launcher", "com.duoyi.giftcenter.giftcenter"};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String[] f4105c = {"/sys/devices/system/cpu/cpu0/cpufreq/scaling_cur_freq", "/system/lib/libc_malloc_debug_qemu.so", "/sys/qemu_trace", "/system/bin/qemu-props", "/dev/socket/qemud", "/dev/qemu_pipe", "/dev/socket/baseband_genyd", "/dev/socket/genyd"};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static String f4106d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static String f4107e = null;

    public static String a(Context context) {
        if (context == null) {
            return "fail";
        }
        try {
            String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
            return string == null ? "null" : string.toLowerCase();
        } catch (Throwable th) {
            if (!X.b(th)) {
                X.c("Failed to get Android ID.", new Object[0]);
            }
            return "fail";
        }
    }

    public static String b(Context context) {
        return ca.a(context, "ro.board.platform");
    }

    public static int c() {
        try {
            return Build.VERSION.SDK_INT;
        } catch (Throwable th) {
            if (X.b(th)) {
                return -1;
            }
            th.printStackTrace();
            return -1;
        }
    }

    public static String d() {
        try {
            return Build.BRAND;
        } catch (Throwable th) {
            if (!X.b(th)) {
                th.printStackTrace();
            }
            return "fail";
        }
    }

    public static String e() {
        return "";
    }

    public static String e(Context context) {
        PackageManager packageManager = context.getPackageManager();
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (true) {
            String[] strArr = f4104b;
            if (i2 >= strArr.length) {
                break;
            }
            try {
                packageManager.getPackageInfo(strArr[i2], 1);
                arrayList.add(Integer.valueOf(i2));
            } catch (PackageManager.NameNotFoundException unused) {
            }
            i2++;
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return arrayList.toString();
    }

    public static String f() {
        try {
            return Build.MODEL;
        } catch (Throwable th) {
            if (X.b(th)) {
                return "fail";
            }
            th.printStackTrace();
            return "fail";
        }
    }

    public static long g() {
        if (!a()) {
            return 0L;
        }
        try {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            return ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
        } catch (Throwable th) {
            if (X.b(th)) {
                return -2L;
            }
            th.printStackTrace();
            return -2L;
        }
    }

    public static long h() {
        FileReader fileReader;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader("/proc/meminfo");
            try {
                BufferedReader bufferedReader2 = new BufferedReader(fileReader, 2048);
                try {
                    bufferedReader2.readLine();
                    String line = bufferedReader2.readLine();
                    if (line == null) {
                        try {
                            bufferedReader2.close();
                        } catch (IOException e2) {
                            if (!X.b(e2)) {
                                e2.printStackTrace();
                            }
                        }
                        try {
                            fileReader.close();
                        } catch (IOException e3) {
                            if (!X.b(e3)) {
                                e3.printStackTrace();
                            }
                        }
                        return -1L;
                    }
                    long j2 = (Long.parseLong(line.split(":\\s+", 2)[1].toLowerCase().replace("kb", "").trim()) * 1024) + 0;
                    String line2 = bufferedReader2.readLine();
                    if (line2 == null) {
                        try {
                            bufferedReader2.close();
                        } catch (IOException e4) {
                            if (!X.b(e4)) {
                                e4.printStackTrace();
                            }
                        }
                        try {
                            fileReader.close();
                        } catch (IOException e5) {
                            if (!X.b(e5)) {
                                e5.printStackTrace();
                            }
                        }
                        return -1L;
                    }
                    long j3 = Long.parseLong(line2.split(":\\s+", 2)[1].toLowerCase().replace("kb", "").trim());
                    Long.signum(j3);
                    long j4 = (j3 * 1024) + j2;
                    String line3 = bufferedReader2.readLine();
                    if (line3 == null) {
                        try {
                            bufferedReader2.close();
                        } catch (IOException e6) {
                            if (!X.b(e6)) {
                                e6.printStackTrace();
                            }
                        }
                        try {
                            fileReader.close();
                        } catch (IOException e7) {
                            if (!X.b(e7)) {
                                e7.printStackTrace();
                            }
                        }
                        return -1L;
                    }
                    long j5 = (Long.parseLong(line3.split(":\\s+", 2)[1].toLowerCase().replace("kb", "").trim()) * 1024) + j4;
                    try {
                        bufferedReader2.close();
                    } catch (IOException e8) {
                        if (!X.b(e8)) {
                            e8.printStackTrace();
                        }
                    }
                    try {
                        fileReader.close();
                    } catch (IOException e9) {
                        if (!X.b(e9)) {
                            e9.printStackTrace();
                        }
                    }
                    return j5;
                } catch (Throwable th) {
                    th = th;
                    bufferedReader = bufferedReader2;
                    try {
                        if (!X.b(th)) {
                            th.printStackTrace();
                        }
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e10) {
                                if (!X.b(e10)) {
                                    e10.printStackTrace();
                                }
                            }
                        }
                        if (fileReader == null) {
                            return -2L;
                        }
                        try {
                            fileReader.close();
                            return -2L;
                        } catch (IOException e11) {
                            if (X.b(e11)) {
                                return -2L;
                            }
                            e11.printStackTrace();
                            return -2L;
                        }
                    } catch (Throwable th2) {
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e12) {
                                if (!X.b(e12)) {
                                    e12.printStackTrace();
                                }
                            }
                        }
                        if (fileReader != null) {
                            try {
                                fileReader.close();
                            } catch (IOException e13) {
                                if (!X.b(e13)) {
                                    e13.printStackTrace();
                                }
                            }
                        }
                        throw th2;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Throwable th4) {
            th = th4;
            fileReader = null;
        }
    }

    public static long i() {
        FileReader fileReader;
        Throwable th;
        BufferedReader bufferedReader;
        try {
            fileReader = new FileReader("/proc/meminfo");
            try {
                bufferedReader = new BufferedReader(fileReader, 2048);
                try {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e2) {
                            if (!X.b(e2)) {
                                e2.printStackTrace();
                            }
                        }
                        try {
                            fileReader.close();
                        } catch (IOException e3) {
                            if (!X.b(e3)) {
                                e3.printStackTrace();
                            }
                        }
                        return -1L;
                    }
                    long j2 = Long.parseLong(line.split(":\\s+", 2)[1].toLowerCase().replace("kb", "").trim()) * 1024;
                    try {
                        bufferedReader.close();
                    } catch (IOException e4) {
                        if (!X.b(e4)) {
                            e4.printStackTrace();
                        }
                    }
                    try {
                        fileReader.close();
                    } catch (IOException e5) {
                        if (!X.b(e5)) {
                            e5.printStackTrace();
                        }
                    }
                    return j2;
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        if (!X.b(th)) {
                            th.printStackTrace();
                        }
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e6) {
                                if (!X.b(e6)) {
                                    e6.printStackTrace();
                                }
                            }
                        }
                        if (fileReader == null) {
                            return -2L;
                        }
                        try {
                            fileReader.close();
                            return -2L;
                        } catch (IOException e7) {
                            if (X.b(e7)) {
                                return -2L;
                            }
                            e7.printStackTrace();
                            return -2L;
                        }
                    } catch (Throwable th3) {
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e8) {
                                if (!X.b(e8)) {
                                    e8.printStackTrace();
                                }
                            }
                        }
                        if (fileReader != null) {
                            try {
                                fileReader.close();
                            } catch (IOException e9) {
                                if (!X.b(e9)) {
                                    e9.printStackTrace();
                                }
                            }
                        }
                        throw th3;
                    }
                }
            } catch (Throwable th4) {
                th = th4;
                bufferedReader = null;
            }
        } catch (Throwable th5) {
            fileReader = null;
            th = th5;
            bufferedReader = null;
        }
    }

    public static long j() {
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            return ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
        } catch (Throwable th) {
            if (!X.b(th)) {
                th.printStackTrace();
            }
            return -1L;
        }
    }

    public static long k() {
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            return ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize());
        } catch (Throwable th) {
            if (!X.b(th)) {
                th.printStackTrace();
            }
            return -1L;
        }
    }

    public static long l() {
        if (!a()) {
            return 0L;
        }
        try {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            return ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize());
        } catch (Throwable th) {
            if (X.b(th)) {
                return -2L;
            }
            th.printStackTrace();
            return -2L;
        }
    }

    public static String m() {
        try {
            return Build.VERSION.RELEASE;
        } catch (Throwable th) {
            if (X.b(th)) {
                return "fail";
            }
            th.printStackTrace();
            return "fail";
        }
    }

    public static String n() {
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (true) {
            String[] strArr = f4105c;
            if (i2 >= strArr.length) {
                break;
            }
            if (i2 == 0) {
                if (!new File(strArr[i2]).exists()) {
                    arrayList.add(Integer.valueOf(i2));
                }
            } else if (new File(strArr[i2]).exists()) {
                arrayList.add(Integer.valueOf(i2));
            }
            i2++;
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return arrayList.toString();
    }

    public static int o() {
        Method method;
        try {
            method = Class.forName("android.app.ActivityManagerNative").getMethod("getDefault", new Class[0]);
            method.setAccessible(true);
        } catch (Exception unused) {
        }
        return method.invoke(null, new Object[0]).getClass().getName().startsWith("$Proxy") ? 256 : 0;
    }

    /* JADX WARN: Not initialized variable reg: 3, insn: 0x00bb: MOVE (r1 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]), block:B:66:0x00bb */
    public static int p() throws Throwable {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2;
        IOException e2;
        UnsupportedEncodingException e3;
        FileNotFoundException e4;
        HashSet hashSet;
        int i2 = 0;
        BufferedReader bufferedReader3 = null;
        try {
        } catch (Throwable th) {
            th = th;
            bufferedReader3 = bufferedReader;
        }
        try {
            try {
                hashSet = new HashSet();
                StringBuilder sb = new StringBuilder();
                sb.append("/proc/");
                sb.append(Process.myPid());
                sb.append("/maps");
                bufferedReader2 = new BufferedReader(new InputStreamReader(new FileInputStream(sb.toString()), "utf-8"));
            } catch (IOException e5) {
                e5.printStackTrace();
            }
        } catch (FileNotFoundException e6) {
            bufferedReader2 = null;
            e4 = e6;
        } catch (UnsupportedEncodingException e7) {
            bufferedReader2 = null;
            e3 = e7;
        } catch (IOException e8) {
            bufferedReader2 = null;
            e2 = e8;
        } catch (Throwable th2) {
            th = th2;
            if (bufferedReader3 != null) {
                try {
                    bufferedReader3.close();
                } catch (IOException e9) {
                    e9.printStackTrace();
                }
            }
            throw th;
        }
        while (true) {
            try {
                String line = bufferedReader2.readLine();
                if (line == null) {
                    break;
                }
                if (line.endsWith(".so") || line.endsWith(".jar")) {
                    hashSet.add(line.substring(line.lastIndexOf(" ") + 1));
                }
            } catch (FileNotFoundException e10) {
                e4 = e10;
                e4.printStackTrace();
                if (bufferedReader2 != null) {
                    bufferedReader2.close();
                }
                return i2;
            } catch (UnsupportedEncodingException e11) {
                e3 = e11;
                e3.printStackTrace();
                if (bufferedReader2 != null) {
                    bufferedReader2.close();
                }
                return i2;
            } catch (IOException e12) {
                e2 = e12;
                e2.printStackTrace();
                if (bufferedReader2 != null) {
                    bufferedReader2.close();
                }
                return i2;
            }
            return i2;
        }
        for (Object obj : hashSet) {
            if (((String) obj).toLowerCase().contains("xposed")) {
                i2 |= 64;
            }
            if (((String) obj).contains("com.saurik.substrate")) {
                i2 |= 128;
            }
        }
        bufferedReader2.close();
        return i2;
    }

    public static boolean q() {
        boolean z;
        String[] strArr = a;
        int length = strArr.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                z = false;
                break;
            }
            if (new File(strArr[i2]).exists()) {
                z = true;
                break;
            }
            i2++;
        }
        String str = Build.TAGS;
        return (str != null && str.contains("test-keys")) || z;
    }

    public static int b() {
        try {
            throw new Exception("detect hook");
        } catch (Exception e2) {
            int i2 = 0;
            int i3 = 0;
            for (StackTraceElement stackTraceElement : e2.getStackTrace()) {
                if (stackTraceElement.getClassName().equals("de.robv.android.xposed.XposedBridge") && stackTraceElement.getMethodName().equals("main")) {
                    i2 |= 4;
                }
                if (stackTraceElement.getClassName().equals("de.robv.android.xposed.XposedBridge") && stackTraceElement.getMethodName().equals("handleHookedMethod")) {
                    i2 |= 8;
                }
                if (stackTraceElement.getClassName().equals("com.saurik.substrate.MS$2") && stackTraceElement.getMethodName().equals("invoked")) {
                    i2 |= 16;
                }
                if (stackTraceElement.getClassName().equals("com.android.internal.os.ZygoteInit") && (i3 = i3 + 1) == 2) {
                    i2 |= 32;
                }
            }
            return i2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x007e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String c(android.content.Context r3) {
        /*
            java.lang.String r0 = "connectivity"
            java.lang.Object r0 = r3.getSystemService(r0)     // Catch: java.lang.Exception -> L77
            android.net.ConnectivityManager r0 = (android.net.ConnectivityManager) r0     // Catch: java.lang.Exception -> L77
            android.net.NetworkInfo r0 = r0.getActiveNetworkInfo()     // Catch: java.lang.Exception -> L77
            if (r0 != 0) goto L10
            r3 = 0
            return r3
        L10:
            int r1 = r0.getType()     // Catch: java.lang.Exception -> L77
            r2 = 1
            if (r1 != r2) goto L1b
            java.lang.String r3 = "WIFI"
            goto L83
        L1b:
            int r0 = r0.getType()     // Catch: java.lang.Exception -> L77
            if (r0 != 0) goto L81
            java.lang.String r0 = "phone"
            java.lang.Object r3 = r3.getSystemService(r0)     // Catch: java.lang.Exception -> L77
            android.telephony.TelephonyManager r3 = (android.telephony.TelephonyManager) r3     // Catch: java.lang.Exception -> L77
            if (r3 == 0) goto L81
            int r3 = r3.getNetworkType()     // Catch: java.lang.Exception -> L77
            switch(r3) {
                case 1: goto L5f;
                case 2: goto L5c;
                case 3: goto L59;
                case 4: goto L56;
                case 5: goto L53;
                case 6: goto L50;
                case 7: goto L4d;
                case 8: goto L4a;
                case 9: goto L47;
                case 10: goto L44;
                case 11: goto L41;
                case 12: goto L3e;
                case 13: goto L3b;
                case 14: goto L38;
                case 15: goto L35;
                default: goto L32;
            }     // Catch: java.lang.Exception -> L77
        L32:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L77
            goto L62
        L35:
            java.lang.String r3 = "HSPA+"
            goto L83
        L38:
            java.lang.String r3 = "eHRPD"
            goto L83
        L3b:
            java.lang.String r3 = "LTE"
            goto L83
        L3e:
            java.lang.String r3 = "EVDO_B"
            goto L83
        L41:
            java.lang.String r3 = "iDen"
            goto L83
        L44:
            java.lang.String r3 = "HSPA"
            goto L83
        L47:
            java.lang.String r3 = "HSUPA"
            goto L83
        L4a:
            java.lang.String r3 = "HSDPA"
            goto L83
        L4d:
            java.lang.String r3 = "1xRTT"
            goto L83
        L50:
            java.lang.String r3 = "EVDO_A"
            goto L83
        L53:
            java.lang.String r3 = "EVDO_0"
            goto L83
        L56:
            java.lang.String r3 = "CDMA"
            goto L83
        L59:
            java.lang.String r3 = "UMTS"
            goto L83
        L5c:
            java.lang.String r3 = "EDGE"
            goto L83
        L5f:
            java.lang.String r3 = "GPRS"
            goto L83
        L62:
            r0.<init>()     // Catch: java.lang.Exception -> L77
            java.lang.String r1 = "MOBILE("
            r0.append(r1)     // Catch: java.lang.Exception -> L77
            r0.append(r3)     // Catch: java.lang.Exception -> L77
            java.lang.String r3 = ")"
            r0.append(r3)     // Catch: java.lang.Exception -> L77
            java.lang.String r3 = r0.toString()     // Catch: java.lang.Exception -> L77
            goto L83
        L77:
            r3 = move-exception
            boolean r0 = com.tencent.bugly.proguard.X.b(r3)
            if (r0 != 0) goto L81
            r3.printStackTrace()
        L81:
            java.lang.String r3 = "unknown"
        L83:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.common.info.b.c(android.content.Context):java.lang.String");
    }

    public static String d(Context context) {
        String strA = ca.a(context, "ro.miui.ui.version.name");
        if (!ca.b(strA) && !strA.equals("fail")) {
            return c.a.a.a.a.i("XiaoMi/MIUI/", strA);
        }
        String strA2 = ca.a(context, "ro.build.version.emui");
        if (!ca.b(strA2) && !strA2.equals("fail")) {
            return c.a.a.a.a.i("HuaWei/EMOTION/", strA2);
        }
        String strA3 = ca.a(context, "ro.lenovo.series");
        if (!ca.b(strA3) && !strA3.equals("fail")) {
            return c.a.a.a.a.i("Lenovo/VIBE/", ca.a(context, "ro.build.version.incremental"));
        }
        String strA4 = ca.a(context, "ro.build.nubia.rom.name");
        if (!ca.b(strA4) && !strA4.equals("fail")) {
            StringBuilder sbU = c.a.a.a.a.u("Zte/NUBIA/", strA4, "_");
            sbU.append(ca.a(context, "ro.build.nubia.rom.code"));
            return sbU.toString();
        }
        String strA5 = ca.a(context, "ro.meizu.product.model");
        if (!ca.b(strA5) && !strA5.equals("fail")) {
            StringBuilder sbR = c.a.a.a.a.r("Meizu/FLYME/");
            sbR.append(ca.a(context, "ro.build.display.id"));
            return sbR.toString();
        }
        String strA6 = ca.a(context, "ro.build.version.opporom");
        if (!ca.b(strA6) && !strA6.equals("fail")) {
            return c.a.a.a.a.i("Oppo/COLOROS/", strA6);
        }
        String strA7 = ca.a(context, "ro.vivo.os.build.display.id");
        if (!ca.b(strA7) && !strA7.equals("fail")) {
            return c.a.a.a.a.i("vivo/FUNTOUCH/", strA7);
        }
        String strA8 = ca.a(context, "ro.aa.romver");
        if (!ca.b(strA8) && !strA8.equals("fail")) {
            StringBuilder sbU2 = c.a.a.a.a.u("htc/", strA8, w.DEFAULT_PATH_SEPARATOR);
            sbU2.append(ca.a(context, "ro.build.description"));
            return sbU2.toString();
        }
        String strA9 = ca.a(context, "ro.lewa.version");
        if (!ca.b(strA9) && !strA9.equals("fail")) {
            StringBuilder sbU3 = c.a.a.a.a.u("tcl/", strA9, w.DEFAULT_PATH_SEPARATOR);
            sbU3.append(ca.a(context, "ro.build.display.id"));
            return sbU3.toString();
        }
        String strA10 = ca.a(context, "ro.gn.gnromvernumber");
        if (!ca.b(strA10) && !strA10.equals("fail")) {
            StringBuilder sbU4 = c.a.a.a.a.u("amigo/", strA10, w.DEFAULT_PATH_SEPARATOR);
            sbU4.append(ca.a(context, "ro.build.display.id"));
            return sbU4.toString();
        }
        String strA11 = ca.a(context, "ro.build.tyd.kbstyle_version");
        if (!ca.b(strA11) && !strA11.equals("fail")) {
            return c.a.a.a.a.i("dido/", strA11);
        }
        return ca.a(context, "ro.build.fingerprint") + w.DEFAULT_PATH_SEPARATOR + ca.a(context, "ro.build.rom.id");
    }

    public static boolean f(Context context) {
        return (((g(context) | b()) | p()) | o()) > 0;
    }

    public static boolean a() {
        try {
            return Environment.getExternalStorageState().equals("mounted");
        } catch (Throwable th) {
            if (X.b(th)) {
                return false;
            }
            th.printStackTrace();
            return false;
        }
    }

    public static int g(Context context) {
        int i2;
        PackageManager packageManager = context.getPackageManager();
        try {
            packageManager.getInstallerPackageName("de.robv.android.xposed.installer");
            i2 = 1;
        } catch (Exception unused) {
            i2 = 0;
        }
        try {
            packageManager.getInstallerPackageName("com.saurik.substrate");
            return i2 | 2;
        } catch (Exception unused2) {
            return i2;
        }
    }

    public static String a(Context context, boolean z) {
        String property = null;
        if (z) {
            try {
                String strA = ca.a(context, "ro.product.cpu.abilist");
                if (ca.b(strA) || strA.equals("fail")) {
                    strA = ca.a(context, "ro.product.cpu.abi");
                }
                if (!ca.b(strA) && !strA.equals("fail")) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("ABI list: ");
                    sb.append(strA);
                    X.a(b.class, sb.toString(), new Object[0]);
                    property = strA.split(",")[0];
                }
            } catch (Throwable th) {
                if (!X.b(th)) {
                    th.printStackTrace();
                }
                return "fail";
            }
        }
        if (property == null) {
            property = System.getProperty("os.arch");
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("");
        sb2.append(property);
        return sb2.toString();
    }

    public static boolean i(Context context) {
        float fMaxMemory = (float) ((Runtime.getRuntime().maxMemory() * 1.0d) / 1048576.0d);
        float f2 = (float) ((Runtime.getRuntime().totalMemory() * 1.0d) / 1048576.0d);
        float f3 = fMaxMemory - f2;
        X.a("maxMemory : %f", Float.valueOf(fMaxMemory));
        X.a("totalMemory : %f", Float.valueOf(f2));
        X.a("freeMemory : %f", Float.valueOf(f3));
        return f3 < 10.0f;
    }

    public static boolean h(Context context) {
        return (e(context) == null && n() == null) ? false : true;
    }
}

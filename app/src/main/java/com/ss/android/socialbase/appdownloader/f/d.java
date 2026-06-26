package com.ss.android.socialbase.appdownloader.f;

import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ss.android.socialbase.appdownloader.g;
import com.ss.android.socialbase.downloader.i.f;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/* JADX INFO: compiled from: RomUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class d {
    public static String a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f3395b = "";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f3396c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static String f3397d = "";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static String f3398e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static String f3399f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static String f3400g;

    public static boolean a() {
        return a("EMUI");
    }

    public static boolean b() {
        return a("MIUI");
    }

    public static boolean c() {
        return a("VIVO");
    }

    public static boolean d() {
        o();
        return a(a);
    }

    public static boolean e() {
        return a("FLYME");
    }

    public static boolean f() {
        return a("SAMSUNG");
    }

    public static String g() {
        if (f3398e == null) {
            a("");
        }
        return f3398e;
    }

    public static String h() {
        if (f3399f == null) {
            a("");
        }
        return f3399f;
    }

    public static String i() {
        if (f3396c == null) {
            a("");
        }
        return f3396c;
    }

    @NonNull
    public static String j() {
        String str = Build.MANUFACTURER;
        return str == null ? "" : str.trim();
    }

    @NonNull
    public static String k() {
        String str = Build.DISPLAY;
        return str == null ? "" : str.trim();
    }

    public static boolean l() {
        p();
        return "V10".equals(f3400g);
    }

    public static boolean m() {
        p();
        return "V11".equals(f3400g);
    }

    public static boolean n() {
        p();
        return "V12".equals(f3400g);
    }

    private static void o() {
        if (TextUtils.isEmpty(a)) {
            com.ss.android.socialbase.downloader.downloader.c.F();
            a = com.ss.android.socialbase.downloader.constants.e.f3503b;
            f3397d = c.a.a.a.a.p(c.a.a.a.a.r("ro.build.version."), com.ss.android.socialbase.downloader.constants.e.f3504c, "rom");
            f3395b = c.a.a.a.a.p(c.a.a.a.a.r("com."), com.ss.android.socialbase.downloader.constants.e.f3504c, ".market");
        }
    }

    private static void p() {
        if (f3400g == null) {
            try {
                f3400g = d("ro.miui.ui.version.name");
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            String str = f3400g;
            if (str == null) {
                str = "";
            }
            f3400g = str;
        }
    }

    public static boolean a(String str) {
        o();
        String str2 = f3398e;
        if (str2 != null) {
            return str2.equals(str);
        }
        String strD = d("ro.miui.ui.version.name");
        f3399f = strD;
        if (TextUtils.isEmpty(strD)) {
            String strD2 = d("ro.build.version.emui");
            f3399f = strD2;
            if (TextUtils.isEmpty(strD2)) {
                String strD3 = d(f3397d);
                f3399f = strD3;
                if (TextUtils.isEmpty(strD3)) {
                    String strD4 = d("ro.vivo.os.version");
                    f3399f = strD4;
                    if (TextUtils.isEmpty(strD4)) {
                        String strD5 = d("ro.smartisan.version");
                        f3399f = strD5;
                        if (TextUtils.isEmpty(strD5)) {
                            String strD6 = d("ro.gn.sv.version");
                            f3399f = strD6;
                            if (TextUtils.isEmpty(strD6)) {
                                String strD7 = d("ro.lenovo.lvp.version");
                                f3399f = strD7;
                                if (!TextUtils.isEmpty(strD7)) {
                                    f3398e = "LENOVO";
                                    f3396c = "com.lenovo.leos.appstore";
                                } else if (j().toUpperCase().contains("SAMSUNG")) {
                                    f3398e = "SAMSUNG";
                                    f3396c = "com.sec.android.app.samsungapps";
                                } else if (j().toUpperCase().contains("ZTE")) {
                                    f3398e = "ZTE";
                                    f3396c = "zte.com.market";
                                } else if (j().toUpperCase().contains("NUBIA")) {
                                    f3398e = "NUBIA";
                                    f3396c = "cn.nubia.neostore";
                                } else if (k().toUpperCase().contains("FLYME")) {
                                    f3398e = "FLYME";
                                    f3396c = "com.meizu.mstore";
                                    f3399f = k();
                                } else if (j().toUpperCase().contains("ONEPLUS")) {
                                    f3398e = "ONEPLUS";
                                    f3399f = d("ro.rom.version");
                                    if (g.a(f3395b) > -1) {
                                        f3396c = f3395b;
                                    } else {
                                        f3396c = "com.heytap.market";
                                    }
                                } else {
                                    f3398e = j().toUpperCase();
                                    f3396c = "";
                                    f3399f = "";
                                }
                            } else {
                                f3398e = "QIONEE";
                                f3396c = "com.gionee.aora.market";
                            }
                        } else {
                            f3398e = "SMARTISAN";
                            f3396c = "com.smartisanos.appstore";
                        }
                    } else {
                        f3398e = "VIVO";
                        f3396c = "com.bbk.appstore";
                    }
                } else {
                    f3398e = a;
                    if (g.a(f3395b) > -1) {
                        f3396c = f3395b;
                    } else {
                        f3396c = "com.heytap.market";
                    }
                }
            } else {
                f3398e = "EMUI";
                f3396c = "com.huawei.appmarket";
            }
        } else {
            f3398e = "MIUI";
            f3396c = "com.xiaomi.market";
            f3400g = f3399f;
        }
        return f3398e.equals(str);
    }

    public static String b(String str) {
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop " + str).getInputStream()), 1024);
        } catch (Throwable unused) {
            bufferedReader = null;
        }
        try {
            String line = bufferedReader.readLine();
            bufferedReader.close();
            f.a(bufferedReader);
            return line;
        } catch (Throwable unused2) {
            f.a(bufferedReader);
            return null;
        }
    }

    public static String c(String str) {
        return (String) Class.forName("android.os.SystemProperties").getMethod("get", String.class).invoke(null, str);
    }

    public static String d(String str) {
        if (com.ss.android.socialbase.downloader.g.a.b().optBoolean("enable_reflect_system_properties", true)) {
            try {
                return c(str);
            } catch (Throwable th) {
                th.printStackTrace();
                return b(str);
            }
        }
        return b(str);
    }
}

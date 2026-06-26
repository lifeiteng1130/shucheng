package com.uc.crashsdk.a;

import com.tencent.bugly.beta.tinker.TinkerUtils;
import com.umeng.analytics.pro.ai;
import com.umeng.commonsdk.framework.UMModuleRegister;

/* JADX INFO: compiled from: ProGuard */
/* JADX INFO: loaded from: classes.dex */
public class d {
    public static final /* synthetic */ boolean a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f4507b = true;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static boolean f4509d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static String f4510e = "hsdk";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static String f4511f = "alid ";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static String f4512g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static String f4514i;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Object f4508c = new Object();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final Object f4513h = new Object();

    public static void a() {
        f.a(0, new e(500), com.uc.crashsdk.b.E() ? 900000L : 90000L);
    }

    public static String b() {
        try {
            return "inv" + f4511f + "cras" + f4510e;
        } catch (Throwable th) {
            g.b(th);
            return "";
        }
    }

    public static byte[] c() {
        return new byte[]{6, 0, 23, 8};
    }

    public static boolean d() {
        if (!com.uc.crashsdk.e.E() && !com.uc.crashsdk.b.I()) {
            a(true);
            return f4507b;
        }
        return true;
    }

    private static String e() {
        if (g.a(f4514i)) {
            synchronized (f4513h) {
                f4514i = g.a(com.uc.crashsdk.b.g(), (com.uc.crashsdk.g.P() ? "https://errlogos.umeng.com" : "https://errlog.umeng.com") + "/api/crashsdk/validate", true);
            }
        }
        return f4514i;
    }

    private static String f() {
        byte[] bArrA;
        String strE;
        byte[] bArrA2;
        byte[] bArrA3;
        StringBuilder sb = new StringBuilder();
        a(sb, TinkerUtils.PLATFORM, com.uc.crashsdk.g.e());
        a(sb, "pkgname", com.uc.crashsdk.a.a);
        a(sb, UMModuleRegister.PROCESS, com.uc.crashsdk.e.h());
        a(sb, "version", com.uc.crashsdk.a.a());
        a(sb, "cver", "3.2.0.4");
        a(sb, "ctag", "release");
        a(sb, "inter", com.uc.crashsdk.g.P() ? "true" : "false");
        a(sb, ai.x, "android");
        String string = sb.toString();
        byte[] bArr = new byte[16];
        c.a(bArr, 0, h.j());
        c.a(bArr, 4, c.a());
        c.a(bArr, 8, c());
        c.a(bArr, 12, com.uc.crashsdk.a.f());
        try {
            bArrA = c.a(string.getBytes(), bArr, true);
        } catch (Throwable th) {
            g.a(th);
            bArrA = null;
        }
        if (bArrA == null || (strE = e()) == null || (bArrA2 = c.a(strE, bArrA)) == null) {
            return null;
        }
        try {
            bArrA3 = c.a(bArrA2, bArr, false);
        } catch (Throwable th2) {
            g.a(th2);
            bArrA3 = null;
        }
        if (bArrA3 != null) {
            return new String(bArrA3);
        }
        return null;
    }

    public static void a(int i2) {
        if (i2 != 500) {
            if (!a) {
                throw new AssertionError();
            }
            return;
        }
        synchronized (f4508c) {
            f4512g = null;
            a(!com.uc.crashsdk.b.C());
            if (g.b(f4512g)) {
                h.a(f4512g);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0052  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static boolean a(boolean r12) {
        /*
            Method dump skipped, instruction units count: 396
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.a.d.a(boolean):boolean");
    }

    private static StringBuilder a(StringBuilder sb, String str, String str2) {
        if (sb.length() > 0) {
            sb.append("`");
        }
        sb.append(str);
        sb.append("=");
        sb.append(str2);
        return sb;
    }
}

package com.uc.crashsdk.a;

import android.os.Build;
import android.os.Process;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseArray;
import androidx.core.os.EnvironmentCompat;
import com.tencent.bugly.beta.tinker.TinkerReport;
import com.uc.crashsdk.JNIBridge;
import com.umeng.analytics.pro.ai;
import com.umeng.commonsdk.statistics.SdkVersion;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: compiled from: ProGuard */
/* JADX INFO: loaded from: classes.dex */
public class h {
    public static final /* synthetic */ boolean a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Object f4534b = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Map<String, String> f4535c = new HashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static int f4536d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Map<String, a> f4537e = new HashMap();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Object f4538f = new Object();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Object f4539g = new Object();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final SparseArray<String> f4540h = new SparseArray<>();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static boolean f4541i = false;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static boolean f4542j = false;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final Object f4543k = new Object();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static String f4544l = null;

    /* JADX INFO: compiled from: ProGuard */
    public static class a {
        public long a = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f4545b = 0;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Map<String, String> f4546c = new HashMap();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private String f4547d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f4548e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f4549f;

        public a(String str, boolean z, boolean z2) {
            this.f4548e = false;
            this.f4549f = false;
            this.f4547d = str;
            this.f4548e = z;
            this.f4549f = z2;
        }

        private long d(String str) {
            return g.c(a(str));
        }

        public final void a(String str, String str2) {
            this.f4546c.put(str, str2);
        }

        public final String b(String str) {
            String strA = a(str);
            return strA == null ? "" : strA;
        }

        public final boolean c(String str) {
            if (g.a(str)) {
                return false;
            }
            String str2 = null;
            long jC = 0;
            HashMap map = new HashMap();
            Map mapC = h.c(str);
            int iC = 0;
            for (String str3 : mapC.keySet()) {
                String str4 = (String) mapC.get(str3);
                if (str3.equals("lt")) {
                    str2 = str4;
                } else if (this.f4548e && str3.equals("up")) {
                    jC = g.c(str4);
                } else if (this.f4548e && str3.equals("pid")) {
                    iC = (int) g.c(str4);
                } else {
                    map.put(str3, str4);
                }
            }
            String str5 = this.f4547d;
            if (str5 != null && !str5.equals(str2)) {
                return false;
            }
            this.a = jC;
            this.f4545b = iC;
            this.f4547d = str2;
            this.f4546c = map;
            return true;
        }

        public final void a(String str, long j2) {
            long jD = d(str) + j2;
            if (jD <= 100) {
                j2 = jD < 0 ? 0L : jD;
            }
            a(str, String.valueOf(j2));
        }

        public final boolean a(a aVar) {
            if (!this.f4549f) {
                com.uc.crashsdk.a.a.a("crashsdk", String.format(Locale.US, "WaItem '%s' is not mergable!", this.f4547d), null);
                return false;
            }
            for (String str : aVar.f4546c.keySet()) {
                if (str.startsWith("c_")) {
                    a(str, aVar.a(str));
                } else {
                    long jD = aVar.d(str);
                    if (jD == 0) {
                        a(str, aVar.a(str));
                    } else if (jD < 100) {
                        a(str, jD);
                    }
                }
            }
            return true;
        }

        public final String a(String str) {
            return this.f4546c.get(str);
        }

        public final String a(boolean z, boolean z2, boolean z3) {
            if (this.f4547d == null) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            if (z) {
                h.b(sb, "lt", "uc");
                h.b(sb, "pre", com.uc.crashsdk.g.e());
                h.b(sb, "pkg", com.uc.crashsdk.a.a);
                h.b(sb, "rom", Build.VERSION.RELEASE);
                h.b(sb, "brd", Build.BRAND);
                h.b(sb, "model", Build.MODEL);
                h.a(sb, "sdk", Build.VERSION.SDK_INT);
                h.b(sb, ai.w, com.uc.crashsdk.e.e());
                h.b(sb, "hdw", com.uc.crashsdk.e.f());
                long jN = h.n();
                h.a(sb, "ram", jN);
                h.b(sb, "aram", h.a(jN));
                h.b(sb, "cver", "3.2.0.4");
                h.b(sb, "cseq", "210105150455");
                h.b(sb, "ctag", "release");
                h.b(sb, "aver", com.uc.crashsdk.a.a());
                h.b(sb, "ver", com.uc.crashsdk.g.R());
                h.b(sb, "sver", com.uc.crashsdk.g.S());
                h.b(sb, "seq", com.uc.crashsdk.g.T());
                h.b(sb, "grd", com.uc.crashsdk.b.x() ? "fg" : "bg");
                h.b(sb, ai.x, "android");
                sb.append("\n");
            }
            h.b(sb, "lt", this.f4547d);
            h.a(sb, this.f4546c);
            if (this.f4548e && !z2) {
                long j2 = this.a;
                if (j2 != 0) {
                    h.b(sb, "up", String.valueOf(j2));
                }
                if (z3) {
                    h.b(sb, "pid", String.format(Locale.US, "%d", Integer.valueOf(Process.myPid())));
                } else {
                    int i2 = this.f4545b;
                    if (i2 != 0) {
                        h.b(sb, "pid", String.format(Locale.US, "%d", Integer.valueOf(i2)));
                    }
                }
            }
            sb.append("\n");
            return sb.toString();
        }
    }

    public static /* synthetic */ String a(long j2) {
        return j2 < PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED ? "512M" : String.format(Locale.US, "%dG", Long.valueOf(((j2 / 1024) + 512) / 1024));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(StringBuilder sb, String str, String str2) {
        c.a.a.a.a.z(sb, str, "=", str2, "`");
    }

    public static /* synthetic */ Map c(String str) {
        HashMap map = new HashMap();
        for (String str2 : str.split("`")) {
            if (str2.length() > 1) {
                String[] strArrSplit = str2.split("=", 3);
                if (strArrSplit.length == 2) {
                    map.put(strArrSplit[0], strArrSplit[1]);
                }
            }
        }
        return map;
    }

    public static void d() {
        b(2, 2000L);
        a(1, 70000L);
    }

    public static boolean e() {
        return f4542j;
    }

    public static void f() {
        b(1, 2000L);
    }

    public static void g() {
        b(3, 0L);
    }

    public static void h() {
        b(4, 0L);
    }

    public static void i() {
        if (com.uc.crashsdk.g.O()) {
            f.a(1, new e(303));
        }
    }

    public static byte[] j() {
        return new byte[]{127, 100, 110, 31};
    }

    private static String l() {
        return com.uc.crashsdk.g.U() + "pv.wa";
    }

    private static String m() {
        return com.uc.crashsdk.g.U() + "cdt.wa";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long n() {
        Iterator<String> it = g.a(new File("/proc/meminfo"), 2).iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            String next = it.next();
            if (next.contains("MemTotal:")) {
                try {
                    return Long.parseLong(next.replaceAll("\\D+", ""));
                } catch (NumberFormatException e2) {
                    g.a(e2);
                    return 0L;
                }
            }
        }
    }

    private static String o() {
        if (g.a(f4544l)) {
            synchronized (f4543k) {
                f4544l = g.a(com.uc.crashsdk.b.h(), com.uc.crashsdk.g.P() ? "https://errlogos.umeng.com/api/crashsdk/logcollect" : "https://errlog.umeng.com/api/crashsdk/logcollect", true);
            }
        }
        return f4544l;
    }

    public static /* synthetic */ void a(StringBuilder sb, String str, long j2) {
        b(sb, str, String.valueOf(j2));
    }

    public static void b() {
        a(2, 0L);
    }

    public static void c() {
        a(3, 0L);
    }

    private static void b(int i2, long j2) {
        if (com.uc.crashsdk.g.O()) {
            f.a(1, new e(301, new Object[]{Integer.valueOf(i2)}), j2);
        }
    }

    private static boolean d(String str) {
        File file = new File(str);
        for (a aVar : a(file, "cst", 30)) {
            String strA = aVar.a("prc");
            if (!g.a(strA)) {
                Map<String, a> map = f4537e;
                a aVar2 = map.get(strA);
                if (aVar2 != null) {
                    aVar2.a(aVar);
                } else {
                    map.put(strA, aVar);
                }
            }
        }
        Map<String, a> map2 = f4537e;
        boolean zB = b(com.uc.crashsdk.e.p(), a((Iterable<a>) map2.values(), true, false).toString());
        g.b(file);
        if (zB || g.a(file, a((Iterable<a>) map2.values(), false, true).toString())) {
            map2.clear();
        }
        return true;
    }

    public static /* synthetic */ void a(StringBuilder sb, Map map) {
        for (String str : map.keySet()) {
            b(sb, str, (String) map.get(str));
        }
    }

    public static void a(String str) {
        synchronized (f4534b) {
            File file = new File(l());
            a aVar = new a("pv", true, true);
            String strC = g.c(file);
            if (!g.a(strC)) {
                aVar.c(strC);
            }
            aVar.a(str, 1L);
            aVar.a("aujv", 1L);
            g.a(file, aVar.a(false, false, false));
        }
    }

    public static boolean b(int i2, Object[] objArr) {
        switch (i2) {
            case TinkerReport.KEY_LOADED_PACKAGE_CHECK_DEX_META /* 351 */:
                if (!a && objArr == null) {
                    throw new AssertionError();
                }
                String str = (String) objArr[0];
                int iIntValue = ((Integer) objArr[1]).intValue();
                if (iIntValue == 1) {
                    if (f4542j) {
                        return false;
                    }
                    f4542j = true;
                }
                File file = new File(str);
                ArrayList<a> arrayListA = a(file, "crp", 100);
                if (iIntValue != 4) {
                    a aVar = new a("crp", false, false);
                    String str2 = SdkVersion.MINI_VERSION;
                    if (iIntValue == 1) {
                        aVar.a("et", String.valueOf(com.uc.crashsdk.b.F()));
                        aVar.a("ete", String.valueOf(com.uc.crashsdk.b.G()));
                    } else if (iIntValue == 3) {
                        aVar.a("et", SdkVersion.MINI_VERSION);
                        aVar.a("ete", SdkVersion.MINI_VERSION);
                    } else if (iIntValue == 2) {
                        aVar.a("hpv", SdkVersion.MINI_VERSION);
                    }
                    aVar.a("prc", com.uc.crashsdk.e.h());
                    if (!com.uc.crashsdk.b.C()) {
                        str2 = "0";
                    }
                    aVar.a("imp", str2);
                    a(aVar);
                    arrayListA.add(0, aVar);
                }
                if (!arrayListA.isEmpty()) {
                    boolean zB = b(com.uc.crashsdk.e.p(), a((Iterable<a>) arrayListA, true, false).toString());
                    g.b(file);
                    if (!zB) {
                        g.a(file, a((Iterable<a>) arrayListA, false, true).toString());
                    }
                }
                return true;
            case TinkerReport.KEY_LOADED_PACKAGE_CHECK_LIB_META /* 352 */:
                if (a || objArr != null) {
                    return d((String) objArr[0]);
                }
                throw new AssertionError();
            case TinkerReport.KEY_LOADED_PACKAGE_CHECK_APK_TINKER_ID_NOT_FOUND /* 353 */:
                if (a || objArr != null) {
                    return b((String) objArr[0], (String) objArr[1], ((Boolean) objArr[2]).booleanValue(), ((Boolean) objArr[3]).booleanValue());
                }
                throw new AssertionError();
            case TinkerReport.KEY_LOADED_PACKAGE_CHECK_PATCH_TINKER_ID_NOT_FOUND /* 354 */:
                if (!a && objArr == null) {
                    throw new AssertionError();
                }
                File file2 = new File((String) objArr[0]);
                boolean zB2 = b(com.uc.crashsdk.e.p(), a((Iterable<a>) a(file2, "cst", 30), true, false).toString());
                if (zB2) {
                    g.b(file2);
                }
                return zB2;
            default:
                return false;
        }
    }

    public static void a() {
        a(0, com.uc.crashsdk.b.E() ? 700000L : 70000L);
    }

    private static void a(int i2, long j2) {
        if (com.uc.crashsdk.b.C()) {
            f.a(0, new e(302, new Object[]{Integer.valueOf(i2)}), j2);
        }
    }

    public static boolean a(String str, String str2) {
        try {
            String str3 = "c_" + str.replaceAll("[^0-9a-zA-Z-_]", "-");
            String strReplaceAll = g.a(str2) ? "" : str2.replaceAll("[`=]", "-");
            Map<String, String> map = f4535c;
            synchronized (map) {
                if (map.get(str3) == null) {
                    int i2 = f4536d;
                    if (i2 >= 20) {
                        return false;
                    }
                    f4536d = i2 + 1;
                }
                map.put(str3, strReplaceAll);
                return true;
            }
        } catch (Throwable th) {
            g.a(th);
            return false;
        }
    }

    public static void b(boolean z) {
        if (a(z, "crash detail upload")) {
            return;
        }
        String str = com.uc.crashsdk.g.U() + "dt.wa";
        com.uc.crashsdk.b.a(f4538f, str, new e(TinkerReport.KEY_LOADED_PACKAGE_CHECK_LIB_META, new Object[]{str}));
        String strM = m();
        com.uc.crashsdk.b.a(f4539g, strM, new e(TinkerReport.KEY_LOADED_PACKAGE_CHECK_PATCH_TINKER_ID_NOT_FOUND, new Object[]{strM}));
    }

    private static boolean b(String str, String str2, boolean z, boolean z2) {
        a aVar;
        File file = new File(m());
        ArrayList<a> arrayListA = a(file, "cst", 30);
        String strI = c.a.a.a.a.i(str, str2);
        Iterator<a> it = arrayListA.iterator();
        while (true) {
            if (!it.hasNext()) {
                aVar = null;
                break;
            }
            aVar = it.next();
            if (strI.equals(aVar.b("prc") + aVar.b("typ"))) {
                break;
            }
        }
        if (aVar == null) {
            aVar = new a("cst", false, true);
            aVar.a("prc", str);
            aVar.a("typ", str2);
            a(aVar);
            arrayListA.add(aVar);
        }
        aVar.a("cnt", 1L);
        if (z) {
            aVar.a("lim", 1L);
        }
        if (z2) {
            aVar.a("syu", 1L);
        }
        return g.a(file, a((Iterable<a>) arrayListA, false, false).toString());
    }

    private static void a(a aVar) {
        Map<String, String> map = f4535c;
        synchronized (map) {
            for (String str : map.keySet()) {
                aVar.a(str, f4535c.get(str));
            }
        }
    }

    public static void a(boolean z) {
        a(1, z);
    }

    public static boolean a(boolean z, String str) {
        if (!com.uc.crashsdk.b.f4552d || z || !JNIBridge.nativeIsCrashing()) {
            return false;
        }
        com.uc.crashsdk.a.a.b("crashsdk", "Native is crashing, skip stat for " + str);
        return true;
    }

    private static void a(int i2, boolean z) {
        if (a(z, "crash rate")) {
            return;
        }
        String str = com.uc.crashsdk.g.U() + "cr.wa";
        com.uc.crashsdk.b.a(f4534b, str, new e(TinkerReport.KEY_LOADED_PACKAGE_CHECK_DEX_META, new Object[]{str, Integer.valueOf(i2)}));
    }

    private static boolean b(String str, String str2) {
        byte[] bArrA;
        boolean z;
        String string;
        byte[] bArrA2;
        if (g.a(str2)) {
            return true;
        }
        byte[] bytes = str2.getBytes();
        try {
            byte[] bArr = new byte[16];
            c.a(bArr, 0, c.a());
            c.a(bArr, 4, j());
            c.a(bArr, 8, com.uc.crashsdk.a.f());
            c.a(bArr, 12, d.c());
            bArrA = c.a(bytes, bArr);
        } catch (Throwable th) {
            g.a(th);
        }
        if (bArrA != null) {
            z = true;
        } else {
            bArrA = bytes;
            z = false;
        }
        if (str == null) {
            str = EnvironmentCompat.MEDIA_UNKNOWN;
        }
        String str3 = com.uc.crashsdk.g.P() ? "4ea4e41a3993" : "28ef1713347d";
        String strValueOf = String.valueOf(System.currentTimeMillis());
        String strD = g.d(str3 + str + strValueOf + "AppChk#2014");
        if (strD == null) {
            string = null;
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(o());
            sb.append("?chk=");
            sb.append(strD.substring(strD.length() - 8, strD.length()));
            sb.append("&vno=");
            sb.append(strValueOf);
            c.a.a.a.a.z(sb, "&uuid=", str, "&app=", str3);
            if (z) {
                sb.append("&enc=aes");
            }
            string = sb.toString();
        }
        return (string == null || (bArrA2 = c.a(string, bArrA)) == null || !new String(bArrA2).contains("retcode=0")) ? false : true;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0040 A[Catch: all -> 0x00cb, TryCatch #0 {, blocks: (B:17:0x001d, B:19:0x0028, B:21:0x002c, B:53:0x00c9, B:22:0x002e, B:24:0x0038, B:26:0x0040, B:28:0x005a, B:30:0x005f, B:37:0x0070, B:38:0x0077, B:44:0x008b, B:46:0x0097, B:51:0x00af, B:52:0x00c2, B:49:0x00a5, B:43:0x0083), top: B:68:0x001d }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x005a A[Catch: all -> 0x00cb, TryCatch #0 {, blocks: (B:17:0x001d, B:19:0x0028, B:21:0x002c, B:53:0x00c9, B:22:0x002e, B:24:0x0038, B:26:0x0040, B:28:0x005a, B:30:0x005f, B:37:0x0070, B:38:0x0077, B:44:0x008b, B:46:0x0097, B:51:0x00af, B:52:0x00c2, B:49:0x00a5, B:43:0x0083), top: B:68:0x001d }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x005f A[Catch: all -> 0x00cb, TryCatch #0 {, blocks: (B:17:0x001d, B:19:0x0028, B:21:0x002c, B:53:0x00c9, B:22:0x002e, B:24:0x0038, B:26:0x0040, B:28:0x005a, B:30:0x005f, B:37:0x0070, B:38:0x0077, B:44:0x008b, B:46:0x0097, B:51:0x00af, B:52:0x00c2, B:49:0x00a5, B:43:0x0083), top: B:68:0x001d }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00a5 A[Catch: all -> 0x00cb, TryCatch #0 {, blocks: (B:17:0x001d, B:19:0x0028, B:21:0x002c, B:53:0x00c9, B:22:0x002e, B:24:0x0038, B:26:0x0040, B:28:0x005a, B:30:0x005f, B:37:0x0070, B:38:0x0077, B:44:0x008b, B:46:0x0097, B:51:0x00af, B:52:0x00c2, B:49:0x00a5, B:43:0x0083), top: B:68:0x001d }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00af A[Catch: all -> 0x00cb, TryCatch #0 {, blocks: (B:17:0x001d, B:19:0x0028, B:21:0x002c, B:53:0x00c9, B:22:0x002e, B:24:0x0038, B:26:0x0040, B:28:0x005a, B:30:0x005f, B:37:0x0070, B:38:0x0077, B:44:0x008b, B:46:0x0097, B:51:0x00af, B:52:0x00c2, B:49:0x00a5, B:43:0x0083), top: B:68:0x001d }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void a(int r9, java.lang.Object[] r10) {
        /*
            Method dump skipped, instruction units count: 248
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.a.h.a(int, java.lang.Object[]):void");
    }

    public static void b(String str) {
        synchronized (f4543k) {
            f4544l = str;
            b.a(com.uc.crashsdk.b.h(), f4544l + "\n");
        }
    }

    private static StringBuilder a(Iterable<a> iterable, boolean z, boolean z2) {
        StringBuilder sb = new StringBuilder();
        boolean z3 = true;
        for (a aVar : iterable) {
            if (z3) {
                sb.append(aVar.a(z, z, z2));
                z3 = false;
            } else {
                sb.append(aVar.a(false, z, z2));
            }
        }
        return sb;
    }

    public static void a(String str, int i2, int i3) {
        if (com.uc.crashsdk.g.O()) {
            synchronized (f4538f) {
                Map<String, a> map = f4537e;
                a aVar = map.get(str);
                if (aVar == null) {
                    aVar = new a("cst", false, true);
                    map.put(str, aVar);
                    a(aVar);
                }
                SparseArray<String> sparseArray = f4540h;
                synchronized (sparseArray) {
                    if (sparseArray.size() == 0) {
                        a(100, "pv");
                        a(102, "hpv");
                        a(1, "all");
                        a(2, "afg");
                        a(101, "abg");
                        a(3, "jfg");
                        a(4, "jbg");
                        a(7, "nfg");
                        a(8, "nbg");
                        a(27, "nafg");
                        a(28, "nabg");
                        a(9, "nho");
                        a(10, "uar");
                        a(29, "ulm");
                        a(30, "ukt");
                        a(31, "uet");
                        a(32, "urs");
                        a(11, "ufg");
                        a(12, "ubg");
                        a(40, "anf");
                        a(41, "anb");
                        a(42, "ancf");
                        a(43, "ancb");
                        a(13, "lup");
                        a(14, "luf");
                        a(15, "lef");
                        a(200, "ltf");
                        a(16, "laf");
                        a(22, "lac");
                        a(23, "lau");
                        a(17, "llf");
                        a(18, "lul");
                        a(19, "lub");
                        a(20, "luc");
                        a(21, "luu");
                        a(24, "lzc");
                        a(201, "lec");
                        a(25, "lrc");
                        a(26, "lss");
                    }
                }
                String str2 = sparseArray.get(i2);
                if (str2 == null) {
                    com.uc.crashsdk.a.a.a("crashsdk", "map key is not set with: " + i2, null);
                }
                aVar.a("prc", str);
                if (str2 != null) {
                    aVar.a(str2, String.valueOf(i3));
                }
            }
        }
    }

    public static boolean a(String str, String str2, boolean z, boolean z2) {
        if (!com.uc.crashsdk.g.O()) {
            return false;
        }
        return com.uc.crashsdk.b.a(f4539g, m(), new e(TinkerReport.KEY_LOADED_PACKAGE_CHECK_APK_TINKER_ID_NOT_FOUND, new Object[]{str, str2, Boolean.valueOf(z), Boolean.valueOf(z2)}));
    }

    private static void a(int i2, String str) {
        f4540h.put(i2, str);
    }

    private static ArrayList<a> a(File file, String str, int i2) {
        ArrayList<String> arrayListA = g.a(file, i2);
        ArrayList<a> arrayList = new ArrayList<>();
        for (String str2 : arrayListA) {
            a aVar = new a(str, false, false);
            if (aVar.c(str2)) {
                arrayList.add(aVar);
            }
        }
        return arrayList;
    }
}

package com.uc.crashsdk;

import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Debug;
import android.os.ParcelFileDescriptor;
import android.os.Process;
import android.os.StatFs;
import android.os.StrictMode;
import androidx.core.app.NotificationCompat;
import androidx.core.os.EnvironmentCompat;
import com.qq.e.comm.constants.Constants;
import com.tencent.bugly.beta.tinker.TinkerReport;
import com.uc.crashsdk.a.h;
import com.uc.crashsdk.export.LogType;
import h.a.a.a.w;
import j$.util.Comparator;
import j$.util.function.Function;
import j$.util.function.ToDoubleFunction;
import j$.util.function.ToIntFunction;
import j$.util.function.ToLongFunction;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.RandomAccessFile;
import java.lang.Thread;
import java.lang.reflect.Method;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jsoup.helper.DataUtil;
import org.mozilla.javascript.Token;

/* JADX INFO: compiled from: ProGuard */
/* JADX INFO: loaded from: classes.dex */
public class e implements Thread.UncaughtExceptionHandler {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static long f4568b;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static String f4574i;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final List<FileInputStream> f4578e = new ArrayList();
    public static final /* synthetic */ boolean a = true;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final AtomicBoolean f4569c = new AtomicBoolean(false);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static boolean f4570d = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static long f4571f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static long f4572g = -1;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static boolean f4573h = true;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static String f4575j = "";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static String f4576k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static String f4577l = null;
    private static String m = null;
    private static final Object n = new Object();
    private static final Object o = new Object();
    private static final Object p = new Object();
    private static final Object q = new Object();
    private static final ArrayList<String> r = new ArrayList<>();
    private static int s = 0;
    private static String t = null;
    private static boolean u = false;
    private static String v = null;
    private static String w = null;
    private static String x = null;
    private static final Object y = new Object();
    private static final Object z = new Object();
    private static Map<String, Integer> A = null;
    private static String B = null;
    private static int C = -1;
    private static int D = -1;
    private static int E = -1;
    private static int F = -1;
    private static int G = -1;
    private static int H = -1;
    private static int I = -1;
    private static String J = "?";
    private static boolean K = false;
    private static boolean L = false;
    private static int M = 0;
    private static int N = 0;
    private static boolean O = false;
    private static com.uc.crashsdk.a.e P = new com.uc.crashsdk.a.e(405);
    private static c Q = new c(0);
    private static boolean R = false;
    private static final com.uc.crashsdk.a.e S = new com.uc.crashsdk.a.e(412);
    private static Thread.UncaughtExceptionHandler T = null;
    private static Throwable U = null;
    private static boolean V = false;
    private static boolean W = false;
    private static Runnable X = null;
    private static final Object Y = new Object();
    private static int Z = 101;
    private static Runnable aa = new com.uc.crashsdk.a.e(407);
    private static final Object ab = new Object();
    private static boolean ac = false;
    private static ParcelFileDescriptor ad = null;
    private static boolean ae = false;
    private static boolean af = false;

    /* JADX INFO: compiled from: ProGuard */
    public static class b implements Comparator<File>, j$.util.Comparator {
        private b() {
        }

        @Override // java.util.Comparator, j$.util.Comparator
        public final /* synthetic */ int compare(Object obj, Object obj2) {
            File file = (File) obj;
            File file2 = (File) obj2;
            if (file.lastModified() > file2.lastModified()) {
                return 1;
            }
            return file.lastModified() < file2.lastModified() ? -1 : 0;
        }

        @Override // java.util.Comparator, j$.util.Comparator
        public /* synthetic */ Comparator reversed() {
            return Collections.reverseOrder(this);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ Comparator thenComparing(Function function) {
            return Comparator.CC.$default$thenComparing(this, function);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparing(Function function, java.util.Comparator comparator) {
            return Comparator.CC.$default$thenComparing(this, function, comparator);
        }

        @Override // java.util.Comparator, j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparing(java.util.Comparator comparator) {
            return Comparator.CC.$default$thenComparing(this, comparator);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparingDouble(ToDoubleFunction toDoubleFunction) {
            return Comparator.CC.$default$thenComparingDouble(this, toDoubleFunction);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparingInt(ToIntFunction toIntFunction) {
            return Comparator.CC.$default$thenComparingInt(this, toIntFunction);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparingLong(ToLongFunction toLongFunction) {
            return Comparator.CC.$default$thenComparingLong(this, toLongFunction);
        }

        public /* synthetic */ b(byte b2) {
            this();
        }
    }

    /* JADX INFO: compiled from: ProGuard */
    public static class c extends BroadcastReceiver {
        private c() {
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (!"android.intent.action.BATTERY_CHANGED".equals(action)) {
                if ("android.intent.action.BATTERY_LOW".equals(action) || "android.intent.action.BATTERY_OKAY".equals(action)) {
                    boolean unused = e.K = "android.intent.action.BATTERY_LOW".equals(action);
                    e.J();
                    return;
                } else {
                    if ("android.intent.action.ANR".equals(action)) {
                        try {
                            e.d(context);
                            return;
                        } catch (Throwable th) {
                            com.uc.crashsdk.a.g.a(th);
                            return;
                        }
                    }
                    return;
                }
            }
            int unused2 = e.C = intent.getIntExtra("level", -1);
            int unused3 = e.D = intent.getIntExtra("scale", -1);
            int unused4 = e.E = intent.getIntExtra("voltage", -1);
            int unused5 = e.F = intent.getIntExtra("health", -1);
            int unused6 = e.G = intent.getIntExtra("plugged", -1);
            int unused7 = e.H = intent.getIntExtra(NotificationCompat.CATEGORY_STATUS, -1);
            int unused8 = e.I = intent.getIntExtra("temperature", -1);
            String unused9 = e.J = intent.getStringExtra("technology");
            if (e.I() >= 2) {
                e.J();
                e.K();
            }
        }

        public /* synthetic */ c(byte b2) {
            this();
        }
    }

    public e() {
        try {
            L();
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
        }
    }

    public static void A() {
        if (ac || com.uc.crashsdk.b.I()) {
            return;
        }
        com.uc.crashsdk.a.f.a(1, new com.uc.crashsdk.a.e(408), 1000L);
    }

    public static void B() {
        com.uc.crashsdk.a.f.a(1, new com.uc.crashsdk.a.e(409), 7000L);
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0011  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void C() {
        /*
            int r0 = com.uc.crashsdk.g.L()
            r1 = 4
            r2 = 3
            r3 = 1
            r4 = 0
            if (r0 == 0) goto L13
            if (r0 == r2) goto L13
            if (r0 != r1) goto Lf
            goto L13
        Lf:
            if (r0 != r3) goto L3f
        L11:
            r3 = 0
            goto L3f
        L13:
            int r5 = android.os.Build.VERSION.SDK_INT
            r6 = 25
            if (r5 > r6) goto L3f
            if (r0 != 0) goto L1d
            r5 = 0
            goto L1e
        L1d:
            r5 = 1
        L1e:
            r6 = 0
            if (r0 != r2) goto L30
            long r8 = java.lang.System.currentTimeMillis()
            r10 = 10
            long r8 = r8 % r10
            int r2 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r2 != 0) goto L2f
            r5 = 1
            goto L30
        L2f:
            r5 = 0
        L30:
            if (r0 != r1) goto L3e
            long r0 = java.lang.System.currentTimeMillis()
            r8 = 3
            long r0 = r0 % r8
            int r2 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r2 != 0) goto L11
            goto L3f
        L3e:
            r3 = r5
        L3f:
            if (r3 != 0) goto L48
            java.lang.String r0 = "crashsdk"
            java.lang.String r1 = "SIG 3 is disabled by settings"
            com.uc.crashsdk.a.a.a(r0, r1)
        L48:
            boolean r0 = com.uc.crashsdk.b.I()
            android.os.Looper r1 = android.os.Looper.getMainLooper()
            android.os.Looper r2 = android.os.Looper.myLooper()
            if (r1 == r2) goto L64
            if (r3 == 0) goto L64
            r1 = 2
            com.uc.crashsdk.a.e r2 = new com.uc.crashsdk.a.e
            r3 = 413(0x19d, float:5.79E-43)
            r2.<init>(r3)
            com.uc.crashsdk.a.f.a(r1, r2)
            goto L65
        L64:
            r4 = r3
        L65:
            r1 = 7
            long r2 = (long) r0
            r0 = 0
            com.uc.crashsdk.JNIBridge.nativeCmd(r1, r2, r0, r0)
            if (r4 == 0) goto L72
            r0 = 8
            com.uc.crashsdk.JNIBridge.cmd(r0)
        L72:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.e.C():void");
    }

    public static ParcelFileDescriptor D() {
        if (!com.uc.crashsdk.b.f4552d) {
            com.uc.crashsdk.a.a.d("crashsdk", "Crash so is not loaded!");
            return null;
        }
        ParcelFileDescriptor parcelFileDescriptor = ad;
        if (parcelFileDescriptor != null) {
            return parcelFileDescriptor;
        }
        int iCmd = (int) JNIBridge.cmd(14);
        if (iCmd == -1) {
            return null;
        }
        ParcelFileDescriptor parcelFileDescriptorAdoptFd = ParcelFileDescriptor.adoptFd(iCmd);
        ad = parcelFileDescriptorAdoptFd;
        ae = true;
        return parcelFileDescriptorAdoptFd;
    }

    public static boolean E() {
        return af;
    }

    public static void F() {
        String strV = g.V();
        File file = new File(strV);
        if (file.exists() && file.isDirectory()) {
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles == null) {
                com.uc.crashsdk.a.a.b("Ucebu can not list folder: " + strV);
                return;
            }
            for (File file2 : fileArrListFiles) {
                if (file2.isFile() && file2.getName().contains("ucebu")) {
                    a(false, false);
                    return;
                }
            }
        }
    }

    public static /* synthetic */ int I() {
        int i2 = M + 1;
        M = i2;
        return i2;
    }

    public static /* synthetic */ void J() {
        StringBuilder sbX;
        if (com.uc.crashsdk.b.f4552d && (sbX = X()) != null) {
            JNIBridge.set(Token.CATCH, sbX.toString());
        }
        L = true;
        Y();
    }

    public static /* synthetic */ int K() {
        M = 0;
        return 0;
    }

    private void L() {
        int iG = g.G();
        for (int i2 = 0; i2 < iG; i2++) {
            try {
                this.f4578e.add(new FileInputStream("/dev/null"));
            } catch (Exception e2) {
                com.uc.crashsdk.a.g.a(e2);
                return;
            }
        }
    }

    private void M() {
        Iterator<FileInputStream> it = this.f4578e.iterator();
        while (it.hasNext()) {
            com.uc.crashsdk.a.g.a(it.next());
        }
        this.f4578e.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean N() {
        if (g.N()) {
            return true;
        }
        return a();
    }

    private static String O() {
        return g.e() + "_";
    }

    private static String P() {
        return com.uc.crashsdk.b.y() ? "fg" : "bg";
    }

    private static byte[] Q() {
        byte[] bArr = null;
        int i2 = 1024;
        while (bArr == null && i2 > 0) {
            try {
                bArr = new byte[i2];
            } catch (Throwable unused) {
                i2 /= 2;
                if (i2 < 16) {
                    return bArr;
                }
            }
        }
        return bArr;
    }

    private static String R() {
        return (!com.uc.crashsdk.b.C() || f4570d) ? LogType.JAVA_TYPE : "ucebujava";
    }

    private static void S() {
        String strTrim;
        BufferedReader bufferedReader;
        Throwable th;
        FileReader fileReader;
        String strTrim2 = "-";
        try {
            strTrim = Build.HARDWARE;
        } catch (Throwable th2) {
            com.uc.crashsdk.a.g.a(th2);
            strTrim = "-";
        }
        try {
            fileReader = new FileReader(new File("/proc/cpuinfo"));
            try {
                bufferedReader = new BufferedReader(fileReader, 512);
                int i2 = 0;
                do {
                    try {
                        String line = bufferedReader.readLine();
                        if (line == null) {
                            break;
                        }
                        if (line.startsWith("Hardware")) {
                            strTrim = line.substring(line.indexOf(":") + 1).trim();
                        } else if (line.startsWith("Processor")) {
                            strTrim2 = line.substring(line.indexOf(":") + 1).trim();
                        }
                        i2++;
                    } catch (Throwable th3) {
                        th = th3;
                        try {
                            com.uc.crashsdk.a.g.a(th);
                            com.uc.crashsdk.a.g.a(fileReader);
                        } catch (Throwable th4) {
                            com.uc.crashsdk.a.g.a(fileReader);
                            com.uc.crashsdk.a.g.a(bufferedReader);
                            throw th4;
                        }
                    }
                } while (i2 < 2);
                com.uc.crashsdk.a.g.a(fileReader);
            } catch (Throwable th5) {
                bufferedReader = null;
                th = th5;
            }
        } catch (Throwable th6) {
            bufferedReader = null;
            th = th6;
            fileReader = null;
        }
        com.uc.crashsdk.a.g.a(bufferedReader);
        f4576k = strTrim;
        f4577l = strTrim2;
    }

    private static String T() {
        return g.U() + "bytes";
    }

    private static boolean U() {
        return Build.VERSION.SDK_INT < 29;
    }

    private static void V() {
        if (O || com.uc.crashsdk.b.C() || com.uc.crashsdk.b.I()) {
            return;
        }
        JNIBridge.cmd(18);
    }

    private static void W() {
        com.uc.crashsdk.a.f.a(3, new com.uc.crashsdk.a.e(414), 1000L);
    }

    private static StringBuilder X() {
        String str;
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("level: ");
            sb.append(C);
            sb.append("\n");
            sb.append("scale: ");
            sb.append(D);
            sb.append("\n");
            switch (F) {
                case 1:
                    str = " (Unknown)";
                    break;
                case 2:
                    str = " (Good)";
                    break;
                case 3:
                    str = " (Overheat)";
                    break;
                case 4:
                    str = " (Dead)";
                    break;
                case 5:
                    str = " (Over voltage)";
                    break;
                case 6:
                    str = " (Unspecified failure)";
                    break;
                case 7:
                    str = " (Cold)";
                    break;
                default:
                    str = " (?)";
                    break;
            }
            sb.append("health: ");
            sb.append(F);
            sb.append(str);
            sb.append("\n");
            int i2 = G;
            String str2 = i2 != 0 ? i2 != 1 ? i2 != 2 ? i2 != 4 ? " (?)" : " (Wireless)" : " (USB port)" : " (AC charger)" : " (None)";
            sb.append("pluged: ");
            sb.append(G);
            sb.append(str2);
            sb.append("\n");
            int i3 = H;
            String str3 = i3 != 1 ? i3 != 2 ? i3 != 3 ? i3 != 4 ? i3 != 5 ? " (?)" : " (Full)" : " (Not charging)" : " (Discharging)" : " (Charging)" : " (Unknown)";
            sb.append("status: ");
            sb.append(H);
            sb.append(str3);
            sb.append("\n");
            sb.append("voltage: ");
            sb.append(E);
            sb.append("\n");
            sb.append("temperature: ");
            sb.append(I);
            sb.append("\n");
            sb.append("technology: ");
            sb.append(J);
            sb.append("\n");
            sb.append("battery low: ");
            sb.append(K);
            sb.append("\n");
            return sb;
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
            return null;
        }
    }

    private static void Y() {
        if (com.uc.crashsdk.b.f4551c && L && com.uc.crashsdk.a.f4494c) {
            L = false;
            if (com.uc.crashsdk.a.f.b(P)) {
                return;
            }
            com.uc.crashsdk.a.f.a(0, P, 2000L);
        }
    }

    private static boolean Z() {
        return com.uc.crashsdk.b.f4552d && JNIBridge.nativeIsCrashing();
    }

    public static boolean a() {
        if (f4571f == 0) {
            f4571f = 2L;
            if (g(com.uc.crashsdk.b.a("logs")) == 1) {
                f4571f = 1L;
            }
        }
        return f4571f == 1;
    }

    private static void aa() {
        String strW = g.W();
        File file = new File(strW);
        if (file.isDirectory()) {
            try {
                File[] fileArrListFiles = file.listFiles();
                if (fileArrListFiles != null && fileArrListFiles.length > 150) {
                    Arrays.sort(fileArrListFiles, new b((byte) 0));
                    int length = fileArrListFiles.length - 150;
                    int i2 = length < 0 ? 0 : length;
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    int i3 = 0;
                    int i4 = 0;
                    int i5 = 0;
                    while (i3 < fileArrListFiles.length) {
                        File file2 = fileArrListFiles[i3];
                        boolean z2 = i3 < i2;
                        if (!z2 && jCurrentTimeMillis - file2.lastModified() >= 432000000) {
                            z2 = true;
                        }
                        if (!z2) {
                            break;
                        }
                        try {
                            file2.delete();
                            i4++;
                            i5 = 0;
                        } catch (Throwable th) {
                            i5++;
                            com.uc.crashsdk.a.g.a(th);
                        }
                        if (i5 >= 3) {
                            break;
                        } else {
                            i3++;
                        }
                    }
                    com.uc.crashsdk.a.a.a("Removed " + i4 + " logs in " + strW);
                }
            } catch (Throwable th2) {
                com.uc.crashsdk.a.g.a(th2);
            }
        }
    }

    public static long b() {
        if (f4572g == -1) {
            f4572g = g(com.uc.crashsdk.b.a("local"));
        }
        return f4572g;
    }

    public static String d(boolean z2) {
        return z2 ? "https://errlogos.umeng.com/upload" : "https://errlog.umeng.com/upload";
    }

    private static String j(String str) {
        return String.format(Locale.US, "%s%s_%s_%s.log", d(), m(), P(), str);
    }

    private static String k(String str) {
        if (!com.uc.crashsdk.a.g.b(str)) {
            return "";
        }
        int iIndexOf = str.indexOf(0);
        if (iIndexOf >= 0) {
            str = str.substring(0, iIndexOf);
        }
        return str.trim();
    }

    private static String l(String str) {
        String strA = com.uc.crashsdk.a.b.a(str, g.w(), g.v());
        if (!str.equals(strA)) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
        }
        return strA;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x006b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static boolean[] m(java.lang.String r7) {
        /*
            boolean r0 = com.uc.crashsdk.g.v()
            boolean r1 = com.uc.crashsdk.g.x()
            r2 = 0
            if (r0 != 0) goto Ld
            if (r1 == 0) goto L6d
        Ld:
            java.lang.String r3 = ".tmp"
            boolean r3 = r7.endsWith(r3)
            if (r3 != 0) goto L6b
            java.lang.String r3 = ".ec"
            boolean r3 = r7.contains(r3)
            if (r3 == 0) goto L1e
            goto L6b
        L1e:
            char r3 = java.io.File.separatorChar
            int r3 = r7.lastIndexOf(r3)
            if (r3 >= 0) goto L27
            r3 = 0
        L27:
            r4 = 0
        L28:
            r5 = 95
            int r3 = r7.indexOf(r5, r3)
            if (r3 < 0) goto L34
            int r4 = r4 + 1
            int r3 = r3 + 1
        L34:
            if (r3 >= 0) goto L28
            r3 = 8
            if (r4 == r3) goto L3b
            goto L6b
        L3b:
            java.lang.String r3 = com.uc.crashsdk.g.w()
            java.lang.String r4 = ".log"
            boolean r6 = r7.endsWith(r4)
            if (r6 != 0) goto L54
            boolean r0 = com.uc.crashsdk.a.g.a(r3)
            if (r0 != 0) goto L6b
            boolean r7 = r7.endsWith(r3)
            if (r7 != 0) goto L5a
            goto L6b
        L54:
            boolean r3 = com.uc.crashsdk.a.g.a(r3)
            if (r3 == 0) goto L5c
        L5a:
            r0 = 0
            goto L6d
        L5c:
            int r3 = r7.lastIndexOf(r5)
            int r3 = r7.indexOf(r4, r3)
            int r7 = r7.lastIndexOf(r4)
            if (r3 == r7) goto L6d
            goto L5a
        L6b:
            r0 = 0
            r1 = 0
        L6d:
            r7 = 2
            boolean[] r7 = new boolean[r7]
            r7[r2] = r0
            r0 = 1
            r7[r0] = r1
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.e.m(java.lang.String):boolean[]");
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0082  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static boolean n(java.lang.String r17) {
        /*
            Method dump skipped, instruction units count: 241
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.e.n(java.lang.String):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x00ae A[Catch: all -> 0x0106, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x0008, B:7:0x0018, B:9:0x0023, B:10:0x002d, B:38:0x00ae, B:49:0x00d3, B:56:0x00ee, B:52:0x00de, B:63:0x00fa, B:66:0x0104, B:11:0x0033, B:13:0x003b, B:14:0x0044, B:16:0x004c, B:18:0x0054, B:20:0x005c, B:26:0x006a, B:28:0x0074, B:30:0x0081, B:32:0x008b, B:33:0x0096, B:35:0x00a0), top: B:71:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static boolean o(java.lang.String r14) {
        /*
            Method dump skipped, instruction units count: 265
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.e.o(java.lang.String):boolean");
    }

    private static Map<String, Integer> p(String str) {
        HashMap map = new HashMap();
        for (String str2 : str.split("\\|", 30)) {
            String[] strArrSplit = str2.split(":", 3);
            if (strArrSplit.length == 2) {
                String strTrim = strArrSplit[0].trim();
                if (!com.uc.crashsdk.a.g.a(strTrim)) {
                    int i2 = 1;
                    try {
                        i2 = Integer.parseInt(strArrSplit[1].trim(), 10);
                    } catch (Throwable th) {
                        com.uc.crashsdk.a.g.a(th);
                    }
                    map.put(strTrim, Integer.valueOf(i2));
                }
            }
        }
        return map;
    }

    private static void q(String str) {
        if (g.q()) {
            try {
                aa();
            } catch (Throwable th) {
                com.uc.crashsdk.a.g.a(th);
            }
            if (str == null || "".equals(str)) {
                return;
            }
            try {
                File file = new File(g.W());
                if (!file.exists()) {
                    file.mkdirs();
                }
                com.uc.crashsdk.a.a.a("crashsdk", "copy log to: " + file);
                com.uc.crashsdk.a.g.a(new File(str), file);
            } catch (Throwable th2) {
                com.uc.crashsdk.a.g.a(th2);
            }
        }
    }

    private static String r(String str) {
        return String.format("$^%s^$", str);
    }

    public static void s() {
        Thread.setDefaultUncaughtExceptionHandler(T);
    }

    public static boolean t() {
        return f4569c.get() || Z();
    }

    public static Throwable u() {
        return U;
    }

    public static int v() {
        if (com.uc.crashsdk.b.F() == 5) {
            return Z;
        }
        return 100;
    }

    public static void w() {
        long jO = g.o();
        if (jO < 0) {
            return;
        }
        boolean z2 = com.uc.crashsdk.b.F() == 5;
        com.uc.crashsdk.a.f.a(0, new com.uc.crashsdk.a.e(TinkerReport.KEY_LOADED_SUCC_COST_1000_LESS));
        if (z2) {
            com.uc.crashsdk.a.e eVar = new com.uc.crashsdk.a.e(TinkerReport.KEY_LOADED_SUCC_COST_3000_LESS);
            X = eVar;
            com.uc.crashsdk.a.f.a(0, eVar, jO);
        }
    }

    public static void x() {
        if (com.uc.crashsdk.b.f4551c && com.uc.crashsdk.a.f4494c && !com.uc.crashsdk.a.f.b(aa)) {
            com.uc.crashsdk.a.f.a(0, aa, 1000L);
        }
    }

    public static boolean y() {
        synchronized (Y) {
            Runnable runnable = X;
            if (runnable == null || W) {
                return false;
            }
            com.uc.crashsdk.a.f.a(runnable);
            X = null;
            return true;
        }
    }

    public static void z() {
        if (g.q()) {
            com.uc.crashsdk.a.f.a(0, new com.uc.crashsdk.a.e(TinkerReport.KEY_LOADED_SUCC_COST_5000_LESS), 10000L);
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        a(thread, th, false);
    }

    public static String d() {
        String str = f4574i;
        if (str != null) {
            return str;
        }
        String strI = i((String) null);
        f4574i = strI;
        return strI;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(17:6|67|7|(4:11|(3:13|(2:15|76)(1:77)|16)|75|17)|20|(8:63|22|65|23|27|(1:29)|30|(1:(1:33)(1:34)))|(2:73|35)|(11:37|69|38|46|71|47|(1:51)|52|(1:56)|60|61)(8:42|71|47|(2:49|51)|52|(2:54|56)|60|61)|45|46|71|47|(0)|52|(0)|60|61) */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x012f, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0130, code lost:
    
        com.uc.crashsdk.a.g.a(r0);
     */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00cc A[Catch: all -> 0x012f, TryCatch #4 {all -> 0x012f, blocks: (B:47:0x00c6, B:49:0x00cc, B:51:0x00d4, B:52:0x00fa, B:54:0x0100, B:56:0x0108), top: B:71:0x00c6 }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0100 A[Catch: all -> 0x012f, TryCatch #4 {all -> 0x012f, blocks: (B:47:0x00c6, B:49:0x00cc, B:51:0x00d4, B:52:0x00fa, B:54:0x0100, B:56:0x0108), top: B:71:0x00c6 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String e() {
        /*
            Method dump skipped, instruction units count: 310
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.e.e():java.lang.String");
    }

    private static long g(String str) {
        try {
            Method declaredMethod = Class.forName("android.os.SystemProperties").getDeclaredMethod("getLong", String.class, Long.TYPE);
            if (declaredMethod != null) {
                declaredMethod.setAccessible(true);
                return ((Long) declaredMethod.invoke(null, str, 0L)).longValue();
            }
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
        }
        return 0L;
    }

    private static String h(String str) {
        try {
            return str.replaceAll("[^0-9a-zA-Z-.]", "-");
        } catch (Throwable unused) {
            return EnvironmentCompat.MEDIA_UNKNOWN;
        }
    }

    private static String i(String str) {
        if (str == null) {
            StringBuilder sbR = c.a.a.a.a.r(String.valueOf(System.currentTimeMillis()));
            sbR.append(new Random().nextInt(65536));
            str = sbR.toString();
        }
        return String.format(Locale.US, "%s%s_%s_%s_%s_%s_", O(), g.R(), g.T(), h(Build.MODEL), h(Build.VERSION.RELEASE), str);
    }

    public static void r() {
        T = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(new e());
    }

    public static void c() {
        f4574i = null;
    }

    public static String h() {
        String str = m;
        if (str != null) {
            return str;
        }
        String strA = a(Process.myPid());
        m = strA;
        return strA;
    }

    public static boolean b(int i2, Object[] objArr) {
        if (i2 == 451) {
            if (a || objArr != null) {
                return a((String) objArr[0], (d) objArr[1]);
            }
            throw new AssertionError();
        }
        if (i2 != 452) {
            if (a) {
                return false;
            }
            throw new AssertionError();
        }
        if (!a && objArr == null) {
            throw new AssertionError();
        }
        String str = (String) objArr[0];
        d dVar = (d) objArr[1];
        return com.uc.crashsdk.a.g.a(new File(str), String.format(Locale.US, "%d %d %d %d", Long.valueOf(dVar.a), Long.valueOf(dVar.f4583b), Integer.valueOf(dVar.f4584c), Integer.valueOf(dVar.f4585d)).getBytes());
    }

    private static void c(OutputStream outputStream) {
        if (com.uc.crashsdk.b.f4552d) {
            String strL = com.uc.crashsdk.b.l();
            f4573h = false;
            if (1 == JNIBridge.cmd(17, strL)) {
                File file = new File(strL);
                try {
                    byte[] bArrE = com.uc.crashsdk.a.g.e(file);
                    if (bArrE != null) {
                        outputStream.write(bArrE);
                    }
                } catch (Throwable th) {
                    a(th, outputStream);
                }
                try {
                    file.delete();
                } catch (Throwable th2) {
                    a(th2, outputStream);
                }
                f4573h = true;
                a(outputStream);
            }
            f4573h = true;
            return;
        }
        File[] fileArrListFiles = null;
        int iH = 900;
        try {
            iH = g.H();
            fileArrListFiles = new File("/proc/self/fd").listFiles();
            if (fileArrListFiles != null) {
                outputStream.write(String.format(Locale.US, "opened file count: %d, write limit: %d.\n", Integer.valueOf(fileArrListFiles.length), Integer.valueOf(iH)).getBytes(DataUtil.defaultCharset));
            } else {
                outputStream.write("[DEBUG] listFiles failed!\n".getBytes(DataUtil.defaultCharset));
            }
        } catch (Throwable th3) {
            a(th3, outputStream);
        }
        if (fileArrListFiles != null) {
            try {
                if (fileArrListFiles.length >= iH) {
                    outputStream.write("opened files:\n".getBytes(DataUtil.defaultCharset));
                    StringBuilder sb = new StringBuilder();
                    try {
                        for (File file2 : fileArrListFiles) {
                            sb.append(file2.getName());
                            sb.append(" -> ");
                            sb.append(file2.getCanonicalPath());
                            sb.append("\n");
                        }
                    } catch (Throwable th4) {
                        a(th4, outputStream);
                    }
                    outputStream.write(sb.toString().getBytes(DataUtil.defaultCharset));
                }
            } catch (Throwable th5) {
                a(th5, outputStream);
            }
        }
        a(outputStream);
    }

    public static String f() {
        if (com.uc.crashsdk.a.g.a(f4576k)) {
            S();
        }
        return f4576k;
    }

    private static void d(OutputStream outputStream) {
        int I2;
        int length;
        File[] fileArrListFiles = null;
        try {
            I2 = g.I();
            try {
                fileArrListFiles = new File("/proc/self/task").listFiles();
                if (fileArrListFiles == null) {
                    return;
                }
                length = fileArrListFiles.length;
                if (length < I2) {
                    return;
                }
            } catch (Throwable th) {
                th = th;
                com.uc.crashsdk.a.g.a(th);
                length = 0;
            }
        } catch (Throwable th2) {
            th = th2;
            I2 = 300;
        }
        if (fileArrListFiles == null) {
            return;
        }
        try {
            outputStream.write("threads info:\n".getBytes(DataUtil.defaultCharset));
            outputStream.write(String.format(Locale.US, "threads count: %d, dump limit: %d.\n", Integer.valueOf(length), Integer.valueOf(I2)).getBytes(DataUtil.defaultCharset));
            outputStream.write(" tid     name\n".getBytes(DataUtil.defaultCharset));
            for (File file : fileArrListFiles) {
                outputStream.write(String.format(Locale.US, "%5s %s\n", file.getName(), k(com.uc.crashsdk.a.g.a(new File(file.getPath(), "comm"), 128, false))).getBytes(DataUtil.defaultCharset));
            }
        } catch (Throwable th3) {
            a(th3, outputStream);
        }
        a(outputStream);
    }

    public static void j() {
        try {
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(StrictMode.getThreadPolicy()).permitNetwork().build());
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
        }
    }

    public static String k() {
        if (com.uc.crashsdk.a.g.a(w)) {
            synchronized (y) {
                w = com.uc.crashsdk.a.g.a(com.uc.crashsdk.b.f(), x, true);
            }
        }
        return w;
    }

    public static void a(int i2, Object[] objArr) {
        int i3;
        switch (i2) {
            case TinkerReport.KEY_LOADED_SUCC_COST_1000_LESS /* 401 */:
                JNIBridge.nativeCmd(10, com.uc.crashsdk.b.F() == 5 ? 1L : 0L, null, null);
                com.uc.crashsdk.a.f4494c = true;
                com.uc.crashsdk.a.a(false);
                L = true;
                Y();
                x();
                return;
            case TinkerReport.KEY_LOADED_SUCC_COST_3000_LESS /* 402 */:
                Object obj = Y;
                synchronized (obj) {
                    if (X == null) {
                        return;
                    }
                    W = true;
                    if (com.uc.crashsdk.b.n()) {
                        return;
                    }
                    if (!com.uc.crashsdk.a.d.d()) {
                        com.uc.crashsdk.a.a.c("DEBUG", com.uc.crashsdk.a.d.b());
                        return;
                    }
                    if (!c(LogType.UNEXP_TYPE)) {
                        com.uc.crashsdk.a.a.d("DEBUG", "unexp sample miss");
                        return;
                    }
                    int iNativeGenerateUnexpLog = JNIBridge.nativeGenerateUnexpLog(g.o(), g.p());
                    if (iNativeGenerateUnexpLog != 0) {
                        f.a(11);
                        if ((iNativeGenerateUnexpLog & 4352) != 0) {
                            Z = 105;
                            i3 = 30;
                        } else if ((iNativeGenerateUnexpLog & LogType.UNEXP_EXIT) != 0) {
                            Z = 104;
                            i3 = 31;
                        } else if ((iNativeGenerateUnexpLog & LogType.UNEXP_RESTART) != 0) {
                            Z = 106;
                            i3 = 32;
                        } else {
                            if ((iNativeGenerateUnexpLog & LogType.UNEXP_ANR) != 0) {
                                Z = 103;
                                f.a(10);
                            } else if ((iNativeGenerateUnexpLog & LogType.UNEXP_LOW_MEMORY) != 0) {
                                Z = 107;
                                f.a(29);
                            } else {
                                Z = 102;
                            }
                            a(true);
                        }
                        f.a(i3);
                        a(true);
                    }
                    synchronized (obj) {
                        X = null;
                        break;
                    }
                    return;
                }
            case TinkerReport.KEY_LOADED_SUCC_COST_5000_LESS /* 403 */:
                aa();
                return;
            case TinkerReport.KEY_LOADED_SUCC_COST_OTHER /* 404 */:
            default:
                if (!a) {
                    throw new AssertionError();
                }
                return;
            case 405:
                L = false;
                StringBuilder sbX = X();
                String strD = com.uc.crashsdk.b.d();
                if (sbX != null) {
                    com.uc.crashsdk.a.g.a(new File(strD), sbX.toString());
                    return;
                }
                return;
            case 406:
                if (!a && objArr == null) {
                    throw new AssertionError();
                }
                a((String) objArr[0], ((Boolean) objArr[1]).booleanValue(), ((Boolean) objArr[2]).booleanValue());
                return;
            case 407:
                try {
                    com.uc.crashsdk.a.d();
                    return;
                } catch (Throwable th) {
                    com.uc.crashsdk.a.g.a(th);
                    return;
                }
            case 408:
                synchronized (ab) {
                    if (!ac && g.O() && com.uc.crashsdk.b.w()) {
                        com.uc.crashsdk.b.p();
                        h.f();
                        f.c();
                        if (com.uc.crashsdk.b.C()) {
                            B();
                        }
                        if (g.O()) {
                            a(Calendar.getInstance());
                        }
                        ac = true;
                        return;
                    }
                    return;
                }
            case 409:
                b(false, false);
                return;
            case 410:
                a(false, true);
                return;
            case 411:
                if (com.uc.crashsdk.b.f4552d) {
                    JNIBridge.set(28, c(LogType.NATIVE_TYPE));
                    JNIBridge.set(29, c(LogType.ANR_TYPE));
                    return;
                }
                return;
            case 412:
                if (!R && com.uc.crashsdk.b.y() && g.K()) {
                    b(com.uc.crashsdk.a.g.a());
                    return;
                }
                if (R) {
                    if (com.uc.crashsdk.b.y() && g.K()) {
                        return;
                    }
                    try {
                        com.uc.crashsdk.a.g.a().unregisterReceiver(Q);
                        R = false;
                        return;
                    } catch (Throwable th2) {
                        com.uc.crashsdk.a.g.a(th2);
                        return;
                    }
                }
                return;
            case 413:
                JNIBridge.cmd(8);
                return;
            case 414:
                try {
                    if (d(com.uc.crashsdk.a.g.a())) {
                        return;
                    }
                    int i4 = N + 1;
                    N = i4;
                    if (i4 < 10) {
                        W();
                        return;
                    } else {
                        if (com.uc.crashsdk.b.f4552d) {
                            JNIBridge.set(130, "(get failed)");
                            return;
                        }
                        return;
                    }
                } catch (Throwable th3) {
                    com.uc.crashsdk.a.g.a(th3);
                    return;
                }
            case 415:
                if (!a && objArr == null) {
                    throw new AssertionError();
                }
                long jLongValue = ((Long) objArr[0]).longValue();
                Calendar calendar = Calendar.getInstance();
                if (calendar.getTimeInMillis() >= jLongValue) {
                    h.g();
                    f.a(100);
                    b(true, true);
                    h.b();
                } else {
                    h.h();
                    h.i();
                    h.c();
                }
                a(calendar);
                break;
                break;
            case 416:
                break;
        }
        V();
    }

    /* JADX INFO: compiled from: ProGuard */
    public static class a extends OutputStream {
        private final long a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final OutputStream f4579b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f4580c = 0;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f4581d = 0;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f4582e = false;

        public a(long j2, OutputStream outputStream) {
            this.a = j2;
            this.f4579b = outputStream;
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x0019  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private int a(byte[] r7, int r8, int r9) throws java.io.IOException {
            /*
                r6 = this;
                int r0 = r6.f4581d
                int r0 = r0 + r9
                r6.f4581d = r0
                boolean r0 = r6.f4582e
                if (r0 == 0) goto Lb
                r7 = 0
                return r7
            Lb:
                int r0 = com.uc.crashsdk.g.y()
                if (r0 <= 0) goto L19
                int r1 = r6.f4580c
                int r2 = r1 + r9
                if (r2 <= r0) goto L19
                int r0 = r0 - r1
                goto L1a
            L19:
                r0 = r9
            L1a:
                int r1 = r6.f4580c
                int r1 = r1 + r0
                r6.f4580c = r1
                long r1 = r6.a
                r3 = 0
                int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
                if (r5 == 0) goto L30
                java.lang.String r1 = new java.lang.String
                r1.<init>(r7, r8, r0)
                r6.b(r1)
                goto L35
            L30:
                java.io.OutputStream r1 = r6.f4579b
                r1.write(r7, r8, r0)
            L35:
                if (r0 >= r9) goto L3a
                r7 = 1
                r6.f4582e = r7
            L3a:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.e.a.a(byte[], int, int):int");
        }

        private void b(String str) {
            if (com.uc.crashsdk.b.f4552d) {
                JNIBridge.nativeClientWriteData(this.a, str);
            }
        }

        @Override // java.io.OutputStream
        public final void write(int i2) throws IOException {
            if (e.f4573h && e.N()) {
                com.uc.crashsdk.a.a.d("DEBUG", String.format(Locale.US, "%c", Integer.valueOf(i2)));
            }
            if (this.a != 0) {
                b(String.format(Locale.US, "%c", Integer.valueOf(i2)));
            } else {
                this.f4579b.write(i2);
            }
            this.f4580c++;
            this.f4581d++;
        }

        @Override // java.io.OutputStream
        public final void write(byte[] bArr, int i2, int i3) throws IOException {
            if (e.f4573h && e.N()) {
                byte[] bArr2 = new byte[i3];
                System.arraycopy(bArr, i2, bArr2, 0, i3);
                if (i3 != 1 || bArr2[0] != 10) {
                    try {
                        com.uc.crashsdk.a.a.d("DEBUG", new String(bArr2));
                    } catch (Throwable unused) {
                    }
                }
            }
            a(bArr, i2, i3);
        }

        public final void a() {
            try {
                if (this.f4581d - this.f4580c > 0) {
                    a("\n");
                    a("--- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ---\n");
                }
                a(String.format(Locale.US, "Full: %d bytes, write: %d bytes, limit: %d bytes, reject: %d bytes.\n", Integer.valueOf(this.f4581d), Integer.valueOf(this.f4580c), Integer.valueOf(g.y()), Integer.valueOf(this.f4581d - this.f4580c)));
            } catch (Throwable th) {
                com.uc.crashsdk.a.g.a(th);
            }
        }

        @Override // java.io.OutputStream
        public final void write(byte[] bArr) throws IOException {
            if (e.f4573h && e.N() && (bArr.length != 1 || bArr[0] != 10)) {
                try {
                    com.uc.crashsdk.a.a.d("DEBUG", new String(bArr));
                } catch (Throwable unused) {
                }
            }
            a(bArr, 0, bArr.length);
        }

        public final void a(String str) throws IOException {
            if (e.f4573h && e.N()) {
                com.uc.crashsdk.a.a.d("DEBUG", str);
            }
            if (this.a != 0) {
                b(str);
            } else {
                this.f4579b.write(str.getBytes(DataUtil.defaultCharset));
            }
        }
    }

    private static void f(OutputStream outputStream) {
        String strM;
        try {
            outputStream.write("recent status:\n".getBytes(DataUtil.defaultCharset));
        } catch (Throwable th) {
            a(th, outputStream);
        }
        try {
            if (af) {
                strM = r("LASTVER");
            } else {
                strM = com.uc.crashsdk.a.m();
            }
            outputStream.write(String.format(Locale.US, "last version: '%s'\n", strM).getBytes(DataUtil.defaultCharset));
        } catch (Throwable th2) {
            a(th2, outputStream);
        }
        try {
            ArrayList<String> arrayList = r;
            synchronized (arrayList) {
                if (t != null) {
                    outputStream.write(String.format(Locale.US, "generating log: %s\n", t).getBytes(DataUtil.defaultCharset));
                }
                if (s > 0 || arrayList.size() > 0) {
                    outputStream.write(String.format(Locale.US, "generated %d logs, recent are:\n", Integer.valueOf(s)).getBytes(DataUtil.defaultCharset));
                    Iterator<String> it = arrayList.iterator();
                    while (it.hasNext()) {
                        outputStream.write(String.format(Locale.US, "* %s\n", it.next()).getBytes(DataUtil.defaultCharset));
                    }
                }
            }
            Locale locale = Locale.US;
            outputStream.write(String.format(locale, "dumping all threads: %s\n", Boolean.valueOf(u)).getBytes(DataUtil.defaultCharset));
            String str = v;
            if (str != null) {
                outputStream.write(String.format(locale, "dumping threads: %s\n", str).getBytes(DataUtil.defaultCharset));
            }
        } catch (Throwable th3) {
            a(th3, outputStream);
        }
        a(outputStream);
    }

    public static String g() {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("JavaMax:    ");
            sb.append(Runtime.getRuntime().maxMemory() / 1024);
            sb.append(" kB\n");
            sb.append("JavaTotal:  ");
            sb.append(Runtime.getRuntime().totalMemory() / 1024);
            sb.append(" kB\n");
            sb.append("JavaFree:   ");
            sb.append(Runtime.getRuntime().freeMemory() / 1024);
            sb.append(" kB\n");
            sb.append("NativeHeap: ");
            sb.append(Debug.getNativeHeapSize() / 1024);
            sb.append(" kB\n");
            sb.append("NativeAllocated: ");
            sb.append(Debug.getNativeHeapAllocatedSize() / 1024);
            sb.append(" kB\n");
            sb.append("NativeFree: ");
            sb.append(Debug.getNativeHeapFreeSize() / 1024);
            sb.append(" kB\n");
            try {
                ActivityManager activityManager = (ActivityManager) com.uc.crashsdk.a.g.a().getSystemService("activity");
                if (activityManager != null) {
                    ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
                    activityManager.getMemoryInfo(memoryInfo);
                    sb.append("availMem:   ");
                    sb.append(memoryInfo.availMem / 1024);
                    sb.append(" kB\n");
                    sb.append("threshold:  ");
                    sb.append(memoryInfo.threshold / 1024);
                    sb.append(" kB\n");
                    sb.append("lowMemory:  ");
                    sb.append(memoryInfo.lowMemory);
                    sb.append("\n");
                }
            } catch (Throwable th) {
                com.uc.crashsdk.a.g.a(th);
            }
            return sb.toString();
        } catch (Throwable th2) {
            com.uc.crashsdk.a.g.a(th2);
            return "";
        }
    }

    /* JADX INFO: compiled from: ProGuard */
    public static class d {
        public long a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f4583b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f4584c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f4585d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f4586e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f4587f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f4588g;

        private d() {
            this.a = 0L;
            this.f4583b = 0L;
            this.f4584c = 0;
            this.f4585d = 0;
            this.f4586e = false;
            this.f4587f = false;
            this.f4588g = false;
        }

        public /* synthetic */ d(byte b2) {
            this();
        }
    }

    public static void l() {
        if (af) {
            return;
        }
        com.uc.crashsdk.a.f.a(1, new com.uc.crashsdk.a.e(411), 1000L);
    }

    public static boolean i() {
        return f4570d;
    }

    public static void o() {
        String strA;
        Throwable th;
        File file;
        if (com.uc.crashsdk.a.g.a(B)) {
            String string = null;
            try {
                file = new File(g.U() + "unique");
            } catch (Throwable th2) {
                strA = string;
                th = th2;
            }
            if (file.exists()) {
                strA = com.uc.crashsdk.a.g.a(file, 48, false);
                try {
                    if (strA != null) {
                        try {
                            if (strA.length() == 36) {
                                string = strA.replaceAll("[^0-9a-zA-Z-]", "-");
                            }
                        } catch (Exception e2) {
                            com.uc.crashsdk.a.g.a(e2);
                            string = strA;
                        }
                    } else {
                        string = strA;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    com.uc.crashsdk.a.g.a(th);
                    string = strA;
                }
                B = string;
            }
            if (com.uc.crashsdk.a.g.a(string)) {
                com.uc.crashsdk.b.D();
                string = UUID.randomUUID().toString();
                if (!com.uc.crashsdk.a.g.a(string)) {
                    com.uc.crashsdk.a.g.a(file, string.getBytes());
                }
            }
            B = string;
        }
    }

    public static String p() {
        return B;
    }

    public static void q() {
        O = false;
        if (!com.uc.crashsdk.b.y()) {
            com.uc.crashsdk.a.f.a(3, new com.uc.crashsdk.a.e(416), 11000L);
        }
        if (U()) {
            return;
        }
        N = 0;
        W();
    }

    private static void b(OutputStream outputStream, String str, String str2) {
        String strR;
        String strNativeGet;
        try {
            outputStream.write("*** *** *** *** *** *** *** *** *** *** *** *** *** *** *** ***\n".getBytes(DataUtil.defaultCharset));
        } catch (Throwable th) {
            a(th, outputStream);
        }
        try {
            Locale locale = Locale.US;
            outputStream.write(String.format(locale, "Basic Information: 'pid: %d/tid: %d/time: %s'\n", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()), m()).getBytes(DataUtil.defaultCharset));
            Object[] objArr = new Object[3];
            objArr[0] = e();
            if (com.uc.crashsdk.a.g.a(f4577l)) {
                S();
            }
            objArr[1] = f4577l;
            objArr[2] = f();
            outputStream.write(String.format(locale, "Cpu Information: 'abi: %s/processor: %s/hardware: %s'\n", objArr).getBytes(DataUtil.defaultCharset));
        } catch (Throwable th2) {
            a(th2, outputStream);
        }
        try {
            Locale locale2 = Locale.US;
            outputStream.write(String.format(locale2, "Mobile Information: 'model: %s/version: %s/sdk: %d'\n", Build.MODEL, Build.VERSION.RELEASE, Integer.valueOf(Build.VERSION.SDK_INT)).getBytes(DataUtil.defaultCharset));
            outputStream.write(("Build fingerprint: '" + Build.FINGERPRINT + "'\n").getBytes(DataUtil.defaultCharset));
            Object[] objArr2 = new Object[4];
            objArr2[0] = a(new Date(f4568b));
            objArr2[1] = Long.valueOf(Runtime.getRuntime().maxMemory());
            objArr2[2] = com.uc.crashsdk.a.g.d();
            objArr2[3] = com.uc.crashsdk.b.y() ? "fg" : "bg";
            outputStream.write(String.format(locale2, "Runtime Information: 'start: %s/maxheap: %s/primaryabi: %s/ground: %s'\n", objArr2).getBytes(DataUtil.defaultCharset));
        } catch (Throwable th3) {
            a(th3, outputStream);
        }
        try {
            Locale locale3 = Locale.US;
            outputStream.write(String.format(locale3, "Application Information: 'version: %s/subversion: %s/buildseq: %s/versioncode: %d'\n", g.R(), g.S(), g.T(), Integer.valueOf(com.uc.crashsdk.a.c())).getBytes(DataUtil.defaultCharset));
            String str3 = "0";
            String str4 = "";
            if (com.uc.crashsdk.b.f4552d) {
                String strNativeGet2 = JNIBridge.nativeGet(1, 0L, null);
                strNativeGet = JNIBridge.nativeGet(2, 0L, null);
                str3 = strNativeGet2;
            } else {
                strNativeGet = "";
            }
            outputStream.write(String.format(locale3, "CrashSDK Information: 'version: %s/nativeseq: %s/javaseq: %s/arch: %s/target: %s'\n", "3.2.0.4", str3, "210105150455", strNativeGet, "release").getBytes(DataUtil.defaultCharset));
            if (str != null) {
                str4 = str;
            }
            outputStream.write(("Report Name: " + str4.substring(str4.lastIndexOf(47) + 1) + "\n").getBytes(DataUtil.defaultCharset));
        } catch (Throwable th4) {
            a(th4, outputStream);
        }
        try {
            if (af) {
                strR = r("UUID");
            } else {
                strR = B;
            }
            outputStream.write(String.format("UUID: %s\n", strR).getBytes(DataUtil.defaultCharset));
            outputStream.write(("Log Type: " + str2 + "\n").getBytes(DataUtil.defaultCharset));
        } catch (Throwable th5) {
            a(th5, outputStream);
        }
        try {
            String strB = com.uc.crashsdk.b.B();
            if (com.uc.crashsdk.a.g.a(strB)) {
                strB = "(none)";
            }
            outputStream.write(("Activity: " + strB + "\n").getBytes(DataUtil.defaultCharset));
        } catch (Throwable th6) {
            a(th6, outputStream);
        }
        a(outputStream);
        try {
            com.uc.crashsdk.a.a(outputStream, DataUtil.defaultCharset);
            if (af) {
                f4573h = false;
                outputStream.write(r("HEADER").getBytes(DataUtil.defaultCharset));
                f4573h = true;
            }
        } catch (Throwable th7) {
            a(th7, outputStream);
        }
        a(outputStream);
    }

    public static String m() {
        return a(new Date());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean d(Context context) {
        List<ActivityManager.ProcessErrorStateInfo> processesInErrorState;
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        boolean z2 = false;
        if (activityManager == null || (processesInErrorState = activityManager.getProcessesInErrorState()) == null) {
            return false;
        }
        int iMyPid = Process.myPid();
        Iterator<ActivityManager.ProcessErrorStateInfo> it = processesInErrorState.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            ActivityManager.ProcessErrorStateInfo next = it.next();
            if (next.pid == iMyPid) {
                O = true;
                if (N()) {
                    com.uc.crashsdk.a.a.d("crashsdk", "ANR occurred in process: " + next.processName);
                }
                if (com.uc.crashsdk.b.f4552d) {
                    JNIBridge.set(130, next.longMsg);
                }
                z2 = true;
            }
        }
        if (!z2 && com.uc.crashsdk.b.f4552d) {
            V();
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void a(boolean z2) {
        File[] fileArrListFiles;
        try {
            if (com.uc.crashsdk.b.v() && (fileArrListFiles = new File(g.V()).listFiles()) != null) {
                int iL = g.l();
                int iM = g.m();
                if (fileArrListFiles.length < Math.min(iL, iM)) {
                    return;
                }
                Object[] objArr = 0;
                int i2 = 0;
                int i3 = 0;
                for (File file : fileArrListFiles) {
                    if (b(file)) {
                        i2++;
                    } else {
                        i3++;
                    }
                }
                int i4 = (!z2 || i2 < iL) ? 0 : (i2 - iL) + 1;
                int i5 = (z2 || i3 < iM) ? 0 : (i3 - iM) + 1;
                if (i4 == 0 && i5 == 0) {
                    return;
                }
                Arrays.sort(fileArrListFiles, new b(objArr == true ? 1 : 0));
                int i6 = i4;
                int i7 = i5;
                for (File file2 : fileArrListFiles) {
                    boolean zB = b(file2);
                    if (zB && i6 > 0) {
                        com.uc.crashsdk.a.a.a("crashsdk", "Delete oldest crash log: " + file2.getPath());
                        file2.delete();
                        i6 += -1;
                    } else if (!zB && i7 > 0) {
                        com.uc.crashsdk.a.a.a("crashsdk", "Delete oldest custom log: " + file2.getPath());
                        file2.delete();
                        i7 += -1;
                    }
                    if (i6 == 0 && i7 == 0) {
                        break;
                    }
                }
                f.a(16, i4 + i5);
                if (i4 > 0) {
                    f.a(22, i4);
                }
                if (i5 > 0) {
                    f.a(23, i5);
                }
            }
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
        }
    }

    public static void n() {
        f4568b = System.currentTimeMillis();
    }

    private static void e(OutputStream outputStream) {
        BufferedReader bufferedReader;
        int iIndexOf;
        if (com.uc.crashsdk.b.f4552d) {
            try {
                outputStream.write("solib build id:\n".getBytes(DataUtil.defaultCharset));
            } catch (Throwable th) {
                a(th, outputStream);
            }
            FileReader fileReader = null;
            try {
                ArrayList arrayList = new ArrayList();
                FileReader fileReader2 = new FileReader(new File("/proc/self/maps"));
                try {
                    bufferedReader = new BufferedReader(fileReader2, 512);
                    while (true) {
                        try {
                            String line = bufferedReader.readLine();
                            if (line == null) {
                                break;
                            }
                            if (line.endsWith(".so") && (iIndexOf = line.indexOf(47)) != -1) {
                                String strSubstring = line.substring(iIndexOf);
                                if ((strSubstring.contains("/data/") || strSubstring.contains(com.uc.crashsdk.a.a)) && !arrayList.contains(strSubstring)) {
                                    arrayList.add(strSubstring);
                                    if (af) {
                                        try {
                                            outputStream.write((String.format("$^%s`%s^$", "SOBUILDID", strSubstring) + "\n").getBytes(DataUtil.defaultCharset));
                                        } catch (Throwable th2) {
                                            a(th2, outputStream);
                                        }
                                    } else {
                                        outputStream.write(String.format(Locale.US, "%s: %s\n", strSubstring, JNIBridge.nativeGet(3, 0L, strSubstring)).getBytes(DataUtil.defaultCharset));
                                    }
                                }
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            fileReader = fileReader2;
                            try {
                                a(th, outputStream);
                                com.uc.crashsdk.a.g.a(fileReader);
                                com.uc.crashsdk.a.g.a(bufferedReader);
                                a(outputStream);
                            } catch (Throwable th4) {
                                com.uc.crashsdk.a.g.a(fileReader);
                                com.uc.crashsdk.a.g.a(bufferedReader);
                                throw th4;
                            }
                        }
                    }
                    com.uc.crashsdk.a.g.a(fileReader2);
                } catch (Throwable th5) {
                    th = th5;
                    bufferedReader = null;
                }
            } catch (Throwable th6) {
                th = th6;
                bufferedReader = null;
            }
            com.uc.crashsdk.a.g.a(bufferedReader);
            a(outputStream);
        }
    }

    public static boolean c(String str) {
        if (af) {
            return true;
        }
        try {
            return o(str);
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
            return true;
        }
    }

    public static boolean d(String str) {
        try {
            if (!com.uc.crashsdk.a.g.b(str) || !str.startsWith("lib") || !str.endsWith(".so")) {
                return false;
            }
            System.loadLibrary(str.substring(3, str.length() - 3));
            return true;
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
            return false;
        }
    }

    public static void c(boolean z2) {
        boolean z3 = true;
        if (!R ? !z2 || !g.K() : z2 && g.K()) {
            z3 = false;
        }
        if (z3) {
            com.uc.crashsdk.a.e eVar = S;
            if (com.uc.crashsdk.a.f.b(eVar)) {
                com.uc.crashsdk.a.f.a(eVar);
            }
            com.uc.crashsdk.a.f.a(0, eVar, 3000L);
        }
    }

    public static String a(String str, String str2) {
        String[] strArr;
        try {
            if (Build.VERSION.SDK_INT >= 26) {
                strArr = new String[]{Constants.KEYS.PLACEMENTS, "-ef"};
            } else {
                strArr = new String[]{Constants.KEYS.PLACEMENTS};
            }
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec(strArr).getInputStream()));
            boolean zB = com.uc.crashsdk.a.g.b(str);
            boolean zB2 = com.uc.crashsdk.a.g.b(str2);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            while (true) {
                String line = bufferedReader.readLine();
                if (line != null) {
                    boolean z2 = true;
                    if ((!zB || !line.contains(str)) && ((!zB2 || !line.contains(str2)) && (line.indexOf(47) >= 0 || line.indexOf(46) <= 0))) {
                        z2 = false;
                    }
                    if (z2) {
                        byteArrayOutputStream.write(line.getBytes(DataUtil.defaultCharset));
                        byteArrayOutputStream.write("\n".getBytes(DataUtil.defaultCharset));
                    }
                } else {
                    return byteArrayOutputStream.toString(DataUtil.defaultCharset);
                }
            }
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
            return "exception exists.";
        }
    }

    private static BufferedReader a(InputStreamReader inputStreamReader) {
        BufferedReader bufferedReader = null;
        int i2 = 8192;
        while (bufferedReader == null && i2 > 0) {
            try {
                bufferedReader = new BufferedReader(inputStreamReader, i2);
            } catch (Throwable unused) {
                i2 /= 2;
                if (i2 < 512) {
                    return bufferedReader;
                }
            }
        }
        return bufferedReader;
    }

    public static int e(boolean z2) {
        int iB;
        if (z2) {
            iB = f.a(com.uc.crashsdk.b.c()) ? 1 : 0;
        } else {
            iB = f.b();
        }
        int iB2 = f.b(z2);
        return iB2 > iB ? iB2 : iB;
    }

    private static void a(OutputStream outputStream) {
        try {
            outputStream.write("--- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ---\n".getBytes(DataUtil.defaultCharset));
        } catch (Throwable th) {
            a(th, outputStream);
        }
    }

    public static StringBuilder e(String str) {
        return a(Thread.currentThread().getStackTrace(), str);
    }

    private static String a(File file) {
        String canonicalPath;
        try {
            canonicalPath = file.getCanonicalPath();
        } catch (Throwable unused) {
            canonicalPath = null;
        }
        return com.uc.crashsdk.a.g.a(canonicalPath) ? file.getPath() : canonicalPath;
    }

    private static long a(StatFs statFs, String str, String str2) {
        try {
            Method declaredMethod = StatFs.class.getDeclaredMethod(str, new Class[0]);
            declaredMethod.setAccessible(true);
            Object objInvoke = declaredMethod.invoke(statFs, new Object[0]);
            if (objInvoke != null && (objInvoke instanceof Long)) {
                return ((Long) objInvoke).longValue();
            }
        } catch (Throwable unused) {
        }
        try {
            Method declaredMethod2 = StatFs.class.getDeclaredMethod(str2, new Class[0]);
            declaredMethod2.setAccessible(true);
            Object objInvoke2 = declaredMethod2.invoke(statFs, new Object[0]);
            if (objInvoke2 == null || !(objInvoke2 instanceof Integer)) {
                return 0L;
            }
            return ((Integer) objInvoke2).intValue();
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
            return 0L;
        }
    }

    private static void b(OutputStream outputStream) {
        BufferedReader bufferedReaderA = null;
        try {
            outputStream.write("logcat:\n".getBytes(DataUtil.defaultCharset));
        } finally {
        }
        try {
            if (g.n() <= 0) {
                try {
                    outputStream.write("[DEBUG] custom java logcat lines count is 0!\n".getBytes(DataUtil.defaultCharset));
                } catch (Throwable th) {
                    a(th, outputStream);
                }
                a(outputStream);
                return;
            }
            int iN = g.n();
            bufferedReaderA = a(new InputStreamReader(Runtime.getRuntime().exec(new String[]{"logcat", "-d", "-b", com.umeng.analytics.pro.c.ar, "-b", "main", "-v", "threadtime", "-t", String.valueOf(iN)}).getInputStream()));
            if (bufferedReaderA == null) {
                try {
                    outputStream.write("[DEBUG] alloc buffer failed!\n".getBytes(DataUtil.defaultCharset));
                } catch (Throwable th2) {
                    a(th2, outputStream);
                }
                a(outputStream);
                return;
            }
            f4573h = false;
            int i2 = 0;
            int i3 = 0;
            while (true) {
                String line = bufferedReaderA.readLine();
                if (line != null) {
                    i2++;
                    if (i3 < iN && !line.contains(" I auditd ") && !line.contains(" I liblog ")) {
                        outputStream.write(line.getBytes(DataUtil.defaultCharset));
                        outputStream.write("\n".getBytes(DataUtil.defaultCharset));
                        i3++;
                    }
                } else {
                    try {
                        break;
                    } catch (Throwable th3) {
                        a(th3, outputStream);
                    }
                }
            }
            outputStream.write(String.format(Locale.US, "[DEBUG] Read %d lines, wrote %d lines.\n", Integer.valueOf(i2), Integer.valueOf(i3)).getBytes(DataUtil.defaultCharset));
            f4573h = true;
            com.uc.crashsdk.a.g.a(bufferedReaderA);
            a(outputStream);
            return;
            com.uc.crashsdk.a.g.a(bufferedReaderA);
            a(outputStream);
            return;
        } finally {
        }
    }

    private static void a(a aVar) {
        try {
            aVar.a(String.format(Locale.US, "log end: %s\n", m()));
        } catch (Throwable th) {
            a(th, aVar);
        }
    }

    public static int a(OutputStream outputStream, String str, int i2) {
        int i3 = 0;
        if (str == null) {
            a(outputStream);
            return 0;
        }
        try {
            String strA = com.uc.crashsdk.a.b.a(str);
            if (strA == null) {
                strA = "file: '" + str + "' not found or decode failed!";
            }
            int length = strA.length();
            if (length <= i2 + 32) {
                i2 = length;
            }
            if (i2 > 0) {
                try {
                    outputStream.write(strA.getBytes(DataUtil.defaultCharset), 0, i2);
                    outputStream.write("\n".getBytes(DataUtil.defaultCharset));
                } catch (Throwable th) {
                    th = th;
                    i3 = i2;
                    a(th, outputStream);
                    i2 = i3;
                }
            }
            if (i2 < strA.length()) {
                outputStream.write(String.format(Locale.US, "(truncated %d bytes)\n", Integer.valueOf(strA.length() - i2)).getBytes(DataUtil.defaultCharset));
            }
        } catch (Throwable th2) {
            th = th2;
        }
        a(outputStream);
        return i2;
    }

    public static String a(int i2) {
        try {
            String strA = com.uc.crashsdk.a.g.a(new File(String.format(Locale.US, "/proc/%d/cmdline", Integer.valueOf(i2))), 128, false);
            return com.uc.crashsdk.a.g.b(strA) ? k(strA) : EnvironmentCompat.MEDIA_UNKNOWN;
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
            return EnvironmentCompat.MEDIA_UNKNOWN;
        }
    }

    private static void b(a aVar) {
        f4573h = false;
        try {
            aVar.write((r("LOG_END") + "\n").getBytes(DataUtil.defaultCharset));
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
        }
        f4573h = true;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(26:0|2|323|3|4|(2:357|6)|9|(1:11)(1:13)|14|(51:318|15|(1:17)|21|(2:339|23)|343|28|291|32|314|33|(1:35)|39|(1:43)|307|47|329|51|55|341|56|347|61|(2:281|67)|72|310|73|77|355|78|321|82|86|337|87|92|(4:94|289|95|99)|303|100|105|316|106|335|111|309|115|(1:117)(2:118|(1:120))|124|333|125|129)|(4:131|277|132|136)(10:301|139|(0)(8:146|287|147|148|149|293|150|(14:152|153|285|154|353|155|156|349|157|176|331|177|181|(21:183|279|184|206|207|345|208|213|(4:215|299|216|220)|312|221|226|327|227|232|(4:234|351|235|239)|240|297|241|(1:247)|248)(25:325|189|(1:191)|192|(1:194)|195|(4:197|(1:199)(1:201)|200|202)|206|207|345|208|213|(0)|312|221|226|327|227|232|(0)|240|297|241|(0)|248))(7:169|138|176|331|177|181|(0)(0)))|258|(1:260)|295|261|(1:263)(1:264)|265|269)|137|138|176|331|177|181|(0)(0)|258|(0)|295|261|(0)(0)|265|269|(3:(0)|(1:284)|(1:319))) */
    /* JADX WARN: Code restructure failed: missing block: B:179:0x0345, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:180:0x0346, code lost:
    
        a(r0, r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:267:0x04ac, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:268:0x04ad, code lost:
    
        com.uc.crashsdk.a.g.a(r0);
     */
    /* JADX WARN: Removed duplicated region for block: B:183:0x034d  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x041d A[Catch: all -> 0x047c, TRY_LEAVE, TryCatch #21 {all -> 0x047c, blocks: (B:21:0x0040, B:55:0x0107, B:86:0x0183, B:92:0x0192, B:94:0x0196, B:99:0x01aa, B:98:0x01a7, B:105:0x01b5, B:124:0x01fb, B:129:0x020c, B:131:0x0210, B:136:0x0224, B:176:0x0338, B:181:0x0349, B:206:0x0404, B:213:0x0419, B:215:0x041d, B:220:0x0432, B:219:0x042f, B:232:0x0448, B:234:0x044c, B:239:0x0461, B:238:0x045e, B:240:0x0464, B:245:0x0470, B:231:0x0445, B:225:0x043b, B:212:0x0416, B:187:0x0363, B:180:0x0346, B:135:0x0221, B:175:0x0335, B:128:0x0209, B:123:0x01f8, B:114:0x01cc, B:110:0x01be, B:104:0x01b2, B:91:0x018f, B:85:0x0180, B:81:0x015f, B:76:0x0139, B:71:0x0124, B:65:0x0119, B:60:0x0110, B:54:0x0104, B:50:0x00f6, B:46:0x00e9, B:31:0x0090, B:27:0x004f, B:20:0x003d, B:132:0x0212, B:67:0x011e, B:95:0x0198, B:32:0x0093, B:39:0x00bf, B:41:0x00c5, B:43:0x00cf, B:38:0x00bc, B:33:0x009c, B:35:0x00ad, B:241:0x046a, B:216:0x0420, B:100:0x01ac, B:47:0x00ec, B:115:0x01cf, B:117:0x01d3, B:118:0x01e5, B:120:0x01eb, B:73:0x0129, B:221:0x0435, B:106:0x01b8, B:15:0x0032, B:17:0x0036, B:82:0x0162, B:227:0x043f, B:51:0x00f9, B:177:0x033b, B:125:0x01fe, B:111:0x01c1, B:87:0x0189, B:23:0x0049, B:56:0x010a, B:28:0x0052, B:208:0x0410, B:61:0x0113, B:235:0x044f, B:78:0x013d), top: B:318:0x0032, inners: #0, #2, #6, #7, #10, #11, #13, #15, #16, #17, #18, #20, #22, #23, #26, #27, #28, #29, #30, #31, #32, #33, #34, #35, #36, #38, #40 }] */
    /* JADX WARN: Removed duplicated region for block: B:234:0x044c A[Catch: all -> 0x047c, TRY_LEAVE, TryCatch #21 {all -> 0x047c, blocks: (B:21:0x0040, B:55:0x0107, B:86:0x0183, B:92:0x0192, B:94:0x0196, B:99:0x01aa, B:98:0x01a7, B:105:0x01b5, B:124:0x01fb, B:129:0x020c, B:131:0x0210, B:136:0x0224, B:176:0x0338, B:181:0x0349, B:206:0x0404, B:213:0x0419, B:215:0x041d, B:220:0x0432, B:219:0x042f, B:232:0x0448, B:234:0x044c, B:239:0x0461, B:238:0x045e, B:240:0x0464, B:245:0x0470, B:231:0x0445, B:225:0x043b, B:212:0x0416, B:187:0x0363, B:180:0x0346, B:135:0x0221, B:175:0x0335, B:128:0x0209, B:123:0x01f8, B:114:0x01cc, B:110:0x01be, B:104:0x01b2, B:91:0x018f, B:85:0x0180, B:81:0x015f, B:76:0x0139, B:71:0x0124, B:65:0x0119, B:60:0x0110, B:54:0x0104, B:50:0x00f6, B:46:0x00e9, B:31:0x0090, B:27:0x004f, B:20:0x003d, B:132:0x0212, B:67:0x011e, B:95:0x0198, B:32:0x0093, B:39:0x00bf, B:41:0x00c5, B:43:0x00cf, B:38:0x00bc, B:33:0x009c, B:35:0x00ad, B:241:0x046a, B:216:0x0420, B:100:0x01ac, B:47:0x00ec, B:115:0x01cf, B:117:0x01d3, B:118:0x01e5, B:120:0x01eb, B:73:0x0129, B:221:0x0435, B:106:0x01b8, B:15:0x0032, B:17:0x0036, B:82:0x0162, B:227:0x043f, B:51:0x00f9, B:177:0x033b, B:125:0x01fe, B:111:0x01c1, B:87:0x0189, B:23:0x0049, B:56:0x010a, B:28:0x0052, B:208:0x0410, B:61:0x0113, B:235:0x044f, B:78:0x013d), top: B:318:0x0032, inners: #0, #2, #6, #7, #10, #11, #13, #15, #16, #17, #18, #20, #22, #23, #26, #27, #28, #29, #30, #31, #32, #33, #34, #35, #36, #38, #40 }] */
    /* JADX WARN: Removed duplicated region for block: B:247:0x0475  */
    /* JADX WARN: Removed duplicated region for block: B:256:0x048a A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:260:0x0494  */
    /* JADX WARN: Removed duplicated region for block: B:263:0x049b A[Catch: all -> 0x04ac, TryCatch #9 {all -> 0x04ac, blocks: (B:261:0x0497, B:263:0x049b, B:265:0x04a6), top: B:295:0x0497 }] */
    /* JADX WARN: Removed duplicated region for block: B:264:0x04a4  */
    /* JADX WARN: Removed duplicated region for block: B:325:0x0368 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.lang.String a(java.lang.Throwable r23, java.lang.String r24, long r25, boolean r27) {
        /*
            Method dump skipped, instruction units count: 1216
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.e.a(java.lang.Throwable, java.lang.String, long, boolean):java.lang.String");
    }

    public static int b(OutputStream outputStream, String str, int i2) {
        int i3;
        DataInputStream dataInputStream;
        int i4;
        DataInputStream dataInputStream2 = null;
        int i5 = 0;
        try {
            File file = new File(str);
            if (file.exists()) {
                byte[] bArrQ = Q();
                if (bArrQ == null) {
                    outputStream.write("(alloc buffer failed!)\n".getBytes(DataUtil.defaultCharset));
                    return 0;
                }
                dataInputStream = new DataInputStream(new FileInputStream(file));
                i4 = 0;
                i3 = 0;
                loop0: while (true) {
                    boolean z2 = false;
                    while (true) {
                        try {
                            int i6 = dataInputStream.read(bArrQ);
                            if (i6 == -1) {
                                break loop0;
                            }
                            i4 += i6;
                            int i7 = i2 - i3;
                            if (i6 <= i7 + 32) {
                                i7 = i6;
                            }
                            if (i7 > 0 && !z2) {
                                outputStream.write(bArrQ, 0, i7);
                                i3 += i7;
                            }
                            if (!z2) {
                                if (i7 < i6 || i3 >= i2) {
                                    z2 = true;
                                }
                            }
                        } catch (Throwable th) {
                            th = th;
                            i5 = i3;
                            dataInputStream2 = dataInputStream;
                            try {
                                a(th, outputStream);
                                com.uc.crashsdk.a.g.a(dataInputStream2);
                                i3 = i5;
                            } finally {
                                com.uc.crashsdk.a.g.a(dataInputStream2);
                            }
                        }
                    }
                }
            } else {
                outputStream.write(("file: '" + str + "' not exists!\n").getBytes(DataUtil.defaultCharset));
                dataInputStream = null;
                i4 = 0;
                i3 = 0;
            }
            if (i3 > 0) {
                outputStream.write("\n".getBytes(DataUtil.defaultCharset));
            }
            if (i3 < i4) {
                outputStream.write(String.format(Locale.US, "(truncated %d bytes)\n", Integer.valueOf(i4 - i3)).getBytes(DataUtil.defaultCharset));
            }
        } catch (Throwable th2) {
            th = th2;
        }
        a(outputStream);
        return i3;
    }

    public static void b(boolean z2) {
        try {
            boolean zS = g.r() && com.uc.crashsdk.b.C() && !f4570d;
            if (!zS) {
                zS = g.s();
            }
            if (zS) {
                if (z2) {
                    String strK = k();
                    if (com.uc.crashsdk.a.g.a(strK)) {
                        return;
                    }
                    j();
                    a(strK, false, false);
                    return;
                }
                a(true, false);
            }
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
        }
    }

    private static boolean b(File file) {
        int iIndexOf;
        String name = file.getName();
        int iLastIndexOf = name.lastIndexOf(95);
        if (iLastIndexOf <= 0 || (iIndexOf = name.indexOf(46, iLastIndexOf)) <= 0) {
            return false;
        }
        String strSubstring = name.substring(iLastIndexOf + 1, iIndexOf);
        return LogType.JAVA_TYPE.equals(strSubstring) || "ucebujava".equals(strSubstring) || LogType.NATIVE_TYPE.equals(strSubstring) || "ucebujni".equals(strSubstring) || LogType.UNEXP_TYPE.equals(strSubstring) || LogType.ANR_TYPE.equals(strSubstring);
    }

    private static String b(String str, boolean z2, boolean z3) {
        if (z2) {
            try {
                str = l(str);
            } catch (Throwable th) {
                com.uc.crashsdk.a.g.a(th);
            }
        }
        if (!z3) {
            return str;
        }
        try {
            return a(str);
        } catch (Throwable th2) {
            com.uc.crashsdk.a.g.a(th2);
            return str;
        }
    }

    public static void b(String str, String str2, boolean z2) {
        h.a(str, str2, false, z2);
    }

    public static void b(String str) {
        synchronized (z) {
            com.uc.crashsdk.a.b.a(com.uc.crashsdk.b.i(), str + "\n");
        }
    }

    private static void b(String str, String str2) {
        try {
            com.uc.crashsdk.d.a(str, h(), str2);
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
        }
    }

    public static void b(Context context) {
        if (g.K()) {
            try {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.intent.action.BATTERY_CHANGED");
                intentFilter.addAction("android.intent.action.BATTERY_LOW");
                intentFilter.addAction("android.intent.action.BATTERY_OKAY");
                context.registerReceiver(Q, intentFilter, null, com.uc.crashsdk.a.f.a(1));
                R = true;
            } catch (Throwable th) {
                com.uc.crashsdk.a.g.a(th);
            }
        }
    }

    public static void b(int i2) {
        com.uc.crashsdk.a.f.a(0, new com.uc.crashsdk.a.e(410), i2 * 1000);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static int b(boolean z2, boolean z3) {
        int i2;
        if (z3 && !ac) {
            f.d(false);
        }
        if (z2) {
            boolean zA = f.a(com.uc.crashsdk.b.c(), false);
            h.i();
            i2 = zA;
        } else {
            int iA = f.a();
            h.i();
            i2 = iA;
        }
        return z3 ? f.a(z2) : i2;
    }

    public static String a(String str) {
        int iLastIndexOf;
        int iIndexOf;
        int i2;
        int iIndexOf2;
        File file;
        byte[] bArrE;
        if (!g.x() || (iLastIndexOf = str.lastIndexOf(47)) <= 0 || (iIndexOf = str.indexOf(95, iLastIndexOf)) <= iLastIndexOf || (iIndexOf2 = str.indexOf(95, (i2 = iIndexOf + 1))) <= iIndexOf) {
            return str;
        }
        String strD = com.uc.crashsdk.a.g.d("CrashSDK" + str.substring(iLastIndexOf + 1, iIndexOf) + str.substring(i2, iIndexOf2));
        if (strD == null || (bArrE = com.uc.crashsdk.a.g.e((file = new File(str)))) == null || bArrE.length <= 0) {
            return str;
        }
        byte[] bArrB = null;
        try {
            bArrB = com.uc.crashsdk.a.c.b(bArrE, strD.substring(0, 16).getBytes());
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
        }
        if (bArrB == null) {
            return str;
        }
        String strI = c.a.a.a.a.i(str, ".ec");
        File file2 = new File(c.a.a.a.a.i(strI, ".tmp"));
        if (!com.uc.crashsdk.a.g.a(file2, bArrB)) {
            return str;
        }
        if (!file2.renameTo(new File(strI))) {
            file2.delete();
            return str;
        }
        file.delete();
        return strI;
    }

    public static void a(Throwable th, OutputStream outputStream) {
        if (outputStream != null) {
            try {
                outputStream.write("[DEBUG] CrashHandler occurred new exception:\n".getBytes(DataUtil.defaultCharset));
                th.printStackTrace(new PrintStream(outputStream));
                outputStream.write("\n\n".getBytes(DataUtil.defaultCharset));
            } catch (Throwable th2) {
                com.uc.crashsdk.a.g.a(th2);
            }
        }
        com.uc.crashsdk.a.g.a(th);
    }

    /* JADX WARN: Removed duplicated region for block: B:112:0x02e7  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x02f2 A[Catch: all -> 0x0432, TryCatch #0 {all -> 0x0432, blocks: (B:4:0x000a, B:6:0x0010, B:8:0x001f, B:9:0x0034, B:11:0x003a, B:12:0x004d, B:14:0x005d, B:16:0x0067, B:147:0x03bd, B:18:0x006d, B:20:0x007b, B:22:0x008d, B:25:0x00ae, B:27:0x00be, B:31:0x00cb, B:42:0x00f7, B:38:0x00e9, B:62:0x01c4, B:64:0x01d8, B:66:0x01dc, B:67:0x01de, B:69:0x01e3, B:70:0x01e5, B:71:0x01ea, B:81:0x020d, B:82:0x0223, B:84:0x0229, B:86:0x0232, B:88:0x023e, B:90:0x025d, B:91:0x0270, B:93:0x0282, B:95:0x0290, B:96:0x02a1, B:110:0x02e3, B:113:0x02f2, B:116:0x02fe, B:119:0x030d, B:121:0x031b, B:123:0x0328, B:126:0x032f, B:130:0x033c, B:132:0x0348, B:134:0x0362, B:135:0x0367, B:137:0x0377, B:139:0x0384, B:145:0x03ae, B:150:0x03d1, B:152:0x03d8, B:154:0x03df, B:156:0x03e6, B:158:0x03ed, B:160:0x03f4, B:166:0x0406, B:168:0x040d, B:170:0x0414, B:172:0x041b, B:164:0x03ff, B:138:0x037e, B:140:0x03a1, B:142:0x03a6, B:98:0x02a7, B:100:0x02ad, B:103:0x02b5, B:105:0x02b9, B:107:0x02cd, B:109:0x02d1, B:75:0x01f4, B:77:0x0202, B:79:0x0208, B:61:0x01c1, B:173:0x0423), top: B:193:0x000a, outer: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:124:0x032c  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01b5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void a(java.lang.String r31, boolean r32, boolean r33) {
        /*
            Method dump skipped, instruction units count: 1099
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.e.a(java.lang.String, boolean, boolean):void");
    }

    public static boolean a(boolean z2, boolean z3) {
        if (!f4570d) {
            if (com.uc.crashsdk.b.f4552d) {
                JNIBridge.set(1, true);
            }
            f4570d = true;
        }
        try {
            String strK = k();
            if (com.uc.crashsdk.a.g.a(strK)) {
                com.uc.crashsdk.a.a.a("crashsdk", "CrashHandler url is empty!");
                return false;
            }
            Object obj = n;
            synchronized (obj) {
                if (com.uc.crashsdk.a.f.a(z2 ? 1 : 0, new com.uc.crashsdk.a.e(406, new Object[]{strK, Boolean.valueOf(z3), Boolean.valueOf(z2)})) && z2) {
                    try {
                        obj.wait();
                    } catch (InterruptedException e2) {
                        com.uc.crashsdk.a.g.a(e2);
                    }
                }
            }
            return true;
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
            return false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r5v7 */
    private static boolean a(String str, com.uc.crashsdk.a.e eVar) {
        boolean zA;
        FileChannel channel;
        Exception e2;
        synchronized (o) {
            File file = new File(str);
            if (!file.exists()) {
                try {
                    file.createNewFile();
                } catch (Exception e3) {
                    com.uc.crashsdk.a.g.a(e3);
                }
            }
            ?? r5 = 0;
            fileLockLock = null;
            FileLock fileLockLock = null;
            zA = false;
            try {
                try {
                    try {
                        channel = new RandomAccessFile(file, "rw").getChannel();
                    } catch (Throwable th) {
                        th = th;
                        r5 = file;
                        com.uc.crashsdk.a.g.a((Closeable) r5);
                        throw th;
                    }
                } catch (Exception e4) {
                    try {
                        com.uc.crashsdk.a.g.a(e4);
                        channel = null;
                    } catch (Exception e5) {
                        channel = null;
                        e2 = e5;
                        com.uc.crashsdk.a.g.a(e2);
                        com.uc.crashsdk.a.g.a(channel);
                        return zA;
                    }
                }
                if (channel != null) {
                    try {
                        fileLockLock = channel.lock();
                    } catch (Exception e6) {
                        try {
                            com.uc.crashsdk.a.g.a(e6);
                        } catch (Exception e7) {
                            e2 = e7;
                            com.uc.crashsdk.a.g.a(e2);
                        }
                    }
                }
                try {
                    zA = eVar.a();
                    com.uc.crashsdk.a.g.a(channel);
                } finally {
                    if (fileLockLock != null) {
                        try {
                            fileLockLock.release();
                        } catch (Exception e8) {
                            com.uc.crashsdk.a.g.a(e8);
                        }
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
        return zA;
    }

    private static boolean a(String str, d dVar) {
        String strA = com.uc.crashsdk.a.g.a(new File(str), 64, false);
        if (strA == null) {
            return false;
        }
        try {
            Matcher matcher = Pattern.compile("(\\d+)\\s+(\\d+)\\s+(\\d+)\\s+(\\d+)").matcher(strA);
            if (matcher.find()) {
                long j2 = Long.parseLong(matcher.group(1));
                if (System.currentTimeMillis() - j2 < 86400000) {
                    dVar.f4583b = Long.parseLong(matcher.group(2));
                    dVar.f4584c = Integer.parseInt(matcher.group(3));
                    dVar.f4585d = Integer.parseInt(matcher.group(4));
                    dVar.a = j2;
                }
            }
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0 */
    /* JADX WARN: Type inference failed for: r11v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r11v3 */
    public static boolean a(StringBuffer stringBuffer, String str, long j2, ArrayList<String> arrayList, ArrayList<String> arrayList2, ArrayList<String> arrayList3, String str2) {
        long j3;
        boolean z2;
        boolean zA;
        if (f4569c.get()) {
            com.uc.crashsdk.a.a.b("Processing java crash, skip generate custom log: " + str);
            return false;
        }
        boolean z3 = af || com.uc.crashsdk.b.I();
        if (!z3 && !com.uc.crashsdk.a.d.d()) {
            com.uc.crashsdk.a.a.c("DEBUG", com.uc.crashsdk.a.d.b());
            return false;
        }
        if (!c(str)) {
            com.uc.crashsdk.a.a.d("DEBUG", "custom log sample miss: " + str);
            return false;
        }
        if (Z()) {
            com.uc.crashsdk.a.a.b("Processing native crash, skip generate custom log: " + str);
            return false;
        }
        if (stringBuffer == null || str == null) {
            return false;
        }
        String strA = g.V() + j(str);
        ?? r11 = (j2 & 32) != 0 ? 1 : 0;
        if (z3) {
            long jNativeClientCreateConnection = com.uc.crashsdk.b.f4552d ? JNIBridge.nativeClientCreateConnection(strA, "custom", str, r11) : 0L;
            if (jNativeClientCreateConnection == 0) {
                com.uc.crashsdk.a.a.d("DEBUG", "skip custom log: " + str);
                return false;
            }
            j3 = jNativeClientCreateConnection;
        } else {
            if (a(h(), str, (boolean) r11)) {
                return false;
            }
            g.a();
            a(false);
            j3 = 0;
        }
        synchronized (p) {
            z2 = r11;
            zA = a(strA, j3, stringBuffer, str, j2, arrayList, arrayList2, arrayList3, str2);
        }
        if (zA && !z3) {
            b(h(), str, z2);
        }
        if (j3 != 0) {
            JNIBridge.nativeClientCloseConnection(j3);
        }
        if (!zA) {
            return false;
        }
        if (!z3) {
            q(strA);
        }
        if (!z3) {
            strA = a(l(strA));
        }
        b(strA, str);
        if (z2 == 0 || z3) {
            return true;
        }
        try {
            a(true, false);
            return true;
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
            return true;
        }
    }

    public static boolean a(String str, String str2, boolean z2) {
        if (!n(str2)) {
            return false;
        }
        h.a(str, str2, true, z2);
        com.uc.crashsdk.a.a.b(String.format(Locale.US, "Custom log '%s' has reach max count!", str2));
        return true;
    }

    private static void a(a aVar, String str, long j2) {
        String strNativeDumpThreads;
        String str2 = null;
        if (com.uc.crashsdk.b.f4552d) {
            try {
                aVar.flush();
            } catch (Throwable th) {
                com.uc.crashsdk.a.g.a(th);
            }
            strNativeDumpThreads = JNIBridge.nativeDumpThreads(str, j2);
            if (af || strNativeDumpThreads == null || strNativeDumpThreads.length() >= 512 || !strNativeDumpThreads.startsWith(w.DEFAULT_PATH_SEPARATOR) || strNativeDumpThreads.indexOf(10) >= 0) {
                str2 = strNativeDumpThreads;
            } else {
                if (!new File(strNativeDumpThreads).exists()) {
                    str2 = "Can not found " + strNativeDumpThreads;
                }
                String str3 = str2;
                str2 = strNativeDumpThreads;
                strNativeDumpThreads = str3;
            }
        } else {
            strNativeDumpThreads = "Native not initialized, skip dump!";
        }
        if (strNativeDumpThreads != null) {
            try {
                aVar.write(strNativeDumpThreads.getBytes(DataUtil.defaultCharset));
                aVar.write("\n".getBytes(DataUtil.defaultCharset));
            } catch (Throwable th2) {
                com.uc.crashsdk.a.g.a(th2);
            }
            a((OutputStream) aVar);
        } else if (str2 != null && !af) {
            b(aVar, str2, 1048576);
            File file = new File(str2);
            if (file.exists()) {
                file.delete();
            }
        }
        try {
            aVar.flush();
        } catch (Throwable th3) {
            com.uc.crashsdk.a.g.a(th3);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0043 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0044  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static boolean a(java.lang.String r18, long r19, java.lang.StringBuffer r21, java.lang.String r22, long r23, java.util.ArrayList<java.lang.String> r25, java.util.ArrayList<java.lang.String> r26, java.util.ArrayList<java.lang.String> r27, java.lang.String r28) {
        /*
            Method dump skipped, instruction units count: 386
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.e.a(java.lang.String, long, java.lang.StringBuffer, java.lang.String, long, java.util.ArrayList, java.util.ArrayList, java.util.ArrayList, java.lang.String):boolean");
    }

    public static void a(String str, boolean z2) {
        if (z2) {
            x = str;
            return;
        }
        synchronized (y) {
            w = str;
            com.uc.crashsdk.a.b.a(com.uc.crashsdk.b.f(), str + "\n");
        }
    }

    private static String a(Date date) {
        return String.format(Locale.US, "%d%02d%02d%02d%02d%02d", Integer.valueOf(date.getYear() + 1900), Integer.valueOf(date.getMonth() + 1), Integer.valueOf(date.getDate()), Integer.valueOf(date.getHours()), Integer.valueOf(date.getMinutes()), Integer.valueOf(date.getSeconds()));
    }

    public static void a(OutputStream outputStream, String str, String str2, int i2, boolean z2, boolean z3) {
        f4573h = false;
        try {
            Locale locale = Locale.US;
            Object[] objArr = new Object[5];
            objArr[0] = str;
            objArr[1] = str2;
            objArr[2] = Integer.valueOf(i2);
            objArr[3] = Integer.valueOf(z2 ? 1 : 0);
            objArr[4] = Integer.valueOf(z3 ? 1 : 0);
            outputStream.write(String.format(locale, "$^%s`%s`%d`%d,%d^$", objArr).getBytes(DataUtil.defaultCharset));
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
        }
        f4573h = true;
        a(outputStream);
    }

    public static void a(OutputStream outputStream, String str, String str2) {
        f4573h = false;
        try {
            outputStream.write(String.format(Locale.US, "$^%s`%s^$", str, str2).getBytes(DataUtil.defaultCharset));
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
        }
        f4573h = true;
    }

    public static void a(Context context) {
        try {
            if (U()) {
                context.registerReceiver(new c((byte) 0), new IntentFilter("android.intent.action.ANR"), null, com.uc.crashsdk.a.f.a(3));
            }
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(19:(21:64|(34:107|(1:109)|110|(1:112)|113|560|114|535|119|525|120|(1:124)|125|126|133|491|(9:554|135|540|136|(1:138)(1:139)|539|574|146|(14:151|(3:511|153|(1:163)(3:507|156|157))(0)|(1:166)|548|167|523|171|(1:173)|174|(1:178)|179|(1:182)|186|(2:188|189)(1:583))(2:190|(14:192|(3:499|194|(1:204)(3:497|197|198))(0)|(1:207)|533|208|521|212|(1:214)|215|(1:219)|220|(1:223)|227|(2:229|230)(1:584))(1:231)))(5:(1:233)|234|(1:236)(1:238)|239|(15:241|(1:245)|(3:562|247|(1:257)(3:558|250|251))(0)|(1:260)|485|261|570|265|(1:267)|268|(1:272)|273|(1:276)|280|(2:282|283)(1:585))(1:(14:(1:288)|(3:552|290|(1:300)(3:546|293|294))(0)|(1:303)|576|304|566|308|(1:310)|311|(1:315)|316|(1:319)|323|(2:325|326)(1:586))))|327|(6:332|(1:334)|335|537|336|341)|342|(1:346)|(3:542|348|(1:359)(4:351|529|352|353))(0)|(1:362)|572|363|564|367|(1:369)|370|(1:374)|375|(1:378)|382|(2:384|385)(1:587))(14:68|(3:494|70|(1:80)(3:489|73|74))(0)|(1:83)|519|84|503|88|(1:90)|91|(1:95)|96|(1:99)|103|(2:105|106)(1:582))|392|568|393|(1:395)|396|(1:400)|(3:513|402|(1:413)(4:405|505|406|407))(0)|(1:416)|550|417|527|421|(1:423)|424|(1:428)|429|(1:432)|436|(2:438|439)(1:588))(17:14|(6:17|544|18|23|(1:579)(1:580)|15)|578|25|(3:492|27|(1:37)(3:487|30|31))(0)|(1:40)|517|41|501|45|(1:47)|48|(1:52)|53|(1:56)|60|(2:62|63)(1:581))|568|393|(0)|396|(2:398|400)|(0)(0)|(1:416)|550|417|527|421|(0)|424|(2:426|428)|429|(1:432)|436|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:419:0x058a, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:420:0x058b, code lost:
    
        com.uc.crashsdk.a.g.a(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:434:0x05c2, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:435:0x05c3, code lost:
    
        com.uc.crashsdk.a.g.a(r0);
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:163:0x023c  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x02b7  */
    /* JADX WARN: Removed duplicated region for block: B:257:0x0355  */
    /* JADX WARN: Removed duplicated region for block: B:300:0x03d0  */
    /* JADX WARN: Removed duplicated region for block: B:359:0x04cd  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:395:0x0544 A[Catch: all -> 0x05d7, TRY_LEAVE, TryCatch #43 {all -> 0x05d7, blocks: (B:393:0x052e, B:395:0x0544), top: B:568:0x052e }] */
    /* JADX WARN: Removed duplicated region for block: B:413:0x057e  */
    /* JADX WARN: Removed duplicated region for block: B:423:0x0599  */
    /* JADX WARN: Removed duplicated region for block: B:438:0x05cf  */
    /* JADX WARN: Removed duplicated region for block: B:458:0x05ff A[DONT_GENERATE, FINALLY_INSNS] */
    /* JADX WARN: Removed duplicated region for block: B:468:0x061a A[DONT_GENERATE, FINALLY_INSNS] */
    /* JADX WARN: Removed duplicated region for block: B:483:0x0650 A[DONT_GENERATE, FINALLY_INSNS] */
    /* JADX WARN: Removed duplicated region for block: B:513:0x0565 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:588:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:589:? A[DONT_GENERATE, FINALLY_INSNS, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00ee  */
    /* JADX WARN: Type inference failed for: r12v0 */
    /* JADX WARN: Type inference failed for: r12v1, types: [long] */
    /* JADX WARN: Type inference failed for: r12v12 */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r12v3 */
    /* JADX WARN: Type inference failed for: r12v4 */
    /* JADX WARN: Type inference failed for: r12v6, types: [long] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(java.lang.Thread r20, java.lang.Throwable r21, boolean r22) {
        /*
            Method dump skipped, instruction units count: 1624
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.e.a(java.lang.Thread, java.lang.Throwable, boolean):void");
    }

    private static void a(Throwable th) {
        try {
            com.uc.crashsdk.a.a.d("DEBUG", a(th.getStackTrace(), (String) null).toString());
        } catch (Throwable unused) {
        }
    }

    private static void a(Calendar calendar) {
        if (g.Q()) {
            long timeInMillis = calendar.getTimeInMillis();
            calendar.add(5, 1);
            calendar.set(11, 0);
            calendar.set(12, 0);
            calendar.set(13, 0);
            long timeInMillis2 = calendar.getTimeInMillis();
            long j2 = timeInMillis2 - timeInMillis;
            com.uc.crashsdk.a.f.a(0, new com.uc.crashsdk.a.e(415, new Object[]{Long.valueOf(timeInMillis2)}), j2 <= 3600000 ? 1000 + j2 : 3600000L);
        }
    }

    public static StringBuilder a(StackTraceElement[] stackTraceElementArr, String str) {
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        if (stackTraceElementArr != null && stackTraceElementArr.length > 0) {
            boolean z2 = str == null;
            int i3 = 0;
            for (StackTraceElement stackTraceElement : stackTraceElementArr) {
                i3++;
                sb.append("  at ");
                sb.append(stackTraceElement.toString());
                sb.append("\n");
                if (!z2 && stackTraceElement.getMethodName().contains(str)) {
                    sb.delete(0, sb.length());
                    z2 = true;
                    i3 = 0;
                }
            }
            i2 = i3;
        }
        if (i2 == 0) {
            sb.append("  (no java stack)\n");
        }
        return sb;
    }

    public static boolean a(ParcelFileDescriptor parcelFileDescriptor) {
        if (ae) {
            com.uc.crashsdk.a.a.d("crashsdk", "Can not call setHostFd and getHostFd in the same process!");
            return false;
        }
        if (!com.uc.crashsdk.b.f4552d) {
            com.uc.crashsdk.a.a.d("crashsdk", "Crash so is not loaded!");
            return false;
        }
        if (ad != null) {
            com.uc.crashsdk.a.a.c("crashsdk", "Has already set host fd!");
        }
        ad = parcelFileDescriptor;
        int fd = parcelFileDescriptor.getFd();
        int iNativeCmd = (int) JNIBridge.nativeCmd(13, fd, null, null);
        af = iNativeCmd != -1;
        return fd == -1 || iNativeCmd != -1;
    }
}

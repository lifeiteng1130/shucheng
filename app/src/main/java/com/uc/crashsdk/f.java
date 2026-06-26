package com.uc.crashsdk;

import android.util.SparseArray;
import android.util.SparseIntArray;
import androidx.camera.camera2.internal.Camera2CameraImpl;
import com.uc.crashsdk.a.h;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: ProGuard */
/* JADX INFO: loaded from: classes.dex */
public class f {
    public static final /* synthetic */ boolean a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Map<String, SparseIntArray> f4592b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Object f4593c = new Object();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final SparseArray<String> f4594d = new SparseArray<>();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Object f4595e = new Object();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static boolean f4596f = false;

    public static void a(int i2) {
        a(i2, 1);
    }

    private static boolean b(int i2, int i3) {
        try {
            b.u();
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
        }
        try {
            String strC = c(i2);
            if (strC == null) {
                com.uc.crashsdk.a.a.a("crashsdk", "Stat type not exists: " + i2, null);
                return false;
            }
            File file = new File(b.c());
            try {
                if (!file.exists()) {
                    file.createNewFile();
                }
            } catch (Throwable th2) {
                com.uc.crashsdk.a.g.a(th2);
            }
            StringBuffer stringBufferA = a(file);
            if (com.uc.crashsdk.a.g.a(stringBufferA)) {
                if (stringBufferA == null) {
                    stringBufferA = new StringBuffer();
                }
                stringBufferA.append("[");
                stringBufferA.append(e.h());
                stringBufferA.append("]\n");
            }
            a(stringBufferA, strC, a(stringBufferA, strC) + i3);
            return a(file, stringBufferA);
        } catch (Throwable th3) {
            com.uc.crashsdk.a.g.a(th3);
            return false;
        }
    }

    private static boolean c(String str) {
        SparseIntArray sparseIntArray = f4592b.get(str);
        if (sparseIntArray == null) {
            return false;
        }
        for (int i2 = 0; i2 < sparseIntArray.size(); i2++) {
            int iKeyAt = sparseIntArray.keyAt(i2);
            d.a(str, iKeyAt, sparseIntArray.get(iKeyAt));
        }
        return true;
    }

    private static char[] d() {
        char[] cArr = null;
        int i2 = 1024;
        while (cArr == null && i2 > 0) {
            try {
                cArr = new char[i2];
            } catch (Throwable unused) {
                i2 /= 2;
                if (i2 < 512) {
                    return cArr;
                }
            }
        }
        return cArr;
    }

    private static void e() {
        SparseArray<String> sparseArray = f4594d;
        synchronized (sparseArray) {
            if (sparseArray.size() != 0) {
                return;
            }
            sparseArray.put(100, "start_pv");
            sparseArray.put(102, "start_hpv");
            sparseArray.put(1, "all_all");
            sparseArray.put(2, "all_fg");
            sparseArray.put(101, "all_bg");
            sparseArray.put(3, "java_fg");
            sparseArray.put(4, "java_bg");
            sparseArray.put(7, "native_fg");
            sparseArray.put(8, "native_bg");
            sparseArray.put(27, "native_anr_fg");
            sparseArray.put(28, "native_anr_bg");
            sparseArray.put(9, "native_ok");
            sparseArray.put(10, "unexp_anr");
            sparseArray.put(29, "unexp_lowmem");
            sparseArray.put(30, "unexp_killed");
            sparseArray.put(31, "unexp_exit");
            sparseArray.put(32, "unexp_restart");
            sparseArray.put(11, "unexp_fg");
            sparseArray.put(12, "unexp_bg");
            sparseArray.put(40, "anr_fg");
            sparseArray.put(41, "anr_bg");
            sparseArray.put(42, "anr_cr_fg");
            sparseArray.put(43, "anr_cr_bg");
            sparseArray.put(13, "log_up_succ");
            sparseArray.put(14, "log_up_fail");
            sparseArray.put(15, "log_empty");
            sparseArray.put(200, "log_tmp");
            sparseArray.put(16, "log_abd_all");
            sparseArray.put(22, "log_abd_builtin");
            sparseArray.put(23, "log_abd_custom");
            sparseArray.put(17, "log_large");
            sparseArray.put(18, "log_up_all");
            sparseArray.put(19, "log_up_bytes");
            sparseArray.put(20, "log_up_crash");
            sparseArray.put(21, "log_up_custom");
            sparseArray.put(24, "log_zipped");
            sparseArray.put(201, "log_enced");
            sparseArray.put(25, "log_renamed");
            sparseArray.put(26, "log_safe_skip");
        }
    }

    private static File[] f() {
        File[] fileArrListFiles = new File(g.U()).listFiles();
        if (fileArrListFiles == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (File file : fileArrListFiles) {
            if (file.getPath().endsWith(".st")) {
                arrayList.add(file);
            }
        }
        return (File[]) arrayList.toArray(new File[arrayList.size()]);
    }

    public static void a(int i2, int i3) {
        if (i3 != 0) {
            a(b.c(), new com.uc.crashsdk.a.e(751, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)}));
            return;
        }
        com.uc.crashsdk.a.a.b("Add stat for type " + i2 + " with count 0!");
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x004a A[Catch: all -> 0x0056, TryCatch #0 {, blocks: (B:7:0x0008, B:9:0x000c, B:11:0x000e, B:13:0x0016, B:15:0x0018, B:17:0x0020, B:19:0x002a, B:27:0x004a, B:28:0x004d, B:29:0x0054, B:21:0x0031, B:23:0x0037, B:25:0x0042), top: B:34:0x0008 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void d(boolean r3) {
        /*
            boolean r0 = com.uc.crashsdk.f.f4596f
            if (r0 == 0) goto L5
            return
        L5:
            java.lang.Object r0 = com.uc.crashsdk.f.f4595e
            monitor-enter(r0)
            boolean r1 = com.uc.crashsdk.f.f4596f     // Catch: java.lang.Throwable -> L56
            if (r1 == 0) goto Le
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L56
            return
        Le:
            java.lang.String r1 = "crash detail"
            boolean r3 = com.uc.crashsdk.a.h.a(r3, r1)     // Catch: java.lang.Throwable -> L56
            if (r3 == 0) goto L18
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L56
            return
        L18:
            r3 = 0
            boolean r1 = com.uc.crashsdk.b.p()     // Catch: java.lang.Throwable -> L56
            r2 = 1
            if (r1 == 0) goto L31
            r3 = 2
            a(r3, r2)     // Catch: java.lang.Throwable -> L56
            boolean r3 = com.uc.crashsdk.b.o()     // Catch: java.lang.Throwable -> L56
            if (r3 == 0) goto L2f
            r3 = 42
            a(r3, r2)     // Catch: java.lang.Throwable -> L56
        L2f:
            r3 = 1
            goto L48
        L31:
            boolean r1 = com.uc.crashsdk.b.q()     // Catch: java.lang.Throwable -> L56
            if (r1 == 0) goto L48
            r3 = 101(0x65, float:1.42E-43)
            a(r3, r2)     // Catch: java.lang.Throwable -> L56
            boolean r3 = com.uc.crashsdk.b.o()     // Catch: java.lang.Throwable -> L56
            if (r3 == 0) goto L2f
            r3 = 43
            a(r3, r2)     // Catch: java.lang.Throwable -> L56
            goto L2f
        L48:
            if (r3 == 0) goto L4d
            a(r2, r2)     // Catch: java.lang.Throwable -> L56
        L4d:
            r3 = 100
            a(r3, r2)     // Catch: java.lang.Throwable -> L56
            com.uc.crashsdk.f.f4596f = r2     // Catch: java.lang.Throwable -> L56
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L56
            return
        L56:
            r3 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L56
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.f.d(boolean):void");
    }

    private static String c(int i2) {
        String str;
        e();
        SparseArray<String> sparseArray = f4594d;
        synchronized (sparseArray) {
            str = sparseArray.get(i2);
        }
        return str;
    }

    private static StringBuffer a(File file) throws Throwable {
        FileReader fileReader;
        FileReader fileReader2 = null;
        if (!file.exists()) {
            return null;
        }
        char[] cArrD = d();
        if (cArrD == null) {
            com.uc.crashsdk.a.a.a("crashsdk", "readCrashStatData alloc buffer failed!", null);
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        try {
            try {
                fileReader = new FileReader(file);
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e2) {
            e = e2;
        }
        try {
            int i2 = fileReader.read(cArrD);
            if (i2 > 0) {
                fileReader2 = null;
                stringBuffer.append(cArrD, 0, i2);
            }
            com.uc.crashsdk.a.g.a(fileReader);
        } catch (Exception e3) {
            e = e3;
            fileReader2 = fileReader;
            com.uc.crashsdk.a.g.a(e);
            com.uc.crashsdk.a.g.a(fileReader2);
        } catch (Throwable th2) {
            th = th2;
            fileReader2 = fileReader;
            com.uc.crashsdk.a.g.a(fileReader2);
            throw th;
        }
        return stringBuffer;
    }

    public static void c(boolean z) {
        if (g.O() && !b.I()) {
            e.j();
            if (!h.e()) {
                h.a(z);
            }
            if (b.C()) {
                d(z);
                a(b.c(), z);
                h.b(z);
            }
        }
    }

    private static int a(StringBuffer stringBuffer, String str) {
        int iIndexOf = stringBuffer.indexOf(str);
        if (iIndexOf < 0) {
            return 0;
        }
        int iIndexOf2 = stringBuffer.indexOf("=", str.length() + iIndexOf);
        if (iIndexOf2 < 0) {
            com.uc.crashsdk.a.a.b(str + " line not contain '='!");
            return 0;
        }
        int i2 = iIndexOf2 + 1;
        int iIndexOf3 = stringBuffer.indexOf("\n", i2);
        if (iIndexOf3 < 0) {
            iIndexOf3 = stringBuffer.length();
        }
        try {
            int i3 = Integer.parseInt(stringBuffer.substring(i2, iIndexOf3));
            if (i3 < 0) {
                return 0;
            }
            return i3;
        } catch (NumberFormatException e2) {
            com.uc.crashsdk.a.g.a(e2);
            return 0;
        }
    }

    private static boolean b(String str) {
        e();
        synchronized (f4594d) {
            File file = new File(str);
            StringBuffer stringBufferA = a(file);
            if (com.uc.crashsdk.a.g.a(stringBufferA)) {
                return false;
            }
            int iIndexOf = stringBufferA.indexOf("[");
            if (iIndexOf < 0) {
                com.uc.crashsdk.a.a.a("crashsdk", "Can not found process name start!", null);
                return false;
            }
            int i2 = iIndexOf + 1;
            int iIndexOf2 = stringBufferA.indexOf("]", i2);
            if (iIndexOf2 < 0) {
                com.uc.crashsdk.a.a.a("crashsdk", "Can not found process name end!", null);
                return false;
            }
            String strSubstring = stringBufferA.substring(i2, iIndexOf2);
            int i3 = 0;
            boolean z = false;
            while (true) {
                try {
                    SparseArray<String> sparseArray = f4594d;
                    if (i3 >= sparseArray.size()) {
                        break;
                    }
                    int iKeyAt = sparseArray.keyAt(i3);
                    String str2 = sparseArray.get(iKeyAt);
                    int iA = a(stringBufferA, str2);
                    if (iA > 0) {
                        h.a(strSubstring, iKeyAt, iA);
                        Map<String, SparseIntArray> map = f4592b;
                        synchronized (map) {
                            SparseIntArray sparseIntArray = map.get(strSubstring);
                            if (sparseIntArray == null) {
                                sparseIntArray = new SparseIntArray();
                                map.put(strSubstring, sparseIntArray);
                            }
                            sparseIntArray.put(iKeyAt, sparseIntArray.get(iKeyAt, 0) + iA);
                        }
                        a(stringBufferA, str2, 0);
                        z = true;
                    }
                    i3++;
                } finally {
                    if (z) {
                        a(file, stringBufferA);
                    }
                }
            }
            return true;
        }
    }

    public static void c() {
        com.uc.crashsdk.a.f.a(1, new com.uc.crashsdk.a.e(Camera2CameraImpl.StateCallback.REOPEN_DELAY_MS), 3000L);
    }

    private static void a(StringBuffer stringBuffer, String str, int i2) {
        int iIndexOf = stringBuffer.indexOf(str);
        if (iIndexOf < 0) {
            if (i2 > 0) {
                stringBuffer.append(str);
                stringBuffer.append("=");
                stringBuffer.append(i2);
                stringBuffer.append("\n");
                return;
            }
            return;
        }
        int iIndexOf2 = stringBuffer.indexOf("\n", iIndexOf);
        if (iIndexOf2 < 0) {
            iIndexOf2 = stringBuffer.length();
        }
        StringBuilder sbT = c.a.a.a.a.t(str, "=");
        sbT.append(String.valueOf(i2));
        stringBuffer.replace(iIndexOf, iIndexOf2, sbT.toString());
    }

    private static boolean a(File file, StringBuffer stringBuffer) throws Throwable {
        FileWriter fileWriter;
        FileWriter fileWriter2 = null;
        try {
            try {
                fileWriter = new FileWriter(file);
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            String string = stringBuffer.toString();
            fileWriter.write(string, 0, string.length());
            com.uc.crashsdk.a.g.a(fileWriter);
            return true;
        } catch (Exception e3) {
            e = e3;
            fileWriter2 = fileWriter;
            com.uc.crashsdk.a.g.a(e);
            com.uc.crashsdk.a.g.a(fileWriter2);
            return false;
        } catch (Throwable th2) {
            th = th2;
            fileWriter2 = fileWriter;
            com.uc.crashsdk.a.g.a(fileWriter2);
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static int a(boolean z) {
        int i2;
        Map<String, SparseIntArray> map = f4592b;
        synchronized (map) {
            try {
                if (z) {
                    String strH = e.h();
                    boolean zC = c(strH);
                    map.remove(strH);
                    i2 = zC;
                } else {
                    Iterator<String> it = map.keySet().iterator();
                    int i3 = 0;
                    while (it.hasNext()) {
                        if (c(it.next())) {
                            i3++;
                        }
                    }
                    f4592b.clear();
                    i2 = i3;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return i2;
    }

    private static boolean a(String str, com.uc.crashsdk.a.e eVar) {
        return b.a(f4593c, str, eVar);
    }

    public static boolean a(String str, boolean z) {
        if (h.a(z, "crash detail report")) {
            return false;
        }
        return a(str, new com.uc.crashsdk.a.e(752, new Object[]{str}));
    }

    public static int a() {
        File[] fileArrF = f();
        if (fileArrF == null) {
            return 0;
        }
        int i2 = 0;
        for (File file : fileArrF) {
            if (a(file.getAbsolutePath(), false)) {
                i2++;
            }
        }
        return i2;
    }

    public static int b(boolean z) {
        int size;
        Map<String, SparseIntArray> map = f4592b;
        synchronized (map) {
            try {
                if (z) {
                    String strH = e.h();
                    if (map.containsKey(strH)) {
                        map.remove(strH);
                        size = 1;
                    } else {
                        size = 0;
                    }
                } else {
                    size = map.size();
                    map.clear();
                }
            } finally {
            }
        }
        return size;
    }

    public static boolean a(String str) {
        return a(str, new com.uc.crashsdk.a.e(753, new Object[]{str}));
    }

    public static boolean a(int i2, Object[] objArr) {
        switch (i2) {
            case 751:
                if (a || objArr != null) {
                    return b(((Integer) objArr[0]).intValue(), ((Integer) objArr[1]).intValue());
                }
                throw new AssertionError();
            case 752:
                if (a || objArr != null) {
                    return b((String) objArr[0]);
                }
                throw new AssertionError();
            case 753:
                if (!a && objArr == null) {
                    throw new AssertionError();
                }
                File file = new File((String) objArr[0]);
                if (!file.exists()) {
                    return false;
                }
                file.delete();
                return true;
            default:
                return false;
        }
    }

    public static int b() {
        File[] fileArrF = f();
        if (fileArrF == null) {
            return 0;
        }
        int i2 = 0;
        for (File file : fileArrF) {
            if (a(file.getAbsolutePath())) {
                i2++;
            }
        }
        return i2;
    }

    public static void b(int i2) {
        if (i2 != 700) {
            return;
        }
        d(false);
    }
}

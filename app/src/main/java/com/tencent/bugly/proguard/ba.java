package com.tencent.bugly.proguard;

import android.content.Context;
import android.os.Process;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.jsoup.helper.DataUtil;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes.dex */
public class ba {
    public static boolean a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static SimpleDateFormat f4335b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f4336c = true;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static int f4337d = 30720;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static StringBuilder f4338e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static StringBuilder f4339f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static boolean f4340g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static a f4341h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static String f4342i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static String f4343j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static Context f4344k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static String f4345l = null;
    private static boolean m = false;
    private static boolean n = false;
    private static ExecutorService o;
    private static int p;
    private static final Object q = new Object();

    /* JADX INFO: compiled from: BUGLY */
    public static class a {
        private boolean a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private File f4346b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f4347c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private long f4348d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private long f4349e = 30720;

        public a(String str) {
            if (str == null || str.equals("")) {
                return;
            }
            this.f4347c = str;
            this.a = a();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean a() {
            try {
                File file = new File(this.f4347c);
                this.f4346b = file;
                if (file.exists() && !this.f4346b.delete()) {
                    this.a = false;
                    return false;
                }
                if (this.f4346b.createNewFile()) {
                    return true;
                }
                this.a = false;
                return false;
            } catch (Throwable th) {
                X.b(th);
                this.a = false;
                return false;
            }
        }

        public boolean a(String str) {
            if (!this.a) {
                return false;
            }
            FileOutputStream fileOutputStream = null;
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(this.f4346b, true);
                try {
                    byte[] bytes = str.getBytes(DataUtil.defaultCharset);
                    fileOutputStream2.write(bytes);
                    fileOutputStream2.flush();
                    fileOutputStream2.close();
                    this.f4348d += (long) bytes.length;
                    this.a = true;
                    try {
                        fileOutputStream2.close();
                    } catch (IOException unused) {
                    }
                    return true;
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    try {
                        X.b(th);
                        this.a = false;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException unused2) {
                            }
                        }
                        return false;
                    } catch (Throwable th2) {
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException unused3) {
                            }
                        }
                        throw th2;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
            }
        }
    }

    static {
        try {
            f4335b = new SimpleDateFormat("MM-dd HH:mm:ss");
        } catch (Throwable th) {
            X.a(th.getCause());
        }
    }

    public static synchronized void c(String str, String str2, String str3) {
        if (m && f4336c) {
            try {
                if (n) {
                    o.execute(new Z(str, str2, str3));
                } else {
                    o.execute(new aa(str, str2, str3));
                }
            } catch (Exception e2) {
                X.a(e2);
            }
        }
    }

    private static String d() {
        com.tencent.bugly.crashreport.b bVar;
        try {
            com.tencent.bugly.crashreport.common.info.a aVarM = com.tencent.bugly.crashreport.common.info.a.m();
            if (aVarM == null || (bVar = aVarM.pa) == null) {
                return null;
            }
            return bVar.getLogFromNative();
        } catch (Throwable th) {
            if (X.b(th)) {
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }

    private static synchronized void e(String str, String str2, String str3) {
        String strA = a(str, str2, str3, Process.myTid());
        synchronized (q) {
            try {
                f4339f.append(strA);
                if (f4339f.length() >= f4337d) {
                    StringBuilder sb = f4339f;
                    f4339f = sb.delete(0, sb.indexOf("\u0001\r\n") + 1);
                }
            } finally {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean f(String str, String str2, String str3) {
        com.tencent.bugly.crashreport.b bVar;
        try {
            com.tencent.bugly.crashreport.common.info.a aVarM = com.tencent.bugly.crashreport.common.info.a.m();
            if (aVarM == null || (bVar = aVarM.pa) == null) {
                return false;
            }
            return bVar.appendLogToNative(str, str2, str3);
        } catch (Throwable th) {
            if (X.b(th)) {
                return false;
            }
            th.printStackTrace();
            return false;
        }
    }

    private static synchronized void g(String str, String str2, String str3) {
        String strA = a(str, str2, str3, Process.myTid());
        synchronized (q) {
            try {
                f4339f.append(strA);
                if (f4339f.length() <= f4337d) {
                    return;
                }
                if (f4340g) {
                    return;
                }
                f4340g = true;
                a aVar = f4341h;
                if (aVar == null) {
                    f4341h = new a(f4345l);
                } else if (aVar.f4346b == null || f4341h.f4346b.length() + ((long) f4339f.length()) > f4341h.f4349e) {
                    f4341h.a();
                }
                if (f4341h.a(f4339f.toString())) {
                    f4339f.setLength(0);
                    f4340g = false;
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static synchronized void a(Context context) {
        if (m || context == null || !f4336c) {
            return;
        }
        try {
            o = Executors.newSingleThreadExecutor();
            f4339f = new StringBuilder(0);
            f4338e = new StringBuilder(0);
            f4344k = context;
            f4342i = com.tencent.bugly.crashreport.common.info.a.a(context).f4099h;
            f4343j = "";
            StringBuilder sb = new StringBuilder();
            sb.append(f4344k.getFilesDir().getPath());
            sb.append(h.a.a.a.w.DEFAULT_PATH_SEPARATOR);
            sb.append("buglylog_");
            sb.append(f4342i);
            sb.append("_");
            sb.append(f4343j);
            sb.append(".txt");
            f4345l = sb.toString();
            p = Process.myPid();
        } catch (Throwable unused) {
        }
        m = true;
    }

    public static byte[] b() {
        return a ? a() : c();
    }

    public static byte[] c() {
        if (!f4336c) {
            return null;
        }
        if (n) {
            X.c("[LogUtil] Get user log from native.", new Object[0]);
            String strD = d();
            if (strD != null) {
                X.c("[LogUtil] Got user log from native: %d bytes", Integer.valueOf(strD.length()));
                return ca.a((File) null, strD, "BuglyNativeLog.txt");
            }
        }
        StringBuilder sb = new StringBuilder();
        synchronized (q) {
            a aVar = f4341h;
            if (aVar != null && aVar.a && f4341h.f4346b != null && f4341h.f4346b.length() > 0) {
                sb.append(ca.a(f4341h.f4346b, 30720, true));
            }
            StringBuilder sb2 = f4339f;
            if (sb2 != null && sb2.length() > 0) {
                sb.append(f4339f.toString());
            }
        }
        return ca.a((File) null, sb.toString(), "BuglyLog.txt");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void d(String str, String str2, String str3) {
        if (a) {
            e(str, str2, str3);
        } else {
            g(str, str2, str3);
        }
    }

    public static void a(int i2) {
        synchronized (q) {
            f4337d = i2;
            if (i2 < 0) {
                f4337d = 0;
            } else if (i2 > 30720) {
                f4337d = 30720;
            }
        }
    }

    public static void a(String str, String str2, Throwable th) {
        if (th == null) {
            return;
        }
        String message = th.getMessage();
        if (message == null) {
            message = "";
        }
        c(str, str2, message + '\n' + ca.a(th));
    }

    private static String a(String str, String str2, String str3, long j2) {
        String string;
        f4338e.setLength(0);
        if (str3.length() > 30720) {
            str3 = str3.substring(str3.length() - 30720, str3.length() - 1);
        }
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = f4335b;
        if (simpleDateFormat != null) {
            string = simpleDateFormat.format(date);
        } else {
            string = date.toString();
        }
        StringBuilder sb = f4338e;
        sb.append(string);
        sb.append(" ");
        sb.append(p);
        sb.append(" ");
        sb.append(j2);
        c.a.a.a.a.z(sb, " ", str, " ", str2);
        sb.append(": ");
        sb.append(str3);
        sb.append("\u0001\r\n");
        return f4338e.toString();
    }

    public static byte[] a() {
        if (f4336c) {
            return ca.a((File) null, f4339f.toString(), "BuglyLog.txt");
        }
        return null;
    }
}

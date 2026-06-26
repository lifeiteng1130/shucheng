package com.tencent.bugly.crashreport.crash;

import android.content.Context;
import android.os.Process;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.proguard.X;
import com.tencent.bugly.proguard.ba;
import com.tencent.bugly.proguard.ca;
import java.lang.Thread;
import java.util.HashMap;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes.dex */
public class l implements Thread.UncaughtExceptionHandler {
    private static String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Object f4233b = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f4234c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final e f4235d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.tencent.bugly.crashreport.common.strategy.c f4236e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.tencent.bugly.crashreport.common.info.a f4237f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Thread.UncaughtExceptionHandler f4238g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Thread.UncaughtExceptionHandler f4239h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f4240i = false;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f4241j;

    public l(Context context, e eVar, com.tencent.bugly.crashreport.common.strategy.c cVar, com.tencent.bugly.crashreport.common.info.a aVar) {
        this.f4234c = context;
        this.f4235d = eVar;
        this.f4236e = cVar;
        this.f4237f = aVar;
    }

    public synchronized void a() {
        if (this.f4241j >= 10) {
            X.c("java crash handler over %d, no need set.", 10);
            return;
        }
        this.f4240i = true;
        Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        if (defaultUncaughtExceptionHandler != null) {
            if (l.class.getName().equals(defaultUncaughtExceptionHandler.getClass().getName())) {
                return;
            }
            if ("com.android.internal.os.RuntimeInit$UncaughtHandler".equals(defaultUncaughtExceptionHandler.getClass().getName())) {
                X.c("backup system java handler: %s", defaultUncaughtExceptionHandler.toString());
                this.f4239h = defaultUncaughtExceptionHandler;
                this.f4238g = defaultUncaughtExceptionHandler;
            } else {
                X.c("backup java handler: %s", defaultUncaughtExceptionHandler.toString());
                this.f4238g = defaultUncaughtExceptionHandler;
            }
        }
        Thread.setDefaultUncaughtExceptionHandler(this);
        this.f4241j++;
        X.c("registered java monitor: %s", toString());
    }

    public synchronized void b() {
        this.f4240i = false;
        X.c("close java monitor!", new Object[0]);
        if (Thread.getDefaultUncaughtExceptionHandler().getClass().getName().contains("bugly")) {
            X.c("Java monitor to unregister: %s", toString());
            Thread.setDefaultUncaughtExceptionHandler(this.f4238g);
            this.f4241j--;
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        synchronized (f4233b) {
            b(thread, th, true, null, null);
        }
    }

    public void b(Thread thread, Throwable th, boolean z, String str, byte[] bArr) {
        if (z) {
            X.b("Java Crash Happen cause by %s(%d)", thread.getName(), Long.valueOf(thread.getId()));
            if (a(thread)) {
                X.c("this class has handled this exception", new Object[0]);
                if (this.f4239h != null) {
                    X.c("call system handler", new Object[0]);
                    this.f4239h.uncaughtException(thread, th);
                } else {
                    a(thread, th);
                }
            }
        } else {
            X.b("Java Catch Happen", new Object[0]);
        }
        try {
            if (!this.f4240i) {
                X.a("Java crash handler is disable. Just return.", new Object[0]);
                if (z) {
                    Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f4238g;
                    if (uncaughtExceptionHandler != null && a(uncaughtExceptionHandler)) {
                        X.b("sys default last handle start!", new Object[0]);
                        this.f4238g.uncaughtException(thread, th);
                        X.b("sys default last handle end!", new Object[0]);
                        return;
                    } else if (this.f4239h != null) {
                        X.b("system handle start!", new Object[0]);
                        this.f4239h.uncaughtException(thread, th);
                        X.b("system handle end!", new Object[0]);
                        return;
                    } else {
                        X.b("crashreport last handle start!", new Object[0]);
                        a(thread, th);
                        X.b("crashreport last handle end!", new Object[0]);
                        return;
                    }
                }
                return;
            }
            if (!this.f4236e.d()) {
                X.e("no remote but still store!", new Object[0]);
            }
            if (!this.f4236e.c().f4112f && this.f4236e.d()) {
                X.b("crash report was closed by remote , will not upload to Bugly , print local for helpful!", new Object[0]);
                e.a(z ? "JAVA_CRASH" : "JAVA_CATCH", ca.a(), this.f4237f.f4099h, thread.getName(), ca.b(th), null);
                if (z) {
                    Thread.UncaughtExceptionHandler uncaughtExceptionHandler2 = this.f4238g;
                    if (uncaughtExceptionHandler2 != null && a(uncaughtExceptionHandler2)) {
                        X.b("sys default last handle start!", new Object[0]);
                        this.f4238g.uncaughtException(thread, th);
                        X.b("sys default last handle end!", new Object[0]);
                        return;
                    } else if (this.f4239h != null) {
                        X.b("system handle start!", new Object[0]);
                        this.f4239h.uncaughtException(thread, th);
                        X.b("system handle end!", new Object[0]);
                        return;
                    } else {
                        X.b("crashreport last handle start!", new Object[0]);
                        a(thread, th);
                        X.b("crashreport last handle end!", new Object[0]);
                        return;
                    }
                }
                return;
            }
            CrashDetailBean crashDetailBeanA = a(thread, th, z, str, bArr);
            if (crashDetailBeanA == null) {
                X.b("pkg crash datas fail!", new Object[0]);
                if (z) {
                    Thread.UncaughtExceptionHandler uncaughtExceptionHandler3 = this.f4238g;
                    if (uncaughtExceptionHandler3 != null && a(uncaughtExceptionHandler3)) {
                        X.b("sys default last handle start!", new Object[0]);
                        this.f4238g.uncaughtException(thread, th);
                        X.b("sys default last handle end!", new Object[0]);
                        return;
                    } else if (this.f4239h != null) {
                        X.b("system handle start!", new Object[0]);
                        this.f4239h.uncaughtException(thread, th);
                        X.b("system handle end!", new Object[0]);
                        return;
                    } else {
                        X.b("crashreport last handle start!", new Object[0]);
                        a(thread, th);
                        X.b("crashreport last handle end!", new Object[0]);
                        return;
                    }
                }
                return;
            }
            e.a(z ? "JAVA_CRASH" : "JAVA_CATCH", ca.a(), this.f4237f.f4099h, thread.getName(), ca.b(th), crashDetailBeanA);
            if (!this.f4235d.c(crashDetailBeanA)) {
                this.f4235d.a(crashDetailBeanA, 3000L, z);
            }
            if (z) {
                this.f4235d.e(crashDetailBeanA);
            }
            if (z) {
                Thread.UncaughtExceptionHandler uncaughtExceptionHandler4 = this.f4238g;
                if (uncaughtExceptionHandler4 != null && a(uncaughtExceptionHandler4)) {
                    X.b("sys default last handle start!", new Object[0]);
                    this.f4238g.uncaughtException(thread, th);
                    X.b("sys default last handle end!", new Object[0]);
                } else if (this.f4239h != null) {
                    X.b("system handle start!", new Object[0]);
                    this.f4239h.uncaughtException(thread, th);
                    X.b("system handle end!", new Object[0]);
                } else {
                    X.b("crashreport last handle start!", new Object[0]);
                    a(thread, th);
                    X.b("crashreport last handle end!", new Object[0]);
                }
            }
        } catch (Throwable th2) {
            try {
                if (!X.b(th2)) {
                    th2.printStackTrace();
                }
                if (z) {
                    Thread.UncaughtExceptionHandler uncaughtExceptionHandler5 = this.f4238g;
                    if (uncaughtExceptionHandler5 != null && a(uncaughtExceptionHandler5)) {
                        X.b("sys default last handle start!", new Object[0]);
                        this.f4238g.uncaughtException(thread, th);
                        X.b("sys default last handle end!", new Object[0]);
                    } else if (this.f4239h != null) {
                        X.b("system handle start!", new Object[0]);
                        this.f4239h.uncaughtException(thread, th);
                        X.b("system handle end!", new Object[0]);
                    } else {
                        X.b("crashreport last handle start!", new Object[0]);
                        a(thread, th);
                        X.b("crashreport last handle end!", new Object[0]);
                    }
                }
            } catch (Throwable th3) {
                if (z) {
                    Thread.UncaughtExceptionHandler uncaughtExceptionHandler6 = this.f4238g;
                    if (uncaughtExceptionHandler6 != null && a(uncaughtExceptionHandler6)) {
                        X.b("sys default last handle start!", new Object[0]);
                        this.f4238g.uncaughtException(thread, th);
                        X.b("sys default last handle end!", new Object[0]);
                    } else if (this.f4239h != null) {
                        X.b("system handle start!", new Object[0]);
                        this.f4239h.uncaughtException(thread, th);
                        X.b("system handle end!", new Object[0]);
                    } else {
                        X.b("crashreport last handle start!", new Object[0]);
                        a(thread, th);
                        X.b("crashreport last handle end!", new Object[0]);
                    }
                }
                throw th3;
            }
        }
    }

    public void a(Thread thread, Throwable th) {
        X.b("current process die", new Object[0]);
        Process.killProcess(Process.myPid());
        System.exit(1);
    }

    public CrashDetailBean a(Thread thread, Throwable th, boolean z, String str, byte[] bArr) {
        String strB;
        if (th == null) {
            X.e("We can do nothing with a null throwable.", new Object[0]);
            return null;
        }
        boolean zI = h.g().i();
        String str2 = (zI && z) ? " This Crash Caused By ANR , PLS To Fix ANR , This Trace May Be Not Useful![Bugly]" : "";
        if (zI && z) {
            X.b("This Crash Caused By ANR , PLS To Fix ANR , This Trace May Be Not Useful!", new Object[0]);
        }
        CrashDetailBean crashDetailBean = new CrashDetailBean();
        crashDetailBean.C = com.tencent.bugly.crashreport.common.info.b.h();
        crashDetailBean.D = com.tencent.bugly.crashreport.common.info.b.j();
        crashDetailBean.E = com.tencent.bugly.crashreport.common.info.b.g();
        crashDetailBean.F = this.f4237f.v();
        crashDetailBean.G = this.f4237f.w();
        crashDetailBean.H = this.f4237f.x();
        crashDetailBean.w = ca.a(this.f4234c, h.f4187e, h.f4190h);
        byte[] bArrB = ba.b();
        crashDetailBean.y = bArrB;
        Object[] objArr = new Object[1];
        objArr[0] = Integer.valueOf(bArrB == null ? 0 : bArrB.length);
        X.c("user log size:%d", objArr);
        crashDetailBean.f4130b = z ? 0 : 2;
        crashDetailBean.f4133e = this.f4237f.l();
        com.tencent.bugly.crashreport.common.info.a aVar = this.f4237f;
        crashDetailBean.f4134f = aVar.E;
        crashDetailBean.f4135g = aVar.i();
        crashDetailBean.m = this.f4237f.y();
        String name = th.getClass().getName();
        String strA = a(th, 1000);
        if (strA == null) {
            strA = "";
        }
        Object[] objArr2 = new Object[2];
        objArr2[0] = Integer.valueOf(th.getStackTrace().length);
        objArr2[1] = Boolean.valueOf(th.getCause() != null);
        X.b("stack frame :%d, has cause %b", objArr2);
        String string = th.getStackTrace().length > 0 ? th.getStackTrace()[0].toString() : "";
        Throwable cause = th;
        while (cause != null && cause.getCause() != null) {
            cause = cause.getCause();
        }
        if (cause != null && cause != th) {
            crashDetailBean.n = cause.getClass().getName();
            String strA2 = a(cause, 1000);
            crashDetailBean.o = strA2;
            if (strA2 == null) {
                crashDetailBean.o = "";
            }
            if (cause.getStackTrace().length > 0) {
                crashDetailBean.p = cause.getStackTrace()[0].toString();
            }
            StringBuilder sb = new StringBuilder();
            sb.append(name);
            sb.append(":");
            sb.append(strA);
            sb.append("\n");
            sb.append(string);
            sb.append("\n......");
            sb.append("\nCaused by:\n");
            sb.append(crashDetailBean.n);
            sb.append(":");
            sb.append(crashDetailBean.o);
            sb.append("\n");
            strB = b(cause, h.f4188f);
            sb.append(strB);
            crashDetailBean.q = sb.toString();
        } else {
            crashDetailBean.n = name;
            String strK = c.a.a.a.a.k(strA, "", str2);
            crashDetailBean.o = strK;
            if (strK == null) {
                crashDetailBean.o = "";
            }
            crashDetailBean.p = string;
            strB = b(th, h.f4188f);
            crashDetailBean.q = strB;
        }
        crashDetailBean.r = System.currentTimeMillis();
        crashDetailBean.u = ca.c(crashDetailBean.q.getBytes());
        try {
            crashDetailBean.z = ca.a(h.f4188f, false);
            crashDetailBean.A = this.f4237f.f4099h;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(thread.getName());
            sb2.append("(");
            sb2.append(thread.getId());
            sb2.append(")");
            String string2 = sb2.toString();
            crashDetailBean.B = string2;
            crashDetailBean.z.put(string2, strB);
            crashDetailBean.I = this.f4237f.r();
            crashDetailBean.f4136h = this.f4237f.p();
            crashDetailBean.f4137i = this.f4237f.o();
            com.tencent.bugly.crashreport.common.info.a aVar2 = this.f4237f;
            crashDetailBean.N = aVar2.f4095d;
            crashDetailBean.O = aVar2.C();
            if (z) {
                this.f4235d.d(crashDetailBean);
            } else {
                boolean z2 = str != null && str.length() > 0;
                boolean z3 = bArr != null && bArr.length > 0;
                if (z2) {
                    HashMap map = new HashMap(1);
                    crashDetailBean.P = map;
                    map.put("UserData", str);
                }
                if (z3) {
                    crashDetailBean.V = bArr;
                }
            }
            crashDetailBean.R = this.f4237f.A();
            crashDetailBean.S = this.f4237f.t();
            crashDetailBean.T = this.f4237f.h();
            crashDetailBean.U = this.f4237f.g();
        } catch (Throwable th2) {
            X.b("handle crash error %s", th2.toString());
        }
        return crashDetailBean;
    }

    private boolean a(Thread thread) {
        synchronized (f4233b) {
            if (a != null && thread.getName().equals(a)) {
                return true;
            }
            a = thread.getName();
            return false;
        }
    }

    private boolean a(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        if (uncaughtExceptionHandler == null) {
            return true;
        }
        String name = uncaughtExceptionHandler.getClass().getName();
        for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
            String className = stackTraceElement.getClassName();
            String methodName = stackTraceElement.getMethodName();
            if (name.equals(className) && "uncaughtException".equals(methodName)) {
                return false;
            }
        }
        return true;
    }

    public static String b(Throwable th, int i2) {
        if (th == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        try {
            if (th.getStackTrace() != null) {
                for (StackTraceElement stackTraceElement : th.getStackTrace()) {
                    if (i2 > 0 && sb.length() >= i2) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("\n[Stack over limit size :");
                        sb2.append(i2);
                        sb2.append(" , has been cutted !]");
                        sb.append(sb2.toString());
                        return sb.toString();
                    }
                    sb.append(stackTraceElement.toString());
                    sb.append("\n");
                }
            }
        } catch (Throwable th2) {
            X.b("gen stack error %s", th2.toString());
        }
        return sb.toString();
    }

    public synchronized void a(StrategyBean strategyBean) {
        if (strategyBean != null) {
            boolean z = strategyBean.f4112f;
            if (z != this.f4240i) {
                X.c("java changed to %b", Boolean.valueOf(z));
                if (strategyBean.f4112f) {
                    a();
                } else {
                    b();
                }
            }
        }
    }

    public static String a(Throwable th, int i2) {
        if (th.getMessage() == null) {
            return "";
        }
        if (i2 >= 0 && th.getMessage().length() > i2) {
            StringBuilder sb = new StringBuilder();
            sb.append(th.getMessage().substring(0, i2));
            sb.append("\n[Message over limit size:");
            return c.a.a.a.a.o(sb, i2, ", has been cutted!]");
        }
        return th.getMessage();
    }
}

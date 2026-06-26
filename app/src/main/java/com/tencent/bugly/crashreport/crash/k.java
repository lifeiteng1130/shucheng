package com.tencent.bugly.crashreport.crash;

import android.content.Context;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.proguard.W;
import com.tencent.bugly.proguard.X;
import com.tencent.bugly.proguard.ba;
import com.tencent.bugly.proguard.ca;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes.dex */
public class k {
    private static k a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.tencent.bugly.crashreport.common.strategy.c f4229b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.tencent.bugly.crashreport.common.info.a f4230c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private e f4231d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Context f4232e;

    private k(Context context) {
        h hVarG = h.g();
        if (hVarG == null) {
            return;
        }
        this.f4229b = com.tencent.bugly.crashreport.common.strategy.c.b();
        this.f4230c = com.tencent.bugly.crashreport.common.info.a.a(context);
        this.f4231d = hVarG.r;
        this.f4232e = context;
        W.c().a(new i(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        X.a("[ExtraCrashManager] Trying to notify Bugly agents.", new Object[0]);
        try {
            Class<?> cls = Class.forName("com.tencent.bugly.proguard.o");
            this.f4230c.getClass();
            ca.a(cls, "sdkPackageName", "com.tencent.bugly", (Object) null);
            X.a("[ExtraCrashManager] Bugly game agent has been notified.", new Object[0]);
        } catch (Throwable unused) {
            X.c("[ExtraCrashManager] no game agent", new Object[0]);
        }
    }

    private CrashDetailBean c(Thread thread, int i2, String str, String str2, String str3, Map<String, String> map) {
        CrashDetailBean crashDetailBean = new CrashDetailBean();
        crashDetailBean.C = com.tencent.bugly.crashreport.common.info.b.h();
        crashDetailBean.D = com.tencent.bugly.crashreport.common.info.b.j();
        crashDetailBean.E = com.tencent.bugly.crashreport.common.info.b.g();
        crashDetailBean.F = this.f4230c.v();
        crashDetailBean.G = this.f4230c.w();
        crashDetailBean.H = this.f4230c.x();
        crashDetailBean.w = ca.a(this.f4232e, h.f4187e, h.f4190h);
        crashDetailBean.f4130b = i2;
        crashDetailBean.f4133e = this.f4230c.l();
        com.tencent.bugly.crashreport.common.info.a aVar = this.f4230c;
        crashDetailBean.f4134f = aVar.E;
        crashDetailBean.f4135g = aVar.i();
        crashDetailBean.m = this.f4230c.y();
        String str4 = "";
        crashDetailBean.n = c.a.a.a.a.i("", str);
        crashDetailBean.o = c.a.a.a.a.i("", str2);
        if (str3 != null) {
            String[] strArrSplit = str3.split("\n");
            if (strArrSplit.length > 0) {
                str4 = strArrSplit[0];
            }
        } else {
            str3 = "";
        }
        crashDetailBean.p = str4;
        crashDetailBean.q = str3;
        crashDetailBean.r = System.currentTimeMillis();
        crashDetailBean.u = ca.c(crashDetailBean.q.getBytes());
        crashDetailBean.z = ca.a(h.f4188f, false);
        crashDetailBean.A = this.f4230c.f4099h;
        crashDetailBean.B = thread.getName() + "(" + thread.getId() + ")";
        crashDetailBean.I = this.f4230c.r();
        crashDetailBean.f4136h = this.f4230c.p();
        com.tencent.bugly.crashreport.common.info.a aVar2 = this.f4230c;
        crashDetailBean.N = aVar2.f4095d;
        crashDetailBean.O = aVar2.C();
        if (!h.g().f()) {
            this.f4231d.d(crashDetailBean);
        }
        crashDetailBean.R = this.f4230c.A();
        crashDetailBean.S = this.f4230c.t();
        crashDetailBean.T = this.f4230c.h();
        crashDetailBean.U = this.f4230c.g();
        crashDetailBean.y = ba.b();
        if (crashDetailBean.P == null) {
            crashDetailBean.P = new LinkedHashMap();
        }
        if (map != null) {
            crashDetailBean.P.putAll(map);
        }
        return crashDetailBean;
    }

    public static k a(Context context) {
        if (a == null) {
            a = new k(context);
        }
        return a;
    }

    public static void a(Thread thread, int i2, String str, String str2, String str3, Map<String, String> map) {
        W.c().a(new j(thread, i2, str, str2, str3, map));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Thread thread, int i2, String str, String str2, String str3, Map<String, String> map) {
        String str4;
        Thread threadCurrentThread = thread == null ? Thread.currentThread() : thread;
        if (i2 == 4) {
            str4 = "Unity";
        } else if (i2 == 5 || i2 == 6) {
            str4 = "Cocos";
        } else {
            if (i2 != 8) {
                X.e("[ExtraCrashManager] Unknown extra crash type: %d", Integer.valueOf(i2));
                return;
            }
            str4 = "H5";
        }
        String str5 = str4;
        X.b("[ExtraCrashManager] %s Crash Happen", str5);
        try {
            if (!this.f4229b.d()) {
                X.e("[ExtraCrashManager] There is no remote strategy, but still store it.", new Object[0]);
            }
            StrategyBean strategyBeanC = this.f4229b.c();
            if (!strategyBeanC.f4112f && this.f4229b.d()) {
                X.b("[ExtraCrashManager] Crash report was closed by remote , will not upload to Bugly , print local for helpful!", new Object[0]);
                e.a(str5, ca.a(), this.f4230c.f4099h, threadCurrentThread.getName(), str + "\n" + str2 + "\n" + str3, null);
                X.b("[ExtraCrashManager] Successfully handled.", new Object[0]);
                return;
            }
            if (i2 != 5 && i2 != 6) {
                if (i2 == 8 && !strategyBeanC.f4118l) {
                    X.b("[ExtraCrashManager] %s report is disabled.", str5);
                    X.b("[ExtraCrashManager] Successfully handled.", new Object[0]);
                    return;
                }
            } else if (!strategyBeanC.f4117k) {
                X.b("[ExtraCrashManager] %s report is disabled.", str5);
                X.b("[ExtraCrashManager] Successfully handled.", new Object[0]);
                return;
            }
            CrashDetailBean crashDetailBeanC = c(threadCurrentThread, i2 == 8 ? 5 : i2, str, str2, str3, map);
            if (crashDetailBeanC == null) {
                X.b("[ExtraCrashManager] Failed to package crash data.", new Object[0]);
                X.b("[ExtraCrashManager] Successfully handled.", new Object[0]);
                return;
            }
            e.a(str5, ca.a(), this.f4230c.f4099h, threadCurrentThread.getName(), str + "\n" + str2 + "\n" + str3, crashDetailBeanC);
            if (!this.f4231d.c(crashDetailBeanC)) {
                this.f4231d.a(crashDetailBeanC, 3000L, false);
            }
            X.b("[ExtraCrashManager] Successfully handled.", new Object[0]);
        } catch (Throwable th) {
            try {
                if (!X.b(th)) {
                    th.printStackTrace();
                }
                X.b("[ExtraCrashManager] Successfully handled.", new Object[0]);
            } catch (Throwable th2) {
                X.b("[ExtraCrashManager] Successfully handled.", new Object[0]);
                throw th2;
            }
        }
    }
}

package com.tencent.bugly.crashreport.crash;

import android.content.Context;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.bugly.crashreport.common.info.AppInfo;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler;
import com.tencent.bugly.proguard.J;
import com.tencent.bugly.proguard.L;
import com.tencent.bugly.proguard.T;
import com.tencent.bugly.proguard.W;
import com.tencent.bugly.proguard.ca;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes.dex */
public class h {
    public static int a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f4184b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static int f4185c = 2;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f4186d = true;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static int f4187e = 20480;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static int f4188f = 20480;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static long f4189g = 604800000;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static String f4190h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static boolean f4191i = false;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static String f4192j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static int f4193k = 5000;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static boolean f4194l = true;
    public static boolean m = false;
    public static String n;
    public static String o;
    private static h p;
    private int A = 31;
    private boolean B = false;
    private final Context q;
    public final e r;
    private final l s;
    private final NativeCrashHandler t;
    public final com.tencent.bugly.crashreport.common.strategy.c u;
    public final W v;
    private final com.tencent.bugly.crashreport.crash.anr.h w;
    public BuglyStrategy.a x;
    public m y;
    private Boolean z;

    public h(int i2, Context context, W w, boolean z, BuglyStrategy.a aVar, m mVar, String str) {
        a = i2;
        Context contextA = ca.a(context);
        this.q = contextA;
        com.tencent.bugly.crashreport.common.strategy.c cVarB = com.tencent.bugly.crashreport.common.strategy.c.b();
        this.u = cVarB;
        this.v = w;
        this.x = aVar;
        this.y = mVar;
        T tA = T.a();
        J jA = J.a();
        e eVar = new e(i2, contextA, tA, jA, cVarB, aVar, mVar);
        this.r = eVar;
        com.tencent.bugly.crashreport.common.info.a aVarA = com.tencent.bugly.crashreport.common.info.a.a(contextA);
        this.s = new l(contextA, eVar, cVarB, aVarA);
        NativeCrashHandler nativeCrashHandler = NativeCrashHandler.getInstance(contextA, aVarA, eVar, cVarB, w, z, str);
        this.t = nativeCrashHandler;
        aVarA.pa = nativeCrashHandler;
        this.w = com.tencent.bugly.crashreport.crash.anr.h.a(contextA, cVarB, aVarA, w, jA, eVar, aVar);
    }

    public static synchronized h g() {
        return p;
    }

    public void c() {
        this.w.b(false);
    }

    public void d() {
        this.s.b();
    }

    public void e() {
        this.t.setUserOpened(false);
    }

    public boolean f() {
        return this.B;
    }

    public boolean h() {
        Boolean bool = this.z;
        if (bool != null) {
            return bool.booleanValue();
        }
        String str = com.tencent.bugly.crashreport.common.info.a.m().f4099h;
        List<L> listA = J.a().a(1);
        ArrayList arrayList = new ArrayList();
        if (listA == null || listA.size() <= 0) {
            this.z = Boolean.FALSE;
            return false;
        }
        for (L l2 : listA) {
            if (str.equals(l2.f4295c)) {
                this.z = Boolean.TRUE;
                arrayList.add(l2);
            }
        }
        if (arrayList.size() > 0) {
            J.a().a(arrayList);
        }
        return true;
    }

    public boolean i() {
        return this.w.b();
    }

    public boolean j() {
        return (this.A & 8) > 0;
    }

    public boolean k() {
        return (this.A & 16) > 0;
    }

    public boolean l() {
        return (this.A & 2) > 0;
    }

    public boolean m() {
        return (this.A & 1) > 0;
    }

    public boolean n() {
        return (this.A & 4) > 0;
    }

    public synchronized void o() {
        r();
        s();
        p();
    }

    public void p() {
        this.w.b(true);
    }

    public void q() {
        this.t.enableCatchAnrTrace();
    }

    public void r() {
        this.s.a();
    }

    public void s() {
        this.t.setUserOpened(true);
    }

    public synchronized void t() {
        this.w.g();
    }

    public void u() {
        this.t.checkUploadRecordCrash();
    }

    public static synchronized h a(int i2, Context context, boolean z, BuglyStrategy.a aVar, m mVar, String str) {
        if (p == null) {
            p = new h(i2, context, W.c(), z, aVar, mVar, str);
        }
        return p;
    }

    public synchronized void b() {
        d();
        e();
        c();
    }

    public void a(StrategyBean strategyBean) {
        this.s.a(strategyBean);
        this.t.onStrategyChanged(strategyBean);
        this.w.a(strategyBean);
        a(3000L);
    }

    public synchronized void a(boolean z, boolean z2, boolean z3) {
        this.t.testNativeCrash(z, z2, z3);
    }

    public void a(Thread thread, Throwable th, boolean z, String str, byte[] bArr, boolean z2) {
        this.v.a(new f(this, z, thread, th, str, bArr, z2));
    }

    public void a(CrashDetailBean crashDetailBean) {
        this.r.f(crashDetailBean);
    }

    public void a(long j2) {
        W.c().a(new g(this), j2);
    }

    public void a() {
        if (com.tencent.bugly.crashreport.common.info.a.m().f4099h.equals(AppInfo.d(this.q))) {
            this.t.removeEmptyNativeRecordFiles();
        }
    }

    public void a(int i2) {
        this.A = i2;
    }

    public void a(boolean z) {
        this.B = z;
    }
}

package com.tencent.bugly.crashreport.common.strategy;

import android.content.Context;
import com.tencent.bugly.crashreport.biz.f;
import com.tencent.bugly.proguard.J;
import com.tencent.bugly.proguard.L;
import com.tencent.bugly.proguard.W;
import com.tencent.bugly.proguard.X;
import com.tencent.bugly.proguard.ca;
import com.tencent.bugly.proguard.ra;
import com.tencent.bugly.proguard.sa;
import com.umeng.commonsdk.statistics.SdkVersion;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes.dex */
public class c {
    public static int a = 1000;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static c f4119b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static String f4120c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List<com.tencent.bugly.a> f4121d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final W f4122e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final StrategyBean f4123f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private StrategyBean f4124g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Context f4125h;

    public c(Context context, List<com.tencent.bugly.a> list) {
        this.f4125h = context;
        a(context);
        this.f4123f = new StrategyBean();
        this.f4121d = list;
        this.f4122e = W.c();
    }

    public StrategyBean c() {
        StrategyBean strategyBean = this.f4124g;
        if (strategyBean != null) {
            if (!ca.c(strategyBean.q)) {
                this.f4124g.q = StrategyBean.a;
            }
            if (!ca.c(this.f4124g.r)) {
                this.f4124g.r = StrategyBean.f4108b;
            }
            return this.f4124g;
        }
        if (!ca.b(f4120c) && ca.c(f4120c)) {
            StrategyBean strategyBean2 = this.f4123f;
            String str = f4120c;
            strategyBean2.q = str;
            strategyBean2.r = str;
        }
        return this.f4123f;
    }

    public synchronized boolean d() {
        return this.f4124g != null;
    }

    public StrategyBean e() {
        byte[] bArr;
        List<L> listA = J.a().a(2);
        if (listA == null || listA.size() <= 0 || (bArr = listA.get(0).f4299g) == null) {
            return null;
        }
        return (StrategyBean) ca.a(bArr, StrategyBean.CREATOR);
    }

    public static synchronized c b() {
        return f4119b;
    }

    public static synchronized c a(Context context, List<com.tencent.bugly.a> list) {
        if (f4119b == null) {
            f4119b = new c(context, list);
        }
        return f4119b;
    }

    public void a(long j2) {
        this.f4122e.a(new b(this), j2);
    }

    public void a(StrategyBean strategyBean, boolean z) {
        X.a("[Strategy] Notify %s", f.class.getName());
        f.a(strategyBean, z);
        for (com.tencent.bugly.a aVar : this.f4121d) {
            try {
                X.a("[Strategy] Notify %s", aVar.getClass().getName());
                aVar.onServerStrategyChanged(strategyBean);
            } catch (Throwable th) {
                if (!X.b(th)) {
                    th.printStackTrace();
                }
            }
        }
    }

    public static void a(String str) {
        if (!ca.b(str) && ca.c(str)) {
            f4120c = str;
        } else {
            X.e("URL user set is invalid.", new Object[0]);
        }
    }

    public void a(sa saVar) {
        if (saVar == null) {
            return;
        }
        StrategyBean strategyBean = this.f4124g;
        if (strategyBean == null || saVar.f4447k != strategyBean.o) {
            StrategyBean strategyBean2 = new StrategyBean();
            strategyBean2.f4112f = saVar.f4440d;
            strategyBean2.f4114h = saVar.f4442f;
            strategyBean2.f4113g = saVar.f4441e;
            if (ca.b(f4120c) || !ca.c(f4120c)) {
                if (ca.c(saVar.f4443g)) {
                    X.a("[Strategy] Upload url changes to %s", saVar.f4443g);
                    strategyBean2.q = saVar.f4443g;
                }
                if (ca.c(saVar.f4444h)) {
                    X.a("[Strategy] Exception upload url changes to %s", saVar.f4444h);
                    strategyBean2.r = saVar.f4444h;
                }
            }
            ra raVar = saVar.f4445i;
            if (raVar != null && !ca.b(raVar.a)) {
                strategyBean2.s = saVar.f4445i.a;
            }
            long j2 = saVar.f4447k;
            if (j2 != 0) {
                strategyBean2.o = j2;
            }
            Map<String, String> map = saVar.f4446j;
            if (map != null && map.size() > 0) {
                Map<String, String> map2 = saVar.f4446j;
                strategyBean2.t = map2;
                String str = map2.get("B11");
                if (str != null && str.equals(SdkVersion.MINI_VERSION)) {
                    strategyBean2.f4115i = true;
                } else {
                    strategyBean2.f4115i = false;
                }
                String str2 = saVar.f4446j.get("B3");
                if (str2 != null) {
                    strategyBean2.w = Long.valueOf(str2).longValue();
                }
                long j3 = saVar.o;
                strategyBean2.p = j3;
                strategyBean2.v = j3;
                String str3 = saVar.f4446j.get("B27");
                if (str3 != null && str3.length() > 0) {
                    try {
                        int i2 = Integer.parseInt(str3);
                        if (i2 > 0) {
                            strategyBean2.u = i2;
                        }
                    } catch (Exception e2) {
                        if (!X.b(e2)) {
                            e2.printStackTrace();
                        }
                    }
                }
                String str4 = saVar.f4446j.get("B25");
                if (str4 != null && str4.equals(SdkVersion.MINI_VERSION)) {
                    strategyBean2.f4117k = true;
                } else {
                    strategyBean2.f4117k = false;
                }
            }
            X.c("[Strategy] enableCrashReport:%b, enableQuery:%b, enableUserInfo:%b, enableAnr:%b, enableBlock:%b, enableSession:%b, enableSessionTimer:%b, sessionOverTime:%d, enableCocos:%b, strategyLastUpdateTime:%d", Boolean.valueOf(strategyBean2.f4112f), Boolean.valueOf(strategyBean2.f4114h), Boolean.valueOf(strategyBean2.f4113g), Boolean.valueOf(strategyBean2.f4115i), Boolean.valueOf(strategyBean2.f4116j), Boolean.valueOf(strategyBean2.m), Boolean.valueOf(strategyBean2.n), Long.valueOf(strategyBean2.p), Boolean.valueOf(strategyBean2.f4117k), Long.valueOf(strategyBean2.o));
            this.f4124g = strategyBean2;
            if (!ca.c(saVar.f4443g)) {
                X.a("[Strategy] download url is null", new Object[0]);
                this.f4124g.q = "";
            }
            if (!ca.c(saVar.f4444h)) {
                X.a("[Strategy] download crashurl is null", new Object[0]);
                this.f4124g.r = "";
            }
            J.a().b(2);
            L l2 = new L();
            l2.f4294b = 2;
            l2.a = strategyBean2.f4110d;
            l2.f4297e = strategyBean2.f4111e;
            l2.f4299g = ca.a(strategyBean2);
            J.a().c(l2);
            a(strategyBean2, true);
        }
    }

    private static void a(Context context) {
        if (com.tencent.bugly.crashreport.common.info.a.a(context) != null) {
            String str = com.tencent.bugly.crashreport.common.info.a.a(context).fa;
            if ("oversea".equals(str)) {
                StrategyBean.a = "https://astat.bugly.qcloud.com/rqd/async";
                StrategyBean.f4108b = "https://astat.bugly.qcloud.com/rqd/async";
            } else if ("na_https".equals(str)) {
                StrategyBean.a = "https://astat.bugly.cros.wr.pvp.net/:8180/rqd/async";
                StrategyBean.f4108b = "https://astat.bugly.cros.wr.pvp.net/:8180/rqd/async";
            }
        }
    }
}

package com.tencent.bugly.proguard;

import android.content.Context;
import com.tencent.bugly.crashreport.biz.UserInfoBean;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes.dex */
public class M {
    public static ta a(UserInfoBean userInfoBean, com.tencent.bugly.crashreport.common.info.a aVar) {
        if (userInfoBean == null) {
            return null;
        }
        ta taVar = new ta();
        taVar.f4449b = userInfoBean.f4062e;
        taVar.f4453f = userInfoBean.f4067j;
        taVar.f4452e = userInfoBean.f4060c;
        taVar.f4451d = userInfoBean.f4061d;
        taVar.f4456i = userInfoBean.o == 1;
        int i2 = userInfoBean.f4059b;
        if (i2 == 1) {
            taVar.f4450c = (byte) 1;
        } else if (i2 == 2) {
            taVar.f4450c = (byte) 4;
        } else if (i2 == 3) {
            taVar.f4450c = (byte) 2;
        } else if (i2 == 4) {
            taVar.f4450c = (byte) 3;
        } else {
            if (i2 < 10 || i2 >= 20) {
                X.b("unknown uinfo type %d ", Integer.valueOf(i2));
                return null;
            }
            taVar.f4450c = (byte) i2;
        }
        HashMap map = new HashMap();
        taVar.f4454g = map;
        if (userInfoBean.p >= 0) {
            StringBuilder sbR = c.a.a.a.a.r("");
            sbR.append(userInfoBean.p);
            map.put("C01", sbR.toString());
        }
        if (userInfoBean.q >= 0) {
            Map<String, String> map2 = taVar.f4454g;
            StringBuilder sbR2 = c.a.a.a.a.r("");
            sbR2.append(userInfoBean.q);
            map2.put("C02", sbR2.toString());
        }
        Map<String, String> map3 = userInfoBean.r;
        if (map3 != null && map3.size() > 0) {
            for (Map.Entry<String, String> entry : userInfoBean.r.entrySet()) {
                Map<String, String> map4 = taVar.f4454g;
                StringBuilder sbR3 = c.a.a.a.a.r("C03_");
                sbR3.append(entry.getKey());
                map4.put(sbR3.toString(), entry.getValue());
            }
        }
        Map<String, String> map5 = userInfoBean.s;
        if (map5 != null && map5.size() > 0) {
            for (Map.Entry<String, String> entry2 : userInfoBean.s.entrySet()) {
                Map<String, String> map6 = taVar.f4454g;
                StringBuilder sbR4 = c.a.a.a.a.r("C04_");
                sbR4.append(entry2.getKey());
                map6.put(sbR4.toString(), entry2.getValue());
            }
        }
        Map<String, String> map7 = taVar.f4454g;
        StringBuilder sbR5 = c.a.a.a.a.r("");
        sbR5.append(!userInfoBean.f4069l);
        map7.put("A36", sbR5.toString());
        Map<String, String> map8 = taVar.f4454g;
        StringBuilder sbR6 = c.a.a.a.a.r("");
        sbR6.append(userInfoBean.f4064g);
        map8.put("F02", sbR6.toString());
        Map<String, String> map9 = taVar.f4454g;
        StringBuilder sbR7 = c.a.a.a.a.r("");
        sbR7.append(userInfoBean.f4065h);
        map9.put("F03", sbR7.toString());
        Map<String, String> map10 = taVar.f4454g;
        StringBuilder sbR8 = c.a.a.a.a.r("");
        sbR8.append(userInfoBean.f4067j);
        map10.put("F04", sbR8.toString());
        Map<String, String> map11 = taVar.f4454g;
        StringBuilder sbR9 = c.a.a.a.a.r("");
        sbR9.append(userInfoBean.f4066i);
        map11.put("F05", sbR9.toString());
        Map<String, String> map12 = taVar.f4454g;
        StringBuilder sbR10 = c.a.a.a.a.r("");
        sbR10.append(userInfoBean.m);
        map12.put("F06", sbR10.toString());
        Map<String, String> map13 = taVar.f4454g;
        StringBuilder sbR11 = c.a.a.a.a.r("");
        sbR11.append(userInfoBean.f4068k);
        map13.put("F10", sbR11.toString());
        X.a("summary type %d vm:%d", Byte.valueOf(taVar.f4450c), Integer.valueOf(taVar.f4454g.size()));
        return taVar;
    }

    public static ua a(List<UserInfoBean> list, int i2) {
        com.tencent.bugly.crashreport.common.info.a aVarM;
        if (list == null || list.size() == 0 || (aVarM = com.tencent.bugly.crashreport.common.info.a.m()) == null) {
            return null;
        }
        aVarM.E();
        ua uaVar = new ua();
        uaVar.f4459d = aVarM.f4099h;
        uaVar.f4460e = aVarM.l();
        ArrayList<ta> arrayList = new ArrayList<>();
        Iterator<UserInfoBean> it = list.iterator();
        while (it.hasNext()) {
            ta taVarA = a(it.next(), aVarM);
            if (taVarA != null) {
                arrayList.add(taVarA);
            }
        }
        uaVar.f4461f = arrayList;
        HashMap map = new HashMap();
        uaVar.f4462g = map;
        StringBuilder sbR = c.a.a.a.a.r("");
        sbR.append(aVarM.n);
        map.put("A7", sbR.toString());
        Map<String, String> map2 = uaVar.f4462g;
        StringBuilder sbR2 = c.a.a.a.a.r("");
        sbR2.append(aVarM.j());
        map2.put("A6", sbR2.toString());
        Map<String, String> map3 = uaVar.f4462g;
        StringBuilder sbR3 = c.a.a.a.a.r("");
        sbR3.append(aVarM.k());
        map3.put("A5", sbR3.toString());
        Map<String, String> map4 = uaVar.f4462g;
        StringBuilder sbR4 = c.a.a.a.a.r("");
        sbR4.append(aVarM.v());
        map4.put("A2", sbR4.toString());
        Map<String, String> map5 = uaVar.f4462g;
        StringBuilder sbR5 = c.a.a.a.a.r("");
        sbR5.append(aVarM.v());
        map5.put("A1", sbR5.toString());
        Map<String, String> map6 = uaVar.f4462g;
        StringBuilder sbR6 = c.a.a.a.a.r("");
        sbR6.append(aVarM.p);
        map6.put("A24", sbR6.toString());
        Map<String, String> map7 = uaVar.f4462g;
        StringBuilder sbR7 = c.a.a.a.a.r("");
        sbR7.append(aVarM.x());
        map7.put("A17", sbR7.toString());
        Map<String, String> map8 = uaVar.f4462g;
        StringBuilder sbR8 = c.a.a.a.a.r("");
        sbR8.append(aVarM.i());
        map8.put("A15", sbR8.toString());
        Map<String, String> map9 = uaVar.f4462g;
        StringBuilder sbR9 = c.a.a.a.a.r("");
        sbR9.append(aVarM.n());
        map9.put("A13", sbR9.toString());
        Map<String, String> map10 = uaVar.f4462g;
        StringBuilder sbR10 = c.a.a.a.a.r("");
        sbR10.append(aVarM.ca);
        map10.put("F08", sbR10.toString());
        Map<String, String> map11 = uaVar.f4462g;
        StringBuilder sbR11 = c.a.a.a.a.r("");
        sbR11.append(aVarM.da);
        map11.put("F09", sbR11.toString());
        Map<String, String> mapG = aVarM.g();
        if (mapG != null && mapG.size() > 0) {
            for (Map.Entry<String, String> entry : mapG.entrySet()) {
                Map<String, String> map12 = uaVar.f4462g;
                StringBuilder sbR12 = c.a.a.a.a.r("C04_");
                sbR12.append(entry.getKey());
                map12.put(sbR12.toString(), entry.getValue());
            }
        }
        if (i2 != 1) {
            if (i2 != 2) {
                X.b("unknown up type %d ", Integer.valueOf(i2));
                return null;
            }
            uaVar.f4458c = (byte) 2;
        } else {
            uaVar.f4458c = (byte) 1;
        }
        return uaVar;
    }

    public static <T extends AbstractC0320m> T a(byte[] bArr, Class<T> cls) {
        if (bArr != null && bArr.length > 0) {
            try {
                T tNewInstance = cls.newInstance();
                C0318k c0318k = new C0318k(bArr);
                c0318k.a("utf-8");
                tNewInstance.a(c0318k);
                return tNewInstance;
            } catch (Throwable th) {
                if (!X.a(th)) {
                    th.printStackTrace();
                }
            }
        }
        return null;
    }

    public static pa a(Context context, int i2, byte[] bArr) {
        String str;
        com.tencent.bugly.crashreport.common.info.a aVarM = com.tencent.bugly.crashreport.common.info.a.m();
        StrategyBean strategyBeanC = com.tencent.bugly.crashreport.common.strategy.c.b().c();
        if (aVarM != null && strategyBeanC != null) {
            try {
                pa paVar = new pa();
                synchronized (aVarM) {
                    paVar.f4409c = aVarM.f4097f;
                    paVar.f4410d = aVarM.e();
                    paVar.f4411e = aVarM.f4098g;
                    paVar.f4412f = aVarM.E;
                    paVar.f4413g = aVarM.I;
                    paVar.f4414h = aVarM.f4103l;
                    paVar.f4415i = i2;
                    if (bArr == null) {
                        bArr = "".getBytes();
                    }
                    paVar.f4416j = bArr;
                    paVar.f4417k = aVarM.o;
                    paVar.f4418l = aVarM.p;
                    paVar.m = new HashMap();
                    paVar.n = aVarM.u();
                    paVar.o = strategyBeanC.o;
                    paVar.q = aVarM.l();
                    paVar.r = com.tencent.bugly.crashreport.common.info.b.c(context);
                    paVar.s = System.currentTimeMillis();
                    paVar.u = aVarM.q();
                    StringBuilder sb = new StringBuilder();
                    sb.append("");
                    sb.append(aVarM.l());
                    paVar.x = sb.toString();
                    paVar.y = paVar.r;
                    paVar.p = "com.tencent.bugly";
                    Map<String, String> map = paVar.m;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("");
                    sb2.append(aVarM.r());
                    map.put("A26", sb2.toString());
                    Map<String, String> map2 = paVar.m;
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("");
                    sb3.append(aVarM.D());
                    map2.put("A62", sb3.toString());
                    Map<String, String> map3 = paVar.m;
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("");
                    sb4.append(aVarM.B());
                    map3.put("A63", sb4.toString());
                    Map<String, String> map4 = paVar.m;
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("");
                    sb5.append(aVarM.ha);
                    map4.put("F11", sb5.toString());
                    Map<String, String> map5 = paVar.m;
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append("");
                    sb6.append(aVarM.ga);
                    map5.put("F12", sb6.toString());
                    Map<String, String> map6 = paVar.m;
                    StringBuilder sb7 = new StringBuilder();
                    sb7.append("");
                    sb7.append(aVarM.G);
                    map6.put("D3", sb7.toString());
                    List<com.tencent.bugly.a> list = com.tencent.bugly.b.f3959b;
                    if (list != null) {
                        for (com.tencent.bugly.a aVar : list) {
                            String str2 = aVar.versionKey;
                            if (str2 != null && (str = aVar.version) != null) {
                                paVar.m.put(str2, str);
                            }
                        }
                    }
                    paVar.m.put("G15", ca.b("G15", ""));
                    paVar.m.put("D4", ca.b("D4", "0"));
                }
                Map<String, String> mapF = aVarM.f();
                if (mapF != null) {
                    for (Map.Entry<String, String> entry : mapF.entrySet()) {
                        paVar.m.put(entry.getKey(), entry.getValue());
                    }
                }
                return paVar;
            } catch (Throwable th) {
                if (!X.a(th)) {
                    th.printStackTrace();
                }
                return null;
            }
        }
        X.b("Can not create request pkg for parameters is invalid.", new Object[0]);
        return null;
    }

    public static byte[] a(Object obj) {
        try {
            C0312e c0312e = new C0312e();
            c0312e.a();
            c0312e.a("utf-8");
            c0312e.a(1);
            c0312e.c("RqdServer");
            c0312e.b("sync");
            c0312e.a("detail", obj);
            return c0312e.b();
        } catch (Throwable th) {
            if (X.a(th)) {
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }

    public static qa a(byte[] bArr, StrategyBean strategyBean, boolean z) {
        if (bArr != null) {
            try {
                C0312e c0312e = new C0312e();
                c0312e.a();
                c0312e.a("utf-8");
                c0312e.a(bArr);
                Object objB = c0312e.b("detail", new qa());
                if (qa.class.isInstance(objB)) {
                    return (qa) qa.class.cast(objB);
                }
                return null;
            } catch (Throwable th) {
                if (!X.a(th)) {
                    th.printStackTrace();
                }
            }
        }
        return null;
    }

    public static byte[] a(AbstractC0320m abstractC0320m) {
        try {
            C0319l c0319l = new C0319l();
            c0319l.a("utf-8");
            abstractC0320m.a(c0319l);
            return c0319l.b();
        } catch (Throwable th) {
            if (X.a(th)) {
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }
}

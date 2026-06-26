package com.tencent.bugly.beta.upgrade;

import android.text.TextUtils;
import androidx.core.view.PointerIconCompat;
import com.tencent.bugly.beta.global.e;
import com.tencent.bugly.proguard.A;
import com.tencent.bugly.proguard.AbstractC0320m;
import com.tencent.bugly.proguard.C0332z;
import com.tencent.bugly.proguard.M;
import com.tencent.bugly.proguard.P;
import com.tencent.bugly.proguard.T;
import com.tencent.bugly.proguard.X;
import com.tencent.bugly.proguard.pa;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes.dex */
public class b {
    public static b a = new b();

    public synchronized void a(int i2, int i3, byte[] bArr, a aVar, boolean z, String str) {
        com.tencent.bugly.crashreport.common.info.a aVarM = com.tencent.bugly.crashreport.common.info.a.m();
        try {
        } catch (Throwable th) {
            th = th;
        }
        try {
            pa paVarA = M.a(e.f3983b.v, i2, bArr);
            if (paVarA != null) {
                e eVar = e.f3983b;
                paVarA.f4410d = eVar.x;
                if (!TextUtils.isEmpty(eVar.R)) {
                    paVarA.f4413g = eVar.R;
                }
                Map<String, String> map = paVarA.m;
                if (map != null) {
                    map.put("G6", eVar.y);
                    paVarA.m.put("G10", "1.5.23");
                    Map<String, String> map2 = paVarA.m;
                    StringBuilder sb = new StringBuilder();
                    sb.append("");
                    sb.append(eVar.A);
                    map2.put("G3", sb.toString());
                    paVarA.m.put("G11", String.valueOf(eVar.z));
                    paVarA.m.put("G2", String.valueOf(com.tencent.bugly.beta.global.a.a(e.f3983b.v)));
                    int i4 = eVar.r;
                    if (i4 < 0) {
                        i4 = 0;
                    }
                    paVarA.m.put("G12", String.valueOf(i4));
                    Map<String, String> map3 = paVarA.m;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("");
                    sb2.append(aVarM.y());
                    map3.put("A21", sb2.toString());
                    Map<String, String> map4 = paVarA.m;
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("");
                    sb3.append(aVarM.l());
                    map4.put("A22", sb3.toString());
                    Map<String, String> map5 = paVarA.m;
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("");
                    sb4.append(eVar.L);
                    map5.put("G13", sb4.toString());
                    Map<String, String> map6 = paVarA.m;
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("");
                    sb5.append(eVar.M);
                    map6.put("G14", sb5.toString());
                    Map<String, String> map7 = paVarA.m;
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append("");
                    sb6.append(eVar.O);
                    map7.put("G15", sb6.toString());
                    Map<String, String> map8 = paVarA.m;
                    StringBuilder sb7 = new StringBuilder();
                    sb7.append("");
                    sb7.append(aVarM.n());
                    map8.put("G17", sb7.toString());
                    Map<String, String> map9 = paVarA.m;
                    StringBuilder sb8 = new StringBuilder();
                    sb8.append("");
                    sb8.append(aVarM.A());
                    map9.put("C01", sb8.toString());
                    Map<String, String> map10 = paVarA.m;
                    StringBuilder sb9 = new StringBuilder();
                    sb9.append("");
                    sb9.append(aVarM.y());
                    map10.put("G18", sb9.toString());
                    Map<String, String> map11 = paVarA.m;
                    StringBuilder sb10 = new StringBuilder();
                    sb10.append("");
                    sb10.append(i3);
                    map11.put("strategyType", sb10.toString());
                    Map<String, String> map12 = paVarA.m;
                    StringBuilder sb11 = new StringBuilder();
                    sb11.append("");
                    sb11.append(z);
                    map12.put("strategyRequestManner", sb11.toString());
                    Map<String, String> mapH = aVarM.h();
                    if (mapH != null && mapH.size() > 0) {
                        for (Map.Entry<String, String> entry : mapH.entrySet()) {
                            Map<String, String> map13 = paVarA.m;
                            StringBuilder sb12 = new StringBuilder();
                            sb12.append("C03_");
                            sb12.append(entry.getKey());
                            map13.put(sb12.toString(), entry.getValue());
                        }
                    }
                    X.a("app version is: [%s.%s], [deviceId:%s], channel: [%s], buildNo: [%s], base tinkerId:[%s], patch tinkerId:[%s], patch version:[%s], strategyType:[%s]", eVar.A, Integer.valueOf(eVar.z), aVarM.l(), paVarA.f4413g, Integer.valueOf(eVar.r), eVar.L, eVar.M, eVar.O, Integer.valueOf(i3));
                    HashMap map14 = new HashMap();
                    StringBuilder sb13 = new StringBuilder();
                    sb13.append(e.f3983b.H.f4001b);
                    sb13.append("");
                    map14.put("grayStrategyUpdateTime", sb13.toString());
                    if (z) {
                        T.a().a(PointerIconCompat.TYPE_HAND, paVarA.f4415i, M.a((Object) paVarA), str, str, aVar, 0, 1, true, map14);
                    } else {
                        T.a().a(PointerIconCompat.TYPE_HAND, paVarA.f4415i, M.a((Object) paVarA), str, str, (P) aVar, false, (Map<String, String>) map14);
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
            if (!X.b(th)) {
                th.printStackTrace();
            }
            aVar.a(i2, null, 0L, 0L, false, "sendRequest failed");
        }
    }

    public synchronized void a(C0332z c0332z, boolean z) {
        if (c0332z == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(c0332z);
        A a2 = new A(arrayList);
        try {
            a(803, -1, M.a((AbstractC0320m) a2), new a(2, 803, a2, Boolean.valueOf(z)), false, e.f3983b.H.a.f4443g);
        } catch (Throwable th) {
            if (!X.a(th)) {
                th.printStackTrace();
            }
        }
    }

    public synchronized void a(A a2, boolean z) {
        if (a2 == null) {
            return;
        }
        try {
            a(803, -1, M.a((AbstractC0320m) a2), new a(2, 803, a2, Boolean.valueOf(z)), false, e.f3983b.H.a.f4443g);
        } catch (Throwable th) {
            if (!X.a(th)) {
                th.printStackTrace();
            }
        }
    }
}

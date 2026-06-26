package com.tencent.bugly.crashreport.common.strategy;

import com.tencent.bugly.proguard.I;
import com.tencent.bugly.proguard.J;
import com.tencent.bugly.proguard.X;
import com.tencent.bugly.proguard.ca;
import java.util.Map;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes.dex */
public class b extends Thread {
    public final /* synthetic */ c a;

    public b(c cVar) {
        this.a = cVar;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        try {
            Map<String, byte[]> mapA = J.a().a(c.a, (I) null, true);
            if (mapA != null) {
                byte[] bArr = mapA.get("device");
                byte[] bArr2 = mapA.get("gateway");
                if (bArr != null) {
                    com.tencent.bugly.crashreport.common.info.a.a(this.a.f4125h).f(new String(bArr));
                }
                if (bArr2 != null) {
                    com.tencent.bugly.crashreport.common.info.a.a(this.a.f4125h).e(new String(bArr2));
                }
            }
            c cVar = this.a;
            cVar.f4124g = cVar.e();
            if (this.a.f4124g != null) {
                if (ca.b(c.f4120c) || !ca.c(c.f4120c)) {
                    this.a.f4124g.q = StrategyBean.a;
                    this.a.f4124g.r = StrategyBean.f4108b;
                } else {
                    this.a.f4124g.q = c.f4120c;
                    this.a.f4124g.r = c.f4120c;
                }
            }
        } catch (Throwable th) {
            if (!X.b(th)) {
                th.printStackTrace();
            }
        }
        c cVar2 = this.a;
        cVar2.a(cVar2.f4124g, false);
    }
}

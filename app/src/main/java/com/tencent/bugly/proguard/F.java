package com.tencent.bugly.proguard;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes.dex */
public class F implements Runnable {
    public final /* synthetic */ int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f4270b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ H f4271c;

    public F(H h2, int i2, int i3) {
        this.f4271c = h2;
        this.a = i2;
        this.f4270b = i3;
    }

    @Override // java.lang.Runnable
    public void run() {
        E e2;
        String str;
        String str2;
        try {
            if (TextUtils.isEmpty(this.f4271c.f4275d)) {
                return;
            }
            List<E> listC = this.f4271c.c(this.a);
            if (listC == null) {
                listC = new ArrayList();
            }
            if (this.f4271c.f4276e.get(Integer.valueOf(this.a)) == null) {
                this.f4271c.f4276e.put(Integer.valueOf(this.a), new HashMap());
            }
            if (((Map) this.f4271c.f4276e.get(Integer.valueOf(this.a))).get(this.f4271c.f4275d) == null) {
                e2 = new E();
                e2.a = this.a;
                e2.f4269g = H.f4273b;
                e2.f4264b = this.f4271c.f4275d;
                e2.f4268f = com.tencent.bugly.crashreport.common.info.a.m().E;
                e2.f4267e = com.tencent.bugly.crashreport.common.info.a.m().f4103l;
                e2.f4265c = System.currentTimeMillis();
                e2.f4266d = this.f4270b;
                ((Map) this.f4271c.f4276e.get(Integer.valueOf(this.a))).put(this.f4271c.f4275d, e2);
            } else {
                e2 = (E) ((Map) this.f4271c.f4276e.get(Integer.valueOf(this.a))).get(this.f4271c.f4275d);
                e2.f4266d = this.f4270b;
            }
            ArrayList arrayList = new ArrayList();
            boolean z = false;
            for (E e3 : listC) {
                if (e3.f4269g == e2.f4269g && (str2 = e3.f4264b) != null && str2.equalsIgnoreCase(e2.f4264b)) {
                    z = true;
                    e3.f4266d = e2.f4266d;
                }
                String str3 = e3.f4267e;
                if ((str3 != null && !str3.equalsIgnoreCase(e2.f4267e)) || (((str = e3.f4268f) != null && !str.equalsIgnoreCase(e2.f4268f)) || e3.f4266d <= 0)) {
                    arrayList.add(e3);
                }
            }
            listC.removeAll(arrayList);
            if (!z) {
                listC.add(e2);
            }
            this.f4271c.a(this.a, listC);
        } catch (Exception unused) {
            X.b("saveCrashRecord failed", new Object[0]);
        }
    }
}

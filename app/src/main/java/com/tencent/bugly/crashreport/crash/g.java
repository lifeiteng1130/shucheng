package com.tencent.bugly.crashreport.crash;

import com.tencent.bugly.proguard.X;
import com.tencent.bugly.proguard.ca;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes.dex */
public class g extends Thread {
    public final /* synthetic */ h a;

    public g(h hVar) {
        this.a = hVar;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        List<CrashDetailBean> list;
        if (!ca.a(this.a.q, "local_crash_lock", 10000L)) {
            X.a("Failed to lock file for uploading local crash.", new Object[0]);
            return;
        }
        List<CrashDetailBean> listB = this.a.r.b();
        if (listB == null || listB.size() <= 0) {
            X.a("no crash need to be uploaded at this start", new Object[0]);
        } else {
            X.a("Size of crash list: %s", Integer.valueOf(listB.size()));
            int size = listB.size();
            if (size > 20) {
                ArrayList arrayList = new ArrayList();
                Collections.sort(listB);
                for (int i2 = 0; i2 < 20; i2++) {
                    arrayList.add(listB.get((size - 1) - i2));
                }
                list = arrayList;
            } else {
                list = listB;
            }
            this.a.r.a(list, 0L, false, false, false);
        }
        ca.b(this.a.q, "local_crash_lock");
    }
}

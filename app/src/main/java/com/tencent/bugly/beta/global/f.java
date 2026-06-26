package com.tencent.bugly.beta.global;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.bugly.beta.download.DownloadTask;
import com.tencent.bugly.proguard.C0323p;
import com.tencent.bugly.proguard.X;
import j$.util.DesugarCollections;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes.dex */
public class f {
    public static f a = new f();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List<Runnable> f3994b = new ArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, DownloadTask> f3995c = DesugarCollections.synchronizedMap(new HashMap());

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Handler f3996d = new Handler(Looper.getMainLooper());

    public synchronized void a(Runnable runnable, int i2) {
        if (this.f3995c.size() == 0) {
            runnable.run();
        } else {
            d dVar = new d(6, Boolean.FALSE, runnable);
            this.f3996d.postDelayed(dVar, i2);
            a(dVar);
        }
    }

    public void b() {
        synchronized (this) {
            Iterator<Runnable> it = this.f3994b.iterator();
            while (it.hasNext()) {
                it.next().run();
            }
            Iterator<DownloadTask> it2 = this.f3995c.values().iterator();
            while (it2.hasNext()) {
                it2.next().delete(false);
            }
            this.f3994b.clear();
            this.f3995c.clear();
        }
    }

    public synchronized void a(Runnable runnable) {
        if (this.f3995c.size() == 0) {
            runnable.run();
        } else {
            this.f3994b.add(runnable);
        }
    }

    public void a(com.tencent.bugly.beta.download.c cVar, Map<String, String> map) {
        DownloadTask downloadTaskA;
        if (cVar == null) {
            return;
        }
        if (map != null && !map.isEmpty()) {
            Iterator<DownloadTask> it = this.f3995c.values().iterator();
            while (it.hasNext()) {
                it.next().delete(true);
            }
            this.f3995c.clear();
            com.tencent.bugly.beta.download.a aVar = new com.tencent.bugly.beta.download.a(1, this, this.f3995c);
            for (String str : ResBean.f3976b) {
                if (!map.containsKey(str)) {
                    this.f3995c.clear();
                    ResBean resBean = new ResBean();
                    ResBean.a = resBean;
                    a.a("rb.bch", resBean);
                    return;
                }
                String str2 = map.get(str);
                if (str.startsWith("IMG_") && !TextUtils.isEmpty(str2)) {
                    ResBean.a.a(str, "");
                    Iterator<DownloadTask> it2 = this.f3995c.values().iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            downloadTaskA = it2.next();
                            if (downloadTaskA.getDownloadUrl().equals(str2)) {
                                break;
                            }
                        } else {
                            downloadTaskA = null;
                            break;
                        }
                    }
                    if (downloadTaskA == null) {
                        downloadTaskA = cVar.a(str2, e.f3983b.u.getAbsolutePath(), null, null);
                    }
                    if (downloadTaskA != null) {
                        downloadTaskA.addListener(aVar);
                        downloadTaskA.setNeededNotify(false);
                        this.f3995c.put(str, downloadTaskA);
                    }
                } else {
                    ResBean.a.a(str, str2);
                }
            }
            a.a("rb.bch", ResBean.a);
            if (this.f3995c.isEmpty()) {
                return;
            }
            Iterator<DownloadTask> it3 = this.f3995c.values().iterator();
            while (it3.hasNext()) {
                it3.next().download();
            }
            return;
        }
        this.f3995c.clear();
        ResBean resBean2 = new ResBean();
        ResBean.a = resBean2;
        a.a("rb.bch", resBean2);
    }

    public void a() {
        ArrayList arrayList = new ArrayList();
        for (String str : ResBean.f3976b) {
            String strA = ResBean.a.a(str);
            if (str.startsWith("IMG_") && !TextUtils.isEmpty(strA)) {
                arrayList.add(strA);
            }
        }
        File[] fileArrListFiles = e.f3983b.u.listFiles();
        if (fileArrListFiles == null || fileArrListFiles.length <= 0) {
            return;
        }
        for (File file : fileArrListFiles) {
            Iterator it = arrayList.iterator();
            boolean z = true;
            while (it.hasNext()) {
                if (file.getAbsolutePath().equals((String) it.next())) {
                    z = false;
                }
            }
            if (z) {
                C0323p.a.b(file.getAbsolutePath());
                if (!file.delete()) {
                    X.b("cannot deleteCache file:%s", file.getAbsolutePath());
                }
            }
        }
    }
}

package com.ss.android.downloadlib.addownload.b;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.android.downloadlib.g.l;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: ModelManager.java */
/* JADX INFO: loaded from: classes.dex */
public class f {
    private volatile boolean a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ConcurrentHashMap<Long, DownloadModel> f3055b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ConcurrentHashMap<Long, DownloadEventConfig> f3056c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ConcurrentHashMap<Long, DownloadController> f3057d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ConcurrentHashMap<Long, com.ss.android.downloadad.api.a.b> f3058e;

    /* JADX INFO: compiled from: ModelManager.java */
    public static class a {
        private static f a = new f();
    }

    public DownloadController c(long j2) {
        return (DownloadController) this.f3057d.get(Long.valueOf(j2));
    }

    public com.ss.android.downloadad.api.a.b d(long j2) {
        return (com.ss.android.downloadad.api.a.b) this.f3058e.get(Long.valueOf(j2));
    }

    @NonNull
    public e e(long j2) {
        e eVar = new e();
        eVar.a = j2;
        eVar.f3052b = a(j2);
        DownloadEventConfig downloadEventConfigB = b(j2);
        eVar.f3053c = downloadEventConfigB;
        if (downloadEventConfigB == null) {
            eVar.f3053c = new com.ss.android.download.api.download.c();
        }
        DownloadController downloadControllerC = c(j2);
        eVar.f3054d = downloadControllerC;
        if (downloadControllerC == null) {
            eVar.f3054d = new com.ss.android.download.api.download.b();
        }
        return eVar;
    }

    public void f(long j2) {
        this.f3055b.remove(Long.valueOf(j2));
        this.f3056c.remove(Long.valueOf(j2));
        this.f3057d.remove(Long.valueOf(j2));
    }

    private f() {
        this.a = false;
        this.f3055b = new ConcurrentHashMap<>();
        this.f3056c = new ConcurrentHashMap<>();
        this.f3057d = new ConcurrentHashMap<>();
        this.f3058e = new ConcurrentHashMap<>();
    }

    public void b() {
        com.ss.android.downloadlib.d.a().a(new Runnable() { // from class: com.ss.android.downloadlib.addownload.b.f.1
            @Override // java.lang.Runnable
            public void run() {
                if (f.this.a) {
                    return;
                }
                synchronized (f.class) {
                    if (!f.this.a) {
                        f.this.f3058e.putAll(i.a().b());
                        f.this.a = true;
                    }
                }
            }
        }, true);
    }

    public ConcurrentHashMap<Long, com.ss.android.downloadad.api.a.b> c() {
        return this.f3058e;
    }

    public static f a() {
        return a.a;
    }

    public DownloadEventConfig b(long j2) {
        return (DownloadEventConfig) this.f3056c.get(Long.valueOf(j2));
    }

    public void a(DownloadModel downloadModel) {
        if (downloadModel != null) {
            this.f3055b.put(Long.valueOf(downloadModel.getId()), downloadModel);
            if (downloadModel.getDeepLink() != null) {
                downloadModel.getDeepLink().setId(downloadModel.getId());
                downloadModel.getDeepLink().setPackageName(downloadModel.getPackageName());
            }
        }
    }

    public com.ss.android.downloadad.api.a.b b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (com.ss.android.downloadad.api.a.b bVar : this.f3058e.values()) {
            if (bVar != null && str.equals(bVar.a())) {
                return bVar;
            }
        }
        return null;
    }

    public void b(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        for (DownloadModel downloadModel : this.f3055b.values()) {
            if ((downloadModel instanceof AdDownloadModel) && TextUtils.equals(downloadModel.getDownloadUrl(), str)) {
                ((AdDownloadModel) downloadModel).setPackageName(str2);
            }
        }
    }

    public void a(long j2, DownloadEventConfig downloadEventConfig) {
        if (downloadEventConfig != null) {
            this.f3056c.put(Long.valueOf(j2), downloadEventConfig);
        }
    }

    public void a(long j2, DownloadController downloadController) {
        if (downloadController != null) {
            this.f3057d.put(Long.valueOf(j2), downloadController);
        }
    }

    public synchronized void a(com.ss.android.downloadad.api.a.b bVar) {
        if (bVar == null) {
            return;
        }
        this.f3058e.put(Long.valueOf(bVar.b()), bVar);
        i.a().a(bVar);
    }

    public DownloadModel a(long j2) {
        return (DownloadModel) this.f3055b.get(Long.valueOf(j2));
    }

    public com.ss.android.downloadad.api.a.b a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (com.ss.android.downloadad.api.a.b bVar : this.f3058e.values()) {
            if (bVar != null && str.equals(bVar.e())) {
                return bVar;
            }
        }
        return null;
    }

    public com.ss.android.downloadad.api.a.b a(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return null;
        }
        for (com.ss.android.downloadad.api.a.b bVar : this.f3058e.values()) {
            if (bVar != null && bVar.s() == downloadInfo.getId()) {
                return bVar;
            }
        }
        if (!TextUtils.isEmpty(downloadInfo.getExtra())) {
            try {
                long jA = l.a(new JSONObject(downloadInfo.getExtra()), BaseConstants.EVENT_LABEL_EXTRA);
                if (jA != 0) {
                    for (com.ss.android.downloadad.api.a.b bVar2 : this.f3058e.values()) {
                        if (bVar2 != null && bVar2.b() == jA) {
                            return bVar2;
                        }
                    }
                    com.ss.android.downloadlib.e.c.a().a("getNativeModelByInfo");
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        for (com.ss.android.downloadad.api.a.b bVar3 : this.f3058e.values()) {
            if (bVar3 != null && TextUtils.equals(bVar3.a(), downloadInfo.getUrl())) {
                return bVar3;
            }
        }
        return null;
    }

    public com.ss.android.downloadad.api.a.b a(int i2) {
        for (com.ss.android.downloadad.api.a.b bVar : this.f3058e.values()) {
            if (bVar != null && bVar.s() == i2) {
                return bVar;
            }
        }
        return null;
    }

    @NonNull
    public Map<Long, com.ss.android.downloadad.api.a.b> a(String str, String str2) {
        HashMap map = new HashMap();
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            for (com.ss.android.downloadad.api.a.b bVar : this.f3058e.values()) {
                if (bVar != null && TextUtils.equals(bVar.a(), str)) {
                    bVar.b(str2);
                    map.put(Long.valueOf(bVar.b()), bVar);
                }
            }
        }
        return map;
    }

    public synchronized void a(List<Long> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<Long> it = list.iterator();
        while (it.hasNext()) {
            long jLongValue = it.next().longValue();
            arrayList.add(String.valueOf(jLongValue));
            this.f3058e.remove(Long.valueOf(jLongValue));
        }
        i.a().a((List<String>) arrayList);
    }
}

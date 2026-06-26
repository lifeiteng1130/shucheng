package com.ss.android.socialbase.downloader.network.a;

import com.ss.android.socialbase.downloader.network.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: FakeDownloadHeadHttpConnection.java */
/* JADX INFO: loaded from: classes.dex */
public class c implements g {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final ArrayList<String> f3869e;
    public final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f3870b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List<com.ss.android.socialbase.downloader.model.c> f3871c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f3874g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f3875h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f3876i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f3877j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private g f3878k;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Map<String, String> f3873f = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f3872d = new Object();

    static {
        ArrayList<String> arrayList = new ArrayList<>(6);
        f3869e = arrayList;
        arrayList.add("Content-Length");
        arrayList.add("Content-Range");
        arrayList.add("Transfer-Encoding");
        arrayList.add("Accept-Ranges");
        arrayList.add("Etag");
        arrayList.add("Content-Disposition");
    }

    public c(String str, List<com.ss.android.socialbase.downloader.model.c> list, long j2) {
        this.a = str;
        this.f3871c = list;
        this.f3870b = j2;
    }

    public void a() {
        if (this.f3873f != null) {
            return;
        }
        try {
            this.f3877j = true;
            this.f3878k = com.ss.android.socialbase.downloader.downloader.c.a(this.a, this.f3871c);
            synchronized (this.f3872d) {
                if (this.f3878k != null) {
                    HashMap map = new HashMap();
                    this.f3873f = map;
                    a(this.f3878k, map);
                    this.f3874g = this.f3878k.b();
                    this.f3875h = System.currentTimeMillis();
                    this.f3876i = a(this.f3874g);
                }
                this.f3877j = false;
                this.f3872d.notifyAll();
            }
        } catch (Throwable th) {
            synchronized (this.f3872d) {
                if (this.f3878k != null) {
                    HashMap map2 = new HashMap();
                    this.f3873f = map2;
                    a(this.f3878k, map2);
                    this.f3874g = this.f3878k.b();
                    this.f3875h = System.currentTimeMillis();
                    this.f3876i = a(this.f3874g);
                }
                this.f3877j = false;
                this.f3872d.notifyAll();
                throw th;
            }
        }
    }

    public boolean a(int i2) {
        return i2 >= 200 && i2 < 300;
    }

    @Override // com.ss.android.socialbase.downloader.network.g
    public int b() {
        return this.f3874g;
    }

    @Override // com.ss.android.socialbase.downloader.network.g
    public void c() {
        g gVar = this.f3878k;
        if (gVar != null) {
            gVar.c();
        }
    }

    public void d() {
        synchronized (this.f3872d) {
            if (this.f3877j && this.f3873f == null) {
                this.f3872d.wait();
            }
        }
    }

    public boolean e() {
        return this.f3876i;
    }

    public boolean f() {
        return System.currentTimeMillis() - this.f3875h < b.f3865b;
    }

    public boolean g() {
        return this.f3877j;
    }

    public List<com.ss.android.socialbase.downloader.model.c> h() {
        return this.f3871c;
    }

    public Map<String, String> i() {
        return this.f3873f;
    }

    private void a(g gVar, Map<String, String> map) {
        if (gVar == null || map == null) {
            return;
        }
        for (String str : f3869e) {
            map.put(str, gVar.a(str));
        }
    }

    @Override // com.ss.android.socialbase.downloader.network.g
    public String a(String str) {
        Map<String, String> map = this.f3873f;
        if (map != null) {
            return map.get(str);
        }
        g gVar = this.f3878k;
        if (gVar != null) {
            return gVar.a(str);
        }
        return null;
    }
}

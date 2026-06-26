package com.ss.android.socialbase.downloader.network.a;

import com.ss.android.socialbase.downloader.i.f;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: DownloadConnectionPool.java */
/* JADX INFO: loaded from: classes.dex */
public class a {
    public int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<String, c> f3863b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map<String, d> f3864c;

    /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.network.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: DownloadConnectionPool.java */
    public static final class C0118a {
        private static final a a = new a();
    }

    public void a(String str, c cVar) {
        synchronized (this.f3863b) {
            this.f3863b.put(str, cVar);
        }
    }

    public d b(String str, List<com.ss.android.socialbase.downloader.model.c> list) {
        d dVarRemove;
        synchronized (this.f3864c) {
            dVarRemove = this.f3864c.remove(str);
        }
        if (dVarRemove == null) {
            return null;
        }
        if (f.a(dVarRemove.f(), list)) {
            try {
                dVarRemove.e();
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
            if (dVarRemove.h() && dVarRemove.g()) {
                return dVarRemove;
            }
        }
        try {
            dVarRemove.d();
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    private a() {
        this.f3863b = new HashMap();
        this.f3864c = new LinkedHashMap(3);
        this.a = 3;
    }

    public void a(int i2) {
        this.a = i2;
    }

    public c a(String str, List<com.ss.android.socialbase.downloader.model.c> list) {
        c cVarRemove;
        synchronized (this.f3863b) {
            cVarRemove = this.f3863b.remove(str);
        }
        if (cVarRemove == null) {
            return null;
        }
        if (f.a(cVarRemove.h(), list)) {
            try {
                cVarRemove.d();
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
            if (cVarRemove.f() && cVarRemove.e()) {
                return cVarRemove;
            }
        }
        try {
            cVarRemove.c();
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public boolean a(String str) {
        c cVar = this.f3863b.get(str);
        if (cVar == null) {
            return false;
        }
        if (cVar.g()) {
            return true;
        }
        return cVar.f() && cVar.e();
    }

    public static a a() {
        return C0118a.a;
    }
}

package com.ss.android.socialbase.downloader.network.a;

import com.ss.android.socialbase.downloader.network.i;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/* JADX INFO: compiled from: FakeDownloadHttpConnection.java */
/* JADX INFO: loaded from: classes.dex */
public class d implements i {
    public final Object a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<com.ss.android.socialbase.downloader.model.c> f3879b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private i f3880c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f3881d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f3882e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private InputStream f3883f;

    @Override // com.ss.android.socialbase.downloader.network.i
    public InputStream a() {
        InputStream inputStream = this.f3883f;
        if (inputStream != null) {
            return inputStream;
        }
        return null;
    }

    public boolean a(int i2) {
        return i2 >= 200 && i2 < 300;
    }

    @Override // com.ss.android.socialbase.downloader.network.g
    public int b() {
        i iVar = this.f3880c;
        if (iVar != null) {
            return iVar.b();
        }
        return 0;
    }

    @Override // com.ss.android.socialbase.downloader.network.g
    public void c() {
        i iVar = this.f3880c;
        if (iVar != null) {
            iVar.c();
        }
    }

    @Override // com.ss.android.socialbase.downloader.network.i
    public void d() {
        i iVar = this.f3880c;
        if (iVar != null) {
            iVar.d();
        }
    }

    public void e() {
        synchronized (this.a) {
            if (this.f3881d && this.f3880c == null) {
                this.a.wait();
            }
        }
    }

    public List<com.ss.android.socialbase.downloader.model.c> f() {
        return this.f3879b;
    }

    public boolean g() {
        try {
            i iVar = this.f3880c;
            if (iVar != null) {
                return a(iVar.b());
            }
            return false;
        } catch (IOException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public boolean h() {
        return System.currentTimeMillis() - this.f3882e < b.a;
    }

    @Override // com.ss.android.socialbase.downloader.network.g
    public String a(String str) {
        i iVar = this.f3880c;
        if (iVar != null) {
            return iVar.a(str);
        }
        return null;
    }
}

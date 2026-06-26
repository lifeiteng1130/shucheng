package com.ss.android.socialbase.downloader.e;

import com.ss.android.socialbase.downloader.i.f;
import java.io.InputStream;

/* JADX INFO: compiled from: SyncStreamReader.java */
/* JADX INFO: loaded from: classes.dex */
public class c implements b {
    private final InputStream a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.ss.android.socialbase.downloader.f.a f3605b;

    public c(InputStream inputStream, int i2) {
        this.a = inputStream;
        this.f3605b = new com.ss.android.socialbase.downloader.f.a(i2);
    }

    @Override // com.ss.android.socialbase.downloader.e.b
    public com.ss.android.socialbase.downloader.f.a a() {
        com.ss.android.socialbase.downloader.f.a aVar = this.f3605b;
        aVar.f3610c = this.a.read(aVar.a);
        return this.f3605b;
    }

    @Override // com.ss.android.socialbase.downloader.e.b
    public void a(com.ss.android.socialbase.downloader.f.a aVar) {
    }

    @Override // com.ss.android.socialbase.downloader.e.b
    public void b() {
        f.a(this.a);
    }
}

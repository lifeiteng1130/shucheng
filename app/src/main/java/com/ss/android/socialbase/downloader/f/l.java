package com.ss.android.socialbase.downloader.f;

import androidx.annotation.NonNull;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.IOException;
import java.io.SyncFailedException;

/* JADX INFO: compiled from: SegmentOutput.java */
/* JADX INFO: loaded from: classes.dex */
public class l implements e {
    private final i a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.ss.android.socialbase.downloader.model.e f3653b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final e f3654c;

    public l(DownloadInfo downloadInfo, b bVar, i iVar) {
        this.a = iVar;
        this.f3653b = a(downloadInfo, iVar);
        this.f3654c = new h(bVar, this);
    }

    public e a() {
        return this.f3654c;
    }

    @Override // com.ss.android.socialbase.downloader.f.e
    public void b(@NonNull a aVar) throws IOException {
        this.f3653b.a(aVar.a, 0, aVar.f3610c);
        this.a.b(aVar.f3610c);
    }

    public void c() throws SyncFailedException {
        this.f3653b.c();
    }

    public void d() {
        com.ss.android.socialbase.downloader.i.f.a(this.f3653b);
    }

    public i e() {
        return this.a;
    }

    private com.ss.android.socialbase.downloader.model.e a(DownloadInfo downloadInfo, i iVar) throws BaseException {
        com.ss.android.socialbase.downloader.model.e eVarA = com.ss.android.socialbase.downloader.i.f.a(downloadInfo, downloadInfo.getTempPath(), downloadInfo.getTempName(), com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId()).a("flush_buffer_size_byte", -1));
        try {
            eVarA.a(iVar.e());
            return eVarA;
        } catch (IOException e2) {
            throw new BaseException(1054, e2);
        }
    }

    public void b() throws IOException {
        this.f3653b.b();
    }
}

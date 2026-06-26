package com.ss.android.downloadlib.f;

import androidx.annotation.NonNull;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import com.ss.android.downloadlib.addownload.b.f;
import com.ss.android.socialbase.appdownloader.c.i;
import com.ss.android.socialbase.appdownloader.c.j;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* JADX INFO: compiled from: AppInstallInvokeInterceptor.java */
/* JADX INFO: loaded from: classes.dex */
public class a implements j {
    /* JADX INFO: Access modifiers changed from: private */
    public void b(DownloadInfo downloadInfo, @NonNull final com.ss.android.downloadlib.guide.install.a aVar) {
        com.ss.android.downloadad.api.a.b bVarA = f.a().a(downloadInfo);
        boolean zA = com.ss.android.downloadlib.b.f.a(bVarA);
        boolean zB = com.ss.android.downloadlib.b.f.b(bVarA);
        if (zA && zB) {
            com.ss.android.downloadlib.b.c.a(bVarA, new com.ss.android.downloadlib.guide.install.a() { // from class: com.ss.android.downloadlib.f.a.3
                @Override // com.ss.android.downloadlib.guide.install.a
                public void a() {
                    aVar.a();
                }
            });
        } else {
            aVar.a();
        }
    }

    @Override // com.ss.android.socialbase.appdownloader.c.j
    public void a(DownloadInfo downloadInfo, final i iVar) {
        a(downloadInfo, new com.ss.android.downloadlib.guide.install.a() { // from class: com.ss.android.downloadlib.f.a.1
            @Override // com.ss.android.downloadlib.guide.install.a
            public void a() {
                iVar.a();
            }
        });
    }

    public void a(final DownloadInfo downloadInfo, @NonNull final com.ss.android.downloadlib.guide.install.a aVar) {
        com.ss.android.downloadad.api.a.b bVarA = f.a().a(downloadInfo);
        if (bVarA != null && com.ss.android.downloadlib.b.i.a(bVarA)) {
            TTDelegateActivity.a(bVarA, new com.ss.android.downloadlib.guide.install.a() { // from class: com.ss.android.downloadlib.f.a.2
                @Override // com.ss.android.downloadlib.guide.install.a
                public void a() {
                    a.this.b(downloadInfo, aVar);
                }
            });
        } else {
            b(downloadInfo, aVar);
        }
    }
}

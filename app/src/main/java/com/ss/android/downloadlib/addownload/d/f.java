package com.ss.android.downloadlib.addownload.d;

import android.content.Context;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: PauseInterceptorManager.java */
/* JADX INFO: loaded from: classes.dex */
public class f {
    private static f a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List<d> f3121b;

    private f() {
        ArrayList arrayList = new ArrayList();
        this.f3121b = arrayList;
        arrayList.add(new e());
        this.f3121b.add(new g());
        this.f3121b.add(new b());
        this.f3121b.add(new a());
    }

    public static f a() {
        if (a == null) {
            synchronized (f.class) {
                if (a == null) {
                    a = new f();
                }
            }
        }
        return a;
    }

    public void a(com.ss.android.downloadad.api.a.b bVar, int i2, c cVar) {
        List<d> list = this.f3121b;
        if (list != null && list.size() != 0 && bVar != null) {
            DownloadInfo downloadInfoA = com.ss.android.downloadlib.g.a((Context) null).a(bVar.a());
            if (downloadInfoA != null && AdBaseConstants.MIME_APK.equals(downloadInfoA.getMimeType())) {
                boolean z = com.ss.android.socialbase.downloader.g.a.a(bVar.s()).a("pause_optimise_switch", 0) == 1;
                for (d dVar : this.f3121b) {
                    if (z || (dVar instanceof g)) {
                        if (dVar.a(bVar, i2, cVar)) {
                            return;
                        }
                    }
                }
                cVar.a(bVar);
                return;
            }
            cVar.a(bVar);
            return;
        }
        cVar.a(bVar);
    }
}

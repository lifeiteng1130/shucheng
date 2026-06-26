package com.ss.android.socialbase.downloader.impls;

import android.database.sqlite.SQLiteException;
import android.os.Build;
import android.os.Looper;
import android.os.Message;
import android.util.SparseArray;
import androidx.camera.core.FocusMeteringAction;
import com.ss.android.socialbase.downloader.downloader.c;
import com.ss.android.socialbase.downloader.downloader.t;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.h.h;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: DefaultDownloadCache.java */
/* JADX INFO: loaded from: classes.dex */
public class d implements com.ss.android.socialbase.downloader.downloader.j {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private t f3772b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile boolean f3773c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile boolean f3774d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private com.ss.android.socialbase.downloader.h.h f3776f;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private h.a f3775e = new h.a() { // from class: com.ss.android.socialbase.downloader.impls.d.1
        @Override // com.ss.android.socialbase.downloader.h.h.a
        public void a(Message message) {
            if (message.what == 1) {
                com.ss.android.socialbase.downloader.downloader.c.l().execute(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.d.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            d.this.i();
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                });
            }
        }
    };
    private final k a = new k();

    public d() {
        this.f3776f = null;
        if (com.ss.android.socialbase.downloader.g.a.c().a("fix_sigbus_downloader_db") && !com.ss.android.socialbase.downloader.i.f.a() && com.ss.android.socialbase.downloader.downloader.c.S()) {
            this.f3772b = com.ss.android.socialbase.downloader.downloader.c.T().a(new c.a.InterfaceC0111a() { // from class: com.ss.android.socialbase.downloader.impls.d.2
                @Override // com.ss.android.socialbase.downloader.downloader.c.a.InterfaceC0111a
                public void a() {
                    d.this.f3772b = new com.ss.android.socialbase.downloader.b.e();
                }
            });
        } else {
            this.f3772b = new com.ss.android.socialbase.downloader.b.e();
        }
        this.f3773c = false;
        this.f3776f = new com.ss.android.socialbase.downloader.h.h(Looper.getMainLooper(), this.f3775e);
        g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        synchronized (this) {
            this.f3773c = true;
            notifyAll();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public List<DownloadInfo> c(String str) {
        return this.a.c(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public boolean d() {
        return this.f3773c;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public boolean e() {
        if (this.f3773c) {
            return true;
        }
        synchronized (this) {
            if (!this.f3773c) {
                com.ss.android.socialbase.downloader.c.a.d("DefaultDownloadCache", "ensureDownloadCacheSyncSuccess: waiting start!!!!");
                try {
                    wait(FocusMeteringAction.DEFAULT_AUTOCANCEL_DURATION);
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
                com.ss.android.socialbase.downloader.c.a.d("DefaultDownloadCache", "ensureDownloadCacheSyncSuccess: waiting end!!!!");
            }
        }
        return this.f3773c;
    }

    public t f() {
        return this.f3772b;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public DownloadInfo g(int i2) {
        DownloadInfo downloadInfoG = this.a.g(i2);
        c(downloadInfoG);
        return downloadInfoG;
    }

    public void h() {
        this.f3776f.sendMessageDelayed(this.f3776f.obtainMessage(1), com.ss.android.socialbase.downloader.g.a.c().a("task_resume_delay") ? 4000L : Build.VERSION.SDK_INT >= 23 ? 1000L : FocusMeteringAction.DEFAULT_AUTOCANCEL_DURATION);
    }

    public void i() {
        List<String> listA;
        ArrayList arrayList;
        DownloadInfo downloadInfo;
        DownloadInfo downloadInfo2;
        if (this.f3773c) {
            if (this.f3774d) {
                com.ss.android.socialbase.downloader.c.a.b("DefaultDownloadCache", "resumeUnCompleteTask: has resumed, return!!!");
                return;
            }
            this.f3774d = true;
            if (com.ss.android.socialbase.downloader.i.f.a()) {
                com.ss.android.socialbase.downloader.downloader.l lVarW = com.ss.android.socialbase.downloader.downloader.c.w();
                if (lVarW != null) {
                    listA = lVarW.a();
                    arrayList = (listA == null || listA.isEmpty()) ? null : new ArrayList();
                } else {
                    listA = null;
                    arrayList = null;
                }
                SparseArray sparseArray = new SparseArray();
                synchronized (this) {
                    SparseArray<DownloadInfo> sparseArrayA = this.a.a();
                    for (int i2 = 0; i2 < sparseArrayA.size(); i2++) {
                        int iKeyAt = sparseArrayA.keyAt(i2);
                        if (iKeyAt != 0 && (downloadInfo2 = sparseArrayA.get(iKeyAt)) != null) {
                            sparseArray.put(iKeyAt, downloadInfo2);
                        }
                    }
                }
                if (sparseArray.size() == 0) {
                    return;
                }
                for (int i3 = 0; i3 < sparseArray.size(); i3++) {
                    int iKeyAt2 = sparseArray.keyAt(i3);
                    if (iKeyAt2 != 0 && (downloadInfo = (DownloadInfo) sparseArray.get(iKeyAt2)) != null) {
                        int realStatus = downloadInfo.getRealStatus();
                        int statusAtDbInit = downloadInfo.getStatusAtDbInit();
                        if (statusAtDbInit >= 1 && statusAtDbInit <= 11) {
                            com.ss.android.socialbase.downloader.d.a.a(com.ss.android.socialbase.downloader.downloader.c.g(), downloadInfo, (BaseException) null, -5);
                        }
                        if (listA != null && arrayList != null && downloadInfo.getMimeType() != null && listA.contains(downloadInfo.getMimeType()) && (com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId()).b("enable_notification_ui") >= 2 || realStatus != -2 || downloadInfo.isPauseReserveOnWifi())) {
                            downloadInfo.setDownloadFromReserveWifi(false);
                            arrayList.add(downloadInfo);
                        }
                    }
                }
                if (lVarW == null || arrayList == null || arrayList.isEmpty()) {
                    return;
                }
                lVarW.a(arrayList, 1);
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public Map<Long, com.ss.android.socialbase.downloader.f.i> l(int i2) {
        Map<Long, com.ss.android.socialbase.downloader.f.i> mapL = this.a.l(i2);
        if (mapL != null && !mapL.isEmpty()) {
            return mapL;
        }
        Map<Long, com.ss.android.socialbase.downloader.f.i> mapL2 = this.f3772b.l(i2);
        this.a.a(i2, mapL2);
        return mapL2;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public void m(int i2) {
        this.a.m(i2);
        this.f3772b.m(i2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public List<com.ss.android.socialbase.downloader.f.i> n(int i2) {
        List<com.ss.android.socialbase.downloader.f.i> listN = this.a.n(i2);
        return (listN == null || listN.size() == 0) ? this.f3772b.n(i2) : listN;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public DownloadInfo b(int i2) {
        return this.a.b(i2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public List<com.ss.android.socialbase.downloader.model.b> c(int i2) {
        return this.a.c(i2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public List<DownloadInfo> d(String str) {
        return this.a.d(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public boolean f(int i2) {
        com.ss.android.socialbase.downloader.downloader.m mVarA;
        if (!com.ss.android.socialbase.downloader.i.f.b() || (mVarA = l.a(true)) == null) {
            this.f3772b.f(i2);
        } else {
            mVarA.p(i2);
        }
        return this.a.f(i2);
    }

    public k a() {
        return this.a;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public List<DownloadInfo> b(String str) {
        return this.a.b(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public void c() {
        try {
            this.a.c();
        } catch (SQLiteException e2) {
            e2.printStackTrace();
        }
        if (com.ss.android.socialbase.downloader.i.f.b()) {
            com.ss.android.socialbase.downloader.downloader.m mVarA = l.a(true);
            if (mVarA != null) {
                mVarA.f();
                return;
            } else {
                this.f3772b.c();
                return;
            }
        }
        this.f3772b.c();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public void d(int i2) {
        this.a.d(i2);
        if (com.ss.android.socialbase.downloader.i.f.b()) {
            com.ss.android.socialbase.downloader.downloader.m mVarA = l.a(true);
            if (mVarA != null) {
                mVarA.o(i2);
                return;
            } else {
                this.f3772b.d(i2);
                return;
            }
        }
        this.f3772b.d(i2);
    }

    public void g() {
        List<com.ss.android.socialbase.downloader.model.b> list;
        DownloadInfo downloadInfo;
        com.ss.android.socialbase.downloader.downloader.c.a(com.ss.android.socialbase.downloader.constants.d.SYNC_START);
        final SparseArray<DownloadInfo> sparseArray = new SparseArray<>();
        final SparseArray<List<com.ss.android.socialbase.downloader.model.b>> sparseArray2 = new SparseArray<>();
        synchronized (this.a) {
            SparseArray<DownloadInfo> sparseArrayA = this.a.a();
            for (int i2 = 0; i2 < sparseArrayA.size(); i2++) {
                int iKeyAt = sparseArrayA.keyAt(i2);
                if (iKeyAt != 0 && (downloadInfo = sparseArrayA.get(iKeyAt)) != null) {
                    sparseArray.put(iKeyAt, downloadInfo);
                }
            }
            SparseArray<List<com.ss.android.socialbase.downloader.model.b>> sparseArrayF = this.a.f();
            for (int i3 = 0; i3 < sparseArrayF.size(); i3++) {
                int iKeyAt2 = sparseArrayF.keyAt(i3);
                if (iKeyAt2 != 0 && (list = sparseArrayF.get(iKeyAt2)) != null) {
                    sparseArray2.put(iKeyAt2, new CopyOnWriteArrayList(list));
                }
            }
        }
        this.f3772b.a(sparseArray, sparseArray2, new com.ss.android.socialbase.downloader.b.d() { // from class: com.ss.android.socialbase.downloader.impls.d.3
            @Override // com.ss.android.socialbase.downloader.b.d
            public void a() {
                synchronized (d.this.a) {
                    SparseArray<DownloadInfo> sparseArrayA2 = d.this.a.a();
                    if (sparseArray != null) {
                        for (int i4 = 0; i4 < sparseArray.size(); i4++) {
                            int iKeyAt3 = sparseArray.keyAt(i4);
                            if (iKeyAt3 != 0) {
                                sparseArrayA2.put(iKeyAt3, (DownloadInfo) sparseArray.get(iKeyAt3));
                            }
                        }
                    }
                    SparseArray<List<com.ss.android.socialbase.downloader.model.b>> sparseArrayF2 = d.this.a.f();
                    if (sparseArray2 != null) {
                        for (int i5 = 0; i5 < sparseArray2.size(); i5++) {
                            int iKeyAt4 = sparseArray2.keyAt(i5);
                            if (iKeyAt4 != 0) {
                                sparseArrayF2.put(iKeyAt4, (List) sparseArray2.get(iKeyAt4));
                            }
                        }
                    }
                }
                d.this.j();
                d.this.h();
                com.ss.android.socialbase.downloader.downloader.c.a(com.ss.android.socialbase.downloader.constants.d.SYNC_SUCCESS);
            }
        });
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public List<DownloadInfo> a(String str) {
        return this.a.a(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public List<DownloadInfo> b() {
        return this.a.b();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public void a(com.ss.android.socialbase.downloader.model.b bVar) {
        synchronized (this.a) {
            this.a.a(bVar);
        }
        if (com.ss.android.socialbase.downloader.i.f.b()) {
            com.ss.android.socialbase.downloader.downloader.m mVarA = l.a(true);
            if (mVarA != null) {
                mVarA.a(bVar);
                return;
            } else {
                this.f3772b.a(bVar);
                return;
            }
        }
        this.f3772b.a(bVar);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public void b(com.ss.android.socialbase.downloader.model.b bVar) {
        if (com.ss.android.socialbase.downloader.i.f.b()) {
            com.ss.android.socialbase.downloader.downloader.m mVarA = l.a(true);
            if (mVarA != null) {
                mVarA.a(bVar);
                return;
            } else {
                this.f3772b.a(bVar);
                return;
            }
        }
        this.f3772b.a(bVar);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public DownloadInfo h(int i2) {
        DownloadInfo downloadInfoH = this.a.h(i2);
        c(downloadInfoH);
        return downloadInfoH;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public DownloadInfo j(int i2) {
        DownloadInfo downloadInfoJ = this.a.j(i2);
        c(downloadInfoJ);
        return downloadInfoJ;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public DownloadInfo d(int i2, long j2) {
        DownloadInfo downloadInfoD = this.a.d(i2, j2);
        b(i2, (List<com.ss.android.socialbase.downloader.model.b>) null);
        return downloadInfoD;
    }

    private void c(DownloadInfo downloadInfo) {
        a(downloadInfo, true);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public DownloadInfo b(int i2, long j2) {
        DownloadInfo downloadInfoB = this.a.b(i2, j2);
        b(i2, (List<com.ss.android.socialbase.downloader.model.b>) null);
        return downloadInfoB;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public DownloadInfo c(int i2, long j2) {
        DownloadInfo downloadInfoC = this.a.c(i2, j2);
        b(i2, (List<com.ss.android.socialbase.downloader.model.b>) null);
        return downloadInfoC;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public boolean e(int i2) {
        com.ss.android.socialbase.downloader.downloader.m mVarA;
        try {
            if (com.ss.android.socialbase.downloader.i.f.b() && (mVarA = l.a(true)) != null) {
                mVarA.n(i2);
            } else {
                this.f3772b.e(i2);
            }
        } catch (SQLiteException e2) {
            e2.printStackTrace();
        }
        return this.a.e(i2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public void b(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return;
        }
        this.a.a(downloadInfo);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public void b(int i2, List<com.ss.android.socialbase.downloader.model.b> list) {
        try {
            a(this.a.b(i2));
            if (list == null) {
                list = this.a.c(i2);
            }
            if (com.ss.android.socialbase.downloader.i.f.b()) {
                com.ss.android.socialbase.downloader.downloader.m mVarA = l.a(true);
                if (mVarA != null) {
                    mVarA.b(i2, list);
                    return;
                } else {
                    this.f3772b.b(i2, list);
                    return;
                }
            }
            this.f3772b.b(i2, list);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public void a(int i2, int i3, long j2) {
        this.a.a(i2, i3, j2);
        if (com.ss.android.socialbase.downloader.i.f.b()) {
            com.ss.android.socialbase.downloader.downloader.m mVarA = l.a(true);
            if (mVarA != null) {
                mVarA.a(i2, i3, j2);
                return;
            } else {
                this.f3772b.a(i2, i3, j2);
                return;
            }
        }
        this.f3772b.a(i2, i3, j2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public void a(int i2, int i3, int i4, long j2) {
        if (com.ss.android.socialbase.downloader.i.f.b()) {
            com.ss.android.socialbase.downloader.downloader.m mVarA = l.a(true);
            if (mVarA != null) {
                mVarA.a(i2, i3, i4, j2);
                return;
            } else {
                this.f3772b.a(i2, i3, i4, j2);
                return;
            }
        }
        this.f3772b.a(i2, i3, i4, j2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public void a(int i2, int i3, int i4, int i5) {
        if (com.ss.android.socialbase.downloader.i.f.b()) {
            com.ss.android.socialbase.downloader.downloader.m mVarA = l.a(true);
            if (mVarA != null) {
                mVarA.a(i2, i3, i4, i5);
                return;
            } else {
                this.f3772b.a(i2, i3, i4, i5);
                return;
            }
        }
        this.f3772b.a(i2, i3, i4, i5);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public DownloadInfo a(int i2, int i3) {
        DownloadInfo downloadInfoA = this.a.a(i2, i3);
        c(downloadInfoA);
        return downloadInfoA;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public boolean a(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return false;
        }
        boolean zA = this.a.a(downloadInfo);
        c(downloadInfo);
        return zA;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public DownloadInfo a(int i2, long j2, String str, String str2) {
        DownloadInfo downloadInfoA = this.a.a(i2, j2, str, str2);
        c(downloadInfoA);
        return downloadInfoA;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public DownloadInfo i(int i2) {
        DownloadInfo downloadInfoI = this.a.i(i2);
        c(downloadInfoI);
        return downloadInfoI;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public DownloadInfo a(int i2, long j2) {
        DownloadInfo downloadInfoA = this.a.a(i2, j2);
        a(downloadInfoA, false);
        return downloadInfoA;
    }

    private void a(DownloadInfo downloadInfo, boolean z) {
        if (downloadInfo == null) {
            return;
        }
        if (!com.ss.android.socialbase.downloader.i.f.b()) {
            this.f3772b.a(downloadInfo);
            return;
        }
        if (z) {
            com.ss.android.socialbase.downloader.downloader.m mVarA = l.a(true);
            if (mVarA != null) {
                mVarA.c(downloadInfo);
            } else {
                this.f3772b.a(downloadInfo);
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public void a(int i2, List<com.ss.android.socialbase.downloader.model.b> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        this.a.a(i2, list);
        if (com.ss.android.socialbase.downloader.i.f.c()) {
            this.f3772b.b(i2, list);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public boolean a(int i2, Map<Long, com.ss.android.socialbase.downloader.f.i> map) {
        this.a.a(i2, map);
        this.f3772b.a(i2, map);
        return false;
    }
}

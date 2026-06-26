package com.ss.android.socialbase.downloader.downloader;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.util.SparseArray;
import androidx.core.view.PointerIconCompat;
import com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.ac;
import com.ss.android.socialbase.downloader.depend.af;
import com.ss.android.socialbase.downloader.depend.z;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.impls.DownloadHandleService;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: DownloadProcessDispatcher.java */
/* JADX INFO: loaded from: classes.dex */
public class d {
    private static volatile d a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile SparseArray<Boolean> f3566b = new SparseArray<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Handler f3567c = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile List<ac> f3568d = new ArrayList();

    public static d a() {
        if (a == null) {
            synchronized (d.class) {
                a = new d();
            }
        }
        return a;
    }

    public void b(ac acVar) {
        if (acVar == null) {
            return;
        }
        synchronized (this.f3568d) {
            if (this.f3568d.contains(acVar)) {
                this.f3568d.remove(acVar);
            }
        }
    }

    public m c(int i2) {
        return com.ss.android.socialbase.downloader.impls.l.a(a(i2) == 1 && !com.ss.android.socialbase.downloader.i.f.c());
    }

    public void d(int i2) {
        m mVarC = c(i2);
        if (mVarC == null) {
            return;
        }
        mVarC.a(i2);
    }

    public boolean e(int i2) {
        m mVarC = c(i2);
        if (mVarC == null) {
            return false;
        }
        return mVarC.b(i2);
    }

    public void f(int i2) {
        m mVarC = c(i2);
        if (mVarC == null) {
            return;
        }
        mVarC.c(i2);
    }

    public void g(int i2) {
        m mVarC = c(i2);
        if (mVarC == null) {
            return;
        }
        mVarC.d(i2);
    }

    public long h(int i2) {
        m mVarC = c(i2);
        if (mVarC == null) {
            return 0L;
        }
        return mVarC.e(i2);
    }

    public int i(int i2) {
        m mVarC = c(i2);
        if (mVarC == null) {
            return 0;
        }
        return mVarC.f(i2);
    }

    public boolean j(int i2) {
        m mVarC = c(i2);
        if (mVarC == null) {
            return false;
        }
        return mVarC.g(i2);
    }

    public DownloadInfo k(int i2) {
        m mVarC = c(i2);
        if (mVarC == null) {
            return null;
        }
        return mVarC.h(i2);
    }

    public z l(int i2) {
        m mVarC = c(i2);
        if (mVarC == null) {
            return null;
        }
        return mVarC.q(i2);
    }

    public af m(int i2) {
        m mVarC = c(i2);
        if (mVarC == null) {
            return null;
        }
        return mVarC.r(i2);
    }

    public void n(int i2) {
        m mVarC = c(i2);
        if (mVarC == null) {
            return;
        }
        mVarC.j(i2);
    }

    public boolean o(int i2) {
        m mVarC = c(i2);
        if (mVarC == null) {
            return false;
        }
        return mVarC.l(i2);
    }

    public void p(int i2) {
        m mVarA = com.ss.android.socialbase.downloader.impls.l.a(false);
        if (mVarA != null) {
            mVarA.k(i2);
        }
        m mVarA2 = com.ss.android.socialbase.downloader.impls.l.a(true);
        if (mVarA2 != null) {
            mVarA2.k(i2);
        }
    }

    public void q(int i2) {
        if (i2 == 0) {
            return;
        }
        b(i2, true);
        m mVarA = com.ss.android.socialbase.downloader.impls.l.a(true);
        if (mVarA == null) {
            return;
        }
        mVarA.startService();
    }

    public IDownloadFileUriProvider r(int i2) {
        m mVarC = c(i2);
        if (mVarC == null) {
            return null;
        }
        return mVarC.s(i2);
    }

    public void c(int i2, boolean z) {
        if (!com.ss.android.socialbase.downloader.i.f.a()) {
            m mVarC = c(i2);
            if (mVarC != null) {
                mVarC.a(i2, z);
            }
            com.ss.android.socialbase.downloader.impls.l.a(true).a(2, i2);
            return;
        }
        if (com.ss.android.socialbase.downloader.i.a.a(8388608)) {
            m mVarA = com.ss.android.socialbase.downloader.impls.l.a(true);
            if (mVarA != null) {
                mVarA.a(i2, z);
            }
            m mVarA2 = com.ss.android.socialbase.downloader.impls.l.a(false);
            if (mVarA2 != null) {
                mVarA2.a(i2, z);
                return;
            }
            return;
        }
        m mVarA3 = com.ss.android.socialbase.downloader.impls.l.a(false);
        if (mVarA3 != null) {
            mVarA3.a(i2, z);
        }
        m mVarA4 = com.ss.android.socialbase.downloader.impls.l.a(true);
        if (mVarA4 != null) {
            mVarA4.a(i2, z);
        }
    }

    public void d(int i2, boolean z) {
        m mVarC = c(i2);
        if (mVarC == null) {
            return;
        }
        mVarC.b(i2, z);
    }

    public List<DownloadInfo> e(String str) {
        SparseArray<DownloadInfo> sparseArray = new SparseArray<>();
        m mVarA = com.ss.android.socialbase.downloader.impls.l.a(false);
        List<DownloadInfo> listE = mVarA != null ? mVarA.e(str) : null;
        m mVarA2 = com.ss.android.socialbase.downloader.impls.l.a(true);
        return a(listE, mVarA2 != null ? mVarA2.e(str) : null, sparseArray);
    }

    public boolean f() {
        m mVarA = com.ss.android.socialbase.downloader.impls.l.a(false);
        if (mVarA != null) {
            return mVarA.e();
        }
        return false;
    }

    public void b() {
        synchronized (this.f3568d) {
            for (ac acVar : this.f3568d) {
                if (acVar != null) {
                    acVar.a();
                }
            }
        }
    }

    public boolean d() {
        return c.O();
    }

    public void a(ac acVar) {
        if (acVar == null) {
            return;
        }
        if (com.ss.android.socialbase.downloader.i.f.c()) {
            acVar.a();
            return;
        }
        if (com.ss.android.socialbase.downloader.impls.l.a(true).g()) {
            acVar.a();
        }
        synchronized (this.f3568d) {
            if (!this.f3568d.contains(acVar)) {
                this.f3568d.add(acVar);
            }
        }
    }

    public List<DownloadInfo> d(String str) {
        SparseArray<DownloadInfo> sparseArray = new SparseArray<>();
        m mVarA = com.ss.android.socialbase.downloader.impls.l.a(false);
        List<DownloadInfo> listD = mVarA != null ? mVarA.d(str) : null;
        m mVarA2 = com.ss.android.socialbase.downloader.impls.l.a(true);
        return a(listD, mVarA2 != null ? mVarA2.d(str) : null, sparseArray);
    }

    public List<DownloadInfo> e() {
        SparseArray<DownloadInfo> sparseArray = new SparseArray<>();
        m mVarA = com.ss.android.socialbase.downloader.impls.l.a(false);
        List<DownloadInfo> listD = mVarA != null ? mVarA.d() : null;
        m mVarA2 = com.ss.android.socialbase.downloader.impls.l.a(true);
        return a(listD, mVarA2 != null ? mVarA2.d() : null, sparseArray);
    }

    public synchronized void b(int i2, boolean z) {
        this.f3566b.put(i2, z ? Boolean.TRUE : Boolean.FALSE);
    }

    public synchronized int b(int i2) {
        if (this.f3566b.get(i2) == null) {
            return -1;
        }
        return this.f3566b.get(i2).booleanValue() ? 1 : 0;
    }

    public void a(int i2, boolean z) {
        b(i2, z);
        if (c.S() && !com.ss.android.socialbase.downloader.i.f.c() && com.ss.android.socialbase.downloader.impls.l.a(true).g()) {
            com.ss.android.socialbase.downloader.impls.l.a(true).c(i2, z);
        }
        if (c.c() || com.ss.android.socialbase.downloader.i.f.c() || com.ss.android.socialbase.downloader.i.f.a()) {
            return;
        }
        try {
            Intent intent = new Intent(c.N(), (Class<?>) DownloadHandleService.class);
            intent.setAction("com.ss.android.downloader.action.PROCESS_NOTIFY");
            intent.putExtra("extra_download_id", i2);
            c.N().startService(intent);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void c() {
        m mVarA = com.ss.android.socialbase.downloader.impls.l.a(false);
        if (mVarA != null) {
            mVarA.a();
        }
        m mVarA2 = com.ss.android.socialbase.downloader.impls.l.a(true);
        if (mVarA2 != null) {
            mVarA2.a();
        }
    }

    private m b(DownloadTask downloadTask) {
        DownloadInfo downloadInfo;
        List<com.ss.android.socialbase.downloader.model.b> listI;
        if (downloadTask == null || (downloadInfo = downloadTask.getDownloadInfo()) == null) {
            return null;
        }
        boolean zIsNeedIndependentProcess = downloadInfo.isNeedIndependentProcess();
        if (com.ss.android.socialbase.downloader.i.f.c() || !com.ss.android.socialbase.downloader.i.f.a()) {
            zIsNeedIndependentProcess = true;
        }
        int iA = a(downloadInfo.getId());
        if (iA >= 0 && iA != zIsNeedIndependentProcess) {
            try {
                if (iA == 1) {
                    if (com.ss.android.socialbase.downloader.i.f.a()) {
                        com.ss.android.socialbase.downloader.impls.l.a(true).a(downloadInfo.getId());
                        DownloadInfo downloadInfoH = com.ss.android.socialbase.downloader.impls.l.a(true).h(downloadInfo.getId());
                        if (downloadInfoH != null) {
                            com.ss.android.socialbase.downloader.impls.l.a(false).b(downloadInfoH);
                        }
                        if (downloadInfoH.getChunkCount() > 1 && (listI = com.ss.android.socialbase.downloader.impls.l.a(true).i(downloadInfo.getId())) != null) {
                            com.ss.android.socialbase.downloader.impls.l.a(false).a(downloadInfo.getId(), com.ss.android.socialbase.downloader.i.f.a(listI));
                        }
                    }
                } else if (com.ss.android.socialbase.downloader.i.f.a()) {
                    com.ss.android.socialbase.downloader.impls.l.a(false).a(downloadInfo.getId());
                    List<com.ss.android.socialbase.downloader.model.b> listI2 = com.ss.android.socialbase.downloader.impls.l.a(false).i(downloadInfo.getId());
                    if (listI2 != null) {
                        com.ss.android.socialbase.downloader.impls.l.a(true).a(downloadInfo.getId(), com.ss.android.socialbase.downloader.i.f.a(listI2));
                    }
                } else {
                    downloadTask.setNeedDelayForCacheSync(true);
                    com.ss.android.socialbase.downloader.impls.l.a(true).a(1, downloadInfo.getId());
                }
            } catch (Throwable unused) {
            }
        }
        a(downloadInfo.getId(), zIsNeedIndependentProcess);
        return com.ss.android.socialbase.downloader.impls.l.a(zIsNeedIndependentProcess);
    }

    public List<DownloadInfo> c(String str) {
        SparseArray<DownloadInfo> sparseArray = new SparseArray<>();
        m mVarA = com.ss.android.socialbase.downloader.impls.l.a(false);
        List<DownloadInfo> listC = mVarA != null ? mVarA.c(str) : null;
        m mVarA2 = com.ss.android.socialbase.downloader.impls.l.a(true);
        return a(listC, mVarA2 != null ? mVarA2.c(str) : null, sparseArray);
    }

    public int a(int i2) {
        if (!c.S()) {
            return -1;
        }
        if (!com.ss.android.socialbase.downloader.i.f.c() && com.ss.android.socialbase.downloader.impls.l.a(true).g()) {
            return com.ss.android.socialbase.downloader.impls.l.a(true).m(i2);
        }
        return b(i2);
    }

    public int a(String str, String str2) {
        return c.a(str, str2);
    }

    public List<DownloadInfo> a(String str) {
        List<DownloadInfo> listA = com.ss.android.socialbase.downloader.impls.l.a(false).a(str);
        List<DownloadInfo> listA2 = com.ss.android.socialbase.downloader.impls.l.a(true).a(str);
        if (listA == null && listA2 == null) {
            return null;
        }
        if (listA == null || listA2 == null) {
            return listA != null ? listA : listA2;
        }
        ArrayList arrayList = new ArrayList(listA);
        arrayList.addAll(listA2);
        return arrayList;
    }

    public void a(int i2, z zVar) {
        m mVarC = c(i2);
        if (mVarC == null) {
            return;
        }
        mVarC.a(i2, zVar);
    }

    private List<DownloadInfo> a(List<DownloadInfo> list, List<DownloadInfo> list2, SparseArray<DownloadInfo> sparseArray) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (DownloadInfo downloadInfo : list) {
                if (downloadInfo != null && sparseArray.get(downloadInfo.getId()) == null) {
                    sparseArray.put(downloadInfo.getId(), downloadInfo);
                }
            }
        }
        if (list2 != null) {
            for (DownloadInfo downloadInfo2 : list2) {
                if (downloadInfo2 != null && sparseArray.get(downloadInfo2.getId()) == null) {
                    sparseArray.put(downloadInfo2.getId(), downloadInfo2);
                }
            }
        }
        for (int i2 = 0; i2 < sparseArray.size(); i2++) {
            arrayList.add(sparseArray.get(sparseArray.keyAt(i2)));
        }
        return arrayList;
    }

    public DownloadInfo b(String str, String str2) {
        int iA = a(str, str2);
        m mVarC = c(iA);
        if (mVarC == null) {
            return null;
        }
        return mVarC.h(iA);
    }

    public List<DownloadInfo> b(String str) {
        SparseArray<DownloadInfo> sparseArray = new SparseArray<>();
        m mVarA = com.ss.android.socialbase.downloader.impls.l.a(false);
        List<DownloadInfo> listB = mVarA != null ? mVarA.b(str) : null;
        m mVarA2 = com.ss.android.socialbase.downloader.impls.l.a(true);
        return a(listB, mVarA2 != null ? mVarA2.b(str) : null, sparseArray);
    }

    public void a(List<String> list) {
        m mVarA = com.ss.android.socialbase.downloader.impls.l.a(false);
        if (mVarA != null) {
            mVarA.a(list);
        }
        m mVarA2 = com.ss.android.socialbase.downloader.impls.l.a(true);
        if (mVarA2 != null) {
            mVarA2.a(list);
        }
    }

    public void b(List<String> list) {
        m mVarA = com.ss.android.socialbase.downloader.impls.l.a(false);
        if (mVarA != null) {
            mVarA.b(list);
        }
        m mVarA2 = com.ss.android.socialbase.downloader.impls.l.a(true);
        if (mVarA2 != null) {
            mVarA2.b(list);
        }
    }

    public void a(int i2, IDownloadListener iDownloadListener, com.ss.android.socialbase.downloader.constants.f fVar, boolean z) {
        m mVarC = c(i2);
        if (mVarC == null) {
            return;
        }
        mVarC.b(i2, iDownloadListener == null ? 0 : iDownloadListener.hashCode(), iDownloadListener, fVar, z);
    }

    public void b(int i2, IDownloadListener iDownloadListener, com.ss.android.socialbase.downloader.constants.f fVar, boolean z) {
        m mVarC = c(i2);
        if (mVarC == null) {
            return;
        }
        mVarC.a(i2, iDownloadListener.hashCode(), iDownloadListener, fVar, z);
    }

    public void a(int i2, IDownloadListener iDownloadListener, com.ss.android.socialbase.downloader.constants.f fVar, boolean z, boolean z2) {
        m mVarC = c(i2);
        if (mVarC == null) {
            return;
        }
        mVarC.a(i2, iDownloadListener.hashCode(), iDownloadListener, fVar, z, z2);
    }

    public void b(com.ss.android.socialbase.downloader.depend.k kVar) {
        c.b(kVar);
    }

    public boolean a(DownloadInfo downloadInfo) {
        m mVarC;
        if (downloadInfo == null || (mVarC = c(downloadInfo.getId())) == null) {
            return false;
        }
        return mVarC.a(downloadInfo);
    }

    public void a(final DownloadTask downloadTask) {
        final m mVarB = b(downloadTask);
        if (mVarB == null) {
            if (downloadTask != null) {
                com.ss.android.socialbase.downloader.d.a.a(downloadTask.getMonitorDepend(), downloadTask.getDownloadInfo(), new BaseException(PointerIconCompat.TYPE_HELP, "tryDownload but getDownloadHandler failed"), downloadTask.getDownloadInfo() != null ? downloadTask.getDownloadInfo().getStatus() : 0);
            }
        } else if (downloadTask.isNeedDelayForCacheSync()) {
            this.f3567c.postDelayed(new Runnable() { // from class: com.ss.android.socialbase.downloader.downloader.d.1
                @Override // java.lang.Runnable
                public void run() {
                    mVarB.a(downloadTask);
                }
            }, 500L);
        } else {
            mVarB.a(downloadTask);
        }
    }

    public void a(com.ss.android.socialbase.downloader.depend.k kVar) {
        c.a(kVar);
    }

    public void a(int i2, long j2) {
        m mVarC = c(i2);
        if (mVarC == null) {
            return;
        }
        mVarC.a(i2, j2);
    }
}

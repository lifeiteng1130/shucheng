package com.ss.android.socialbase.downloader.impls;

import android.text.TextUtils;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.constants.DownloadStatus;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: DownloadCache.java */
/* JADX INFO: loaded from: classes.dex */
public class k implements com.ss.android.socialbase.downloader.downloader.j {
    private final SparseArray<DownloadInfo> a = new SparseArray<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final SparseArray<List<com.ss.android.socialbase.downloader.model.b>> f3789b = new SparseArray<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final SparseArray<Map<Long, com.ss.android.socialbase.downloader.f.i>> f3790c = new SparseArray<>();

    public SparseArray<DownloadInfo> a() {
        return this.a;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public void a(int i2, int i3, int i4, int i5) {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public synchronized DownloadInfo b(int i2) {
        DownloadInfo downloadInfo;
        try {
            downloadInfo = this.a.get(i2);
        } catch (Exception e2) {
            e2.printStackTrace();
            downloadInfo = null;
        }
        return downloadInfo;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public void b(int i2, List<com.ss.android.socialbase.downloader.model.b> list) {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public void b(com.ss.android.socialbase.downloader.model.b bVar) {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public synchronized List<DownloadInfo> c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (this.a.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < this.a.size(); i2++) {
            DownloadInfo downloadInfo = this.a.get(this.a.keyAt(i2));
            if (downloadInfo != null && !TextUtils.isEmpty(downloadInfo.getMimeType()) && downloadInfo.getMimeType().equals(str) && downloadInfo.getStatus() == -3) {
                arrayList.add(downloadInfo);
            }
        }
        return arrayList;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public synchronized List<DownloadInfo> d(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (this.a.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < this.a.size(); i2++) {
            DownloadInfo downloadInfo = this.a.get(this.a.keyAt(i2));
            if (downloadInfo != null && !TextUtils.isEmpty(downloadInfo.getMimeType()) && downloadInfo.getMimeType().equals(str) && DownloadStatus.isUnCompletedStatus(downloadInfo.getStatus())) {
                arrayList.add(downloadInfo);
            }
        }
        return arrayList;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public boolean d() {
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public boolean e() {
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public synchronized boolean e(int i2) {
        this.a.remove(i2);
        return true;
    }

    public SparseArray<List<com.ss.android.socialbase.downloader.model.b>> f() {
        return this.f3789b;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public DownloadInfo g(int i2) {
        DownloadInfo downloadInfoB = b(i2);
        if (downloadInfoB != null) {
            downloadInfoB.setStatus(2);
        }
        return downloadInfoB;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public DownloadInfo h(int i2) {
        DownloadInfo downloadInfoB = b(i2);
        if (downloadInfoB != null) {
            downloadInfoB.setStatus(5);
            downloadInfoB.setFirstDownload(false);
        }
        return downloadInfoB;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public DownloadInfo i(int i2) {
        DownloadInfo downloadInfoB = b(i2);
        if (downloadInfoB != null) {
            downloadInfoB.setStatus(1);
        }
        return downloadInfoB;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public DownloadInfo j(int i2) {
        DownloadInfo downloadInfoB = b(i2);
        if (downloadInfoB != null) {
            downloadInfoB.setStatus(-7);
        }
        return downloadInfoB;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public synchronized Map<Long, com.ss.android.socialbase.downloader.f.i> l(int i2) {
        return this.f3790c.get(i2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public synchronized void m(int i2) {
        this.f3790c.remove(i2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public synchronized List<com.ss.android.socialbase.downloader.f.i> n(int i2) {
        Map<Long, com.ss.android.socialbase.downloader.f.i> map = this.f3790c.get(i2);
        if (map != null && !map.isEmpty()) {
            return new ArrayList(map.values());
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public synchronized List<DownloadInfo> a(String str) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        try {
            int size = this.a.size();
            for (int i2 = 0; i2 < size; i2++) {
                DownloadInfo downloadInfoValueAt = this.a.valueAt(i2);
                if (str != null && str.equals(downloadInfoValueAt.getUrl())) {
                    arrayList.add(downloadInfoValueAt);
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return arrayList;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public boolean f(int i2) {
        e(i2);
        d(i2);
        m(i2);
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public synchronized List<DownloadInfo> b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (this.a.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < this.a.size(); i2++) {
            DownloadInfo downloadInfo = this.a.get(this.a.keyAt(i2));
            if (downloadInfo != null && !TextUtils.isEmpty(downloadInfo.getMimeType()) && downloadInfo.getMimeType().equals(str) && DownloadStatus.isFailedStatus(downloadInfo.getStatus())) {
                arrayList.add(downloadInfo);
            }
        }
        return arrayList;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public void a(com.ss.android.socialbase.downloader.model.b bVar) {
        int iK = bVar.k();
        List<com.ss.android.socialbase.downloader.model.b> arrayList = this.f3789b.get(iK);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            this.f3789b.put(iK, arrayList);
        }
        arrayList.add(bVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0021, code lost:
    
        r0.b(r5);
     */
    @Override // com.ss.android.socialbase.downloader.downloader.j
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized void a(int r3, int r4, long r5) {
        /*
            r2 = this;
            monitor-enter(r2)
            java.util.List r3 = r2.c(r3)     // Catch: java.lang.Throwable -> L26
            if (r3 != 0) goto L9
            monitor-exit(r2)
            return
        L9:
            java.util.Iterator r3 = r3.iterator()     // Catch: java.lang.Throwable -> L26
        Ld:
            boolean r0 = r3.hasNext()     // Catch: java.lang.Throwable -> L26
            if (r0 == 0) goto L24
            java.lang.Object r0 = r3.next()     // Catch: java.lang.Throwable -> L26
            com.ss.android.socialbase.downloader.model.b r0 = (com.ss.android.socialbase.downloader.model.b) r0     // Catch: java.lang.Throwable -> L26
            if (r0 == 0) goto Ld
            int r1 = r0.s()     // Catch: java.lang.Throwable -> L26
            if (r1 != r4) goto Ld
            r0.b(r5)     // Catch: java.lang.Throwable -> L26
        L24:
            monitor-exit(r2)
            return
        L26:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.impls.k.a(int, int, long):void");
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public synchronized List<com.ss.android.socialbase.downloader.model.b> c(int i2) {
        return this.f3789b.get(i2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public synchronized void d(int i2) {
        this.f3789b.remove(i2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public synchronized void c() {
        this.a.clear();
        this.f3789b.clear();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public DownloadInfo d(int i2, long j2) {
        DownloadInfo downloadInfoB = b(i2);
        if (downloadInfoB != null) {
            downloadInfoB.setCurBytes(j2, false);
            downloadInfoB.setStatus(-2);
        }
        return downloadInfoB;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public synchronized List<DownloadInfo> b() {
        if (this.a.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList(this.a.size());
        for (int i2 = 0; i2 < this.a.size(); i2++) {
            DownloadInfo downloadInfoValueAt = this.a.valueAt(i2);
            if (downloadInfoValueAt != null) {
                arrayList.add(downloadInfoValueAt);
            }
        }
        return arrayList;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public DownloadInfo c(int i2, long j2) {
        DownloadInfo downloadInfoB = b(i2);
        if (downloadInfoB != null) {
            downloadInfoB.setCurBytes(j2, false);
            downloadInfoB.setStatus(-3);
            downloadInfoB.setFirstDownload(false);
            downloadInfoB.setFirstSuccess(false);
        }
        return downloadInfoB;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x002b, code lost:
    
        if (r0.g() != null) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x002e, code lost:
    
        r3 = r0.g().iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x003a, code lost:
    
        if (r3.hasNext() == false) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x003c, code lost:
    
        r5 = r3.next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0042, code lost:
    
        if (r5 == null) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0048, code lost:
    
        if (r5.s() != r4) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x004a, code lost:
    
        r5.b(r6);
     */
    @Override // com.ss.android.socialbase.downloader.downloader.j
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized void a(int r3, int r4, int r5, long r6) {
        /*
            r2 = this;
            monitor-enter(r2)
            java.util.List r3 = r2.c(r3)     // Catch: java.lang.Throwable -> L4f
            if (r3 != 0) goto L9
            monitor-exit(r2)
            return
        L9:
            java.util.Iterator r3 = r3.iterator()     // Catch: java.lang.Throwable -> L4f
        Ld:
            boolean r0 = r3.hasNext()     // Catch: java.lang.Throwable -> L4f
            if (r0 == 0) goto L4d
            java.lang.Object r0 = r3.next()     // Catch: java.lang.Throwable -> L4f
            com.ss.android.socialbase.downloader.model.b r0 = (com.ss.android.socialbase.downloader.model.b) r0     // Catch: java.lang.Throwable -> L4f
            if (r0 == 0) goto Ld
            int r1 = r0.s()     // Catch: java.lang.Throwable -> L4f
            if (r1 != r5) goto Ld
            boolean r1 = r0.f()     // Catch: java.lang.Throwable -> L4f
            if (r1 != 0) goto Ld
            java.util.List r3 = r0.g()     // Catch: java.lang.Throwable -> L4f
            if (r3 != 0) goto L2e
            goto L4d
        L2e:
            java.util.List r3 = r0.g()     // Catch: java.lang.Throwable -> L4f
            java.util.Iterator r3 = r3.iterator()     // Catch: java.lang.Throwable -> L4f
        L36:
            boolean r5 = r3.hasNext()     // Catch: java.lang.Throwable -> L4f
            if (r5 == 0) goto L4d
            java.lang.Object r5 = r3.next()     // Catch: java.lang.Throwable -> L4f
            com.ss.android.socialbase.downloader.model.b r5 = (com.ss.android.socialbase.downloader.model.b) r5     // Catch: java.lang.Throwable -> L4f
            if (r5 == 0) goto L36
            int r0 = r5.s()     // Catch: java.lang.Throwable -> L4f
            if (r0 != r4) goto L36
            r5.b(r6)     // Catch: java.lang.Throwable -> L4f
        L4d:
            monitor-exit(r2)
            return
        L4f:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.impls.k.a(int, int, int, long):void");
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public DownloadInfo b(int i2, long j2) {
        DownloadInfo downloadInfoB = b(i2);
        if (downloadInfoB != null) {
            downloadInfoB.setCurBytes(j2, false);
            downloadInfoB.setStatus(-1);
            downloadInfoB.setFirstDownload(false);
        }
        return downloadInfoB;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public void b(DownloadInfo downloadInfo) {
        a(downloadInfo);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public synchronized DownloadInfo a(int i2, int i3) {
        DownloadInfo downloadInfoB;
        downloadInfoB = b(i2);
        if (downloadInfoB != null) {
            downloadInfoB.setChunkCount(i3);
        }
        return downloadInfoB;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public synchronized boolean a(DownloadInfo downloadInfo) {
        boolean z = true;
        if (downloadInfo == null) {
            return true;
        }
        if (this.a.get(downloadInfo.getId()) == null) {
            z = false;
        }
        this.a.put(downloadInfo.getId(), downloadInfo);
        return z;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public DownloadInfo a(int i2, long j2, String str, String str2) {
        DownloadInfo downloadInfoB = b(i2);
        if (downloadInfoB != null) {
            downloadInfoB.setTotalBytes(j2);
            downloadInfoB.seteTag(str);
            if (TextUtils.isEmpty(downloadInfoB.getName()) && !TextUtils.isEmpty(str2)) {
                downloadInfoB.setName(str2);
            }
            downloadInfoB.setStatus(3);
        }
        return downloadInfoB;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public DownloadInfo a(int i2, long j2) {
        DownloadInfo downloadInfoB = b(i2);
        if (downloadInfoB != null) {
            downloadInfoB.setCurBytes(j2, false);
            if (downloadInfoB.getStatus() != -3 && downloadInfoB.getStatus() != -2 && !DownloadStatus.isFailedStatus(downloadInfoB.getStatus()) && downloadInfoB.getStatus() != -4) {
                downloadInfoB.setStatus(4);
            }
        }
        return downloadInfoB;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public synchronized void a(int i2, List<com.ss.android.socialbase.downloader.model.b> list) {
        if (list == null) {
            return;
        }
        d(i2);
        for (com.ss.android.socialbase.downloader.model.b bVar : list) {
            if (bVar != null) {
                a(bVar);
                if (bVar.f()) {
                    Iterator<com.ss.android.socialbase.downloader.model.b> it = bVar.g().iterator();
                    while (it.hasNext()) {
                        a(it.next());
                    }
                }
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public synchronized boolean a(int i2, Map<Long, com.ss.android.socialbase.downloader.f.i> map) {
        this.f3790c.put(i2, map);
        return false;
    }
}

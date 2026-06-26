package com.ss.android.socialbase.downloader.f;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.h.e;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.network.c;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SegmentDispatcher.java */
/* JADX INFO: loaded from: classes.dex */
public class k implements f, c.a {
    private int A;
    private final boolean B;
    private final DownloadInfo a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final n f3641b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final b f3642c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.ss.android.socialbase.downloader.h.f f3643d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final g f3644e;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private com.ss.android.socialbase.downloader.model.d f3649j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private com.ss.android.socialbase.downloader.model.d f3650k;
    private long m;
    private int p;
    private BaseException q;
    private volatile boolean r;
    private final com.ss.android.socialbase.downloader.i.e t;
    private final com.ss.android.socialbase.downloader.h.e u;
    private long w;
    private long x;
    private long y;
    private float z;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private volatile boolean f3645f = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private volatile boolean f3646g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final List<m> f3647h = new ArrayList();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final List<q> f3648i = new ArrayList();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private volatile boolean f3651l = true;
    private final LinkedList<i> n = new LinkedList<>();
    private final List<i> o = new ArrayList();
    private final Object s = new Object();
    private volatile boolean v = false;
    private final e.b C = new e.b() { // from class: com.ss.android.socialbase.downloader.f.k.1

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f3652b;

        @Override // com.ss.android.socialbase.downloader.h.e.b
        public long a() {
            if (k.this.f3645f || k.this.f3646g) {
                return -1L;
            }
            synchronized (k.this) {
                if (k.this.f3649j == null && k.this.f3650k == null) {
                    long j2 = k.this.w;
                    if (j2 <= 0) {
                        return -1L;
                    }
                    this.f3652b++;
                    m mVarA = k.this.a(false, System.currentTimeMillis(), j2);
                    if (mVarA == null) {
                        return j2;
                    }
                    k.this.c(mVarA);
                    mVarA.f();
                    return ((long) ((this.f3652b / k.this.f3648i.size()) + 1)) * j2;
                }
                return -1L;
            }
        }
    };
    private final e.b D = new e.b() { // from class: com.ss.android.socialbase.downloader.f.k.2
        @Override // com.ss.android.socialbase.downloader.h.e.b
        public long a() {
            return k.this.r();
        }
    };

    public k(@NonNull DownloadInfo downloadInfo, @NonNull n nVar, com.ss.android.socialbase.downloader.h.f fVar) {
        this.a = downloadInfo;
        this.f3641b = nVar;
        b bVar = new b(nVar.d(), nVar.e());
        this.f3642c = bVar;
        this.f3643d = fVar;
        this.f3644e = new g(downloadInfo, fVar, bVar);
        this.u = new com.ss.android.socialbase.downloader.h.e();
        this.t = new com.ss.android.socialbase.downloader.i.e();
        this.B = com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId()).b("debug") == 1;
    }

    private void h() {
        if (this.x > 0) {
            this.y = System.currentTimeMillis();
            this.u.a(this.D, 0L);
        }
    }

    private void i() {
        List<String> backUpUrls;
        int iL = this.f3641b.l();
        if (iL <= 0) {
            this.f3651l = false;
            e();
            return;
        }
        com.ss.android.socialbase.downloader.network.c cVarA = com.ss.android.socialbase.downloader.network.c.a();
        cVarA.a(this.a.getUrl(), this, 2000L);
        if (iL <= 2 || (backUpUrls = this.a.getBackUpUrls()) == null) {
            return;
        }
        for (String str : backUpUrls) {
            if (!TextUtils.isEmpty(str)) {
                cVarA.a(str, this, 2000L);
            }
        }
    }

    private q j() {
        q qVar;
        synchronized (this) {
            int size = this.p % this.f3648i.size();
            if (this.f3641b.b()) {
                this.p++;
            }
            qVar = this.f3648i.get(size);
        }
        return qVar;
    }

    private void k() {
        com.ss.android.socialbase.downloader.c.a.c("SegmentDispatcher", "onComplete");
        this.f3642c.c();
        synchronized (this.s) {
            this.s.notify();
        }
    }

    private boolean l() {
        Iterator<m> it = this.f3647h.iterator();
        while (it.hasNext()) {
            if (!it.next().g()) {
                return false;
            }
        }
        return true;
    }

    private void m() {
        int size;
        if (this.m > 0 && (size = this.o.size()) > 1) {
            ArrayList<i> arrayList = null;
            int i2 = 0;
            for (int i3 = 1; i3 < size; i3++) {
                i iVar = this.o.get(i2);
                i iVar2 = this.o.get(i3);
                if (iVar.e() > iVar2.c() && iVar2.a() <= 0 && iVar2.a == null) {
                    if (arrayList == null) {
                        arrayList = new ArrayList(1);
                    }
                    arrayList.add(iVar2);
                    if (this.B) {
                        String str = "clearCovered, covered = " + iVar2 + ", prev = " + iVar;
                    }
                } else if (iVar2.e() > iVar.e()) {
                    i2++;
                }
            }
            if (arrayList != null) {
                for (i iVar3 : arrayList) {
                    this.o.remove(iVar3);
                    for (m mVar : this.f3647h) {
                        if (mVar.a == iVar3) {
                            if (this.B) {
                                String str2 = "clearCoveredSegmentLocked: reconnect, segment = " + iVar3 + ", threadIndex = " + mVar.f3656c;
                            }
                            mVar.a(true);
                        }
                    }
                }
            }
        }
    }

    private boolean n() {
        long j2 = this.m;
        if (j2 <= 0) {
            this.r = false;
            return false;
        }
        synchronized (this) {
            long jA = o.a(this.o);
            com.ss.android.socialbase.downloader.c.a.c("SegmentDispatcher", "isAllContentDownloaded: firstOffset = " + jA);
            if (jA >= j2) {
                this.r = true;
                return true;
            }
            this.r = false;
            return false;
        }
    }

    private long o() {
        Iterator<m> it = this.f3647h.iterator();
        long jB = 0;
        while (it.hasNext()) {
            jB += it.next().b();
        }
        return jB;
    }

    private i p() {
        int i2 = 0;
        while (true) {
            i iVarQ = q();
            if (iVarQ == null) {
                return null;
            }
            m mVar = iVarQ.a;
            if (mVar == null) {
                return iVarQ;
            }
            if (iVarQ.j() >= 2) {
                return null;
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            b(jCurrentTimeMillis);
            if (jCurrentTimeMillis - mVar.f3659f > 2000 && a(mVar, jCurrentTimeMillis - 2000, jCurrentTimeMillis, 500L, 1.0d)) {
                if (this.B) {
                    String str = "obtainSegmentWhenNoNewSegment: isDownloadSpeedPoor segment = " + iVarQ + ", owner.threadIndex = " + mVar.f3656c;
                }
                return iVarQ;
            }
            int i3 = i2 + 1;
            if (i2 > 2) {
                if (this.B) {
                    String str2 = "obtainSegmentWhenNoNewSegment: waitCount > 2, return segment = " + iVarQ;
                }
                return iVarQ;
            }
            try {
                synchronized (this) {
                    wait(500L);
                }
                i2 = i3;
            } catch (InterruptedException unused) {
                return null;
            }
        }
    }

    private i q() {
        int iJ;
        i iVar = null;
        int i2 = Integer.MAX_VALUE;
        for (i iVar2 : this.o) {
            if (a(iVar2) > 0 && (iJ = iVar2.j()) < i2) {
                iVar = iVar2;
                i2 = iJ;
            }
        }
        return iVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long r() {
        if (this.f3645f || this.f3646g) {
            return -1L;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        synchronized (this) {
            b(jCurrentTimeMillis);
            long jK = this.f3641b.k();
            if (jK > 0) {
                long j2 = this.y;
                if (j2 > 0 && jCurrentTimeMillis - j2 > jK && a(jCurrentTimeMillis, jK)) {
                    this.y = jCurrentTimeMillis;
                    this.A++;
                }
            }
        }
        return 2000L;
    }

    private void b(List<i> list) {
        long totalBytes = this.a.getTotalBytes();
        this.m = totalBytes;
        if (totalBytes <= 0) {
            this.m = this.a.getExpectFileLength();
            StringBuilder sbR = c.a.a.a.a.r("initSegments: getExpectFileLength = ");
            sbR.append(this.m);
            com.ss.android.socialbase.downloader.c.a.c("SegmentDispatcher", sbR.toString());
        }
        synchronized (this) {
            this.n.clear();
            if (list == null || list.isEmpty()) {
                a((List<i>) this.n, new i(0L, -1L), false);
            } else {
                Iterator<i> it = list.iterator();
                while (it.hasNext()) {
                    a((List<i>) this.n, new i(it.next()), false);
                }
                d(this.n);
                c(this.n);
            }
            com.ss.android.socialbase.downloader.c.a.c("SegmentDispatcher", "initSegments: totalLength = " + this.m);
        }
    }

    private void c() throws BaseException {
        BaseException baseException;
        synchronized (this.s) {
            if (this.f3649j == null && this.f3650k == null) {
                this.s.wait();
            }
        }
        if (this.f3649j == null && this.f3650k == null && (baseException = this.q) != null) {
            throw baseException;
        }
    }

    private void d() throws BaseException {
        try {
            this.f3644e.a((d) this.f3642c);
        } catch (p unused) {
        } catch (BaseException e2) {
            com.ss.android.socialbase.downloader.c.a.e("SegmentDispatcher", "dispatchSegments: loopAndWrite e = " + e2);
            a(e2);
            throw e2;
        }
        if (this.f3646g || this.f3645f) {
            return;
        }
        try {
            synchronized (this) {
                while (!this.n.isEmpty()) {
                    i iVarPoll = this.n.poll();
                    if (iVarPoll != null) {
                        a(this.o, iVarPoll, true);
                    }
                }
                c(this.o);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (!this.v || this.q == null) {
            if (this.a.getCurBytes() != this.a.getTotalBytes()) {
                com.ss.android.socialbase.downloader.d.a.a(this.a, this.o);
            }
            com.ss.android.socialbase.downloader.c.a.c("SegmentDispatcher", "dispatchSegments::download finished");
        } else {
            StringBuilder sbR = c.a.a.a.a.r("dispatchSegments: loopAndWrite  failedException = ");
            sbR.append(this.q);
            com.ss.android.socialbase.downloader.c.a.e("SegmentDispatcher", sbR.toString());
            throw this.q;
        }
    }

    private void e() {
        int iA;
        if (this.m <= 0 || this.f3651l) {
            iA = 1;
        } else {
            iA = this.f3641b.a();
            int iH = (int) (this.m / this.f3641b.h());
            if (iA > iH) {
                iA = iH;
            }
        }
        StringBuilder sbR = c.a.a.a.a.r("dispatchReadThread: totalLength = ");
        sbR.append(this.m);
        sbR.append(", threadCount = ");
        sbR.append(iA);
        com.ss.android.socialbase.downloader.c.a.c("SegmentDispatcher", sbR.toString());
        int i2 = iA > 0 ? iA : 1;
        synchronized (this) {
            while (this.f3647h.size() < i2) {
                if (!this.f3646g && !this.f3645f) {
                    a(j());
                    if (this.f3641b.f()) {
                        break;
                    }
                }
                return;
            }
        }
    }

    private void f() {
        this.f3648i.add(new q(this.a.getUrl(), true));
        List<String> backUpUrls = this.a.getBackUpUrls();
        if (backUpUrls != null) {
            for (String str : backUpUrls) {
                if (!TextUtils.isEmpty(str)) {
                    this.f3648i.add(new q(str, false));
                }
            }
        }
        this.f3641b.a(this.f3648i.size());
    }

    private void g() {
        n nVar = this.f3641b;
        this.w = nVar.j();
        this.x = nVar.k();
        this.z = nVar.o();
        int i2 = this.A;
        if (i2 > 0) {
            this.u.a(this.C, i2);
        }
    }

    public boolean a(List<i> list) {
        try {
            f();
            b(list);
            e();
            g();
            i();
            long jCurrentTimeMillis = System.currentTimeMillis();
            try {
                c();
                long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
                this.a.increaseAllConnectTime(jCurrentTimeMillis2);
                this.a.setFirstSpeedTime(jCurrentTimeMillis2);
                if (!this.f3646g && !this.f3645f) {
                    this.f3643d.a(this.m);
                    h();
                    d();
                    return true;
                }
                if (!this.f3646g && !this.f3645f) {
                    com.ss.android.socialbase.downloader.c.a.c("SegmentDispatcher", "finally pause");
                    b();
                }
                this.u.b();
                return true;
            } catch (Throwable th) {
                long jCurrentTimeMillis3 = System.currentTimeMillis() - jCurrentTimeMillis;
                this.a.increaseAllConnectTime(jCurrentTimeMillis3);
                this.a.setFirstSpeedTime(jCurrentTimeMillis3);
                throw th;
            }
        } finally {
            if (!this.f3646g && !this.f3645f) {
                com.ss.android.socialbase.downloader.c.a.c("SegmentDispatcher", "finally pause");
                b();
            }
            this.u.b();
        }
    }

    private void c(List<i> list) {
        long jB = o.b(list);
        StringBuilder sbR = c.a.a.a.a.r("checkDownloadBytes: getCurBytes = ");
        sbR.append(this.a.getCurBytes());
        sbR.append(", totalBytes = ");
        sbR.append(this.a.getTotalBytes());
        sbR.append(", downloadedBytes = ");
        sbR.append(jB);
        com.ss.android.socialbase.downloader.c.a.c("SegmentDispatcher", sbR.toString());
        if (jB > this.a.getTotalBytes() && this.a.getTotalBytes() > 0) {
            jB = this.a.getTotalBytes();
        }
        if (this.a.getCurBytes() == this.a.getTotalBytes() || this.a.getCurBytes() == jB) {
            return;
        }
        this.a.setCurBytes(jB);
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x00a1, code lost:
    
        if ((r10.e() - r24.e()) < (r14 / 2)) goto L32;
     */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00fb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void e(com.ss.android.socialbase.downloader.f.m r23, com.ss.android.socialbase.downloader.f.i r24) throws com.ss.android.socialbase.downloader.f.j {
        /*
            Method dump skipped, instruction units count: 713
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.f.k.e(com.ss.android.socialbase.downloader.f.m, com.ss.android.socialbase.downloader.f.i):void");
    }

    private void b(String str, List<q> list) {
        int iA;
        if (this.B) {
            Iterator<q> it = list.iterator();
            while (it.hasNext()) {
                String str2 = "addIpListLocked: urlRecord = " + it.next();
            }
        }
        int iL = this.f3641b.l();
        if ((iL == 1 || iL == 3) && (iA = a(str)) >= 0 && iA < this.f3648i.size()) {
            this.f3648i.addAll(iA + 1, list);
        } else {
            this.f3648i.addAll(list);
        }
    }

    private List<q> c(String str, List<InetAddress> list) {
        boolean z;
        if (list != null && !list.isEmpty()) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            int i2 = 0;
            for (InetAddress inetAddress : list) {
                if (inetAddress != null) {
                    String hostAddress = inetAddress.getHostAddress();
                    if (!TextUtils.isEmpty(hostAddress)) {
                        boolean z2 = this.B;
                        q qVar = new q(str, hostAddress);
                        LinkedList linkedList = (LinkedList) linkedHashMap.get(qVar.f3668c);
                        if (linkedList == null) {
                            linkedList = new LinkedList();
                            linkedHashMap.put(qVar.f3668c, linkedList);
                        }
                        linkedList.add(qVar);
                        i2++;
                    }
                }
            }
            if (i2 > 0) {
                ArrayList arrayList = new ArrayList();
                do {
                    Iterator it = linkedHashMap.entrySet().iterator();
                    z = false;
                    while (it.hasNext()) {
                        LinkedList linkedList2 = (LinkedList) ((Map.Entry) it.next()).getValue();
                        if (linkedList2 != null && !linkedList2.isEmpty()) {
                            arrayList.add((q) linkedList2.pollFirst());
                            i2--;
                            z = true;
                        }
                    }
                    if (i2 <= 0) {
                        break;
                    }
                } while (z);
                return arrayList;
            }
        }
        return null;
    }

    private void d(List<i> list) {
        i iVar = list.get(0);
        long jC = iVar.c();
        if (jC > 0) {
            i iVar2 = new i(0L, jC - 1);
            String str = "fixSegmentsLocked: first = " + iVar + ", add new first = " + iVar2;
            a(list, iVar2, true);
        }
        Iterator<i> it = list.iterator();
        if (it.hasNext()) {
            i next = it.next();
            while (it.hasNext()) {
                i next2 = it.next();
                if (next.f() < next2.c() - 1) {
                    com.ss.android.socialbase.downloader.c.a.d("SegmentDispatcher", "fixSegment: segment = " + next + ", new end = " + (next2.c() - 1));
                    next.c(next2.c() - 1);
                }
                next = next2;
            }
        }
        i iVar3 = (i) c.a.a.a.a.E(list, 1);
        long totalBytes = this.a.getTotalBytes();
        if (totalBytes <= 0 || (iVar3.f() != -1 && iVar3.f() < totalBytes - 1)) {
            com.ss.android.socialbase.downloader.c.a.d("SegmentDispatcher", "fixSegment: last segment = " + iVar3 + ", new end=-1");
            iVar3.c(-1L);
        }
    }

    private i b(m mVar, q qVar) {
        while (!this.n.isEmpty()) {
            i iVarPoll = this.n.poll();
            if (iVarPoll != null) {
                a(this.o, iVarPoll, true);
                if (a(iVarPoll) > 0 || this.m <= 0) {
                    return iVarPoll;
                }
            }
        }
        m();
        i iVarC = c(mVar, qVar);
        if (iVarC != null && a(iVarC) > 0) {
            a(this.o, iVarC, true);
            return iVarC;
        }
        i iVarP = p();
        if (iVarP != null) {
            return iVarP;
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.f.f
    public void b(m mVar, i iVar) {
        synchronized (this) {
            e(mVar, iVar);
        }
    }

    @Override // com.ss.android.socialbase.downloader.network.c.a
    public void a(String str, List<InetAddress> list) {
        if (this.f3646g || this.f3645f) {
            return;
        }
        List<q> listC = null;
        try {
            listC = c(str, list);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        synchronized (this) {
            if (listC != null) {
                b(str, listC);
                this.f3651l = false;
                this.f3641b.a(this.f3648i.size());
                e();
            } else {
                this.f3651l = false;
                this.f3641b.a(this.f3648i.size());
                e();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.f.f
    public void b(m mVar) {
        StringBuilder sbR = c.a.a.a.a.r("onReaderExit: threadIndex = ");
        sbR.append(mVar.f3656c);
        com.ss.android.socialbase.downloader.c.a.c("SegmentDispatcher", sbR.toString());
        synchronized (this) {
            mVar.c(true);
            this.f3647h.remove(mVar);
            m();
            if (this.f3647h.isEmpty()) {
                k();
            } else if (n()) {
                Iterator<m> it = this.f3647h.iterator();
                while (it.hasNext()) {
                    it.next().e();
                }
                k();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.f.f
    public void c(m mVar, i iVar) {
        synchronized (this) {
            if (iVar.a == mVar) {
                com.ss.android.socialbase.downloader.c.a.c("SegmentDispatcher", "unApplySegment " + iVar);
                iVar.d(mVar.d());
                iVar.a = null;
                mVar.a();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.f.f
    public e d(m mVar, i iVar) {
        e eVarA;
        synchronized (this) {
            l lVar = new l(this.a, this.f3642c, iVar);
            this.f3644e.a(lVar);
            eVarA = lVar.a();
        }
        return eVarA;
    }

    private int a(String str) {
        int size = this.f3648i.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (TextUtils.equals(this.f3648i.get(i2).a, str)) {
                return i2;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(m mVar) {
        synchronized (this) {
            q qVarD = d(mVar);
            if (qVarD == null) {
                return false;
            }
            return mVar.a(qVarD);
        }
    }

    private void a(List<i> list, i iVar, boolean z) {
        long jC = iVar.c();
        int size = list.size();
        int i2 = 0;
        while (i2 < size && jC >= list.get(i2).c()) {
            i2++;
        }
        list.add(i2, iVar);
        if (z) {
            iVar.a(size);
        }
    }

    private q d(m mVar) {
        q next;
        Iterator<q> it = this.f3648i.iterator();
        q qVar = null;
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (next != mVar.f3655b && !next.d()) {
                if (qVar == null) {
                    qVar = next;
                }
                if (next.a() <= 0) {
                    break;
                }
            }
        }
        if (this.f3641b.b()) {
            if (next != null) {
                return next;
            }
            if (this.f3641b.c()) {
                return null;
            }
        }
        return qVar;
    }

    private void b(m mVar, i iVar, q qVar, com.ss.android.socialbase.downloader.model.d dVar) throws BaseException {
        m mVar2 = iVar.a;
        if (mVar2 != null && mVar2 != mVar) {
            throw new j(1, "segment already has an owner");
        }
        if (mVar.h() == iVar.e()) {
            if (!dVar.b()) {
                if (iVar.e() <= 0) {
                    StringBuilder sbR = c.a.a.a.a.r("parseHttpResponse: segment.getCurrentOffsetRead = ");
                    sbR.append(iVar.e());
                    com.ss.android.socialbase.downloader.c.a.e("SegmentDispatcher", sbR.toString());
                    if (!dVar.a()) {
                        int i2 = dVar.f3858c;
                        StringBuilder sbR2 = c.a.a.a.a.r("2: response code error : ");
                        sbR2.append(dVar.f3858c);
                        sbR2.append(" segment=");
                        sbR2.append(iVar);
                        throw new com.ss.android.socialbase.downloader.exception.b(1004, i2, sbR2.toString());
                    }
                } else {
                    int i3 = dVar.f3858c;
                    StringBuilder sbR3 = c.a.a.a.a.r("1: response code error : ");
                    sbR3.append(dVar.f3858c);
                    sbR3.append(" segment=");
                    sbR3.append(iVar);
                    throw new com.ss.android.socialbase.downloader.exception.b(1004, i3, sbR3.toString());
                }
            }
            if (qVar.f3669d) {
                if (this.f3649j == null) {
                    this.f3649j = dVar;
                    synchronized (this.s) {
                        this.s.notify();
                    }
                    com.ss.android.socialbase.downloader.h.f fVar = this.f3643d;
                    if (fVar != null) {
                        fVar.a(qVar.a, dVar.f3857b, iVar.e());
                    }
                    long j2 = dVar.j();
                    if (j2 > 0) {
                        for (i iVar2 : this.o) {
                            if (iVar2.f() <= 0 || iVar2.f() > j2 - 1) {
                                iVar2.c(j2 - 1);
                            }
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            a(dVar);
            if (this.f3650k == null) {
                this.f3650k = dVar;
                if (this.a.getTotalBytes() <= 0) {
                    long j3 = dVar.j();
                    com.ss.android.socialbase.downloader.c.a.c("SegmentDispatcher", "checkSegmentHttpResponse:len=" + j3 + ",url=" + qVar.a);
                    this.a.setTotalBytes(j3);
                }
                synchronized (this.s) {
                    this.s.notify();
                }
                return;
            }
            return;
        }
        throw new j(5, "applySegment");
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00b7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private com.ss.android.socialbase.downloader.f.i c(com.ss.android.socialbase.downloader.f.m r28, com.ss.android.socialbase.downloader.f.q r29) {
        /*
            Method dump skipped, instruction units count: 495
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.f.k.c(com.ss.android.socialbase.downloader.f.m, com.ss.android.socialbase.downloader.f.q):com.ss.android.socialbase.downloader.f.i");
    }

    private void a(q qVar) {
        m mVar = new m(this.a, this, this.f3642c, qVar, this.f3647h.size());
        this.f3647h.add(mVar);
        mVar.a(com.ss.android.socialbase.downloader.downloader.c.q().submit(mVar));
    }

    private float d(m mVar, q qVar) {
        long jB = mVar.b();
        int size = this.f3647h.size();
        if (size <= 1) {
            size = this.f3641b.a();
        }
        float f2 = 1.0f;
        if (jB <= 0) {
            float fM = this.f3641b.m();
            if (fM <= 0.0f || fM >= 1.0f) {
                fM = 1.0f / size;
            }
            if (mVar.f3656c == 0) {
                return fM;
            }
            if (size > 1) {
                f2 = 1.0f - fM;
                size--;
            }
        } else {
            long jO = o();
            if (jO > jB) {
                return jB / jO;
            }
        }
        return f2 / size;
    }

    @Override // com.ss.android.socialbase.downloader.f.f
    public void a(m mVar) {
        if (this.B) {
            StringBuilder sbR = c.a.a.a.a.r("onReaderRun, threadIndex = ");
            sbR.append(mVar.f3656c);
            com.ss.android.socialbase.downloader.c.a.c("SegmentDispatcher", sbR.toString());
        }
    }

    @Override // com.ss.android.socialbase.downloader.f.f
    public i a(m mVar, q qVar) {
        if (this.f3645f || this.f3646g) {
            return null;
        }
        synchronized (this) {
            i iVarB = b(mVar, qVar);
            if (iVarB != null) {
                iVarB.h();
                if (iVarB.j() > 1) {
                    return new i(iVarB);
                }
            }
            return iVarB;
        }
    }

    @Override // com.ss.android.socialbase.downloader.f.f
    public void a(m mVar, i iVar) {
        synchronized (this) {
            iVar.i();
        }
    }

    @Override // com.ss.android.socialbase.downloader.f.f
    public void a(m mVar, i iVar, q qVar, com.ss.android.socialbase.downloader.model.d dVar) {
        synchronized (this) {
            if (!this.f3645f && !this.f3646g) {
                b(mVar, iVar, qVar, dVar);
                mVar.b(false);
                if (this.m <= 0) {
                    long totalBytes = this.a.getTotalBytes();
                    this.m = totalBytes;
                    if (totalBytes <= 0) {
                        this.m = dVar.j();
                    }
                    e();
                } else if (this.f3641b.f()) {
                    e();
                }
            } else {
                throw new p("connected");
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.f.f
    public void a(m mVar, q qVar, i iVar, BaseException baseException, int i2, int i3) {
        boolean zB = com.ss.android.socialbase.downloader.i.f.b(baseException);
        int errorCode = baseException.getErrorCode();
        if (errorCode == 1047 || errorCode == 1074 || errorCode == 1055) {
            zB = true;
        }
        if (zB || i2 >= i3) {
            c(mVar);
        }
    }

    public void b() {
        com.ss.android.socialbase.downloader.c.a.c("SegmentDispatcher", "pause1");
        this.f3646g = true;
        synchronized (this) {
            Iterator<m> it = this.f3647h.iterator();
            while (it.hasNext()) {
                it.next().e();
            }
        }
        this.f3644e.b();
        this.f3642c.c();
    }

    @Override // com.ss.android.socialbase.downloader.f.f
    public void a(m mVar, q qVar, i iVar, BaseException baseException) {
        synchronized (this) {
            com.ss.android.socialbase.downloader.c.a.e("SegmentDispatcher", "onSegmentFailed: segment = " + iVar + ", e = " + baseException);
            mVar.b(true);
            if (mVar.f3656c == 0) {
                this.q = baseException;
            }
            if (l()) {
                if (this.q == null) {
                    this.q = baseException;
                }
                this.v = true;
                a(this.q);
            }
        }
    }

    private void b(long j2) {
        this.t.a(this.a.getCurBytes(), j2);
        Iterator<m> it = this.f3647h.iterator();
        while (it.hasNext()) {
            it.next().b(j2);
        }
    }

    private void a(BaseException baseException) {
        com.ss.android.socialbase.downloader.c.a.e("SegmentDispatcher", "onError, e = " + baseException);
        this.q = baseException;
        this.f3642c.c();
        synchronized (this) {
            Iterator<m> it = this.f3647h.iterator();
            while (it.hasNext()) {
                it.next().e();
            }
        }
    }

    private void a(com.ss.android.socialbase.downloader.model.d dVar) throws BaseException {
        com.ss.android.socialbase.downloader.model.d dVar2 = this.f3649j;
        if (dVar2 == null && (dVar2 = this.f3650k) == null) {
            return;
        }
        long j2 = dVar.j();
        long j3 = dVar2.j();
        if (j2 != j3) {
            String str = "total len not equals,len=" + j2 + ",sLen=" + j3 + ",code=" + dVar.f3858c + ",sCode=" + dVar2.f3858c + ",range=" + dVar.e() + ",sRange = " + dVar2.e() + ",url = " + dVar.a + ",sUrl=" + dVar2.a;
            com.ss.android.socialbase.downloader.c.a.e("SegmentDispatcher", str);
            if (j2 > 0 && j3 > 0) {
                throw new BaseException(1074, str);
            }
        }
        String strC = dVar.c();
        String strC2 = dVar2.c();
        if (TextUtils.equals(strC, strC2)) {
            return;
        }
        String str2 = "etag not equals with main url, etag = " + strC + ", mainEtag = " + strC2;
        com.ss.android.socialbase.downloader.c.a.e("SegmentDispatcher", str2);
        if (!TextUtils.isEmpty(strC) && !TextUtils.isEmpty(strC2) && !strC.equalsIgnoreCase(strC2)) {
            throw new BaseException(1074, str2);
        }
    }

    public void a() {
        com.ss.android.socialbase.downloader.c.a.c("SegmentDispatcher", "cancel");
        this.f3645f = true;
        synchronized (this) {
            Iterator<m> it = this.f3647h.iterator();
            while (it.hasNext()) {
                it.next().e();
            }
        }
        this.f3644e.a();
        this.f3642c.c();
    }

    private int a(long j2) {
        int size = this.o.size();
        for (int i2 = 0; i2 < size; i2++) {
            i iVar = this.o.get(i2);
            if (iVar.c() == j2) {
                return i2;
            }
            if (iVar.c() > j2) {
                return -1;
            }
        }
        return -1;
    }

    private long a(int i2, int i3) {
        i iVar = this.o.get(i2);
        long jA = a(iVar);
        int i4 = i2 + 1;
        i iVar2 = i4 < i3 ? this.o.get(i4) : null;
        if (iVar2 == null) {
            return jA;
        }
        long jC = iVar2.c() - iVar.e();
        return jA == -1 ? jC : Math.min(jA, jC);
    }

    private long a(i iVar) {
        long jB = iVar.b();
        if (jB != -1) {
            return jB;
        }
        long j2 = this.m;
        return j2 > 0 ? j2 - iVar.e() : jB;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public m a(boolean z, long j2, long j3) {
        m mVar = null;
        for (m mVar2 : this.f3647h) {
            if (mVar2.f3656c != 0 || z) {
                if (mVar2.f3657d > 0 && mVar2.f3658e <= 0 && j2 - mVar2.f3657d > j3 && (mVar == null || mVar2.f3657d < mVar.f3657d)) {
                    mVar = mVar2;
                }
            }
        }
        return mVar;
    }

    private boolean a(m mVar, long j2, long j3, long j4, double d2) {
        if (mVar.f3659f <= 0) {
            return false;
        }
        long jB = this.t.b(j2, j3);
        int size = this.f3647h.size();
        if (size > 0) {
            jB /= (long) size;
        }
        long jA = mVar.a(j2, j3);
        return jA < j4 || ((double) jA) < ((double) jB) * d2;
    }

    private boolean a(long j2, long j3) {
        long j4 = j2 - j3;
        long jB = this.t.b(j4, j2);
        int size = this.f3647h.size();
        if (size > 0) {
            jB /= (long) size;
        }
        m mVarA = a(j4, j2, (long) Math.max(10.0f, jB * this.z), size / 2);
        if (mVarA != null) {
            c(mVarA);
            StringBuilder sbR = c.a.a.a.a.r("handlePoorReadThread: reconnect for poor speed, threadIndex = ");
            sbR.append(mVarA.f3656c);
            com.ss.android.socialbase.downloader.c.a.d("SegmentDispatcher", sbR.toString());
            mVarA.f();
            return true;
        }
        m mVarA2 = a(true, j2, j3);
        if (mVarA2 == null) {
            return false;
        }
        c(mVarA2);
        StringBuilder sbR2 = c.a.a.a.a.r("handlePoorReadThread: reconnect for connect timeout, threadIndex = ");
        sbR2.append(mVarA2.f3656c);
        com.ss.android.socialbase.downloader.c.a.d("SegmentDispatcher", sbR2.toString());
        mVarA2.f();
        return true;
    }

    private m a(long j2, long j3, long j4, int i2) {
        long j5 = RecyclerView.FOREVER_NS;
        int i3 = 0;
        m mVar = null;
        for (m mVar2 : this.f3647h) {
            if (mVar2.f3659f > 0) {
                i3++;
                if (mVar2.f3659f < j2) {
                    long jA = mVar2.a(j2, j3);
                    boolean z = this.B;
                    if (jA >= 0 && jA < j5) {
                        mVar = mVar2;
                        j5 = jA;
                    }
                }
            }
        }
        if (mVar == null || i3 < i2 || j5 >= j4) {
            return null;
        }
        com.ss.android.socialbase.downloader.c.a.c("SegmentDispatcher", "findPoorReadThread: ----------- minSpeed = " + j5 + ", threadIndex = " + mVar.f3656c);
        return mVar;
    }
}

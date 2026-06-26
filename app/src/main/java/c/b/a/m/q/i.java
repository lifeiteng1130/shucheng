package c.b.a.m.q;

import android.os.Build;
import android.os.SystemClock;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import c.b.a.m.q.g;
import c.b.a.m.q.j;
import c.b.a.m.q.l;
import c.b.a.m.q.m;
import c.b.a.m.q.q;
import c.b.a.s.j.a;
import c.b.a.s.j.d;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.data.DataRewinder;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: DecodeJob.java */
/* JADX INFO: loaded from: classes.dex */
public class i<R> implements g.a, Runnable, Comparable<i<?>>, a.d {
    public c.b.a.m.a A;
    public DataFetcher<?> B;
    public volatile c.b.a.m.q.g C;
    public volatile boolean D;
    public volatile boolean E;
    public boolean F;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final d f402d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Pools.Pool<i<?>> f403e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public c.b.a.d f406h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public c.b.a.m.j f407i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public c.b.a.f f408j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public o f409k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f410l;
    public int m;
    public k n;
    public c.b.a.m.l o;
    public a<R> p;
    public int q;
    public g r;
    public f s;
    public long t;
    public boolean u;
    public Object v;
    public Thread w;
    public c.b.a.m.j x;
    public c.b.a.m.j y;
    public Object z;
    public final h<R> a = new h<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<Throwable> f400b = new ArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c.b.a.s.j.d f401c = new d.b();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final c<?> f404f = new c<>();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final e f405g = new e();

    /* JADX INFO: compiled from: DecodeJob.java */
    public interface a<R> {
    }

    /* JADX INFO: compiled from: DecodeJob.java */
    public final class b<Z> implements j.a<Z> {
        public final c.b.a.m.a a;

        public b(c.b.a.m.a aVar) {
            this.a = aVar;
        }
    }

    /* JADX INFO: compiled from: DecodeJob.java */
    public static class c<Z> {
        public c.b.a.m.j a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public c.b.a.m.o<Z> f412b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public v<Z> f413c;
    }

    /* JADX INFO: compiled from: DecodeJob.java */
    public interface d {
    }

    /* JADX INFO: compiled from: DecodeJob.java */
    public static class e {
        public boolean a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f414b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f415c;

        public final boolean a(boolean z) {
            return (this.f415c || z || this.f414b) && this.a;
        }
    }

    /* JADX INFO: compiled from: DecodeJob.java */
    public enum f {
        INITIALIZE,
        SWITCH_TO_SOURCE_SERVICE,
        DECODE_DATA
    }

    /* JADX INFO: compiled from: DecodeJob.java */
    public enum g {
        INITIALIZE,
        RESOURCE_CACHE,
        DATA_CACHE,
        SOURCE,
        ENCODE,
        FINISHED
    }

    public i(d dVar, Pools.Pool<i<?>> pool) {
        this.f402d = dVar;
        this.f403e = pool;
    }

    @Override // c.b.a.m.q.g.a
    public void a(c.b.a.m.j jVar, Exception exc, DataFetcher<?> dataFetcher, c.b.a.m.a aVar) {
        dataFetcher.cleanup();
        r rVar = new r("Fetching data failed", exc);
        rVar.setLoggingDetails(jVar, aVar, dataFetcher.getDataClass());
        this.f400b.add(rVar);
        if (Thread.currentThread() == this.w) {
            m();
        } else {
            this.s = f.SWITCH_TO_SOURCE_SERVICE;
            ((m) this.p).i(this);
        }
    }

    @Override // c.b.a.s.j.a.d
    @NonNull
    public c.b.a.s.j.d b() {
        return this.f401c;
    }

    @Override // c.b.a.m.q.g.a
    public void c() {
        this.s = f.SWITCH_TO_SOURCE_SERVICE;
        ((m) this.p).i(this);
    }

    @Override // java.lang.Comparable
    public int compareTo(@NonNull i<?> iVar) {
        i<?> iVar2 = iVar;
        int iOrdinal = this.f408j.ordinal() - iVar2.f408j.ordinal();
        return iOrdinal == 0 ? this.q - iVar2.q : iOrdinal;
    }

    @Override // c.b.a.m.q.g.a
    public void d(c.b.a.m.j jVar, Object obj, DataFetcher<?> dataFetcher, c.b.a.m.a aVar, c.b.a.m.j jVar2) {
        this.x = jVar;
        this.z = obj;
        this.B = dataFetcher;
        this.A = aVar;
        this.y = jVar2;
        this.F = jVar != this.a.a().get(0);
        if (Thread.currentThread() == this.w) {
            g();
        } else {
            this.s = f.DECODE_DATA;
            ((m) this.p).i(this);
        }
    }

    public final <Data> w<R> e(DataFetcher<?> dataFetcher, Data data, c.b.a.m.a aVar) {
        if (data == null) {
            return null;
        }
        try {
            int i2 = c.b.a.s.e.f675b;
            long jElapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos();
            w<R> wVarF = f(data, aVar);
            if (Log.isLoggable("DecodeJob", 2)) {
                j("Decoded result " + wVarF, jElapsedRealtimeNanos, null);
            }
            return wVarF;
        } finally {
            dataFetcher.cleanup();
        }
    }

    public final <Data> w<R> f(Data data, c.b.a.m.a aVar) {
        u<Data, ?, R> uVarD = this.a.d(data.getClass());
        c.b.a.m.l lVar = this.o;
        if (Build.VERSION.SDK_INT >= 26) {
            boolean z = aVar == c.b.a.m.a.RESOURCE_DISK_CACHE || this.a.r;
            c.b.a.m.k<Boolean> kVar = c.b.a.m.r.c.m.f526d;
            Boolean bool = (Boolean) lVar.b(kVar);
            if (bool == null || (bool.booleanValue() && !z)) {
                lVar = new c.b.a.m.l();
                lVar.c(this.o);
                lVar.f313b.put(kVar, Boolean.valueOf(z));
            }
        }
        c.b.a.m.l lVar2 = lVar;
        DataRewinder<Data> dataRewinderBuild = this.f406h.f216c.f228e.build(data);
        try {
            return uVarD.a(dataRewinderBuild, lVar2, this.f410l, this.m, new b(aVar));
        } finally {
            dataRewinderBuild.cleanup();
        }
    }

    public final void g() {
        v vVarE;
        boolean zA;
        if (Log.isLoggable("DecodeJob", 2)) {
            long j2 = this.t;
            StringBuilder sbR = c.a.a.a.a.r("data: ");
            sbR.append(this.z);
            sbR.append(", cache key: ");
            sbR.append(this.x);
            sbR.append(", fetcher: ");
            sbR.append(this.B);
            j("Retrieved data", j2, sbR.toString());
        }
        v vVarA = null;
        try {
            vVarE = e(this.B, this.z, this.A);
        } catch (r e2) {
            e2.setLoggingDetails(this.y, this.A);
            this.f400b.add(e2);
            vVarE = null;
        }
        if (vVarE == null) {
            m();
            return;
        }
        c.b.a.m.a aVar = this.A;
        boolean z = this.F;
        if (vVarE instanceof s) {
            ((s) vVarE).a();
        }
        if (this.f404f.f413c != null) {
            vVarA = v.a(vVarE);
            vVarE = vVarA;
        }
        o();
        m<?> mVar = (m) this.p;
        synchronized (mVar) {
            mVar.r = vVarE;
            mVar.s = aVar;
            mVar.z = z;
        }
        synchronized (mVar) {
            mVar.f442c.a();
            if (mVar.y) {
                mVar.r.recycle();
                mVar.g();
            } else {
                if (mVar.f441b.isEmpty()) {
                    throw new IllegalStateException("Received a resource without any callbacks to notify");
                }
                if (mVar.t) {
                    throw new IllegalStateException("Already have resource");
                }
                m.c cVar = mVar.f445f;
                w<?> wVar = mVar.r;
                boolean z2 = mVar.n;
                c.b.a.m.j jVar = mVar.m;
                q.a aVar2 = mVar.f443d;
                Objects.requireNonNull(cVar);
                mVar.w = new q<>(wVar, z2, true, jVar, aVar2);
                mVar.t = true;
                m.e eVar = mVar.f441b;
                Objects.requireNonNull(eVar);
                ArrayList<m.d> arrayList = new ArrayList(eVar.a);
                mVar.e(arrayList.size() + 1);
                ((l) mVar.f446g).e(mVar, mVar.m, mVar.w);
                for (m.d dVar : arrayList) {
                    dVar.f454b.execute(new m.b(dVar.a));
                }
                mVar.d();
            }
        }
        this.r = g.ENCODE;
        try {
            c<?> cVar2 = this.f404f;
            if (cVar2.f413c != null) {
                try {
                    ((l.c) this.f402d).a().a(cVar2.a, new c.b.a.m.q.f(cVar2.f412b, cVar2.f413c, this.o));
                    cVar2.f413c.d();
                } catch (Throwable th) {
                    cVar2.f413c.d();
                    throw th;
                }
            }
            e eVar2 = this.f405g;
            synchronized (eVar2) {
                eVar2.f414b = true;
                zA = eVar2.a(false);
            }
            if (zA) {
                l();
            }
        } finally {
            if (vVarA != null) {
                vVarA.d();
            }
        }
    }

    public final c.b.a.m.q.g h() {
        int iOrdinal = this.r.ordinal();
        if (iOrdinal == 1) {
            return new x(this.a, this);
        }
        if (iOrdinal == 2) {
            return new c.b.a.m.q.d(this.a, this);
        }
        if (iOrdinal == 3) {
            return new b0(this.a, this);
        }
        if (iOrdinal == 5) {
            return null;
        }
        StringBuilder sbR = c.a.a.a.a.r("Unrecognized stage: ");
        sbR.append(this.r);
        throw new IllegalStateException(sbR.toString());
    }

    public final g i(g gVar) {
        int iOrdinal = gVar.ordinal();
        if (iOrdinal == 0) {
            return this.n.b() ? g.RESOURCE_CACHE : i(g.RESOURCE_CACHE);
        }
        if (iOrdinal == 1) {
            return this.n.a() ? g.DATA_CACHE : i(g.DATA_CACHE);
        }
        if (iOrdinal == 2) {
            return this.u ? g.FINISHED : g.SOURCE;
        }
        if (iOrdinal == 3 || iOrdinal == 5) {
            return g.FINISHED;
        }
        throw new IllegalArgumentException("Unrecognized stage: " + gVar);
    }

    public final void j(String str, long j2, String str2) {
        StringBuilder sbT = c.a.a.a.a.t(str, " in ");
        sbT.append(c.b.a.s.e.a(j2));
        sbT.append(", load key: ");
        sbT.append(this.f409k);
        sbT.append(str2 != null ? c.a.a.a.a.i(", ", str2) : "");
        sbT.append(", thread: ");
        sbT.append(Thread.currentThread().getName());
        sbT.toString();
    }

    public final void k() {
        boolean zA;
        o();
        r rVar = new r("Failed to load resource", new ArrayList(this.f400b));
        m<?> mVar = (m) this.p;
        synchronized (mVar) {
            mVar.u = rVar;
        }
        synchronized (mVar) {
            mVar.f442c.a();
            if (mVar.y) {
                mVar.g();
            } else {
                if (mVar.f441b.isEmpty()) {
                    throw new IllegalStateException("Received an exception without any callbacks to notify");
                }
                if (mVar.v) {
                    throw new IllegalStateException("Already failed once");
                }
                mVar.v = true;
                c.b.a.m.j jVar = mVar.m;
                m.e eVar = mVar.f441b;
                Objects.requireNonNull(eVar);
                ArrayList<m.d> arrayList = new ArrayList(eVar.a);
                mVar.e(arrayList.size() + 1);
                ((l) mVar.f446g).e(mVar, jVar, null);
                for (m.d dVar : arrayList) {
                    dVar.f454b.execute(new m.a(dVar.a));
                }
                mVar.d();
            }
        }
        e eVar2 = this.f405g;
        synchronized (eVar2) {
            eVar2.f415c = true;
            zA = eVar2.a(false);
        }
        if (zA) {
            l();
        }
    }

    public final void l() {
        e eVar = this.f405g;
        synchronized (eVar) {
            eVar.f414b = false;
            eVar.a = false;
            eVar.f415c = false;
        }
        c<?> cVar = this.f404f;
        cVar.a = null;
        cVar.f412b = null;
        cVar.f413c = null;
        h<R> hVar = this.a;
        hVar.f390c = null;
        hVar.f391d = null;
        hVar.n = null;
        hVar.f394g = null;
        hVar.f398k = null;
        hVar.f396i = null;
        hVar.o = null;
        hVar.f397j = null;
        hVar.p = null;
        hVar.a.clear();
        hVar.f399l = false;
        hVar.f389b.clear();
        hVar.m = false;
        this.D = false;
        this.f406h = null;
        this.f407i = null;
        this.o = null;
        this.f408j = null;
        this.f409k = null;
        this.p = null;
        this.r = null;
        this.C = null;
        this.w = null;
        this.x = null;
        this.z = null;
        this.A = null;
        this.B = null;
        this.t = 0L;
        this.E = false;
        this.v = null;
        this.f400b.clear();
        this.f403e.release(this);
    }

    public final void m() {
        this.w = Thread.currentThread();
        int i2 = c.b.a.s.e.f675b;
        this.t = SystemClock.elapsedRealtimeNanos();
        boolean zB = false;
        while (!this.E && this.C != null && !(zB = this.C.b())) {
            this.r = i(this.r);
            this.C = h();
            if (this.r == g.SOURCE) {
                this.s = f.SWITCH_TO_SOURCE_SERVICE;
                ((m) this.p).i(this);
                return;
            }
        }
        if ((this.r == g.FINISHED || this.E) && !zB) {
            k();
        }
    }

    public final void n() {
        int iOrdinal = this.s.ordinal();
        if (iOrdinal == 0) {
            this.r = i(g.INITIALIZE);
            this.C = h();
            m();
        } else if (iOrdinal == 1) {
            m();
        } else if (iOrdinal == 2) {
            g();
        } else {
            StringBuilder sbR = c.a.a.a.a.r("Unrecognized run reason: ");
            sbR.append(this.s);
            throw new IllegalStateException(sbR.toString());
        }
    }

    public final void o() {
        this.f401c.a();
        if (this.D) {
            throw new IllegalStateException("Already notified", this.f400b.isEmpty() ? null : (Throwable) c.a.a.a.a.E(this.f400b, 1));
        }
        this.D = true;
    }

    @Override // java.lang.Runnable
    public void run() {
        DataFetcher<?> dataFetcher = this.B;
        try {
            try {
                if (this.E) {
                    k();
                } else {
                    n();
                    if (dataFetcher != null) {
                        dataFetcher.cleanup();
                    }
                }
            } finally {
                if (dataFetcher != null) {
                    dataFetcher.cleanup();
                }
            }
        } catch (c.b.a.m.q.c e2) {
            throw e2;
        } catch (Throwable th) {
            if (Log.isLoggable("DecodeJob", 3)) {
                String str = "DecodeJob threw unexpectedly, isCancelled: " + this.E + ", stage: " + this.r;
            }
            if (this.r != g.ENCODE) {
                this.f400b.add(th);
                k();
            }
            if (!this.E) {
                throw th;
            }
            throw th;
        }
    }
}

package c.b.a.m.q;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.core.util.Pools;
import c.b.a.m.q.i;
import c.b.a.m.q.q;
import c.b.a.s.j.a;
import c.b.a.s.j.d;
import j$.lang.Iterable;
import j$.util.Spliterator;
import j$.util.function.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: EngineJob.java */
/* JADX INFO: loaded from: classes.dex */
public class m<R> implements i.a<R>, a.d {
    public static final c a = new c();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f441b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c.b.a.s.j.d f442c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final q.a f443d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Pools.Pool<m<?>> f444e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final c f445f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final n f446g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final c.b.a.m.q.e0.a f447h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final c.b.a.m.q.e0.a f448i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final c.b.a.m.q.e0.a f449j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final c.b.a.m.q.e0.a f450k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final AtomicInteger f451l;
    public c.b.a.m.j m;
    public boolean n;
    public boolean o;
    public boolean p;
    public boolean q;
    public w<?> r;
    public c.b.a.m.a s;
    public boolean t;
    public r u;
    public boolean v;
    public q<?> w;
    public i<R> x;
    public volatile boolean y;
    public boolean z;

    /* JADX INFO: compiled from: EngineJob.java */
    public class a implements Runnable {
        public final c.b.a.q.g a;

        public a(c.b.a.q.g gVar) {
            this.a = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.b.a.q.h hVar = (c.b.a.q.h) this.a;
            hVar.f639c.a();
            synchronized (hVar.f640d) {
                synchronized (m.this) {
                    if (m.this.f441b.a.contains(new d(this.a, c.b.a.s.d.f674b))) {
                        m mVar = m.this;
                        c.b.a.q.g gVar = this.a;
                        Objects.requireNonNull(mVar);
                        try {
                            ((c.b.a.q.h) gVar).m(mVar.u, 5);
                        } catch (Throwable th) {
                            throw new c.b.a.m.q.c(th);
                        }
                    }
                    m.this.d();
                }
            }
        }
    }

    /* JADX INFO: compiled from: EngineJob.java */
    public class b implements Runnable {
        public final c.b.a.q.g a;

        public b(c.b.a.q.g gVar) {
            this.a = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.b.a.q.h hVar = (c.b.a.q.h) this.a;
            hVar.f639c.a();
            synchronized (hVar.f640d) {
                synchronized (m.this) {
                    if (m.this.f441b.a.contains(new d(this.a, c.b.a.s.d.f674b))) {
                        m.this.w.a();
                        m mVar = m.this;
                        c.b.a.q.g gVar = this.a;
                        Objects.requireNonNull(mVar);
                        try {
                            ((c.b.a.q.h) gVar).n(mVar.w, mVar.s, mVar.z);
                            m.this.h(this.a);
                        } catch (Throwable th) {
                            throw new c.b.a.m.q.c(th);
                        }
                    }
                    m.this.d();
                }
            }
        }
    }

    /* JADX INFO: compiled from: EngineJob.java */
    @VisibleForTesting
    public static class c {
    }

    /* JADX INFO: compiled from: EngineJob.java */
    public static final class d {
        public final c.b.a.q.g a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Executor f454b;

        public d(c.b.a.q.g gVar, Executor executor) {
            this.a = gVar;
            this.f454b = executor;
        }

        public boolean equals(Object obj) {
            if (obj instanceof d) {
                return this.a.equals(((d) obj).a);
            }
            return false;
        }

        public int hashCode() {
            return this.a.hashCode();
        }
    }

    /* JADX INFO: compiled from: EngineJob.java */
    public static final class e implements Iterable<d>, Iterable {
        public final List<d> a = new ArrayList(2);

        @Override // j$.lang.Iterable
        public /* synthetic */ void forEach(Consumer consumer) {
            Iterable.CC.$default$forEach(this, consumer);
        }

        public boolean isEmpty() {
            return this.a.isEmpty();
        }

        @Override // java.lang.Iterable, j$.lang.Iterable
        @NonNull
        public Iterator<d> iterator() {
            return this.a.iterator();
        }

        @Override // java.lang.Iterable, j$.lang.Iterable
        public /* synthetic */ Spliterator spliterator() {
            return j$.util.v.o(iterator(), 0);
        }
    }

    public m(c.b.a.m.q.e0.a aVar, c.b.a.m.q.e0.a aVar2, c.b.a.m.q.e0.a aVar3, c.b.a.m.q.e0.a aVar4, n nVar, q.a aVar5, Pools.Pool<m<?>> pool) {
        c cVar = a;
        this.f441b = new e();
        this.f442c = new d.b();
        this.f451l = new AtomicInteger();
        this.f447h = aVar;
        this.f448i = aVar2;
        this.f449j = aVar3;
        this.f450k = aVar4;
        this.f446g = nVar;
        this.f443d = aVar5;
        this.f444e = pool;
        this.f445f = cVar;
    }

    public synchronized void a(c.b.a.q.g gVar, Executor executor) {
        this.f442c.a();
        this.f441b.a.add(new d(gVar, executor));
        boolean z = true;
        if (this.t) {
            e(1);
            executor.execute(new b(gVar));
        } else if (this.v) {
            e(1);
            executor.execute(new a(gVar));
        } else {
            if (this.y) {
                z = false;
            }
            c.b.a.m.f.L0(z, "Cannot add callbacks to a cancelled EngineJob");
        }
    }

    @Override // c.b.a.s.j.a.d
    @NonNull
    public c.b.a.s.j.d b() {
        return this.f442c;
    }

    public void c() {
        if (f()) {
            return;
        }
        this.y = true;
        i<R> iVar = this.x;
        iVar.E = true;
        g gVar = iVar.C;
        if (gVar != null) {
            gVar.cancel();
        }
        n nVar = this.f446g;
        c.b.a.m.j jVar = this.m;
        l lVar = (l) nVar;
        synchronized (lVar) {
            t tVar = lVar.f422b;
            Objects.requireNonNull(tVar);
            Map<c.b.a.m.j, m<?>> mapA = tVar.a(this.q);
            if (equals(mapA.get(jVar))) {
                mapA.remove(jVar);
            }
        }
    }

    public void d() {
        q<?> qVar;
        synchronized (this) {
            this.f442c.a();
            c.b.a.m.f.L0(f(), "Not yet complete!");
            int iDecrementAndGet = this.f451l.decrementAndGet();
            c.b.a.m.f.L0(iDecrementAndGet >= 0, "Can't decrement below 0");
            if (iDecrementAndGet == 0) {
                qVar = this.w;
                g();
            } else {
                qVar = null;
            }
        }
        if (qVar != null) {
            qVar.b();
        }
    }

    public synchronized void e(int i2) {
        q<?> qVar;
        c.b.a.m.f.L0(f(), "Not yet complete!");
        if (this.f451l.getAndAdd(i2) == 0 && (qVar = this.w) != null) {
            qVar.a();
        }
    }

    public final boolean f() {
        return this.v || this.t || this.y;
    }

    public final synchronized void g() {
        boolean zA;
        if (this.m == null) {
            throw new IllegalArgumentException();
        }
        this.f441b.a.clear();
        this.m = null;
        this.w = null;
        this.r = null;
        this.v = false;
        this.y = false;
        this.t = false;
        this.z = false;
        i<R> iVar = this.x;
        i.e eVar = iVar.f405g;
        synchronized (eVar) {
            eVar.a = true;
            zA = eVar.a(false);
        }
        if (zA) {
            iVar.l();
        }
        this.x = null;
        this.u = null;
        this.s = null;
        this.f444e.release(this);
    }

    public synchronized void h(c.b.a.q.g gVar) {
        this.f442c.a();
        this.f441b.a.remove(new d(gVar, c.b.a.s.d.f674b));
        if (this.f441b.isEmpty()) {
            c();
            if ((this.t || this.v) && this.f451l.get() == 0) {
                g();
            }
        }
    }

    public void i(i<?> iVar) {
        (this.o ? this.f449j : this.p ? this.f450k : this.f448i).f383c.execute(iVar);
    }
}

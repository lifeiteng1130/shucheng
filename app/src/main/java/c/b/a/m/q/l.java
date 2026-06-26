package c.b.a.m.q;

import android.os.SystemClock;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.util.Pools;
import c.b.a.m.q.a;
import c.b.a.m.q.d0.a;
import c.b.a.m.q.d0.i;
import c.b.a.m.q.i;
import c.b.a.m.q.q;
import c.b.a.s.j.a;
import java.io.File;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: Engine.java */
/* JADX INFO: loaded from: classes.dex */
public class l implements n, i.a, q.a {
    public static final boolean a = Log.isLoggable("Engine", 2);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final t f422b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final p f423c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c.b.a.m.q.d0.i f424d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final b f425e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final z f426f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final c f427g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final a f428h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final c.b.a.m.q.a f429i;

    /* JADX INFO: compiled from: Engine.java */
    @VisibleForTesting
    public static class a {
        public final i.d a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Pools.Pool<i<?>> f430b = c.b.a.s.j.a.a(150, new C0020a());

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f431c;

        /* JADX INFO: renamed from: c.b.a.m.q.l$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: Engine.java */
        public class C0020a implements a.b<i<?>> {
            public C0020a() {
            }

            @Override // c.b.a.s.j.a.b
            public i<?> a() {
                a aVar = a.this;
                return new i<>(aVar.a, aVar.f430b);
            }
        }

        public a(i.d dVar) {
            this.a = dVar;
        }
    }

    /* JADX INFO: compiled from: Engine.java */
    @VisibleForTesting
    public static class b {
        public final c.b.a.m.q.e0.a a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final c.b.a.m.q.e0.a f432b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final c.b.a.m.q.e0.a f433c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final c.b.a.m.q.e0.a f434d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final n f435e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final q.a f436f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final Pools.Pool<m<?>> f437g = c.b.a.s.j.a.a(150, new a());

        /* JADX INFO: compiled from: Engine.java */
        public class a implements a.b<m<?>> {
            public a() {
            }

            @Override // c.b.a.s.j.a.b
            public m<?> a() {
                b bVar = b.this;
                return new m<>(bVar.a, bVar.f432b, bVar.f433c, bVar.f434d, bVar.f435e, bVar.f436f, bVar.f437g);
            }
        }

        public b(c.b.a.m.q.e0.a aVar, c.b.a.m.q.e0.a aVar2, c.b.a.m.q.e0.a aVar3, c.b.a.m.q.e0.a aVar4, n nVar, q.a aVar5) {
            this.a = aVar;
            this.f432b = aVar2;
            this.f433c = aVar3;
            this.f434d = aVar4;
            this.f435e = nVar;
            this.f436f = aVar5;
        }
    }

    /* JADX INFO: compiled from: Engine.java */
    public static class c implements i.d {
        public final a.InterfaceC0016a a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public volatile c.b.a.m.q.d0.a f438b;

        public c(a.InterfaceC0016a interfaceC0016a) {
            this.a = interfaceC0016a;
        }

        public c.b.a.m.q.d0.a a() {
            if (this.f438b == null) {
                synchronized (this) {
                    if (this.f438b == null) {
                        c.b.a.m.q.d0.d dVar = (c.b.a.m.q.d0.d) this.a;
                        c.b.a.m.q.d0.f fVar = (c.b.a.m.q.d0.f) dVar.f365b;
                        File cacheDir = fVar.a.getCacheDir();
                        c.b.a.m.q.d0.e eVar = null;
                        if (cacheDir == null) {
                            cacheDir = null;
                        } else if (fVar.f370b != null) {
                            cacheDir = new File(cacheDir, fVar.f370b);
                        }
                        if (cacheDir != null && (cacheDir.isDirectory() || cacheDir.mkdirs())) {
                            eVar = new c.b.a.m.q.d0.e(cacheDir, dVar.a);
                        }
                        this.f438b = eVar;
                    }
                    if (this.f438b == null) {
                        this.f438b = new c.b.a.m.q.d0.b();
                    }
                }
            }
            return this.f438b;
        }
    }

    /* JADX INFO: compiled from: Engine.java */
    public class d {
        public final m<?> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final c.b.a.q.g f439b;

        public d(c.b.a.q.g gVar, m<?> mVar) {
            this.f439b = gVar;
            this.a = mVar;
        }
    }

    public l(c.b.a.m.q.d0.i iVar, a.InterfaceC0016a interfaceC0016a, c.b.a.m.q.e0.a aVar, c.b.a.m.q.e0.a aVar2, c.b.a.m.q.e0.a aVar3, c.b.a.m.q.e0.a aVar4, boolean z) {
        this.f424d = iVar;
        c cVar = new c(interfaceC0016a);
        this.f427g = cVar;
        c.b.a.m.q.a aVar5 = new c.b.a.m.q.a(z);
        this.f429i = aVar5;
        synchronized (this) {
            synchronized (aVar5) {
                aVar5.f316d = this;
            }
        }
        this.f423c = new p();
        this.f422b = new t();
        this.f425e = new b(aVar, aVar2, aVar3, aVar4, this, this);
        this.f428h = new a(cVar);
        this.f426f = new z();
        ((c.b.a.m.q.d0.h) iVar).a = this;
    }

    public static void d(String str, long j2, c.b.a.m.j jVar) {
        StringBuilder sbT = c.a.a.a.a.t(str, " in ");
        sbT.append(c.b.a.s.e.a(j2));
        sbT.append("ms, key: ");
        sbT.append(jVar);
        sbT.toString();
    }

    @Override // c.b.a.m.q.q.a
    public void a(c.b.a.m.j jVar, q<?> qVar) {
        c.b.a.m.q.a aVar = this.f429i;
        synchronized (aVar) {
            a.b bVarRemove = aVar.f314b.remove(jVar);
            if (bVarRemove != null) {
                bVarRemove.f318c = null;
                bVarRemove.clear();
            }
        }
        if (qVar.a) {
            ((c.b.a.m.q.d0.h) this.f424d).a(jVar, qVar);
        } else {
            this.f426f.a(qVar, false);
        }
    }

    public <R> d b(c.b.a.d dVar, Object obj, c.b.a.m.j jVar, int i2, int i3, Class<?> cls, Class<R> cls2, c.b.a.f fVar, k kVar, Map<Class<?>, c.b.a.m.p<?>> map, boolean z, boolean z2, c.b.a.m.l lVar, boolean z3, boolean z4, boolean z5, boolean z6, c.b.a.q.g gVar, Executor executor) {
        long jElapsedRealtimeNanos;
        if (a) {
            int i4 = c.b.a.s.e.f675b;
            jElapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos();
        } else {
            jElapsedRealtimeNanos = 0;
        }
        long j2 = jElapsedRealtimeNanos;
        Objects.requireNonNull(this.f423c);
        o oVar = new o(obj, jVar, i2, i3, map, cls, cls2, lVar);
        synchronized (this) {
            q<?> qVarC = c(oVar, z3, j2);
            if (qVarC == null) {
                return g(dVar, obj, jVar, i2, i3, cls, cls2, fVar, kVar, map, z, z2, lVar, z3, z4, z5, z6, gVar, executor, oVar, j2);
            }
            ((c.b.a.q.h) gVar).n(qVarC, c.b.a.m.a.MEMORY_CACHE, false);
            return null;
        }
    }

    @Nullable
    public final q<?> c(o oVar, boolean z, long j2) {
        q<?> qVar;
        if (!z) {
            return null;
        }
        c.b.a.m.q.a aVar = this.f429i;
        synchronized (aVar) {
            a.b bVar = aVar.f314b.get(oVar);
            if (bVar == null) {
                qVar = null;
            } else {
                qVar = bVar.get();
                if (qVar == null) {
                    aVar.b(bVar);
                }
            }
        }
        if (qVar != null) {
            qVar.a();
        }
        if (qVar != null) {
            if (a) {
                d("Loaded resource from active resources", j2, oVar);
            }
            return qVar;
        }
        w wVarB = ((c.b.a.m.q.d0.h) this.f424d).b(oVar);
        q<?> qVar2 = wVarB == null ? null : wVarB instanceof q ? (q) wVarB : new q<>(wVarB, true, true, oVar, this);
        if (qVar2 != null) {
            qVar2.a();
            this.f429i.a(oVar, qVar2);
        }
        if (qVar2 == null) {
            return null;
        }
        if (a) {
            d("Loaded resource from cache", j2, oVar);
        }
        return qVar2;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0021 A[Catch: all -> 0x0026, TRY_LEAVE, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x0007, B:7:0x000c, B:9:0x0021), top: B:15:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized void e(c.b.a.m.q.m<?> r2, c.b.a.m.j r3, c.b.a.m.q.q<?> r4) {
        /*
            r1 = this;
            monitor-enter(r1)
            if (r4 == 0) goto Lc
            boolean r0 = r4.a     // Catch: java.lang.Throwable -> L26
            if (r0 == 0) goto Lc
            c.b.a.m.q.a r0 = r1.f429i     // Catch: java.lang.Throwable -> L26
            r0.a(r3, r4)     // Catch: java.lang.Throwable -> L26
        Lc:
            c.b.a.m.q.t r4 = r1.f422b     // Catch: java.lang.Throwable -> L26
            java.util.Objects.requireNonNull(r4)     // Catch: java.lang.Throwable -> L26
            boolean r0 = r2.q     // Catch: java.lang.Throwable -> L26
            java.util.Map r4 = r4.a(r0)     // Catch: java.lang.Throwable -> L26
            java.lang.Object r0 = r4.get(r3)     // Catch: java.lang.Throwable -> L26
            boolean r2 = r2.equals(r0)     // Catch: java.lang.Throwable -> L26
            if (r2 == 0) goto L24
            r4.remove(r3)     // Catch: java.lang.Throwable -> L26
        L24:
            monitor-exit(r1)
            return
        L26:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: c.b.a.m.q.l.e(c.b.a.m.q.m, c.b.a.m.j, c.b.a.m.q.q):void");
    }

    public void f(w<?> wVar) {
        if (!(wVar instanceof q)) {
            throw new IllegalArgumentException("Cannot release anything but an EngineResource");
        }
        ((q) wVar).b();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <R> d g(c.b.a.d dVar, Object obj, c.b.a.m.j jVar, int i2, int i3, Class<?> cls, Class<R> cls2, c.b.a.f fVar, k kVar, Map<Class<?>, c.b.a.m.p<?>> map, boolean z, boolean z2, c.b.a.m.l lVar, boolean z3, boolean z4, boolean z5, boolean z6, c.b.a.q.g gVar, Executor executor, o oVar, long j2) {
        t tVar = this.f422b;
        m<?> mVar = (z6 ? tVar.f471b : tVar.a).get(oVar);
        if (mVar != null) {
            mVar.a(gVar, executor);
            if (a) {
                d("Added to existing load", j2, oVar);
            }
            return new d(gVar, mVar);
        }
        m<?> mVarAcquire = this.f425e.f437g.acquire();
        Objects.requireNonNull(mVarAcquire, "Argument must not be null");
        synchronized (mVarAcquire) {
            mVarAcquire.m = oVar;
            mVarAcquire.n = z3;
            mVarAcquire.o = z4;
            mVarAcquire.p = z5;
            mVarAcquire.q = z6;
        }
        a aVar = this.f428h;
        i<R> iVar = (i) aVar.f430b.acquire();
        Objects.requireNonNull(iVar, "Argument must not be null");
        int i4 = aVar.f431c;
        aVar.f431c = i4 + 1;
        h<R> hVar = iVar.a;
        i.d dVar2 = iVar.f402d;
        hVar.f390c = dVar;
        hVar.f391d = obj;
        hVar.n = jVar;
        hVar.f392e = i2;
        hVar.f393f = i3;
        hVar.p = kVar;
        hVar.f394g = cls;
        hVar.f395h = dVar2;
        hVar.f398k = cls2;
        hVar.o = fVar;
        hVar.f396i = lVar;
        hVar.f397j = map;
        hVar.q = z;
        hVar.r = z2;
        iVar.f406h = dVar;
        iVar.f407i = jVar;
        iVar.f408j = fVar;
        iVar.f409k = oVar;
        iVar.f410l = i2;
        iVar.m = i3;
        iVar.n = kVar;
        iVar.u = z6;
        iVar.o = lVar;
        iVar.p = mVarAcquire;
        iVar.q = i4;
        iVar.s = i.f.INITIALIZE;
        iVar.v = obj;
        t tVar2 = this.f422b;
        Objects.requireNonNull(tVar2);
        tVar2.a(mVarAcquire.q).put(oVar, mVarAcquire);
        mVarAcquire.a(gVar, executor);
        synchronized (mVarAcquire) {
            mVarAcquire.x = iVar;
            i.g gVarI = iVar.i(i.g.INITIALIZE);
            (gVarI == i.g.RESOURCE_CACHE || gVarI == i.g.DATA_CACHE ? mVarAcquire.f447h : mVarAcquire.o ? mVarAcquire.f449j : mVarAcquire.p ? mVarAcquire.f450k : mVarAcquire.f448i).f383c.execute(iVar);
        }
        if (a) {
            d("Started new load", j2, oVar);
        }
        return new d(gVar, mVarAcquire);
    }
}

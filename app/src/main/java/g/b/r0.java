package g.b;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: EventLoop.common.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class r0 extends s0 implements h0 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f6290e = AtomicReferenceFieldUpdater.newUpdater(r0.class, Object.class, "_queue");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f6291f = AtomicReferenceFieldUpdater.newUpdater(r0.class, Object.class, "_delayed");
    private volatile /* synthetic */ Object _queue = null;
    private volatile /* synthetic */ Object _delayed = null;
    private volatile /* synthetic */ int _isCompleted = 0;

    /* JADX INFO: compiled from: EventLoop.common.kt */
    public final class a extends c {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final h<f.v> f6292d;

        /* JADX WARN: Multi-variable type inference failed */
        public a(long j2, @NotNull h<? super f.v> hVar) {
            super(j2);
            this.f6292d = hVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f6292d.b(r0.this, f.v.a);
        }

        @Override // g.b.r0.c
        @NotNull
        public String toString() {
            return super.toString() + this.f6292d.toString();
        }
    }

    /* JADX INFO: compiled from: EventLoop.common.kt */
    public static final class b extends c {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Runnable f6294d;

        public b(long j2, @NotNull Runnable runnable) {
            super(j2);
            this.f6294d = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f6294d.run();
        }

        @Override // g.b.r0.c
        @NotNull
        public String toString() {
            return super.toString() + this.f6294d.toString();
        }
    }

    /* JADX INFO: compiled from: EventLoop.common.kt */
    public static abstract class c implements Runnable, Comparable<c>, m0, g.b.g2.u {
        public Object a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f6295b = -1;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @JvmField
        public long f6296c;

        public c(long j2) {
            this.f6296c = j2;
        }

        @Override // g.b.g2.u
        public void a(@Nullable g.b.g2.t<?> tVar) {
            if (!(this.a != t0.a)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            this.a = tVar;
        }

        @Override // g.b.g2.u
        @Nullable
        public g.b.g2.t<?> c() {
            Object obj = this.a;
            if (!(obj instanceof g.b.g2.t)) {
                obj = null;
            }
            return (g.b.g2.t) obj;
        }

        @Override // java.lang.Comparable
        public int compareTo(c cVar) {
            long j2 = this.f6296c - cVar.f6296c;
            if (j2 > 0) {
                return 1;
            }
            return j2 < 0 ? -1 : 0;
        }

        @Override // g.b.g2.u
        public void d(int i2) {
            this.f6295b = i2;
        }

        @Override // g.b.m0
        public final synchronized void e() {
            Object obj = this.a;
            g.b.g2.q qVar = t0.a;
            if (obj == qVar) {
                return;
            }
            if (!(obj instanceof d)) {
                obj = null;
            }
            d dVar = (d) obj;
            if (dVar != null) {
                synchronized (dVar) {
                    if (c() != null) {
                        dVar.d(f());
                    }
                }
            }
            this.a = qVar;
        }

        @Override // g.b.g2.u
        public int f() {
            return this.f6295b;
        }

        @NotNull
        public String toString() {
            StringBuilder sbR = c.a.a.a.a.r("Delayed[nanos=");
            sbR.append(this.f6296c);
            sbR.append(']');
            return sbR.toString();
        }
    }

    /* JADX INFO: compiled from: EventLoop.common.kt */
    public static final class d extends g.b.g2.t<c> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @JvmField
        public long f6297b;

        public d(long j2) {
            this.f6297b = j2;
        }
    }

    @Override // g.b.h0
    public void a(long j2, @NotNull h<? super f.v> hVar) {
        long jA = t0.a(j2);
        if (jA < 4611686018427387903L) {
            long jNanoTime = System.nanoTime();
            a aVar = new a(jA + jNanoTime, hVar);
            hVar.a(new n0(aVar));
            z(jNanoTime, aVar);
        }
    }

    @Override // g.b.y
    public final void dispatch(@NotNull f.z.f fVar, @NotNull Runnable runnable) {
        v(runnable);
    }

    @NotNull
    public m0 h(long j2, @NotNull Runnable runnable, @NotNull f.z.f fVar) {
        return c.b.a.m.f.n3(j2, runnable, fVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:61:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00b8  */
    @Override // g.b.q0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public long s() {
        /*
            Method dump skipped, instruction units count: 217
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: g.b.r0.s():long");
    }

    @Override // g.b.q0
    public void shutdown() {
        c cVarE;
        y1 y1Var = y1.f6304b;
        y1.a.set(null);
        this._isCompleted = 1;
        while (true) {
            Object obj = this._queue;
            if (obj == null) {
                if (f6290e.compareAndSet(this, null, t0.f6300b)) {
                    break;
                }
            } else if (obj instanceof g.b.g2.l) {
                ((g.b.g2.l) obj).b();
                break;
            } else {
                if (obj == t0.f6300b) {
                    break;
                }
                g.b.g2.l lVar = new g.b.g2.l(8, true);
                lVar.a((Runnable) obj);
                if (f6290e.compareAndSet(this, obj, lVar)) {
                    break;
                }
            }
        }
        while (s() <= 0) {
        }
        long jNanoTime = System.nanoTime();
        while (true) {
            d dVar = (d) this._delayed;
            if (dVar == null || (cVarE = dVar.e()) == null) {
                return;
            } else {
                d0.f6179h.z(jNanoTime, cVarE);
            }
        }
    }

    public final void v(@NotNull Runnable runnable) {
        if (!w(runnable)) {
            d0.f6179h.v(runnable);
            return;
        }
        Thread threadU = u();
        if (Thread.currentThread() != threadU) {
            LockSupport.unpark(threadU);
        }
    }

    public final boolean w(Runnable runnable) {
        while (true) {
            Object obj = this._queue;
            if (this._isCompleted != 0) {
                return false;
            }
            if (obj == null) {
                if (f6290e.compareAndSet(this, null, runnable)) {
                    return true;
                }
            } else if (obj instanceof g.b.g2.l) {
                g.b.g2.l lVar = (g.b.g2.l) obj;
                int iA = lVar.a(runnable);
                if (iA == 0) {
                    return true;
                }
                if (iA == 1) {
                    f6290e.compareAndSet(this, obj, lVar.e());
                } else if (iA == 2) {
                    return false;
                }
            } else {
                if (obj == t0.f6300b) {
                    return false;
                }
                g.b.g2.l lVar2 = new g.b.g2.l(8, true);
                lVar2.a((Runnable) obj);
                lVar2.a(runnable);
                if (f6290e.compareAndSet(this, obj, lVar2)) {
                    return true;
                }
            }
        }
    }

    public boolean x() {
        g.b.g2.a<j0<?>> aVar = this.f6285d;
        if (!(aVar == null || aVar.f6188b == aVar.f6189c)) {
            return false;
        }
        d dVar = (d) this._delayed;
        if (dVar != null && !dVar.c()) {
            return false;
        }
        Object obj = this._queue;
        if (obj == null) {
            return true;
        }
        return obj instanceof g.b.g2.l ? ((g.b.g2.l) obj).d() : obj == t0.f6300b;
    }

    public final void y() {
        this._queue = null;
        this._delayed = null;
    }

    public final void z(long j2, @NotNull c cVar) {
        char c2;
        Thread threadU;
        c cVarB;
        c cVar2 = null;
        if (this._isCompleted == 0) {
            d dVar = (d) this._delayed;
            if (dVar == null) {
                f6291f.compareAndSet(this, null, new d(j2));
                Object obj = this._delayed;
                f.c0.c.j.c(obj);
                dVar = (d) obj;
            }
            synchronized (cVar) {
                if (cVar.a == t0.a) {
                    c2 = 2;
                } else {
                    synchronized (dVar) {
                        c cVarB2 = dVar.b();
                        if (this._isCompleted != 0) {
                            c2 = 1;
                        } else {
                            if (cVarB2 == null) {
                                dVar.f6297b = j2;
                            } else {
                                long j3 = cVarB2.f6296c;
                                if (j3 - j2 >= 0) {
                                    j3 = j2;
                                }
                                if (j3 - dVar.f6297b > 0) {
                                    dVar.f6297b = j3;
                                }
                            }
                            long j4 = cVar.f6296c;
                            long j5 = dVar.f6297b;
                            if (j4 - j5 < 0) {
                                cVar.f6296c = j5;
                            }
                            dVar.a(cVar);
                            c2 = 0;
                        }
                    }
                }
            }
        } else {
            c2 = 1;
        }
        if (c2 != 0) {
            if (c2 == 1) {
                d0.f6179h.z(j2, cVar);
                return;
            } else {
                if (c2 != 2) {
                    throw new IllegalStateException("unexpected result".toString());
                }
                return;
            }
        }
        d dVar2 = (d) this._delayed;
        if (dVar2 != null) {
            synchronized (dVar2) {
                cVarB = dVar2.b();
            }
            cVar2 = cVarB;
        }
        if (!(cVar2 == cVar) || Thread.currentThread() == (threadU = u())) {
            return;
        }
        LockSupport.unpark(threadU);
    }
}

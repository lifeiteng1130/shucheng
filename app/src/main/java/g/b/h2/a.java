package g.b.h2;

import android.support.v4.media.session.PlaybackStateCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.umeng.analytics.pro.ai;
import g.b.g2.q;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.LockSupport;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: CoroutineScheduler.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a implements Executor, Closeable {
    private volatile /* synthetic */ int _isTerminated;
    public volatile /* synthetic */ long controlState;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @JvmField
    @NotNull
    public final d f6218e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @JvmField
    @NotNull
    public final d f6219f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @JvmField
    @NotNull
    public final AtomicReferenceArray<C0185a> f6220g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @JvmField
    public final int f6221h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @JvmField
    public final int f6222i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @JvmField
    public final long f6223j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @JvmField
    @NotNull
    public final String f6224k;
    private volatile /* synthetic */ long parkedWorkersStack;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @JvmField
    @NotNull
    public static final q f6217d = new q("NOT_IN_STACK");
    public static final /* synthetic */ AtomicLongFieldUpdater a = AtomicLongFieldUpdater.newUpdater(a.class, "parkedWorkersStack");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f6215b = AtomicLongFieldUpdater.newUpdater(a.class, "controlState");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f6216c = AtomicIntegerFieldUpdater.newUpdater(a.class, "_isTerminated");

    /* JADX INFO: renamed from: g.b.h2.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: CoroutineScheduler.kt */
    public final class C0185a extends Thread {
        public static final /* synthetic */ AtomicIntegerFieldUpdater a = AtomicIntegerFieldUpdater.newUpdater(C0185a.class, "workerCtl");

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @JvmField
        @NotNull
        public final m f6225b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @JvmField
        @NotNull
        public b f6226c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f6227d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f6228e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f6229f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @JvmField
        public boolean f6230g;
        private volatile int indexInArray;

        @Nullable
        private volatile Object nextParkedWorker;

        @NotNull
        public volatile /* synthetic */ int workerCtl;

        public C0185a(int i2) {
            setDaemon(true);
            this.f6225b = new m();
            this.f6226c = b.DORMANT;
            this.workerCtl = 0;
            this.nextParkedWorker = a.f6217d;
            this.f6229f = f.d0.c.Default.nextInt();
            f(i2);
        }

        @Nullable
        public final i a(boolean z) {
            boolean z2;
            i iVarD;
            i iVarE;
            i iVarE2;
            boolean z3;
            if (this.f6226c == b.CPU_ACQUIRED) {
                z2 = true;
            } else {
                a aVar = a.this;
                while (true) {
                    long j2 = aVar.controlState;
                    if (((int) ((9223367638808264704L & j2) >> 42)) == 0) {
                        z3 = false;
                        break;
                    }
                    if (a.f6215b.compareAndSet(aVar, j2, j2 - 4398046511104L)) {
                        z3 = true;
                        break;
                    }
                }
                if (z3) {
                    this.f6226c = b.CPU_ACQUIRED;
                    z2 = true;
                } else {
                    z2 = false;
                }
            }
            if (!z2) {
                if (!z || (iVarD = this.f6225b.e()) == null) {
                    iVarD = a.this.f6219f.d();
                }
                return iVarD != null ? iVarD : i(true);
            }
            if (z) {
                boolean z4 = d(a.this.f6221h * 2) == 0;
                if (z4 && (iVarE2 = e()) != null) {
                    return iVarE2;
                }
                i iVarE3 = this.f6225b.e();
                if (iVarE3 != null) {
                    return iVarE3;
                }
                if (!z4 && (iVarE = e()) != null) {
                    return iVarE;
                }
            } else {
                i iVarE4 = e();
                if (iVarE4 != null) {
                    return iVarE4;
                }
            }
            return i(false);
        }

        public final int b() {
            return this.indexInArray;
        }

        @Nullable
        public final Object c() {
            return this.nextParkedWorker;
        }

        public final int d(int i2) {
            int i3 = this.f6229f;
            int i4 = i3 ^ (i3 << 13);
            int i5 = i4 ^ (i4 >> 17);
            int i6 = i5 ^ (i5 << 5);
            this.f6229f = i6;
            int i7 = i2 - 1;
            return (i7 & i2) == 0 ? i6 & i7 : (i6 & Integer.MAX_VALUE) % i2;
        }

        public final i e() {
            if (d(2) == 0) {
                i iVarD = a.this.f6218e.d();
                return iVarD != null ? iVarD : a.this.f6219f.d();
            }
            i iVarD2 = a.this.f6219f.d();
            return iVarD2 != null ? iVarD2 : a.this.f6218e.d();
        }

        public final void f(int i2) {
            StringBuilder sb = new StringBuilder();
            sb.append(a.this.f6224k);
            sb.append("-worker-");
            sb.append(i2 == 0 ? "TERMINATED" : String.valueOf(i2));
            setName(sb.toString());
            this.indexInArray = i2;
        }

        public final void g(@Nullable Object obj) {
            this.nextParkedWorker = obj;
        }

        public final boolean h(@NotNull b bVar) {
            b bVar2 = this.f6226c;
            boolean z = bVar2 == b.CPU_ACQUIRED;
            if (z) {
                a.f6215b.addAndGet(a.this, 4398046511104L);
            }
            if (bVar2 != bVar) {
                this.f6226c = bVar;
            }
            return z;
        }

        public final i i(boolean z) {
            long jH;
            long jG;
            int i2 = (int) (a.this.controlState & 2097151);
            if (i2 < 2) {
                return null;
            }
            int iD = d(i2);
            long jMin = RecyclerView.FOREVER_NS;
            for (int i3 = 0; i3 < i2; i3++) {
                iD++;
                if (iD > i2) {
                    iD = 1;
                }
                C0185a c0185a = a.this.f6220g.get(iD);
                if (c0185a != null && c0185a != this) {
                    if (z) {
                        jG = this.f6225b.g(c0185a.f6225b);
                    } else {
                        m mVar = this.f6225b;
                        m mVar2 = c0185a.f6225b;
                        Objects.requireNonNull(mVar);
                        i iVarF = mVar2.f();
                        if (iVarF != null) {
                            mVar.a(iVarF, false);
                            jH = -1;
                        } else {
                            jH = mVar.h(mVar2, false);
                        }
                        jG = jH;
                    }
                    if (jG == -1) {
                        return this.f6225b.e();
                    }
                    if (jG > 0) {
                        jMin = Math.min(jMin, jG);
                    }
                }
            }
            if (jMin == RecyclerView.FOREVER_NS) {
                jMin = 0;
            }
            this.f6228e = jMin;
            return null;
        }

        /* JADX WARN: Code restructure failed: missing block: B:98:0x0003, code lost:
        
            continue;
         */
        @Override // java.lang.Thread, java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void run() {
            /*
                Method dump skipped, instruction units count: 330
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: g.b.h2.a.C0185a.run():void");
        }
    }

    /* JADX INFO: compiled from: CoroutineScheduler.kt */
    public enum b {
        CPU_ACQUIRED,
        BLOCKING,
        PARKING,
        DORMANT,
        TERMINATED
    }

    public a(int i2, int i3, long j2, @NotNull String str) {
        this.f6221h = i2;
        this.f6222i = i3;
        this.f6223j = j2;
        this.f6224k = str;
        if (!(i2 >= 1)) {
            throw new IllegalArgumentException(c.a.a.a.a.d("Core pool size ", i2, " should be at least 1").toString());
        }
        if (!(i3 >= i2)) {
            throw new IllegalArgumentException(c.a.a.a.a.e("Max pool size ", i3, " should be greater than or equals to core pool size ", i2).toString());
        }
        if (!(i3 <= 2097150)) {
            throw new IllegalArgumentException(c.a.a.a.a.d("Max pool size ", i3, " should not exceed maximal supported number of threads 2097150").toString());
        }
        if (!(j2 > 0)) {
            throw new IllegalArgumentException(("Idle worker keep alive time " + j2 + " must be positive").toString());
        }
        this.f6218e = new d();
        this.f6219f = new d();
        this.parkedWorkersStack = 0L;
        this.f6220g = new AtomicReferenceArray<>(i3 + 1);
        this.controlState = ((long) i2) << 42;
        this._isTerminated = 0;
    }

    public static /* synthetic */ void e(a aVar, Runnable runnable, j jVar, boolean z, int i2) {
        g gVar = (i2 & 2) != 0 ? g.a : null;
        if ((i2 & 4) != 0) {
            z = false;
        }
        aVar.d(runnable, gVar, z);
    }

    public final int a() {
        synchronized (this.f6220g) {
            if (this._isTerminated != 0) {
                return -1;
            }
            long j2 = this.controlState;
            int i2 = (int) (j2 & 2097151);
            int i3 = i2 - ((int) ((j2 & 4398044413952L) >> 21));
            if (i3 < 0) {
                i3 = 0;
            }
            if (i3 >= this.f6221h) {
                return 0;
            }
            if (i2 >= this.f6222i) {
                return 0;
            }
            int i4 = ((int) (this.controlState & 2097151)) + 1;
            if (!(i4 > 0 && this.f6220g.get(i4) == null)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            C0185a c0185a = new C0185a(i4);
            this.f6220g.set(i4, c0185a);
            if (!(i4 == ((int) (2097151 & f6215b.incrementAndGet(this))))) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            c0185a.start();
            return i3 + 1;
        }
    }

    @NotNull
    public final i b(@NotNull Runnable runnable, @NotNull j jVar) {
        long jA = l.f6248e.a();
        if (!(runnable instanceof i)) {
            return new k(runnable, jA, jVar);
        }
        i iVar = (i) runnable;
        iVar.a = jA;
        iVar.f6243b = jVar;
        return iVar;
    }

    public final C0185a c() {
        Thread threadCurrentThread = Thread.currentThread();
        if (!(threadCurrentThread instanceof C0185a)) {
            threadCurrentThread = null;
        }
        C0185a c0185a = (C0185a) threadCurrentThread;
        if (c0185a == null || !f.c0.c.j.a(a.this, this)) {
            return null;
        }
        return c0185a;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0076  */
    @Override // java.io.Closeable, java.lang.AutoCloseable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void close() throws java.lang.InterruptedException {
        /*
            r9 = this;
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r0 = g.b.h2.a.f6216c
            r1 = 0
            r2 = 1
            boolean r0 = r0.compareAndSet(r9, r1, r2)
            if (r0 != 0) goto Lc
            goto L9c
        Lc:
            g.b.h2.a$a r0 = r9.c()
            java.util.concurrent.atomic.AtomicReferenceArray<g.b.h2.a$a> r3 = r9.f6220g
            monitor-enter(r3)
            long r4 = r9.controlState     // Catch: java.lang.Throwable -> L9d
            r6 = 2097151(0x1fffff, double:1.0361303E-317)
            long r4 = r4 & r6
            int r5 = (int) r4
            monitor-exit(r3)
            if (r2 > r5) goto L63
            r3 = 1
        L1e:
            java.util.concurrent.atomic.AtomicReferenceArray<g.b.h2.a$a> r4 = r9.f6220g
            java.lang.Object r4 = r4.get(r3)
            f.c0.c.j.c(r4)
            g.b.h2.a$a r4 = (g.b.h2.a.C0185a) r4
            if (r4 == r0) goto L5e
        L2b:
            boolean r6 = r4.isAlive()
            if (r6 == 0) goto L3a
            java.util.concurrent.locks.LockSupport.unpark(r4)
            r6 = 10000(0x2710, double:4.9407E-320)
            r4.join(r6)
            goto L2b
        L3a:
            g.b.h2.m r4 = r4.f6225b
            g.b.h2.d r6 = r9.f6219f
            java.util.Objects.requireNonNull(r4)
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r7 = g.b.h2.m.a
            r8 = 0
            java.lang.Object r7 = r7.getAndSet(r4, r8)
            g.b.h2.i r7 = (g.b.h2.i) r7
            if (r7 == 0) goto L4f
            r6.a(r7)
        L4f:
            g.b.h2.i r7 = r4.f()
            if (r7 == 0) goto L5a
            r6.a(r7)
            r7 = 1
            goto L5b
        L5a:
            r7 = 0
        L5b:
            if (r7 == 0) goto L5e
            goto L4f
        L5e:
            if (r3 == r5) goto L63
            int r3 = r3 + 1
            goto L1e
        L63:
            g.b.h2.d r1 = r9.f6219f
            r1.b()
            g.b.h2.d r1 = r9.f6218e
            r1.b()
        L6d:
            if (r0 == 0) goto L76
            g.b.h2.i r1 = r0.a(r2)
            if (r1 == 0) goto L76
            goto L7e
        L76:
            g.b.h2.d r1 = r9.f6218e
            java.lang.Object r1 = r1.d()
            g.b.h2.i r1 = (g.b.h2.i) r1
        L7e:
            if (r1 == 0) goto L81
            goto L89
        L81:
            g.b.h2.d r1 = r9.f6219f
            java.lang.Object r1 = r1.d()
            g.b.h2.i r1 = (g.b.h2.i) r1
        L89:
            if (r1 == 0) goto L8f
            r9.i(r1)
            goto L6d
        L8f:
            if (r0 == 0) goto L96
            g.b.h2.a$b r1 = g.b.h2.a.b.TERMINATED
            r0.h(r1)
        L96:
            r0 = 0
            r9.parkedWorkersStack = r0
            r9.controlState = r0
        L9c:
            return
        L9d:
            r0 = move-exception
            monitor-exit(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: g.b.h2.a.close():void");
    }

    public final void d(@NotNull Runnable runnable, @NotNull j jVar, boolean z) {
        i iVarA;
        i iVarB = b(runnable, jVar);
        C0185a c0185aC = c();
        if (c0185aC == null || c0185aC.f6226c == b.TERMINATED || (iVarB.f6243b.g() == 0 && c0185aC.f6226c == b.BLOCKING)) {
            iVarA = iVarB;
        } else {
            c0185aC.f6230g = true;
            iVarA = c0185aC.f6225b.a(iVarB, z);
        }
        if (iVarA != null) {
            if (!(iVarA.f6243b.g() == 1 ? this.f6219f.a(iVarA) : this.f6218e.a(iVarA))) {
                throw new RejectedExecutionException(c.a.a.a.a.p(new StringBuilder(), this.f6224k, " was terminated"));
            }
        }
        boolean z2 = z && c0185aC != null;
        if (iVarB.f6243b.g() == 0) {
            if (z2) {
                return;
            }
            j();
        } else {
            long jAddAndGet = f6215b.addAndGet(this, PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE);
            if (z2 || l() || k(jAddAndGet)) {
                return;
            }
            l();
        }
    }

    @Override // java.util.concurrent.Executor
    public void execute(@NotNull Runnable runnable) {
        e(this, runnable, null, false, 6);
    }

    public final int f(C0185a c0185a) {
        Object objC = c0185a.c();
        while (objC != f6217d) {
            if (objC == null) {
                return 0;
            }
            C0185a c0185a2 = (C0185a) objC;
            int iB = c0185a2.b();
            if (iB != 0) {
                return iB;
            }
            objC = c0185a2.c();
        }
        return -1;
    }

    public final boolean g(@NotNull C0185a c0185a) {
        long j2;
        long j3;
        int iB;
        if (c0185a.c() != f6217d) {
            return false;
        }
        do {
            j2 = this.parkedWorkersStack;
            j3 = (PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE + j2) & (-2097152);
            iB = c0185a.b();
            c0185a.g(this.f6220g.get((int) (2097151 & j2)));
        } while (!a.compareAndSet(this, j2, j3 | ((long) iB)));
        return true;
    }

    public final void h(@NotNull C0185a c0185a, int i2, int i3) {
        while (true) {
            long j2 = this.parkedWorkersStack;
            int iF = (int) (2097151 & j2);
            long j3 = (PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE + j2) & (-2097152);
            if (iF == i2) {
                iF = i3 == 0 ? f(c0185a) : i3;
            }
            if (iF >= 0 && a.compareAndSet(this, j2, j3 | ((long) iF))) {
                return;
            }
        }
    }

    public final void i(@NotNull i iVar) {
        try {
            iVar.run();
        } finally {
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [boolean, int] */
    public final boolean isTerminated() {
        return this._isTerminated;
    }

    public final void j() {
        if (l() || k(this.controlState)) {
            return;
        }
        l();
    }

    public final boolean k(long j2) {
        int i2 = ((int) (2097151 & j2)) - ((int) ((j2 & 4398044413952L) >> 21));
        if (i2 < 0) {
            i2 = 0;
        }
        if (i2 < this.f6221h) {
            int iA = a();
            if (iA == 1 && this.f6221h > 1) {
                a();
            }
            if (iA > 0) {
                return true;
            }
        }
        return false;
    }

    public final boolean l() {
        while (true) {
            long j2 = this.parkedWorkersStack;
            C0185a c0185a = this.f6220g.get((int) (2097151 & j2));
            if (c0185a != null) {
                long j3 = (PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE + j2) & (-2097152);
                int iF = f(c0185a);
                if (iF >= 0 && a.compareAndSet(this, j2, ((long) iF) | j3)) {
                    c0185a.g(f6217d);
                }
            } else {
                c0185a = null;
            }
            if (c0185a == null) {
                return false;
            }
            if (C0185a.a.compareAndSet(c0185a, -1, 0)) {
                LockSupport.unpark(c0185a);
                return true;
            }
        }
    }

    @NotNull
    public String toString() {
        ArrayList arrayList = new ArrayList();
        int length = this.f6220g.length();
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 1; i7 < length; i7++) {
            C0185a c0185a = this.f6220g.get(i7);
            if (c0185a != null) {
                int iD = c0185a.f6225b.d();
                int iOrdinal = c0185a.f6226c.ordinal();
                if (iOrdinal == 0) {
                    i2++;
                    arrayList.add(String.valueOf(iD) + ai.aD);
                } else if (iOrdinal == 1) {
                    i3++;
                    arrayList.add(String.valueOf(iD) + "b");
                } else if (iOrdinal == 2) {
                    i4++;
                } else if (iOrdinal == 3) {
                    i5++;
                    if (iD > 0) {
                        arrayList.add(String.valueOf(iD) + "d");
                    }
                } else if (iOrdinal == 4) {
                    i6++;
                }
            }
        }
        long j2 = this.controlState;
        return this.f6224k + '@' + c.b.a.m.f.v2(this) + "[Pool Size {core = " + this.f6221h + ", max = " + this.f6222i + "}, Worker States {CPU = " + i2 + ", blocking = " + i3 + ", parked = " + i4 + ", dormant = " + i5 + ", terminated = " + i6 + "}, running workers queues = " + arrayList + ", global CPU queue size = " + this.f6218e.c() + ", global blocking queue size = " + this.f6219f.c() + ", Control State {created workers= " + ((int) (2097151 & j2)) + ", blocking tasks = " + ((int) ((4398044413952L & j2) >> 21)) + ", CPUs acquired = " + (this.f6221h - ((int) ((9223367638808264704L & j2) >> 42))) + "}]";
    }
}

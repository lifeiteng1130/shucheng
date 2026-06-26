package j$.util.stream;

import j$.util.Spliterator;
import j$.util.function.Supplier;
import j$.util.stream.InterfaceC0444l1;
import j$.util.stream.R1;
import java.util.Objects;

/* JADX INFO: renamed from: j$.util.stream.h1, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
abstract class AbstractC0428h1<E_IN, E_OUT, S extends InterfaceC0444l1<E_OUT, S>> extends T1<E_OUT> implements InterfaceC0444l1<E_OUT, S> {
    private final AbstractC0428h1 a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AbstractC0428h1 f8200b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final int f8201c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private AbstractC0428h1 f8202d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f8203e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f8204f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Spliterator f8205g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f8206h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f8207i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Runnable f8208j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f8209k;

    AbstractC0428h1(Spliterator spliterator, int i2, boolean z) {
        this.f8200b = null;
        this.f8205g = spliterator;
        this.a = this;
        int i3 = T2.f8125b & i2;
        this.f8201c = i3;
        this.f8204f = (~(i3 << 1)) & T2.f8130g;
        this.f8203e = 0;
        this.f8209k = z;
    }

    AbstractC0428h1(AbstractC0428h1 abstractC0428h1, int i2) {
        if (abstractC0428h1.f8206h) {
            throw new IllegalStateException("stream has already been operated upon or closed");
        }
        abstractC0428h1.f8206h = true;
        abstractC0428h1.f8202d = this;
        this.f8200b = abstractC0428h1;
        this.f8201c = T2.f8126c & i2;
        this.f8204f = T2.h(i2, abstractC0428h1.f8204f);
        AbstractC0428h1 abstractC0428h12 = abstractC0428h1.a;
        this.a = abstractC0428h12;
        if (F0()) {
            abstractC0428h12.f8207i = true;
        }
        this.f8203e = abstractC0428h1.f8203e + 1;
    }

    private Spliterator H0(int i2) {
        int i3;
        int i4;
        AbstractC0428h1<E_IN, E_OUT, S> abstractC0428h1 = this.a;
        Spliterator spliteratorE0 = abstractC0428h1.f8205g;
        if (spliteratorE0 == null) {
            throw new IllegalStateException("source already consumed or closed");
        }
        abstractC0428h1.f8205g = null;
        if (abstractC0428h1.f8209k && abstractC0428h1.f8207i) {
            AbstractC0428h1<E_IN, E_OUT, S> abstractC0428h12 = abstractC0428h1.f8202d;
            int i5 = 1;
            while (abstractC0428h1 != this) {
                int i6 = abstractC0428h12.f8201c;
                if (abstractC0428h12.F0()) {
                    i5 = 0;
                    if (T2.SHORT_CIRCUIT.n(i6)) {
                        i6 &= ~T2.p;
                    }
                    spliteratorE0 = abstractC0428h12.E0(abstractC0428h1, spliteratorE0);
                    if (spliteratorE0.hasCharacteristics(64)) {
                        i3 = i6 & (~T2.o);
                        i4 = T2.n;
                    } else {
                        i3 = i6 & (~T2.n);
                        i4 = T2.o;
                    }
                    i6 = i3 | i4;
                }
                abstractC0428h12.f8203e = i5;
                abstractC0428h12.f8204f = T2.h(i6, abstractC0428h1.f8204f);
                i5++;
                AbstractC0428h1<E_IN, E_OUT, S> abstractC0428h13 = abstractC0428h12;
                abstractC0428h12 = abstractC0428h12.f8202d;
                abstractC0428h1 = abstractC0428h13;
            }
        }
        if (i2 != 0) {
            this.f8204f = T2.h(i2, this.f8204f);
        }
        return spliteratorE0;
    }

    abstract U2 A0();

    final boolean B0() {
        return T2.ORDERED.n(this.f8204f);
    }

    public /* synthetic */ Spliterator C0() {
        return H0(0);
    }

    R1 D0(T1 t1, Spliterator spliterator, j$.util.function.z zVar) {
        throw new UnsupportedOperationException("Parallel evaluation is not supported");
    }

    Spliterator E0(T1 t1, Spliterator spliterator) {
        return D0(t1, spliterator, new j$.util.function.z() { // from class: j$.util.stream.j
            @Override // j$.util.function.z
            public final Object apply(int i2) {
                return new Object[i2];
            }
        }).spliterator();
    }

    abstract boolean F0();

    abstract A2 G0(int i2, A2 a2);

    final Spliterator I0() {
        AbstractC0428h1<E_IN, E_OUT, S> abstractC0428h1 = this.a;
        if (this != abstractC0428h1) {
            throw new IllegalStateException();
        }
        if (this.f8206h) {
            throw new IllegalStateException("stream has already been operated upon or closed");
        }
        this.f8206h = true;
        Spliterator spliterator = abstractC0428h1.f8205g;
        if (spliterator == null) {
            throw new IllegalStateException("source already consumed or closed");
        }
        abstractC0428h1.f8205g = null;
        return spliterator;
    }

    abstract Spliterator J0(T1 t1, Supplier supplier, boolean z);

    @Override // j$.util.stream.InterfaceC0444l1, java.lang.AutoCloseable
    public void close() {
        this.f8206h = true;
        this.f8205g = null;
        AbstractC0428h1 abstractC0428h1 = this.a;
        Runnable runnable = abstractC0428h1.f8208j;
        if (runnable != null) {
            abstractC0428h1.f8208j = null;
            runnable.run();
        }
    }

    @Override // j$.util.stream.InterfaceC0444l1
    public final boolean isParallel() {
        return this.a.f8209k;
    }

    @Override // j$.util.stream.T1
    final void m0(A2 a2, Spliterator spliterator) {
        Objects.requireNonNull(a2);
        if (T2.SHORT_CIRCUIT.n(this.f8204f)) {
            n0(a2, spliterator);
            return;
        }
        a2.m(spliterator.getExactSizeIfKnown());
        spliterator.forEachRemaining(a2);
        a2.l();
    }

    @Override // j$.util.stream.T1
    final void n0(A2 a2, Spliterator spliterator) {
        AbstractC0428h1<E_IN, E_OUT, S> abstractC0428h1 = this;
        while (abstractC0428h1.f8203e > 0) {
            abstractC0428h1 = abstractC0428h1.f8200b;
        }
        a2.m(spliterator.getExactSizeIfKnown());
        abstractC0428h1.z0(spliterator, a2);
        a2.l();
    }

    @Override // j$.util.stream.T1
    final R1 o0(Spliterator spliterator, boolean z, j$.util.function.z zVar) {
        if (this.a.f8209k) {
            return y0(this, spliterator, z, zVar);
        }
        R1.a aVarS0 = s0(p0(spliterator), zVar);
        Objects.requireNonNull(aVarS0);
        m0(u0(aVarS0), spliterator);
        return aVarS0.a();
    }

    @Override // j$.util.stream.InterfaceC0444l1
    public InterfaceC0444l1 onClose(Runnable runnable) {
        AbstractC0428h1 abstractC0428h1 = this.a;
        Runnable runnable2 = abstractC0428h1.f8208j;
        if (runnable2 != null) {
            runnable = new f3(runnable2, runnable);
        }
        abstractC0428h1.f8208j = runnable;
        return this;
    }

    @Override // j$.util.stream.T1
    final long p0(Spliterator spliterator) {
        if (T2.SIZED.n(this.f8204f)) {
            return spliterator.getExactSizeIfKnown();
        }
        return -1L;
    }

    public final InterfaceC0444l1 parallel() {
        this.a.f8209k = true;
        return this;
    }

    @Override // j$.util.stream.T1
    final U2 q0() {
        AbstractC0428h1<E_IN, E_OUT, S> abstractC0428h1 = this;
        while (abstractC0428h1.f8203e > 0) {
            abstractC0428h1 = abstractC0428h1.f8200b;
        }
        return abstractC0428h1.A0();
    }

    @Override // j$.util.stream.T1
    final int r0() {
        return this.f8204f;
    }

    public final InterfaceC0444l1 sequential() {
        this.a.f8209k = false;
        return this;
    }

    public Spliterator spliterator() {
        if (this.f8206h) {
            throw new IllegalStateException("stream has already been operated upon or closed");
        }
        this.f8206h = true;
        AbstractC0428h1<E_IN, E_OUT, S> abstractC0428h1 = this.a;
        if (this != abstractC0428h1) {
            return J0(this, new Supplier() { // from class: j$.util.stream.k
                @Override // j$.util.function.Supplier
                public final Object get() {
                    return this.a.C0();
                }
            }, abstractC0428h1.f8209k);
        }
        Spliterator spliterator = abstractC0428h1.f8205g;
        if (spliterator == null) {
            throw new IllegalStateException("source already consumed or closed");
        }
        abstractC0428h1.f8205g = null;
        return spliterator;
    }

    @Override // j$.util.stream.T1
    final A2 t0(A2 a2, Spliterator spliterator) {
        Objects.requireNonNull(a2);
        m0(u0(a2), spliterator);
        return a2;
    }

    @Override // j$.util.stream.T1
    final A2 u0(A2 a2) {
        Objects.requireNonNull(a2);
        for (AbstractC0428h1<E_IN, E_OUT, S> abstractC0428h1 = this; abstractC0428h1.f8203e > 0; abstractC0428h1 = abstractC0428h1.f8200b) {
            a2 = abstractC0428h1.G0(abstractC0428h1.f8200b.f8204f, a2);
        }
        return a2;
    }

    @Override // j$.util.stream.T1
    final Spliterator v0(final Spliterator spliterator) {
        return this.f8203e == 0 ? spliterator : J0(this, new Supplier() { // from class: j$.util.stream.l
            @Override // j$.util.function.Supplier
            public final Object get() {
                return spliterator;
            }
        }, this.a.f8209k);
    }

    final Object w0(g3 g3Var) {
        if (this.f8206h) {
            throw new IllegalStateException("stream has already been operated upon or closed");
        }
        this.f8206h = true;
        return this.a.f8209k ? g3Var.c(this, H0(g3Var.b())) : g3Var.d(this, H0(g3Var.b()));
    }

    final R1 x0(j$.util.function.z zVar) {
        if (this.f8206h) {
            throw new IllegalStateException("stream has already been operated upon or closed");
        }
        this.f8206h = true;
        if (!this.a.f8209k || this.f8200b == null || !F0()) {
            return o0(H0(0), true, zVar);
        }
        this.f8203e = 0;
        AbstractC0428h1 abstractC0428h1 = this.f8200b;
        return D0(abstractC0428h1, abstractC0428h1.H0(0), zVar);
    }

    abstract R1 y0(T1 t1, Spliterator spliterator, boolean z, j$.util.function.z zVar);

    abstract void z0(Spliterator spliterator, A2 a2);
}

package j$.util.stream;

import j$.C0367i0;
import j$.C0371k0;
import j$.C0375m0;
import j$.util.Spliterator;
import j$.util.function.BiConsumer;
import j$.util.function.BiFunction;
import j$.util.function.C0387a;
import j$.util.function.C0388b;
import j$.util.function.C0396j;
import j$.util.function.C0397k;
import j$.util.function.Function;
import j$.util.function.Supplier;
import j$.util.function.ToLongFunction;
import j$.util.stream.A2;
import j$.util.stream.AbstractC0460p1;
import j$.util.stream.AbstractC0487w1;
import j$.util.stream.AbstractC0496y2;
import j$.util.stream.R1;
import j$.util.t;
import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
abstract class D1<E_IN> extends AbstractC0428h1<E_IN, Long, H1> implements H1 {

    class a extends AbstractC0460p1.i<Long> {

        /* JADX INFO: renamed from: j$.util.stream.D1$a$a, reason: collision with other inner class name */
        class C0220a extends A2.c<Double> {
            C0220a(a aVar, A2 a2) {
                super(a2);
            }

            @Override // j$.util.stream.A2.g, j$.util.stream.A2
            public void accept(long j2) {
                this.a.accept(j2);
            }
        }

        a(D1 d1, AbstractC0428h1 abstractC0428h1, U2 u2, int i2) {
            super(abstractC0428h1, u2, i2);
        }

        @Override // j$.util.stream.AbstractC0428h1
        A2 G0(int i2, A2 a2) {
            return new C0220a(this, a2);
        }
    }

    class b extends i<Long> {

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final /* synthetic */ j$.util.function.H f8027l;

        class a extends A2.c<Long> {
            a(A2 a2) {
                super(a2);
            }

            @Override // j$.util.stream.A2.g, j$.util.stream.A2
            public void accept(long j2) {
                this.a.accept(b.this.f8027l.applyAsLong(j2));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(D1 d1, AbstractC0428h1 abstractC0428h1, U2 u2, int i2, j$.util.function.H h2) {
            super(abstractC0428h1, u2, i2);
            this.f8027l = h2;
        }

        @Override // j$.util.stream.AbstractC0428h1
        A2 G0(int i2, A2 a2) {
            return new a(a2);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [U] */
    class c<U> extends AbstractC0496y2.m<Long, U> {

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final /* synthetic */ j$.util.function.F f8029l;

        class a extends A2.c<U> {
            a(A2 a2) {
                super(a2);
            }

            @Override // j$.util.stream.A2.g, j$.util.stream.A2
            public void accept(long j2) {
                this.a.accept(c.this.f8029l.apply(j2));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(D1 d1, AbstractC0428h1 abstractC0428h1, U2 u2, int i2, j$.util.function.F f2) {
            super(abstractC0428h1, u2, i2);
            this.f8029l = f2;
        }

        @Override // j$.util.stream.AbstractC0428h1
        A2 G0(int i2, A2 a2) {
            return new a(a2);
        }
    }

    class d extends i<Long> {

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final /* synthetic */ j$.util.function.F f8031l;

        class a extends A2.c<Long> {
            a(A2 a2) {
                super(a2);
            }

            @Override // j$.util.stream.A2.g, j$.util.stream.A2
            public void accept(long j2) {
                H1 h1 = (H1) d.this.f8031l.apply(j2);
                if (h1 != null) {
                    try {
                        h1.sequential().f(new j$.util.function.E() { // from class: j$.util.stream.P
                            @Override // j$.util.function.E
                            public final void accept(long j3) {
                                this.a.a.accept(j3);
                            }

                            @Override // j$.util.function.E
                            public j$.util.function.E f(j$.util.function.E e2) {
                                Objects.requireNonNull(e2);
                                return new C0396j(this, e2);
                            }
                        });
                    } catch (Throwable th) {
                        try {
                            h1.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                        throw th;
                    }
                }
                if (h1 != null) {
                    h1.close();
                }
            }

            @Override // j$.util.stream.A2.c, j$.util.stream.A2
            public void m(long j2) {
                this.a.m(-1L);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(D1 d1, AbstractC0428h1 abstractC0428h1, U2 u2, int i2, j$.util.function.F f2) {
            super(abstractC0428h1, u2, i2);
            this.f8031l = f2;
        }

        @Override // j$.util.stream.AbstractC0428h1
        A2 G0(int i2, A2 a2) {
            return new a(a2);
        }
    }

    class e extends i<Long> {

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final /* synthetic */ j$.util.function.G f8033l;

        class a extends A2.c<Long> {
            a(A2 a2) {
                super(a2);
            }

            @Override // j$.util.stream.A2.g, j$.util.stream.A2
            public void accept(long j2) {
                if (((C0367i0) e.this.f8033l).b(j2)) {
                    this.a.accept(j2);
                }
            }

            @Override // j$.util.stream.A2.c, j$.util.stream.A2
            public void m(long j2) {
                this.a.m(-1L);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(D1 d1, AbstractC0428h1 abstractC0428h1, U2 u2, int i2, j$.util.function.G g2) {
            super(abstractC0428h1, u2, i2);
            this.f8033l = g2;
        }

        @Override // j$.util.stream.AbstractC0428h1
        A2 G0(int i2, A2 a2) {
            return new a(a2);
        }
    }

    class f extends i<Long> {

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final /* synthetic */ j$.util.function.E f8035l;

        class a extends A2.c<Long> {
            a(A2 a2) {
                super(a2);
            }

            @Override // j$.util.stream.A2.g, j$.util.stream.A2
            public void accept(long j2) {
                f.this.f8035l.accept(j2);
                this.a.accept(j2);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(D1 d1, AbstractC0428h1 abstractC0428h1, U2 u2, int i2, j$.util.function.E e2) {
            super(abstractC0428h1, u2, i2);
            this.f8035l = e2;
        }

        @Override // j$.util.stream.AbstractC0428h1
        A2 G0(int i2, A2 a2) {
            return new a(a2);
        }
    }

    static class g<E_IN> extends D1<E_IN> {
        g(Spliterator spliterator, int i2, boolean z) {
            super(spliterator, i2, z);
        }

        @Override // j$.util.stream.AbstractC0428h1
        final boolean F0() {
            throw new UnsupportedOperationException();
        }

        @Override // j$.util.stream.AbstractC0428h1
        final A2 G0(int i2, A2 a2) {
            throw new UnsupportedOperationException();
        }

        @Override // j$.util.stream.D1, j$.util.stream.H1
        public void Y(j$.util.function.E e2) {
            if (!isParallel()) {
                D1.L0(I0()).e(e2);
            } else {
                Objects.requireNonNull(e2);
                w0(new AbstractC0487w1.c(e2, true));
            }
        }

        @Override // j$.util.stream.D1, j$.util.stream.H1
        public void f(j$.util.function.E e2) {
            if (isParallel()) {
                super.f(e2);
            } else {
                D1.L0(I0()).e(e2);
            }
        }

        @Override // j$.util.stream.AbstractC0428h1, j$.util.stream.InterfaceC0444l1
        public /* bridge */ /* synthetic */ H1 parallel() {
            parallel();
            return this;
        }

        @Override // j$.util.stream.AbstractC0428h1, j$.util.stream.InterfaceC0444l1
        public /* bridge */ /* synthetic */ H1 sequential() {
            sequential();
            return this;
        }
    }

    static abstract class h<E_IN> extends D1<E_IN> {
        h(AbstractC0428h1 abstractC0428h1, U2 u2, int i2) {
            super(abstractC0428h1, i2);
        }

        @Override // j$.util.stream.AbstractC0428h1
        final boolean F0() {
            return true;
        }

        @Override // j$.util.stream.AbstractC0428h1, j$.util.stream.InterfaceC0444l1
        public /* bridge */ /* synthetic */ H1 parallel() {
            parallel();
            return this;
        }

        @Override // j$.util.stream.AbstractC0428h1, j$.util.stream.InterfaceC0444l1
        public /* bridge */ /* synthetic */ H1 sequential() {
            sequential();
            return this;
        }
    }

    static abstract class i<E_IN> extends D1<E_IN> {
        i(AbstractC0428h1 abstractC0428h1, U2 u2, int i2) {
            super(abstractC0428h1, i2);
        }

        @Override // j$.util.stream.AbstractC0428h1
        final boolean F0() {
            return false;
        }

        @Override // j$.util.stream.AbstractC0428h1, j$.util.stream.InterfaceC0444l1
        public /* bridge */ /* synthetic */ H1 parallel() {
            parallel();
            return this;
        }

        @Override // j$.util.stream.AbstractC0428h1, j$.util.stream.InterfaceC0444l1
        public /* bridge */ /* synthetic */ H1 sequential() {
            sequential();
            return this;
        }
    }

    D1(Spliterator spliterator, int i2, boolean z) {
        super(spliterator, i2, z);
    }

    D1(AbstractC0428h1 abstractC0428h1, int i2) {
        super(abstractC0428h1, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Spliterator.c L0(Spliterator spliterator) {
        if (spliterator instanceof Spliterator.c) {
            return (Spliterator.c) spliterator;
        }
        if (!i3.a) {
            throw new UnsupportedOperationException("LongStream.adapt(Spliterator<Long> s)");
        }
        i3.a(AbstractC0428h1.class, "using LongStream.adapt(Spliterator<Long> s)");
        throw null;
    }

    @Override // j$.util.stream.H1
    public final long A(long j2, j$.util.function.D d2) {
        Objects.requireNonNull(d2);
        return ((Long) w0(new C0465q2(U2.LONG_VALUE, d2, j2))).longValue();
    }

    @Override // j$.util.stream.AbstractC0428h1
    final U2 A0() {
        return U2.LONG_VALUE;
    }

    @Override // j$.util.stream.AbstractC0428h1
    final Spliterator J0(T1 t1, Supplier supplier, boolean z) {
        return new b3(t1, supplier, z);
    }

    @Override // j$.util.stream.H1
    public final Stream N(j$.util.function.F f2) {
        Objects.requireNonNull(f2);
        return new c(this, this, U2.LONG_VALUE, T2.f8134k | T2.f8132i, f2);
    }

    @Override // j$.util.stream.H1
    public void Y(j$.util.function.E e2) {
        Objects.requireNonNull(e2);
        w0(new AbstractC0487w1.c(e2, true));
    }

    @Override // j$.util.stream.H1
    public final InterfaceC0471s1 asDoubleStream() {
        return new a(this, this, U2.LONG_VALUE, T2.f8134k | T2.f8132i);
    }

    @Override // j$.util.stream.H1
    public final j$.util.p average() {
        return ((long[]) d0(new Supplier() { // from class: j$.util.stream.V
            @Override // j$.util.function.Supplier
            public final Object get() {
                return new long[2];
            }
        }, new j$.util.function.K() { // from class: j$.util.stream.O
            @Override // j$.util.function.K
            public final void accept(Object obj, long j2) {
                long[] jArr = (long[]) obj;
                jArr[0] = jArr[0] + 1;
                jArr[1] = jArr[1] + j2;
            }
        }, new BiConsumer() { // from class: j$.util.stream.N
            @Override // j$.util.function.BiConsumer
            public BiConsumer a(BiConsumer biConsumer) {
                Objects.requireNonNull(biConsumer);
                return new C0387a(this, biConsumer);
            }

            @Override // j$.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                long[] jArr = (long[]) obj;
                long[] jArr2 = (long[]) obj2;
                jArr[0] = jArr[0] + jArr2[0];
                jArr[1] = jArr[1] + jArr2[1];
            }
        }))[0] > 0 ? j$.util.p.d(r0[1] / r0[0]) : j$.util.p.a();
    }

    @Override // j$.util.stream.H1
    public final boolean b0(j$.util.function.G g2) {
        return ((Boolean) w0(Q1.t(g2, N1.ANY))).booleanValue();
    }

    @Override // j$.util.stream.H1
    public final Stream boxed() {
        return N(C0398a.a);
    }

    @Override // j$.util.stream.H1
    public final boolean c(j$.util.function.G g2) {
        return ((Boolean) w0(Q1.t(g2, N1.NONE))).booleanValue();
    }

    @Override // j$.util.stream.H1
    public final long count() {
        return ((D1) x(new j$.util.function.H() { // from class: j$.util.stream.U
            @Override // j$.util.function.H
            public j$.util.function.H a(j$.util.function.H h2) {
                Objects.requireNonNull(h2);
                return new C0397k(this, h2);
            }

            @Override // j$.util.function.H
            public final long applyAsLong(long j2) {
                return 1L;
            }

            @Override // j$.util.function.H
            public j$.util.function.H b(j$.util.function.H h2) {
                Objects.requireNonNull(h2);
                return new j$.util.function.l(this, h2);
            }
        })).sum();
    }

    @Override // j$.util.stream.H1
    public final Object d0(Supplier supplier, j$.util.function.K k2, final BiConsumer biConsumer) {
        j$.util.function.p pVar = new j$.util.function.p() { // from class: j$.util.stream.S
            @Override // j$.util.function.BiFunction
            public BiFunction andThen(Function function) {
                Objects.requireNonNull(function);
                return new C0388b(this, function);
            }

            @Override // j$.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                biConsumer.accept(obj, obj2);
                return obj;
            }
        };
        Objects.requireNonNull(supplier);
        Objects.requireNonNull(k2);
        return w0(new U1(U2.LONG_VALUE, pVar, k2, supplier));
    }

    @Override // j$.util.stream.H1
    public final H1 distinct() {
        return ((AbstractC0496y2) N(C0398a.a)).distinct().e0(new ToLongFunction() { // from class: j$.util.stream.T
            @Override // j$.util.function.ToLongFunction
            public final long applyAsLong(Object obj) {
                return ((Long) obj).longValue();
            }
        });
    }

    @Override // j$.util.stream.H1
    public void f(j$.util.function.E e2) {
        Objects.requireNonNull(e2);
        w0(new AbstractC0487w1.c(e2, false));
    }

    @Override // j$.util.stream.H1
    public final boolean f0(j$.util.function.G g2) {
        return ((Boolean) w0(Q1.t(g2, N1.ALL))).booleanValue();
    }

    @Override // j$.util.stream.H1
    public final j$.util.r findAny() {
        return (j$.util.r) w0(new C0475t1(false, U2.LONG_VALUE, j$.util.r.a(), Z0.a, C0415e0.a));
    }

    @Override // j$.util.stream.H1
    public final j$.util.r findFirst() {
        return (j$.util.r) w0(new C0475t1(true, U2.LONG_VALUE, j$.util.r.a(), Z0.a, C0415e0.a));
    }

    @Override // j$.util.stream.H1
    public final H1 g0(j$.util.function.G g2) {
        Objects.requireNonNull(g2);
        return new e(this, this, U2.LONG_VALUE, T2.o, g2);
    }

    @Override // j$.util.stream.H1
    public final j$.util.r i(j$.util.function.D d2) {
        Objects.requireNonNull(d2);
        return (j$.util.r) w0(new C0472s2(U2.LONG_VALUE, d2));
    }

    @Override // j$.util.stream.InterfaceC0444l1
    public final t.c iterator() {
        return j$.util.v.h(spliterator());
    }

    @Override // j$.util.stream.InterfaceC0444l1
    public Iterator iterator() {
        return j$.util.v.h(spliterator());
    }

    @Override // j$.util.stream.H1
    public final InterfaceC0471s1 j(C0371k0 c0371k0) {
        Objects.requireNonNull(c0371k0);
        return new F1(this, this, U2.LONG_VALUE, T2.f8134k | T2.f8132i, c0371k0);
    }

    @Override // j$.util.stream.H1
    public final H1 limit(long j2) {
        if (j2 >= 0) {
            return B2.h(this, 0L, j2);
        }
        throw new IllegalArgumentException(Long.toString(j2));
    }

    @Override // j$.util.stream.H1
    public final j$.util.r max() {
        return i(new j$.util.function.D() { // from class: j$.util.stream.Y0
            @Override // j$.util.function.D
            public final long applyAsLong(long j2, long j3) {
                return Math.max(j2, j3);
            }
        });
    }

    @Override // j$.util.stream.H1
    public final j$.util.r min() {
        return i(new j$.util.function.D() { // from class: j$.util.stream.Y
            @Override // j$.util.function.D
            public final long applyAsLong(long j2, long j3) {
                return Math.min(j2, j3);
            }
        });
    }

    @Override // j$.util.stream.H1
    public final H1 q(j$.util.function.E e2) {
        Objects.requireNonNull(e2);
        return new f(this, this, U2.LONG_VALUE, 0, e2);
    }

    @Override // j$.util.stream.H1
    public final H1 r(j$.util.function.F f2) {
        return new d(this, this, U2.LONG_VALUE, T2.f8134k | T2.f8132i | T2.o, f2);
    }

    @Override // j$.util.stream.T1
    final R1.a s0(long j2, j$.util.function.z zVar) {
        return S1.q(j2);
    }

    @Override // j$.util.stream.H1
    public final H1 skip(long j2) {
        if (j2 >= 0) {
            return j2 == 0 ? this : B2.h(this, j2, -1L);
        }
        throw new IllegalArgumentException(Long.toString(j2));
    }

    @Override // j$.util.stream.H1
    public final H1 sorted() {
        return new L2(this);
    }

    @Override // j$.util.stream.AbstractC0428h1, j$.util.stream.InterfaceC0444l1
    public final Spliterator.c spliterator() {
        return L0(super.spliterator());
    }

    @Override // j$.util.stream.H1
    public final long sum() {
        return ((Long) w0(new C0465q2(U2.LONG_VALUE, new j$.util.function.D() { // from class: j$.util.stream.J0
            @Override // j$.util.function.D
            public final long applyAsLong(long j2, long j3) {
                return j2 + j3;
            }
        }, 0L))).longValue();
    }

    @Override // j$.util.stream.H1
    public final j$.util.n summaryStatistics() {
        return (j$.util.n) d0(new Supplier() { // from class: j$.util.stream.f1
            @Override // j$.util.function.Supplier
            public final Object get() {
                return new j$.util.n();
            }
        }, new j$.util.function.K() { // from class: j$.util.stream.m0
            @Override // j$.util.function.K
            public final void accept(Object obj, long j2) {
                ((j$.util.n) obj).accept(j2);
            }
        }, new BiConsumer() { // from class: j$.util.stream.w0
            @Override // j$.util.function.BiConsumer
            public BiConsumer a(BiConsumer biConsumer) {
                Objects.requireNonNull(biConsumer);
                return new C0387a(this, biConsumer);
            }

            @Override // j$.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                ((j$.util.n) obj).b((j$.util.n) obj2);
            }
        });
    }

    @Override // j$.util.stream.H1
    public final long[] toArray() {
        return (long[]) S1.o((R1.d) x0(new j$.util.function.z() { // from class: j$.util.stream.Q
            @Override // j$.util.function.z
            public final Object apply(int i2) {
                return new Long[i2];
            }
        })).e();
    }

    @Override // j$.util.stream.InterfaceC0444l1
    public InterfaceC0444l1 unordered() {
        return !B0() ? this : new G1(this, this, U2.LONG_VALUE, T2.m);
    }

    @Override // j$.util.stream.H1
    public final C1 w(C0375m0 c0375m0) {
        Objects.requireNonNull(c0375m0);
        return new E1(this, this, U2.LONG_VALUE, T2.f8134k | T2.f8132i, c0375m0);
    }

    @Override // j$.util.stream.H1
    public final H1 x(j$.util.function.H h2) {
        Objects.requireNonNull(h2);
        return new b(this, this, U2.LONG_VALUE, T2.f8134k | T2.f8132i, h2);
    }

    @Override // j$.util.stream.AbstractC0428h1
    final R1 y0(T1 t1, Spliterator spliterator, boolean z, j$.util.function.z zVar) {
        return S1.h(t1, spliterator, z);
    }

    @Override // j$.util.stream.AbstractC0428h1
    final void z0(Spliterator spliterator, A2 a2) {
        j$.util.function.E k0;
        Spliterator.c cVarL0 = L0(spliterator);
        if (a2 instanceof j$.util.function.E) {
            k0 = (j$.util.function.E) a2;
        } else {
            if (i3.a) {
                i3.a(AbstractC0428h1.class, "using LongStream.adapt(Sink<Long> s)");
                throw null;
            }
            k0 = new K0(a2);
        }
        while (!a2.o() && cVarL0.n(k0)) {
        }
    }
}

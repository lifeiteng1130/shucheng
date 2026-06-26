package j$.util.stream;

import j$.C0351a0;
import j$.util.Spliterator;
import j$.util.function.BiConsumer;
import j$.util.function.BiFunction;
import j$.util.function.C0387a;
import j$.util.function.C0388b;
import j$.util.function.C0395i;
import j$.util.function.Function;
import j$.util.function.Supplier;
import j$.util.function.ToIntFunction;
import j$.util.stream.A2;
import j$.util.stream.AbstractC0460p1;
import j$.util.stream.AbstractC0487w1;
import j$.util.stream.AbstractC0496y2;
import j$.util.stream.D1;
import j$.util.stream.R1;
import j$.util.t;
import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: renamed from: j$.util.stream.z1, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
abstract class AbstractC0499z1<E_IN> extends AbstractC0428h1<E_IN, Integer, C1> implements C1 {

    /* JADX INFO: renamed from: j$.util.stream.z1$a */
    class a extends D1.i<Integer> {

        /* JADX INFO: renamed from: j$.util.stream.z1$a$a, reason: collision with other inner class name */
        class C0224a extends A2.b<Long> {
            C0224a(a aVar, A2 a2) {
                super(a2);
            }

            @Override // j$.util.stream.A2.f, j$.util.stream.A2, j$.util.function.y
            public void accept(int i2) {
                this.a.accept(i2);
            }
        }

        a(AbstractC0499z1 abstractC0499z1, AbstractC0428h1 abstractC0428h1, U2 u2, int i2) {
            super(abstractC0428h1, u2, i2);
        }

        @Override // j$.util.stream.AbstractC0428h1
        A2 G0(int i2, A2 a2) {
            return new C0224a(this, a2);
        }
    }

    /* JADX INFO: renamed from: j$.util.stream.z1$b */
    class b extends k<Integer> {

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final /* synthetic */ j$.util.function.y f8314l;

        /* JADX INFO: renamed from: j$.util.stream.z1$b$a */
        class a extends A2.b<Integer> {
            a(A2 a2) {
                super(a2);
            }

            @Override // j$.util.stream.A2.f, j$.util.stream.A2, j$.util.function.y
            public void accept(int i2) {
                b.this.f8314l.accept(i2);
                this.a.accept(i2);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(AbstractC0499z1 abstractC0499z1, AbstractC0428h1 abstractC0428h1, U2 u2, int i2, j$.util.function.y yVar) {
            super(abstractC0428h1, u2, i2);
            this.f8314l = yVar;
        }

        @Override // j$.util.stream.AbstractC0428h1
        A2 G0(int i2, A2 a2) {
            return new a(a2);
        }
    }

    /* JADX INFO: renamed from: j$.util.stream.z1$c */
    class c extends AbstractC0460p1.i<Integer> {

        /* JADX INFO: renamed from: j$.util.stream.z1$c$a */
        class a extends A2.b<Double> {
            a(c cVar, A2 a2) {
                super(a2);
            }

            @Override // j$.util.stream.A2.f, j$.util.stream.A2, j$.util.function.y
            public void accept(int i2) {
                this.a.accept(i2);
            }
        }

        c(AbstractC0499z1 abstractC0499z1, AbstractC0428h1 abstractC0428h1, U2 u2, int i2) {
            super(abstractC0428h1, u2, i2);
        }

        @Override // j$.util.stream.AbstractC0428h1
        A2 G0(int i2, A2 a2) {
            return new a(this, a2);
        }
    }

    /* JADX INFO: renamed from: j$.util.stream.z1$d */
    class d extends k<Integer> {

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final /* synthetic */ j$.util.function.C f8316l;

        /* JADX INFO: renamed from: j$.util.stream.z1$d$a */
        class a extends A2.b<Integer> {
            a(A2 a2) {
                super(a2);
            }

            @Override // j$.util.stream.A2.f, j$.util.stream.A2, j$.util.function.y
            public void accept(int i2) {
                this.a.accept(((C0351a0) d.this.f8316l).a(i2));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(AbstractC0499z1 abstractC0499z1, AbstractC0428h1 abstractC0428h1, U2 u2, int i2, j$.util.function.C c2) {
            super(abstractC0428h1, u2, i2);
            this.f8316l = c2;
        }

        @Override // j$.util.stream.AbstractC0428h1
        A2 G0(int i2, A2 a2) {
            return new a(a2);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [U] */
    /* JADX INFO: renamed from: j$.util.stream.z1$e */
    class e<U> extends AbstractC0496y2.m<Integer, U> {

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final /* synthetic */ j$.util.function.z f8318l;

        /* JADX INFO: renamed from: j$.util.stream.z1$e$a */
        class a extends A2.b<U> {
            a(A2 a2) {
                super(a2);
            }

            @Override // j$.util.stream.A2.f, j$.util.stream.A2, j$.util.function.y
            public void accept(int i2) {
                this.a.accept(e.this.f8318l.apply(i2));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(AbstractC0499z1 abstractC0499z1, AbstractC0428h1 abstractC0428h1, U2 u2, int i2, j$.util.function.z zVar) {
            super(abstractC0428h1, u2, i2);
            this.f8318l = zVar;
        }

        @Override // j$.util.stream.AbstractC0428h1
        A2 G0(int i2, A2 a2) {
            return new a(a2);
        }
    }

    /* JADX INFO: renamed from: j$.util.stream.z1$f */
    class f extends D1.i<Integer> {

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final /* synthetic */ j$.util.function.B f8320l;

        /* JADX INFO: renamed from: j$.util.stream.z1$f$a */
        class a extends A2.b<Long> {
            a(A2 a2) {
                super(a2);
            }

            @Override // j$.util.stream.A2.f, j$.util.stream.A2, j$.util.function.y
            public void accept(int i2) {
                this.a.accept(f.this.f8320l.applyAsLong(i2));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(AbstractC0499z1 abstractC0499z1, AbstractC0428h1 abstractC0428h1, U2 u2, int i2, j$.util.function.B b2) {
            super(abstractC0428h1, u2, i2);
            this.f8320l = b2;
        }

        @Override // j$.util.stream.AbstractC0428h1
        A2 G0(int i2, A2 a2) {
            return new a(a2);
        }
    }

    /* JADX INFO: renamed from: j$.util.stream.z1$g */
    class g extends k<Integer> {

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final /* synthetic */ j$.util.function.z f8322l;

        /* JADX INFO: renamed from: j$.util.stream.z1$g$a */
        class a extends A2.b<Integer> {
            a(A2 a2) {
                super(a2);
            }

            @Override // j$.util.stream.A2.f, j$.util.stream.A2, j$.util.function.y
            public void accept(int i2) {
                C1 c1 = (C1) g.this.f8322l.apply(i2);
                if (c1 != null) {
                    try {
                        c1.sequential().Q(new j$.util.function.y() { // from class: j$.util.stream.F
                            @Override // j$.util.function.y
                            public final void accept(int i3) {
                                this.a.a.accept(i3);
                            }

                            @Override // j$.util.function.y
                            public j$.util.function.y k(j$.util.function.y yVar) {
                                Objects.requireNonNull(yVar);
                                return new C0395i(this, yVar);
                            }
                        });
                    } catch (Throwable th) {
                        try {
                            c1.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                        throw th;
                    }
                }
                if (c1 != null) {
                    c1.close();
                }
            }

            @Override // j$.util.stream.A2.b, j$.util.stream.A2
            public void m(long j2) {
                this.a.m(-1L);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(AbstractC0499z1 abstractC0499z1, AbstractC0428h1 abstractC0428h1, U2 u2, int i2, j$.util.function.z zVar) {
            super(abstractC0428h1, u2, i2);
            this.f8322l = zVar;
        }

        @Override // j$.util.stream.AbstractC0428h1
        A2 G0(int i2, A2 a2) {
            return new a(a2);
        }
    }

    /* JADX INFO: renamed from: j$.util.stream.z1$h */
    class h extends k<Integer> {

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final /* synthetic */ j$.util.function.A f8324l;

        /* JADX INFO: renamed from: j$.util.stream.z1$h$a */
        class a extends A2.b<Integer> {
            a(A2 a2) {
                super(a2);
            }

            @Override // j$.util.stream.A2.f, j$.util.stream.A2, j$.util.function.y
            public void accept(int i2) {
                if (((j$.U) h.this.f8324l).b(i2)) {
                    this.a.accept(i2);
                }
            }

            @Override // j$.util.stream.A2.b, j$.util.stream.A2
            public void m(long j2) {
                this.a.m(-1L);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        h(AbstractC0499z1 abstractC0499z1, AbstractC0428h1 abstractC0428h1, U2 u2, int i2, j$.util.function.A a2) {
            super(abstractC0428h1, u2, i2);
            this.f8324l = a2;
        }

        @Override // j$.util.stream.AbstractC0428h1
        A2 G0(int i2, A2 a2) {
            return new a(a2);
        }
    }

    /* JADX INFO: renamed from: j$.util.stream.z1$i */
    static class i<E_IN> extends AbstractC0499z1<E_IN> {
        i(Spliterator spliterator, int i2, boolean z) {
            super(spliterator, i2, z);
        }

        @Override // j$.util.stream.AbstractC0499z1, j$.util.stream.C1
        public void E(j$.util.function.y yVar) {
            if (!isParallel()) {
                AbstractC0499z1.L0(I0()).e(yVar);
            } else {
                Objects.requireNonNull(yVar);
                w0(new AbstractC0487w1.b(yVar, true));
            }
        }

        @Override // j$.util.stream.AbstractC0428h1
        final boolean F0() {
            throw new UnsupportedOperationException();
        }

        @Override // j$.util.stream.AbstractC0428h1
        final A2 G0(int i2, A2 a2) {
            throw new UnsupportedOperationException();
        }

        @Override // j$.util.stream.AbstractC0499z1, j$.util.stream.C1
        public void Q(j$.util.function.y yVar) {
            if (isParallel()) {
                super.Q(yVar);
            } else {
                AbstractC0499z1.L0(I0()).e(yVar);
            }
        }

        @Override // j$.util.stream.AbstractC0428h1, j$.util.stream.InterfaceC0444l1
        public /* bridge */ /* synthetic */ C1 parallel() {
            parallel();
            return this;
        }

        @Override // j$.util.stream.AbstractC0428h1, j$.util.stream.InterfaceC0444l1
        public /* bridge */ /* synthetic */ C1 sequential() {
            sequential();
            return this;
        }
    }

    /* JADX INFO: renamed from: j$.util.stream.z1$j */
    static abstract class j<E_IN> extends AbstractC0499z1<E_IN> {
        j(AbstractC0428h1 abstractC0428h1, U2 u2, int i2) {
            super(abstractC0428h1, i2);
        }

        @Override // j$.util.stream.AbstractC0428h1
        final boolean F0() {
            return true;
        }

        @Override // j$.util.stream.AbstractC0428h1, j$.util.stream.InterfaceC0444l1
        public /* bridge */ /* synthetic */ C1 parallel() {
            parallel();
            return this;
        }

        @Override // j$.util.stream.AbstractC0428h1, j$.util.stream.InterfaceC0444l1
        public /* bridge */ /* synthetic */ C1 sequential() {
            sequential();
            return this;
        }
    }

    /* JADX INFO: renamed from: j$.util.stream.z1$k */
    static abstract class k<E_IN> extends AbstractC0499z1<E_IN> {
        k(AbstractC0428h1 abstractC0428h1, U2 u2, int i2) {
            super(abstractC0428h1, i2);
        }

        @Override // j$.util.stream.AbstractC0428h1
        final boolean F0() {
            return false;
        }

        @Override // j$.util.stream.AbstractC0428h1, j$.util.stream.InterfaceC0444l1
        public /* bridge */ /* synthetic */ C1 parallel() {
            parallel();
            return this;
        }

        @Override // j$.util.stream.AbstractC0428h1, j$.util.stream.InterfaceC0444l1
        public /* bridge */ /* synthetic */ C1 sequential() {
            sequential();
            return this;
        }
    }

    AbstractC0499z1(Spliterator spliterator, int i2, boolean z) {
        super(spliterator, i2, z);
    }

    AbstractC0499z1(AbstractC0428h1 abstractC0428h1, int i2) {
        super(abstractC0428h1, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Spliterator.b L0(Spliterator spliterator) {
        if (spliterator instanceof Spliterator.b) {
            return (Spliterator.b) spliterator;
        }
        if (!i3.a) {
            throw new UnsupportedOperationException("IntStream.adapt(Spliterator<Integer> s)");
        }
        i3.a(AbstractC0428h1.class, "using IntStream.adapt(Spliterator<Integer> s)");
        throw null;
    }

    @Override // j$.util.stream.AbstractC0428h1
    final U2 A0() {
        return U2.INT_VALUE;
    }

    @Override // j$.util.stream.C1
    public void E(j$.util.function.y yVar) {
        Objects.requireNonNull(yVar);
        w0(new AbstractC0487w1.b(yVar, true));
    }

    @Override // j$.util.stream.C1
    public final Stream F(j$.util.function.z zVar) {
        Objects.requireNonNull(zVar);
        return new e(this, this, U2.INT_VALUE, T2.f8134k | T2.f8132i, zVar);
    }

    @Override // j$.util.stream.AbstractC0428h1
    final Spliterator J0(T1 t1, Supplier supplier, boolean z) {
        return new a3(t1, supplier, z);
    }

    @Override // j$.util.stream.C1
    public final int K(int i2, j$.util.function.x xVar) {
        Objects.requireNonNull(xVar);
        return ((Integer) w0(new C0441k2(U2.INT_VALUE, xVar, i2))).intValue();
    }

    @Override // j$.util.stream.C1
    public final boolean L(j$.util.function.A a2) {
        return ((Boolean) w0(Q1.s(a2, N1.ALL))).booleanValue();
    }

    @Override // j$.util.stream.C1
    public final C1 M(j$.util.function.z zVar) {
        return new g(this, this, U2.INT_VALUE, T2.f8134k | T2.f8132i | T2.o, zVar);
    }

    @Override // j$.util.stream.C1
    public void Q(j$.util.function.y yVar) {
        Objects.requireNonNull(yVar);
        w0(new AbstractC0487w1.b(yVar, false));
    }

    @Override // j$.util.stream.C1
    public final boolean R(j$.util.function.A a2) {
        return ((Boolean) w0(Q1.s(a2, N1.NONE))).booleanValue();
    }

    @Override // j$.util.stream.C1
    public final C1 X(j$.util.function.A a2) {
        Objects.requireNonNull(a2);
        return new h(this, this, U2.INT_VALUE, T2.o, a2);
    }

    @Override // j$.util.stream.C1
    public final j$.util.q Z(j$.util.function.x xVar) {
        Objects.requireNonNull(xVar);
        return (j$.util.q) w0(new C0449m2(U2.INT_VALUE, xVar));
    }

    @Override // j$.util.stream.C1
    public final C1 a0(j$.util.function.y yVar) {
        Objects.requireNonNull(yVar);
        return new b(this, this, U2.INT_VALUE, 0, yVar);
    }

    @Override // j$.util.stream.C1
    public final InterfaceC0471s1 asDoubleStream() {
        return new c(this, this, U2.INT_VALUE, T2.f8134k | T2.f8132i);
    }

    @Override // j$.util.stream.C1
    public final H1 asLongStream() {
        return new a(this, this, U2.INT_VALUE, T2.f8134k | T2.f8132i);
    }

    @Override // j$.util.stream.C1
    public final j$.util.p average() {
        return ((long[]) j0(new Supplier() { // from class: j$.util.stream.E
            @Override // j$.util.function.Supplier
            public final Object get() {
                return new long[2];
            }
        }, new j$.util.function.J() { // from class: j$.util.stream.L
            @Override // j$.util.function.J
            public final void accept(Object obj, int i2) {
                long[] jArr = (long[]) obj;
                jArr[0] = jArr[0] + 1;
                jArr[1] = jArr[1] + ((long) i2);
            }
        }, new BiConsumer() { // from class: j$.util.stream.K
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

    @Override // j$.util.stream.C1
    public final boolean b(j$.util.function.A a2) {
        return ((Boolean) w0(Q1.s(a2, N1.ANY))).booleanValue();
    }

    @Override // j$.util.stream.C1
    public final Stream boxed() {
        return F(C0410d.a);
    }

    @Override // j$.util.stream.C1
    public final long count() {
        return ((D1) h(new j$.util.function.B() { // from class: j$.util.stream.I
            @Override // j$.util.function.B
            public final long applyAsLong(int i2) {
                return 1L;
            }
        })).sum();
    }

    @Override // j$.util.stream.C1
    public final C1 distinct() {
        return ((AbstractC0496y2) F(C0410d.a)).distinct().m(new ToIntFunction() { // from class: j$.util.stream.J
            @Override // j$.util.function.ToIntFunction
            public final int applyAsInt(Object obj) {
                return ((Integer) obj).intValue();
            }
        });
    }

    @Override // j$.util.stream.C1
    public final j$.util.q findAny() {
        return (j$.util.q) w0(new C0475t1(false, U2.INT_VALUE, j$.util.q.a(), R0.a, W.a));
    }

    @Override // j$.util.stream.C1
    public final j$.util.q findFirst() {
        return (j$.util.q) w0(new C0475t1(true, U2.INT_VALUE, j$.util.q.a(), R0.a, W.a));
    }

    @Override // j$.util.stream.C1
    public final H1 h(j$.util.function.B b2) {
        Objects.requireNonNull(b2);
        return new f(this, this, U2.INT_VALUE, T2.f8134k | T2.f8132i, b2);
    }

    @Override // j$.util.stream.C1
    public final InterfaceC0471s1 i0(j$.W w) {
        Objects.requireNonNull(w);
        return new A1(this, this, U2.INT_VALUE, T2.f8134k | T2.f8132i, w);
    }

    @Override // j$.util.stream.InterfaceC0444l1
    public final t.b iterator() {
        return j$.util.v.g(spliterator());
    }

    @Override // j$.util.stream.InterfaceC0444l1
    public Iterator iterator() {
        return j$.util.v.g(spliterator());
    }

    @Override // j$.util.stream.C1
    public final Object j0(Supplier supplier, j$.util.function.J j2, final BiConsumer biConsumer) {
        j$.util.function.p pVar = new j$.util.function.p() { // from class: j$.util.stream.G
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
        Objects.requireNonNull(j2);
        return w0(new C0457o2(U2.INT_VALUE, pVar, j2, supplier));
    }

    @Override // j$.util.stream.C1
    public final C1 limit(long j2) {
        if (j2 >= 0) {
            return B2.g(this, 0L, j2);
        }
        throw new IllegalArgumentException(Long.toString(j2));
    }

    @Override // j$.util.stream.C1
    public final j$.util.q max() {
        return Z(new j$.util.function.x() { // from class: j$.util.stream.Q0
            @Override // j$.util.function.x
            public final int applyAsInt(int i2, int i3) {
                return Math.max(i2, i3);
            }
        });
    }

    @Override // j$.util.stream.C1
    public final j$.util.q min() {
        return Z(new j$.util.function.x() { // from class: j$.util.stream.C
            @Override // j$.util.function.x
            public final int applyAsInt(int i2, int i3) {
                return Math.min(i2, i3);
            }
        });
    }

    @Override // j$.util.stream.T1
    final R1.a s0(long j2, j$.util.function.z zVar) {
        return S1.p(j2);
    }

    @Override // j$.util.stream.C1
    public final C1 skip(long j2) {
        if (j2 >= 0) {
            return j2 == 0 ? this : B2.g(this, j2, -1L);
        }
        throw new IllegalArgumentException(Long.toString(j2));
    }

    @Override // j$.util.stream.C1
    public final C1 sorted() {
        return new K2(this);
    }

    @Override // j$.util.stream.AbstractC0428h1, j$.util.stream.InterfaceC0444l1
    public final Spliterator.b spliterator() {
        return L0(super.spliterator());
    }

    @Override // j$.util.stream.C1
    public final int sum() {
        return ((Integer) w0(new C0441k2(U2.INT_VALUE, new j$.util.function.x() { // from class: j$.util.stream.o0
            @Override // j$.util.function.x
            public final int applyAsInt(int i2, int i3) {
                return i2 + i3;
            }
        }, 0))).intValue();
    }

    @Override // j$.util.stream.C1
    public final j$.util.m summaryStatistics() {
        return (j$.util.m) j0(new Supplier() { // from class: j$.util.stream.d1
            @Override // j$.util.function.Supplier
            public final Object get() {
                return new j$.util.m();
            }
        }, new j$.util.function.J() { // from class: j$.util.stream.h
            @Override // j$.util.function.J
            public final void accept(Object obj, int i2) {
                ((j$.util.m) obj).accept(i2);
            }
        }, new BiConsumer() { // from class: j$.util.stream.a1
            @Override // j$.util.function.BiConsumer
            public BiConsumer a(BiConsumer biConsumer) {
                Objects.requireNonNull(biConsumer);
                return new C0387a(this, biConsumer);
            }

            @Override // j$.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                ((j$.util.m) obj).b((j$.util.m) obj2);
            }
        });
    }

    @Override // j$.util.stream.C1
    public final int[] toArray() {
        return (int[]) S1.n((R1.c) x0(new j$.util.function.z() { // from class: j$.util.stream.H
            @Override // j$.util.function.z
            public final Object apply(int i2) {
                return new Integer[i2];
            }
        })).e();
    }

    @Override // j$.util.stream.InterfaceC0444l1
    public InterfaceC0444l1 unordered() {
        return !B0() ? this : new B1(this, this, U2.INT_VALUE, T2.m);
    }

    @Override // j$.util.stream.C1
    public final C1 y(j$.util.function.C c2) {
        Objects.requireNonNull(c2);
        return new d(this, this, U2.INT_VALUE, T2.f8134k | T2.f8132i, c2);
    }

    @Override // j$.util.stream.AbstractC0428h1
    final R1 y0(T1 t1, Spliterator spliterator, boolean z, j$.util.function.z zVar) {
        return S1.g(t1, spliterator, z);
    }

    @Override // j$.util.stream.AbstractC0428h1
    final void z0(Spliterator spliterator, A2 a2) {
        j$.util.function.y c0406c;
        Spliterator.b bVarL0 = L0(spliterator);
        if (a2 instanceof j$.util.function.y) {
            c0406c = (j$.util.function.y) a2;
        } else {
            if (i3.a) {
                i3.a(AbstractC0428h1.class, "using IntStream.adapt(Sink<Integer> s)");
                throw null;
            }
            c0406c = new C0406c(a2);
        }
        while (!a2.o() && bVarL0.n(c0406c)) {
        }
    }
}

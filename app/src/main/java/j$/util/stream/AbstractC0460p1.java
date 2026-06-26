package j$.util.stream;

import j$.util.Spliterator;
import j$.util.function.BiConsumer;
import j$.util.function.BiFunction;
import j$.util.function.C0387a;
import j$.util.function.C0388b;
import j$.util.function.C0392f;
import j$.util.function.Function;
import j$.util.function.Supplier;
import j$.util.function.ToDoubleFunction;
import j$.util.stream.A2;
import j$.util.stream.AbstractC0487w1;
import j$.util.stream.AbstractC0496y2;
import j$.util.stream.D1;
import j$.util.stream.R1;
import j$.util.t;
import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: renamed from: j$.util.stream.p1, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
abstract class AbstractC0460p1<E_IN> extends AbstractC0428h1<E_IN, Double, InterfaceC0471s1> implements InterfaceC0471s1 {

    /* JADX INFO: renamed from: j$.util.stream.p1$a */
    class a extends i<Double> {

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final /* synthetic */ j$.util.function.w f8244l;

        /* JADX INFO: renamed from: j$.util.stream.p1$a$a, reason: collision with other inner class name */
        class C0222a extends A2.a<Double> {
            C0222a(A2 a2) {
                super(a2);
            }

            @Override // j$.util.stream.A2.e, j$.util.stream.A2
            public void accept(double d2) {
                this.a.accept(((j$.J) a.this.f8244l).a(d2));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(AbstractC0460p1 abstractC0460p1, AbstractC0428h1 abstractC0428h1, U2 u2, int i2, j$.util.function.w wVar) {
            super(abstractC0428h1, u2, i2);
            this.f8244l = wVar;
        }

        @Override // j$.util.stream.AbstractC0428h1
        A2 G0(int i2, A2 a2) {
            return new C0222a(a2);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [U] */
    /* JADX INFO: renamed from: j$.util.stream.p1$b */
    class b<U> extends AbstractC0496y2.m<Double, U> {

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final /* synthetic */ j$.util.function.t f8246l;

        /* JADX INFO: renamed from: j$.util.stream.p1$b$a */
        class a extends A2.a<U> {
            a(A2 a2) {
                super(a2);
            }

            @Override // j$.util.stream.A2.e, j$.util.stream.A2
            public void accept(double d2) {
                this.a.accept(b.this.f8246l.apply(d2));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(AbstractC0460p1 abstractC0460p1, AbstractC0428h1 abstractC0428h1, U2 u2, int i2, j$.util.function.t tVar) {
            super(abstractC0428h1, u2, i2);
            this.f8246l = tVar;
        }

        @Override // j$.util.stream.AbstractC0428h1
        A2 G0(int i2, A2 a2) {
            return new a(a2);
        }
    }

    /* JADX INFO: renamed from: j$.util.stream.p1$c */
    class c extends D1.i<Double> {

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final /* synthetic */ j$.util.function.v f8248l;

        /* JADX INFO: renamed from: j$.util.stream.p1$c$a */
        class a extends A2.a<Long> {
            a(A2 a2) {
                super(a2);
            }

            @Override // j$.util.stream.A2.e, j$.util.stream.A2
            public void accept(double d2) {
                this.a.accept(c.this.f8248l.applyAsLong(d2));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(AbstractC0460p1 abstractC0460p1, AbstractC0428h1 abstractC0428h1, U2 u2, int i2, j$.util.function.v vVar) {
            super(abstractC0428h1, u2, i2);
            this.f8248l = vVar;
        }

        @Override // j$.util.stream.AbstractC0428h1
        A2 G0(int i2, A2 a2) {
            return new a(a2);
        }
    }

    /* JADX INFO: renamed from: j$.util.stream.p1$d */
    class d extends i<Double> {

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final /* synthetic */ j$.util.function.t f8250l;

        /* JADX INFO: renamed from: j$.util.stream.p1$d$a */
        class a extends A2.a<Double> {
            a(A2 a2) {
                super(a2);
            }

            @Override // j$.util.stream.A2.e, j$.util.stream.A2
            public void accept(double d2) {
                InterfaceC0471s1 interfaceC0471s1 = (InterfaceC0471s1) d.this.f8250l.apply(d2);
                if (interfaceC0471s1 != null) {
                    try {
                        interfaceC0471s1.sequential().l(new j$.util.function.s() { // from class: j$.util.stream.o
                            @Override // j$.util.function.s
                            public final void accept(double d3) {
                                this.a.a.accept(d3);
                            }

                            @Override // j$.util.function.s
                            public j$.util.function.s j(j$.util.function.s sVar) {
                                Objects.requireNonNull(sVar);
                                return new C0392f(this, sVar);
                            }
                        });
                    } catch (Throwable th) {
                        try {
                            interfaceC0471s1.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                        throw th;
                    }
                }
                if (interfaceC0471s1 != null) {
                    interfaceC0471s1.close();
                }
            }

            @Override // j$.util.stream.A2.a, j$.util.stream.A2
            public void m(long j2) {
                this.a.m(-1L);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(AbstractC0460p1 abstractC0460p1, AbstractC0428h1 abstractC0428h1, U2 u2, int i2, j$.util.function.t tVar) {
            super(abstractC0428h1, u2, i2);
            this.f8250l = tVar;
        }

        @Override // j$.util.stream.AbstractC0428h1
        A2 G0(int i2, A2 a2) {
            return new a(a2);
        }
    }

    /* JADX INFO: renamed from: j$.util.stream.p1$e */
    class e extends i<Double> {

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final /* synthetic */ j$.util.function.u f8252l;

        /* JADX INFO: renamed from: j$.util.stream.p1$e$a */
        class a extends A2.a<Double> {
            a(A2 a2) {
                super(a2);
            }

            @Override // j$.util.stream.A2.e, j$.util.stream.A2
            public void accept(double d2) {
                if (((j$.D) e.this.f8252l).b(d2)) {
                    this.a.accept(d2);
                }
            }

            @Override // j$.util.stream.A2.a, j$.util.stream.A2
            public void m(long j2) {
                this.a.m(-1L);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(AbstractC0460p1 abstractC0460p1, AbstractC0428h1 abstractC0428h1, U2 u2, int i2, j$.util.function.u uVar) {
            super(abstractC0428h1, u2, i2);
            this.f8252l = uVar;
        }

        @Override // j$.util.stream.AbstractC0428h1
        A2 G0(int i2, A2 a2) {
            return new a(a2);
        }
    }

    /* JADX INFO: renamed from: j$.util.stream.p1$f */
    class f extends i<Double> {

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final /* synthetic */ j$.util.function.s f8254l;

        /* JADX INFO: renamed from: j$.util.stream.p1$f$a */
        class a extends A2.a<Double> {
            a(A2 a2) {
                super(a2);
            }

            @Override // j$.util.stream.A2.e, j$.util.stream.A2
            public void accept(double d2) {
                f.this.f8254l.accept(d2);
                this.a.accept(d2);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(AbstractC0460p1 abstractC0460p1, AbstractC0428h1 abstractC0428h1, U2 u2, int i2, j$.util.function.s sVar) {
            super(abstractC0428h1, u2, i2);
            this.f8254l = sVar;
        }

        @Override // j$.util.stream.AbstractC0428h1
        A2 G0(int i2, A2 a2) {
            return new a(a2);
        }
    }

    /* JADX INFO: renamed from: j$.util.stream.p1$g */
    static class g<E_IN> extends AbstractC0460p1<E_IN> {
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

        @Override // j$.util.stream.AbstractC0460p1, j$.util.stream.InterfaceC0471s1
        public void k0(j$.util.function.s sVar) {
            if (!isParallel()) {
                AbstractC0460p1.L0(I0()).e(sVar);
            } else {
                Objects.requireNonNull(sVar);
                w0(new AbstractC0487w1.a(sVar, true));
            }
        }

        @Override // j$.util.stream.AbstractC0460p1, j$.util.stream.InterfaceC0471s1
        public void l(j$.util.function.s sVar) {
            if (isParallel()) {
                super.l(sVar);
            } else {
                AbstractC0460p1.L0(I0()).e(sVar);
            }
        }

        @Override // j$.util.stream.AbstractC0428h1, j$.util.stream.InterfaceC0444l1
        public /* bridge */ /* synthetic */ InterfaceC0471s1 parallel() {
            parallel();
            return this;
        }

        @Override // j$.util.stream.AbstractC0428h1, j$.util.stream.InterfaceC0444l1
        public /* bridge */ /* synthetic */ InterfaceC0471s1 sequential() {
            sequential();
            return this;
        }
    }

    /* JADX INFO: renamed from: j$.util.stream.p1$h */
    static abstract class h<E_IN> extends AbstractC0460p1<E_IN> {
        h(AbstractC0428h1 abstractC0428h1, U2 u2, int i2) {
            super(abstractC0428h1, i2);
        }

        @Override // j$.util.stream.AbstractC0428h1
        final boolean F0() {
            return true;
        }

        @Override // j$.util.stream.AbstractC0428h1, j$.util.stream.InterfaceC0444l1
        public /* bridge */ /* synthetic */ InterfaceC0471s1 parallel() {
            parallel();
            return this;
        }

        @Override // j$.util.stream.AbstractC0428h1, j$.util.stream.InterfaceC0444l1
        public /* bridge */ /* synthetic */ InterfaceC0471s1 sequential() {
            sequential();
            return this;
        }
    }

    /* JADX INFO: renamed from: j$.util.stream.p1$i */
    static abstract class i<E_IN> extends AbstractC0460p1<E_IN> {
        i(AbstractC0428h1 abstractC0428h1, U2 u2, int i2) {
            super(abstractC0428h1, i2);
        }

        @Override // j$.util.stream.AbstractC0428h1
        final boolean F0() {
            return false;
        }

        @Override // j$.util.stream.AbstractC0428h1, j$.util.stream.InterfaceC0444l1
        public /* bridge */ /* synthetic */ InterfaceC0471s1 parallel() {
            parallel();
            return this;
        }

        @Override // j$.util.stream.AbstractC0428h1, j$.util.stream.InterfaceC0444l1
        public /* bridge */ /* synthetic */ InterfaceC0471s1 sequential() {
            sequential();
            return this;
        }
    }

    AbstractC0460p1(Spliterator spliterator, int i2, boolean z) {
        super(spliterator, i2, z);
    }

    AbstractC0460p1(AbstractC0428h1 abstractC0428h1, int i2) {
        super(abstractC0428h1, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Spliterator.a L0(Spliterator spliterator) {
        if (spliterator instanceof Spliterator.a) {
            return (Spliterator.a) spliterator;
        }
        if (!i3.a) {
            throw new UnsupportedOperationException("DoubleStream.adapt(Spliterator<Double> s)");
        }
        i3.a(AbstractC0428h1.class, "using DoubleStream.adapt(Spliterator<Double> s)");
        throw null;
    }

    @Override // j$.util.stream.AbstractC0428h1
    final U2 A0() {
        return U2.DOUBLE_VALUE;
    }

    @Override // j$.util.stream.InterfaceC0471s1
    public final j$.util.p C(j$.util.function.r rVar) {
        Objects.requireNonNull(rVar);
        return (j$.util.p) w0(new Y1(U2.DOUBLE_VALUE, rVar));
    }

    @Override // j$.util.stream.InterfaceC0471s1
    public final Object D(Supplier supplier, j$.util.function.I i2, final BiConsumer biConsumer) {
        j$.util.function.p pVar = new j$.util.function.p() { // from class: j$.util.stream.w
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
        Objects.requireNonNull(i2);
        return w0(new C0401a2(U2.DOUBLE_VALUE, pVar, i2, supplier));
    }

    @Override // j$.util.stream.InterfaceC0471s1
    public final double G(double d2, j$.util.function.r rVar) {
        Objects.requireNonNull(rVar);
        return ((Double) w0(new W1(U2.DOUBLE_VALUE, rVar, d2))).doubleValue();
    }

    @Override // j$.util.stream.InterfaceC0471s1
    public final InterfaceC0471s1 H(j$.util.function.w wVar) {
        Objects.requireNonNull(wVar);
        return new a(this, this, U2.DOUBLE_VALUE, T2.f8134k | T2.f8132i, wVar);
    }

    @Override // j$.util.stream.InterfaceC0471s1
    public final Stream I(j$.util.function.t tVar) {
        Objects.requireNonNull(tVar);
        return new b(this, this, U2.DOUBLE_VALUE, T2.f8134k | T2.f8132i, tVar);
    }

    @Override // j$.util.stream.InterfaceC0471s1
    public final boolean J(j$.util.function.u uVar) {
        return ((Boolean) w0(Q1.r(uVar, N1.NONE))).booleanValue();
    }

    @Override // j$.util.stream.AbstractC0428h1
    final Spliterator J0(T1 t1, Supplier supplier, boolean z) {
        return new Z2(t1, supplier, z);
    }

    @Override // j$.util.stream.InterfaceC0471s1
    public final boolean O(j$.util.function.u uVar) {
        return ((Boolean) w0(Q1.r(uVar, N1.ALL))).booleanValue();
    }

    @Override // j$.util.stream.InterfaceC0471s1
    public final boolean W(j$.util.function.u uVar) {
        return ((Boolean) w0(Q1.r(uVar, N1.ANY))).booleanValue();
    }

    @Override // j$.util.stream.InterfaceC0471s1
    public final j$.util.p average() {
        double[] dArr = (double[]) D(new Supplier() { // from class: j$.util.stream.x
            @Override // j$.util.function.Supplier
            public final Object get() {
                return new double[4];
            }
        }, new j$.util.function.I() { // from class: j$.util.stream.t
            @Override // j$.util.function.I
            public final void accept(Object obj, double d2) {
                double[] dArr2 = (double[]) obj;
                dArr2[2] = dArr2[2] + 1.0d;
                C0452n1.b(dArr2, d2);
                dArr2[3] = dArr2[3] + d2;
            }
        }, new BiConsumer() { // from class: j$.util.stream.v
            @Override // j$.util.function.BiConsumer
            public BiConsumer a(BiConsumer biConsumer) {
                Objects.requireNonNull(biConsumer);
                return new C0387a(this, biConsumer);
            }

            @Override // j$.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                double[] dArr2 = (double[]) obj;
                double[] dArr3 = (double[]) obj2;
                C0452n1.b(dArr2, dArr3[0]);
                C0452n1.b(dArr2, dArr3[1]);
                dArr2[2] = dArr2[2] + dArr3[2];
                dArr2[3] = dArr2[3] + dArr3[3];
            }
        });
        return dArr[2] > 0.0d ? j$.util.p.d(C0452n1.a(dArr) / dArr[2]) : j$.util.p.a();
    }

    @Override // j$.util.stream.InterfaceC0471s1
    public final Stream boxed() {
        return I(O0.a);
    }

    @Override // j$.util.stream.InterfaceC0471s1
    public final long count() {
        return ((D1) v(new j$.util.function.v() { // from class: j$.util.stream.s
            @Override // j$.util.function.v
            public final long applyAsLong(double d2) {
                return 1L;
            }
        })).sum();
    }

    @Override // j$.util.stream.InterfaceC0471s1
    public final InterfaceC0471s1 d(j$.util.function.s sVar) {
        Objects.requireNonNull(sVar);
        return new f(this, this, U2.DOUBLE_VALUE, 0, sVar);
    }

    @Override // j$.util.stream.InterfaceC0471s1
    public final InterfaceC0471s1 distinct() {
        return ((AbstractC0496y2) I(O0.a)).distinct().h0(new ToDoubleFunction() { // from class: j$.util.stream.n
            @Override // j$.util.function.ToDoubleFunction
            public final double applyAsDouble(Object obj) {
                return ((Double) obj).doubleValue();
            }
        });
    }

    @Override // j$.util.stream.InterfaceC0471s1
    public final j$.util.p findAny() {
        return (j$.util.p) w0(new C0475t1(false, U2.DOUBLE_VALUE, j$.util.p.a(), S0.a, U0.a));
    }

    @Override // j$.util.stream.InterfaceC0471s1
    public final j$.util.p findFirst() {
        return (j$.util.p) w0(new C0475t1(true, U2.DOUBLE_VALUE, j$.util.p.a(), S0.a, U0.a));
    }

    @Override // j$.util.stream.InterfaceC0444l1
    public final t.a iterator() {
        return j$.util.v.f(spliterator());
    }

    @Override // j$.util.stream.InterfaceC0444l1
    public Iterator iterator() {
        return j$.util.v.f(spliterator());
    }

    @Override // j$.util.stream.InterfaceC0471s1
    public void k0(j$.util.function.s sVar) {
        Objects.requireNonNull(sVar);
        w0(new AbstractC0487w1.a(sVar, true));
    }

    @Override // j$.util.stream.InterfaceC0471s1
    public void l(j$.util.function.s sVar) {
        Objects.requireNonNull(sVar);
        w0(new AbstractC0487w1.a(sVar, false));
    }

    @Override // j$.util.stream.InterfaceC0471s1
    public final InterfaceC0471s1 limit(long j2) {
        if (j2 >= 0) {
            return B2.f(this, 0L, j2);
        }
        throw new IllegalArgumentException(Long.toString(j2));
    }

    @Override // j$.util.stream.InterfaceC0471s1
    public final j$.util.p max() {
        return C(new j$.util.function.r() { // from class: j$.util.stream.D
            @Override // j$.util.function.r
            public final double applyAsDouble(double d2, double d3) {
                return Math.max(d2, d3);
            }
        });
    }

    @Override // j$.util.stream.InterfaceC0471s1
    public final j$.util.p min() {
        return C(new j$.util.function.r() { // from class: j$.util.stream.X0
            @Override // j$.util.function.r
            public final double applyAsDouble(double d2, double d3) {
                return Math.min(d2, d3);
            }
        });
    }

    @Override // j$.util.stream.InterfaceC0471s1
    public final C1 o(j$.F f2) {
        Objects.requireNonNull(f2);
        return new C0464q1(this, this, U2.DOUBLE_VALUE, T2.f8134k | T2.f8132i, f2);
    }

    @Override // j$.util.stream.T1
    final R1.a s0(long j2, j$.util.function.z zVar) {
        return S1.j(j2);
    }

    @Override // j$.util.stream.InterfaceC0471s1
    public final InterfaceC0471s1 skip(long j2) {
        if (j2 >= 0) {
            return j2 == 0 ? this : B2.f(this, j2, -1L);
        }
        throw new IllegalArgumentException(Long.toString(j2));
    }

    @Override // j$.util.stream.InterfaceC0471s1
    public final InterfaceC0471s1 sorted() {
        return new J2(this);
    }

    @Override // j$.util.stream.AbstractC0428h1, j$.util.stream.InterfaceC0444l1
    public final Spliterator.a spliterator() {
        return L0(super.spliterator());
    }

    @Override // j$.util.stream.InterfaceC0471s1
    public final double sum() {
        return C0452n1.a((double[]) D(new Supplier() { // from class: j$.util.stream.u
            @Override // j$.util.function.Supplier
            public final Object get() {
                return new double[3];
            }
        }, new j$.util.function.I() { // from class: j$.util.stream.r
            @Override // j$.util.function.I
            public final void accept(Object obj, double d2) {
                double[] dArr = (double[]) obj;
                C0452n1.b(dArr, d2);
                dArr[2] = dArr[2] + d2;
            }
        }, new BiConsumer() { // from class: j$.util.stream.p
            @Override // j$.util.function.BiConsumer
            public BiConsumer a(BiConsumer biConsumer) {
                Objects.requireNonNull(biConsumer);
                return new C0387a(this, biConsumer);
            }

            @Override // j$.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                double[] dArr = (double[]) obj;
                double[] dArr2 = (double[]) obj2;
                C0452n1.b(dArr, dArr2[0]);
                C0452n1.b(dArr, dArr2[1]);
                dArr[2] = dArr[2] + dArr2[2];
            }
        }));
    }

    @Override // j$.util.stream.InterfaceC0471s1
    public final j$.util.l summaryStatistics() {
        return (j$.util.l) D(new Supplier() { // from class: j$.util.stream.H0
            @Override // j$.util.function.Supplier
            public final Object get() {
                return new j$.util.l();
            }
        }, new j$.util.function.I() { // from class: j$.util.stream.X
            @Override // j$.util.function.I
            public final void accept(Object obj, double d2) {
                ((j$.util.l) obj).accept(d2);
            }
        }, new BiConsumer() { // from class: j$.util.stream.k0
            @Override // j$.util.function.BiConsumer
            public BiConsumer a(BiConsumer biConsumer) {
                Objects.requireNonNull(biConsumer);
                return new C0387a(this, biConsumer);
            }

            @Override // j$.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                ((j$.util.l) obj).b((j$.util.l) obj2);
            }
        });
    }

    @Override // j$.util.stream.InterfaceC0471s1
    public final InterfaceC0471s1 t(j$.util.function.u uVar) {
        Objects.requireNonNull(uVar);
        return new e(this, this, U2.DOUBLE_VALUE, T2.o, uVar);
    }

    @Override // j$.util.stream.InterfaceC0471s1
    public final double[] toArray() {
        return (double[]) S1.m((R1.b) x0(new j$.util.function.z() { // from class: j$.util.stream.q
            @Override // j$.util.function.z
            public final Object apply(int i2) {
                return new Double[i2];
            }
        })).e();
    }

    @Override // j$.util.stream.InterfaceC0471s1
    public final InterfaceC0471s1 u(j$.util.function.t tVar) {
        return new d(this, this, U2.DOUBLE_VALUE, T2.f8134k | T2.f8132i | T2.o, tVar);
    }

    @Override // j$.util.stream.InterfaceC0444l1
    public InterfaceC0444l1 unordered() {
        return !B0() ? this : new C0467r1(this, this, U2.DOUBLE_VALUE, T2.m);
    }

    @Override // j$.util.stream.InterfaceC0471s1
    public final H1 v(j$.util.function.v vVar) {
        Objects.requireNonNull(vVar);
        return new c(this, this, U2.DOUBLE_VALUE, T2.f8134k | T2.f8132i, vVar);
    }

    @Override // j$.util.stream.AbstractC0428h1
    final R1 y0(T1 t1, Spliterator spliterator, boolean z, j$.util.function.z zVar) {
        return S1.f(t1, spliterator, z);
    }

    @Override // j$.util.stream.AbstractC0428h1
    final void z0(Spliterator spliterator, A2 a2) {
        j$.util.function.s m;
        Spliterator.a aVarL0 = L0(spliterator);
        if (a2 instanceof j$.util.function.s) {
            m = (j$.util.function.s) a2;
        } else {
            if (i3.a) {
                i3.a(AbstractC0428h1.class, "using DoubleStream.adapt(Sink<Double> s)");
                throw null;
            }
            m = new M(a2);
        }
        while (!a2.o() && aVarL0.n(m)) {
        }
    }
}

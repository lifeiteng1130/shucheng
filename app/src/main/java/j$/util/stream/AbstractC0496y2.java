package j$.util.stream;

import j$.util.Spliterator;
import j$.util.function.BiConsumer;
import j$.util.function.BiFunction;
import j$.util.function.Consumer;
import j$.util.function.Function;
import j$.util.function.Predicate;
import j$.util.function.Supplier;
import j$.util.function.ToDoubleFunction;
import j$.util.function.ToIntFunction;
import j$.util.function.ToLongFunction;
import j$.util.stream.A2;
import j$.util.stream.AbstractC0460p1;
import j$.util.stream.AbstractC0487w1;
import j$.util.stream.AbstractC0499z1;
import j$.util.stream.D1;
import j$.util.stream.InterfaceC0448m1;
import j$.util.stream.R1;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: renamed from: j$.util.stream.y2, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
abstract class AbstractC0496y2<P_IN, P_OUT> extends AbstractC0428h1<P_IN, P_OUT, Stream<P_OUT>> implements Stream<P_OUT> {

    /* JADX INFO: renamed from: j$.util.stream.y2$a */
    class a extends D1.i<P_OUT> {

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final /* synthetic */ Function f8291l;

        /* JADX INFO: renamed from: j$.util.stream.y2$a$a, reason: collision with other inner class name */
        class C0223a extends A2.d<P_OUT, Long> {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            j$.util.function.E f8292b;

            C0223a(A2 a2) {
                super(a2);
                A2 a22 = this.a;
                Objects.requireNonNull(a22);
                this.f8292b = new K0(a22);
            }

            @Override // j$.util.function.Consumer
            public void accept(Object obj) {
                H1 h1 = (H1) a.this.f8291l.apply(obj);
                if (h1 != null) {
                    try {
                        h1.sequential().f(this.f8292b);
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

            @Override // j$.util.stream.A2.d, j$.util.stream.A2
            public void m(long j2) {
                this.a.m(-1L);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(AbstractC0496y2 abstractC0496y2, AbstractC0428h1 abstractC0428h1, U2 u2, int i2, Function function) {
            super(abstractC0428h1, u2, i2);
            this.f8291l = function;
        }

        @Override // j$.util.stream.AbstractC0428h1
        A2 G0(int i2, A2 a2) {
            return new C0223a(a2);
        }
    }

    /* JADX INFO: renamed from: j$.util.stream.y2$b */
    class b extends m<P_OUT, P_OUT> {

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final /* synthetic */ Consumer f8294l;

        /* JADX INFO: renamed from: j$.util.stream.y2$b$a */
        class a extends A2.d<P_OUT, P_OUT> {
            a(A2 a2) {
                super(a2);
            }

            @Override // j$.util.function.Consumer
            public void accept(Object obj) {
                b.this.f8294l.accept(obj);
                this.a.accept(obj);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(AbstractC0496y2 abstractC0496y2, AbstractC0428h1 abstractC0428h1, U2 u2, int i2, Consumer consumer) {
            super(abstractC0428h1, u2, i2);
            this.f8294l = consumer;
        }

        @Override // j$.util.stream.AbstractC0428h1
        A2 G0(int i2, A2 a2) {
            return new a(a2);
        }
    }

    /* JADX INFO: renamed from: j$.util.stream.y2$c */
    class c extends m<P_OUT, P_OUT> {

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final /* synthetic */ Predicate f8296l;

        /* JADX INFO: renamed from: j$.util.stream.y2$c$a */
        class a extends A2.d<P_OUT, P_OUT> {
            a(A2 a2) {
                super(a2);
            }

            @Override // j$.util.function.Consumer
            public void accept(Object obj) {
                if (c.this.f8296l.test(obj)) {
                    this.a.accept(obj);
                }
            }

            @Override // j$.util.stream.A2.d, j$.util.stream.A2
            public void m(long j2) {
                this.a.m(-1L);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(AbstractC0496y2 abstractC0496y2, AbstractC0428h1 abstractC0428h1, U2 u2, int i2, Predicate predicate) {
            super(abstractC0428h1, u2, i2);
            this.f8296l = predicate;
        }

        @Override // j$.util.stream.AbstractC0428h1
        A2 G0(int i2, A2 a2) {
            return new a(a2);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* JADX INFO: renamed from: j$.util.stream.y2$d */
    class d<R> extends m<P_OUT, R> {

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final /* synthetic */ Function f8298l;

        /* JADX INFO: renamed from: j$.util.stream.y2$d$a */
        class a extends A2.d<P_OUT, R> {
            a(A2 a2) {
                super(a2);
            }

            @Override // j$.util.function.Consumer
            public void accept(Object obj) {
                this.a.accept(d.this.f8298l.apply(obj));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(AbstractC0496y2 abstractC0496y2, AbstractC0428h1 abstractC0428h1, U2 u2, int i2, Function function) {
            super(abstractC0428h1, u2, i2);
            this.f8298l = function;
        }

        @Override // j$.util.stream.AbstractC0428h1
        A2 G0(int i2, A2 a2) {
            return new a(a2);
        }
    }

    /* JADX INFO: renamed from: j$.util.stream.y2$e */
    class e extends AbstractC0499z1.k<P_OUT> {

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final /* synthetic */ ToIntFunction f8300l;

        /* JADX INFO: renamed from: j$.util.stream.y2$e$a */
        class a extends A2.d<P_OUT, Integer> {
            a(A2 a2) {
                super(a2);
            }

            @Override // j$.util.function.Consumer
            public void accept(Object obj) {
                this.a.accept(e.this.f8300l.applyAsInt(obj));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(AbstractC0496y2 abstractC0496y2, AbstractC0428h1 abstractC0428h1, U2 u2, int i2, ToIntFunction toIntFunction) {
            super(abstractC0428h1, u2, i2);
            this.f8300l = toIntFunction;
        }

        @Override // j$.util.stream.AbstractC0428h1
        A2 G0(int i2, A2 a2) {
            return new a(a2);
        }
    }

    /* JADX INFO: renamed from: j$.util.stream.y2$f */
    class f extends D1.i<P_OUT> {

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final /* synthetic */ ToLongFunction f8302l;

        /* JADX INFO: renamed from: j$.util.stream.y2$f$a */
        class a extends A2.d<P_OUT, Long> {
            a(A2 a2) {
                super(a2);
            }

            @Override // j$.util.function.Consumer
            public void accept(Object obj) {
                this.a.accept(f.this.f8302l.applyAsLong(obj));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(AbstractC0496y2 abstractC0496y2, AbstractC0428h1 abstractC0428h1, U2 u2, int i2, ToLongFunction toLongFunction) {
            super(abstractC0428h1, u2, i2);
            this.f8302l = toLongFunction;
        }

        @Override // j$.util.stream.AbstractC0428h1
        A2 G0(int i2, A2 a2) {
            return new a(a2);
        }
    }

    /* JADX INFO: renamed from: j$.util.stream.y2$g */
    class g extends AbstractC0460p1.i<P_OUT> {

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final /* synthetic */ ToDoubleFunction f8304l;

        /* JADX INFO: renamed from: j$.util.stream.y2$g$a */
        class a extends A2.d<P_OUT, Double> {
            a(A2 a2) {
                super(a2);
            }

            @Override // j$.util.function.Consumer
            public void accept(Object obj) {
                this.a.accept(g.this.f8304l.applyAsDouble(obj));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(AbstractC0496y2 abstractC0496y2, AbstractC0428h1 abstractC0428h1, U2 u2, int i2, ToDoubleFunction toDoubleFunction) {
            super(abstractC0428h1, u2, i2);
            this.f8304l = toDoubleFunction;
        }

        @Override // j$.util.stream.AbstractC0428h1
        A2 G0(int i2, A2 a2) {
            return new a(a2);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* JADX INFO: renamed from: j$.util.stream.y2$h */
    class h<R> extends m<P_OUT, R> {

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final /* synthetic */ Function f8306l;

        /* JADX INFO: renamed from: j$.util.stream.y2$h$a */
        class a extends A2.d<P_OUT, R> {
            a(A2 a2) {
                super(a2);
            }

            @Override // j$.util.function.Consumer
            public void accept(Object obj) {
                Stream stream = (Stream) h.this.f8306l.apply(obj);
                if (stream != null) {
                    try {
                        ((Stream) stream.sequential()).forEach(this.a);
                    } catch (Throwable th) {
                        try {
                            stream.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                        throw th;
                    }
                }
                if (stream != null) {
                    stream.close();
                }
            }

            @Override // j$.util.stream.A2.d, j$.util.stream.A2
            public void m(long j2) {
                this.a.m(-1L);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        h(AbstractC0496y2 abstractC0496y2, AbstractC0428h1 abstractC0428h1, U2 u2, int i2, Function function) {
            super(abstractC0428h1, u2, i2);
            this.f8306l = function;
        }

        @Override // j$.util.stream.AbstractC0428h1
        A2 G0(int i2, A2 a2) {
            return new a(a2);
        }
    }

    /* JADX INFO: renamed from: j$.util.stream.y2$i */
    class i extends AbstractC0499z1.k<P_OUT> {

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final /* synthetic */ Function f8308l;

        /* JADX INFO: renamed from: j$.util.stream.y2$i$a */
        class a extends A2.d<P_OUT, Integer> {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            j$.util.function.y f8309b;

            a(A2 a2) {
                super(a2);
                A2 a22 = this.a;
                Objects.requireNonNull(a22);
                this.f8309b = new C0406c(a22);
            }

            @Override // j$.util.function.Consumer
            public void accept(Object obj) {
                C1 c1 = (C1) i.this.f8308l.apply(obj);
                if (c1 != null) {
                    try {
                        c1.sequential().Q(this.f8309b);
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

            @Override // j$.util.stream.A2.d, j$.util.stream.A2
            public void m(long j2) {
                this.a.m(-1L);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        i(AbstractC0496y2 abstractC0496y2, AbstractC0428h1 abstractC0428h1, U2 u2, int i2, Function function) {
            super(abstractC0428h1, u2, i2);
            this.f8308l = function;
        }

        @Override // j$.util.stream.AbstractC0428h1
        A2 G0(int i2, A2 a2) {
            return new a(a2);
        }
    }

    /* JADX INFO: renamed from: j$.util.stream.y2$j */
    class j extends AbstractC0460p1.i<P_OUT> {

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final /* synthetic */ Function f8311l;

        /* JADX INFO: renamed from: j$.util.stream.y2$j$a */
        class a extends A2.d<P_OUT, Double> {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            j$.util.function.s f8312b;

            a(A2 a2) {
                super(a2);
                A2 a22 = this.a;
                Objects.requireNonNull(a22);
                this.f8312b = new M(a22);
            }

            @Override // j$.util.function.Consumer
            public void accept(Object obj) {
                InterfaceC0471s1 interfaceC0471s1 = (InterfaceC0471s1) j.this.f8311l.apply(obj);
                if (interfaceC0471s1 != null) {
                    try {
                        interfaceC0471s1.sequential().l(this.f8312b);
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

            @Override // j$.util.stream.A2.d, j$.util.stream.A2
            public void m(long j2) {
                this.a.m(-1L);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        j(AbstractC0496y2 abstractC0496y2, AbstractC0428h1 abstractC0428h1, U2 u2, int i2, Function function) {
            super(abstractC0428h1, u2, i2);
            this.f8311l = function;
        }

        @Override // j$.util.stream.AbstractC0428h1
        A2 G0(int i2, A2 a2) {
            return new a(a2);
        }
    }

    /* JADX INFO: renamed from: j$.util.stream.y2$k */
    static class k<E_IN, E_OUT> extends AbstractC0496y2<E_IN, E_OUT> {
        k(Spliterator spliterator, int i2, boolean z) {
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

        @Override // j$.util.stream.AbstractC0496y2, j$.util.stream.Stream
        public void forEach(Consumer consumer) {
            if (isParallel()) {
                super.forEach(consumer);
            } else {
                I0().forEachRemaining(consumer);
            }
        }

        @Override // j$.util.stream.AbstractC0496y2, j$.util.stream.Stream
        public void g(Consumer consumer) {
            if (!isParallel()) {
                I0().forEachRemaining(consumer);
            } else {
                Objects.requireNonNull(consumer);
                w0(new AbstractC0487w1.d(consumer, true));
            }
        }
    }

    /* JADX INFO: renamed from: j$.util.stream.y2$l */
    static abstract class l<E_IN, E_OUT> extends AbstractC0496y2<E_IN, E_OUT> {
        l(AbstractC0428h1 abstractC0428h1, U2 u2, int i2) {
            super(abstractC0428h1, i2);
        }

        @Override // j$.util.stream.AbstractC0428h1
        final boolean F0() {
            return true;
        }
    }

    /* JADX INFO: renamed from: j$.util.stream.y2$m */
    static abstract class m<E_IN, E_OUT> extends AbstractC0496y2<E_IN, E_OUT> {
        m(AbstractC0428h1 abstractC0428h1, U2 u2, int i2) {
            super(abstractC0428h1, i2);
        }

        @Override // j$.util.stream.AbstractC0428h1
        final boolean F0() {
            return false;
        }
    }

    AbstractC0496y2(Spliterator spliterator, int i2, boolean z) {
        super(spliterator, i2, z);
    }

    AbstractC0496y2(AbstractC0428h1 abstractC0428h1, int i2) {
        super(abstractC0428h1, i2);
    }

    @Override // j$.util.stream.AbstractC0428h1
    final U2 A0() {
        return U2.REFERENCE;
    }

    @Override // j$.util.stream.Stream
    public final InterfaceC0471s1 B(Function function) {
        Objects.requireNonNull(function);
        return new j(this, this, U2.REFERENCE, T2.f8134k | T2.f8132i | T2.o, function);
    }

    @Override // j$.util.stream.AbstractC0428h1
    final Spliterator J0(T1 t1, Supplier supplier, boolean z) {
        return new e3(t1, supplier, z);
    }

    @Override // j$.util.stream.Stream
    public final Stream P(Predicate predicate) {
        Objects.requireNonNull(predicate);
        return new c(this, this, U2.REFERENCE, T2.o, predicate);
    }

    @Override // j$.util.stream.Stream
    public final Stream S(Consumer consumer) {
        Objects.requireNonNull(consumer);
        return new b(this, this, U2.REFERENCE, 0, consumer);
    }

    @Override // j$.util.stream.Stream
    public final Object T(InterfaceC0448m1 interfaceC0448m1) {
        final Object objW0;
        if (isParallel() && interfaceC0448m1.characteristics().contains(InterfaceC0448m1.a.CONCURRENT) && (!B0() || interfaceC0448m1.characteristics().contains(InterfaceC0448m1.a.UNORDERED))) {
            objW0 = interfaceC0448m1.supplier().get();
            final BiConsumer biConsumerAccumulator = interfaceC0448m1.accumulator();
            forEach(new Consumer() { // from class: j$.util.stream.r0
                @Override // j$.util.function.Consumer
                public final void accept(Object obj) {
                    biConsumerAccumulator.accept(objW0, obj);
                }

                @Override // j$.util.function.Consumer
                public /* synthetic */ Consumer andThen(Consumer consumer) {
                    return Consumer.CC.$default$andThen(this, consumer);
                }
            });
        } else {
            Objects.requireNonNull(interfaceC0448m1);
            Supplier supplier = interfaceC0448m1.supplier();
            objW0 = w0(new C0425g2(U2.REFERENCE, interfaceC0448m1.combiner(), interfaceC0448m1.accumulator(), supplier, interfaceC0448m1));
        }
        return interfaceC0448m1.characteristics().contains(InterfaceC0448m1.a.IDENTITY_FINISH) ? objW0 : interfaceC0448m1.finisher().apply(objW0);
    }

    @Override // j$.util.stream.Stream
    public final boolean U(Predicate predicate) {
        return ((Boolean) w0(Q1.u(predicate, N1.ALL))).booleanValue();
    }

    @Override // j$.util.stream.Stream
    public final H1 V(Function function) {
        Objects.requireNonNull(function);
        return new a(this, this, U2.REFERENCE, T2.f8134k | T2.f8132i | T2.o, function);
    }

    @Override // j$.util.stream.Stream
    public final boolean a(Predicate predicate) {
        return ((Boolean) w0(Q1.u(predicate, N1.ANY))).booleanValue();
    }

    @Override // j$.util.stream.Stream
    public final boolean c0(Predicate predicate) {
        return ((Boolean) w0(Q1.u(predicate, N1.NONE))).booleanValue();
    }

    @Override // j$.util.stream.Stream
    public final long count() {
        return ((D1) e0(new ToLongFunction() { // from class: j$.util.stream.p0
            @Override // j$.util.function.ToLongFunction
            public final long applyAsLong(Object obj) {
                return 1L;
            }
        })).sum();
    }

    @Override // j$.util.stream.Stream
    public final Stream distinct() {
        return new C0456o1(this, U2.REFERENCE, T2.f8131h | T2.o);
    }

    @Override // j$.util.stream.Stream
    public final C1 e(Function function) {
        Objects.requireNonNull(function);
        return new i(this, this, U2.REFERENCE, T2.f8134k | T2.f8132i | T2.o, function);
    }

    @Override // j$.util.stream.Stream
    public final H1 e0(ToLongFunction toLongFunction) {
        Objects.requireNonNull(toLongFunction);
        return new f(this, this, U2.REFERENCE, T2.f8134k | T2.f8132i, toLongFunction);
    }

    @Override // j$.util.stream.Stream
    public final j$.util.o findAny() {
        return (j$.util.o) w0(new C0475t1(false, U2.REFERENCE, j$.util.o.a(), C0424g1.a, W0.a));
    }

    @Override // j$.util.stream.Stream
    public final j$.util.o findFirst() {
        return (j$.util.o) w0(new C0475t1(true, U2.REFERENCE, j$.util.o.a(), C0424g1.a, W0.a));
    }

    @Override // j$.util.stream.Stream
    public void forEach(Consumer consumer) {
        Objects.requireNonNull(consumer);
        w0(new AbstractC0487w1.d(consumer, false));
    }

    @Override // j$.util.stream.Stream
    public void g(Consumer consumer) {
        Objects.requireNonNull(consumer);
        w0(new AbstractC0487w1.d(consumer, true));
    }

    @Override // j$.util.stream.Stream
    public final InterfaceC0471s1 h0(ToDoubleFunction toDoubleFunction) {
        Objects.requireNonNull(toDoubleFunction);
        return new g(this, this, U2.REFERENCE, T2.f8134k | T2.f8132i, toDoubleFunction);
    }

    @Override // j$.util.stream.InterfaceC0444l1
    public final Iterator iterator() {
        return j$.util.v.i(spliterator());
    }

    @Override // j$.util.stream.Stream
    public final Object k(Supplier supplier, BiConsumer biConsumer, BiConsumer biConsumer2) {
        Objects.requireNonNull(supplier);
        Objects.requireNonNull(biConsumer);
        Objects.requireNonNull(biConsumer2);
        return w0(new C0433i2(U2.REFERENCE, biConsumer2, biConsumer, supplier));
    }

    @Override // j$.util.stream.Stream
    public final Object l0(Object obj, j$.util.function.p pVar) {
        Objects.requireNonNull(pVar);
        return w0(new C0409c2(U2.REFERENCE, pVar, pVar, obj));
    }

    @Override // j$.util.stream.Stream
    public final Stream limit(long j2) {
        if (j2 >= 0) {
            return B2.i(this, 0L, j2);
        }
        throw new IllegalArgumentException(Long.toString(j2));
    }

    @Override // j$.util.stream.Stream
    public final C1 m(ToIntFunction toIntFunction) {
        Objects.requireNonNull(toIntFunction);
        return new e(this, this, U2.REFERENCE, T2.f8134k | T2.f8132i, toIntFunction);
    }

    @Override // j$.util.stream.Stream
    public final j$.util.o max(final Comparator comparator) {
        Objects.requireNonNull(comparator);
        return s(new j$.util.function.p() { // from class: j$.util.function.d
            @Override // j$.util.function.BiFunction
            public BiFunction andThen(Function function) {
                Objects.requireNonNull(function);
                return new C0388b(this, function);
            }

            @Override // j$.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return comparator.compare(obj, obj2) >= 0 ? obj : obj2;
            }
        });
    }

    @Override // j$.util.stream.Stream
    public final j$.util.o min(final Comparator comparator) {
        Objects.requireNonNull(comparator);
        return s(new j$.util.function.p() { // from class: j$.util.function.c
            @Override // j$.util.function.BiFunction
            public BiFunction andThen(Function function) {
                Objects.requireNonNull(function);
                return new C0388b(this, function);
            }

            @Override // j$.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return comparator.compare(obj, obj2) <= 0 ? obj : obj2;
            }
        });
    }

    @Override // j$.util.stream.Stream
    public final Stream n(Function function) {
        Objects.requireNonNull(function);
        return new d(this, this, U2.REFERENCE, T2.f8134k | T2.f8132i, function);
    }

    @Override // j$.util.stream.Stream
    public final Stream p(Function function) {
        Objects.requireNonNull(function);
        return new h(this, this, U2.REFERENCE, T2.f8134k | T2.f8132i | T2.o, function);
    }

    @Override // j$.util.stream.Stream
    public final j$.util.o s(j$.util.function.p pVar) {
        Objects.requireNonNull(pVar);
        return (j$.util.o) w0(new C0417e2(U2.REFERENCE, pVar));
    }

    @Override // j$.util.stream.T1
    final R1.a s0(long j2, j$.util.function.z zVar) {
        return S1.d(j2, zVar);
    }

    @Override // j$.util.stream.Stream
    public final Stream skip(long j2) {
        if (j2 >= 0) {
            return j2 == 0 ? this : B2.i(this, j2, -1L);
        }
        throw new IllegalArgumentException(Long.toString(j2));
    }

    @Override // j$.util.stream.Stream
    public final Stream sorted() {
        return new M2(this);
    }

    @Override // j$.util.stream.Stream
    public final Object[] toArray() {
        C0463q0 c0463q0 = new j$.util.function.z() { // from class: j$.util.stream.q0
            @Override // j$.util.function.z
            public final Object apply(int i2) {
                return new Object[i2];
            }
        };
        return S1.l(x0(c0463q0), c0463q0).p(c0463q0);
    }

    @Override // j$.util.stream.Stream
    public final Object[] toArray(j$.util.function.z zVar) {
        return S1.l(x0(zVar), zVar).p(zVar);
    }

    @Override // j$.util.stream.InterfaceC0444l1
    public InterfaceC0444l1 unordered() {
        return !B0() ? this : new C0500z2(this, this, U2.REFERENCE, T2.m);
    }

    @Override // j$.util.stream.AbstractC0428h1
    final R1 y0(T1 t1, Spliterator spliterator, boolean z, j$.util.function.z zVar) {
        return S1.e(t1, spliterator, z, zVar);
    }

    @Override // j$.util.stream.Stream
    public final Object z(Object obj, BiFunction biFunction, j$.util.function.p pVar) {
        Objects.requireNonNull(biFunction);
        Objects.requireNonNull(pVar);
        return w0(new C0409c2(U2.REFERENCE, pVar, biFunction, obj));
    }

    @Override // j$.util.stream.AbstractC0428h1
    final void z0(Spliterator spliterator, A2 a2) {
        while (!a2.o() && spliterator.b(a2)) {
        }
    }

    @Override // j$.util.stream.Stream
    public final Stream sorted(Comparator comparator) {
        return new M2(this, comparator);
    }
}

package j$.util.stream;

import j$.util.Spliterator;
import j$.util.function.BiFunction;
import j$.util.function.C0388b;
import j$.util.function.C0392f;
import j$.util.function.C0395i;
import j$.util.function.C0396j;
import j$.util.function.Consumer;
import j$.util.function.Function;
import j$.util.stream.A2;
import j$.util.stream.R1;
import j$.util.stream.S1;
import j$.util.stream.S2;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Deque;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.CountedCompleter;

/* JADX INFO: loaded from: classes2.dex */
final class S1 {
    private static final R1 a = new j.d(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final R1.c f8072b = new j.b();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final R1.d f8073c = new j.c();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final R1.b f8074d = new j.a();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int[] f8075e = new int[0];

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final long[] f8076f = new long[0];

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final double[] f8077g = new double[0];

    private static abstract class b<T, T_NODE extends R1<T>> implements R1<T> {
        protected final R1 a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        protected final R1 f8078b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final long f8079c;

        b(R1 r1, R1 r12) {
            this.a = r1;
            this.f8078b = r12;
            this.f8079c = r1.count() + r12.count();
        }

        @Override // j$.util.stream.R1
        public /* bridge */ /* synthetic */ R1.e b(int i2) {
            return (R1.e) b(i2);
        }

        @Override // j$.util.stream.R1
        public R1 b(int i2) {
            if (i2 == 0) {
                return this.a;
            }
            if (i2 == 1) {
                return this.f8078b;
            }
            throw new IndexOutOfBoundsException();
        }

        @Override // j$.util.stream.R1
        public long count() {
            return this.f8079c;
        }

        @Override // j$.util.stream.R1
        public int n() {
            return 2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class c<T> implements R1<T> {
        final Object[] a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f8080b;

        c(long j2, j$.util.function.z zVar) {
            if (j2 >= 2147483639) {
                throw new IllegalArgumentException("Stream size exceeds max array size");
            }
            this.a = (Object[]) zVar.apply((int) j2);
            this.f8080b = 0;
        }

        c(Object[] objArr) {
            this.a = objArr;
            this.f8080b = objArr.length;
        }

        @Override // j$.util.stream.R1
        public R1 b(int i2) {
            throw new IndexOutOfBoundsException();
        }

        @Override // j$.util.stream.R1
        public long count() {
            return this.f8080b;
        }

        @Override // j$.util.stream.R1
        public void forEach(Consumer consumer) {
            for (int i2 = 0; i2 < this.f8080b; i2++) {
                consumer.accept(this.a[i2]);
            }
        }

        @Override // j$.util.stream.R1
        public void i(Object[] objArr, int i2) {
            System.arraycopy(this.a, 0, objArr, i2, this.f8080b);
        }

        @Override // j$.util.stream.R1
        public /* synthetic */ int n() {
            return 0;
        }

        @Override // j$.util.stream.R1
        public Object[] p(j$.util.function.z zVar) {
            Object[] objArr = this.a;
            if (objArr.length == this.f8080b) {
                return objArr;
            }
            throw new IllegalStateException();
        }

        @Override // j$.util.stream.R1
        public /* synthetic */ R1 q(long j2, long j3, j$.util.function.z zVar) {
            return Q1.n(this, j2, j3, zVar);
        }

        @Override // j$.util.stream.R1
        public Spliterator spliterator() {
            return j$.util.v.n(this.a, 0, this.f8080b, 1040);
        }

        public String toString() {
            return String.format("ArrayNode[%d][%s]", Integer.valueOf(this.a.length - this.f8080b), Arrays.toString(this.a));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static final class d<T> implements R1<T> {
        private final Collection a;

        d(Collection collection) {
            this.a = collection;
        }

        @Override // j$.util.stream.R1
        public R1 b(int i2) {
            throw new IndexOutOfBoundsException();
        }

        @Override // j$.util.stream.R1
        public long count() {
            return this.a.size();
        }

        @Override // j$.util.stream.R1
        public void forEach(Consumer consumer) {
            j$.time.a.v(this.a, consumer);
        }

        @Override // j$.util.stream.R1
        public void i(Object[] objArr, int i2) {
            Iterator it = this.a.iterator();
            while (it.hasNext()) {
                objArr[i2] = it.next();
                i2++;
            }
        }

        @Override // j$.util.stream.R1
        public /* synthetic */ int n() {
            return 0;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // j$.util.stream.R1
        public Object[] p(j$.util.function.z zVar) {
            Collection collection = this.a;
            return collection.toArray((Object[]) zVar.apply(collection.size()));
        }

        @Override // j$.util.stream.R1
        public /* synthetic */ R1 q(long j2, long j3, j$.util.function.z zVar) {
            return Q1.n(this, j2, j3, zVar);
        }

        @Override // j$.util.stream.R1
        public Spliterator spliterator() {
            Collection collection = this.a;
            return (collection instanceof j$.util.Collection ? ((j$.util.Collection) collection).stream() : Q1.v(j$.time.a.A(collection), false)).spliterator();
        }

        public String toString() {
            return String.format("CollectionNode[%d][%s]", Integer.valueOf(this.a.size()), this.a);
        }
    }

    private static class e<P_IN, P_OUT, T_NODE extends R1<P_OUT>, T_BUILDER extends R1.a<P_OUT>> extends AbstractC0440k1<P_IN, P_OUT, T_NODE, e<P_IN, P_OUT, T_NODE, T_BUILDER>> {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        protected final T1 f8081h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        protected final j$.util.function.F f8082i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        protected final j$.util.function.p f8083j;

        private static final class a<P_IN> extends e<P_IN, Double, R1.b, R1.a.InterfaceC0221a> {
            a(T1 t1, Spliterator spliterator) {
                super(t1, spliterator, new j$.util.function.F() { // from class: j$.util.stream.e1
                    @Override // j$.util.function.F
                    public final Object apply(long j2) {
                        return S1.j(j2);
                    }
                }, new j$.util.function.p() { // from class: j$.util.stream.Z
                    @Override // j$.util.function.BiFunction
                    public BiFunction andThen(Function function) {
                        Objects.requireNonNull(function);
                        return new C0388b(this, function);
                    }

                    @Override // j$.util.function.BiFunction
                    public final Object apply(Object obj, Object obj2) {
                        return new S1.f.a((R1.b) obj, (R1.b) obj2);
                    }
                });
            }
        }

        private static final class b<P_IN> extends e<P_IN, Integer, R1.c, R1.a.b> {
            b(T1 t1, Spliterator spliterator) {
                super(t1, spliterator, new j$.util.function.F() { // from class: j$.util.stream.c1
                    @Override // j$.util.function.F
                    public final Object apply(long j2) {
                        return S1.p(j2);
                    }
                }, new j$.util.function.p() { // from class: j$.util.stream.f
                    @Override // j$.util.function.BiFunction
                    public BiFunction andThen(Function function) {
                        Objects.requireNonNull(function);
                        return new C0388b(this, function);
                    }

                    @Override // j$.util.function.BiFunction
                    public final Object apply(Object obj, Object obj2) {
                        return new S1.f.b((R1.c) obj, (R1.c) obj2);
                    }
                });
            }
        }

        private static final class c<P_IN> extends e<P_IN, Long, R1.d, R1.a.c> {
            c(T1 t1, Spliterator spliterator) {
                super(t1, spliterator, new j$.util.function.F() { // from class: j$.util.stream.B
                    @Override // j$.util.function.F
                    public final Object apply(long j2) {
                        return S1.q(j2);
                    }
                }, new j$.util.function.p() { // from class: j$.util.stream.y
                    @Override // j$.util.function.BiFunction
                    public BiFunction andThen(Function function) {
                        Objects.requireNonNull(function);
                        return new C0388b(this, function);
                    }

                    @Override // j$.util.function.BiFunction
                    public final Object apply(Object obj, Object obj2) {
                        return new S1.f.c((R1.d) obj, (R1.d) obj2);
                    }
                });
            }
        }

        private static final class d<P_IN, P_OUT> extends e<P_IN, P_OUT, R1<P_OUT>, R1.a<P_OUT>> {
            d(T1 t1, final j$.util.function.z zVar, Spliterator spliterator) {
                super(t1, spliterator, new j$.util.function.F() { // from class: j$.util.stream.j0
                    @Override // j$.util.function.F
                    public final Object apply(long j2) {
                        return S1.d(j2, zVar);
                    }
                }, new j$.util.function.p() { // from class: j$.util.stream.P0
                    @Override // j$.util.function.BiFunction
                    public BiFunction andThen(Function function) {
                        Objects.requireNonNull(function);
                        return new C0388b(this, function);
                    }

                    @Override // j$.util.function.BiFunction
                    public final Object apply(Object obj, Object obj2) {
                        return new S1.f((R1) obj, (R1) obj2);
                    }
                });
            }
        }

        e(e eVar, Spliterator spliterator) {
            super(eVar, spliterator);
            this.f8081h = eVar.f8081h;
            this.f8082i = eVar.f8082i;
            this.f8083j = eVar.f8083j;
        }

        e(T1 t1, Spliterator spliterator, j$.util.function.F f2, j$.util.function.p pVar) {
            super(t1, spliterator);
            this.f8081h = t1;
            this.f8082i = f2;
            this.f8083j = pVar;
        }

        @Override // j$.util.stream.AbstractC0440k1
        protected Object a() {
            R1.a aVar = (R1.a) this.f8082i.apply(this.f8081h.p0(this.f8225c));
            this.f8081h.t0(aVar, this.f8225c);
            return aVar.a();
        }

        @Override // j$.util.stream.AbstractC0440k1
        protected AbstractC0440k1 f(Spliterator spliterator) {
            return new e(this, spliterator);
        }

        @Override // j$.util.stream.AbstractC0440k1, java.util.concurrent.CountedCompleter
        public void onCompletion(CountedCompleter countedCompleter) {
            if (!d()) {
                g((R1) this.f8083j.apply((R1) ((e) this.f8227e).b(), (R1) ((e) this.f8228f).b()));
            }
            this.f8225c = null;
            this.f8228f = null;
            this.f8227e = null;
        }
    }

    static final class f<T> extends b<T, R1<T>> implements R1<T> {

        static final class a extends d<Double, j$.util.function.s, double[], Spliterator.a, R1.b> implements R1.b {
            a(R1.b bVar, R1.b bVar2) {
                super(bVar, bVar2);
            }

            @Override // j$.util.stream.R1
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public /* synthetic */ void i(Double[] dArr, int i2) {
                Q1.e(this, dArr, i2);
            }

            @Override // j$.util.stream.R1.e
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public double[] c(int i2) {
                return new double[i2];
            }

            @Override // j$.util.stream.R1
            public /* synthetic */ void forEach(Consumer consumer) {
                Q1.h(this, consumer);
            }

            @Override // j$.util.stream.R1
            /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
            public /* synthetic */ R1.b q(long j2, long j3, j$.util.function.z zVar) {
                return Q1.k(this, j2, j3, zVar);
            }

            @Override // j$.util.stream.R1
            public Spliterator.d spliterator() {
                return new o.a(this);
            }

            @Override // j$.util.stream.R1
            public Spliterator spliterator() {
                return new o.a(this);
            }
        }

        static final class b extends d<Integer, j$.util.function.y, int[], Spliterator.b, R1.c> implements R1.c {
            b(R1.c cVar, R1.c cVar2) {
                super(cVar, cVar2);
            }

            @Override // j$.util.stream.R1
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public /* synthetic */ void i(Integer[] numArr, int i2) {
                Q1.f(this, numArr, i2);
            }

            @Override // j$.util.stream.R1.e
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public int[] c(int i2) {
                return new int[i2];
            }

            @Override // j$.util.stream.R1
            public /* synthetic */ void forEach(Consumer consumer) {
                Q1.i(this, consumer);
            }

            @Override // j$.util.stream.R1
            /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
            public /* synthetic */ R1.c q(long j2, long j3, j$.util.function.z zVar) {
                return Q1.l(this, j2, j3, zVar);
            }

            @Override // j$.util.stream.R1
            public Spliterator.d spliterator() {
                return new o.b(this);
            }

            @Override // j$.util.stream.R1
            public Spliterator spliterator() {
                return new o.b(this);
            }
        }

        static final class c extends d<Long, j$.util.function.E, long[], Spliterator.c, R1.d> implements R1.d {
            c(R1.d dVar, R1.d dVar2) {
                super(dVar, dVar2);
            }

            @Override // j$.util.stream.R1
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public /* synthetic */ void i(Long[] lArr, int i2) {
                Q1.g(this, lArr, i2);
            }

            @Override // j$.util.stream.R1.e
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public long[] c(int i2) {
                return new long[i2];
            }

            @Override // j$.util.stream.R1
            public /* synthetic */ void forEach(Consumer consumer) {
                Q1.j(this, consumer);
            }

            @Override // j$.util.stream.R1
            /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
            public /* synthetic */ R1.d q(long j2, long j3, j$.util.function.z zVar) {
                return Q1.m(this, j2, j3, zVar);
            }

            @Override // j$.util.stream.R1
            public Spliterator.d spliterator() {
                return new o.c(this);
            }

            @Override // j$.util.stream.R1
            public Spliterator spliterator() {
                return new o.c(this);
            }
        }

        private static abstract class d<E, T_CONS, T_ARR, T_SPLITR extends Spliterator.d<E, T_CONS, T_SPLITR>, T_NODE extends R1.e<E, T_CONS, T_ARR, T_SPLITR, T_NODE>> extends b<E, T_NODE> implements R1.e<E, T_CONS, T_ARR, T_SPLITR, T_NODE> {
            d(R1.e eVar, R1.e eVar2) {
                super(eVar, eVar2);
            }

            @Override // j$.util.stream.R1.e
            public void d(Object obj, int i2) {
                ((R1.e) this.a).d(obj, i2);
                ((R1.e) this.f8078b).d(obj, i2 + ((int) ((R1.e) this.a).count()));
            }

            @Override // j$.util.stream.R1.e
            public Object e() {
                long jCount = count();
                if (jCount >= 2147483639) {
                    throw new IllegalArgumentException("Stream size exceeds max array size");
                }
                Object objC = c((int) jCount);
                d(objC, 0);
                return objC;
            }

            @Override // j$.util.stream.R1.e
            public void g(Object obj) {
                ((R1.e) this.a).g(obj);
                ((R1.e) this.f8078b).g(obj);
            }

            @Override // j$.util.stream.R1
            public /* synthetic */ Object[] p(j$.util.function.z zVar) {
                return Q1.d(this, zVar);
            }

            public String toString() {
                return count() < 32 ? String.format("%s[%s.%s]", getClass().getName(), this.a, this.f8078b) : String.format("%s[size=%d]", getClass().getName(), Long.valueOf(count()));
            }
        }

        f(R1 r1, R1 r12) {
            super(r1, r12);
        }

        @Override // j$.util.stream.R1
        public void forEach(Consumer consumer) {
            this.a.forEach(consumer);
            this.f8078b.forEach(consumer);
        }

        @Override // j$.util.stream.R1
        public void i(Object[] objArr, int i2) {
            Objects.requireNonNull(objArr);
            this.a.i(objArr, i2);
            this.f8078b.i(objArr, i2 + ((int) this.a.count()));
        }

        @Override // j$.util.stream.R1
        public Object[] p(j$.util.function.z zVar) {
            long jCount = count();
            if (jCount >= 2147483639) {
                throw new IllegalArgumentException("Stream size exceeds max array size");
            }
            Object[] objArr = (Object[]) zVar.apply((int) jCount);
            i(objArr, 0);
            return objArr;
        }

        @Override // j$.util.stream.R1
        public R1 q(long j2, long j3, j$.util.function.z zVar) {
            if (j2 == 0 && j3 == count()) {
                return this;
            }
            long jCount = this.a.count();
            return j2 >= jCount ? this.f8078b.q(j2 - jCount, j3 - jCount, zVar) : j3 <= jCount ? this.a.q(j2, j3, zVar) : S1.i(U2.REFERENCE, this.a.q(j2, jCount, zVar), this.f8078b.q(0L, j3 - jCount, zVar));
        }

        @Override // j$.util.stream.R1
        public Spliterator spliterator() {
            return new o.e(this);
        }

        public String toString() {
            return count() < 32 ? String.format("ConcNode[%s.%s]", this.a, this.f8078b) : String.format("ConcNode[size=%d]", Long.valueOf(count()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class g implements R1.b {
        final double[] a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f8084b;

        g(long j2) {
            if (j2 >= 2147483639) {
                throw new IllegalArgumentException("Stream size exceeds max array size");
            }
            this.a = new double[(int) j2];
            this.f8084b = 0;
        }

        g(double[] dArr) {
            this.a = dArr;
            this.f8084b = dArr.length;
        }

        @Override // j$.util.stream.R1.e, j$.util.stream.R1
        public R1.e b(int i2) {
            throw new IndexOutOfBoundsException();
        }

        @Override // j$.util.stream.R1
        public long count() {
            return this.f8084b;
        }

        @Override // j$.util.stream.R1.e
        public void d(Object obj, int i2) {
            System.arraycopy(this.a, 0, (double[]) obj, i2, this.f8084b);
        }

        @Override // j$.util.stream.R1.e
        public Object e() {
            double[] dArr = this.a;
            int length = dArr.length;
            int i2 = this.f8084b;
            return length == i2 ? dArr : Arrays.copyOf(dArr, i2);
        }

        @Override // j$.util.stream.R1
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void i(Double[] dArr, int i2) {
            Q1.e(this, dArr, i2);
        }

        @Override // j$.util.stream.R1
        public /* synthetic */ void forEach(Consumer consumer) {
            Q1.h(this, consumer);
        }

        @Override // j$.util.stream.R1.e
        public void g(Object obj) {
            j$.util.function.s sVar = (j$.util.function.s) obj;
            for (int i2 = 0; i2 < this.f8084b; i2++) {
                sVar.accept(this.a[i2]);
            }
        }

        @Override // j$.util.stream.R1
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ R1.b q(long j2, long j3, j$.util.function.z zVar) {
            return Q1.k(this, j2, j3, zVar);
        }

        @Override // j$.util.stream.R1
        public /* synthetic */ int n() {
            return 0;
        }

        @Override // j$.util.stream.R1
        public /* synthetic */ Object[] p(j$.util.function.z zVar) {
            return Q1.d(this, zVar);
        }

        @Override // j$.util.stream.R1.e, j$.util.stream.R1
        public Spliterator.d spliterator() {
            return j$.util.v.j(this.a, 0, this.f8084b, 1040);
        }

        public String toString() {
            return String.format("DoubleArrayNode[%d][%s]", Integer.valueOf(this.a.length - this.f8084b), Arrays.toString(this.a));
        }

        @Override // j$.util.stream.R1
        public /* synthetic */ R1 b(int i2) {
            b(i2);
            throw null;
        }

        @Override // j$.util.stream.R1
        public Spliterator spliterator() {
            return j$.util.v.j(this.a, 0, this.f8084b, 1040);
        }
    }

    private static final class h extends g implements R1.a.InterfaceC0221a {
        h(long j2) {
            super(j2);
        }

        @Override // j$.util.stream.R1.a.InterfaceC0221a, j$.util.stream.R1.a
        public R1.b a() {
            if (this.f8084b >= this.a.length) {
                return this;
            }
            throw new IllegalStateException(String.format("Current size %d is less than fixed size %d", Integer.valueOf(this.f8084b), Integer.valueOf(this.a.length)));
        }

        @Override // j$.util.stream.R1.a
        public /* bridge */ /* synthetic */ R1 a() {
            a();
            return this;
        }

        @Override // j$.util.stream.A2
        public void accept(double d2) {
            int i2 = this.f8084b;
            double[] dArr = this.a;
            if (i2 >= dArr.length) {
                throw new IllegalStateException(String.format("Accept exceeded fixed size of %d", Integer.valueOf(this.a.length)));
            }
            this.f8084b = i2 + 1;
            dArr[i2] = d2;
        }

        @Override // j$.util.stream.A2, j$.util.function.y
        public /* synthetic */ void accept(int i2) {
            j$.time.a.a(this);
            throw null;
        }

        @Override // j$.util.stream.A2
        public /* synthetic */ void accept(long j2) {
            j$.time.a.b(this);
            throw null;
        }

        @Override // j$.util.function.Consumer
        public /* synthetic */ Consumer andThen(Consumer consumer) {
            return Consumer.CC.$default$andThen(this, consumer);
        }

        @Override // j$.util.function.s
        public j$.util.function.s j(j$.util.function.s sVar) {
            Objects.requireNonNull(sVar);
            return new C0392f(this, sVar);
        }

        @Override // j$.util.stream.A2
        public void l() {
            if (this.f8084b < this.a.length) {
                throw new IllegalStateException(String.format("End size %d is less than fixed size %d", Integer.valueOf(this.f8084b), Integer.valueOf(this.a.length)));
            }
        }

        @Override // j$.util.stream.A2
        public void m(long j2) {
            if (j2 != this.a.length) {
                throw new IllegalStateException(String.format("Begin size %d is not equal to fixed size %d", Long.valueOf(j2), Integer.valueOf(this.a.length)));
            }
            this.f8084b = 0;
        }

        @Override // j$.util.stream.A2
        public /* synthetic */ boolean o() {
            return false;
        }

        @Override // j$.util.function.Consumer
        /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void accept(Double d2) {
            Q1.a(this, d2);
        }

        @Override // j$.util.stream.S1.g
        public String toString() {
            return String.format("DoubleFixedNodeBuilder[%d][%s]", Integer.valueOf(this.a.length - this.f8084b), Arrays.toString(this.a));
        }
    }

    private static final class i extends S2.b implements R1.b, R1.a.InterfaceC0221a {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private boolean f8085g = false;

        i() {
        }

        @Override // j$.util.stream.S2.b
        /* JADX INFO: renamed from: A */
        public Spliterator.a spliterator() {
            return super.spliterator();
        }

        @Override // j$.util.function.Consumer
        /* JADX INFO: renamed from: B, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void accept(Double d2) {
            Q1.a(this, d2);
        }

        @Override // j$.util.stream.R1
        /* JADX INFO: renamed from: C, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void i(Double[] dArr, int i2) {
            Q1.e(this, dArr, i2);
        }

        @Override // j$.util.stream.R1
        /* JADX INFO: renamed from: D, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ R1.b q(long j2, long j3, j$.util.function.z zVar) {
            return Q1.k(this, j2, j3, zVar);
        }

        @Override // j$.util.stream.R1.a.InterfaceC0221a, j$.util.stream.R1.a
        public R1.b a() {
            return this;
        }

        @Override // j$.util.stream.R1.a
        public R1 a() {
            return this;
        }

        @Override // j$.util.stream.S2.b, j$.util.function.s
        public void accept(double d2) {
            super.accept(d2);
        }

        @Override // j$.util.stream.A2, j$.util.function.y
        public /* synthetic */ void accept(int i2) {
            j$.time.a.a(this);
            throw null;
        }

        @Override // j$.util.stream.A2
        public /* synthetic */ void accept(long j2) {
            j$.time.a.b(this);
            throw null;
        }

        @Override // j$.util.function.Consumer
        public /* synthetic */ Consumer andThen(Consumer consumer) {
            return Consumer.CC.$default$andThen(this, consumer);
        }

        @Override // j$.util.stream.R1.e, j$.util.stream.R1
        public R1.e b(int i2) {
            throw new IndexOutOfBoundsException();
        }

        @Override // j$.util.stream.S2.e, j$.util.stream.R1.e
        public void d(Object obj, int i2) {
            super.d((double[]) obj, i2);
        }

        @Override // j$.util.stream.S2.e, j$.util.stream.R1.e
        public Object e() {
            return (double[]) super.e();
        }

        @Override // j$.util.stream.S2.e, j$.util.stream.R1.e
        public void g(Object obj) {
            super.g((j$.util.function.s) obj);
        }

        @Override // j$.util.stream.A2
        public void l() {
            this.f8085g = false;
        }

        @Override // j$.util.stream.A2
        public void m(long j2) {
            this.f8085g = true;
            clear();
            w(j2);
        }

        @Override // j$.util.stream.R1
        public /* synthetic */ int n() {
            return 0;
        }

        @Override // j$.util.stream.A2
        public /* synthetic */ boolean o() {
            return false;
        }

        @Override // j$.util.stream.R1
        public /* synthetic */ Object[] p(j$.util.function.z zVar) {
            return Q1.d(this, zVar);
        }

        @Override // j$.util.stream.S2.b, j$.util.stream.S2.e, java.lang.Iterable, j$.lang.Iterable
        public Spliterator.d spliterator() {
            return super.spliterator();
        }

        @Override // j$.util.stream.R1
        public /* synthetic */ R1 b(int i2) {
            b(i2);
            throw null;
        }

        @Override // j$.util.stream.S2.b, j$.util.stream.S2.e, java.lang.Iterable, j$.lang.Iterable
        public Spliterator spliterator() {
            return super.spliterator();
        }
    }

    private static abstract class j<T, T_ARR, T_CONS> implements R1<T> {

        private static final class a extends j<Double, double[], j$.util.function.s> implements R1.b {
            a() {
            }

            @Override // j$.util.stream.R1
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public /* synthetic */ void i(Double[] dArr, int i2) {
                Q1.e(this, dArr, i2);
            }

            @Override // j$.util.stream.S1.j, j$.util.stream.R1
            public R1.e b(int i2) {
                throw new IndexOutOfBoundsException();
            }

            @Override // j$.util.stream.R1.e
            public Object e() {
                return S1.f8077g;
            }

            @Override // j$.util.stream.S1.j, j$.util.stream.R1
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public /* synthetic */ R1.b q(long j2, long j3, j$.util.function.z zVar) {
                return Q1.k(this, j2, j3, zVar);
            }

            @Override // j$.util.stream.R1
            public /* synthetic */ void forEach(Consumer consumer) {
                Q1.h(this, consumer);
            }

            @Override // j$.util.stream.R1
            public Spliterator.d spliterator() {
                return j$.util.v.b();
            }

            @Override // j$.util.stream.S1.j, j$.util.stream.R1
            public /* synthetic */ R1 b(int i2) {
                b(i2);
                throw null;
            }

            @Override // j$.util.stream.R1
            public Spliterator spliterator() {
                return j$.util.v.b();
            }
        }

        private static final class b extends j<Integer, int[], j$.util.function.y> implements R1.c {
            b() {
            }

            @Override // j$.util.stream.R1
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public /* synthetic */ void i(Integer[] numArr, int i2) {
                Q1.f(this, numArr, i2);
            }

            @Override // j$.util.stream.S1.j, j$.util.stream.R1
            public R1.e b(int i2) {
                throw new IndexOutOfBoundsException();
            }

            @Override // j$.util.stream.R1.e
            public Object e() {
                return S1.f8075e;
            }

            @Override // j$.util.stream.S1.j, j$.util.stream.R1
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public /* synthetic */ R1.c q(long j2, long j3, j$.util.function.z zVar) {
                return Q1.l(this, j2, j3, zVar);
            }

            @Override // j$.util.stream.R1
            public /* synthetic */ void forEach(Consumer consumer) {
                Q1.i(this, consumer);
            }

            @Override // j$.util.stream.R1
            public Spliterator.d spliterator() {
                return j$.util.v.c();
            }

            @Override // j$.util.stream.S1.j, j$.util.stream.R1
            public /* synthetic */ R1 b(int i2) {
                b(i2);
                throw null;
            }

            @Override // j$.util.stream.R1
            public Spliterator spliterator() {
                return j$.util.v.c();
            }
        }

        private static final class c extends j<Long, long[], j$.util.function.E> implements R1.d {
            c() {
            }

            @Override // j$.util.stream.R1
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public /* synthetic */ void i(Long[] lArr, int i2) {
                Q1.g(this, lArr, i2);
            }

            @Override // j$.util.stream.S1.j, j$.util.stream.R1
            public R1.e b(int i2) {
                throw new IndexOutOfBoundsException();
            }

            @Override // j$.util.stream.R1.e
            public Object e() {
                return S1.f8076f;
            }

            @Override // j$.util.stream.S1.j, j$.util.stream.R1
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public /* synthetic */ R1.d q(long j2, long j3, j$.util.function.z zVar) {
                return Q1.m(this, j2, j3, zVar);
            }

            @Override // j$.util.stream.R1
            public /* synthetic */ void forEach(Consumer consumer) {
                Q1.j(this, consumer);
            }

            @Override // j$.util.stream.R1
            public Spliterator.d spliterator() {
                return j$.util.v.d();
            }

            @Override // j$.util.stream.S1.j, j$.util.stream.R1
            public /* synthetic */ R1 b(int i2) {
                b(i2);
                throw null;
            }

            @Override // j$.util.stream.R1
            public Spliterator spliterator() {
                return j$.util.v.d();
            }
        }

        private static class d<T> extends j<T, T[], Consumer<? super T>> {
            d(a aVar) {
            }

            @Override // j$.util.stream.R1
            public void forEach(Consumer consumer) {
            }

            @Override // j$.util.stream.R1
            public void i(Object[] objArr, int i2) {
            }

            @Override // j$.util.stream.R1
            public Spliterator spliterator() {
                return j$.util.v.e();
            }
        }

        j() {
        }

        @Override // j$.util.stream.R1
        public R1 b(int i2) {
            throw new IndexOutOfBoundsException();
        }

        @Override // j$.util.stream.R1
        public long count() {
            return 0L;
        }

        public void d(Object obj, int i2) {
        }

        public void g(Object obj) {
        }

        @Override // j$.util.stream.R1
        public /* synthetic */ int n() {
            return 0;
        }

        @Override // j$.util.stream.R1
        public Object[] p(j$.util.function.z zVar) {
            return (Object[]) zVar.apply(0);
        }

        @Override // j$.util.stream.R1
        public /* synthetic */ R1 q(long j2, long j3, j$.util.function.z zVar) {
            return Q1.n(this, j2, j3, zVar);
        }
    }

    private static final class k<T> extends c<T> implements R1.a<T> {
        k(long j2, j$.util.function.z zVar) {
            super(j2, zVar);
        }

        @Override // j$.util.stream.R1.a
        public R1 a() {
            if (this.f8080b >= this.a.length) {
                return this;
            }
            throw new IllegalStateException(String.format("Current size %d is less than fixed size %d", Integer.valueOf(this.f8080b), Integer.valueOf(this.a.length)));
        }

        @Override // j$.util.stream.A2
        public /* synthetic */ void accept(double d2) {
            j$.time.a.c(this);
            throw null;
        }

        @Override // j$.util.stream.A2, j$.util.function.y
        public /* synthetic */ void accept(int i2) {
            j$.time.a.a(this);
            throw null;
        }

        @Override // j$.util.stream.A2
        public /* synthetic */ void accept(long j2) {
            j$.time.a.b(this);
            throw null;
        }

        @Override // j$.util.function.Consumer
        public void accept(Object obj) {
            int i2 = this.f8080b;
            Object[] objArr = this.a;
            if (i2 >= objArr.length) {
                throw new IllegalStateException(String.format("Accept exceeded fixed size of %d", Integer.valueOf(this.a.length)));
            }
            this.f8080b = i2 + 1;
            objArr[i2] = obj;
        }

        @Override // j$.util.function.Consumer
        public /* synthetic */ Consumer andThen(Consumer consumer) {
            return Consumer.CC.$default$andThen(this, consumer);
        }

        @Override // j$.util.stream.A2
        public void l() {
            if (this.f8080b < this.a.length) {
                throw new IllegalStateException(String.format("End size %d is less than fixed size %d", Integer.valueOf(this.f8080b), Integer.valueOf(this.a.length)));
            }
        }

        @Override // j$.util.stream.A2
        public void m(long j2) {
            if (j2 != this.a.length) {
                throw new IllegalStateException(String.format("Begin size %d is not equal to fixed size %d", Long.valueOf(j2), Integer.valueOf(this.a.length)));
            }
            this.f8080b = 0;
        }

        @Override // j$.util.stream.A2
        public /* synthetic */ boolean o() {
            return false;
        }

        @Override // j$.util.stream.S1.c
        public String toString() {
            return String.format("FixedNodeBuilder[%d][%s]", Integer.valueOf(this.a.length - this.f8080b), Arrays.toString(this.a));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class l implements R1.c {
        final int[] a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f8086b;

        l(long j2) {
            if (j2 >= 2147483639) {
                throw new IllegalArgumentException("Stream size exceeds max array size");
            }
            this.a = new int[(int) j2];
            this.f8086b = 0;
        }

        l(int[] iArr) {
            this.a = iArr;
            this.f8086b = iArr.length;
        }

        @Override // j$.util.stream.R1.e, j$.util.stream.R1
        public R1.e b(int i2) {
            throw new IndexOutOfBoundsException();
        }

        @Override // j$.util.stream.R1
        public long count() {
            return this.f8086b;
        }

        @Override // j$.util.stream.R1.e
        public void d(Object obj, int i2) {
            System.arraycopy(this.a, 0, (int[]) obj, i2, this.f8086b);
        }

        @Override // j$.util.stream.R1.e
        public Object e() {
            int[] iArr = this.a;
            int length = iArr.length;
            int i2 = this.f8086b;
            return length == i2 ? iArr : Arrays.copyOf(iArr, i2);
        }

        @Override // j$.util.stream.R1
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void i(Integer[] numArr, int i2) {
            Q1.f(this, numArr, i2);
        }

        @Override // j$.util.stream.R1
        public /* synthetic */ void forEach(Consumer consumer) {
            Q1.i(this, consumer);
        }

        @Override // j$.util.stream.R1.e
        public void g(Object obj) {
            j$.util.function.y yVar = (j$.util.function.y) obj;
            for (int i2 = 0; i2 < this.f8086b; i2++) {
                yVar.accept(this.a[i2]);
            }
        }

        @Override // j$.util.stream.R1
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ R1.c q(long j2, long j3, j$.util.function.z zVar) {
            return Q1.l(this, j2, j3, zVar);
        }

        @Override // j$.util.stream.R1
        public /* synthetic */ int n() {
            return 0;
        }

        @Override // j$.util.stream.R1
        public /* synthetic */ Object[] p(j$.util.function.z zVar) {
            return Q1.d(this, zVar);
        }

        @Override // j$.util.stream.R1.e, j$.util.stream.R1
        public Spliterator.d spliterator() {
            return j$.util.v.k(this.a, 0, this.f8086b, 1040);
        }

        public String toString() {
            return String.format("IntArrayNode[%d][%s]", Integer.valueOf(this.a.length - this.f8086b), Arrays.toString(this.a));
        }

        @Override // j$.util.stream.R1
        public /* synthetic */ R1 b(int i2) {
            b(i2);
            throw null;
        }

        @Override // j$.util.stream.R1
        public Spliterator spliterator() {
            return j$.util.v.k(this.a, 0, this.f8086b, 1040);
        }
    }

    private static final class m extends l implements R1.a.b {
        m(long j2) {
            super(j2);
        }

        @Override // j$.util.stream.R1.a.b, j$.util.stream.R1.a
        public R1.c a() {
            if (this.f8086b >= this.a.length) {
                return this;
            }
            throw new IllegalStateException(String.format("Current size %d is less than fixed size %d", Integer.valueOf(this.f8086b), Integer.valueOf(this.a.length)));
        }

        @Override // j$.util.stream.R1.a
        public /* bridge */ /* synthetic */ R1 a() {
            a();
            return this;
        }

        @Override // j$.util.stream.A2
        public /* synthetic */ void accept(double d2) {
            j$.time.a.c(this);
            throw null;
        }

        @Override // j$.util.stream.A2, j$.util.function.y
        public void accept(int i2) {
            int i3 = this.f8086b;
            int[] iArr = this.a;
            if (i3 >= iArr.length) {
                throw new IllegalStateException(String.format("Accept exceeded fixed size of %d", Integer.valueOf(this.a.length)));
            }
            this.f8086b = i3 + 1;
            iArr[i3] = i2;
        }

        @Override // j$.util.stream.A2
        public /* synthetic */ void accept(long j2) {
            j$.time.a.b(this);
            throw null;
        }

        @Override // j$.util.function.Consumer
        public /* synthetic */ Consumer andThen(Consumer consumer) {
            return Consumer.CC.$default$andThen(this, consumer);
        }

        @Override // j$.util.function.y
        public j$.util.function.y k(j$.util.function.y yVar) {
            Objects.requireNonNull(yVar);
            return new C0395i(this, yVar);
        }

        @Override // j$.util.stream.A2
        public void l() {
            if (this.f8086b < this.a.length) {
                throw new IllegalStateException(String.format("End size %d is less than fixed size %d", Integer.valueOf(this.f8086b), Integer.valueOf(this.a.length)));
            }
        }

        @Override // j$.util.stream.A2
        public void m(long j2) {
            if (j2 != this.a.length) {
                throw new IllegalStateException(String.format("Begin size %d is not equal to fixed size %d", Long.valueOf(j2), Integer.valueOf(this.a.length)));
            }
            this.f8086b = 0;
        }

        @Override // j$.util.stream.A2
        public /* synthetic */ boolean o() {
            return false;
        }

        @Override // j$.util.function.Consumer
        /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void accept(Integer num) {
            Q1.b(this, num);
        }

        @Override // j$.util.stream.S1.l
        public String toString() {
            return String.format("IntFixedNodeBuilder[%d][%s]", Integer.valueOf(this.a.length - this.f8086b), Arrays.toString(this.a));
        }
    }

    private static final class n extends S2.c implements R1.c, R1.a.b {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private boolean f8087g = false;

        n() {
        }

        @Override // j$.util.stream.S2.c
        /* JADX INFO: renamed from: A */
        public Spliterator.b spliterator() {
            return super.spliterator();
        }

        @Override // j$.util.function.Consumer
        /* JADX INFO: renamed from: B, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void accept(Integer num) {
            Q1.b(this, num);
        }

        @Override // j$.util.stream.R1
        /* JADX INFO: renamed from: C, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void i(Integer[] numArr, int i2) {
            Q1.f(this, numArr, i2);
        }

        @Override // j$.util.stream.R1
        /* JADX INFO: renamed from: D, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ R1.c q(long j2, long j3, j$.util.function.z zVar) {
            return Q1.l(this, j2, j3, zVar);
        }

        @Override // j$.util.stream.R1.a.b, j$.util.stream.R1.a
        public R1.c a() {
            return this;
        }

        @Override // j$.util.stream.R1.a
        public R1 a() {
            return this;
        }

        @Override // j$.util.stream.A2
        public /* synthetic */ void accept(double d2) {
            j$.time.a.c(this);
            throw null;
        }

        @Override // j$.util.stream.S2.c, j$.util.function.y
        public void accept(int i2) {
            super.accept(i2);
        }

        @Override // j$.util.stream.A2
        public /* synthetic */ void accept(long j2) {
            j$.time.a.b(this);
            throw null;
        }

        @Override // j$.util.function.Consumer
        public /* synthetic */ Consumer andThen(Consumer consumer) {
            return Consumer.CC.$default$andThen(this, consumer);
        }

        @Override // j$.util.stream.R1.e, j$.util.stream.R1
        public R1.e b(int i2) {
            throw new IndexOutOfBoundsException();
        }

        @Override // j$.util.stream.S2.e, j$.util.stream.R1.e
        public void d(Object obj, int i2) {
            super.d((int[]) obj, i2);
        }

        @Override // j$.util.stream.S2.e, j$.util.stream.R1.e
        public Object e() {
            return (int[]) super.e();
        }

        @Override // j$.util.stream.S2.e, j$.util.stream.R1.e
        public void g(Object obj) {
            super.g((j$.util.function.y) obj);
        }

        @Override // j$.util.stream.A2
        public void l() {
            this.f8087g = false;
        }

        @Override // j$.util.stream.A2
        public void m(long j2) {
            this.f8087g = true;
            clear();
            w(j2);
        }

        @Override // j$.util.stream.R1
        public /* synthetic */ int n() {
            return 0;
        }

        @Override // j$.util.stream.A2
        public /* synthetic */ boolean o() {
            return false;
        }

        @Override // j$.util.stream.R1
        public /* synthetic */ Object[] p(j$.util.function.z zVar) {
            return Q1.d(this, zVar);
        }

        @Override // j$.util.stream.S2.c, j$.util.stream.S2.e, java.lang.Iterable, j$.lang.Iterable
        public Spliterator.d spliterator() {
            return super.spliterator();
        }

        @Override // j$.util.stream.R1
        public /* synthetic */ R1 b(int i2) {
            b(i2);
            throw null;
        }

        @Override // j$.util.stream.S2.c, j$.util.stream.S2.e, java.lang.Iterable, j$.lang.Iterable
        public Spliterator spliterator() {
            return super.spliterator();
        }
    }

    private static abstract class o<T, S extends Spliterator<T>, N extends R1<T>> implements Spliterator<T> {
        R1 a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f8088b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Spliterator f8089c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Spliterator f8090d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Deque f8091e;

        private static final class a extends d<Double, j$.util.function.s, double[], Spliterator.a, R1.b> implements Spliterator.a {
            a(R1.b bVar) {
                super(bVar);
            }

            @Override // j$.util.Spliterator
            public /* synthetic */ boolean b(Consumer consumer) {
                return j$.util.s.e(this, consumer);
            }

            @Override // j$.util.Spliterator
            public /* synthetic */ void forEachRemaining(Consumer consumer) {
                j$.util.s.a(this, consumer);
            }
        }

        private static final class b extends d<Integer, j$.util.function.y, int[], Spliterator.b, R1.c> implements Spliterator.b {
            b(R1.c cVar) {
                super(cVar);
            }

            @Override // j$.util.Spliterator
            public /* synthetic */ boolean b(Consumer consumer) {
                return j$.util.s.f(this, consumer);
            }

            @Override // j$.util.Spliterator
            public /* synthetic */ void forEachRemaining(Consumer consumer) {
                j$.util.s.b(this, consumer);
            }
        }

        private static final class c extends d<Long, j$.util.function.E, long[], Spliterator.c, R1.d> implements Spliterator.c {
            c(R1.d dVar) {
                super(dVar);
            }

            @Override // j$.util.Spliterator
            public /* synthetic */ boolean b(Consumer consumer) {
                return j$.util.s.g(this, consumer);
            }

            @Override // j$.util.Spliterator
            public /* synthetic */ void forEachRemaining(Consumer consumer) {
                j$.util.s.c(this, consumer);
            }
        }

        private static abstract class d<T, T_CONS, T_ARR, T_SPLITR extends Spliterator.d<T, T_CONS, T_SPLITR>, N extends R1.e<T, T_CONS, T_ARR, T_SPLITR, N>> extends o<T, T_SPLITR, N> implements Spliterator.d<T, T_CONS, T_SPLITR> {
            d(R1.e eVar) {
                super(eVar);
            }

            @Override // j$.util.Spliterator.d
            /* JADX INFO: renamed from: forEachRemaining, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public void e(Object obj) {
                if (this.a == null) {
                    return;
                }
                if (this.f8090d != null) {
                    while (n(obj)) {
                    }
                    return;
                }
                Spliterator spliterator = this.f8089c;
                if (spliterator != null) {
                    ((Spliterator.d) spliterator).e(obj);
                    return;
                }
                Deque dequeF = f();
                while (true) {
                    R1.e eVar = (R1.e) a(dequeF);
                    if (eVar == null) {
                        this.a = null;
                        return;
                    }
                    eVar.g(obj);
                }
            }

            @Override // j$.util.Spliterator.d
            /* JADX INFO: renamed from: tryAdvance, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public boolean n(Object obj) {
                R1.e eVar;
                if (!h()) {
                    return false;
                }
                boolean zN = ((Spliterator.d) this.f8090d).n(obj);
                if (!zN) {
                    if (this.f8089c == null && (eVar = (R1.e) a(this.f8091e)) != null) {
                        Spliterator.d dVarSpliterator = eVar.spliterator();
                        this.f8090d = dVarSpliterator;
                        return dVarSpliterator.n(obj);
                    }
                    this.a = null;
                }
                return zN;
            }
        }

        private static final class e<T> extends o<T, Spliterator<T>, R1<T>> {
            e(R1 r1) {
                super(r1);
            }

            @Override // j$.util.Spliterator
            public boolean b(Consumer consumer) {
                R1 r1A;
                if (!h()) {
                    return false;
                }
                boolean zB = this.f8090d.b(consumer);
                if (!zB) {
                    if (this.f8089c == null && (r1A = a(this.f8091e)) != null) {
                        Spliterator spliterator = r1A.spliterator();
                        this.f8090d = spliterator;
                        return spliterator.b(consumer);
                    }
                    this.a = null;
                }
                return zB;
            }

            @Override // j$.util.Spliterator
            public void forEachRemaining(Consumer consumer) {
                if (this.a == null) {
                    return;
                }
                if (this.f8090d != null) {
                    while (b(consumer)) {
                    }
                    return;
                }
                Spliterator spliterator = this.f8089c;
                if (spliterator != null) {
                    spliterator.forEachRemaining(consumer);
                    return;
                }
                Deque dequeF = f();
                while (true) {
                    R1 r1A = a(dequeF);
                    if (r1A == null) {
                        this.a = null;
                        return;
                    }
                    r1A.forEach(consumer);
                }
            }
        }

        o(R1 r1) {
            this.a = r1;
        }

        protected final R1 a(Deque deque) {
            while (true) {
                R1 r1 = (R1) deque.pollFirst();
                if (r1 == null) {
                    return null;
                }
                if (r1.n() != 0) {
                    for (int iN = r1.n() - 1; iN >= 0; iN--) {
                        deque.addFirst(r1.b(iN));
                    }
                } else if (r1.count() > 0) {
                    return r1;
                }
            }
        }

        @Override // j$.util.Spliterator
        public final int characteristics() {
            return 64;
        }

        @Override // j$.util.Spliterator
        public final long estimateSize() {
            long jCount = 0;
            if (this.a == null) {
                return 0L;
            }
            Spliterator spliterator = this.f8089c;
            if (spliterator != null) {
                return spliterator.estimateSize();
            }
            for (int i2 = this.f8088b; i2 < this.a.n(); i2++) {
                jCount += this.a.b(i2).count();
            }
            return jCount;
        }

        protected final Deque f() {
            ArrayDeque arrayDeque = new ArrayDeque(8);
            int iN = this.a.n();
            while (true) {
                iN--;
                if (iN < this.f8088b) {
                    return arrayDeque;
                }
                arrayDeque.addFirst(this.a.b(iN));
            }
        }

        @Override // j$.util.Spliterator
        public Comparator getComparator() {
            throw new IllegalStateException();
        }

        @Override // j$.util.Spliterator
        public /* synthetic */ long getExactSizeIfKnown() {
            return j$.time.a.g(this);
        }

        protected final boolean h() {
            if (this.a == null) {
                return false;
            }
            if (this.f8090d != null) {
                return true;
            }
            Spliterator spliterator = this.f8089c;
            if (spliterator == null) {
                Deque dequeF = f();
                this.f8091e = dequeF;
                R1 r1A = a(dequeF);
                if (r1A == null) {
                    this.a = null;
                    return false;
                }
                spliterator = r1A.spliterator();
            }
            this.f8090d = spliterator;
            return true;
        }

        @Override // j$.util.Spliterator
        public /* synthetic */ boolean hasCharacteristics(int i2) {
            return j$.time.a.h(this, i2);
        }

        @Override // j$.util.Spliterator
        public /* bridge */ /* synthetic */ Spliterator.a trySplit() {
            return (Spliterator.a) trySplit();
        }

        @Override // j$.util.Spliterator
        public /* bridge */ /* synthetic */ Spliterator.b trySplit() {
            return (Spliterator.b) trySplit();
        }

        @Override // j$.util.Spliterator
        public /* bridge */ /* synthetic */ Spliterator.c trySplit() {
            return (Spliterator.c) trySplit();
        }

        @Override // j$.util.Spliterator
        public /* bridge */ /* synthetic */ Spliterator.d trySplit() {
            return (Spliterator.d) trySplit();
        }

        @Override // j$.util.Spliterator
        public final Spliterator trySplit() {
            R1 r1 = this.a;
            if (r1 == null || this.f8090d != null) {
                return null;
            }
            Spliterator spliterator = this.f8089c;
            if (spliterator != null) {
                return spliterator.trySplit();
            }
            if (this.f8088b < r1.n() - 1) {
                R1 r12 = this.a;
                int i2 = this.f8088b;
                this.f8088b = i2 + 1;
                return r12.b(i2).spliterator();
            }
            R1 r1B = this.a.b(this.f8088b);
            this.a = r1B;
            if (r1B.n() == 0) {
                Spliterator spliterator2 = this.a.spliterator();
                this.f8089c = spliterator2;
                return spliterator2.trySplit();
            }
            this.f8088b = 0;
            R1 r13 = this.a;
            this.f8088b = 1;
            return r13.b(0).spliterator();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class p implements R1.d {
        final long[] a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f8092b;

        p(long j2) {
            if (j2 >= 2147483639) {
                throw new IllegalArgumentException("Stream size exceeds max array size");
            }
            this.a = new long[(int) j2];
            this.f8092b = 0;
        }

        p(long[] jArr) {
            this.a = jArr;
            this.f8092b = jArr.length;
        }

        @Override // j$.util.stream.R1.e, j$.util.stream.R1
        public R1.e b(int i2) {
            throw new IndexOutOfBoundsException();
        }

        @Override // j$.util.stream.R1
        public long count() {
            return this.f8092b;
        }

        @Override // j$.util.stream.R1.e
        public void d(Object obj, int i2) {
            System.arraycopy(this.a, 0, (long[]) obj, i2, this.f8092b);
        }

        @Override // j$.util.stream.R1.e
        public Object e() {
            long[] jArr = this.a;
            int length = jArr.length;
            int i2 = this.f8092b;
            return length == i2 ? jArr : Arrays.copyOf(jArr, i2);
        }

        @Override // j$.util.stream.R1
        public /* synthetic */ void forEach(Consumer consumer) {
            Q1.j(this, consumer);
        }

        @Override // j$.util.stream.R1.e
        public void g(Object obj) {
            j$.util.function.E e2 = (j$.util.function.E) obj;
            for (int i2 = 0; i2 < this.f8092b; i2++) {
                e2.accept(this.a[i2]);
            }
        }

        @Override // j$.util.stream.R1
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void i(Long[] lArr, int i2) {
            Q1.g(this, lArr, i2);
        }

        @Override // j$.util.stream.R1
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ R1.d q(long j2, long j3, j$.util.function.z zVar) {
            return Q1.m(this, j2, j3, zVar);
        }

        @Override // j$.util.stream.R1
        public /* synthetic */ int n() {
            return 0;
        }

        @Override // j$.util.stream.R1
        public /* synthetic */ Object[] p(j$.util.function.z zVar) {
            return Q1.d(this, zVar);
        }

        @Override // j$.util.stream.R1.e, j$.util.stream.R1
        public Spliterator.d spliterator() {
            return j$.util.v.l(this.a, 0, this.f8092b, 1040);
        }

        public String toString() {
            return String.format("LongArrayNode[%d][%s]", Integer.valueOf(this.a.length - this.f8092b), Arrays.toString(this.a));
        }

        @Override // j$.util.stream.R1
        public /* synthetic */ R1 b(int i2) {
            b(i2);
            throw null;
        }

        @Override // j$.util.stream.R1
        public Spliterator spliterator() {
            return j$.util.v.l(this.a, 0, this.f8092b, 1040);
        }
    }

    private static final class q extends p implements R1.a.c {
        q(long j2) {
            super(j2);
        }

        @Override // j$.util.stream.R1.a.c, j$.util.stream.R1.a
        public R1.d a() {
            if (this.f8092b >= this.a.length) {
                return this;
            }
            throw new IllegalStateException(String.format("Current size %d is less than fixed size %d", Integer.valueOf(this.f8092b), Integer.valueOf(this.a.length)));
        }

        @Override // j$.util.stream.R1.a
        public /* bridge */ /* synthetic */ R1 a() {
            a();
            return this;
        }

        @Override // j$.util.stream.A2
        public /* synthetic */ void accept(double d2) {
            j$.time.a.c(this);
            throw null;
        }

        @Override // j$.util.stream.A2, j$.util.function.y
        public /* synthetic */ void accept(int i2) {
            j$.time.a.a(this);
            throw null;
        }

        @Override // j$.util.stream.A2
        public void accept(long j2) {
            int i2 = this.f8092b;
            long[] jArr = this.a;
            if (i2 >= jArr.length) {
                throw new IllegalStateException(String.format("Accept exceeded fixed size of %d", Integer.valueOf(this.a.length)));
            }
            this.f8092b = i2 + 1;
            jArr[i2] = j2;
        }

        @Override // j$.util.function.Consumer
        public /* synthetic */ Consumer andThen(Consumer consumer) {
            return Consumer.CC.$default$andThen(this, consumer);
        }

        @Override // j$.util.function.E
        public j$.util.function.E f(j$.util.function.E e2) {
            Objects.requireNonNull(e2);
            return new C0396j(this, e2);
        }

        @Override // j$.util.stream.A2
        public void l() {
            if (this.f8092b < this.a.length) {
                throw new IllegalStateException(String.format("End size %d is less than fixed size %d", Integer.valueOf(this.f8092b), Integer.valueOf(this.a.length)));
            }
        }

        @Override // j$.util.stream.A2
        public void m(long j2) {
            if (j2 != this.a.length) {
                throw new IllegalStateException(String.format("Begin size %d is not equal to fixed size %d", Long.valueOf(j2), Integer.valueOf(this.a.length)));
            }
            this.f8092b = 0;
        }

        @Override // j$.util.stream.A2
        public /* synthetic */ boolean o() {
            return false;
        }

        @Override // j$.util.function.Consumer
        /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void accept(Long l2) {
            Q1.c(this, l2);
        }

        @Override // j$.util.stream.S1.p
        public String toString() {
            return String.format("LongFixedNodeBuilder[%d][%s]", Integer.valueOf(this.a.length - this.f8092b), Arrays.toString(this.a));
        }
    }

    private static final class r extends S2.d implements R1.d, R1.a.c {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private boolean f8093g = false;

        r() {
        }

        @Override // j$.util.stream.S2.d
        /* JADX INFO: renamed from: A */
        public Spliterator.c spliterator() {
            return super.spliterator();
        }

        @Override // j$.util.function.Consumer
        /* JADX INFO: renamed from: B, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void accept(Long l2) {
            Q1.c(this, l2);
        }

        @Override // j$.util.stream.R1
        /* JADX INFO: renamed from: C, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void i(Long[] lArr, int i2) {
            Q1.g(this, lArr, i2);
        }

        @Override // j$.util.stream.R1
        /* JADX INFO: renamed from: D, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ R1.d q(long j2, long j3, j$.util.function.z zVar) {
            return Q1.m(this, j2, j3, zVar);
        }

        @Override // j$.util.stream.R1.a.c, j$.util.stream.R1.a
        public R1.d a() {
            return this;
        }

        @Override // j$.util.stream.R1.a
        public R1 a() {
            return this;
        }

        @Override // j$.util.stream.A2
        public /* synthetic */ void accept(double d2) {
            j$.time.a.c(this);
            throw null;
        }

        @Override // j$.util.stream.A2, j$.util.function.y
        public /* synthetic */ void accept(int i2) {
            j$.time.a.a(this);
            throw null;
        }

        @Override // j$.util.stream.S2.d, j$.util.function.E
        public void accept(long j2) {
            super.accept(j2);
        }

        @Override // j$.util.function.Consumer
        public /* synthetic */ Consumer andThen(Consumer consumer) {
            return Consumer.CC.$default$andThen(this, consumer);
        }

        @Override // j$.util.stream.R1.e, j$.util.stream.R1
        public R1.e b(int i2) {
            throw new IndexOutOfBoundsException();
        }

        @Override // j$.util.stream.S2.e, j$.util.stream.R1.e
        public void d(Object obj, int i2) {
            super.d((long[]) obj, i2);
        }

        @Override // j$.util.stream.S2.e, j$.util.stream.R1.e
        public Object e() {
            return (long[]) super.e();
        }

        @Override // j$.util.stream.S2.e, j$.util.stream.R1.e
        public void g(Object obj) {
            super.g((j$.util.function.E) obj);
        }

        @Override // j$.util.stream.A2
        public void l() {
            this.f8093g = false;
        }

        @Override // j$.util.stream.A2
        public void m(long j2) {
            this.f8093g = true;
            clear();
            w(j2);
        }

        @Override // j$.util.stream.R1
        public /* synthetic */ int n() {
            return 0;
        }

        @Override // j$.util.stream.A2
        public /* synthetic */ boolean o() {
            return false;
        }

        @Override // j$.util.stream.R1
        public /* synthetic */ Object[] p(j$.util.function.z zVar) {
            return Q1.d(this, zVar);
        }

        @Override // j$.util.stream.S2.d, j$.util.stream.S2.e, java.lang.Iterable, j$.lang.Iterable
        public Spliterator.d spliterator() {
            return super.spliterator();
        }

        @Override // j$.util.stream.R1
        public /* synthetic */ R1 b(int i2) {
            b(i2);
            throw null;
        }

        @Override // j$.util.stream.S2.d, j$.util.stream.S2.e, java.lang.Iterable, j$.lang.Iterable
        public Spliterator spliterator() {
            return super.spliterator();
        }
    }

    private static abstract class s<P_IN, P_OUT, T_SINK extends A2<P_OUT>, K extends s<P_IN, P_OUT, T_SINK, K>> extends CountedCompleter<Void> implements A2<P_OUT> {
        protected final Spliterator a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        protected final T1 f8094b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        protected final long f8095c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        protected long f8096d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        protected long f8097e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        protected int f8098f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        protected int f8099g;

        static final class a<P_IN> extends s<P_IN, Double, A2.e, a<P_IN>> implements A2.e {

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            private final double[] f8100h;

            a(Spliterator spliterator, T1 t1, double[] dArr) {
                super(spliterator, t1, dArr.length);
                this.f8100h = dArr;
            }

            a(a aVar, Spliterator spliterator, long j2, long j3) {
                super(aVar, spliterator, j2, j3, aVar.f8100h.length);
                this.f8100h = aVar.f8100h;
            }

            @Override // j$.util.stream.S1.s, j$.util.stream.A2
            public void accept(double d2) {
                int i2 = this.f8098f;
                if (i2 >= this.f8099g) {
                    throw new IndexOutOfBoundsException(Integer.toString(this.f8098f));
                }
                double[] dArr = this.f8100h;
                this.f8098f = i2 + 1;
                dArr[i2] = d2;
            }

            @Override // j$.util.stream.S1.s
            s b(Spliterator spliterator, long j2, long j3) {
                return new a(this, spliterator, j2, j3);
            }

            @Override // j$.util.function.Consumer
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public /* synthetic */ void accept(Double d2) {
                Q1.a(this, d2);
            }

            @Override // j$.util.function.s
            public j$.util.function.s j(j$.util.function.s sVar) {
                Objects.requireNonNull(sVar);
                return new C0392f(this, sVar);
            }
        }

        static final class b<P_IN> extends s<P_IN, Integer, A2.f, b<P_IN>> implements A2.f {

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            private final int[] f8101h;

            b(Spliterator spliterator, T1 t1, int[] iArr) {
                super(spliterator, t1, iArr.length);
                this.f8101h = iArr;
            }

            b(b bVar, Spliterator spliterator, long j2, long j3) {
                super(bVar, spliterator, j2, j3, bVar.f8101h.length);
                this.f8101h = bVar.f8101h;
            }

            @Override // j$.util.stream.S1.s, j$.util.stream.A2, j$.util.function.y
            public void accept(int i2) {
                int i3 = this.f8098f;
                if (i3 >= this.f8099g) {
                    throw new IndexOutOfBoundsException(Integer.toString(this.f8098f));
                }
                int[] iArr = this.f8101h;
                this.f8098f = i3 + 1;
                iArr[i3] = i2;
            }

            @Override // j$.util.stream.S1.s
            s b(Spliterator spliterator, long j2, long j3) {
                return new b(this, spliterator, j2, j3);
            }

            @Override // j$.util.function.Consumer
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public /* synthetic */ void accept(Integer num) {
                Q1.b(this, num);
            }

            @Override // j$.util.function.y
            public j$.util.function.y k(j$.util.function.y yVar) {
                Objects.requireNonNull(yVar);
                return new C0395i(this, yVar);
            }
        }

        static final class c<P_IN> extends s<P_IN, Long, A2.g, c<P_IN>> implements A2.g {

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            private final long[] f8102h;

            c(Spliterator spliterator, T1 t1, long[] jArr) {
                super(spliterator, t1, jArr.length);
                this.f8102h = jArr;
            }

            c(c cVar, Spliterator spliterator, long j2, long j3) {
                super(cVar, spliterator, j2, j3, cVar.f8102h.length);
                this.f8102h = cVar.f8102h;
            }

            @Override // j$.util.stream.S1.s, j$.util.stream.A2
            public void accept(long j2) {
                int i2 = this.f8098f;
                if (i2 >= this.f8099g) {
                    throw new IndexOutOfBoundsException(Integer.toString(this.f8098f));
                }
                long[] jArr = this.f8102h;
                this.f8098f = i2 + 1;
                jArr[i2] = j2;
            }

            @Override // j$.util.stream.S1.s
            s b(Spliterator spliterator, long j2, long j3) {
                return new c(this, spliterator, j2, j3);
            }

            @Override // j$.util.function.Consumer
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public /* synthetic */ void accept(Long l2) {
                Q1.c(this, l2);
            }

            @Override // j$.util.function.E
            public j$.util.function.E f(j$.util.function.E e2) {
                Objects.requireNonNull(e2);
                return new C0396j(this, e2);
            }
        }

        static final class d<P_IN, P_OUT> extends s<P_IN, P_OUT, A2<P_OUT>, d<P_IN, P_OUT>> implements A2<P_OUT> {

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            private final Object[] f8103h;

            d(Spliterator spliterator, T1 t1, Object[] objArr) {
                super(spliterator, t1, objArr.length);
                this.f8103h = objArr;
            }

            d(d dVar, Spliterator spliterator, long j2, long j3) {
                super(dVar, spliterator, j2, j3, dVar.f8103h.length);
                this.f8103h = dVar.f8103h;
            }

            @Override // j$.util.function.Consumer
            public void accept(Object obj) {
                int i2 = this.f8098f;
                if (i2 >= this.f8099g) {
                    throw new IndexOutOfBoundsException(Integer.toString(this.f8098f));
                }
                Object[] objArr = this.f8103h;
                this.f8098f = i2 + 1;
                objArr[i2] = obj;
            }

            @Override // j$.util.stream.S1.s
            s b(Spliterator spliterator, long j2, long j3) {
                return new d(this, spliterator, j2, j3);
            }
        }

        s(Spliterator spliterator, T1 t1, int i2) {
            this.a = spliterator;
            this.f8094b = t1;
            this.f8095c = AbstractC0440k1.h(spliterator.estimateSize());
            this.f8096d = 0L;
            this.f8097e = i2;
        }

        s(s sVar, Spliterator spliterator, long j2, long j3, int i2) {
            super(sVar);
            this.a = spliterator;
            this.f8094b = sVar.f8094b;
            this.f8095c = sVar.f8095c;
            this.f8096d = j2;
            this.f8097e = j3;
            if (j2 < 0 || j3 < 0 || (j2 + j3) - 1 >= i2) {
                throw new IllegalArgumentException(String.format("offset and length interval [%d, %d + %d) is not within array size interval [0, %d)", Long.valueOf(j2), Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i2)));
            }
        }

        @Override // j$.util.stream.A2
        public /* synthetic */ void accept(double d2) {
            j$.time.a.c(this);
            throw null;
        }

        @Override // j$.util.stream.A2, j$.util.function.y
        public /* synthetic */ void accept(int i2) {
            j$.time.a.a(this);
            throw null;
        }

        @Override // j$.util.stream.A2
        public /* synthetic */ void accept(long j2) {
            j$.time.a.b(this);
            throw null;
        }

        @Override // j$.util.function.Consumer
        public /* synthetic */ Consumer andThen(Consumer consumer) {
            return Consumer.CC.$default$andThen(this, consumer);
        }

        abstract s b(Spliterator spliterator, long j2, long j3);

        @Override // java.util.concurrent.CountedCompleter
        public void compute() {
            Spliterator spliteratorTrySplit;
            Spliterator spliterator = this.a;
            s<P_IN, P_OUT, T_SINK, K> sVarB = this;
            while (spliterator.estimateSize() > sVarB.f8095c && (spliteratorTrySplit = spliterator.trySplit()) != null) {
                sVarB.setPendingCount(1);
                long jEstimateSize = spliteratorTrySplit.estimateSize();
                sVarB.b(spliteratorTrySplit, sVarB.f8096d, jEstimateSize).fork();
                sVarB = sVarB.b(spliterator, sVarB.f8096d + jEstimateSize, sVarB.f8097e - jEstimateSize);
            }
            AbstractC0428h1 abstractC0428h1 = (AbstractC0428h1) sVarB.f8094b;
            Objects.requireNonNull(abstractC0428h1);
            abstractC0428h1.m0(abstractC0428h1.u0(sVarB), spliterator);
            sVarB.propagateCompletion();
        }

        @Override // j$.util.stream.A2
        public void l() {
        }

        @Override // j$.util.stream.A2
        public void m(long j2) {
            long j3 = this.f8097e;
            if (j2 > j3) {
                throw new IllegalStateException("size passed to Sink.begin exceeds array length");
            }
            int i2 = (int) this.f8096d;
            this.f8098f = i2;
            this.f8099g = i2 + ((int) j3);
        }

        @Override // j$.util.stream.A2
        public /* synthetic */ boolean o() {
            return false;
        }
    }

    private static final class t<T> extends S2<T> implements R1<T>, R1.a<T> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private boolean f8104g = false;

        t() {
        }

        @Override // j$.util.stream.R1.a
        public R1 a() {
            return this;
        }

        @Override // j$.util.stream.A2
        public /* synthetic */ void accept(double d2) {
            j$.time.a.c(this);
            throw null;
        }

        @Override // j$.util.stream.A2, j$.util.function.y
        public /* synthetic */ void accept(int i2) {
            j$.time.a.a(this);
            throw null;
        }

        @Override // j$.util.stream.A2
        public /* synthetic */ void accept(long j2) {
            j$.time.a.b(this);
            throw null;
        }

        @Override // j$.util.stream.S2, j$.util.function.Consumer
        public void accept(Object obj) {
            super.accept(obj);
        }

        @Override // j$.util.stream.R1
        public R1 b(int i2) {
            throw new IndexOutOfBoundsException();
        }

        @Override // j$.util.stream.S2, j$.lang.Iterable
        public void forEach(Consumer consumer) {
            super.forEach(consumer);
        }

        @Override // j$.util.stream.S2, j$.util.stream.R1
        public void i(Object[] objArr, int i2) {
            super.i(objArr, i2);
        }

        @Override // j$.util.stream.A2
        public void l() {
            this.f8104g = false;
        }

        @Override // j$.util.stream.A2
        public void m(long j2) {
            this.f8104g = true;
            clear();
            t(j2);
        }

        @Override // j$.util.stream.R1
        public /* synthetic */ int n() {
            return 0;
        }

        @Override // j$.util.stream.A2
        public /* synthetic */ boolean o() {
            return false;
        }

        @Override // j$.util.stream.R1
        public Object[] p(j$.util.function.z zVar) {
            long jCount = count();
            if (jCount >= 2147483639) {
                throw new IllegalArgumentException("Stream size exceeds max array size");
            }
            Object[] objArr = (Object[]) zVar.apply((int) jCount);
            i(objArr, 0);
            return objArr;
        }

        @Override // j$.util.stream.R1
        public /* synthetic */ R1 q(long j2, long j3, j$.util.function.z zVar) {
            return Q1.n(this, j2, j3, zVar);
        }

        @Override // j$.util.stream.S2, java.lang.Iterable, j$.lang.Iterable
        public Spliterator spliterator() {
            return super.spliterator();
        }
    }

    private static abstract class u<T, T_NODE extends R1<T>, K extends u<T, T_NODE, K>> extends CountedCompleter<Void> {
        protected final R1 a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        protected final int f8105b;

        private static final class a extends d<Double, j$.util.function.s, double[], Spliterator.a, R1.b> {
            a(R1.b bVar, double[] dArr, int i2, a aVar) {
                super(bVar, dArr, i2, null);
            }
        }

        private static final class b extends d<Integer, j$.util.function.y, int[], Spliterator.b, R1.c> {
            b(R1.c cVar, int[] iArr, int i2, a aVar) {
                super(cVar, iArr, i2, null);
            }
        }

        private static final class c extends d<Long, j$.util.function.E, long[], Spliterator.c, R1.d> {
            c(R1.d dVar, long[] jArr, int i2, a aVar) {
                super(dVar, jArr, i2, null);
            }
        }

        private static class d<T, T_CONS, T_ARR, T_SPLITR extends Spliterator.d<T, T_CONS, T_SPLITR>, T_NODE extends R1.e<T, T_CONS, T_ARR, T_SPLITR, T_NODE>> extends u<T, T_NODE, d<T, T_CONS, T_ARR, T_SPLITR, T_NODE>> {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private final Object f8106c;

            d(R1.e eVar, Object obj, int i2, a aVar) {
                super(eVar, i2);
                this.f8106c = obj;
            }

            private d(d dVar, R1.e eVar, int i2) {
                super(dVar, eVar, i2);
                this.f8106c = dVar.f8106c;
            }

            @Override // j$.util.stream.S1.u
            void a() {
                ((R1.e) this.a).d(this.f8106c, this.f8105b);
            }

            @Override // j$.util.stream.S1.u
            u b(int i2, int i3) {
                return new d(this, ((R1.e) this.a).b(i2), i3);
            }
        }

        private static final class e<T> extends u<T, R1<T>, e<T>> {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private final Object[] f8107c;

            e(R1 r1, Object[] objArr, int i2, a aVar) {
                super(r1, i2);
                this.f8107c = objArr;
            }

            private e(e eVar, R1 r1, int i2) {
                super(eVar, r1, i2);
                this.f8107c = eVar.f8107c;
            }

            @Override // j$.util.stream.S1.u
            void a() {
                this.a.i(this.f8107c, this.f8105b);
            }

            @Override // j$.util.stream.S1.u
            u b(int i2, int i3) {
                return new e(this, this.a.b(i2), i3);
            }
        }

        u(R1 r1, int i2) {
            this.a = r1;
            this.f8105b = i2;
        }

        u(u uVar, R1 r1, int i2) {
            super(uVar);
            this.a = r1;
            this.f8105b = i2;
        }

        abstract void a();

        abstract u b(int i2, int i3);

        @Override // java.util.concurrent.CountedCompleter
        public void compute() {
            u<T, T_NODE, K> uVarB = this;
            while (uVarB.a.n() != 0) {
                uVarB.setPendingCount(uVarB.a.n() - 1);
                int i2 = 0;
                int iCount = 0;
                while (i2 < uVarB.a.n() - 1) {
                    u uVarB2 = uVarB.b(i2, uVarB.f8105b + iCount);
                    iCount = (int) (((long) iCount) + uVarB2.a.count());
                    uVarB2.fork();
                    i2++;
                }
                uVarB = uVarB.b(i2, uVarB.f8105b + iCount);
            }
            uVarB.a();
            uVarB.propagateCompletion();
        }
    }

    static R1.a d(long j2, j$.util.function.z zVar) {
        return (j2 < 0 || j2 >= 2147483639) ? new t() : new k(j2, zVar);
    }

    public static R1 e(T1 t1, Spliterator spliterator, boolean z, j$.util.function.z zVar) {
        long jP0 = t1.p0(spliterator);
        if (jP0 < 0 || !spliterator.hasCharacteristics(16384)) {
            R1 r1 = (R1) new e.d(t1, zVar, spliterator).invoke();
            return z ? l(r1, zVar) : r1;
        }
        if (jP0 >= 2147483639) {
            throw new IllegalArgumentException("Stream size exceeds max array size");
        }
        Object[] objArr = (Object[]) zVar.apply((int) jP0);
        new s.d(spliterator, t1, objArr).invoke();
        return new c(objArr);
    }

    public static R1.b f(T1 t1, Spliterator spliterator, boolean z) {
        long jP0 = t1.p0(spliterator);
        if (jP0 < 0 || !spliterator.hasCharacteristics(16384)) {
            R1.b bVar = (R1.b) new e.a(t1, spliterator).invoke();
            return z ? m(bVar) : bVar;
        }
        if (jP0 >= 2147483639) {
            throw new IllegalArgumentException("Stream size exceeds max array size");
        }
        double[] dArr = new double[(int) jP0];
        new s.a(spliterator, t1, dArr).invoke();
        return new g(dArr);
    }

    public static R1.c g(T1 t1, Spliterator spliterator, boolean z) {
        long jP0 = t1.p0(spliterator);
        if (jP0 < 0 || !spliterator.hasCharacteristics(16384)) {
            R1.c cVar = (R1.c) new e.b(t1, spliterator).invoke();
            return z ? n(cVar) : cVar;
        }
        if (jP0 >= 2147483639) {
            throw new IllegalArgumentException("Stream size exceeds max array size");
        }
        int[] iArr = new int[(int) jP0];
        new s.b(spliterator, t1, iArr).invoke();
        return new l(iArr);
    }

    public static R1.d h(T1 t1, Spliterator spliterator, boolean z) {
        long jP0 = t1.p0(spliterator);
        if (jP0 < 0 || !spliterator.hasCharacteristics(16384)) {
            R1.d dVar = (R1.d) new e.c(t1, spliterator).invoke();
            return z ? o(dVar) : dVar;
        }
        if (jP0 >= 2147483639) {
            throw new IllegalArgumentException("Stream size exceeds max array size");
        }
        long[] jArr = new long[(int) jP0];
        new s.c(spliterator, t1, jArr).invoke();
        return new p(jArr);
    }

    static R1 i(U2 u2, R1 r1, R1 r12) {
        int iOrdinal = u2.ordinal();
        if (iOrdinal == 0) {
            return new f(r1, r12);
        }
        if (iOrdinal == 1) {
            return new f.b((R1.c) r1, (R1.c) r12);
        }
        if (iOrdinal == 2) {
            return new f.c((R1.d) r1, (R1.d) r12);
        }
        if (iOrdinal == 3) {
            return new f.a((R1.b) r1, (R1.b) r12);
        }
        throw new IllegalStateException("Unknown shape " + u2);
    }

    static R1.a.InterfaceC0221a j(long j2) {
        return (j2 < 0 || j2 >= 2147483639) ? new i() : new h(j2);
    }

    static R1 k(U2 u2) {
        int iOrdinal = u2.ordinal();
        if (iOrdinal == 0) {
            return a;
        }
        if (iOrdinal == 1) {
            return f8072b;
        }
        if (iOrdinal == 2) {
            return f8073c;
        }
        if (iOrdinal == 3) {
            return f8074d;
        }
        throw new IllegalStateException("Unknown shape " + u2);
    }

    public static R1 l(R1 r1, j$.util.function.z zVar) {
        if (r1.n() <= 0) {
            return r1;
        }
        long jCount = r1.count();
        if (jCount >= 2147483639) {
            throw new IllegalArgumentException("Stream size exceeds max array size");
        }
        Object[] objArr = (Object[]) zVar.apply((int) jCount);
        new u.e(r1, objArr, 0, null).invoke();
        return new c(objArr);
    }

    public static R1.b m(R1.b bVar) {
        if (bVar.n() <= 0) {
            return bVar;
        }
        long jCount = bVar.count();
        if (jCount >= 2147483639) {
            throw new IllegalArgumentException("Stream size exceeds max array size");
        }
        double[] dArr = new double[(int) jCount];
        new u.a(bVar, dArr, 0, null).invoke();
        return new g(dArr);
    }

    public static R1.c n(R1.c cVar) {
        if (cVar.n() <= 0) {
            return cVar;
        }
        long jCount = cVar.count();
        if (jCount >= 2147483639) {
            throw new IllegalArgumentException("Stream size exceeds max array size");
        }
        int[] iArr = new int[(int) jCount];
        new u.b(cVar, iArr, 0, null).invoke();
        return new l(iArr);
    }

    public static R1.d o(R1.d dVar) {
        if (dVar.n() <= 0) {
            return dVar;
        }
        long jCount = dVar.count();
        if (jCount >= 2147483639) {
            throw new IllegalArgumentException("Stream size exceeds max array size");
        }
        long[] jArr = new long[(int) jCount];
        new u.c(dVar, jArr, 0, null).invoke();
        return new p(jArr);
    }

    static R1.a.b p(long j2) {
        return (j2 < 0 || j2 >= 2147483639) ? new n() : new m(j2);
    }

    static R1.a.c q(long j2) {
        return (j2 < 0 || j2 >= 2147483639) ? new r() : new q(j2);
    }
}

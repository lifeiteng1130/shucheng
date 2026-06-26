package j$.util.stream;

import androidx.recyclerview.widget.RecyclerView;
import j$.util.Spliterator;
import j$.util.stream.A2;
import j$.util.stream.AbstractC0460p1;
import j$.util.stream.AbstractC0496y2;
import j$.util.stream.AbstractC0499z1;
import j$.util.stream.D1;
import j$.util.stream.R1;
import j$.util.stream.c3;
import j$.util.stream.d3;

/* JADX INFO: loaded from: classes2.dex */
final class B2 {

    /* JADX INFO: Add missing generic type declarations: [T] */
    class a<T> extends AbstractC0496y2.l<T, T> {

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final /* synthetic */ long f8007l;
        final /* synthetic */ long m;

        /* JADX INFO: renamed from: j$.util.stream.B2$a$a, reason: collision with other inner class name */
        class C0219a extends A2.d<T, T> {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            long f8008b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            long f8009c;

            C0219a(A2 a2) {
                super(a2);
                this.f8008b = a.this.f8007l;
                long j2 = a.this.m;
                this.f8009c = j2 < 0 ? RecyclerView.FOREVER_NS : j2;
            }

            @Override // j$.util.function.Consumer
            public void accept(Object obj) {
                long j2 = this.f8008b;
                if (j2 != 0) {
                    this.f8008b = j2 - 1;
                    return;
                }
                long j3 = this.f8009c;
                if (j3 > 0) {
                    this.f8009c = j3 - 1;
                    this.a.accept(obj);
                }
            }

            @Override // j$.util.stream.A2.d, j$.util.stream.A2
            public void m(long j2) {
                this.a.m(B2.c(j2, a.this.f8007l, this.f8009c));
            }

            @Override // j$.util.stream.A2.d, j$.util.stream.A2
            public boolean o() {
                return this.f8009c == 0 || this.a.o();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(AbstractC0428h1 abstractC0428h1, U2 u2, int i2, long j2, long j3) {
            super(abstractC0428h1, u2, i2);
            this.f8007l = j2;
            this.m = j3;
        }

        @Override // j$.util.stream.AbstractC0428h1
        R1 D0(T1 t1, Spliterator spliterator, j$.util.function.z zVar) {
            long jP0 = t1.p0(spliterator);
            return (jP0 <= 0 || !spliterator.hasCharacteristics(16384)) ? !T2.ORDERED.n(t1.r0()) ? S1.e(this, K0(t1.v0(spliterator), this.f8007l, this.m, jP0), true, zVar) : new e(this, t1, spliterator, zVar, this.f8007l, this.m).invoke() : S1.e(t1, B2.b(t1.q0(), spliterator, this.f8007l, this.m), true, zVar);
        }

        @Override // j$.util.stream.AbstractC0428h1
        Spliterator E0(T1 t1, Spliterator spliterator) {
            long jP0 = t1.p0(spliterator);
            if (jP0 > 0 && spliterator.hasCharacteristics(16384)) {
                Spliterator spliteratorV0 = t1.v0(spliterator);
                long j2 = this.f8007l;
                return new c3.e(spliteratorV0, j2, B2.d(j2, this.m));
            }
            return !T2.ORDERED.n(t1.r0()) ? K0(t1.v0(spliterator), this.f8007l, this.m, jP0) : new e(this, t1, spliterator, new j$.util.function.z() { // from class: j$.util.stream.t0
                @Override // j$.util.function.z
                public final Object apply(int i2) {
                    return new Object[i2];
                }
            }, this.f8007l, this.m).invoke().spliterator();
        }

        @Override // j$.util.stream.AbstractC0428h1
        A2 G0(int i2, A2 a2) {
            return new C0219a(a2);
        }

        Spliterator K0(Spliterator spliterator, long j2, long j3, long j4) {
            long j5;
            long jMin;
            if (j2 <= j4) {
                long j6 = j4 - j2;
                jMin = j3 >= 0 ? Math.min(j3, j6) : j6;
                j5 = 0;
            } else {
                j5 = j2;
                jMin = j3;
            }
            return new d3.e(spliterator, j5, jMin);
        }
    }

    class b extends AbstractC0499z1.j<Integer> {

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final /* synthetic */ long f8011l;
        final /* synthetic */ long m;

        class a extends A2.b<Integer> {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            long f8012b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            long f8013c;

            a(A2 a2) {
                super(a2);
                this.f8012b = b.this.f8011l;
                long j2 = b.this.m;
                this.f8013c = j2 < 0 ? RecyclerView.FOREVER_NS : j2;
            }

            @Override // j$.util.stream.A2.f, j$.util.stream.A2, j$.util.function.y
            public void accept(int i2) {
                long j2 = this.f8012b;
                if (j2 != 0) {
                    this.f8012b = j2 - 1;
                    return;
                }
                long j3 = this.f8013c;
                if (j3 > 0) {
                    this.f8013c = j3 - 1;
                    this.a.accept(i2);
                }
            }

            @Override // j$.util.stream.A2.b, j$.util.stream.A2
            public void m(long j2) {
                this.a.m(B2.c(j2, b.this.f8011l, this.f8013c));
            }

            @Override // j$.util.stream.A2.b, j$.util.stream.A2
            public boolean o() {
                return this.f8013c == 0 || this.a.o();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(AbstractC0428h1 abstractC0428h1, U2 u2, int i2, long j2, long j3) {
            super(abstractC0428h1, u2, i2);
            this.f8011l = j2;
            this.m = j3;
        }

        @Override // j$.util.stream.AbstractC0428h1
        R1 D0(T1 t1, Spliterator spliterator, j$.util.function.z zVar) {
            long jP0 = t1.p0(spliterator);
            return (jP0 <= 0 || !spliterator.hasCharacteristics(16384)) ? !T2.ORDERED.n(t1.r0()) ? S1.g(this, M0((Spliterator.b) t1.v0(spliterator), this.f8011l, this.m, jP0), true) : new e(this, t1, spliterator, zVar, this.f8011l, this.m).invoke() : S1.g(t1, B2.b(t1.q0(), spliterator, this.f8011l, this.m), true);
        }

        @Override // j$.util.stream.AbstractC0428h1
        Spliterator E0(T1 t1, Spliterator spliterator) {
            long jP0 = t1.p0(spliterator);
            if (jP0 > 0 && spliterator.hasCharacteristics(16384)) {
                Spliterator.b bVar = (Spliterator.b) t1.v0(spliterator);
                long j2 = this.f8011l;
                return new c3.b(bVar, j2, B2.d(j2, this.m));
            }
            return !T2.ORDERED.n(t1.r0()) ? M0((Spliterator.b) t1.v0(spliterator), this.f8011l, this.m, jP0) : new e(this, t1, spliterator, new j$.util.function.z() { // from class: j$.util.stream.s0
                @Override // j$.util.function.z
                public final Object apply(int i2) {
                    return new Integer[i2];
                }
            }, this.f8011l, this.m).invoke().spliterator();
        }

        @Override // j$.util.stream.AbstractC0428h1
        A2 G0(int i2, A2 a2) {
            return new a(a2);
        }

        Spliterator.b M0(Spliterator.b bVar, long j2, long j3, long j4) {
            long j5;
            long jMin;
            if (j2 <= j4) {
                long j6 = j4 - j2;
                jMin = j3 >= 0 ? Math.min(j3, j6) : j6;
                j5 = 0;
            } else {
                j5 = j2;
                jMin = j3;
            }
            return new d3.b(bVar, j5, jMin);
        }
    }

    class c extends D1.h<Long> {

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final /* synthetic */ long f8015l;
        final /* synthetic */ long m;

        class a extends A2.c<Long> {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            long f8016b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            long f8017c;

            a(A2 a2) {
                super(a2);
                this.f8016b = c.this.f8015l;
                long j2 = c.this.m;
                this.f8017c = j2 < 0 ? RecyclerView.FOREVER_NS : j2;
            }

            @Override // j$.util.stream.A2.g, j$.util.stream.A2
            public void accept(long j2) {
                long j3 = this.f8016b;
                if (j3 != 0) {
                    this.f8016b = j3 - 1;
                    return;
                }
                long j4 = this.f8017c;
                if (j4 > 0) {
                    this.f8017c = j4 - 1;
                    this.a.accept(j2);
                }
            }

            @Override // j$.util.stream.A2.c, j$.util.stream.A2
            public void m(long j2) {
                this.a.m(B2.c(j2, c.this.f8015l, this.f8017c));
            }

            @Override // j$.util.stream.A2.c, j$.util.stream.A2
            public boolean o() {
                return this.f8017c == 0 || this.a.o();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(AbstractC0428h1 abstractC0428h1, U2 u2, int i2, long j2, long j3) {
            super(abstractC0428h1, u2, i2);
            this.f8015l = j2;
            this.m = j3;
        }

        @Override // j$.util.stream.AbstractC0428h1
        R1 D0(T1 t1, Spliterator spliterator, j$.util.function.z zVar) {
            long jP0 = t1.p0(spliterator);
            return (jP0 <= 0 || !spliterator.hasCharacteristics(16384)) ? !T2.ORDERED.n(t1.r0()) ? S1.h(this, M0((Spliterator.c) t1.v0(spliterator), this.f8015l, this.m, jP0), true) : new e(this, t1, spliterator, zVar, this.f8015l, this.m).invoke() : S1.h(t1, B2.b(t1.q0(), spliterator, this.f8015l, this.m), true);
        }

        @Override // j$.util.stream.AbstractC0428h1
        Spliterator E0(T1 t1, Spliterator spliterator) {
            long jP0 = t1.p0(spliterator);
            if (jP0 > 0 && spliterator.hasCharacteristics(16384)) {
                Spliterator.c cVar = (Spliterator.c) t1.v0(spliterator);
                long j2 = this.f8015l;
                return new c3.c(cVar, j2, B2.d(j2, this.m));
            }
            return !T2.ORDERED.n(t1.r0()) ? M0((Spliterator.c) t1.v0(spliterator), this.f8015l, this.m, jP0) : new e(this, t1, spliterator, new j$.util.function.z() { // from class: j$.util.stream.u0
                @Override // j$.util.function.z
                public final Object apply(int i2) {
                    return new Long[i2];
                }
            }, this.f8015l, this.m).invoke().spliterator();
        }

        @Override // j$.util.stream.AbstractC0428h1
        A2 G0(int i2, A2 a2) {
            return new a(a2);
        }

        Spliterator.c M0(Spliterator.c cVar, long j2, long j3, long j4) {
            long j5;
            long jMin;
            if (j2 <= j4) {
                long j6 = j4 - j2;
                jMin = j3 >= 0 ? Math.min(j3, j6) : j6;
                j5 = 0;
            } else {
                j5 = j2;
                jMin = j3;
            }
            return new d3.c(cVar, j5, jMin);
        }
    }

    class d extends AbstractC0460p1.h<Double> {

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final /* synthetic */ long f8019l;
        final /* synthetic */ long m;

        class a extends A2.a<Double> {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            long f8020b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            long f8021c;

            a(A2 a2) {
                super(a2);
                this.f8020b = d.this.f8019l;
                long j2 = d.this.m;
                this.f8021c = j2 < 0 ? RecyclerView.FOREVER_NS : j2;
            }

            @Override // j$.util.stream.A2.e, j$.util.stream.A2
            public void accept(double d2) {
                long j2 = this.f8020b;
                if (j2 != 0) {
                    this.f8020b = j2 - 1;
                    return;
                }
                long j3 = this.f8021c;
                if (j3 > 0) {
                    this.f8021c = j3 - 1;
                    this.a.accept(d2);
                }
            }

            @Override // j$.util.stream.A2.a, j$.util.stream.A2
            public void m(long j2) {
                this.a.m(B2.c(j2, d.this.f8019l, this.f8021c));
            }

            @Override // j$.util.stream.A2.a, j$.util.stream.A2
            public boolean o() {
                return this.f8021c == 0 || this.a.o();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(AbstractC0428h1 abstractC0428h1, U2 u2, int i2, long j2, long j3) {
            super(abstractC0428h1, u2, i2);
            this.f8019l = j2;
            this.m = j3;
        }

        @Override // j$.util.stream.AbstractC0428h1
        R1 D0(T1 t1, Spliterator spliterator, j$.util.function.z zVar) {
            long jP0 = t1.p0(spliterator);
            return (jP0 <= 0 || !spliterator.hasCharacteristics(16384)) ? !T2.ORDERED.n(t1.r0()) ? S1.f(this, M0((Spliterator.a) t1.v0(spliterator), this.f8019l, this.m, jP0), true) : new e(this, t1, spliterator, zVar, this.f8019l, this.m).invoke() : S1.f(t1, B2.b(t1.q0(), spliterator, this.f8019l, this.m), true);
        }

        @Override // j$.util.stream.AbstractC0428h1
        Spliterator E0(T1 t1, Spliterator spliterator) {
            long jP0 = t1.p0(spliterator);
            if (jP0 > 0 && spliterator.hasCharacteristics(16384)) {
                Spliterator.a aVar = (Spliterator.a) t1.v0(spliterator);
                long j2 = this.f8019l;
                return new c3.a(aVar, j2, B2.d(j2, this.m));
            }
            return !T2.ORDERED.n(t1.r0()) ? M0((Spliterator.a) t1.v0(spliterator), this.f8019l, this.m, jP0) : new e(this, t1, spliterator, new j$.util.function.z() { // from class: j$.util.stream.v0
                @Override // j$.util.function.z
                public final Object apply(int i2) {
                    return new Double[i2];
                }
            }, this.f8019l, this.m).invoke().spliterator();
        }

        @Override // j$.util.stream.AbstractC0428h1
        A2 G0(int i2, A2 a2) {
            return new a(a2);
        }

        Spliterator.a M0(Spliterator.a aVar, long j2, long j3, long j4) {
            long j5;
            long jMin;
            if (j2 <= j4) {
                long j6 = j4 - j2;
                jMin = j3 >= 0 ? Math.min(j3, j6) : j6;
                j5 = 0;
            } else {
                j5 = j2;
                jMin = j3;
            }
            return new d3.a(aVar, j5, jMin);
        }
    }

    private static final class e<P_IN, P_OUT> extends AbstractC0432i1<P_IN, P_OUT, R1<P_OUT>, e<P_IN, P_OUT>> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private final AbstractC0428h1 f8023j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private final j$.util.function.z f8024k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private final long f8025l;
        private final long m;
        private long n;
        private volatile boolean o;

        e(e eVar, Spliterator spliterator) {
            super(eVar, spliterator);
            this.f8023j = eVar.f8023j;
            this.f8024k = eVar.f8024k;
            this.f8025l = eVar.f8025l;
            this.m = eVar.m;
        }

        e(AbstractC0428h1 abstractC0428h1, T1 t1, Spliterator spliterator, j$.util.function.z zVar, long j2, long j3) {
            super(t1, spliterator);
            this.f8023j = abstractC0428h1;
            this.f8024k = zVar;
            this.f8025l = j2;
            this.m = j3;
        }

        private long m(long j2) {
            if (this.o) {
                return this.n;
            }
            e eVar = (e) this.f8227e;
            e eVar2 = (e) this.f8228f;
            if (eVar == null || eVar2 == null) {
                return this.n;
            }
            long jM = eVar.m(j2);
            return jM >= j2 ? jM : jM + eVar2.m(j2);
        }

        @Override // j$.util.stream.AbstractC0440k1
        protected Object a() {
            if (e()) {
                R1.a aVarS0 = this.f8023j.s0(T2.SIZED.t(this.f8023j.f8201c) ? this.f8023j.p0(this.f8225c) : -1L, this.f8024k);
                A2 a2G0 = this.f8023j.G0(this.f8224b.r0(), aVarS0);
                T1 t1 = this.f8224b;
                t1.n0(t1.u0(a2G0), this.f8225c);
                return aVarS0.a();
            }
            T1 t12 = this.f8224b;
            R1.a aVarS02 = t12.s0(-1L, this.f8024k);
            t12.t0(aVarS02, this.f8225c);
            R1 r1A = aVarS02.a();
            this.n = r1A.count();
            this.o = true;
            this.f8225c = null;
            return r1A;
        }

        @Override // j$.util.stream.AbstractC0440k1
        protected AbstractC0440k1 f(Spliterator spliterator) {
            return new e(this, spliterator);
        }

        @Override // j$.util.stream.AbstractC0432i1
        protected void i() {
            this.f8214i = true;
            if (this.o) {
                g(k());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // j$.util.stream.AbstractC0432i1
        /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
        public final R1 k() {
            return S1.k(this.f8023j.A0());
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0065  */
        @Override // j$.util.stream.AbstractC0440k1, java.util.concurrent.CountedCompleter
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void onCompletion(java.util.concurrent.CountedCompleter r12) {
            /*
                Method dump skipped, instruction units count: 228
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: j$.util.stream.B2.e.onCompletion(java.util.concurrent.CountedCompleter):void");
        }
    }

    static Spliterator b(U2 u2, Spliterator spliterator, long j2, long j3) {
        long jD = d(j2, j3);
        int iOrdinal = u2.ordinal();
        if (iOrdinal == 0) {
            return new c3.e(spliterator, j2, jD);
        }
        if (iOrdinal == 1) {
            return new c3.b((Spliterator.b) spliterator, j2, jD);
        }
        if (iOrdinal == 2) {
            return new c3.c((Spliterator.c) spliterator, j2, jD);
        }
        if (iOrdinal == 3) {
            return new c3.a((Spliterator.a) spliterator, j2, jD);
        }
        throw new IllegalStateException("Unknown shape " + u2);
    }

    static long c(long j2, long j3, long j4) {
        if (j2 >= 0) {
            return Math.max(-1L, Math.min(j2 - j3, j4));
        }
        return -1L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long d(long j2, long j3) {
        long j4 = j3 >= 0 ? j2 + j3 : Long.MAX_VALUE;
        return j4 >= 0 ? j4 : RecyclerView.FOREVER_NS;
    }

    private static int e(long j2) {
        return (j2 != -1 ? T2.p : 0) | T2.o;
    }

    public static InterfaceC0471s1 f(AbstractC0428h1 abstractC0428h1, long j2, long j3) {
        if (j2 >= 0) {
            return new d(abstractC0428h1, U2.DOUBLE_VALUE, e(j3), j2, j3);
        }
        throw new IllegalArgumentException("Skip must be non-negative: " + j2);
    }

    public static C1 g(AbstractC0428h1 abstractC0428h1, long j2, long j3) {
        if (j2 >= 0) {
            return new b(abstractC0428h1, U2.INT_VALUE, e(j3), j2, j3);
        }
        throw new IllegalArgumentException("Skip must be non-negative: " + j2);
    }

    public static H1 h(AbstractC0428h1 abstractC0428h1, long j2, long j3) {
        if (j2 >= 0) {
            return new c(abstractC0428h1, U2.LONG_VALUE, e(j3), j2, j3);
        }
        throw new IllegalArgumentException("Skip must be non-negative: " + j2);
    }

    public static Stream i(AbstractC0428h1 abstractC0428h1, long j2, long j3) {
        if (j2 >= 0) {
            return new a(abstractC0428h1, U2.REFERENCE, e(j3), j2, j3);
        }
        throw new IllegalArgumentException("Skip must be non-negative: " + j2);
    }
}

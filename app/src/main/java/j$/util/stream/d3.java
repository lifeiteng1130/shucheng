package j$.util.stream;

import j$.util.Spliterator;
import j$.util.function.C0392f;
import j$.util.function.C0395i;
import j$.util.function.C0396j;
import j$.util.function.Consumer;
import j$.util.stream.X2;
import java.util.Comparator;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes2.dex */
abstract class d3<T, T_SPLITR extends Spliterator<T>> {
    protected final Spliterator a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final boolean f8185b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f8186c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final AtomicLong f8187d;

    static final class a extends d<Double, j$.util.function.s, X2.a, Spliterator.a> implements Spliterator.a, j$.util.function.s {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        double f8188e;

        a(Spliterator.a aVar, long j2, long j3) {
            super(aVar, j2, j3);
        }

        a(Spliterator.a aVar, a aVar2) {
            super(aVar, aVar2);
        }

        @Override // j$.util.function.s
        public void accept(double d2) {
            this.f8188e = d2;
        }

        @Override // j$.util.Spliterator
        public /* synthetic */ boolean b(Consumer consumer) {
            return j$.util.s.e(this, consumer);
        }

        @Override // j$.util.Spliterator
        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            j$.util.s.a(this, consumer);
        }

        @Override // j$.util.function.s
        public j$.util.function.s j(j$.util.function.s sVar) {
            Objects.requireNonNull(sVar);
            return new C0392f(this, sVar);
        }

        @Override // j$.util.stream.d3
        protected Spliterator q(Spliterator spliterator) {
            return new a((Spliterator.a) spliterator, this);
        }

        @Override // j$.util.stream.d3.d
        protected void s(Object obj) {
            ((j$.util.function.s) obj).accept(this.f8188e);
        }

        @Override // j$.util.stream.d3.d
        protected X2.d t(int i2) {
            return new X2.a(i2);
        }
    }

    static final class b extends d<Integer, j$.util.function.y, X2.b, Spliterator.b> implements Spliterator.b, j$.util.function.y {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f8189e;

        b(Spliterator.b bVar, long j2, long j3) {
            super(bVar, j2, j3);
        }

        b(Spliterator.b bVar, b bVar2) {
            super(bVar, bVar2);
        }

        @Override // j$.util.function.y
        public void accept(int i2) {
            this.f8189e = i2;
        }

        @Override // j$.util.Spliterator
        public /* synthetic */ boolean b(Consumer consumer) {
            return j$.util.s.f(this, consumer);
        }

        @Override // j$.util.Spliterator
        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            j$.util.s.b(this, consumer);
        }

        @Override // j$.util.function.y
        public j$.util.function.y k(j$.util.function.y yVar) {
            Objects.requireNonNull(yVar);
            return new C0395i(this, yVar);
        }

        @Override // j$.util.stream.d3
        protected Spliterator q(Spliterator spliterator) {
            return new b((Spliterator.b) spliterator, this);
        }

        @Override // j$.util.stream.d3.d
        protected void s(Object obj) {
            ((j$.util.function.y) obj).accept(this.f8189e);
        }

        @Override // j$.util.stream.d3.d
        protected X2.d t(int i2) {
            return new X2.b(i2);
        }
    }

    static final class c extends d<Long, j$.util.function.E, X2.c, Spliterator.c> implements Spliterator.c, j$.util.function.E {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        long f8190e;

        c(Spliterator.c cVar, long j2, long j3) {
            super(cVar, j2, j3);
        }

        c(Spliterator.c cVar, c cVar2) {
            super(cVar, cVar2);
        }

        @Override // j$.util.function.E
        public void accept(long j2) {
            this.f8190e = j2;
        }

        @Override // j$.util.Spliterator
        public /* synthetic */ boolean b(Consumer consumer) {
            return j$.util.s.g(this, consumer);
        }

        @Override // j$.util.function.E
        public j$.util.function.E f(j$.util.function.E e2) {
            Objects.requireNonNull(e2);
            return new C0396j(this, e2);
        }

        @Override // j$.util.Spliterator
        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            j$.util.s.c(this, consumer);
        }

        @Override // j$.util.stream.d3
        protected Spliterator q(Spliterator spliterator) {
            return new c((Spliterator.c) spliterator, this);
        }

        @Override // j$.util.stream.d3.d
        protected void s(Object obj) {
            ((j$.util.function.E) obj).accept(this.f8190e);
        }

        @Override // j$.util.stream.d3.d
        protected X2.d t(int i2) {
            return new X2.c(i2);
        }
    }

    static abstract class d<T, T_CONS, T_BUFF extends X2.d<T_CONS>, T_SPLITR extends Spliterator.d<T, T_CONS, T_SPLITR>> extends d3<T, T_SPLITR> implements Spliterator.d<T, T_CONS, T_SPLITR> {
        d(Spliterator.d dVar, long j2, long j3) {
            super(dVar, j2, j3);
        }

        d(Spliterator.d dVar, d dVar2) {
            super(dVar, dVar2);
        }

        @Override // j$.util.Spliterator.d
        /* JADX INFO: renamed from: forEachRemaining, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public void e(Object obj) {
            Objects.requireNonNull(obj);
            X2.d dVarT = null;
            while (true) {
                f fVarR = r();
                if (fVarR == f.NO_MORE) {
                    return;
                }
                if (fVarR != f.MAYBE_MORE) {
                    ((Spliterator.d) this.a).e(obj);
                    return;
                }
                if (dVarT == null) {
                    dVarT = t(128);
                } else {
                    dVarT.f8157b = 0;
                }
                long j2 = 0;
                while (((Spliterator.d) this.a).n(dVarT)) {
                    j2++;
                    if (j2 >= 128) {
                        break;
                    }
                }
                if (j2 == 0) {
                    return;
                } else {
                    dVarT.b(obj, p(j2));
                }
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

        @Override // j$.util.Spliterator
        public /* synthetic */ boolean hasCharacteristics(int i2) {
            return j$.time.a.h(this, i2);
        }

        protected abstract void s(Object obj);

        protected abstract X2.d t(int i2);

        @Override // j$.util.Spliterator.d
        /* JADX INFO: renamed from: tryAdvance, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public boolean n(Object obj) {
            Objects.requireNonNull(obj);
            while (r() != f.NO_MORE && ((Spliterator.d) this.a).n(this)) {
                if (p(1L) == 1) {
                    s(obj);
                    return true;
                }
            }
            return false;
        }
    }

    static final class e<T> extends d3<T, Spliterator<T>> implements Spliterator<T>, Consumer<T> {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f8191e;

        e(Spliterator spliterator, long j2, long j3) {
            super(spliterator, j2, j3);
        }

        e(Spliterator spliterator, e eVar) {
            super(spliterator, eVar);
        }

        @Override // j$.util.function.Consumer
        public final void accept(Object obj) {
            this.f8191e = obj;
        }

        @Override // j$.util.function.Consumer
        public /* synthetic */ Consumer andThen(Consumer consumer) {
            return Consumer.CC.$default$andThen(this, consumer);
        }

        @Override // j$.util.Spliterator
        public boolean b(Consumer consumer) {
            Objects.requireNonNull(consumer);
            while (r() != f.NO_MORE && this.a.b(this)) {
                if (p(1L) == 1) {
                    consumer.accept(this.f8191e);
                    this.f8191e = null;
                    return true;
                }
            }
            return false;
        }

        @Override // j$.util.Spliterator
        public void forEachRemaining(Consumer consumer) {
            Objects.requireNonNull(consumer);
            X2.e eVar = null;
            while (true) {
                f fVarR = r();
                if (fVarR == f.NO_MORE) {
                    return;
                }
                if (fVarR != f.MAYBE_MORE) {
                    this.a.forEachRemaining(consumer);
                    return;
                }
                if (eVar == null) {
                    eVar = new X2.e(128);
                } else {
                    eVar.a = 0;
                }
                long j2 = 0;
                while (this.a.b(eVar)) {
                    j2++;
                    if (j2 >= 128) {
                        break;
                    }
                }
                if (j2 == 0) {
                    return;
                }
                long jP = p(j2);
                for (int i2 = 0; i2 < jP; i2++) {
                    consumer.accept(eVar.f8158b[i2]);
                }
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

        @Override // j$.util.Spliterator
        public /* synthetic */ boolean hasCharacteristics(int i2) {
            return j$.time.a.h(this, i2);
        }

        @Override // j$.util.stream.d3
        protected Spliterator q(Spliterator spliterator) {
            return new e(spliterator, this);
        }
    }

    enum f {
        NO_MORE,
        MAYBE_MORE,
        UNLIMITED
    }

    d3(Spliterator spliterator, long j2, long j3) {
        this.a = spliterator;
        this.f8185b = j3 < 0;
        this.f8186c = j3 >= 0 ? j3 : 0L;
        this.f8187d = new AtomicLong(j3 >= 0 ? j2 + j3 : j2);
    }

    d3(Spliterator spliterator, d3 d3Var) {
        this.a = spliterator;
        this.f8185b = d3Var.f8185b;
        this.f8187d = d3Var.f8187d;
        this.f8186c = d3Var.f8186c;
    }

    public final int characteristics() {
        return this.a.characteristics() & (-16465);
    }

    public final long estimateSize() {
        return this.a.estimateSize();
    }

    protected final long p(long j2) {
        long j3;
        long jMin;
        do {
            j3 = this.f8187d.get();
            if (j3 != 0) {
                jMin = Math.min(j3, j2);
                if (jMin <= 0) {
                    break;
                }
            } else {
                if (this.f8185b) {
                    return j2;
                }
                return 0L;
            }
        } while (!this.f8187d.compareAndSet(j3, j3 - jMin));
        if (this.f8185b) {
            return Math.max(j2 - jMin, 0L);
        }
        long j4 = this.f8186c;
        return j3 > j4 ? Math.max(jMin - (j3 - j4), 0L) : jMin;
    }

    protected abstract Spliterator q(Spliterator spliterator);

    protected final f r() {
        return this.f8187d.get() > 0 ? f.MAYBE_MORE : this.f8185b ? f.UNLIMITED : f.NO_MORE;
    }

    public /* bridge */ /* synthetic */ Spliterator.a trySplit() {
        return (Spliterator.a) m31trySplit();
    }

    /* JADX INFO: renamed from: trySplit, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Spliterator.b m28trySplit() {
        return (Spliterator.b) m31trySplit();
    }

    /* JADX INFO: renamed from: trySplit, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Spliterator.c m29trySplit() {
        return (Spliterator.c) m31trySplit();
    }

    /* JADX INFO: renamed from: trySplit, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Spliterator.d m30trySplit() {
        return (Spliterator.d) m31trySplit();
    }

    /* JADX INFO: renamed from: trySplit, reason: collision with other method in class */
    public final Spliterator m31trySplit() {
        Spliterator spliteratorTrySplit;
        if (this.f8187d.get() == 0 || (spliteratorTrySplit = this.a.trySplit()) == null) {
            return null;
        }
        return q(spliteratorTrySplit);
    }
}

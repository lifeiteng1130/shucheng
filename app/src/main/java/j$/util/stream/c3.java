package j$.util.stream;

import j$.util.Spliterator;
import j$.util.function.C0392f;
import j$.util.function.C0395i;
import j$.util.function.C0396j;
import j$.util.function.Consumer;
import java.util.Comparator;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
abstract class c3<T, T_SPLITR extends Spliterator<T>> {
    final long a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final long f8177b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Spliterator f8178c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    long f8179d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    long f8180e;

    static final class a extends d<Double, Spliterator.a, j$.util.function.s> implements Spliterator.a {
        a(Spliterator.a aVar, long j2, long j3) {
            super(aVar, j2, j3);
        }

        a(Spliterator.a aVar, long j2, long j3, long j4, long j5) {
            super(aVar, j2, j3, j4, j5, null);
        }

        @Override // j$.util.stream.c3
        protected Spliterator a(Spliterator spliterator, long j2, long j3, long j4, long j5) {
            return new a((Spliterator.a) spliterator, j2, j3, j4, j5);
        }

        @Override // j$.util.Spliterator
        public /* synthetic */ boolean b(Consumer consumer) {
            return j$.util.s.e(this, consumer);
        }

        @Override // j$.util.stream.c3.d
        protected /* bridge */ /* synthetic */ Object f() {
            return new j$.util.function.s() { // from class: j$.util.stream.B0
                @Override // j$.util.function.s
                public final void accept(double d2) {
                }

                @Override // j$.util.function.s
                public j$.util.function.s j(j$.util.function.s sVar) {
                    Objects.requireNonNull(sVar);
                    return new C0392f(this, sVar);
                }
            };
        }

        @Override // j$.util.Spliterator
        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            j$.util.s.a(this, consumer);
        }
    }

    static final class b extends d<Integer, Spliterator.b, j$.util.function.y> implements Spliterator.b {
        b(Spliterator.b bVar, long j2, long j3) {
            super(bVar, j2, j3);
        }

        b(Spliterator.b bVar, long j2, long j3, long j4, long j5) {
            super(bVar, j2, j3, j4, j5, null);
        }

        @Override // j$.util.stream.c3
        protected Spliterator a(Spliterator spliterator, long j2, long j3, long j4, long j5) {
            return new b((Spliterator.b) spliterator, j2, j3, j4, j5);
        }

        @Override // j$.util.Spliterator
        public /* synthetic */ boolean b(Consumer consumer) {
            return j$.util.s.f(this, consumer);
        }

        @Override // j$.util.stream.c3.d
        protected /* bridge */ /* synthetic */ Object f() {
            return new j$.util.function.y() { // from class: j$.util.stream.C0
                @Override // j$.util.function.y
                public final void accept(int i2) {
                }

                @Override // j$.util.function.y
                public j$.util.function.y k(j$.util.function.y yVar) {
                    Objects.requireNonNull(yVar);
                    return new C0395i(this, yVar);
                }
            };
        }

        @Override // j$.util.Spliterator
        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            j$.util.s.b(this, consumer);
        }
    }

    static final class c extends d<Long, Spliterator.c, j$.util.function.E> implements Spliterator.c {
        c(Spliterator.c cVar, long j2, long j3) {
            super(cVar, j2, j3);
        }

        c(Spliterator.c cVar, long j2, long j3, long j4, long j5) {
            super(cVar, j2, j3, j4, j5, null);
        }

        @Override // j$.util.stream.c3
        protected Spliterator a(Spliterator spliterator, long j2, long j3, long j4, long j5) {
            return new c((Spliterator.c) spliterator, j2, j3, j4, j5);
        }

        @Override // j$.util.Spliterator
        public /* synthetic */ boolean b(Consumer consumer) {
            return j$.util.s.g(this, consumer);
        }

        @Override // j$.util.stream.c3.d
        protected /* bridge */ /* synthetic */ Object f() {
            return new j$.util.function.E() { // from class: j$.util.stream.D0
                @Override // j$.util.function.E
                public final void accept(long j2) {
                }

                @Override // j$.util.function.E
                public j$.util.function.E f(j$.util.function.E e2) {
                    Objects.requireNonNull(e2);
                    return new C0396j(this, e2);
                }
            };
        }

        @Override // j$.util.Spliterator
        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            j$.util.s.c(this, consumer);
        }
    }

    static abstract class d<T, T_SPLITR extends Spliterator.d<T, T_CONS, T_SPLITR>, T_CONS> extends c3<T, T_SPLITR> implements Spliterator.d<T, T_CONS, T_SPLITR> {
        d(Spliterator.d dVar, long j2, long j3) {
            super(dVar, j2, j3, 0L, Math.min(dVar.estimateSize(), j3));
        }

        protected abstract Object f();

        @Override // j$.util.Spliterator.d
        /* JADX INFO: renamed from: forEachRemaining, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public void e(Object obj) {
            Objects.requireNonNull(obj);
            long j2 = this.a;
            long j3 = this.f8180e;
            if (j2 >= j3) {
                return;
            }
            long j4 = this.f8179d;
            if (j4 >= j3) {
                return;
            }
            if (j4 >= j2 && ((Spliterator.d) this.f8178c).estimateSize() + j4 <= this.f8177b) {
                ((Spliterator.d) this.f8178c).e(obj);
                this.f8179d = this.f8180e;
                return;
            }
            while (this.a > this.f8179d) {
                ((Spliterator.d) this.f8178c).n(f());
                this.f8179d++;
            }
            while (this.f8179d < this.f8180e) {
                ((Spliterator.d) this.f8178c).n(obj);
                this.f8179d++;
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

        @Override // j$.util.Spliterator.d
        /* JADX INFO: renamed from: tryAdvance, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public boolean n(Object obj) {
            long j2;
            Objects.requireNonNull(obj);
            if (this.a >= this.f8180e) {
                return false;
            }
            while (true) {
                long j3 = this.a;
                j2 = this.f8179d;
                if (j3 <= j2) {
                    break;
                }
                ((Spliterator.d) this.f8178c).n(f());
                this.f8179d++;
            }
            if (j2 >= this.f8180e) {
                return false;
            }
            this.f8179d = j2 + 1;
            return ((Spliterator.d) this.f8178c).n(obj);
        }

        d(Spliterator.d dVar, long j2, long j3, long j4, long j5, V2 v2) {
            super(dVar, j2, j3, j4, j5);
        }
    }

    static final class e<T> extends c3<T, Spliterator<T>> implements Spliterator<T> {
        e(Spliterator spliterator, long j2, long j3) {
            super(spliterator, j2, j3, 0L, Math.min(spliterator.estimateSize(), j3));
        }

        private e(Spliterator spliterator, long j2, long j3, long j4, long j5) {
            super(spliterator, j2, j3, j4, j5);
        }

        @Override // j$.util.stream.c3
        protected Spliterator a(Spliterator spliterator, long j2, long j3, long j4, long j5) {
            return new e(spliterator, j2, j3, j4, j5);
        }

        @Override // j$.util.Spliterator
        public boolean b(Consumer consumer) {
            long j2;
            Objects.requireNonNull(consumer);
            if (this.a >= this.f8180e) {
                return false;
            }
            while (true) {
                long j3 = this.a;
                j2 = this.f8179d;
                if (j3 <= j2) {
                    break;
                }
                this.f8178c.b(new Consumer() { // from class: j$.util.stream.E0
                    @Override // j$.util.function.Consumer
                    public final void accept(Object obj) {
                    }

                    @Override // j$.util.function.Consumer
                    public /* synthetic */ Consumer andThen(Consumer consumer2) {
                        return Consumer.CC.$default$andThen(this, consumer2);
                    }
                });
                this.f8179d++;
            }
            if (j2 >= this.f8180e) {
                return false;
            }
            this.f8179d = j2 + 1;
            return this.f8178c.b(consumer);
        }

        @Override // j$.util.Spliterator
        public void forEachRemaining(Consumer consumer) {
            Objects.requireNonNull(consumer);
            long j2 = this.a;
            long j3 = this.f8180e;
            if (j2 >= j3) {
                return;
            }
            long j4 = this.f8179d;
            if (j4 >= j3) {
                return;
            }
            if (j4 >= j2 && this.f8178c.estimateSize() + j4 <= this.f8177b) {
                this.f8178c.forEachRemaining(consumer);
                this.f8179d = this.f8180e;
                return;
            }
            while (this.a > this.f8179d) {
                this.f8178c.b(new Consumer() { // from class: j$.util.stream.F0
                    @Override // j$.util.function.Consumer
                    public final void accept(Object obj) {
                    }

                    @Override // j$.util.function.Consumer
                    public /* synthetic */ Consumer andThen(Consumer consumer2) {
                        return Consumer.CC.$default$andThen(this, consumer2);
                    }
                });
                this.f8179d++;
            }
            while (this.f8179d < this.f8180e) {
                this.f8178c.b(consumer);
                this.f8179d++;
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
    }

    c3(Spliterator spliterator, long j2, long j3, long j4, long j5) {
        this.f8178c = spliterator;
        this.a = j2;
        this.f8177b = j3;
        this.f8179d = j4;
        this.f8180e = j5;
    }

    protected abstract Spliterator a(Spliterator spliterator, long j2, long j3, long j4, long j5);

    public int characteristics() {
        return this.f8178c.characteristics();
    }

    public long estimateSize() {
        long j2 = this.a;
        long j3 = this.f8180e;
        if (j2 < j3) {
            return j3 - Math.max(j2, this.f8179d);
        }
        return 0L;
    }

    public /* bridge */ /* synthetic */ Spliterator.a trySplit() {
        return (Spliterator.a) m27trySplit();
    }

    /* JADX INFO: renamed from: trySplit, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Spliterator.b m24trySplit() {
        return (Spliterator.b) m27trySplit();
    }

    /* JADX INFO: renamed from: trySplit, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Spliterator.c m25trySplit() {
        return (Spliterator.c) m27trySplit();
    }

    /* JADX INFO: renamed from: trySplit, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Spliterator.d m26trySplit() {
        return (Spliterator.d) m27trySplit();
    }

    /* JADX INFO: renamed from: trySplit, reason: collision with other method in class */
    public Spliterator m27trySplit() {
        long j2 = this.a;
        long j3 = this.f8180e;
        if (j2 >= j3 || this.f8179d >= j3) {
            return null;
        }
        while (true) {
            Spliterator spliteratorTrySplit = this.f8178c.trySplit();
            if (spliteratorTrySplit == null) {
                return null;
            }
            long jEstimateSize = spliteratorTrySplit.estimateSize() + this.f8179d;
            long jMin = Math.min(jEstimateSize, this.f8177b);
            long j4 = this.a;
            if (j4 >= jMin) {
                this.f8179d = jMin;
            } else {
                long j5 = this.f8177b;
                if (jMin < j5) {
                    long j6 = this.f8179d;
                    if (j6 < j4 || jEstimateSize > j5) {
                        this.f8179d = jMin;
                        return a(spliteratorTrySplit, j4, j5, j6, jMin);
                    }
                    this.f8179d = jMin;
                    return spliteratorTrySplit;
                }
                this.f8178c = spliteratorTrySplit;
                this.f8180e = jMin;
            }
        }
    }
}

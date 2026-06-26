package j$.util;

import androidx.recyclerview.widget.RecyclerView;
import j$.C$r8$wrapper$java$util$function$Consumer$VWRP;
import j$.util.Iterator;
import j$.util.Spliterator;
import j$.util.function.C0392f;
import j$.util.function.C0395i;
import j$.util.function.C0396j;
import j$.util.function.Consumer;
import j$.util.function.E;
import j$.util.function.y;
import j$.util.t;
import java.util.NoSuchElementException;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class v {
    private static final Spliterator a = new g.d();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Spliterator.b f8327b = new g.b();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Spliterator.c f8328c = new g.c();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Spliterator.a f8329d = new g.a();

    /* JADX INFO: Add missing generic type declarations: [T] */
    class a<T> implements java.util.Iterator<T>, Consumer<T>, Iterator {
        boolean a = false;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f8330b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Spliterator f8331c;

        a(Spliterator spliterator) {
            this.f8331c = spliterator;
        }

        @Override // j$.util.function.Consumer
        public void accept(Object obj) {
            this.a = true;
            this.f8330b = obj;
        }

        @Override // j$.util.function.Consumer
        public /* synthetic */ Consumer andThen(Consumer consumer) {
            return Consumer.CC.$default$andThen(this, consumer);
        }

        @Override // j$.util.Iterator
        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            Iterator.CC.$default$forEachRemaining(this, consumer);
        }

        @Override // java.util.Iterator
        public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
            Iterator.CC.$default$forEachRemaining(this, C$r8$wrapper$java$util$function$Consumer$VWRP.convert(consumer));
        }

        @Override // java.util.Iterator, j$.util.Iterator
        public boolean hasNext() {
            if (!this.a) {
                this.f8331c.b(this);
            }
            return this.a;
        }

        @Override // java.util.Iterator, j$.util.Iterator
        public Object next() {
            if (!this.a && !hasNext()) {
                throw new NoSuchElementException();
            }
            this.a = false;
            return this.f8330b;
        }

        @Override // java.util.Iterator, j$.util.Iterator
        public /* synthetic */ void remove() {
            Iterator.CC.a(this);
            throw null;
        }
    }

    class b implements t.b, y {
        boolean a = false;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f8332b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Spliterator.b f8333c;

        b(Spliterator.b bVar) {
            this.f8333c = bVar;
        }

        @Override // j$.util.function.y
        public void accept(int i2) {
            this.a = true;
            this.f8332b = i2;
        }

        @Override // j$.util.t
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void forEachRemaining(y yVar) {
            Objects.requireNonNull(yVar);
            while (hasNext()) {
                yVar.accept(nextInt());
            }
        }

        @Override // j$.util.t.b, j$.util.Iterator
        public void forEachRemaining(Consumer consumer) {
            if (consumer instanceof y) {
                forEachRemaining((y) consumer);
                return;
            }
            Objects.requireNonNull(consumer);
            if (w.a) {
                w.a(b.class, "{0} calling PrimitiveIterator.OfInt.forEachRemainingInt(action::accept)");
                throw null;
            }
            while (hasNext()) {
                consumer.accept(Integer.valueOf(nextInt()));
            }
        }

        @Override // java.util.Iterator, j$.util.Iterator
        public boolean hasNext() {
            if (!this.a) {
                this.f8333c.tryAdvance(this);
            }
            return this.a;
        }

        @Override // j$.util.function.y
        public y k(y yVar) {
            Objects.requireNonNull(yVar);
            return new C0395i(this, yVar);
        }

        @Override // java.util.Iterator, j$.util.Iterator
        public Integer next() {
            if (!w.a) {
                return Integer.valueOf(nextInt());
            }
            w.a(b.class, "{0} calling PrimitiveIterator.OfInt.nextInt()");
            throw null;
        }

        @Override // j$.util.t.b
        public int nextInt() {
            if (!this.a && !hasNext()) {
                throw new NoSuchElementException();
            }
            this.a = false;
            return this.f8332b;
        }

        @Override // java.util.Iterator, j$.util.Iterator
        public /* synthetic */ void remove() {
            Iterator.CC.a(this);
            throw null;
        }
    }

    class c implements t.c, E {
        boolean a = false;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        long f8334b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Spliterator.c f8335c;

        c(Spliterator.c cVar) {
            this.f8335c = cVar;
        }

        @Override // j$.util.function.E
        public void accept(long j2) {
            this.a = true;
            this.f8334b = j2;
        }

        @Override // j$.util.t
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void forEachRemaining(E e2) {
            Objects.requireNonNull(e2);
            while (hasNext()) {
                e2.accept(nextLong());
            }
        }

        @Override // j$.util.function.E
        public E f(E e2) {
            Objects.requireNonNull(e2);
            return new C0396j(this, e2);
        }

        @Override // j$.util.t.c, j$.util.Iterator
        public void forEachRemaining(Consumer consumer) {
            if (consumer instanceof E) {
                forEachRemaining((E) consumer);
                return;
            }
            Objects.requireNonNull(consumer);
            if (w.a) {
                w.a(c.class, "{0} calling PrimitiveIterator.OfLong.forEachRemainingLong(action::accept)");
                throw null;
            }
            while (hasNext()) {
                consumer.accept(Long.valueOf(nextLong()));
            }
        }

        @Override // java.util.Iterator, j$.util.Iterator
        public boolean hasNext() {
            if (!this.a) {
                this.f8335c.tryAdvance(this);
            }
            return this.a;
        }

        @Override // java.util.Iterator, j$.util.Iterator
        public Long next() {
            if (!w.a) {
                return Long.valueOf(nextLong());
            }
            w.a(c.class, "{0} calling PrimitiveIterator.OfLong.nextLong()");
            throw null;
        }

        @Override // j$.util.t.c
        public long nextLong() {
            if (!this.a && !hasNext()) {
                throw new NoSuchElementException();
            }
            this.a = false;
            return this.f8334b;
        }

        @Override // java.util.Iterator, j$.util.Iterator
        public /* synthetic */ void remove() {
            Iterator.CC.a(this);
            throw null;
        }
    }

    class d implements t.a, j$.util.function.s {
        boolean a = false;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        double f8336b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Spliterator.a f8337c;

        d(Spliterator.a aVar) {
            this.f8337c = aVar;
        }

        @Override // j$.util.function.s
        public void accept(double d2) {
            this.a = true;
            this.f8336b = d2;
        }

        @Override // j$.util.t
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public void forEachRemaining(j$.util.function.s sVar) {
            Objects.requireNonNull(sVar);
            while (hasNext()) {
                sVar.accept(nextDouble());
            }
        }

        @Override // j$.util.t.a, j$.util.Iterator
        public void forEachRemaining(Consumer consumer) {
            if (consumer instanceof j$.util.function.s) {
                forEachRemaining((j$.util.function.s) consumer);
                return;
            }
            Objects.requireNonNull(consumer);
            if (w.a) {
                w.a(d.class, "{0} calling PrimitiveIterator.OfDouble.forEachRemainingDouble(action::accept)");
                throw null;
            }
            while (hasNext()) {
                consumer.accept(Double.valueOf(nextDouble()));
            }
        }

        @Override // java.util.Iterator, j$.util.Iterator
        public boolean hasNext() {
            if (!this.a) {
                this.f8337c.tryAdvance(this);
            }
            return this.a;
        }

        @Override // j$.util.function.s
        public j$.util.function.s j(j$.util.function.s sVar) {
            Objects.requireNonNull(sVar);
            return new C0392f(this, sVar);
        }

        @Override // java.util.Iterator, j$.util.Iterator
        public Double next() {
            if (!w.a) {
                return Double.valueOf(nextDouble());
            }
            w.a(d.class, "{0} calling PrimitiveIterator.OfDouble.nextLong()");
            throw null;
        }

        @Override // j$.util.t.a
        public double nextDouble() {
            if (!this.a && !hasNext()) {
                throw new NoSuchElementException();
            }
            this.a = false;
            return this.f8336b;
        }

        @Override // java.util.Iterator, j$.util.Iterator
        public /* synthetic */ void remove() {
            Iterator.CC.a(this);
            throw null;
        }
    }

    static final class e<T> implements Spliterator<T> {
        private final Object[] a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f8338b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f8339c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final int f8340d;

        public e(Object[] objArr, int i2, int i3, int i4) {
            this.a = objArr;
            this.f8338b = i2;
            this.f8339c = i3;
            this.f8340d = i4 | 64 | 16384;
        }

        @Override // j$.util.Spliterator
        public boolean b(Consumer consumer) {
            consumer.getClass();
            int i2 = this.f8338b;
            if (i2 < 0 || i2 >= this.f8339c) {
                return false;
            }
            Object[] objArr = this.a;
            this.f8338b = i2 + 1;
            consumer.accept(objArr[i2]);
            return true;
        }

        @Override // j$.util.Spliterator
        public int characteristics() {
            return this.f8340d;
        }

        @Override // j$.util.Spliterator
        public long estimateSize() {
            return this.f8339c - this.f8338b;
        }

        @Override // j$.util.Spliterator
        public void forEachRemaining(Consumer consumer) {
            int i2;
            consumer.getClass();
            Object[] objArr = this.a;
            int length = objArr.length;
            int i3 = this.f8339c;
            if (length < i3 || (i2 = this.f8338b) < 0) {
                return;
            }
            this.f8338b = i3;
            if (i2 < i3) {
                do {
                    consumer.accept(objArr[i2]);
                    i2++;
                } while (i2 < i3);
            }
        }

        @Override // j$.util.Spliterator
        public java.util.Comparator getComparator() {
            if (j$.time.a.h(this, 4)) {
                return null;
            }
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

        @Override // j$.util.Spliterator
        public Spliterator trySplit() {
            int i2 = this.f8338b;
            int i3 = (this.f8339c + i2) >>> 1;
            if (i2 >= i3) {
                return null;
            }
            Object[] objArr = this.a;
            this.f8338b = i3;
            return new e(objArr, i2, i3, this.f8340d);
        }
    }

    static final class f implements Spliterator.a {
        private final double[] a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f8341b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f8342c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final int f8343d;

        public f(double[] dArr, int i2, int i3, int i4) {
            this.a = dArr;
            this.f8341b = i2;
            this.f8342c = i3;
            this.f8343d = i4 | 64 | 16384;
        }

        @Override // j$.util.Spliterator.a, j$.util.Spliterator
        public /* synthetic */ boolean b(Consumer consumer) {
            return s.e(this, consumer);
        }

        @Override // j$.util.Spliterator
        public int characteristics() {
            return this.f8343d;
        }

        @Override // j$.util.Spliterator.d
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public void forEachRemaining(j$.util.function.s sVar) {
            int i2;
            sVar.getClass();
            double[] dArr = this.a;
            int length = dArr.length;
            int i3 = this.f8342c;
            if (length < i3 || (i2 = this.f8341b) < 0) {
                return;
            }
            this.f8341b = i3;
            if (i2 < i3) {
                do {
                    sVar.accept(dArr[i2]);
                    i2++;
                } while (i2 < i3);
            }
        }

        @Override // j$.util.Spliterator
        public long estimateSize() {
            return this.f8342c - this.f8341b;
        }

        @Override // j$.util.Spliterator.a, j$.util.Spliterator
        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            s.a(this, consumer);
        }

        @Override // j$.util.Spliterator
        public java.util.Comparator getComparator() {
            if (j$.time.a.h(this, 4)) {
                return null;
            }
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
        /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
        public boolean tryAdvance(j$.util.function.s sVar) {
            sVar.getClass();
            int i2 = this.f8341b;
            if (i2 < 0 || i2 >= this.f8342c) {
                return false;
            }
            double[] dArr = this.a;
            this.f8341b = i2 + 1;
            sVar.accept(dArr[i2]);
            return true;
        }

        @Override // j$.util.Spliterator
        public Spliterator.a trySplit() {
            int i2 = this.f8341b;
            int i3 = (this.f8342c + i2) >>> 1;
            if (i2 >= i3) {
                return null;
            }
            double[] dArr = this.a;
            this.f8341b = i3;
            return new f(dArr, i2, i3, this.f8343d);
        }
    }

    private static abstract class g<T, S extends Spliterator<T>, C> {

        private static final class a extends g<Double, Spliterator.a, j$.util.function.s> implements Spliterator.a {
            a() {
            }

            @Override // j$.util.Spliterator.a, j$.util.Spliterator
            public /* synthetic */ boolean b(Consumer consumer) {
                return s.e(this, consumer);
            }

            @Override // j$.util.Spliterator.a
            /* JADX INFO: renamed from: e */
            public void forEachRemaining(j$.util.function.s sVar) {
                Objects.requireNonNull(sVar);
            }

            @Override // j$.util.Spliterator.a, j$.util.Spliterator
            public /* synthetic */ void forEachRemaining(Consumer consumer) {
                s.a(this, consumer);
            }

            @Override // j$.util.Spliterator
            public java.util.Comparator getComparator() {
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

            @Override // j$.util.Spliterator.a
            /* JADX INFO: renamed from: n */
            public boolean tryAdvance(j$.util.function.s sVar) {
                Objects.requireNonNull(sVar);
                return false;
            }

            @Override // j$.util.v.g, j$.util.Spliterator.a, j$.util.Spliterator.d, j$.util.Spliterator
            public /* bridge */ /* synthetic */ Spliterator.a trySplit() {
                return null;
            }

            @Override // j$.util.v.g, j$.util.Spliterator.a, j$.util.Spliterator.d, j$.util.Spliterator
            public /* bridge */ /* synthetic */ Spliterator.d trySplit() {
                return null;
            }
        }

        private static final class b extends g<Integer, Spliterator.b, y> implements Spliterator.b {
            b() {
            }

            @Override // j$.util.Spliterator.b, j$.util.Spliterator
            public /* synthetic */ boolean b(Consumer consumer) {
                return s.f(this, consumer);
            }

            @Override // j$.util.Spliterator.b
            /* JADX INFO: renamed from: c */
            public void forEachRemaining(y yVar) {
                Objects.requireNonNull(yVar);
            }

            @Override // j$.util.Spliterator.b, j$.util.Spliterator
            public /* synthetic */ void forEachRemaining(Consumer consumer) {
                s.b(this, consumer);
            }

            @Override // j$.util.Spliterator.b
            /* JADX INFO: renamed from: g */
            public boolean tryAdvance(y yVar) {
                Objects.requireNonNull(yVar);
                return false;
            }

            @Override // j$.util.Spliterator
            public java.util.Comparator getComparator() {
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

            @Override // j$.util.v.g, j$.util.Spliterator.a, j$.util.Spliterator.d, j$.util.Spliterator
            public /* bridge */ /* synthetic */ Spliterator.b trySplit() {
                return null;
            }

            @Override // j$.util.v.g, j$.util.Spliterator.a, j$.util.Spliterator.d, j$.util.Spliterator
            public /* bridge */ /* synthetic */ Spliterator.d trySplit() {
                return null;
            }
        }

        private static final class c extends g<Long, Spliterator.c, E> implements Spliterator.c {
            c() {
            }

            @Override // j$.util.Spliterator.c, j$.util.Spliterator
            public /* synthetic */ boolean b(Consumer consumer) {
                return s.g(this, consumer);
            }

            @Override // j$.util.Spliterator.c
            /* JADX INFO: renamed from: d */
            public void forEachRemaining(E e2) {
                Objects.requireNonNull(e2);
            }

            @Override // j$.util.Spliterator.c, j$.util.Spliterator
            public /* synthetic */ void forEachRemaining(Consumer consumer) {
                s.c(this, consumer);
            }

            @Override // j$.util.Spliterator
            public java.util.Comparator getComparator() {
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

            @Override // j$.util.Spliterator.c
            /* JADX INFO: renamed from: i */
            public boolean tryAdvance(E e2) {
                Objects.requireNonNull(e2);
                return false;
            }

            @Override // j$.util.v.g, j$.util.Spliterator.a, j$.util.Spliterator.d, j$.util.Spliterator
            public /* bridge */ /* synthetic */ Spliterator.c trySplit() {
                return null;
            }

            @Override // j$.util.v.g, j$.util.Spliterator.a, j$.util.Spliterator.d, j$.util.Spliterator
            public /* bridge */ /* synthetic */ Spliterator.d trySplit() {
                return null;
            }
        }

        private static final class d<T> extends g<T, Spliterator<T>, Consumer<? super T>> implements Spliterator<T> {
            d() {
            }

            @Override // j$.util.Spliterator
            public boolean b(Consumer consumer) {
                Objects.requireNonNull(consumer);
                return false;
            }

            @Override // j$.util.Spliterator
            public void forEachRemaining(Consumer consumer) {
                Objects.requireNonNull(consumer);
            }

            @Override // j$.util.Spliterator
            public java.util.Comparator getComparator() {
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

        g() {
        }

        public int characteristics() {
            return 16448;
        }

        public long estimateSize() {
            return 0L;
        }

        public void forEachRemaining(Object obj) {
            Objects.requireNonNull(obj);
        }

        public boolean tryAdvance(Object obj) {
            Objects.requireNonNull(obj);
            return false;
        }

        public Spliterator trySplit() {
            return null;
        }
    }

    static final class h implements Spliterator.b {
        private final int[] a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f8344b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f8345c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final int f8346d;

        public h(int[] iArr, int i2, int i3, int i4) {
            this.a = iArr;
            this.f8344b = i2;
            this.f8345c = i3;
            this.f8346d = i4 | 64 | 16384;
        }

        @Override // j$.util.Spliterator.b, j$.util.Spliterator
        public /* synthetic */ boolean b(Consumer consumer) {
            return s.f(this, consumer);
        }

        @Override // j$.util.Spliterator.d
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void forEachRemaining(y yVar) {
            int i2;
            yVar.getClass();
            int[] iArr = this.a;
            int length = iArr.length;
            int i3 = this.f8345c;
            if (length < i3 || (i2 = this.f8344b) < 0) {
                return;
            }
            this.f8344b = i3;
            if (i2 < i3) {
                do {
                    yVar.accept(iArr[i2]);
                    i2++;
                } while (i2 < i3);
            }
        }

        @Override // j$.util.Spliterator
        public int characteristics() {
            return this.f8346d;
        }

        @Override // j$.util.Spliterator
        public long estimateSize() {
            return this.f8345c - this.f8344b;
        }

        @Override // j$.util.Spliterator.b, j$.util.Spliterator
        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            s.b(this, consumer);
        }

        @Override // j$.util.Spliterator.d
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public boolean tryAdvance(y yVar) {
            yVar.getClass();
            int i2 = this.f8344b;
            if (i2 < 0 || i2 >= this.f8345c) {
                return false;
            }
            int[] iArr = this.a;
            this.f8344b = i2 + 1;
            yVar.accept(iArr[i2]);
            return true;
        }

        @Override // j$.util.Spliterator
        public java.util.Comparator getComparator() {
            if (j$.time.a.h(this, 4)) {
                return null;
            }
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

        @Override // j$.util.Spliterator
        public Spliterator.b trySplit() {
            int i2 = this.f8344b;
            int i3 = (this.f8345c + i2) >>> 1;
            if (i2 >= i3) {
                return null;
            }
            int[] iArr = this.a;
            this.f8344b = i3;
            return new h(iArr, i2, i3, this.f8346d);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static class i<T> implements Spliterator<T> {
        private final java.util.Collection a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private java.util.Iterator f8347b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f8348c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private long f8349d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f8350e;

        public i(java.util.Collection collection, int i2) {
            this.a = collection;
            this.f8347b = null;
            this.f8348c = (i2 & 4096) == 0 ? i2 | 64 | 16384 : i2;
        }

        public i(java.util.Iterator it, int i2) {
            this.a = null;
            this.f8347b = it;
            this.f8349d = RecyclerView.FOREVER_NS;
            this.f8348c = i2 & (-16449);
        }

        @Override // j$.util.Spliterator
        public boolean b(Consumer consumer) {
            consumer.getClass();
            if (this.f8347b == null) {
                this.f8347b = this.a.iterator();
                this.f8349d = this.a.size();
            }
            if (!this.f8347b.hasNext()) {
                return false;
            }
            consumer.accept(this.f8347b.next());
            return true;
        }

        @Override // j$.util.Spliterator
        public int characteristics() {
            return this.f8348c;
        }

        @Override // j$.util.Spliterator
        public long estimateSize() {
            if (this.f8347b != null) {
                return this.f8349d;
            }
            this.f8347b = this.a.iterator();
            long size = this.a.size();
            this.f8349d = size;
            return size;
        }

        @Override // j$.util.Spliterator
        public void forEachRemaining(Consumer consumer) {
            consumer.getClass();
            java.util.Iterator it = this.f8347b;
            if (it == null) {
                it = this.a.iterator();
                this.f8347b = it;
                this.f8349d = this.a.size();
            }
            Iterator.EL.forEachRemaining(it, consumer);
        }

        @Override // j$.util.Spliterator
        public java.util.Comparator getComparator() {
            if (j$.time.a.h(this, 4)) {
                return null;
            }
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

        @Override // j$.util.Spliterator
        public Spliterator trySplit() {
            long size;
            java.util.Iterator it = this.f8347b;
            if (it == null) {
                it = this.a.iterator();
                this.f8347b = it;
                size = this.a.size();
                this.f8349d = size;
            } else {
                size = this.f8349d;
            }
            if (size <= 1 || !it.hasNext()) {
                return null;
            }
            int i2 = this.f8350e + 1024;
            if (i2 > size) {
                i2 = (int) size;
            }
            if (i2 > 33554432) {
                i2 = 33554432;
            }
            Object[] objArr = new Object[i2];
            int i3 = 0;
            do {
                objArr[i3] = it.next();
                i3++;
                if (i3 >= i2) {
                    break;
                }
            } while (it.hasNext());
            this.f8350e = i3;
            long j2 = this.f8349d;
            if (j2 != RecyclerView.FOREVER_NS) {
                this.f8349d = j2 - ((long) i3);
            }
            return new e(objArr, 0, i3, this.f8348c);
        }
    }

    static final class j implements Spliterator.c {
        private final long[] a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f8351b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f8352c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final int f8353d;

        public j(long[] jArr, int i2, int i3, int i4) {
            this.a = jArr;
            this.f8351b = i2;
            this.f8352c = i3;
            this.f8353d = i4 | 64 | 16384;
        }

        @Override // j$.util.Spliterator.c, j$.util.Spliterator
        public /* synthetic */ boolean b(Consumer consumer) {
            return s.g(this, consumer);
        }

        @Override // j$.util.Spliterator
        public int characteristics() {
            return this.f8353d;
        }

        @Override // j$.util.Spliterator.d
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void forEachRemaining(E e2) {
            int i2;
            e2.getClass();
            long[] jArr = this.a;
            int length = jArr.length;
            int i3 = this.f8352c;
            if (length < i3 || (i2 = this.f8351b) < 0) {
                return;
            }
            this.f8351b = i3;
            if (i2 < i3) {
                do {
                    e2.accept(jArr[i2]);
                    i2++;
                } while (i2 < i3);
            }
        }

        @Override // j$.util.Spliterator
        public long estimateSize() {
            return this.f8352c - this.f8351b;
        }

        @Override // j$.util.Spliterator.c, j$.util.Spliterator
        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            s.c(this, consumer);
        }

        @Override // j$.util.Spliterator
        public java.util.Comparator getComparator() {
            if (j$.time.a.h(this, 4)) {
                return null;
            }
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
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public boolean tryAdvance(E e2) {
            e2.getClass();
            int i2 = this.f8351b;
            if (i2 < 0 || i2 >= this.f8352c) {
                return false;
            }
            long[] jArr = this.a;
            this.f8351b = i2 + 1;
            e2.accept(jArr[i2]);
            return true;
        }

        @Override // j$.util.Spliterator
        public Spliterator.c trySplit() {
            int i2 = this.f8351b;
            int i3 = (this.f8352c + i2) >>> 1;
            if (i2 >= i3) {
                return null;
            }
            long[] jArr = this.a;
            this.f8351b = i3;
            return new j(jArr, i2, i3, this.f8353d);
        }
    }

    private static void a(int i2, int i3, int i4) {
        if (i3 <= i4) {
            if (i3 < 0) {
                throw new ArrayIndexOutOfBoundsException(i3);
            }
            if (i4 > i2) {
                throw new ArrayIndexOutOfBoundsException(i4);
            }
            return;
        }
        throw new ArrayIndexOutOfBoundsException("origin(" + i3 + ") > fence(" + i4 + ")");
    }

    public static Spliterator.a b() {
        return f8329d;
    }

    public static Spliterator.b c() {
        return f8327b;
    }

    public static Spliterator.c d() {
        return f8328c;
    }

    public static Spliterator e() {
        return a;
    }

    public static t.a f(Spliterator.a aVar) {
        Objects.requireNonNull(aVar);
        return new d(aVar);
    }

    public static t.b g(Spliterator.b bVar) {
        Objects.requireNonNull(bVar);
        return new b(bVar);
    }

    public static t.c h(Spliterator.c cVar) {
        Objects.requireNonNull(cVar);
        return new c(cVar);
    }

    public static java.util.Iterator i(Spliterator spliterator) {
        Objects.requireNonNull(spliterator);
        return new a(spliterator);
    }

    public static Spliterator.a j(double[] dArr, int i2, int i3, int i4) {
        Objects.requireNonNull(dArr);
        a(dArr.length, i2, i3);
        return new f(dArr, i2, i3, i4);
    }

    public static Spliterator.b k(int[] iArr, int i2, int i3, int i4) {
        Objects.requireNonNull(iArr);
        a(iArr.length, i2, i3);
        return new h(iArr, i2, i3, i4);
    }

    public static Spliterator.c l(long[] jArr, int i2, int i3, int i4) {
        Objects.requireNonNull(jArr);
        a(jArr.length, i2, i3);
        return new j(jArr, i2, i3, i4);
    }

    public static Spliterator m(java.util.Collection collection, int i2) {
        Objects.requireNonNull(collection);
        return new i(collection, i2);
    }

    public static Spliterator n(Object[] objArr, int i2, int i3, int i4) {
        Objects.requireNonNull(objArr);
        a(objArr.length, i2, i3);
        return new e(objArr, i2, i3, i4);
    }

    public static Spliterator o(java.util.Iterator it, int i2) {
        Objects.requireNonNull(it);
        return new i(it, i2);
    }
}

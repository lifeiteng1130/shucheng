package j$.util.stream;

import j$.C$r8$wrapper$java$util$function$Consumer$VWRP;
import j$.C0366i;
import j$.lang.Iterable;
import j$.util.Spliterator;
import j$.util.function.C0392f;
import j$.util.function.C0395i;
import j$.util.function.C0396j;
import j$.util.function.Consumer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
class S2<E> extends AbstractC0436j1 implements Consumer<E>, Iterable<E>, Iterable {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected Object[] f8108e = new Object[16];

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected Object[][] f8109f;

    class a implements Spliterator<E> {
        int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final int f8110b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f8111c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final int f8112d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object[] f8113e;

        a(int i2, int i3, int i4, int i5) {
            this.a = i2;
            this.f8110b = i3;
            this.f8111c = i4;
            this.f8112d = i5;
            Object[][] objArr = S2.this.f8109f;
            this.f8113e = objArr == null ? S2.this.f8108e : objArr[i2];
        }

        @Override // j$.util.Spliterator
        public boolean b(Consumer consumer) {
            Objects.requireNonNull(consumer);
            int i2 = this.a;
            int i3 = this.f8110b;
            if (i2 >= i3 && (i2 != i3 || this.f8111c >= this.f8112d)) {
                return false;
            }
            Object[] objArr = this.f8113e;
            int i4 = this.f8111c;
            this.f8111c = i4 + 1;
            consumer.accept(objArr[i4]);
            if (this.f8111c == this.f8113e.length) {
                this.f8111c = 0;
                int i5 = this.a + 1;
                this.a = i5;
                Object[][] objArr2 = S2.this.f8109f;
                if (objArr2 != null && i5 <= this.f8110b) {
                    this.f8113e = objArr2[i5];
                }
            }
            return true;
        }

        @Override // j$.util.Spliterator
        public int characteristics() {
            return 16464;
        }

        @Override // j$.util.Spliterator
        public long estimateSize() {
            int i2 = this.a;
            int i3 = this.f8110b;
            if (i2 == i3) {
                return ((long) this.f8112d) - ((long) this.f8111c);
            }
            long[] jArr = S2.this.f8220d;
            return ((jArr[i3] + ((long) this.f8112d)) - jArr[i2]) - ((long) this.f8111c);
        }

        @Override // j$.util.Spliterator
        public void forEachRemaining(Consumer consumer) {
            int i2;
            Objects.requireNonNull(consumer);
            int i3 = this.a;
            int i4 = this.f8110b;
            if (i3 < i4 || (i3 == i4 && this.f8111c < this.f8112d)) {
                int i5 = this.f8111c;
                while (true) {
                    i2 = this.f8110b;
                    if (i3 >= i2) {
                        break;
                    }
                    Object[] objArr = S2.this.f8109f[i3];
                    while (i5 < objArr.length) {
                        consumer.accept(objArr[i5]);
                        i5++;
                    }
                    i5 = 0;
                    i3++;
                }
                Object[] objArr2 = this.a == i2 ? this.f8113e : S2.this.f8109f[i2];
                int i6 = this.f8112d;
                while (i5 < i6) {
                    consumer.accept(objArr2[i5]);
                    i5++;
                }
                this.a = this.f8110b;
                this.f8111c = this.f8112d;
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

        @Override // j$.util.Spliterator
        public Spliterator trySplit() {
            int i2 = this.a;
            int i3 = this.f8110b;
            if (i2 < i3) {
                S2 s2 = S2.this;
                int i4 = i3 - 1;
                a aVar = new a(i2, i4, this.f8111c, s2.f8109f[i4].length);
                int i5 = this.f8110b;
                this.a = i5;
                this.f8111c = 0;
                this.f8113e = S2.this.f8109f[i5];
                return aVar;
            }
            if (i2 != i3) {
                return null;
            }
            int i6 = this.f8112d;
            int i7 = this.f8111c;
            int i8 = (i6 - i7) / 2;
            if (i8 == 0) {
                return null;
            }
            Spliterator spliteratorN = j$.util.v.n(this.f8113e, i7, i7 + i8, 1040);
            this.f8111c += i8;
            return spliteratorN;
        }
    }

    static class b extends e<Double, double[], j$.util.function.s> implements j$.util.function.s {

        class a extends e<Double, double[], j$.util.function.s>.a<Spliterator.a> implements Spliterator.a {
            a(int i2, int i3, int i4, int i5) {
                super(i2, i3, i4, i5);
            }

            @Override // j$.util.stream.S2.e.a
            void a(Object obj, int i2, Object obj2) {
                ((j$.util.function.s) obj2).accept(((double[]) obj)[i2]);
            }

            @Override // j$.util.Spliterator
            public /* synthetic */ boolean b(Consumer consumer) {
                return j$.util.s.e(this, consumer);
            }

            @Override // j$.util.stream.S2.e.a
            Spliterator.d f(Object obj, int i2, int i3) {
                return j$.util.v.j((double[]) obj, i2, i3 + i2, 1040);
            }

            @Override // j$.util.Spliterator
            public /* synthetic */ void forEachRemaining(Consumer consumer) {
                j$.util.s.a(this, consumer);
            }

            @Override // j$.util.stream.S2.e.a
            Spliterator.d h(int i2, int i3, int i4, int i5) {
                return b.this.new a(i2, i3, i4, i5);
            }
        }

        b() {
        }

        b(int i2) {
            super(i2);
        }

        @Override // j$.util.stream.S2.e, java.lang.Iterable, j$.lang.Iterable
        /* JADX INFO: renamed from: A, reason: merged with bridge method [inline-methods] */
        public Spliterator.a spliterator() {
            return new a(0, this.f8219c, 0, this.f8218b);
        }

        public void accept(double d2) {
            z();
            double[] dArr = (double[]) this.f8118e;
            int i2 = this.f8218b;
            this.f8218b = i2 + 1;
            dArr[i2] = d2;
        }

        @Override // j$.util.stream.S2.e
        public Object c(int i2) {
            return new double[i2];
        }

        @Override // j$.lang.Iterable
        public void forEach(Consumer consumer) {
            if (consumer instanceof j$.util.function.s) {
                g((j$.util.function.s) consumer);
            } else {
                if (i3.a) {
                    i3.a(getClass(), "{0} calling SpinedBuffer.OfDouble.forEach(Consumer)");
                    throw null;
                }
                spliterator().forEachRemaining(consumer);
            }
        }

        @Override // java.lang.Iterable, j$.lang.Iterable
        public Iterator iterator() {
            return j$.util.v.f(spliterator());
        }

        @Override // j$.util.function.s
        public j$.util.function.s j(j$.util.function.s sVar) {
            Objects.requireNonNull(sVar);
            return new C0392f(this, sVar);
        }

        @Override // j$.util.stream.S2.e
        protected void s(Object obj, int i2, int i3, Object obj2) {
            double[] dArr = (double[]) obj;
            j$.util.function.s sVar = (j$.util.function.s) obj2;
            while (i2 < i3) {
                sVar.accept(dArr[i2]);
                i2++;
            }
        }

        @Override // j$.util.stream.S2.e
        protected int t(Object obj) {
            return ((double[]) obj).length;
        }

        public String toString() {
            double[] dArr = (double[]) e();
            return dArr.length < 200 ? String.format("%s[length=%d, chunks=%d]%s", getClass().getSimpleName(), Integer.valueOf(dArr.length), Integer.valueOf(this.f8219c), Arrays.toString(dArr)) : String.format("%s[length=%d, chunks=%d]%s...", getClass().getSimpleName(), Integer.valueOf(dArr.length), Integer.valueOf(this.f8219c), Arrays.toString(Arrays.copyOf(dArr, 200)));
        }

        @Override // j$.util.stream.S2.e
        protected Object[] y(int i2) {
            return new double[i2][];
        }
    }

    static class c extends e<Integer, int[], j$.util.function.y> implements j$.util.function.y {

        class a extends e<Integer, int[], j$.util.function.y>.a<Spliterator.b> implements Spliterator.b {
            a(int i2, int i3, int i4, int i5) {
                super(i2, i3, i4, i5);
            }

            @Override // j$.util.stream.S2.e.a
            void a(Object obj, int i2, Object obj2) {
                ((j$.util.function.y) obj2).accept(((int[]) obj)[i2]);
            }

            @Override // j$.util.Spliterator
            public /* synthetic */ boolean b(Consumer consumer) {
                return j$.util.s.f(this, consumer);
            }

            @Override // j$.util.stream.S2.e.a
            Spliterator.d f(Object obj, int i2, int i3) {
                return j$.util.v.k((int[]) obj, i2, i3 + i2, 1040);
            }

            @Override // j$.util.Spliterator
            public /* synthetic */ void forEachRemaining(Consumer consumer) {
                j$.util.s.b(this, consumer);
            }

            @Override // j$.util.stream.S2.e.a
            Spliterator.d h(int i2, int i3, int i4, int i5) {
                return c.this.new a(i2, i3, i4, i5);
            }
        }

        c() {
        }

        c(int i2) {
            super(i2);
        }

        @Override // j$.util.stream.S2.e, java.lang.Iterable, j$.lang.Iterable
        /* JADX INFO: renamed from: A, reason: merged with bridge method [inline-methods] */
        public Spliterator.b spliterator() {
            return new a(0, this.f8219c, 0, this.f8218b);
        }

        public void accept(int i2) {
            z();
            int[] iArr = (int[]) this.f8118e;
            int i3 = this.f8218b;
            this.f8218b = i3 + 1;
            iArr[i3] = i2;
        }

        @Override // j$.util.stream.S2.e
        public Object c(int i2) {
            return new int[i2];
        }

        @Override // j$.lang.Iterable
        public void forEach(Consumer consumer) {
            if (consumer instanceof j$.util.function.y) {
                g((j$.util.function.y) consumer);
            } else {
                if (i3.a) {
                    i3.a(getClass(), "{0} calling SpinedBuffer.OfInt.forEach(Consumer)");
                    throw null;
                }
                spliterator().forEachRemaining(consumer);
            }
        }

        @Override // java.lang.Iterable, j$.lang.Iterable
        public Iterator iterator() {
            return j$.util.v.g(spliterator());
        }

        @Override // j$.util.function.y
        public j$.util.function.y k(j$.util.function.y yVar) {
            Objects.requireNonNull(yVar);
            return new C0395i(this, yVar);
        }

        @Override // j$.util.stream.S2.e
        protected void s(Object obj, int i2, int i3, Object obj2) {
            int[] iArr = (int[]) obj;
            j$.util.function.y yVar = (j$.util.function.y) obj2;
            while (i2 < i3) {
                yVar.accept(iArr[i2]);
                i2++;
            }
        }

        @Override // j$.util.stream.S2.e
        protected int t(Object obj) {
            return ((int[]) obj).length;
        }

        public String toString() {
            int[] iArr = (int[]) e();
            return iArr.length < 200 ? String.format("%s[length=%d, chunks=%d]%s", getClass().getSimpleName(), Integer.valueOf(iArr.length), Integer.valueOf(this.f8219c), Arrays.toString(iArr)) : String.format("%s[length=%d, chunks=%d]%s...", getClass().getSimpleName(), Integer.valueOf(iArr.length), Integer.valueOf(this.f8219c), Arrays.toString(Arrays.copyOf(iArr, 200)));
        }

        @Override // j$.util.stream.S2.e
        protected Object[] y(int i2) {
            return new int[i2][];
        }
    }

    static class d extends e<Long, long[], j$.util.function.E> implements j$.util.function.E {

        class a extends e<Long, long[], j$.util.function.E>.a<Spliterator.c> implements Spliterator.c {
            a(int i2, int i3, int i4, int i5) {
                super(i2, i3, i4, i5);
            }

            @Override // j$.util.stream.S2.e.a
            void a(Object obj, int i2, Object obj2) {
                ((j$.util.function.E) obj2).accept(((long[]) obj)[i2]);
            }

            @Override // j$.util.Spliterator
            public /* synthetic */ boolean b(Consumer consumer) {
                return j$.util.s.g(this, consumer);
            }

            @Override // j$.util.stream.S2.e.a
            Spliterator.d f(Object obj, int i2, int i3) {
                return j$.util.v.l((long[]) obj, i2, i3 + i2, 1040);
            }

            @Override // j$.util.Spliterator
            public /* synthetic */ void forEachRemaining(Consumer consumer) {
                j$.util.s.c(this, consumer);
            }

            @Override // j$.util.stream.S2.e.a
            Spliterator.d h(int i2, int i3, int i4, int i5) {
                return d.this.new a(i2, i3, i4, i5);
            }
        }

        d() {
        }

        d(int i2) {
            super(i2);
        }

        @Override // j$.util.stream.S2.e, java.lang.Iterable, j$.lang.Iterable
        /* JADX INFO: renamed from: A, reason: merged with bridge method [inline-methods] */
        public Spliterator.c spliterator() {
            return new a(0, this.f8219c, 0, this.f8218b);
        }

        public void accept(long j2) {
            z();
            long[] jArr = (long[]) this.f8118e;
            int i2 = this.f8218b;
            this.f8218b = i2 + 1;
            jArr[i2] = j2;
        }

        @Override // j$.util.stream.S2.e
        public Object c(int i2) {
            return new long[i2];
        }

        @Override // j$.util.function.E
        public j$.util.function.E f(j$.util.function.E e2) {
            Objects.requireNonNull(e2);
            return new C0396j(this, e2);
        }

        @Override // j$.lang.Iterable
        public void forEach(Consumer consumer) {
            if (consumer instanceof j$.util.function.E) {
                g((j$.util.function.E) consumer);
            } else {
                if (i3.a) {
                    i3.a(getClass(), "{0} calling SpinedBuffer.OfLong.forEach(Consumer)");
                    throw null;
                }
                spliterator().forEachRemaining(consumer);
            }
        }

        @Override // java.lang.Iterable, j$.lang.Iterable
        public Iterator iterator() {
            return j$.util.v.h(spliterator());
        }

        @Override // j$.util.stream.S2.e
        protected void s(Object obj, int i2, int i3, Object obj2) {
            long[] jArr = (long[]) obj;
            j$.util.function.E e2 = (j$.util.function.E) obj2;
            while (i2 < i3) {
                e2.accept(jArr[i2]);
                i2++;
            }
        }

        @Override // j$.util.stream.S2.e
        protected int t(Object obj) {
            return ((long[]) obj).length;
        }

        public String toString() {
            long[] jArr = (long[]) e();
            return jArr.length < 200 ? String.format("%s[length=%d, chunks=%d]%s", getClass().getSimpleName(), Integer.valueOf(jArr.length), Integer.valueOf(this.f8219c), Arrays.toString(jArr)) : String.format("%s[length=%d, chunks=%d]%s...", getClass().getSimpleName(), Integer.valueOf(jArr.length), Integer.valueOf(this.f8219c), Arrays.toString(Arrays.copyOf(jArr, 200)));
        }

        @Override // j$.util.stream.S2.e
        protected Object[] y(int i2) {
            return new long[i2][];
        }
    }

    static abstract class e<E, T_ARR, T_CONS> extends AbstractC0436j1 implements Iterable<E>, Iterable {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f8118e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        Object[] f8119f;

        abstract class a<T_SPLITR extends Spliterator.d<E, T_CONS, T_SPLITR>> implements Spliterator.d<E, T_CONS, T_SPLITR> {
            int a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final int f8120b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            int f8121c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final int f8122d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            Object f8123e;

            a(int i2, int i3, int i4, int i5) {
                this.a = i2;
                this.f8120b = i3;
                this.f8121c = i4;
                this.f8122d = i5;
                Object[] objArr = e.this.f8119f;
                this.f8123e = objArr == null ? e.this.f8118e : objArr[i2];
            }

            abstract void a(Object obj, int i2, Object obj2);

            @Override // j$.util.Spliterator
            public int characteristics() {
                return 16464;
            }

            @Override // j$.util.Spliterator
            public long estimateSize() {
                int i2 = this.a;
                int i3 = this.f8120b;
                if (i2 == i3) {
                    return ((long) this.f8122d) - ((long) this.f8121c);
                }
                long[] jArr = e.this.f8220d;
                return ((jArr[i3] + ((long) this.f8122d)) - jArr[i2]) - ((long) this.f8121c);
            }

            abstract Spliterator.d f(Object obj, int i2, int i3);

            @Override // j$.util.Spliterator.d
            /* JADX INFO: renamed from: forEachRemaining, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public void e(Object obj) {
                int i2;
                Objects.requireNonNull(obj);
                int i3 = this.a;
                int i4 = this.f8120b;
                if (i3 < i4 || (i3 == i4 && this.f8121c < this.f8122d)) {
                    int i5 = this.f8121c;
                    while (true) {
                        i2 = this.f8120b;
                        if (i3 >= i2) {
                            break;
                        }
                        e eVar = e.this;
                        Object obj2 = eVar.f8119f[i3];
                        eVar.s(obj2, i5, eVar.t(obj2), obj);
                        i5 = 0;
                        i3++;
                    }
                    e.this.s(this.a == i2 ? this.f8123e : e.this.f8119f[i2], i5, this.f8122d, obj);
                    this.a = this.f8120b;
                    this.f8121c = this.f8122d;
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

            abstract Spliterator.d h(int i2, int i3, int i4, int i5);

            @Override // j$.util.Spliterator
            public /* synthetic */ boolean hasCharacteristics(int i2) {
                return j$.time.a.h(this, i2);
            }

            @Override // j$.util.Spliterator.d
            /* JADX INFO: renamed from: tryAdvance, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public boolean n(Object obj) {
                Objects.requireNonNull(obj);
                int i2 = this.a;
                int i3 = this.f8120b;
                if (i2 >= i3 && (i2 != i3 || this.f8121c >= this.f8122d)) {
                    return false;
                }
                Object obj2 = this.f8123e;
                int i4 = this.f8121c;
                this.f8121c = i4 + 1;
                a(obj2, i4, obj);
                if (this.f8121c == e.this.t(this.f8123e)) {
                    this.f8121c = 0;
                    int i5 = this.a + 1;
                    this.a = i5;
                    Object[] objArr = e.this.f8119f;
                    if (objArr != null && i5 <= this.f8120b) {
                        this.f8123e = objArr[i5];
                    }
                }
                return true;
            }

            @Override // j$.util.Spliterator.d, j$.util.Spliterator
            public /* bridge */ /* synthetic */ Spliterator.a trySplit() {
                return (Spliterator.a) trySplit();
            }

            @Override // j$.util.Spliterator.d, j$.util.Spliterator
            public /* bridge */ /* synthetic */ Spliterator.b trySplit() {
                return (Spliterator.b) trySplit();
            }

            @Override // j$.util.Spliterator.d, j$.util.Spliterator
            public /* bridge */ /* synthetic */ Spliterator.c trySplit() {
                return (Spliterator.c) trySplit();
            }

            @Override // j$.util.Spliterator
            public Spliterator.d trySplit() {
                int i2 = this.a;
                int i3 = this.f8120b;
                if (i2 < i3) {
                    int i4 = this.f8121c;
                    e eVar = e.this;
                    Spliterator.d dVarH = h(i2, i3 - 1, i4, eVar.t(eVar.f8119f[i3 - 1]));
                    int i5 = this.f8120b;
                    this.a = i5;
                    this.f8121c = 0;
                    this.f8123e = e.this.f8119f[i5];
                    return dVarH;
                }
                if (i2 != i3) {
                    return null;
                }
                int i6 = this.f8122d;
                int i7 = this.f8121c;
                int i8 = (i6 - i7) / 2;
                if (i8 == 0) {
                    return null;
                }
                Spliterator.d dVarF = f(this.f8123e, i7, i8);
                this.f8121c += i8;
                return dVarF;
            }
        }

        e() {
            this.f8118e = c(16);
        }

        e(int i2) {
            super(i2);
            this.f8118e = c(1 << this.a);
        }

        private void x() {
            if (this.f8119f == null) {
                Object[] objArrY = y(8);
                this.f8119f = objArrY;
                this.f8220d = new long[8];
                objArrY[0] = this.f8118e;
            }
        }

        public abstract Object c(int i2);

        @Override // j$.util.stream.AbstractC0436j1
        public void clear() {
            Object[] objArr = this.f8119f;
            if (objArr != null) {
                this.f8118e = objArr[0];
                this.f8119f = null;
                this.f8220d = null;
            }
            this.f8218b = 0;
            this.f8219c = 0;
        }

        public void d(Object obj, int i2) {
            long j2 = i2;
            long jCount = count() + j2;
            if (jCount > t(obj) || jCount < j2) {
                throw new IndexOutOfBoundsException("does not fit");
            }
            if (this.f8219c == 0) {
                System.arraycopy(this.f8118e, 0, obj, i2, this.f8218b);
                return;
            }
            for (int i3 = 0; i3 < this.f8219c; i3++) {
                Object[] objArr = this.f8119f;
                System.arraycopy(objArr[i3], 0, obj, i2, t(objArr[i3]));
                i2 += t(this.f8119f[i3]);
            }
            int i4 = this.f8218b;
            if (i4 > 0) {
                System.arraycopy(this.f8118e, 0, obj, i2, i4);
            }
        }

        public Object e() {
            long jCount = count();
            if (jCount >= 2147483639) {
                throw new IllegalArgumentException("Stream size exceeds max array size");
            }
            Object objC = c((int) jCount);
            d(objC, 0);
            return objC;
        }

        public void g(Object obj) {
            for (int i2 = 0; i2 < this.f8219c; i2++) {
                Object[] objArr = this.f8119f;
                s(objArr[i2], 0, t(objArr[i2]), obj);
            }
            s(this.f8118e, 0, this.f8218b, obj);
        }

        protected abstract void s(Object obj, int i2, int i3, Object obj2);

        public abstract Spliterator spliterator();

        @Override // java.lang.Iterable
        public /* synthetic */ java.util.Spliterator spliterator() {
            return C0366i.a(spliterator());
        }

        protected abstract int t(Object obj);

        protected long u() {
            int i2 = this.f8219c;
            if (i2 == 0) {
                return t(this.f8118e);
            }
            return ((long) t(this.f8119f[i2])) + this.f8220d[i2];
        }

        protected int v(long j2) {
            if (this.f8219c == 0) {
                if (j2 < this.f8218b) {
                    return 0;
                }
                throw new IndexOutOfBoundsException(Long.toString(j2));
            }
            if (j2 >= count()) {
                throw new IndexOutOfBoundsException(Long.toString(j2));
            }
            for (int i2 = 0; i2 <= this.f8219c; i2++) {
                if (j2 < this.f8220d[i2] + ((long) t(this.f8119f[i2]))) {
                    return i2;
                }
            }
            throw new IndexOutOfBoundsException(Long.toString(j2));
        }

        protected final void w(long j2) {
            long jU = u();
            if (j2 <= jU) {
                return;
            }
            x();
            int i2 = this.f8219c;
            while (true) {
                i2++;
                if (j2 <= jU) {
                    return;
                }
                Object[] objArr = this.f8119f;
                if (i2 >= objArr.length) {
                    int length = objArr.length * 2;
                    this.f8119f = Arrays.copyOf(objArr, length);
                    this.f8220d = Arrays.copyOf(this.f8220d, length);
                }
                int iR = r(i2);
                this.f8119f[i2] = c(iR);
                long[] jArr = this.f8220d;
                int i3 = i2 - 1;
                jArr[i2] = jArr[i3] + ((long) t(this.f8119f[i3]));
                jU += (long) iR;
            }
        }

        protected abstract Object[] y(int i2);

        protected void z() {
            if (this.f8218b == t(this.f8118e)) {
                x();
                int i2 = this.f8219c;
                int i3 = i2 + 1;
                Object[] objArr = this.f8119f;
                if (i3 >= objArr.length || objArr[i2 + 1] == null) {
                    w(u() + 1);
                }
                this.f8218b = 0;
                int i4 = this.f8219c + 1;
                this.f8219c = i4;
                this.f8118e = this.f8119f[i4];
            }
        }
    }

    S2() {
    }

    private void u() {
        if (this.f8109f == null) {
            Object[][] objArr = new Object[8][];
            this.f8109f = objArr;
            this.f8220d = new long[8];
            objArr[0] = this.f8108e;
        }
    }

    public void accept(Object obj) {
        if (this.f8218b == this.f8108e.length) {
            u();
            int i2 = this.f8219c;
            int i3 = i2 + 1;
            Object[][] objArr = this.f8109f;
            if (i3 >= objArr.length || objArr[i2 + 1] == null) {
                t(s() + 1);
            }
            this.f8218b = 0;
            int i4 = this.f8219c + 1;
            this.f8219c = i4;
            this.f8108e = this.f8109f[i4];
        }
        Object[] objArr2 = this.f8108e;
        int i5 = this.f8218b;
        this.f8218b = i5 + 1;
        objArr2[i5] = obj;
    }

    @Override // j$.util.function.Consumer
    public /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.$default$andThen(this, consumer);
    }

    @Override // j$.util.stream.AbstractC0436j1
    public void clear() {
        Object[][] objArr = this.f8109f;
        if (objArr != null) {
            this.f8108e = objArr[0];
            int i2 = 0;
            while (true) {
                Object[] objArr2 = this.f8108e;
                if (i2 >= objArr2.length) {
                    break;
                }
                objArr2[i2] = null;
                i2++;
            }
            this.f8109f = null;
            this.f8220d = null;
        } else {
            for (int i3 = 0; i3 < this.f8218b; i3++) {
                this.f8108e[i3] = null;
            }
        }
        this.f8218b = 0;
        this.f8219c = 0;
    }

    public void forEach(Consumer consumer) {
        for (int i2 = 0; i2 < this.f8219c; i2++) {
            for (Object obj : this.f8109f[i2]) {
                consumer.accept(obj);
            }
        }
        for (int i3 = 0; i3 < this.f8218b; i3++) {
            consumer.accept(this.f8108e[i3]);
        }
    }

    @Override // java.lang.Iterable
    public /* synthetic */ void forEach(java.util.function.Consumer consumer) {
        forEach(C$r8$wrapper$java$util$function$Consumer$VWRP.convert(consumer));
    }

    public void i(Object[] objArr, int i2) {
        long j2 = i2;
        long jCount = count() + j2;
        if (jCount > objArr.length || jCount < j2) {
            throw new IndexOutOfBoundsException("does not fit");
        }
        if (this.f8219c == 0) {
            System.arraycopy(this.f8108e, 0, objArr, i2, this.f8218b);
            return;
        }
        for (int i3 = 0; i3 < this.f8219c; i3++) {
            Object[][] objArr2 = this.f8109f;
            System.arraycopy(objArr2[i3], 0, objArr, i2, objArr2[i3].length);
            i2 += this.f8109f[i3].length;
        }
        int i4 = this.f8218b;
        if (i4 > 0) {
            System.arraycopy(this.f8108e, 0, objArr, i2, i4);
        }
    }

    @Override // java.lang.Iterable, j$.lang.Iterable
    public Iterator iterator() {
        return j$.util.v.i(spliterator());
    }

    protected long s() {
        int i2 = this.f8219c;
        if (i2 == 0) {
            return this.f8108e.length;
        }
        return ((long) this.f8109f[i2].length) + this.f8220d[i2];
    }

    public Spliterator spliterator() {
        return new a(0, this.f8219c, 0, this.f8218b);
    }

    @Override // java.lang.Iterable
    public /* synthetic */ java.util.Spliterator spliterator() {
        return C0366i.a(spliterator());
    }

    protected final void t(long j2) {
        long jS = s();
        if (j2 <= jS) {
            return;
        }
        u();
        int i2 = this.f8219c;
        while (true) {
            i2++;
            if (j2 <= jS) {
                return;
            }
            Object[][] objArr = this.f8109f;
            if (i2 >= objArr.length) {
                int length = objArr.length * 2;
                this.f8109f = (Object[][]) Arrays.copyOf(objArr, length);
                this.f8220d = Arrays.copyOf(this.f8220d, length);
            }
            int iR = r(i2);
            Object[][] objArr2 = this.f8109f;
            objArr2[i2] = new Object[iR];
            long[] jArr = this.f8220d;
            int i3 = i2 - 1;
            jArr[i2] = jArr[i3] + ((long) objArr2[i3].length);
            jS += (long) iR;
        }
    }

    public String toString() {
        final ArrayList arrayList = new ArrayList();
        forEach(new Consumer() { // from class: j$.util.stream.b1
            @Override // j$.util.function.Consumer
            public final void accept(Object obj) {
                arrayList.add(obj);
            }

            @Override // j$.util.function.Consumer
            public /* synthetic */ Consumer andThen(Consumer consumer) {
                return Consumer.CC.$default$andThen(this, consumer);
            }
        });
        StringBuilder sbA = j$.com.android.tools.r8.a.a("SpinedBuffer:");
        sbA.append(arrayList.toString());
        return sbA.toString();
    }
}

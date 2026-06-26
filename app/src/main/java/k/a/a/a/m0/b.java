package k.a.a.a.m0;

import j$.lang.Iterable;
import j$.util.Collection;
import j$.util.Iterator;
import j$.util.Set;
import j$.util.Spliterator;
import j$.util.function.Consumer;
import j$.util.function.Predicate;
import j$.util.stream.Q1;
import j$.util.stream.Stream;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import org.slf4j.helpers.MessageFormatter;

/* JADX INFO: compiled from: Array2DHashSet.java */
/* JADX INFO: loaded from: classes3.dex */
public class b<T> implements Set<T>, j$.util.Set {
    public final k.a.a.a.m0.a<? super T> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public T[][] f8495b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f8496c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f8497d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f8498e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f8499f;

    /* JADX INFO: compiled from: Array2DHashSet.java */
    public class a implements Iterator<T>, j$.util.Iterator {
        public final T[] a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f8500b = 0;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f8501c = true;

        public a(T[] tArr) {
            this.a = tArr;
        }

        @Override // j$.util.Iterator
        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            Iterator.CC.$default$forEachRemaining(this, consumer);
        }

        @Override // java.util.Iterator, j$.util.Iterator
        public boolean hasNext() {
            return this.f8500b < this.a.length;
        }

        @Override // java.util.Iterator, j$.util.Iterator
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            this.f8501c = false;
            T[] tArr = this.a;
            int i2 = this.f8500b;
            this.f8500b = i2 + 1;
            return tArr[i2];
        }

        @Override // java.util.Iterator, j$.util.Iterator
        public void remove() {
            if (this.f8501c) {
                throw new IllegalStateException();
            }
            b.this.remove(this.a[this.f8500b - 1]);
            this.f8501c = true;
        }
    }

    public b() {
        this(null, 16, 8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public T a(Object obj) {
        return obj;
    }

    @Override // java.util.Set, java.util.Collection, j$.util.Set, j$.util.Collection
    public final boolean add(T t) {
        return f(t) == t;
    }

    @Override // java.util.Set, java.util.Collection, j$.util.Set, j$.util.Collection
    public boolean addAll(Collection<? extends T> collection) {
        boolean z = false;
        for (T t : collection) {
            if (f(t) != t) {
                z = true;
            }
        }
        return z;
    }

    public boolean b(T t) {
        if (t == null) {
            return false;
        }
        T[] tArr = this.f8495b[e(t)];
        T t2 = null;
        if (tArr != null) {
            int length = tArr.length;
            int i2 = 0;
            while (true) {
                if (i2 < length) {
                    T t3 = tArr[i2];
                    if (t3 == null) {
                        break;
                    }
                    if (this.a.a(t3, t)) {
                        t2 = t3;
                        break;
                    }
                    i2++;
                } else {
                    break;
                }
            }
        }
        return t2 != null;
    }

    public T[] c(int i2) {
        return (T[]) new Object[i2];
    }

    @Override // java.util.Set, java.util.Collection, j$.util.Set, j$.util.Collection
    public void clear() {
        this.f8495b = d(16);
        this.f8496c = 0;
        this.f8497d = (int) Math.floor(12.0d);
    }

    @Override // java.util.Set, java.util.Collection, j$.util.Set, j$.util.Collection
    public final boolean contains(Object obj) {
        return b(a(obj));
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0029, code lost:
    
        continue;
     */
    @Override // java.util.Set, java.util.Collection, j$.util.Set, j$.util.Collection
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean containsAll(java.util.Collection<?> r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof k.a.a.a.m0.b
            r1 = 0
            if (r0 == 0) goto L2c
            k.a.a.a.m0.b r8 = (k.a.a.a.m0.b) r8
            T[][] r8 = r8.f8495b
            int r0 = r8.length
            r2 = 0
        Lb:
            if (r2 >= r0) goto L45
            r3 = r8[r2]
            if (r3 != 0) goto L12
            goto L29
        L12:
            int r4 = r3.length
            r5 = 0
        L14:
            if (r5 >= r4) goto L29
            r6 = r3[r5]
            if (r6 != 0) goto L1b
            goto L29
        L1b:
            java.lang.Object r6 = r7.a(r6)
            boolean r6 = r7.b(r6)
            if (r6 != 0) goto L26
            return r1
        L26:
            int r5 = r5 + 1
            goto L14
        L29:
            int r2 = r2 + 1
            goto Lb
        L2c:
            java.util.Iterator r8 = r8.iterator()
        L30:
            boolean r0 = r8.hasNext()
            if (r0 == 0) goto L45
            java.lang.Object r0 = r8.next()
            java.lang.Object r0 = r7.a(r0)
            boolean r0 = r7.b(r0)
            if (r0 != 0) goto L30
            return r1
        L45:
            r8 = 1
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: k.a.a.a.m0.b.containsAll(java.util.Collection):boolean");
    }

    public T[][] d(int i2) {
        return (T[][]) new Object[i2][];
    }

    public final int e(T t) {
        return this.a.b(t) & (this.f8495b.length - 1);
    }

    @Override // java.util.Set, java.util.Collection, j$.util.Set, j$.util.Collection
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (bVar.f8496c != this.f8496c) {
            return false;
        }
        return containsAll(bVar);
    }

    public final T f(T t) {
        T[] tArrC;
        if (this.f8496c > this.f8497d) {
            T[][] tArr = this.f8495b;
            this.f8498e += 4;
            int length = tArr.length * 2;
            T[][] tArrD = d(length);
            int[] iArr = new int[tArrD.length];
            this.f8495b = tArrD;
            this.f8497d = (int) (((double) length) * 0.75d);
            for (T[] tArr2 : tArr) {
                if (tArr2 != null) {
                    for (T t2 : tArr2) {
                        if (t2 == null) {
                            break;
                        }
                        int iE = e(t2);
                        int i2 = iArr[iE];
                        if (i2 == 0) {
                            tArrC = c(this.f8499f);
                            tArrD[iE] = tArrC;
                        } else {
                            tArrC = tArrD[iE];
                            if (i2 == tArrC.length) {
                                tArrC = (T[]) Arrays.copyOf(tArrC, tArrC.length * 2);
                                tArrD[iE] = tArrC;
                            }
                        }
                        tArrC[i2] = t2;
                        iArr[iE] = iArr[iE] + 1;
                    }
                }
            }
        }
        int iE2 = e(t);
        T[] tArr3 = this.f8495b[iE2];
        if (tArr3 == null) {
            T[] tArrC2 = c(this.f8499f);
            tArrC2[0] = t;
            this.f8495b[iE2] = tArrC2;
            this.f8496c++;
            return t;
        }
        for (int i3 = 0; i3 < tArr3.length; i3++) {
            T t3 = tArr3[i3];
            if (t3 == null) {
                tArr3[i3] = t;
                this.f8496c++;
                return t;
            }
            if (this.a.a(t3, t)) {
                return t3;
            }
        }
        int length2 = tArr3.length;
        Object[] objArrCopyOf = Arrays.copyOf(tArr3, tArr3.length * 2);
        ((T[][]) this.f8495b)[iE2] = objArrCopyOf;
        objArrCopyOf[length2] = t;
        this.f8496c++;
        return t;
    }

    @Override // j$.util.Collection, j$.lang.Iterable
    public /* synthetic */ void forEach(Consumer consumer) {
        Iterable.CC.$default$forEach(this, consumer);
    }

    public boolean g(T t) {
        T t2;
        if (t == null) {
            return false;
        }
        T[] tArr = this.f8495b[e(t)];
        if (tArr == null) {
            return false;
        }
        for (int i2 = 0; i2 < tArr.length && (t2 = tArr[i2]) != null; i2++) {
            if (this.a.a(t2, t)) {
                System.arraycopy(tArr, i2 + 1, tArr, i2, (tArr.length - i2) - 1);
                tArr[tArr.length - 1] = null;
                this.f8496c--;
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Set, java.util.Collection, j$.util.Set, j$.util.Collection
    public int hashCode() {
        int iX5 = 0;
        for (T[] tArr : this.f8495b) {
            if (tArr != null) {
                for (T t : tArr) {
                    if (t == null) {
                        break;
                    }
                    iX5 = c.b.a.m.f.X5(iX5, this.a.b(t));
                }
            }
        }
        return c.b.a.m.f.I1(iX5, this.f8496c);
    }

    @Override // java.util.Set, java.util.Collection, j$.util.Set, j$.util.Collection
    public final boolean isEmpty() {
        return this.f8496c == 0;
    }

    @Override // java.util.Set, java.util.Collection, java.lang.Iterable, j$.util.Set, j$.util.Collection, j$.lang.Iterable
    public java.util.Iterator<T> iterator() {
        return new a(toArray());
    }

    @Override // java.util.Collection, j$.util.Collection
    public /* synthetic */ Stream parallelStream() {
        return Q1.v(j$.time.a.A(this), true);
    }

    @Override // java.util.Set, java.util.Collection, j$.util.Set, j$.util.Collection
    public final boolean remove(Object obj) {
        return g(a(obj));
    }

    @Override // java.util.Set, java.util.Collection, j$.util.Set, j$.util.Collection
    public boolean removeAll(Collection<?> collection) {
        java.util.Iterator<?> it = collection.iterator();
        boolean zG = false;
        while (it.hasNext()) {
            zG |= g(a(it.next()));
        }
        return zG;
    }

    @Override // j$.util.Collection
    public /* synthetic */ boolean removeIf(Predicate predicate) {
        return Collection.CC.$default$removeIf(this, predicate);
    }

    @Override // java.util.Set, java.util.Collection, j$.util.Set, j$.util.Collection
    public boolean retainAll(java.util.Collection<?> collection) {
        int i2 = 0;
        for (T[] tArr : this.f8495b) {
            if (tArr != null) {
                int i3 = 0;
                int i4 = 0;
                while (i3 < tArr.length && tArr[i3] != null) {
                    if (collection.contains(tArr[i3])) {
                        if (i3 != i4) {
                            tArr[i4] = tArr[i3];
                        }
                        i4++;
                        i2++;
                    }
                    i3++;
                }
                i2 += i4;
                while (i4 < i3) {
                    tArr[i4] = null;
                    i4++;
                }
            }
        }
        boolean z = i2 != this.f8496c;
        this.f8496c = i2;
        return z;
    }

    @Override // java.util.Set, java.util.Collection, j$.util.Set, j$.util.Collection
    public final int size() {
        return this.f8496c;
    }

    @Override // java.util.Set, java.util.Collection, java.lang.Iterable, j$.util.Set, j$.util.Collection, j$.lang.Iterable
    public /* synthetic */ Spliterator spliterator() {
        return Set.CC.$default$spliterator(this);
    }

    @Override // java.util.Collection, j$.util.Collection
    public /* synthetic */ Stream stream() {
        return Q1.v(j$.time.a.A(this), false);
    }

    @Override // java.util.Set, java.util.Collection, j$.util.Set, j$.util.Collection
    public T[] toArray() {
        T[] tArrC = c(this.f8496c);
        int i2 = 0;
        for (T[] tArr : this.f8495b) {
            if (tArr != null) {
                int length = tArr.length;
                int i3 = 0;
                while (i3 < length) {
                    T t = tArr[i3];
                    if (t == null) {
                        break;
                    }
                    tArrC[i2] = t;
                    i3++;
                    i2++;
                }
            }
        }
        return tArrC;
    }

    public String toString() {
        if (this.f8496c == 0) {
            return MessageFormatter.DELIM_STR;
        }
        StringBuilder sbQ = c.a.a.a.a.q(MessageFormatter.DELIM_START);
        boolean z = true;
        for (T[] tArr : this.f8495b) {
            if (tArr != null) {
                for (T t : tArr) {
                    if (t == null) {
                        break;
                    }
                    if (z) {
                        z = false;
                    } else {
                        sbQ.append(", ");
                    }
                    sbQ.append(t.toString());
                }
            }
        }
        sbQ.append(MessageFormatter.DELIM_STOP);
        return sbQ.toString();
    }

    public b(k.a.a.a.m0.a<? super T> aVar, int i2, int i3) {
        this.f8496c = 0;
        this.f8497d = (int) Math.floor(12.0d);
        this.f8498e = 1;
        this.f8499f = 8;
        this.a = aVar == null ? j.a : aVar;
        this.f8495b = d(i2);
        this.f8499f = i3;
    }

    @Override // java.util.Set, java.util.Collection, j$.util.Set, j$.util.Collection
    public <U> U[] toArray(U[] uArr) {
        int length = uArr.length;
        int i2 = this.f8496c;
        if (length < i2) {
            uArr = (U[]) Arrays.copyOf(uArr, i2);
        }
        int i3 = 0;
        for (T[] tArr : this.f8495b) {
            if (tArr != null) {
                int length2 = tArr.length;
                int i4 = 0;
                while (i4 < length2) {
                    T t = tArr[i4];
                    if (t == null) {
                        break;
                    }
                    uArr[i3] = t;
                    i4++;
                    i3++;
                }
            }
        }
        return uArr;
    }
}

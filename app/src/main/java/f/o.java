package f;

import j$.lang.Iterable;
import j$.util.Collection;
import j$.util.Spliterator;
import j$.util.function.Consumer;
import j$.util.function.Predicate;
import j$.util.stream.Q1;
import j$.util.stream.Stream;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import kotlin.ExperimentalUnsignedTypes;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.jvm.JvmInline;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: UIntArray.kt */
/* JADX INFO: loaded from: classes3.dex */
@SinceKotlin(version = "1.3")
@ExperimentalUnsignedTypes
@JvmInline
public final class o implements Collection<n>, f.c0.c.z.a, j$.util.Collection {

    @NotNull
    public final int[] a;

    /* JADX INFO: compiled from: UIntArray.kt */
    public static final class a extends f.x.o {
        public int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int[] f6157b;

        public a(@NotNull int[] iArr) {
            f.c0.c.j.e(iArr, "array");
            this.f6157b = iArr;
        }

        @Override // java.util.Iterator, j$.util.Iterator
        public boolean hasNext() {
            return this.a < this.f6157b.length;
        }
    }

    @PublishedApi
    public /* synthetic */ o(int[] iArr) {
        f.c0.c.j.e(iArr, "storage");
        this.a = iArr;
    }

    @Override // java.util.Collection, j$.util.Collection, java.util.Set, j$.util.Set
    public /* synthetic */ boolean add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection, j$.util.Collection, java.util.Set, j$.util.Set
    public boolean addAll(Collection<? extends n> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection, j$.util.Collection, java.util.Set, j$.util.Set
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection, j$.util.Collection, java.util.Set, j$.util.Set
    public final boolean contains(Object obj) {
        if (!(obj instanceof n)) {
            return false;
        }
        return c.b.a.m.f.Z0(this.a, ((n) obj).a);
    }

    @Override // java.util.Collection, j$.util.Collection, java.util.Set, j$.util.Set
    public boolean containsAll(@NotNull Collection<? extends Object> collection) {
        int[] iArr = this.a;
        f.c0.c.j.e(collection, "elements");
        if (collection.isEmpty()) {
            return true;
        }
        for (Object obj : collection) {
            if (!((obj instanceof n) && c.b.a.m.f.Z0(iArr, ((n) obj).a))) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Collection, j$.util.Collection, java.util.Set, j$.util.Set
    public boolean equals(Object obj) {
        return (obj instanceof o) && f.c0.c.j.a(this.a, ((o) obj).a);
    }

    @Override // j$.util.Collection, j$.lang.Iterable
    public /* synthetic */ void forEach(Consumer consumer) {
        Iterable.CC.$default$forEach(this, consumer);
    }

    @Override // java.util.Collection, j$.util.Collection, java.util.Set, j$.util.Set
    public int hashCode() {
        int[] iArr = this.a;
        if (iArr != null) {
            return Arrays.hashCode(iArr);
        }
        return 0;
    }

    @Override // java.util.Collection, j$.util.Collection, java.util.Set, j$.util.Set
    public boolean isEmpty() {
        return this.a.length == 0;
    }

    @Override // java.util.Collection, java.lang.Iterable, j$.util.Collection, java.util.Set, j$.lang.Iterable
    @NotNull
    public Iterator<n> iterator() {
        return new a(this.a);
    }

    @Override // java.util.Collection, j$.util.Collection
    public /* synthetic */ Stream parallelStream() {
        return Q1.v(j$.time.a.A(this), true);
    }

    @Override // java.util.Collection, j$.util.Collection, java.util.Set, j$.util.Set
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection, j$.util.Collection, java.util.Set, j$.util.Set
    public boolean removeAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // j$.util.Collection
    public /* synthetic */ boolean removeIf(Predicate predicate) {
        return Collection.CC.$default$removeIf(this, predicate);
    }

    @Override // java.util.Collection, j$.util.Collection, java.util.Set, j$.util.Set
    public boolean retainAll(java.util.Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection, j$.util.Collection, java.util.Set, j$.util.Set
    public final int size() {
        return this.a.length;
    }

    @Override // java.util.Collection, java.lang.Iterable, j$.util.Collection, java.util.Set, j$.lang.Iterable
    public /* synthetic */ Spliterator spliterator() {
        return Collection.CC.$default$spliterator(this);
    }

    @Override // java.util.Collection, j$.util.Collection
    public /* synthetic */ Stream stream() {
        return Q1.v(j$.time.a.A(this), false);
    }

    @Override // java.util.Collection, j$.util.Collection, java.util.Set, j$.util.Set
    public Object[] toArray() {
        return f.c0.c.e.a(this);
    }

    @Override // java.util.Collection, j$.util.Collection, java.util.Set, j$.util.Set
    public <T> T[] toArray(T[] tArr) {
        return (T[]) f.c0.c.e.b(this, tArr);
    }

    public String toString() {
        int[] iArr = this.a;
        StringBuilder sbR = c.a.a.a.a.r("UIntArray(storage=");
        sbR.append(Arrays.toString(iArr));
        sbR.append(")");
        return sbR.toString();
    }
}

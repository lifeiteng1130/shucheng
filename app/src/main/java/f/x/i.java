package f.x;

import j$.lang.Iterable;
import j$.util.Collection;
import j$.util.List;
import j$.util.Spliterator;
import j$.util.function.Consumer;
import j$.util.function.Predicate;
import j$.util.function.UnaryOperator;
import j$.util.stream.Q1;
import j$.util.stream.Stream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import okhttp3.HttpUrl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Collections.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class i implements List, Serializable, RandomAccess, f.c0.c.z.a, j$.util.List {

    @NotNull
    public static final i INSTANCE = new i();
    private static final long serialVersionUID = -7390468764508069838L;

    private final Object readResolve() {
        return INSTANCE;
    }

    @Override // java.util.List, j$.util.List
    public /* synthetic */ void add(int i2, Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void add(int i2, Void r2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection, j$.util.List, j$.util.Collection, java.util.Set, j$.util.Set
    public /* synthetic */ boolean add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean add(Void r2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, j$.util.List
    public boolean addAll(int i2, Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection, j$.util.List, j$.util.Collection, java.util.Set, j$.util.Set
    public boolean addAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection, j$.util.List, j$.util.Collection, java.util.Set, j$.util.Set
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection, j$.util.List, j$.util.Collection, java.util.Set, j$.util.Set
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof Void) {
            return contains((Void) obj);
        }
        return false;
    }

    public boolean contains(@NotNull Void r2) {
        f.c0.c.j.e(r2, "element");
        return false;
    }

    @Override // java.util.List, java.util.Collection, j$.util.List, j$.util.Collection, java.util.Set, j$.util.Set
    public boolean containsAll(@NotNull Collection collection) {
        f.c0.c.j.e(collection, "elements");
        return collection.isEmpty();
    }

    @Override // java.util.List, java.util.Collection, j$.util.List, j$.util.Collection, java.util.Set, j$.util.Set
    public boolean equals(@Nullable Object obj) {
        return (obj instanceof List) && ((List) obj).isEmpty();
    }

    @Override // j$.util.Collection, j$.lang.Iterable
    public /* synthetic */ void forEach(Consumer consumer) {
        Iterable.CC.$default$forEach(this, consumer);
    }

    public int getSize() {
        return 0;
    }

    @Override // java.util.List, java.util.Collection, j$.util.List, j$.util.Collection, java.util.Set, j$.util.Set
    public int hashCode() {
        return 1;
    }

    @Override // java.util.List, j$.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof Void) {
            return indexOf((Void) obj);
        }
        return -1;
    }

    public int indexOf(@NotNull Void r2) {
        f.c0.c.j.e(r2, "element");
        return -1;
    }

    @Override // java.util.List, java.util.Collection, j$.util.List, j$.util.Collection, java.util.Set, j$.util.Set
    public boolean isEmpty() {
        return true;
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable, j$.util.List, j$.util.Collection, java.util.Set, j$.lang.Iterable
    @NotNull
    public Iterator iterator() {
        return h.a;
    }

    @Override // java.util.List, j$.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof Void) {
            return lastIndexOf((Void) obj);
        }
        return -1;
    }

    public int lastIndexOf(@NotNull Void r2) {
        f.c0.c.j.e(r2, "element");
        return -1;
    }

    @Override // java.util.List, j$.util.List
    @NotNull
    public ListIterator listIterator() {
        return h.a;
    }

    @Override // java.util.Collection, j$.util.Collection
    public /* synthetic */ Stream parallelStream() {
        return Q1.v(j$.time.a.A(this), true);
    }

    @Override // java.util.List, j$.util.List
    public /* synthetic */ Object remove(int i2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, j$.util.List
    public Void remove(int i2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection, j$.util.List, j$.util.Collection, java.util.Set, j$.util.Set
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection, j$.util.List, j$.util.Collection, java.util.Set, j$.util.Set
    public boolean removeAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // j$.util.Collection
    public /* synthetic */ boolean removeIf(Predicate predicate) {
        return Collection.CC.$default$removeIf(this, predicate);
    }

    @Override // j$.util.List
    public /* synthetic */ void replaceAll(UnaryOperator unaryOperator) {
        List.CC.$default$replaceAll(this, unaryOperator);
    }

    @Override // java.util.List, java.util.Collection, j$.util.List, j$.util.Collection, java.util.Set, j$.util.Set
    public boolean retainAll(java.util.Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, j$.util.List
    public /* synthetic */ Object set(int i2, Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public Void set(int i2, Void r2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection, j$.util.List, j$.util.Collection, java.util.Set, j$.util.Set
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.List, j$.util.List
    public /* synthetic */ void sort(Comparator comparator) {
        List.CC.$default$sort(this, comparator);
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable, j$.util.List, j$.util.Collection, java.util.Set, j$.lang.Iterable
    public /* synthetic */ Spliterator spliterator() {
        return List.CC.$default$spliterator(this);
    }

    @Override // java.util.Collection, j$.util.Collection
    public /* synthetic */ Stream stream() {
        return Q1.v(j$.time.a.A(this), false);
    }

    @Override // java.util.List, j$.util.List
    @NotNull
    public java.util.List subList(int i2, int i3) {
        if (i2 == 0 && i3 == 0) {
            return this;
        }
        throw new IndexOutOfBoundsException(c.a.a.a.a.e("fromIndex: ", i2, ", toIndex: ", i3));
    }

    @Override // java.util.List, java.util.Collection, j$.util.List, j$.util.Collection, java.util.Set, j$.util.Set
    public Object[] toArray() {
        return f.c0.c.e.a(this);
    }

    @Override // java.util.List, java.util.Collection, j$.util.List, j$.util.Collection, java.util.Set, j$.util.Set
    public <T> T[] toArray(T[] tArr) {
        return (T[]) f.c0.c.e.b(this, tArr);
    }

    @NotNull
    public String toString() {
        return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
    }

    @Override // java.util.List, j$.util.List
    @NotNull
    public Void get(int i2) {
        throw new IndexOutOfBoundsException("Empty list doesn't contain element at index " + i2 + '.');
    }

    @Override // java.util.List, j$.util.List
    @NotNull
    public ListIterator listIterator(int i2) {
        if (i2 == 0) {
            return h.a;
        }
        throw new IndexOutOfBoundsException(c.a.a.a.a.G("Index: ", i2));
    }
}

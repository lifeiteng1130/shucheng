package f.x;

import com.umeng.analytics.pro.ai;
import j$.util.Iterator;
import j$.util.List;
import j$.util.Spliterator;
import j$.util.function.Consumer;
import j$.util.function.UnaryOperator;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.RandomAccess;
import kotlin.SinceKotlin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AbstractList.kt */
/* JADX INFO: loaded from: classes3.dex */
@SinceKotlin(version = "1.1")
public abstract class b<E> extends f.x.a<E> implements List<E>, f.c0.c.z.a, j$.util.List {

    @NotNull
    public static final a Companion = new a(null);

    /* JADX INFO: compiled from: AbstractList.kt */
    public static final class a {
        public a(f.c0.c.f fVar) {
        }
    }

    /* JADX INFO: renamed from: f.x.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AbstractList.kt */
    public class C0179b implements Iterator<E>, f.c0.c.z.a, j$.util.Iterator {
        public int a;

        public C0179b() {
        }

        @Override // j$.util.Iterator
        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            Iterator.CC.$default$forEachRemaining(this, consumer);
        }

        @Override // java.util.Iterator, j$.util.Iterator
        public boolean hasNext() {
            return this.a < b.this.size();
        }

        @Override // java.util.Iterator, j$.util.Iterator
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            b bVar = b.this;
            int i2 = this.a;
            this.a = i2 + 1;
            return (E) bVar.get(i2);
        }

        @Override // java.util.Iterator, j$.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX INFO: compiled from: AbstractList.kt */
    public class c extends b<E>.C0179b implements ListIterator<E>, f.c0.c.z.a, j$.util.Iterator {
        public c(int i2) {
            super();
            a aVar = b.Companion;
            int size = b.this.size();
            Objects.requireNonNull(aVar);
            if (i2 < 0 || i2 > size) {
                throw new IndexOutOfBoundsException(c.a.a.a.a.e("index: ", i2, ", size: ", size));
            }
            this.a = i2;
        }

        @Override // java.util.ListIterator
        public void add(E e2) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.a > 0;
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.a;
        }

        @Override // java.util.ListIterator
        public E previous() {
            if (!hasPrevious()) {
                throw new NoSuchElementException();
            }
            b bVar = b.this;
            int i2 = this.a - 1;
            this.a = i2;
            return (E) bVar.get(i2);
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.a - 1;
        }

        @Override // java.util.ListIterator
        public void set(E e2) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX INFO: compiled from: AbstractList.kt */
    public static final class d<E> extends b<E> implements RandomAccess {
        public int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final b<E> f6162b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f6163c;

        /* JADX WARN: Multi-variable type inference failed */
        public d(@NotNull b<? extends E> bVar, int i2, int i3) {
            f.c0.c.j.e(bVar, "list");
            this.f6162b = bVar;
            this.f6163c = i2;
            a aVar = b.Companion;
            int size = bVar.size();
            Objects.requireNonNull(aVar);
            if (i2 >= 0 && i3 <= size) {
                if (i2 > i3) {
                    throw new IllegalArgumentException(c.a.a.a.a.e("fromIndex: ", i2, " > toIndex: ", i3));
                }
                this.a = i3 - i2;
                return;
            }
            throw new IndexOutOfBoundsException("fromIndex: " + i2 + ", toIndex: " + i3 + ", size: " + size);
        }

        @Override // f.x.b, java.util.List, j$.util.List
        public E get(int i2) {
            a aVar = b.Companion;
            int i3 = this.a;
            Objects.requireNonNull(aVar);
            if (i2 < 0 || i2 >= i3) {
                throw new IndexOutOfBoundsException(c.a.a.a.a.e("index: ", i2, ", size: ", i3));
            }
            return this.f6162b.get(this.f6163c + i2);
        }

        @Override // f.x.b, f.x.a
        public int getSize() {
            return this.a;
        }
    }

    @Override // java.util.List, j$.util.List
    public void add(int i2, E e2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, j$.util.List
    public boolean addAll(int i2, Collection<? extends E> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection, j$.util.Collection, java.util.Set, j$.util.Set
    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        Collection collection = (Collection) obj;
        Objects.requireNonNull(Companion);
        f.c0.c.j.e(this, ai.aD);
        f.c0.c.j.e(collection, "other");
        if (size() == collection.size()) {
            java.util.Iterator<E> it = collection.iterator();
            java.util.Iterator<E> it2 = iterator();
            while (it2.hasNext()) {
                if (!f.c0.c.j.a(it2.next(), it.next())) {
                }
            }
            return true;
        }
        return false;
    }

    public abstract E get(int i2);

    @Override // f.x.a
    public abstract int getSize();

    @Override // java.util.Collection, j$.util.Collection, java.util.Set, j$.util.Set
    public int hashCode() {
        Objects.requireNonNull(Companion);
        f.c0.c.j.e(this, ai.aD);
        java.util.Iterator<E> it = iterator();
        int iHashCode = 1;
        while (it.hasNext()) {
            E next = it.next();
            iHashCode = (iHashCode * 31) + (next != null ? next.hashCode() : 0);
        }
        return iHashCode;
    }

    public int indexOf(Object obj) {
        java.util.Iterator<E> it = iterator();
        int i2 = 0;
        while (it.hasNext()) {
            if (f.c0.c.j.a(it.next(), obj)) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    @Override // f.x.a, java.util.Collection, java.lang.Iterable, j$.util.Collection, java.util.Set, j$.lang.Iterable
    @NotNull
    public java.util.Iterator<E> iterator() {
        return new C0179b();
    }

    public int lastIndexOf(Object obj) {
        ListIterator<E> listIterator = listIterator(size());
        while (listIterator.hasPrevious()) {
            if (f.c0.c.j.a(listIterator.previous(), obj)) {
                return listIterator.nextIndex();
            }
        }
        return -1;
    }

    @Override // java.util.List, j$.util.List
    @NotNull
    public ListIterator<E> listIterator() {
        return new c(0);
    }

    @Override // java.util.List, j$.util.List
    public E remove(int i2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // j$.util.List
    public /* synthetic */ void replaceAll(UnaryOperator unaryOperator) {
        List.CC.$default$replaceAll(this, unaryOperator);
    }

    @Override // java.util.List, j$.util.List
    public E set(int i2, E e2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, j$.util.List
    public /* synthetic */ void sort(Comparator comparator) {
        List.CC.$default$sort(this, comparator);
    }

    @Override // f.x.a, java.util.Collection, java.lang.Iterable, j$.util.Collection, java.util.Set, j$.lang.Iterable
    public /* synthetic */ Spliterator spliterator() {
        return List.CC.$default$spliterator(this);
    }

    @Override // java.util.List, j$.util.List
    @NotNull
    public java.util.List<E> subList(int i2, int i3) {
        return new d(this, i2, i3);
    }

    @Override // java.util.List, j$.util.List
    @NotNull
    public ListIterator<E> listIterator(int i2) {
        return new c(i2);
    }
}

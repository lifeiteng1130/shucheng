package j$.util;

import j$.util.v;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public interface Set<E> extends Collection<E> {

    /* JADX INFO: renamed from: j$.util.Set$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static Spliterator $default$spliterator(java.util.Set set) {
            Objects.requireNonNull(set);
            return new v.i(set, 1);
        }
    }

    @Override // j$.util.Collection, j$.util.Set
    boolean add(Object obj);

    @Override // j$.util.Collection, j$.util.Set
    boolean addAll(java.util.Collection collection);

    @Override // j$.util.Collection, j$.util.Set
    void clear();

    @Override // j$.util.Collection, j$.util.Set
    boolean contains(Object obj);

    @Override // j$.util.Collection, j$.util.Set
    boolean containsAll(java.util.Collection collection);

    @Override // j$.util.Collection, j$.util.Set
    boolean equals(Object obj);

    @Override // j$.util.Collection, j$.util.Set
    int hashCode();

    @Override // j$.util.Collection, j$.util.Set
    boolean isEmpty();

    @Override // java.util.Collection, java.lang.Iterable, j$.util.Set, j$.util.Collection, j$.lang.Iterable
    java.util.Iterator iterator();

    @Override // j$.util.Collection, j$.util.Set
    boolean remove(Object obj);

    @Override // j$.util.Collection, j$.util.Set
    boolean removeAll(java.util.Collection collection);

    @Override // j$.util.Collection, j$.util.Set
    boolean retainAll(java.util.Collection collection);

    @Override // j$.util.Collection, j$.util.Set
    int size();

    @Override // java.util.Collection, java.lang.Iterable, j$.util.Set, j$.util.Collection, j$.lang.Iterable
    Spliterator spliterator();

    @Override // j$.util.Collection, j$.util.Set
    Object[] toArray();

    @Override // j$.util.Collection, j$.util.Set
    Object[] toArray(Object[] objArr);
}

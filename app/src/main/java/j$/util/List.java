package j$.util;

import j$.util.function.UnaryOperator;
import j$.util.v;
import java.util.Arrays;
import java.util.ListIterator;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public interface List<E> extends Collection<E> {

    /* JADX INFO: renamed from: j$.util.List$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        /* JADX WARN: Multi-variable type inference failed */
        public static void $default$replaceAll(java.util.List list, UnaryOperator unaryOperator) {
            if (DesugarCollections.f7915b.isInstance(list)) {
                DesugarCollections.e(list, unaryOperator);
                return;
            }
            Objects.requireNonNull(unaryOperator);
            ListIterator listIterator = list.listIterator();
            while (listIterator.hasNext()) {
                listIterator.set(unaryOperator.apply(listIterator.next()));
            }
        }

        public static void $default$sort(java.util.List list, java.util.Comparator comparator) {
            if (DesugarCollections.f7915b.isInstance(list)) {
                DesugarCollections.f(list, comparator);
                return;
            }
            Object[] array = list.toArray();
            Arrays.sort(array, comparator);
            ListIterator<E> listIterator = list.listIterator();
            for (Object obj : array) {
                listIterator.next();
                listIterator.set(obj);
            }
        }

        public static Spliterator $default$spliterator(java.util.List list) {
            Objects.requireNonNull(list);
            return new v.i(list, 16);
        }
    }

    /* JADX INFO: renamed from: j$.util.List$-EL, reason: invalid class name */
    public final /* synthetic */ class EL {
        public static /* synthetic */ void sort(java.util.List list, java.util.Comparator comparator) {
            if (list instanceof List) {
                ((List) list).sort(comparator);
            } else {
                CC.$default$sort(list, comparator);
            }
        }
    }

    void add(int i2, Object obj);

    @Override // java.util.Collection, j$.util.List, j$.util.Collection, java.util.Set, j$.util.Set
    boolean add(Object obj);

    boolean addAll(int i2, java.util.Collection collection);

    @Override // java.util.Collection, j$.util.List, j$.util.Collection, java.util.Set, j$.util.Set
    boolean addAll(java.util.Collection collection);

    @Override // java.util.Collection, j$.util.List, j$.util.Collection, java.util.Set, j$.util.Set
    void clear();

    @Override // java.util.Collection, j$.util.List, j$.util.Collection, java.util.Set, j$.util.Set
    boolean contains(Object obj);

    @Override // java.util.Collection, j$.util.List, j$.util.Collection, java.util.Set, j$.util.Set
    boolean containsAll(java.util.Collection collection);

    @Override // java.util.Collection, j$.util.List, j$.util.Collection, java.util.Set, j$.util.Set
    boolean equals(Object obj);

    Object get(int i2);

    @Override // java.util.Collection, j$.util.List, j$.util.Collection, java.util.Set, j$.util.Set
    int hashCode();

    int indexOf(Object obj);

    @Override // java.util.Collection, j$.util.List, j$.util.Collection, java.util.Set, j$.util.Set
    boolean isEmpty();

    @Override // java.util.Collection, java.lang.Iterable, j$.util.List, j$.util.Collection, java.util.Set, j$.lang.Iterable
    java.util.Iterator iterator();

    int lastIndexOf(Object obj);

    ListIterator listIterator();

    ListIterator listIterator(int i2);

    Object remove(int i2);

    @Override // java.util.Collection, j$.util.List, j$.util.Collection, java.util.Set, j$.util.Set
    boolean remove(Object obj);

    @Override // java.util.Collection, j$.util.List, j$.util.Collection, java.util.Set, j$.util.Set
    boolean removeAll(java.util.Collection collection);

    void replaceAll(UnaryOperator unaryOperator);

    @Override // java.util.Collection, j$.util.List, j$.util.Collection, java.util.Set, j$.util.Set
    boolean retainAll(java.util.Collection collection);

    Object set(int i2, Object obj);

    @Override // java.util.Collection, j$.util.List, j$.util.Collection, java.util.Set, j$.util.Set
    int size();

    void sort(java.util.Comparator comparator);

    @Override // java.util.Collection, java.lang.Iterable, java.util.List, j$.util.List, j$.util.Collection, java.util.Set, j$.lang.Iterable
    Spliterator spliterator();

    java.util.List subList(int i2, int i3);

    @Override // java.util.Collection, j$.util.List, j$.util.Collection, java.util.Set, j$.util.Set
    Object[] toArray();

    @Override // java.util.Collection, j$.util.List, j$.util.Collection, java.util.Set, j$.util.Set
    Object[] toArray(Object[] objArr);
}

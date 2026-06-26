package j$.util;

import j$.lang.Iterable;
import j$.util.function.Consumer;
import j$.util.function.Predicate;
import j$.util.function.z;
import j$.util.stream.Stream;
import j$.util.v;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public interface Collection<E> extends Iterable<E> {

    /* JADX INFO: renamed from: j$.util.Collection$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static boolean $default$removeIf(java.util.Collection collection, Predicate predicate) {
            if (DesugarCollections.a.isInstance(collection)) {
                return DesugarCollections.d(collection, predicate);
            }
            Objects.requireNonNull(predicate);
            boolean z = false;
            java.util.Iterator<E> it = collection.iterator();
            while (it.hasNext()) {
                if (predicate.test(it.next())) {
                    it.remove();
                    z = true;
                }
            }
            return z;
        }

        public static Spliterator $default$spliterator(java.util.Collection collection) {
            Objects.requireNonNull(collection);
            return new v.i(collection, 0);
        }
    }

    boolean add(Object obj);

    boolean addAll(java.util.Collection collection);

    void clear();

    boolean contains(Object obj);

    boolean containsAll(java.util.Collection collection);

    boolean equals(Object obj);

    void forEach(Consumer consumer);

    int hashCode();

    boolean isEmpty();

    java.util.Iterator iterator();

    Stream parallelStream();

    boolean remove(Object obj);

    boolean removeAll(java.util.Collection collection);

    boolean removeIf(Predicate predicate);

    boolean retainAll(java.util.Collection collection);

    int size();

    Spliterator spliterator();

    Stream stream();

    Object[] toArray();

    Object[] toArray(z zVar);

    Object[] toArray(Object[] objArr);
}

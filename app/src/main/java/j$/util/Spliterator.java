package j$.util;

import j$.util.function.Consumer;
import j$.util.function.E;
import j$.util.function.y;

/* JADX INFO: loaded from: classes2.dex */
public interface Spliterator<T> {

    public interface a extends d<Double, j$.util.function.s, a> {
        @Override // j$.util.Spliterator
        boolean b(Consumer consumer);

        void e(j$.util.function.s sVar);

        @Override // j$.util.Spliterator
        void forEachRemaining(Consumer consumer);

        boolean n(j$.util.function.s sVar);

        @Override // j$.util.Spliterator.d, j$.util.Spliterator
        a trySplit();
    }

    public interface b extends d<Integer, y, b> {
        @Override // j$.util.Spliterator
        boolean b(Consumer consumer);

        void c(y yVar);

        @Override // j$.util.Spliterator
        void forEachRemaining(Consumer consumer);

        boolean g(y yVar);

        @Override // j$.util.Spliterator.d, j$.util.Spliterator
        b trySplit();
    }

    public interface c extends d<Long, E, c> {
        @Override // j$.util.Spliterator
        boolean b(Consumer consumer);

        void d(E e2);

        @Override // j$.util.Spliterator
        void forEachRemaining(Consumer consumer);

        boolean i(E e2);

        @Override // j$.util.Spliterator.d, j$.util.Spliterator
        c trySplit();
    }

    public interface d<T, T_CONS, T_SPLITR extends d<T, T_CONS, T_SPLITR>> extends Spliterator<T> {
        void forEachRemaining(Object obj);

        boolean tryAdvance(Object obj);

        @Override // j$.util.Spliterator
        d trySplit();
    }

    boolean b(Consumer consumer);

    int characteristics();

    long estimateSize();

    void forEachRemaining(Consumer consumer);

    java.util.Comparator getComparator();

    long getExactSizeIfKnown();

    boolean hasCharacteristics(int i2);

    Spliterator trySplit();
}

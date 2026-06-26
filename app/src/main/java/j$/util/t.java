package j$.util;

import j$.util.function.Consumer;
import j$.util.function.E;
import j$.util.function.y;

/* JADX INFO: loaded from: classes2.dex */
public interface t<T, T_CONS> extends java.util.Iterator<T>, Iterator {

    public interface a extends t<Double, j$.util.function.s> {
        void e(j$.util.function.s sVar);

        void forEachRemaining(Consumer consumer);

        @Override // java.util.Iterator, j$.util.Iterator
        Double next();

        double nextDouble();
    }

    public interface b extends t<Integer, y> {
        void c(y yVar);

        void forEachRemaining(Consumer consumer);

        @Override // java.util.Iterator, j$.util.Iterator
        Integer next();

        int nextInt();
    }

    public interface c extends t<Long, E> {
        void d(E e2);

        void forEachRemaining(Consumer consumer);

        @Override // java.util.Iterator, j$.util.Iterator
        Long next();

        long nextLong();
    }

    void forEachRemaining(Object obj);
}

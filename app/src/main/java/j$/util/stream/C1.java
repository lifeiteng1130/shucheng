package j$.util.stream;

import j$.util.Spliterator;
import j$.util.function.BiConsumer;
import j$.util.function.Supplier;
import j$.util.t;

/* JADX INFO: loaded from: classes2.dex */
public interface C1 extends InterfaceC0444l1<Integer, C1> {
    void E(j$.util.function.y yVar);

    Stream F(j$.util.function.z zVar);

    int K(int i2, j$.util.function.x xVar);

    boolean L(j$.util.function.A a);

    C1 M(j$.util.function.z zVar);

    void Q(j$.util.function.y yVar);

    boolean R(j$.util.function.A a);

    C1 X(j$.util.function.A a);

    j$.util.q Z(j$.util.function.x xVar);

    C1 a0(j$.util.function.y yVar);

    InterfaceC0471s1 asDoubleStream();

    H1 asLongStream();

    j$.util.p average();

    boolean b(j$.util.function.A a);

    Stream boxed();

    long count();

    C1 distinct();

    j$.util.q findAny();

    j$.util.q findFirst();

    H1 h(j$.util.function.B b2);

    InterfaceC0471s1 i0(j$.W w);

    @Override // j$.util.stream.InterfaceC0444l1
    t.b iterator();

    Object j0(Supplier supplier, j$.util.function.J j2, BiConsumer biConsumer);

    C1 limit(long j2);

    j$.util.q max();

    j$.util.q min();

    @Override // j$.util.stream.InterfaceC0444l1
    C1 parallel();

    @Override // j$.util.stream.InterfaceC0444l1
    C1 sequential();

    C1 skip(long j2);

    C1 sorted();

    @Override // j$.util.stream.InterfaceC0444l1
    Spliterator.b spliterator();

    int sum();

    j$.util.m summaryStatistics();

    int[] toArray();

    C1 y(j$.util.function.C c2);
}

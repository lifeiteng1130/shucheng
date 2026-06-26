package j$.util.stream;

import j$.util.Spliterator;
import j$.util.function.BiConsumer;
import j$.util.function.Supplier;
import j$.util.t;

/* JADX INFO: renamed from: j$.util.stream.s1, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public interface InterfaceC0471s1 extends InterfaceC0444l1<Double, InterfaceC0471s1> {
    j$.util.p C(j$.util.function.r rVar);

    Object D(Supplier supplier, j$.util.function.I i2, BiConsumer biConsumer);

    double G(double d2, j$.util.function.r rVar);

    InterfaceC0471s1 H(j$.util.function.w wVar);

    Stream I(j$.util.function.t tVar);

    boolean J(j$.util.function.u uVar);

    boolean O(j$.util.function.u uVar);

    boolean W(j$.util.function.u uVar);

    j$.util.p average();

    Stream boxed();

    long count();

    InterfaceC0471s1 d(j$.util.function.s sVar);

    InterfaceC0471s1 distinct();

    j$.util.p findAny();

    j$.util.p findFirst();

    @Override // j$.util.stream.InterfaceC0444l1
    t.a iterator();

    void k0(j$.util.function.s sVar);

    void l(j$.util.function.s sVar);

    InterfaceC0471s1 limit(long j2);

    j$.util.p max();

    j$.util.p min();

    C1 o(j$.F f2);

    @Override // j$.util.stream.InterfaceC0444l1
    InterfaceC0471s1 parallel();

    @Override // j$.util.stream.InterfaceC0444l1
    InterfaceC0471s1 sequential();

    InterfaceC0471s1 skip(long j2);

    InterfaceC0471s1 sorted();

    @Override // j$.util.stream.InterfaceC0444l1
    Spliterator.a spliterator();

    double sum();

    j$.util.l summaryStatistics();

    InterfaceC0471s1 t(j$.util.function.u uVar);

    double[] toArray();

    InterfaceC0471s1 u(j$.util.function.t tVar);

    H1 v(j$.util.function.v vVar);
}

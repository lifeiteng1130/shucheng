package j$.util.stream;

import j$.C0371k0;
import j$.C0375m0;
import j$.util.Spliterator;
import j$.util.function.BiConsumer;
import j$.util.function.Supplier;
import j$.util.t;

/* JADX INFO: loaded from: classes2.dex */
public interface H1 extends InterfaceC0444l1<Long, H1> {
    long A(long j2, j$.util.function.D d2);

    Stream N(j$.util.function.F f2);

    void Y(j$.util.function.E e2);

    InterfaceC0471s1 asDoubleStream();

    j$.util.p average();

    boolean b0(j$.util.function.G g2);

    Stream boxed();

    boolean c(j$.util.function.G g2);

    long count();

    Object d0(Supplier supplier, j$.util.function.K k2, BiConsumer biConsumer);

    H1 distinct();

    void f(j$.util.function.E e2);

    boolean f0(j$.util.function.G g2);

    j$.util.r findAny();

    j$.util.r findFirst();

    H1 g0(j$.util.function.G g2);

    j$.util.r i(j$.util.function.D d2);

    @Override // j$.util.stream.InterfaceC0444l1
    t.c iterator();

    InterfaceC0471s1 j(C0371k0 c0371k0);

    H1 limit(long j2);

    j$.util.r max();

    j$.util.r min();

    @Override // j$.util.stream.InterfaceC0444l1
    H1 parallel();

    H1 q(j$.util.function.E e2);

    H1 r(j$.util.function.F f2);

    @Override // j$.util.stream.InterfaceC0444l1
    H1 sequential();

    H1 skip(long j2);

    H1 sorted();

    @Override // j$.util.stream.InterfaceC0444l1
    Spliterator.c spliterator();

    long sum();

    j$.util.n summaryStatistics();

    long[] toArray();

    C1 w(C0375m0 c0375m0);

    H1 x(j$.util.function.H h2);
}

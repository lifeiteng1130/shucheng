package j$;

import j$.util.Spliterator;
import j$.util.function.BiConsumer;
import j$.util.function.Supplier;
import j$.util.stream.C1;
import j$.util.stream.H1;
import j$.util.stream.InterfaceC0444l1;
import j$.util.stream.InterfaceC0471s1;
import j$.util.stream.Stream;
import j$.util.t;
import java.util.Iterator;
import java.util.stream.LongStream;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class N0 implements H1 {
    final /* synthetic */ LongStream a;

    private /* synthetic */ N0(LongStream longStream) {
        this.a = longStream;
    }

    public static /* synthetic */ H1 m0(LongStream longStream) {
        if (longStream == null) {
            return null;
        }
        return longStream instanceof O0 ? ((O0) longStream).a : new N0(longStream);
    }

    @Override // j$.util.stream.H1
    public /* synthetic */ long A(long j2, j$.util.function.D d2) {
        return this.a.reduce(j2, C0357d0.a(d2));
    }

    @Override // j$.util.stream.H1
    public /* synthetic */ Stream N(j$.util.function.F f2) {
        return P0.m0(this.a.mapToObj(C0365h0.a(f2)));
    }

    @Override // j$.util.stream.H1
    public /* synthetic */ void Y(j$.util.function.E e2) {
        this.a.forEachOrdered(C0361f0.a(e2));
    }

    @Override // j$.util.stream.H1
    public /* synthetic */ InterfaceC0471s1 asDoubleStream() {
        return J0.m0(this.a.asDoubleStream());
    }

    @Override // j$.util.stream.H1
    public /* synthetic */ j$.util.p average() {
        return j$.time.a.n(this.a.average());
    }

    @Override // j$.util.stream.H1
    public /* synthetic */ boolean b0(j$.util.function.G g2) {
        return this.a.anyMatch(C0369j0.a(g2));
    }

    @Override // j$.util.stream.H1
    public /* synthetic */ Stream boxed() {
        return P0.m0(this.a.boxed());
    }

    @Override // j$.util.stream.H1
    public /* synthetic */ boolean c(j$.util.function.G g2) {
        return this.a.noneMatch(C0369j0.a(g2));
    }

    @Override // j$.util.stream.InterfaceC0444l1, java.lang.AutoCloseable
    public /* synthetic */ void close() {
        this.a.close();
    }

    @Override // j$.util.stream.H1
    public /* synthetic */ long count() {
        return this.a.count();
    }

    @Override // j$.util.stream.H1
    public /* synthetic */ Object d0(Supplier supplier, j$.util.function.K k2, BiConsumer biConsumer) {
        return this.a.collect(C$r8$wrapper$java$util$function$Supplier$WRP.convert(supplier), v0.a(k2), C0384s.a(biConsumer));
    }

    @Override // j$.util.stream.H1
    public /* synthetic */ H1 distinct() {
        return m0(this.a.distinct());
    }

    @Override // j$.util.stream.H1
    public /* synthetic */ void f(j$.util.function.E e2) {
        this.a.forEach(C0361f0.a(e2));
    }

    @Override // j$.util.stream.H1
    public /* synthetic */ boolean f0(j$.util.function.G g2) {
        return this.a.allMatch(C0369j0.a(g2));
    }

    @Override // j$.util.stream.H1
    public /* synthetic */ j$.util.r findAny() {
        return j$.time.a.p(this.a.findAny());
    }

    @Override // j$.util.stream.H1
    public /* synthetic */ j$.util.r findFirst() {
        return j$.time.a.p(this.a.findFirst());
    }

    @Override // j$.util.stream.H1
    public /* synthetic */ H1 g0(j$.util.function.G g2) {
        return m0(this.a.filter(C0369j0.a(g2)));
    }

    @Override // j$.util.stream.H1
    public /* synthetic */ j$.util.r i(j$.util.function.D d2) {
        return j$.time.a.p(this.a.reduce(C0357d0.a(d2)));
    }

    @Override // j$.util.stream.InterfaceC0444l1
    public /* synthetic */ boolean isParallel() {
        return this.a.isParallel();
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.PrimitiveIterator$OfLong] */
    @Override // j$.util.stream.H1, j$.util.stream.InterfaceC0444l1
    public /* synthetic */ t.c iterator() {
        return C0360f.a(this.a.iterator());
    }

    @Override // j$.util.stream.InterfaceC0444l1
    public /* synthetic */ Iterator iterator() {
        return this.a.iterator();
    }

    @Override // j$.util.stream.H1
    public /* synthetic */ InterfaceC0471s1 j(C0371k0 c0371k0) {
        return J0.m0(this.a.mapToDouble(c0371k0 == null ? null : c0371k0.a));
    }

    @Override // j$.util.stream.H1
    public /* synthetic */ H1 limit(long j2) {
        return m0(this.a.limit(j2));
    }

    @Override // j$.util.stream.H1
    public /* synthetic */ j$.util.r max() {
        return j$.time.a.p(this.a.max());
    }

    @Override // j$.util.stream.H1
    public /* synthetic */ j$.util.r min() {
        return j$.time.a.p(this.a.min());
    }

    @Override // j$.util.stream.InterfaceC0444l1
    public /* synthetic */ InterfaceC0444l1 onClose(Runnable runnable) {
        return F0.m0(this.a.onClose(runnable));
    }

    @Override // j$.util.stream.H1, j$.util.stream.InterfaceC0444l1
    public /* synthetic */ H1 parallel() {
        return m0(this.a.parallel());
    }

    @Override // j$.util.stream.InterfaceC0444l1
    public /* synthetic */ InterfaceC0444l1 parallel() {
        return F0.m0(this.a.parallel());
    }

    @Override // j$.util.stream.H1
    public /* synthetic */ H1 q(j$.util.function.E e2) {
        return m0(this.a.peek(C0361f0.a(e2)));
    }

    @Override // j$.util.stream.H1
    public /* synthetic */ H1 r(j$.util.function.F f2) {
        return m0(this.a.flatMap(C0365h0.a(f2)));
    }

    @Override // j$.util.stream.H1, j$.util.stream.InterfaceC0444l1
    public /* synthetic */ H1 sequential() {
        return m0(this.a.sequential());
    }

    @Override // j$.util.stream.InterfaceC0444l1
    public /* synthetic */ InterfaceC0444l1 sequential() {
        return F0.m0(this.a.sequential());
    }

    @Override // j$.util.stream.H1
    public /* synthetic */ H1 skip(long j2) {
        return m0(this.a.skip(j2));
    }

    @Override // j$.util.stream.H1
    public /* synthetic */ H1 sorted() {
        return m0(this.a.sorted());
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.Spliterator$OfLong] */
    @Override // j$.util.stream.H1, j$.util.stream.InterfaceC0444l1
    public /* synthetic */ Spliterator.c spliterator() {
        return C0376n.a(this.a.spliterator());
    }

    @Override // j$.util.stream.InterfaceC0444l1
    public /* synthetic */ Spliterator spliterator() {
        return C0364h.a(this.a.spliterator());
    }

    @Override // j$.util.stream.H1
    public /* synthetic */ long sum() {
        return this.a.sum();
    }

    @Override // j$.util.stream.H1
    public j$.util.n summaryStatistics() {
        this.a.summaryStatistics();
        throw new Error("Java 8+ API desugaring (library desugaring) cannot convert from java.util.LongSummaryStatistics");
    }

    @Override // j$.util.stream.H1
    public /* synthetic */ long[] toArray() {
        return this.a.toArray();
    }

    @Override // j$.util.stream.InterfaceC0444l1
    public /* synthetic */ InterfaceC0444l1 unordered() {
        return F0.m0(this.a.unordered());
    }

    @Override // j$.util.stream.H1
    public /* synthetic */ C1 w(C0375m0 c0375m0) {
        return L0.m0(this.a.mapToInt(c0375m0 == null ? null : c0375m0.a));
    }

    @Override // j$.util.stream.H1
    public /* synthetic */ H1 x(j$.util.function.H h2) {
        return m0(this.a.map(C0381p0.a(h2)));
    }
}

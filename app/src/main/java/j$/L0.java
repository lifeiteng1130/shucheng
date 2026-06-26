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
import java.util.stream.IntStream;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class L0 implements C1 {
    final /* synthetic */ IntStream a;

    private /* synthetic */ L0(IntStream intStream) {
        this.a = intStream;
    }

    public static /* synthetic */ C1 m0(IntStream intStream) {
        if (intStream == null) {
            return null;
        }
        return intStream instanceof M0 ? ((M0) intStream).a : new L0(intStream);
    }

    @Override // j$.util.stream.C1
    public /* synthetic */ void E(j$.util.function.y yVar) {
        this.a.forEachOrdered(Q.a(yVar));
    }

    @Override // j$.util.stream.C1
    public /* synthetic */ Stream F(j$.util.function.z zVar) {
        return P0.m0(this.a.mapToObj(T.a(zVar)));
    }

    @Override // j$.util.stream.C1
    public /* synthetic */ int K(int i2, j$.util.function.x xVar) {
        return this.a.reduce(i2, O.a(xVar));
    }

    @Override // j$.util.stream.C1
    public /* synthetic */ boolean L(j$.util.function.A a) {
        return this.a.allMatch(V.a(a));
    }

    @Override // j$.util.stream.C1
    public /* synthetic */ C1 M(j$.util.function.z zVar) {
        return m0(this.a.flatMap(T.a(zVar)));
    }

    @Override // j$.util.stream.C1
    public /* synthetic */ void Q(j$.util.function.y yVar) {
        this.a.forEach(Q.a(yVar));
    }

    @Override // j$.util.stream.C1
    public /* synthetic */ boolean R(j$.util.function.A a) {
        return this.a.noneMatch(V.a(a));
    }

    @Override // j$.util.stream.C1
    public /* synthetic */ C1 X(j$.util.function.A a) {
        return m0(this.a.filter(V.a(a)));
    }

    @Override // j$.util.stream.C1
    public /* synthetic */ j$.util.q Z(j$.util.function.x xVar) {
        return j$.time.a.o(this.a.reduce(O.a(xVar)));
    }

    @Override // j$.util.stream.C1
    public /* synthetic */ C1 a0(j$.util.function.y yVar) {
        return m0(this.a.peek(Q.a(yVar)));
    }

    @Override // j$.util.stream.C1
    public /* synthetic */ InterfaceC0471s1 asDoubleStream() {
        return J0.m0(this.a.asDoubleStream());
    }

    @Override // j$.util.stream.C1
    public /* synthetic */ H1 asLongStream() {
        return N0.m0(this.a.asLongStream());
    }

    @Override // j$.util.stream.C1
    public /* synthetic */ j$.util.p average() {
        return j$.time.a.n(this.a.average());
    }

    @Override // j$.util.stream.C1
    public /* synthetic */ boolean b(j$.util.function.A a) {
        return this.a.anyMatch(V.a(a));
    }

    @Override // j$.util.stream.C1
    public /* synthetic */ Stream boxed() {
        return P0.m0(this.a.boxed());
    }

    @Override // j$.util.stream.InterfaceC0444l1, java.lang.AutoCloseable
    public /* synthetic */ void close() {
        this.a.close();
    }

    @Override // j$.util.stream.C1
    public /* synthetic */ long count() {
        return this.a.count();
    }

    @Override // j$.util.stream.C1
    public /* synthetic */ C1 distinct() {
        return m0(this.a.distinct());
    }

    @Override // j$.util.stream.C1
    public /* synthetic */ j$.util.q findAny() {
        return j$.time.a.o(this.a.findAny());
    }

    @Override // j$.util.stream.C1
    public /* synthetic */ j$.util.q findFirst() {
        return j$.time.a.o(this.a.findFirst());
    }

    @Override // j$.util.stream.C1
    public /* synthetic */ H1 h(j$.util.function.B b2) {
        return N0.m0(this.a.mapToLong(Z.a(b2)));
    }

    @Override // j$.util.stream.C1
    public /* synthetic */ InterfaceC0471s1 i0(W w) {
        return J0.m0(this.a.mapToDouble(w == null ? null : w.a));
    }

    @Override // j$.util.stream.InterfaceC0444l1
    public /* synthetic */ boolean isParallel() {
        return this.a.isParallel();
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.PrimitiveIterator$OfInt] */
    @Override // j$.util.stream.C1, j$.util.stream.InterfaceC0444l1
    public /* synthetic */ t.b iterator() {
        return C0356d.a(this.a.iterator());
    }

    @Override // j$.util.stream.InterfaceC0444l1
    public /* synthetic */ Iterator iterator() {
        return this.a.iterator();
    }

    @Override // j$.util.stream.C1
    public /* synthetic */ Object j0(Supplier supplier, j$.util.function.J j2, BiConsumer biConsumer) {
        return this.a.collect(C$r8$wrapper$java$util$function$Supplier$WRP.convert(supplier), t0.a(j2), C0384s.a(biConsumer));
    }

    @Override // j$.util.stream.C1
    public /* synthetic */ C1 limit(long j2) {
        return m0(this.a.limit(j2));
    }

    @Override // j$.util.stream.C1
    public /* synthetic */ j$.util.q max() {
        return j$.time.a.o(this.a.max());
    }

    @Override // j$.util.stream.C1
    public /* synthetic */ j$.util.q min() {
        return j$.time.a.o(this.a.min());
    }

    @Override // j$.util.stream.InterfaceC0444l1
    public /* synthetic */ InterfaceC0444l1 onClose(Runnable runnable) {
        return F0.m0(this.a.onClose(runnable));
    }

    @Override // j$.util.stream.C1, j$.util.stream.InterfaceC0444l1
    public /* synthetic */ C1 parallel() {
        return m0(this.a.parallel());
    }

    @Override // j$.util.stream.InterfaceC0444l1
    public /* synthetic */ InterfaceC0444l1 parallel() {
        return F0.m0(this.a.parallel());
    }

    @Override // j$.util.stream.C1, j$.util.stream.InterfaceC0444l1
    public /* synthetic */ C1 sequential() {
        return m0(this.a.sequential());
    }

    @Override // j$.util.stream.InterfaceC0444l1
    public /* synthetic */ InterfaceC0444l1 sequential() {
        return F0.m0(this.a.sequential());
    }

    @Override // j$.util.stream.C1
    public /* synthetic */ C1 skip(long j2) {
        return m0(this.a.skip(j2));
    }

    @Override // j$.util.stream.C1
    public /* synthetic */ C1 sorted() {
        return m0(this.a.sorted());
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.Spliterator$OfInt] */
    @Override // j$.util.stream.C1, j$.util.stream.InterfaceC0444l1
    public /* synthetic */ Spliterator.b spliterator() {
        return C0372l.a(this.a.spliterator());
    }

    @Override // j$.util.stream.InterfaceC0444l1
    public /* synthetic */ Spliterator spliterator() {
        return C0364h.a(this.a.spliterator());
    }

    @Override // j$.util.stream.C1
    public /* synthetic */ int sum() {
        return this.a.sum();
    }

    @Override // j$.util.stream.C1
    public j$.util.m summaryStatistics() {
        this.a.summaryStatistics();
        throw new Error("Java 8+ API desugaring (library desugaring) cannot convert from java.util.IntSummaryStatistics");
    }

    @Override // j$.util.stream.C1
    public /* synthetic */ int[] toArray() {
        return this.a.toArray();
    }

    @Override // j$.util.stream.InterfaceC0444l1
    public /* synthetic */ InterfaceC0444l1 unordered() {
        return F0.m0(this.a.unordered());
    }

    @Override // j$.util.stream.C1
    public /* synthetic */ C1 y(j$.util.function.C c2) {
        return m0(this.a.map(C0353b0.a(c2)));
    }
}

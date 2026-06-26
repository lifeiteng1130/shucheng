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
import java.util.stream.DoubleStream;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class J0 implements InterfaceC0471s1 {
    final /* synthetic */ DoubleStream a;

    private /* synthetic */ J0(DoubleStream doubleStream) {
        this.a = doubleStream;
    }

    public static /* synthetic */ InterfaceC0471s1 m0(DoubleStream doubleStream) {
        if (doubleStream == null) {
            return null;
        }
        return doubleStream instanceof K0 ? ((K0) doubleStream).a : new J0(doubleStream);
    }

    @Override // j$.util.stream.InterfaceC0471s1
    public /* synthetic */ j$.util.p C(j$.util.function.r rVar) {
        return j$.time.a.n(this.a.reduce(C0504y.a(rVar)));
    }

    @Override // j$.util.stream.InterfaceC0471s1
    public /* synthetic */ Object D(Supplier supplier, j$.util.function.I i2, BiConsumer biConsumer) {
        return this.a.collect(C$r8$wrapper$java$util$function$Supplier$WRP.convert(supplier), r0.a(i2), C0384s.a(biConsumer));
    }

    @Override // j$.util.stream.InterfaceC0471s1
    public /* synthetic */ double G(double d2, j$.util.function.r rVar) {
        return this.a.reduce(d2, C0504y.a(rVar));
    }

    @Override // j$.util.stream.InterfaceC0471s1
    public /* synthetic */ InterfaceC0471s1 H(j$.util.function.w wVar) {
        return m0(this.a.map(K.a(wVar)));
    }

    @Override // j$.util.stream.InterfaceC0471s1
    public /* synthetic */ Stream I(j$.util.function.t tVar) {
        return P0.m0(this.a.mapToObj(C.a(tVar)));
    }

    @Override // j$.util.stream.InterfaceC0471s1
    public /* synthetic */ boolean J(j$.util.function.u uVar) {
        return this.a.noneMatch(E.a(uVar));
    }

    @Override // j$.util.stream.InterfaceC0471s1
    public /* synthetic */ boolean O(j$.util.function.u uVar) {
        return this.a.allMatch(E.a(uVar));
    }

    @Override // j$.util.stream.InterfaceC0471s1
    public /* synthetic */ boolean W(j$.util.function.u uVar) {
        return this.a.anyMatch(E.a(uVar));
    }

    @Override // j$.util.stream.InterfaceC0471s1
    public /* synthetic */ j$.util.p average() {
        return j$.time.a.n(this.a.average());
    }

    @Override // j$.util.stream.InterfaceC0471s1
    public /* synthetic */ Stream boxed() {
        return P0.m0(this.a.boxed());
    }

    @Override // j$.util.stream.InterfaceC0444l1, java.lang.AutoCloseable
    public /* synthetic */ void close() {
        this.a.close();
    }

    @Override // j$.util.stream.InterfaceC0471s1
    public /* synthetic */ long count() {
        return this.a.count();
    }

    @Override // j$.util.stream.InterfaceC0471s1
    public /* synthetic */ InterfaceC0471s1 d(j$.util.function.s sVar) {
        return m0(this.a.peek(A.a(sVar)));
    }

    @Override // j$.util.stream.InterfaceC0471s1
    public /* synthetic */ InterfaceC0471s1 distinct() {
        return m0(this.a.distinct());
    }

    @Override // j$.util.stream.InterfaceC0471s1
    public /* synthetic */ j$.util.p findAny() {
        return j$.time.a.n(this.a.findAny());
    }

    @Override // j$.util.stream.InterfaceC0471s1
    public /* synthetic */ j$.util.p findFirst() {
        return j$.time.a.n(this.a.findFirst());
    }

    @Override // j$.util.stream.InterfaceC0444l1
    public /* synthetic */ boolean isParallel() {
        return this.a.isParallel();
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.PrimitiveIterator$OfDouble] */
    @Override // j$.util.stream.InterfaceC0471s1, j$.util.stream.InterfaceC0444l1
    public /* synthetic */ t.a iterator() {
        return C0352b.a(this.a.iterator());
    }

    @Override // j$.util.stream.InterfaceC0444l1
    public /* synthetic */ Iterator iterator() {
        return this.a.iterator();
    }

    @Override // j$.util.stream.InterfaceC0471s1
    public /* synthetic */ void k0(j$.util.function.s sVar) {
        this.a.forEachOrdered(A.a(sVar));
    }

    @Override // j$.util.stream.InterfaceC0471s1
    public /* synthetic */ void l(j$.util.function.s sVar) {
        this.a.forEach(A.a(sVar));
    }

    @Override // j$.util.stream.InterfaceC0471s1
    public /* synthetic */ InterfaceC0471s1 limit(long j2) {
        return m0(this.a.limit(j2));
    }

    @Override // j$.util.stream.InterfaceC0471s1
    public /* synthetic */ j$.util.p max() {
        return j$.time.a.n(this.a.max());
    }

    @Override // j$.util.stream.InterfaceC0471s1
    public /* synthetic */ j$.util.p min() {
        return j$.time.a.n(this.a.min());
    }

    @Override // j$.util.stream.InterfaceC0471s1
    public /* synthetic */ C1 o(F f2) {
        return L0.m0(this.a.mapToInt(f2 == null ? null : f2.a));
    }

    @Override // j$.util.stream.InterfaceC0444l1
    public /* synthetic */ InterfaceC0444l1 onClose(Runnable runnable) {
        return F0.m0(this.a.onClose(runnable));
    }

    @Override // j$.util.stream.InterfaceC0444l1
    public /* synthetic */ InterfaceC0444l1 parallel() {
        return F0.m0(this.a.parallel());
    }

    @Override // j$.util.stream.InterfaceC0471s1, j$.util.stream.InterfaceC0444l1
    public /* synthetic */ InterfaceC0471s1 parallel() {
        return m0(this.a.parallel());
    }

    @Override // j$.util.stream.InterfaceC0444l1
    public /* synthetic */ InterfaceC0444l1 sequential() {
        return F0.m0(this.a.sequential());
    }

    @Override // j$.util.stream.InterfaceC0471s1, j$.util.stream.InterfaceC0444l1
    public /* synthetic */ InterfaceC0471s1 sequential() {
        return m0(this.a.sequential());
    }

    @Override // j$.util.stream.InterfaceC0471s1
    public /* synthetic */ InterfaceC0471s1 skip(long j2) {
        return m0(this.a.skip(j2));
    }

    @Override // j$.util.stream.InterfaceC0471s1
    public /* synthetic */ InterfaceC0471s1 sorted() {
        return m0(this.a.sorted());
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.Spliterator$OfDouble] */
    @Override // j$.util.stream.InterfaceC0471s1, j$.util.stream.InterfaceC0444l1
    public /* synthetic */ Spliterator.a spliterator() {
        return C0368j.a(this.a.spliterator());
    }

    @Override // j$.util.stream.InterfaceC0444l1
    public /* synthetic */ Spliterator spliterator() {
        return C0364h.a(this.a.spliterator());
    }

    @Override // j$.util.stream.InterfaceC0471s1
    public /* synthetic */ double sum() {
        return this.a.sum();
    }

    @Override // j$.util.stream.InterfaceC0471s1
    public j$.util.l summaryStatistics() {
        this.a.summaryStatistics();
        throw new Error("Java 8+ API desugaring (library desugaring) cannot convert from java.util.DoubleSummaryStatistics");
    }

    @Override // j$.util.stream.InterfaceC0471s1
    public /* synthetic */ InterfaceC0471s1 t(j$.util.function.u uVar) {
        return m0(this.a.filter(E.a(uVar)));
    }

    @Override // j$.util.stream.InterfaceC0471s1
    public /* synthetic */ double[] toArray() {
        return this.a.toArray();
    }

    @Override // j$.util.stream.InterfaceC0471s1
    public /* synthetic */ InterfaceC0471s1 u(j$.util.function.t tVar) {
        return m0(this.a.flatMap(C.a(tVar)));
    }

    @Override // j$.util.stream.InterfaceC0444l1
    public /* synthetic */ InterfaceC0444l1 unordered() {
        return F0.m0(this.a.unordered());
    }

    @Override // j$.util.stream.InterfaceC0471s1
    public /* synthetic */ H1 v(j$.util.function.v vVar) {
        return N0.m0(this.a.mapToLong(I.a(vVar)));
    }
}

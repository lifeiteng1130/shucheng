package j$;

import j$.util.Spliterator;
import j$.util.function.BiConsumer;
import j$.util.function.BiFunction;
import j$.util.function.Consumer;
import j$.util.function.Function;
import j$.util.function.Predicate;
import j$.util.function.Supplier;
import j$.util.function.ToDoubleFunction;
import j$.util.function.ToIntFunction;
import j$.util.function.ToLongFunction;
import j$.util.stream.C1;
import j$.util.stream.H1;
import j$.util.stream.InterfaceC0444l1;
import j$.util.stream.InterfaceC0448m1;
import j$.util.stream.InterfaceC0471s1;
import j$.util.stream.Stream;
import java.util.Comparator;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class P0 implements Stream {
    final /* synthetic */ java.util.stream.Stream a;

    private /* synthetic */ P0(java.util.stream.Stream stream) {
        this.a = stream;
    }

    public static /* synthetic */ Stream m0(java.util.stream.Stream stream) {
        if (stream == null) {
            return null;
        }
        return stream instanceof Q0 ? ((Q0) stream).a : new P0(stream);
    }

    @Override // j$.util.stream.Stream
    public /* synthetic */ InterfaceC0471s1 B(Function function) {
        return J0.m0(this.a.flatMapToDouble(M.a(function)));
    }

    @Override // j$.util.stream.Stream
    public /* synthetic */ Stream P(Predicate predicate) {
        return m0(this.a.filter(x0.a(predicate)));
    }

    @Override // j$.util.stream.Stream
    public /* synthetic */ Stream S(Consumer consumer) {
        return m0(this.a.peek(C$r8$wrapper$java$util$function$Consumer$WRP.convert(consumer)));
    }

    @Override // j$.util.stream.Stream
    public /* synthetic */ Object T(InterfaceC0448m1 interfaceC0448m1) {
        return this.a.collect(I0.a(interfaceC0448m1));
    }

    @Override // j$.util.stream.Stream
    public /* synthetic */ boolean U(Predicate predicate) {
        return this.a.allMatch(x0.a(predicate));
    }

    @Override // j$.util.stream.Stream
    public /* synthetic */ H1 V(Function function) {
        return N0.m0(this.a.flatMapToLong(M.a(function)));
    }

    @Override // j$.util.stream.Stream
    public /* synthetic */ boolean a(Predicate predicate) {
        return this.a.anyMatch(x0.a(predicate));
    }

    @Override // j$.util.stream.Stream
    public /* synthetic */ boolean c0(Predicate predicate) {
        return this.a.noneMatch(x0.a(predicate));
    }

    @Override // j$.util.stream.InterfaceC0444l1, java.lang.AutoCloseable
    public /* synthetic */ void close() {
        this.a.close();
    }

    @Override // j$.util.stream.Stream
    public /* synthetic */ long count() {
        return this.a.count();
    }

    @Override // j$.util.stream.Stream
    public /* synthetic */ Stream distinct() {
        return m0(this.a.distinct());
    }

    @Override // j$.util.stream.Stream
    public /* synthetic */ C1 e(Function function) {
        return L0.m0(this.a.flatMapToInt(M.a(function)));
    }

    @Override // j$.util.stream.Stream
    public /* synthetic */ H1 e0(ToLongFunction toLongFunction) {
        return N0.m0(this.a.mapToLong(E0.a(toLongFunction)));
    }

    @Override // j$.util.stream.Stream
    public /* synthetic */ j$.util.o findAny() {
        return j$.time.a.m(this.a.findAny());
    }

    @Override // j$.util.stream.Stream
    public /* synthetic */ j$.util.o findFirst() {
        return j$.time.a.m(this.a.findFirst());
    }

    @Override // j$.util.stream.Stream
    public /* synthetic */ void forEach(Consumer consumer) {
        this.a.forEach(C$r8$wrapper$java$util$function$Consumer$WRP.convert(consumer));
    }

    @Override // j$.util.stream.Stream
    public /* synthetic */ void g(Consumer consumer) {
        this.a.forEachOrdered(C$r8$wrapper$java$util$function$Consumer$WRP.convert(consumer));
    }

    @Override // j$.util.stream.Stream
    public /* synthetic */ InterfaceC0471s1 h0(ToDoubleFunction toDoubleFunction) {
        return J0.m0(this.a.mapToDouble(A0.a(toDoubleFunction)));
    }

    @Override // j$.util.stream.InterfaceC0444l1
    public /* synthetic */ boolean isParallel() {
        return this.a.isParallel();
    }

    @Override // j$.util.stream.InterfaceC0444l1
    public /* synthetic */ Iterator iterator() {
        return this.a.iterator();
    }

    @Override // j$.util.stream.Stream
    public /* synthetic */ Object k(Supplier supplier, BiConsumer biConsumer, BiConsumer biConsumer2) {
        return this.a.collect(C$r8$wrapper$java$util$function$Supplier$WRP.convert(supplier), C0384s.a(biConsumer), C0384s.a(biConsumer2));
    }

    @Override // j$.util.stream.Stream
    public /* synthetic */ Object l0(Object obj, j$.util.function.p pVar) {
        return this.a.reduce(obj, C0502w.a(pVar));
    }

    @Override // j$.util.stream.Stream
    public /* synthetic */ Stream limit(long j2) {
        return m0(this.a.limit(j2));
    }

    @Override // j$.util.stream.Stream
    public /* synthetic */ C1 m(ToIntFunction toIntFunction) {
        return L0.m0(this.a.mapToInt(C0.a(toIntFunction)));
    }

    @Override // j$.util.stream.Stream
    public /* synthetic */ j$.util.o max(Comparator comparator) {
        return j$.time.a.m(this.a.max(comparator));
    }

    @Override // j$.util.stream.Stream
    public /* synthetic */ j$.util.o min(Comparator comparator) {
        return j$.time.a.m(this.a.min(comparator));
    }

    @Override // j$.util.stream.Stream
    public /* synthetic */ Stream n(Function function) {
        return m0(this.a.map(M.a(function)));
    }

    @Override // j$.util.stream.InterfaceC0444l1
    public /* synthetic */ InterfaceC0444l1 onClose(Runnable runnable) {
        return F0.m0(this.a.onClose(runnable));
    }

    @Override // j$.util.stream.Stream
    public /* synthetic */ Stream p(Function function) {
        return m0(this.a.flatMap(M.a(function)));
    }

    @Override // j$.util.stream.InterfaceC0444l1
    public /* synthetic */ InterfaceC0444l1 parallel() {
        return F0.m0(this.a.parallel());
    }

    @Override // j$.util.stream.Stream
    public /* synthetic */ j$.util.o s(j$.util.function.p pVar) {
        return j$.time.a.m(this.a.reduce(C0502w.a(pVar)));
    }

    @Override // j$.util.stream.InterfaceC0444l1
    public /* synthetic */ InterfaceC0444l1 sequential() {
        return F0.m0(this.a.sequential());
    }

    @Override // j$.util.stream.Stream
    public /* synthetic */ Stream skip(long j2) {
        return m0(this.a.skip(j2));
    }

    @Override // j$.util.stream.Stream
    public /* synthetic */ Stream sorted() {
        return m0(this.a.sorted());
    }

    @Override // j$.util.stream.Stream
    public /* synthetic */ Stream sorted(Comparator comparator) {
        return m0(this.a.sorted(comparator));
    }

    @Override // j$.util.stream.InterfaceC0444l1
    public /* synthetic */ Spliterator spliterator() {
        return C0364h.a(this.a.spliterator());
    }

    @Override // j$.util.stream.Stream
    public /* synthetic */ Object[] toArray() {
        return this.a.toArray();
    }

    @Override // j$.util.stream.Stream
    public /* synthetic */ Object[] toArray(j$.util.function.z zVar) {
        return this.a.toArray(T.a(zVar));
    }

    @Override // j$.util.stream.InterfaceC0444l1
    public /* synthetic */ InterfaceC0444l1 unordered() {
        return F0.m0(this.a.unordered());
    }

    @Override // j$.util.stream.Stream
    public /* synthetic */ Object z(Object obj, BiFunction biFunction, j$.util.function.p pVar) {
        return this.a.reduce(obj, C0386u.a(biFunction), C0502w.a(pVar));
    }
}

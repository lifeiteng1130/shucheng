package j$;

import j$.util.Spliterator;
import j$.util.stream.InterfaceC0444l1;
import java.util.Iterator;
import java.util.stream.BaseStream;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class F0 implements InterfaceC0444l1 {
    final /* synthetic */ BaseStream a;

    private /* synthetic */ F0(BaseStream baseStream) {
        this.a = baseStream;
    }

    public static /* synthetic */ InterfaceC0444l1 m0(BaseStream baseStream) {
        if (baseStream == null) {
            return null;
        }
        return baseStream instanceof G0 ? ((G0) baseStream).a : new F0(baseStream);
    }

    @Override // j$.util.stream.InterfaceC0444l1, java.lang.AutoCloseable
    public /* synthetic */ void close() {
        this.a.close();
    }

    @Override // j$.util.stream.InterfaceC0444l1
    public /* synthetic */ boolean isParallel() {
        return this.a.isParallel();
    }

    @Override // j$.util.stream.InterfaceC0444l1
    public /* synthetic */ Iterator iterator() {
        return this.a.iterator();
    }

    @Override // j$.util.stream.InterfaceC0444l1
    public /* synthetic */ InterfaceC0444l1 onClose(Runnable runnable) {
        return m0(this.a.onClose(runnable));
    }

    @Override // j$.util.stream.InterfaceC0444l1
    public /* synthetic */ InterfaceC0444l1 parallel() {
        return m0(this.a.parallel());
    }

    @Override // j$.util.stream.InterfaceC0444l1
    public /* synthetic */ InterfaceC0444l1 sequential() {
        return m0(this.a.sequential());
    }

    @Override // j$.util.stream.InterfaceC0444l1
    public /* synthetic */ Spliterator spliterator() {
        return C0364h.a(this.a.spliterator());
    }

    @Override // j$.util.stream.InterfaceC0444l1
    public /* synthetic */ InterfaceC0444l1 unordered() {
        return m0(this.a.unordered());
    }
}

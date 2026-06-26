package j$;

import j$.util.stream.InterfaceC0444l1;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.stream.BaseStream;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class G0 implements BaseStream {
    final /* synthetic */ InterfaceC0444l1 a;

    private /* synthetic */ G0(InterfaceC0444l1 interfaceC0444l1) {
        this.a = interfaceC0444l1;
    }

    public static /* synthetic */ BaseStream m0(InterfaceC0444l1 interfaceC0444l1) {
        if (interfaceC0444l1 == null) {
            return null;
        }
        return interfaceC0444l1 instanceof F0 ? ((F0) interfaceC0444l1).a : new G0(interfaceC0444l1);
    }

    @Override // java.util.stream.BaseStream, java.lang.AutoCloseable
    public /* synthetic */ void close() {
        this.a.close();
    }

    @Override // java.util.stream.BaseStream
    public /* synthetic */ boolean isParallel() {
        return this.a.isParallel();
    }

    @Override // java.util.stream.BaseStream
    public /* synthetic */ Iterator iterator() {
        return this.a.iterator();
    }

    @Override // java.util.stream.BaseStream
    public /* synthetic */ BaseStream onClose(Runnable runnable) {
        return m0(this.a.onClose(runnable));
    }

    @Override // java.util.stream.BaseStream
    public /* synthetic */ BaseStream parallel() {
        return m0(this.a.parallel());
    }

    @Override // java.util.stream.BaseStream
    public /* synthetic */ BaseStream sequential() {
        return m0(this.a.sequential());
    }

    @Override // java.util.stream.BaseStream
    public /* synthetic */ Spliterator spliterator() {
        return C0366i.a(this.a.spliterator());
    }

    @Override // java.util.stream.BaseStream
    public /* synthetic */ BaseStream unordered() {
        return m0(this.a.unordered());
    }
}

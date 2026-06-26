package j$;

import j$.util.function.BiConsumer;
import j$.util.function.Function;
import j$.util.function.Supplier;
import j$.util.stream.InterfaceC0448m1;
import java.util.Set;
import java.util.stream.Collector;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class H0 implements InterfaceC0448m1 {
    final /* synthetic */ Collector a;

    private /* synthetic */ H0(Collector collector) {
        this.a = collector;
    }

    public static /* synthetic */ InterfaceC0448m1 a(Collector collector) {
        if (collector == null) {
            return null;
        }
        return collector instanceof I0 ? ((I0) collector).a : new H0(collector);
    }

    @Override // j$.util.stream.InterfaceC0448m1
    public /* synthetic */ BiConsumer accumulator() {
        return r.b(this.a.accumulator());
    }

    @Override // j$.util.stream.InterfaceC0448m1
    public /* synthetic */ Set characteristics() {
        return this.a.characteristics();
    }

    @Override // j$.util.stream.InterfaceC0448m1
    public /* synthetic */ j$.util.function.p combiner() {
        return C0501v.a(this.a.combiner());
    }

    @Override // j$.util.stream.InterfaceC0448m1
    public /* synthetic */ Function finisher() {
        return L.a(this.a.finisher());
    }

    @Override // j$.util.stream.InterfaceC0448m1
    public /* synthetic */ Supplier supplier() {
        return y0.a(this.a.supplier());
    }
}

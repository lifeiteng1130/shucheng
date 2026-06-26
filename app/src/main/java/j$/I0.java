package j$;

import j$.util.stream.InterfaceC0448m1;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class I0 implements Collector {
    final /* synthetic */ InterfaceC0448m1 a;

    private /* synthetic */ I0(InterfaceC0448m1 interfaceC0448m1) {
        this.a = interfaceC0448m1;
    }

    public static /* synthetic */ Collector a(InterfaceC0448m1 interfaceC0448m1) {
        if (interfaceC0448m1 == null) {
            return null;
        }
        return interfaceC0448m1 instanceof H0 ? ((H0) interfaceC0448m1).a : new I0(interfaceC0448m1);
    }

    @Override // java.util.stream.Collector
    public /* synthetic */ BiConsumer accumulator() {
        return C0384s.a(this.a.accumulator());
    }

    @Override // java.util.stream.Collector
    public /* synthetic */ Set characteristics() {
        return this.a.characteristics();
    }

    @Override // java.util.stream.Collector
    public /* synthetic */ BinaryOperator combiner() {
        return C0502w.a(this.a.combiner());
    }

    @Override // java.util.stream.Collector
    public /* synthetic */ Function finisher() {
        return M.a(this.a.finisher());
    }

    @Override // java.util.stream.Collector
    public /* synthetic */ Supplier supplier() {
        return C$r8$wrapper$java$util$function$Supplier$WRP.convert(this.a.supplier());
    }
}

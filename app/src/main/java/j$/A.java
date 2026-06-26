package j$;

import java.util.function.DoubleConsumer;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class A implements DoubleConsumer {
    final /* synthetic */ j$.util.function.s a;

    private /* synthetic */ A(j$.util.function.s sVar) {
        this.a = sVar;
    }

    public static /* synthetic */ DoubleConsumer a(j$.util.function.s sVar) {
        if (sVar == null) {
            return null;
        }
        return sVar instanceof C0505z ? ((C0505z) sVar).a : new A(sVar);
    }

    @Override // java.util.function.DoubleConsumer
    public /* synthetic */ void accept(double d2) {
        this.a.accept(d2);
    }

    @Override // java.util.function.DoubleConsumer
    public /* synthetic */ DoubleConsumer andThen(DoubleConsumer doubleConsumer) {
        return a(this.a.j(C0505z.b(doubleConsumer)));
    }
}

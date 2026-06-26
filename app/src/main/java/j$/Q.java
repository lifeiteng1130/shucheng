package j$;

import java.util.function.IntConsumer;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class Q implements IntConsumer {
    final /* synthetic */ j$.util.function.y a;

    private /* synthetic */ Q(j$.util.function.y yVar) {
        this.a = yVar;
    }

    public static /* synthetic */ IntConsumer a(j$.util.function.y yVar) {
        if (yVar == null) {
            return null;
        }
        return yVar instanceof P ? ((P) yVar).a : new Q(yVar);
    }

    @Override // java.util.function.IntConsumer
    public /* synthetic */ void accept(int i2) {
        this.a.accept(i2);
    }

    @Override // java.util.function.IntConsumer
    public /* synthetic */ IntConsumer andThen(IntConsumer intConsumer) {
        return a(this.a.k(P.b(intConsumer)));
    }
}

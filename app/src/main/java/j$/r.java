package j$;

import j$.util.function.BiConsumer;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class r implements BiConsumer {
    final /* synthetic */ java.util.function.BiConsumer a;

    private /* synthetic */ r(java.util.function.BiConsumer biConsumer) {
        this.a = biConsumer;
    }

    public static /* synthetic */ BiConsumer b(java.util.function.BiConsumer biConsumer) {
        if (biConsumer == null) {
            return null;
        }
        return biConsumer instanceof C0384s ? ((C0384s) biConsumer).a : new r(biConsumer);
    }

    @Override // j$.util.function.BiConsumer
    public /* synthetic */ BiConsumer a(BiConsumer biConsumer) {
        return b(this.a.andThen(C0384s.a(biConsumer)));
    }

    @Override // j$.util.function.BiConsumer
    public /* synthetic */ void accept(Object obj, Object obj2) {
        this.a.accept(obj, obj2);
    }
}

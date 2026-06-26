package j$;

import java.util.function.IntConsumer;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class P implements j$.util.function.y {
    final /* synthetic */ IntConsumer a;

    private /* synthetic */ P(IntConsumer intConsumer) {
        this.a = intConsumer;
    }

    public static /* synthetic */ j$.util.function.y b(IntConsumer intConsumer) {
        if (intConsumer == null) {
            return null;
        }
        return intConsumer instanceof Q ? ((Q) intConsumer).a : new P(intConsumer);
    }

    @Override // j$.util.function.y
    public /* synthetic */ void accept(int i2) {
        this.a.accept(i2);
    }

    @Override // j$.util.function.y
    public /* synthetic */ j$.util.function.y k(j$.util.function.y yVar) {
        return b(this.a.andThen(Q.a(yVar)));
    }
}

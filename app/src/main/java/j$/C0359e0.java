package j$;

import java.util.function.LongConsumer;

/* JADX INFO: renamed from: j$.e0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class C0359e0 implements j$.util.function.E {
    final /* synthetic */ LongConsumer a;

    private /* synthetic */ C0359e0(LongConsumer longConsumer) {
        this.a = longConsumer;
    }

    public static /* synthetic */ j$.util.function.E b(LongConsumer longConsumer) {
        if (longConsumer == null) {
            return null;
        }
        return longConsumer instanceof C0361f0 ? ((C0361f0) longConsumer).a : new C0359e0(longConsumer);
    }

    @Override // j$.util.function.E
    public /* synthetic */ void accept(long j2) {
        this.a.accept(j2);
    }

    @Override // j$.util.function.E
    public /* synthetic */ j$.util.function.E f(j$.util.function.E e2) {
        return b(this.a.andThen(C0361f0.a(e2)));
    }
}

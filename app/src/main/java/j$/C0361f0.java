package j$;

import java.util.function.LongConsumer;

/* JADX INFO: renamed from: j$.f0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class C0361f0 implements LongConsumer {
    final /* synthetic */ j$.util.function.E a;

    private /* synthetic */ C0361f0(j$.util.function.E e2) {
        this.a = e2;
    }

    public static /* synthetic */ LongConsumer a(j$.util.function.E e2) {
        if (e2 == null) {
            return null;
        }
        return e2 instanceof C0359e0 ? ((C0359e0) e2).a : new C0361f0(e2);
    }

    @Override // java.util.function.LongConsumer
    public /* synthetic */ void accept(long j2) {
        this.a.accept(j2);
    }

    @Override // java.util.function.LongConsumer
    public /* synthetic */ LongConsumer andThen(LongConsumer longConsumer) {
        return a(this.a.f(C0359e0.b(longConsumer)));
    }
}

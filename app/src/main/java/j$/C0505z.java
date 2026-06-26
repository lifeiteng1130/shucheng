package j$;

import java.util.function.DoubleConsumer;

/* JADX INFO: renamed from: j$.z, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class C0505z implements j$.util.function.s {
    final /* synthetic */ DoubleConsumer a;

    private /* synthetic */ C0505z(DoubleConsumer doubleConsumer) {
        this.a = doubleConsumer;
    }

    public static /* synthetic */ j$.util.function.s b(DoubleConsumer doubleConsumer) {
        if (doubleConsumer == null) {
            return null;
        }
        return doubleConsumer instanceof A ? ((A) doubleConsumer).a : new C0505z(doubleConsumer);
    }

    @Override // j$.util.function.s
    public /* synthetic */ void accept(double d2) {
        this.a.accept(d2);
    }

    @Override // j$.util.function.s
    public /* synthetic */ j$.util.function.s j(j$.util.function.s sVar) {
        return b(this.a.andThen(A.a(sVar)));
    }
}

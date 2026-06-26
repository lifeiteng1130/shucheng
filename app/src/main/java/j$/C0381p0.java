package j$;

import java.util.function.LongUnaryOperator;

/* JADX INFO: renamed from: j$.p0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class C0381p0 implements LongUnaryOperator {
    final /* synthetic */ j$.util.function.H a;

    private /* synthetic */ C0381p0(j$.util.function.H h2) {
        this.a = h2;
    }

    public static /* synthetic */ LongUnaryOperator a(j$.util.function.H h2) {
        if (h2 == null) {
            return null;
        }
        return h2 instanceof C0379o0 ? ((C0379o0) h2).a : new C0381p0(h2);
    }

    @Override // java.util.function.LongUnaryOperator
    public /* synthetic */ LongUnaryOperator andThen(LongUnaryOperator longUnaryOperator) {
        return a(this.a.a(C0379o0.c(longUnaryOperator)));
    }

    @Override // java.util.function.LongUnaryOperator
    public /* synthetic */ long applyAsLong(long j2) {
        return this.a.applyAsLong(j2);
    }

    @Override // java.util.function.LongUnaryOperator
    public /* synthetic */ LongUnaryOperator compose(LongUnaryOperator longUnaryOperator) {
        return a(this.a.b(C0379o0.c(longUnaryOperator)));
    }
}

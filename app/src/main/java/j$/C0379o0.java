package j$;

import java.util.function.LongUnaryOperator;

/* JADX INFO: renamed from: j$.o0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class C0379o0 implements j$.util.function.H {
    final /* synthetic */ LongUnaryOperator a;

    private /* synthetic */ C0379o0(LongUnaryOperator longUnaryOperator) {
        this.a = longUnaryOperator;
    }

    public static /* synthetic */ j$.util.function.H c(LongUnaryOperator longUnaryOperator) {
        if (longUnaryOperator == null) {
            return null;
        }
        return longUnaryOperator instanceof C0381p0 ? ((C0381p0) longUnaryOperator).a : new C0379o0(longUnaryOperator);
    }

    @Override // j$.util.function.H
    public /* synthetic */ j$.util.function.H a(j$.util.function.H h2) {
        return c(this.a.andThen(C0381p0.a(h2)));
    }

    @Override // j$.util.function.H
    public /* synthetic */ long applyAsLong(long j2) {
        return this.a.applyAsLong(j2);
    }

    @Override // j$.util.function.H
    public /* synthetic */ j$.util.function.H b(j$.util.function.H h2) {
        return c(this.a.compose(C0381p0.a(h2)));
    }
}

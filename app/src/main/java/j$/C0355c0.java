package j$;

import java.util.function.LongBinaryOperator;

/* JADX INFO: renamed from: j$.c0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class C0355c0 implements j$.util.function.D {
    final /* synthetic */ LongBinaryOperator a;

    private /* synthetic */ C0355c0(LongBinaryOperator longBinaryOperator) {
        this.a = longBinaryOperator;
    }

    public static /* synthetic */ j$.util.function.D a(LongBinaryOperator longBinaryOperator) {
        if (longBinaryOperator == null) {
            return null;
        }
        return longBinaryOperator instanceof C0357d0 ? ((C0357d0) longBinaryOperator).a : new C0355c0(longBinaryOperator);
    }

    @Override // j$.util.function.D
    public /* synthetic */ long applyAsLong(long j2, long j3) {
        return this.a.applyAsLong(j2, j3);
    }
}

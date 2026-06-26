package j$;

import java.util.function.IntBinaryOperator;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class N implements j$.util.function.x {
    final /* synthetic */ IntBinaryOperator a;

    private /* synthetic */ N(IntBinaryOperator intBinaryOperator) {
        this.a = intBinaryOperator;
    }

    public static /* synthetic */ j$.util.function.x a(IntBinaryOperator intBinaryOperator) {
        if (intBinaryOperator == null) {
            return null;
        }
        return intBinaryOperator instanceof O ? ((O) intBinaryOperator).a : new N(intBinaryOperator);
    }

    @Override // j$.util.function.x
    public /* synthetic */ int applyAsInt(int i2, int i3) {
        return this.a.applyAsInt(i2, i3);
    }
}

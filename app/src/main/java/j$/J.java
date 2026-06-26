package j$;

import java.util.function.DoubleUnaryOperator;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class J implements j$.util.function.w {
    final /* synthetic */ DoubleUnaryOperator a;

    private /* synthetic */ J(DoubleUnaryOperator doubleUnaryOperator) {
        this.a = doubleUnaryOperator;
    }

    public static /* synthetic */ j$.util.function.w b(DoubleUnaryOperator doubleUnaryOperator) {
        if (doubleUnaryOperator == null) {
            return null;
        }
        return doubleUnaryOperator instanceof K ? ((K) doubleUnaryOperator).a : new J(doubleUnaryOperator);
    }

    public /* synthetic */ double a(double d2) {
        return this.a.applyAsDouble(d2);
    }
}

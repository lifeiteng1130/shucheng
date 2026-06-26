package j$;

import java.util.function.DoubleUnaryOperator;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class K implements DoubleUnaryOperator {
    final /* synthetic */ j$.util.function.w a;

    private /* synthetic */ K(j$.util.function.w wVar) {
        this.a = wVar;
    }

    public static /* synthetic */ DoubleUnaryOperator a(j$.util.function.w wVar) {
        if (wVar == null) {
            return null;
        }
        return wVar instanceof J ? ((J) wVar).a : new K(wVar);
    }

    @Override // java.util.function.DoubleUnaryOperator
    public /* synthetic */ DoubleUnaryOperator andThen(DoubleUnaryOperator doubleUnaryOperator) {
        return a(J.b(((J) this.a).a.andThen(a(J.b(doubleUnaryOperator)))));
    }

    @Override // java.util.function.DoubleUnaryOperator
    public /* synthetic */ double applyAsDouble(double d2) {
        return ((J) this.a).a.applyAsDouble(d2);
    }

    @Override // java.util.function.DoubleUnaryOperator
    public /* synthetic */ DoubleUnaryOperator compose(DoubleUnaryOperator doubleUnaryOperator) {
        return a(J.b(((J) this.a).a.compose(a(J.b(doubleUnaryOperator)))));
    }
}

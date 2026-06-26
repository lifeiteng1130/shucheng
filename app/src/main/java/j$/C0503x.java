package j$;

import java.util.function.DoubleBinaryOperator;

/* JADX INFO: renamed from: j$.x, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class C0503x implements j$.util.function.r {
    final /* synthetic */ DoubleBinaryOperator a;

    private /* synthetic */ C0503x(DoubleBinaryOperator doubleBinaryOperator) {
        this.a = doubleBinaryOperator;
    }

    public static /* synthetic */ j$.util.function.r a(DoubleBinaryOperator doubleBinaryOperator) {
        if (doubleBinaryOperator == null) {
            return null;
        }
        return doubleBinaryOperator instanceof C0504y ? ((C0504y) doubleBinaryOperator).a : new C0503x(doubleBinaryOperator);
    }

    @Override // j$.util.function.r
    public /* synthetic */ double applyAsDouble(double d2, double d3) {
        return this.a.applyAsDouble(d2, d3);
    }
}

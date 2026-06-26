package j$;

import java.util.function.DoubleToLongFunction;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class H implements j$.util.function.v {
    final /* synthetic */ DoubleToLongFunction a;

    private /* synthetic */ H(DoubleToLongFunction doubleToLongFunction) {
        this.a = doubleToLongFunction;
    }

    public static /* synthetic */ j$.util.function.v a(DoubleToLongFunction doubleToLongFunction) {
        if (doubleToLongFunction == null) {
            return null;
        }
        return doubleToLongFunction instanceof I ? ((I) doubleToLongFunction).a : new H(doubleToLongFunction);
    }

    @Override // j$.util.function.v
    public /* synthetic */ long applyAsLong(double d2) {
        return this.a.applyAsLong(d2);
    }
}

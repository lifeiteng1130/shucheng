package j$;

import java.util.function.DoubleToLongFunction;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class I implements DoubleToLongFunction {
    final /* synthetic */ j$.util.function.v a;

    private /* synthetic */ I(j$.util.function.v vVar) {
        this.a = vVar;
    }

    public static /* synthetic */ DoubleToLongFunction a(j$.util.function.v vVar) {
        if (vVar == null) {
            return null;
        }
        return vVar instanceof H ? ((H) vVar).a : new I(vVar);
    }

    @Override // java.util.function.DoubleToLongFunction
    public /* synthetic */ long applyAsLong(double d2) {
        return this.a.applyAsLong(d2);
    }
}

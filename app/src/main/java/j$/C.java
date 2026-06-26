package j$;

import java.util.function.DoubleFunction;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class C implements DoubleFunction {
    final /* synthetic */ j$.util.function.t a;

    private /* synthetic */ C(j$.util.function.t tVar) {
        this.a = tVar;
    }

    public static /* synthetic */ DoubleFunction a(j$.util.function.t tVar) {
        if (tVar == null) {
            return null;
        }
        return tVar instanceof B ? ((B) tVar).a : new C(tVar);
    }

    @Override // java.util.function.DoubleFunction
    public /* synthetic */ Object apply(double d2) {
        return this.a.apply(d2);
    }
}

package j$;

import j$.util.function.ToDoubleFunction;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class z0 implements ToDoubleFunction {
    final /* synthetic */ java.util.function.ToDoubleFunction a;

    private /* synthetic */ z0(java.util.function.ToDoubleFunction toDoubleFunction) {
        this.a = toDoubleFunction;
    }

    public static /* synthetic */ ToDoubleFunction a(java.util.function.ToDoubleFunction toDoubleFunction) {
        if (toDoubleFunction == null) {
            return null;
        }
        return toDoubleFunction instanceof A0 ? ((A0) toDoubleFunction).a : new z0(toDoubleFunction);
    }

    @Override // j$.util.function.ToDoubleFunction
    public /* synthetic */ double applyAsDouble(Object obj) {
        return this.a.applyAsDouble(obj);
    }
}

package j$;

import j$.util.function.ToLongFunction;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class D0 implements ToLongFunction {
    final /* synthetic */ java.util.function.ToLongFunction a;

    private /* synthetic */ D0(java.util.function.ToLongFunction toLongFunction) {
        this.a = toLongFunction;
    }

    public static /* synthetic */ ToLongFunction a(java.util.function.ToLongFunction toLongFunction) {
        if (toLongFunction == null) {
            return null;
        }
        return toLongFunction instanceof E0 ? ((E0) toLongFunction).a : new D0(toLongFunction);
    }

    @Override // j$.util.function.ToLongFunction
    public /* synthetic */ long applyAsLong(Object obj) {
        return this.a.applyAsLong(obj);
    }
}

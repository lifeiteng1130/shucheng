package j$;

import j$.util.function.ToIntFunction;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class B0 implements ToIntFunction {
    final /* synthetic */ java.util.function.ToIntFunction a;

    private /* synthetic */ B0(java.util.function.ToIntFunction toIntFunction) {
        this.a = toIntFunction;
    }

    public static /* synthetic */ ToIntFunction a(java.util.function.ToIntFunction toIntFunction) {
        if (toIntFunction == null) {
            return null;
        }
        return toIntFunction instanceof C0 ? ((C0) toIntFunction).a : new B0(toIntFunction);
    }

    @Override // j$.util.function.ToIntFunction
    public /* synthetic */ int applyAsInt(Object obj) {
        return this.a.applyAsInt(obj);
    }
}

package j$;

import java.util.function.IntToLongFunction;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class Y implements j$.util.function.B {
    final /* synthetic */ IntToLongFunction a;

    private /* synthetic */ Y(IntToLongFunction intToLongFunction) {
        this.a = intToLongFunction;
    }

    public static /* synthetic */ j$.util.function.B a(IntToLongFunction intToLongFunction) {
        if (intToLongFunction == null) {
            return null;
        }
        return intToLongFunction instanceof Z ? ((Z) intToLongFunction).a : new Y(intToLongFunction);
    }

    @Override // j$.util.function.B
    public /* synthetic */ long applyAsLong(int i2) {
        return this.a.applyAsLong(i2);
    }
}

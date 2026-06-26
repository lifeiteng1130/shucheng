package j$;

import java.util.function.IntToLongFunction;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class Z implements IntToLongFunction {
    final /* synthetic */ j$.util.function.B a;

    private /* synthetic */ Z(j$.util.function.B b2) {
        this.a = b2;
    }

    public static /* synthetic */ IntToLongFunction a(j$.util.function.B b2) {
        if (b2 == null) {
            return null;
        }
        return b2 instanceof Y ? ((Y) b2).a : new Z(b2);
    }

    @Override // java.util.function.IntToLongFunction
    public /* synthetic */ long applyAsLong(int i2) {
        return this.a.applyAsLong(i2);
    }
}

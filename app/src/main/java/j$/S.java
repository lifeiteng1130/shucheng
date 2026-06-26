package j$;

import java.util.function.IntFunction;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class S implements j$.util.function.z {
    final /* synthetic */ IntFunction a;

    private /* synthetic */ S(IntFunction intFunction) {
        this.a = intFunction;
    }

    public static /* synthetic */ j$.util.function.z a(IntFunction intFunction) {
        if (intFunction == null) {
            return null;
        }
        return intFunction instanceof T ? ((T) intFunction).a : new S(intFunction);
    }

    @Override // j$.util.function.z
    public /* synthetic */ Object apply(int i2) {
        return this.a.apply(i2);
    }
}

package j$;

import java.util.function.IntFunction;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class T implements IntFunction {
    final /* synthetic */ j$.util.function.z a;

    private /* synthetic */ T(j$.util.function.z zVar) {
        this.a = zVar;
    }

    public static /* synthetic */ IntFunction a(j$.util.function.z zVar) {
        if (zVar == null) {
            return null;
        }
        return zVar instanceof S ? ((S) zVar).a : new T(zVar);
    }

    @Override // java.util.function.IntFunction
    public /* synthetic */ Object apply(int i2) {
        return this.a.apply(i2);
    }
}

package j$;

import java.util.function.IntBinaryOperator;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class O implements IntBinaryOperator {
    final /* synthetic */ j$.util.function.x a;

    private /* synthetic */ O(j$.util.function.x xVar) {
        this.a = xVar;
    }

    public static /* synthetic */ IntBinaryOperator a(j$.util.function.x xVar) {
        if (xVar == null) {
            return null;
        }
        return xVar instanceof N ? ((N) xVar).a : new O(xVar);
    }

    @Override // java.util.function.IntBinaryOperator
    public /* synthetic */ int applyAsInt(int i2, int i3) {
        return this.a.applyAsInt(i2, i3);
    }
}

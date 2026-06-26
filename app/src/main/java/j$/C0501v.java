package j$;

import j$.util.function.BiFunction;
import j$.util.function.Function;
import java.util.function.BinaryOperator;

/* JADX INFO: renamed from: j$.v, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class C0501v implements j$.util.function.p {
    final /* synthetic */ BinaryOperator a;

    private /* synthetic */ C0501v(BinaryOperator binaryOperator) {
        this.a = binaryOperator;
    }

    public static /* synthetic */ j$.util.function.p a(BinaryOperator binaryOperator) {
        if (binaryOperator == null) {
            return null;
        }
        return binaryOperator instanceof C0502w ? ((C0502w) binaryOperator).a : new C0501v(binaryOperator);
    }

    @Override // j$.util.function.BiFunction
    public /* synthetic */ BiFunction andThen(Function function) {
        return C0385t.a(this.a.andThen(M.a(function)));
    }

    @Override // j$.util.function.BiFunction
    public /* synthetic */ Object apply(Object obj, Object obj2) {
        return this.a.apply(obj, obj2);
    }
}

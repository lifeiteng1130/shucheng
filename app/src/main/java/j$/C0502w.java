package j$;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;

/* JADX INFO: renamed from: j$.w, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class C0502w implements BinaryOperator {
    final /* synthetic */ j$.util.function.p a;

    private /* synthetic */ C0502w(j$.util.function.p pVar) {
        this.a = pVar;
    }

    public static /* synthetic */ BinaryOperator a(j$.util.function.p pVar) {
        if (pVar == null) {
            return null;
        }
        return pVar instanceof C0501v ? ((C0501v) pVar).a : new C0502w(pVar);
    }

    @Override // java.util.function.BiFunction
    public /* synthetic */ BiFunction andThen(Function function) {
        return C0386u.a(this.a.andThen(L.a(function)));
    }

    @Override // java.util.function.BiFunction
    public /* synthetic */ Object apply(Object obj, Object obj2) {
        return this.a.apply(obj, obj2);
    }
}

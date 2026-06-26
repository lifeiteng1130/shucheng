package j$;

import java.util.function.IntPredicate;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class V implements IntPredicate {
    final /* synthetic */ j$.util.function.A a;

    private /* synthetic */ V(j$.util.function.A a) {
        this.a = a;
    }

    public static /* synthetic */ IntPredicate a(j$.util.function.A a) {
        if (a == null) {
            return null;
        }
        return a instanceof U ? ((U) a).a : new V(a);
    }

    @Override // java.util.function.IntPredicate
    public /* synthetic */ IntPredicate and(IntPredicate intPredicate) {
        return a(U.a(((U) this.a).a.and(a(U.a(intPredicate)))));
    }

    @Override // java.util.function.IntPredicate
    public /* synthetic */ IntPredicate negate() {
        return a(U.a(((U) this.a).a.negate()));
    }

    @Override // java.util.function.IntPredicate
    public /* synthetic */ IntPredicate or(IntPredicate intPredicate) {
        return a(U.a(((U) this.a).a.or(a(U.a(intPredicate)))));
    }

    @Override // java.util.function.IntPredicate
    public /* synthetic */ boolean test(int i2) {
        return ((U) this.a).a.test(i2);
    }
}

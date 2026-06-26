package j$;

import java.util.function.DoublePredicate;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class E implements DoublePredicate {
    final /* synthetic */ j$.util.function.u a;

    private /* synthetic */ E(j$.util.function.u uVar) {
        this.a = uVar;
    }

    public static /* synthetic */ DoublePredicate a(j$.util.function.u uVar) {
        if (uVar == null) {
            return null;
        }
        return uVar instanceof D ? ((D) uVar).a : new E(uVar);
    }

    @Override // java.util.function.DoublePredicate
    public /* synthetic */ DoublePredicate and(DoublePredicate doublePredicate) {
        return a(D.a(((D) this.a).a.and(a(D.a(doublePredicate)))));
    }

    @Override // java.util.function.DoublePredicate
    public /* synthetic */ DoublePredicate negate() {
        return a(D.a(((D) this.a).a.negate()));
    }

    @Override // java.util.function.DoublePredicate
    public /* synthetic */ DoublePredicate or(DoublePredicate doublePredicate) {
        return a(D.a(((D) this.a).a.or(a(D.a(doublePredicate)))));
    }

    @Override // java.util.function.DoublePredicate
    public /* synthetic */ boolean test(double d2) {
        return ((D) this.a).a.test(d2);
    }
}

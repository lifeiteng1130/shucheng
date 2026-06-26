package j$;

import j$.util.function.Predicate;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class w0 implements Predicate {
    final /* synthetic */ java.util.function.Predicate a;

    private /* synthetic */ w0(java.util.function.Predicate predicate) {
        this.a = predicate;
    }

    public static /* synthetic */ Predicate c(java.util.function.Predicate predicate) {
        if (predicate == null) {
            return null;
        }
        return predicate instanceof x0 ? ((x0) predicate).a : new w0(predicate);
    }

    @Override // j$.util.function.Predicate
    public /* synthetic */ Predicate a(Predicate predicate) {
        return c(this.a.or(x0.a(predicate)));
    }

    @Override // j$.util.function.Predicate
    public /* synthetic */ Predicate b(Predicate predicate) {
        return c(this.a.and(x0.a(predicate)));
    }

    @Override // j$.util.function.Predicate
    public /* synthetic */ Predicate negate() {
        return c(this.a.negate());
    }

    @Override // j$.util.function.Predicate
    public /* synthetic */ boolean test(Object obj) {
        return this.a.test(obj);
    }
}

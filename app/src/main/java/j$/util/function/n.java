package j$.util.function;

import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class n implements Predicate {
    public final /* synthetic */ Predicate a;

    public /* synthetic */ n(Predicate predicate) {
        this.a = predicate;
    }

    @Override // j$.util.function.Predicate
    public Predicate a(Predicate predicate) {
        Objects.requireNonNull(predicate);
        return new m(this, predicate);
    }

    @Override // j$.util.function.Predicate
    public Predicate b(Predicate predicate) {
        Objects.requireNonNull(predicate);
        return new o(this, predicate);
    }

    @Override // j$.util.function.Predicate
    public Predicate negate() {
        return new n(this);
    }

    @Override // j$.util.function.Predicate
    public final boolean test(Object obj) {
        return !this.a.test(obj);
    }
}

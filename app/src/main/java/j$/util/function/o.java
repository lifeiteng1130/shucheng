package j$.util.function;

import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class o implements Predicate {
    public final /* synthetic */ Predicate a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Predicate f7996b;

    public /* synthetic */ o(Predicate predicate, Predicate predicate2) {
        this.a = predicate;
        this.f7996b = predicate2;
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
        return this.a.test(obj) && this.f7996b.test(obj);
    }
}

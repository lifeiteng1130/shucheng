package j$.util.stream;

import j$.util.Spliterator;
import j$.util.function.Predicate;
import j$.util.function.Supplier;
import java.util.Objects;

/* JADX INFO: renamed from: j$.util.stream.t1, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
final class C0475t1<T, O> implements g3<T, O> {
    private final U2 a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final boolean f8267b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Object f8268c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final Predicate f8269d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final Supplier f8270e;

    C0475t1(boolean z, U2 u2, Object obj, Predicate predicate, Supplier supplier) {
        this.f8267b = z;
        this.a = u2;
        this.f8268c = obj;
        this.f8269d = predicate;
        this.f8270e = supplier;
    }

    @Override // j$.util.stream.g3
    public int b() {
        return T2.p | (this.f8267b ? 0 : T2.m);
    }

    @Override // j$.util.stream.g3
    public Object c(T1 t1, Spliterator spliterator) {
        return new C0483v1(this, t1, spliterator).invoke();
    }

    @Override // j$.util.stream.g3
    public Object d(T1 t1, Spliterator spliterator) {
        h3 h3Var = (h3) this.f8270e.get();
        AbstractC0428h1 abstractC0428h1 = (AbstractC0428h1) t1;
        Objects.requireNonNull(h3Var);
        abstractC0428h1.m0(abstractC0428h1.u0(h3Var), spliterator);
        Object obj = h3Var.get();
        return obj != null ? obj : this.f8268c;
    }
}

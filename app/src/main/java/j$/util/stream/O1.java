package j$.util.stream;

import j$.util.Spliterator;
import j$.util.function.Supplier;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
final class O1<T> implements g3<T, Boolean> {
    private final U2 a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final N1 f8061b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Supplier f8062c;

    O1(U2 u2, N1 n1, Supplier supplier) {
        this.a = u2;
        this.f8061b = n1;
        this.f8062c = supplier;
    }

    @Override // j$.util.stream.g3
    public int b() {
        return T2.p | T2.m;
    }

    @Override // j$.util.stream.g3
    public Object c(T1 t1, Spliterator spliterator) {
        return new P1(this, t1, spliterator).invoke();
    }

    @Override // j$.util.stream.g3
    public Object d(T1 t1, Spliterator spliterator) {
        M1 m1 = (M1) this.f8062c.get();
        AbstractC0428h1 abstractC0428h1 = (AbstractC0428h1) t1;
        Objects.requireNonNull(m1);
        abstractC0428h1.m0(abstractC0428h1.u0(m1), spliterator);
        return Boolean.valueOf(m1.f8056b);
    }
}

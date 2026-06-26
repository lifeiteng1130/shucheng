package j$.util.stream;

import j$.util.Comparator;
import j$.util.Spliterator;
import j$.util.stream.AbstractC0496y2;
import j$.util.stream.S1;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
final class M2<T> extends AbstractC0496y2.l<T, T> {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final boolean f8057l;
    private final Comparator m;

    M2(AbstractC0428h1 abstractC0428h1) {
        super(abstractC0428h1, U2.REFERENCE, T2.f8135l | T2.f8133j);
        this.f8057l = true;
        this.m = Comparator.CC.a();
    }

    M2(AbstractC0428h1 abstractC0428h1, java.util.Comparator comparator) {
        super(abstractC0428h1, U2.REFERENCE, T2.f8135l | T2.f8134k);
        this.f8057l = false;
        Objects.requireNonNull(comparator);
        this.m = comparator;
    }

    @Override // j$.util.stream.AbstractC0428h1
    public R1 D0(T1 t1, Spliterator spliterator, j$.util.function.z zVar) {
        if (T2.SORTED.n(t1.r0()) && this.f8057l) {
            return t1.o0(spliterator, false, zVar);
        }
        Object[] objArrP = t1.o0(spliterator, true, zVar).p(zVar);
        Arrays.sort(objArrP, this.m);
        return new S1.c(objArrP);
    }

    @Override // j$.util.stream.AbstractC0428h1
    public A2 G0(int i2, A2 a2) {
        Objects.requireNonNull(a2);
        return (T2.SORTED.n(i2) && this.f8057l) ? a2 : T2.SIZED.n(i2) ? new R2(a2, this.m) : new N2(a2, this.m);
    }
}

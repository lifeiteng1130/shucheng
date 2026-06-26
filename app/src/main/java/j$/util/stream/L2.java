package j$.util.stream;

import j$.util.Spliterator;
import j$.util.stream.D1;
import j$.util.stream.R1;
import j$.util.stream.S1;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
final class L2 extends D1.h<Long> {
    L2(AbstractC0428h1 abstractC0428h1) {
        super(abstractC0428h1, U2.LONG_VALUE, T2.f8135l | T2.f8133j);
    }

    @Override // j$.util.stream.AbstractC0428h1
    public R1 D0(T1 t1, Spliterator spliterator, j$.util.function.z zVar) {
        if (T2.SORTED.n(t1.r0())) {
            return t1.o0(spliterator, false, zVar);
        }
        long[] jArr = (long[]) ((R1.d) t1.o0(spliterator, true, zVar)).e();
        Arrays.sort(jArr);
        return new S1.p(jArr);
    }

    @Override // j$.util.stream.AbstractC0428h1
    public A2 G0(int i2, A2 a2) {
        Objects.requireNonNull(a2);
        return T2.SORTED.n(i2) ? a2 : T2.SIZED.n(i2) ? new Q2(a2) : new I2(a2);
    }
}

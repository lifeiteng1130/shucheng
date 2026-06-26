package j$.util.stream;

import j$.util.stream.A2;
import j$.util.stream.AbstractC0499z1;

/* JADX INFO: renamed from: j$.util.stream.q1, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
class C0464q1 extends AbstractC0499z1.k<Double> {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    final /* synthetic */ j$.F f8259l;

    /* JADX INFO: renamed from: j$.util.stream.q1$a */
    class a extends A2.a<Integer> {
        a(A2 a2) {
            super(a2);
        }

        @Override // j$.util.stream.A2.e, j$.util.stream.A2
        public void accept(double d2) {
            this.a.accept(C0464q1.this.f8259l.a(d2));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C0464q1(AbstractC0460p1 abstractC0460p1, AbstractC0428h1 abstractC0428h1, U2 u2, int i2, j$.F f2) {
        super(abstractC0428h1, u2, i2);
        this.f8259l = f2;
    }

    @Override // j$.util.stream.AbstractC0428h1
    A2 G0(int i2, A2 a2) {
        return new a(a2);
    }
}

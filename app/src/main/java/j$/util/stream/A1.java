package j$.util.stream;

import j$.util.stream.A2;
import j$.util.stream.AbstractC0460p1;

/* JADX INFO: loaded from: classes2.dex */
class A1 extends AbstractC0460p1.i<Integer> {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    final /* synthetic */ j$.W f8005l;

    class a extends A2.b<Double> {
        a(A2 a2) {
            super(a2);
        }

        @Override // j$.util.stream.A2.f, j$.util.stream.A2, j$.util.function.y
        public void accept(int i2) {
            this.a.accept(A1.this.f8005l.a(i2));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    A1(AbstractC0499z1 abstractC0499z1, AbstractC0428h1 abstractC0428h1, U2 u2, int i2, j$.W w) {
        super(abstractC0428h1, u2, i2);
        this.f8005l = w;
    }

    @Override // j$.util.stream.AbstractC0428h1
    A2 G0(int i2, A2 a2) {
        return new a(a2);
    }
}

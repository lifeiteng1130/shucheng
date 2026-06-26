package j$.util.stream;

import j$.C0375m0;
import j$.util.stream.A2;
import j$.util.stream.AbstractC0499z1;

/* JADX INFO: loaded from: classes2.dex */
class E1 extends AbstractC0499z1.k<Long> {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    final /* synthetic */ C0375m0 f8038l;

    class a extends A2.c<Integer> {
        a(A2 a2) {
            super(a2);
        }

        @Override // j$.util.stream.A2.g, j$.util.stream.A2
        public void accept(long j2) {
            this.a.accept(E1.this.f8038l.a(j2));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    E1(D1 d1, AbstractC0428h1 abstractC0428h1, U2 u2, int i2, C0375m0 c0375m0) {
        super(abstractC0428h1, u2, i2);
        this.f8038l = c0375m0;
    }

    @Override // j$.util.stream.AbstractC0428h1
    A2 G0(int i2, A2 a2) {
        return new a(a2);
    }
}

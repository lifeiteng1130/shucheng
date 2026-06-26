package j$.util.stream;

import j$.C0371k0;
import j$.util.stream.A2;
import j$.util.stream.AbstractC0460p1;

/* JADX INFO: loaded from: classes2.dex */
class F1 extends AbstractC0460p1.i<Long> {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    final /* synthetic */ C0371k0 f8041l;

    class a extends A2.c<Double> {
        a(A2 a2) {
            super(a2);
        }

        @Override // j$.util.stream.A2.g, j$.util.stream.A2
        public void accept(long j2) {
            this.a.accept(F1.this.f8041l.a(j2));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    F1(D1 d1, AbstractC0428h1 abstractC0428h1, U2 u2, int i2, C0371k0 c0371k0) {
        super(abstractC0428h1, u2, i2);
        this.f8041l = c0371k0;
    }

    @Override // j$.util.stream.AbstractC0428h1
    A2 G0(int i2, A2 a2) {
        return new a(a2);
    }
}

package j$.util.stream;

import j$.util.function.C0392f;
import j$.util.stream.A2;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
class L1 extends M1<Double> implements A2.e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ N1 f8054c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ j$.util.function.u f8055d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    L1(N1 n1, j$.util.function.u uVar) {
        super(n1);
        this.f8054c = n1;
        this.f8055d = uVar;
    }

    @Override // j$.util.stream.M1, j$.util.stream.A2
    public void accept(double d2) {
        if (this.a || ((j$.D) this.f8055d).b(d2) != this.f8054c.f8058b) {
            return;
        }
        this.a = true;
        this.f8056b = this.f8054c.f8059c;
    }

    @Override // j$.util.function.Consumer
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void accept(Double d2) {
        Q1.a(this, d2);
    }

    @Override // j$.util.function.s
    public j$.util.function.s j(j$.util.function.s sVar) {
        Objects.requireNonNull(sVar);
        return new C0392f(this, sVar);
    }
}

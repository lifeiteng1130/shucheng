package j$.util.stream;

import j$.util.function.C0395i;
import j$.util.stream.A2;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
class J1 extends M1<Integer> implements A2.f {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ N1 f8050c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ j$.util.function.A f8051d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    J1(N1 n1, j$.util.function.A a) {
        super(n1);
        this.f8050c = n1;
        this.f8051d = a;
    }

    @Override // j$.util.stream.M1, j$.util.stream.A2, j$.util.function.y
    public void accept(int i2) {
        if (this.a || ((j$.U) this.f8051d).b(i2) != this.f8050c.f8058b) {
            return;
        }
        this.a = true;
        this.f8056b = this.f8050c.f8059c;
    }

    @Override // j$.util.function.Consumer
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void accept(Integer num) {
        Q1.b(this, num);
    }

    @Override // j$.util.function.y
    public j$.util.function.y k(j$.util.function.y yVar) {
        Objects.requireNonNull(yVar);
        return new C0395i(this, yVar);
    }
}

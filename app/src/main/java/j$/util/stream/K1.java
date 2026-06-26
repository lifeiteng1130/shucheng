package j$.util.stream;

import j$.C0367i0;
import j$.util.function.C0396j;
import j$.util.stream.A2;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
class K1 extends M1<Long> implements A2.g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ N1 f8052c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ j$.util.function.G f8053d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    K1(N1 n1, j$.util.function.G g2) {
        super(n1);
        this.f8052c = n1;
        this.f8053d = g2;
    }

    @Override // j$.util.stream.M1, j$.util.stream.A2
    public void accept(long j2) {
        if (this.a || ((C0367i0) this.f8053d).b(j2) != this.f8052c.f8058b) {
            return;
        }
        this.a = true;
        this.f8056b = this.f8052c.f8059c;
    }

    @Override // j$.util.function.Consumer
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void accept(Long l2) {
        Q1.c(this, l2);
    }

    @Override // j$.util.function.E
    public j$.util.function.E f(j$.util.function.E e2) {
        Objects.requireNonNull(e2);
        return new C0396j(this, e2);
    }
}

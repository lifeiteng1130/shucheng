package j$.util.stream;

import j$.util.function.C0396j;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class K0 implements j$.util.function.E {
    public final /* synthetic */ A2 a;

    @Override // j$.util.function.E
    public final void accept(long j2) {
        this.a.accept(j2);
    }

    @Override // j$.util.function.E
    public j$.util.function.E f(j$.util.function.E e2) {
        Objects.requireNonNull(e2);
        return new C0396j(this, e2);
    }
}

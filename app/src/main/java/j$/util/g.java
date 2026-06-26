package j$.util;

import j$.util.function.C0396j;
import j$.util.function.Consumer;
import j$.util.function.E;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class g implements E {
    public final /* synthetic */ Consumer a;

    @Override // j$.util.function.E
    public final void accept(long j2) {
        this.a.accept(Long.valueOf(j2));
    }

    @Override // j$.util.function.E
    public E f(E e2) {
        Objects.requireNonNull(e2);
        return new C0396j(this, e2);
    }
}

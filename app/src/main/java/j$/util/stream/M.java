package j$.util.stream;

import j$.util.function.C0392f;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class M implements j$.util.function.s {
    public final /* synthetic */ A2 a;

    @Override // j$.util.function.s
    public final void accept(double d2) {
        this.a.accept(d2);
    }

    @Override // j$.util.function.s
    public j$.util.function.s j(j$.util.function.s sVar) {
        Objects.requireNonNull(sVar);
        return new C0392f(this, sVar);
    }
}

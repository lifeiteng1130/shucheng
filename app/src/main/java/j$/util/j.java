package j$.util;

import j$.util.function.C0392f;
import j$.util.function.Consumer;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class j implements j$.util.function.s {
    public final /* synthetic */ Consumer a;

    @Override // j$.util.function.s
    public final void accept(double d2) {
        this.a.accept(Double.valueOf(d2));
    }

    @Override // j$.util.function.s
    public j$.util.function.s j(j$.util.function.s sVar) {
        Objects.requireNonNull(sVar);
        return new C0392f(this, sVar);
    }
}

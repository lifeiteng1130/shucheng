package j$.util;

import j$.util.function.C0395i;
import j$.util.function.Consumer;
import j$.util.function.y;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class h implements y {
    public final /* synthetic */ Consumer a;

    @Override // j$.util.function.y
    public final void accept(int i2) {
        this.a.accept(Integer.valueOf(i2));
    }

    @Override // j$.util.function.y
    public y k(y yVar) {
        Objects.requireNonNull(yVar);
        return new C0395i(this, yVar);
    }
}

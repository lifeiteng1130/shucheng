package j$.util.stream;

import j$.util.function.C0395i;
import java.util.Objects;

/* JADX INFO: renamed from: j$.util.stream.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class C0406c implements j$.util.function.y {
    public final /* synthetic */ A2 a;

    @Override // j$.util.function.y
    public final void accept(int i2) {
        this.a.accept(i2);
    }

    @Override // j$.util.function.y
    public j$.util.function.y k(j$.util.function.y yVar) {
        Objects.requireNonNull(yVar);
        return new C0395i(this, yVar);
    }
}

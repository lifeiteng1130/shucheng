package g.b;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: CancellableContinuationImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c1 extends f {
    public final f.c0.b.l<Throwable, f.v> a;

    /* JADX WARN: Multi-variable type inference failed */
    public c1(@NotNull f.c0.b.l<? super Throwable, f.v> lVar) {
        this.a = lVar;
    }

    @Override // g.b.g
    public void a(@Nullable Throwable th) {
        this.a.invoke(th);
    }

    @Override // f.c0.b.l
    public f.v invoke(Throwable th) {
        this.a.invoke(th);
        return f.v.a;
    }

    @NotNull
    public String toString() {
        StringBuilder sbR = c.a.a.a.a.r("InvokeOnCancel[");
        sbR.append(c.b.a.m.f.W1(this.a));
        sbR.append('@');
        sbR.append(c.b.a.m.f.v2(this));
        sbR.append(']');
        return sbR.toString();
    }
}

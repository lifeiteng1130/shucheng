package g.b;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: CancellableContinuation.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class n0 extends f {
    public final m0 a;

    public n0(@NotNull m0 m0Var) {
        this.a = m0Var;
    }

    @Override // g.b.g
    public void a(@Nullable Throwable th) {
        this.a.e();
    }

    @Override // f.c0.b.l
    public f.v invoke(Throwable th) {
        this.a.e();
        return f.v.a;
    }

    @NotNull
    public String toString() {
        StringBuilder sbR = c.a.a.a.a.r("DisposeOnCancel[");
        sbR.append(this.a);
        sbR.append(']');
        return sbR.toString();
    }
}

package g.b;

import java.util.concurrent.Future;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Executors.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class l0 implements m0 {
    public final Future<?> a;

    public l0(@NotNull Future<?> future) {
        this.a = future;
    }

    @Override // g.b.m0
    public void e() {
        this.a.cancel(false);
    }

    @NotNull
    public String toString() {
        StringBuilder sbR = c.a.a.a.a.r("DisposableFutureHandle[");
        sbR.append(this.a);
        sbR.append(']');
        return sbR.toString();
    }
}

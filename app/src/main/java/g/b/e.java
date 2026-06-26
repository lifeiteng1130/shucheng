package g.b;

import java.util.concurrent.Future;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Future.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e extends f {
    public final Future<?> a;

    public e(@NotNull Future<?> future) {
        this.a = future;
    }

    @Override // g.b.g
    public void a(@Nullable Throwable th) {
        this.a.cancel(false);
    }

    @Override // f.c0.b.l
    public f.v invoke(Throwable th) {
        this.a.cancel(false);
        return f.v.a;
    }

    @NotNull
    public String toString() {
        StringBuilder sbR = c.a.a.a.a.r("CancelFutureOnCancel[");
        sbR.append(this.a);
        sbR.append(']');
        return sbR.toString();
    }
}

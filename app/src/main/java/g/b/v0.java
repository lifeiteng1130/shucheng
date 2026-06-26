package g.b;

import g.b.y;
import java.io.Closeable;
import java.util.concurrent.Executor;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Executors.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class v0 extends y implements Closeable {
    static {
        y.a aVar = y.Key;
        u0 u0Var = u0.INSTANCE;
        f.c0.c.j.e(aVar, "baseKey");
        f.c0.c.j.e(u0Var, "safeCast");
    }

    public abstract void close();

    @NotNull
    public abstract Executor n();
}

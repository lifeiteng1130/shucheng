package c.c.a.n;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes.dex */
public final class f {
    public static Executor a = Executors.newCachedThreadPool();

    static {
        Executors.newSingleThreadScheduledExecutor();
    }
}

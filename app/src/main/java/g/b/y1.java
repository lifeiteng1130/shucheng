package g.b;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: EventLoop.common.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class y1 {
    public static final ThreadLocal<q0> a = new ThreadLocal<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public static final y1 f6304b = null;

    @NotNull
    public static final q0 a() {
        ThreadLocal<q0> threadLocal = a;
        q0 q0Var = threadLocal.get();
        if (q0Var != null) {
            return q0Var;
        }
        d dVar = new d(Thread.currentThread());
        threadLocal.set(dVar);
        return dVar;
    }
}

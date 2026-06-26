package g.b;

import java.lang.reflect.Method;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Executors.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class x0 extends w0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public final Executor f6303b;

    public x0(@NotNull Executor executor) {
        Method method;
        this.f6303b = executor;
        Method method2 = g.b.g2.d.a;
        boolean z = false;
        try {
            ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = (ScheduledThreadPoolExecutor) (executor instanceof ScheduledThreadPoolExecutor ? executor : null);
            if (scheduledThreadPoolExecutor != null && (method = g.b.g2.d.a) != null) {
                method.invoke(scheduledThreadPoolExecutor, Boolean.TRUE);
                z = true;
            }
        } catch (Throwable unused) {
        }
        this.a = z;
    }

    @Override // g.b.v0
    @NotNull
    public Executor n() {
        return this.f6303b;
    }
}

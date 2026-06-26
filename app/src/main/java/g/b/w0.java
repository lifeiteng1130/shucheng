package g.b;

import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Executors.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class w0 extends v0 implements h0 {
    public boolean a;

    @Override // g.b.h0
    public void a(long j2, @NotNull h<? super f.v> hVar) {
        ScheduledFuture<?> scheduledFutureP = this.a ? p(new u1(this, hVar), ((i) hVar).f6255f, j2) : null;
        if (scheduledFutureP != null) {
            ((i) hVar).a(new e(scheduledFutureP));
        } else {
            d0.f6179h.a(j2, hVar);
        }
    }

    @Override // g.b.v0, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Executor executorN = n();
        if (!(executorN instanceof ExecutorService)) {
            executorN = null;
        }
        ExecutorService executorService = (ExecutorService) executorN;
        if (executorService != null) {
            executorService.shutdown();
        }
    }

    @Override // g.b.y
    public void dispatch(@NotNull f.z.f fVar, @NotNull Runnable runnable) {
        try {
            n().execute(runnable);
        } catch (RejectedExecutionException e2) {
            o(fVar, e2);
            k0.f6263b.dispatch(fVar, runnable);
        }
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof w0) && ((w0) obj).n() == n();
    }

    @Override // g.b.h0
    @NotNull
    public m0 h(long j2, @NotNull Runnable runnable, @NotNull f.z.f fVar) {
        ScheduledFuture<?> scheduledFutureP = this.a ? p(runnable, fVar, j2) : null;
        return scheduledFutureP != null ? new l0(scheduledFutureP) : d0.f6179h.h(j2, runnable, fVar);
    }

    public int hashCode() {
        return System.identityHashCode(n());
    }

    public final void o(f.z.f fVar, RejectedExecutionException rejectedExecutionException) {
        CancellationException cancellationException = new CancellationException("The task was rejected");
        cancellationException.initCause(rejectedExecutionException);
        f1 f1Var = (f1) fVar.get(f1.N);
        if (f1Var != null) {
            f1Var.k(cancellationException);
        }
    }

    public final ScheduledFuture<?> p(Runnable runnable, f.z.f fVar, long j2) {
        try {
            Executor executorN = n();
            if (!(executorN instanceof ScheduledExecutorService)) {
                executorN = null;
            }
            ScheduledExecutorService scheduledExecutorService = (ScheduledExecutorService) executorN;
            if (scheduledExecutorService != null) {
                return scheduledExecutorService.schedule(runnable, j2, TimeUnit.MILLISECONDS);
            }
            return null;
        } catch (RejectedExecutionException e2) {
            o(fVar, e2);
            return null;
        }
    }

    @Override // g.b.y
    @NotNull
    public String toString() {
        return n().toString();
    }
}

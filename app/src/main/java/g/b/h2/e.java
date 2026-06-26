package g.b.h2;

import g.b.d0;
import g.b.v0;
import java.util.Objects;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Dispatcher.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e extends v0 implements j, Executor {
    public static final /* synthetic */ AtomicIntegerFieldUpdater a = AtomicIntegerFieldUpdater.newUpdater(e.class, "inFlightTasks");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c f6239c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f6240d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f6241e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f6242f;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentLinkedQueue<Runnable> f6238b = new ConcurrentLinkedQueue<>();
    private volatile /* synthetic */ int inFlightTasks = 0;

    public e(@NotNull c cVar, int i2, @Nullable String str, int i3) {
        this.f6239c = cVar;
        this.f6240d = i2;
        this.f6241e = str;
        this.f6242f = i3;
    }

    @Override // g.b.h2.j
    public void b() {
        Runnable runnablePoll = this.f6238b.poll();
        if (runnablePoll != null) {
            c cVar = this.f6239c;
            Objects.requireNonNull(cVar);
            try {
                cVar.a.d(runnablePoll, this, true);
                return;
            } catch (RejectedExecutionException unused) {
                d0.f6179h.v(cVar.a.b(runnablePoll, this));
                return;
            }
        }
        a.decrementAndGet(this);
        Runnable runnablePoll2 = this.f6238b.poll();
        if (runnablePoll2 != null) {
            o(runnablePoll2, true);
        }
    }

    @Override // g.b.v0, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw new IllegalStateException("Close cannot be invoked on LimitingBlockingDispatcher".toString());
    }

    @Override // g.b.y
    public void dispatch(@NotNull f.z.f fVar, @NotNull Runnable runnable) {
        o(runnable, false);
    }

    @Override // g.b.y
    public void dispatchYield(@NotNull f.z.f fVar, @NotNull Runnable runnable) {
        o(runnable, true);
    }

    @Override // java.util.concurrent.Executor
    public void execute(@NotNull Runnable runnable) {
        o(runnable, false);
    }

    @Override // g.b.h2.j
    public int g() {
        return this.f6242f;
    }

    public final void o(Runnable runnable, boolean z) {
        do {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = a;
            if (atomicIntegerFieldUpdater.incrementAndGet(this) <= this.f6240d) {
                c cVar = this.f6239c;
                Objects.requireNonNull(cVar);
                try {
                    cVar.a.d(runnable, this, z);
                    return;
                } catch (RejectedExecutionException unused) {
                    d0.f6179h.v(cVar.a.b(runnable, this));
                    return;
                }
            }
            this.f6238b.add(runnable);
            if (atomicIntegerFieldUpdater.decrementAndGet(this) >= this.f6240d) {
                return;
            } else {
                runnable = this.f6238b.poll();
            }
        } while (runnable != null);
    }

    @Override // g.b.y
    @NotNull
    public String toString() {
        String str = this.f6241e;
        if (str != null) {
            return str;
        }
        return super.toString() + "[dispatcher = " + this.f6239c + ']';
    }
}

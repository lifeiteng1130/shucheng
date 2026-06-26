package g.b;

import androidx.recyclerview.widget.RecyclerView;
import g.b.r0;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: DefaultExecutor.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d0 extends r0 implements Runnable {
    private static volatile Thread _thread;
    private static volatile int debugStatus;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final long f6178g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NotNull
    public static final d0 f6179h;

    static {
        Long l2;
        d0 d0Var = new d0();
        f6179h = d0Var;
        d0Var.q(false);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        try {
            l2 = Long.getLong("kotlinx.coroutines.DefaultExecutor.keepAlive", 1000L);
        } catch (SecurityException unused) {
            l2 = 1000L;
        }
        f6178g = timeUnit.toNanos(l2.longValue());
    }

    public final synchronized void A() {
        if (B()) {
            debugStatus = 3;
            y();
            notifyAll();
        }
    }

    public final boolean B() {
        int i2 = debugStatus;
        return i2 == 2 || i2 == 3;
    }

    @Override // g.b.r0, g.b.h0
    @NotNull
    public m0 h(long j2, @NotNull Runnable runnable, @NotNull f.z.f fVar) {
        long jA = t0.a(j2);
        if (jA >= 4611686018427387903L) {
            return q1.a;
        }
        long jNanoTime = System.nanoTime();
        r0.b bVar = new r0.b(jA + jNanoTime, runnable);
        z(jNanoTime, bVar);
        return bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        boolean zX;
        y1 y1Var = y1.f6304b;
        y1.a.set(this);
        try {
            synchronized (this) {
                if (B()) {
                    z = false;
                } else {
                    z = true;
                    debugStatus = 1;
                    notifyAll();
                }
            }
            if (!z) {
                if (zX) {
                    return;
                } else {
                    return;
                }
            }
            long j2 = Long.MAX_VALUE;
            while (true) {
                Thread.interrupted();
                long jS = s();
                if (jS == RecyclerView.FOREVER_NS) {
                    long jNanoTime = System.nanoTime();
                    if (j2 == RecyclerView.FOREVER_NS) {
                        j2 = f6178g + jNanoTime;
                    }
                    long j3 = j2 - jNanoTime;
                    if (j3 <= 0) {
                        _thread = null;
                        A();
                        if (x()) {
                            return;
                        }
                        u();
                        return;
                    }
                    jS = f.e0.e.a(jS, j3);
                } else {
                    j2 = Long.MAX_VALUE;
                }
                if (jS > 0) {
                    if (B()) {
                        _thread = null;
                        A();
                        if (x()) {
                            return;
                        }
                        u();
                        return;
                    }
                    LockSupport.parkNanos(this, jS);
                }
            }
        } finally {
            _thread = null;
            A();
            if (!x()) {
                u();
            }
        }
    }

    @Override // g.b.s0
    @NotNull
    public Thread u() {
        Thread thread = _thread;
        if (thread == null) {
            synchronized (this) {
                thread = _thread;
                if (thread == null) {
                    thread = new Thread(this, "kotlinx.coroutines.DefaultExecutor");
                    _thread = thread;
                    thread.setDaemon(true);
                    thread.start();
                }
            }
        }
        return thread;
    }
}

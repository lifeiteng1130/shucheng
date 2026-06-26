package g.b;

import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: CommonPool.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class o extends v0 {
    public static final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public static final o f6281b = new o();
    private static volatile Executor pool;

    /* JADX INFO: compiled from: CommonPool.kt */
    public static final class a implements ThreadFactory {
        public final /* synthetic */ AtomicInteger a;

        public a(AtomicInteger atomicInteger) {
            this.a = atomicInteger;
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            StringBuilder sbR = c.a.a.a.a.r("CommonPool-worker-");
            sbR.append(this.a.incrementAndGet());
            Thread thread = new Thread(runnable, sbR.toString());
            thread.setDaemon(true);
            return thread;
        }
    }

    static {
        String property;
        int iIntValue;
        try {
            property = System.getProperty("kotlinx.coroutines.default.parallelism");
        } catch (Throwable unused) {
            property = null;
        }
        if (property != null) {
            Integer numQ = f.h0.k.Q(property);
            if (numQ == null || numQ.intValue() < 1) {
                throw new IllegalStateException(c.a.a.a.a.i("Expected positive number in kotlinx.coroutines.default.parallelism, but has ", property).toString());
            }
            iIntValue = numQ.intValue();
        } else {
            iIntValue = -1;
        }
        a = iIntValue;
    }

    @Override // g.b.v0, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw new IllegalStateException("Close cannot be invoked on CommonPool".toString());
    }

    @Override // g.b.y
    public void dispatch(@NotNull f.z.f fVar, @NotNull Runnable runnable) {
        try {
            Executor executorP = pool;
            if (executorP == null) {
                synchronized (this) {
                    executorP = pool;
                    if (executorP == null) {
                        executorP = p();
                        pool = executorP;
                    }
                }
            }
            executorP.execute(runnable);
        } catch (RejectedExecutionException unused) {
            d0.f6179h.v(runnable);
        }
    }

    public final ExecutorService o() {
        return Executors.newFixedThreadPool(q(), new a(new AtomicInteger()));
    }

    public final ExecutorService p() {
        Class<?> cls;
        ExecutorService executorService;
        Integer num;
        if (System.getSecurityManager() != null) {
            return o();
        }
        ExecutorService executorService2 = null;
        try {
            cls = Class.forName("java.util.concurrent.ForkJoinPool");
        } catch (Throwable unused) {
            cls = null;
        }
        if (cls == null) {
            return o();
        }
        if (a < 0) {
            try {
                Object objInvoke = cls.getMethod("commonPool", new Class[0]).invoke(null, new Object[0]);
                if (!(objInvoke instanceof ExecutorService)) {
                    objInvoke = null;
                }
                executorService = (ExecutorService) objInvoke;
            } catch (Throwable unused2) {
                executorService = null;
            }
            if (executorService != null) {
                Objects.requireNonNull(f6281b);
                executorService.submit(p.a);
                try {
                    Object objInvoke2 = cls.getMethod("getPoolSize", new Class[0]).invoke(executorService, new Object[0]);
                    if (!(objInvoke2 instanceof Integer)) {
                        objInvoke2 = null;
                    }
                    num = (Integer) objInvoke2;
                } catch (Throwable unused3) {
                    num = null;
                }
                if (!(num != null && num.intValue() >= 1)) {
                    executorService = null;
                }
                if (executorService != null) {
                    return executorService;
                }
            }
        }
        try {
            Object objNewInstance = cls.getConstructor(Integer.TYPE).newInstance(Integer.valueOf(f6281b.q()));
            if (!(objNewInstance instanceof ExecutorService)) {
                objNewInstance = null;
            }
            executorService2 = (ExecutorService) objNewInstance;
        } catch (Throwable unused4) {
        }
        return executorService2 != null ? executorService2 : o();
    }

    public final int q() {
        Integer numValueOf = Integer.valueOf(a);
        if (!(numValueOf.intValue() > 0)) {
            numValueOf = null;
        }
        if (numValueOf != null) {
            return numValueOf.intValue();
        }
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors() - 1;
        return iAvailableProcessors >= 1 ? iAvailableProcessors : 1;
    }

    @Override // g.b.y
    @NotNull
    public String toString() {
        return "CommonPool";
    }
}

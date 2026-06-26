package c.b.a.m.q.e0;

import android.os.Process;
import android.os.StrictMode;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: GlideExecutor.java */
/* JADX INFO: loaded from: classes.dex */
public final class a implements ExecutorService {
    public static final long a = TimeUnit.SECONDS.toMillis(10);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile int f382b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ExecutorService f383c;

    /* JADX INFO: renamed from: c.b.a.m.q.e0.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: GlideExecutor.java */
    public static final class ThreadFactoryC0017a implements ThreadFactory {
        public final String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f384b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f385c;

        /* JADX INFO: renamed from: c.b.a.m.q.e0.a$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: GlideExecutor.java */
        public class C0018a extends Thread {
            public C0018a(Runnable runnable, String str) {
                super(runnable, str);
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                Process.setThreadPriority(9);
                if (ThreadFactoryC0017a.this.f384b) {
                    StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectNetwork().penaltyDeath().build());
                }
                try {
                    super.run();
                } catch (Throwable th) {
                    Objects.requireNonNull(ThreadFactoryC0017a.this);
                    ((b.C0019a) b.f386b).a(th);
                }
            }
        }

        public ThreadFactoryC0017a(String str, b bVar, boolean z) {
            this.a = str;
            this.f384b = z;
        }

        @Override // java.util.concurrent.ThreadFactory
        public synchronized Thread newThread(@NonNull Runnable runnable) {
            C0018a c0018a;
            c0018a = new C0018a(runnable, "glide-" + this.a + "-thread-" + this.f385c);
            this.f385c = this.f385c + 1;
            return c0018a;
        }
    }

    /* JADX INFO: compiled from: GlideExecutor.java */
    public interface b {
        public static final b a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f386b;

        /* JADX INFO: renamed from: c.b.a.m.q.e0.a$b$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: GlideExecutor.java */
        public class C0019a implements b {
            public void a(Throwable th) {
                Log.isLoggable("GlideExecutor", 6);
            }
        }

        static {
            C0019a c0019a = new C0019a();
            a = c0019a;
            f386b = c0019a;
        }
    }

    @VisibleForTesting
    public a(ExecutorService executorService) {
        this.f383c = executorService;
    }

    public static int a() {
        if (f382b == 0) {
            f382b = Math.min(4, Runtime.getRuntime().availableProcessors());
        }
        return f382b;
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean awaitTermination(long j2, @NonNull TimeUnit timeUnit) {
        return this.f383c.awaitTermination(j2, timeUnit);
    }

    @Override // java.util.concurrent.Executor
    public void execute(@NonNull Runnable runnable) {
        this.f383c.execute(runnable);
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public <T> List<Future<T>> invokeAll(@NonNull Collection<? extends Callable<T>> collection) {
        return this.f383c.invokeAll(collection);
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public <T> T invokeAny(@NonNull Collection<? extends Callable<T>> collection) {
        return (T) this.f383c.invokeAny(collection);
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isShutdown() {
        return this.f383c.isShutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isTerminated() {
        return this.f383c.isTerminated();
    }

    @Override // java.util.concurrent.ExecutorService
    public void shutdown() {
        this.f383c.shutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public List<Runnable> shutdownNow() {
        return this.f383c.shutdownNow();
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public Future<?> submit(@NonNull Runnable runnable) {
        return this.f383c.submit(runnable);
    }

    public String toString() {
        return this.f383c.toString();
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public <T> List<Future<T>> invokeAll(@NonNull Collection<? extends Callable<T>> collection, long j2, @NonNull TimeUnit timeUnit) {
        return this.f383c.invokeAll(collection, j2, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> T invokeAny(@NonNull Collection<? extends Callable<T>> collection, long j2, @NonNull TimeUnit timeUnit) {
        return (T) this.f383c.invokeAny(collection, j2, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public <T> Future<T> submit(@NonNull Runnable runnable, T t) {
        return this.f383c.submit(runnable, t);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> Future<T> submit(@NonNull Callable<T> callable) {
        return this.f383c.submit(callable);
    }
}

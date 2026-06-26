package c.b.a.m.q;

import android.os.Process;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import c.b.a.m.q.q;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: compiled from: ActiveResources.java */
/* JADX INFO: loaded from: classes.dex */
public final class a {
    public final boolean a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @VisibleForTesting
    public final Map<c.b.a.m.j, b> f314b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ReferenceQueue<q<?>> f315c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public q.a f316d;

    /* JADX INFO: renamed from: c.b.a.m.q.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ActiveResources.java */
    public class ThreadFactoryC0014a implements ThreadFactory {

        /* JADX INFO: renamed from: c.b.a.m.q.a$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: ActiveResources.java */
        public class RunnableC0015a implements Runnable {
            public final /* synthetic */ Runnable a;

            public RunnableC0015a(ThreadFactoryC0014a threadFactoryC0014a, Runnable runnable) {
                this.a = runnable;
            }

            @Override // java.lang.Runnable
            public void run() {
                Process.setThreadPriority(10);
                this.a.run();
            }
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(@NonNull Runnable runnable) {
            return new Thread(new RunnableC0015a(this, runnable), "glide-active-resources");
        }
    }

    /* JADX INFO: compiled from: ActiveResources.java */
    @VisibleForTesting
    public static final class b extends WeakReference<q<?>> {
        public final c.b.a.m.j a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f317b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Nullable
        public w<?> f318c;

        public b(@NonNull c.b.a.m.j jVar, @NonNull q<?> qVar, @NonNull ReferenceQueue<? super q<?>> referenceQueue, boolean z) {
            w<?> wVar;
            super(qVar, referenceQueue);
            Objects.requireNonNull(jVar, "Argument must not be null");
            this.a = jVar;
            if (qVar.a && z) {
                wVar = qVar.f465c;
                Objects.requireNonNull(wVar, "Argument must not be null");
            } else {
                wVar = null;
            }
            this.f318c = wVar;
            this.f317b = qVar.a;
        }
    }

    public a(boolean z) {
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor(new ThreadFactoryC0014a());
        this.f314b = new HashMap();
        this.f315c = new ReferenceQueue<>();
        this.a = z;
        executorServiceNewSingleThreadExecutor.execute(new c.b.a.m.q.b(this));
    }

    public synchronized void a(c.b.a.m.j jVar, q<?> qVar) {
        b bVarPut = this.f314b.put(jVar, new b(jVar, qVar, this.f315c, this.a));
        if (bVarPut != null) {
            bVarPut.f318c = null;
            bVarPut.clear();
        }
    }

    public void b(@NonNull b bVar) {
        w<?> wVar;
        synchronized (this) {
            this.f314b.remove(bVar.a);
            if (bVar.f317b && (wVar = bVar.f318c) != null) {
                this.f316d.a(bVar.a, new q<>(wVar, true, false, bVar.a, this.f316d));
            }
        }
    }
}

package c.b.a.s;

import androidx.annotation.NonNull;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: Executors.java */
/* JADX INFO: loaded from: classes.dex */
public final class d {
    public static final Executor a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Executor f674b = new b();

    /* JADX INFO: compiled from: Executors.java */
    public class a implements Executor {
        @Override // java.util.concurrent.Executor
        public void execute(@NonNull Runnable runnable) {
            i.f().post(runnable);
        }
    }

    /* JADX INFO: compiled from: Executors.java */
    public class b implements Executor {
        @Override // java.util.concurrent.Executor
        public void execute(@NonNull Runnable runnable) {
            runnable.run();
        }
    }
}

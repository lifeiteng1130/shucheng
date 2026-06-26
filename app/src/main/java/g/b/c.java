package g.b;

import java.util.concurrent.locks.LockSupport;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Builders.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c<T> extends a<T> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Thread f6173d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final q0 f6174e;

    public c(@NotNull f.z.f fVar, @NotNull Thread thread, @Nullable q0 q0Var) {
        super(fVar, true);
        this.f6173d = thread;
        this.f6174e = q0Var;
    }

    @Override // g.b.k1
    public void o(@Nullable Object obj) {
        if (!f.c0.c.j.a(Thread.currentThread(), this.f6173d)) {
            LockSupport.unpark(this.f6173d);
        }
    }
}

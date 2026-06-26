package g.b;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: JobSupport.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d1 extends h1 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f6180e = AtomicIntegerFieldUpdater.newUpdater(d1.class, "_invoked");
    private volatile /* synthetic */ int _invoked = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final f.c0.b.l<Throwable, f.v> f6181f;

    /* JADX WARN: Multi-variable type inference failed */
    public d1(@NotNull f.c0.b.l<? super Throwable, f.v> lVar) {
        this.f6181f = lVar;
    }

    @Override // f.c0.b.l
    public /* bridge */ /* synthetic */ f.v invoke(Throwable th) {
        k(th);
        return f.v.a;
    }

    @Override // g.b.u
    public void k(@Nullable Throwable th) {
        if (f6180e.compareAndSet(this, 0, 1)) {
            this.f6181f.invoke(th);
        }
    }
}

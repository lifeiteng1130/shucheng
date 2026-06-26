package g.b;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: JobSupport.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e1 extends j1 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final f.c0.b.l<Throwable, f.v> f6182e;

    /* JADX WARN: Multi-variable type inference failed */
    public e1(@NotNull f.c0.b.l<? super Throwable, f.v> lVar) {
        this.f6182e = lVar;
    }

    @Override // f.c0.b.l
    public f.v invoke(Throwable th) {
        this.f6182e.invoke(th);
        return f.v.a;
    }

    @Override // g.b.u
    public void k(@Nullable Throwable th) {
        this.f6182e.invoke(th);
    }
}

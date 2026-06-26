package g.b;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: JobSupport.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class t1<T> extends j1 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final i<T> f6301e;

    /* JADX WARN: Multi-variable type inference failed */
    public t1(@NotNull i<? super T> iVar) {
        this.f6301e = iVar;
    }

    @Override // f.c0.b.l
    public /* bridge */ /* synthetic */ f.v invoke(Throwable th) {
        k(th);
        return f.v.a;
    }

    @Override // g.b.u
    public void k(@Nullable Throwable th) {
        Object objB = l().B();
        if (objB instanceof s) {
            this.f6301e.resumeWith(f.h.m11constructorimpl(c.b.a.m.f.m1(((s) objB).f6298b)));
        } else {
            this.f6301e.resumeWith(f.h.m11constructorimpl(l1.a(objB)));
        }
    }
}

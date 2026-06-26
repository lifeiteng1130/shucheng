package e.a.a.d.v;

import e.a.a.d.v.e;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: HttpHelper.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class h extends e.c {
    public final /* synthetic */ g.b.h<l> a;

    /* JADX WARN: Multi-variable type inference failed */
    public h(g.b.h<? super l> hVar) {
        this.a = hVar;
    }

    @Override // e.a.a.d.v.e.c
    public void a(@NotNull Throwable th) {
        f.c0.c.j.e(th, com.umeng.analytics.pro.c.O);
        if (this.a.h()) {
            return;
        }
        this.a.g(th);
    }

    @Override // e.a.a.d.v.e.c
    public void b(@NotNull l lVar) {
        f.c0.c.j.e(lVar, "response");
        if (this.a.h()) {
            return;
        }
        this.a.resumeWith(f.h.m11constructorimpl(lVar));
    }
}

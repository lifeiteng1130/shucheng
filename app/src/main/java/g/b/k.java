package g.b;

import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: JobSupport.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class k extends h1 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @JvmField
    @NotNull
    public final i<?> f6262e;

    public k(@NotNull i<?> iVar) {
        this.f6262e = iVar;
    }

    @Override // f.c0.b.l
    public /* bridge */ /* synthetic */ f.v invoke(Throwable th) {
        k(th);
        return f.v.a;
    }

    @Override // g.b.u
    public void k(@Nullable Throwable th) {
        i<?> iVar = this.f6262e;
        Throwable thQ = iVar.q(l());
        boolean zN = false;
        if (iVar.f6260c == 2) {
            f.z.d<?> dVar = iVar.f6256g;
            if (!(dVar instanceof g.b.g2.f)) {
                dVar = null;
            }
            g.b.g2.f fVar = (g.b.g2.f) dVar;
            if (fVar != null) {
                zN = fVar.n(thQ);
            }
        }
        if (zN) {
            return;
        }
        iVar.g(thQ);
        iVar.o();
    }
}

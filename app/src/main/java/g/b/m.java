package g.b;

import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: JobSupport.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class m extends h1 implements l {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @JvmField
    @NotNull
    public final n f6278e;

    public m(@NotNull n nVar) {
        this.f6278e = nVar;
    }

    @Override // g.b.l
    public boolean b(@NotNull Throwable th) {
        return l().s(th);
    }

    @Override // f.c0.b.l
    public /* bridge */ /* synthetic */ f.v invoke(Throwable th) {
        k(th);
        return f.v.a;
    }

    @Override // g.b.u
    public void k(@Nullable Throwable th) {
        this.f6278e.f(l());
    }
}

package g.b.g2;

import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Scopes.kt */
/* JADX INFO: loaded from: classes3.dex */
public class p<T> extends g.b.a<T> implements f.z.j.a.d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @JvmField
    @NotNull
    public final f.z.d<T> f6208d;

    /* JADX WARN: Multi-variable type inference failed */
    public p(@NotNull f.z.f fVar, @NotNull f.z.d<? super T> dVar) {
        super(fVar, true);
        this.f6208d = dVar;
    }

    @Override // g.b.k1
    public final boolean G() {
        return true;
    }

    @Override // g.b.a
    public void T(@Nullable Object obj) {
        f.z.d<T> dVar = this.f6208d;
        dVar.resumeWith(c.b.a.m.f.F4(obj, dVar));
    }

    @Override // f.z.j.a.d
    @Nullable
    public final f.z.j.a.d getCallerFrame() {
        f.z.d<T> dVar = this.f6208d;
        if (!(dVar instanceof f.z.j.a.d)) {
            dVar = null;
        }
        return (f.z.j.a.d) dVar;
    }

    @Override // g.b.k1
    public void o(@Nullable Object obj) {
        g.b(c.b.a.m.f.j3(this.f6208d), c.b.a.m.f.F4(obj, this.f6208d), null, 2);
    }
}

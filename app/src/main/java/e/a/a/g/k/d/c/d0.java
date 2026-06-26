package e.a.a.g.k.d.c;

import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: RssSourceViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "io.legado.app.ui.rss.source.manage.RssSourceViewModel$importDefault$1", f = "RssSourceViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class d0 extends f.z.j.a.g implements f.c0.b.p<g.b.a0, f.z.d<? super f.v>, Object> {
    public int label;

    public d0(f.z.d<? super d0> dVar) {
        super(2, dVar);
    }

    @Override // f.z.j.a.a
    @NotNull
    public final f.z.d<f.v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
        return new d0(dVar);
    }

    @Override // f.c0.b.p
    @Nullable
    public final Object invoke(@NotNull g.b.a0 a0Var, @Nullable f.z.d<? super f.v> dVar) {
        return ((d0) create(a0Var, dVar)).invokeSuspend(f.v.a);
    }

    @Override // f.z.j.a.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        c.b.a.m.f.E5(obj);
        e.a.a.d.m mVar = e.a.a.d.m.a;
        e.a.a.d.m.c();
        return f.v.a;
    }
}

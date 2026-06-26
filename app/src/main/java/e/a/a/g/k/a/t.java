package e.a.a.g.k.a;

import g.b.a0;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: RssSortViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "io.legado.app.ui.rss.article.RssSortViewModel$clearArticles$2", f = "RssSortViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class t extends f.z.j.a.g implements f.c0.b.q<a0, f.v, f.z.d<? super f.v>, Object> {
    public int label;

    public t(f.z.d<? super t> dVar) {
        super(3, dVar);
    }

    @Override // f.c0.b.q
    @Nullable
    public final Object invoke(@NotNull a0 a0Var, @NotNull f.v vVar, @Nullable f.z.d<? super f.v> dVar) {
        return new t(dVar).invokeSuspend(f.v.a);
    }

    @Override // f.z.j.a.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        c.b.a.m.f.E5(obj);
        return f.v.a;
    }
}

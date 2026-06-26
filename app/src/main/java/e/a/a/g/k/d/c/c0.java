package e.a.a.g.k.d.c;

import io.legado.app.ui.rss.source.manage.RssSourceViewModel;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: RssSourceViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "io.legado.app.ui.rss.source.manage.RssSourceViewModel$exportSelection$6", f = "RssSourceViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class c0 extends f.z.j.a.g implements f.c0.b.q<g.b.a0, Throwable, f.z.d<? super f.v>, Object> {
    public /* synthetic */ Object L$0;
    public int label;
    public final /* synthetic */ RssSourceViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c0(RssSourceViewModel rssSourceViewModel, f.z.d<? super c0> dVar) {
        super(3, dVar);
        this.this$0 = rssSourceViewModel;
    }

    @Override // f.c0.b.q
    @Nullable
    public final Object invoke(@NotNull g.b.a0 a0Var, @NotNull Throwable th, @Nullable f.z.d<? super f.v> dVar) {
        c0 c0Var = new c0(this.this$0, dVar);
        c0Var.L$0 = th;
        return c0Var.invokeSuspend(f.v.a);
    }

    @Override // f.z.j.a.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        c.b.a.m.f.E5(obj);
        c.a.a.a.a.A((Throwable) this.L$0, "导出失败\n", this.this$0.b());
        return f.v.a;
    }
}

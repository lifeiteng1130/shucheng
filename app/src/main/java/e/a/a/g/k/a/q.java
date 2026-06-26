package e.a.a.g.k.a;

import g.b.a0;
import io.legado.app.ui.rss.article.RssArticlesViewModel;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: RssArticlesViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "io.legado.app.ui.rss.article.RssArticlesViewModel$loadMore$2", f = "RssArticlesViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class q extends f.z.j.a.g implements f.c0.b.q<a0, Throwable, f.z.d<? super f.v>, Object> {
    public /* synthetic */ Object L$0;
    public int label;
    public final /* synthetic */ RssArticlesViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(RssArticlesViewModel rssArticlesViewModel, f.z.d<? super q> dVar) {
        super(3, dVar);
        this.this$0 = rssArticlesViewModel;
    }

    @Override // f.c0.b.q
    @Nullable
    public final Object invoke(@NotNull a0 a0Var, @NotNull Throwable th, @Nullable f.z.d<? super f.v> dVar) {
        q qVar = new q(this.this$0, dVar);
        qVar.L$0 = th;
        return qVar.invokeSuspend(f.v.a);
    }

    @Override // f.z.j.a.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        c.b.a.m.f.E5(obj);
        ((Throwable) this.L$0).printStackTrace();
        this.this$0.loadFinally.postValue(Boolean.FALSE);
        return f.v.a;
    }
}

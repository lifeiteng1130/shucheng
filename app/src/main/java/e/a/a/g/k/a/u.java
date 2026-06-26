package e.a.a.g.k.a;

import g.b.a0;
import io.legado.app.data.AppDatabaseKt;
import io.legado.app.data.entities.RssArticle;
import io.legado.app.data.entities.RssReadRecord;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: RssSortViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "io.legado.app.ui.rss.article.RssSortViewModel$read$1", f = "RssSortViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class u extends f.z.j.a.g implements f.c0.b.p<a0, f.z.d<? super f.v>, Object> {
    public final /* synthetic */ RssArticle $rssArticle;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u(RssArticle rssArticle, f.z.d<? super u> dVar) {
        super(2, dVar);
        this.$rssArticle = rssArticle;
    }

    @Override // f.z.j.a.a
    @NotNull
    public final f.z.d<f.v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
        return new u(this.$rssArticle, dVar);
    }

    @Override // f.c0.b.p
    @Nullable
    public final Object invoke(@NotNull a0 a0Var, @Nullable f.z.d<? super f.v> dVar) {
        return ((u) create(a0Var, dVar)).invokeSuspend(f.v.a);
    }

    @Override // f.z.j.a.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        c.b.a.m.f.E5(obj);
        AppDatabaseKt.getAppDb().getRssArticleDao().insertRecord(new RssReadRecord(this.$rssArticle.getLink(), false, 2, null));
        return f.v.a;
    }
}

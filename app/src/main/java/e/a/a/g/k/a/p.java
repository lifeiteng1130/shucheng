package e.a.a.g.k.a;

import g.b.a0;
import io.legado.app.data.AppDatabaseKt;
import io.legado.app.data.dao.RssArticleDao;
import io.legado.app.data.entities.RssArticle;
import io.legado.app.model.rss.RssResult;
import io.legado.app.ui.rss.article.RssArticlesViewModel;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: RssArticlesViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "io.legado.app.ui.rss.article.RssArticlesViewModel$loadMore$1", f = "RssArticlesViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class p extends f.z.j.a.g implements f.c0.b.q<a0, RssResult, f.z.d<? super f.v>, Object> {
    public /* synthetic */ Object L$0;
    public int label;
    public final /* synthetic */ RssArticlesViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(RssArticlesViewModel rssArticlesViewModel, f.z.d<? super p> dVar) {
        super(3, dVar);
        this.this$0 = rssArticlesViewModel;
    }

    @Override // f.c0.b.q
    @Nullable
    public final Object invoke(@NotNull a0 a0Var, @NotNull RssResult rssResult, @Nullable f.z.d<? super f.v> dVar) {
        p pVar = new p(this.this$0, dVar);
        pVar.L$0 = rssResult;
        return pVar.invokeSuspend(f.v.a);
    }

    @Override // f.z.j.a.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        c.b.a.m.f.E5(obj);
        RssResult rssResult = (RssResult) this.L$0;
        this.this$0.nextPageUrl = rssResult.getNextPageUrl();
        RssArticlesViewModel rssArticlesViewModel = this.this$0;
        List<RssArticle> articles = rssResult.getArticles();
        Objects.requireNonNull(rssArticlesViewModel);
        if (articles.isEmpty()) {
            rssArticlesViewModel.loadFinally.postValue(Boolean.FALSE);
        } else {
            RssArticle rssArticle = (RssArticle) f.x.e.k(articles);
            if (AppDatabaseKt.getAppDb().getRssArticleDao().get(rssArticle.getOrigin(), rssArticle.getLink()) != null) {
                rssArticlesViewModel.loadFinally.postValue(Boolean.FALSE);
            } else {
                for (RssArticle rssArticle2 : articles) {
                    long j2 = rssArticlesViewModel.order;
                    rssArticlesViewModel.order = (-1) + j2;
                    rssArticle2.setOrder(j2);
                }
                RssArticleDao rssArticleDao = AppDatabaseKt.getAppDb().getRssArticleDao();
                Object[] array = articles.toArray(new RssArticle[0]);
                Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
                RssArticle[] rssArticleArr = (RssArticle[]) array;
                rssArticleDao.insert((RssArticle[]) Arrays.copyOf(rssArticleArr, rssArticleArr.length));
            }
        }
        rssArticlesViewModel.isLoading = false;
        return f.v.a;
    }
}

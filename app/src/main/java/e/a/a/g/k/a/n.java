package e.a.a.g.k.a;

import g.b.a0;
import g.b.k0;
import g.b.o1;
import io.legado.app.data.AppDatabaseKt;
import io.legado.app.data.dao.RssArticleDao;
import io.legado.app.data.entities.RssArticle;
import io.legado.app.data.entities.RssSource;
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
@DebugMetadata(c = "io.legado.app.ui.rss.article.RssArticlesViewModel$loadContent$1", f = "RssArticlesViewModel.kt", i = {}, l = {45}, m = "invokeSuspend", n = {}, s = {})
public final class n extends f.z.j.a.g implements f.c0.b.q<a0, RssResult, f.z.d<? super f.v>, Object> {
    public final /* synthetic */ RssSource $rssSource;
    public /* synthetic */ Object L$0;
    public int label;
    public final /* synthetic */ RssArticlesViewModel this$0;

    /* JADX INFO: compiled from: RssArticlesViewModel.kt */
    @DebugMetadata(c = "io.legado.app.ui.rss.article.RssArticlesViewModel$loadContent$1$1$2", f = "RssArticlesViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class a extends f.z.j.a.g implements f.c0.b.p<a0, f.z.d<? super f.v>, Object> {
        public int label;
        public final /* synthetic */ RssArticlesViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(RssArticlesViewModel rssArticlesViewModel, f.z.d<? super a> dVar) {
            super(2, dVar);
            this.this$0 = rssArticlesViewModel;
        }

        @Override // f.z.j.a.a
        @NotNull
        public final f.z.d<f.v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
            return new a(this.this$0, dVar);
        }

        @Override // f.c0.b.p
        @Nullable
        public final Object invoke(@NotNull a0 a0Var, @Nullable f.z.d<? super f.v> dVar) {
            return ((a) create(a0Var, dVar)).invokeSuspend(f.v.a);
        }

        @Override // f.z.j.a.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            c.b.a.m.f.E5(obj);
            this.this$0.loadFinally.postValue(Boolean.FALSE);
            return f.v.a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(RssArticlesViewModel rssArticlesViewModel, RssSource rssSource, f.z.d<? super n> dVar) {
        super(3, dVar);
        this.this$0 = rssArticlesViewModel;
        this.$rssSource = rssSource;
    }

    @Override // f.c0.b.q
    @Nullable
    public final Object invoke(@NotNull a0 a0Var, @NotNull RssResult rssResult, @Nullable f.z.d<? super f.v> dVar) {
        n nVar = new n(this.this$0, this.$rssSource, dVar);
        nVar.L$0 = rssResult;
        return nVar.invokeSuspend(f.v.a);
    }

    @Override // f.z.j.a.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
        RssArticlesViewModel rssArticlesViewModel;
        RssArticlesViewModel rssArticlesViewModel2;
        f.z.i.a aVar = f.z.i.a.COROUTINE_SUSPENDED;
        int i2 = this.label;
        if (i2 == 0) {
            c.b.a.m.f.E5(obj);
            RssResult rssResult = (RssResult) this.L$0;
            this.this$0.nextPageUrl = rssResult.getNextPageUrl();
            List<RssArticle> articles = rssResult.getArticles();
            RssSource rssSource = this.$rssSource;
            rssArticlesViewModel = this.this$0;
            for (RssArticle rssArticle : articles) {
                long j2 = rssArticlesViewModel.order;
                rssArticlesViewModel.order = (-1) + j2;
                rssArticle.setOrder(j2);
            }
            RssArticleDao rssArticleDao = AppDatabaseKt.getAppDb().getRssArticleDao();
            Object[] array = articles.toArray(new RssArticle[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
            RssArticle[] rssArticleArr = (RssArticle[]) array;
            rssArticleDao.insert((RssArticle[]) Arrays.copyOf(rssArticleArr, rssArticleArr.length));
            String ruleNextPage = rssSource.getRuleNextPage();
            if (!(ruleNextPage == null || ruleNextPage.length() == 0)) {
                AppDatabaseKt.getAppDb().getRssArticleDao().clearOld(rssSource.getSourceUrl(), rssArticlesViewModel.sortName, rssArticlesViewModel.order);
                rssArticlesViewModel.loadFinally.postValue(Boolean.TRUE);
                rssArticlesViewModel.isLoading = false;
                return f.v.a;
            }
            k0 k0Var = k0.f6264c;
            o1 o1Var = g.b.g2.m.f6207b;
            a aVar2 = new a(rssArticlesViewModel, null);
            this.L$0 = rssArticlesViewModel;
            this.label = 1;
            if (c.b.a.m.f.f6(o1Var, aVar2, this) == aVar) {
                return aVar;
            }
            rssArticlesViewModel2 = rssArticlesViewModel;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            rssArticlesViewModel2 = (RssArticlesViewModel) this.L$0;
            c.b.a.m.f.E5(obj);
        }
        rssArticlesViewModel = rssArticlesViewModel2;
        rssArticlesViewModel.isLoading = false;
        return f.v.a;
    }
}

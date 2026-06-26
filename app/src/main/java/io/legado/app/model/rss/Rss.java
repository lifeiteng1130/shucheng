package io.legado.app.model.rss;

import c.b.a.m.f;
import com.umeng.analytics.pro.c;
import e.a.a.d.u.b;
import e.a.a.d.v.l;
import e.a.a.h.x;
import f.c0.b.p;
import f.c0.c.j;
import f.v;
import f.z.d;
import f.z.i.a;
import f.z.j.a.g;
import g.b.a0;
import g.b.k0;
import io.legado.app.data.entities.RssArticle;
import io.legado.app.data.entities.RssSource;
import io.legado.app.model.Debug;
import io.legado.app.model.analyzeRule.AnalyzeRule;
import io.legado.app.model.analyzeRule.AnalyzeUrl;
import io.legado.app.model.analyzeRule.RuleData;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Rss.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0016\u0010\u0017JE\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u000f\u0010\u0010J=\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lio/legado/app/model/rss/Rss;", "", "Lg/b/a0;", "scope", "", "sortName", "sortUrl", "Lio/legado/app/data/entities/RssSource;", "rssSource", "", "page", "Lf/z/f;", c.R, "Le/a/a/d/u/b;", "Lio/legado/app/model/rss/RssResult;", "getArticles", "(Lg/b/a0;Ljava/lang/String;Ljava/lang/String;Lio/legado/app/data/entities/RssSource;ILf/z/f;)Le/a/a/d/u/b;", "Lio/legado/app/data/entities/RssArticle;", "rssArticle", "ruleContent", "getContent", "(Lg/b/a0;Lio/legado/app/data/entities/RssArticle;Ljava/lang/String;Lio/legado/app/data/entities/RssSource;Lf/z/f;)Le/a/a/d/u/b;", "<init>", "()V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class Rss {

    @NotNull
    public static final Rss INSTANCE = new Rss();

    /* JADX INFO: renamed from: io.legado.app.model.rss.Rss$getArticles$1, reason: invalid class name */
    /* JADX INFO: compiled from: Rss.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lg/b/a0;", "Lio/legado/app/model/rss/RssResult;", "<anonymous>", "(Lg/b/a0;)Lio/legado/app/model/rss/RssResult;"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "io.legado.app.model.rss.Rss$getArticles$1", f = "Rss.kt", i = {0}, l = {33}, m = "invokeSuspend", n = {"ruleData"}, s = {"L$0"})
    public static final class AnonymousClass1 extends g implements p<a0, d<? super RssResult>, Object> {
        public final /* synthetic */ int $page;
        public final /* synthetic */ RssSource $rssSource;
        public final /* synthetic */ String $sortName;
        public final /* synthetic */ String $sortUrl;
        public Object L$0;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str, int i2, RssSource rssSource, String str2, d<? super AnonymousClass1> dVar) {
            super(2, dVar);
            this.$sortUrl = str;
            this.$page = i2;
            this.$rssSource = rssSource;
            this.$sortName = str2;
        }

        @Override // f.z.j.a.a
        @NotNull
        public final d<v> create(@Nullable Object obj, @NotNull d<?> dVar) {
            return new AnonymousClass1(this.$sortUrl, this.$page, this.$rssSource, this.$sortName, dVar);
        }

        @Override // f.c0.b.p
        @Nullable
        public final Object invoke(@NotNull a0 a0Var, @Nullable d<? super RssResult> dVar) {
            return ((AnonymousClass1) create(a0Var, dVar)).invokeSuspend(v.a);
        }

        @Override // f.z.j.a.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
            Object strResponse$default;
            RuleData ruleData;
            a aVar = a.COROUTINE_SUSPENDED;
            int i2 = this.label;
            if (i2 == 0) {
                f.E5(obj);
                RuleData ruleData2 = new RuleData();
                AnalyzeUrl analyzeUrl = new AnalyzeUrl(this.$sortUrl, null, new Integer(this.$page), null, null, null, false, null, null, ruleData2, this.$rssSource.getHeaderMap(), 506, null);
                String sourceUrl = this.$rssSource.getSourceUrl();
                this.L$0 = ruleData2;
                this.label = 1;
                strResponse$default = AnalyzeUrl.getStrResponse$default(analyzeUrl, sourceUrl, null, null, this, 6, null);
                if (strResponse$default == aVar) {
                    return aVar;
                }
                ruleData = ruleData2;
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                RuleData ruleData3 = (RuleData) this.L$0;
                f.E5(obj);
                ruleData = ruleData3;
                strResponse$default = obj;
            }
            return RssParserByRule.INSTANCE.parseXML(this.$sortName, this.$sortUrl, ((l) strResponse$default).f5588b, this.$rssSource, ruleData);
        }
    }

    /* JADX INFO: renamed from: io.legado.app.model.rss.Rss$getContent$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Rss.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lg/b/a0;", "", "<anonymous>", "(Lg/b/a0;)Ljava/lang/String;"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "io.legado.app.model.rss.Rss$getContent$1", f = "Rss.kt", i = {}, l = {52}, m = "invokeSuspend", n = {}, s = {})
    public static final class C03381 extends g implements p<a0, d<? super String>, Object> {
        public final /* synthetic */ RssArticle $rssArticle;
        public final /* synthetic */ RssSource $rssSource;
        public final /* synthetic */ String $ruleContent;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C03381(RssArticle rssArticle, RssSource rssSource, String str, d<? super C03381> dVar) {
            super(2, dVar);
            this.$rssArticle = rssArticle;
            this.$rssSource = rssSource;
            this.$ruleContent = str;
        }

        @Override // f.z.j.a.a
        @NotNull
        public final d<v> create(@Nullable Object obj, @NotNull d<?> dVar) {
            return new C03381(this.$rssArticle, this.$rssSource, this.$ruleContent, dVar);
        }

        @Override // f.c0.b.p
        @Nullable
        public final Object invoke(@NotNull a0 a0Var, @Nullable d<? super String> dVar) {
            return ((C03381) create(a0Var, dVar)).invokeSuspend(v.a);
        }

        @Override // f.z.j.a.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
            Object strResponse$default;
            a aVar = a.COROUTINE_SUSPENDED;
            int i2 = this.label;
            if (i2 == 0) {
                f.E5(obj);
                AnalyzeUrl analyzeUrl = new AnalyzeUrl(this.$rssArticle.getLink(), null, null, null, null, this.$rssArticle.getOrigin(), false, null, null, this.$rssArticle, this.$rssSource.getHeaderMap(), 478, null);
                String origin = this.$rssArticle.getOrigin();
                this.label = 1;
                strResponse$default = AnalyzeUrl.getStrResponse$default(analyzeUrl, origin, null, null, this, 6, null);
                if (strResponse$default == aVar) {
                    return aVar;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                f.E5(obj);
                strResponse$default = obj;
            }
            String str = ((l) strResponse$default).f5588b;
            Debug debug = Debug.INSTANCE;
            Debug.log$default(debug, this.$rssSource.getSourceUrl(), j.k("≡获取成功:", this.$rssSource.getSourceUrl()), false, false, false, 0, 60, null);
            Debug.log$default(debug, this.$rssSource.getSourceUrl(), str, false, false, false, 20, 28, null);
            AnalyzeRule analyzeRule = new AnalyzeRule(this.$rssArticle);
            AnalyzeRule content$default = AnalyzeRule.setContent$default(analyzeRule, str, null, 2, null);
            x xVar = x.a;
            content$default.setBaseUrl(x.a(this.$rssArticle.getOrigin(), this.$rssArticle.getLink()));
            return AnalyzeRule.getString$default(analyzeRule, this.$ruleContent, false, (String) null, 6, (Object) null);
        }
    }

    private Rss() {
    }

    public static b getArticles$default(Rss rss, a0 a0Var, String str, String str2, RssSource rssSource, int i2, f.z.f fVar, int i3, Object obj) {
        if ((i3 & 32) != 0) {
            k0 k0Var = k0.f6264c;
            fVar = k0.f6263b;
        }
        return rss.getArticles(a0Var, str, str2, rssSource, i2, fVar);
    }

    public static b getContent$default(Rss rss, a0 a0Var, RssArticle rssArticle, String str, RssSource rssSource, f.z.f fVar, int i2, Object obj) {
        if ((i2 & 16) != 0) {
            k0 k0Var = k0.f6264c;
            fVar = k0.f6263b;
        }
        return rss.getContent(a0Var, rssArticle, str, rssSource, fVar);
    }

    @NotNull
    public final b<RssResult> getArticles(@NotNull a0 scope, @NotNull String sortName, @NotNull String sortUrl, @NotNull RssSource rssSource, int page, @NotNull f.z.f context) {
        j.e(scope, "scope");
        j.e(sortName, "sortName");
        j.e(sortUrl, "sortUrl");
        j.e(rssSource, "rssSource");
        j.e(context, c.R);
        return b.a.a(scope, context, new AnonymousClass1(sortUrl, page, rssSource, sortName, null));
    }

    @NotNull
    public final b<String> getContent(@NotNull a0 scope, @NotNull RssArticle rssArticle, @NotNull String ruleContent, @NotNull RssSource rssSource, @NotNull f.z.f context) {
        j.e(scope, "scope");
        j.e(rssArticle, "rssArticle");
        j.e(ruleContent, "ruleContent");
        j.e(rssSource, "rssSource");
        j.e(context, c.R);
        return b.a.a(scope, context, new C03381(rssArticle, rssSource, ruleContent, null));
    }
}

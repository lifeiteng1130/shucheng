package e.a.a.g.k.c;

import android.content.Intent;
import androidx.view.MutableLiveData;
import f.v;
import g.b.a0;
import io.legado.app.data.AppDatabaseKt;
import io.legado.app.data.entities.RssArticle;
import io.legado.app.data.entities.RssSource;
import io.legado.app.data.entities.RssStar;
import io.legado.app.ui.rss.read.ReadRssViewModel;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ReadRssViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "io.legado.app.ui.rss.read.ReadRssViewModel$initData$1", f = "ReadRssViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class j extends f.z.j.a.g implements f.c0.b.p<a0, f.z.d<? super v>, Object> {
    public final /* synthetic */ Intent $intent;
    public int label;
    public final /* synthetic */ ReadRssViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(Intent intent, ReadRssViewModel readRssViewModel, f.z.d<? super j> dVar) {
        super(2, dVar);
        this.$intent = intent;
        this.this$0 = readRssViewModel;
    }

    @Override // f.z.j.a.a
    @NotNull
    public final f.z.d<v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
        return new j(this.$intent, this.this$0, dVar);
    }

    @Override // f.c0.b.p
    @Nullable
    public final Object invoke(@NotNull a0 a0Var, @Nullable f.z.d<? super v> dVar) {
        return ((j) create(a0Var, dVar)).invokeSuspend(v.a);
    }

    @Override // f.z.j.a.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
        v vVar;
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        c.b.a.m.f.E5(obj);
        String stringExtra = this.$intent.getStringExtra("origin");
        String stringExtra2 = this.$intent.getStringExtra("link");
        v vVar2 = null;
        if (stringExtra == null) {
            return null;
        }
        ReadRssViewModel readRssViewModel = this.this$0;
        RssSource byKey = AppDatabaseKt.getAppDb().getRssSourceDao().getByKey(stringExtra);
        readRssViewModel.rssSource = byKey;
        if (stringExtra2 != null) {
            RssStar rssStar = AppDatabaseKt.getAppDb().getRssStarDao().get(stringExtra, stringExtra2);
            readRssViewModel.rssStar = rssStar;
            RssArticle rssArticle = rssStar == null ? null : rssStar.toRssArticle();
            if (rssArticle == null) {
                rssArticle = AppDatabaseKt.getAppDb().getRssArticleDao().get(stringExtra, stringExtra2);
            }
            readRssViewModel.rssArticle = rssArticle;
            if (rssArticle == null) {
                return null;
            }
            String description = rssArticle.getDescription();
            if (description == null || f.h0.k.s(description)) {
                RssSource rssSource = readRssViewModel.rssSource;
                if (rssSource != null) {
                    String ruleContent = rssSource.getRuleContent();
                    if (ruleContent == null || f.h0.k.s(ruleContent)) {
                        ReadRssViewModel.f(readRssViewModel, rssArticle.getLink(), rssArticle.getOrigin());
                    } else {
                        ReadRssViewModel.e(readRssViewModel, rssArticle, ruleContent);
                    }
                    vVar2 = v.a;
                }
                if (vVar2 == null) {
                    ReadRssViewModel.f(readRssViewModel, rssArticle.getLink(), rssArticle.getOrigin());
                }
            } else {
                MutableLiveData<String> mutableLiveData = readRssViewModel.contentLiveData;
                String description2 = rssArticle.getDescription();
                f.c0.c.j.c(description2);
                mutableLiveData.postValue(description2);
            }
            vVar = v.a;
        } else {
            String ruleContent2 = byKey != null ? byKey.getRuleContent() : null;
            if (ruleContent2 == null || f.h0.k.s(ruleContent2)) {
                ReadRssViewModel.f(readRssViewModel, stringExtra, stringExtra);
            } else {
                RssArticle rssArticle2 = new RssArticle(null, null, null, 0L, null, null, null, null, null, false, null, 2047, null);
                rssArticle2.setOrigin(stringExtra);
                rssArticle2.setLink(stringExtra);
                RssSource rssSource2 = readRssViewModel.rssSource;
                f.c0.c.j.c(rssSource2);
                rssArticle2.setTitle(rssSource2.getSourceName());
                ReadRssViewModel.e(readRssViewModel, rssArticle2, ruleContent2);
            }
            vVar = v.a;
        }
        return vVar;
    }
}

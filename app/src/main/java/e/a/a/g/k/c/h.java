package e.a.a.g.k.c;

import f.v;
import g.b.a0;
import io.legado.app.data.AppDatabaseKt;
import io.legado.app.data.entities.RssArticle;
import io.legado.app.data.entities.RssStar;
import io.legado.app.ui.rss.read.ReadRssViewModel;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ReadRssViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "io.legado.app.ui.rss.read.ReadRssViewModel$favorite$1", f = "ReadRssViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class h extends f.z.j.a.g implements f.c0.b.p<a0, f.z.d<? super v>, Object> {
    public int label;
    public final /* synthetic */ ReadRssViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(ReadRssViewModel readRssViewModel, f.z.d<? super h> dVar) {
        super(2, dVar);
        this.this$0 = readRssViewModel;
    }

    @Override // f.z.j.a.a
    @NotNull
    public final f.z.d<v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
        return new h(this.this$0, dVar);
    }

    @Override // f.c0.b.p
    @Nullable
    public final Object invoke(@NotNull a0 a0Var, @Nullable f.z.d<? super v> dVar) {
        return ((h) create(a0Var, dVar)).invokeSuspend(v.a);
    }

    @Override // f.z.j.a.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
        v vVar;
        RssStar star;
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        c.b.a.m.f.E5(obj);
        ReadRssViewModel readRssViewModel = this.this$0;
        RssStar rssStar = readRssViewModel.rssStar;
        if (rssStar == null) {
            vVar = null;
        } else {
            AppDatabaseKt.getAppDb().getRssStarDao().delete(rssStar.getOrigin(), rssStar.getLink());
            readRssViewModel.rssStar = null;
            vVar = v.a;
        }
        if (vVar != null) {
            return vVar;
        }
        RssArticle rssArticle = this.this$0.rssArticle;
        if (rssArticle == null || (star = rssArticle.toStar()) == null) {
            return null;
        }
        ReadRssViewModel readRssViewModel2 = this.this$0;
        AppDatabaseKt.getAppDb().getRssStarDao().insert(star);
        readRssViewModel2.rssStar = star;
        return v.a;
    }
}

package e.a.a.g.k.d.a;

import c.b.a.m.f;
import f.c0.b.p;
import f.v;
import f.z.j.a.g;
import g.b.a0;
import io.legado.app.data.AppDatabaseKt;
import io.legado.app.ui.rss.source.debug.RssSourceDebugModel;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: RssSourceDebugModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "io.legado.app.ui.rss.source.debug.RssSourceDebugModel$initData$1$1", f = "RssSourceDebugModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class d extends g implements p<a0, f.z.d<? super v>, Object> {
    public final /* synthetic */ String $sourceUrl;
    public int label;
    public final /* synthetic */ RssSourceDebugModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(RssSourceDebugModel rssSourceDebugModel, String str, f.z.d<? super d> dVar) {
        super(2, dVar);
        this.this$0 = rssSourceDebugModel;
        this.$sourceUrl = str;
    }

    @Override // f.z.j.a.a
    @NotNull
    public final f.z.d<v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
        return new d(this.this$0, this.$sourceUrl, dVar);
    }

    @Override // f.c0.b.p
    @Nullable
    public final Object invoke(@NotNull a0 a0Var, @Nullable f.z.d<? super v> dVar) {
        return ((d) create(a0Var, dVar)).invokeSuspend(v.a);
    }

    @Override // f.z.j.a.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        f.E5(obj);
        this.this$0.rssSource = AppDatabaseKt.getAppDb().getRssSourceDao().getByKey(this.$sourceUrl);
        return v.a;
    }
}

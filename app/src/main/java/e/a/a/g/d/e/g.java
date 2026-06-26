package e.a.a.g.d.e;

import f.c0.b.p;
import f.v;
import g.b.a0;
import io.legado.app.data.AppDatabaseKt;
import io.legado.app.ui.book.explore.ExploreShowViewModel;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ExploreShowViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "io.legado.app.ui.book.explore.ExploreShowViewModel$initData$2", f = "ExploreShowViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class g extends f.z.j.a.g implements p<a0, f.z.d<? super v>, Object> {
    public final /* synthetic */ String $exploreUrlParam;
    public final /* synthetic */ String $sourceUrlParam;
    public int label;
    public final /* synthetic */ ExploreShowViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(ExploreShowViewModel exploreShowViewModel, String str, String str2, f.z.d<? super g> dVar) {
        super(2, dVar);
        this.this$0 = exploreShowViewModel;
        this.$exploreUrlParam = str;
        this.$sourceUrlParam = str2;
    }

    @Override // f.z.j.a.a
    @NotNull
    public final f.z.d<v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
        return new g(this.this$0, this.$exploreUrlParam, this.$sourceUrlParam, dVar);
    }

    @Override // f.c0.b.p
    @Nullable
    public final Object invoke(@NotNull a0 a0Var, @Nullable f.z.d<? super v> dVar) {
        return ((g) create(a0Var, dVar)).invokeSuspend(v.a);
    }

    @Override // f.z.j.a.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        c.b.a.m.f.E5(obj);
        ExploreShowViewModel exploreShowViewModel = this.this$0;
        exploreShowViewModel.exploreUrl = this.$exploreUrlParam;
        if (this.$sourceUrlParam != null) {
            exploreShowViewModel.bookSource = AppDatabaseKt.getAppDb().getBookSourceDao().getBookSource(this.$sourceUrlParam);
        }
        ExploreShowViewModel exploreShowViewModel2 = this.this$0;
        exploreShowViewModel2.page = 1;
        exploreShowViewModel2.e();
        return v.a;
    }
}

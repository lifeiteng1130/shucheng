package e.a.a.g.d.e;

import android.content.Intent;
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
@DebugMetadata(c = "io.legado.app.ui.book.explore.ExploreShowViewModel$initData$1", f = "ExploreShowViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class f extends f.z.j.a.g implements p<a0, f.z.d<? super v>, Object> {
    public final /* synthetic */ Intent $intent;
    public int label;
    public final /* synthetic */ ExploreShowViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(Intent intent, ExploreShowViewModel exploreShowViewModel, f.z.d<? super f> dVar) {
        super(2, dVar);
        this.$intent = intent;
        this.this$0 = exploreShowViewModel;
    }

    @Override // f.z.j.a.a
    @NotNull
    public final f.z.d<v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
        return new f(this.$intent, this.this$0, dVar);
    }

    @Override // f.c0.b.p
    @Nullable
    public final Object invoke(@NotNull a0 a0Var, @Nullable f.z.d<? super v> dVar) {
        return ((f) create(a0Var, dVar)).invokeSuspend(v.a);
    }

    @Override // f.z.j.a.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        c.b.a.m.f.E5(obj);
        String stringExtra = this.$intent.getStringExtra("sourceUrl");
        this.this$0.exploreUrl = this.$intent.getStringExtra("exploreUrl");
        ExploreShowViewModel exploreShowViewModel = this.this$0;
        if (exploreShowViewModel.bookSource == null && stringExtra != null) {
            exploreShowViewModel.bookSource = AppDatabaseKt.getAppDb().getBookSourceDao().getBookSource(stringExtra);
        }
        this.this$0.e();
        return v.a;
    }
}

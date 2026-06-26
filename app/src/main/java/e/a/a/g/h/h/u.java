package e.a.a.g.h.h;

import f.v;
import g.b.a0;
import io.legado.app.data.AppDatabaseKt;
import io.legado.app.data.entities.BookSource;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ExploreViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "io.legado.app.ui.main.explore.ExploreViewModel$topSource$1", f = "ExploreViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class u extends f.z.j.a.g implements f.c0.b.p<a0, f.z.d<? super v>, Object> {
    public final /* synthetic */ BookSource $bookSource;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u(BookSource bookSource, f.z.d<? super u> dVar) {
        super(2, dVar);
        this.$bookSource = bookSource;
    }

    @Override // f.z.j.a.a
    @NotNull
    public final f.z.d<v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
        return new u(this.$bookSource, dVar);
    }

    @Override // f.c0.b.p
    @Nullable
    public final Object invoke(@NotNull a0 a0Var, @Nullable f.z.d<? super v> dVar) {
        return ((u) create(a0Var, dVar)).invokeSuspend(v.a);
    }

    @Override // f.z.j.a.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        c.b.a.m.f.E5(obj);
        this.$bookSource.setCustomOrder(AppDatabaseKt.getAppDb().getBookSourceDao().getMinOrder() - 1);
        AppDatabaseKt.getAppDb().getBookSourceDao().insert(this.$bookSource);
        return v.a;
    }
}

package e.a.a.g.b;

import io.legado.app.data.AppDatabaseKt;
import io.legado.app.data.entities.BookSource;
import io.legado.app.ui.association.ImportBookSourceViewModel;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ImportBookSourceViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "io.legado.app.ui.association.ImportBookSourceViewModel$comparisonSource$1", f = "ImportBookSourceViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class u extends f.z.j.a.g implements f.c0.b.p<g.b.a0, f.z.d<? super f.v>, Object> {
    public int label;
    public final /* synthetic */ ImportBookSourceViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u(ImportBookSourceViewModel importBookSourceViewModel, f.z.d<? super u> dVar) {
        super(2, dVar);
        this.this$0 = importBookSourceViewModel;
    }

    @Override // f.z.j.a.a
    @NotNull
    public final f.z.d<f.v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
        return new u(this.this$0, dVar);
    }

    @Override // f.c0.b.p
    @Nullable
    public final Object invoke(@NotNull g.b.a0 a0Var, @Nullable f.z.d<? super f.v> dVar) {
        return ((u) create(a0Var, dVar)).invokeSuspend(f.v.a);
    }

    @Override // f.z.j.a.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        c.b.a.m.f.E5(obj);
        ImportBookSourceViewModel importBookSourceViewModel = this.this$0;
        for (BookSource bookSource : importBookSourceViewModel.allSources) {
            BookSource bookSource2 = AppDatabaseKt.getAppDb().getBookSourceDao().getBookSource(bookSource.getBookSourceUrl());
            importBookSourceViewModel.checkSources.add(bookSource2);
            importBookSourceViewModel.selectStatus.add(Boolean.valueOf(bookSource2 == null || bookSource2.getLastUpdateTime() < bookSource.getLastUpdateTime()));
        }
        ImportBookSourceViewModel importBookSourceViewModel2 = this.this$0;
        importBookSourceViewModel2.successLiveData.postValue(new Integer(importBookSourceViewModel2.allSources.size()));
        return f.v.a;
    }
}

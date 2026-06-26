package e.a.a.g.b;

import io.legado.app.data.AppDatabaseKt;
import io.legado.app.data.entities.RssSource;
import io.legado.app.ui.association.ImportRssSourceViewModel;
import java.util.Iterator;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ImportRssSourceViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "io.legado.app.ui.association.ImportRssSourceViewModel$comparisonSource$1", f = "ImportRssSourceViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class d0 extends f.z.j.a.g implements f.c0.b.p<g.b.a0, f.z.d<? super f.v>, Object> {
    public int label;
    public final /* synthetic */ ImportRssSourceViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d0(ImportRssSourceViewModel importRssSourceViewModel, f.z.d<? super d0> dVar) {
        super(2, dVar);
        this.this$0 = importRssSourceViewModel;
    }

    @Override // f.z.j.a.a
    @NotNull
    public final f.z.d<f.v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
        return new d0(this.this$0, dVar);
    }

    @Override // f.c0.b.p
    @Nullable
    public final Object invoke(@NotNull g.b.a0 a0Var, @Nullable f.z.d<? super f.v> dVar) {
        return ((d0) create(a0Var, dVar)).invokeSuspend(f.v.a);
    }

    @Override // f.z.j.a.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        c.b.a.m.f.E5(obj);
        ImportRssSourceViewModel importRssSourceViewModel = this.this$0;
        Iterator<T> it = importRssSourceViewModel.allSources.iterator();
        while (it.hasNext()) {
            RssSource byKey = AppDatabaseKt.getAppDb().getRssSourceDao().getByKey(((RssSource) it.next()).getSourceUrl());
            importRssSourceViewModel.checkSources.add(byKey);
            importRssSourceViewModel.selectStatus.add(Boolean.valueOf(byKey == null));
        }
        ImportRssSourceViewModel importRssSourceViewModel2 = this.this$0;
        importRssSourceViewModel2.successLiveData.postValue(new Integer(importRssSourceViewModel2.allSources.size()));
        return f.v.a;
    }
}

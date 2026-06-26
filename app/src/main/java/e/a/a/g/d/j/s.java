package e.a.a.g.d.j;

import f.v;
import g.b.a0;
import io.legado.app.data.AppDatabaseKt;
import io.legado.app.data.entities.SearchKeyword;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: SearchViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "io.legado.app.ui.book.search.SearchViewModel$saveSearchKey$1", f = "SearchViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class s extends f.z.j.a.g implements f.c0.b.p<a0, f.z.d<? super v>, Object> {
    public final /* synthetic */ String $key;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(String str, f.z.d<? super s> dVar) {
        super(2, dVar);
        this.$key = str;
    }

    @Override // f.z.j.a.a
    @NotNull
    public final f.z.d<v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
        return new s(this.$key, dVar);
    }

    @Override // f.c0.b.p
    @Nullable
    public final Object invoke(@NotNull a0 a0Var, @Nullable f.z.d<? super v> dVar) {
        return ((s) create(a0Var, dVar)).invokeSuspend(v.a);
    }

    @Override // f.z.j.a.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
        v vVar;
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        c.b.a.m.f.E5(obj);
        SearchKeyword searchKeyword = AppDatabaseKt.getAppDb().getSearchKeywordDao().get(this.$key);
        if (searchKeyword == null) {
            vVar = null;
        } else {
            searchKeyword.setUsage(searchKeyword.getUsage() + 1);
            AppDatabaseKt.getAppDb().getSearchKeywordDao().update(searchKeyword);
            vVar = v.a;
        }
        if (vVar == null) {
            AppDatabaseKt.getAppDb().getSearchKeywordDao().insert(new SearchKeyword(this.$key, 1, 0L, 4, null));
        }
        return v.a;
    }
}

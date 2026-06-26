package io.legado.app.model.webBook;

import c.b.a.m.f;
import f.c0.b.p;
import f.v;
import f.x.e;
import f.z.d;
import f.z.j.a.g;
import g.b.a0;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: SearchBookModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lg/b/a0;", "Lf/v;", "<anonymous>", "(Lg/b/a0;)V"}, k = 3, mv = {1, 5, 1})
@DebugMetadata(c = "io.legado.app.model.webBook.SearchBookModel$search$1$task$2", f = "SearchBookModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class SearchBookModel$search$1$task$2 extends g implements p<a0, d<? super v>, Object> {
    public final /* synthetic */ long $searchId;
    private /* synthetic */ Object L$0;
    public int label;
    public final /* synthetic */ SearchBookModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchBookModel$search$1$task$2(SearchBookModel searchBookModel, long j2, d<? super SearchBookModel$search$1$task$2> dVar) {
        super(2, dVar);
        this.this$0 = searchBookModel;
        this.$searchId = j2;
    }

    @Override // f.z.j.a.a
    @NotNull
    public final d<v> create(@Nullable Object obj, @NotNull d<?> dVar) {
        SearchBookModel$search$1$task$2 searchBookModel$search$1$task$2 = new SearchBookModel$search$1$task$2(this.this$0, this.$searchId, dVar);
        searchBookModel$search$1$task$2.L$0 = obj;
        return searchBookModel$search$1$task$2;
    }

    @Override // f.c0.b.p
    @Nullable
    public final Object invoke(@NotNull a0 a0Var, @Nullable d<? super v> dVar) {
        return ((SearchBookModel$search$1$task$2) create(a0Var, dVar)).invokeSuspend(v.a);
    }

    @Override // f.z.j.a.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
        v vVar;
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        f.E5(obj);
        a0 a0Var = (a0) this.L$0;
        SearchBookModel searchBookModel = this.this$0;
        long j2 = this.$searchId;
        synchronized (a0Var) {
            if (searchBookModel.searchIndex < e.m(searchBookModel.bookSourceList)) {
                searchBookModel.search(j2);
            } else {
                searchBookModel.searchIndex++;
            }
            if (searchBookModel.searchIndex >= e.m(searchBookModel.bookSourceList) + Math.min(searchBookModel.bookSourceList.size(), searchBookModel.getThreadCount())) {
                searchBookModel.callBack.onSearchFinish();
            }
            vVar = v.a;
        }
        return vVar;
    }
}

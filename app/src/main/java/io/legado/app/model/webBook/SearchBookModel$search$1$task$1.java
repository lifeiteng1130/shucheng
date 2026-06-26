package io.legado.app.model.webBook;

import c.b.a.m.f;
import f.c0.b.q;
import f.v;
import f.z.d;
import f.z.j.a.g;
import g.b.a0;
import io.legado.app.data.entities.SearchBook;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: SearchBookModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0003H\u008a@¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lg/b/a0;", "Ljava/util/ArrayList;", "Lio/legado/app/data/entities/SearchBook;", "Lkotlin/collections/ArrayList;", "it", "Lf/v;", "<anonymous>", "(Lg/b/a0;Ljava/util/ArrayList;)V"}, k = 3, mv = {1, 5, 1})
@DebugMetadata(c = "io.legado.app.model.webBook.SearchBookModel$search$1$task$1", f = "SearchBookModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class SearchBookModel$search$1$task$1 extends g implements q<a0, ArrayList<SearchBook>, d<? super v>, Object> {
    public final /* synthetic */ long $searchId;
    public /* synthetic */ Object L$0;
    public int label;
    public final /* synthetic */ SearchBookModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchBookModel$search$1$task$1(long j2, SearchBookModel searchBookModel, d<? super SearchBookModel$search$1$task$1> dVar) {
        super(3, dVar);
        this.$searchId = j2;
        this.this$0 = searchBookModel;
    }

    @Override // f.c0.b.q
    @Nullable
    public final Object invoke(@NotNull a0 a0Var, @NotNull ArrayList<SearchBook> arrayList, @Nullable d<? super v> dVar) {
        SearchBookModel$search$1$task$1 searchBookModel$search$1$task$1 = new SearchBookModel$search$1$task$1(this.$searchId, this.this$0, dVar);
        searchBookModel$search$1$task$1.L$0 = arrayList;
        return searchBookModel$search$1$task$1.invokeSuspend(v.a);
    }

    @Override // f.z.j.a.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        f.E5(obj);
        ArrayList<SearchBook> arrayList = (ArrayList) this.L$0;
        if (this.$searchId == this.this$0.mSearchId) {
            this.this$0.callBack.onSearchSuccess(arrayList);
        }
        return v.a;
    }
}

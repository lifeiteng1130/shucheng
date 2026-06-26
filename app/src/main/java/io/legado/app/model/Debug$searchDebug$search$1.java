package io.legado.app.model;

import c.b.a.m.f;
import f.c0.b.q;
import f.v;
import f.z.d;
import f.z.j.a.g;
import g.b.a0;
import io.legado.app.data.entities.SearchBook;
import io.legado.app.model.webBook.WebBook;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Debug.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0003H\u008a@¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lg/b/a0;", "Ljava/util/ArrayList;", "Lio/legado/app/data/entities/SearchBook;", "Lkotlin/collections/ArrayList;", "searchBooks", "Lf/v;", "<anonymous>", "(Lg/b/a0;Ljava/util/ArrayList;)V"}, k = 3, mv = {1, 5, 1})
@DebugMetadata(c = "io.legado.app.model.Debug$searchDebug$search$1", f = "Debug.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class Debug$searchDebug$search$1 extends g implements q<a0, ArrayList<SearchBook>, d<? super v>, Object> {
    public final /* synthetic */ a0 $scope;
    public final /* synthetic */ WebBook $webBook;
    public /* synthetic */ Object L$0;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Debug$searchDebug$search$1(a0 a0Var, WebBook webBook, d<? super Debug$searchDebug$search$1> dVar) {
        super(3, dVar);
        this.$scope = a0Var;
        this.$webBook = webBook;
    }

    @Override // f.c0.b.q
    @Nullable
    public final Object invoke(@NotNull a0 a0Var, @NotNull ArrayList<SearchBook> arrayList, @Nullable d<? super v> dVar) {
        Debug$searchDebug$search$1 debug$searchDebug$search$1 = new Debug$searchDebug$search$1(this.$scope, this.$webBook, dVar);
        debug$searchDebug$search$1.L$0 = arrayList;
        return debug$searchDebug$search$1.invokeSuspend(v.a);
    }

    @Override // f.z.j.a.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        f.E5(obj);
        ArrayList arrayList = (ArrayList) this.L$0;
        if (!arrayList.isEmpty()) {
            Debug debug = Debug.INSTANCE;
            Debug.log$default(debug, Debug.debugSource, "︽搜索页解析完成", false, false, false, 0, 60, null);
            Debug.log$default(debug, Debug.debugSource, null, false, false, false, 0, 46, null);
            debug.infoDebug(this.$scope, this.$webBook, ((SearchBook) arrayList.get(0)).toBook());
        } else {
            Debug.log$default(Debug.INSTANCE, Debug.debugSource, "︽未获取到书籍", false, false, false, -1, 28, null);
        }
        return v.a;
    }
}

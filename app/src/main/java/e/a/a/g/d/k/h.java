package e.a.a.g.d.k;

import e.a.a.d.k;
import f.c0.b.p;
import f.v;
import g.b.a0;
import io.legado.app.data.AppDatabaseKt;
import io.legado.app.data.entities.Book;
import io.legado.app.ui.book.searchContent.SearchContentViewModel;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: SearchContentViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "io.legado.app.ui.book.searchContent.SearchContentViewModel$initBook$1", f = "SearchContentViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class h extends f.z.j.a.g implements p<a0, f.z.d<? super v>, Object> {
    public final /* synthetic */ String $bookUrl;
    public int label;
    public final /* synthetic */ SearchContentViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(SearchContentViewModel searchContentViewModel, String str, f.z.d<? super h> dVar) {
        super(2, dVar);
        this.this$0 = searchContentViewModel;
        this.$bookUrl = str;
    }

    @Override // f.z.j.a.a
    @NotNull
    public final f.z.d<v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
        return new h(this.this$0, this.$bookUrl, dVar);
    }

    @Override // f.c0.b.p
    @Nullable
    public final Object invoke(@NotNull a0 a0Var, @Nullable f.z.d<? super v> dVar) {
        return ((h) create(a0Var, dVar)).invokeSuspend(v.a);
    }

    @Override // f.z.j.a.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        c.b.a.m.f.E5(obj);
        this.this$0.book = AppDatabaseKt.getAppDb().getBookDao().getBook(this.$bookUrl);
        SearchContentViewModel searchContentViewModel = this.this$0;
        Book book = searchContentViewModel.book;
        if (book == null) {
            return null;
        }
        searchContentViewModel.contentProcessor = new k(book.getName(), book.getOrigin());
        return v.a;
    }
}

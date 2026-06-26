package e.a.a.g.d.d;

import f.v;
import g.b.a0;
import g.b.k0;
import io.legado.app.data.entities.Book;
import io.legado.app.model.webBook.WebBook;
import io.legado.app.ui.book.changesource.ChangeSourceViewModel;
import java.util.Objects;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ChangeSourceViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "io.legado.app.ui.book.changesource.ChangeSourceViewModel$loadBookInfo$1", f = "ChangeSourceViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class l extends f.z.j.a.g implements f.c0.b.q<a0, Book, f.z.d<? super v>, Object> {
    public final /* synthetic */ Book $book;
    public final /* synthetic */ WebBook $webBook;
    public /* synthetic */ Object L$0;
    public int label;
    public final /* synthetic */ ChangeSourceViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(ChangeSourceViewModel changeSourceViewModel, WebBook webBook, Book book, f.z.d<? super l> dVar) {
        super(3, dVar);
        this.this$0 = changeSourceViewModel;
        this.$webBook = webBook;
        this.$book = book;
    }

    @Override // f.c0.b.q
    @Nullable
    public final Object invoke(@NotNull a0 a0Var, @NotNull Book book, @Nullable f.z.d<? super v> dVar) {
        l lVar = new l(this.this$0, this.$webBook, this.$book, dVar);
        lVar.L$0 = book;
        return lVar.invokeSuspend(v.a);
    }

    @Override // f.z.j.a.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        c.b.a.m.f.E5(obj);
        Book book = (Book) this.L$0;
        if (c.b.a.m.f.K2(this.this$0.b(), "changeSourceLoadToc", false, 2)) {
            ChangeSourceViewModel changeSourceViewModel = this.this$0;
            WebBook webBook = this.$webBook;
            Book book2 = this.$book;
            Objects.requireNonNull(changeSourceViewModel);
            e.a.a.d.u.b chapterList$default = WebBook.getChapterList$default(webBook, changeSourceViewModel, book2, null, 4, null);
            k0 k0Var = k0.f6264c;
            chapterList$default.d(k0.f6263b, new n(book2, changeSourceViewModel, null));
            e.a.a.d.u.b.b(chapterList$default, null, new o(null), 1);
        } else {
            this.$book.setLatestChapterTitle(book.getLatestChapterTitle());
            ChangeSourceViewModel.g(this.this$0, this.$book.toSearchBook());
        }
        return v.a;
    }
}

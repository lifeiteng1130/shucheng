package e.a.a.g.d.d;

import f.v;
import g.b.a0;
import io.legado.app.data.entities.Book;
import io.legado.app.data.entities.SearchBook;
import io.legado.app.model.webBook.WebBook;
import io.legado.app.ui.book.changesource.ChangeSourceViewModel;
import java.util.ArrayList;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ChangeSourceViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "io.legado.app.ui.book.changesource.ChangeSourceViewModel$search$task$1", f = "ChangeSourceViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class q extends f.z.j.a.g implements f.c0.b.q<a0, ArrayList<SearchBook>, f.z.d<? super v>, Object> {
    public final /* synthetic */ WebBook $webBook;
    public /* synthetic */ Object L$0;
    public int label;
    public final /* synthetic */ ChangeSourceViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(ChangeSourceViewModel changeSourceViewModel, WebBook webBook, f.z.d<? super q> dVar) {
        super(3, dVar);
        this.this$0 = changeSourceViewModel;
        this.$webBook = webBook;
    }

    @Override // f.c0.b.q
    @Nullable
    public final Object invoke(@NotNull a0 a0Var, @NotNull ArrayList<SearchBook> arrayList, @Nullable f.z.d<? super v> dVar) {
        q qVar = new q(this.this$0, this.$webBook, dVar);
        qVar.L$0 = arrayList;
        return qVar.invokeSuspend(v.a);
    }

    @Override // f.z.j.a.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        c.b.a.m.f.E5(obj);
        ArrayList<SearchBook> arrayList = (ArrayList) this.L$0;
        ChangeSourceViewModel changeSourceViewModel = this.this$0;
        WebBook webBook = this.$webBook;
        for (SearchBook searchBook : arrayList) {
            if (f.c0.c.j.a(searchBook.getName(), changeSourceViewModel.name)) {
                e.a.a.d.e eVar = e.a.a.d.e.a;
                if ((eVar.a() && f.h0.k.d(searchBook.getAuthor(), changeSourceViewModel.author, false, 2)) || !eVar.a()) {
                    String latestChapterTitle = searchBook.getLatestChapterTitle();
                    if (!(latestChapterTitle == null || latestChapterTitle.length() == 0)) {
                        ChangeSourceViewModel.g(changeSourceViewModel, searchBook);
                    } else if (c.b.a.m.f.K2(k.d.a.h.g(), "changeSourceLoadToc", false, 2) || c.b.a.m.f.K2(k.d.a.h.g(), "changeSourceLoadToc", false, 2)) {
                        Book book = searchBook.toBook();
                        e.a.a.d.u.b bookInfo$default = WebBook.getBookInfo$default(webBook, changeSourceViewModel, book, null, false, 12, null);
                        e.a.a.d.u.b.e(bookInfo$default, null, new l(changeSourceViewModel, webBook, book, null), 1);
                        e.a.a.d.u.b.b(bookInfo$default, null, new m(null), 1);
                    } else {
                        ChangeSourceViewModel.g(changeSourceViewModel, searchBook);
                    }
                }
            }
        }
        return v.a;
    }
}

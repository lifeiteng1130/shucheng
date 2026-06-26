package e.a.a.g.d.d;

import f.v;
import g.b.a0;
import io.legado.app.data.entities.Book;
import io.legado.app.data.entities.BookChapter;
import io.legado.app.ui.book.changesource.ChangeSourceViewModel;
import java.util.List;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ChangeSourceViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "io.legado.app.ui.book.changesource.ChangeSourceViewModel$loadBookToc$1", f = "ChangeSourceViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class n extends f.z.j.a.g implements f.c0.b.q<a0, List<? extends BookChapter>, f.z.d<? super v>, Object> {
    public final /* synthetic */ Book $book;
    public /* synthetic */ Object L$0;
    public int label;
    public final /* synthetic */ ChangeSourceViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(Book book, ChangeSourceViewModel changeSourceViewModel, f.z.d<? super n> dVar) {
        super(3, dVar);
        this.$book = book;
        this.this$0 = changeSourceViewModel;
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull a0 a0Var, @NotNull List<BookChapter> list, @Nullable f.z.d<? super v> dVar) {
        n nVar = new n(this.$book, this.this$0, dVar);
        nVar.L$0 = list;
        return nVar.invokeSuspend(v.a);
    }

    @Override // f.c0.b.q
    public /* bridge */ /* synthetic */ Object invoke(a0 a0Var, List<? extends BookChapter> list, f.z.d<? super v> dVar) {
        return invoke2(a0Var, (List<BookChapter>) list, dVar);
    }

    @Override // f.z.j.a.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        c.b.a.m.f.E5(obj);
        List list = (List) this.L$0;
        if (!list.isEmpty()) {
            this.$book.setLatestChapterTitle(((BookChapter) f.x.e.r(list)).getTitle());
            ChangeSourceViewModel.g(this.this$0, this.$book.toSearchBook());
        }
        return v.a;
    }
}

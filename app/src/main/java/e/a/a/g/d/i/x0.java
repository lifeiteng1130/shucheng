package e.a.a.g.d.i;

import io.legado.app.data.entities.Book;
import io.legado.app.data.entities.BookProgress;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ReadBookViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "io.legado.app.ui.book.read.ReadBookViewModel$syncBookProgress$2", f = "ReadBookViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class x0 extends f.z.j.a.g implements f.c0.b.q<g.b.a0, BookProgress, f.z.d<? super f.v>, Object> {
    public final /* synthetic */ f.c0.b.l<BookProgress, f.v> $alertSync;
    public final /* synthetic */ Book $book;
    public /* synthetic */ Object L$0;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public x0(Book book, f.c0.b.l<? super BookProgress, f.v> lVar, f.z.d<? super x0> dVar) {
        super(3, dVar);
        this.$book = book;
        this.$alertSync = lVar;
    }

    @Override // f.c0.b.q
    @Nullable
    public final Object invoke(@NotNull g.b.a0 a0Var, @Nullable BookProgress bookProgress, @Nullable f.z.d<? super f.v> dVar) {
        x0 x0Var = new x0(this.$book, this.$alertSync, dVar);
        x0Var.L$0 = bookProgress;
        return x0Var.invokeSuspend(f.v.a);
    }

    @Override // f.z.j.a.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        c.b.a.m.f.E5(obj);
        BookProgress bookProgress = (BookProgress) this.L$0;
        if (bookProgress != null) {
            Book book = this.$book;
            f.c0.b.l<BookProgress, f.v> lVar = this.$alertSync;
            if (bookProgress.getDurChapterIndex() >= book.getDurChapterIndex() && (bookProgress.getDurChapterIndex() != book.getDurChapterIndex() || bookProgress.getDurChapterPos() >= book.getDurChapterPos())) {
                e.a.a.f.s.k.a.r(bookProgress);
            } else if (lVar != null) {
                lVar.invoke(bookProgress);
            }
        }
        return f.v.a;
    }
}

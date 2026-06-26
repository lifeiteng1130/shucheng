package e.a.a.g.d.m;

import f.v;
import g.b.a0;
import io.legado.app.data.entities.Book;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: TocViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "io.legado.app.ui.book.toc.TocViewModel$reverseToc$2", f = "TocViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class t extends f.z.j.a.g implements f.c0.b.q<a0, Book, f.z.d<? super v>, Object> {
    public final /* synthetic */ f.c0.b.l<Book, v> $success;
    public /* synthetic */ Object L$0;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public t(f.c0.b.l<? super Book, v> lVar, f.z.d<? super t> dVar) {
        super(3, dVar);
        this.$success = lVar;
    }

    @Override // f.c0.b.q
    @Nullable
    public final Object invoke(@NotNull a0 a0Var, @Nullable Book book, @Nullable f.z.d<? super v> dVar) {
        t tVar = new t(this.$success, dVar);
        tVar.L$0 = book;
        return tVar.invokeSuspend(v.a);
    }

    @Override // f.z.j.a.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        c.b.a.m.f.E5(obj);
        Book book = (Book) this.L$0;
        if (book != null) {
            this.$success.invoke(book);
        }
        return v.a;
    }
}

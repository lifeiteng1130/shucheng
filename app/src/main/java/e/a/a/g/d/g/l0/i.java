package e.a.a.g.d.g.l0;

import e.a.a.f.s.k;
import f.c0.b.p;
import f.v;
import g.b.a0;
import io.legado.app.data.AppDatabaseKt;
import io.legado.app.data.entities.Book;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: BookInfoEditViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "io.legado.app.ui.book.info.edit.BookInfoEditViewModel$saveBook$1", f = "BookInfoEditViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class i extends f.z.j.a.g implements p<a0, f.z.d<? super v>, Object> {
    public final /* synthetic */ Book $book;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(Book book, f.z.d<? super i> dVar) {
        super(2, dVar);
        this.$book = book;
    }

    @Override // f.z.j.a.a
    @NotNull
    public final f.z.d<v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
        return new i(this.$book, dVar);
    }

    @Override // f.c0.b.p
    @Nullable
    public final Object invoke(@NotNull a0 a0Var, @Nullable f.z.d<? super v> dVar) {
        return ((i) create(a0Var, dVar)).invokeSuspend(v.a);
    }

    @Override // f.z.j.a.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        c.b.a.m.f.E5(obj);
        k kVar = k.a;
        Book book = k.f5677c;
        if (f.c0.c.j.a(book == null ? null : book.getBookUrl(), this.$book.getBookUrl())) {
            k.f5677c = this.$book;
        }
        AppDatabaseKt.getAppDb().getBookDao().update(this.$book);
        return v.a;
    }
}

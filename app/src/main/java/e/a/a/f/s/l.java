package e.a.a.f.s;

import f.v;
import g.b.a0;
import io.legado.app.data.AppDatabaseKt;
import io.legado.app.data.entities.Book;
import io.legado.app.data.entities.BookChapter;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ReadBook.kt */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "io.legado.app.service.help.ReadBook$download$1$1", f = "ReadBook.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class l extends f.z.j.a.g implements f.c0.b.p<a0, f.z.d<? super v>, Object> {
    public final /* synthetic */ Book $book;
    public final /* synthetic */ int $index;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(Book book, int i2, f.z.d<? super l> dVar) {
        super(2, dVar);
        this.$book = book;
        this.$index = i2;
    }

    @Override // f.z.j.a.a
    @NotNull
    public final f.z.d<v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
        return new l(this.$book, this.$index, dVar);
    }

    @Override // f.c0.b.p
    @Nullable
    public final Object invoke(@NotNull a0 a0Var, @Nullable f.z.d<? super v> dVar) {
        return ((l) create(a0Var, dVar)).invokeSuspend(v.a);
    }

    @Override // f.z.j.a.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        c.b.a.m.f.E5(obj);
        BookChapter chapter = AppDatabaseKt.getAppDb().getBookChapterDao().getChapter(this.$book.getBookUrl(), this.$index);
        v vVar = null;
        if (chapter != null) {
            if (e.a.a.d.g.a.k(this.$book, chapter)) {
                k.a.p(chapter.getIndex());
            } else {
                k.g(k.a, chapter, false, null, 4);
            }
            vVar = v.a;
        }
        if (vVar == null) {
            k.a.p(this.$index);
        }
        return v.a;
    }
}

package e.a.a.g.d.i;

import io.legado.app.data.AppDatabaseKt;
import io.legado.app.data.dao.BookChapterDao;
import io.legado.app.data.entities.Book;
import io.legado.app.data.entities.BookChapter;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ReadBookViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "io.legado.app.ui.book.read.ReadBookViewModel$upChangeDurChapterIndex$1", f = "ReadBookViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class a1 extends f.z.j.a.g implements f.c0.b.p<g.b.a0, f.z.d<? super f.v>, Object> {
    public final /* synthetic */ Book $book;
    public final /* synthetic */ List<BookChapter> $chapters;
    public final /* synthetic */ int $oldTocSize;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a1(Book book, int i2, List<BookChapter> list, f.z.d<? super a1> dVar) {
        super(2, dVar);
        this.$book = book;
        this.$oldTocSize = i2;
        this.$chapters = list;
    }

    @Override // f.z.j.a.a
    @NotNull
    public final f.z.d<f.v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
        return new a1(this.$book, this.$oldTocSize, this.$chapters, dVar);
    }

    @Override // f.c0.b.p
    @Nullable
    public final Object invoke(@NotNull g.b.a0 a0Var, @Nullable f.z.d<? super f.v> dVar) {
        return ((a1) create(a0Var, dVar)).invokeSuspend(f.v.a);
    }

    @Override // f.z.j.a.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        c.b.a.m.f.E5(obj);
        e.a.a.f.s.k kVar = e.a.a.f.s.k.a;
        int iF = e.a.a.d.g.a.f(this.$book.getDurChapterIndex(), this.$oldTocSize, this.$book.getDurChapterTitle(), this.$chapters);
        e.a.a.f.s.k.f5681g = iF;
        this.$book.setDurChapterIndex(iF);
        this.$book.setDurChapterTitle(this.$chapters.get(e.a.a.f.s.k.f5681g).getTitle());
        AppDatabaseKt.getAppDb().getBookDao().update(this.$book);
        BookChapterDao bookChapterDao = AppDatabaseKt.getAppDb().getBookChapterDao();
        Object[] array = this.$chapters.toArray(new BookChapter[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        BookChapter[] bookChapterArr = (BookChapter[]) array;
        bookChapterDao.insert((BookChapter[]) Arrays.copyOf(bookChapterArr, bookChapterArr.length));
        e.a.a.f.s.k.f5680f = this.$chapters.size();
        kVar.u(null);
        kVar.i(true, null);
        return f.v.a;
    }
}

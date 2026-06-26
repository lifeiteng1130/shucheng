package e.a.a.g.d.g;

import io.legado.app.data.AppDatabaseKt;
import io.legado.app.data.dao.BookChapterDao;
import io.legado.app.data.entities.Book;
import io.legado.app.data.entities.BookChapter;
import io.legado.app.ui.book.info.BookInfoViewModel;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: BookInfoViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "io.legado.app.ui.book.info.BookInfoViewModel$upChangeDurChapterIndex$1", f = "BookInfoViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class k0 extends f.z.j.a.g implements f.c0.b.p<g.b.a0, f.z.d<? super f.v>, Object> {
    public final /* synthetic */ Book $book;
    public final /* synthetic */ List<BookChapter> $chapters;
    public final /* synthetic */ int $oldTocSize;
    public int label;
    public final /* synthetic */ BookInfoViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k0(Book book, int i2, List<BookChapter> list, BookInfoViewModel bookInfoViewModel, f.z.d<? super k0> dVar) {
        super(2, dVar);
        this.$book = book;
        this.$oldTocSize = i2;
        this.$chapters = list;
        this.this$0 = bookInfoViewModel;
    }

    @Override // f.z.j.a.a
    @NotNull
    public final f.z.d<f.v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
        return new k0(this.$book, this.$oldTocSize, this.$chapters, this.this$0, dVar);
    }

    @Override // f.c0.b.p
    @Nullable
    public final Object invoke(@NotNull g.b.a0 a0Var, @Nullable f.z.d<? super f.v> dVar) {
        return ((k0) create(a0Var, dVar)).invokeSuspend(f.v.a);
    }

    @Override // f.z.j.a.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        c.b.a.m.f.E5(obj);
        Book book = this.$book;
        book.setDurChapterIndex(e.a.a.d.g.a.f(book.getDurChapterIndex(), this.$oldTocSize, this.$book.getDurChapterTitle(), this.$chapters));
        Book book2 = this.$book;
        book2.setDurChapterTitle(this.$chapters.get(book2.getDurChapterIndex()).getTitle());
        if (this.this$0.inBookshelf) {
            AppDatabaseKt.getAppDb().getBookDao().update(this.$book);
            BookChapterDao bookChapterDao = AppDatabaseKt.getAppDb().getBookChapterDao();
            Object[] array = this.$chapters.toArray(new BookChapter[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
            BookChapter[] bookChapterArr = (BookChapter[]) array;
            bookChapterDao.insert((BookChapter[]) Arrays.copyOf(bookChapterArr, bookChapterArr.length));
        }
        this.this$0.bookData.postValue(this.$book);
        this.this$0.chapterListData.postValue(this.$chapters);
        return f.v.a;
    }
}

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
@DebugMetadata(c = "io.legado.app.ui.book.info.BookInfoViewModel$addToBookshelf$1", f = "BookInfoViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class b0 extends f.z.j.a.g implements f.c0.b.p<g.b.a0, f.z.d<? super f.v>, Object> {
    public int label;
    public final /* synthetic */ BookInfoViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b0(BookInfoViewModel bookInfoViewModel, f.z.d<? super b0> dVar) {
        super(2, dVar);
        this.this$0 = bookInfoViewModel;
    }

    @Override // f.z.j.a.a
    @NotNull
    public final f.z.d<f.v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
        return new b0(this.this$0, dVar);
    }

    @Override // f.c0.b.p
    @Nullable
    public final Object invoke(@NotNull g.b.a0 a0Var, @Nullable f.z.d<? super f.v> dVar) {
        return ((b0) create(a0Var, dVar)).invokeSuspend(f.v.a);
    }

    @Override // f.z.j.a.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        c.b.a.m.f.E5(obj);
        Book value = this.this$0.bookData.getValue();
        if (value != null) {
            if (value.getOrder() == 0) {
                value.setOrder(AppDatabaseKt.getAppDb().getBookDao().getMaxOrder() + 1);
            }
            Book book = AppDatabaseKt.getAppDb().getBookDao().getBook(value.getName(), value.getAuthor());
            if (book != null) {
                value.setDurChapterPos(book.getDurChapterPos());
                value.setDurChapterTitle(book.getDurChapterTitle());
            }
            AppDatabaseKt.getAppDb().getBookDao().insert(value);
        }
        List<BookChapter> value2 = this.this$0.chapterListData.getValue();
        if (value2 != null) {
            BookChapterDao bookChapterDao = AppDatabaseKt.getAppDb().getBookChapterDao();
            Object[] array = value2.toArray(new BookChapter[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
            BookChapter[] bookChapterArr = (BookChapter[]) array;
            bookChapterDao.insert((BookChapter[]) Arrays.copyOf(bookChapterArr, bookChapterArr.length));
        }
        this.this$0.inBookshelf = true;
        return f.v.a;
    }
}

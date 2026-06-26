package e.a.a.g.d.f;

import f.c0.b.p;
import f.v;
import g.b.a0;
import io.legado.app.data.AppDatabaseKt;
import io.legado.app.data.dao.BookDao;
import io.legado.app.data.dao.BookGroupDao;
import io.legado.app.data.entities.Book;
import io.legado.app.data.entities.BookGroup;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: GroupViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "io.legado.app.ui.book.group.GroupViewModel$delGroup$1", f = "GroupViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class o extends f.z.j.a.g implements p<a0, f.z.d<? super v>, Object> {
    public final /* synthetic */ BookGroup[] $bookGroup;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(BookGroup[] bookGroupArr, f.z.d<? super o> dVar) {
        super(2, dVar);
        this.$bookGroup = bookGroupArr;
    }

    @Override // f.z.j.a.a
    @NotNull
    public final f.z.d<v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
        return new o(this.$bookGroup, dVar);
    }

    @Override // f.c0.b.p
    @Nullable
    public final Object invoke(@NotNull a0 a0Var, @Nullable f.z.d<? super v> dVar) {
        return ((o) create(a0Var, dVar)).invokeSuspend(v.a);
    }

    @Override // f.z.j.a.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        c.b.a.m.f.E5(obj);
        BookGroupDao bookGroupDao = AppDatabaseKt.getAppDb().getBookGroupDao();
        BookGroup[] bookGroupArr = this.$bookGroup;
        bookGroupDao.delete((BookGroup[]) Arrays.copyOf(bookGroupArr, bookGroupArr.length));
        for (BookGroup bookGroup : this.$bookGroup) {
            List<Book> booksByGroup = AppDatabaseKt.getAppDb().getBookDao().getBooksByGroup(bookGroup.getGroupId());
            for (Book book : booksByGroup) {
                book.setGroup(book.getGroup() - bookGroup.getGroupId());
            }
            BookDao bookDao = AppDatabaseKt.getAppDb().getBookDao();
            Object[] array = booksByGroup.toArray(new Book[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
            Book[] bookArr = (Book[]) array;
            bookDao.update((Book[]) Arrays.copyOf(bookArr, bookArr.length));
        }
        return v.a;
    }
}

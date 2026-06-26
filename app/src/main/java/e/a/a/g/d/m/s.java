package e.a.a.g.d.m;

import f.v;
import g.b.a0;
import io.legado.app.data.AppDatabaseKt;
import io.legado.app.data.dao.BookChapterDao;
import io.legado.app.data.entities.Book;
import io.legado.app.data.entities.BookChapter;
import io.legado.app.ui.book.toc.TocViewModel;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: TocViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "io.legado.app.ui.book.toc.TocViewModel$reverseToc$1", f = "TocViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class s extends f.z.j.a.g implements f.c0.b.p<a0, f.z.d<? super Book>, Object> {
    public int label;
    public final /* synthetic */ TocViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(TocViewModel tocViewModel, f.z.d<? super s> dVar) {
        super(2, dVar);
        this.this$0 = tocViewModel;
    }

    @Override // f.z.j.a.a
    @NotNull
    public final f.z.d<v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
        return new s(this.this$0, dVar);
    }

    @Override // f.c0.b.p
    @Nullable
    public final Object invoke(@NotNull a0 a0Var, @Nullable f.z.d<? super Book> dVar) {
        return ((s) create(a0Var, dVar)).invokeSuspend(v.a);
    }

    @Override // f.z.j.a.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        c.b.a.m.f.E5(obj);
        Book value = this.this$0.bookData.getValue();
        if (value == null) {
            return null;
        }
        value.setReverseToc(!value.getReverseToc());
        List listZ = f.x.e.z(AppDatabaseKt.getAppDb().getBookChapterDao().getChapterList(value.getBookUrl()));
        int i2 = 0;
        for (Object obj2 : listZ) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                f.x.e.D();
                throw null;
            }
            ((BookChapter) obj2).setIndex(new Integer(i2).intValue());
            i2 = i3;
        }
        BookChapterDao bookChapterDao = AppDatabaseKt.getAppDb().getBookChapterDao();
        Object[] array = listZ.toArray(new BookChapter[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        BookChapter[] bookChapterArr = (BookChapter[]) array;
        bookChapterDao.insert((BookChapter[]) Arrays.copyOf(bookChapterArr, bookChapterArr.length));
        return value;
    }
}

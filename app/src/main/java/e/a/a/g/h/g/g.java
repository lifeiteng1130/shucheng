package e.a.a.g.h.g;

import e.a.a.h.x;
import f.c0.b.p;
import f.c0.b.q;
import f.c0.c.s;
import f.v;
import g.b.a0;
import g.b.k0;
import io.legado.app.data.AppDatabaseKt;
import io.legado.app.data.entities.Book;
import io.legado.app.data.entities.BookSource;
import io.legado.app.model.webBook.WebBook;
import java.util.List;
import java.util.Objects;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: BookshelfViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "io.legado.app.ui.main.bookshelf.BookshelfViewModel$addBookByUrl$1", f = "BookshelfViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class g extends f.z.j.a.g implements p<a0, f.z.d<? super v>, Object> {
    public final /* synthetic */ String $bookUrls;
    public final /* synthetic */ s $successCount;
    private /* synthetic */ Object L$0;
    public int label;

    /* JADX INFO: compiled from: BookshelfViewModel.kt */
    @DebugMetadata(c = "io.legado.app.ui.main.bookshelf.BookshelfViewModel$addBookByUrl$1$2$1", f = "BookshelfViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class a extends f.z.j.a.g implements q<a0, Book, f.z.d<? super v>, Object> {
        public final /* synthetic */ s $successCount;
        public /* synthetic */ Object L$0;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(s sVar, f.z.d<? super a> dVar) {
            super(3, dVar);
            this.$successCount = sVar;
        }

        @Override // f.c0.b.q
        @Nullable
        public final Object invoke(@NotNull a0 a0Var, @NotNull Book book, @Nullable f.z.d<? super v> dVar) {
            a aVar = new a(this.$successCount, dVar);
            aVar.L$0 = book;
            return aVar.invokeSuspend(v.a);
        }

        @Override // f.z.j.a.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            c.b.a.m.f.E5(obj);
            Book book = (Book) this.L$0;
            book.setOrder(AppDatabaseKt.getAppDb().getBookDao().getMaxOrder() + 1);
            AppDatabaseKt.getAppDb().getBookDao().insert(book);
            this.$successCount.element++;
            return v.a;
        }
    }

    /* JADX INFO: compiled from: BookshelfViewModel.kt */
    @DebugMetadata(c = "io.legado.app.ui.main.bookshelf.BookshelfViewModel$addBookByUrl$1$2$2", f = "BookshelfViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class b extends f.z.j.a.g implements q<a0, Throwable, f.z.d<? super v>, Object> {
        public /* synthetic */ Object L$0;
        public int label;

        public b(f.z.d<? super b> dVar) {
            super(3, dVar);
        }

        @Override // f.c0.b.q
        @Nullable
        public final Object invoke(@NotNull a0 a0Var, @NotNull Throwable th, @Nullable f.z.d<? super v> dVar) {
            b bVar = new b(dVar);
            bVar.L$0 = th;
            return bVar.invokeSuspend(v.a);
        }

        @Override // f.z.j.a.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws Exception {
            f.z.i.a aVar = f.z.i.a.COROUTINE_SUSPENDED;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            c.b.a.m.f.E5(obj);
            throw new Exception(((Throwable) this.L$0).getLocalizedMessage());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(String str, s sVar, f.z.d<? super g> dVar) {
        super(2, dVar);
        this.$bookUrls = str;
        this.$successCount = sVar;
    }

    @Override // f.z.j.a.a
    @NotNull
    public final f.z.d<v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
        g gVar = new g(this.$bookUrls, this.$successCount, dVar);
        gVar.L$0 = obj;
        return gVar;
    }

    @Override // f.c0.b.p
    @Nullable
    public final Object invoke(@NotNull a0 a0Var, @Nullable f.z.d<? super v> dVar) {
        return ((g) create(a0Var, dVar)).invokeSuspend(v.a);
    }

    @Override // f.z.j.a.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        c.b.a.m.f.E5(obj);
        a0 a0Var = (a0) this.L$0;
        List<BookSource> hasBookUrlPattern = null;
        for (String str : f.h0.k.F(this.$bookUrls, new String[]{"\n"}, false, 0, 6)) {
            Objects.requireNonNull(str, "null cannot be cast to non-null type kotlin.CharSequence");
            String string = f.h0.k.R(str).toString();
            if (!(string.length() == 0) && AppDatabaseKt.getAppDb().getBookDao().getBook(string) == null) {
                x xVar = x.a;
                String strC = x.c(string);
                if (strC != null) {
                    BookSource bookSource = AppDatabaseKt.getAppDb().getBookSourceDao().getBookSource(strC);
                    if (bookSource == null) {
                        if (hasBookUrlPattern == null) {
                            hasBookUrlPattern = AppDatabaseKt.getAppDb().getBookSourceDao().getHasBookUrlPattern();
                        }
                        for (BookSource bookSource2 : hasBookUrlPattern) {
                            String bookUrlPattern = bookSource2.getBookUrlPattern();
                            f.c0.c.j.c(bookUrlPattern);
                            if (new f.h0.g(bookUrlPattern).matches(string)) {
                                bookSource = bookSource2;
                            }
                        }
                    }
                    List<BookSource> list = hasBookUrlPattern;
                    if (bookSource != null) {
                        s sVar = this.$successCount;
                        e.a.a.d.u.b bookInfo$default = WebBook.getBookInfo$default(new WebBook(bookSource), a0Var, new Book(string, null, bookSource.getBookSourceUrl(), bookSource.getBookSourceName(), null, null, null, null, null, null, null, null, null, 0, 0L, null, 0L, 0L, 0, 0, null, 0, 0, 0L, null, false, 0, 0, null, null, 1073741810, null), null, false, 12, null);
                        k0 k0Var = k0.f6264c;
                        bookInfo$default.d(k0.f6263b, new a(sVar, null));
                        e.a.a.d.u.b.b(bookInfo$default, null, new b(null), 1);
                    }
                    hasBookUrlPattern = list;
                }
            }
        }
        return v.a;
    }
}

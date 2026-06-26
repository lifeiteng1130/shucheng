package e.a.a.g.d.g;

import io.legado.app.data.AppDatabaseKt;
import io.legado.app.data.dao.BookDao;
import io.legado.app.data.entities.Book;
import io.legado.app.ui.book.info.BookInfoActivity;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: BookInfoActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "io.legado.app.ui.book.info.BookInfoActivity$tocActivityResult$1$1$1$1", f = "BookInfoActivity.kt", i = {}, l = {63}, m = "invokeSuspend", n = {}, s = {})
public final class a0 extends f.z.j.a.g implements f.c0.b.p<g.b.a0, f.z.d<? super f.v>, Object> {
    public final /* synthetic */ Book $book;
    public final /* synthetic */ f.g<Integer, Integer> $it;
    public int label;
    public final /* synthetic */ BookInfoActivity this$0;

    /* JADX INFO: compiled from: BookInfoActivity.kt */
    @DebugMetadata(c = "io.legado.app.ui.book.info.BookInfoActivity$tocActivityResult$1$1$1$1$1", f = "BookInfoActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class a extends f.z.j.a.g implements f.c0.b.p<g.b.a0, f.z.d<? super f.v>, Object> {
        public final /* synthetic */ Book $book;
        public final /* synthetic */ f.g<Integer, Integer> $it;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Book book, f.g<Integer, Integer> gVar, f.z.d<? super a> dVar) {
            super(2, dVar);
            this.$book = book;
            this.$it = gVar;
        }

        @Override // f.z.j.a.a
        @NotNull
        public final f.z.d<f.v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
            return new a(this.$book, this.$it, dVar);
        }

        @Override // f.c0.b.p
        @Nullable
        public final Object invoke(@NotNull g.b.a0 a0Var, @Nullable f.z.d<? super f.v> dVar) {
            return ((a) create(a0Var, dVar)).invokeSuspend(f.v.a);
        }

        @Override // f.z.j.a.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            c.b.a.m.f.E5(obj);
            this.$book.setDurChapterIndex(this.$it.getFirst().intValue());
            this.$book.setDurChapterPos(this.$it.getSecond().intValue());
            BookDao bookDao = AppDatabaseKt.getAppDb().getBookDao();
            Book book = this.$book;
            f.c0.c.j.d(book, "book");
            bookDao.update(book);
            return f.v.a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a0(BookInfoActivity bookInfoActivity, Book book, f.g<Integer, Integer> gVar, f.z.d<? super a0> dVar) {
        super(2, dVar);
        this.this$0 = bookInfoActivity;
        this.$book = book;
        this.$it = gVar;
    }

    @Override // f.z.j.a.a
    @NotNull
    public final f.z.d<f.v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
        return new a0(this.this$0, this.$book, this.$it, dVar);
    }

    @Override // f.c0.b.p
    @Nullable
    public final Object invoke(@NotNull g.b.a0 a0Var, @Nullable f.z.d<? super f.v> dVar) {
        return ((a0) create(a0Var, dVar)).invokeSuspend(f.v.a);
    }

    @Override // f.z.j.a.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
        f.z.i.a aVar = f.z.i.a.COROUTINE_SUSPENDED;
        int i2 = this.label;
        if (i2 == 0) {
            c.b.a.m.f.E5(obj);
            g.b.k0 k0Var = g.b.k0.f6264c;
            g.b.y yVar = g.b.k0.f6263b;
            a aVar2 = new a(this.$book, this.$it, null);
            this.label = 1;
            if (c.b.a.m.f.f6(yVar, aVar2, this) == aVar) {
                return aVar;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            c.b.a.m.f.E5(obj);
        }
        BookInfoActivity bookInfoActivity = this.this$0;
        Book book = this.$book;
        f.c0.c.j.d(book, "book");
        BookInfoActivity.T0(bookInfoActivity, book);
        return f.v.a;
    }
}

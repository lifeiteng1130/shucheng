package io.legado.app.ui.book.arrange;

import android.app.Application;
import c.b.a.m.f;
import f.c0.b.p;
import f.c0.c.j;
import f.v;
import f.z.d;
import f.z.j.a.g;
import g.b.a0;
import io.legado.app.base.BaseViewModel;
import io.legado.app.data.AppDatabaseKt;
import io.legado.app.data.dao.BookDao;
import io.legado.app.data.entities.Book;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ArrangeBookViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J#\u0010\b\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ!\u0010\u000b\u001a\u00020\u00072\u0012\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002\"\u00020\u0003¢\u0006\u0004\b\u000b\u0010\fJ!\u0010\r\u001a\u00020\u00072\u0012\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002\"\u00020\u0003¢\u0006\u0004\b\r\u0010\f¨\u0006\u0012"}, d2 = {"Lio/legado/app/ui/book/arrange/ArrangeBookViewModel;", "Lio/legado/app/base/BaseViewModel;", "", "Lio/legado/app/data/entities/Book;", "books", "", "canUpdate", "Lf/v;", "f", "([Lio/legado/app/data/entities/Book;Z)V", "book", "g", "([Lio/legado/app/data/entities/Book;)V", "e", "Landroid/app/Application;", "application", "<init>", "(Landroid/app/Application;)V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class ArrangeBookViewModel extends BaseViewModel {

    /* JADX INFO: compiled from: ArrangeBookViewModel.kt */
    @DebugMetadata(c = "io.legado.app.ui.book.arrange.ArrangeBookViewModel$deleteBook$1", f = "ArrangeBookViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class a extends g implements p<a0, d<? super v>, Object> {
        public final /* synthetic */ Book[] $book;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Book[] bookArr, d<? super a> dVar) {
            super(2, dVar);
            this.$book = bookArr;
        }

        @Override // f.z.j.a.a
        @NotNull
        public final d<v> create(@Nullable Object obj, @NotNull d<?> dVar) {
            return new a(this.$book, dVar);
        }

        @Override // f.c0.b.p
        @Nullable
        public final Object invoke(@NotNull a0 a0Var, @Nullable d<? super v> dVar) {
            return ((a) create(a0Var, dVar)).invokeSuspend(v.a);
        }

        @Override // f.z.j.a.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            f.E5(obj);
            BookDao bookDao = AppDatabaseKt.getAppDb().getBookDao();
            Book[] bookArr = this.$book;
            bookDao.delete((Book[]) Arrays.copyOf(bookArr, bookArr.length));
            return v.a;
        }
    }

    /* JADX INFO: compiled from: ArrangeBookViewModel.kt */
    @DebugMetadata(c = "io.legado.app.ui.book.arrange.ArrangeBookViewModel$upCanUpdate$1", f = "ArrangeBookViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class b extends g implements p<a0, d<? super v>, Object> {
        public final /* synthetic */ Book[] $books;
        public final /* synthetic */ boolean $canUpdate;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Book[] bookArr, boolean z, d<? super b> dVar) {
            super(2, dVar);
            this.$books = bookArr;
            this.$canUpdate = z;
        }

        @Override // f.z.j.a.a
        @NotNull
        public final d<v> create(@Nullable Object obj, @NotNull d<?> dVar) {
            return new b(this.$books, this.$canUpdate, dVar);
        }

        @Override // f.c0.b.p
        @Nullable
        public final Object invoke(@NotNull a0 a0Var, @Nullable d<? super v> dVar) {
            return ((b) create(a0Var, dVar)).invokeSuspend(v.a);
        }

        @Override // f.z.j.a.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            f.E5(obj);
            Book[] bookArr = this.$books;
            boolean z = this.$canUpdate;
            for (Book book : bookArr) {
                book.setCanUpdate(z);
            }
            BookDao bookDao = AppDatabaseKt.getAppDb().getBookDao();
            Book[] bookArr2 = this.$books;
            bookDao.update((Book[]) Arrays.copyOf(bookArr2, bookArr2.length));
            return v.a;
        }
    }

    /* JADX INFO: compiled from: ArrangeBookViewModel.kt */
    @DebugMetadata(c = "io.legado.app.ui.book.arrange.ArrangeBookViewModel$updateBook$1", f = "ArrangeBookViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class c extends g implements p<a0, d<? super v>, Object> {
        public final /* synthetic */ Book[] $book;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Book[] bookArr, d<? super c> dVar) {
            super(2, dVar);
            this.$book = bookArr;
        }

        @Override // f.z.j.a.a
        @NotNull
        public final d<v> create(@Nullable Object obj, @NotNull d<?> dVar) {
            return new c(this.$book, dVar);
        }

        @Override // f.c0.b.p
        @Nullable
        public final Object invoke(@NotNull a0 a0Var, @Nullable d<? super v> dVar) {
            return ((c) create(a0Var, dVar)).invokeSuspend(v.a);
        }

        @Override // f.z.j.a.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            f.E5(obj);
            BookDao bookDao = AppDatabaseKt.getAppDb().getBookDao();
            Book[] bookArr = this.$book;
            bookDao.update((Book[]) Arrays.copyOf(bookArr, bookArr.length));
            return v.a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArrangeBookViewModel(@NotNull Application application) {
        super(application);
        j.e(application, "application");
    }

    public final void e(@NotNull Book... book) {
        j.e(book, "book");
        BaseViewModel.a(this, null, null, new a(book, null), 3, null);
    }

    public final void f(@NotNull Book[] books, boolean canUpdate) {
        j.e(books, "books");
        BaseViewModel.a(this, null, null, new b(books, canUpdate, null), 3, null);
    }

    public final void g(@NotNull Book... book) {
        j.e(book, "book");
        BaseViewModel.a(this, null, null, new c(book, null), 3, null);
    }
}

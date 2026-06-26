package e.a.a.g.d.g;

import io.legado.app.data.entities.Book;
import io.legado.app.data.entities.BookChapter;
import io.legado.app.ui.book.info.BookInfoViewModel;
import java.util.List;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: BookInfoViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "io.legado.app.ui.book.info.BookInfoViewModel$changeTo$1", f = "BookInfoViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class d0 extends f.z.j.a.g implements f.c0.b.p<g.b.a0, f.z.d<? super f.v>, Object> {
    public final /* synthetic */ Book $newBook;
    public int label;
    public final /* synthetic */ BookInfoViewModel this$0;

    /* JADX INFO: compiled from: BookInfoViewModel.kt */
    public static final class a extends f.c0.c.k implements f.c0.b.l<List<? extends BookChapter>, f.v> {
        public final /* synthetic */ Book $newBook;
        public final /* synthetic */ f.c0.c.s $oldTocSize;
        public final /* synthetic */ BookInfoViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(BookInfoViewModel bookInfoViewModel, Book book, f.c0.c.s sVar) {
            super(1);
            this.this$0 = bookInfoViewModel;
            this.$newBook = book;
            this.$oldTocSize = sVar;
        }

        @Override // f.c0.b.l
        public /* bridge */ /* synthetic */ f.v invoke(List<? extends BookChapter> list) {
            invoke2((List<BookChapter>) list);
            return f.v.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull List<BookChapter> list) {
            f.c0.c.j.e(list, "it");
            BookInfoViewModel.f(this.this$0, this.$newBook, this.$oldTocSize.element, list);
        }
    }

    /* JADX INFO: compiled from: BookInfoViewModel.kt */
    public static final class b extends f.c0.c.k implements f.c0.b.l<List<? extends BookChapter>, f.v> {
        public final /* synthetic */ Book $newBook;
        public final /* synthetic */ f.c0.c.s $oldTocSize;
        public final /* synthetic */ BookInfoViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(BookInfoViewModel bookInfoViewModel, Book book, f.c0.c.s sVar) {
            super(1);
            this.this$0 = bookInfoViewModel;
            this.$newBook = book;
            this.$oldTocSize = sVar;
        }

        @Override // f.c0.b.l
        public /* bridge */ /* synthetic */ f.v invoke(List<? extends BookChapter> list) {
            invoke2((List<BookChapter>) list);
            return f.v.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull List<BookChapter> list) {
            f.c0.c.j.e(list, "it");
            BookInfoViewModel.f(this.this$0, this.$newBook, this.$oldTocSize.element, list);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d0(Book book, BookInfoViewModel bookInfoViewModel, f.z.d<? super d0> dVar) {
        super(2, dVar);
        this.$newBook = book;
        this.this$0 = bookInfoViewModel;
    }

    @Override // f.z.j.a.a
    @NotNull
    public final f.z.d<f.v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
        return new d0(this.$newBook, this.this$0, dVar);
    }

    @Override // f.c0.b.p
    @Nullable
    public final Object invoke(@NotNull g.b.a0 a0Var, @Nullable f.z.d<? super f.v> dVar) {
        return ((d0) create(a0Var, dVar)).invokeSuspend(f.v.a);
    }

    @Override // f.z.j.a.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
        Book value;
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        c.b.a.m.f.E5(obj);
        f.c0.c.s sVar = new f.c0.c.s();
        sVar.element = this.$newBook.getTotalChapterNum();
        BookInfoViewModel bookInfoViewModel = this.this$0;
        if (bookInfoViewModel.inBookshelf && (value = bookInfoViewModel.bookData.getValue()) != null) {
            Book book = this.$newBook;
            sVar.element = value.getTotalChapterNum();
            value.changeTo(book);
        }
        this.this$0.bookData.postValue(this.$newBook);
        this.this$0.h(this.$newBook);
        if (this.$newBook.getTocUrl().length() == 0) {
            BookInfoViewModel bookInfoViewModel2 = this.this$0;
            Book book2 = this.$newBook;
            bookInfoViewModel2.i(book2, false, new a(bookInfoViewModel2, book2, sVar));
        } else {
            BookInfoViewModel bookInfoViewModel3 = this.this$0;
            Book book3 = this.$newBook;
            bookInfoViewModel3.j(book3, new b(bookInfoViewModel3, book3, sVar));
        }
        return f.v.a;
    }
}

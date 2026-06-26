package io.legado.app.ui.book.info;

import android.app.Application;
import androidx.view.MutableLiveData;
import com.qq.e.comm.constants.Constants;
import com.umeng.analytics.pro.ai;
import e.a.a.f.s.k;
import f.c0.b.l;
import f.c0.b.p;
import f.c0.b.q;
import f.c0.c.j;
import f.v;
import g.b.a0;
import g.b.k0;
import io.legado.app.base.BaseViewModel;
import io.legado.app.data.AppDatabaseKt;
import io.legado.app.data.dao.BookChapterDao;
import io.legado.app.data.entities.Book;
import io.legado.app.data.entities.BookChapter;
import io.legado.app.data.entities.BookSource;
import io.legado.app.model.localBook.LocalBook;
import io.legado.app.model.webBook.WebBook;
import io.wenyuange.app.release.R;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mozilla.javascript.optimizer.OptRuntime;

/* JADX INFO: compiled from: BookInfoViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010<\u001a\u00020;¢\u0006\u0004\b=\u0010>J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006JD\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022+\b\u0002\u0010\r\u001a%\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\t0\b¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJL\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u00102+\b\u0002\u0010\r\u001a%\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\t0\b¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0016\u001a\u00020\u00042\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u001d\u0010\u0018\u001a\u00020\u00042\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u0018\u0010\u0017J)\u0010\u001a\u001a\u00020\u00042\b\b\u0002\u0010\u0019\u001a\u00020\u00102\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u001a\u0010\u001bR\"\u0010#\u001a\u00020\u001c8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R$\u0010*\u001a\u0004\u0018\u00010$8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R%\u00100\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0+8\u0006@\u0006¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R\u001f\u00103\u001a\b\u0012\u0004\u0012\u00020\u00020+8\u0006@\u0006¢\u0006\f\n\u0004\b1\u0010-\u001a\u0004\b2\u0010/R\"\u0010:\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109¨\u0006?"}, d2 = {"Lio/legado/app/ui/book/info/BookInfoViewModel;", "Lio/legado/app/base/BaseViewModel;", "Lio/legado/app/data/entities/Book;", "book", "Lf/v;", "h", "(Lio/legado/app/data/entities/Book;)V", "Lkotlin/Function1;", "", "Lio/legado/app/data/entities/BookChapter;", "Lkotlin/ParameterName;", "name", "chapters", "changeDruChapterIndex", "j", "(Lio/legado/app/data/entities/Book;Lf/c0/b/l;)V", "", "canReName", ai.aA, "(Lio/legado/app/data/entities/Book;ZLf/c0/b/l;)V", "Lkotlin/Function0;", "success", "k", "(Lf/c0/b/a;)V", Constants.LANDSCAPE, "deleteOriginal", "g", "(ZLf/c0/b/a;)V", "", "e", OptRuntime.GeneratorState.resumptionPoint_TYPE, "getDurChapterIndex", "()I", "setDurChapterIndex", "(I)V", "durChapterIndex", "Lio/legado/app/data/entities/BookSource;", "Lio/legado/app/data/entities/BookSource;", "getBookSource", "()Lio/legado/app/data/entities/BookSource;", "setBookSource", "(Lio/legado/app/data/entities/BookSource;)V", "bookSource", "Landroidx/lifecycle/MutableLiveData;", "d", "Landroidx/lifecycle/MutableLiveData;", "getChapterListData", "()Landroidx/lifecycle/MutableLiveData;", "chapterListData", ai.aD, "getBookData", "bookData", "f", "Z", "getInBookshelf", "()Z", "setInBookshelf", "(Z)V", "inBookshelf", "Landroid/app/Application;", "application", "<init>", "(Landroid/app/Application;)V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class BookInfoViewModel extends BaseViewModel {

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final MutableLiveData<Book> bookData;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final MutableLiveData<List<BookChapter>> chapterListData;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    public int durChapterIndex;

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    public boolean inBookshelf;

    /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public BookSource bookSource;

    /* JADX INFO: compiled from: BookInfoViewModel.kt */
    @DebugMetadata(c = "io.legado.app.ui.book.info.BookInfoViewModel$delBook$1", f = "BookInfoViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class a extends f.z.j.a.g implements p<a0, f.z.d<? super v>, Object> {
        public final /* synthetic */ boolean $deleteOriginal;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(boolean z, f.z.d<? super a> dVar) {
            super(2, dVar);
            this.$deleteOriginal = z;
        }

        @Override // f.z.j.a.a
        @NotNull
        public final f.z.d<v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
            return BookInfoViewModel.this.new a(this.$deleteOriginal, dVar);
        }

        @Override // f.c0.b.p
        @Nullable
        public final Object invoke(@NotNull a0 a0Var, @Nullable f.z.d<? super v> dVar) {
            return ((a) create(a0Var, dVar)).invokeSuspend(v.a);
        }

        @Override // f.z.j.a.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            c.b.a.m.f.E5(obj);
            Book value = BookInfoViewModel.this.bookData.getValue();
            if (value == null) {
                return null;
            }
            BookInfoViewModel bookInfoViewModel = BookInfoViewModel.this;
            boolean z = this.$deleteOriginal;
            Book.INSTANCE.delete(value);
            bookInfoViewModel.inBookshelf = false;
            if (value.isLocalBook()) {
                LocalBook.INSTANCE.deleteBook(value, z);
            }
            return v.a;
        }
    }

    /* JADX INFO: compiled from: BookInfoViewModel.kt */
    @DebugMetadata(c = "io.legado.app.ui.book.info.BookInfoViewModel$delBook$2", f = "BookInfoViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class b extends f.z.j.a.g implements q<a0, v, f.z.d<? super v>, Object> {
        public final /* synthetic */ f.c0.b.a<v> $success;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(f.c0.b.a<v> aVar, f.z.d<? super b> dVar) {
            super(3, dVar);
            this.$success = aVar;
        }

        @Override // f.c0.b.q
        @Nullable
        public final Object invoke(@NotNull a0 a0Var, @Nullable v vVar, @Nullable f.z.d<? super v> dVar) {
            return new b(this.$success, dVar).invokeSuspend(v.a);
        }

        @Override // f.z.j.a.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            c.b.a.m.f.E5(obj);
            f.c0.b.a<v> aVar = this.$success;
            if (aVar != null) {
                aVar.invoke();
            }
            return v.a;
        }
    }

    /* JADX INFO: compiled from: BookInfoViewModel.kt */
    @DebugMetadata(c = "io.legado.app.ui.book.info.BookInfoViewModel$loadBookInfo$1", f = "BookInfoViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class c extends f.z.j.a.g implements p<a0, f.z.d<? super Object>, Object> {
        public final /* synthetic */ Book $book;
        public final /* synthetic */ boolean $canReName;
        public final /* synthetic */ l<List<BookChapter>, v> $changeDruChapterIndex;
        private /* synthetic */ Object L$0;
        public int label;
        public final /* synthetic */ BookInfoViewModel this$0;

        /* JADX INFO: compiled from: BookInfoViewModel.kt */
        @DebugMetadata(c = "io.legado.app.ui.book.info.BookInfoViewModel$loadBookInfo$1$1$1", f = "BookInfoViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class a extends f.z.j.a.g implements q<a0, Book, f.z.d<? super v>, Object> {
            public final /* synthetic */ Book $book;
            public final /* synthetic */ l<List<BookChapter>, v> $changeDruChapterIndex;
            public /* synthetic */ Object L$0;
            public int label;
            public final /* synthetic */ BookInfoViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public a(BookInfoViewModel bookInfoViewModel, Book book, l<? super List<BookChapter>, v> lVar, f.z.d<? super a> dVar) {
                super(3, dVar);
                this.this$0 = bookInfoViewModel;
                this.$book = book;
                this.$changeDruChapterIndex = lVar;
            }

            @Override // f.c0.b.q
            @Nullable
            public final Object invoke(@NotNull a0 a0Var, @NotNull Book book, @Nullable f.z.d<? super v> dVar) {
                a aVar = new a(this.this$0, this.$book, this.$changeDruChapterIndex, dVar);
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
                this.this$0.bookData.postValue(this.$book);
                if (this.this$0.inBookshelf) {
                    AppDatabaseKt.getAppDb().getBookDao().update(this.$book);
                }
                this.this$0.j(book, this.$changeDruChapterIndex);
                return v.a;
            }
        }

        /* JADX INFO: compiled from: BookInfoViewModel.kt */
        @DebugMetadata(c = "io.legado.app.ui.book.info.BookInfoViewModel$loadBookInfo$1$1$2", f = "BookInfoViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class b extends f.z.j.a.g implements q<a0, Throwable, f.z.d<? super v>, Object> {
            public int label;
            public final /* synthetic */ BookInfoViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(BookInfoViewModel bookInfoViewModel, f.z.d<? super b> dVar) {
                super(3, dVar);
                this.this$0 = bookInfoViewModel;
            }

            @Override // f.c0.b.q
            @Nullable
            public final Object invoke(@NotNull a0 a0Var, @NotNull Throwable th, @Nullable f.z.d<? super v> dVar) {
                return new b(this.this$0, dVar).invokeSuspend(v.a);
            }

            @Override // f.z.j.a.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                c.b.a.m.f.E5(obj);
                this.this$0.c(R.string.error_get_book_info);
                return v.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public c(Book book, BookInfoViewModel bookInfoViewModel, l<? super List<BookChapter>, v> lVar, boolean z, f.z.d<? super c> dVar) {
            super(2, dVar);
            this.$book = book;
            this.this$0 = bookInfoViewModel;
            this.$changeDruChapterIndex = lVar;
            this.$canReName = z;
        }

        @Override // f.z.j.a.a
        @NotNull
        public final f.z.d<v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
            c cVar = new c(this.$book, this.this$0, this.$changeDruChapterIndex, this.$canReName, dVar);
            cVar.L$0 = obj;
            return cVar;
        }

        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(@NotNull a0 a0Var, @Nullable f.z.d<Object> dVar) {
            return ((c) create(a0Var, dVar)).invokeSuspend(v.a);
        }

        @Override // f.c0.b.p
        public /* bridge */ /* synthetic */ Object invoke(a0 a0Var, f.z.d<? super Object> dVar) {
            return invoke2(a0Var, (f.z.d<Object>) dVar);
        }

        @Override // f.z.j.a.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
            e.a.a.d.u.b bVar;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            c.b.a.m.f.E5(obj);
            a0 a0Var = (a0) this.L$0;
            if (this.$book.isLocalBook()) {
                this.this$0.j(this.$book, this.$changeDruChapterIndex);
                return v.a;
            }
            BookInfoViewModel bookInfoViewModel = this.this$0;
            BookSource bookSource = bookInfoViewModel.bookSource;
            if (bookSource == null) {
                bVar = null;
            } else {
                Book book = this.$book;
                boolean z = this.$canReName;
                l<List<BookChapter>, v> lVar = this.$changeDruChapterIndex;
                e.a.a.d.u.b bookInfo$default = WebBook.getBookInfo$default(new WebBook(bookSource), a0Var, book, null, z, 4, null);
                k0 k0Var = k0.f6264c;
                bookInfo$default.d(k0.f6263b, new a(bookInfoViewModel, book, lVar, null));
                e.a.a.d.u.b.b(bookInfo$default, null, new b(bookInfoViewModel, null), 1);
                bVar = bookInfo$default;
            }
            if (bVar != null) {
                return bVar;
            }
            BookInfoViewModel bookInfoViewModel2 = this.this$0;
            bookInfoViewModel2.chapterListData.postValue(f.x.i.INSTANCE);
            bookInfoViewModel2.c(R.string.error_no_source);
            return v.a;
        }
    }

    /* JADX INFO: compiled from: BookInfoViewModel.kt */
    @DebugMetadata(c = "io.legado.app.ui.book.info.BookInfoViewModel$loadChapter$1", f = "BookInfoViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class d extends f.z.j.a.g implements p<a0, f.z.d<? super Object>, Object> {
        public final /* synthetic */ Book $book;
        public final /* synthetic */ l<List<BookChapter>, v> $changeDruChapterIndex;
        private /* synthetic */ Object L$0;
        public int label;
        public final /* synthetic */ BookInfoViewModel this$0;

        /* JADX INFO: compiled from: BookInfoViewModel.kt */
        @DebugMetadata(c = "io.legado.app.ui.book.info.BookInfoViewModel$loadChapter$1$2$1", f = "BookInfoViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class a extends f.z.j.a.g implements q<a0, List<? extends BookChapter>, f.z.d<? super v>, Object> {
            public final /* synthetic */ Book $book;
            public final /* synthetic */ l<List<BookChapter>, v> $changeDruChapterIndex;
            public /* synthetic */ Object L$0;
            public int label;
            public final /* synthetic */ BookInfoViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public a(BookInfoViewModel bookInfoViewModel, Book book, l<? super List<BookChapter>, v> lVar, f.z.d<? super a> dVar) {
                super(3, dVar);
                this.this$0 = bookInfoViewModel;
                this.$book = book;
                this.$changeDruChapterIndex = lVar;
            }

            @Nullable
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(@NotNull a0 a0Var, @NotNull List<BookChapter> list, @Nullable f.z.d<? super v> dVar) {
                a aVar = new a(this.this$0, this.$book, this.$changeDruChapterIndex, dVar);
                aVar.L$0 = list;
                return aVar.invokeSuspend(v.a);
            }

            @Override // f.c0.b.q
            public /* bridge */ /* synthetic */ Object invoke(a0 a0Var, List<? extends BookChapter> list, f.z.d<? super v> dVar) {
                return invoke2(a0Var, (List<BookChapter>) list, dVar);
            }

            @Override // f.z.j.a.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                c.b.a.m.f.E5(obj);
                List<BookChapter> list = (List) this.L$0;
                if (!list.isEmpty()) {
                    if (this.this$0.inBookshelf) {
                        AppDatabaseKt.getAppDb().getBookDao().update(this.$book);
                        BookChapterDao bookChapterDao = AppDatabaseKt.getAppDb().getBookChapterDao();
                        Object[] array = list.toArray(new BookChapter[0]);
                        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
                        BookChapter[] bookChapterArr = (BookChapter[]) array;
                        bookChapterDao.insert((BookChapter[]) Arrays.copyOf(bookChapterArr, bookChapterArr.length));
                    }
                    l<List<BookChapter>, v> lVar = this.$changeDruChapterIndex;
                    if (lVar == null) {
                        this.this$0.chapterListData.postValue(list);
                    } else {
                        lVar.invoke(list);
                    }
                } else {
                    this.this$0.c(R.string.chapter_list_empty);
                }
                return v.a;
            }
        }

        /* JADX INFO: compiled from: BookInfoViewModel.kt */
        @DebugMetadata(c = "io.legado.app.ui.book.info.BookInfoViewModel$loadChapter$1$2$2", f = "BookInfoViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class b extends f.z.j.a.g implements q<a0, Throwable, f.z.d<? super v>, Object> {
            public int label;
            public final /* synthetic */ BookInfoViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(BookInfoViewModel bookInfoViewModel, f.z.d<? super b> dVar) {
                super(3, dVar);
                this.this$0 = bookInfoViewModel;
            }

            @Override // f.c0.b.q
            @Nullable
            public final Object invoke(@NotNull a0 a0Var, @NotNull Throwable th, @Nullable f.z.d<? super v> dVar) {
                return new b(this.this$0, dVar).invokeSuspend(v.a);
            }

            @Override // f.z.j.a.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                c.b.a.m.f.E5(obj);
                this.this$0.chapterListData.postValue(f.x.i.INSTANCE);
                this.this$0.c(R.string.error_get_chapter_list);
                return v.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public d(Book book, BookInfoViewModel bookInfoViewModel, l<? super List<BookChapter>, v> lVar, f.z.d<? super d> dVar) {
            super(2, dVar);
            this.$book = book;
            this.this$0 = bookInfoViewModel;
            this.$changeDruChapterIndex = lVar;
        }

        @Override // f.z.j.a.a
        @NotNull
        public final f.z.d<v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
            d dVar2 = new d(this.$book, this.this$0, this.$changeDruChapterIndex, dVar);
            dVar2.L$0 = obj;
            return dVar2;
        }

        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(@NotNull a0 a0Var, @Nullable f.z.d<Object> dVar) {
            return ((d) create(a0Var, dVar)).invokeSuspend(v.a);
        }

        @Override // f.c0.b.p
        public /* bridge */ /* synthetic */ Object invoke(a0 a0Var, f.z.d<? super Object> dVar) {
            return invoke2(a0Var, (f.z.d<Object>) dVar);
        }

        @Override // f.z.j.a.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
            e.a.a.d.u.b bVar;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            c.b.a.m.f.E5(obj);
            a0 a0Var = (a0) this.L$0;
            if (this.$book.isLocalBook()) {
                ArrayList<BookChapter> chapterList = LocalBook.INSTANCE.getChapterList(this.$book);
                Book book = this.$book;
                BookInfoViewModel bookInfoViewModel = this.this$0;
                AppDatabaseKt.getAppDb().getBookDao().update(book);
                BookChapterDao bookChapterDao = AppDatabaseKt.getAppDb().getBookChapterDao();
                Object[] array = chapterList.toArray(new BookChapter[0]);
                Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
                BookChapter[] bookChapterArr = (BookChapter[]) array;
                bookChapterDao.insert((BookChapter[]) Arrays.copyOf(bookChapterArr, bookChapterArr.length));
                bookInfoViewModel.chapterListData.postValue(chapterList);
                return v.a;
            }
            BookInfoViewModel bookInfoViewModel2 = this.this$0;
            BookSource bookSource = bookInfoViewModel2.bookSource;
            if (bookSource == null) {
                bVar = null;
            } else {
                Book book2 = this.$book;
                l<List<BookChapter>, v> lVar = this.$changeDruChapterIndex;
                e.a.a.d.u.b chapterList$default = WebBook.getChapterList$default(new WebBook(bookSource), a0Var, book2, null, 4, null);
                k0 k0Var = k0.f6264c;
                chapterList$default.d(k0.f6263b, new a(bookInfoViewModel2, book2, lVar, null));
                e.a.a.d.u.b.b(chapterList$default, null, new b(bookInfoViewModel2, null), 1);
                bVar = chapterList$default;
            }
            if (bVar != null) {
                return bVar;
            }
            BookInfoViewModel bookInfoViewModel3 = this.this$0;
            bookInfoViewModel3.chapterListData.postValue(f.x.i.INSTANCE);
            bookInfoViewModel3.c(R.string.error_no_source);
            return v.a;
        }
    }

    /* JADX INFO: compiled from: BookInfoViewModel.kt */
    @DebugMetadata(c = "io.legado.app.ui.book.info.BookInfoViewModel$loadChapter$2", f = "BookInfoViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class e extends f.z.j.a.g implements q<a0, Throwable, f.z.d<? super v>, Object> {
        public /* synthetic */ Object L$0;
        public int label;

        public e(f.z.d<? super e> dVar) {
            super(3, dVar);
        }

        @Override // f.c0.b.q
        @Nullable
        public final Object invoke(@NotNull a0 a0Var, @NotNull Throwable th, @Nullable f.z.d<? super v> dVar) {
            e eVar = BookInfoViewModel.this.new e(dVar);
            eVar.L$0 = th;
            return eVar.invokeSuspend(v.a);
        }

        @Override // f.z.j.a.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            c.b.a.m.f.E5(obj);
            BookInfoViewModel.this.d(j.k("LoadTocError:", ((Throwable) this.L$0).getLocalizedMessage()));
            return v.a;
        }
    }

    /* JADX INFO: compiled from: BookInfoViewModel.kt */
    @DebugMetadata(c = "io.legado.app.ui.book.info.BookInfoViewModel$saveBook$1", f = "BookInfoViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class f extends f.z.j.a.g implements p<a0, f.z.d<? super v>, Object> {
        public int label;

        public f(f.z.d<? super f> dVar) {
            super(2, dVar);
        }

        @Override // f.z.j.a.a
        @NotNull
        public final f.z.d<v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
            return BookInfoViewModel.this.new f(dVar);
        }

        @Override // f.c0.b.p
        @Nullable
        public final Object invoke(@NotNull a0 a0Var, @Nullable f.z.d<? super v> dVar) {
            return ((f) create(a0Var, dVar)).invokeSuspend(v.a);
        }

        @Override // f.z.j.a.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            c.b.a.m.f.E5(obj);
            Book value = BookInfoViewModel.this.bookData.getValue();
            if (value == null) {
                return null;
            }
            if (value.getOrder() == 0) {
                value.setOrder(AppDatabaseKt.getAppDb().getBookDao().getMaxOrder() + 1);
            }
            Book book = AppDatabaseKt.getAppDb().getBookDao().getBook(value.getName(), value.getAuthor());
            if (book != null) {
                value.setDurChapterPos(book.getDurChapterPos());
                value.setDurChapterTitle(book.getDurChapterTitle());
            }
            AppDatabaseKt.getAppDb().getBookDao().insert(value);
            k kVar = k.a;
            Book book2 = k.f5677c;
            if (j.a(book2 == null ? null : book2.getName(), value.getName())) {
                Book book3 = k.f5677c;
                if (j.a(book3 != null ? book3.getAuthor() : null, value.getAuthor())) {
                    k.f5677c = value;
                }
            }
            return v.a;
        }
    }

    /* JADX INFO: compiled from: BookInfoViewModel.kt */
    @DebugMetadata(c = "io.legado.app.ui.book.info.BookInfoViewModel$saveBook$2", f = "BookInfoViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class g extends f.z.j.a.g implements q<a0, v, f.z.d<? super v>, Object> {
        public final /* synthetic */ f.c0.b.a<v> $success;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(f.c0.b.a<v> aVar, f.z.d<? super g> dVar) {
            super(3, dVar);
            this.$success = aVar;
        }

        @Override // f.c0.b.q
        @Nullable
        public final Object invoke(@NotNull a0 a0Var, @Nullable v vVar, @Nullable f.z.d<? super v> dVar) {
            return new g(this.$success, dVar).invokeSuspend(v.a);
        }

        @Override // f.z.j.a.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            c.b.a.m.f.E5(obj);
            f.c0.b.a<v> aVar = this.$success;
            if (aVar != null) {
                aVar.invoke();
            }
            return v.a;
        }
    }

    /* JADX INFO: compiled from: BookInfoViewModel.kt */
    @DebugMetadata(c = "io.legado.app.ui.book.info.BookInfoViewModel$saveChapterList$1", f = "BookInfoViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class h extends f.z.j.a.g implements p<a0, f.z.d<? super v>, Object> {
        public int label;

        public h(f.z.d<? super h> dVar) {
            super(2, dVar);
        }

        @Override // f.z.j.a.a
        @NotNull
        public final f.z.d<v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
            return BookInfoViewModel.this.new h(dVar);
        }

        @Override // f.c0.b.p
        @Nullable
        public final Object invoke(@NotNull a0 a0Var, @Nullable f.z.d<? super v> dVar) {
            return ((h) create(a0Var, dVar)).invokeSuspend(v.a);
        }

        @Override // f.z.j.a.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            c.b.a.m.f.E5(obj);
            List<BookChapter> value = BookInfoViewModel.this.chapterListData.getValue();
            if (value == null) {
                return null;
            }
            BookChapterDao bookChapterDao = AppDatabaseKt.getAppDb().getBookChapterDao();
            Object[] array = value.toArray(new BookChapter[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
            BookChapter[] bookChapterArr = (BookChapter[]) array;
            bookChapterDao.insert((BookChapter[]) Arrays.copyOf(bookChapterArr, bookChapterArr.length));
            return v.a;
        }
    }

    /* JADX INFO: compiled from: BookInfoViewModel.kt */
    @DebugMetadata(c = "io.legado.app.ui.book.info.BookInfoViewModel$saveChapterList$2", f = "BookInfoViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class i extends f.z.j.a.g implements q<a0, v, f.z.d<? super v>, Object> {
        public final /* synthetic */ f.c0.b.a<v> $success;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(f.c0.b.a<v> aVar, f.z.d<? super i> dVar) {
            super(3, dVar);
            this.$success = aVar;
        }

        @Override // f.c0.b.q
        @Nullable
        public final Object invoke(@NotNull a0 a0Var, @Nullable v vVar, @Nullable f.z.d<? super v> dVar) {
            return new i(this.$success, dVar).invokeSuspend(v.a);
        }

        @Override // f.z.j.a.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            c.b.a.m.f.E5(obj);
            f.c0.b.a<v> aVar = this.$success;
            if (aVar != null) {
                aVar.invoke();
            }
            return v.a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BookInfoViewModel(@NotNull Application application) {
        super(application);
        j.e(application, "application");
        this.bookData = new MutableLiveData<>();
        this.chapterListData = new MutableLiveData<>();
    }

    public static final void e(BookInfoViewModel bookInfoViewModel, Book book) {
        Objects.requireNonNull(bookInfoViewModel);
        bookInfoViewModel.durChapterIndex = book.getDurChapterIndex();
        bookInfoViewModel.bookData.postValue(book);
        bookInfoViewModel.h(book);
        if (book.getTocUrl().length() == 0) {
            bookInfoViewModel.i(book, true, null);
            return;
        }
        List<BookChapter> chapterList = AppDatabaseKt.getAppDb().getBookChapterDao().getChapterList(book.getBookUrl());
        if (true ^ chapterList.isEmpty()) {
            bookInfoViewModel.chapterListData.postValue(chapterList);
        } else {
            bookInfoViewModel.j(book, null);
        }
    }

    public static final void f(BookInfoViewModel bookInfoViewModel, Book book, int i2, List list) {
        Objects.requireNonNull(bookInfoViewModel);
        BaseViewModel.a(bookInfoViewModel, null, null, new e.a.a.g.d.g.k0(book, i2, list, bookInfoViewModel, null), 3, null);
    }

    public final void g(boolean deleteOriginal, @Nullable f.c0.b.a<v> success) {
        BaseViewModel.a(this, null, null, new a(deleteOriginal, null), 3, null).d(null, new b(success, null));
    }

    public final void h(Book book) {
        this.bookSource = book.isLocalBook() ? null : AppDatabaseKt.getAppDb().getBookSourceDao().getBookSource(book.getOrigin());
    }

    public final void i(@NotNull Book book, boolean canReName, @Nullable l<? super List<BookChapter>, v> changeDruChapterIndex) {
        j.e(book, "book");
        BaseViewModel.a(this, null, null, new c(book, this, changeDruChapterIndex, canReName, null), 3, null);
    }

    public final void j(Book book, l<? super List<BookChapter>, v> changeDruChapterIndex) {
        e.a.a.d.u.b.b(BaseViewModel.a(this, null, null, new d(book, this, changeDruChapterIndex, null), 3, null), null, new e(null), 1);
    }

    public final void k(@Nullable f.c0.b.a<v> success) {
        BaseViewModel.a(this, null, null, new f(null), 3, null).d(null, new g(success, null));
    }

    public final void l(@Nullable f.c0.b.a<v> success) {
        BaseViewModel.a(this, null, null, new h(null), 3, null).d(null, new i(success, null));
    }
}

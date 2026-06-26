package io.legado.app.ui.book.read;

import android.app.Application;
import android.graphics.Bitmap;
import com.umeng.analytics.pro.ai;
import e.a.a.d.u.b;
import e.a.a.f.s.k;
import e.a.a.g.d.i.a1;
import e.a.a.g.d.i.r0;
import e.a.a.g.d.i.w0;
import e.a.a.g.d.i.x0;
import f.c0.b.l;
import f.c0.b.p;
import f.c0.b.q;
import f.c0.c.s;
import f.v;
import g.b.a0;
import g.b.g2.m;
import g.b.k0;
import g.b.o1;
import io.legado.app.base.BaseViewModel;
import io.legado.app.data.AppDatabaseKt;
import io.legado.app.data.dao.BookChapterDao;
import io.legado.app.data.entities.Book;
import io.legado.app.data.entities.BookChapter;
import io.legado.app.data.entities.BookSource;
import io.legado.app.data.entities.ReadRecord;
import io.legado.app.model.localBook.LocalBook;
import io.legado.app.model.webBook.PreciseSearch;
import io.legado.app.model.webBook.WebBook;
import io.legado.app.service.BaseReadAloudService;
import io.legado.app.utils.FileUtils;
import io.wenyuange.app.release.R;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ReadBookViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010(\u001a\u00020'¢\u0006\u0004\b)\u0010*JB\u0010\f\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022+\b\u0002\u0010\u000b\u001a%\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0004¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0011\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\nH\u0014¢\u0006\u0004\b\u0012\u0010\u0013JD\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022+\b\u0002\u0010\u000b\u001a%\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u0014\u0010\rJ\u001f\u0010\u0017\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0017\u0010\u0018R\"\u0010\u001f\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010#\u001a\u00020 8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&¨\u0006+"}, d2 = {"Lio/legado/app/ui/book/read/ReadBookViewModel;", "Lio/legado/app/base/BaseViewModel;", "Lio/legado/app/data/entities/Book;", "book", "Lkotlin/Function1;", "", "Lio/legado/app/data/entities/BookChapter;", "Lkotlin/ParameterName;", "name", "chapters", "Lf/v;", "changeDruChapterIndex", "j", "(Lio/legado/app/data/entities/Book;Lf/c0/b/l;)V", "newBook", "h", "(Lio/legado/app/data/entities/Book;)V", "m", "onCleared", "()V", ai.aA, "", "author", "g", "(Ljava/lang/String;Ljava/lang/String;)V", "d", "Ljava/lang/String;", "getSearchContentQuery", "()Ljava/lang/String;", "setSearchContentQuery", "(Ljava/lang/String;)V", "searchContentQuery", "", ai.aD, "Z", "isInitFinish", "()Z", "setInitFinish", "(Z)V", "Landroid/app/Application;", "application", "<init>", "(Landroid/app/Application;)V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class ReadBookViewModel extends BaseViewModel {

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    public boolean isInitFinish;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public String searchContentQuery;

    /* JADX INFO: compiled from: ReadBookViewModel.kt */
    @DebugMetadata(c = "io.legado.app.ui.book.read.ReadBookViewModel$autoChangeSource$1", f = "ReadBookViewModel.kt", i = {}, l = {214}, m = "invokeSuspend", n = {}, s = {})
    public static final class a extends f.z.j.a.g implements p<a0, f.z.d<? super v>, Object> {
        public final /* synthetic */ String $author;
        public final /* synthetic */ String $name;
        private /* synthetic */ Object L$0;
        public int label;
        public final /* synthetic */ ReadBookViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, String str2, ReadBookViewModel readBookViewModel, f.z.d<? super a> dVar) {
            super(2, dVar);
            this.$name = str;
            this.$author = str2;
            this.this$0 = readBookViewModel;
        }

        @Override // f.z.j.a.a
        @NotNull
        public final f.z.d<v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
            a aVar = new a(this.$name, this.$author, this.this$0, dVar);
            aVar.L$0 = obj;
            return aVar;
        }

        @Override // f.c0.b.p
        @Nullable
        public final Object invoke(@NotNull a0 a0Var, @Nullable f.z.d<? super v> dVar) {
            return ((a) create(a0Var, dVar)).invokeSuspend(v.a);
        }

        @Override // f.z.j.a.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws Exception {
            f.z.i.a aVar = f.z.i.a.COROUTINE_SUSPENDED;
            int i2 = this.label;
            if (i2 == 0) {
                c.b.a.m.f.E5(obj);
                a0 a0Var = (a0) this.L$0;
                List<BookSource> allTextEnabled = AppDatabaseKt.getAppDb().getBookSourceDao().getAllTextEnabled();
                PreciseSearch preciseSearch = PreciseSearch.INSTANCE;
                String str = this.$name;
                String str2 = this.$author;
                this.label = 1;
                obj = preciseSearch.searchFirstBook(a0Var, allTextEnabled, str, str2, this);
                if (obj == aVar) {
                    return aVar;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                c.b.a.m.f.E5(obj);
            }
            Book book = (Book) obj;
            if (book == null) {
                throw new Exception("自动换源失败");
            }
            e.a.a.f.s.k kVar = e.a.a.f.s.k.a;
            book.upInfoFromOld(e.a.a.f.s.k.f5677c);
            this.this$0.h(book);
            return v.a;
        }
    }

    /* JADX INFO: compiled from: ReadBookViewModel.kt */
    @DebugMetadata(c = "io.legado.app.ui.book.read.ReadBookViewModel$autoChangeSource$2", f = "ReadBookViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class b extends f.z.j.a.g implements p<a0, f.z.d<? super v>, Object> {
        public int label;

        public b(f.z.d<? super b> dVar) {
            super(2, dVar);
        }

        @Override // f.z.j.a.a
        @NotNull
        public final f.z.d<v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
            return ReadBookViewModel.this.new b(dVar);
        }

        @Override // f.c0.b.p
        @Nullable
        public final Object invoke(@NotNull a0 a0Var, @Nullable f.z.d<? super v> dVar) {
            return ((b) create(a0Var, dVar)).invokeSuspend(v.a);
        }

        @Override // f.z.j.a.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            c.b.a.m.f.E5(obj);
            e.a.a.f.s.k.a.u(ReadBookViewModel.this.b().getString(R.string.source_auto_changing));
            return v.a;
        }
    }

    /* JADX INFO: compiled from: ReadBookViewModel.kt */
    @DebugMetadata(c = "io.legado.app.ui.book.read.ReadBookViewModel$autoChangeSource$3", f = "ReadBookViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class c extends f.z.j.a.g implements q<a0, Throwable, f.z.d<? super v>, Object> {
        public /* synthetic */ Object L$0;
        public int label;

        public c(f.z.d<? super c> dVar) {
            super(3, dVar);
        }

        @Override // f.c0.b.q
        @Nullable
        public final Object invoke(@NotNull a0 a0Var, @NotNull Throwable th, @Nullable f.z.d<? super v> dVar) {
            c cVar = ReadBookViewModel.this.new c(dVar);
            cVar.L$0 = th;
            return cVar.invokeSuspend(v.a);
        }

        @Override // f.z.j.a.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            c.b.a.m.f.E5(obj);
            Throwable th = (Throwable) this.L$0;
            ReadBookViewModel readBookViewModel = ReadBookViewModel.this;
            c.b.a.m.f.R5(readBookViewModel.b(), c.b.a.m.f.C2(th));
            return v.a;
        }
    }

    /* JADX INFO: compiled from: ReadBookViewModel.kt */
    @DebugMetadata(c = "io.legado.app.ui.book.read.ReadBookViewModel$autoChangeSource$4", f = "ReadBookViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class d extends f.z.j.a.g implements p<a0, f.z.d<? super v>, Object> {
        public int label;

        public d(f.z.d<? super d> dVar) {
            super(2, dVar);
        }

        @Override // f.z.j.a.a
        @NotNull
        public final f.z.d<v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
            return new d(dVar);
        }

        @Override // f.c0.b.p
        @Nullable
        public final Object invoke(@NotNull a0 a0Var, @Nullable f.z.d<? super v> dVar) {
            return ((d) create(a0Var, dVar)).invokeSuspend(v.a);
        }

        @Override // f.z.j.a.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            c.b.a.m.f.E5(obj);
            e.a.a.f.s.k.a.u(null);
            return v.a;
        }
    }

    /* JADX INFO: compiled from: ReadBookViewModel.kt */
    @DebugMetadata(c = "io.legado.app.ui.book.read.ReadBookViewModel$changeTo$1", f = "ReadBookViewModel.kt", i = {}, l = {195}, m = "invokeSuspend", n = {}, s = {})
    public static final class e extends f.z.j.a.g implements p<a0, f.z.d<? super v>, Object> {
        public final /* synthetic */ Book $newBook;
        public Object L$0;
        public int label;
        public final /* synthetic */ ReadBookViewModel this$0;

        /* JADX INFO: compiled from: ReadBookViewModel.kt */
        @DebugMetadata(c = "io.legado.app.ui.book.read.ReadBookViewModel$changeTo$1$3", f = "ReadBookViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class a extends f.z.j.a.g implements p<a0, f.z.d<? super v>, Object> {
            public int label;

            public a(f.z.d<? super a> dVar) {
                super(2, dVar);
            }

            @Override // f.z.j.a.a
            @NotNull
            public final f.z.d<v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
                return new a(dVar);
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
                e.a.a.f.s.k kVar = e.a.a.f.s.k.a;
                k.a aVar = e.a.a.f.s.k.f5684j;
                if (aVar == null) {
                    return null;
                }
                c.b.a.m.f.V5(aVar, 0, false, null, 7, null);
                return v.a;
            }
        }

        /* JADX INFO: compiled from: ReadBookViewModel.kt */
        public static final class b extends f.c0.c.k implements l<List<? extends BookChapter>, v> {
            public final /* synthetic */ Book $newBook;
            public final /* synthetic */ s $oldTocSize;
            public final /* synthetic */ ReadBookViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(ReadBookViewModel readBookViewModel, Book book, s sVar) {
                super(1);
                this.this$0 = readBookViewModel;
                this.$newBook = book;
                this.$oldTocSize = sVar;
            }

            @Override // f.c0.b.l
            public /* bridge */ /* synthetic */ v invoke(List<? extends BookChapter> list) {
                invoke2((List<BookChapter>) list);
                return v.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull List<BookChapter> list) {
                f.c0.c.j.e(list, "it");
                ReadBookViewModel.f(this.this$0, this.$newBook, this.$oldTocSize.element, list);
            }
        }

        /* JADX INFO: compiled from: ReadBookViewModel.kt */
        public static final class c extends f.c0.c.k implements l<List<? extends BookChapter>, v> {
            public final /* synthetic */ Book $newBook;
            public final /* synthetic */ s $oldTocSize;
            public final /* synthetic */ ReadBookViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public c(ReadBookViewModel readBookViewModel, Book book, s sVar) {
                super(1);
                this.this$0 = readBookViewModel;
                this.$newBook = book;
                this.$oldTocSize = sVar;
            }

            @Override // f.c0.b.l
            public /* bridge */ /* synthetic */ v invoke(List<? extends BookChapter> list) {
                invoke2((List<BookChapter>) list);
                return v.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull List<BookChapter> list) {
                f.c0.c.j.e(list, "it");
                ReadBookViewModel.f(this.this$0, this.$newBook, this.$oldTocSize.element, list);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(Book book, ReadBookViewModel readBookViewModel, f.z.d<? super e> dVar) {
            super(2, dVar);
            this.$newBook = book;
            this.this$0 = readBookViewModel;
        }

        @Override // f.z.j.a.a
        @NotNull
        public final f.z.d<v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
            return new e(this.$newBook, this.this$0, dVar);
        }

        @Override // f.c0.b.p
        @Nullable
        public final Object invoke(@NotNull a0 a0Var, @Nullable f.z.d<? super v> dVar) {
            return ((e) create(a0Var, dVar)).invokeSuspend(v.a);
        }

        @Override // f.z.j.a.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
            s sVar;
            f.z.i.a aVar = f.z.i.a.COROUTINE_SUSPENDED;
            int i2 = this.label;
            if (i2 == 0) {
                c.b.a.m.f.E5(obj);
                s sVar2 = new s();
                sVar2.element = this.$newBook.getTotalChapterNum();
                e.a.a.f.s.k.a.u(null);
                Book book = e.a.a.f.s.k.f5677c;
                if (book != null) {
                    Book book2 = this.$newBook;
                    sVar2.element = book.getTotalChapterNum();
                    book.changeTo(book2);
                }
                e.a.a.f.s.k.f5677c = this.$newBook;
                BookSource bookSource = AppDatabaseKt.getAppDb().getBookSourceDao().getBookSource(this.$newBook.getOrigin());
                if (bookSource != null) {
                    e.a.a.f.s.k.o = new WebBook(bookSource);
                }
                e.a.a.f.s.k.f5685k = null;
                e.a.a.f.s.k.f5686l = null;
                e.a.a.f.s.k.m = null;
                k0 k0Var = k0.f6264c;
                o1 o1Var = m.f6207b;
                a aVar2 = new a(null);
                this.L$0 = sVar2;
                this.label = 1;
                if (c.b.a.m.f.f6(o1Var, aVar2, this) == aVar) {
                    return aVar;
                }
                sVar = sVar2;
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                sVar = (s) this.L$0;
                c.b.a.m.f.E5(obj);
            }
            if (this.$newBook.getTocUrl().length() == 0) {
                ReadBookViewModel readBookViewModel = this.this$0;
                Book book3 = this.$newBook;
                readBookViewModel.i(book3, new b(readBookViewModel, book3, sVar));
            } else {
                ReadBookViewModel readBookViewModel2 = this.this$0;
                Book book4 = this.$newBook;
                readBookViewModel2.j(book4, new c(readBookViewModel2, book4, sVar));
            }
            return v.a;
        }
    }

    /* JADX INFO: compiled from: ReadBookViewModel.kt */
    @DebugMetadata(c = "io.legado.app.ui.book.read.ReadBookViewModel$loadBookInfo$1", f = "ReadBookViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class f extends f.z.j.a.g implements q<a0, Book, f.z.d<? super v>, Object> {
        public final /* synthetic */ Book $book;
        public final /* synthetic */ l<List<BookChapter>, v> $changeDruChapterIndex;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public f(Book book, l<? super List<BookChapter>, v> lVar, f.z.d<? super f> dVar) {
            super(3, dVar);
            this.$book = book;
            this.$changeDruChapterIndex = lVar;
        }

        @Override // f.c0.b.q
        @Nullable
        public final Object invoke(@NotNull a0 a0Var, @NotNull Book book, @Nullable f.z.d<? super v> dVar) {
            return ReadBookViewModel.this.new f(this.$book, this.$changeDruChapterIndex, dVar).invokeSuspend(v.a);
        }

        @Override // f.z.j.a.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            c.b.a.m.f.E5(obj);
            ReadBookViewModel.this.j(this.$book, this.$changeDruChapterIndex);
            return v.a;
        }
    }

    /* JADX INFO: compiled from: ReadBookViewModel.kt */
    @DebugMetadata(c = "io.legado.app.ui.book.read.ReadBookViewModel$loadChapterList$1", f = "ReadBookViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class g extends f.z.j.a.g implements p<a0, f.z.d<? super v>, Object> {
        public final /* synthetic */ Book $book;
        public int label;
        public final /* synthetic */ ReadBookViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(Book book, ReadBookViewModel readBookViewModel, f.z.d<? super g> dVar) {
            super(2, dVar);
            this.$book = book;
            this.this$0 = readBookViewModel;
        }

        @Override // f.z.j.a.a
        @NotNull
        public final f.z.d<v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
            return new g(this.$book, this.this$0, dVar);
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
            ArrayList<BookChapter> chapterList = LocalBook.INSTANCE.getChapterList(this.$book);
            Book book = this.$book;
            ReadBookViewModel readBookViewModel = this.this$0;
            AppDatabaseKt.getAppDb().getBookChapterDao().delByBook(book.getBookUrl());
            BookChapterDao bookChapterDao = AppDatabaseKt.getAppDb().getBookChapterDao();
            Object[] array = chapterList.toArray(new BookChapter[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
            BookChapter[] bookChapterArr = (BookChapter[]) array;
            bookChapterDao.insert((BookChapter[]) Arrays.copyOf(bookChapterArr, bookChapterArr.length));
            AppDatabaseKt.getAppDb().getBookDao().update(book);
            e.a.a.f.s.k kVar = e.a.a.f.s.k.a;
            e.a.a.f.s.k.f5680f = chapterList.size();
            if (chapterList.isEmpty()) {
                kVar.u(readBookViewModel.b().getString(R.string.error_load_toc));
            } else {
                kVar.u(null);
                kVar.i(true, null);
            }
            return v.a;
        }
    }

    /* JADX INFO: compiled from: ReadBookViewModel.kt */
    @DebugMetadata(c = "io.legado.app.ui.book.read.ReadBookViewModel$loadChapterList$2", f = "ReadBookViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class h extends f.z.j.a.g implements q<a0, Throwable, f.z.d<? super v>, Object> {
        public /* synthetic */ Object L$0;
        public int label;

        public h(f.z.d<? super h> dVar) {
            super(3, dVar);
        }

        @Override // f.c0.b.q
        @Nullable
        public final Object invoke(@NotNull a0 a0Var, @NotNull Throwable th, @Nullable f.z.d<? super v> dVar) {
            h hVar = new h(dVar);
            hVar.L$0 = th;
            return hVar.invokeSuspend(v.a);
        }

        @Override // f.z.j.a.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            c.b.a.m.f.E5(obj);
            e.a.a.f.s.k.a.u(f.c0.c.j.k("LoadTocError:", ((Throwable) this.L$0).getLocalizedMessage()));
            return v.a;
        }
    }

    /* JADX INFO: compiled from: ReadBookViewModel.kt */
    @DebugMetadata(c = "io.legado.app.ui.book.read.ReadBookViewModel$loadChapterList$3", f = "ReadBookViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class i extends f.z.j.a.g implements q<a0, List<? extends BookChapter>, f.z.d<? super v>, Object> {
        public final /* synthetic */ Book $book;
        public final /* synthetic */ l<List<BookChapter>, v> $changeDruChapterIndex;
        public /* synthetic */ Object L$0;
        public int label;
        public final /* synthetic */ ReadBookViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public i(l<? super List<BookChapter>, v> lVar, Book book, ReadBookViewModel readBookViewModel, f.z.d<? super i> dVar) {
            super(3, dVar);
            this.$changeDruChapterIndex = lVar;
            this.$book = book;
            this.this$0 = readBookViewModel;
        }

        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(@NotNull a0 a0Var, @NotNull List<BookChapter> list, @Nullable f.z.d<? super v> dVar) {
            i iVar = new i(this.$changeDruChapterIndex, this.$book, this.this$0, dVar);
            iVar.L$0 = list;
            return iVar.invokeSuspend(v.a);
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
                l<List<BookChapter>, v> lVar = this.$changeDruChapterIndex;
                if (lVar == null) {
                    BookChapterDao bookChapterDao = AppDatabaseKt.getAppDb().getBookChapterDao();
                    Object[] array = list.toArray(new BookChapter[0]);
                    Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
                    BookChapter[] bookChapterArr = (BookChapter[]) array;
                    bookChapterDao.insert((BookChapter[]) Arrays.copyOf(bookChapterArr, bookChapterArr.length));
                    AppDatabaseKt.getAppDb().getBookDao().update(this.$book);
                    e.a.a.f.s.k kVar = e.a.a.f.s.k.a;
                    e.a.a.f.s.k.f5680f = list.size();
                    kVar.u(null);
                    kVar.i(true, null);
                } else {
                    lVar.invoke(list);
                }
            } else {
                e.a.a.f.s.k.a.u(this.this$0.b().getString(R.string.error_load_toc));
            }
            return v.a;
        }
    }

    /* JADX INFO: compiled from: ReadBookViewModel.kt */
    @DebugMetadata(c = "io.legado.app.ui.book.read.ReadBookViewModel$loadChapterList$4", f = "ReadBookViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class j extends f.z.j.a.g implements q<a0, Throwable, f.z.d<? super v>, Object> {
        public int label;

        public j(f.z.d<? super j> dVar) {
            super(3, dVar);
        }

        @Override // f.c0.b.q
        @Nullable
        public final Object invoke(@NotNull a0 a0Var, @NotNull Throwable th, @Nullable f.z.d<? super v> dVar) {
            return ReadBookViewModel.this.new j(dVar).invokeSuspend(v.a);
        }

        @Override // f.z.j.a.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            c.b.a.m.f.E5(obj);
            e.a.a.f.s.k.a.u(ReadBookViewModel.this.b().getString(R.string.error_load_toc));
            return v.a;
        }
    }

    /* JADX INFO: compiled from: ReadBookViewModel.kt */
    @DebugMetadata(c = "io.legado.app.ui.book.read.ReadBookViewModel$refreshContent$1", f = "ReadBookViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class k extends f.z.j.a.g implements p<a0, f.z.d<? super v>, Object> {
        public final /* synthetic */ Book $book;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(Book book, f.z.d<? super k> dVar) {
            super(2, dVar);
            this.$book = book;
        }

        @Override // f.z.j.a.a
        @NotNull
        public final f.z.d<v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
            return new k(this.$book, dVar);
        }

        @Override // f.c0.b.p
        @Nullable
        public final Object invoke(@NotNull a0 a0Var, @Nullable f.z.d<? super v> dVar) {
            return ((k) create(a0Var, dVar)).invokeSuspend(v.a);
        }

        @Override // f.z.j.a.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            c.b.a.m.f.E5(obj);
            BookChapterDao bookChapterDao = AppDatabaseKt.getAppDb().getBookChapterDao();
            String bookUrl = this.$book.getBookUrl();
            e.a.a.f.s.k kVar = e.a.a.f.s.k.a;
            BookChapter chapter = bookChapterDao.getChapter(bookUrl, e.a.a.f.s.k.f5681g);
            if (chapter == null) {
                return null;
            }
            Book book = this.$book;
            e.a.a.d.g gVar = e.a.a.d.g.a;
            f.c0.c.j.e(book, "book");
            f.c0.c.j.e(chapter, "bookChapter");
            if (!book.isLocalTxt()) {
                FileUtils.a.a(e.a.a.d.g.f5530b, "book_cache", book.getFolderName(), chapter.getFileName()).delete();
            }
            e.a.a.f.s.k.j(kVar, e.a.a.f.s.k.f5681g, false, false, null, 10);
            return v.a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReadBookViewModel(@NotNull Application application) {
        super(application);
        f.c0.c.j.e(application, "application");
        this.searchContentQuery = "";
    }

    public static final void e(ReadBookViewModel readBookViewModel, Book book) {
        Objects.requireNonNull(readBookViewModel);
        e.a.a.f.s.k kVar = e.a.a.f.s.k.a;
        Book book2 = e.a.a.f.s.k.f5677c;
        if (f.c0.c.j.a(book2 == null ? null : book2.getBookUrl(), book.getBookUrl())) {
            e.a.a.f.s.k.f5677c = book;
            if (e.a.a.f.s.k.f5681g != book.getDurChapterIndex()) {
                e.a.a.f.s.k.f5681g = book.getDurChapterIndex();
                e.a.a.f.s.k.f5682h = book.getDurChapterPos();
                e.a.a.f.s.k.f5685k = null;
                e.a.a.f.s.k.f5686l = null;
                e.a.a.f.s.k.m = null;
            }
            e.a.a.f.s.k.f5676b.postValue(book.getName());
            kVar.v(book);
            readBookViewModel.isInitFinish = true;
            if (!book.isLocalBook() && e.a.a.f.s.k.o == null) {
                readBookViewModel.g(book.getName(), book.getAuthor());
                return;
            }
            int chapterCount = AppDatabaseKt.getAppDb().getBookChapterDao().getChapterCount(book.getBookUrl());
            e.a.a.f.s.k.f5680f = chapterCount;
            if (chapterCount == 0) {
                if (book.getTocUrl().length() == 0) {
                    readBookViewModel.i(book, null);
                } else {
                    readBookViewModel.j(book, null);
                }
            } else if (e.a.a.f.s.k.f5686l != null) {
                k.a aVar = e.a.a.f.s.k.f5684j;
                if (aVar != null) {
                    c.b.a.m.f.V5(aVar, 0, false, null, 5, null);
                }
            } else {
                kVar.i(true, null);
            }
            if (BaseReadAloudService.f6927b) {
                return;
            }
            n(readBookViewModel, book, false, null, 6);
            return;
        }
        f.c0.c.j.e(book, "book");
        e.a.a.f.s.k.f5677c = book;
        e.a.a.f.s.k.f5678d = new e.a.a.d.k(book.getName(), book.getOrigin());
        ReadRecord readRecord = e.a.a.f.s.k.r;
        readRecord.setBookName(book.getName());
        Long readTime = AppDatabaseKt.getAppDb().getReadRecordDao().getReadTime(book.getName());
        readRecord.setReadTime(readTime == null ? 0L : readTime.longValue());
        e.a.a.f.s.k.f5681g = book.getDurChapterIndex();
        e.a.a.f.s.k.f5682h = book.getDurChapterPos();
        e.a.a.f.s.k.f5683i = f.c0.c.j.a(book.getOrigin(), "loc_book");
        e.a.a.f.s.k.f5680f = book.getTotalChapterNum();
        kVar.c();
        e.a.a.f.s.k.f5676b.postValue(book.getName());
        k.a aVar2 = e.a.a.f.s.k.f5684j;
        if (aVar2 != null) {
            aVar2.D();
        }
        kVar.v(book);
        synchronized (e.a.a.g.d.i.s1.h.b.a) {
            Iterator<Map.Entry<Integer, ConcurrentHashMap<String, Bitmap>>> it = e.a.a.g.d.i.s1.h.b.f5799b.entrySet().iterator();
            while (it.hasNext()) {
                Iterator<Map.Entry<String, Bitmap>> it2 = it.next().getValue().entrySet().iterator();
                while (it2.hasNext()) {
                    it2.next().getValue().recycle();
                }
            }
            e.a.a.g.d.i.s1.h.b.f5799b.clear();
        }
        synchronized (kVar) {
            e.a.a.f.s.k.q.clear();
        }
        readBookViewModel.isInitFinish = true;
        if (!book.isLocalBook()) {
            e.a.a.f.s.k kVar2 = e.a.a.f.s.k.a;
            if (e.a.a.f.s.k.o == null) {
                readBookViewModel.g(book.getName(), book.getAuthor());
                return;
            }
        }
        e.a.a.f.s.k kVar3 = e.a.a.f.s.k.a;
        int chapterCount2 = AppDatabaseKt.getAppDb().getBookChapterDao().getChapterCount(book.getBookUrl());
        e.a.a.f.s.k.f5680f = chapterCount2;
        if (chapterCount2 == 0) {
            if (book.getTocUrl().length() == 0) {
                readBookViewModel.i(book, null);
            } else {
                readBookViewModel.j(book, null);
            }
        } else {
            int i2 = e.a.a.f.s.k.f5681g;
            int i3 = e.a.a.f.s.k.f5680f;
            if (i2 > i3 - 1) {
                e.a.a.f.s.k.f5681g = i3 - 1;
            }
            kVar3.i(true, null);
        }
        n(readBookViewModel, book, false, null, 6);
    }

    public static final void f(ReadBookViewModel readBookViewModel, Book book, int i2, List list) {
        Objects.requireNonNull(readBookViewModel);
        BaseViewModel.a(readBookViewModel, null, null, new a1(book, i2, list, null), 3, null);
    }

    public static /* synthetic */ void k(ReadBookViewModel readBookViewModel, Book book, l lVar, int i2) {
        int i3 = i2 & 2;
        readBookViewModel.j(book, null);
    }

    public static void l(ReadBookViewModel readBookViewModel, int i2, int i3, f.c0.b.a aVar, int i4) {
        if ((i4 & 2) != 0) {
            i3 = 0;
        }
        if ((i4 & 4) != 0) {
            aVar = null;
        }
        Objects.requireNonNull(readBookViewModel);
        e.a.a.f.s.k kVar = e.a.a.f.s.k.a;
        kVar.c();
        k.a aVar2 = e.a.a.f.s.k.f5684j;
        if (aVar2 != null) {
            c.b.a.m.f.V5(aVar2, 0, false, null, 7, null);
        }
        if (i2 != e.a.a.f.s.k.f5681g) {
            e.a.a.f.s.k.f5681g = i2;
            e.a.a.f.s.k.f5682h = i3;
        }
        kVar.q();
        kVar.i(true, new r0(aVar));
    }

    public static void n(ReadBookViewModel readBookViewModel, Book book, boolean z, l lVar, int i2) {
        if ((i2 & 2) != 0) {
            e.a.a.d.e eVar = e.a.a.d.e.a;
            z = c.b.a.m.f.J2(k.d.a.h.g(), "syncBookProgress", true);
        }
        if ((i2 & 4) != 0) {
            lVar = null;
        }
        Objects.requireNonNull(readBookViewModel);
        f.c0.c.j.e(book, "book");
        if (z) {
            BaseViewModel.a(readBookViewModel, null, null, new w0(book, null), 3, null).d(null, new x0(book, lVar, null));
        }
    }

    public final void g(String name, String author) {
        e.a.a.d.e eVar = e.a.a.d.e.a;
        if (c.b.a.m.f.J2(k.d.a.h.g(), "autoChangeSource", true)) {
            e.a.a.d.u.b bVarA = BaseViewModel.a(this, null, null, new a(name, author, this, null), 3, null);
            b bVar = new b(null);
            f.c0.c.j.e(bVar, "block");
            bVarA.f5561e = new b.c(bVarA, null, bVar);
            e.a.a.d.u.b.b(bVarA, null, new c(null), 1);
            e.a.a.d.u.b.c(bVarA, null, new d(null), 1);
        }
    }

    public final void h(@NotNull Book newBook) {
        f.c0.c.j.e(newBook, "newBook");
        BaseViewModel.a(this, null, null, new e(newBook, this, null), 3, null);
    }

    public final void i(Book book, l<? super List<BookChapter>, v> changeDruChapterIndex) {
        e.a.a.d.u.b bookInfo$default;
        if (book.isLocalBook()) {
            j(book, changeDruChapterIndex);
            return;
        }
        e.a.a.f.s.k kVar = e.a.a.f.s.k.a;
        WebBook webBook = e.a.a.f.s.k.o;
        if (webBook == null || (bookInfo$default = WebBook.getBookInfo$default(webBook, this, book, null, false, 4, null)) == null) {
            return;
        }
        f fVar = new f(book, changeDruChapterIndex, null);
        b.C0148b c0148b = e.a.a.d.u.b.a;
        bookInfo$default.d(null, fVar);
    }

    public final void j(@NotNull Book book, @Nullable l<? super List<BookChapter>, v> changeDruChapterIndex) {
        f.c0.c.j.e(book, "book");
        if (book.isLocalBook()) {
            e.a.a.d.u.b.b(BaseViewModel.a(this, null, null, new g(book, this, null), 3, null), null, new h(null), 1);
            return;
        }
        e.a.a.f.s.k kVar = e.a.a.f.s.k.a;
        WebBook webBook = e.a.a.f.s.k.o;
        e.a.a.d.u.b chapterList$default = webBook == null ? null : WebBook.getChapterList$default(webBook, this, book, null, 4, null);
        if (chapterList$default == null) {
            return;
        }
        k0 k0Var = k0.f6264c;
        chapterList$default.d(k0.f6263b, new i(changeDruChapterIndex, book, this, null));
        e.a.a.d.u.b.b(chapterList$default, null, new j(null), 1);
    }

    public final void m(@NotNull Book book) {
        f.c0.c.j.e(book, "book");
        BaseViewModel.a(this, null, null, new k(book, null), 3, null);
    }

    @Override // io.legado.app.base.BaseViewModel, androidx.view.ViewModel
    public void onCleared() {
        super.onCleared();
        if (BaseReadAloudService.f6929d) {
            e.a.a.f.s.j jVar = e.a.a.f.s.j.a;
            e.a.a.f.s.j.f(b());
        }
    }
}

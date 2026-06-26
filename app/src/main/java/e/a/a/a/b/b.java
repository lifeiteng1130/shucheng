package e.a.a.a.b;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import e.a.a.h.n;
import f.c0.b.p;
import f.c0.c.j;
import f.h0.k;
import f.v;
import f.z.j.a.g;
import g.b.a0;
import io.legado.app.data.AppDatabaseKt;
import io.legado.app.data.dao.BookChapterDao;
import io.legado.app.data.entities.Book;
import io.legado.app.data.entities.BookChapter;
import io.legado.app.data.entities.BookSource;
import io.legado.app.model.localBook.LocalBook;
import io.legado.app.model.webBook.WebBook;
import io.wenyuange.app.release.R;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import k.d.a.h;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: BookController.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: compiled from: BookController.kt */
    @DebugMetadata(c = "io.legado.app.api.controller.BookController$getBookContent$1$1", f = "BookController.kt", i = {}, l = {127}, m = "invokeSuspend", n = {}, s = {})
    public static final class a extends g implements p<a0, f.z.d<? super String>, Object> {
        public final /* synthetic */ Book $book;
        public final /* synthetic */ BookChapter $chapter;
        public final /* synthetic */ BookSource $source;
        private /* synthetic */ Object L$0;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(BookSource bookSource, Book book, BookChapter bookChapter, f.z.d<? super a> dVar) {
            super(2, dVar);
            this.$source = bookSource;
            this.$book = book;
            this.$chapter = bookChapter;
        }

        @Override // f.z.j.a.a
        @NotNull
        public final f.z.d<v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
            a aVar = new a(this.$source, this.$book, this.$chapter, dVar);
            aVar.L$0 = obj;
            return aVar;
        }

        @Override // f.c0.b.p
        @Nullable
        public final Object invoke(@NotNull a0 a0Var, @Nullable f.z.d<? super String> dVar) {
            return ((a) create(a0Var, dVar)).invokeSuspend(v.a);
        }

        @Override // f.z.j.a.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
            f.z.i.a aVar = f.z.i.a.COROUTINE_SUSPENDED;
            int i2 = this.label;
            if (i2 == 0) {
                c.b.a.m.f.E5(obj);
                a0 a0Var = (a0) this.L$0;
                WebBook webBook = new WebBook(this.$source);
                Book book = this.$book;
                BookChapter bookChapter = this.$chapter;
                this.label = 1;
                obj = WebBook.getContentAwait$default(webBook, a0Var, book, bookChapter, null, this, 8, null);
                if (obj == aVar) {
                    return aVar;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                c.b.a.m.f.E5(obj);
            }
            return obj;
        }
    }

    /* JADX INFO: renamed from: e.a.a.a.b.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: BookController.kt */
    @DebugMetadata(c = "io.legado.app.api.controller.BookController$refreshToc$toc$1", f = "BookController.kt", i = {0}, l = {71, 73}, m = "invokeSuspend", n = {"$this$runBlocking"}, s = {"L$0"})
    public static final class C0145b extends g implements p<a0, f.z.d<? super List<? extends BookChapter>>, Object> {
        public final /* synthetic */ Book $book;
        public final /* synthetic */ WebBook $webBook;
        private /* synthetic */ Object L$0;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0145b(Book book, WebBook webBook, f.z.d<? super C0145b> dVar) {
            super(2, dVar);
            this.$book = book;
            this.$webBook = webBook;
        }

        @Override // f.z.j.a.a
        @NotNull
        public final f.z.d<v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
            C0145b c0145b = new C0145b(this.$book, this.$webBook, dVar);
            c0145b.L$0 = obj;
            return c0145b;
        }

        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(@NotNull a0 a0Var, @Nullable f.z.d<? super List<BookChapter>> dVar) {
            return ((C0145b) create(a0Var, dVar)).invokeSuspend(v.a);
        }

        @Override // f.c0.b.p
        public /* bridge */ /* synthetic */ Object invoke(a0 a0Var, f.z.d<? super List<? extends BookChapter>> dVar) {
            return invoke2(a0Var, (f.z.d<? super List<BookChapter>>) dVar);
        }

        @Override // f.z.j.a.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
            a0 a0Var;
            f.z.i.a aVar = f.z.i.a.COROUTINE_SUSPENDED;
            int i2 = this.label;
            if (i2 == 0) {
                c.b.a.m.f.E5(obj);
                a0Var = (a0) this.L$0;
                if (k.s(this.$book.getTocUrl())) {
                    WebBook webBook = this.$webBook;
                    Book book = this.$book;
                    this.L$0 = a0Var;
                    this.label = 1;
                    if (WebBook.getBookInfoAwait$default(webBook, a0Var, book, false, this, 4, null) == aVar) {
                        return aVar;
                    }
                }
            } else {
                if (i2 != 1) {
                    if (i2 == 2) {
                        c.b.a.m.f.E5(obj);
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                a0Var = (a0) this.L$0;
                c.b.a.m.f.E5(obj);
            }
            WebBook webBook2 = this.$webBook;
            Book book2 = this.$book;
            this.L$0 = null;
            this.label = 2;
            obj = webBook2.getChapterListAwait(a0Var, book2, this);
            return obj == aVar ? aVar : obj;
        }
    }

    /* JADX INFO: compiled from: GsonExtensions.kt */
    public static final class c extends TypeToken<Book> {
    }

    @NotNull
    public static final e.a.a.a.a a(@NotNull Map<String, ? extends List<String>> map) {
        String str;
        j.e(map, "parameters");
        List<String> list = map.get("url");
        String str2 = list == null ? null : (String) f.x.e.n(list, 0);
        List<String> list2 = map.get("index");
        Integer numValueOf = (list2 == null || (str = (String) f.x.e.n(list2, 0)) == null) ? null : Integer.valueOf(Integer.parseInt(str));
        e.a.a.a.a aVar = new e.a.a.a.a();
        if (str2 == null || str2.length() == 0) {
            j.e("参数url不能为空，请指定书籍地址", "errorMsg");
            return aVar;
        }
        if (numValueOf == null) {
            j.e("参数index不能为空, 请指定目录序号", "errorMsg");
            return aVar;
        }
        Book book = AppDatabaseKt.getAppDb().getBookDao().getBook(str2);
        BookChapter chapter = AppDatabaseKt.getAppDb().getBookChapterDao().getChapter(str2, numValueOf.intValue());
        if (book == null || chapter == null) {
            j.e("未找到", "errorMsg");
        } else {
            String strE = e.a.a.d.g.a.e(book, chapter);
            if (strE != null) {
                d(book, numValueOf.intValue());
                aVar.a(strE);
            } else {
                BookSource bookSource = AppDatabaseKt.getAppDb().getBookSourceDao().getBookSource(book.getOrigin());
                if (bookSource != null) {
                    String str3 = (String) c.b.a.m.f.T4(null, new a(bookSource, book, chapter, null), 1, null);
                    int iIntValue = numValueOf.intValue();
                    if (iIntValue > book.getDurChapterIndex()) {
                        book.setDurChapterIndex(iIntValue);
                        book.setDurChapterTime(System.currentTimeMillis());
                        BookChapter chapter2 = AppDatabaseKt.getAppDb().getBookChapterDao().getChapter(book.getBookUrl(), iIntValue);
                        if (chapter2 != null) {
                            book.setDurChapterTitle(chapter2.getTitle());
                        }
                        AppDatabaseKt.getAppDb().getBookDao().update(book);
                        e.a.a.f.s.k kVar = e.a.a.f.s.k.a;
                        Book book2 = e.a.a.f.s.k.f5677c;
                        if (j.a(book2 != null ? book2.getBookUrl() : null, book.getBookUrl())) {
                            e.a.a.f.s.k.f5677c = book;
                            e.a.a.f.s.k.f5681g = iIntValue;
                        }
                    }
                    aVar.a(str3);
                    obj = aVar;
                }
                if (obj == null) {
                    j.e("未找到书源", "errorMsg");
                }
            }
        }
        return aVar;
    }

    @NotNull
    public static final e.a.a.a.a b(@NotNull Map<String, ? extends List<String>> map) {
        j.e(map, "parameters");
        e.a.a.a.a aVar = new e.a.a.a.a();
        try {
            List<String> list = map.get("url");
            String str = list == null ? null : (String) f.x.e.n(list, 0);
            if (str == null || str.length() == 0) {
                j.e("参数url不能为空，请指定书籍地址", "errorMsg");
                return aVar;
            }
            Book book = AppDatabaseKt.getAppDb().getBookDao().getBook(str);
            if (book == null) {
                j.e("bookUrl不对", "errorMsg");
                return aVar;
            }
            if (book.isLocalBook()) {
                ArrayList<BookChapter> chapterList = LocalBook.INSTANCE.getChapterList(book);
                AppDatabaseKt.getAppDb().getBookChapterDao().delByBook(book.getBookUrl());
                BookChapterDao bookChapterDao = AppDatabaseKt.getAppDb().getBookChapterDao();
                Object[] array = chapterList.toArray(new BookChapter[0]);
                if (array == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                }
                BookChapter[] bookChapterArr = (BookChapter[]) array;
                bookChapterDao.insert((BookChapter[]) Arrays.copyOf(bookChapterArr, bookChapterArr.length));
                AppDatabaseKt.getAppDb().getBookDao().update(book);
                if (chapterList.isEmpty()) {
                    String string = h.g().getString(R.string.error_load_toc);
                    j.d(string, "appCtx.getString(R.string.error_load_toc)");
                    j.e(string, "errorMsg");
                } else {
                    aVar.a(chapterList);
                }
                return aVar;
            }
            BookSource bookSource = AppDatabaseKt.getAppDb().getBookSourceDao().getBookSource(book.getOrigin());
            if (bookSource == null) {
                j.e("未找到对应书源,请换源", "errorMsg");
                return aVar;
            }
            List list2 = (List) c.b.a.m.f.T4(null, new C0145b(book, new WebBook(bookSource), null), 1, null);
            AppDatabaseKt.getAppDb().getBookChapterDao().delByBook(book.getBookUrl());
            BookChapterDao bookChapterDao2 = AppDatabaseKt.getAppDb().getBookChapterDao();
            Object[] array2 = list2.toArray(new BookChapter[0]);
            if (array2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
            }
            BookChapter[] bookChapterArr2 = (BookChapter[]) array2;
            bookChapterDao2.insert((BookChapter[]) Arrays.copyOf(bookChapterArr2, bookChapterArr2.length));
            AppDatabaseKt.getAppDb().getBookDao().update(book);
            if (list2.isEmpty()) {
                String string2 = h.g().getString(R.string.error_load_toc);
                j.d(string2, "appCtx.getString(R.string.error_load_toc)");
                j.e(string2, "errorMsg");
            } else {
                aVar.a(list2);
            }
            return aVar;
        } catch (Exception e2) {
            String localizedMessage = e2.getLocalizedMessage();
            if (localizedMessage == null) {
                localizedMessage = "refresh toc error";
            }
            j.e(localizedMessage, "errorMsg");
            return aVar;
        }
    }

    @NotNull
    public static final e.a.a.a.a c(@Nullable String str) {
        Object objM11constructorimpl;
        Gson gsonA = n.a();
        try {
            Type type = new c().getType();
            j.d(type, "object : TypeToken<T>() {}.type");
            Object objFromJson = gsonA.fromJson(str, type);
            if (!(objFromJson instanceof Book)) {
                objFromJson = null;
            }
            objM11constructorimpl = f.h.m11constructorimpl((Book) objFromJson);
        } catch (Throwable th) {
            objM11constructorimpl = f.h.m11constructorimpl(c.b.a.m.f.m1(th));
        }
        if (f.h.m16isFailureimpl(objM11constructorimpl)) {
            objM11constructorimpl = null;
        }
        Book book = (Book) objM11constructorimpl;
        e.a.a.a.a aVar = new e.a.a.a.a();
        if (book == null) {
            j.e("格式不对", "errorMsg");
            return aVar;
        }
        AppDatabaseKt.getAppDb().getBookDao().insert(book);
        e.a.a.f.s.k kVar = e.a.a.f.s.k.a;
        Book book2 = e.a.a.f.s.k.f5677c;
        if (j.a(book2 != null ? book2.getBookUrl() : null, book.getBookUrl())) {
            e.a.a.f.s.k.f5677c = book;
            e.a.a.f.s.k.f5681g = book.getDurChapterIndex();
        }
        aVar.a("");
        return aVar;
    }

    public static final void d(Book book, int i2) {
        if (i2 > book.getDurChapterIndex()) {
            book.setDurChapterIndex(i2);
            book.setDurChapterTime(System.currentTimeMillis());
            BookChapter chapter = AppDatabaseKt.getAppDb().getBookChapterDao().getChapter(book.getBookUrl(), i2);
            if (chapter != null) {
                book.setDurChapterTitle(chapter.getTitle());
            }
            AppDatabaseKt.getAppDb().getBookDao().update(book);
            e.a.a.f.s.k kVar = e.a.a.f.s.k.a;
            Book book2 = e.a.a.f.s.k.f5677c;
            if (j.a(book2 == null ? null : book2.getBookUrl(), book.getBookUrl())) {
                e.a.a.f.s.k.f5677c = book;
                e.a.a.f.s.k.f5681g = i2;
            }
        }
    }
}

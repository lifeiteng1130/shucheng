package io.legado.app.model.webBook;

import c.b.a.m.f;
import com.umeng.analytics.pro.c;
import e.a.a.d.u.b;
import f.c0.b.p;
import f.c0.c.j;
import f.v;
import f.z.d;
import f.z.i.a;
import f.z.j.a.g;
import g.b.a0;
import g.b.k0;
import io.legado.app.data.entities.Book;
import io.legado.app.data.entities.BookChapter;
import io.legado.app.data.entities.BookSource;
import io.legado.app.data.entities.SearchBook;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mozilla.javascript.Token;

/* JADX INFO: compiled from: WebBook.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010*\u001a\u00020)¢\u0006\u0004\b1\u00102JI\u0010\u000e\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\r0\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000e\u0010\u000fJ?\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011J?\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00130\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u0014\u0010\u000fJA\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\r2\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0011J7\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00160\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00162\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ/\u0010\u001c\u001a\u00020\u00162\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00162\b\b\u0002\u0010\u0019\u001a\u00020\u0018H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ3\u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u00130\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00162\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u001f\u0010 J+\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00132\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0016H\u0086@ø\u0001\u0000¢\u0006\u0004\b!\u0010\"JA\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00040\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010#\u001a\u00020\u001e2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b%\u0010&J7\u0010'\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010#\u001a\u00020\u001e2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0004H\u0086@ø\u0001\u0000¢\u0006\u0004\b'\u0010(R\u0019\u0010*\u001a\u00020)8\u0006@\u0006¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R\u0013\u00100\u001a\u00020\u00048F@\u0006¢\u0006\u0006\u001a\u0004\b.\u0010/\u0082\u0002\u0004\n\u0002\b\u0019¨\u00063"}, d2 = {"Lio/legado/app/model/webBook/WebBook;", "", "Lg/b/a0;", "scope", "", "key", "", "page", "Lf/z/f;", c.R, "Le/a/a/d/u/b;", "Ljava/util/ArrayList;", "Lio/legado/app/data/entities/SearchBook;", "Lkotlin/collections/ArrayList;", "searchBook", "(Lg/b/a0;Ljava/lang/String;Ljava/lang/Integer;Lf/z/f;)Le/a/a/d/u/b;", "searchBookAwait", "(Lg/b/a0;Ljava/lang/String;Ljava/lang/Integer;Lf/z/d;)Ljava/lang/Object;", "url", "", "exploreBook", "exploreBookAwait", "Lio/legado/app/data/entities/Book;", "book", "", "canReName", "getBookInfo", "(Lg/b/a0;Lio/legado/app/data/entities/Book;Lf/z/f;Z)Le/a/a/d/u/b;", "getBookInfoAwait", "(Lg/b/a0;Lio/legado/app/data/entities/Book;ZLf/z/d;)Ljava/lang/Object;", "Lio/legado/app/data/entities/BookChapter;", "getChapterList", "(Lg/b/a0;Lio/legado/app/data/entities/Book;Lf/z/f;)Le/a/a/d/u/b;", "getChapterListAwait", "(Lg/b/a0;Lio/legado/app/data/entities/Book;Lf/z/d;)Ljava/lang/Object;", "bookChapter", "nextChapterUrl", "getContent", "(Lg/b/a0;Lio/legado/app/data/entities/Book;Lio/legado/app/data/entities/BookChapter;Ljava/lang/String;Lf/z/f;)Le/a/a/d/u/b;", "getContentAwait", "(Lg/b/a0;Lio/legado/app/data/entities/Book;Lio/legado/app/data/entities/BookChapter;Ljava/lang/String;Lf/z/d;)Ljava/lang/Object;", "Lio/legado/app/data/entities/BookSource;", "bookSource", "Lio/legado/app/data/entities/BookSource;", "getBookSource", "()Lio/legado/app/data/entities/BookSource;", "getSourceUrl", "()Ljava/lang/String;", "sourceUrl", "<init>", "(Lio/legado/app/data/entities/BookSource;)V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class WebBook {

    @NotNull
    private final BookSource bookSource;

    /* JADX INFO: renamed from: io.legado.app.model.webBook.WebBook$exploreBook$1, reason: invalid class name */
    /* JADX INFO: compiled from: WebBook.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lg/b/a0;", "", "Lio/legado/app/data/entities/SearchBook;", "<anonymous>", "(Lg/b/a0;)Ljava/util/List;"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "io.legado.app.model.webBook.WebBook$exploreBook$1", f = "WebBook.kt", i = {}, l = {73}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends g implements p<a0, d<? super List<? extends SearchBook>>, Object> {
        public final /* synthetic */ Integer $page;
        public final /* synthetic */ a0 $scope;
        public final /* synthetic */ String $url;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(a0 a0Var, String str, Integer num, d<? super AnonymousClass1> dVar) {
            super(2, dVar);
            this.$scope = a0Var;
            this.$url = str;
            this.$page = num;
        }

        @Override // f.z.j.a.a
        @NotNull
        public final d<v> create(@Nullable Object obj, @NotNull d<?> dVar) {
            return WebBook.this.new AnonymousClass1(this.$scope, this.$url, this.$page, dVar);
        }

        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(@NotNull a0 a0Var, @Nullable d<? super List<SearchBook>> dVar) {
            return ((AnonymousClass1) create(a0Var, dVar)).invokeSuspend(v.a);
        }

        @Override // f.c0.b.p
        public /* bridge */ /* synthetic */ Object invoke(a0 a0Var, d<? super List<? extends SearchBook>> dVar) {
            return invoke2(a0Var, (d<? super List<SearchBook>>) dVar);
        }

        @Override // f.z.j.a.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
            a aVar = a.COROUTINE_SUSPENDED;
            int i2 = this.label;
            if (i2 == 0) {
                f.E5(obj);
                WebBook webBook = WebBook.this;
                a0 a0Var = this.$scope;
                String str = this.$url;
                Integer num = this.$page;
                this.label = 1;
                obj = webBook.exploreBookAwait(a0Var, str, num, this);
                if (obj == aVar) {
                    return aVar;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                f.E5(obj);
            }
            return obj;
        }
    }

    /* JADX INFO: renamed from: io.legado.app.model.webBook.WebBook$exploreBookAwait$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: WebBook.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "io.legado.app.model.webBook.WebBook", f = "WebBook.kt", i = {0, 0, 0, 0}, l = {90}, m = "exploreBookAwait", n = {"this", "scope", "variableBook", "analyzeUrl"}, s = {"L$0", "L$1", "L$2", "L$3"})
    public static final class C03391 extends f.z.j.a.c {
        public Object L$0;
        public Object L$1;
        public Object L$2;
        public Object L$3;
        public int label;
        public /* synthetic */ Object result;

        public C03391(d<? super C03391> dVar) {
            super(dVar);
        }

        @Override // f.z.j.a.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return WebBook.this.exploreBookAwait(null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: io.legado.app.model.webBook.WebBook$getBookInfo$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: WebBook.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lg/b/a0;", "Lio/legado/app/data/entities/Book;", "<anonymous>", "(Lg/b/a0;)Lio/legado/app/data/entities/Book;"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "io.legado.app.model.webBook.WebBook$getBookInfo$1", f = "WebBook.kt", i = {}, l = {112}, m = "invokeSuspend", n = {}, s = {})
    public static final class C03401 extends g implements p<a0, d<? super Book>, Object> {
        public final /* synthetic */ Book $book;
        public final /* synthetic */ boolean $canReName;
        public final /* synthetic */ a0 $scope;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C03401(a0 a0Var, Book book, boolean z, d<? super C03401> dVar) {
            super(2, dVar);
            this.$scope = a0Var;
            this.$book = book;
            this.$canReName = z;
        }

        @Override // f.z.j.a.a
        @NotNull
        public final d<v> create(@Nullable Object obj, @NotNull d<?> dVar) {
            return WebBook.this.new C03401(this.$scope, this.$book, this.$canReName, dVar);
        }

        @Override // f.c0.b.p
        @Nullable
        public final Object invoke(@NotNull a0 a0Var, @Nullable d<? super Book> dVar) {
            return ((C03401) create(a0Var, dVar)).invokeSuspend(v.a);
        }

        @Override // f.z.j.a.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
            a aVar = a.COROUTINE_SUSPENDED;
            int i2 = this.label;
            if (i2 == 0) {
                f.E5(obj);
                WebBook webBook = WebBook.this;
                a0 a0Var = this.$scope;
                Book book = this.$book;
                boolean z = this.$canReName;
                this.label = 1;
                obj = webBook.getBookInfoAwait(a0Var, book, z, this);
                if (obj == aVar) {
                    return aVar;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                f.E5(obj);
            }
            return obj;
        }
    }

    /* JADX INFO: renamed from: io.legado.app.model.webBook.WebBook$getBookInfoAwait$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: WebBook.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "io.legado.app.model.webBook.WebBook", f = "WebBook.kt", i = {}, l = {Token.USE_STACK}, m = "getBookInfoAwait", n = {}, s = {})
    public static final class C03411 extends f.z.j.a.c {
        public Object L$0;
        public Object L$1;
        public Object L$2;
        public boolean Z$0;
        public int label;
        public /* synthetic */ Object result;

        public C03411(d<? super C03411> dVar) {
            super(dVar);
        }

        @Override // f.z.j.a.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return WebBook.this.getBookInfoAwait(null, null, false, this);
        }
    }

    /* JADX INFO: renamed from: io.legado.app.model.webBook.WebBook$getChapterList$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: WebBook.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lg/b/a0;", "", "Lio/legado/app/data/entities/BookChapter;", "<anonymous>", "(Lg/b/a0;)Ljava/util/List;"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "io.legado.app.model.webBook.WebBook$getChapterList$1", f = "WebBook.kt", i = {}, l = {Token.COMMENT}, m = "invokeSuspend", n = {}, s = {})
    public static final class C03421 extends g implements p<a0, d<? super List<? extends BookChapter>>, Object> {
        public final /* synthetic */ Book $book;
        public final /* synthetic */ a0 $scope;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C03421(a0 a0Var, Book book, d<? super C03421> dVar) {
            super(2, dVar);
            this.$scope = a0Var;
            this.$book = book;
        }

        @Override // f.z.j.a.a
        @NotNull
        public final d<v> create(@Nullable Object obj, @NotNull d<?> dVar) {
            return WebBook.this.new C03421(this.$scope, this.$book, dVar);
        }

        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(@NotNull a0 a0Var, @Nullable d<? super List<BookChapter>> dVar) {
            return ((C03421) create(a0Var, dVar)).invokeSuspend(v.a);
        }

        @Override // f.c0.b.p
        public /* bridge */ /* synthetic */ Object invoke(a0 a0Var, d<? super List<? extends BookChapter>> dVar) {
            return invoke2(a0Var, (d<? super List<BookChapter>>) dVar);
        }

        @Override // f.z.j.a.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
            a aVar = a.COROUTINE_SUSPENDED;
            int i2 = this.label;
            if (i2 == 0) {
                f.E5(obj);
                WebBook webBook = WebBook.this;
                a0 a0Var = this.$scope;
                Book book = this.$book;
                this.label = 1;
                obj = webBook.getChapterListAwait(a0Var, book, this);
                if (obj == aVar) {
                    return aVar;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                f.E5(obj);
            }
            return obj;
        }
    }

    /* JADX INFO: renamed from: io.legado.app.model.webBook.WebBook$getChapterListAwait$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: WebBook.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "io.legado.app.model.webBook.WebBook", f = "WebBook.kt", i = {}, l = {172, 186, 187}, m = "getChapterListAwait", n = {}, s = {})
    public static final class C03431 extends f.z.j.a.c {
        public Object L$0;
        public Object L$1;
        public Object L$2;
        public int label;
        public /* synthetic */ Object result;

        public C03431(d<? super C03431> dVar) {
            super(dVar);
        }

        @Override // f.z.j.a.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return WebBook.this.getChapterListAwait(null, null, this);
        }
    }

    /* JADX INFO: renamed from: io.legado.app.model.webBook.WebBook$getContent$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: WebBook.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lg/b/a0;", "", "<anonymous>", "(Lg/b/a0;)Ljava/lang/String;"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "io.legado.app.model.webBook.WebBook$getContent$1", f = "WebBook.kt", i = {}, l = {209}, m = "invokeSuspend", n = {}, s = {})
    public static final class C03441 extends g implements p<a0, d<? super String>, Object> {
        public final /* synthetic */ Book $book;
        public final /* synthetic */ BookChapter $bookChapter;
        public final /* synthetic */ String $nextChapterUrl;
        public final /* synthetic */ a0 $scope;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C03441(a0 a0Var, Book book, BookChapter bookChapter, String str, d<? super C03441> dVar) {
            super(2, dVar);
            this.$scope = a0Var;
            this.$book = book;
            this.$bookChapter = bookChapter;
            this.$nextChapterUrl = str;
        }

        @Override // f.z.j.a.a
        @NotNull
        public final d<v> create(@Nullable Object obj, @NotNull d<?> dVar) {
            return WebBook.this.new C03441(this.$scope, this.$book, this.$bookChapter, this.$nextChapterUrl, dVar);
        }

        @Override // f.c0.b.p
        @Nullable
        public final Object invoke(@NotNull a0 a0Var, @Nullable d<? super String> dVar) {
            return ((C03441) create(a0Var, dVar)).invokeSuspend(v.a);
        }

        @Override // f.z.j.a.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
            a aVar = a.COROUTINE_SUSPENDED;
            int i2 = this.label;
            if (i2 == 0) {
                f.E5(obj);
                WebBook webBook = WebBook.this;
                a0 a0Var = this.$scope;
                Book book = this.$book;
                BookChapter bookChapter = this.$bookChapter;
                String str = this.$nextChapterUrl;
                this.label = 1;
                obj = webBook.getContentAwait(a0Var, book, bookChapter, str, this);
                if (obj == aVar) {
                    return aVar;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                f.E5(obj);
            }
            return obj;
        }
    }

    /* JADX INFO: renamed from: io.legado.app.model.webBook.WebBook$getContentAwait$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: WebBook.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "io.legado.app.model.webBook.WebBook", f = "WebBook.kt", i = {}, l = {224, 241, 246}, m = "getContentAwait", n = {}, s = {})
    public static final class C03451 extends f.z.j.a.c {
        public Object L$0;
        public Object L$1;
        public Object L$2;
        public Object L$3;
        public Object L$4;
        public int label;
        public /* synthetic */ Object result;

        public C03451(d<? super C03451> dVar) {
            super(dVar);
        }

        @Override // f.z.j.a.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return WebBook.this.getContentAwait(null, null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: io.legado.app.model.webBook.WebBook$searchBook$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: WebBook.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0003*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lg/b/a0;", "Ljava/util/ArrayList;", "Lio/legado/app/data/entities/SearchBook;", "Lkotlin/collections/ArrayList;", "<anonymous>", "(Lg/b/a0;)Ljava/util/ArrayList;"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "io.legado.app.model.webBook.WebBook$searchBook$1", f = "WebBook.kt", i = {}, l = {30}, m = "invokeSuspend", n = {}, s = {})
    public static final class C03461 extends g implements p<a0, d<? super ArrayList<SearchBook>>, Object> {
        public final /* synthetic */ String $key;
        public final /* synthetic */ Integer $page;
        public final /* synthetic */ a0 $scope;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C03461(a0 a0Var, String str, Integer num, d<? super C03461> dVar) {
            super(2, dVar);
            this.$scope = a0Var;
            this.$key = str;
            this.$page = num;
        }

        @Override // f.z.j.a.a
        @NotNull
        public final d<v> create(@Nullable Object obj, @NotNull d<?> dVar) {
            return WebBook.this.new C03461(this.$scope, this.$key, this.$page, dVar);
        }

        @Override // f.c0.b.p
        @Nullable
        public final Object invoke(@NotNull a0 a0Var, @Nullable d<? super ArrayList<SearchBook>> dVar) {
            return ((C03461) create(a0Var, dVar)).invokeSuspend(v.a);
        }

        @Override // f.z.j.a.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
            a aVar = a.COROUTINE_SUSPENDED;
            int i2 = this.label;
            if (i2 == 0) {
                f.E5(obj);
                WebBook webBook = WebBook.this;
                a0 a0Var = this.$scope;
                String str = this.$key;
                Integer num = this.$page;
                this.label = 1;
                obj = webBook.searchBookAwait(a0Var, str, num, this);
                if (obj == aVar) {
                    return aVar;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                f.E5(obj);
            }
            return obj;
        }
    }

    /* JADX INFO: renamed from: io.legado.app.model.webBook.WebBook$searchBookAwait$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: WebBook.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "io.legado.app.model.webBook.WebBook", f = "WebBook.kt", i = {0}, l = {49}, m = "searchBookAwait", n = {"analyzeUrl"}, s = {"L$3"})
    public static final class C03471 extends f.z.j.a.c {
        public Object L$0;
        public Object L$1;
        public Object L$2;
        public Object L$3;
        public int label;
        public /* synthetic */ Object result;

        public C03471(d<? super C03471> dVar) {
            super(dVar);
        }

        @Override // f.z.j.a.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return WebBook.this.searchBookAwait(null, null, null, this);
        }
    }

    public WebBook(@NotNull BookSource bookSource) {
        j.e(bookSource, "bookSource");
        this.bookSource = bookSource;
    }

    public static b exploreBook$default(WebBook webBook, a0 a0Var, String str, Integer num, f.z.f fVar, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            num = 1;
        }
        if ((i2 & 8) != 0) {
            k0 k0Var = k0.f6264c;
            fVar = k0.f6263b;
        }
        return webBook.exploreBook(a0Var, str, num, fVar);
    }

    public static Object exploreBookAwait$default(WebBook webBook, a0 a0Var, String str, Integer num, d dVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            b.C0148b c0148b = b.a;
            a0Var = b.f5558b;
        }
        if ((i2 & 4) != 0) {
            num = 1;
        }
        return webBook.exploreBookAwait(a0Var, str, num, dVar);
    }

    public static b getBookInfo$default(WebBook webBook, a0 a0Var, Book book, f.z.f fVar, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            k0 k0Var = k0.f6264c;
            fVar = k0.f6263b;
        }
        if ((i2 & 8) != 0) {
            z = true;
        }
        return webBook.getBookInfo(a0Var, book, fVar, z);
    }

    public static Object getBookInfoAwait$default(WebBook webBook, a0 a0Var, Book book, boolean z, d dVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            b.C0148b c0148b = b.a;
            a0Var = b.f5558b;
        }
        if ((i2 & 4) != 0) {
            z = true;
        }
        return webBook.getBookInfoAwait(a0Var, book, z, dVar);
    }

    public static b getChapterList$default(WebBook webBook, a0 a0Var, Book book, f.z.f fVar, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            k0 k0Var = k0.f6264c;
            fVar = k0.f6263b;
        }
        return webBook.getChapterList(a0Var, book, fVar);
    }

    public static Object getChapterListAwait$default(WebBook webBook, a0 a0Var, Book book, d dVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            b.C0148b c0148b = b.a;
            a0Var = b.f5558b;
        }
        return webBook.getChapterListAwait(a0Var, book, dVar);
    }

    public static b getContent$default(WebBook webBook, a0 a0Var, Book book, BookChapter bookChapter, String str, f.z.f fVar, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            str = null;
        }
        String str2 = str;
        if ((i2 & 16) != 0) {
            k0 k0Var = k0.f6264c;
            fVar = k0.f6263b;
        }
        return webBook.getContent(a0Var, book, bookChapter, str2, fVar);
    }

    public static /* synthetic */ Object getContentAwait$default(WebBook webBook, a0 a0Var, Book book, BookChapter bookChapter, String str, d dVar, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            str = null;
        }
        return webBook.getContentAwait(a0Var, book, bookChapter, str, dVar);
    }

    public static b searchBook$default(WebBook webBook, a0 a0Var, String str, Integer num, f.z.f fVar, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            num = 1;
        }
        if ((i2 & 8) != 0) {
            k0 k0Var = k0.f6264c;
            fVar = k0.f6263b;
        }
        return webBook.searchBook(a0Var, str, num, fVar);
    }

    public static /* synthetic */ Object searchBookAwait$default(WebBook webBook, a0 a0Var, String str, Integer num, d dVar, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            num = 1;
        }
        return webBook.searchBookAwait(a0Var, str, num, dVar);
    }

    @NotNull
    public final b<List<SearchBook>> exploreBook(@NotNull a0 scope, @NotNull String url, @Nullable Integer page, @NotNull f.z.f context) {
        j.e(scope, "scope");
        j.e(url, "url");
        j.e(context, c.R);
        return b.a.a(scope, context, new AnonymousClass1(scope, url, page, null));
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object exploreBookAwait(@org.jetbrains.annotations.NotNull g.b.a0 r28, @org.jetbrains.annotations.NotNull java.lang.String r29, @org.jetbrains.annotations.Nullable java.lang.Integer r30, @org.jetbrains.annotations.NotNull f.z.d<? super java.util.ArrayList<io.legado.app.data.entities.SearchBook>> r31) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 202
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.legado.app.model.webBook.WebBook.exploreBookAwait(g.b.a0, java.lang.String, java.lang.Integer, f.z.d):java.lang.Object");
    }

    @NotNull
    public final b<Book> getBookInfo(@NotNull a0 scope, @NotNull Book book, @NotNull f.z.f context, boolean canReName) {
        j.e(scope, "scope");
        j.e(book, "book");
        j.e(context, c.R);
        return b.a.a(scope, context, new C03401(scope, book, canReName, null));
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object getBookInfoAwait(@org.jetbrains.annotations.NotNull g.b.a0 r22, @org.jetbrains.annotations.NotNull io.legado.app.data.entities.Book r23, boolean r24, @org.jetbrains.annotations.NotNull f.z.d<? super io.legado.app.data.entities.Book> r25) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 249
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.legado.app.model.webBook.WebBook.getBookInfoAwait(g.b.a0, io.legado.app.data.entities.Book, boolean, f.z.d):java.lang.Object");
    }

    @NotNull
    public final BookSource getBookSource() {
        return this.bookSource;
    }

    @NotNull
    public final b<List<BookChapter>> getChapterList(@NotNull a0 scope, @NotNull Book book, @NotNull f.z.f context) {
        j.e(scope, "scope");
        j.e(book, "book");
        j.e(context, c.R);
        return b.a.a(scope, context, new C03421(scope, book, null));
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x0120 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object getChapterListAwait(@org.jetbrains.annotations.NotNull g.b.a0 r23, @org.jetbrains.annotations.NotNull io.legado.app.data.entities.Book r24, @org.jetbrains.annotations.NotNull f.z.d<? super java.util.List<io.legado.app.data.entities.BookChapter>> r25) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 290
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.legado.app.model.webBook.WebBook.getChapterListAwait(g.b.a0, io.legado.app.data.entities.Book, f.z.d):java.lang.Object");
    }

    @NotNull
    public final b<String> getContent(@NotNull a0 scope, @NotNull Book book, @NotNull BookChapter bookChapter, @Nullable String nextChapterUrl, @NotNull f.z.f context) {
        j.e(scope, "scope");
        j.e(book, "book");
        j.e(bookChapter, "bookChapter");
        j.e(context, c.R);
        return b.a.a(scope, context, new C03441(scope, book, bookChapter, nextChapterUrl, null));
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x016d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object getContentAwait(@org.jetbrains.annotations.NotNull g.b.a0 r28, @org.jetbrains.annotations.NotNull io.legado.app.data.entities.Book r29, @org.jetbrains.annotations.NotNull io.legado.app.data.entities.BookChapter r30, @org.jetbrains.annotations.Nullable java.lang.String r31, @org.jetbrains.annotations.NotNull f.z.d<? super java.lang.String> r32) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 367
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.legado.app.model.webBook.WebBook.getContentAwait(g.b.a0, io.legado.app.data.entities.Book, io.legado.app.data.entities.BookChapter, java.lang.String, f.z.d):java.lang.Object");
    }

    @NotNull
    public final String getSourceUrl() {
        return this.bookSource.getBookSourceUrl();
    }

    @NotNull
    public final b<ArrayList<SearchBook>> searchBook(@NotNull a0 scope, @NotNull String key, @Nullable Integer page, @NotNull f.z.f context) {
        j.e(scope, "scope");
        j.e(key, "key");
        j.e(context, c.R);
        return b.a.a(scope, context, new C03461(scope, key, page, null));
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object searchBookAwait(@org.jetbrains.annotations.NotNull g.b.a0 r28, @org.jetbrains.annotations.NotNull java.lang.String r29, @org.jetbrains.annotations.Nullable java.lang.Integer r30, @org.jetbrains.annotations.NotNull f.z.d<? super java.util.ArrayList<io.legado.app.data.entities.SearchBook>> r31) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 223
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.legado.app.model.webBook.WebBook.searchBookAwait(g.b.a0, java.lang.String, java.lang.Integer, f.z.d):java.lang.Object");
    }
}

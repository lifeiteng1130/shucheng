package io.legado.app.model;

import android.annotation.SuppressLint;
import androidx.core.app.NotificationCompat;
import c.b.a.m.f;
import e.a.a.d.u.a;
import e.a.a.d.u.b;
import f.c0.b.q;
import f.c0.c.j;
import f.h0.k;
import f.v;
import f.x.e;
import f.z.d;
import f.z.j.a.g;
import g.b.a0;
import io.legado.app.data.entities.Book;
import io.legado.app.data.entities.BookChapter;
import io.legado.app.data.entities.RssArticle;
import io.legado.app.data.entities.RssSource;
import io.legado.app.model.rss.Rss;
import io.legado.app.model.rss.RssResult;
import io.legado.app.model.webBook.WebBook;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Debug.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001BB\t\b\u0002¢\u0006\u0004\b@\u0010AJ/\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0010\u0010\u0011J'\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0013\u0010\u0011J'\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J'\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0018\u0010\u0017J9\u0010\u001c\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u00192\b\u0010\u001b\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJK\u0010&\u001a\u00020\n2\b\u0010\u001e\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010!\u001a\u00020 2\b\b\u0002\u0010\"\u001a\u00020 2\b\b\u0002\u0010#\u001a\u00020 2\b\b\u0002\u0010%\u001a\u00020$¢\u0006\u0004\b&\u0010'J\u0017\u0010&\u001a\u00020\n2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b&\u0010(J\u0017\u0010*\u001a\u00020\n2\b\b\u0002\u0010)\u001a\u00020 ¢\u0006\u0004\b*\u0010+J\u001d\u0010,\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b,\u0010-J%\u0010,\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0006¢\u0006\u0004\b,\u0010\u0011R\u0016\u0010/\u001a\u00020.8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u00102\u001a\u0002018\u0002@\u0003X\u0083\u0004¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u00105\u001a\u0002048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u00106R$\u00108\u001a\u0004\u0018\u0001078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b8\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u0018\u0010>\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u0010?¨\u0006C"}, d2 = {"Lio/legado/app/model/Debug;", "", "Lg/b/a0;", "scope", "Lio/legado/app/data/entities/RssArticle;", "rssArticle", "", "ruleContent", "Lio/legado/app/data/entities/RssSource;", "rssSource", "Lf/v;", "rssContentDebug", "(Lg/b/a0;Lio/legado/app/data/entities/RssArticle;Ljava/lang/String;Lio/legado/app/data/entities/RssSource;)V", "Lio/legado/app/model/webBook/WebBook;", "webBook", "url", "exploreDebug", "(Lg/b/a0;Lio/legado/app/model/webBook/WebBook;Ljava/lang/String;)V", "key", "searchDebug", "Lio/legado/app/data/entities/Book;", "book", "infoDebug", "(Lg/b/a0;Lio/legado/app/model/webBook/WebBook;Lio/legado/app/data/entities/Book;)V", "tocDebug", "Lio/legado/app/data/entities/BookChapter;", "bookChapter", "nextChapterUrl", "contentDebug", "(Lg/b/a0;Lio/legado/app/model/webBook/WebBook;Lio/legado/app/data/entities/Book;Lio/legado/app/data/entities/BookChapter;Ljava/lang/String;)V", "sourceUrl", NotificationCompat.CATEGORY_MESSAGE, "", "print", "isHtml", "showTime", "", "state", "log", "(Ljava/lang/String;Ljava/lang/String;ZZZI)V", "(Ljava/lang/String;)V", "destroy", "cancelDebug", "(Z)V", "startDebug", "(Lg/b/a0;Lio/legado/app/data/entities/RssSource;)V", "Le/a/a/d/u/a;", "tasks", "Le/a/a/d/u/a;", "Ljava/text/SimpleDateFormat;", "DEBUG_TIME_FORMAT", "Ljava/text/SimpleDateFormat;", "", "startTime", "J", "Lio/legado/app/model/Debug$Callback;", "callback", "Lio/legado/app/model/Debug$Callback;", "getCallback", "()Lio/legado/app/model/Debug$Callback;", "setCallback", "(Lio/legado/app/model/Debug$Callback;)V", "debugSource", "Ljava/lang/String;", "<init>", "()V", "Callback", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class Debug {

    @Nullable
    private static Callback callback;

    @Nullable
    private static String debugSource;

    @NotNull
    public static final Debug INSTANCE = new Debug();

    @NotNull
    private static final a tasks = new a();

    @SuppressLint({"ConstantLocale"})
    @NotNull
    private static final SimpleDateFormat DEBUG_TIME_FORMAT = new SimpleDateFormat("[mm:ss.SSS]", Locale.getDefault());
    private static long startTime = System.currentTimeMillis();

    /* JADX INFO: compiled from: Debug.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lio/legado/app/model/Debug$Callback;", "", "", "state", "", NotificationCompat.CATEGORY_MESSAGE, "Lf/v;", "printLog", "(ILjava/lang/String;)V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
    public interface Callback {
        void printLog(int state, @NotNull String msg);
    }

    /* JADX INFO: renamed from: io.legado.app.model.Debug$rssContentDebug$1, reason: invalid class name */
    /* JADX INFO: compiled from: Debug.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lg/b/a0;", "", "it", "Lf/v;", "<anonymous>", "(Lg/b/a0;Ljava/lang/String;)V"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "io.legado.app.model.Debug$rssContentDebug$1", f = "Debug.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends g implements q<a0, String, d<? super v>, Object> {
        public /* synthetic */ Object L$0;
        public int label;

        public AnonymousClass1(d<? super AnonymousClass1> dVar) {
            super(3, dVar);
        }

        @Override // f.c0.b.q
        @Nullable
        public final Object invoke(@NotNull a0 a0Var, @NotNull String str, @Nullable d<? super v> dVar) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(dVar);
            anonymousClass1.L$0 = str;
            return anonymousClass1.invokeSuspend(v.a);
        }

        @Override // f.z.j.a.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            f.E5(obj);
            String str = (String) this.L$0;
            Debug debug = Debug.INSTANCE;
            Debug.log$default(debug, Debug.debugSource, str, false, false, false, 0, 60, null);
            Debug.log$default(debug, Debug.debugSource, "︽内容页解析完成", false, false, false, 1000, 28, null);
            return v.a;
        }
    }

    /* JADX INFO: renamed from: io.legado.app.model.Debug$rssContentDebug$2, reason: invalid class name */
    /* JADX INFO: compiled from: Debug.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lg/b/a0;", "", "it", "Lf/v;", "<anonymous>", "(Lg/b/a0;Ljava/lang/Throwable;)V"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "io.legado.app.model.Debug$rssContentDebug$2", f = "Debug.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends g implements q<a0, Throwable, d<? super v>, Object> {
        public /* synthetic */ Object L$0;
        public int label;

        public AnonymousClass2(d<? super AnonymousClass2> dVar) {
            super(3, dVar);
        }

        @Override // f.c0.b.q
        @Nullable
        public final Object invoke(@NotNull a0 a0Var, @NotNull Throwable th, @Nullable d<? super v> dVar) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(dVar);
            anonymousClass2.L$0 = th;
            return anonymousClass2.invokeSuspend(v.a);
        }

        @Override // f.z.j.a.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            f.E5(obj);
            Debug.log$default(Debug.INSTANCE, Debug.debugSource, f.C2((Throwable) this.L$0), false, false, false, -1, 28, null);
            return v.a;
        }
    }

    /* JADX INFO: renamed from: io.legado.app.model.Debug$startDebug$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Debug.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lg/b/a0;", "Lio/legado/app/model/rss/RssResult;", "it", "Lf/v;", "<anonymous>", "(Lg/b/a0;Lio/legado/app/model/rss/RssResult;)V"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "io.legado.app.model.Debug$startDebug$1", f = "Debug.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C03331 extends g implements q<a0, RssResult, d<? super v>, Object> {
        public final /* synthetic */ RssSource $rssSource;
        public final /* synthetic */ a0 $scope;
        public /* synthetic */ Object L$0;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C03331(RssSource rssSource, a0 a0Var, d<? super C03331> dVar) {
            super(3, dVar);
            this.$rssSource = rssSource;
            this.$scope = a0Var;
        }

        @Override // f.c0.b.q
        @Nullable
        public final Object invoke(@NotNull a0 a0Var, @NotNull RssResult rssResult, @Nullable d<? super v> dVar) {
            C03331 c03331 = new C03331(this.$rssSource, this.$scope, dVar);
            c03331.L$0 = rssResult;
            return c03331.invokeSuspend(v.a);
        }

        /* JADX WARN: Removed duplicated region for block: B:32:0x00b5  */
        @Override // f.z.j.a.a
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r14) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 224
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: io.legado.app.model.Debug.C03331.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: io.legado.app.model.Debug$startDebug$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Debug.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lg/b/a0;", "", "it", "Lf/v;", "<anonymous>", "(Lg/b/a0;Ljava/lang/Throwable;)V"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "io.legado.app.model.Debug$startDebug$2", f = "Debug.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C03342 extends g implements q<a0, Throwable, d<? super v>, Object> {
        public /* synthetic */ Object L$0;
        public int label;

        public C03342(d<? super C03342> dVar) {
            super(3, dVar);
        }

        @Override // f.c0.b.q
        @Nullable
        public final Object invoke(@NotNull a0 a0Var, @NotNull Throwable th, @Nullable d<? super v> dVar) {
            C03342 c03342 = new C03342(dVar);
            c03342.L$0 = th;
            return c03342.invokeSuspend(v.a);
        }

        @Override // f.z.j.a.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            f.E5(obj);
            Debug.log$default(Debug.INSTANCE, Debug.debugSource, f.C2((Throwable) this.L$0), false, false, false, -1, 28, null);
            return v.a;
        }
    }

    private Debug() {
    }

    public static /* synthetic */ void cancelDebug$default(Debug debug, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = false;
        }
        debug.cancelDebug(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void contentDebug(a0 scope, WebBook webBook, Book book, BookChapter bookChapter, String nextChapterUrl) {
        log$default(this, debugSource, "︾开始解析正文页", false, false, false, 0, 60, null);
        b<?> content$default = WebBook.getContent$default(webBook, scope, book, bookChapter, nextChapterUrl, null, 16, null);
        b.e(content$default, null, new Debug$contentDebug$content$1(null), 1);
        b.b(content$default, null, new Debug$contentDebug$content$2(null), 1);
        tasks.a(content$default);
    }

    private final void exploreDebug(a0 scope, WebBook webBook, String url) {
        log$default(this, debugSource, "︾开始解析发现页", false, false, false, 0, 60, null);
        b<?> bVarExploreBook$default = WebBook.exploreBook$default(webBook, scope, url, 1, null, 8, null);
        b.e(bVarExploreBook$default, null, new Debug$exploreDebug$explore$1(scope, webBook, null), 1);
        b.b(bVarExploreBook$default, null, new Debug$exploreDebug$explore$2(null), 1);
        tasks.a(bVarExploreBook$default);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void infoDebug(a0 scope, WebBook webBook, Book book) {
        if (!k.s(book.getTocUrl())) {
            log$default(this, debugSource, "目录url不为空,详情页已解析", false, false, false, 0, 60, null);
            log$default(this, debugSource, null, false, false, false, 0, 46, null);
            tocDebug(scope, webBook, book);
        } else {
            log$default(this, debugSource, "︾开始解析详情页", false, false, false, 0, 60, null);
            b<?> bookInfo$default = WebBook.getBookInfo$default(webBook, scope, book, null, false, 12, null);
            b.e(bookInfo$default, null, new Debug$infoDebug$info$1(scope, webBook, book, null), 1);
            b.b(bookInfo$default, null, new Debug$infoDebug$info$2(null), 1);
            tasks.a(bookInfo$default);
        }
    }

    public static /* synthetic */ void log$default(Debug debug, String str, String str2, boolean z, boolean z2, boolean z3, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str2 = "";
        }
        debug.log(str, str2, (i3 & 4) != 0 ? true : z, (i3 & 8) != 0 ? false : z2, (i3 & 16) != 0 ? true : z3, (i3 & 32) != 0 ? 1 : i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void rssContentDebug(a0 scope, RssArticle rssArticle, String ruleContent, RssSource rssSource) {
        log$default(this, debugSource, "︾开始解析内容页", false, false, false, 0, 60, null);
        b content$default = Rss.getContent$default(Rss.INSTANCE, scope, rssArticle, ruleContent, rssSource, null, 16, null);
        b.e(content$default, null, new AnonymousClass1(null), 1);
        b.b(content$default, null, new AnonymousClass2(null), 1);
    }

    private final void searchDebug(a0 scope, WebBook webBook, String key) {
        log$default(this, debugSource, "︾开始解析搜索页", false, false, false, 0, 60, null);
        b<?> bVarSearchBook$default = WebBook.searchBook$default(webBook, scope, key, 1, null, 8, null);
        b.e(bVarSearchBook$default, null, new Debug$searchDebug$search$1(scope, webBook, null), 1);
        b.b(bVarSearchBook$default, null, new Debug$searchDebug$search$2(null), 1);
        tasks.a(bVarSearchBook$default);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void tocDebug(a0 scope, WebBook webBook, Book book) {
        log$default(this, debugSource, "︾开始解析目录页", false, false, false, 0, 60, null);
        b<?> chapterList$default = WebBook.getChapterList$default(webBook, scope, book, null, 4, null);
        b.e(chapterList$default, null, new Debug$tocDebug$chapterList$1(scope, webBook, book, null), 1);
        b.b(chapterList$default, null, new Debug$tocDebug$chapterList$2(null), 1);
        tasks.a(chapterList$default);
    }

    public final void cancelDebug(boolean destroy) {
        tasks.b();
        if (destroy) {
            debugSource = null;
            callback = null;
        }
    }

    @Nullable
    public final Callback getCallback() {
        return callback;
    }

    public final synchronized void log(@Nullable String sourceUrl, @Nullable String msg, boolean print, boolean isHtml, boolean showTime, int state) {
        if (j.a(debugSource, sourceUrl) && callback != null && print) {
            String strA = msg == null ? "" : msg;
            if (isHtml) {
                e.a.a.h.q qVar = e.a.a.h.q.a;
                strA = e.a.a.h.q.a(msg);
            }
            if (showTime) {
                strA = ((Object) DEBUG_TIME_FORMAT.format(new Date(System.currentTimeMillis() - startTime))) + ' ' + strA;
            }
            Callback callback2 = callback;
            if (callback2 != null) {
                callback2.printLog(state, strA);
            }
        }
    }

    public final void setCallback(@Nullable Callback callback2) {
        callback = callback2;
    }

    public final void startDebug(@NotNull a0 scope, @NotNull RssSource rssSource) {
        j.e(scope, "scope");
        j.e(rssSource, "rssSource");
        cancelDebug$default(this, false, 1, null);
        String sourceUrl = rssSource.getSourceUrl();
        debugSource = sourceUrl;
        log$default(this, sourceUrl, "︾开始解析", false, false, false, 0, 60, null);
        Set<Map.Entry<String, String>> setEntrySet = rssSource.sortUrls().entrySet();
        j.d(setEntrySet, "rssSource.sortUrls().entries");
        Object objJ = e.j(setEntrySet);
        j.d(objJ, "rssSource.sortUrls().entries.first()");
        Map.Entry entry = (Map.Entry) objJ;
        Rss rss = Rss.INSTANCE;
        Object key = entry.getKey();
        j.d(key, "sort.key");
        Object value = entry.getValue();
        j.d(value, "sort.value");
        b articles$default = Rss.getArticles$default(rss, scope, (String) key, (String) value, rssSource, 1, null, 32, null);
        b.e(articles$default, null, new C03331(rssSource, scope, null), 1);
        b.b(articles$default, null, new C03342(null), 1);
    }

    public final synchronized void log(@Nullable String msg) {
        log$default(this, debugSource, msg, true, false, false, 0, 56, null);
    }

    public final void startDebug(@NotNull a0 scope, @NotNull WebBook webBook, @NotNull String key) {
        j.e(scope, "scope");
        j.e(webBook, "webBook");
        j.e(key, "key");
        cancelDebug$default(this, false, 1, null);
        debugSource = webBook.getSourceUrl();
        startTime = System.currentTimeMillis();
        if (f.o3(key)) {
            Book book = new Book(null, null, null, null, null, null, null, null, null, null, null, null, null, 0, 0L, null, 0L, 0L, 0, 0, null, 0, 0, 0L, null, false, 0, 0, null, null, 1073741823, null);
            book.setOrigin(webBook.getSourceUrl());
            book.setBookUrl(key);
            log$default(this, webBook.getSourceUrl(), j.k("⇒开始访问详情页:", key), false, false, false, 0, 60, null);
            infoDebug(scope, webBook, book);
            return;
        }
        if (k.d(key, "::", false, 2)) {
            String strSubstring = key.substring(k.q(key, "::", 0, false, 6) + 2);
            j.d(strSubstring, "(this as java.lang.String).substring(startIndex)");
            log$default(this, webBook.getSourceUrl(), j.k("⇒开始访问发现页:", strSubstring), false, false, false, 0, 60, null);
            exploreDebug(scope, webBook, strSubstring);
            return;
        }
        if (k.K(key, "++", false, 2)) {
            String strSubstring2 = key.substring(2);
            j.d(strSubstring2, "(this as java.lang.String).substring(startIndex)");
            Book book2 = new Book(null, null, null, null, null, null, null, null, null, null, null, null, null, 0, 0L, null, 0L, 0L, 0, 0, null, 0, 0, 0L, null, false, 0, 0, null, null, 1073741823, null);
            book2.setOrigin(webBook.getSourceUrl());
            book2.setTocUrl(strSubstring2);
            log$default(this, webBook.getSourceUrl(), j.k("⇒开始访目录页:", strSubstring2), false, false, false, 0, 60, null);
            tocDebug(scope, webBook, book2);
            return;
        }
        if (k.K(key, "--", false, 2)) {
            String strSubstring3 = key.substring(2);
            j.d(strSubstring3, "(this as java.lang.String).substring(startIndex)");
            Book book3 = new Book(null, null, null, null, null, null, null, null, null, null, null, null, null, 0, 0L, null, 0L, 0L, 0, 0, null, 0, 0, 0L, null, false, 0, 0, null, null, 1073741823, null);
            book3.setOrigin(webBook.getSourceUrl());
            log$default(this, webBook.getSourceUrl(), j.k("⇒开始访正文页:", strSubstring3), false, false, false, 0, 60, null);
            BookChapter bookChapter = new BookChapter(null, null, null, null, 0, null, null, null, null, null, null, null, 4095, null);
            bookChapter.setTitle("调试");
            bookChapter.setUrl(strSubstring3);
            contentDebug(scope, webBook, book3, bookChapter, null);
            return;
        }
        log$default(this, webBook.getSourceUrl(), j.k("⇒开始搜索关键字:", key), false, false, false, 0, 60, null);
        searchDebug(scope, webBook, key);
    }
}

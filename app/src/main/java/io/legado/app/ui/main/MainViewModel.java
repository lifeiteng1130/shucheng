package io.legado.app.ui.main;

import android.app.Application;
import c.b.a.m.f;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.umeng.analytics.pro.ai;
import e.a.a.d.e;
import f.c0.b.p;
import f.c0.b.q;
import f.c0.c.j;
import f.v;
import f.z.j.a.g;
import g.b.a0;
import g.b.v0;
import g.b.x0;
import io.legado.app.base.BaseViewModel;
import io.legado.app.data.AppDatabaseKt;
import io.legado.app.data.entities.Book;
import io.legado.app.data.entities.BookSource;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mozilla.javascript.optimizer.OptRuntime;

/* JADX INFO: compiled from: MainViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b \u0010!J\u000f\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0003\u0010\u0004J\u001b\u0010\b\u001a\u00020\u00022\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\n\u0010\u0004J\u000f\u0010\u000b\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u000b\u0010\u0004R\u001f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\"\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00060\u00168\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001d\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u001b¨\u0006\""}, d2 = {"Lio/legado/app/ui/main/MainViewModel;", "Lio/legado/app/base/BaseViewModel;", "Lf/v;", "onCleared", "()V", "", "Lio/legado/app/data/entities/Book;", "books", "f", "(Ljava/util/List;)V", "g", "e", "Ljava/util/concurrent/CopyOnWriteArraySet;", "", "Ljava/util/concurrent/CopyOnWriteArraySet;", "getUpdateList", "()Ljava/util/concurrent/CopyOnWriteArraySet;", "updateList", "Lg/b/v0;", "d", "Lg/b/v0;", "upTocPool", "j$/util/concurrent/ConcurrentHashMap", "Lj$/util/concurrent/ConcurrentHashMap;", "bookMap", "", ai.aD, OptRuntime.GeneratorState.resumptionPoint_TYPE, "threadCount", "usePoolCount", "Landroid/app/Application;", "application", "<init>", "(Landroid/app/Application;)V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class MainViewModel extends BaseViewModel {

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    public int threadCount;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public v0 upTocPool;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final CopyOnWriteArraySet<String> updateList;

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final ConcurrentHashMap<String, Book> bookMap;

    /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
    public volatile int usePoolCount;

    /* JADX INFO: compiled from: MainViewModel.kt */
    @DebugMetadata(c = "io.legado.app.ui.main.MainViewModel$upToc$1", f = "MainViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class a extends g implements p<a0, f.z.d<? super v>, Object> {
        public final /* synthetic */ List<Book> $books;
        public int label;
        public final /* synthetic */ MainViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(List<Book> list, MainViewModel mainViewModel, f.z.d<? super a> dVar) {
            super(2, dVar);
            this.$books = list;
            this.this$0 = mainViewModel;
        }

        @Override // f.z.j.a.a
        @NotNull
        public final f.z.d<v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
            return new a(this.$books, this.this$0, dVar);
        }

        @Override // f.c0.b.p
        @Nullable
        public final Object invoke(@NotNull a0 a0Var, @Nullable f.z.d<? super v> dVar) {
            return ((a) create(a0Var, dVar)).invokeSuspend(v.a);
        }

        @Override // f.z.j.a.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
            int i2;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            f.E5(obj);
            List<Book> list = this.$books;
            ArrayList<Book> arrayList = new ArrayList();
            Iterator<T> it = list.iterator();
            while (true) {
                i2 = 0;
                z = false;
                boolean z = false;
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                Book book = (Book) next;
                if (!j.a(book.getOrigin(), "loc_book") && book.getCanUpdate()) {
                    z = true;
                }
                if (Boolean.valueOf(z).booleanValue()) {
                    arrayList.add(next);
                }
            }
            MainViewModel mainViewModel = this.this$0;
            for (Book book2 : arrayList) {
                mainViewModel.bookMap.put(book2.getBookUrl(), book2);
            }
            int i3 = this.this$0.threadCount;
            if (i3 > 0) {
                do {
                    i2++;
                    int i4 = this.this$0.usePoolCount;
                    MainViewModel mainViewModel2 = this.this$0;
                    if (i4 < mainViewModel2.threadCount) {
                        mainViewModel2.usePoolCount++;
                        this.this$0.g();
                    }
                } while (i2 < i3);
            }
            return v.a;
        }
    }

    /* JADX INFO: compiled from: MainViewModel.kt */
    @DebugMetadata(c = "io.legado.app.ui.main.MainViewModel$updateToc$1$2$1", f = "MainViewModel.kt", i = {0, 0, 1}, l = {81, 83}, m = "invokeSuspend", n = {"$this$execute", "webBook", "webBook"}, s = {"L$0", "L$1", "L$0"})
    public static final class b extends g implements p<a0, f.z.d<? super v>, Object> {
        public final /* synthetic */ Book $book;
        public final /* synthetic */ BookSource $bookSource;
        private /* synthetic */ Object L$0;
        public Object L$1;
        public int label;
        public final /* synthetic */ MainViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(BookSource bookSource, Book book, MainViewModel mainViewModel, f.z.d<? super b> dVar) {
            super(2, dVar);
            this.$bookSource = bookSource;
            this.$book = book;
            this.this$0 = mainViewModel;
        }

        @Override // f.z.j.a.a
        @NotNull
        public final f.z.d<v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
            b bVar = new b(this.$bookSource, this.$book, this.this$0, dVar);
            bVar.L$0 = obj;
            return bVar;
        }

        @Override // f.c0.b.p
        @Nullable
        public final Object invoke(@NotNull a0 a0Var, @Nullable f.z.d<? super v> dVar) {
            return ((b) create(a0Var, dVar)).invokeSuspend(v.a);
        }

        /* JADX WARN: Removed duplicated region for block: B:19:0x0068 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0069  */
        @Override // f.z.j.a.a
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r13) throws java.lang.Throwable {
            /*
                r12 = this;
                f.z.i.a r0 = f.z.i.a.COROUTINE_SUSPENDED
                int r1 = r12.label
                r2 = 0
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L29
                if (r1 == r4) goto L1d
                if (r1 != r3) goto L15
                java.lang.Object r0 = r12.L$0
                io.legado.app.model.webBook.WebBook r0 = (io.legado.app.model.webBook.WebBook) r0
                c.b.a.m.f.E5(r13)
                goto L6a
            L15:
                java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r13.<init>(r0)
                throw r13
            L1d:
                java.lang.Object r1 = r12.L$1
                io.legado.app.model.webBook.WebBook r1 = (io.legado.app.model.webBook.WebBook) r1
                java.lang.Object r5 = r12.L$0
                g.b.a0 r5 = (g.b.a0) r5
                c.b.a.m.f.E5(r13)
                goto L59
            L29:
                c.b.a.m.f.E5(r13)
                java.lang.Object r13 = r12.L$0
                g.b.a0 r13 = (g.b.a0) r13
                io.legado.app.model.webBook.WebBook r1 = new io.legado.app.model.webBook.WebBook
                io.legado.app.data.entities.BookSource r5 = r12.$bookSource
                r1.<init>(r5)
                io.legado.app.data.entities.Book r5 = r12.$book
                java.lang.String r5 = r5.getTocUrl()
                boolean r5 = f.h0.k.s(r5)
                if (r5 == 0) goto L5a
                io.legado.app.data.entities.Book r7 = r12.$book
                r8 = 0
                r10 = 4
                r11 = 0
                r12.L$0 = r13
                r12.L$1 = r1
                r12.label = r4
                r5 = r1
                r6 = r13
                r9 = r12
                java.lang.Object r5 = io.legado.app.model.webBook.WebBook.getBookInfoAwait$default(r5, r6, r7, r8, r9, r10, r11)
                if (r5 != r0) goto L58
                return r0
            L58:
                r5 = r13
            L59:
                r13 = r5
            L5a:
                io.legado.app.data.entities.Book r5 = r12.$book
                r12.L$0 = r1
                r12.L$1 = r2
                r12.label = r3
                java.lang.Object r13 = r1.getChapterListAwait(r13, r5, r12)
                if (r13 != r0) goto L69
                return r0
            L69:
                r0 = r1
            L6a:
                java.util.List r13 = (java.util.List) r13
                io.legado.app.data.AppDatabase r1 = io.legado.app.data.AppDatabaseKt.getAppDb()
                io.legado.app.data.dao.BookDao r1 = r1.getBookDao()
                io.legado.app.data.entities.Book[] r3 = new io.legado.app.data.entities.Book[r4]
                io.legado.app.data.entities.Book r4 = r12.$book
                r5 = 0
                r3[r5] = r4
                r1.update(r3)
                io.legado.app.data.AppDatabase r1 = io.legado.app.data.AppDatabaseKt.getAppDb()
                io.legado.app.data.dao.BookChapterDao r1 = r1.getBookChapterDao()
                io.legado.app.data.entities.Book r3 = r12.$book
                java.lang.String r3 = r3.getBookUrl()
                r1.delByBook(r3)
                io.legado.app.data.AppDatabase r1 = io.legado.app.data.AppDatabaseKt.getAppDb()
                io.legado.app.data.dao.BookChapterDao r1 = r1.getBookChapterDao()
                io.legado.app.data.entities.BookChapter[] r3 = new io.legado.app.data.entities.BookChapter[r5]
                java.lang.Object[] r13 = r13.toArray(r3)
                java.lang.String r3 = "null cannot be cast to non-null type kotlin.Array<T>"
                java.util.Objects.requireNonNull(r13, r3)
                io.legado.app.data.entities.BookChapter[] r13 = (io.legado.app.data.entities.BookChapter[]) r13
                int r3 = r13.length
                java.lang.Object[] r13 = java.util.Arrays.copyOf(r13, r3)
                io.legado.app.data.entities.BookChapter[] r13 = (io.legado.app.data.entities.BookChapter[]) r13
                r1.insert(r13)
                io.legado.app.ui.main.MainViewModel r3 = r12.this$0
                io.legado.app.data.entities.Book r13 = r12.$book
                java.util.Objects.requireNonNull(r3)
                e.a.a.g.h.c r6 = new e.a.a.g.h.c
                r6.<init>(r13, r0, r2)
                r4 = 0
                r5 = 0
                r7 = 3
                r8 = 0
                io.legado.app.base.BaseViewModel.a(r3, r4, r5, r6, r7, r8)
                f.v r13 = f.v.a
                return r13
            */
            throw new UnsupportedOperationException("Method not decompiled: io.legado.app.ui.main.MainViewModel.b.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: compiled from: MainViewModel.kt */
    @DebugMetadata(c = "io.legado.app.ui.main.MainViewModel$updateToc$1$2$2", f = "MainViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class c extends g implements q<a0, Throwable, f.z.d<? super v>, Object> {
        public /* synthetic */ Object L$0;
        public int label;

        public c(f.z.d<? super c> dVar) {
            super(3, dVar);
        }

        @Override // f.c0.b.q
        @Nullable
        public final Object invoke(@NotNull a0 a0Var, @NotNull Throwable th, @Nullable f.z.d<? super v> dVar) {
            c cVar = new c(dVar);
            cVar.L$0 = th;
            return cVar.invokeSuspend(v.a);
        }

        @Override // f.z.j.a.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            f.E5(obj);
            ((Throwable) this.L$0).printStackTrace();
            return v.a;
        }
    }

    /* JADX INFO: compiled from: MainViewModel.kt */
    @DebugMetadata(c = "io.legado.app.ui.main.MainViewModel$updateToc$1$2$3", f = "MainViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class d extends g implements p<a0, f.z.d<? super v>, Object> {
        public final /* synthetic */ Book $book;
        public final /* synthetic */ Map.Entry<String, Book> $bookEntry;
        private /* synthetic */ Object L$0;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(Map.Entry<String, Book> entry, Book book, f.z.d<? super d> dVar) {
            super(2, dVar);
            this.$bookEntry = entry;
            this.$book = book;
        }

        @Override // f.z.j.a.a
        @NotNull
        public final f.z.d<v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
            d dVar2 = MainViewModel.this.new d(this.$bookEntry, this.$book, dVar);
            dVar2.L$0 = obj;
            return dVar2;
        }

        @Override // f.c0.b.p
        @Nullable
        public final Object invoke(@NotNull a0 a0Var, @Nullable f.z.d<? super v> dVar) {
            return ((d) create(a0Var, dVar)).invokeSuspend(v.a);
        }

        @Override // f.z.j.a.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
            v vVar;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            f.E5(obj);
            a0 a0Var = (a0) this.L$0;
            MainViewModel mainViewModel = MainViewModel.this;
            Map.Entry<String, Book> entry = this.$bookEntry;
            Book book = this.$book;
            synchronized (a0Var) {
                mainViewModel.bookMap.remove(entry.getKey());
                mainViewModel.updateList.remove(book.getBookUrl());
                LiveEventBus.get("upBookToc").post(book.getBookUrl());
                mainViewModel.e();
                vVar = v.a;
            }
            return vVar;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MainViewModel(@NotNull Application application) {
        super(application);
        j.e(application, "application");
        int iK = e.a.k();
        this.threadCount = iK;
        ExecutorService executorServiceNewFixedThreadPool = Executors.newFixedThreadPool(iK);
        j.d(executorServiceNewFixedThreadPool, "newFixedThreadPool(threadCount)");
        this.upTocPool = new x0(executorServiceNewFixedThreadPool);
        this.updateList = new CopyOnWriteArraySet<>();
        this.bookMap = new ConcurrentHashMap<>();
    }

    public final void e() {
        if (this.bookMap.size() > this.updateList.size()) {
            g();
        } else {
            this.usePoolCount--;
        }
    }

    public final void f(@NotNull List<Book> books) {
        j.e(books, "books");
        BaseViewModel.a(this, null, null, new a(books, this, null), 3, null);
    }

    public final synchronized void g() {
        for (Map.Entry<String, Book> entry : this.bookMap.entrySet()) {
            if (!this.updateList.contains(entry.getKey())) {
                Book value = entry.getValue();
                synchronized (this) {
                    this.updateList.add(value.getBookUrl());
                    LiveEventBus.get("upBookToc").post(value.getBookUrl());
                    BookSource bookSource = AppDatabaseKt.getAppDb().getBookSourceDao().getBookSource(value.getOrigin());
                    e.a.a.d.u.b bVar = null;
                    if (bookSource != null) {
                        e.a.a.d.u.b bVarA = BaseViewModel.a(this, null, this.upTocPool, new b(bookSource, value, this, null), 1, null);
                        e.a.a.d.u.b.b(bVarA, null, new c(null), 1);
                        e.a.a.d.u.b.c(bVarA, null, new d(entry, value, null), 1);
                        bVar = bVarA;
                    }
                    if (bVar == null) {
                        synchronized (this) {
                            this.bookMap.remove(entry.getKey());
                            this.updateList.remove(value.getBookUrl());
                            LiveEventBus.get("upBookToc").post(value.getBookUrl());
                            e();
                        }
                    }
                }
                return;
            }
        }
        this.usePoolCount--;
    }

    @Override // io.legado.app.base.BaseViewModel, androidx.view.ViewModel
    public void onCleared() {
        super.onCleared();
        this.upTocPool.close();
    }
}

package io.legado.app.ui.book.changecover;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;
import androidx.view.MutableLiveData;
import c.b.a.m.f;
import com.qq.e.comm.constants.Constants;
import com.umeng.analytics.pro.ai;
import e.a.a.d.e;
import f.c0.b.p;
import f.c0.b.q;
import f.c0.c.j;
import f.h0.k;
import f.v;
import f.z.d;
import f.z.j.a.g;
import g.b.a0;
import g.b.k0;
import g.b.v0;
import io.legado.app.base.BaseViewModel;
import io.legado.app.data.AppDatabaseKt;
import io.legado.app.data.entities.BookSource;
import io.legado.app.data.entities.SearchBook;
import io.legado.app.model.webBook.WebBook;
import io.legado.app.ui.book.changecover.ChangeCoverViewModel;
import j$.util.Comparator;
import j$.util.function.Function;
import j$.util.function.ToDoubleFunction;
import j$.util.function.ToIntFunction;
import j$.util.function.ToLongFunction;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mozilla.javascript.optimizer.OptRuntime;

/* JADX INFO: compiled from: ChangeCoverViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010D\u001a\u00020C¢\u0006\u0004\bE\u0010FJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0007\u0010\u0004R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010\nR\"\u0010\u0012\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R%\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00140\u00138\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00150\u001b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010&\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010%R\u001f\u0010*\u001a\b\u0012\u0004\u0012\u00020'0\u00138\u0006@\u0006¢\u0006\f\n\u0004\b(\u0010\u0017\u001a\u0004\b)\u0010\u0019R\"\u0010-\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\r\u001a\u0004\b+\u0010\u000f\"\u0004\b,\u0010\u0011R&\u00103\u001a\u0012\u0012\u0004\u0012\u00020/0.j\b\u0012\u0004\u0012\u00020/`08\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u00102R\u0016\u00107\u001a\u0002048\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u00106R\u0019\u0010<\u001a\u0002088\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u00109\u001a\u0004\b:\u0010;R\u0016\u0010@\u001a\u00020=8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010B\u001a\u0002048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u00106¨\u0006G"}, d2 = {"Lio/legado/app/ui/book/changecover/ChangeCoverViewModel;", "Lio/legado/app/base/BaseViewModel;", "Lf/v;", "onCleared", "()V", "g", "e", "f", "Le/a/a/d/u/a;", "h", "Le/a/a/d/u/a;", "tasks", "", "Ljava/lang/String;", "getAuthor", "()Ljava/lang/String;", "setAuthor", "(Ljava/lang/String;)V", "author", "Landroidx/lifecycle/MutableLiveData;", "", "Lio/legado/app/data/entities/SearchBook;", "k", "Landroidx/lifecycle/MutableLiveData;", "getSearchBooksLiveData", "()Landroidx/lifecycle/MutableLiveData;", "searchBooksLiveData", "Ljava/util/concurrent/CopyOnWriteArraySet;", Constants.LANDSCAPE, "Ljava/util/concurrent/CopyOnWriteArraySet;", "searchBooks", "", "n", "J", "postTime", "Lg/b/v0;", "d", "Lg/b/v0;", "searchPool", "", "j", "getSearchStateData", "searchStateData", "getName", "setName", "name", "Ljava/util/ArrayList;", "Lio/legado/app/data/entities/BookSource;", "Lkotlin/collections/ArrayList;", ai.aA, "Ljava/util/ArrayList;", "bookSourceList", "", ai.aD, OptRuntime.GeneratorState.resumptionPoint_TYPE, "threadCount", "Landroid/os/Handler;", "Landroid/os/Handler;", "getHandler", "()Landroid/os/Handler;", "handler", "Ljava/lang/Runnable;", "m", "Ljava/lang/Runnable;", "sendRunnable", "o", "searchIndex", "Landroid/app/Application;", "application", "<init>", "(Landroid/app/Application;)V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class ChangeCoverViewModel extends BaseViewModel {

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final int threadCount;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public v0 searchPool;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final Handler handler;

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public String name;

    /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public String author;

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public e.a.a.d.u.a tasks;

    /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public ArrayList<BookSource> bookSourceList;

    /* JADX INFO: renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> searchStateData;

    /* JADX INFO: renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final MutableLiveData<List<SearchBook>> searchBooksLiveData;

    /* JADX INFO: renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final CopyOnWriteArraySet<SearchBook> searchBooks;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    @NotNull
    public final Runnable sendRunnable;

    /* JADX INFO: renamed from: n, reason: from kotlin metadata */
    public long postTime;

    /* JADX INFO: renamed from: o, reason: from kotlin metadata */
    public volatile int searchIndex;

    /* JADX INFO: compiled from: ChangeCoverViewModel.kt */
    @DebugMetadata(c = "io.legado.app.ui.book.changecover.ChangeCoverViewModel$search$task$1", f = "ChangeCoverViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class a extends g implements q<a0, ArrayList<SearchBook>, d<? super v>, Object> {
        public /* synthetic */ Object L$0;
        public int label;

        public a(d<? super a> dVar) {
            super(3, dVar);
        }

        @Override // f.c0.b.q
        @Nullable
        public final Object invoke(@NotNull a0 a0Var, @NotNull ArrayList<SearchBook> arrayList, @Nullable d<? super v> dVar) {
            a aVar = ChangeCoverViewModel.this.new a(dVar);
            aVar.L$0 = arrayList;
            return aVar.invokeSuspend(v.a);
        }

        @Override // f.z.j.a.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            f.E5(obj);
            ArrayList arrayList = (ArrayList) this.L$0;
            if (!arrayList.isEmpty()) {
                Object obj2 = arrayList.get(0);
                j.d(obj2, "it[0]");
                SearchBook searchBook = (SearchBook) obj2;
                if (j.a(searchBook.getName(), ChangeCoverViewModel.this.name) && j.a(searchBook.getAuthor(), ChangeCoverViewModel.this.author)) {
                    String coverUrl = searchBook.getCoverUrl();
                    if (!(coverUrl == null || coverUrl.length() == 0)) {
                        AppDatabaseKt.getAppDb().getSearchBookDao().insert(searchBook);
                        if (!ChangeCoverViewModel.this.searchBooks.contains(searchBook)) {
                            ChangeCoverViewModel.this.searchBooks.add(searchBook);
                            ChangeCoverViewModel.this.g();
                        }
                    }
                }
            }
            return v.a;
        }
    }

    /* JADX INFO: compiled from: ChangeCoverViewModel.kt */
    @DebugMetadata(c = "io.legado.app.ui.book.changecover.ChangeCoverViewModel$search$task$2", f = "ChangeCoverViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class b extends g implements p<a0, d<? super v>, Object> {
        public int label;

        public b(d<? super b> dVar) {
            super(2, dVar);
        }

        @Override // f.z.j.a.a
        @NotNull
        public final d<v> create(@Nullable Object obj, @NotNull d<?> dVar) {
            return ChangeCoverViewModel.this.new b(dVar);
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
            ChangeCoverViewModel.this.f();
            return v.a;
        }
    }

    /* JADX INFO: compiled from: Comparisons.kt */
    public static final class c<T> implements Comparator<T>, j$.util.Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator, j$.util.Comparator
        public final int compare(T t, T t2) {
            return f.V0(Integer.valueOf(((SearchBook) t).getOriginOrder()), Integer.valueOf(((SearchBook) t2).getOriginOrder()));
        }

        @Override // java.util.Comparator, j$.util.Comparator
        public /* synthetic */ Comparator reversed() {
            return Collections.reverseOrder(this);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ Comparator thenComparing(Function function) {
            return Comparator.CC.$default$thenComparing(this, function);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparing(Function function, java.util.Comparator comparator) {
            return Comparator.CC.$default$thenComparing(this, function, comparator);
        }

        @Override // java.util.Comparator, j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparing(java.util.Comparator comparator) {
            return Comparator.CC.$default$thenComparing(this, comparator);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparingDouble(ToDoubleFunction toDoubleFunction) {
            return Comparator.CC.$default$thenComparingDouble(this, toDoubleFunction);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparingInt(ToIntFunction toIntFunction) {
            return Comparator.CC.$default$thenComparingInt(this, toIntFunction);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparingLong(ToLongFunction toLongFunction) {
            return Comparator.CC.$default$thenComparingLong(this, toLongFunction);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChangeCoverViewModel(@NotNull Application application) {
        super(application);
        j.e(application, "application");
        this.threadCount = e.a.k();
        this.handler = new Handler(Looper.getMainLooper());
        this.name = "";
        this.author = "";
        this.tasks = new e.a.a.d.u.a();
        this.bookSourceList = new ArrayList<>();
        this.searchStateData = new MutableLiveData<>();
        this.searchBooksLiveData = new MutableLiveData<>();
        this.searchBooks = new CopyOnWriteArraySet<>();
        this.sendRunnable = new Runnable() { // from class: e.a.a.g.d.c.c
            @Override // java.lang.Runnable
            public final void run() {
                ChangeCoverViewModel changeCoverViewModel = this.a;
                j.e(changeCoverViewModel, "this$0");
                changeCoverViewModel.g();
            }
        };
        this.searchIndex = -1;
    }

    public final synchronized void e() {
        if (this.searchIndex >= f.x.e.m(this.bookSourceList)) {
            return;
        }
        this.searchIndex++;
        BookSource bookSource = this.bookSourceList.get(this.searchIndex);
        j.d(bookSource, "bookSourceList[searchIndex]");
        BookSource bookSource2 = bookSource;
        String coverUrl = bookSource2.getSearchRule().getCoverUrl();
        if (coverUrl == null || k.s(coverUrl)) {
            f();
            return;
        }
        WebBook webBook = new WebBook(bookSource2);
        String str = this.name;
        v0 v0Var = this.searchPool;
        j.c(v0Var);
        e.a.a.d.u.b<?> bVarSearchBook$default = WebBook.searchBook$default(webBook, this, str, null, v0Var, 4, null);
        bVarSearchBook$default.f(60000L);
        k0 k0Var = k0.f6264c;
        bVarSearchBook$default.d(k0.f6263b, new a(null));
        e.a.a.d.u.b.c(bVarSearchBook$default, null, new b(null), 1);
        this.tasks.a(bVarSearchBook$default);
    }

    public final synchronized void f() {
        if (this.searchIndex < f.x.e.m(this.bookSourceList)) {
            e();
        } else {
            this.searchIndex++;
        }
        if (this.searchIndex >= f.x.e.m(this.bookSourceList) + Math.min(this.bookSourceList.size(), this.threadCount)) {
            this.searchStateData.postValue(Boolean.FALSE);
        }
    }

    public final synchronized void g() {
        if (System.currentTimeMillis() >= this.postTime + ((long) 500)) {
            this.handler.removeCallbacks(this.sendRunnable);
            this.postTime = System.currentTimeMillis();
            this.searchBooksLiveData.postValue(f.x.e.B(f.x.e.F(this.searchBooks), new c()));
        } else {
            this.handler.removeCallbacks(this.sendRunnable);
            this.handler.postDelayed(this.sendRunnable, 500L);
        }
    }

    @Override // io.legado.app.base.BaseViewModel, androidx.view.ViewModel
    public void onCleared() {
        super.onCleared();
        v0 v0Var = this.searchPool;
        if (v0Var == null) {
            return;
        }
        v0Var.close();
    }
}

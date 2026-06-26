package io.legado.app.ui.book.changesource;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;
import androidx.view.MutableLiveData;
import c.b.a.m.f;
import com.qq.e.comm.constants.Constants;
import com.umeng.analytics.pro.ai;
import e.a.a.d.e;
import e.a.a.g.d.d.q;
import e.a.a.g.d.d.r;
import e.a.a.g.d.d.s;
import f.c0.b.p;
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
import io.legado.app.data.dao.SearchBookDao;
import io.legado.app.data.entities.BookSource;
import io.legado.app.data.entities.SearchBook;
import io.legado.app.model.webBook.WebBook;
import io.legado.app.ui.book.changesource.ChangeSourceViewModel;
import j$.util.Comparator;
import j$.util.function.Function;
import j$.util.function.ToDoubleFunction;
import j$.util.function.ToIntFunction;
import j$.util.function.ToLongFunction;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArraySet;
import k.d.a.h;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mozilla.javascript.optimizer.OptRuntime;

/* JADX INFO: compiled from: ChangeSourceViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010F\u001a\u00020E¢\u0006\u0004\bG\u0010HJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0004J\r\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0007\u0010\u0004R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010\nR\"\u0010\u0012\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R%\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u001c0\u001b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u0016\u0010%\u001a\u00020#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010$R\u0019\u0010+\u001a\u00020&8\u0006@\u0006¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\"\u0010.\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\r\u001a\u0004\b,\u0010\u000f\"\u0004\b-\u0010\u0011R&\u00104\u001a\u0012\u0012\u0004\u0012\u0002000/j\b\u0012\u0004\u0012\u000200`18\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u00106\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u0010\rR\u0016\u00108\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u0010\u0019R\u001c\u0010<\u001a\b\u0012\u0004\u0012\u00020\u001d098\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b:\u0010;R\u0018\u0010@\u001a\u0004\u0018\u00010=8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u0010?R\u001f\u0010D\u001a\b\u0012\u0004\u0012\u00020A0\u001b8\u0006@\u0006¢\u0006\f\n\u0004\bB\u0010\u001f\u001a\u0004\bC\u0010!¨\u0006I"}, d2 = {"Lio/legado/app/ui/book/changesource/ChangeSourceViewModel;", "Lio/legado/app/base/BaseViewModel;", "Lf/v;", "j", "()V", "h", ai.aA, "onCleared", "", "n", "J", "postTime", "", "Ljava/lang/String;", "getAuthor", "()Ljava/lang/String;", "setAuthor", "(Ljava/lang/String;)V", "author", "Ljava/lang/Runnable;", "o", "Ljava/lang/Runnable;", "sendRunnable", "", ai.aD, OptRuntime.GeneratorState.resumptionPoint_TYPE, "threadCount", "Landroidx/lifecycle/MutableLiveData;", "", "Lio/legado/app/data/entities/SearchBook;", "g", "Landroidx/lifecycle/MutableLiveData;", "getSearchBooksLiveData", "()Landroidx/lifecycle/MutableLiveData;", "searchBooksLiveData", "Le/a/a/d/u/a;", "Le/a/a/d/u/a;", "tasks", "Landroid/os/Handler;", "e", "Landroid/os/Handler;", "getHandler", "()Landroid/os/Handler;", "handler", "getName", "setName", "name", "Ljava/util/ArrayList;", "Lio/legado/app/data/entities/BookSource;", "Lkotlin/collections/ArrayList;", Constants.LANDSCAPE, "Ljava/util/ArrayList;", "bookSourceList", "k", "screenKey", "p", "searchIndex", "Ljava/util/concurrent/CopyOnWriteArraySet;", "m", "Ljava/util/concurrent/CopyOnWriteArraySet;", "searchBooks", "Lg/b/v0;", "d", "Lg/b/v0;", "searchPool", "", "f", "getSearchStateData", "searchStateData", "Landroid/app/Application;", "application", "<init>", "(Landroid/app/Application;)V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class ChangeSourceViewModel extends BaseViewModel {

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
    public final MutableLiveData<Boolean> searchStateData;

    /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final MutableLiveData<List<SearchBook>> searchBooksLiveData;

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public String name;

    /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public String author;

    /* JADX INFO: renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public e.a.a.d.u.a tasks;

    /* JADX INFO: renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public String screenKey;

    /* JADX INFO: renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public ArrayList<BookSource> bookSourceList;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    @NotNull
    public final CopyOnWriteArraySet<SearchBook> searchBooks;

    /* JADX INFO: renamed from: n, reason: from kotlin metadata */
    public long postTime;

    /* JADX INFO: renamed from: o, reason: from kotlin metadata */
    @NotNull
    public final Runnable sendRunnable;

    /* JADX INFO: renamed from: p, reason: from kotlin metadata */
    public volatile int searchIndex;

    /* JADX INFO: compiled from: ChangeSourceViewModel.kt */
    @DebugMetadata(c = "io.legado.app.ui.book.changesource.ChangeSourceViewModel$loadDbSearchBook$1", f = "ChangeSourceViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class a extends g implements p<a0, d<? super v>, Object> {
        public int label;

        public a(d<? super a> dVar) {
            super(2, dVar);
        }

        @Override // f.z.j.a.a
        @NotNull
        public final d<v> create(@Nullable Object obj, @NotNull d<?> dVar) {
            return ChangeSourceViewModel.this.new a(dVar);
        }

        @Override // f.c0.b.p
        @Nullable
        public final Object invoke(@NotNull a0 a0Var, @Nullable d<? super v> dVar) {
            return ((a) create(a0Var, dVar)).invokeSuspend(v.a);
        }

        @Override // f.z.j.a.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
            List<SearchBook> changeSourceSearch;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            f.E5(obj);
            ChangeSourceViewModel.this.searchBooks.clear();
            ChangeSourceViewModel.this.j();
            if (e.a.a()) {
                SearchBookDao searchBookDao = AppDatabaseKt.getAppDb().getSearchBookDao();
                ChangeSourceViewModel changeSourceViewModel = ChangeSourceViewModel.this;
                changeSourceSearch = searchBookDao.getChangeSourceSearch(changeSourceViewModel.name, changeSourceViewModel.author, ChangeSourceViewModel.e(changeSourceViewModel));
            } else {
                SearchBookDao searchBookDao2 = AppDatabaseKt.getAppDb().getSearchBookDao();
                ChangeSourceViewModel changeSourceViewModel2 = ChangeSourceViewModel.this;
                changeSourceSearch = searchBookDao2.getChangeSourceSearch(changeSourceViewModel2.name, "", ChangeSourceViewModel.e(changeSourceViewModel2));
            }
            ChangeSourceViewModel.this.searchBooks.addAll(changeSourceSearch);
            ChangeSourceViewModel changeSourceViewModel3 = ChangeSourceViewModel.this;
            changeSourceViewModel3.searchBooksLiveData.postValue(f.x.e.F(changeSourceViewModel3.searchBooks));
            if (changeSourceSearch.size() <= 1) {
                ChangeSourceViewModel changeSourceViewModel4 = ChangeSourceViewModel.this;
                Objects.requireNonNull(changeSourceViewModel4);
                BaseViewModel.a(changeSourceViewModel4, null, null, new s(changeSourceViewModel4, null), 3, null);
            }
            return v.a;
        }
    }

    /* JADX INFO: compiled from: Comparisons.kt */
    public static final class b<T> implements Comparator<T>, j$.util.Comparator {
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
    public ChangeSourceViewModel(@NotNull Application application) {
        super(application);
        j.e(application, "application");
        this.threadCount = e.a.k();
        this.handler = new Handler(Looper.getMainLooper());
        this.searchStateData = new MutableLiveData<>();
        this.searchBooksLiveData = new MutableLiveData<>();
        this.name = "";
        this.author = "";
        this.tasks = new e.a.a.d.u.a();
        this.screenKey = "";
        this.bookSourceList = new ArrayList<>();
        this.searchBooks = new CopyOnWriteArraySet<>();
        this.sendRunnable = new Runnable() { // from class: e.a.a.g.d.d.i
            @Override // java.lang.Runnable
            public final void run() {
                ChangeSourceViewModel changeSourceViewModel = this.a;
                f.c0.c.j.e(changeSourceViewModel, "this$0");
                changeSourceViewModel.j();
            }
        };
        this.searchIndex = -1;
    }

    public static final String e(ChangeSourceViewModel changeSourceViewModel) {
        Objects.requireNonNull(changeSourceViewModel);
        String strO2 = f.O2(h.g(), "searchGroup", null, 2);
        return strO2 == null ? "" : strO2;
    }

    public static final void f(ChangeSourceViewModel changeSourceViewModel) {
        synchronized (changeSourceViewModel) {
            if (changeSourceViewModel.searchIndex >= f.x.e.m(changeSourceViewModel.bookSourceList)) {
                return;
            }
            changeSourceViewModel.searchIndex++;
            BookSource bookSource = changeSourceViewModel.bookSourceList.get(changeSourceViewModel.searchIndex);
            j.d(bookSource, "bookSourceList[searchIndex]");
            WebBook webBook = new WebBook(bookSource);
            String str = changeSourceViewModel.name;
            v0 v0Var = changeSourceViewModel.searchPool;
            j.c(v0Var);
            e.a.a.d.u.b<?> bVarSearchBook$default = WebBook.searchBook$default(webBook, changeSourceViewModel, str, null, v0Var, 4, null);
            bVarSearchBook$default.f(60000L);
            k0 k0Var = k0.f6264c;
            bVarSearchBook$default.d(k0.f6263b, new q(changeSourceViewModel, webBook, null));
            e.a.a.d.u.b.c(bVarSearchBook$default, null, new r(changeSourceViewModel, null), 1);
            changeSourceViewModel.tasks.a(bVarSearchBook$default);
        }
    }

    public static final void g(ChangeSourceViewModel changeSourceViewModel, SearchBook searchBook) {
        if (changeSourceViewModel.searchBooks.contains(searchBook)) {
            return;
        }
        AppDatabaseKt.getAppDb().getSearchBookDao().insert(searchBook);
        if ((changeSourceViewModel.screenKey.length() == 0) || k.d(searchBook.getName(), changeSourceViewModel.screenKey, false, 2)) {
            changeSourceViewModel.searchBooks.add(searchBook);
        }
        changeSourceViewModel.j();
    }

    public final void h() {
        BaseViewModel.a(this, null, null, new a(null), 3, null);
    }

    public final void i() {
        HashSet<e.a.a.d.u.b<?>> hashSet = this.tasks.a;
        if ((hashSet == null ? 0 : hashSet.size()) == 0) {
            BaseViewModel.a(this, null, null, new s(this, null), 3, null);
            return;
        }
        this.tasks.b();
        v0 v0Var = this.searchPool;
        if (v0Var != null) {
            v0Var.close();
        }
        this.searchStateData.postValue(Boolean.FALSE);
    }

    public final synchronized void j() {
        if (System.currentTimeMillis() >= this.postTime + ((long) 500)) {
            this.handler.removeCallbacks(this.sendRunnable);
            this.postTime = System.currentTimeMillis();
            this.searchBooksLiveData.postValue(f.x.e.B(f.x.e.F(this.searchBooks), new b()));
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

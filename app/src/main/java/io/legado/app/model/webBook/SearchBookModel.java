package io.legado.app.model.webBook;

import c.b.a.m.f;
import e.a.a.d.e;
import e.a.a.d.u.a;
import e.a.a.d.u.b;
import f.c0.c.j;
import f.h0.k;
import g.b.a0;
import g.b.k0;
import g.b.v0;
import g.b.x0;
import io.legado.app.data.AppDatabaseKt;
import io.legado.app.data.entities.BookSource;
import io.legado.app.data.entities.SearchBook;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import k.d.a.h;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mozilla.javascript.optimizer.OptRuntime;

/* JADX INFO: compiled from: SearchBookModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001,B\u0017\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b*\u0010+J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0007\u0010\u000bJ\r\u0010\f\u001a\u00020\u0002¢\u0006\u0004\b\f\u0010\u0004J\r\u0010\r\u001a\u00020\u0002¢\u0006\u0004\b\r\u0010\u0004R\u0016\u0010\u000f\u001a\u00020\u000e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0012\u001a\u00020\u00118\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0015\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0017\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R&\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\u001a0\u0019j\b\u0012\u0004\u0012\u00020\u001a`\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\u001e\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0019\u0010 \u001a\u00020\u00148\u0006@\u0006¢\u0006\f\n\u0004\b \u0010\u0016\u001a\u0004\b!\u0010\"R\u0016\u0010#\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010\u0016R\u0018\u0010%\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010(\u001a\u00020'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010)¨\u0006-"}, d2 = {"Lio/legado/app/model/webBook/SearchBookModel;", "", "Lf/v;", "initSearchPool", "()V", "", "searchId", "search", "(J)V", "", "key", "(JLjava/lang/String;)V", "cancelSearch", "close", "Lio/legado/app/model/webBook/SearchBookModel$CallBack;", "callBack", "Lio/legado/app/model/webBook/SearchBookModel$CallBack;", "Lg/b/a0;", "scope", "Lg/b/a0;", "", "searchIndex", OptRuntime.GeneratorState.resumptionPoint_TYPE, "mSearchId", "J", "Ljava/util/ArrayList;", "Lio/legado/app/data/entities/BookSource;", "Lkotlin/collections/ArrayList;", "bookSourceList", "Ljava/util/ArrayList;", "searchKey", "Ljava/lang/String;", "threadCount", "getThreadCount", "()I", "searchPage", "Lg/b/v0;", "searchPool", "Lg/b/v0;", "Le/a/a/d/u/a;", "tasks", "Le/a/a/d/u/a;", "<init>", "(Lg/b/a0;Lio/legado/app/model/webBook/SearchBookModel$CallBack;)V", "CallBack", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class SearchBookModel {

    @NotNull
    private ArrayList<BookSource> bookSourceList;

    @NotNull
    private final CallBack callBack;
    private long mSearchId;

    @NotNull
    private final a0 scope;
    private volatile int searchIndex;

    @NotNull
    private String searchKey;
    private int searchPage;

    @Nullable
    private v0 searchPool;

    @NotNull
    private a tasks;
    private final int threadCount;

    /* JADX INFO: compiled from: SearchBookModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J'\u0010\t\u001a\u00020\u00022\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007H&¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0002H&¢\u0006\u0004\b\u000b\u0010\u0004J\u000f\u0010\f\u001a\u00020\u0002H&¢\u0006\u0004\b\f\u0010\u0004¨\u0006\r"}, d2 = {"Lio/legado/app/model/webBook/SearchBookModel$CallBack;", "", "Lf/v;", "onSearchStart", "()V", "Ljava/util/ArrayList;", "Lio/legado/app/data/entities/SearchBook;", "Lkotlin/collections/ArrayList;", "searchBooks", "onSearchSuccess", "(Ljava/util/ArrayList;)V", "onSearchFinish", "onSearchCancel", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
    public interface CallBack {
        void onSearchCancel();

        void onSearchFinish();

        void onSearchStart();

        void onSearchSuccess(@NotNull ArrayList<SearchBook> searchBooks);
    }

    public SearchBookModel(@NotNull a0 a0Var, @NotNull CallBack callBack) {
        j.e(a0Var, "scope");
        j.e(callBack, "callBack");
        this.scope = a0Var;
        this.callBack = callBack;
        this.threadCount = e.a.k();
        this.searchPage = 1;
        this.searchKey = "";
        this.tasks = new a();
        this.bookSourceList = new ArrayList<>();
        this.searchIndex = -1;
    }

    private final void initSearchPool() {
        ExecutorService executorServiceNewFixedThreadPool = Executors.newFixedThreadPool(this.threadCount);
        j.d(executorServiceNewFixedThreadPool, "newFixedThreadPool(threadCount)");
        this.searchPool = new x0(executorServiceNewFixedThreadPool);
    }

    public final void cancelSearch() {
        close();
        this.callBack.onSearchCancel();
    }

    public final void close() {
        this.tasks.b();
        v0 v0Var = this.searchPool;
        if (v0Var != null) {
            v0Var.close();
        }
        this.mSearchId = 0L;
    }

    public final int getThreadCount() {
        return this.threadCount;
    }

    public final void search(long searchId, @NotNull String key) {
        j.e(key, "key");
        this.callBack.onSearchStart();
        int i2 = 0;
        if (searchId != this.mSearchId) {
            if (key.length() == 0) {
                this.callBack.onSearchCancel();
                return;
            }
            this.searchKey = key;
            if (this.mSearchId != 0) {
                close();
            }
            initSearchPool();
            this.mSearchId = searchId;
            this.searchPage = 1;
            String strO2 = f.O2(h.g(), "searchGroup", null, 2);
            if (strO2 == null) {
                strO2 = "";
            }
            this.bookSourceList.clear();
            if (k.s(strO2)) {
                this.bookSourceList.addAll(AppDatabaseKt.getAppDb().getBookSourceDao().getAllEnabled());
            } else {
                this.bookSourceList.addAll(AppDatabaseKt.getAppDb().getBookSourceDao().getEnabledByGroup(strO2));
            }
        } else {
            this.searchPage++;
        }
        this.searchIndex = -1;
        int i3 = this.threadCount;
        if (i3 > 0) {
            do {
                i2++;
                search(searchId);
            } while (i2 < i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void search(long searchId) {
        synchronized (this) {
            if (this.searchIndex >= f.x.e.m(this.bookSourceList)) {
                return;
            }
            this.searchIndex++;
            BookSource bookSource = this.bookSourceList.get(this.searchIndex);
            j.d(bookSource, "bookSourceList[searchIndex]");
            WebBook webBook = new WebBook(bookSource);
            a0 a0Var = this.scope;
            String str = this.searchKey;
            Integer numValueOf = Integer.valueOf(this.searchPage);
            v0 v0Var = this.searchPool;
            j.c(v0Var);
            b<ArrayList<SearchBook>> bVarSearchBook = webBook.searchBook(a0Var, str, numValueOf, v0Var);
            bVarSearchBook.f(30000L);
            k0 k0Var = k0.f6264c;
            bVarSearchBook.d(k0.f6263b, new SearchBookModel$search$1$task$1(searchId, this, null));
            b.c(bVarSearchBook, null, new SearchBookModel$search$1$task$2(this, searchId, null), 1);
            this.tasks.a(bVarSearchBook);
        }
    }
}

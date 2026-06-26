package io.legado.app.ui.book.search;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;
import androidx.view.MutableLiveData;
import c.b.a.m.f;
import com.qq.e.comm.constants.Constants;
import com.umeng.analytics.pro.ai;
import e.a.a.g.d.j.q;
import e.a.a.g.d.j.r;
import f.c0.b.l;
import f.c0.b.p;
import f.c0.c.j;
import f.h0.k;
import f.v;
import f.x.e;
import f.z.d;
import f.z.j.a.g;
import g.b.a0;
import io.legado.app.base.BaseViewModel;
import io.legado.app.data.AppDatabaseKt;
import io.legado.app.data.dao.SearchBookDao;
import io.legado.app.data.entities.SearchBook;
import io.legado.app.model.webBook.SearchBookModel;
import io.legado.app.ui.book.search.SearchViewModel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: SearchViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010I\u001a\u00020H¢\u0006\u0004\bJ\u0010KJ\u0015\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ'\u0010\u000e\u001a\u00020\u00052\u0016\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0010\u0010\tJ\u000f\u0010\u0011\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0011\u0010\tJD\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00032%\u0010\u0017\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u000b¢\u0006\f\b\u0015\u0012\b\b\u0012\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0014¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u001a\u0010\tJ\u000f\u0010\u001b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u001b\u0010\tR&\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR.\u0010%\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u001f0\u001e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(R(\u0010+\u001a\b\u0012\u0004\u0012\u00020*0\u001e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010 \u001a\u0004\b+\u0010\"\"\u0004\b,\u0010$R\u0016\u0010.\u001a\u00020&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010(R\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u00101R\"\u00107\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u0010\u0007R\"\u0010:\u001a\u00020*8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b8\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u0019\u0010C\u001a\u00020>8\u0006@\u0006¢\u0006\f\n\u0004\b?\u0010@\u001a\u0004\bA\u0010BR\u0016\u0010G\u001a\u00020D8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bE\u0010F¨\u0006L"}, d2 = {"Lio/legado/app/ui/book/search/SearchViewModel;", "Lio/legado/app/base/BaseViewModel;", "Lio/legado/app/model/webBook/SearchBookModel$CallBack;", "", "key", "Lf/v;", "f", "(Ljava/lang/String;)V", "onSearchStart", "()V", "Ljava/util/ArrayList;", "Lio/legado/app/data/entities/SearchBook;", "Lkotlin/collections/ArrayList;", "searchBooks", "onSearchSuccess", "(Ljava/util/ArrayList;)V", "onSearchFinish", "onSearchCancel", "name", "author", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "searchBook", "success", "e", "(Ljava/lang/String;Ljava/lang/String;Lf/c0/b/l;)V", "onCleared", "g", ai.aA, "Ljava/util/ArrayList;", "Landroidx/lifecycle/MutableLiveData;", "", "Landroidx/lifecycle/MutableLiveData;", "getSearchBookLiveData", "()Landroidx/lifecycle/MutableLiveData;", "setSearchBookLiveData", "(Landroidx/lifecycle/MutableLiveData;)V", "searchBookLiveData", "", "j", "J", "searchID", "", "isSearchLiveData", "setSearchLiveData", "k", "postTime", "Lio/legado/app/model/webBook/SearchBookModel;", "d", "Lio/legado/app/model/webBook/SearchBookModel;", "searchBookModel", "Ljava/lang/String;", "getSearchKey", "()Ljava/lang/String;", "setSearchKey", "searchKey", "h", "Z", "isLoading", "()Z", "setLoading", "(Z)V", "Landroid/os/Handler;", ai.aD, "Landroid/os/Handler;", "getHandler", "()Landroid/os/Handler;", "handler", "Ljava/lang/Runnable;", Constants.LANDSCAPE, "Ljava/lang/Runnable;", "sendRunnable", "Landroid/app/Application;", "application", "<init>", "(Landroid/app/Application;)V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class SearchViewModel extends BaseViewModel implements SearchBookModel.CallBack {

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final Handler handler;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final SearchBookModel searchBookModel;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public MutableLiveData<Boolean> isSearchLiveData;

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public MutableLiveData<List<SearchBook>> searchBookLiveData;

    /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public String searchKey;

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    public boolean isLoading;

    /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public ArrayList<SearchBook> searchBooks;

    /* JADX INFO: renamed from: j, reason: collision with root package name and from kotlin metadata */
    public long searchID;

    /* JADX INFO: renamed from: k, reason: collision with root package name and from kotlin metadata */
    public long postTime;

    /* JADX INFO: renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final Runnable sendRunnable;

    /* JADX INFO: compiled from: SearchViewModel.kt */
    @DebugMetadata(c = "io.legado.app.ui.book.search.SearchViewModel$getSearchBook$1", f = "SearchViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class a extends g implements p<a0, d<? super v>, Object> {
        public final /* synthetic */ String $author;
        public final /* synthetic */ String $name;
        public final /* synthetic */ l<SearchBook, v> $success;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public a(String str, String str2, l<? super SearchBook, v> lVar, d<? super a> dVar) {
            super(2, dVar);
            this.$name = str;
            this.$author = str2;
            this.$success = lVar;
        }

        @Override // f.z.j.a.a
        @NotNull
        public final d<v> create(@Nullable Object obj, @NotNull d<?> dVar) {
            return new a(this.$name, this.$author, this.$success, dVar);
        }

        @Override // f.c0.b.p
        @Nullable
        public final Object invoke(@NotNull a0 a0Var, @Nullable d<? super v> dVar) {
            return ((a) create(a0Var, dVar)).invokeSuspend(v.a);
        }

        @Override // f.z.j.a.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            f.E5(obj);
            SearchBook firstByNameAuthor = AppDatabaseKt.getAppDb().getSearchBookDao().getFirstByNameAuthor(this.$name, this.$author);
            l<SearchBook, v> lVar = this.$success;
            if (lVar == null) {
                return null;
            }
            lVar.invoke(firstByNameAuthor);
            return v.a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchViewModel(@NotNull Application application) {
        super(application);
        j.e(application, "application");
        this.handler = new Handler(Looper.getMainLooper());
        this.searchBookModel = new SearchBookModel(this, this);
        this.isSearchLiveData = new MutableLiveData<>();
        this.searchBookLiveData = new MutableLiveData<>();
        this.searchKey = "";
        this.searchBooks = new ArrayList<>();
        this.sendRunnable = new Runnable() { // from class: e.a.a.g.d.j.m
            @Override // java.lang.Runnable
            public final void run() {
                SearchViewModel searchViewModel = this.a;
                f.c0.c.j.e(searchViewModel, "this$0");
                searchViewModel.g();
            }
        };
    }

    public final void e(@NotNull String name, @NotNull String author, @Nullable l<? super SearchBook, v> success) {
        j.e(name, "name");
        j.e(author, "author");
        BaseViewModel.a(this, null, null, new a(name, author, success, null), 3, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x001a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void f(@org.jetbrains.annotations.NotNull java.lang.String r6) {
        /*
            r5 = this;
            java.lang.String r0 = "key"
            f.c0.c.j.e(r6, r0)
            java.lang.String r0 = r5.searchKey
            boolean r0 = f.c0.c.j.a(r0, r6)
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L1a
            int r0 = r6.length()
            if (r0 <= 0) goto L17
            r0 = 1
            goto L18
        L17:
            r0 = 0
        L18:
            if (r0 == 0) goto L33
        L1a:
            io.legado.app.model.webBook.SearchBookModel r0 = r5.searchBookModel
            r0.cancelSearch()
            java.util.ArrayList<io.legado.app.data.entities.SearchBook> r0 = r5.searchBooks
            r0.clear()
            androidx.lifecycle.MutableLiveData<java.util.List<io.legado.app.data.entities.SearchBook>> r0 = r5.searchBookLiveData
            java.util.ArrayList<io.legado.app.data.entities.SearchBook> r3 = r5.searchBooks
            r0.postValue(r3)
            long r3 = java.lang.System.currentTimeMillis()
            r5.searchID = r3
            r5.searchKey = r6
        L33:
            java.lang.String r6 = r5.searchKey
            int r6 = r6.length()
            if (r6 != 0) goto L3c
            r1 = 1
        L3c:
            if (r1 == 0) goto L3f
            return
        L3f:
            io.legado.app.model.webBook.SearchBookModel r6 = r5.searchBookModel
            long r0 = r5.searchID
            java.lang.String r2 = r5.searchKey
            r6.search(r0, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.legado.app.ui.book.search.SearchViewModel.f(java.lang.String):void");
    }

    public final synchronized void g() {
        long j2 = 500;
        if (System.currentTimeMillis() >= this.postTime + j2) {
            this.handler.removeCallbacks(this.sendRunnable);
            this.postTime = System.currentTimeMillis();
            this.searchBookLiveData.postValue(this.searchBooks);
        } else {
            this.handler.removeCallbacks(this.sendRunnable);
            this.handler.postDelayed(this.sendRunnable, (j2 - System.currentTimeMillis()) + this.postTime);
        }
    }

    @Override // io.legado.app.base.BaseViewModel, androidx.view.ViewModel
    public void onCleared() {
        super.onCleared();
        this.searchBookModel.close();
    }

    @Override // io.legado.app.model.webBook.SearchBookModel.CallBack
    public void onSearchCancel() {
        this.isSearchLiveData.postValue(Boolean.FALSE);
        this.isLoading = false;
    }

    @Override // io.legado.app.model.webBook.SearchBookModel.CallBack
    public void onSearchFinish() {
        this.isSearchLiveData.postValue(Boolean.FALSE);
        this.isLoading = false;
    }

    @Override // io.legado.app.model.webBook.SearchBookModel.CallBack
    public void onSearchStart() {
        this.isSearchLiveData.postValue(Boolean.TRUE);
        this.isLoading = true;
    }

    @Override // io.legado.app.model.webBook.SearchBookModel.CallBack
    public void onSearchSuccess(@NotNull ArrayList<SearchBook> searchBooks) {
        j.e(searchBooks, "searchBooks");
        boolean zK2 = f.K2(b(), "precisionSearch", false, 2);
        SearchBookDao searchBookDao = AppDatabaseKt.getAppDb().getSearchBookDao();
        Object[] array = searchBooks.toArray(new SearchBook[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        SearchBook[] searchBookArr = (SearchBook[]) array;
        searchBookDao.insert((SearchBook[]) Arrays.copyOf(searchBookArr, searchBookArr.length));
        synchronized (this) {
            if (!searchBooks.isEmpty()) {
                ArrayList<SearchBook> arrayList = new ArrayList(this.searchBooks);
                ArrayList<SearchBook> arrayList2 = new ArrayList<>();
                ArrayList<SearchBook> arrayList3 = new ArrayList();
                ArrayList<SearchBook> arrayList4 = new ArrayList();
                for (SearchBook searchBook : arrayList) {
                    if (!f.p3(this)) {
                        return;
                    }
                    if (j.a(searchBook.getName(), this.searchKey) || j.a(searchBook.getAuthor(), this.searchKey)) {
                        arrayList2.add(searchBook);
                    } else if (k.d(searchBook.getName(), this.searchKey, false, 2) || k.d(searchBook.getAuthor(), this.searchKey, false, 2)) {
                        arrayList3.add(searchBook);
                    } else {
                        arrayList4.add(searchBook);
                    }
                }
                for (SearchBook searchBook2 : searchBooks) {
                    if (!f.p3(this)) {
                        return;
                    }
                    if (j.a(searchBook2.getName(), this.searchKey) || j.a(searchBook2.getAuthor(), this.searchKey)) {
                        boolean z = false;
                        for (SearchBook searchBook3 : arrayList2) {
                            if (!f.p3(this)) {
                                return;
                            }
                            if (j.a(searchBook3.getName(), searchBook2.getName()) && j.a(searchBook3.getAuthor(), searchBook2.getAuthor())) {
                                searchBook3.addOrigin(searchBook2.getOrigin());
                                z = true;
                            }
                        }
                        if (!z) {
                            arrayList2.add(searchBook2);
                        }
                    } else if (k.d(searchBook2.getName(), this.searchKey, false, 2) || k.d(searchBook2.getAuthor(), this.searchKey, false, 2)) {
                        boolean z2 = false;
                        for (SearchBook searchBook4 : arrayList3) {
                            if (!f.p3(this)) {
                                return;
                            }
                            if (j.a(searchBook4.getName(), searchBook2.getName()) && j.a(searchBook4.getAuthor(), searchBook2.getAuthor())) {
                                searchBook4.addOrigin(searchBook2.getOrigin());
                                z2 = true;
                            }
                        }
                        if (!z2) {
                            arrayList3.add(searchBook2);
                        }
                    } else if (zK2) {
                        continue;
                    } else {
                        boolean z3 = false;
                        for (SearchBook searchBook5 : arrayList4) {
                            if (!f.p3(this)) {
                                return;
                            }
                            if (j.a(searchBook5.getName(), searchBook2.getName()) && j.a(searchBook5.getAuthor(), searchBook2.getAuthor())) {
                                searchBook5.addOrigin(searchBook2.getOrigin());
                                z3 = true;
                            }
                        }
                        if (!z3) {
                            arrayList4.add(searchBook2);
                        }
                    }
                }
                if (!f.p3(this)) {
                    return;
                }
                if (arrayList2.size() > 1) {
                    f.m5(arrayList2, new q());
                }
                arrayList2.addAll(e.B(arrayList3, new r()));
                if (!zK2) {
                    arrayList2.addAll(arrayList4);
                }
                this.searchBooks = arrayList2;
                g();
            }
        }
    }
}

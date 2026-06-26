package io.legado.app.ui.book.explore;

import android.app.Application;
import androidx.view.MutableLiveData;
import c.b.a.m.f;
import com.umeng.analytics.pro.ai;
import f.c0.b.q;
import f.c0.c.j;
import f.v;
import f.z.d;
import f.z.j.a.g;
import g.b.a0;
import g.b.k0;
import io.legado.app.base.BaseViewModel;
import io.legado.app.data.AppDatabaseKt;
import io.legado.app.data.dao.SearchBookDao;
import io.legado.app.data.entities.BookSource;
import io.legado.app.data.entities.SearchBook;
import io.legado.app.model.webBook.WebBook;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mozilla.javascript.optimizer.OptRuntime;

/* JADX INFO: compiled from: ExploreShowViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001d\u0010\u001eJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\nR\u001f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R%\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00130\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u000f\u001a\u0004\b\u0016\u0010\u0011R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001f"}, d2 = {"Lio/legado/app/ui/book/explore/ExploreShowViewModel;", "Lio/legado/app/base/BaseViewModel;", "Lf/v;", "e", "()V", "", "g", OptRuntime.GeneratorState.resumptionPoint_TYPE, "page", "Lio/legado/app/data/entities/BookSource;", "Lio/legado/app/data/entities/BookSource;", "bookSource", "Landroidx/lifecycle/MutableLiveData;", "", "d", "Landroidx/lifecycle/MutableLiveData;", "getErrorLiveData", "()Landroidx/lifecycle/MutableLiveData;", "errorLiveData", "", "Lio/legado/app/data/entities/SearchBook;", ai.aD, "getBooksData", "booksData", "f", "Ljava/lang/String;", "exploreUrl", "Landroid/app/Application;", "application", "<init>", "(Landroid/app/Application;)V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class ExploreShowViewModel extends BaseViewModel {

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final MutableLiveData<List<SearchBook>> booksData;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final MutableLiveData<String> errorLiveData;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public BookSource bookSource;

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public String exploreUrl;

    /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
    public int page;

    /* JADX INFO: compiled from: ExploreShowViewModel.kt */
    @DebugMetadata(c = "io.legado.app.ui.book.explore.ExploreShowViewModel$explore$1", f = "ExploreShowViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class a extends g implements q<a0, List<? extends SearchBook>, d<? super v>, Object> {
        public /* synthetic */ Object L$0;
        public int label;

        public a(d<? super a> dVar) {
            super(3, dVar);
        }

        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(@NotNull a0 a0Var, @NotNull List<SearchBook> list, @Nullable d<? super v> dVar) {
            a aVar = ExploreShowViewModel.this.new a(dVar);
            aVar.L$0 = list;
            return aVar.invokeSuspend(v.a);
        }

        @Override // f.c0.b.q
        public /* bridge */ /* synthetic */ Object invoke(a0 a0Var, List<? extends SearchBook> list, d<? super v> dVar) {
            return invoke2(a0Var, (List<SearchBook>) list, dVar);
        }

        @Override // f.z.j.a.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            f.E5(obj);
            List<SearchBook> list = (List) this.L$0;
            ExploreShowViewModel.this.booksData.postValue(list);
            SearchBookDao searchBookDao = AppDatabaseKt.getAppDb().getSearchBookDao();
            Object[] array = list.toArray(new SearchBook[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
            SearchBook[] searchBookArr = (SearchBook[]) array;
            searchBookDao.insert((SearchBook[]) Arrays.copyOf(searchBookArr, searchBookArr.length));
            ExploreShowViewModel.this.page++;
            return v.a;
        }
    }

    /* JADX INFO: compiled from: ExploreShowViewModel.kt */
    @DebugMetadata(c = "io.legado.app.ui.book.explore.ExploreShowViewModel$explore$2", f = "ExploreShowViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class b extends g implements q<a0, Throwable, d<? super v>, Object> {
        public /* synthetic */ Object L$0;
        public int label;

        public b(d<? super b> dVar) {
            super(3, dVar);
        }

        @Override // f.c0.b.q
        @Nullable
        public final Object invoke(@NotNull a0 a0Var, @NotNull Throwable th, @Nullable d<? super v> dVar) {
            b bVar = ExploreShowViewModel.this.new b(dVar);
            bVar.L$0 = th;
            return bVar.invokeSuspend(v.a);
        }

        @Override // f.z.j.a.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            f.E5(obj);
            Throwable th = (Throwable) this.L$0;
            th.printStackTrace();
            ExploreShowViewModel.this.errorLiveData.postValue(f.C2(th));
            return v.a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExploreShowViewModel(@NotNull Application application) {
        super(application);
        j.e(application, "application");
        this.booksData = new MutableLiveData<>();
        this.errorLiveData = new MutableLiveData<>();
        this.page = 1;
    }

    public final void e() {
        BookSource bookSource = this.bookSource;
        String str = this.exploreUrl;
        if (bookSource == null || str == null) {
            return;
        }
        e.a.a.d.u.b bVarExploreBook$default = WebBook.exploreBook$default(new WebBook(bookSource), this, str, Integer.valueOf(this.page), null, 8, null);
        bVarExploreBook$default.f(30000L);
        k0 k0Var = k0.f6264c;
        bVarExploreBook$default.d(k0.f6263b, new a(null));
        e.a.a.d.u.b.b(bVarExploreBook$default, null, new b(null), 1);
    }
}

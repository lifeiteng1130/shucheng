package io.legado.app.ui.book.search;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import androidx.appcompat.widget.SearchView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.view.LiveData;
import androidx.view.Observer;
import androidx.view.ViewModelLazy;
import androidx.view.ViewModelProvider;
import androidx.view.ViewModelStore;
import androidx.viewbinding.ViewBinding;
import c.b.a.m.f;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.gson.Gson;
import com.ifmvo.togetherad.core.helper.AdHelperInter;
import com.ifmvo.togetherad.core.listener.InterListener;
import com.qq.e.comm.constants.Constants;
import com.umeng.analytics.MobclickAgent;
import com.umeng.analytics.pro.ai;
import e.a.a.d.q;
import e.a.a.d.w.c;
import e.a.a.g.d.j.i;
import e.a.a.g.d.j.s;
import e.a.a.h.n;
import f.c0.b.l;
import f.c0.b.p;
import f.c0.c.j;
import f.c0.c.k;
import f.h;
import f.v;
import f.z.j.a.g;
import g.b.a0;
import g.b.k0;
import g.b.y;
import io.legado.app.base.BaseViewModel;
import io.legado.app.base.VMBaseActivity;
import io.legado.app.data.AppDatabaseKt;
import io.legado.app.data.entities.Book;
import io.legado.app.data.entities.SearchBook;
import io.legado.app.data.entities.SearchKeyword;
import io.legado.app.databinding.ActivityBookSearchBinding;
import io.legado.app.lib.theme.ATH;
import io.legado.app.model.AdsConfig;
import io.legado.app.ui.book.info.BookInfoActivity;
import io.legado.app.ui.book.search.BookAdapter;
import io.legado.app.ui.book.search.HistoryKeyAdapter;
import io.legado.app.ui.book.search.SearchActivity;
import io.legado.app.ui.book.search.SearchAdapter;
import io.legado.app.ui.book.search.SearchViewModel;
import io.legado.app.ui.book.source.manage.BookSourceActivity;
import io.legado.app.ui.widget.TitleBar;
import io.legado.app.ui.widget.anima.RefreshProgressBar;
import io.legado.app.ui.widget.dynamiclayout.DynamicFrameLayout;
import io.legado.app.ui.widget.recycler.LoadMoreView;
import io.legado.app.ui.widget.recycler.WrapContentLinearLayoutManager;
import io.wenyuange.app.release.R;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jsoup.nodes.Attributes;

/* JADX INFO: compiled from: SearchActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000ª\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u00042\u00020\u00052\u00020\u0006B\u0007¢\u0006\u0004\ba\u0010!J\u001b\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0011\u0010\u0010\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u001b\u0010\u0014\u001a\u00020\t2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0019\u0010\u0018\u001a\u00020\t2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0019\u0010\u001b\u001a\u00020\t2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0007H\u0014¢\u0006\u0004\b\u001b\u0010\u000bJ\u0017\u0010\u001e\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\tH\u0014¢\u0006\u0004\b \u0010!J\u0017\u0010$\u001a\u00020\f2\u0006\u0010#\u001a\u00020\"H\u0016¢\u0006\u0004\b$\u0010%J\u001f\u0010(\u001a\u00020\t2\u0006\u0010&\u001a\u00020\u00122\u0006\u0010'\u001a\u00020\u0012H\u0016¢\u0006\u0004\b(\u0010)J\u0017\u0010,\u001a\u00020\t2\u0006\u0010+\u001a\u00020*H\u0016¢\u0006\u0004\b,\u0010-J\u0017\u0010.\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b.\u0010\u0015J\r\u0010/\u001a\u00020\t¢\u0006\u0004\b/\u0010!R$\u00104\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020*01\u0018\u0001008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u00108\u001a\u0002058\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b6\u00107R\u0018\u0010;\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010>\u001a\u00020<8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b,\u0010=R\u0016\u0010B\u001a\u00020?8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b@\u0010AR$\u0010E\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020C01\u0018\u0001008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bD\u00103R\"\u0010M\u001a\u00020F8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\bG\u0010H\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bN\u0010OR\u001d\u0010T\u001a\u00020\u00038T@\u0014X\u0094\u0084\u0002¢\u0006\f\n\u0004\bP\u0010Q\u001a\u0004\bR\u0010SR&\u0010Y\u001a\u0012\u0012\u0004\u0012\u00020\u00120Uj\b\u0012\u0004\u0012\u00020\u0012`V8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bW\u0010XR\u0016\u0010\\\u001a\u00020Z8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b(\u0010[R\u0018\u0010`\u001a\u0004\u0018\u00010]8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b^\u0010_¨\u0006b"}, d2 = {"Lio/legado/app/ui/book/search/SearchActivity;", "Lio/legado/app/base/VMBaseActivity;", "Lio/legado/app/databinding/ActivityBookSearchBinding;", "Lio/legado/app/ui/book/search/SearchViewModel;", "Lio/legado/app/ui/book/search/BookAdapter$a;", "Lio/legado/app/ui/book/search/HistoryKeyAdapter$a;", "Lio/legado/app/ui/book/search/SearchAdapter$a;", "Landroid/content/Intent;", "intent", "Lf/v;", "W0", "(Landroid/content/Intent;)V", "", "open", "V0", "(Z)V", "Y0", "()Lf/v;", "", "key", "Z0", "(Ljava/lang/String;)V", "Landroid/os/Bundle;", "savedInstanceState", "O0", "(Landroid/os/Bundle;)V", "data", "onNewIntent", "Landroid/view/Menu;", "menu", "P0", "(Landroid/view/Menu;)Z", "onDestroy", "()V", "Landroid/view/MenuItem;", "item", "Q0", "(Landroid/view/MenuItem;)Z", "name", "author", Constants.LANDSCAPE, "(Ljava/lang/String;Ljava/lang/String;)V", "Lio/legado/app/data/entities/Book;", "book", "k", "(Lio/legado/app/data/entities/Book;)V", "P", "X0", "Landroidx/lifecycle/LiveData;", "", "o", "Landroidx/lifecycle/LiveData;", "bookData", "Landroidx/appcompat/widget/SearchView;", "m", "Landroidx/appcompat/widget/SearchView;", "searchView", "q", "Landroid/view/MenuItem;", "precisionSearchMenuItem", "Lio/legado/app/ui/book/search/HistoryKeyAdapter;", "Lio/legado/app/ui/book/search/HistoryKeyAdapter;", "historyKeyAdapter", "Lio/legado/app/ui/book/search/BookAdapter;", "j", "Lio/legado/app/ui/book/search/BookAdapter;", "bookAdapter", "Lio/legado/app/data/entities/SearchKeyword;", "n", "historyData", "Lio/legado/app/ui/book/search/SearchAdapter;", ai.aA, "Lio/legado/app/ui/book/search/SearchAdapter;", "T0", "()Lio/legado/app/ui/book/search/SearchAdapter;", "setAdapter", "(Lio/legado/app/ui/book/search/SearchAdapter;)V", "adapter", "p", "Landroid/view/Menu;", "h", "Lf/e;", "U0", "()Lio/legado/app/ui/book/search/SearchViewModel;", "viewModel", "Ljava/util/LinkedHashSet;", "Lkotlin/collections/LinkedHashSet;", "r", "Ljava/util/LinkedHashSet;", "groups", "Lio/legado/app/ui/widget/recycler/LoadMoreView;", "Lio/legado/app/ui/widget/recycler/LoadMoreView;", "loadMoreView", "Lcom/ifmvo/togetherad/core/helper/AdHelperInter;", ai.az, "Lcom/ifmvo/togetherad/core/helper/AdHelperInter;", "adHelperInter", "<init>", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class SearchActivity extends VMBaseActivity<ActivityBookSearchBinding, SearchViewModel> implements BookAdapter.a, HistoryKeyAdapter.a, SearchAdapter.a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f7256g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final f.e viewModel;

    /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
    public SearchAdapter adapter;

    /* JADX INFO: renamed from: j, reason: collision with root package name and from kotlin metadata */
    public BookAdapter bookAdapter;

    /* JADX INFO: renamed from: k, reason: collision with root package name and from kotlin metadata */
    public HistoryKeyAdapter historyKeyAdapter;

    /* JADX INFO: renamed from: l, reason: collision with root package name and from kotlin metadata */
    public LoadMoreView loadMoreView;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    public SearchView searchView;

    /* JADX INFO: renamed from: n, reason: from kotlin metadata */
    @Nullable
    public LiveData<List<SearchKeyword>> historyData;

    /* JADX INFO: renamed from: o, reason: from kotlin metadata */
    @Nullable
    public LiveData<List<Book>> bookData;

    /* JADX INFO: renamed from: p, reason: from kotlin metadata */
    @Nullable
    public Menu menu;

    /* JADX INFO: renamed from: q, reason: from kotlin metadata */
    @Nullable
    public MenuItem precisionSearchMenuItem;

    /* JADX INFO: renamed from: r, reason: from kotlin metadata */
    @NotNull
    public LinkedHashSet<String> groups;

    /* JADX INFO: renamed from: s, reason: from kotlin metadata */
    @Nullable
    public AdHelperInter adHelperInter;

    /* JADX INFO: compiled from: SearchActivity.kt */
    @DebugMetadata(c = "io.legado.app.ui.book.search.SearchActivity$searchHistory$1", f = "SearchActivity.kt", i = {}, l = {389}, m = "invokeSuspend", n = {}, s = {})
    public static final class a extends g implements p<a0, f.z.d<? super v>, Object> {
        public final /* synthetic */ String $key;
        public int label;

        /* JADX INFO: renamed from: io.legado.app.ui.book.search.SearchActivity$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchActivity.kt */
        @DebugMetadata(c = "io.legado.app.ui.book.search.SearchActivity$searchHistory$1$1", f = "SearchActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class C0204a extends g implements p<a0, f.z.d<? super Boolean>, Object> {
            public final /* synthetic */ String $key;
            public int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0204a(String str, f.z.d<? super C0204a> dVar) {
                super(2, dVar);
                this.$key = str;
            }

            @Override // f.z.j.a.a
            @NotNull
            public final f.z.d<v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
                return new C0204a(this.$key, dVar);
            }

            @Override // f.c0.b.p
            @Nullable
            public final Object invoke(@NotNull a0 a0Var, @Nullable f.z.d<? super Boolean> dVar) {
                return ((C0204a) create(a0Var, dVar)).invokeSuspend(v.a);
            }

            @Override // f.z.j.a.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                f.E5(obj);
                return Boolean.valueOf(AppDatabaseKt.getAppDb().getBookDao().findByName(this.$key).isEmpty());
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, f.z.d<? super a> dVar) {
            super(2, dVar);
            this.$key = str;
        }

        @Override // f.z.j.a.a
        @NotNull
        public final f.z.d<v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
            return SearchActivity.this.new a(this.$key, dVar);
        }

        @Override // f.c0.b.p
        @Nullable
        public final Object invoke(@NotNull a0 a0Var, @Nullable f.z.d<? super v> dVar) {
            return ((a) create(a0Var, dVar)).invokeSuspend(v.a);
        }

        @Override // f.z.j.a.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
            f.z.i.a aVar = f.z.i.a.COROUTINE_SUSPENDED;
            int i2 = this.label;
            if (i2 == 0) {
                f.E5(obj);
                SearchView searchView = SearchActivity.this.searchView;
                if (searchView == null) {
                    j.m("searchView");
                    throw null;
                }
                if (j.a(searchView.getQuery().toString(), this.$key)) {
                    SearchView searchView2 = SearchActivity.this.searchView;
                    if (searchView2 != null) {
                        searchView2.setQuery(this.$key, true);
                        return v.a;
                    }
                    j.m("searchView");
                    throw null;
                }
                k0 k0Var = k0.f6264c;
                y yVar = k0.f6263b;
                C0204a c0204a = new C0204a(this.$key, null);
                this.label = 1;
                obj = f.f6(yVar, c0204a, this);
                if (obj == aVar) {
                    return aVar;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                f.E5(obj);
            }
            if (((Boolean) obj).booleanValue()) {
                SearchView searchView3 = SearchActivity.this.searchView;
                if (searchView3 == null) {
                    j.m("searchView");
                    throw null;
                }
                searchView3.setQuery(this.$key, true);
            } else {
                SearchView searchView4 = SearchActivity.this.searchView;
                if (searchView4 == null) {
                    j.m("searchView");
                    throw null;
                }
                searchView4.setQuery(this.$key, false);
            }
            return v.a;
        }
    }

    /* JADX INFO: compiled from: SearchActivity.kt */
    public static final class b implements InterListener {
        public b() {
        }

        @Override // com.ifmvo.togetherad.core.listener.InterListener
        public void onAdClicked(@NotNull String str) {
            j.e(str, "providerType");
            // AD REMOVED: MobclickAgent.onEvent(SearchActivity.this, "searchAdsClick");
        }

        @Override // com.ifmvo.togetherad.core.listener.InterListener
        public void onAdClose(@NotNull String str) {
            j.e(str, "providerType");
        }

        @Override // com.ifmvo.togetherad.core.listener.InterListener
        public void onAdExpose(@NotNull String str) {
            j.e(str, "providerType");
            // AD REMOVED: MobclickAgent.onEvent(SearchActivity.this, "searchAdsExpose", str);
        }

        @Override // com.ifmvo.togetherad.core.listener.BaseListener
        public void onAdFailed(@NotNull String str, @Nullable String str2) {
            j.e(str, "providerType");
            // AD REMOVED: MobclickAgent.onEvent(SearchActivity.this, "searchAdsFaild");
            // AD REMOVED: MobclickAgent.onEvent(SearchActivity.this, "searchAdsFaildMsg", str + Attributes.InternalPrefix + ((Object) str2));
        }

        @Override // com.ifmvo.togetherad.core.listener.BaseListener
        public void onAdFailedAll(@Nullable String str) {
            // AD REMOVED: MobclickAgent.onEvent(SearchActivity.this, "searchAdsFaild");
            // AD REMOVED: MobclickAgent.onEvent(SearchActivity.this, "searchAdsFaild", String.valueOf(str));
        }

        @Override // com.ifmvo.togetherad.core.listener.InterListener
        public void onAdLoaded(@NotNull String str) {
            j.e(str, "providerType");
            AdHelperInter adHelperInter = SearchActivity.this.adHelperInter;
            if (adHelperInter == null) {
                return;
            }
            adHelperInter.show();
        }

        @Override // com.ifmvo.togetherad.core.listener.BaseListener
        public void onAdStartRequest(@NotNull String str) {
            j.e(str, "providerType");
        }
    }

    /* JADX INFO: compiled from: SearchActivity.kt */
    public static final class c extends k implements l<SearchBook, v> {
        public c() {
            super(1);
        }

        @Override // f.c0.b.l
        public /* bridge */ /* synthetic */ v invoke(SearchBook searchBook) {
            invoke2(searchBook);
            return v.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@Nullable SearchBook searchBook) {
            if (searchBook == null) {
                return;
            }
            SearchActivity searchActivity = SearchActivity.this;
            Intent intent = new Intent(searchActivity, (Class<?>) BookInfoActivity.class);
            intent.addFlags(268435456);
            intent.putExtra("name", searchBook.getName());
            intent.putExtra("author", searchBook.getAuthor());
            searchActivity.startActivity(intent);
        }
    }

    /* JADX INFO: compiled from: ActivityViewModelLazy.kt */
    public static final class d extends k implements f.c0.b.a<ViewModelProvider.Factory> {
        public final /* synthetic */ ComponentActivity $this_viewModels;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(ComponentActivity componentActivity) {
            super(0);
            this.$this_viewModels = componentActivity;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // f.c0.b.a
        @NotNull
        public final ViewModelProvider.Factory invoke() {
            return this.$this_viewModels.getDefaultViewModelProviderFactory();
        }
    }

    /* JADX INFO: compiled from: ActivityViewModelLazy.kt */
    public static final class e extends k implements f.c0.b.a<ViewModelStore> {
        public final /* synthetic */ ComponentActivity $this_viewModels;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(ComponentActivity componentActivity) {
            super(0);
            this.$this_viewModels = componentActivity;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // f.c0.b.a
        @NotNull
        public final ViewModelStore invoke() {
            ViewModelStore viewModelStore = this.$this_viewModels.getViewModelStore();
            j.d(viewModelStore, "viewModelStore");
            return viewModelStore;
        }
    }

    public SearchActivity() {
        super(false, null, null, false, false, 31);
        this.viewModel = new ViewModelLazy(f.c0.c.v.a(SearchViewModel.class), new e(this), new d(this));
        this.groups = new LinkedHashSet<>();
    }

    @Override // io.legado.app.base.BaseActivity
    public ViewBinding L0() {
        View viewInflate = getLayoutInflater().inflate(R.layout.activity_book_search, (ViewGroup) null, false);
        int i2 = R.id.content_view;
        DynamicFrameLayout dynamicFrameLayout = (DynamicFrameLayout) viewInflate.findViewById(R.id.content_view);
        if (dynamicFrameLayout != null) {
            i2 = R.id.fb_stop;
            FloatingActionButton floatingActionButton = (FloatingActionButton) viewInflate.findViewById(R.id.fb_stop);
            if (floatingActionButton != null) {
                i2 = R.id.ll_history;
                LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(R.id.ll_history);
                if (linearLayout != null) {
                    i2 = R.id.recycler_view;
                    RecyclerView recyclerView = (RecyclerView) viewInflate.findViewById(R.id.recycler_view);
                    if (recyclerView != null) {
                        i2 = R.id.refresh_progress_bar;
                        RefreshProgressBar refreshProgressBar = (RefreshProgressBar) viewInflate.findViewById(R.id.refresh_progress_bar);
                        if (refreshProgressBar != null) {
                            i2 = R.id.rv_bookshelf_search;
                            RecyclerView recyclerView2 = (RecyclerView) viewInflate.findViewById(R.id.rv_bookshelf_search);
                            if (recyclerView2 != null) {
                                i2 = R.id.rv_history_key;
                                RecyclerView recyclerView3 = (RecyclerView) viewInflate.findViewById(R.id.rv_history_key);
                                if (recyclerView3 != null) {
                                    i2 = R.id.title_bar;
                                    TitleBar titleBar = (TitleBar) viewInflate.findViewById(R.id.title_bar);
                                    if (titleBar != null) {
                                        i2 = R.id.tv_book_show;
                                        TextView textView = (TextView) viewInflate.findViewById(R.id.tv_book_show);
                                        if (textView != null) {
                                            i2 = R.id.tv_clear_history;
                                            TextView textView2 = (TextView) viewInflate.findViewById(R.id.tv_clear_history);
                                            if (textView2 != null) {
                                                i2 = R.id.tv_history;
                                                TextView textView3 = (TextView) viewInflate.findViewById(R.id.tv_history);
                                                if (textView3 != null) {
                                                    ActivityBookSearchBinding activityBookSearchBinding = new ActivityBookSearchBinding((ConstraintLayout) viewInflate, dynamicFrameLayout, floatingActionButton, linearLayout, recyclerView, refreshProgressBar, recyclerView2, recyclerView3, titleBar, textView, textView2, textView3);
                                                    j.d(activityBookSearchBinding, "inflate(layoutInflater)");
                                                    return activityBookSearchBinding;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i2)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.legado.app.base.BaseActivity
    public void O0(@Nullable Bundle savedInstanceState) {
        ((ActivityBookSearchBinding) K0()).f6489c.setBackgroundColor(f.R1(this));
        View viewFindViewById = ((ActivityBookSearchBinding) K0()).f6494h.findViewById(R.id.search_view);
        j.d(viewFindViewById, "binding.titleBar.findViewById(R.id.search_view)");
        this.searchView = (SearchView) viewFindViewById;
        ATH ath = ATH.a;
        ath.b(((ActivityBookSearchBinding) K0()).f6490d);
        ath.b(((ActivityBookSearchBinding) K0()).f6492f);
        ath.b(((ActivityBookSearchBinding) K0()).f6493g);
        this.bookAdapter = new BookAdapter(this, this);
        ((ActivityBookSearchBinding) K0()).f6492f.setLayoutManager(new FlexboxLayoutManager(this));
        RecyclerView recyclerView = ((ActivityBookSearchBinding) K0()).f6492f;
        BookAdapter bookAdapter = this.bookAdapter;
        if (bookAdapter == null) {
            j.m("bookAdapter");
            throw null;
        }
        recyclerView.setAdapter(bookAdapter);
        this.historyKeyAdapter = new HistoryKeyAdapter(this, this);
        ((ActivityBookSearchBinding) K0()).f6493g.setLayoutManager(new FlexboxLayoutManager(this));
        RecyclerView recyclerView2 = ((ActivityBookSearchBinding) K0()).f6493g;
        HistoryKeyAdapter historyKeyAdapter = this.historyKeyAdapter;
        if (historyKeyAdapter == null) {
            j.m("historyKeyAdapter");
            throw null;
        }
        recyclerView2.setAdapter(historyKeyAdapter);
        SearchAdapter searchAdapter = new SearchAdapter(this, this);
        j.e(searchAdapter, "<set-?>");
        this.adapter = searchAdapter;
        ((ActivityBookSearchBinding) K0()).f6490d.setLayoutManager(new WrapContentLinearLayoutManager(this));
        ((ActivityBookSearchBinding) K0()).f6490d.setAdapter(T0());
        T0().registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() { // from class: io.legado.app.ui.book.search.SearchActivity$initRecyclerView$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeInserted(int positionStart, int itemCount) {
                super.onItemRangeInserted(positionStart, itemCount);
                if (positionStart == 0) {
                    SearchActivity searchActivity = this.a;
                    int i2 = SearchActivity.f7256g;
                    ((ActivityBookSearchBinding) searchActivity.K0()).f6490d.scrollToPosition(0);
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeMoved(int fromPosition, int toPosition, int itemCount) {
                super.onItemRangeMoved(fromPosition, toPosition, itemCount);
                if (toPosition == 0) {
                    SearchActivity searchActivity = this.a;
                    int i2 = SearchActivity.f7256g;
                    ((ActivityBookSearchBinding) searchActivity.K0()).f6490d.scrollToPosition(0);
                }
            }
        });
        this.loadMoreView = new LoadMoreView(this, null);
        ((ActivityBookSearchBinding) K0()).f6490d.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: io.legado.app.ui.book.search.SearchActivity$initRecyclerView$2
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(@NotNull RecyclerView recyclerView3, int dx, int dy) {
                j.e(recyclerView3, "recyclerView");
                super.onScrolled(recyclerView3, dx, dy);
                if (recyclerView3.canScrollVertically(1)) {
                    return;
                }
                SearchActivity searchActivity = this.a;
                int i2 = SearchActivity.f7256g;
                if (searchActivity.U0().isLoading) {
                    return;
                }
                if (searchActivity.U0().searchKey.length() > 0) {
                    LoadMoreView loadMoreView = searchActivity.loadMoreView;
                    if (loadMoreView == null) {
                        j.m("loadMoreView");
                        throw null;
                    }
                    if (loadMoreView.getHasMore()) {
                        searchActivity.U0().f("");
                    }
                }
            }
        });
        SearchView searchView = this.searchView;
        if (searchView == null) {
            j.m("searchView");
            throw null;
        }
        ATH.h(ath, searchView, f.R2(this), false, 4);
        AdsConfig adsConfigC = e.a.a.d.w.c.c(this);
        if (adsConfigC.getEnableSearch() && e.a.a.d.w.c.d(adsConfigC.getSearcherRange())) {
            X0();
        }
        SearchView searchView2 = this.searchView;
        if (searchView2 == null) {
            j.m("searchView");
            throw null;
        }
        searchView2.onActionViewExpanded();
        SearchView searchView3 = this.searchView;
        if (searchView3 == null) {
            j.m("searchView");
            throw null;
        }
        searchView3.setSubmitButtonEnabled(true);
        SearchView searchView4 = this.searchView;
        if (searchView4 == null) {
            j.m("searchView");
            throw null;
        }
        searchView4.setQueryHint(getString(R.string.search_book_key));
        SearchView searchView5 = this.searchView;
        if (searchView5 == null) {
            j.m("searchView");
            throw null;
        }
        searchView5.clearFocus();
        SearchView searchView6 = this.searchView;
        if (searchView6 == null) {
            j.m("searchView");
            throw null;
        }
        searchView6.setOnQueryTextListener(new SearchView.OnQueryTextListener() { // from class: io.legado.app.ui.book.search.SearchActivity$initSearchView$1
            @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
            public boolean onQueryTextChange(@Nullable String newText) {
                if (newText == null || f.h0.k.s(newText)) {
                    this.a.U0().searchBookModel.cancelSearch();
                }
                SearchActivity searchActivity = this.a;
                int i2 = SearchActivity.f7256g;
                searchActivity.Z0(newText);
                return false;
            }

            @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
            public boolean onQueryTextSubmit(@Nullable String query) {
                SearchActivity searchActivity = this.a;
                Objects.requireNonNull(searchActivity);
                AdsConfig adsConfigC2 = c.c(searchActivity);
                if (adsConfigC2.getEnableContentSearch() && c.d(adsConfigC2.getContentSearcherRange())) {
                    searchActivity.X0();
                }
                SearchView searchView7 = this.a.searchView;
                if (searchView7 == null) {
                    j.m("searchView");
                    throw null;
                }
                searchView7.clearFocus();
                if (query != null) {
                    SearchActivity searchActivity2 = this.a;
                    SearchViewModel searchViewModelU0 = searchActivity2.U0();
                    Objects.requireNonNull(searchViewModelU0);
                    j.e(query, "key");
                    BaseViewModel.a(searchViewModelU0, null, null, new s(query, null), 3, null);
                    searchActivity2.U0().f(query);
                    // AD REMOVED: MobclickAgent.onEvent(searchActivity2, "searcheMsg", query);
                }
                this.a.V0(false);
                return true;
            }
        });
        SearchView searchView7 = this.searchView;
        if (searchView7 == null) {
            j.m("searchView");
            throw null;
        }
        searchView7.setOnQueryTextFocusChangeListener(new View.OnFocusChangeListener() { // from class: e.a.a.g.d.j.e
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                SearchActivity searchActivity = this.a;
                int i2 = SearchActivity.f7256g;
                f.c0.c.j.e(searchActivity, "this$0");
                if (!z) {
                    SearchView searchView8 = searchActivity.searchView;
                    if (searchView8 == null) {
                        f.c0.c.j.m("searchView");
                        throw null;
                    }
                    String string = searchView8.getQuery().toString();
                    Objects.requireNonNull(string, "null cannot be cast to non-null type kotlin.CharSequence");
                    if (f.h0.k.R(string).toString().length() == 0) {
                        searchActivity.finish();
                        return;
                    }
                }
                searchActivity.V0(z);
            }
        });
        V0(true);
        FloatingActionButton floatingActionButton = ((ActivityBookSearchBinding) K0()).f6488b;
        e.a.a.e.d.a aVar = new e.a.a.e.d.a();
        aVar.b(f.M1(this));
        int iM1 = f.M1(this);
        int iAlpha = Color.alpha(iM1);
        float[] fArr = new float[3];
        Color.colorToHSV(iM1, fArr);
        fArr[2] = fArr[2] * 0.9f;
        aVar.d((iAlpha << 24) + (16777215 & Color.HSVToColor(fArr)));
        floatingActionButton.setBackgroundTintList(aVar.a());
        ((ActivityBookSearchBinding) K0()).f6488b.setOnClickListener(new View.OnClickListener() { // from class: e.a.a.g.d.j.k
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SearchActivity searchActivity = this.a;
                int i2 = SearchActivity.f7256g;
                f.c0.c.j.e(searchActivity, "this$0");
                searchActivity.U0().searchBookModel.cancelSearch();
                ((ActivityBookSearchBinding) searchActivity.K0()).f6491e.setAutoLoading(false);
            }
        });
        ((ActivityBookSearchBinding) K0()).f6496j.setOnClickListener(new View.OnClickListener() { // from class: e.a.a.g.d.j.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SearchActivity searchActivity = this.a;
                int i2 = SearchActivity.f7256g;
                f.c0.c.j.e(searchActivity, "this$0");
                SearchViewModel searchViewModelU0 = searchActivity.U0();
                Objects.requireNonNull(searchViewModelU0);
                BaseViewModel.a(searchViewModelU0, null, null, new p(null), 3, null);
            }
        });
        AppDatabaseKt.getAppDb().getBookSourceDao().liveGroupEnabled().observe(this, new Observer() { // from class: e.a.a.g.d.j.d
            @Override // androidx.view.Observer
            public final void onChanged(Object obj) {
                SearchActivity searchActivity = this.a;
                List<String> list = (List) obj;
                int i2 = SearchActivity.f7256g;
                f.c0.c.j.e(searchActivity, "this$0");
                searchActivity.groups.clear();
                f.c0.c.j.d(list, "it");
                ArrayList arrayList = new ArrayList(c.b.a.m.f.S0(list, 10));
                for (String str : list) {
                    LinkedHashSet<String> linkedHashSet = searchActivity.groups;
                    e.a.a.c.d dVar = e.a.a.c.d.a;
                    arrayList.add(Boolean.valueOf(c.b.a.m.f.T(linkedHashSet, c.b.a.m.f.o5(str, e.a.a.c.d.f5514h, 0, 2))));
                }
                searchActivity.Y0();
            }
        });
        U0().searchBookLiveData.observe(this, new Observer() { // from class: e.a.a.g.d.j.f
            @Override // androidx.view.Observer
            public final void onChanged(Object obj) {
                SearchActivity searchActivity = this.a;
                List list = (List) obj;
                int i2 = SearchActivity.f7256g;
                f.c0.c.j.e(searchActivity, "this$0");
                if (list != null) {
                    searchActivity.T0().n(list);
                }
            }
        });
        U0().isSearchLiveData.observe(this, new Observer() { // from class: e.a.a.g.d.j.g
            /* JADX WARN: Multi-variable type inference failed */
            @Override // androidx.view.Observer
            public final void onChanged(Object obj) {
                SearchActivity searchActivity = this.a;
                Boolean bool = (Boolean) obj;
                int i2 = SearchActivity.f7256g;
                f.c0.c.j.e(searchActivity, "this$0");
                f.c0.c.j.d(bool, "it");
                if (bool.booleanValue()) {
                    ((ActivityBookSearchBinding) searchActivity.K0()).f6491e.setAutoLoading(true);
                    FloatingActionButton floatingActionButton2 = ((ActivityBookSearchBinding) searchActivity.K0()).f6488b;
                    f.c0.c.j.d(floatingActionButton2, "binding.fbStop");
                    c.b.a.m.f.c6(floatingActionButton2);
                    return;
                }
                ((ActivityBookSearchBinding) searchActivity.K0()).f6491e.setAutoLoading(false);
                LoadMoreView loadMoreView = searchActivity.loadMoreView;
                if (loadMoreView == null) {
                    f.c0.c.j.m("loadMoreView");
                    throw null;
                }
                loadMoreView.d();
                FloatingActionButton floatingActionButton3 = ((ActivityBookSearchBinding) searchActivity.K0()).f6488b;
                f.c0.c.j.d(floatingActionButton3, "binding.fbStop");
                c.b.a.m.f.l3(floatingActionButton3);
            }
        });
        W0(getIntent());
    }

    @Override // io.legado.app.ui.book.search.HistoryKeyAdapter.a
    public void P(@NotNull String key) {
        j.e(key, "key");
        f.L3(this, null, null, new a(key, null), 3, null);
    }

    @Override // io.legado.app.base.BaseActivity
    public boolean P0(@NotNull Menu menu) {
        j.e(menu, "menu");
        getMenuInflater().inflate(R.menu.book_search, menu);
        MenuItem menuItemFindItem = menu.findItem(R.id.menu_precision_search);
        this.precisionSearchMenuItem = menuItemFindItem;
        if (menuItemFindItem != null) {
            menuItemFindItem.setChecked(f.K2(this, "precisionSearch", false, 2));
        }
        this.menu = menu;
        Y0();
        return super.P0(menu);
    }

    @Override // io.legado.app.base.BaseActivity
    public boolean Q0(@NotNull MenuItem item) {
        String string;
        String string2;
        j.e(item, "item");
        int itemId = item.getItemId();
        if (itemId == R.id.menu_precision_search) {
            f.o4(this, "precisionSearch", !f.K2(this, "precisionSearch", false, 2));
            MenuItem menuItem = this.precisionSearchMenuItem;
            if (menuItem != null) {
                menuItem.setChecked(f.K2(this, "precisionSearch", false, 2));
            }
            SearchView searchView = this.searchView;
            if (searchView == null) {
                j.m("searchView");
                throw null;
            }
            CharSequence query = searchView.getQuery();
            String string3 = query == null ? null : query.toString();
            if (string3 != null && (string = f.h0.k.R(string3).toString()) != null) {
                SearchView searchView2 = this.searchView;
                if (searchView2 == null) {
                    j.m("searchView");
                    throw null;
                }
                searchView2.setQuery(string, true);
            }
        } else if (itemId == R.id.menu_source_manage) {
            Intent intent = new Intent(this, (Class<?>) BookSourceActivity.class);
            intent.addFlags(268435456);
            startActivity(intent);
        } else if (item.getGroupId() == R.id.source_group) {
            item.setChecked(true);
            if (j.a(item.getTitle().toString(), getString(R.string.all_source))) {
                f.r4(this, "searchGroup", "");
            } else {
                f.r4(this, "searchGroup", item.getTitle().toString());
            }
            SearchView searchView3 = this.searchView;
            if (searchView3 == null) {
                j.m("searchView");
                throw null;
            }
            CharSequence query2 = searchView3.getQuery();
            String string4 = query2 == null ? null : query2.toString();
            if (string4 != null && (string2 = f.h0.k.R(string4).toString()) != null) {
                SearchView searchView4 = this.searchView;
                if (searchView4 == null) {
                    j.m("searchView");
                    throw null;
                }
                searchView4.setQuery(string2, true);
            }
        }
        return super.Q0(item);
    }

    @NotNull
    public final SearchAdapter T0() {
        SearchAdapter searchAdapter = this.adapter;
        if (searchAdapter != null) {
            return searchAdapter;
        }
        j.m("adapter");
        throw null;
    }

    @NotNull
    public SearchViewModel U0() {
        return (SearchViewModel) this.viewModel.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void V0(boolean open) {
        if (!open) {
            ((ActivityBookSearchBinding) K0()).f6489c.setVisibility(8);
            return;
        }
        SearchView searchView = this.searchView;
        if (searchView == null) {
            j.m("searchView");
            throw null;
        }
        Z0(searchView.getQuery().toString());
        ((ActivityBookSearchBinding) K0()).f6489c.setVisibility(0);
    }

    public final void W0(Intent intent) {
        String stringExtra;
        v vVar;
        if (intent == null || (stringExtra = intent.getStringExtra("key")) == null) {
            vVar = null;
        } else {
            SearchView searchView = this.searchView;
            if (searchView == null) {
                j.m("searchView");
                throw null;
            }
            searchView.setQuery(stringExtra, true);
            vVar = v.a;
        }
        if (vVar == null) {
            SearchView searchView2 = this.searchView;
            if (searchView2 != null) {
                ((TextView) searchView2.findViewById(R.id.search_src_text)).requestFocus();
            } else {
                j.m("searchView");
                throw null;
            }
        }
    }

    public final void X0() {
        Object objM11constructorimpl;
        AdsConfig adsConfig;
        j.e(this, com.umeng.analytics.pro.c.R);
        String strO2 = f.O2(this, "adsConfig", null, 2);
        if (strO2 == null) {
            adsConfig = new AdsConfig();
        } else {
            Gson gsonA = n.a();
            try {
                Type type = new c.a().getType();
                j.d(type, "object : TypeToken<T>() {}.type");
                Object objFromJson = gsonA.fromJson(strO2, type);
                if (!(objFromJson instanceof AdsConfig)) {
                    objFromJson = null;
                }
                objM11constructorimpl = h.m11constructorimpl((AdsConfig) objFromJson);
            } catch (Throwable th) {
                objM11constructorimpl = h.m11constructorimpl(f.m1(th));
            }
            adsConfig = (AdsConfig) (h.m16isFailureimpl(objM11constructorimpl) ? null : objM11constructorimpl);
            if (adsConfig == null) {
                adsConfig = new AdsConfig();
            } else {
                adsConfig.getEnableAds();
            }
        }
        if (adsConfig.getEnableAds()) {
            j.e(adsConfig, "adsConfig");
            if (System.currentTimeMillis() - q.a.a() > adsConfig.getInstallSearchTime() * ((long) 1000)) {
                if (this.adHelperInter == null) {
                    this.adHelperInter = new AdHelperInter(this, "ad_inter", adsConfig.getCacheWeight(), new b());
                }
                AdHelperInter adHelperInter = this.adHelperInter;
                if (adHelperInter == null) {
                    return;
                }
                adHelperInter.load();
            }
        }
    }

    public final v Y0() {
        Menu menu = this.menu;
        if (menu == null) {
            return null;
        }
        String strO2 = f.O2(this, "searchGroup", null, 2);
        menu.removeGroup(R.id.source_group);
        MenuItem menuItemAdd = menu.add(R.id.source_group, 0, 0, R.string.all_source);
        boolean z = false;
        for (String str : f.x.e.B(this.groups, i.a)) {
            MenuItem menuItemAdd2 = menu.add(R.id.source_group, 0, 0, str);
            if (menuItemAdd2 != null && j.a(str, strO2)) {
                menuItemAdd2.setChecked(true);
                z = true;
            }
        }
        menu.setGroupCheckable(R.id.source_group, true, true);
        if (!z) {
            menuItemAdd.setChecked(true);
        }
        return v.a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void Z0(String key) {
        LiveData<List<Book>> liveData = this.bookData;
        if (liveData != null) {
            liveData.removeObservers(this);
        }
        if (key == null || f.h0.k.s(key)) {
            TextView textView = ((ActivityBookSearchBinding) K0()).f6495i;
            j.d(textView, "binding.tvBookShow");
            f.e3(textView);
            RecyclerView recyclerView = ((ActivityBookSearchBinding) K0()).f6492f;
            j.d(recyclerView, "binding.rvBookshelfSearch");
            f.e3(recyclerView);
        } else {
            LiveData<List<Book>> liveDataLiveDataSearch = AppDatabaseKt.getAppDb().getBookDao().liveDataSearch(key);
            this.bookData = liveDataLiveDataSearch;
            if (liveDataLiveDataSearch != null) {
                liveDataLiveDataSearch.observe(this, new Observer() { // from class: e.a.a.g.d.j.c
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // androidx.view.Observer
                    public final void onChanged(Object obj) {
                        SearchActivity searchActivity = this.a;
                        List list = (List) obj;
                        int i2 = SearchActivity.f7256g;
                        f.c0.c.j.e(searchActivity, "this$0");
                        if (list.isEmpty()) {
                            TextView textView2 = ((ActivityBookSearchBinding) searchActivity.K0()).f6495i;
                            f.c0.c.j.d(textView2, "binding.tvBookShow");
                            c.b.a.m.f.e3(textView2);
                            RecyclerView recyclerView2 = ((ActivityBookSearchBinding) searchActivity.K0()).f6492f;
                            f.c0.c.j.d(recyclerView2, "binding.rvBookshelfSearch");
                            c.b.a.m.f.e3(recyclerView2);
                        } else {
                            TextView textView3 = ((ActivityBookSearchBinding) searchActivity.K0()).f6495i;
                            f.c0.c.j.d(textView3, "binding.tvBookShow");
                            c.b.a.m.f.c6(textView3);
                            RecyclerView recyclerView3 = ((ActivityBookSearchBinding) searchActivity.K0()).f6492f;
                            f.c0.c.j.d(recyclerView3, "binding.rvBookshelfSearch");
                            c.b.a.m.f.c6(recyclerView3);
                        }
                        BookAdapter bookAdapter = searchActivity.bookAdapter;
                        if (bookAdapter == null) {
                            f.c0.c.j.m("bookAdapter");
                            throw null;
                        }
                        bookAdapter.x(list);
                        BookAdapter bookAdapter2 = searchActivity.bookAdapter;
                        if (bookAdapter2 != null) {
                            bookAdapter2.notifyDataSetChanged();
                        } else {
                            f.c0.c.j.m("bookAdapter");
                            throw null;
                        }
                    }
                });
            }
        }
        LiveData<List<SearchKeyword>> liveData2 = this.historyData;
        if (liveData2 != null) {
            liveData2.removeObservers(this);
        }
        LiveData<List<SearchKeyword>> liveDataLiveDataByUsage = key == null || f.h0.k.s(key) ? AppDatabaseKt.getAppDb().getSearchKeywordDao().liveDataByUsage() : AppDatabaseKt.getAppDb().getSearchKeywordDao().liveDataSearch(key);
        this.historyData = liveDataLiveDataByUsage;
        if (liveDataLiveDataByUsage == null) {
            return;
        }
        liveDataLiveDataByUsage.observe(this, new Observer() { // from class: e.a.a.g.d.j.h
            /* JADX WARN: Multi-variable type inference failed */
            @Override // androidx.view.Observer
            public final void onChanged(Object obj) {
                SearchActivity searchActivity = this.a;
                List list = (List) obj;
                int i2 = SearchActivity.f7256g;
                f.c0.c.j.e(searchActivity, "this$0");
                HistoryKeyAdapter historyKeyAdapter = searchActivity.historyKeyAdapter;
                if (historyKeyAdapter == null) {
                    f.c0.c.j.m("historyKeyAdapter");
                    throw null;
                }
                historyKeyAdapter.x(list);
                HistoryKeyAdapter historyKeyAdapter2 = searchActivity.historyKeyAdapter;
                if (historyKeyAdapter2 == null) {
                    f.c0.c.j.m("historyKeyAdapter");
                    throw null;
                }
                historyKeyAdapter2.notifyDataSetChanged();
                if (list.isEmpty()) {
                    TextView textView2 = ((ActivityBookSearchBinding) searchActivity.K0()).f6496j;
                    f.c0.c.j.d(textView2, "binding.tvClearHistory");
                    c.b.a.m.f.l3(textView2);
                } else {
                    TextView textView3 = ((ActivityBookSearchBinding) searchActivity.K0()).f6496j;
                    f.c0.c.j.d(textView3, "binding.tvClearHistory");
                    c.b.a.m.f.c6(textView3);
                }
            }
        });
    }

    @Override // io.legado.app.ui.book.search.BookAdapter.a
    public void k(@NotNull Book book) {
        j.e(book, "book");
        Intent intent = new Intent(this, (Class<?>) BookInfoActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("name", book.getName());
        intent.putExtra("author", book.getAuthor());
        startActivity(intent);
    }

    @Override // io.legado.app.ui.book.search.SearchAdapter.a
    public void l(@NotNull String name, @NotNull String author) {
        j.e(name, "name");
        j.e(author, "author");
        U0().e(name, author, new c());
    }

    @Override // io.legado.app.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        AdHelperInter adHelperInter = this.adHelperInter;
        if (adHelperInter != null) {
            adHelperInter.destroy();
        }
        this.adHelperInter = null;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(@Nullable Intent data) {
        super.onNewIntent(data);
        W0(data);
    }
}

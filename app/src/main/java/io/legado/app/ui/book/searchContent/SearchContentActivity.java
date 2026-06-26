package io.legado.app.ui.book.searchContent;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.SearchView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.media2.session.MediaConstants;
import androidx.view.ViewModelLazy;
import androidx.view.ViewModelProvider;
import androidx.view.ViewModelStore;
import androidx.viewbinding.ViewBinding;
import c.b.a.m.f;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.jeremyliao.liveeventbus.core.Observable;
import com.qq.e.comm.constants.Constants;
import com.umeng.analytics.pro.ai;
import e.a.a.g.d.k.g;
import e.a.a.g.d.k.h;
import e.a.a.g.d.k.j;
import f.c0.b.l;
import f.c0.c.k;
import f.c0.c.u;
import f.e;
import f.v;
import f.x.i;
import g.b.g2.m;
import g.b.k0;
import io.legado.app.base.BaseViewModel;
import io.legado.app.base.VMBaseActivity;
import io.legado.app.data.entities.Book;
import io.legado.app.data.entities.BookChapter;
import io.legado.app.databinding.ActivitySearchContentBinding;
import io.legado.app.lib.theme.ATH;
import io.legado.app.ui.book.searchContent.SearchContentActivity;
import io.legado.app.ui.book.searchContent.SearchContentAdapter;
import io.legado.app.ui.widget.TitleBar;
import io.legado.app.ui.widget.anima.RefreshProgressBar;
import io.legado.app.ui.widget.recycler.UpLinearLayoutManager;
import io.legado.app.ui.widget.recycler.VerticalDivider;
import io.legado.app.ui.widget.recycler.scroller.FastScrollRecyclerView;
import io.legado.app.utils.EventBusExtensionsKt$observeEvent$o$1;
import io.wenyuange.app.release.R;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mozilla.javascript.optimizer.OptRuntime;

/* JADX INFO: compiled from: SearchContentActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\t\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004B\u0007¢\u0006\u0004\b0\u0010\u000bJ\u0019\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\"\u0010\u001e\u001a\u00020\u00178\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001d\u0010#\u001a\u00020\u00038T@\u0014X\u0094\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b%\u0010&R\u001c\u0010*\u001a\b\u0012\u0004\u0012\u00020\f0(8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010)R\u0016\u0010-\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u0010/\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010,¨\u00061"}, d2 = {"Lio/legado/app/ui/book/searchContent/SearchContentActivity;", "Lio/legado/app/base/VMBaseActivity;", "Lio/legado/app/databinding/ActivitySearchContentBinding;", "Lio/legado/app/ui/book/searchContent/SearchContentViewModel;", "Lio/legado/app/ui/book/searchContent/SearchContentAdapter$a;", "Landroid/os/Bundle;", "savedInstanceState", "Lf/v;", "O0", "(Landroid/os/Bundle;)V", "N0", "()V", "Le/a/a/g/d/k/j;", "searchResult", "Y", "(Le/a/a/g/d/k/j;)V", "", "n", "()I", "Landroidx/appcompat/widget/SearchView;", "k", "Landroidx/appcompat/widget/SearchView;", "searchView", "Lio/legado/app/ui/book/searchContent/SearchContentAdapter;", ai.aA, "Lio/legado/app/ui/book/searchContent/SearchContentAdapter;", "U0", "()Lio/legado/app/ui/book/searchContent/SearchContentAdapter;", "setAdapter", "(Lio/legado/app/ui/book/searchContent/SearchContentAdapter;)V", "adapter", "h", "Lf/e;", "V0", "()Lio/legado/app/ui/book/searchContent/SearchContentViewModel;", "viewModel", "Lio/legado/app/ui/widget/recycler/UpLinearLayoutManager;", "j", "Lio/legado/app/ui/widget/recycler/UpLinearLayoutManager;", "mLayoutManager", "", "Ljava/util/List;", "searchResultList", Constants.LANDSCAPE, OptRuntime.GeneratorState.resumptionPoint_TYPE, "searchResultCounts", "m", "durChapterIndex", "<init>", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class SearchContentActivity extends VMBaseActivity<ActivitySearchContentBinding, SearchContentViewModel> implements SearchContentAdapter.a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f7273g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final e viewModel;

    /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
    public SearchContentAdapter adapter;

    /* JADX INFO: renamed from: j, reason: collision with root package name and from kotlin metadata */
    public UpLinearLayoutManager mLayoutManager;

    /* JADX INFO: renamed from: k, reason: collision with root package name and from kotlin metadata */
    public SearchView searchView;

    /* JADX INFO: renamed from: l, reason: collision with root package name and from kotlin metadata */
    public int searchResultCounts;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    public int durChapterIndex;

    /* JADX INFO: renamed from: n, reason: from kotlin metadata */
    @NotNull
    public List<j> searchResultList;

    /* JADX INFO: compiled from: SearchContentActivity.kt */
    public static final class a extends k implements l<BookChapter, v> {
        public a() {
            super(1);
        }

        @Override // f.c0.b.l
        public /* bridge */ /* synthetic */ v invoke(BookChapter bookChapter) {
            invoke2(bookChapter);
            return v.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull BookChapter bookChapter) {
            String bookUrl;
            f.c0.c.j.e(bookChapter, "chapter");
            Book book = SearchContentActivity.this.V0().book;
            if (book == null || (bookUrl = book.getBookUrl()) == null) {
                return;
            }
            SearchContentActivity searchContentActivity = SearchContentActivity.this;
            if (f.c0.c.j.a(bookChapter.getBookUrl(), bookUrl)) {
                searchContentActivity.U0().cacheFileNames.add(bookChapter.getFileName());
                searchContentActivity.U0().notifyItemChanged(bookChapter.getIndex(), Boolean.TRUE);
            }
        }
    }

    /* JADX INFO: compiled from: SearchContentActivity.kt */
    public static final class b extends k implements f.c0.b.a<v> {
        public b() {
            super(0);
        }

        @Override // f.c0.b.a
        public /* bridge */ /* synthetic */ v invoke() {
            invoke2();
            return v.a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            SearchContentActivity searchContentActivity = SearchContentActivity.this;
            int i2 = SearchContentActivity.f7273g;
            ((ActivitySearchContentBinding) searchContentActivity.K0()).f6562h.setText(f.c0.c.j.k("搜索结果：", Integer.valueOf(searchContentActivity.searchResultCounts)));
            Book book = searchContentActivity.V0().book;
            if (book == null) {
                return;
            }
            k0 k0Var = k0.f6264c;
            f.L3(searchContentActivity, k0.f6263b, null, new e.a.a.g.d.k.d(searchContentActivity, book, null), 2, null);
            searchContentActivity.durChapterIndex = book.getDurChapterIndex();
            String stringExtra = searchContentActivity.getIntent().getStringExtra("searchWord");
            if (stringExtra == null) {
                return;
            }
            SearchView searchView = searchContentActivity.searchView;
            if (searchView != null) {
                searchView.setQuery(stringExtra, true);
            } else {
                f.c0.c.j.m("searchView");
                throw null;
            }
        }
    }

    /* JADX INFO: compiled from: ActivityViewModelLazy.kt */
    public static final class c extends k implements f.c0.b.a<ViewModelProvider.Factory> {
        public final /* synthetic */ ComponentActivity $this_viewModels;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(ComponentActivity componentActivity) {
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
    public static final class d extends k implements f.c0.b.a<ViewModelStore> {
        public final /* synthetic */ ComponentActivity $this_viewModels;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(ComponentActivity componentActivity) {
            super(0);
            this.$this_viewModels = componentActivity;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // f.c0.b.a
        @NotNull
        public final ViewModelStore invoke() {
            ViewModelStore viewModelStore = this.$this_viewModels.getViewModelStore();
            f.c0.c.j.d(viewModelStore, "viewModelStore");
            return viewModelStore;
        }
    }

    public SearchContentActivity() {
        super(false, null, null, false, false, 31);
        this.viewModel = new ViewModelLazy(f.c0.c.v.a(SearchContentViewModel.class), new d(this), new c(this));
        this.searchResultList = new ArrayList();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001c  */
    /* JADX WARN: Type inference failed for: r1v10, types: [T, java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r3v4, types: [T, java.lang.Iterable, java.util.ArrayList] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object T0(io.legado.app.ui.book.searchContent.SearchContentActivity r22, java.lang.String r23, io.legado.app.data.entities.BookChapter r24, f.z.d r25) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 415
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.legado.app.ui.book.searchContent.SearchContentActivity.T0(io.legado.app.ui.book.searchContent.SearchContentActivity, java.lang.String, io.legado.app.data.entities.BookChapter, f.z.d):java.lang.Object");
    }

    @Override // io.legado.app.base.BaseActivity
    public ViewBinding L0() {
        View viewInflate = getLayoutInflater().inflate(R.layout.activity_search_content, (ViewGroup) null, false);
        int i2 = R.id.iv_search_content_bottom;
        AppCompatImageView appCompatImageView = (AppCompatImageView) viewInflate.findViewById(R.id.iv_search_content_bottom);
        if (appCompatImageView != null) {
            i2 = R.id.iv_search_content_top;
            AppCompatImageView appCompatImageView2 = (AppCompatImageView) viewInflate.findViewById(R.id.iv_search_content_top);
            if (appCompatImageView2 != null) {
                i2 = R.id.ll_search_base_info;
                LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(R.id.ll_search_base_info);
                if (linearLayout != null) {
                    i2 = R.id.recycler_view;
                    FastScrollRecyclerView fastScrollRecyclerView = (FastScrollRecyclerView) viewInflate.findViewById(R.id.recycler_view);
                    if (fastScrollRecyclerView != null) {
                        i2 = R.id.refresh_progress_bar;
                        RefreshProgressBar refreshProgressBar = (RefreshProgressBar) viewInflate.findViewById(R.id.refresh_progress_bar);
                        if (refreshProgressBar != null) {
                            i2 = R.id.title_bar;
                            TitleBar titleBar = (TitleBar) viewInflate.findViewById(R.id.title_bar);
                            if (titleBar != null) {
                                i2 = R.id.tv_current_search_info;
                                TextView textView = (TextView) viewInflate.findViewById(R.id.tv_current_search_info);
                                if (textView != null) {
                                    ActivitySearchContentBinding activitySearchContentBinding = new ActivitySearchContentBinding((ConstraintLayout) viewInflate, appCompatImageView, appCompatImageView2, linearLayout, fastScrollRecyclerView, refreshProgressBar, titleBar, textView);
                                    f.c0.c.j.d(activitySearchContentBinding, "inflate(layoutInflater)");
                                    return activitySearchContentBinding;
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i2)));
    }

    @Override // io.legado.app.base.BaseActivity
    public void N0() {
        String[] strArr = {"saveContent"};
        EventBusExtensionsKt$observeEvent$o$1 eventBusExtensionsKt$observeEvent$o$1 = new EventBusExtensionsKt$observeEvent$o$1(new a());
        for (int i2 = 0; i2 < 1; i2++) {
            Observable observable = LiveEventBus.get(strArr[i2], BookChapter.class);
            f.c0.c.j.d(observable, "get(tag, EVENT::class.java)");
            observable.observe(this, eventBusExtensionsKt$observeEvent$o$1);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.legado.app.base.BaseActivity
    public void O0(@Nullable Bundle savedInstanceState) {
        View viewFindViewById = ((ActivitySearchContentBinding) K0()).f6561g.findViewById(R.id.search_view);
        f.c0.c.j.d(viewFindViewById, "binding.titleBar.findViewById(R.id.search_view)");
        this.searchView = (SearchView) viewFindViewById;
        int iT1 = f.T1(this);
        int iS2 = f.S2(this, ((double) 1) - (((((double) Color.blue(iT1)) * 0.114d) + ((((double) Color.green(iT1)) * 0.587d) + (((double) Color.red(iT1)) * 0.299d))) / ((double) 255)) < 0.4d);
        ((ActivitySearchContentBinding) K0()).f6558d.setBackgroundColor(iT1);
        ((ActivitySearchContentBinding) K0()).f6562h.setTextColor(iS2);
        ((ActivitySearchContentBinding) K0()).f6557c.setColorFilter(iS2);
        ((ActivitySearchContentBinding) K0()).f6556b.setColorFilter(iS2);
        ATH ath = ATH.a;
        SearchView searchView = this.searchView;
        if (searchView == null) {
            f.c0.c.j.m("searchView");
            throw null;
        }
        ATH.h(ath, searchView, f.R2(this), false, 4);
        SearchView searchView2 = this.searchView;
        if (searchView2 == null) {
            f.c0.c.j.m("searchView");
            throw null;
        }
        searchView2.onActionViewExpanded();
        SearchView searchView3 = this.searchView;
        if (searchView3 == null) {
            f.c0.c.j.m("searchView");
            throw null;
        }
        searchView3.setSubmitButtonEnabled(true);
        SearchView searchView4 = this.searchView;
        if (searchView4 == null) {
            f.c0.c.j.m("searchView");
            throw null;
        }
        searchView4.setQueryHint(getString(R.string.search));
        SearchView searchView5 = this.searchView;
        if (searchView5 == null) {
            f.c0.c.j.m("searchView");
            throw null;
        }
        searchView5.clearFocus();
        SearchView searchView6 = this.searchView;
        if (searchView6 == null) {
            f.c0.c.j.m("searchView");
            throw null;
        }
        searchView6.setOnQueryTextListener(new SearchView.OnQueryTextListener() { // from class: io.legado.app.ui.book.searchContent.SearchContentActivity$initSearchView$1
            @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
            public boolean onQueryTextChange(@Nullable String newText) {
                return false;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r3v2, types: [T, f.x.i] */
            @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
            public boolean onQueryTextSubmit(@NotNull String query) {
                f.c0.c.j.e(query, MediaConstants.MEDIA_URI_QUERY_QUERY);
                if (!f.c0.c.j.a(this.a.V0().lastQuery, query)) {
                    SearchContentActivity searchContentActivity = this.a;
                    Objects.requireNonNull(searchContentActivity);
                    f.c0.c.j.e(query, "newText");
                    if (!f.h0.k.s(query)) {
                        searchContentActivity.U0().h();
                        searchContentActivity.searchResultList.clear();
                        ((ActivitySearchContentBinding) searchContentActivity.K0()).f6560f.setAutoLoading(true);
                        searchContentActivity.searchResultCounts = 0;
                        SearchContentViewModel searchContentViewModelV0 = searchContentActivity.V0();
                        Objects.requireNonNull(searchContentViewModelV0);
                        f.c0.c.j.e(query, "<set-?>");
                        searchContentViewModelV0.lastQuery = query;
                        u uVar = new u();
                        uVar.element = i.INSTANCE;
                        k0 k0Var = k0.f6264c;
                        f.L3(searchContentActivity, m.f6207b, null, new g(searchContentActivity, uVar, query, null), 2, null);
                    }
                }
                return false;
            }
        });
        SearchContentAdapter searchContentAdapter = new SearchContentAdapter(this, this);
        f.c0.c.j.e(searchContentAdapter, "<set-?>");
        this.adapter = searchContentAdapter;
        this.mLayoutManager = new UpLinearLayoutManager(this);
        FastScrollRecyclerView fastScrollRecyclerView = ((ActivitySearchContentBinding) K0()).f6559e;
        UpLinearLayoutManager upLinearLayoutManager = this.mLayoutManager;
        if (upLinearLayoutManager == null) {
            f.c0.c.j.m("mLayoutManager");
            throw null;
        }
        fastScrollRecyclerView.setLayoutManager(upLinearLayoutManager);
        ((ActivitySearchContentBinding) K0()).f6559e.addItemDecoration(new VerticalDivider(this));
        ((ActivitySearchContentBinding) K0()).f6559e.setAdapter(U0());
        ((ActivitySearchContentBinding) K0()).f6557c.setOnClickListener(new View.OnClickListener() { // from class: e.a.a.g.d.k.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SearchContentActivity searchContentActivity = this.a;
                int i2 = SearchContentActivity.f7273g;
                f.c0.c.j.e(searchContentActivity, "this$0");
                UpLinearLayoutManager upLinearLayoutManager2 = searchContentActivity.mLayoutManager;
                if (upLinearLayoutManager2 != null) {
                    upLinearLayoutManager2.scrollToPositionWithOffset(0, 0);
                } else {
                    f.c0.c.j.m("mLayoutManager");
                    throw null;
                }
            }
        });
        ((ActivitySearchContentBinding) K0()).f6556b.setOnClickListener(new View.OnClickListener() { // from class: e.a.a.g.d.k.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SearchContentActivity searchContentActivity = this.a;
                int i2 = SearchContentActivity.f7273g;
                f.c0.c.j.e(searchContentActivity, "this$0");
                if (searchContentActivity.U0().getItemCount() > 0) {
                    UpLinearLayoutManager upLinearLayoutManager2 = searchContentActivity.mLayoutManager;
                    if (upLinearLayoutManager2 != null) {
                        upLinearLayoutManager2.scrollToPositionWithOffset(searchContentActivity.U0().getItemCount() - 1, 0);
                    } else {
                        f.c0.c.j.m("mLayoutManager");
                        throw null;
                    }
                }
            }
        });
        String stringExtra = getIntent().getStringExtra("bookUrl");
        if (stringExtra == null) {
            return;
        }
        SearchContentViewModel searchContentViewModelV0 = V0();
        b bVar = new b();
        Objects.requireNonNull(searchContentViewModelV0);
        f.c0.c.j.e(stringExtra, "bookUrl");
        f.c0.c.j.e(bVar, "success");
        searchContentViewModelV0.bookUrl = stringExtra;
        BaseViewModel.a(searchContentViewModelV0, null, null, new h(searchContentViewModelV0, stringExtra, null), 3, null).d(null, new e.a.a.g.d.k.i(bVar, null));
    }

    @NotNull
    public final SearchContentAdapter U0() {
        SearchContentAdapter searchContentAdapter = this.adapter;
        if (searchContentAdapter != null) {
            return searchContentAdapter;
        }
        f.c0.c.j.m("adapter");
        throw null;
    }

    @NotNull
    public SearchContentViewModel V0() {
        return (SearchContentViewModel) this.viewModel.getValue();
    }

    @Override // io.legado.app.ui.book.searchContent.SearchContentAdapter.a
    public void Y(@NotNull j searchResult) {
        f.c0.c.j.e(searchResult, "searchResult");
        Intent intent = new Intent();
        intent.putExtra("index", searchResult.f5816g);
        intent.putExtra("contentPosition", searchResult.f5819j);
        intent.putExtra(MediaConstants.MEDIA_URI_QUERY_QUERY, searchResult.f5814e);
        intent.putExtra("indexWithinChapter", searchResult.f5811b);
        setResult(-1, intent);
        finish();
    }

    @Override // io.legado.app.ui.book.searchContent.SearchContentAdapter.a
    /* JADX INFO: renamed from: n, reason: from getter */
    public int getDurChapterIndex() {
        return this.durChapterIndex;
    }
}

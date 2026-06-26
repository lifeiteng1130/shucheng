package io.legado.app.ui.rss.article;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.view.LiveData;
import androidx.view.Observer;
import androidx.view.ViewModelProvider;
import androidx.view.ViewModelStore;
import androidx.view.ViewModelStoreOwner;
import androidx.viewbinding.ViewBinding;
import com.umeng.analytics.pro.ai;
import e.a.a.d.u.b;
import e.a.a.g.k.a.n;
import e.a.a.g.k.a.o;
import e.a.a.g.k.a.p;
import e.a.a.g.k.a.u;
import f.c0.b.a;
import f.c0.b.l;
import f.c0.c.j;
import f.c0.c.k;
import f.c0.c.q;
import f.c0.c.v;
import f.f0.h;
import g.b.k0;
import io.legado.app.base.BaseViewModel;
import io.legado.app.base.VMBaseFragment;
import io.legado.app.data.AppDatabaseKt;
import io.legado.app.data.entities.RssArticle;
import io.legado.app.data.entities.RssSource;
import io.legado.app.databinding.FragmentRssArticlesBinding;
import io.legado.app.databinding.ViewLoadMoreBinding;
import io.legado.app.lib.theme.ATH;
import io.legado.app.model.rss.Rss;
import io.legado.app.ui.rss.article.BaseRssArticlesAdapter;
import io.legado.app.ui.rss.article.RssArticlesFragment;
import io.legado.app.ui.rss.read.ReadRssActivity;
import io.legado.app.ui.widget.recycler.LoadMoreView;
import io.legado.app.ui.widget.recycler.RecyclerViewAtPager2;
import io.legado.app.ui.widget.recycler.VerticalDivider;
import io.legado.app.utils.viewbindingdelegate.ViewBindingProperty;
import io.wenyuange.app.release.R;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: RssArticlesFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0007\u0018\u0000 92\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001:B\u0007¢\u0006\u0004\b8\u0010\fJ!\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0014\u0010\fR\u0016\u0010\u0016\u001a\u00020\u00118V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0013R&\u0010\u001e\u001a\u0006\u0012\u0002\b\u00030\u00178\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b \u0010!R\u001d\u0010'\u001a\u00020\u00028T@\u0014X\u0094\u0084\u0002¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u001d\u0010,\u001a\u00020(8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b)\u0010$\u001a\u0004\b*\u0010+R\u001d\u00102\u001a\u00020-8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R$\u00107\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r04\u0018\u0001038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u00106¨\u0006;"}, d2 = {"Lio/legado/app/ui/rss/article/RssArticlesFragment;", "Lio/legado/app/base/VMBaseFragment;", "Lio/legado/app/ui/rss/article/RssArticlesViewModel;", "Lio/legado/app/ui/rss/article/BaseRssArticlesAdapter$a;", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "Lf/v;", "R", "(Landroid/view/View;Landroid/os/Bundle;)V", "O", "()V", "Lio/legado/app/data/entities/RssArticle;", "rssArticle", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Lio/legado/app/data/entities/RssArticle;)V", "", "X", "()Z", "Y", "y", "isGridLayout", "Lio/legado/app/ui/rss/article/BaseRssArticlesAdapter;", ai.aA, "Lio/legado/app/ui/rss/article/BaseRssArticlesAdapter;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "()Lio/legado/app/ui/rss/article/BaseRssArticlesAdapter;", "setAdapter", "(Lio/legado/app/ui/rss/article/BaseRssArticlesAdapter;)V", "adapter", "Lio/legado/app/ui/widget/recycler/LoadMoreView;", "j", "Lio/legado/app/ui/widget/recycler/LoadMoreView;", "loadMoreView", "h", "Lf/e;", ExifInterface.LONGITUDE_WEST, "()Lio/legado/app/ui/rss/article/RssArticlesViewModel;", "viewModel", "Lio/legado/app/ui/rss/article/RssSortViewModel;", "g", "U", "()Lio/legado/app/ui/rss/article/RssSortViewModel;", "activityViewModel", "Lio/legado/app/databinding/FragmentRssArticlesBinding;", "f", "Lio/legado/app/utils/viewbindingdelegate/ViewBindingProperty;", "getBinding", "()Lio/legado/app/databinding/FragmentRssArticlesBinding;", "binding", "Landroidx/lifecycle/LiveData;", "", "k", "Landroidx/lifecycle/LiveData;", "rssArticlesData", "<init>", "d", ai.at, "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class RssArticlesFragment extends VMBaseFragment<RssArticlesViewModel> implements BaseRssArticlesAdapter.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ h<Object>[] f7491e;

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final ViewBindingProperty binding;

    /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final f.e activityViewModel;

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final f.e viewModel;

    /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
    public BaseRssArticlesAdapter<?> adapter;

    /* JADX INFO: renamed from: j, reason: collision with root package name and from kotlin metadata */
    public LoadMoreView loadMoreView;

    /* JADX INFO: renamed from: k, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public LiveData<List<RssArticle>> rssArticlesData;

    /* JADX INFO: renamed from: io.legado.app.ui.rss.article.RssArticlesFragment$a, reason: from kotlin metadata */
    /* JADX INFO: compiled from: RssArticlesFragment.kt */
    public static final class Companion {
        public Companion(f.c0.c.f fVar) {
        }
    }

    /* JADX INFO: compiled from: RssArticlesFragment.kt */
    public static final class b extends k implements l<ViewGroup, ViewBinding> {
        public b() {
            super(1);
        }

        @Override // f.c0.b.l
        @NotNull
        public final ViewBinding invoke(@NotNull ViewGroup viewGroup) {
            j.e(viewGroup, "it");
            LoadMoreView loadMoreView = RssArticlesFragment.this.loadMoreView;
            if (loadMoreView == null) {
                j.m("loadMoreView");
                throw null;
            }
            ViewLoadMoreBinding viewLoadMoreBindingA = ViewLoadMoreBinding.a(loadMoreView);
            j.d(viewLoadMoreBindingA, "bind(loadMoreView)");
            return viewLoadMoreBindingA;
        }
    }

    /* JADX INFO: compiled from: FragmentViewModelLazy.kt */
    public static final class c extends k implements a<ViewModelStore> {
        public final /* synthetic */ Fragment $this_activityViewModels;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Fragment fragment) {
            super(0);
            this.$this_activityViewModels = fragment;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // f.c0.b.a
        @NotNull
        public final ViewModelStore invoke() {
            FragmentActivity fragmentActivityRequireActivity = this.$this_activityViewModels.requireActivity();
            j.d(fragmentActivityRequireActivity, "requireActivity()");
            ViewModelStore viewModelStore = fragmentActivityRequireActivity.getViewModelStore();
            j.d(viewModelStore, "requireActivity().viewModelStore");
            return viewModelStore;
        }
    }

    /* JADX INFO: compiled from: FragmentViewModelLazy.kt */
    public static final class d extends k implements a<ViewModelProvider.Factory> {
        public final /* synthetic */ Fragment $this_activityViewModels;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(Fragment fragment) {
            super(0);
            this.$this_activityViewModels = fragment;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // f.c0.b.a
        @NotNull
        public final ViewModelProvider.Factory invoke() {
            FragmentActivity fragmentActivityRequireActivity = this.$this_activityViewModels.requireActivity();
            j.d(fragmentActivityRequireActivity, "requireActivity()");
            return fragmentActivityRequireActivity.getDefaultViewModelProviderFactory();
        }
    }

    /* JADX INFO: compiled from: FragmentViewBindings.kt */
    public static final class e extends k implements l<RssArticlesFragment, FragmentRssArticlesBinding> {
        public e() {
            super(1);
        }

        @Override // f.c0.b.l
        @NotNull
        public final FragmentRssArticlesBinding invoke(@NotNull RssArticlesFragment rssArticlesFragment) {
            j.e(rssArticlesFragment, "fragment");
            View viewRequireView = rssArticlesFragment.requireView();
            RecyclerViewAtPager2 recyclerViewAtPager2 = (RecyclerViewAtPager2) viewRequireView.findViewById(R.id.recycler_view);
            if (recyclerViewAtPager2 == null) {
                throw new NullPointerException("Missing required view with ID: ".concat(viewRequireView.getResources().getResourceName(R.id.recycler_view)));
            }
            SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) viewRequireView;
            return new FragmentRssArticlesBinding(swipeRefreshLayout, recyclerViewAtPager2, swipeRefreshLayout);
        }
    }

    /* JADX INFO: compiled from: FragmentViewModelLazy.kt */
    public static final class f extends k implements a<Fragment> {
        public final /* synthetic */ Fragment $this_viewModels;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(Fragment fragment) {
            super(0);
            this.$this_viewModels = fragment;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // f.c0.b.a
        @NotNull
        public final Fragment invoke() {
            return this.$this_viewModels;
        }
    }

    /* JADX INFO: compiled from: FragmentViewModelLazy.kt */
    public static final class g extends k implements a<ViewModelStore> {
        public final /* synthetic */ a $ownerProducer;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(a aVar) {
            super(0);
            this.$ownerProducer = aVar;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // f.c0.b.a
        @NotNull
        public final ViewModelStore invoke() {
            ViewModelStore viewModelStore = ((ViewModelStoreOwner) this.$ownerProducer.invoke()).getViewModelStore();
            j.d(viewModelStore, "ownerProducer().viewModelStore");
            return viewModelStore;
        }
    }

    static {
        h<Object>[] hVarArr = new h[3];
        q qVar = new q(v.a(RssArticlesFragment.class), "binding", "getBinding()Lio/legado/app/databinding/FragmentRssArticlesBinding;");
        Objects.requireNonNull(v.a);
        hVarArr[0] = qVar;
        f7491e = hVarArr;
        INSTANCE = new Companion(null);
    }

    public RssArticlesFragment() {
        super(R.layout.fragment_rss_articles);
        this.binding = c.b.a.m.f.b6(this, new e());
        this.activityViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, v.a(RssSortViewModel.class), new c(this), new d(this));
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, v.a(RssArticlesViewModel.class), new g(new f(this)), null);
    }

    @Override // io.legado.app.ui.rss.article.BaseRssArticlesAdapter.a
    public void A(@NotNull RssArticle rssArticle) {
        j.e(rssArticle, "rssArticle");
        RssSortViewModel rssSortViewModelU = U();
        Objects.requireNonNull(rssSortViewModelU);
        j.e(rssArticle, "rssArticle");
        BaseViewModel.a(rssSortViewModelU, null, null, new u(rssArticle, null), 3, null);
        Intent intent = new Intent(requireContext(), (Class<?>) ReadRssActivity.class);
        intent.putExtra("title", rssArticle.getTitle());
        intent.putExtra("origin", rssArticle.getOrigin());
        intent.putExtra("link", rssArticle.getLink());
        startActivity(intent);
    }

    @Override // io.legado.app.base.BaseFragment
    public void O() {
        W().loadFinally.observe(getViewLifecycleOwner(), new Observer() { // from class: e.a.a.g.k.a.d
            @Override // androidx.view.Observer
            public final void onChanged(Object obj) {
                RssArticlesFragment rssArticlesFragment = this.a;
                Boolean bool = (Boolean) obj;
                RssArticlesFragment.Companion companion = RssArticlesFragment.INSTANCE;
                f.c0.c.j.e(rssArticlesFragment, "this$0");
                ((FragmentRssArticlesBinding) rssArticlesFragment.binding.b(rssArticlesFragment, RssArticlesFragment.f7491e[0])).f6733c.setRefreshing(false);
                f.c0.c.j.d(bool, "it");
                if (bool.booleanValue()) {
                    LoadMoreView loadMoreView = rssArticlesFragment.loadMoreView;
                    if (loadMoreView != null) {
                        loadMoreView.d();
                        return;
                    } else {
                        f.c0.c.j.m("loadMoreView");
                        throw null;
                    }
                }
                LoadMoreView loadMoreView2 = rssArticlesFragment.loadMoreView;
                if (loadMoreView2 == null) {
                    f.c0.c.j.m("loadMoreView");
                    throw null;
                }
                int i2 = LoadMoreView.a;
                loadMoreView2.c(null);
            }
        });
    }

    @Override // io.legado.app.base.BaseFragment
    public void R(@NotNull View view, @Nullable Bundle savedInstanceState) {
        j.e(view, "view");
        RssArticlesViewModel rssArticlesViewModelW = W();
        Bundle arguments = getArguments();
        Objects.requireNonNull(rssArticlesViewModelW);
        if (arguments != null) {
            String string = arguments.getString("sortName");
            if (string == null) {
                string = "";
            }
            j.e(string, "<set-?>");
            rssArticlesViewModelW.sortName = string;
            String string2 = arguments.getString("sortUrl");
            String str = string2 != null ? string2 : "";
            j.e(str, "<set-?>");
            rssArticlesViewModelW.sortUrl = str;
        }
        X();
        X();
        String str2 = U().url;
        if (str2 == null) {
            return;
        }
        LiveData<List<RssArticle>> liveData = this.rssArticlesData;
        if (liveData != null) {
            liveData.removeObservers(this);
        }
        LiveData<List<RssArticle>> liveDataLiveByOriginSort = AppDatabaseKt.getAppDb().getRssArticleDao().liveByOriginSort(str2, W().sortName);
        this.rssArticlesData = liveDataLiveByOriginSort;
        if (liveDataLiveByOriginSort == null) {
            return;
        }
        liveDataLiveByOriginSort.observe(getViewLifecycleOwner(), new Observer() { // from class: e.a.a.g.k.a.f
            @Override // androidx.view.Observer
            public final void onChanged(Object obj) {
                RssArticlesFragment rssArticlesFragment = this.a;
                RssArticlesFragment.Companion companion = RssArticlesFragment.INSTANCE;
                f.c0.c.j.e(rssArticlesFragment, "this$0");
                rssArticlesFragment.V().x((List) obj);
            }
        });
    }

    public final RssSortViewModel U() {
        return (RssSortViewModel) this.activityViewModel.getValue();
    }

    @NotNull
    public final BaseRssArticlesAdapter<?> V() {
        BaseRssArticlesAdapter<?> baseRssArticlesAdapter = this.adapter;
        if (baseRssArticlesAdapter != null) {
            return baseRssArticlesAdapter;
        }
        j.m("adapter");
        throw null;
    }

    @NotNull
    public RssArticlesViewModel W() {
        return (RssArticlesViewModel) this.viewModel.getValue();
    }

    public final boolean X() {
        RecyclerView.LayoutManager linearLayoutManager;
        BaseRssArticlesAdapter<?> rssArticlesAdapter;
        final FragmentRssArticlesBinding fragmentRssArticlesBinding = (FragmentRssArticlesBinding) this.binding.b(this, f7491e[0]);
        fragmentRssArticlesBinding.f6733c.setColorSchemeColors(c.b.a.m.f.N1(this));
        ATH.a.b(fragmentRssArticlesBinding.f6732b);
        RecyclerViewAtPager2 recyclerViewAtPager2 = fragmentRssArticlesBinding.f6732b;
        if (U().f()) {
            fragmentRssArticlesBinding.f6732b.setPadding(8, 0, 8, 0);
            linearLayoutManager = new GridLayoutManager(requireContext(), 2);
        } else {
            RecyclerViewAtPager2 recyclerViewAtPager22 = fragmentRssArticlesBinding.f6732b;
            Context contextRequireContext = requireContext();
            j.d(contextRequireContext, "requireContext()");
            recyclerViewAtPager22.addItemDecoration(new VerticalDivider(contextRequireContext));
            linearLayoutManager = new LinearLayoutManager(requireContext());
        }
        recyclerViewAtPager2.setLayoutManager(linearLayoutManager);
        RssSource rssSource = U().rssSource;
        Integer numValueOf = rssSource == null ? null : Integer.valueOf(rssSource.getArticleStyle());
        if (numValueOf != null && numValueOf.intValue() == 1) {
            Context contextRequireContext2 = requireContext();
            j.d(contextRequireContext2, "requireContext()");
            rssArticlesAdapter = new RssArticlesAdapter1(contextRequireContext2, this);
        } else if (numValueOf != null && numValueOf.intValue() == 2) {
            Context contextRequireContext3 = requireContext();
            j.d(contextRequireContext3, "requireContext()");
            rssArticlesAdapter = new RssArticlesAdapter2(contextRequireContext3, this);
        } else {
            Context contextRequireContext4 = requireContext();
            j.d(contextRequireContext4, "requireContext()");
            rssArticlesAdapter = new RssArticlesAdapter(contextRequireContext4, this);
        }
        j.e(rssArticlesAdapter, "<set-?>");
        this.adapter = rssArticlesAdapter;
        fragmentRssArticlesBinding.f6732b.setAdapter(V());
        Context contextRequireContext5 = requireContext();
        j.d(contextRequireContext5, "requireContext()");
        this.loadMoreView = new LoadMoreView(contextRequireContext5, null);
        V().d(new b());
        fragmentRssArticlesBinding.f6733c.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: e.a.a.g.k.a.g
            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
            public final void onRefresh() {
                RssArticlesFragment rssArticlesFragment = this.a;
                RssArticlesFragment.Companion companion = RssArticlesFragment.INSTANCE;
                f.c0.c.j.e(rssArticlesFragment, "this$0");
                rssArticlesFragment.Y();
            }
        });
        fragmentRssArticlesBinding.f6732b.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: io.legado.app.ui.rss.article.RssArticlesFragment$initView$1$3
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(@NotNull RecyclerView recyclerView, int dx, int dy) {
                j.e(recyclerView, "recyclerView");
                super.onScrolled(recyclerView, dx, dy);
                if (recyclerView.canScrollVertically(1)) {
                    return;
                }
                RssArticlesFragment rssArticlesFragment = this.a;
                RssArticlesFragment.Companion companion = RssArticlesFragment.INSTANCE;
                if (rssArticlesFragment.W().isLoading) {
                    return;
                }
                LoadMoreView loadMoreView = rssArticlesFragment.loadMoreView;
                if (loadMoreView == null) {
                    j.m("loadMoreView");
                    throw null;
                }
                if (!loadMoreView.getHasMore() || rssArticlesFragment.V().j() <= 0) {
                    return;
                }
                LoadMoreView loadMoreView2 = rssArticlesFragment.loadMoreView;
                if (loadMoreView2 == null) {
                    j.m("loadMoreView");
                    throw null;
                }
                loadMoreView2.d();
                RssSource rssSource2 = rssArticlesFragment.U().rssSource;
                if (rssSource2 == null) {
                    return;
                }
                RssArticlesViewModel rssArticlesViewModelW = rssArticlesFragment.W();
                Objects.requireNonNull(rssArticlesViewModelW);
                j.e(rssSource2, "rssSource");
                rssArticlesViewModelW.isLoading = true;
                rssArticlesViewModelW.page++;
                String str = rssArticlesViewModelW.nextPageUrl;
                if (str == null || str.length() == 0) {
                    rssArticlesViewModelW.loadFinally.postValue(Boolean.FALSE);
                    return;
                }
                b articles$default = Rss.getArticles$default(Rss.INSTANCE, rssArticlesViewModelW, rssArticlesViewModelW.sortName, str, rssSource2, rssArticlesViewModelW.page, null, 32, null);
                k0 k0Var = k0.f6264c;
                articles$default.d(k0.f6263b, new p(rssArticlesViewModelW, null));
                b.b(articles$default, null, new e.a.a.g.k.a.q(rssArticlesViewModelW, null), 1);
            }
        });
        return fragmentRssArticlesBinding.f6733c.post(new Runnable() { // from class: e.a.a.g.k.a.e
            @Override // java.lang.Runnable
            public final void run() {
                FragmentRssArticlesBinding fragmentRssArticlesBinding2 = fragmentRssArticlesBinding;
                RssArticlesFragment rssArticlesFragment = this;
                RssArticlesFragment.Companion companion = RssArticlesFragment.INSTANCE;
                f.c0.c.j.e(fragmentRssArticlesBinding2, "$this_with");
                f.c0.c.j.e(rssArticlesFragment, "this$0");
                fragmentRssArticlesBinding2.f6733c.setRefreshing(true);
                rssArticlesFragment.Y();
            }
        });
    }

    public final void Y() {
        RssSource rssSource = U().rssSource;
        if (rssSource == null) {
            return;
        }
        RssArticlesViewModel rssArticlesViewModelW = W();
        Objects.requireNonNull(rssArticlesViewModelW);
        j.e(rssSource, "rssSource");
        rssArticlesViewModelW.isLoading = true;
        rssArticlesViewModelW.page = 1;
        e.a.a.d.u.b articles$default = Rss.getArticles$default(Rss.INSTANCE, rssArticlesViewModelW, rssArticlesViewModelW.sortName, rssArticlesViewModelW.sortUrl, rssSource, 1, null, 32, null);
        k0 k0Var = k0.f6264c;
        articles$default.d(k0.f6263b, new n(rssArticlesViewModelW, rssSource, null));
        e.a.a.d.u.b.b(articles$default, null, new o(rssArticlesViewModelW, null), 1);
    }

    @Override // io.legado.app.ui.rss.article.BaseRssArticlesAdapter.a
    public boolean y() {
        return U().f();
    }
}

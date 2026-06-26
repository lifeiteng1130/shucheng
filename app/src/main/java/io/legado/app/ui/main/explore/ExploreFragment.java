package io.legado.app.ui.main.explore;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.view.LiveData;
import androidx.view.Observer;
import androidx.view.ViewModelStore;
import androidx.view.ViewModelStoreOwner;
import c.b.a.m.f;
import com.umeng.analytics.pro.ai;
import e.a.a.g.h.h.u;
import f.c0.b.l;
import f.c0.c.j;
import f.c0.c.k;
import f.c0.c.q;
import f.c0.c.v;
import f.e;
import f.f0.h;
import io.legado.app.base.BaseViewModel;
import io.legado.app.base.VMBaseFragment;
import io.legado.app.data.AppDatabaseKt;
import io.legado.app.data.entities.BookSource;
import io.legado.app.databinding.FragmentExploreBinding;
import io.legado.app.lib.theme.ATH;
import io.legado.app.ui.book.explore.ExploreShowActivity;
import io.legado.app.ui.book.search.SearchActivity;
import io.legado.app.ui.main.explore.ExploreAdapter;
import io.legado.app.ui.main.explore.ExploreDiffCallBack;
import io.legado.app.ui.main.explore.ExploreFragment;
import io.legado.app.ui.widget.TitleBar;
import io.legado.app.ui.widget.recycler.RecyclerViewAtPager2;
import io.legado.app.utils.viewbindingdelegate.ViewBindingProperty;
import io.wenyuange.app.release.R;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ExploreFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0004B\u0007¢\u0006\u0004\bG\u0010\u0016J!\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ'\u0010!\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u001dH\u0016¢\u0006\u0004\b!\u0010\"J\u0017\u0010#\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0004\b#\u0010$J\u0017\u0010'\u001a\u00020\t2\u0006\u0010&\u001a\u00020%H\u0016¢\u0006\u0004\b'\u0010(R$\u0010-\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020%0*\u0018\u00010)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b/\u00100R&\u00106\u001a\u0012\u0012\u0004\u0012\u00020\u001d02j\b\u0012\u0004\u0012\u00020\u001d`38\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b4\u00105R\u001d\u0010;\u001a\u00020\u00028T@\u0014X\u0094\u0084\u0002¢\u0006\f\n\u0004\b7\u00108\u001a\u0004\b9\u0010:R\u001d\u0010A\u001a\u00020<8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@R\u0016\u0010E\u001a\u00020B8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bC\u0010DR$\u0010F\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0*\u0018\u00010)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010,¨\u0006H"}, d2 = {"Lio/legado/app/ui/main/explore/ExploreFragment;", "Lio/legado/app/base/VMBaseFragment;", "Lio/legado/app/ui/main/explore/ExploreViewModel;", "Lio/legado/app/ui/main/explore/ExploreAdapter$a;", "Landroid/view/MenuItem$OnMenuItemClickListener;", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "Lf/v;", "R", "(Landroid/view/View;Landroid/os/Bundle;)V", "Landroid/view/Menu;", "menu", "P", "(Landroid/view/Menu;)V", "Landroid/view/MenuItem;", "item", "", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "onPause", "()V", "Q", "(Landroid/view/MenuItem;)V", "", "pos", ai.at, "(I)V", "", "sourceUrl", "title", "exploreUrl", "G", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "J", "(Ljava/lang/String;)V", "Lio/legado/app/data/entities/BookSource;", "source", "j", "(Lio/legado/app/data/entities/BookSource;)V", "Landroidx/lifecycle/LiveData;", "", "k", "Landroidx/lifecycle/LiveData;", "liveExplore", "Lio/legado/app/ui/main/explore/ExploreAdapter;", "g", "Lio/legado/app/ui/main/explore/ExploreAdapter;", "adapter", "Ljava/util/LinkedHashSet;", "Lkotlin/collections/LinkedHashSet;", ai.aA, "Ljava/util/LinkedHashSet;", "groups", "e", "Lf/e;", "getViewModel", "()Lio/legado/app/ui/main/explore/ExploreViewModel;", "viewModel", "Lio/legado/app/databinding/FragmentExploreBinding;", "f", "Lio/legado/app/utils/viewbindingdelegate/ViewBindingProperty;", "U", "()Lio/legado/app/databinding/FragmentExploreBinding;", "binding", "Landroidx/recyclerview/widget/LinearLayoutManager;", "h", "Landroidx/recyclerview/widget/LinearLayoutManager;", "linearLayoutManager", "liveGroup", "<init>", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class ExploreFragment extends VMBaseFragment<ExploreViewModel> implements ExploreAdapter.a, MenuItem.OnMenuItemClickListener {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ h<Object>[] f7443d;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final e viewModel;

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final ViewBindingProperty binding;

    /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
    public ExploreAdapter adapter;

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    public LinearLayoutManager linearLayoutManager;

    /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final LinkedHashSet<String> groups;

    /* JADX INFO: renamed from: j, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public LiveData<List<String>> liveGroup;

    /* JADX INFO: renamed from: k, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public LiveData<List<BookSource>> liveExplore;

    /* JADX INFO: compiled from: FragmentViewBindings.kt */
    public static final class a extends k implements l<ExploreFragment, FragmentExploreBinding> {
        public a() {
            super(1);
        }

        @Override // f.c0.b.l
        @NotNull
        public final FragmentExploreBinding invoke(@NotNull ExploreFragment exploreFragment) {
            j.e(exploreFragment, "fragment");
            View viewRequireView = exploreFragment.requireView();
            int i2 = R.id.rv_find;
            RecyclerViewAtPager2 recyclerViewAtPager2 = (RecyclerViewAtPager2) viewRequireView.findViewById(R.id.rv_find);
            if (recyclerViewAtPager2 != null) {
                i2 = R.id.title_bar;
                TitleBar titleBar = (TitleBar) viewRequireView.findViewById(R.id.title_bar);
                if (titleBar != null) {
                    i2 = R.id.tv_empty_msg;
                    TextView textView = (TextView) viewRequireView.findViewById(R.id.tv_empty_msg);
                    if (textView != null) {
                        return new FragmentExploreBinding((ConstraintLayout) viewRequireView, recyclerViewAtPager2, titleBar, textView);
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(viewRequireView.getResources().getResourceName(i2)));
        }
    }

    /* JADX INFO: compiled from: FragmentViewModelLazy.kt */
    public static final class b extends k implements f.c0.b.a<Fragment> {
        public final /* synthetic */ Fragment $this_viewModels;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Fragment fragment) {
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
    public static final class c extends k implements f.c0.b.a<ViewModelStore> {
        public final /* synthetic */ f.c0.b.a $ownerProducer;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(f.c0.b.a aVar) {
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
        h<Object>[] hVarArr = new h[2];
        q qVar = new q(v.a(ExploreFragment.class), "binding", "getBinding()Lio/legado/app/databinding/FragmentExploreBinding;");
        Objects.requireNonNull(v.a);
        hVarArr[1] = qVar;
        f7443d = hVarArr;
    }

    public ExploreFragment() {
        super(R.layout.fragment_explore);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, v.a(ExploreViewModel.class), new c(new b(this)), null);
        this.binding = f.b6(this, new a());
        this.groups = new LinkedHashSet<>();
    }

    @Override // io.legado.app.ui.main.explore.ExploreAdapter.a
    public void G(@NotNull String sourceUrl, @NotNull String title, @NotNull String exploreUrl) {
        j.e(sourceUrl, "sourceUrl");
        j.e(title, "title");
        j.e(exploreUrl, "exploreUrl");
        Intent intent = new Intent(requireContext(), (Class<?>) ExploreShowActivity.class);
        intent.putExtra("exploreName", title);
        intent.putExtra("sourceUrl", sourceUrl);
        intent.putExtra("exploreUrl", exploreUrl);
        startActivity(intent);
    }

    @Override // io.legado.app.ui.main.explore.ExploreAdapter.a
    public void J(@NotNull String sourceUrl) {
        j.e(sourceUrl, "sourceUrl");
    }

    @Override // io.legado.app.base.BaseFragment
    public void P(@NotNull Menu menu) {
        j.e(menu, "menu");
        j.e(menu, "menu");
        N().inflate(R.menu.main_explore, menu);
        menu.findItem(R.id.menu_search).setOnMenuItemClickListener(this);
    }

    @Override // io.legado.app.base.BaseFragment
    public void Q(@NotNull MenuItem item) {
        j.e(item, "item");
        j.e(item, "item");
    }

    @Override // io.legado.app.base.BaseFragment
    public void R(@NotNull View view, @Nullable Bundle savedInstanceState) {
        j.e(view, "view");
        T(U().f6718c.getToolbar());
        ATH.a.b(U().f6717b);
        this.linearLayoutManager = new LinearLayoutManager(getContext());
        RecyclerViewAtPager2 recyclerViewAtPager2 = U().f6717b;
        LinearLayoutManager linearLayoutManager = this.linearLayoutManager;
        if (linearLayoutManager == null) {
            j.m("linearLayoutManager");
            throw null;
        }
        recyclerViewAtPager2.setLayoutManager(linearLayoutManager);
        Context contextRequireContext = requireContext();
        j.d(contextRequireContext, "requireContext()");
        this.adapter = new ExploreAdapter(contextRequireContext, this, this);
        RecyclerViewAtPager2 recyclerViewAtPager22 = U().f6717b;
        ExploreAdapter exploreAdapter = this.adapter;
        if (exploreAdapter == null) {
            j.m("adapter");
            throw null;
        }
        recyclerViewAtPager22.setAdapter(exploreAdapter);
        ExploreAdapter exploreAdapter2 = this.adapter;
        if (exploreAdapter2 == null) {
            j.m("adapter");
            throw null;
        }
        exploreAdapter2.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() { // from class: io.legado.app.ui.main.explore.ExploreFragment$initRecyclerView$1
            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeInserted(int positionStart, int itemCount) {
                super.onItemRangeInserted(positionStart, itemCount);
                if (positionStart == 0) {
                    ExploreFragment exploreFragment = this.a;
                    h<Object>[] hVarArr = ExploreFragment.f7443d;
                    exploreFragment.U().f6717b.scrollToPosition(0);
                }
            }
        });
        LiveData<List<String>> liveData = this.liveGroup;
        if (liveData != null) {
            liveData.removeObservers(getViewLifecycleOwner());
        }
        LiveData<List<String>> liveDataLiveExploreGroup = AppDatabaseKt.getAppDb().getBookSourceDao().liveExploreGroup();
        this.liveGroup = liveDataLiveExploreGroup;
        if (liveDataLiveExploreGroup != null) {
            liveDataLiveExploreGroup.observe(getViewLifecycleOwner(), new Observer() { // from class: e.a.a.g.h.h.m
                @Override // androidx.view.Observer
                public final void onChanged(Object obj) {
                    ExploreFragment exploreFragment = this.a;
                    List<String> list = (List) obj;
                    f.f0.h<Object>[] hVarArr = ExploreFragment.f7443d;
                    f.c0.c.j.e(exploreFragment, "this$0");
                    exploreFragment.groups.clear();
                    f.c0.c.j.d(list, "it");
                    ArrayList arrayList = new ArrayList(c.b.a.m.f.S0(list, 10));
                    for (String str : list) {
                        LinkedHashSet<String> linkedHashSet = exploreFragment.groups;
                        e.a.a.c.d dVar = e.a.a.c.d.a;
                        arrayList.add(Boolean.valueOf(c.b.a.m.f.T(linkedHashSet, c.b.a.m.f.o5(str, e.a.a.c.d.f5514h, 0, 2))));
                    }
                }
            });
        }
        LiveData<List<BookSource>> liveData2 = this.liveExplore;
        if (liveData2 != null) {
            liveData2.removeObservers(getViewLifecycleOwner());
        }
        LiveData<List<BookSource>> liveDataLiveExplore = AppDatabaseKt.getAppDb().getBookSourceDao().liveExplore();
        this.liveExplore = liveDataLiveExplore;
        if (liveDataLiveExplore == null) {
            return;
        }
        liveDataLiveExplore.observe(getViewLifecycleOwner(), new Observer() { // from class: e.a.a.g.h.h.n
            @Override // androidx.view.Observer
            public final void onChanged(Object obj) {
                ExploreFragment exploreFragment = this.a;
                List list = (List) obj;
                f.f0.h<Object>[] hVarArr = ExploreFragment.f7443d;
                f.c0.c.j.e(exploreFragment, "this$0");
                TextView textView = exploreFragment.U().f6719d;
                f.c0.c.j.d(textView, "binding.tvEmptyMsg");
                f.c0.c.j.d(list, "it");
                textView.setVisibility(list.isEmpty() ^ true ? 8 : 0);
                ExploreAdapter exploreAdapter3 = exploreFragment.adapter;
                if (exploreAdapter3 == null) {
                    f.c0.c.j.m("adapter");
                    throw null;
                }
                DiffUtil.DiffResult diffResultCalculateDiff = DiffUtil.calculateDiff(new ExploreDiffCallBack(new ArrayList(exploreAdapter3.items), list));
                f.c0.c.j.d(diffResultCalculateDiff, "calculateDiff(ExploreDiffCallBack(ArrayList(adapter.getItems()), it))");
                ExploreAdapter exploreAdapter4 = exploreFragment.adapter;
                if (exploreAdapter4 == null) {
                    f.c0.c.j.m("adapter");
                    throw null;
                }
                exploreAdapter4.x(list);
                ExploreAdapter exploreAdapter5 = exploreFragment.adapter;
                if (exploreAdapter5 != null) {
                    diffResultCalculateDiff.dispatchUpdatesTo(exploreAdapter5);
                } else {
                    f.c0.c.j.m("adapter");
                    throw null;
                }
            }
        });
    }

    public final FragmentExploreBinding U() {
        return (FragmentExploreBinding) this.binding.b(this, f7443d[1]);
    }

    @Override // io.legado.app.ui.main.explore.ExploreAdapter.a
    public void a(int pos) {
        RecyclerView.LayoutManager layoutManager = U().f6717b.getLayoutManager();
        Objects.requireNonNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(pos, 0);
    }

    @Override // io.legado.app.ui.main.explore.ExploreAdapter.a
    public void j(@NotNull BookSource source) {
        j.e(source, "source");
        ExploreViewModel exploreViewModel = (ExploreViewModel) this.viewModel.getValue();
        Objects.requireNonNull(exploreViewModel);
        j.e(source, "bookSource");
        BaseViewModel.a(exploreViewModel, null, null, new u(source, null), 3, null);
    }

    @Override // android.view.MenuItem.OnMenuItemClickListener
    public boolean onMenuItemClick(@Nullable MenuItem item) {
        Integer numValueOf = item == null ? null : Integer.valueOf(item.getItemId());
        if (numValueOf == null || numValueOf.intValue() != R.id.menu_search) {
            return true;
        }
        startActivity(new Intent(requireContext(), (Class<?>) SearchActivity.class));
        return true;
    }

    @Override // io.legado.app.base.VMBaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
    }
}

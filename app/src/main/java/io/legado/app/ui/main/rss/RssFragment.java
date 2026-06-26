package io.legado.app.ui.main.rss;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.SearchView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.view.LiveData;
import androidx.view.Observer;
import androidx.view.ViewModelStore;
import androidx.view.ViewModelStoreOwner;
import c.b.a.m.f;
import com.qq.e.comm.constants.Constants;
import com.umeng.analytics.pro.ai;
import f.c0.b.l;
import f.c0.c.j;
import f.c0.c.k;
import f.c0.c.q;
import f.c0.c.v;
import f.e;
import f.f0.h;
import io.legado.app.base.VMBaseFragment;
import io.legado.app.data.AppDatabaseKt;
import io.legado.app.data.dao.RssSourceDao;
import io.legado.app.data.entities.RssSource;
import io.legado.app.databinding.FragmentRssBinding;
import io.legado.app.lib.theme.ATH;
import io.legado.app.ui.main.rss.RssAdapter;
import io.legado.app.ui.main.rss.RssFragment;
import io.legado.app.ui.rss.article.RssSortActivity;
import io.legado.app.ui.rss.favorites.RssFavoritesActivity;
import io.legado.app.ui.rss.read.ReadRssActivity;
import io.legado.app.ui.rss.source.edit.RssSourceEditActivity;
import io.legado.app.ui.rss.source.manage.RssSourceActivity;
import io.legado.app.ui.rss.source.manage.RssSourceViewModel;
import io.legado.app.ui.widget.TitleBar;
import io.legado.app.ui.widget.recycler.RecyclerViewAtPager2;
import io.legado.app.utils.viewbindingdelegate.ViewBindingProperty;
import io.wenyuange.app.release.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mozilla.javascript.optimizer.OptRuntime;

/* JADX INFO: compiled from: RssFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0007¢\u0006\u0004\bC\u0010\u0014J!\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0019\u0010\u0018J\u0017\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u001a\u0010\u0018J\u0017\u0010\u001b\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u001b\u0010\u0018J\u0011\u0010\u001c\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u001b\u0010 \u001a\u00020\b2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0002¢\u0006\u0004\b \u0010!R\u0016\u0010$\u001a\u00020\"8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0019\u0010#R&\u0010)\u001a\u0012\u0012\u0004\u0012\u00020\u001e0%j\b\u0012\u0004\u0012\u00020\u001e`&8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b+\u0010,R$\u00102\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150/\u0018\u00010.8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u00101R$\u00104\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0/\u0018\u00010.8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u00101R\u0018\u00108\u001a\u0004\u0018\u0001058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00107R\u001d\u0010<\u001a\u00020\u00028T@\u0014X\u0094\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u00109\u001a\u0004\b:\u0010;R\u001d\u0010B\u001a\u00020=8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b>\u0010?\u001a\u0004\b@\u0010A¨\u0006D"}, d2 = {"Lio/legado/app/ui/main/rss/RssFragment;", "Lio/legado/app/base/VMBaseFragment;", "Lio/legado/app/ui/rss/source/manage/RssSourceViewModel;", "Lio/legado/app/ui/main/rss/RssAdapter$a;", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "Lf/v;", "R", "(Landroid/view/View;Landroid/os/Bundle;)V", "Landroid/view/Menu;", "menu", "P", "(Landroid/view/Menu;)V", "Landroid/view/MenuItem;", "item", "Q", "(Landroid/view/MenuItem;)V", "onPause", "()V", "Lio/legado/app/data/entities/RssSource;", "rssSource", OptRuntime.GeneratorState.resumptionPoint_TYPE, "(Lio/legado/app/data/entities/RssSource;)V", "g", "h", "d", ExifInterface.LONGITUDE_WEST, "()Lf/v;", "", "searchKey", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "(Ljava/lang/String;)V", "Landroidx/appcompat/widget/SearchView;", "Landroidx/appcompat/widget/SearchView;", "searchView", "Ljava/util/LinkedHashSet;", "Lkotlin/collections/LinkedHashSet;", "j", "Ljava/util/LinkedHashSet;", "groups", "Lio/legado/app/ui/main/rss/RssAdapter;", "f", "Lio/legado/app/ui/main/rss/RssAdapter;", "adapter", "Landroidx/lifecycle/LiveData;", "", ai.aA, "Landroidx/lifecycle/LiveData;", "liveRssData", "k", "liveGroup", "Landroid/view/SubMenu;", Constants.LANDSCAPE, "Landroid/view/SubMenu;", "groupsMenu", "Lf/e;", "getViewModel", "()Lio/legado/app/ui/rss/source/manage/RssSourceViewModel;", "viewModel", "Lio/legado/app/databinding/FragmentRssBinding;", "e", "Lio/legado/app/utils/viewbindingdelegate/ViewBindingProperty;", "U", "()Lio/legado/app/databinding/FragmentRssBinding;", "binding", "<init>", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class RssFragment extends VMBaseFragment<RssSourceViewModel> implements RssAdapter.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ h<Object>[] f7457d;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final ViewBindingProperty binding;

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    public RssAdapter adapter;

    /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
    public SearchView searchView;

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final e viewModel;

    /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public LiveData<List<RssSource>> liveRssData;

    /* JADX INFO: renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final LinkedHashSet<String> groups;

    /* JADX INFO: renamed from: k, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public LiveData<List<String>> liveGroup;

    /* JADX INFO: renamed from: l, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public SubMenu groupsMenu;

    /* JADX INFO: compiled from: FragmentViewBindings.kt */
    public static final class a extends k implements l<RssFragment, FragmentRssBinding> {
        public a() {
            super(1);
        }

        @Override // f.c0.b.l
        @NotNull
        public final FragmentRssBinding invoke(@NotNull RssFragment rssFragment) {
            j.e(rssFragment, "fragment");
            View viewRequireView = rssFragment.requireView();
            int i2 = R.id.recycler_view;
            RecyclerViewAtPager2 recyclerViewAtPager2 = (RecyclerViewAtPager2) viewRequireView.findViewById(R.id.recycler_view);
            if (recyclerViewAtPager2 != null) {
                i2 = R.id.title_bar;
                TitleBar titleBar = (TitleBar) viewRequireView.findViewById(R.id.title_bar);
                if (titleBar != null) {
                    i2 = R.id.tv_empty_msg;
                    TextView textView = (TextView) viewRequireView.findViewById(R.id.tv_empty_msg);
                    if (textView != null) {
                        return new FragmentRssBinding((ConstraintLayout) viewRequireView, recyclerViewAtPager2, titleBar, textView);
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
        q qVar = new q(v.a(RssFragment.class), "binding", "getBinding()Lio/legado/app/databinding/FragmentRssBinding;");
        Objects.requireNonNull(v.a);
        hVarArr[0] = qVar;
        f7457d = hVarArr;
    }

    public RssFragment() {
        super(R.layout.fragment_rss);
        this.binding = f.b6(this, new a());
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, v.a(RssSourceViewModel.class), new c(new b(this)), null);
        this.groups = new LinkedHashSet<>();
    }

    @Override // io.legado.app.ui.main.rss.RssAdapter.a
    public void I(@NotNull RssSource rssSource) {
        j.e(rssSource, "rssSource");
        if (!rssSource.getSingleUrl()) {
            Intent intent = new Intent(requireContext(), (Class<?>) RssSortActivity.class);
            intent.putExtra("url", rssSource.getSourceUrl());
            startActivity(intent);
        } else {
            if (f.h0.k.H(rssSource.getSourceUrl(), "http", true)) {
                Intent intent2 = new Intent(requireContext(), (Class<?>) ReadRssActivity.class);
                intent2.putExtra("title", rssSource.getSourceName());
                intent2.putExtra("origin", rssSource.getSourceUrl());
                startActivity(intent2);
                return;
            }
            Context context = getContext();
            if (context == null) {
                return;
            }
            f.i4(context, rssSource.getSourceUrl());
        }
    }

    @Override // io.legado.app.base.BaseFragment
    public void P(@NotNull Menu menu) {
        j.e(menu, "menu");
        N().inflate(R.menu.main_rss, menu);
        MenuItem menuItemFindItem = menu.findItem(R.id.menu_group);
        this.groupsMenu = menuItemFindItem == null ? null : menuItemFindItem.getSubMenu();
        W();
    }

    @Override // io.legado.app.base.BaseFragment
    public void Q(@NotNull MenuItem item) {
        j.e(item, "item");
        j.e(item, "item");
        switch (item.getItemId()) {
            case R.id.menu_rss_config /* 2131296868 */:
                startActivity(new Intent(requireContext(), (Class<?>) RssSourceActivity.class));
                return;
            case R.id.menu_rss_star /* 2131296869 */:
                startActivity(new Intent(requireContext(), (Class<?>) RssFavoritesActivity.class));
                return;
            default:
                if (item.getGroupId() == R.id.menu_group_text) {
                    SearchView searchView = this.searchView;
                    if (searchView != null) {
                        searchView.setQuery(item.getTitle(), true);
                        return;
                    } else {
                        j.m("searchView");
                        throw null;
                    }
                }
                return;
        }
    }

    @Override // io.legado.app.base.BaseFragment
    public void R(@NotNull View view, @Nullable Bundle savedInstanceState) {
        j.e(view, "view");
        View viewFindViewById = U().f6735c.findViewById(R.id.search_view);
        j.d(viewFindViewById, "binding.titleBar.findViewById(R.id.search_view)");
        this.searchView = (SearchView) viewFindViewById;
        T(U().f6735c.getToolbar());
        ATH ath = ATH.a;
        SearchView searchView = this.searchView;
        if (searchView == null) {
            j.m("searchView");
            throw null;
        }
        j.e(this, "<this>");
        Context contextRequireContext = requireContext();
        j.d(contextRequireContext, "requireContext()");
        j.e(this, "<this>");
        Context contextRequireContext2 = requireContext();
        j.d(contextRequireContext2, "requireContext()");
        ATH.h(ath, searchView, f.S2(contextRequireContext, f.u3(contextRequireContext2)), false, 4);
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
        searchView4.setQueryHint(getString(R.string.rss));
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
        searchView6.setOnQueryTextListener(new SearchView.OnQueryTextListener() { // from class: io.legado.app.ui.main.rss.RssFragment$initSearchView$1
            @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
            public boolean onQueryTextChange(@Nullable String newText) {
                RssFragment rssFragment = this.a;
                h<Object>[] hVarArr = RssFragment.f7457d;
                rssFragment.V(newText);
                return false;
            }

            @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
            public boolean onQueryTextSubmit(@Nullable String query) {
                return false;
            }
        });
        ath.b(U().f6734b);
        Context contextRequireContext3 = requireContext();
        j.d(contextRequireContext3, "requireContext()");
        this.adapter = new RssAdapter(contextRequireContext3, this);
        RecyclerViewAtPager2 recyclerViewAtPager2 = U().f6734b;
        RssAdapter rssAdapter = this.adapter;
        if (rssAdapter == null) {
            j.m("adapter");
            throw null;
        }
        recyclerViewAtPager2.setAdapter(rssAdapter);
        RssAdapter rssAdapter2 = this.adapter;
        if (rssAdapter2 == null) {
            j.m("adapter");
            throw null;
        }
        rssAdapter2.e(new e.a.a.g.h.j.h(this));
        LiveData<List<String>> liveData = this.liveGroup;
        if (liveData != null) {
            liveData.removeObservers(getViewLifecycleOwner());
        }
        LiveData<List<String>> liveDataLiveGroup = AppDatabaseKt.getAppDb().getRssSourceDao().liveGroup();
        this.liveGroup = liveDataLiveGroup;
        if (liveDataLiveGroup != null) {
            liveDataLiveGroup.observe(getViewLifecycleOwner(), new Observer() { // from class: e.a.a.g.h.j.c
                @Override // androidx.view.Observer
                public final void onChanged(Object obj) {
                    RssFragment rssFragment = this.a;
                    List<String> list = (List) obj;
                    f.f0.h<Object>[] hVarArr = RssFragment.f7457d;
                    j.e(rssFragment, "this$0");
                    rssFragment.groups.clear();
                    j.d(list, "it");
                    ArrayList arrayList = new ArrayList(c.b.a.m.f.S0(list, 10));
                    for (String str : list) {
                        LinkedHashSet<String> linkedHashSet = rssFragment.groups;
                        e.a.a.c.d dVar = e.a.a.c.d.a;
                        arrayList.add(Boolean.valueOf(c.b.a.m.f.T(linkedHashSet, c.b.a.m.f.o5(str, e.a.a.c.d.f5514h, 0, 2))));
                    }
                    rssFragment.W();
                }
            });
        }
        V(null);
    }

    public final FragmentRssBinding U() {
        return (FragmentRssBinding) this.binding.b(this, f7457d[0]);
    }

    public final void V(String searchKey) {
        LiveData<List<RssSource>> liveDataLiveEnabled;
        LiveData<List<RssSource>> liveData = this.liveRssData;
        if (liveData != null) {
            liveData.removeObservers(this);
        }
        if (searchKey == null || searchKey.length() == 0) {
            liveDataLiveEnabled = AppDatabaseKt.getAppDb().getRssSourceDao().liveEnabled();
        } else if (f.h0.k.K(searchKey, "group:", false, 2)) {
            String strM = f.h0.k.M(searchKey, "group:", null, 2);
            liveDataLiveEnabled = AppDatabaseKt.getAppDb().getRssSourceDao().liveEnabledByGroup('%' + strM + '%');
        } else {
            RssSourceDao rssSourceDao = AppDatabaseKt.getAppDb().getRssSourceDao();
            StringBuilder sb = new StringBuilder();
            sb.append('%');
            sb.append((Object) searchKey);
            sb.append('%');
            liveDataLiveEnabled = rssSourceDao.liveEnabled(sb.toString());
        }
        liveDataLiveEnabled.observe(getViewLifecycleOwner(), new Observer() { // from class: e.a.a.g.h.j.d
            @Override // androidx.view.Observer
            public final void onChanged(Object obj) {
                RssFragment rssFragment = this.a;
                List list = (List) obj;
                f.f0.h<Object>[] hVarArr = RssFragment.f7457d;
                j.e(rssFragment, "this$0");
                RssAdapter rssAdapter = rssFragment.adapter;
                if (rssAdapter != null) {
                    rssAdapter.x(list);
                } else {
                    j.m("adapter");
                    throw null;
                }
            }
        });
        this.liveRssData = liveDataLiveEnabled;
    }

    public final f.v W() {
        SubMenu subMenu = this.groupsMenu;
        if (subMenu == null) {
            return null;
        }
        subMenu.removeGroup(R.id.menu_group_text);
        Iterator it = f.x.e.B(this.groups, e.a.a.g.h.j.e.a).iterator();
        while (it.hasNext()) {
            subMenu.add(R.id.menu_group_text, 0, 0, (String) it.next());
        }
        return f.v.a;
    }

    @Override // io.legado.app.ui.main.rss.RssAdapter.a
    public void d(@NotNull RssSource rssSource) {
        j.e(rssSource, "rssSource");
        ((RssSourceViewModel) this.viewModel.getValue()).f(rssSource);
    }

    @Override // io.legado.app.ui.main.rss.RssAdapter.a
    public void g(@NotNull RssSource rssSource) {
        j.e(rssSource, "rssSource");
        ((RssSourceViewModel) this.viewModel.getValue()).h(rssSource);
    }

    @Override // io.legado.app.ui.main.rss.RssAdapter.a
    public void h(@NotNull RssSource rssSource) {
        j.e(rssSource, "rssSource");
        Intent intent = new Intent(requireContext(), (Class<?>) RssSourceEditActivity.class);
        intent.putExtra("data", rssSource.getSourceUrl());
        startActivity(intent);
    }

    @Override // io.legado.app.base.VMBaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        SearchView searchView = this.searchView;
        if (searchView != null) {
            searchView.clearFocus();
        } else {
            j.m("searchView");
            throw null;
        }
    }
}

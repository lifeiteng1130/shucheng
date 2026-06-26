package io.legado.app.ui.rss.article;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.activity.ComponentActivity;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.Fragment;
import androidx.view.Observer;
import androidx.view.ViewModelLazy;
import androidx.view.ViewModelProvider;
import androidx.view.ViewModelStore;
import androidx.viewbinding.ViewBinding;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import c.b.a.m.f;
import c.e.a.b.z.d;
import com.google.android.material.tabs.TabLayout;
import com.qq.e.comm.constants.Constants;
import com.umeng.analytics.pro.ai;
import e.a.a.g.k.a.s;
import e.a.a.g.k.a.t;
import f.c0.c.j;
import f.c0.c.k;
import f.e;
import f.v;
import io.legado.app.base.BaseViewModel;
import io.legado.app.base.VMBaseActivity;
import io.legado.app.data.entities.RssSource;
import io.legado.app.databinding.ActivityRssArtivlesBinding;
import io.legado.app.ui.rss.article.RssArticlesFragment;
import io.legado.app.ui.rss.article.RssSortActivity;
import io.legado.app.ui.rss.article.RssSortViewModel;
import io.legado.app.ui.rss.source.edit.RssSourceEditActivity;
import io.legado.app.ui.widget.TitleBar;
import io.wenyuange.app.release.R;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Objects;
import java.util.Set;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: RssSortActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u00011B\u0007¢\u0006\u0004\b0\u0010\u0013J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0012\u0010\u0013R2\u0010\u001a\u001a\u001e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u0014j\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0016`\u00178\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001d\u0010\u001f\u001a\u00020\u00038T@\u0014X\u0094\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR2\u0010%\u001a\u001e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020!0 j\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020!`\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$R$\u0010+\u001a\u0010\u0012\f\u0012\n (*\u0004\u0018\u00010'0'0&8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u001a\u0010/\u001a\u00060,R\u00020\u00008\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b-\u0010.¨\u00062"}, d2 = {"Lio/legado/app/ui/rss/article/RssSortActivity;", "Lio/legado/app/base/VMBaseActivity;", "Lio/legado/app/databinding/ActivityRssArtivlesBinding;", "Lio/legado/app/ui/rss/article/RssSortViewModel;", "Landroid/os/Bundle;", "savedInstanceState", "Lf/v;", "O0", "(Landroid/os/Bundle;)V", "Landroid/view/Menu;", "menu", "", "P0", "(Landroid/view/Menu;)Z", "Landroid/view/MenuItem;", "item", "Q0", "(Landroid/view/MenuItem;)Z", "U0", "()V", "Ljava/util/HashMap;", "", "Landroidx/fragment/app/Fragment;", "Lkotlin/collections/HashMap;", "k", "Ljava/util/HashMap;", "fragmentMap", "h", "Lf/e;", "T0", "()Lio/legado/app/ui/rss/article/RssSortViewModel;", "viewModel", "Ljava/util/LinkedHashMap;", "", "Lkotlin/collections/LinkedHashMap;", ai.aA, "Ljava/util/LinkedHashMap;", "sorts", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", Constants.LANDSCAPE, "Landroidx/activity/result/ActivityResultLauncher;", "upSourceResult", "Lio/legado/app/ui/rss/article/RssSortActivity$a;", "j", "Lio/legado/app/ui/rss/article/RssSortActivity$a;", "adapter", "<init>", ai.at, "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class RssSortActivity extends VMBaseActivity<ActivityRssArtivlesBinding, RssSortViewModel> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f7505g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final e viewModel;

    /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public LinkedHashMap<String, String> sorts;

    /* JADX INFO: renamed from: j, reason: collision with root package name and from kotlin metadata */
    public a adapter;

    /* JADX INFO: renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final HashMap<Long, Fragment> fragmentMap;

    /* JADX INFO: renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final ActivityResultLauncher<Intent> upSourceResult;

    /* JADX INFO: compiled from: RssSortActivity.kt */
    public final class a extends FragmentStateAdapter {
        public final /* synthetic */ RssSortActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(RssSortActivity rssSortActivity) {
            super(rssSortActivity);
            j.e(rssSortActivity, "this$0");
            this.a = rssSortActivity;
        }

        @Override // androidx.viewpager2.adapter.FragmentStateAdapter
        public boolean containsItem(long j2) {
            return this.a.fragmentMap.containsKey(Long.valueOf(j2));
        }

        @Override // androidx.viewpager2.adapter.FragmentStateAdapter
        @NotNull
        public Fragment createFragment(int i2) {
            long itemId = getItemId(i2);
            RssArticlesFragment.Companion companion = RssArticlesFragment.INSTANCE;
            Set<String> setKeySet = this.a.sorts.keySet();
            j.d(setKeySet, "sorts.keys");
            Object objH = f.x.e.h(setKeySet, i2);
            j.d(objH, "sorts.keys.elementAt(position)");
            String str = (String) objH;
            Collection<String> collectionValues = this.a.sorts.values();
            j.d(collectionValues, "sorts.values");
            Object objH2 = f.x.e.h(collectionValues, i2);
            j.d(objH2, "sorts.values.elementAt(position)");
            String str2 = (String) objH2;
            Objects.requireNonNull(companion);
            j.e(str, "sortName");
            j.e(str2, "sortUrl");
            RssArticlesFragment rssArticlesFragment = new RssArticlesFragment();
            Bundle bundle = new Bundle();
            bundle.putString("sortName", str);
            bundle.putString("sortUrl", str2);
            rssArticlesFragment.setArguments(bundle);
            this.a.fragmentMap.put(Long.valueOf(itemId), rssArticlesFragment);
            return rssArticlesFragment;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.a.sorts.size();
        }

        @Override // androidx.viewpager2.adapter.FragmentStateAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
        public long getItemId(int i2) {
            RssSource rssSource = this.a.T0().rssSource;
            return ((long) ((rssSource == null ? 0 : rssSource.getArticleStyle()) * 100)) + super.getItemId(i2);
        }
    }

    /* JADX INFO: compiled from: RssSortActivity.kt */
    public static final class b extends k implements f.c0.b.a<v> {
        public b() {
            super(0);
        }

        @Override // f.c0.b.a
        public /* bridge */ /* synthetic */ v invoke() {
            invoke2();
            return v.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            RssSortActivity rssSortActivity = RssSortActivity.this;
            int i2 = RssSortActivity.f7505g;
            rssSortActivity.U0();
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
            j.d(viewModelStore, "viewModelStore");
            return viewModelStore;
        }
    }

    public RssSortActivity() {
        super(false, null, null, false, false, 31);
        this.viewModel = new ViewModelLazy(f.c0.c.v.a(RssSortViewModel.class), new d(this), new c(this));
        this.sorts = new LinkedHashMap<>();
        this.fragmentMap = new HashMap<>();
        ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: e.a.a.g.k.a.i
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                RssSortActivity rssSortActivity = this.a;
                int i2 = RssSortActivity.f7505g;
                f.c0.c.j.e(rssSortActivity, "this$0");
                if (((ActivityResult) obj).getResultCode() == -1) {
                    RssSortViewModel rssSortViewModelT0 = rssSortActivity.T0();
                    Intent intent = rssSortActivity.getIntent();
                    f.c0.c.j.d(intent, "intent");
                    rssSortViewModelT0.e(intent, new r(rssSortActivity));
                }
            }
        });
        j.d(activityResultLauncherRegisterForActivityResult, "registerForActivityResult(\n        ActivityResultContracts.StartActivityForResult()\n    ) {\n        if (it.resultCode == RESULT_OK) {\n            viewModel.initData(intent) {\n                upFragments()\n            }\n        }\n    }");
        this.upSourceResult = activityResultLauncherRegisterForActivityResult;
    }

    @Override // io.legado.app.base.BaseActivity
    public ViewBinding L0() {
        View viewInflate = getLayoutInflater().inflate(R.layout.activity_rss_artivles, (ViewGroup) null, false);
        int i2 = R.id.tab_layout;
        TabLayout tabLayout = (TabLayout) viewInflate.findViewById(R.id.tab_layout);
        if (tabLayout != null) {
            i2 = R.id.title_bar;
            TitleBar titleBar = (TitleBar) viewInflate.findViewById(R.id.title_bar);
            if (titleBar != null) {
                i2 = R.id.view_pager;
                ViewPager2 viewPager2 = (ViewPager2) viewInflate.findViewById(R.id.view_pager);
                if (viewPager2 != null) {
                    ActivityRssArtivlesBinding activityRssArtivlesBinding = new ActivityRssArtivlesBinding((LinearLayout) viewInflate, tabLayout, titleBar, viewPager2);
                    j.d(activityRssArtivlesBinding, "inflate(layoutInflater)");
                    return activityRssArtivlesBinding;
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i2)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.legado.app.base.BaseActivity
    public void O0(@Nullable Bundle savedInstanceState) {
        this.adapter = new a(this);
        ViewPager2 viewPager2 = ((ActivityRssArtivlesBinding) K0()).f6540d;
        a aVar = this.adapter;
        if (aVar == null) {
            j.m("adapter");
            throw null;
        }
        viewPager2.setAdapter(aVar);
        new c.e.a.b.z.d(((ActivityRssArtivlesBinding) K0()).f6538b, ((ActivityRssArtivlesBinding) K0()).f6540d, new d.b() { // from class: e.a.a.g.k.a.j
            @Override // c.e.a.b.z.d.b
            public final void a(TabLayout.g gVar, int i2) {
                RssSortActivity rssSortActivity = this.a;
                int i3 = RssSortActivity.f7505g;
                f.c0.c.j.e(rssSortActivity, "this$0");
                f.c0.c.j.e(gVar, "tab");
                Set<String> setKeySet = rssSortActivity.sorts.keySet();
                f.c0.c.j.d(setKeySet, "sorts.keys");
                gVar.c((CharSequence) f.x.e.h(setKeySet, i2));
            }
        }).a();
        T0().titleLiveData.observe(this, new Observer() { // from class: e.a.a.g.k.a.h
            /* JADX WARN: Multi-variable type inference failed */
            @Override // androidx.view.Observer
            public final void onChanged(Object obj) {
                RssSortActivity rssSortActivity = this.a;
                int i2 = RssSortActivity.f7505g;
                f.c0.c.j.e(rssSortActivity, "this$0");
                ((ActivityRssArtivlesBinding) rssSortActivity.K0()).f6539c.setTitle((String) obj);
            }
        });
        RssSortViewModel rssSortViewModelT0 = T0();
        Intent intent = getIntent();
        j.d(intent, "intent");
        rssSortViewModelT0.e(intent, new b());
    }

    @Override // io.legado.app.base.BaseActivity
    public boolean P0(@NotNull Menu menu) {
        j.e(menu, "menu");
        getMenuInflater().inflate(R.menu.rss_articles, menu);
        return super.P0(menu);
    }

    @Override // io.legado.app.base.BaseActivity
    public boolean Q0(@NotNull MenuItem item) {
        String sourceUrl;
        j.e(item, "item");
        int itemId = item.getItemId();
        if (itemId != R.id.menu_clear) {
            if (itemId == R.id.menu_edit_source) {
                RssSource rssSource = T0().rssSource;
                if (rssSource != null && (sourceUrl = rssSource.getSourceUrl()) != null) {
                    this.upSourceResult.launch(new Intent(this, (Class<?>) RssSourceEditActivity.class).putExtra("data", sourceUrl));
                }
            } else if (itemId == R.id.menu_switch_layout) {
                RssSortViewModel rssSortViewModelT0 = T0();
                RssSource rssSource2 = rssSortViewModelT0.rssSource;
                if (rssSource2 != null) {
                    if (rssSource2.getArticleStyle() < 2) {
                        rssSource2.setArticleStyle(rssSource2.getArticleStyle() + 1);
                    } else {
                        rssSource2.setArticleStyle(0);
                    }
                    BaseViewModel.a(rssSortViewModelT0, null, null, new e.a.a.g.k.a.v(rssSource2, null), 3, null);
                }
                U0();
            }
        } else if (T0().url != null) {
            RssSortViewModel rssSortViewModelT02 = T0();
            Objects.requireNonNull(rssSortViewModelT02);
            BaseViewModel.a(rssSortViewModelT02, null, null, new s(rssSortViewModelT02, null), 3, null).d(null, new t(null));
        }
        return super.Q0(item);
    }

    @NotNull
    public RssSortViewModel T0() {
        return (RssSortViewModel) this.viewModel.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void U0() {
        LinkedHashMap<String, String> linkedHashMapSortUrls;
        RssSource rssSource = T0().rssSource;
        if (rssSource != null && (linkedHashMapSortUrls = rssSource.sortUrls()) != null) {
            this.sorts = linkedHashMapSortUrls;
        }
        if (this.sorts.size() == 1) {
            TabLayout tabLayout = ((ActivityRssArtivlesBinding) K0()).f6538b;
            j.d(tabLayout, "binding.tabLayout");
            f.e3(tabLayout);
        } else {
            TabLayout tabLayout2 = ((ActivityRssArtivlesBinding) K0()).f6538b;
            j.d(tabLayout2, "binding.tabLayout");
            f.c6(tabLayout2);
        }
        a aVar = this.adapter;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
        } else {
            j.m("adapter");
            throw null;
        }
    }
}

package io.legado.app.ui.book.toc;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.activity.ComponentActivity;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.media2.session.MediaConstants;
import androidx.view.ViewModelLazy;
import androidx.view.ViewModelProvider;
import androidx.view.ViewModelStore;
import androidx.viewbinding.ViewBinding;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import c.b.a.m.f;
import c.e.a.b.z.d;
import com.google.android.material.tabs.TabLayout;
import com.umeng.analytics.pro.ai;
import e.a.a.g.d.m.r;
import e.a.a.g.d.m.s;
import e.a.a.g.d.m.t;
import f.c0.b.l;
import f.c0.c.j;
import f.c0.c.k;
import f.e;
import f.v;
import io.legado.app.base.BaseViewModel;
import io.legado.app.base.VMBaseActivity;
import io.legado.app.data.entities.Book;
import io.legado.app.databinding.ActivityChapterListBinding;
import io.legado.app.lib.theme.ATH;
import io.legado.app.ui.book.toc.TocActivity;
import io.legado.app.ui.book.toc.TocViewModel;
import io.legado.app.ui.widget.TitleBar;
import io.wenyuange.app.release.R;
import java.util.Objects;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: TocActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\"B\u0007¢\u0006\u0004\b!\u0010\u0013J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u001d\u0010\u001c\u001a\u00020\u00038T@\u0014X\u0094\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f¨\u0006#"}, d2 = {"Lio/legado/app/ui/book/toc/TocActivity;", "Lio/legado/app/base/VMBaseActivity;", "Lio/legado/app/databinding/ActivityChapterListBinding;", "Lio/legado/app/ui/book/toc/TocViewModel;", "Landroid/os/Bundle;", "savedInstanceState", "Lf/v;", "O0", "(Landroid/os/Bundle;)V", "Landroid/view/Menu;", "menu", "", "P0", "(Landroid/view/Menu;)Z", "Landroid/view/MenuItem;", "item", "Q0", "(Landroid/view/MenuItem;)Z", "onBackPressed", "()V", "Landroidx/appcompat/widget/SearchView;", "j", "Landroidx/appcompat/widget/SearchView;", "searchView", "h", "Lf/e;", "T0", "()Lio/legado/app/ui/book/toc/TocViewModel;", "viewModel", "Lcom/google/android/material/tabs/TabLayout;", ai.aA, "Lcom/google/android/material/tabs/TabLayout;", "tabLayout", "<init>", ai.at, "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class TocActivity extends VMBaseActivity<ActivityChapterListBinding, TocViewModel> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f7337g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final e viewModel;

    /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
    public TabLayout tabLayout;

    /* JADX INFO: renamed from: j, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public SearchView searchView;

    /* JADX INFO: compiled from: TocActivity.kt */
    public final class a extends FragmentStateAdapter {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(TocActivity tocActivity) {
            super(tocActivity);
            j.e(tocActivity, "this$0");
        }

        @Override // androidx.viewpager2.adapter.FragmentStateAdapter
        @NotNull
        public Fragment createFragment(int i2) {
            return i2 == 0 ? new ChapterListFragment() : new BookmarkFragment();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return 2;
        }
    }

    /* JADX INFO: compiled from: TocActivity.kt */
    public static final class b extends k implements l<Book, v> {
        public b() {
            super(1);
        }

        @Override // f.c0.b.l
        public /* bridge */ /* synthetic */ v invoke(Book book) {
            invoke2(book);
            return v.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull Book book) {
            j.e(book, "it");
            TocActivity tocActivity = TocActivity.this;
            Intent intent = new Intent();
            intent.putExtra("index", book.getDurChapterIndex());
            intent.putExtra("chapterPos", book.getDurChapterPos());
            tocActivity.setResult(-1, intent);
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

    public TocActivity() {
        super(false, null, null, false, false, 31);
        this.viewModel = new ViewModelLazy(f.c0.c.v.a(TocViewModel.class), new d(this), new c(this));
    }

    @Override // io.legado.app.base.BaseActivity
    public ViewBinding L0() {
        View viewInflate = getLayoutInflater().inflate(R.layout.activity_chapter_list, (ViewGroup) null, false);
        int i2 = R.id.title_bar;
        TitleBar titleBar = (TitleBar) viewInflate.findViewById(R.id.title_bar);
        if (titleBar != null) {
            i2 = R.id.view_pager;
            ViewPager2 viewPager2 = (ViewPager2) viewInflate.findViewById(R.id.view_pager);
            if (viewPager2 != null) {
                ActivityChapterListBinding activityChapterListBinding = new ActivityChapterListBinding((LinearLayout) viewInflate, titleBar, viewPager2);
                j.d(activityChapterListBinding, "inflate(layoutInflater)");
                return activityChapterListBinding;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i2)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.legado.app.base.BaseActivity
    public void O0(@Nullable Bundle savedInstanceState) {
        View viewFindViewById = ((ActivityChapterListBinding) K0()).f6507b.findViewById(R.id.tab_layout);
        j.d(viewFindViewById, "binding.titleBar.findViewById(R.id.tab_layout)");
        TabLayout tabLayout = (TabLayout) viewFindViewById;
        this.tabLayout = tabLayout;
        if (tabLayout == null) {
            j.m("tabLayout");
            throw null;
        }
        tabLayout.setTabIndicatorFullWidth(false);
        TabLayout tabLayout2 = this.tabLayout;
        if (tabLayout2 == null) {
            j.m("tabLayout");
            throw null;
        }
        tabLayout2.setSelectedTabIndicatorColor(f.M1(this));
        ((ActivityChapterListBinding) K0()).f6508c.setAdapter(new a(this));
        TabLayout tabLayout3 = this.tabLayout;
        if (tabLayout3 == null) {
            j.m("tabLayout");
            throw null;
        }
        new c.e.a.b.z.d(tabLayout3, ((ActivityChapterListBinding) K0()).f6508c, new d.b() { // from class: e.a.a.g.d.m.n
            @Override // c.e.a.b.z.d.b
            public final void a(TabLayout.g gVar, int i2) {
                int i3 = TocActivity.f7337g;
                f.c0.c.j.e(gVar, "tab");
                if (i2 == 0) {
                    gVar.b(R.string.chapter_list);
                } else {
                    gVar.b(R.string.bookmark);
                }
            }
        }).a();
        String stringExtra = getIntent().getStringExtra("bookUrl");
        if (stringExtra == null) {
            return;
        }
        TocViewModel tocViewModelT0 = T0();
        Objects.requireNonNull(tocViewModelT0);
        j.e(stringExtra, "bookUrl");
        tocViewModelT0.bookUrl = stringExtra;
        BaseViewModel.a(tocViewModelT0, null, null, new r(stringExtra, tocViewModelT0, null), 3, null);
    }

    @Override // io.legado.app.base.BaseActivity
    public boolean P0(@NotNull Menu menu) {
        j.e(menu, "menu");
        getMenuInflater().inflate(R.menu.book_toc, menu);
        View actionView = menu.findItem(R.id.menu_search).getActionView();
        Objects.requireNonNull(actionView, "null cannot be cast to non-null type androidx.appcompat.widget.SearchView");
        SearchView searchView = (SearchView) actionView;
        this.searchView = searchView;
        ATH ath = ATH.a;
        j.c(searchView);
        ATH.h(ath, searchView, f.R2(this), false, 4);
        SearchView searchView2 = this.searchView;
        if (searchView2 != null) {
            searchView2.setMaxWidth(getResources().getDisplayMetrics().widthPixels);
        }
        SearchView searchView3 = this.searchView;
        if (searchView3 != null) {
            searchView3.onActionViewCollapsed();
        }
        SearchView searchView4 = this.searchView;
        if (searchView4 != null) {
            searchView4.setOnCloseListener(new SearchView.OnCloseListener() { // from class: e.a.a.g.d.m.m
                @Override // androidx.appcompat.widget.SearchView.OnCloseListener
                public final boolean onClose() {
                    TocActivity tocActivity = this.a;
                    int i2 = TocActivity.f7337g;
                    f.c0.c.j.e(tocActivity, "this$0");
                    TabLayout tabLayout = tocActivity.tabLayout;
                    if (tabLayout != null) {
                        c.b.a.m.f.c6(tabLayout);
                        return false;
                    }
                    f.c0.c.j.m("tabLayout");
                    throw null;
                }
            });
        }
        SearchView searchView5 = this.searchView;
        if (searchView5 != null) {
            searchView5.setOnSearchClickListener(new View.OnClickListener() { // from class: e.a.a.g.d.m.l
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TocActivity tocActivity = this.a;
                    int i2 = TocActivity.f7337g;
                    f.c0.c.j.e(tocActivity, "this$0");
                    TabLayout tabLayout = tocActivity.tabLayout;
                    if (tabLayout != null) {
                        c.b.a.m.f.e3(tabLayout);
                    } else {
                        f.c0.c.j.m("tabLayout");
                        throw null;
                    }
                }
            });
        }
        SearchView searchView6 = this.searchView;
        if (searchView6 != null) {
            searchView6.setOnQueryTextListener(new SearchView.OnQueryTextListener() { // from class: io.legado.app.ui.book.toc.TocActivity$onCompatCreateOptionsMenu$3
                @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
                public boolean onQueryTextChange(@NotNull String newText) {
                    j.e(newText, "newText");
                    TabLayout tabLayout = this.a.tabLayout;
                    if (tabLayout == null) {
                        j.m("tabLayout");
                        throw null;
                    }
                    if (tabLayout.getSelectedTabPosition() == 1) {
                        TocViewModel.a aVar = this.a.T0().bookMarkCallBack;
                        if (aVar == null) {
                            return false;
                        }
                        aVar.l(newText);
                        return false;
                    }
                    TocViewModel.b bVar = this.a.T0().chapterCallBack;
                    if (bVar == null) {
                        return false;
                    }
                    bVar.z(newText);
                    return false;
                }

                @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
                public boolean onQueryTextSubmit(@NotNull String query) {
                    j.e(query, MediaConstants.MEDIA_URI_QUERY_QUERY);
                    return false;
                }
            });
        }
        return super.P0(menu);
    }

    @Override // io.legado.app.base.BaseActivity
    public boolean Q0(@NotNull MenuItem item) {
        j.e(item, "item");
        if (item.getItemId() == R.id.menu_reverse_toc) {
            TocViewModel tocViewModelT0 = T0();
            b bVar = new b();
            Objects.requireNonNull(tocViewModelT0);
            j.e(bVar, "success");
            BaseViewModel.a(tocViewModelT0, null, null, new s(tocViewModelT0, null), 3, null).d(null, new t(bVar, null));
        }
        return super.Q0(item);
    }

    @NotNull
    public TocViewModel T0() {
        return (TocViewModel) this.viewModel.getValue();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        TabLayout tabLayout = this.tabLayout;
        if (tabLayout == null) {
            j.m("tabLayout");
            throw null;
        }
        if (!(tabLayout.getVisibility() == 8)) {
            super.onBackPressed();
            return;
        }
        SearchView searchView = this.searchView;
        if (searchView != null) {
            searchView.onActionViewCollapsed();
        }
        TabLayout tabLayout2 = this.tabLayout;
        if (tabLayout2 != null) {
            f.c6(tabLayout2);
        } else {
            j.m("tabLayout");
            throw null;
        }
    }
}

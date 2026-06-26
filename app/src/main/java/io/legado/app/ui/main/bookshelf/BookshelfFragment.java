package io.legado.app.ui.main.bookshelf;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.widget.SearchView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.media2.session.MediaConstants;
import androidx.view.LiveData;
import androidx.view.Observer;
import androidx.view.ViewModelProvider;
import androidx.view.ViewModelStore;
import androidx.view.ViewModelStoreOwner;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import c.e.a.b.z.d;
import com.google.android.material.tabs.TabLayout;
import com.qq.e.comm.constants.Constants;
import com.umeng.analytics.pro.ai;
import e.a.a.e.a.i;
import e.a.a.h.m;
import f.c0.b.l;
import f.c0.c.j;
import f.c0.c.k;
import f.c0.c.q;
import f.f0.h;
import f.v;
import io.legado.app.base.BaseViewModel;
import io.legado.app.base.VMBaseFragment;
import io.legado.app.data.AppDatabaseKt;
import io.legado.app.data.entities.Book;
import io.legado.app.data.entities.BookGroup;
import io.legado.app.databinding.FragmentBookshelfBinding;
import io.legado.app.lib.theme.ATH;
import io.legado.app.ui.book.arrange.ArrangeBookActivity;
import io.legado.app.ui.book.cache.CacheActivity;
import io.legado.app.ui.book.group.GroupManageDialog;
import io.legado.app.ui.book.local.ImportBookActivity;
import io.legado.app.ui.book.search.SearchActivity;
import io.legado.app.ui.document.FilePicker;
import io.legado.app.ui.main.MainViewModel;
import io.legado.app.ui.main.bookshelf.BookshelfFragment;
import io.legado.app.ui.main.bookshelf.BookshelfViewModel;
import io.legado.app.ui.main.bookshelf.books.BaseBooksAdapter;
import io.legado.app.ui.main.bookshelf.books.BooksFragment;
import io.legado.app.ui.widget.TitleBar;
import io.legado.app.utils.viewbindingdelegate.ViewBindingProperty;
import io.wenyuange.app.release.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: BookshelfFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¦\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0004:\u0001UB\u0007¢\u0006\u0004\bT\u0010\"J!\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0019\u0010\u001a\u001a\u00020\u00162\b\u0010\u0019\u001a\u0004\u0018\u00010\u0014H\u0016¢\u0006\u0004\b\u001a\u0010\u0018J\u0017\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\u001f\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001f\u0010\u001eJ\u0017\u0010 \u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b \u0010\u001eJ\u000f\u0010!\u001a\u00020\tH\u0002¢\u0006\u0004\b!\u0010\"R\u001c\u0010'\u001a\b\u0012\u0004\u0012\u00020$0#8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u001d\u0010-\u001a\u00020(8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u00104\u001a\u00020$8B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b2\u00103R2\u0010;\u001a\u001e\u0012\u0004\u0012\u000206\u0012\u0004\u0012\u00020705j\u000e\u0012\u0004\u0012\u000206\u0012\u0004\u0012\u000207`88\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b9\u0010:R\u001d\u0010@\u001a\u00020\u00028T@\u0014X\u0094\u0084\u0002¢\u0006\f\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?R$\u0010E\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0B\u0018\u00010A8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bC\u0010DR\u001d\u0010J\u001a\u00020F8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bG\u0010=\u001a\u0004\bH\u0010IR$\u0010O\u001a\u0010\u0012\f\u0012\n M*\u0004\u0018\u00010L0L0K8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010NR\u0016\u0010S\u001a\u00020P8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bQ\u0010R¨\u0006V"}, d2 = {"Lio/legado/app/ui/main/bookshelf/BookshelfFragment;", "Lio/legado/app/base/VMBaseFragment;", "Lio/legado/app/ui/main/bookshelf/BookshelfViewModel;", "Lcom/google/android/material/tabs/TabLayout$d;", "Landroidx/appcompat/widget/SearchView$OnQueryTextListener;", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "Lf/v;", "R", "(Landroid/view/View;Landroid/os/Bundle;)V", "Landroid/view/Menu;", "menu", "P", "(Landroid/view/Menu;)V", "Landroid/view/MenuItem;", "item", "Q", "(Landroid/view/MenuItem;)V", "", MediaConstants.MEDIA_URI_QUERY_QUERY, "", "onQueryTextSubmit", "(Ljava/lang/String;)Z", "newText", "onQueryTextChange", "Lcom/google/android/material/tabs/TabLayout$g;", "tab", "m", "(Lcom/google/android/material/tabs/TabLayout$g;)V", "K", "x", "X", "()V", "", "Lio/legado/app/data/entities/BookGroup;", "k", "Ljava/util/List;", "bookGroups", "Lio/legado/app/databinding/FragmentBookshelfBinding;", "e", "Lio/legado/app/utils/viewbindingdelegate/ViewBindingProperty;", "U", "()Lio/legado/app/databinding/FragmentBookshelfBinding;", "binding", "Lcom/google/android/material/tabs/TabLayout;", ai.aA, "Lcom/google/android/material/tabs/TabLayout;", "tabLayout", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "()Lio/legado/app/data/entities/BookGroup;", "selectedGroup", "Ljava/util/HashMap;", "", "Lio/legado/app/ui/main/bookshelf/books/BooksFragment;", "Lkotlin/collections/HashMap;", Constants.LANDSCAPE, "Ljava/util/HashMap;", "fragmentMap", "f", "Lf/e;", ExifInterface.LONGITUDE_WEST, "()Lio/legado/app/ui/main/bookshelf/BookshelfViewModel;", "viewModel", "Landroidx/lifecycle/LiveData;", "", "j", "Landroidx/lifecycle/LiveData;", "bookGroupLiveData", "Lio/legado/app/ui/main/MainViewModel;", "g", "getActivityViewModel", "()Lio/legado/app/ui/main/MainViewModel;", "activityViewModel", "Landroidx/activity/result/ActivityResultLauncher;", "Le/a/a/g/f/d;", "kotlin.jvm.PlatformType", "Landroidx/activity/result/ActivityResultLauncher;", "importBookshelf", "Landroidx/viewpager2/adapter/FragmentStateAdapter;", "h", "Landroidx/viewpager2/adapter/FragmentStateAdapter;", "adapter", "<init>", ai.at, "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class BookshelfFragment extends VMBaseFragment<BookshelfViewModel> implements TabLayout.d, SearchView.OnQueryTextListener {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ h<Object>[] f7403d;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final ViewBindingProperty binding;

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final f.e viewModel;

    /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final f.e activityViewModel;

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    public FragmentStateAdapter adapter;

    /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
    public TabLayout tabLayout;

    /* JADX INFO: renamed from: j, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public LiveData<List<BookGroup>> bookGroupLiveData;

    /* JADX INFO: renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final List<BookGroup> bookGroups;

    /* JADX INFO: renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final HashMap<Long, BooksFragment> fragmentMap;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    @NotNull
    public final ActivityResultLauncher<e.a.a.g.f.d> importBookshelf;

    /* JADX INFO: compiled from: BookshelfFragment.kt */
    public final class a extends FragmentStateAdapter {
        public final /* synthetic */ BookshelfFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(BookshelfFragment bookshelfFragment) {
            super(bookshelfFragment);
            j.e(bookshelfFragment, "this$0");
            this.a = bookshelfFragment;
        }

        @Override // androidx.viewpager2.adapter.FragmentStateAdapter
        public boolean containsItem(long j2) {
            return this.a.fragmentMap.containsKey(Long.valueOf(j2));
        }

        @Override // androidx.viewpager2.adapter.FragmentStateAdapter
        @NotNull
        public Fragment createFragment(int i2) {
            BookGroup bookGroup = this.a.bookGroups.get(i2);
            BooksFragment.Companion aVar = BooksFragment.INSTANCE;
            long groupId = bookGroup.getGroupId();
            Objects.requireNonNull(aVar);
            BooksFragment booksFragment = new BooksFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("position", i2);
            bundle.putLong("groupId", groupId);
            booksFragment.setArguments(bundle);
            this.a.fragmentMap.put(Long.valueOf(bookGroup.getGroupId()), booksFragment);
            return booksFragment;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.a.bookGroups.size();
        }

        @Override // androidx.viewpager2.adapter.FragmentStateAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
        public long getItemId(int i2) {
            return this.a.bookGroups.get(i2).getGroupId();
        }
    }

    /* JADX INFO: compiled from: BookshelfFragment.kt */
    public static final class b extends k implements l<String, v> {
        public b() {
            super(1);
        }

        @Override // f.c0.b.l
        public /* bridge */ /* synthetic */ v invoke(String str) {
            invoke2(str);
            return v.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull String str) {
            j.e(str, "it");
            FragmentActivity activity = BookshelfFragment.this.getActivity();
            if (activity == null) {
                return;
            }
            c.b.a.m.f.g5(activity, str, null, 2);
        }
    }

    /* JADX INFO: compiled from: FragmentViewModelLazy.kt */
    public static final class c extends k implements f.c0.b.a<ViewModelStore> {
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
    public static final class d extends k implements f.c0.b.a<ViewModelProvider.Factory> {
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
    public static final class e extends k implements l<BookshelfFragment, FragmentBookshelfBinding> {
        public e() {
            super(1);
        }

        @Override // f.c0.b.l
        @NotNull
        public final FragmentBookshelfBinding invoke(@NotNull BookshelfFragment bookshelfFragment) {
            j.e(bookshelfFragment, "fragment");
            View viewRequireView = bookshelfFragment.requireView();
            int i2 = R.id.title_bar;
            TitleBar titleBar = (TitleBar) viewRequireView.findViewById(R.id.title_bar);
            if (titleBar != null) {
                i2 = R.id.view_pager_bookshelf;
                ViewPager2 viewPager2 = (ViewPager2) viewRequireView.findViewById(R.id.view_pager_bookshelf);
                if (viewPager2 != null) {
                    return new FragmentBookshelfBinding((RootView) viewRequireView, titleBar, viewPager2);
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(viewRequireView.getResources().getResourceName(i2)));
        }
    }

    /* JADX INFO: compiled from: FragmentViewModelLazy.kt */
    public static final class f extends k implements f.c0.b.a<Fragment> {
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
    public static final class g extends k implements f.c0.b.a<ViewModelStore> {
        public final /* synthetic */ f.c0.b.a $ownerProducer;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(f.c0.b.a aVar) {
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
        q qVar = new q(f.c0.c.v.a(BookshelfFragment.class), "binding", "getBinding()Lio/legado/app/databinding/FragmentBookshelfBinding;");
        Objects.requireNonNull(f.c0.c.v.a);
        hVarArr[0] = qVar;
        f7403d = hVarArr;
    }

    public BookshelfFragment() {
        super(R.layout.fragment_bookshelf);
        this.binding = c.b.a.m.f.b6(this, new e());
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, f.c0.c.v.a(BookshelfViewModel.class), new g(new f(this)), null);
        this.activityViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, f.c0.c.v.a(MainViewModel.class), new c(this), new d(this));
        this.bookGroups = new ArrayList();
        this.fragmentMap = new HashMap<>();
        ActivityResultLauncher<e.a.a.g.f.d> activityResultLauncherRegisterForActivityResult = registerForActivityResult(new FilePicker(), new ActivityResultCallback() { // from class: e.a.a.g.h.g.c
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                BookshelfFragment bookshelfFragment = this.a;
                Uri uri = (Uri) obj;
                f.f0.h<Object>[] hVarArr = BookshelfFragment.f7403d;
                f.c0.c.j.e(bookshelfFragment, "this$0");
                if (uri == null) {
                    return;
                }
                Context contextRequireContext = bookshelfFragment.requireContext();
                f.c0.c.j.d(contextRequireContext, "requireContext()");
                String strB4 = c.b.a.m.f.B4(uri, contextRequireContext);
                if (strB4 == null) {
                    return;
                }
                bookshelfFragment.W().e(strB4, bookshelfFragment.V().getGroupId());
            }
        });
        j.d(activityResultLauncherRegisterForActivityResult, "registerForActivityResult(FilePicker()) {\n        it?.readText(requireContext())?.let { text ->\n            viewModel.importBookshelf(text, selectedGroup.groupId)\n        }\n    }");
        this.importBookshelf = activityResultLauncherRegisterForActivityResult;
    }

    @Override // com.google.android.material.tabs.TabLayout.c
    public void K(@NotNull TabLayout.g tab) {
        j.e(tab, "tab");
    }

    @Override // io.legado.app.base.BaseFragment
    public void P(@NotNull Menu menu) {
        j.e(menu, "menu");
        N().inflate(R.menu.main_bookshelf, menu);
    }

    @Override // io.legado.app.base.BaseFragment
    public void Q(@NotNull MenuItem item) {
        List<Book> listG;
        j.e(item, "item");
        j.e(item, "item");
        switch (item.getItemId()) {
            case R.id.menu_add_local /* 2131296782 */:
                startActivity(new Intent(requireContext(), (Class<?>) ImportBookActivity.class));
                return;
            case R.id.menu_add_url /* 2131296785 */:
                Integer numValueOf = Integer.valueOf(R.string.add_book_url);
                e.a.a.g.h.g.d dVar = new e.a.a.g.h.g.d(this);
                FragmentActivity fragmentActivityRequireActivity = requireActivity();
                j.d(fragmentActivityRequireActivity, "requireActivity()");
                ((i) c.b.a.m.f.h0(fragmentActivityRequireActivity, numValueOf, null, dVar)).p();
                return;
            case R.id.menu_arrange_bookshelf /* 2131296787 */:
                Intent intent = new Intent(requireContext(), (Class<?>) ArrangeBookActivity.class);
                intent.putExtra("groupId", V().getGroupId());
                intent.putExtra("groupName", V().getGroupName());
                startActivity(intent);
                return;
            case R.id.menu_bookshelf_layout /* 2131296793 */:
                Integer numValueOf2 = Integer.valueOf(R.string.bookshelf_layout);
                e.a.a.g.h.g.e eVar = new e.a.a.g.h.g.e(this);
                FragmentActivity fragmentActivityRequireActivity2 = requireActivity();
                j.d(fragmentActivityRequireActivity2, "requireActivity()");
                ((i) c.b.a.m.f.h0(fragmentActivityRequireActivity2, numValueOf2, null, eVar)).p();
                return;
            case R.id.menu_download /* 2131296817 */:
                Intent intent2 = new Intent(requireContext(), (Class<?>) CacheActivity.class);
                intent2.putExtra("groupId", V().getGroupId());
                intent2.putExtra("groupName", V().getGroupName());
                startActivity(intent2);
                return;
            case R.id.menu_export_bookshelf /* 2131296826 */:
                BooksFragment booksFragment = this.fragmentMap.get(Long.valueOf(V().getGroupId()));
                BookshelfViewModel bookshelfViewModelW = W();
                if (booksFragment == null) {
                    listG = null;
                } else {
                    BaseBooksAdapter<?> baseBooksAdapter = booksFragment.booksAdapter;
                    if (baseBooksAdapter == null) {
                        j.m("booksAdapter");
                        throw null;
                    }
                    listG = baseBooksAdapter.g();
                }
                b bVar = new b();
                Objects.requireNonNull(bookshelfViewModelW);
                j.e(bVar, "success");
                BaseViewModel.a(bookshelfViewModelW, null, null, new e.a.a.g.h.g.j(listG, null), 3, null).d(null, new e.a.a.g.h.g.k(bVar, null));
                return;
            case R.id.menu_group_manage /* 2131296835 */:
                GroupManageDialog groupManageDialog = new GroupManageDialog();
                FragmentManager childFragmentManager = getChildFragmentManager();
                j.d(childFragmentManager, "childFragmentManager");
                groupManageDialog.show(childFragmentManager, "groupManageDialog");
                return;
            case R.id.menu_import_bookshelf /* 2131296843 */:
                Integer numValueOf3 = Integer.valueOf(R.string.import_bookshelf);
                e.a.a.g.h.g.f fVar = new e.a.a.g.h.g.f(this);
                FragmentActivity fragmentActivityRequireActivity3 = requireActivity();
                j.d(fragmentActivityRequireActivity3, "requireActivity()");
                ((i) c.b.a.m.f.h0(fragmentActivityRequireActivity3, numValueOf3, null, fVar)).p();
                return;
            case R.id.menu_search /* 2131296874 */:
                startActivity(new Intent(requireContext(), (Class<?>) SearchActivity.class));
                return;
            case R.id.menu_update_toc /* 2131296900 */:
                BooksFragment booksFragment2 = this.fragmentMap.get(Long.valueOf(V().getGroupId()));
                if (booksFragment2 == null) {
                    return;
                }
                BaseBooksAdapter<?> baseBooksAdapter2 = booksFragment2.booksAdapter;
                if (baseBooksAdapter2 == null) {
                    j.m("booksAdapter");
                    throw null;
                }
                ((MainViewModel) this.activityViewModel.getValue()).f(baseBooksAdapter2.g());
                return;
            default:
                return;
        }
    }

    @Override // io.legado.app.base.BaseFragment
    public void R(@NotNull View view, @Nullable Bundle savedInstanceState) {
        j.e(view, "view");
        View viewFindViewById = U().f6710b.findViewById(R.id.tab_layout);
        j.d(viewFindViewById, "binding.titleBar.findViewById(R.id.tab_layout)");
        this.tabLayout = (TabLayout) viewFindViewById;
        T(U().f6710b.getToolbar());
        ATH.a.b(U().f6711c);
        TabLayout tabLayout = this.tabLayout;
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
        tabLayout2.setTabMode(0);
        TabLayout tabLayout3 = this.tabLayout;
        if (tabLayout3 == null) {
            j.m("tabLayout");
            throw null;
        }
        Context contextRequireContext = requireContext();
        j.d(contextRequireContext, "requireContext()");
        tabLayout3.setSelectedTabIndicatorColor(c.b.a.m.f.M1(contextRequireContext));
        U().f6711c.setOffscreenPageLimit(1);
        this.adapter = new a(this);
        ViewPager2 viewPager2 = U().f6711c;
        FragmentStateAdapter fragmentStateAdapter = this.adapter;
        if (fragmentStateAdapter == null) {
            j.m("adapter");
            throw null;
        }
        viewPager2.setAdapter(fragmentStateAdapter);
        TabLayout tabLayout4 = this.tabLayout;
        if (tabLayout4 == null) {
            j.m("tabLayout");
            throw null;
        }
        new c.e.a.b.z.d(tabLayout4, U().f6711c, new d.b() { // from class: e.a.a.g.h.g.a
            @Override // c.e.a.b.z.d.b
            public final void a(TabLayout.g gVar, int i2) {
                BookshelfFragment bookshelfFragment = this.a;
                f.f0.h<Object>[] hVarArr = BookshelfFragment.f7403d;
                f.c0.c.j.e(bookshelfFragment, "this$0");
                f.c0.c.j.e(gVar, "tab");
                gVar.c(bookshelfFragment.bookGroups.get(i2).getGroupName());
            }
        }).a();
        LiveData<List<BookGroup>> liveData = this.bookGroupLiveData;
        if (liveData != null) {
            liveData.removeObservers(getViewLifecycleOwner());
        }
        LiveData<List<BookGroup>> liveDataLiveDataShow = AppDatabaseKt.getAppDb().getBookGroupDao().liveDataShow();
        liveDataLiveDataShow.observe(getViewLifecycleOwner(), new Observer() { // from class: e.a.a.g.h.g.b
            @Override // androidx.view.Observer
            public final void onChanged(Object obj) {
                BookshelfFragment bookshelfFragment = this.a;
                List<BookGroup> list = (List) obj;
                f.f0.h<Object>[] hVarArr = BookshelfFragment.f7403d;
                f.c0.c.j.e(bookshelfFragment, "this$0");
                BookshelfViewModel bookshelfViewModelW = bookshelfFragment.W();
                f.c0.c.j.d(list, "it");
                Objects.requireNonNull(bookshelfViewModelW);
                f.c0.c.j.e(list, "groups");
                for (BookGroup bookGroup : list) {
                    if (bookGroup.getGroupId() >= 0 && (bookGroup.getGroupId() & (bookGroup.getGroupId() - 1)) != 0) {
                        long j2 = 1;
                        while ((j2 & AppDatabaseKt.getAppDb().getBookGroupDao().getIdsSum()) != 0) {
                            j2 <<= 1;
                        }
                        AppDatabaseKt.getAppDb().getBookGroupDao().delete(bookGroup);
                        AppDatabaseKt.getAppDb().getBookGroupDao().insert(BookGroup.copy$default(bookGroup, j2, null, 0, false, 14, null));
                        AppDatabaseKt.getAppDb().getBookDao().upGroup(bookGroup.getGroupId(), j2);
                    }
                }
                synchronized (bookshelfFragment) {
                    if (list.isEmpty()) {
                        AppDatabaseKt.getAppDb().getBookGroupDao().enableGroup(-1L);
                    } else if (!f.c0.c.j.a(list, bookshelfFragment.bookGroups)) {
                        bookshelfFragment.bookGroups.clear();
                        bookshelfFragment.bookGroups.addAll(list);
                        FragmentStateAdapter fragmentStateAdapter2 = bookshelfFragment.adapter;
                        if (fragmentStateAdapter2 == null) {
                            f.c0.c.j.m("adapter");
                            throw null;
                        }
                        fragmentStateAdapter2.notifyDataSetChanged();
                        bookshelfFragment.X();
                    }
                }
            }
        });
        this.bookGroupLiveData = liveDataLiveDataShow;
    }

    public final FragmentBookshelfBinding U() {
        return (FragmentBookshelfBinding) this.binding.b(this, f7403d[0]);
    }

    public final BookGroup V() {
        List<BookGroup> list = this.bookGroups;
        TabLayout tabLayout = this.tabLayout;
        if (tabLayout != null) {
            return list.get(tabLayout.getSelectedTabPosition());
        }
        j.m("tabLayout");
        throw null;
    }

    @NotNull
    public BookshelfViewModel W() {
        return (BookshelfViewModel) this.viewModel.getValue();
    }

    public final synchronized void X() {
        TabLayout tabLayout = this.tabLayout;
        if (tabLayout == null) {
            j.m("tabLayout");
            throw null;
        }
        tabLayout.removeOnTabSelectedListener((TabLayout.d) this);
        TabLayout tabLayout2 = this.tabLayout;
        if (tabLayout2 == null) {
            j.m("tabLayout");
            throw null;
        }
        TabLayout.g gVarG = tabLayout2.g(m.d(this, "saveTabPosition", 0));
        if (gVarG != null) {
            gVarG.a();
        }
        TabLayout tabLayout3 = this.tabLayout;
        if (tabLayout3 == null) {
            j.m("tabLayout");
            throw null;
        }
        tabLayout3.addOnTabSelectedListener((TabLayout.d) this);
    }

    @Override // com.google.android.material.tabs.TabLayout.c
    public void m(@NotNull TabLayout.g tab) {
        j.e(tab, "tab");
        BooksFragment booksFragment = this.fragmentMap.get(Long.valueOf(V().getGroupId()));
        if (booksFragment == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(V().getGroupName());
        sb.append('(');
        BaseBooksAdapter<?> baseBooksAdapter = booksFragment.booksAdapter;
        if (baseBooksAdapter == null) {
            j.m("booksAdapter");
            throw null;
        }
        sb.append(baseBooksAdapter.getItemCount());
        sb.append(')');
        m.m(this, sb.toString());
    }

    @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
    public boolean onQueryTextChange(@Nullable String newText) {
        return false;
    }

    @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
    public boolean onQueryTextSubmit(@Nullable String query) {
        Intent intent = new Intent(requireContext(), (Class<?>) SearchActivity.class);
        intent.putExtra("key", query);
        startActivity(intent);
        return false;
    }

    @Override // com.google.android.material.tabs.TabLayout.c
    public void x(@NotNull TabLayout.g tab) {
        j.e(tab, "tab");
        m.i(this, "saveTabPosition", tab.f2438d);
    }
}

package io.legado.app.ui.book.changesource;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.KeyEventDispatcher;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.view.Observer;
import androidx.view.ViewModelStore;
import androidx.view.ViewModelStoreOwner;
import c.b.a.m.f;
import com.umeng.analytics.pro.ai;
import e.a.a.g.d.d.p;
import e.a.a.h.m;
import f.c0.b.l;
import f.c0.c.j;
import f.c0.c.k;
import f.c0.c.q;
import f.c0.c.v;
import f.f0.h;
import io.legado.app.base.BaseDialogFragment;
import io.legado.app.base.BaseViewModel;
import io.legado.app.data.AppDatabaseKt;
import io.legado.app.data.entities.Book;
import io.legado.app.data.entities.SearchBook;
import io.legado.app.databinding.DialogChangeSourceBinding;
import io.legado.app.ui.book.changesource.ChangeSourceAdapter;
import io.legado.app.ui.book.changesource.ChangeSourceDialog;
import io.legado.app.ui.book.source.manage.BookSourceActivity;
import io.legado.app.ui.widget.anima.RefreshProgressBar;
import io.legado.app.ui.widget.recycler.VerticalDivider;
import io.legado.app.utils.viewbindingdelegate.ViewBindingProperty;
import io.wenyuange.app.release.R;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ChangeSourceDialog.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 @2\u00020\u00012\u00020\u00022\u00020\u0003:\u0002A@B\u0007¢\u0006\u0004\b?\u0010\u0006J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J-\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001c\u0010\u001bJ\u000f\u0010\u001d\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001d\u0010\u0006R\"\u0010%\u001a\u00020\u001e8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001d\u0010+\u001a\u00020&8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R&\u00101\u001a\u0012\u0012\u0004\u0012\u00020-0,j\b\u0012\u0004\u0012\u00020-`.8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u0018\u00104\u001a\u0004\u0018\u00010-8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b2\u00103R\u0018\u00108\u001a\u0004\u0018\u0001058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00107R\u001d\u0010>\u001a\u0002098B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=¨\u0006B"}, d2 = {"Lio/legado/app/ui/book/changesource/ChangeSourceDialog;", "Lio/legado/app/base/BaseDialogFragment;", "Landroidx/appcompat/widget/Toolbar$OnMenuItemClickListener;", "Lio/legado/app/ui/book/changesource/ChangeSourceAdapter$a;", "Lf/v;", "onStart", "()V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "P", "(Landroid/view/View;Landroid/os/Bundle;)V", "Landroid/view/MenuItem;", "item", "", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Lio/legado/app/data/entities/SearchBook;", "searchBook", ExifInterface.LONGITUDE_EAST, "(Lio/legado/app/data/entities/SearchBook;)V", "F", ExifInterface.GPS_DIRECTION_TRUE, "Lio/legado/app/ui/book/changesource/ChangeSourceAdapter;", "h", "Lio/legado/app/ui/book/changesource/ChangeSourceAdapter;", "Q", "()Lio/legado/app/ui/book/changesource/ChangeSourceAdapter;", "setAdapter", "(Lio/legado/app/ui/book/changesource/ChangeSourceAdapter;)V", "adapter", "Lio/legado/app/ui/book/changesource/ChangeSourceViewModel;", "g", "Lf/e;", ExifInterface.LATITUDE_SOUTH, "()Lio/legado/app/ui/book/changesource/ChangeSourceViewModel;", "viewModel", "Ljava/util/LinkedHashSet;", "", "Lkotlin/collections/LinkedHashSet;", "e", "Ljava/util/LinkedHashSet;", "groups", "getBookUrl", "()Ljava/lang/String;", "bookUrl", "Lio/legado/app/ui/book/changesource/ChangeSourceDialog$a;", "f", "Lio/legado/app/ui/book/changesource/ChangeSourceDialog$a;", "callBack", "Lio/legado/app/databinding/DialogChangeSourceBinding;", "d", "Lio/legado/app/utils/viewbindingdelegate/ViewBindingProperty;", "R", "()Lio/legado/app/databinding/DialogChangeSourceBinding;", "binding", "<init>", "b", ai.at, "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class ChangeSourceDialog extends BaseDialogFragment implements Toolbar.OnMenuItemClickListener, ChangeSourceAdapter.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ h<Object>[] f7062c;

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public a callBack;

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    public ChangeSourceAdapter adapter;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final ViewBindingProperty binding = f.b6(this, new c());

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final LinkedHashSet<String> groups = new LinkedHashSet<>();

    /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final f.e viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, v.a(ChangeSourceViewModel.class), new e(new d(this)), null);

    /* JADX INFO: compiled from: ChangeSourceDialog.kt */
    public interface a {
        void V(@NotNull Book book);

        @Nullable
        /* JADX INFO: renamed from: c0 */
        Book getOldbook();
    }

    /* JADX INFO: renamed from: io.legado.app.ui.book.changesource.ChangeSourceDialog$b, reason: from kotlin metadata */
    /* JADX INFO: compiled from: ChangeSourceDialog.kt */
    public static final class Companion {
        public Companion(f.c0.c.f fVar) {
        }

        public final void a(@NotNull FragmentManager fragmentManager, @NotNull String str, @NotNull String str2) {
            j.e(fragmentManager, "manager");
            j.e(str, "name");
            j.e(str2, "author");
            Fragment fragmentFindFragmentByTag = fragmentManager.findFragmentByTag("changeSourceDialog");
            ChangeSourceDialog changeSourceDialog = fragmentFindFragmentByTag instanceof ChangeSourceDialog ? (ChangeSourceDialog) fragmentFindFragmentByTag : null;
            if (changeSourceDialog == null) {
                changeSourceDialog = new ChangeSourceDialog();
                Bundle bundle = new Bundle();
                bundle.putString("name", str);
                bundle.putString("author", str2);
                changeSourceDialog.setArguments(bundle);
            }
            changeSourceDialog.show(fragmentManager, "changeSourceDialog");
        }
    }

    /* JADX INFO: compiled from: FragmentViewBindings.kt */
    public static final class c extends k implements l<ChangeSourceDialog, DialogChangeSourceBinding> {
        public c() {
            super(1);
        }

        @Override // f.c0.b.l
        @NotNull
        public final DialogChangeSourceBinding invoke(@NotNull ChangeSourceDialog changeSourceDialog) {
            j.e(changeSourceDialog, "fragment");
            View viewRequireView = changeSourceDialog.requireView();
            int i2 = R.id.recycler_view;
            RecyclerView recyclerView = (RecyclerView) viewRequireView.findViewById(R.id.recycler_view);
            if (recyclerView != null) {
                i2 = R.id.refresh_progress_bar;
                RefreshProgressBar refreshProgressBar = (RefreshProgressBar) viewRequireView.findViewById(R.id.refresh_progress_bar);
                if (refreshProgressBar != null) {
                    i2 = R.id.tool_bar;
                    Toolbar toolbar = (Toolbar) viewRequireView.findViewById(R.id.tool_bar);
                    if (toolbar != null) {
                        return new DialogChangeSourceBinding((LinearLayout) viewRequireView, recyclerView, refreshProgressBar, toolbar);
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(viewRequireView.getResources().getResourceName(i2)));
        }
    }

    /* JADX INFO: compiled from: FragmentViewModelLazy.kt */
    public static final class d extends k implements f.c0.b.a<Fragment> {
        public final /* synthetic */ Fragment $this_viewModels;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(Fragment fragment) {
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
    public static final class e extends k implements f.c0.b.a<ViewModelStore> {
        public final /* synthetic */ f.c0.b.a $ownerProducer;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(f.c0.b.a aVar) {
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
        q qVar = new q(v.a(ChangeSourceDialog.class), "binding", "getBinding()Lio/legado/app/databinding/DialogChangeSourceBinding;");
        Objects.requireNonNull(v.a);
        hVarArr[0] = qVar;
        f7062c = hVarArr;
        INSTANCE = new Companion(null);
    }

    @Override // io.legado.app.ui.book.changesource.ChangeSourceAdapter.a
    public void E(@NotNull SearchBook searchBook) {
        j.e(searchBook, "searchBook");
        Book book = searchBook.toBook();
        a aVar = this.callBack;
        book.upInfoFromOld(aVar == null ? null : aVar.getOldbook());
        a aVar2 = this.callBack;
        if (aVar2 != null) {
            aVar2.V(book);
        }
        dismissAllowingStateLoss();
    }

    @Override // io.legado.app.ui.book.changesource.ChangeSourceAdapter.a
    public void F(@NotNull SearchBook searchBook) {
        j.e(searchBook, "searchBook");
        ChangeSourceViewModel changeSourceViewModelS = S();
        Objects.requireNonNull(changeSourceViewModelS);
        j.e(searchBook, "searchBook");
        BaseViewModel.a(changeSourceViewModelS, null, null, new e.a.a.g.d.d.k(searchBook, changeSourceViewModelS, null), 3, null);
    }

    @Override // io.legado.app.base.BaseDialogFragment
    public void P(@NotNull View view, @Nullable Bundle savedInstanceState) {
        j.e(view, "view");
        R().f6601d.setBackgroundColor(f.Q2(this));
        ChangeSourceViewModel changeSourceViewModelS = S();
        Bundle arguments = getArguments();
        Objects.requireNonNull(changeSourceViewModelS);
        if (arguments != null) {
            String string = arguments.getString("name");
            if (string != null) {
                j.e(string, "<set-?>");
                changeSourceViewModelS.name = string;
            }
            String string2 = arguments.getString("author");
            if (string2 != null) {
                e.a.a.c.d dVar = e.a.a.c.d.a;
                String strReplace = e.a.a.c.d.f5512f.replace(string2, "");
                j.e(strReplace, "<set-?>");
                changeSourceViewModelS.author = strReplace;
            }
        }
        T();
        R().f6601d.inflateMenu(R.menu.change_source);
        Menu menu = R().f6601d.getMenu();
        j.d(menu, "binding.toolBar.menu");
        Context contextRequireContext = requireContext();
        j.d(contextRequireContext, "requireContext()");
        m.b(menu, contextRequireContext, null, 2);
        R().f6601d.setOnMenuItemClickListener(this);
        MenuItem menuItemFindItem = R().f6601d.getMenu().findItem(R.id.menu_check_author);
        if (menuItemFindItem != null) {
            menuItemFindItem.setChecked(e.a.a.d.e.a.a());
        }
        MenuItem menuItemFindItem2 = R().f6601d.getMenu().findItem(R.id.menu_load_info);
        if (menuItemFindItem2 != null) {
            e.a.a.d.e eVar = e.a.a.d.e.a;
            menuItemFindItem2.setChecked(f.K2(k.d.a.h.g(), "changeSourceLoadToc", false, 2));
        }
        MenuItem menuItemFindItem3 = R().f6601d.getMenu().findItem(R.id.menu_load_toc);
        if (menuItemFindItem3 != null) {
            e.a.a.d.e eVar2 = e.a.a.d.e.a;
            menuItemFindItem3.setChecked(f.K2(k.d.a.h.g(), "changeSourceLoadToc", false, 2));
        }
        Context contextRequireContext2 = requireContext();
        j.d(contextRequireContext2, "requireContext()");
        ChangeSourceAdapter changeSourceAdapter = new ChangeSourceAdapter(contextRequireContext2, S(), this);
        j.e(changeSourceAdapter, "<set-?>");
        this.adapter = changeSourceAdapter;
        R().f6599b.setLayoutManager(new LinearLayoutManager(getContext()));
        RecyclerView recyclerView = R().f6599b;
        Context contextRequireContext3 = requireContext();
        j.d(contextRequireContext3, "requireContext()");
        recyclerView.addItemDecoration(new VerticalDivider(contextRequireContext3));
        R().f6599b.setAdapter(Q());
        Q().registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() { // from class: io.legado.app.ui.book.changesource.ChangeSourceDialog$initRecyclerView$1
            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeInserted(int positionStart, int itemCount) {
                if (positionStart == 0) {
                    ChangeSourceDialog changeSourceDialog = this.a;
                    ChangeSourceDialog.Companion companion = ChangeSourceDialog.INSTANCE;
                    changeSourceDialog.R().f6599b.scrollToPosition(0);
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeMoved(int fromPosition, int toPosition, int itemCount) {
                if (toPosition == 0) {
                    ChangeSourceDialog changeSourceDialog = this.a;
                    ChangeSourceDialog.Companion companion = ChangeSourceDialog.INSTANCE;
                    changeSourceDialog.R().f6599b.scrollToPosition(0);
                }
            }
        });
        View actionView = R().f6601d.getMenu().findItem(R.id.menu_screen).getActionView();
        Objects.requireNonNull(actionView, "null cannot be cast to non-null type androidx.appcompat.widget.SearchView");
        SearchView searchView = (SearchView) actionView;
        searchView.setOnCloseListener(new SearchView.OnCloseListener() { // from class: e.a.a.g.d.d.d
            @Override // androidx.appcompat.widget.SearchView.OnCloseListener
            public final boolean onClose() {
                ChangeSourceDialog changeSourceDialog = this.a;
                ChangeSourceDialog.Companion companion = ChangeSourceDialog.INSTANCE;
                f.c0.c.j.e(changeSourceDialog, "this$0");
                changeSourceDialog.T();
                return false;
            }
        });
        searchView.setOnSearchClickListener(new View.OnClickListener() { // from class: e.a.a.g.d.d.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ChangeSourceDialog changeSourceDialog = this.a;
                ChangeSourceDialog.Companion companion = ChangeSourceDialog.INSTANCE;
                f.c0.c.j.e(changeSourceDialog, "this$0");
                changeSourceDialog.R().f6601d.setTitle("");
                changeSourceDialog.R().f6601d.setSubtitle("");
            }
        });
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() { // from class: io.legado.app.ui.book.changesource.ChangeSourceDialog$initSearchView$3
            @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
            public boolean onQueryTextChange(@Nullable String newText) {
                ChangeSourceDialog changeSourceDialog = this.a;
                ChangeSourceDialog.Companion companion = ChangeSourceDialog.INSTANCE;
                ChangeSourceViewModel changeSourceViewModelS2 = changeSourceDialog.S();
                Objects.requireNonNull(changeSourceViewModelS2);
                BaseViewModel.a(changeSourceViewModelS2, null, null, new p(changeSourceViewModelS2, newText, null), 3, null);
                return false;
            }

            @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
            public boolean onQueryTextSubmit(@Nullable String query) {
                return false;
            }
        });
        S().searchStateData.observe(getViewLifecycleOwner(), new Observer() { // from class: e.a.a.g.d.d.e
            @Override // androidx.view.Observer
            public final void onChanged(Object obj) {
                ChangeSourceDialog changeSourceDialog = this.a;
                Boolean bool = (Boolean) obj;
                ChangeSourceDialog.Companion companion = ChangeSourceDialog.INSTANCE;
                f.c0.c.j.e(changeSourceDialog, "this$0");
                RefreshProgressBar refreshProgressBar = changeSourceDialog.R().f6600c;
                f.c0.c.j.d(bool, "it");
                refreshProgressBar.setAutoLoading(bool.booleanValue());
                if (bool.booleanValue()) {
                    MenuItem menuItemFindItem4 = changeSourceDialog.R().f6601d.getMenu().findItem(R.id.menu_stop);
                    if (menuItemFindItem4 != null) {
                        menuItemFindItem4.setIcon(R.drawable.ic_stop_black_24dp);
                    }
                } else {
                    MenuItem menuItemFindItem5 = changeSourceDialog.R().f6601d.getMenu().findItem(R.id.menu_stop);
                    if (menuItemFindItem5 != null) {
                        menuItemFindItem5.setIcon(R.drawable.ic_refresh_black_24dp);
                    }
                }
                Menu menu2 = changeSourceDialog.R().f6601d.getMenu();
                f.c0.c.j.d(menu2, "binding.toolBar.menu");
                Context contextRequireContext4 = changeSourceDialog.requireContext();
                f.c0.c.j.d(contextRequireContext4, "requireContext()");
                e.a.a.h.m.b(menu2, contextRequireContext4, null, 2);
            }
        });
        S().searchBooksLiveData.observe(getViewLifecycleOwner(), new Observer() { // from class: e.a.a.g.d.d.f
            @Override // androidx.view.Observer
            public final void onChanged(Object obj) {
                ChangeSourceDialog changeSourceDialog = this.a;
                List list = (List) obj;
                ChangeSourceDialog.Companion companion = ChangeSourceDialog.INSTANCE;
                f.c0.c.j.e(changeSourceDialog, "this$0");
                if (list == null || list.isEmpty()) {
                    return;
                }
                changeSourceDialog.Q().n(list);
            }
        });
        AppDatabaseKt.getAppDb().getBookSourceDao().liveGroupEnabled().observe(this, new Observer() { // from class: e.a.a.g.d.d.c
            @Override // androidx.view.Observer
            public final void onChanged(Object obj) {
                ChangeSourceDialog changeSourceDialog = this.a;
                List<String> list = (List) obj;
                ChangeSourceDialog.Companion companion = ChangeSourceDialog.INSTANCE;
                f.c0.c.j.e(changeSourceDialog, "this$0");
                changeSourceDialog.groups.clear();
                f.c0.c.j.d(list, "it");
                ArrayList arrayList = new ArrayList(c.b.a.m.f.S0(list, 10));
                for (String str : list) {
                    LinkedHashSet<String> linkedHashSet = changeSourceDialog.groups;
                    e.a.a.c.d dVar2 = e.a.a.c.d.a;
                    arrayList.add(Boolean.valueOf(c.b.a.m.f.T(linkedHashSet, c.b.a.m.f.o5(str, e.a.a.c.d.f5514h, 0, 2))));
                }
                Menu menu2 = changeSourceDialog.R().f6601d.getMenu();
                f.c0.c.j.d(menu2, "binding.toolBar.menu");
                String strF = e.a.a.h.m.f(changeSourceDialog, "searchGroup", null, 2);
                menu2.removeGroup(R.id.source_group);
                MenuItem menuItemAdd = menu2.add(R.id.source_group, 0, 0, R.string.all_source);
                boolean z = false;
                for (String str2 : f.x.e.B(changeSourceDialog.groups, h.a)) {
                    MenuItem menuItemAdd2 = menu2.add(R.id.source_group, 0, 0, str2);
                    if (menuItemAdd2 != null && f.c0.c.j.a(str2, strF)) {
                        menuItemAdd2.setChecked(true);
                        z = true;
                    }
                }
                menu2.setGroupCheckable(R.id.source_group, true, true);
                if (z) {
                    return;
                }
                menuItemAdd.setChecked(true);
            }
        });
        S().h();
    }

    @NotNull
    public final ChangeSourceAdapter Q() {
        ChangeSourceAdapter changeSourceAdapter = this.adapter;
        if (changeSourceAdapter != null) {
            return changeSourceAdapter;
        }
        j.m("adapter");
        throw null;
    }

    public final DialogChangeSourceBinding R() {
        return (DialogChangeSourceBinding) this.binding.b(this, f7062c[0]);
    }

    public final ChangeSourceViewModel S() {
        return (ChangeSourceViewModel) this.viewModel.getValue();
    }

    public final void T() {
        R().f6601d.setTitle(S().name);
        R().f6601d.setSubtitle(S().author);
    }

    @Override // io.legado.app.ui.book.changesource.ChangeSourceAdapter.a
    @Nullable
    public String getBookUrl() {
        Book oldbook;
        a aVar = this.callBack;
        if (aVar == null || (oldbook = aVar.getOldbook()) == null) {
            return null;
        }
        return oldbook.getBookUrl();
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        j.e(inflater, "inflater");
        KeyEventDispatcher.Component activity = getActivity();
        this.callBack = activity instanceof a ? (a) activity : null;
        return inflater.inflate(R.layout.dialog_change_source, container);
    }

    @Override // androidx.appcompat.widget.Toolbar.OnMenuItemClickListener
    public boolean onMenuItemClick(@Nullable MenuItem item) {
        Integer numValueOf = item == null ? null : Integer.valueOf(item.getItemId());
        if (numValueOf != null && numValueOf.intValue() == R.id.menu_check_author) {
            e.a.a.d.e eVar = e.a.a.d.e.a;
            f.o4(k.d.a.h.g(), "changeSourceCheckAuthor", !item.isChecked());
            item.setChecked(!item.isChecked());
            S().h();
            return false;
        }
        if (numValueOf != null && numValueOf.intValue() == R.id.menu_load_toc) {
            m.h(this, "changeSourceLoadToc", !item.isChecked());
            item.setChecked(!item.isChecked());
            return false;
        }
        if (numValueOf != null && numValueOf.intValue() == R.id.menu_load_info) {
            m.h(this, "changeSourceLoadInfo", !item.isChecked());
            item.setChecked(!item.isChecked());
            return false;
        }
        if (numValueOf != null && numValueOf.intValue() == R.id.menu_stop) {
            S().i();
            return false;
        }
        if (numValueOf != null && numValueOf.intValue() == R.id.menu_source_manage) {
            startActivity(new Intent(requireContext(), (Class<?>) BookSourceActivity.class));
            return false;
        }
        Integer numValueOf2 = item != null ? Integer.valueOf(item.getGroupId()) : null;
        if (numValueOf2 == null || numValueOf2.intValue() != R.id.source_group || item.isChecked()) {
            return false;
        }
        item.setChecked(true);
        if (j.a(item.getTitle().toString(), getString(R.string.all_source))) {
            m.j(this, "searchGroup", "");
        } else {
            m.j(this, "searchGroup", item.getTitle().toString());
        }
        S().i();
        S().h();
        return false;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        Window window;
        super.onStart();
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        j.d(fragmentActivityRequireActivity, "requireActivity()");
        DisplayMetrics displayMetricsV2 = f.V2(fragmentActivityRequireActivity);
        Dialog dialog = getDialog();
        if (dialog == null || (window = dialog.getWindow()) == null) {
            return;
        }
        window.setLayout((int) (((double) displayMetricsV2.widthPixels) * 0.9d), (int) (((double) displayMetricsV2.heightPixels) * 0.9d));
    }
}

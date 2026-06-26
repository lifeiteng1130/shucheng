package io.legado.app.ui.book.changecover;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.KeyEventDispatcher;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.view.Observer;
import androidx.view.ViewModelStore;
import androidx.view.ViewModelStoreOwner;
import c.b.a.m.f;
import com.umeng.analytics.pro.ai;
import e.a.a.d.u.b;
import e.a.a.h.m;
import f.c0.b.l;
import f.c0.c.j;
import f.c0.c.k;
import f.c0.c.q;
import f.c0.c.v;
import f.f0.h;
import io.legado.app.base.BaseDialogFragment;
import io.legado.app.base.BaseViewModel;
import io.legado.app.databinding.DialogChangeCoverBinding;
import io.legado.app.ui.book.changecover.ChangeCoverDialog;
import io.legado.app.ui.book.changecover.CoverAdapter;
import io.legado.app.ui.widget.anima.RefreshProgressBar;
import io.legado.app.utils.viewbindingdelegate.ViewBindingProperty;
import io.wenyuange.app.release.R;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ChangeCoverDialog.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 62\u00020\u00012\u00020\u00022\u00020\u0003:\u000276B\u0007¢\u0006\u0004\b5\u0010\u0006J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J-\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0013\u0010\u0006J\u0019\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001b\u0010\u001cR\"\u0010$\u001a\u00020\u001d8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u0018\u0010(\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u001d\u0010.\u001a\u00020)8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R\u001d\u00104\u001a\u00020/8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103¨\u00068"}, d2 = {"Lio/legado/app/ui/book/changecover/ChangeCoverDialog;", "Lio/legado/app/base/BaseDialogFragment;", "Landroidx/appcompat/widget/Toolbar$OnMenuItemClickListener;", "Lio/legado/app/ui/book/changecover/CoverAdapter$a;", "Lf/v;", "onStart", "()V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "P", "(Landroid/view/View;Landroid/os/Bundle;)V", "O", "Landroid/view/MenuItem;", "item", "", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "", "coverUrl", ai.aD, "(Ljava/lang/String;)V", "Lio/legado/app/ui/book/changecover/CoverAdapter;", "g", "Lio/legado/app/ui/book/changecover/CoverAdapter;", "Q", "()Lio/legado/app/ui/book/changecover/CoverAdapter;", "setAdapter", "(Lio/legado/app/ui/book/changecover/CoverAdapter;)V", "adapter", "Lio/legado/app/ui/book/changecover/ChangeCoverDialog$a;", "e", "Lio/legado/app/ui/book/changecover/ChangeCoverDialog$a;", "callBack", "Lio/legado/app/ui/book/changecover/ChangeCoverViewModel;", "f", "Lf/e;", ExifInterface.LATITUDE_SOUTH, "()Lio/legado/app/ui/book/changecover/ChangeCoverViewModel;", "viewModel", "Lio/legado/app/databinding/DialogChangeCoverBinding;", "d", "Lio/legado/app/utils/viewbindingdelegate/ViewBindingProperty;", "R", "()Lio/legado/app/databinding/DialogChangeCoverBinding;", "binding", "<init>", "b", ai.at, "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class ChangeCoverDialog extends BaseDialogFragment implements Toolbar.OnMenuItemClickListener, CoverAdapter.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ h<Object>[] f7044c;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public a callBack;

    /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
    public CoverAdapter adapter;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final ViewBindingProperty binding = f.b6(this, new c());

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final f.e viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, v.a(ChangeCoverViewModel.class), new e(new d(this)), null);

    /* JADX INFO: compiled from: ChangeCoverDialog.kt */
    public interface a {
        void o0(@NotNull String str);
    }

    /* JADX INFO: renamed from: io.legado.app.ui.book.changecover.ChangeCoverDialog$b, reason: from kotlin metadata */
    /* JADX INFO: compiled from: ChangeCoverDialog.kt */
    public static final class Companion {
        public Companion(f.c0.c.f fVar) {
        }

        public final void a(@NotNull FragmentManager fragmentManager, @NotNull String str, @NotNull String str2) {
            j.e(fragmentManager, "manager");
            j.e(str, "name");
            j.e(str2, "author");
            Fragment fragmentFindFragmentByTag = fragmentManager.findFragmentByTag("changeCoverDialog");
            ChangeCoverDialog changeCoverDialog = fragmentFindFragmentByTag instanceof ChangeCoverDialog ? (ChangeCoverDialog) fragmentFindFragmentByTag : null;
            if (changeCoverDialog == null) {
                changeCoverDialog = new ChangeCoverDialog();
                Bundle bundle = new Bundle();
                bundle.putString("name", str);
                bundle.putString("author", str2);
                changeCoverDialog.setArguments(bundle);
            }
            changeCoverDialog.show(fragmentManager, "changeCoverDialog");
        }
    }

    /* JADX INFO: compiled from: FragmentViewBindings.kt */
    public static final class c extends k implements l<ChangeCoverDialog, DialogChangeCoverBinding> {
        public c() {
            super(1);
        }

        @Override // f.c0.b.l
        @NotNull
        public final DialogChangeCoverBinding invoke(@NotNull ChangeCoverDialog changeCoverDialog) {
            j.e(changeCoverDialog, "fragment");
            View viewRequireView = changeCoverDialog.requireView();
            int i2 = R.id.recycler_view;
            RecyclerView recyclerView = (RecyclerView) viewRequireView.findViewById(R.id.recycler_view);
            if (recyclerView != null) {
                i2 = R.id.refresh_progress_bar;
                RefreshProgressBar refreshProgressBar = (RefreshProgressBar) viewRequireView.findViewById(R.id.refresh_progress_bar);
                if (refreshProgressBar != null) {
                    i2 = R.id.tool_bar;
                    Toolbar toolbar = (Toolbar) viewRequireView.findViewById(R.id.tool_bar);
                    if (toolbar != null) {
                        return new DialogChangeCoverBinding((LinearLayout) viewRequireView, recyclerView, refreshProgressBar, toolbar);
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
        q qVar = new q(v.a(ChangeCoverDialog.class), "binding", "getBinding()Lio/legado/app/databinding/DialogChangeCoverBinding;");
        Objects.requireNonNull(v.a);
        hVarArr[0] = qVar;
        f7044c = hVarArr;
        INSTANCE = new Companion(null);
    }

    @Override // io.legado.app.base.BaseDialogFragment
    public void O() {
        S().searchStateData.observe(getViewLifecycleOwner(), new Observer() { // from class: e.a.a.g.d.c.b
            @Override // androidx.view.Observer
            public final void onChanged(Object obj) {
                ChangeCoverDialog changeCoverDialog = this.a;
                Boolean bool = (Boolean) obj;
                ChangeCoverDialog.Companion companion = ChangeCoverDialog.INSTANCE;
                j.e(changeCoverDialog, "this$0");
                RefreshProgressBar refreshProgressBar = changeCoverDialog.R().f6597c;
                j.d(bool, "it");
                refreshProgressBar.setAutoLoading(bool.booleanValue());
                if (bool.booleanValue()) {
                    MenuItem menuItemFindItem = changeCoverDialog.R().f6598d.getMenu().findItem(R.id.menu_stop);
                    if (menuItemFindItem != null) {
                        menuItemFindItem.setIcon(R.drawable.ic_stop_black_24dp);
                    }
                } else {
                    MenuItem menuItemFindItem2 = changeCoverDialog.R().f6598d.getMenu().findItem(R.id.menu_stop);
                    if (menuItemFindItem2 != null) {
                        menuItemFindItem2.setIcon(R.drawable.ic_refresh_black_24dp);
                    }
                }
                Menu menu = changeCoverDialog.R().f6598d.getMenu();
                j.d(menu, "binding.toolBar.menu");
                Context contextRequireContext = changeCoverDialog.requireContext();
                j.d(contextRequireContext, "requireContext()");
                m.b(menu, contextRequireContext, null, 2);
            }
        });
        S().searchBooksLiveData.observe(getViewLifecycleOwner(), new Observer() { // from class: e.a.a.g.d.c.a
            @Override // androidx.view.Observer
            public final void onChanged(Object obj) {
                ChangeCoverDialog changeCoverDialog = this.a;
                List list = (List) obj;
                ChangeCoverDialog.Companion companion = ChangeCoverDialog.INSTANCE;
                j.e(changeCoverDialog, "this$0");
                if (list == null || list.isEmpty()) {
                    return;
                }
                changeCoverDialog.Q().n(list);
                changeCoverDialog.Q().notifyDataSetChanged();
            }
        });
    }

    @Override // io.legado.app.base.BaseDialogFragment
    public void P(@NotNull View view, @Nullable Bundle savedInstanceState) {
        j.e(view, "view");
        R().f6598d.setBackgroundColor(f.Q2(this));
        R().f6598d.setTitle(R.string.change_cover_source);
        ChangeCoverViewModel changeCoverViewModelS = S();
        Bundle arguments = getArguments();
        Objects.requireNonNull(changeCoverViewModelS);
        if (arguments != null) {
            String string = arguments.getString("name");
            if (string != null) {
                j.e(string, "<set-?>");
                changeCoverViewModelS.name = string;
            }
            String string2 = arguments.getString("author");
            if (string2 != null) {
                e.a.a.c.d dVar = e.a.a.c.d.a;
                String strReplace = e.a.a.c.d.f5512f.replace(string2, "");
                j.e(strReplace, "<set-?>");
                changeCoverViewModelS.author = strReplace;
            }
        }
        R().f6598d.inflateMenu(R.menu.change_cover);
        Menu menu = R().f6598d.getMenu();
        j.d(menu, "binding.toolBar.menu");
        Context contextRequireContext = requireContext();
        j.d(contextRequireContext, "requireContext()");
        m.b(menu, contextRequireContext, null, 2);
        R().f6598d.setOnMenuItemClickListener(this);
        R().f6596b.setLayoutManager(new GridLayoutManager(requireContext(), 3));
        Context contextRequireContext2 = requireContext();
        j.d(contextRequireContext2, "requireContext()");
        CoverAdapter coverAdapter = new CoverAdapter(contextRequireContext2, this);
        j.e(coverAdapter, "<set-?>");
        this.adapter = coverAdapter;
        R().f6596b.setAdapter(Q());
        ChangeCoverViewModel changeCoverViewModelS2 = S();
        Objects.requireNonNull(changeCoverViewModelS2);
        BaseViewModel.a(changeCoverViewModelS2, null, null, new e.a.a.g.d.c.e(changeCoverViewModelS2, null), 3, null);
    }

    @NotNull
    public final CoverAdapter Q() {
        CoverAdapter coverAdapter = this.adapter;
        if (coverAdapter != null) {
            return coverAdapter;
        }
        j.m("adapter");
        throw null;
    }

    public final DialogChangeCoverBinding R() {
        return (DialogChangeCoverBinding) this.binding.b(this, f7044c[0]);
    }

    public final ChangeCoverViewModel S() {
        return (ChangeCoverViewModel) this.viewModel.getValue();
    }

    @Override // io.legado.app.ui.book.changecover.CoverAdapter.a
    public void c(@NotNull String coverUrl) {
        j.e(coverUrl, "coverUrl");
        a aVar = this.callBack;
        if (aVar != null) {
            aVar.o0(coverUrl);
        }
        dismissAllowingStateLoss();
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        j.e(inflater, "inflater");
        KeyEventDispatcher.Component activity = getActivity();
        this.callBack = activity instanceof a ? (a) activity : null;
        return inflater.inflate(R.layout.dialog_change_cover, container);
    }

    @Override // androidx.appcompat.widget.Toolbar.OnMenuItemClickListener
    public boolean onMenuItemClick(@Nullable MenuItem item) {
        Integer numValueOf = item == null ? null : Integer.valueOf(item.getItemId());
        if (numValueOf != null && numValueOf.intValue() == R.id.menu_stop) {
            ChangeCoverViewModel changeCoverViewModelS = S();
            HashSet<b<?>> hashSet = changeCoverViewModelS.tasks.a;
            if ((hashSet == null ? 0 : hashSet.size()) == 0) {
                BaseViewModel.a(changeCoverViewModelS, null, null, new e.a.a.g.d.c.f(changeCoverViewModelS, null), 3, null);
            } else {
                changeCoverViewModelS.tasks.b();
                changeCoverViewModelS.searchStateData.postValue(Boolean.FALSE);
            }
        }
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

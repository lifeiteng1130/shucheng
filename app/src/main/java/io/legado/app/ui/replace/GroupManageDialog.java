package io.legado.app.ui.replace;

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
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.view.Observer;
import androidx.view.ViewModelProvider;
import androidx.view.ViewModelStore;
import androidx.viewbinding.ViewBinding;
import c.b.a.m.f;
import com.umeng.analytics.pro.ai;
import e.a.a.e.a.i;
import e.a.a.g.j.o;
import e.a.a.h.m;
import f.c0.b.l;
import f.c0.c.j;
import f.c0.c.k;
import f.c0.c.q;
import f.c0.c.v;
import f.e;
import f.f0.h;
import io.legado.app.base.BaseViewModel;
import io.legado.app.base.adapter.ItemViewHolder;
import io.legado.app.base.adapter.RecyclerAdapter;
import io.legado.app.data.AppDatabaseKt;
import io.legado.app.databinding.DialogRecyclerViewBinding;
import io.legado.app.databinding.ItemGroupManageBinding;
import io.legado.app.ui.replace.GroupManageDialog;
import io.legado.app.ui.replace.ReplaceRuleViewModel;
import io.legado.app.ui.widget.recycler.VerticalDivider;
import io.legado.app.ui.widget.recycler.scroller.FastScrollRecyclerView;
import io.legado.app.utils.viewbindingdelegate.ViewBindingProperty;
import io.wenyuange.app.release.R;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: GroupManageDialog.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002:\u0001(B\u0007¢\u0006\u0004\b'\u0010\u0005J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J-\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ!\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0004\b\u0015\u0010\u0016R\u001a\u0010\u001a\u001a\u00060\u0017R\u00020\u00008\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001d\u0010 \u001a\u00020\u001b8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001d\u0010&\u001a\u00020!8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%¨\u0006)"}, d2 = {"Lio/legado/app/ui/replace/GroupManageDialog;", "Landroidx/fragment/app/DialogFragment;", "Landroidx/appcompat/widget/Toolbar$OnMenuItemClickListener;", "Lf/v;", "onStart", "()V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Landroid/view/MenuItem;", "item", "", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Lio/legado/app/ui/replace/GroupManageDialog$a;", ai.aD, "Lio/legado/app/ui/replace/GroupManageDialog$a;", "adapter", "Lio/legado/app/databinding/DialogRecyclerViewBinding;", "d", "Lio/legado/app/utils/viewbindingdelegate/ViewBindingProperty;", "getBinding", "()Lio/legado/app/databinding/DialogRecyclerViewBinding;", "binding", "Lio/legado/app/ui/replace/ReplaceRuleViewModel;", "b", "Lf/e;", "getViewModel", "()Lio/legado/app/ui/replace/ReplaceRuleViewModel;", "viewModel", "<init>", ai.at, "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class GroupManageDialog extends DialogFragment implements Toolbar.OnMenuItemClickListener {
    public static final /* synthetic */ h<Object>[] a;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    public a adapter;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final e viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, v.a(ReplaceRuleViewModel.class), new b(this), new c(this));

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final ViewBindingProperty binding = f.b6(this, new d());

    /* JADX INFO: compiled from: GroupManageDialog.kt */
    public final class a extends RecyclerAdapter<String, ItemGroupManageBinding> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ GroupManageDialog f7471f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@NotNull GroupManageDialog groupManageDialog, Context context) {
            super(context);
            j.e(groupManageDialog, "this$0");
            j.e(context, com.umeng.analytics.pro.c.R);
            this.f7471f = groupManageDialog;
        }

        @Override // io.legado.app.base.adapter.RecyclerAdapter
        public void i(ItemViewHolder itemViewHolder, ViewBinding viewBinding, String str, List list, int i2) {
            ItemGroupManageBinding itemGroupManageBinding = (ItemGroupManageBinding) viewBinding;
            String str2 = str;
            j.e(itemViewHolder, "holder");
            j.e(itemGroupManageBinding, "binding");
            j.e(str2, "item");
            j.e(list, "payloads");
            itemGroupManageBinding.a.setBackgroundColor(f.R1(this.context));
            itemGroupManageBinding.f6794d.setText(str2);
        }

        @Override // io.legado.app.base.adapter.RecyclerAdapter
        public ViewBinding q(ViewGroup viewGroup) {
            j.e(viewGroup, "parent");
            ItemGroupManageBinding itemGroupManageBindingA = ItemGroupManageBinding.a(this.inflater, viewGroup, false);
            j.d(itemGroupManageBindingA, "inflate(inflater, parent, false)");
            return itemGroupManageBindingA;
        }

        @Override // io.legado.app.base.adapter.RecyclerAdapter
        public void w(final ItemViewHolder itemViewHolder, ViewBinding viewBinding) {
            ItemGroupManageBinding itemGroupManageBinding = (ItemGroupManageBinding) viewBinding;
            j.e(itemViewHolder, "holder");
            j.e(itemGroupManageBinding, "binding");
            final GroupManageDialog groupManageDialog = this.f7471f;
            itemGroupManageBinding.f6793c.setOnClickListener(new View.OnClickListener() { // from class: e.a.a.g.j.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    GroupManageDialog.a aVar = this.a;
                    ItemViewHolder itemViewHolder2 = itemViewHolder;
                    GroupManageDialog groupManageDialog2 = groupManageDialog;
                    f.c0.c.j.e(aVar, "this$0");
                    f.c0.c.j.e(itemViewHolder2, "$holder");
                    f.c0.c.j.e(groupManageDialog2, "this$1");
                    String item = aVar.getItem(itemViewHolder2.getLayoutPosition());
                    if (item == null) {
                        return;
                    }
                    f.f0.h<Object>[] hVarArr = GroupManageDialog.a;
                    String string = groupManageDialog2.getString(R.string.group_edit);
                    p pVar = new p(groupManageDialog2, item);
                    FragmentActivity fragmentActivityRequireActivity = groupManageDialog2.requireActivity();
                    f.c0.c.j.d(fragmentActivityRequireActivity, "requireActivity()");
                    c.b.a.m.f.J4(((e.a.a.e.a.i) c.b.a.m.f.g0(fragmentActivityRequireActivity, string, null, pVar)).p());
                }
            });
            itemGroupManageBinding.f6792b.setOnClickListener(new View.OnClickListener() { // from class: e.a.a.g.j.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    GroupManageDialog.a aVar = this.a;
                    ItemViewHolder itemViewHolder2 = itemViewHolder;
                    GroupManageDialog groupManageDialog2 = groupManageDialog;
                    f.c0.c.j.e(aVar, "this$0");
                    f.c0.c.j.e(itemViewHolder2, "$holder");
                    f.c0.c.j.e(groupManageDialog2, "this$1");
                    String item = aVar.getItem(itemViewHolder2.getLayoutPosition());
                    if (item == null) {
                        return;
                    }
                    ReplaceRuleViewModel replaceRuleViewModel = (ReplaceRuleViewModel) groupManageDialog2.viewModel.getValue();
                    Objects.requireNonNull(replaceRuleViewModel);
                    f.c0.c.j.e(item, "group");
                    BaseViewModel.a(replaceRuleViewModel, null, null, new t(replaceRuleViewModel, item, null), 3, null);
                }
            });
        }
    }

    /* JADX INFO: compiled from: FragmentViewModelLazy.kt */
    public static final class b extends k implements f.c0.b.a<ViewModelStore> {
        public final /* synthetic */ Fragment $this_activityViewModels;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Fragment fragment) {
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
    public static final class c extends k implements f.c0.b.a<ViewModelProvider.Factory> {
        public final /* synthetic */ Fragment $this_activityViewModels;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Fragment fragment) {
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
    public static final class d extends k implements l<GroupManageDialog, DialogRecyclerViewBinding> {
        public d() {
            super(1);
        }

        @Override // f.c0.b.l
        @NotNull
        public final DialogRecyclerViewBinding invoke(@NotNull GroupManageDialog groupManageDialog) {
            j.e(groupManageDialog, "fragment");
            return DialogRecyclerViewBinding.a(groupManageDialog.requireView());
        }
    }

    static {
        h<Object>[] hVarArr = new h[2];
        q qVar = new q(v.a(GroupManageDialog.class), "binding", "getBinding()Lio/legado/app/databinding/DialogRecyclerViewBinding;");
        Objects.requireNonNull(v.a);
        hVarArr[1] = qVar;
        a = hVarArr;
    }

    public static final ReplaceRuleViewModel N(GroupManageDialog groupManageDialog) {
        return (ReplaceRuleViewModel) groupManageDialog.viewModel.getValue();
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        j.e(inflater, "inflater");
        return inflater.inflate(R.layout.dialog_recycler_view, container);
    }

    @Override // androidx.appcompat.widget.Toolbar.OnMenuItemClickListener
    public boolean onMenuItemClick(@Nullable MenuItem item) {
        Integer numValueOf = item == null ? null : Integer.valueOf(item.getItemId());
        if (numValueOf == null || numValueOf.intValue() != R.id.menu_add) {
            return true;
        }
        String string = getString(R.string.add_group);
        o oVar = new o(this);
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        j.d(fragmentActivityRequireActivity, "requireActivity()");
        f.J4(((i) f.g0(fragmentActivityRequireActivity, string, null, oVar)).p());
        return true;
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

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        j.e(view, "view");
        super.onViewCreated(view, savedInstanceState);
        view.setBackgroundColor(f.S1(this));
        ViewBindingProperty viewBindingProperty = this.binding;
        h<?>[] hVarArr = a;
        ((DialogRecyclerViewBinding) viewBindingProperty.b(this, hVarArr[1])).f6672c.setBackgroundColor(f.Q2(this));
        DialogRecyclerViewBinding dialogRecyclerViewBinding = (DialogRecyclerViewBinding) this.binding.b(this, hVarArr[1]);
        dialogRecyclerViewBinding.f6672c.setTitle(getString(R.string.group_manage));
        dialogRecyclerViewBinding.f6672c.inflateMenu(R.menu.group_manage);
        Menu menu = dialogRecyclerViewBinding.f6672c.getMenu();
        j.d(menu, "toolBar.menu");
        Context contextRequireContext = requireContext();
        j.d(contextRequireContext, "requireContext()");
        m.b(menu, contextRequireContext, null, 2);
        dialogRecyclerViewBinding.f6672c.setOnMenuItemClickListener(this);
        Context contextRequireContext2 = requireContext();
        j.d(contextRequireContext2, "requireContext()");
        this.adapter = new a(this, contextRequireContext2);
        dialogRecyclerViewBinding.f6671b.setLayoutManager(new LinearLayoutManager(requireContext()));
        FastScrollRecyclerView fastScrollRecyclerView = dialogRecyclerViewBinding.f6671b;
        Context contextRequireContext3 = requireContext();
        j.d(contextRequireContext3, "requireContext()");
        fastScrollRecyclerView.addItemDecoration(new VerticalDivider(contextRequireContext3));
        FastScrollRecyclerView fastScrollRecyclerView2 = dialogRecyclerViewBinding.f6671b;
        a aVar = this.adapter;
        if (aVar == null) {
            j.m("adapter");
            throw null;
        }
        fastScrollRecyclerView2.setAdapter(aVar);
        AppDatabaseKt.getAppDb().getReplaceRuleDao().liveGroup().observe(getViewLifecycleOwner(), new Observer() { // from class: e.a.a.g.j.c
            @Override // androidx.view.Observer
            public final void onChanged(Object obj) {
                GroupManageDialog groupManageDialog = this.a;
                List<String> list = (List) obj;
                f.f0.h<Object>[] hVarArr2 = GroupManageDialog.a;
                f.c0.c.j.e(groupManageDialog, "this$0");
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                f.c0.c.j.d(list, "it");
                ArrayList arrayList = new ArrayList(c.b.a.m.f.S0(list, 10));
                for (String str : list) {
                    e.a.a.c.d dVar = e.a.a.c.d.a;
                    arrayList.add(Boolean.valueOf(c.b.a.m.f.T(linkedHashSet, c.b.a.m.f.o5(str, e.a.a.c.d.f5514h, 0, 2))));
                }
                GroupManageDialog.a aVar2 = groupManageDialog.adapter;
                if (aVar2 == null) {
                    f.c0.c.j.m("adapter");
                    throw null;
                }
                aVar2.x(f.x.e.F(linkedHashSet));
            }
        });
    }
}

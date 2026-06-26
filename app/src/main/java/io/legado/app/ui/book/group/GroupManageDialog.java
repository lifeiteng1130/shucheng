package io.legado.app.ui.book.group;

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
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.view.Observer;
import androidx.view.ViewModelStore;
import androidx.view.ViewModelStoreOwner;
import androidx.viewbinding.ViewBinding;
import c.b.a.m.f;
import com.umeng.analytics.pro.ai;
import e.a.a.e.a.i;
import e.a.a.h.m;
import f.c0.b.l;
import f.c0.c.j;
import f.c0.c.k;
import f.c0.c.q;
import f.c0.c.v;
import f.e;
import f.f0.h;
import io.legado.app.base.BaseDialogFragment;
import io.legado.app.base.adapter.ItemViewHolder;
import io.legado.app.base.adapter.RecyclerAdapter;
import io.legado.app.data.AppDatabaseKt;
import io.legado.app.data.entities.BookGroup;
import io.legado.app.databinding.DialogRecyclerViewBinding;
import io.legado.app.databinding.ItemBookGroupManageBinding;
import io.legado.app.lib.theme.view.ATESwitch;
import io.legado.app.ui.book.group.GroupManageDialog;
import io.legado.app.ui.book.group.GroupViewModel;
import io.legado.app.ui.widget.recycler.ItemTouchCallback;
import io.legado.app.ui.widget.recycler.VerticalDivider;
import io.legado.app.ui.widget.recycler.scroller.FastScrollRecyclerView;
import io.legado.app.ui.widget.text.AccentTextView;
import io.legado.app.utils.viewbindingdelegate.ViewBindingProperty;
import io.wenyuange.app.release.R;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: GroupManageDialog.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002:\u0001(B\u0007¢\u0006\u0004\b'\u0010\u0005J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J-\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ!\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0004\b\u0015\u0010\u0016R\u001d\u0010\u001c\u001a\u00020\u00178B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010 \u001a\u00060\u001dR\u00020\u00008\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u001d\u0010&\u001a\u00020!8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%¨\u0006)"}, d2 = {"Lio/legado/app/ui/book/group/GroupManageDialog;", "Lio/legado/app/base/BaseDialogFragment;", "Landroidx/appcompat/widget/Toolbar$OnMenuItemClickListener;", "Lf/v;", "onStart", "()V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "P", "(Landroid/view/View;Landroid/os/Bundle;)V", "Landroid/view/MenuItem;", "item", "", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Lio/legado/app/databinding/DialogRecyclerViewBinding;", "e", "Lio/legado/app/utils/viewbindingdelegate/ViewBindingProperty;", "R", "()Lio/legado/app/databinding/DialogRecyclerViewBinding;", "binding", "Lio/legado/app/ui/book/group/GroupManageDialog$a;", "d", "Lio/legado/app/ui/book/group/GroupManageDialog$a;", "adapter", "Lio/legado/app/ui/book/group/GroupViewModel;", ai.aD, "Lf/e;", "getViewModel", "()Lio/legado/app/ui/book/group/GroupViewModel;", "viewModel", "<init>", ai.at, "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class GroupManageDialog extends BaseDialogFragment implements Toolbar.OnMenuItemClickListener {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ h<Object>[] f7089b;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    public a adapter;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final e viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, v.a(GroupViewModel.class), new d(new c(this)), null);

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final ViewBindingProperty binding = f.b6(this, new b());

    /* JADX INFO: compiled from: GroupManageDialog.kt */
    public final class a extends RecyclerAdapter<BookGroup, ItemBookGroupManageBinding> implements ItemTouchCallback.a {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f7093f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ GroupManageDialog f7094g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@NotNull GroupManageDialog groupManageDialog, Context context) {
            super(context);
            j.e(groupManageDialog, "this$0");
            j.e(context, com.umeng.analytics.pro.c.R);
            this.f7094g = groupManageDialog;
        }

        @Override // io.legado.app.ui.widget.recycler.ItemTouchCallback.a
        public void a(int i2) {
            j.e(this, "this");
        }

        @Override // io.legado.app.ui.widget.recycler.ItemTouchCallback.a
        public void b(@NotNull RecyclerView recyclerView, @NotNull RecyclerView.ViewHolder viewHolder) {
            j.e(recyclerView, "recyclerView");
            j.e(viewHolder, "viewHolder");
            if (this.f7093f) {
                Iterator it = this.items.iterator();
                int i2 = 0;
                while (it.hasNext()) {
                    i2++;
                    ((BookGroup) it.next()).setOrder(i2);
                }
                GroupViewModel groupViewModelQ = GroupManageDialog.Q(this.f7094g);
                Object[] array = this.items.toArray(new BookGroup[0]);
                Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
                BookGroup[] bookGroupArr = (BookGroup[]) array;
                groupViewModelQ.f((BookGroup[]) Arrays.copyOf(bookGroupArr, bookGroupArr.length));
            }
            this.f7093f = false;
        }

        @Override // io.legado.app.ui.widget.recycler.ItemTouchCallback.a
        public boolean c(int i2, int i3) {
            z(i2, i3);
            this.f7093f = true;
            return true;
        }

        @Override // io.legado.app.base.adapter.RecyclerAdapter
        public void i(ItemViewHolder itemViewHolder, ViewBinding viewBinding, BookGroup bookGroup, List list, int i2) {
            ItemBookGroupManageBinding itemBookGroupManageBinding = (ItemBookGroupManageBinding) viewBinding;
            BookGroup bookGroup2 = bookGroup;
            j.e(itemViewHolder, "holder");
            j.e(itemBookGroupManageBinding, "binding");
            j.e(bookGroup2, "item");
            j.e(list, "payloads");
            itemBookGroupManageBinding.a.setBackgroundColor(f.R1(this.context));
            itemBookGroupManageBinding.f6748d.setText(bookGroup2.getManageName(this.context));
            itemBookGroupManageBinding.f6746b.setChecked(bookGroup2.getShow());
        }

        @Override // io.legado.app.base.adapter.RecyclerAdapter
        public ViewBinding q(ViewGroup viewGroup) {
            j.e(viewGroup, "parent");
            View viewInflate = this.inflater.inflate(R.layout.item_book_group_manage, viewGroup, false);
            int i2 = R.id.sw_show;
            ATESwitch aTESwitch = (ATESwitch) viewInflate.findViewById(R.id.sw_show);
            if (aTESwitch != null) {
                i2 = R.id.tv_edit;
                TextView textView = (TextView) viewInflate.findViewById(R.id.tv_edit);
                if (textView != null) {
                    i2 = R.id.tv_group;
                    TextView textView2 = (TextView) viewInflate.findViewById(R.id.tv_group);
                    if (textView2 != null) {
                        ItemBookGroupManageBinding itemBookGroupManageBinding = new ItemBookGroupManageBinding((LinearLayout) viewInflate, aTESwitch, textView, textView2);
                        j.d(itemBookGroupManageBinding, "inflate(inflater, parent, false)");
                        return itemBookGroupManageBinding;
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i2)));
        }

        @Override // io.legado.app.base.adapter.RecyclerAdapter
        public void w(final ItemViewHolder itemViewHolder, ViewBinding viewBinding) {
            ItemBookGroupManageBinding itemBookGroupManageBinding = (ItemBookGroupManageBinding) viewBinding;
            j.e(itemViewHolder, "holder");
            j.e(itemBookGroupManageBinding, "binding");
            final GroupManageDialog groupManageDialog = this.f7094g;
            itemBookGroupManageBinding.f6747c.setOnClickListener(new View.OnClickListener() { // from class: e.a.a.g.d.f.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    GroupManageDialog.a aVar = this.a;
                    ItemViewHolder itemViewHolder2 = itemViewHolder;
                    GroupManageDialog groupManageDialog2 = groupManageDialog;
                    f.c0.c.j.e(aVar, "this$0");
                    f.c0.c.j.e(itemViewHolder2, "$holder");
                    f.c0.c.j.e(groupManageDialog2, "this$1");
                    BookGroup item = aVar.getItem(itemViewHolder2.getLayoutPosition());
                    if (item == null) {
                        return;
                    }
                    f.f0.h<Object>[] hVarArr = GroupManageDialog.f7089b;
                    String string = groupManageDialog2.getString(R.string.group_edit);
                    l lVar = new l(groupManageDialog2, item);
                    FragmentActivity fragmentActivityRequireActivity = groupManageDialog2.requireActivity();
                    f.c0.c.j.d(fragmentActivityRequireActivity, "requireActivity()");
                    c.b.a.m.f.J4(((e.a.a.e.a.i) c.b.a.m.f.g0(fragmentActivityRequireActivity, string, null, lVar)).p());
                }
            });
            itemBookGroupManageBinding.f6746b.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: e.a.a.g.d.f.b
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    BookGroup item;
                    GroupManageDialog.a aVar = this.a;
                    ItemViewHolder itemViewHolder2 = itemViewHolder;
                    GroupManageDialog groupManageDialog2 = groupManageDialog;
                    f.c0.c.j.e(aVar, "this$0");
                    f.c0.c.j.e(itemViewHolder2, "$holder");
                    f.c0.c.j.e(groupManageDialog2, "this$1");
                    if (!compoundButton.isPressed() || (item = aVar.getItem(itemViewHolder2.getLayoutPosition())) == null) {
                        return;
                    }
                    ((GroupViewModel) groupManageDialog2.viewModel.getValue()).f(BookGroup.copy$default(item, 0L, null, 0, z, 7, null));
                }
            });
        }
    }

    /* JADX INFO: compiled from: FragmentViewBindings.kt */
    public static final class b extends k implements l<GroupManageDialog, DialogRecyclerViewBinding> {
        public b() {
            super(1);
        }

        @Override // f.c0.b.l
        @NotNull
        public final DialogRecyclerViewBinding invoke(@NotNull GroupManageDialog groupManageDialog) {
            j.e(groupManageDialog, "fragment");
            return DialogRecyclerViewBinding.a(groupManageDialog.requireView());
        }
    }

    /* JADX INFO: compiled from: FragmentViewModelLazy.kt */
    public static final class c extends k implements f.c0.b.a<Fragment> {
        public final /* synthetic */ Fragment $this_viewModels;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Fragment fragment) {
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
    public static final class d extends k implements f.c0.b.a<ViewModelStore> {
        public final /* synthetic */ f.c0.b.a $ownerProducer;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(f.c0.b.a aVar) {
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
        q qVar = new q(v.a(GroupManageDialog.class), "binding", "getBinding()Lio/legado/app/databinding/DialogRecyclerViewBinding;");
        Objects.requireNonNull(v.a);
        hVarArr[1] = qVar;
        f7089b = hVarArr;
    }

    public static final GroupViewModel Q(GroupManageDialog groupManageDialog) {
        return (GroupViewModel) groupManageDialog.viewModel.getValue();
    }

    @Override // io.legado.app.base.BaseDialogFragment
    public void P(@NotNull View view, @Nullable Bundle savedInstanceState) {
        j.e(view, "view");
        R().f6672c.setBackgroundColor(f.Q2(this));
        R().f6672c.setTitle(getString(R.string.group_manage));
        Context contextRequireContext = requireContext();
        j.d(contextRequireContext, "requireContext()");
        this.adapter = new a(this, contextRequireContext);
        R().f6671b.setLayoutManager(new LinearLayoutManager(requireContext()));
        FastScrollRecyclerView fastScrollRecyclerView = R().f6671b;
        Context contextRequireContext2 = requireContext();
        j.d(contextRequireContext2, "requireContext()");
        fastScrollRecyclerView.addItemDecoration(new VerticalDivider(contextRequireContext2));
        FastScrollRecyclerView fastScrollRecyclerView2 = R().f6671b;
        a aVar = this.adapter;
        if (aVar == null) {
            j.m("adapter");
            throw null;
        }
        fastScrollRecyclerView2.setAdapter(aVar);
        a aVar2 = this.adapter;
        if (aVar2 == null) {
            j.m("adapter");
            throw null;
        }
        ItemTouchCallback itemTouchCallback = new ItemTouchCallback(aVar2);
        itemTouchCallback.isCanDrag = true;
        new ItemTouchHelper(itemTouchCallback).attachToRecyclerView(R().f6671b);
        AccentTextView accentTextView = R().f6675f;
        Context contextRequireContext3 = requireContext();
        j.d(contextRequireContext3, "requireContext()");
        accentTextView.setTextColor(f.M1(contextRequireContext3));
        AccentTextView accentTextView2 = R().f6675f;
        j.d(accentTextView2, "binding.tvOk");
        f.c6(accentTextView2);
        R().f6675f.setOnClickListener(new View.OnClickListener() { // from class: e.a.a.g.d.f.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                GroupManageDialog groupManageDialog = this.a;
                f.f0.h<Object>[] hVarArr = GroupManageDialog.f7089b;
                f.c0.c.j.e(groupManageDialog, "this$0");
                groupManageDialog.dismissAllowingStateLoss();
            }
        });
        AppDatabaseKt.getAppDb().getBookGroupDao().liveDataAll().observe(getViewLifecycleOwner(), new Observer() { // from class: e.a.a.g.d.f.d
            @Override // androidx.view.Observer
            public final void onChanged(Object obj) {
                GroupManageDialog groupManageDialog = this.a;
                List list = (List) obj;
                f.f0.h<Object>[] hVarArr = GroupManageDialog.f7089b;
                f.c0.c.j.e(groupManageDialog, "this$0");
                GroupManageDialog.a aVar3 = groupManageDialog.adapter;
                if (aVar3 != null) {
                    aVar3.x(list);
                } else {
                    f.c0.c.j.m("adapter");
                    throw null;
                }
            }
        });
        R().f6672c.setOnMenuItemClickListener(this);
        R().f6672c.inflateMenu(R.menu.book_group_manage);
        Menu menu = R().f6672c.getMenu();
        j.d(menu, "binding.toolBar.menu");
        Context contextRequireContext4 = requireContext();
        j.d(contextRequireContext4, "requireContext()");
        m.b(menu, contextRequireContext4, null, 2);
    }

    public final DialogRecyclerViewBinding R() {
        return (DialogRecyclerViewBinding) this.binding.b(this, f7089b[1]);
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
        e.a.a.g.d.f.j jVar = new e.a.a.g.d.f.j(this);
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        j.d(fragmentActivityRequireActivity, "requireActivity()");
        f.J4(((i) f.g0(fragmentActivityRequireActivity, string, null, jVar)).p());
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
}

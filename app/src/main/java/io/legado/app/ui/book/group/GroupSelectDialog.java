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
import androidx.core.view.KeyEventDispatcher;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.view.Observer;
import androidx.view.ViewModelStore;
import androidx.view.ViewModelStoreOwner;
import androidx.viewbinding.ViewBinding;
import com.umeng.analytics.pro.ai;
import e.a.a.e.a.i;
import e.a.a.h.m;
import f.c0.b.l;
import f.c0.c.j;
import f.c0.c.k;
import f.c0.c.q;
import f.c0.c.v;
import f.f0.h;
import io.legado.app.base.BaseDialogFragment;
import io.legado.app.base.adapter.ItemViewHolder;
import io.legado.app.base.adapter.RecyclerAdapter;
import io.legado.app.data.AppDatabaseKt;
import io.legado.app.data.entities.BookGroup;
import io.legado.app.databinding.DialogBookGroupPickerBinding;
import io.legado.app.databinding.ItemGroupSelectBinding;
import io.legado.app.lib.theme.view.ATECheckBox;
import io.legado.app.ui.book.group.GroupSelectDialog;
import io.legado.app.ui.widget.recycler.ItemTouchCallback;
import io.legado.app.ui.widget.recycler.VerticalDivider;
import io.legado.app.utils.viewbindingdelegate.ViewBindingProperty;
import io.wenyuange.app.release.R;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mozilla.javascript.optimizer.OptRuntime;

/* JADX INFO: compiled from: GroupSelectDialog.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\u0018\u0000 42\u00020\u00012\u00020\u0002:\u0003546B\u0007¢\u0006\u0004\b3\u0010\u0005J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J-\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ!\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0004\b\u0015\u0010\u0016R\u001d\u0010\u001c\u001a\u00020\u00178B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001d\u0010\"\u001a\u00020\u001d8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u0018\u0010&\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010)R\u001a\u0010.\u001a\u00060+R\u00020\u00008\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u00101¨\u00067"}, d2 = {"Lio/legado/app/ui/book/group/GroupSelectDialog;", "Lio/legado/app/base/BaseDialogFragment;", "Landroidx/appcompat/widget/Toolbar$OnMenuItemClickListener;", "Lf/v;", "onStart", "()V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "P", "(Landroid/view/View;Landroid/os/Bundle;)V", "Landroid/view/MenuItem;", "item", "", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Lio/legado/app/ui/book/group/GroupViewModel;", "f", "Lf/e;", "getViewModel", "()Lio/legado/app/ui/book/group/GroupViewModel;", "viewModel", "Lio/legado/app/databinding/DialogBookGroupPickerBinding;", "d", "Lio/legado/app/utils/viewbindingdelegate/ViewBindingProperty;", "R", "()Lio/legado/app/databinding/DialogBookGroupPickerBinding;", "binding", "Lio/legado/app/ui/book/group/GroupSelectDialog$a;", "h", "Lio/legado/app/ui/book/group/GroupSelectDialog$a;", "callBack", "", ai.aA, "J", "groupId", "Lio/legado/app/ui/book/group/GroupSelectDialog$c;", "g", "Lio/legado/app/ui/book/group/GroupSelectDialog$c;", "adapter", "", "e", OptRuntime.GeneratorState.resumptionPoint_TYPE, "requestCode", "<init>", "b", ai.at, ai.aD, "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class GroupSelectDialog extends BaseDialogFragment implements Toolbar.OnMenuItemClickListener {

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ h<Object>[] f7096c;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final ViewBindingProperty binding = c.b.a.m.f.b6(this, new d());

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    public int requestCode = -1;

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final f.e viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, v.a(GroupViewModel.class), new f(new e(this)), null);

    /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
    public c adapter;

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public a callBack;

    /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
    public long groupId;

    /* JADX INFO: compiled from: GroupSelectDialog.kt */
    public interface a {
        void L(int i2, long j2);
    }

    /* JADX INFO: renamed from: io.legado.app.ui.book.group.GroupSelectDialog$b, reason: from kotlin metadata */
    /* JADX INFO: compiled from: GroupSelectDialog.kt */
    public static final class Companion {
        public Companion(f.c0.c.f fVar) {
        }

        public final void a(@NotNull FragmentManager fragmentManager, long j2, int i2) {
            j.e(fragmentManager, "manager");
            GroupSelectDialog groupSelectDialog = new GroupSelectDialog();
            Bundle bundle = new Bundle();
            bundle.putLong("groupId", j2);
            bundle.putInt("requestCode", i2);
            groupSelectDialog.setArguments(bundle);
            groupSelectDialog.show(fragmentManager, "groupSelectDialog");
        }
    }

    /* JADX INFO: compiled from: GroupSelectDialog.kt */
    public final class c extends RecyclerAdapter<BookGroup, ItemGroupSelectBinding> implements ItemTouchCallback.a {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f7103f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ GroupSelectDialog f7104g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(@NotNull GroupSelectDialog groupSelectDialog, Context context) {
            super(context);
            j.e(groupSelectDialog, "this$0");
            j.e(context, com.umeng.analytics.pro.c.R);
            this.f7104g = groupSelectDialog;
        }

        @Override // io.legado.app.ui.widget.recycler.ItemTouchCallback.a
        public void a(int i2) {
            j.e(this, "this");
        }

        @Override // io.legado.app.ui.widget.recycler.ItemTouchCallback.a
        public void b(@NotNull RecyclerView recyclerView, @NotNull RecyclerView.ViewHolder viewHolder) {
            j.e(recyclerView, "recyclerView");
            j.e(viewHolder, "viewHolder");
            if (this.f7103f) {
                Iterator it = this.items.iterator();
                int i2 = 0;
                while (it.hasNext()) {
                    i2++;
                    ((BookGroup) it.next()).setOrder(i2);
                }
                GroupViewModel groupViewModelQ = GroupSelectDialog.Q(this.f7104g);
                Object[] array = this.items.toArray(new BookGroup[0]);
                Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
                BookGroup[] bookGroupArr = (BookGroup[]) array;
                groupViewModelQ.f((BookGroup[]) Arrays.copyOf(bookGroupArr, bookGroupArr.length));
            }
            this.f7103f = false;
        }

        @Override // io.legado.app.ui.widget.recycler.ItemTouchCallback.a
        public boolean c(int i2, int i3) {
            z(i2, i3);
            this.f7103f = true;
            return true;
        }

        @Override // io.legado.app.base.adapter.RecyclerAdapter
        public void i(ItemViewHolder itemViewHolder, ViewBinding viewBinding, BookGroup bookGroup, List list, int i2) {
            ItemGroupSelectBinding itemGroupSelectBinding = (ItemGroupSelectBinding) viewBinding;
            BookGroup bookGroup2 = bookGroup;
            j.e(itemViewHolder, "holder");
            j.e(itemGroupSelectBinding, "binding");
            j.e(bookGroup2, "item");
            j.e(list, "payloads");
            GroupSelectDialog groupSelectDialog = this.f7104g;
            itemGroupSelectBinding.a.setBackgroundColor(c.b.a.m.f.R1(this.context));
            itemGroupSelectBinding.f6795b.setText(bookGroup2.getGroupName());
            itemGroupSelectBinding.f6795b.setChecked((bookGroup2.getGroupId() & groupSelectDialog.groupId) > 0);
        }

        @Override // io.legado.app.base.adapter.RecyclerAdapter
        public ViewBinding q(ViewGroup viewGroup) {
            j.e(viewGroup, "parent");
            View viewInflate = this.inflater.inflate(R.layout.item_group_select, viewGroup, false);
            int i2 = R.id.cb_group;
            ATECheckBox aTECheckBox = (ATECheckBox) viewInflate.findViewById(R.id.cb_group);
            if (aTECheckBox != null) {
                i2 = R.id.tv_edit;
                TextView textView = (TextView) viewInflate.findViewById(R.id.tv_edit);
                if (textView != null) {
                    ItemGroupSelectBinding itemGroupSelectBinding = new ItemGroupSelectBinding((LinearLayout) viewInflate, aTECheckBox, textView);
                    j.d(itemGroupSelectBinding, "inflate(inflater, parent, false)");
                    return itemGroupSelectBinding;
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i2)));
        }

        @Override // io.legado.app.base.adapter.RecyclerAdapter
        public void w(final ItemViewHolder itemViewHolder, ViewBinding viewBinding) {
            ItemGroupSelectBinding itemGroupSelectBinding = (ItemGroupSelectBinding) viewBinding;
            j.e(itemViewHolder, "holder");
            j.e(itemGroupSelectBinding, "binding");
            final GroupSelectDialog groupSelectDialog = this.f7104g;
            itemGroupSelectBinding.f6795b.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: e.a.a.g.d.f.g
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    BookGroup item;
                    GroupSelectDialog.c cVar = this.a;
                    ItemViewHolder itemViewHolder2 = itemViewHolder;
                    GroupSelectDialog groupSelectDialog2 = groupSelectDialog;
                    f.c0.c.j.e(cVar, "this$0");
                    f.c0.c.j.e(itemViewHolder2, "$holder");
                    f.c0.c.j.e(groupSelectDialog2, "this$1");
                    if (!compoundButton.isPressed() || (item = cVar.getItem(itemViewHolder2.getLayoutPosition())) == null) {
                        return;
                    }
                    groupSelectDialog2.groupId = z ? item.getGroupId() + groupSelectDialog2.groupId : groupSelectDialog2.groupId - item.getGroupId();
                }
            });
            itemGroupSelectBinding.f6796c.setOnClickListener(new View.OnClickListener() { // from class: e.a.a.g.d.f.h
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    GroupSelectDialog.c cVar = this.a;
                    ItemViewHolder itemViewHolder2 = itemViewHolder;
                    GroupSelectDialog groupSelectDialog2 = groupSelectDialog;
                    f.c0.c.j.e(cVar, "this$0");
                    f.c0.c.j.e(itemViewHolder2, "$holder");
                    f.c0.c.j.e(groupSelectDialog2, "this$1");
                    BookGroup item = cVar.getItem(itemViewHolder2.getLayoutPosition());
                    if (item == null) {
                        return;
                    }
                    GroupSelectDialog.Companion companion = GroupSelectDialog.INSTANCE;
                    String string = groupSelectDialog2.getString(R.string.group_edit);
                    n nVar = new n(groupSelectDialog2, item);
                    FragmentActivity fragmentActivityRequireActivity = groupSelectDialog2.requireActivity();
                    f.c0.c.j.d(fragmentActivityRequireActivity, "requireActivity()");
                    c.b.a.m.f.J4(((e.a.a.e.a.i) c.b.a.m.f.g0(fragmentActivityRequireActivity, string, null, nVar)).p());
                }
            });
        }
    }

    /* JADX INFO: compiled from: FragmentViewBindings.kt */
    public static final class d extends k implements l<GroupSelectDialog, DialogBookGroupPickerBinding> {
        public d() {
            super(1);
        }

        @Override // f.c0.b.l
        @NotNull
        public final DialogBookGroupPickerBinding invoke(@NotNull GroupSelectDialog groupSelectDialog) {
            j.e(groupSelectDialog, "fragment");
            View viewRequireView = groupSelectDialog.requireView();
            int i2 = R.id.recycler_view;
            RecyclerView recyclerView = (RecyclerView) viewRequireView.findViewById(R.id.recycler_view);
            if (recyclerView != null) {
                i2 = R.id.tool_bar;
                Toolbar toolbar = (Toolbar) viewRequireView.findViewById(R.id.tool_bar);
                if (toolbar != null) {
                    i2 = R.id.tv_cancel;
                    TextView textView = (TextView) viewRequireView.findViewById(R.id.tv_cancel);
                    if (textView != null) {
                        i2 = R.id.tv_ok;
                        TextView textView2 = (TextView) viewRequireView.findViewById(R.id.tv_ok);
                        if (textView2 != null) {
                            return new DialogBookGroupPickerBinding((LinearLayout) viewRequireView, recyclerView, toolbar, textView, textView2);
                        }
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(viewRequireView.getResources().getResourceName(i2)));
        }
    }

    /* JADX INFO: compiled from: FragmentViewModelLazy.kt */
    public static final class e extends k implements f.c0.b.a<Fragment> {
        public final /* synthetic */ Fragment $this_viewModels;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(Fragment fragment) {
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
    public static final class f extends k implements f.c0.b.a<ViewModelStore> {
        public final /* synthetic */ f.c0.b.a $ownerProducer;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(f.c0.b.a aVar) {
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
        q qVar = new q(v.a(GroupSelectDialog.class), "binding", "getBinding()Lio/legado/app/databinding/DialogBookGroupPickerBinding;");
        Objects.requireNonNull(v.a);
        hVarArr[0] = qVar;
        f7096c = hVarArr;
        INSTANCE = new Companion(null);
    }

    public static final GroupViewModel Q(GroupSelectDialog groupSelectDialog) {
        return (GroupViewModel) groupSelectDialog.viewModel.getValue();
    }

    @Override // io.legado.app.base.BaseDialogFragment
    public void P(@NotNull View view, @Nullable Bundle savedInstanceState) {
        j.e(view, "view");
        R().f6584c.setBackgroundColor(c.b.a.m.f.Q2(this));
        KeyEventDispatcher.Component activity = getActivity();
        this.callBack = activity instanceof a ? (a) activity : null;
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.groupId = arguments.getLong("groupId");
            this.requestCode = arguments.getInt("requestCode", -1);
        }
        R().f6584c.setTitle(getString(R.string.group_select));
        R().f6584c.inflateMenu(R.menu.book_group_manage);
        Menu menu = R().f6584c.getMenu();
        j.d(menu, "binding.toolBar.menu");
        Context contextRequireContext = requireContext();
        j.d(contextRequireContext, "requireContext()");
        m.b(menu, contextRequireContext, null, 2);
        R().f6584c.setOnMenuItemClickListener(this);
        Context contextRequireContext2 = requireContext();
        j.d(contextRequireContext2, "requireContext()");
        this.adapter = new c(this, contextRequireContext2);
        R().f6583b.setLayoutManager(new LinearLayoutManager(requireContext()));
        RecyclerView recyclerView = R().f6583b;
        Context contextRequireContext3 = requireContext();
        j.d(contextRequireContext3, "requireContext()");
        recyclerView.addItemDecoration(new VerticalDivider(contextRequireContext3));
        RecyclerView recyclerView2 = R().f6583b;
        c cVar = this.adapter;
        if (cVar == null) {
            j.m("adapter");
            throw null;
        }
        recyclerView2.setAdapter(cVar);
        c cVar2 = this.adapter;
        if (cVar2 == null) {
            j.m("adapter");
            throw null;
        }
        ItemTouchCallback itemTouchCallback = new ItemTouchCallback(cVar2);
        itemTouchCallback.isCanDrag = true;
        new ItemTouchHelper(itemTouchCallback).attachToRecyclerView(R().f6583b);
        R().f6585d.setOnClickListener(new View.OnClickListener() { // from class: e.a.a.g.d.f.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                GroupSelectDialog groupSelectDialog = this.a;
                GroupSelectDialog.Companion companion = GroupSelectDialog.INSTANCE;
                f.c0.c.j.e(groupSelectDialog, "this$0");
                groupSelectDialog.dismissAllowingStateLoss();
            }
        });
        TextView textView = R().f6586e;
        Context contextRequireContext4 = requireContext();
        j.d(contextRequireContext4, "requireContext()");
        textView.setTextColor(c.b.a.m.f.M1(contextRequireContext4));
        R().f6586e.setOnClickListener(new View.OnClickListener() { // from class: e.a.a.g.d.f.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                GroupSelectDialog groupSelectDialog = this.a;
                GroupSelectDialog.Companion companion = GroupSelectDialog.INSTANCE;
                f.c0.c.j.e(groupSelectDialog, "this$0");
                GroupSelectDialog.a aVar = groupSelectDialog.callBack;
                if (aVar != null) {
                    aVar.L(groupSelectDialog.requestCode, groupSelectDialog.groupId);
                }
                groupSelectDialog.dismissAllowingStateLoss();
            }
        });
        AppDatabaseKt.getAppDb().getBookGroupDao().liveDataSelect().observe(getViewLifecycleOwner(), new Observer() { // from class: e.a.a.g.d.f.i
            @Override // androidx.view.Observer
            public final void onChanged(Object obj) {
                GroupSelectDialog groupSelectDialog = this.a;
                List list = (List) obj;
                GroupSelectDialog.Companion companion = GroupSelectDialog.INSTANCE;
                f.c0.c.j.e(groupSelectDialog, "this$0");
                GroupSelectDialog.c cVar3 = groupSelectDialog.adapter;
                if (cVar3 != null) {
                    cVar3.x(list);
                } else {
                    f.c0.c.j.m("adapter");
                    throw null;
                }
            }
        });
    }

    public final DialogBookGroupPickerBinding R() {
        return (DialogBookGroupPickerBinding) this.binding.b(this, f7096c[0]);
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        j.e(inflater, "inflater");
        return inflater.inflate(R.layout.dialog_book_group_picker, container);
    }

    @Override // androidx.appcompat.widget.Toolbar.OnMenuItemClickListener
    public boolean onMenuItemClick(@Nullable MenuItem item) {
        Integer numValueOf = item == null ? null : Integer.valueOf(item.getItemId());
        if (numValueOf == null || numValueOf.intValue() != R.id.menu_add) {
            return true;
        }
        String string = getString(R.string.add_group);
        e.a.a.g.d.f.m mVar = new e.a.a.g.d.f.m(this);
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        j.d(fragmentActivityRequireActivity, "requireActivity()");
        c.b.a.m.f.J4(((i) c.b.a.m.f.g0(fragmentActivityRequireActivity, string, null, mVar)).p());
        return true;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        Window window;
        super.onStart();
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        j.d(fragmentActivityRequireActivity, "requireActivity()");
        DisplayMetrics displayMetricsV2 = c.b.a.m.f.V2(fragmentActivityRequireActivity);
        Dialog dialog = getDialog();
        if (dialog == null || (window = dialog.getWindow()) == null) {
            return;
        }
        window.setLayout((int) (((double) displayMetricsV2.widthPixels) * 0.9d), (int) (((double) displayMetricsV2.heightPixels) * 0.9d));
    }
}

package io.legado.app.ui.association;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.CompoundButton;
import android.widget.ScrollView;
import androidx.appcompat.widget.Toolbar;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.view.ViewModelProvider;
import androidx.view.ViewModelStore;
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
import io.legado.app.base.BaseViewModel;
import io.legado.app.base.adapter.ItemViewHolder;
import io.legado.app.base.adapter.RecyclerAdapter;
import io.legado.app.data.AppDatabaseKt;
import io.legado.app.data.entities.BookSource;
import io.legado.app.databinding.DialogEditTextBinding;
import io.legado.app.databinding.DialogRecyclerViewBinding;
import io.legado.app.databinding.ItemSourceImportBinding;
import io.legado.app.lib.theme.view.ATECheckBox;
import io.legado.app.ui.association.ImportBookSourceDialog;
import io.legado.app.ui.association.ImportBookSourceViewModel;
import io.legado.app.ui.widget.text.AccentTextView;
import io.legado.app.utils.viewbindingdelegate.ViewBindingProperty;
import io.wenyuange.app.release.R;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ImportBookSourceDialog.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u00012\u00020\u0002:\u00011B\u0007¢\u0006\u0004\b0\u0010\u0005J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J-\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ!\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0012H\u0017¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u001b\u0010\u0005R\u001d\u0010!\u001a\u00020\u001c8F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001d\u0010'\u001a\u00020\"8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R&\u0010/\u001a\u00060(R\u00020\u00008\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.¨\u00062"}, d2 = {"Lio/legado/app/ui/association/ImportBookSourceDialog;", "Lio/legado/app/base/BaseDialogFragment;", "Landroidx/appcompat/widget/Toolbar$OnMenuItemClickListener;", "Lf/v;", "onStart", "()V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "P", "(Landroid/view/View;Landroid/os/Bundle;)V", "Landroid/view/MenuItem;", "item", "", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Landroid/content/DialogInterface;", "dialog", "onDismiss", "(Landroid/content/DialogInterface;)V", ExifInterface.GPS_DIRECTION_TRUE, "Lio/legado/app/ui/association/ImportBookSourceViewModel;", "d", "Lf/e;", ExifInterface.LATITUDE_SOUTH, "()Lio/legado/app/ui/association/ImportBookSourceViewModel;", "viewModel", "Lio/legado/app/databinding/DialogRecyclerViewBinding;", ai.aD, "Lio/legado/app/utils/viewbindingdelegate/ViewBindingProperty;", "R", "()Lio/legado/app/databinding/DialogRecyclerViewBinding;", "binding", "Lio/legado/app/ui/association/ImportBookSourceDialog$SourcesAdapter;", "e", "Lio/legado/app/ui/association/ImportBookSourceDialog$SourcesAdapter;", "Q", "()Lio/legado/app/ui/association/ImportBookSourceDialog$SourcesAdapter;", "setAdapter", "(Lio/legado/app/ui/association/ImportBookSourceDialog$SourcesAdapter;)V", "adapter", "<init>", "SourcesAdapter", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class ImportBookSourceDialog extends BaseDialogFragment implements Toolbar.OnMenuItemClickListener {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ h<Object>[] f6986b;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final ViewBindingProperty binding = f.b6(this, new d());

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final e viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, v.a(ImportBookSourceViewModel.class), new b(this), new c(this));

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    public SourcesAdapter adapter;

    /* JADX INFO: compiled from: ImportBookSourceDialog.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lio/legado/app/ui/association/ImportBookSourceDialog$SourcesAdapter;", "Lio/legado/app/base/adapter/RecyclerAdapter;", "Lio/legado/app/data/entities/BookSource;", "Lio/legado/app/databinding/ItemSourceImportBinding;", "Landroid/content/Context;", com.umeng.analytics.pro.c.R, "<init>", "(Lio/legado/app/ui/association/ImportBookSourceDialog;Landroid/content/Context;)V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
    public final class SourcesAdapter extends RecyclerAdapter<BookSource, ItemSourceImportBinding> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ ImportBookSourceDialog f6990f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SourcesAdapter(@NotNull ImportBookSourceDialog importBookSourceDialog, Context context) {
            super(context);
            j.e(importBookSourceDialog, "this$0");
            j.e(context, com.umeng.analytics.pro.c.R);
            this.f6990f = importBookSourceDialog;
        }

        @Override // io.legado.app.base.adapter.RecyclerAdapter
        public void i(ItemViewHolder itemViewHolder, ViewBinding viewBinding, BookSource bookSource, List list, int i2) {
            ItemSourceImportBinding itemSourceImportBinding = (ItemSourceImportBinding) viewBinding;
            BookSource bookSource2 = bookSource;
            j.e(itemViewHolder, "holder");
            j.e(itemSourceImportBinding, "binding");
            j.e(bookSource2, "item");
            j.e(list, "payloads");
            ImportBookSourceDialog importBookSourceDialog = this.f6990f;
            ATECheckBox aTECheckBox = itemSourceImportBinding.f6850b;
            Boolean bool = importBookSourceDialog.S().selectStatus.get(itemViewHolder.getLayoutPosition());
            j.d(bool, "viewModel.selectStatus[holder.layoutPosition]");
            aTECheckBox.setChecked(bool.booleanValue());
            itemSourceImportBinding.f6850b.setText(bookSource2.getBookSourceName());
            BookSource bookSource3 = importBookSourceDialog.S().checkSources.get(itemViewHolder.getLayoutPosition());
            itemSourceImportBinding.f6851c.setText(bookSource3 == null ? "新书源" : bookSource2.getLastUpdateTime() > bookSource3.getLastUpdateTime() ? "更新" : "已存在");
        }

        @Override // io.legado.app.base.adapter.RecyclerAdapter
        public ViewBinding q(ViewGroup viewGroup) {
            j.e(viewGroup, "parent");
            ItemSourceImportBinding itemSourceImportBindingA = ItemSourceImportBinding.a(this.inflater, viewGroup, false);
            j.d(itemSourceImportBindingA, "inflate(inflater, parent, false)");
            return itemSourceImportBindingA;
        }

        @Override // io.legado.app.base.adapter.RecyclerAdapter
        public void w(final ItemViewHolder itemViewHolder, ViewBinding viewBinding) {
            ItemSourceImportBinding itemSourceImportBinding = (ItemSourceImportBinding) viewBinding;
            j.e(itemViewHolder, "holder");
            j.e(itemSourceImportBinding, "binding");
            final ImportBookSourceDialog importBookSourceDialog = this.f6990f;
            itemSourceImportBinding.f6850b.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: e.a.a.g.b.g
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    ImportBookSourceDialog importBookSourceDialog2 = importBookSourceDialog;
                    ItemViewHolder itemViewHolder2 = itemViewHolder;
                    f.c0.c.j.e(importBookSourceDialog2, "this$0");
                    f.c0.c.j.e(itemViewHolder2, "$holder");
                    if (compoundButton.isPressed()) {
                        importBookSourceDialog2.S().selectStatus.set(itemViewHolder2.getLayoutPosition(), Boolean.valueOf(z));
                        importBookSourceDialog2.T();
                    }
                }
            });
        }
    }

    /* JADX INFO: compiled from: ImportBookSourceDialog.kt */
    public static final class a extends k implements l<e.a.a.e.a.h<? extends DialogInterface>, f.v> {
        public final /* synthetic */ MenuItem $item;

        /* JADX INFO: renamed from: io.legado.app.ui.association.ImportBookSourceDialog$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: ImportBookSourceDialog.kt */
        public static final class C0190a extends k implements f.c0.b.a<View> {
            public final /* synthetic */ DialogEditTextBinding $alertBinding;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0190a(DialogEditTextBinding dialogEditTextBinding) {
                super(0);
                this.$alertBinding = dialogEditTextBinding;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // f.c0.b.a
            @NotNull
            public final View invoke() {
                ScrollView scrollView = this.$alertBinding.a;
                j.d(scrollView, "alertBinding.root");
                return scrollView;
            }
        }

        /* JADX INFO: compiled from: ImportBookSourceDialog.kt */
        public static final class b extends k implements l<DialogInterface, f.v> {
            public final /* synthetic */ DialogEditTextBinding $alertBinding;
            public final /* synthetic */ MenuItem $item;
            public final /* synthetic */ ImportBookSourceDialog this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(DialogEditTextBinding dialogEditTextBinding, ImportBookSourceDialog importBookSourceDialog, MenuItem menuItem) {
                super(1);
                this.$alertBinding = dialogEditTextBinding;
                this.this$0 = importBookSourceDialog;
                this.$item = menuItem;
            }

            @Override // f.c0.b.l
            public /* bridge */ /* synthetic */ f.v invoke(DialogInterface dialogInterface) {
                invoke2(dialogInterface);
                return f.v.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull DialogInterface dialogInterface) {
                String string;
                j.e(dialogInterface, "it");
                Editable text = this.$alertBinding.f6613b.getText();
                if (text == null || (string = text.toString()) == null) {
                    return;
                }
                ImportBookSourceDialog importBookSourceDialog = this.this$0;
                MenuItem menuItem = this.$item;
                importBookSourceDialog.S().groupName = string;
                menuItem.setTitle(importBookSourceDialog.getString(R.string.diy_edit_source_group_title, string));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(MenuItem menuItem) {
            super(1);
            this.$item = menuItem;
        }

        @Override // f.c0.b.l
        public /* bridge */ /* synthetic */ f.v invoke(e.a.a.e.a.h<? extends DialogInterface> hVar) {
            invoke2(hVar);
            return f.v.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull e.a.a.e.a.h<? extends DialogInterface> hVar) {
            j.e(hVar, "$this$alert");
            DialogEditTextBinding dialogEditTextBindingA = DialogEditTextBinding.a(ImportBookSourceDialog.this.getLayoutInflater());
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            for (String str : AppDatabaseKt.getAppDb().getBookSourceDao().getAllGroup()) {
                e.a.a.c.d dVar = e.a.a.c.d.a;
                f.T(linkedHashSet, f.o5(str, e.a.a.c.d.f5514h, 0, 2));
            }
            dialogEditTextBindingA.f6613b.setFilterValues(f.x.e.F(linkedHashSet));
            dialogEditTextBindingA.f6613b.setDropDownHeight(f.m2(180));
            j.d(dialogEditTextBindingA, "inflate(layoutInflater).apply {\n                        val groups = linkedSetOf<String>()\n                        appDb.bookSourceDao.allGroup.forEach { group ->\n                            groups.addAll(group.splitNotBlank(AppPattern.splitGroupRegex))\n                        }\n                        editView.setFilterValues(groups.toList())\n                        editView.dropDownHeight = 180.dp\n                    }");
            hVar.d(new C0190a(dialogEditTextBindingA));
            hVar.m(new b(dialogEditTextBindingA, ImportBookSourceDialog.this, this.$item));
            f.d4(hVar, null, 1, null);
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
    public static final class d extends k implements l<ImportBookSourceDialog, DialogRecyclerViewBinding> {
        public d() {
            super(1);
        }

        @Override // f.c0.b.l
        @NotNull
        public final DialogRecyclerViewBinding invoke(@NotNull ImportBookSourceDialog importBookSourceDialog) {
            j.e(importBookSourceDialog, "fragment");
            return DialogRecyclerViewBinding.a(importBookSourceDialog.requireView());
        }
    }

    static {
        h<Object>[] hVarArr = new h[2];
        q qVar = new q(v.a(ImportBookSourceDialog.class), "binding", "getBinding()Lio/legado/app/databinding/DialogRecyclerViewBinding;");
        Objects.requireNonNull(v.a);
        hVarArr[0] = qVar;
        f6986b = hVarArr;
    }

    @Override // io.legado.app.base.BaseDialogFragment
    public void P(@NotNull View view, @Nullable Bundle savedInstanceState) {
        j.e(view, "view");
        R().f6672c.setTitle(R.string.import_book_source);
        R().f6672c.setOnMenuItemClickListener(this);
        R().f6672c.inflateMenu(R.menu.import_source);
        MenuItem menuItemFindItem = R().f6672c.getMenu().findItem(R.id.menu_Keep_original_name);
        if (menuItemFindItem != null) {
            menuItemFindItem.setChecked(e.a.a.d.e.a.g());
        }
        Context contextRequireContext = requireContext();
        j.d(contextRequireContext, "requireContext()");
        SourcesAdapter sourcesAdapter = new SourcesAdapter(this, contextRequireContext);
        j.e(sourcesAdapter, "<set-?>");
        this.adapter = sourcesAdapter;
        R().f6671b.setLayoutManager(new LinearLayoutManager(requireContext()));
        R().f6671b.setAdapter(Q());
        Q().x(S().allSources);
        AccentTextView accentTextView = R().f6673d;
        j.d(accentTextView, "binding.tvCancel");
        f.c6(accentTextView);
        R().f6673d.setOnClickListener(new View.OnClickListener() { // from class: e.a.a.g.b.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ImportBookSourceDialog importBookSourceDialog = this.a;
                f.f0.h<Object>[] hVarArr = ImportBookSourceDialog.f6986b;
                f.c0.c.j.e(importBookSourceDialog, "this$0");
                importBookSourceDialog.dismissAllowingStateLoss();
            }
        });
        AccentTextView accentTextView2 = R().f6675f;
        j.d(accentTextView2, "binding.tvOk");
        f.c6(accentTextView2);
        R().f6675f.setOnClickListener(new View.OnClickListener() { // from class: e.a.a.g.b.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ImportBookSourceDialog importBookSourceDialog = this.a;
                f.f0.h<Object>[] hVarArr = ImportBookSourceDialog.f6986b;
                f.c0.c.j.e(importBookSourceDialog, "this$0");
                Context contextRequireContext2 = importBookSourceDialog.requireContext();
                f.c0.c.j.d(contextRequireContext2, "requireContext()");
                e.a.a.g.m.k.k kVar = new e.a.a.g.m.k.k(contextRequireContext2);
                kVar.show();
                ImportBookSourceViewModel importBookSourceViewModelS = importBookSourceDialog.S();
                t tVar = new t(kVar, importBookSourceDialog);
                Objects.requireNonNull(importBookSourceViewModelS);
                f.c0.c.j.e(tVar, "finally");
                e.a.a.d.u.b.c(BaseViewModel.a(importBookSourceViewModelS, null, null, new v(importBookSourceViewModelS, null), 3, null), null, new w(tVar, null), 1);
            }
        });
        T();
        AccentTextView accentTextView3 = R().f6674e;
        j.d(accentTextView3, "binding.tvFooterLeft");
        f.c6(accentTextView3);
        R().f6674e.setOnClickListener(new View.OnClickListener() { // from class: e.a.a.g.b.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ImportBookSourceDialog importBookSourceDialog = this.a;
                f.f0.h<Object>[] hVarArr = ImportBookSourceDialog.f6986b;
                f.c0.c.j.e(importBookSourceDialog, "this$0");
                boolean zG = importBookSourceDialog.S().g();
                int i2 = 0;
                for (Object obj : importBookSourceDialog.S().selectStatus) {
                    int i3 = i2 + 1;
                    if (i2 < 0) {
                        f.x.e.D();
                        throw null;
                    }
                    boolean z = !zG;
                    if (((Boolean) obj).booleanValue() != z) {
                        importBookSourceDialog.S().selectStatus.set(i2, Boolean.valueOf(z));
                    }
                    i2 = i3;
                }
                importBookSourceDialog.Q().notifyDataSetChanged();
                importBookSourceDialog.T();
            }
        });
    }

    @NotNull
    public final SourcesAdapter Q() {
        SourcesAdapter sourcesAdapter = this.adapter;
        if (sourcesAdapter != null) {
            return sourcesAdapter;
        }
        j.m("adapter");
        throw null;
    }

    public final DialogRecyclerViewBinding R() {
        return (DialogRecyclerViewBinding) this.binding.b(this, f6986b[0]);
    }

    @NotNull
    public final ImportBookSourceViewModel S() {
        return (ImportBookSourceViewModel) this.viewModel.getValue();
    }

    public final void T() {
        if (S().g()) {
            R().f6674e.setText(getString(R.string.select_cancel_count, Integer.valueOf(S().h()), Integer.valueOf(S().allSources.size())));
        } else {
            R().f6674e.setText(getString(R.string.select_all_count, Integer.valueOf(S().h()), Integer.valueOf(S().allSources.size())));
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        j.e(inflater, "inflater");
        return inflater.inflate(R.layout.dialog_recycler_view, container);
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(@NotNull DialogInterface dialog) {
        j.e(dialog, "dialog");
        super.onDismiss(dialog);
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        activity.finish();
    }

    @Override // androidx.appcompat.widget.Toolbar.OnMenuItemClickListener
    @SuppressLint({"InflateParams"})
    public boolean onMenuItemClick(@NotNull MenuItem item) {
        j.e(item, "item");
        int itemId = item.getItemId();
        if (itemId == R.id.menu_Keep_original_name) {
            item.setChecked(!item.isChecked());
            m.h(this, "importKeepName", item.isChecked());
            return false;
        }
        if (itemId != R.id.menu_new_group) {
            return false;
        }
        Integer numValueOf = Integer.valueOf(R.string.diy_edit_source_group);
        a aVar = new a(item);
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        j.d(fragmentActivityRequireActivity, "requireActivity()");
        ((i) f.h0(fragmentActivityRequireActivity, numValueOf, null, aVar)).p();
        return false;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        Window window;
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog == null || (window = dialog.getWindow()) == null) {
            return;
        }
        window.setLayout(-1, -2);
    }
}

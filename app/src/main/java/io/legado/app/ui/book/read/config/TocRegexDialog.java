package io.legado.app.ui.book.read.config;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
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
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.KeyEventDispatcher;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.view.LiveData;
import androidx.view.Observer;
import androidx.view.ViewModelStore;
import androidx.view.ViewModelStoreOwner;
import androidx.viewbinding.ViewBinding;
import com.umeng.analytics.pro.ai;
import e.a.a.e.a.i;
import e.a.a.g.d.i.r1.c5;
import e.a.a.g.d.i.r1.x4;
import e.a.a.g.d.i.r1.y4;
import e.a.a.h.f;
import e.a.a.h.m;
import f.c0.b.l;
import f.c0.b.p;
import f.c0.c.j;
import f.c0.c.k;
import f.c0.c.q;
import f.c0.c.v;
import f.f0.h;
import f.z.j.a.g;
import g.b.a0;
import g.b.k0;
import io.legado.app.base.BaseDialogFragment;
import io.legado.app.base.BaseViewModel;
import io.legado.app.base.adapter.ItemViewHolder;
import io.legado.app.base.adapter.RecyclerAdapter;
import io.legado.app.data.AppDatabaseKt;
import io.legado.app.data.dao.TxtTocRuleDao;
import io.legado.app.data.entities.TxtTocRule;
import io.legado.app.databinding.DialogTocRegexBinding;
import io.legado.app.databinding.DialogTocRegexEditBinding;
import io.legado.app.databinding.ItemTocRegexBinding;
import io.legado.app.lib.theme.view.ATERadioButton;
import io.legado.app.lib.theme.view.ATESwitch;
import io.legado.app.ui.book.read.config.TocRegexDialog;
import io.legado.app.ui.widget.recycler.ItemTouchCallback;
import io.legado.app.ui.widget.recycler.VerticalDivider;
import io.legado.app.ui.widget.text.EditText;
import io.legado.app.utils.viewbindingdelegate.ViewBindingProperty;
import io.wenyuange.app.release.R;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: TocRegexDialog.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 =2\u00020\u00012\u00020\u0002:\u0003>=?B\u0007¢\u0006\u0004\b<\u0010\u0005J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J-\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ!\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u001b\u0010\u0019\u001a\u00020\u00032\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0003¢\u0006\u0004\b\u0019\u0010\u001aR\u001d\u0010 \u001a\u00020\u001b8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR$\u0010%\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\"\u0018\u00010!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010)\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(R$\u0010/\u001a\u0004\u0018\u00010&8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b*\u0010(\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u0016\u00101\u001a\u00020&8\u0002@\u0002X\u0082D¢\u0006\u0006\n\u0004\b0\u0010(R\u001a\u00105\u001a\u000602R\u00020\u00008\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b3\u00104R\u001d\u0010;\u001a\u0002068B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b7\u00108\u001a\u0004\b9\u0010:¨\u0006@"}, d2 = {"Lio/legado/app/ui/book/read/config/TocRegexDialog;", "Lio/legado/app/base/BaseDialogFragment;", "Landroidx/appcompat/widget/Toolbar$OnMenuItemClickListener;", "Lf/v;", "onStart", "()V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "P", "(Landroid/view/View;Landroid/os/Bundle;)V", "Landroid/view/MenuItem;", "item", "", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Lio/legado/app/data/entities/TxtTocRule;", "rule", "Q", "(Lio/legado/app/data/entities/TxtTocRule;)V", "Lio/legado/app/databinding/DialogTocRegexBinding;", "j", "Lio/legado/app/utils/viewbindingdelegate/ViewBindingProperty;", "R", "()Lio/legado/app/databinding/DialogTocRegexBinding;", "binding", "Landroidx/lifecycle/LiveData;", "", "f", "Landroidx/lifecycle/LiveData;", "tocRegexLiveData", "", "h", "Ljava/lang/String;", "durRegex", "g", "getSelectedName", "()Ljava/lang/String;", "setSelectedName", "(Ljava/lang/String;)V", "selectedName", "d", "importTocRuleKey", "Lio/legado/app/ui/book/read/config/TocRegexDialog$TocRegexAdapter;", "e", "Lio/legado/app/ui/book/read/config/TocRegexDialog$TocRegexAdapter;", "adapter", "Lio/legado/app/ui/book/read/config/TocRegexViewModel;", ai.aA, "Lf/e;", "getViewModel", "()Lio/legado/app/ui/book/read/config/TocRegexViewModel;", "viewModel", "<init>", "b", ai.at, "TocRegexAdapter", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class TocRegexDialog extends BaseDialogFragment implements Toolbar.OnMenuItemClickListener {

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ h<Object>[] f7212c;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    public TocRegexAdapter adapter;

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public LiveData<List<TxtTocRule>> tocRegexLiveData;

    /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public String selectedName;

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public String durRegex;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final String importTocRuleKey = "tocRuleUrl";

    /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final f.e viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, v.a(TocRegexViewModel.class), new f(new e(this)), null);

    /* JADX INFO: renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final ViewBindingProperty binding = c.b.a.m.f.b6(this, new d());

    /* JADX INFO: compiled from: TocRegexDialog.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004B\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0014\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0019"}, d2 = {"Lio/legado/app/ui/book/read/config/TocRegexDialog$TocRegexAdapter;", "Lio/legado/app/base/adapter/RecyclerAdapter;", "Lio/legado/app/data/entities/TxtTocRule;", "Lio/legado/app/databinding/ItemTocRegexBinding;", "Lio/legado/app/ui/widget/recycler/ItemTouchCallback$a;", "", "srcPosition", "targetPosition", "", ai.aD, "(II)Z", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "viewHolder", "Lf/v;", "b", "(Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/RecyclerView$ViewHolder;)V", "f", "Z", "isMoved", "Landroid/content/Context;", com.umeng.analytics.pro.c.R, "<init>", "(Lio/legado/app/ui/book/read/config/TocRegexDialog;Landroid/content/Context;)V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
    public final class TocRegexAdapter extends RecyclerAdapter<TxtTocRule, ItemTocRegexBinding> implements ItemTouchCallback.a {

        /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
        public boolean isMoved;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ TocRegexDialog f7221g;

        /* JADX INFO: compiled from: TocRegexDialog.kt */
        @DebugMetadata(c = "io.legado.app.ui.book.read.config.TocRegexDialog$TocRegexAdapter$onClearView$1", f = "TocRegexDialog.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class a extends g implements p<a0, f.z.d<? super f.v>, Object> {
            public int label;

            public a(f.z.d<? super a> dVar) {
                super(2, dVar);
            }

            @Override // f.z.j.a.a
            @NotNull
            public final f.z.d<f.v> create(@Nullable Object obj, @NotNull f.z.d<?> dVar) {
                return TocRegexAdapter.this.new a(dVar);
            }

            @Override // f.c0.b.p
            @Nullable
            public final Object invoke(@NotNull a0 a0Var, @Nullable f.z.d<? super f.v> dVar) {
                return ((a) create(a0Var, dVar)).invokeSuspend(f.v.a);
            }

            @Override // f.z.j.a.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                c.b.a.m.f.E5(obj);
                TxtTocRuleDao txtTocRuleDao = AppDatabaseKt.getAppDb().getTxtTocRuleDao();
                Object[] array = TocRegexAdapter.this.items.toArray(new TxtTocRule[0]);
                Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
                TxtTocRule[] txtTocRuleArr = (TxtTocRule[]) array;
                txtTocRuleDao.update((TxtTocRule[]) Arrays.copyOf(txtTocRuleArr, txtTocRuleArr.length));
                return f.v.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TocRegexAdapter(@NotNull TocRegexDialog tocRegexDialog, Context context) {
            super(context);
            j.e(tocRegexDialog, "this$0");
            j.e(context, com.umeng.analytics.pro.c.R);
            this.f7221g = tocRegexDialog;
        }

        @Override // io.legado.app.ui.widget.recycler.ItemTouchCallback.a
        public void a(int i2) {
            j.e(this, "this");
        }

        @Override // io.legado.app.ui.widget.recycler.ItemTouchCallback.a
        public void b(@NotNull RecyclerView recyclerView, @NotNull RecyclerView.ViewHolder viewHolder) {
            j.e(recyclerView, "recyclerView");
            j.e(viewHolder, "viewHolder");
            j.e(this, "this");
            j.e(recyclerView, "recyclerView");
            j.e(viewHolder, "viewHolder");
            if (this.isMoved) {
                Iterator it = this.items.iterator();
                int i2 = 0;
                while (it.hasNext()) {
                    i2++;
                    ((TxtTocRule) it.next()).setSerialNumber(i2);
                }
                TocRegexDialog tocRegexDialog = this.f7221g;
                k0 k0Var = k0.f6264c;
                c.b.a.m.f.L3(tocRegexDialog, k0.f6263b, null, new a(null), 2, null);
            }
            this.isMoved = false;
        }

        @Override // io.legado.app.ui.widget.recycler.ItemTouchCallback.a
        public boolean c(int srcPosition, int targetPosition) {
            z(srcPosition, targetPosition);
            this.isMoved = true;
            j.e(this, "this");
            return true;
        }

        @Override // io.legado.app.base.adapter.RecyclerAdapter
        public void i(ItemViewHolder itemViewHolder, ViewBinding viewBinding, TxtTocRule txtTocRule, List list, int i2) {
            ItemTocRegexBinding itemTocRegexBinding = (ItemTocRegexBinding) viewBinding;
            TxtTocRule txtTocRule2 = txtTocRule;
            j.e(itemViewHolder, "holder");
            j.e(itemTocRegexBinding, "binding");
            j.e(txtTocRule2, "item");
            j.e(list, "payloads");
            TocRegexDialog tocRegexDialog = this.f7221g;
            if (!list.isEmpty()) {
                itemTocRegexBinding.f6858d.setChecked(j.a(txtTocRule2.getName(), tocRegexDialog.selectedName));
                return;
            }
            itemTocRegexBinding.a.setBackgroundColor(c.b.a.m.f.R1(this.context));
            itemTocRegexBinding.f6858d.setText(txtTocRule2.getName());
            itemTocRegexBinding.f6858d.setChecked(j.a(txtTocRule2.getName(), tocRegexDialog.selectedName));
            itemTocRegexBinding.f6859e.setChecked(txtTocRule2.getEnable());
        }

        @Override // io.legado.app.base.adapter.RecyclerAdapter
        public ViewBinding q(ViewGroup viewGroup) {
            j.e(viewGroup, "parent");
            View viewInflate = this.inflater.inflate(R.layout.item_toc_regex, viewGroup, false);
            int i2 = R.id.iv_delete;
            AppCompatImageView appCompatImageView = (AppCompatImageView) viewInflate.findViewById(R.id.iv_delete);
            if (appCompatImageView != null) {
                i2 = R.id.iv_edit;
                AppCompatImageView appCompatImageView2 = (AppCompatImageView) viewInflate.findViewById(R.id.iv_edit);
                if (appCompatImageView2 != null) {
                    i2 = R.id.rb_regex_name;
                    ATERadioButton aTERadioButton = (ATERadioButton) viewInflate.findViewById(R.id.rb_regex_name);
                    if (aTERadioButton != null) {
                        i2 = R.id.swt_enabled;
                        ATESwitch aTESwitch = (ATESwitch) viewInflate.findViewById(R.id.swt_enabled);
                        if (aTESwitch != null) {
                            ItemTocRegexBinding itemTocRegexBinding = new ItemTocRegexBinding((LinearLayout) viewInflate, appCompatImageView, appCompatImageView2, aTERadioButton, aTESwitch);
                            j.d(itemTocRegexBinding, "inflate(inflater, parent, false)");
                            return itemTocRegexBinding;
                        }
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i2)));
        }

        @Override // io.legado.app.base.adapter.RecyclerAdapter
        public void w(final ItemViewHolder itemViewHolder, ViewBinding viewBinding) {
            ItemTocRegexBinding itemTocRegexBinding = (ItemTocRegexBinding) viewBinding;
            j.e(itemViewHolder, "holder");
            j.e(itemTocRegexBinding, "binding");
            final TocRegexDialog tocRegexDialog = this.f7221g;
            itemTocRegexBinding.f6858d.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: e.a.a.g.d.i.r1.q1
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    TocRegexDialog tocRegexDialog2 = tocRegexDialog;
                    TocRegexDialog.TocRegexAdapter tocRegexAdapter = this;
                    ItemViewHolder itemViewHolder2 = itemViewHolder;
                    f.c0.c.j.e(tocRegexDialog2, "this$0");
                    f.c0.c.j.e(tocRegexAdapter, "this$1");
                    f.c0.c.j.e(itemViewHolder2, "$holder");
                    if (compoundButton.isPressed() && z) {
                        TxtTocRule item = tocRegexAdapter.getItem(itemViewHolder2.getLayoutPosition());
                        tocRegexDialog2.selectedName = item == null ? null : item.getName();
                        int itemCount = tocRegexAdapter.getItemCount() - 1;
                        Boolean bool = Boolean.TRUE;
                        synchronized (tocRegexAdapter) {
                            f.c0.c.j.e(bool, "payloads");
                            try {
                                int iJ = tocRegexAdapter.j();
                                if (iJ > 0) {
                                    if (itemCount >= 0 && itemCount < iJ) {
                                        tocRegexAdapter.notifyItemRangeChanged(tocRegexAdapter.l() + 0, (itemCount - 0) + 1, bool);
                                    }
                                }
                                f.h.m11constructorimpl(f.v.a);
                            } catch (Throwable th) {
                                f.h.m11constructorimpl(c.b.a.m.f.m1(th));
                            }
                        }
                    }
                }
            });
            itemTocRegexBinding.f6859e.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: e.a.a.g.d.i.r1.p1
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    TxtTocRule item;
                    TocRegexDialog.TocRegexAdapter tocRegexAdapter = this.a;
                    ItemViewHolder itemViewHolder2 = itemViewHolder;
                    TocRegexDialog tocRegexDialog2 = tocRegexDialog;
                    f.c0.c.j.e(tocRegexAdapter, "this$0");
                    f.c0.c.j.e(itemViewHolder2, "$holder");
                    f.c0.c.j.e(tocRegexDialog2, "this$1");
                    if (!compoundButton.isPressed() || (item = tocRegexAdapter.getItem(itemViewHolder2.getLayoutPosition())) == null) {
                        return;
                    }
                    item.setEnable(z);
                    g.b.k0 k0Var = g.b.k0.f6264c;
                    c.b.a.m.f.L3(tocRegexDialog2, g.b.k0.f6263b, null, new v4(item, null), 2, null);
                }
            });
            itemTocRegexBinding.f6857c.setOnClickListener(new View.OnClickListener() { // from class: e.a.a.g.d.i.r1.r1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TocRegexDialog tocRegexDialog2 = tocRegexDialog;
                    TocRegexDialog.TocRegexAdapter tocRegexAdapter = this;
                    ItemViewHolder itemViewHolder2 = itemViewHolder;
                    f.c0.c.j.e(tocRegexDialog2, "this$0");
                    f.c0.c.j.e(tocRegexAdapter, "this$1");
                    f.c0.c.j.e(itemViewHolder2, "$holder");
                    TxtTocRule item = tocRegexAdapter.getItem(itemViewHolder2.getLayoutPosition());
                    TocRegexDialog.Companion companion = TocRegexDialog.INSTANCE;
                    tocRegexDialog2.Q(item);
                }
            });
            itemTocRegexBinding.f6856b.setOnClickListener(new View.OnClickListener() { // from class: e.a.a.g.d.i.r1.s1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TocRegexDialog.TocRegexAdapter tocRegexAdapter = this.a;
                    ItemViewHolder itemViewHolder2 = itemViewHolder;
                    TocRegexDialog tocRegexDialog2 = tocRegexDialog;
                    f.c0.c.j.e(tocRegexAdapter, "this$0");
                    f.c0.c.j.e(itemViewHolder2, "$holder");
                    f.c0.c.j.e(tocRegexDialog2, "this$1");
                    TxtTocRule item = tocRegexAdapter.getItem(itemViewHolder2.getLayoutPosition());
                    if (item == null) {
                        return;
                    }
                    g.b.k0 k0Var = g.b.k0.f6264c;
                    c.b.a.m.f.L3(tocRegexDialog2, g.b.k0.f6263b, null, new w4(item, null), 2, null);
                }
            });
        }
    }

    /* JADX INFO: compiled from: TocRegexDialog.kt */
    public interface a {
        void H0(@NotNull String str);
    }

    /* JADX INFO: renamed from: io.legado.app.ui.book.read.config.TocRegexDialog$b, reason: from kotlin metadata */
    /* JADX INFO: compiled from: TocRegexDialog.kt */
    public static final class Companion {
        public Companion(f.c0.c.f fVar) {
        }
    }

    /* JADX INFO: compiled from: TocRegexDialog.kt */
    public static final class c extends k implements l<e.a.a.e.a.h<? extends DialogInterface>, f.v> {
        public final /* synthetic */ TxtTocRule $tocRule;

        /* JADX INFO: compiled from: TocRegexDialog.kt */
        public static final class a extends k implements f.c0.b.a<View> {
            public final /* synthetic */ DialogTocRegexEditBinding $alertBinding;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(DialogTocRegexEditBinding dialogTocRegexEditBinding) {
                super(0);
                this.$alertBinding = dialogTocRegexEditBinding;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // f.c0.b.a
            @NotNull
            public final View invoke() {
                LinearLayout linearLayout = this.$alertBinding.a;
                j.d(linearLayout, "alertBinding.root");
                return linearLayout;
            }
        }

        /* JADX INFO: compiled from: TocRegexDialog.kt */
        public static final class b extends k implements l<DialogInterface, f.v> {
            public final /* synthetic */ DialogTocRegexEditBinding $alertBinding;
            public final /* synthetic */ TxtTocRule $tocRule;
            public final /* synthetic */ TocRegexDialog this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(DialogTocRegexEditBinding dialogTocRegexEditBinding, TxtTocRule txtTocRule, TocRegexDialog tocRegexDialog) {
                super(1);
                this.$alertBinding = dialogTocRegexEditBinding;
                this.$tocRule = txtTocRule;
                this.this$0 = tocRegexDialog;
            }

            @Override // f.c0.b.l
            public /* bridge */ /* synthetic */ f.v invoke(DialogInterface dialogInterface) {
                invoke2(dialogInterface);
                return f.v.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull DialogInterface dialogInterface) {
                j.e(dialogInterface, "it");
                DialogTocRegexEditBinding dialogTocRegexEditBinding = this.$alertBinding;
                TxtTocRule txtTocRule = this.$tocRule;
                TocRegexDialog tocRegexDialog = this.this$0;
                txtTocRule.setName(String.valueOf(dialogTocRegexEditBinding.f6700b.getText()));
                txtTocRule.setRule(String.valueOf(dialogTocRegexEditBinding.f6701c.getText()));
                TocRegexViewModel tocRegexViewModel = (TocRegexViewModel) tocRegexDialog.viewModel.getValue();
                Objects.requireNonNull(tocRegexViewModel);
                j.e(txtTocRule, "rule");
                BaseViewModel.a(tocRegexViewModel, null, null, new c5(txtTocRule, null), 3, null);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(TxtTocRule txtTocRule) {
            super(1);
            this.$tocRule = txtTocRule;
        }

        @Override // f.c0.b.l
        public /* bridge */ /* synthetic */ f.v invoke(e.a.a.e.a.h<? extends DialogInterface> hVar) {
            invoke2(hVar);
            return f.v.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull e.a.a.e.a.h<? extends DialogInterface> hVar) {
            j.e(hVar, "$this$alert");
            View viewInflate = TocRegexDialog.this.getLayoutInflater().inflate(R.layout.dialog_toc_regex_edit, (ViewGroup) null, false);
            int i2 = R.id.tv_rule_name;
            EditText editText = (EditText) viewInflate.findViewById(R.id.tv_rule_name);
            if (editText != null) {
                i2 = R.id.tv_rule_regex;
                EditText editText2 = (EditText) viewInflate.findViewById(R.id.tv_rule_regex);
                if (editText2 != null) {
                    DialogTocRegexEditBinding dialogTocRegexEditBinding = new DialogTocRegexEditBinding((LinearLayout) viewInflate, editText, editText2);
                    j.d(dialogTocRegexEditBinding, "inflate(layoutInflater)");
                    TxtTocRule txtTocRule = this.$tocRule;
                    editText.setText(txtTocRule.getName());
                    editText2.setText(txtTocRule.getRule());
                    hVar.d(new a(dialogTocRegexEditBinding));
                    hVar.m(new b(dialogTocRegexEditBinding, this.$tocRule, TocRegexDialog.this));
                    c.b.a.m.f.K0(hVar, null, 1, null);
                    return;
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i2)));
        }
    }

    /* JADX INFO: compiled from: FragmentViewBindings.kt */
    public static final class d extends k implements l<TocRegexDialog, DialogTocRegexBinding> {
        public d() {
            super(1);
        }

        @Override // f.c0.b.l
        @NotNull
        public final DialogTocRegexBinding invoke(@NotNull TocRegexDialog tocRegexDialog) {
            j.e(tocRegexDialog, "fragment");
            View viewRequireView = tocRegexDialog.requireView();
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
                            return new DialogTocRegexBinding((LinearLayout) viewRequireView, recyclerView, toolbar, textView, textView2);
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
        q qVar = new q(v.a(TocRegexDialog.class), "binding", "getBinding()Lio/legado/app/databinding/DialogTocRegexBinding;");
        Objects.requireNonNull(v.a);
        hVarArr[1] = qVar;
        f7212c = hVarArr;
        INSTANCE = new Companion(null);
    }

    @Override // io.legado.app.base.BaseDialogFragment
    public void P(@NotNull View view, @Nullable Bundle savedInstanceState) {
        j.e(view, "view");
        R().f6697c.setBackgroundColor(c.b.a.m.f.Q2(this));
        Bundle arguments = getArguments();
        this.durRegex = arguments == null ? null : arguments.getString("tocRegex");
        R().f6697c.setTitle(R.string.txt_toc_regex);
        R().f6697c.inflateMenu(R.menu.txt_toc_regex);
        Menu menu = R().f6697c.getMenu();
        j.d(menu, "binding.toolBar.menu");
        Context contextRequireContext = requireContext();
        j.d(contextRequireContext, "requireContext()");
        m.b(menu, contextRequireContext, null, 2);
        R().f6697c.setOnMenuItemClickListener(this);
        DialogTocRegexBinding dialogTocRegexBindingR = R();
        Context contextRequireContext2 = requireContext();
        j.d(contextRequireContext2, "requireContext()");
        this.adapter = new TocRegexAdapter(this, contextRequireContext2);
        RecyclerView recyclerView = dialogTocRegexBindingR.f6696b;
        Context contextRequireContext3 = requireContext();
        j.d(contextRequireContext3, "requireContext()");
        recyclerView.addItemDecoration(new VerticalDivider(contextRequireContext3));
        RecyclerView recyclerView2 = dialogTocRegexBindingR.f6696b;
        TocRegexAdapter tocRegexAdapter = this.adapter;
        if (tocRegexAdapter == null) {
            j.m("adapter");
            throw null;
        }
        recyclerView2.setAdapter(tocRegexAdapter);
        TocRegexAdapter tocRegexAdapter2 = this.adapter;
        if (tocRegexAdapter2 == null) {
            j.m("adapter");
            throw null;
        }
        ItemTouchCallback itemTouchCallback = new ItemTouchCallback(tocRegexAdapter2);
        itemTouchCallback.isCanDrag = true;
        new ItemTouchHelper(itemTouchCallback).attachToRecyclerView(dialogTocRegexBindingR.f6696b);
        dialogTocRegexBindingR.f6698d.setOnClickListener(new View.OnClickListener() { // from class: e.a.a.g.d.i.r1.u1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                TocRegexDialog tocRegexDialog = this.a;
                TocRegexDialog.Companion companion = TocRegexDialog.INSTANCE;
                f.c0.c.j.e(tocRegexDialog, "this$0");
                tocRegexDialog.dismissAllowingStateLoss();
            }
        });
        dialogTocRegexBindingR.f6699e.setOnClickListener(new View.OnClickListener() { // from class: e.a.a.g.d.i.r1.o1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                TocRegexDialog tocRegexDialog = this.a;
                TocRegexDialog.Companion companion = TocRegexDialog.INSTANCE;
                f.c0.c.j.e(tocRegexDialog, "this$0");
                TocRegexDialog.TocRegexAdapter tocRegexAdapter3 = tocRegexDialog.adapter;
                if (tocRegexAdapter3 == null) {
                    f.c0.c.j.m("adapter");
                    throw null;
                }
                for (TxtTocRule txtTocRule : tocRegexAdapter3.items) {
                    if (f.c0.c.j.a(tocRegexDialog.selectedName, txtTocRule.getName())) {
                        KeyEventDispatcher.Component activity = tocRegexDialog.getActivity();
                        TocRegexDialog.a aVar = activity instanceof TocRegexDialog.a ? (TocRegexDialog.a) activity : null;
                        if (aVar != null) {
                            aVar.H0(txtTocRule.getRule());
                        }
                        tocRegexDialog.dismissAllowingStateLoss();
                        return;
                    }
                }
            }
        });
        LiveData<List<TxtTocRule>> liveData = this.tocRegexLiveData;
        if (liveData != null) {
            liveData.removeObservers(getViewLifecycleOwner());
        }
        LiveData<List<TxtTocRule>> liveDataObserveAll = AppDatabaseKt.getAppDb().getTxtTocRuleDao().observeAll();
        this.tocRegexLiveData = liveDataObserveAll;
        if (liveDataObserveAll == null) {
            return;
        }
        liveDataObserveAll.observe(getViewLifecycleOwner(), new Observer() { // from class: e.a.a.g.d.i.r1.t1
            @Override // androidx.view.Observer
            public final void onChanged(Object obj) {
                TocRegexDialog tocRegexDialog = this.a;
                List<TxtTocRule> list = (List) obj;
                TocRegexDialog.Companion companion = TocRegexDialog.INSTANCE;
                f.c0.c.j.e(tocRegexDialog, "this$0");
                f.c0.c.j.d(list, "tocRules");
                if (tocRegexDialog.selectedName == null && tocRegexDialog.durRegex != null) {
                    for (TxtTocRule txtTocRule : list) {
                        if (f.c0.c.j.a(tocRegexDialog.durRegex, txtTocRule.getRule())) {
                            tocRegexDialog.selectedName = txtTocRule.getName();
                        }
                    }
                    if (tocRegexDialog.selectedName == null) {
                        tocRegexDialog.selectedName = "";
                    }
                }
                TocRegexDialog.TocRegexAdapter tocRegexAdapter3 = tocRegexDialog.adapter;
                if (tocRegexAdapter3 == null) {
                    f.c0.c.j.m("adapter");
                    throw null;
                }
                tocRegexAdapter3.x(list);
            }
        });
    }

    @SuppressLint({"InflateParams"})
    public final void Q(TxtTocRule rule) {
        TxtTocRule txtTocRuleCopy$default = rule == null ? null : TxtTocRule.copy$default(rule, 0L, null, null, 0, false, 31, null);
        if (txtTocRuleCopy$default == null) {
            txtTocRuleCopy$default = new TxtTocRule(0L, null, null, 0, false, 31, null);
        }
        Context contextRequireContext = requireContext();
        j.d(contextRequireContext, "requireContext()");
        ((i) c.b.a.m.f.j0(contextRequireContext, Integer.valueOf(R.string.txt_toc_regex), null, new c(txtTocRuleCopy$default), 2)).p();
    }

    public final DialogTocRegexBinding R() {
        return (DialogTocRegexBinding) this.binding.b(this, f7212c[1]);
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        j.e(inflater, "inflater");
        return inflater.inflate(R.layout.dialog_toc_regex, container);
    }

    @Override // androidx.appcompat.widget.Toolbar.OnMenuItemClickListener
    public boolean onMenuItemClick(@Nullable MenuItem item) {
        Integer numValueOf = item == null ? null : Integer.valueOf(item.getItemId());
        if (numValueOf != null && numValueOf.intValue() == R.id.menu_add) {
            Q(null);
        } else if (numValueOf != null && numValueOf.intValue() == R.id.menu_default) {
            TocRegexViewModel tocRegexViewModel = (TocRegexViewModel) this.viewModel.getValue();
            Objects.requireNonNull(tocRegexViewModel);
            BaseViewModel.a(tocRegexViewModel, null, null, new y4(null), 3, null);
        } else if (numValueOf != null && numValueOf.intValue() == R.id.menu_import) {
            f.b bVar = e.a.a.h.f.a;
            Context contextRequireContext = requireContext();
            j.d(contextRequireContext, "requireContext()");
            e.a.a.h.f fVarA = f.b.a(bVar, contextRequireContext, null, 0L, 0, false, 14);
            String strA = fVarA.a(this.importTocRuleKey);
            List listL5 = strA == null ? null : c.b.a.m.f.L5(c.b.a.m.f.n5(strA, ","));
            if (listL5 == null) {
                listL5 = new ArrayList();
            }
            if (!listL5.contains("https://gitee.com/fisher52/YueDuJson/raw/master/myTxtChapterRule.json")) {
                listL5.add(0, "https://gitee.com/fisher52/YueDuJson/raw/master/myTxtChapterRule.json");
            }
            Context contextRequireContext2 = requireContext();
            j.d(contextRequireContext2, "requireContext()");
            ((i) c.b.a.m.f.j0(contextRequireContext2, Integer.valueOf(R.string.import_on_line), null, new x4(this, listL5, fVarA), 2)).p();
        }
        return false;
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
        window.setLayout((int) (((double) displayMetricsV2.widthPixels) * 0.9d), (int) (((double) displayMetricsV2.heightPixels) * 0.8d));
    }
}

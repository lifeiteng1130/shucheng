package io.legado.app.ui.replace;

import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.os.BundleKt;
import androidx.core.view.ViewCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import c.b.a.m.f;
import com.umeng.analytics.pro.ai;
import com.umeng.analytics.pro.c;
import f.c0.c.j;
import f.g;
import f.v;
import f.x.e;
import io.legado.app.base.adapter.ItemViewHolder;
import io.legado.app.base.adapter.RecyclerAdapter;
import io.legado.app.data.entities.ReplaceRule;
import io.legado.app.databinding.ItemReplaceRuleBinding;
import io.legado.app.lib.theme.view.ATECheckBox;
import io.legado.app.lib.theme.view.ATESwitch;
import io.legado.app.ui.replace.ReplaceRuleAdapter;
import io.legado.app.ui.widget.recycler.DragSelectTouchHelper;
import io.legado.app.ui.widget.recycler.ItemTouchCallback;
import io.wenyuange.app.release.R;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ReplaceRuleAdapter.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u00016B\u0017\u0012\u0006\u00103\u001a\u000202\u0012\u0006\u00101\u001a\u00020*¢\u0006\u0004\b4\u00105J\r\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000b\u0010\u0007J\u001f\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017R&\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u00020\bj\b\u0012\u0004\u0012\u00020\u0002`\u00188\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR&\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00020\u00020\bj\b\u0012\u0004\u0012\u00020\u0002`\u00188\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001aR\u0019\u0010#\u001a\u00020\u001e8\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u001f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00020$8\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\"\u00101\u001a\u00020*8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100¨\u00067"}, d2 = {"Lio/legado/app/ui/replace/ReplaceRuleAdapter;", "Lio/legado/app/base/adapter/RecyclerAdapter;", "Lio/legado/app/data/entities/ReplaceRule;", "Lio/legado/app/databinding/ItemReplaceRuleBinding;", "Lio/legado/app/ui/widget/recycler/ItemTouchCallback$a;", "Lf/v;", "B", "()V", "Ljava/util/LinkedHashSet;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "()Ljava/util/LinkedHashSet;", ai.aC, "", "srcPosition", "targetPosition", "", ai.aD, "(II)Z", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "viewHolder", "b", "(Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/RecyclerView$ViewHolder;)V", "Lkotlin/collections/LinkedHashSet;", ai.aA, "Ljava/util/LinkedHashSet;", "movedItems", "g", "selected", "Lio/legado/app/ui/widget/recycler/DragSelectTouchHelper$b;", "j", "Lio/legado/app/ui/widget/recycler/DragSelectTouchHelper$b;", "getDragSelectCallback", "()Lio/legado/app/ui/widget/recycler/DragSelectTouchHelper$b;", "dragSelectCallback", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "h", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "getDiffItemCallBack", "()Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "diffItemCallBack", "Lio/legado/app/ui/replace/ReplaceRuleAdapter$a;", "f", "Lio/legado/app/ui/replace/ReplaceRuleAdapter$a;", "getCallBack", "()Lio/legado/app/ui/replace/ReplaceRuleAdapter$a;", "setCallBack", "(Lio/legado/app/ui/replace/ReplaceRuleAdapter$a;)V", "callBack", "Landroid/content/Context;", c.R, "<init>", "(Landroid/content/Context;Lio/legado/app/ui/replace/ReplaceRuleAdapter$a;)V", ai.at, "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class ReplaceRuleAdapter extends RecyclerAdapter<ReplaceRule, ItemReplaceRuleBinding> implements ItemTouchCallback.a {

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public a callBack;

    /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final LinkedHashSet<ReplaceRule> selected;

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final DiffUtil.ItemCallback<ReplaceRule> diffItemCallBack;

    /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final LinkedHashSet<ReplaceRule> movedItems;

    /* JADX INFO: renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final DragSelectTouchHelper.b dragSelectCallback;

    /* JADX INFO: compiled from: ReplaceRuleAdapter.kt */
    public interface a {
        void I(@NotNull ReplaceRule replaceRule);

        void J0(@NotNull ReplaceRule replaceRule);

        void a();

        void b();

        void g0(@NotNull ReplaceRule replaceRule);

        void q0(@NotNull ReplaceRule replaceRule);

        void update(@NotNull ReplaceRule... replaceRuleArr);
    }

    /* JADX INFO: compiled from: ReplaceRuleAdapter.kt */
    public static final class b extends DragSelectTouchHelper.a<ReplaceRule> {
        public b(DragSelectTouchHelper.a.EnumC0216a enumC0216a) {
            super(enumC0216a);
        }

        @Override // io.legado.app.ui.widget.recycler.DragSelectTouchHelper.a
        @NotNull
        public Set<ReplaceRule> d() {
            return ReplaceRuleAdapter.this.selected;
        }

        @Override // io.legado.app.ui.widget.recycler.DragSelectTouchHelper.a
        public ReplaceRule e(int i2) {
            ReplaceRule replaceRule = (ReplaceRule) e.n(ReplaceRuleAdapter.this.items, i2);
            j.c(replaceRule);
            return replaceRule;
        }

        @Override // io.legado.app.ui.widget.recycler.DragSelectTouchHelper.a
        public boolean f(int i2, boolean z) {
            ReplaceRule replaceRule = (ReplaceRule) e.n(ReplaceRuleAdapter.this.items, i2);
            if (replaceRule == null) {
                return false;
            }
            ReplaceRuleAdapter replaceRuleAdapter = ReplaceRuleAdapter.this;
            if (z) {
                replaceRuleAdapter.selected.add(replaceRule);
            } else {
                replaceRuleAdapter.selected.remove(replaceRule);
            }
            replaceRuleAdapter.notifyItemChanged(i2, BundleKt.bundleOf(new g("selected", null)));
            replaceRuleAdapter.callBack.b();
            return true;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReplaceRuleAdapter(@NotNull Context context, @NotNull a aVar) {
        super(context);
        j.e(context, c.R);
        j.e(aVar, "callBack");
        this.callBack = aVar;
        this.selected = new LinkedHashSet<>();
        this.diffItemCallBack = new DiffUtil.ItemCallback<ReplaceRule>() { // from class: io.legado.app.ui.replace.ReplaceRuleAdapter$diffItemCallBack$1
            @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
            public boolean areContentsTheSame(ReplaceRule replaceRule, ReplaceRule replaceRule2) {
                ReplaceRule replaceRule3 = replaceRule;
                ReplaceRule replaceRule4 = replaceRule2;
                j.e(replaceRule3, "oldItem");
                j.e(replaceRule4, "newItem");
                return j.a(replaceRule3.getName(), replaceRule4.getName()) && j.a(replaceRule3.getGroup(), replaceRule4.getGroup()) && replaceRule3.isEnabled() == replaceRule4.isEnabled();
            }

            @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
            public boolean areItemsTheSame(ReplaceRule replaceRule, ReplaceRule replaceRule2) {
                ReplaceRule replaceRule3 = replaceRule;
                ReplaceRule replaceRule4 = replaceRule2;
                j.e(replaceRule3, "oldItem");
                j.e(replaceRule4, "newItem");
                return replaceRule3.getId() == replaceRule4.getId();
            }

            @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
            public Object getChangePayload(ReplaceRule replaceRule, ReplaceRule replaceRule2) {
                ReplaceRule replaceRule3 = replaceRule;
                ReplaceRule replaceRule4 = replaceRule2;
                j.e(replaceRule3, "oldItem");
                j.e(replaceRule4, "newItem");
                Bundle bundle = new Bundle();
                if (!j.a(replaceRule3.getName(), replaceRule4.getName())) {
                    bundle.putString("name", replaceRule4.getName());
                }
                if (!j.a(replaceRule3.getGroup(), replaceRule4.getGroup())) {
                    bundle.putString("group", replaceRule4.getGroup());
                }
                if (replaceRule3.isEnabled() != replaceRule4.isEnabled()) {
                    bundle.putBoolean("enabled", replaceRule4.isEnabled());
                }
                if (bundle.isEmpty()) {
                    return null;
                }
                return bundle;
            }
        };
        this.movedItems = new LinkedHashSet<>();
        this.dragSelectCallback = new b(DragSelectTouchHelper.a.EnumC0216a.ToggleAndReverse);
    }

    @NotNull
    public final LinkedHashSet<ReplaceRule> A() {
        LinkedHashSet<ReplaceRule> linkedHashSet = new LinkedHashSet<>();
        Collection<ReplaceRule> collection = this.items;
        ArrayList arrayList = new ArrayList(f.S0(collection, 10));
        for (ReplaceRule replaceRule : collection) {
            if (this.selected.contains(replaceRule)) {
                linkedHashSet.add(replaceRule);
            }
            arrayList.add(v.a);
        }
        return linkedHashSet;
    }

    public final void B() {
        for (ReplaceRule replaceRule : this.items) {
            if (this.selected.contains(replaceRule)) {
                this.selected.remove(replaceRule);
            } else {
                this.selected.add(replaceRule);
            }
        }
        notifyItemRangeChanged(0, getItemCount(), BundleKt.bundleOf(new g("selected", null)));
        this.callBack.b();
    }

    @Override // io.legado.app.ui.widget.recycler.ItemTouchCallback.a
    public void a(int i2) {
        j.e(this, "this");
    }

    @Override // io.legado.app.ui.widget.recycler.ItemTouchCallback.a
    public void b(@NotNull RecyclerView recyclerView, @NotNull RecyclerView.ViewHolder viewHolder) {
        j.e(recyclerView, "recyclerView");
        j.e(viewHolder, "viewHolder");
        if (!this.movedItems.isEmpty()) {
            a aVar = this.callBack;
            Object[] array = this.movedItems.toArray(new ReplaceRule[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
            ReplaceRule[] replaceRuleArr = (ReplaceRule[]) array;
            aVar.update((ReplaceRule[]) Arrays.copyOf(replaceRuleArr, replaceRuleArr.length));
            this.movedItems.clear();
        }
    }

    @Override // io.legado.app.ui.widget.recycler.ItemTouchCallback.a
    public boolean c(int srcPosition, int targetPosition) {
        ReplaceRule replaceRule = (ReplaceRule) e.n(this.items, srcPosition);
        ReplaceRule replaceRule2 = (ReplaceRule) e.n(this.items, targetPosition);
        if (replaceRule != null && replaceRule2 != null) {
            if (replaceRule.getOrder() == replaceRule2.getOrder()) {
                this.callBack.a();
            } else {
                int order = replaceRule.getOrder();
                replaceRule.setOrder(replaceRule2.getOrder());
                replaceRule2.setOrder(order);
                this.movedItems.add(replaceRule);
                this.movedItems.add(replaceRule2);
            }
        }
        z(srcPosition, targetPosition);
        return true;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // io.legado.app.base.adapter.RecyclerAdapter
    public void i(ItemViewHolder itemViewHolder, ViewBinding viewBinding, ReplaceRule replaceRule, List list, int i2) {
        ItemReplaceRuleBinding itemReplaceRuleBinding = (ItemReplaceRuleBinding) viewBinding;
        ReplaceRule replaceRule2 = replaceRule;
        j.e(itemViewHolder, "holder");
        j.e(itemReplaceRuleBinding, "binding");
        j.e(replaceRule2, "item");
        j.e(list, "payloads");
        Object objN = e.n(list, 0);
        Bundle bundle = objN instanceof Bundle ? (Bundle) objN : null;
        if (bundle == null) {
            itemReplaceRuleBinding.a.setBackgroundColor((Math.min(255, Math.max(0, (int) (255 * 0.5f))) << 24) + (f.R1(this.context) & ViewCompat.MEASURED_SIZE_MASK));
            String group = replaceRule2.getGroup();
            if (group == null || group.length() == 0) {
                itemReplaceRuleBinding.f6816b.setText(replaceRule2.getName());
            } else {
                ATECheckBox aTECheckBox = itemReplaceRuleBinding.f6816b;
                String str = String.format("%s (%s)", Arrays.copyOf(new Object[]{replaceRule2.getName(), replaceRule2.getGroup()}, 2));
                j.d(str, "java.lang.String.format(format, *args)");
                aTECheckBox.setText(str);
            }
            itemReplaceRuleBinding.f6819e.setChecked(replaceRule2.isEnabled());
            itemReplaceRuleBinding.f6816b.setChecked(this.selected.contains(replaceRule2));
            return;
        }
        Set<String> setKeySet = bundle.keySet();
        j.d(setKeySet, "bundle.keySet()");
        ArrayList arrayList = new ArrayList(f.S0(setKeySet, 10));
        for (String str2 : setKeySet) {
            if (str2 != null) {
                switch (str2.hashCode()) {
                    case -1609594047:
                        if (str2.equals("enabled")) {
                            itemReplaceRuleBinding.f6819e.setChecked(replaceRule2.isEnabled());
                            continue;
                        }
                        break;
                    case 3373707:
                        if (!str2.equals("name")) {
                        }
                        break;
                    case 98629247:
                        if (!str2.equals("group")) {
                        }
                        break;
                    case 1191572123:
                        if (str2.equals("selected")) {
                            itemReplaceRuleBinding.f6816b.setChecked(this.selected.contains(replaceRule2));
                            continue;
                        }
                        break;
                }
                String group2 = replaceRule2.getGroup();
                if (group2 == null || group2.length() == 0) {
                    itemReplaceRuleBinding.f6816b.setText(replaceRule2.getName());
                } else {
                    ATECheckBox aTECheckBox2 = itemReplaceRuleBinding.f6816b;
                    String str3 = String.format("%s (%s)", Arrays.copyOf(new Object[]{replaceRule2.getName(), replaceRule2.getGroup()}, 2));
                    j.d(str3, "java.lang.String.format(format, *args)");
                    aTECheckBox2.setText(str3);
                }
            }
            arrayList.add(v.a);
        }
    }

    @Override // io.legado.app.base.adapter.RecyclerAdapter
    public ViewBinding q(ViewGroup viewGroup) {
        j.e(viewGroup, "parent");
        View viewInflate = this.inflater.inflate(R.layout.item_replace_rule, viewGroup, false);
        int i2 = R.id.cb_name;
        ATECheckBox aTECheckBox = (ATECheckBox) viewInflate.findViewById(R.id.cb_name);
        if (aTECheckBox != null) {
            i2 = R.id.iv_edit;
            AppCompatImageView appCompatImageView = (AppCompatImageView) viewInflate.findViewById(R.id.iv_edit);
            if (appCompatImageView != null) {
                i2 = R.id.iv_menu_more;
                AppCompatImageView appCompatImageView2 = (AppCompatImageView) viewInflate.findViewById(R.id.iv_menu_more);
                if (appCompatImageView2 != null) {
                    i2 = R.id.swt_enabled;
                    ATESwitch aTESwitch = (ATESwitch) viewInflate.findViewById(R.id.swt_enabled);
                    if (aTESwitch != null) {
                        ItemReplaceRuleBinding itemReplaceRuleBinding = new ItemReplaceRuleBinding((LinearLayout) viewInflate, aTECheckBox, appCompatImageView, appCompatImageView2, aTESwitch);
                        j.d(itemReplaceRuleBinding, "inflate(inflater, parent, false)");
                        return itemReplaceRuleBinding;
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i2)));
    }

    @Override // io.legado.app.base.adapter.RecyclerAdapter
    public void v() {
        this.callBack.b();
    }

    @Override // io.legado.app.base.adapter.RecyclerAdapter
    public void w(final ItemViewHolder itemViewHolder, ViewBinding viewBinding) {
        final ItemReplaceRuleBinding itemReplaceRuleBinding = (ItemReplaceRuleBinding) viewBinding;
        j.e(itemViewHolder, "holder");
        j.e(itemReplaceRuleBinding, "binding");
        itemReplaceRuleBinding.f6819e.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: e.a.a.g.j.k
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                ReplaceRule item;
                ReplaceRuleAdapter replaceRuleAdapter = this.a;
                ItemViewHolder itemViewHolder2 = itemViewHolder;
                f.c0.c.j.e(replaceRuleAdapter, "this$0");
                f.c0.c.j.e(itemViewHolder2, "$holder");
                if (!compoundButton.isPressed() || (item = replaceRuleAdapter.getItem(itemViewHolder2.getLayoutPosition())) == null) {
                    return;
                }
                item.setEnabled(z);
                replaceRuleAdapter.callBack.update(item);
            }
        });
        itemReplaceRuleBinding.f6817c.setOnClickListener(new View.OnClickListener() { // from class: e.a.a.g.j.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReplaceRuleAdapter replaceRuleAdapter = this.a;
                ItemViewHolder itemViewHolder2 = itemViewHolder;
                f.c0.c.j.e(replaceRuleAdapter, "this$0");
                f.c0.c.j.e(itemViewHolder2, "$holder");
                ReplaceRule item = replaceRuleAdapter.getItem(itemViewHolder2.getLayoutPosition());
                if (item == null) {
                    return;
                }
                replaceRuleAdapter.callBack.I(item);
            }
        });
        itemReplaceRuleBinding.f6816b.setOnClickListener(new View.OnClickListener() { // from class: e.a.a.g.j.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReplaceRuleAdapter replaceRuleAdapter = this.a;
                ItemViewHolder itemViewHolder2 = itemViewHolder;
                ItemReplaceRuleBinding itemReplaceRuleBinding2 = itemReplaceRuleBinding;
                f.c0.c.j.e(replaceRuleAdapter, "this$0");
                f.c0.c.j.e(itemViewHolder2, "$holder");
                f.c0.c.j.e(itemReplaceRuleBinding2, "$this_apply");
                ReplaceRule item = replaceRuleAdapter.getItem(itemViewHolder2.getLayoutPosition());
                if (item != null) {
                    if (itemReplaceRuleBinding2.f6816b.isChecked()) {
                        replaceRuleAdapter.selected.add(item);
                    } else {
                        replaceRuleAdapter.selected.remove(item);
                    }
                }
                replaceRuleAdapter.callBack.b();
            }
        });
        itemReplaceRuleBinding.f6818d.setOnClickListener(new View.OnClickListener() { // from class: e.a.a.g.j.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                final ReplaceRuleAdapter replaceRuleAdapter = this.a;
                ItemReplaceRuleBinding itemReplaceRuleBinding2 = itemReplaceRuleBinding;
                ItemViewHolder itemViewHolder2 = itemViewHolder;
                f.c0.c.j.e(replaceRuleAdapter, "this$0");
                f.c0.c.j.e(itemReplaceRuleBinding2, "$this_apply");
                f.c0.c.j.e(itemViewHolder2, "$holder");
                AppCompatImageView appCompatImageView = itemReplaceRuleBinding2.f6818d;
                f.c0.c.j.d(appCompatImageView, "ivMenuMore");
                final ReplaceRule replaceRule = (ReplaceRule) f.x.e.n(replaceRuleAdapter.items, itemViewHolder2.getLayoutPosition());
                if (replaceRule == null) {
                    return;
                }
                PopupMenu popupMenu = new PopupMenu(replaceRuleAdapter.context, appCompatImageView);
                popupMenu.inflate(R.menu.replace_rule_item);
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { // from class: e.a.a.g.j.j
                    @Override // android.widget.PopupMenu.OnMenuItemClickListener
                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        ReplaceRuleAdapter replaceRuleAdapter2 = replaceRuleAdapter;
                        ReplaceRule replaceRule2 = replaceRule;
                        f.c0.c.j.e(replaceRuleAdapter2, "this$0");
                        f.c0.c.j.e(replaceRule2, "$item");
                        int itemId = menuItem.getItemId();
                        if (itemId == R.id.menu_bottom) {
                            replaceRuleAdapter2.callBack.J0(replaceRule2);
                            return true;
                        }
                        if (itemId == R.id.menu_del) {
                            replaceRuleAdapter2.callBack.g0(replaceRule2);
                            return true;
                        }
                        if (itemId != R.id.menu_top) {
                            return true;
                        }
                        replaceRuleAdapter2.callBack.q0(replaceRule2);
                        return true;
                    }
                });
                popupMenu.show();
            }
        });
    }
}

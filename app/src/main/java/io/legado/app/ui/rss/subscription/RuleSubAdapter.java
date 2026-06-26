package io.legado.app.ui.rss.subscription;

import android.content.Context;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.umeng.analytics.pro.ai;
import com.umeng.analytics.pro.c;
import f.c0.c.j;
import f.x.e;
import io.legado.app.base.adapter.ItemViewHolder;
import io.legado.app.base.adapter.RecyclerAdapter;
import io.legado.app.data.entities.RuleSub;
import io.legado.app.databinding.ItemRuleSubBinding;
import io.legado.app.ui.rss.subscription.RuleSubAdapter;
import io.legado.app.ui.widget.recycler.ItemTouchCallback;
import io.legado.app.ui.widget.text.AccentBgTextView;
import io.wenyuange.app.release.R;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: RuleSubAdapter.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0001'B\u0017\u0012\u0006\u0010$\u001a\u00020#\u0012\u0006\u0010\"\u001a\u00020\u001d¢\u0006\u0004\b%\u0010&J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R&\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0012j\b\u0012\u0004\u0012\u00020\u0002`\u00138\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R:\u0010\u001c\u001a&\u0012\f\u0012\n \u0019*\u0004\u0018\u00010\u00180\u0018 \u0019*\u0012\u0012\u000e\b\u0001\u0012\n \u0019*\u0004\u0018\u00010\u00180\u00180\u00170\u00178\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0019\u0010\"\u001a\u00020\u001d8\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!¨\u0006("}, d2 = {"Lio/legado/app/ui/rss/subscription/RuleSubAdapter;", "Lio/legado/app/base/adapter/RecyclerAdapter;", "Lio/legado/app/data/entities/RuleSub;", "Lio/legado/app/databinding/ItemRuleSubBinding;", "Lio/legado/app/ui/widget/recycler/ItemTouchCallback$a;", "", "srcPosition", "targetPosition", "", ai.aD, "(II)Z", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "viewHolder", "Lf/v;", "b", "(Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/RecyclerView$ViewHolder;)V", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "h", "Ljava/util/HashSet;", "movedItems", "", "", "kotlin.jvm.PlatformType", "g", "[Ljava/lang/String;", "typeArray", "Lio/legado/app/ui/rss/subscription/RuleSubAdapter$a;", "f", "Lio/legado/app/ui/rss/subscription/RuleSubAdapter$a;", "getCallBack", "()Lio/legado/app/ui/rss/subscription/RuleSubAdapter$a;", "callBack", "Landroid/content/Context;", c.R, "<init>", "(Landroid/content/Context;Lio/legado/app/ui/rss/subscription/RuleSubAdapter$a;)V", ai.at, "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class RuleSubAdapter extends RecyclerAdapter<RuleSub, ItemRuleSubBinding> implements ItemTouchCallback.a {

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final a callBack;

    /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final String[] typeArray;

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final HashSet<RuleSub> movedItems;

    /* JADX INFO: compiled from: RuleSubAdapter.kt */
    public interface a {
        void G0(@NotNull RuleSub ruleSub);

        void Q(@NotNull RuleSub ruleSub);

        void a();

        void p0(@NotNull RuleSub ruleSub);

        void r(@NotNull RuleSub... ruleSubArr);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RuleSubAdapter(@NotNull Context context, @NotNull a aVar) {
        super(context);
        j.e(context, c.R);
        j.e(aVar, "callBack");
        this.callBack = aVar;
        String[] stringArray = context.getResources().getStringArray(R.array.rule_type);
        j.d(stringArray, "context.resources.getStringArray(R.array.rule_type)");
        this.typeArray = stringArray;
        this.movedItems = new HashSet<>();
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
            Object[] array = this.movedItems.toArray(new RuleSub[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
            RuleSub[] ruleSubArr = (RuleSub[]) array;
            aVar.r((RuleSub[]) Arrays.copyOf(ruleSubArr, ruleSubArr.length));
            this.movedItems.clear();
        }
    }

    @Override // io.legado.app.ui.widget.recycler.ItemTouchCallback.a
    public boolean c(int srcPosition, int targetPosition) {
        RuleSub ruleSub = (RuleSub) e.n(this.items, srcPosition);
        RuleSub ruleSub2 = (RuleSub) e.n(this.items, targetPosition);
        if (ruleSub != null && ruleSub2 != null) {
            if (ruleSub.getCustomOrder() == ruleSub2.getCustomOrder()) {
                this.callBack.a();
            } else {
                int customOrder = ruleSub.getCustomOrder();
                ruleSub.setCustomOrder(ruleSub2.getCustomOrder());
                ruleSub2.setCustomOrder(customOrder);
                this.movedItems.add(ruleSub);
                this.movedItems.add(ruleSub2);
            }
        }
        z(srcPosition, targetPosition);
        return true;
    }

    @Override // io.legado.app.base.adapter.RecyclerAdapter
    public void i(ItemViewHolder itemViewHolder, ViewBinding viewBinding, RuleSub ruleSub, List list, int i2) {
        ItemRuleSubBinding itemRuleSubBinding = (ItemRuleSubBinding) viewBinding;
        RuleSub ruleSub2 = ruleSub;
        j.e(itemViewHolder, "holder");
        j.e(itemRuleSubBinding, "binding");
        j.e(ruleSub2, "item");
        j.e(list, "payloads");
        itemRuleSubBinding.f6838e.setText(this.typeArray[ruleSub2.getType()]);
        itemRuleSubBinding.f6837d.setText(ruleSub2.getName());
        itemRuleSubBinding.f6839f.setText(ruleSub2.getUrl());
    }

    @Override // io.legado.app.base.adapter.RecyclerAdapter
    public ViewBinding q(ViewGroup viewGroup) {
        j.e(viewGroup, "parent");
        View viewInflate = this.inflater.inflate(R.layout.item_rule_sub, viewGroup, false);
        int i2 = R.id.iv_edit;
        AppCompatImageView appCompatImageView = (AppCompatImageView) viewInflate.findViewById(R.id.iv_edit);
        if (appCompatImageView != null) {
            i2 = R.id.iv_menu_more;
            AppCompatImageView appCompatImageView2 = (AppCompatImageView) viewInflate.findViewById(R.id.iv_menu_more);
            if (appCompatImageView2 != null) {
                i2 = R.id.tv_name;
                TextView textView = (TextView) viewInflate.findViewById(R.id.tv_name);
                if (textView != null) {
                    i2 = R.id.tv_type;
                    AccentBgTextView accentBgTextView = (AccentBgTextView) viewInflate.findViewById(R.id.tv_type);
                    if (accentBgTextView != null) {
                        i2 = R.id.tv_url;
                        TextView textView2 = (TextView) viewInflate.findViewById(R.id.tv_url);
                        if (textView2 != null) {
                            ItemRuleSubBinding itemRuleSubBinding = new ItemRuleSubBinding((ConstraintLayout) viewInflate, appCompatImageView, appCompatImageView2, textView, accentBgTextView, textView2);
                            j.d(itemRuleSubBinding, "inflate(inflater, parent, false)");
                            return itemRuleSubBinding;
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i2)));
    }

    @Override // io.legado.app.base.adapter.RecyclerAdapter
    public void w(final ItemViewHolder itemViewHolder, ViewBinding viewBinding) {
        final ItemRuleSubBinding itemRuleSubBinding = (ItemRuleSubBinding) viewBinding;
        j.e(itemViewHolder, "holder");
        j.e(itemRuleSubBinding, "binding");
        itemRuleSubBinding.a.setOnClickListener(new View.OnClickListener() { // from class: e.a.a.g.k.e.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RuleSubAdapter ruleSubAdapter = this.a;
                ItemViewHolder itemViewHolder2 = itemViewHolder;
                j.e(ruleSubAdapter, "this$0");
                j.e(itemViewHolder2, "$holder");
                RuleSubAdapter.a aVar = ruleSubAdapter.callBack;
                RuleSub item = ruleSubAdapter.getItem(itemViewHolder2.getLayoutPosition());
                j.c(item);
                aVar.p0(item);
            }
        });
        itemRuleSubBinding.f6835b.setOnClickListener(new View.OnClickListener() { // from class: e.a.a.g.k.e.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RuleSubAdapter ruleSubAdapter = this.a;
                ItemViewHolder itemViewHolder2 = itemViewHolder;
                j.e(ruleSubAdapter, "this$0");
                j.e(itemViewHolder2, "$holder");
                RuleSubAdapter.a aVar = ruleSubAdapter.callBack;
                RuleSub item = ruleSubAdapter.getItem(itemViewHolder2.getLayoutPosition());
                j.c(item);
                aVar.Q(item);
            }
        });
        itemRuleSubBinding.f6836c.setOnClickListener(new View.OnClickListener() { // from class: e.a.a.g.k.e.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                final RuleSubAdapter ruleSubAdapter = this.a;
                ItemRuleSubBinding itemRuleSubBinding2 = itemRuleSubBinding;
                ItemViewHolder itemViewHolder2 = itemViewHolder;
                j.e(ruleSubAdapter, "this$0");
                j.e(itemRuleSubBinding2, "$binding");
                j.e(itemViewHolder2, "$holder");
                AppCompatImageView appCompatImageView = itemRuleSubBinding2.f6836c;
                j.d(appCompatImageView, "binding.ivMenuMore");
                final RuleSub ruleSub = (RuleSub) f.x.e.n(ruleSubAdapter.items, itemViewHolder2.getLayoutPosition());
                if (ruleSub == null) {
                    return;
                }
                PopupMenu popupMenu = new PopupMenu(ruleSubAdapter.context, appCompatImageView);
                popupMenu.inflate(R.menu.source_sub_item);
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { // from class: e.a.a.g.k.e.b
                    @Override // android.widget.PopupMenu.OnMenuItemClickListener
                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        RuleSubAdapter ruleSubAdapter2 = ruleSubAdapter;
                        RuleSub ruleSub2 = ruleSub;
                        j.e(ruleSubAdapter2, "this$0");
                        j.e(ruleSub2, "$source");
                        if (menuItem.getItemId() != R.id.menu_del) {
                            return true;
                        }
                        ruleSubAdapter2.callBack.G0(ruleSub2);
                        return true;
                    }
                });
                popupMenu.show();
            }
        });
    }
}

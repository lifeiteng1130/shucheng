package io.legado.app.ui.book.search;

import android.R;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import com.umeng.analytics.pro.ai;
import e.a.a.g.d.j.o;
import f.c0.c.j;
import io.legado.app.base.adapter.ItemViewHolder;
import io.legado.app.base.adapter.RecyclerAdapter;
import io.legado.app.data.entities.SearchKeyword;
import io.legado.app.databinding.ItemFilletTextBinding;
import io.legado.app.ui.book.search.HistoryKeyAdapter;
import io.legado.app.ui.widget.anima.explosion_field.ExplosionView;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: HistoryKeyAdapter.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0012B\u0017\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\t\u001a\u00020\u0004¢\u0006\u0004\b\u0010\u0010\u0011R\u0019\u0010\t\u001a\u00020\u00048\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0013"}, d2 = {"Lio/legado/app/ui/book/search/HistoryKeyAdapter;", "Lio/legado/app/base/adapter/RecyclerAdapter;", "Lio/legado/app/data/entities/SearchKeyword;", "Lio/legado/app/databinding/ItemFilletTextBinding;", "Lio/legado/app/ui/book/search/HistoryKeyAdapter$a;", "f", "Lio/legado/app/ui/book/search/HistoryKeyAdapter$a;", "getCallBack", "()Lio/legado/app/ui/book/search/HistoryKeyAdapter$a;", "callBack", "Lio/legado/app/ui/widget/anima/explosion_field/ExplosionView;", "g", "Lio/legado/app/ui/widget/anima/explosion_field/ExplosionView;", "explosionField", "Lio/legado/app/ui/book/search/SearchActivity;", "activity", "<init>", "(Lio/legado/app/ui/book/search/SearchActivity;Lio/legado/app/ui/book/search/HistoryKeyAdapter$a;)V", ai.at, "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class HistoryKeyAdapter extends RecyclerAdapter<SearchKeyword, ItemFilletTextBinding> {

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final a callBack;

    /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final ExplosionView explosionField;

    /* JADX INFO: compiled from: HistoryKeyAdapter.kt */
    public interface a {
        void P(@NotNull String str);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HistoryKeyAdapter(@NotNull SearchActivity searchActivity, @NotNull a aVar) {
        super(searchActivity);
        j.e(searchActivity, "activity");
        j.e(aVar, "callBack");
        this.callBack = aVar;
        j.e(searchActivity, "activity");
        View viewFindViewById = searchActivity.findViewById(R.id.content);
        Objects.requireNonNull(viewFindViewById, "null cannot be cast to non-null type android.view.ViewGroup");
        ExplosionView explosionView = new ExplosionView(searchActivity, null);
        ((ViewGroup) viewFindViewById).addView(explosionView, new ViewGroup.LayoutParams(-1, -1));
        this.explosionField = explosionView;
    }

    @Override // io.legado.app.base.adapter.RecyclerAdapter
    public void i(ItemViewHolder itemViewHolder, ViewBinding viewBinding, SearchKeyword searchKeyword, List list, int i2) {
        ItemFilletTextBinding itemFilletTextBinding = (ItemFilletTextBinding) viewBinding;
        SearchKeyword searchKeyword2 = searchKeyword;
        j.e(itemViewHolder, "holder");
        j.e(itemFilletTextBinding, "binding");
        j.e(searchKeyword2, "item");
        j.e(list, "payloads");
        itemFilletTextBinding.f6784b.setText(searchKeyword2.getWord());
    }

    @Override // io.legado.app.base.adapter.RecyclerAdapter
    public ViewBinding q(ViewGroup viewGroup) {
        j.e(viewGroup, "parent");
        ItemFilletTextBinding itemFilletTextBindingA = ItemFilletTextBinding.a(this.inflater, viewGroup, false);
        j.d(itemFilletTextBindingA, "inflate(inflater, parent, false)");
        return itemFilletTextBindingA;
    }

    @Override // io.legado.app.base.adapter.RecyclerAdapter
    public void w(final ItemViewHolder itemViewHolder, ViewBinding viewBinding) {
        j.e(itemViewHolder, "holder");
        j.e((ItemFilletTextBinding) viewBinding, "binding");
        View view = itemViewHolder.itemView;
        view.setOnClickListener(new View.OnClickListener() { // from class: e.a.a.g.d.j.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                HistoryKeyAdapter historyKeyAdapter = this.a;
                ItemViewHolder itemViewHolder2 = itemViewHolder;
                f.c0.c.j.e(historyKeyAdapter, "this$0");
                f.c0.c.j.e(itemViewHolder2, "$holder");
                SearchKeyword item = historyKeyAdapter.getItem(itemViewHolder2.getLayoutPosition());
                if (item == null) {
                    return;
                }
                historyKeyAdapter.callBack.P(item.getWord());
            }
        });
        j.d(view, "");
        view.setOnLongClickListener(new o(true, this, view, itemViewHolder));
    }
}

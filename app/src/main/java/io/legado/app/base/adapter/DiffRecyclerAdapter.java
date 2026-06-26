package io.legado.app.base.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.AsyncListDiffer;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import c.b.a.m.f;
import com.qq.e.comm.constants.Constants;
import com.umeng.analytics.pro.ai;
import com.umeng.analytics.pro.c;
import f.c0.c.j;
import f.c0.c.k;
import f.e;
import f.h;
import f.v;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: DiffRecyclerAdapter.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u0000*\u0004\b\u0000\u0010\u0001*\b\b\u0001\u0010\u0003*\u00020\u00022\b\u0012\u0004\u0012\u00020\u00050\u0004B\u000f\u0012\u0006\u0010?\u001a\u00020:¢\u0006\u0004\bF\u0010GJ\u001d\u0010\t\u001a\u00020\b2\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0006¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u0004\u0018\u00018\u00002\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0013\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0011\u001a\u00020\u000b¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001a\u00028\u00012\u0006\u0010\u0016\u001a\u00020\u0015H$¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ5\u0010#\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00028\u00012\u0006\u0010\u001f\u001a\u00028\u00002\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020!0 H&¢\u0006\u0004\b#\u0010$J\u001f\u0010%\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00028\u0001H&¢\u0006\u0004\b%\u0010&J\u001f\u0010(\u001a\u00020\u000b2\u0006\u0010'\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0014¢\u0006\u0004\b(\u0010)J\u001f\u0010*\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010'\u001a\u00020\u000bH\u0016¢\u0006\u0004\b*\u0010+J\u001d\u0010,\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b,\u0010-J+\u0010.\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000b2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020!0 ¢\u0006\u0004\b.\u0010/R#\u00105\u001a\b\u0012\u0004\u0012\u00028\u0000008B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104R\u001c\u00109\u001a\b\u0012\u0004\u0012\u00028\u0000068&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b7\u00108R\u001c\u0010?\u001a\u00020:8\u0004@\u0004X\u0084\u0004¢\u0006\f\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>R\u0019\u0010E\u001a\u00020@8\u0006@\u0006¢\u0006\f\n\u0004\bA\u0010B\u001a\u0004\bC\u0010D¨\u0006H"}, d2 = {"Lio/legado/app/base/adapter/DiffRecyclerAdapter;", "ITEM", "Landroidx/viewbinding/ViewBinding;", "VB", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lio/legado/app/base/adapter/ItemViewHolder;", "", "items", "Lf/v;", "n", "(Ljava/util/List;)V", "", "position", "getItem", "(I)Ljava/lang/Object;", "g", "()Ljava/util/List;", "getItemCount", "()I", "getItemViewType", "(I)I", "Landroid/view/ViewGroup;", "parent", ai.aA, "(Landroid/view/ViewGroup;)Landroidx/viewbinding/ViewBinding;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "onAttachedToRecyclerView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "holder", "binding", "item", "", "", "payloads", "d", "(Lio/legado/app/base/adapter/ItemViewHolder;Landroidx/viewbinding/ViewBinding;Ljava/lang/Object;Ljava/util/List;)V", "m", "(Lio/legado/app/base/adapter/ItemViewHolder;Landroidx/viewbinding/ViewBinding;)V", "viewType", "h", "(II)I", Constants.LANDSCAPE, "(Landroid/view/ViewGroup;I)Lio/legado/app/base/adapter/ItemViewHolder;", "j", "(Lio/legado/app/base/adapter/ItemViewHolder;I)V", "k", "(Lio/legado/app/base/adapter/ItemViewHolder;ILjava/util/List;)V", "Landroidx/recyclerview/widget/AsyncListDiffer;", ai.aD, "Lf/e;", "e", "()Landroidx/recyclerview/widget/AsyncListDiffer;", "asyncListDiffer", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "f", "()Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "diffItemCallback", "Landroid/content/Context;", ai.at, "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", c.R, "Landroid/view/LayoutInflater;", "b", "Landroid/view/LayoutInflater;", "getInflater", "()Landroid/view/LayoutInflater;", "inflater", "<init>", "(Landroid/content/Context;)V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public abstract class DiffRecyclerAdapter<ITEM, VB extends ViewBinding> extends RecyclerView.Adapter<ItemViewHolder> {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    @NotNull
    public final Context context;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final LayoutInflater inflater;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final e asyncListDiffer;

    /* JADX INFO: compiled from: DiffRecyclerAdapter.kt */
    public static final class a extends k implements f.c0.b.a<AsyncListDiffer<ITEM>> {
        public final /* synthetic */ DiffRecyclerAdapter<ITEM, VB> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(DiffRecyclerAdapter<ITEM, VB> diffRecyclerAdapter) {
            super(0);
            this.this$0 = diffRecyclerAdapter;
        }

        @Override // f.c0.b.a
        @NotNull
        public final AsyncListDiffer<ITEM> invoke() {
            DiffRecyclerAdapter<ITEM, VB> diffRecyclerAdapter = this.this$0;
            AsyncListDiffer<ITEM> asyncListDiffer = new AsyncListDiffer<>(diffRecyclerAdapter, diffRecyclerAdapter.f());
            final DiffRecyclerAdapter<ITEM, VB> diffRecyclerAdapter2 = this.this$0;
            asyncListDiffer.addListListener(new AsyncListDiffer.ListListener() { // from class: e.a.a.b.e.a
                @Override // androidx.recyclerview.widget.AsyncListDiffer.ListListener
                public final void onCurrentListChanged(List list, List list2) {
                    j.e(diffRecyclerAdapter2, "this$0");
                    j.e(list, "$noName_0");
                    j.e(list2, "$noName_1");
                }
            });
            return asyncListDiffer;
        }
    }

    public DiffRecyclerAdapter(@NotNull Context context) {
        j.e(context, c.R);
        this.context = context;
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(context);
        j.d(layoutInflaterFrom, "from(context)");
        this.inflater = layoutInflaterFrom;
        this.asyncListDiffer = f.N3(new a(this));
    }

    public abstract void d(@NotNull ItemViewHolder holder, @NotNull VB binding, ITEM item, @NotNull List<Object> payloads);

    public final AsyncListDiffer<ITEM> e() {
        return (AsyncListDiffer) this.asyncListDiffer.getValue();
    }

    @NotNull
    public abstract DiffUtil.ItemCallback<ITEM> f();

    @NotNull
    public final List<ITEM> g() {
        List<ITEM> currentList = e().getCurrentList();
        j.d(currentList, "asyncListDiffer.currentList");
        return currentList;
    }

    @Nullable
    public final ITEM getItem(int position) {
        List<ITEM> currentList = e().getCurrentList();
        j.d(currentList, "asyncListDiffer.currentList");
        return (ITEM) f.x.e.n(currentList, position);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return g().size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int position) {
        return 0;
    }

    public int h() {
        return 1;
    }

    @NotNull
    public abstract VB i(@NotNull ViewGroup parent);

    public final void j(@NotNull ItemViewHolder itemViewHolder) {
        j.e(itemViewHolder, "holder");
    }

    public final void k(@NotNull ItemViewHolder itemViewHolder, @NotNull List list) {
        j.e(itemViewHolder, "holder");
        j.e(list, "payloads");
        ITEM item = getItem(itemViewHolder.getLayoutPosition());
        if (item == null) {
            return;
        }
        d(itemViewHolder, itemViewHolder.binding, item, list);
    }

    @NotNull
    public ItemViewHolder l(@NotNull ViewGroup viewGroup) {
        j.e(viewGroup, "parent");
        ItemViewHolder itemViewHolder = new ItemViewHolder(i(viewGroup));
        m(itemViewHolder, itemViewHolder.binding);
        return itemViewHolder;
    }

    public abstract void m(@NotNull ItemViewHolder holder, @NotNull VB binding);

    /* JADX WARN: Multi-variable type inference failed */
    public final synchronized void n(@Nullable List<? extends ITEM> items) {
        try {
            e().submitList(items);
            h.m11constructorimpl(v.a);
        } catch (Throwable th) {
            h.m11constructorimpl(f.m1(th));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(@NotNull RecyclerView recyclerView) {
        j.e(recyclerView, "recyclerView");
        super.onAttachedToRecyclerView(recyclerView);
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            ((GridLayoutManager) layoutManager).setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup(this) { // from class: io.legado.app.base.adapter.DiffRecyclerAdapter.onAttachedToRecyclerView.1
                public final /* synthetic */ DiffRecyclerAdapter<ITEM, VB> a;

                {
                    this.a = this;
                }

                @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
                public int getSpanSize(int position) {
                    DiffRecyclerAdapter<ITEM, VB> diffRecyclerAdapter = this.a;
                    diffRecyclerAdapter.getItemViewType(position);
                    return diffRecyclerAdapter.h();
                }
            });
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i2) {
        j((ItemViewHolder) viewHolder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return l(viewGroup);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(RecyclerView.ViewHolder viewHolder) {
        ItemViewHolder itemViewHolder = (ItemViewHolder) viewHolder;
        j.e(itemViewHolder, "holder");
        super.onViewAttachedToWindow(itemViewHolder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i2, List list) {
        k((ItemViewHolder) viewHolder, list);
    }
}

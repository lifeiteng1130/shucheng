package io.legado.app.base.adapter;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import c.b.a.m.f;
import com.qq.e.comm.constants.Constants;
import com.umeng.analytics.pro.ai;
import com.umeng.analytics.pro.c;
import f.c0.b.l;
import f.c0.c.j;
import f.c0.c.k;
import f.e;
import f.h;
import f.v;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: RecyclerAdapter.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\b&\u0018\u0000*\u0004\b\u0000\u0010\u0001*\b\b\u0001\u0010\u0003*\u00020\u00022\b\u0012\u0004\u0012\u00020\u00050\u0004B\u000f\u0012\u0006\u0010R\u001a\u00020M¢\u0006\u0004\ba\u0010bJ\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000b\u0010\nJ0\u0010\u0013\u001a\u00020\u00122!\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00020\f¢\u0006\u0004\b\u0013\u0010\u0014J0\u0010\u0016\u001a\u00020\u00122!\u0010\u0015\u001a\u001d\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00020\f¢\u0006\u0004\b\u0016\u0010\u0014J\u001d\u0010\u0019\u001a\u00020\u00122\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ+\u0010\u001d\u001a\u00020\u00122\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00172\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u001b¢\u0006\u0004\b\u001d\u0010\u001eJ\u0015\u0010 \u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00028\u0000¢\u0006\u0004\b \u0010!J\u001b\u0010#\u001a\u00020\u00122\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000\u0017¢\u0006\u0004\b#\u0010\u001aJ\u001d\u0010&\u001a\u00020\u00122\u0006\u0010$\u001a\u00020\u00062\u0006\u0010%\u001a\u00020\u0006¢\u0006\u0004\b&\u0010'J\r\u0010(\u001a\u00020\u0012¢\u0006\u0004\b(\u0010)J\r\u0010*\u001a\u00020\u0006¢\u0006\u0004\b*\u0010+J\r\u0010,\u001a\u00020\u0006¢\u0006\u0004\b,\u0010+J\u0017\u0010-\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b-\u0010.J\u0017\u0010/\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b/\u0010.J\r\u00100\u001a\u00020\u0006¢\u0006\u0004\b0\u0010+J\u0015\u00101\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b1\u00102J\u000f\u00103\u001a\u00020\u0012H\u0016¢\u0006\u0004\b3\u0010)J\u0017\u00104\u001a\u00028\u00012\u0006\u0010\u0010\u001a\u00020\rH$¢\u0006\u0004\b4\u00105J\u0017\u00108\u001a\u00020\u00122\u0006\u00107\u001a\u000206H\u0016¢\u0006\u0004\b8\u00109J=\u0010?\u001a\u00020\u00122\u0006\u0010:\u001a\u00020\u00052\u0006\u0010;\u001a\u00028\u00012\u0006\u0010\u001f\u001a\u00028\u00002\f\u0010>\u001a\b\u0012\u0004\u0012\u00020=0<2\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b?\u0010@J\u001f\u0010A\u001a\u00020\u00122\u0006\u0010:\u001a\u00020\u00052\u0006\u0010;\u001a\u00028\u0001H&¢\u0006\u0004\bA\u0010BJ\u001f\u0010C\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00020\u0006H\u0014¢\u0006\u0004\bC\u0010DJ\u001f\u0010F\u001a\u00020\u00062\u0006\u0010E\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0014¢\u0006\u0004\bF\u0010GJ\u001d\u0010H\u001a\u00020\u00122\u0006\u0010:\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\bH\u0010IJ+\u0010J\u001a\u00020\u00122\u0006\u0010:\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010>\u001a\b\u0012\u0004\u0012\u00020=0<¢\u0006\u0004\bJ\u0010KR\u001c\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000<8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010LR\u001c\u0010R\u001a\u00020M8\u0004@\u0004X\u0084\u0004¢\u0006\f\n\u0004\bN\u0010O\u001a\u0004\bP\u0010QR>\u0010W\u001a#\u0012\u001f\u0012\u001d\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00020\f0S8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010T\u001a\u0004\bU\u0010VR\u0019\u0010]\u001a\u00020X8\u0006@\u0006¢\u0006\f\n\u0004\bY\u0010Z\u001a\u0004\b[\u0010\\R>\u0010`\u001a#\u0012\u001f\u0012\u001d\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00020\f0S8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b^\u0010T\u001a\u0004\b_\u0010V¨\u0006c"}, d2 = {"Lio/legado/app/base/adapter/RecyclerAdapter;", "ITEM", "Landroidx/viewbinding/ViewBinding;", "VB", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lio/legado/app/base/adapter/ItemViewHolder;", "", "position", "", ai.az, "(I)Z", "r", "Lkotlin/Function1;", "Landroid/view/ViewGroup;", "Lkotlin/ParameterName;", "name", "parent", "header", "Lf/v;", "e", "(Lf/c0/b/l;)V", "footer", "d", "", "items", "x", "(Ljava/util/List;)V", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "itemCallback", "y", "(Ljava/util/List;Landroidx/recyclerview/widget/DiffUtil$ItemCallback;)V", "item", "f", "(Ljava/lang/Object;)V", "newItems", "g", "oldPosition", "newPosition", ai.aB, "(II)V", "h", "()V", "j", "()I", Constants.LANDSCAPE, "getItem", "(I)Ljava/lang/Object;", "n", "getItemCount", "getItemViewType", "(I)I", ai.aC, "q", "(Landroid/view/ViewGroup;)Landroidx/viewbinding/ViewBinding;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "onAttachedToRecyclerView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "holder", "binding", "", "", "payloads", ai.aA, "(Lio/legado/app/base/adapter/ItemViewHolder;Landroidx/viewbinding/ViewBinding;Ljava/lang/Object;Ljava/util/List;I)V", "w", "(Lio/legado/app/base/adapter/ItemViewHolder;Landroidx/viewbinding/ViewBinding;)V", "o", "(Ljava/lang/Object;I)I", "viewType", "p", "(II)I", ai.aF, "(Lio/legado/app/base/adapter/ItemViewHolder;I)V", ai.aE, "(Lio/legado/app/base/adapter/ItemViewHolder;ILjava/util/List;)V", "Ljava/util/List;", "Landroid/content/Context;", ai.at, "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", c.R, "Landroid/util/SparseArray;", "Lf/e;", "k", "()Landroid/util/SparseArray;", "footerItems", "Landroid/view/LayoutInflater;", "b", "Landroid/view/LayoutInflater;", "getInflater", "()Landroid/view/LayoutInflater;", "inflater", ai.aD, "m", "headerItems", "<init>", "(Landroid/content/Context;)V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public abstract class RecyclerAdapter<ITEM, VB extends ViewBinding> extends RecyclerView.Adapter<ItemViewHolder> {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    @NotNull
    public final Context context;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final LayoutInflater inflater;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final e headerItems;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final e footerItems;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final List<ITEM> items;

    /* JADX INFO: compiled from: RecyclerAdapter.kt */
    public static final class a extends k implements f.c0.b.a<SparseArray<l<? super ViewGroup, ? extends ViewBinding>>> {
        public static final a INSTANCE = new a();

        public a() {
            super(0);
        }

        @Override // f.c0.b.a
        @NotNull
        public final SparseArray<l<? super ViewGroup, ? extends ViewBinding>> invoke() {
            return new SparseArray<>();
        }
    }

    /* JADX INFO: compiled from: RecyclerAdapter.kt */
    public static final class b extends k implements f.c0.b.a<SparseArray<l<? super ViewGroup, ? extends ViewBinding>>> {
        public static final b INSTANCE = new b();

        public b() {
            super(0);
        }

        @Override // f.c0.b.a
        @NotNull
        public final SparseArray<l<? super ViewGroup, ? extends ViewBinding>> invoke() {
            return new SparseArray<>();
        }
    }

    public RecyclerAdapter(@NotNull Context context) {
        j.e(context, c.R);
        this.context = context;
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(context);
        j.d(layoutInflaterFrom, "from(context)");
        this.inflater = layoutInflaterFrom;
        this.headerItems = f.N3(b.INSTANCE);
        this.footerItems = f.N3(a.INSTANCE);
        this.items = new ArrayList();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final synchronized void d(@NotNull l<? super ViewGroup, ? extends ViewBinding> footer) {
        j.e(footer, "footer");
        try {
            int iJ = j() + k().size();
            k().put(k().size() + 2147482648, footer);
            notifyItemInserted(iJ);
            h.m11constructorimpl(v.a);
        } catch (Throwable th) {
            h.m11constructorimpl(f.m1(th));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final synchronized void e(@NotNull l<? super ViewGroup, ? extends ViewBinding> header) {
        j.e(header, "header");
        try {
            int size = m().size();
            m().put(m().size() - Integer.MIN_VALUE, header);
            notifyItemInserted(size);
            h.m11constructorimpl(v.a);
        } catch (Throwable th) {
            h.m11constructorimpl(f.m1(th));
        }
    }

    public final synchronized void f(ITEM item) {
        try {
            int iJ = j();
            if (this.items.add(item)) {
                notifyItemInserted(iJ + l());
            }
            v();
            h.m11constructorimpl(v.a);
        } catch (Throwable th) {
            h.m11constructorimpl(f.m1(th));
        }
    }

    public final synchronized void g(@NotNull List<? extends ITEM> newItems) {
        j.e(newItems, "newItems");
        try {
            int iJ = j();
            if (this.items.addAll(newItems)) {
                if (iJ == 0 && l() == 0) {
                    notifyDataSetChanged();
                } else {
                    notifyItemRangeInserted(iJ + l(), newItems.size());
                }
            }
            v();
            h.m11constructorimpl(v.a);
        } catch (Throwable th) {
            h.m11constructorimpl(f.m1(th));
        }
    }

    @Nullable
    public final ITEM getItem(int position) {
        return (ITEM) f.x.e.n(this.items, position);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return l() + j() + k().size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int position) {
        if (position < l()) {
            return position - Integer.MIN_VALUE;
        }
        if (r(position)) {
            return ((position + 2147482648) - j()) - l();
        }
        if (getItem(position - l()) == null) {
            return 0;
        }
        l();
        return o();
    }

    public final synchronized void h() {
        try {
            this.items.clear();
            notifyDataSetChanged();
            v();
            h.m11constructorimpl(v.a);
        } catch (Throwable th) {
            h.m11constructorimpl(f.m1(th));
        }
    }

    public abstract void i(@NotNull ItemViewHolder holder, @NotNull VB binding, ITEM item, @NotNull List<Object> payloads, int position);

    public final int j() {
        return this.items.size();
    }

    public final SparseArray<l<ViewGroup, ViewBinding>> k() {
        return (SparseArray) this.footerItems.getValue();
    }

    public final int l() {
        return m().size();
    }

    public final SparseArray<l<ViewGroup, ViewBinding>> m() {
        return (SparseArray) this.headerItems.getValue();
    }

    @Nullable
    public final ITEM n(int position) {
        return (ITEM) f.x.e.n(this.items, position - l());
    }

    public int o() {
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(@NotNull RecyclerView recyclerView) {
        j.e(recyclerView, "recyclerView");
        super.onAttachedToRecyclerView(recyclerView);
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            ((GridLayoutManager) layoutManager).setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup(this) { // from class: io.legado.app.base.adapter.RecyclerAdapter.onAttachedToRecyclerView.1
                public final /* synthetic */ RecyclerAdapter<ITEM, VB> a;

                {
                    this.a = this;
                }

                @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
                public int getSpanSize(int position) {
                    RecyclerAdapter<ITEM, VB> recyclerAdapter = this.a;
                    recyclerAdapter.getItemViewType(position);
                    return recyclerAdapter.p();
                }
            });
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i2) {
        t((ItemViewHolder) viewHolder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        j.e(viewGroup, "parent");
        if (i2 < l() - Integer.MIN_VALUE) {
            return new ItemViewHolder(m().get(i2).invoke(viewGroup));
        }
        if (i2 >= 2147482648) {
            return new ItemViewHolder(k().get(i2).invoke(viewGroup));
        }
        ItemViewHolder itemViewHolder = new ItemViewHolder(q(viewGroup));
        w(itemViewHolder, itemViewHolder.binding);
        return itemViewHolder;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(RecyclerView.ViewHolder viewHolder) {
        ItemViewHolder itemViewHolder = (ItemViewHolder) viewHolder;
        j.e(itemViewHolder, "holder");
        super.onViewAttachedToWindow(itemViewHolder);
        if (s(itemViewHolder.getLayoutPosition())) {
            return;
        }
        r(itemViewHolder.getLayoutPosition());
    }

    public int p() {
        return 1;
    }

    @NotNull
    public abstract VB q(@NotNull ViewGroup parent);

    public final boolean r(int position) {
        return position >= l() + j();
    }

    public final boolean s(int position) {
        return position < l();
    }

    public final void t(@NotNull ItemViewHolder itemViewHolder) {
        j.e(itemViewHolder, "holder");
    }

    public final void u(@NotNull ItemViewHolder itemViewHolder, @NotNull List list) {
        ITEM item;
        j.e(itemViewHolder, "holder");
        j.e(list, "payloads");
        if (s(itemViewHolder.getLayoutPosition()) || r(itemViewHolder.getLayoutPosition()) || (item = getItem(itemViewHolder.getLayoutPosition() - l())) == null) {
            return;
        }
        i(itemViewHolder, itemViewHolder.binding, item, list, itemViewHolder.getLayoutPosition() - l());
    }

    public void v() {
    }

    public abstract void w(@NotNull ItemViewHolder holder, @NotNull VB binding);

    public final synchronized void x(@Nullable List<? extends ITEM> items) {
        try {
            if (!this.items.isEmpty()) {
                this.items.clear();
            }
            if (items != null) {
                this.items.addAll(items);
            }
            notifyDataSetChanged();
            v();
            h.m11constructorimpl(v.a);
        } catch (Throwable th) {
            h.m11constructorimpl(f.m1(th));
        }
    }

    public final synchronized void y(@Nullable final List<? extends ITEM> items, @NotNull final DiffUtil.ItemCallback<ITEM> itemCallback) {
        j.e(itemCallback, "itemCallback");
        try {
            DiffUtil.DiffResult diffResultCalculateDiff = DiffUtil.calculateDiff(new DiffUtil.Callback(this) { // from class: io.legado.app.base.adapter.RecyclerAdapter$setItems$2$callback$1
                public final /* synthetic */ RecyclerAdapter<ITEM, VB> a;

                /* JADX WARN: Multi-variable type inference failed */
                {
                    this.a = this;
                }

                /* JADX WARN: Type inference fix 'apply assigned field type' failed
                java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
                	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
                	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
                	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
                 */
                @Override // androidx.recyclerview.widget.DiffUtil.Callback
                public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
                    RecyclerAdapter<ITEM, VB> recyclerAdapter = this.a;
                    Object item = recyclerAdapter.getItem(oldItemPosition - recyclerAdapter.l());
                    if (item == null) {
                        return true;
                    }
                    List<ITEM> list = items;
                    Object objN = list == 0 ? null : f.x.e.n(list, newItemPosition - this.a.l());
                    if (objN == null) {
                        return true;
                    }
                    return itemCallback.areContentsTheSame(item, objN);
                }

                /* JADX WARN: Type inference fix 'apply assigned field type' failed
                java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
                	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
                	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
                	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
                 */
                @Override // androidx.recyclerview.widget.DiffUtil.Callback
                public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
                    RecyclerAdapter<ITEM, VB> recyclerAdapter = this.a;
                    Object item = recyclerAdapter.getItem(oldItemPosition - recyclerAdapter.l());
                    if (item == null) {
                        return true;
                    }
                    List<ITEM> list = items;
                    Object objN = list == 0 ? null : f.x.e.n(list, newItemPosition - this.a.l());
                    if (objN == null) {
                        return true;
                    }
                    return itemCallback.areItemsTheSame(item, objN);
                }

                /* JADX WARN: Type inference fix 'apply assigned field type' failed
                java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
                	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
                	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
                	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
                 */
                @Override // androidx.recyclerview.widget.DiffUtil.Callback
                @Nullable
                public Object getChangePayload(int oldItemPosition, int newItemPosition) {
                    RecyclerAdapter<ITEM, VB> recyclerAdapter = this.a;
                    Object item = recyclerAdapter.getItem(oldItemPosition - recyclerAdapter.l());
                    if (item == null) {
                        return null;
                    }
                    List<ITEM> list = items;
                    Object objN = list == 0 ? null : f.x.e.n(list, newItemPosition - this.a.l());
                    if (objN == null) {
                        return null;
                    }
                    return itemCallback.getChangePayload(item, objN);
                }

                @Override // androidx.recyclerview.widget.DiffUtil.Callback
                public int getNewListSize() {
                    List<ITEM> list = items;
                    return this.a.l() + (list == 0 ? 0 : list.size()) + this.a.k().size();
                }

                @Override // androidx.recyclerview.widget.DiffUtil.Callback
                public int getOldListSize() {
                    return this.a.getItemCount();
                }
            });
            j.d(diffResultCalculateDiff, "calculateDiff(callback)");
            if (!this.items.isEmpty()) {
                this.items.clear();
            }
            if (items != null) {
                this.items.addAll(items);
            }
            diffResultCalculateDiff.dispatchUpdatesTo(this);
            v();
            h.m11constructorimpl(v.a);
        } catch (Throwable th) {
            h.m11constructorimpl(f.m1(th));
        }
    }

    public final synchronized void z(int oldPosition, int newPosition) {
        try {
            int iJ = j();
            boolean z = false;
            if (oldPosition >= 0 && oldPosition < iJ) {
                if (newPosition >= 0 && newPosition < iJ) {
                    z = true;
                }
                if (z) {
                    int iL = oldPosition + l();
                    int iL2 = newPosition + l();
                    Collections.swap(this.items, iL, iL2);
                    notifyItemMoved(iL, iL2);
                }
            }
            v();
            h.m11constructorimpl(v.a);
        } finally {
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i2, List list) {
        u((ItemViewHolder) viewHolder, list);
    }
}

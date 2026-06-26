package io.legado.app.ui.rss.source.manage;

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
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import c.b.a.m.f;
import com.umeng.analytics.pro.ai;
import f.c0.c.j;
import f.g;
import f.v;
import f.x.e;
import io.legado.app.base.adapter.ItemViewHolder;
import io.legado.app.base.adapter.RecyclerAdapter;
import io.legado.app.data.entities.RssSource;
import io.legado.app.databinding.ItemRssSourceBinding;
import io.legado.app.lib.theme.view.ATECheckBox;
import io.legado.app.lib.theme.view.ATESwitch;
import io.legado.app.ui.rss.source.manage.RssSourceAdapter;
import io.legado.app.ui.widget.recycler.DragSelectTouchHelper;
import io.legado.app.ui.widget.recycler.ItemTouchCallback;
import io.wenyuange.app.release.R;
import j$.util.Comparator;
import j$.util.function.Function;
import j$.util.function.ToDoubleFunction;
import j$.util.function.ToIntFunction;
import j$.util.function.ToLongFunction;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: RssSourceAdapter.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u00012B\u0017\u0012\u0006\u0010/\u001a\u00020.\u0012\u0006\u0010#\u001a\u00020\u001e¢\u0006\u0004\b0\u00101J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\u0007J\u0013\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017R\u0019\u0010\u001d\u001a\u00020\u00188\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0019\u0010#\u001a\u00020\u001e8\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R&\u0010(\u001a\u0012\u0012\u0004\u0012\u00020\u00020$j\b\u0012\u0004\u0012\u00020\u0002`%8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010'R&\u0010-\u001a\u0012\u0012\u0004\u0012\u00020\u00020)j\b\u0012\u0004\u0012\u00020\u0002`*8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,¨\u00063"}, d2 = {"Lio/legado/app/ui/rss/source/manage/RssSourceAdapter;", "Lio/legado/app/base/adapter/RecyclerAdapter;", "Lio/legado/app/data/entities/RssSource;", "Lio/legado/app/databinding/ItemRssSourceBinding;", "Lio/legado/app/ui/widget/recycler/ItemTouchCallback$a;", "Lf/v;", ai.aC, "()V", "B", "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "()Ljava/util/List;", "", "srcPosition", "targetPosition", "", ai.aD, "(II)Z", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "viewHolder", "b", "(Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/RecyclerView$ViewHolder;)V", "Lio/legado/app/ui/widget/recycler/DragSelectTouchHelper$b;", ai.aA, "Lio/legado/app/ui/widget/recycler/DragSelectTouchHelper$b;", "getDragSelectCallback", "()Lio/legado/app/ui/widget/recycler/DragSelectTouchHelper$b;", "dragSelectCallback", "Lio/legado/app/ui/rss/source/manage/RssSourceAdapter$a;", "f", "Lio/legado/app/ui/rss/source/manage/RssSourceAdapter$a;", "getCallBack", "()Lio/legado/app/ui/rss/source/manage/RssSourceAdapter$a;", "callBack", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "h", "Ljava/util/HashSet;", "movedItems", "Ljava/util/LinkedHashSet;", "Lkotlin/collections/LinkedHashSet;", "g", "Ljava/util/LinkedHashSet;", "selected", "Landroid/content/Context;", com.umeng.analytics.pro.c.R, "<init>", "(Landroid/content/Context;Lio/legado/app/ui/rss/source/manage/RssSourceAdapter$a;)V", ai.at, "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class RssSourceAdapter extends RecyclerAdapter<RssSource, ItemRssSourceBinding> implements ItemTouchCallback.a {

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final a callBack;

    /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final LinkedHashSet<RssSource> selected;

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final HashSet<RssSource> movedItems;

    /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final DragSelectTouchHelper.b dragSelectCallback;

    /* JADX INFO: compiled from: RssSourceAdapter.kt */
    public interface a {
        void a();

        void b();

        void d(@NotNull RssSource rssSource);

        void e0(@NotNull RssSource rssSource);

        void g(@NotNull RssSource rssSource);

        void h(@NotNull RssSource rssSource);

        void update(@NotNull RssSource... rssSourceArr);
    }

    /* JADX INFO: compiled from: RssSourceAdapter.kt */
    public static final class b extends DragSelectTouchHelper.a<RssSource> {
        public b(DragSelectTouchHelper.a.EnumC0216a enumC0216a) {
            super(enumC0216a);
        }

        @Override // io.legado.app.ui.widget.recycler.DragSelectTouchHelper.a
        @NotNull
        public Set<RssSource> d() {
            return RssSourceAdapter.this.selected;
        }

        @Override // io.legado.app.ui.widget.recycler.DragSelectTouchHelper.a
        public RssSource e(int i2) {
            RssSource rssSource = (RssSource) e.n(RssSourceAdapter.this.items, i2);
            j.c(rssSource);
            return rssSource;
        }

        @Override // io.legado.app.ui.widget.recycler.DragSelectTouchHelper.a
        public boolean f(int i2, boolean z) {
            RssSource rssSource = (RssSource) e.n(RssSourceAdapter.this.items, i2);
            if (rssSource == null) {
                return false;
            }
            RssSourceAdapter rssSourceAdapter = RssSourceAdapter.this;
            if (z) {
                rssSourceAdapter.selected.add(rssSource);
            } else {
                rssSourceAdapter.selected.remove(rssSource);
            }
            rssSourceAdapter.notifyItemChanged(i2, BundleKt.bundleOf(new g("selected", null)));
            rssSourceAdapter.callBack.b();
            return true;
        }
    }

    /* JADX INFO: compiled from: Comparisons.kt */
    public static final class c<T> implements Comparator<T>, j$.util.Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator, j$.util.Comparator
        public final int compare(T t, T t2) {
            return f.V0(Integer.valueOf(((RssSource) t).getCustomOrder()), Integer.valueOf(((RssSource) t2).getCustomOrder()));
        }

        @Override // java.util.Comparator, j$.util.Comparator
        public /* synthetic */ Comparator reversed() {
            return Collections.reverseOrder(this);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ Comparator thenComparing(Function function) {
            return Comparator.CC.$default$thenComparing(this, function);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparing(Function function, java.util.Comparator comparator) {
            return Comparator.CC.$default$thenComparing(this, function, comparator);
        }

        @Override // java.util.Comparator, j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparing(java.util.Comparator comparator) {
            return Comparator.CC.$default$thenComparing(this, comparator);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparingDouble(ToDoubleFunction toDoubleFunction) {
            return Comparator.CC.$default$thenComparingDouble(this, toDoubleFunction);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparingInt(ToIntFunction toIntFunction) {
            return Comparator.CC.$default$thenComparingInt(this, toIntFunction);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparingLong(ToLongFunction toLongFunction) {
            return Comparator.CC.$default$thenComparingLong(this, toLongFunction);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RssSourceAdapter(@NotNull Context context, @NotNull a aVar) {
        super(context);
        j.e(context, com.umeng.analytics.pro.c.R);
        j.e(aVar, "callBack");
        this.callBack = aVar;
        this.selected = new LinkedHashSet<>();
        this.movedItems = new HashSet<>();
        this.dragSelectCallback = new b(DragSelectTouchHelper.a.EnumC0216a.ToggleAndReverse);
    }

    @NotNull
    public final List<RssSource> A() {
        ArrayList arrayList = new ArrayList();
        for (RssSource rssSource : this.items) {
            if (this.selected.contains(rssSource)) {
                arrayList.add(rssSource);
            }
        }
        return e.B(arrayList, new c());
    }

    public final void B() {
        for (RssSource rssSource : this.items) {
            if (this.selected.contains(rssSource)) {
                this.selected.remove(rssSource);
            } else {
                this.selected.add(rssSource);
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
            Object[] array = this.movedItems.toArray(new RssSource[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
            RssSource[] rssSourceArr = (RssSource[]) array;
            aVar.update((RssSource[]) Arrays.copyOf(rssSourceArr, rssSourceArr.length));
            this.movedItems.clear();
        }
    }

    @Override // io.legado.app.ui.widget.recycler.ItemTouchCallback.a
    public boolean c(int srcPosition, int targetPosition) {
        RssSource rssSource = (RssSource) e.n(this.items, srcPosition);
        RssSource rssSource2 = (RssSource) e.n(this.items, targetPosition);
        if (rssSource != null && rssSource2 != null) {
            if (rssSource.getCustomOrder() == rssSource2.getCustomOrder()) {
                this.callBack.a();
            } else {
                int customOrder = rssSource.getCustomOrder();
                rssSource.setCustomOrder(rssSource2.getCustomOrder());
                rssSource2.setCustomOrder(customOrder);
                this.movedItems.add(rssSource);
                this.movedItems.add(rssSource2);
            }
        }
        z(srcPosition, targetPosition);
        return true;
    }

    @Override // io.legado.app.base.adapter.RecyclerAdapter
    public void i(ItemViewHolder itemViewHolder, ViewBinding viewBinding, RssSource rssSource, List list, int i2) {
        ItemRssSourceBinding itemRssSourceBinding = (ItemRssSourceBinding) viewBinding;
        RssSource rssSource2 = rssSource;
        j.e(itemViewHolder, "holder");
        j.e(itemRssSourceBinding, "binding");
        j.e(rssSource2, "item");
        j.e(list, "payloads");
        Object objN = e.n(list, 0);
        Bundle bundle = objN instanceof Bundle ? (Bundle) objN : null;
        if (bundle != null) {
            Set<String> setKeySet = bundle.keySet();
            j.d(setKeySet, "bundle.keySet()");
            ArrayList arrayList = new ArrayList(f.S0(setKeySet, 10));
            Iterator<T> it = setKeySet.iterator();
            while (it.hasNext()) {
                if (j.a((String) it.next(), "selected")) {
                    itemRssSourceBinding.f6831b.setChecked(this.selected.contains(rssSource2));
                }
                arrayList.add(v.a);
            }
            return;
        }
        itemRssSourceBinding.a.setBackgroundColor((Math.min(255, Math.max(0, (int) (255 * 0.5f))) << 24) + (f.R1(this.context) & ViewCompat.MEASURED_SIZE_MASK));
        String sourceGroup = rssSource2.getSourceGroup();
        if (sourceGroup == null || sourceGroup.length() == 0) {
            itemRssSourceBinding.f6831b.setText(rssSource2.getSourceName());
        } else {
            ATECheckBox aTECheckBox = itemRssSourceBinding.f6831b;
            String str = String.format("%s (%s)", Arrays.copyOf(new Object[]{rssSource2.getSourceName(), rssSource2.getSourceGroup()}, 2));
            j.d(str, "java.lang.String.format(format, *args)");
            aTECheckBox.setText(str);
        }
        itemRssSourceBinding.f6834e.setChecked(rssSource2.getEnabled());
        itemRssSourceBinding.f6831b.setChecked(this.selected.contains(rssSource2));
    }

    @Override // io.legado.app.base.adapter.RecyclerAdapter
    public ViewBinding q(ViewGroup viewGroup) {
        j.e(viewGroup, "parent");
        View viewInflate = this.inflater.inflate(R.layout.item_rss_source, viewGroup, false);
        int i2 = R.id.cb_source;
        ATECheckBox aTECheckBox = (ATECheckBox) viewInflate.findViewById(R.id.cb_source);
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
                        ItemRssSourceBinding itemRssSourceBinding = new ItemRssSourceBinding((LinearLayout) viewInflate, aTECheckBox, appCompatImageView, appCompatImageView2, aTESwitch);
                        j.d(itemRssSourceBinding, "inflate(inflater, parent, false)");
                        return itemRssSourceBinding;
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
        final ItemRssSourceBinding itemRssSourceBinding = (ItemRssSourceBinding) viewBinding;
        j.e(itemViewHolder, "holder");
        j.e(itemRssSourceBinding, "binding");
        itemRssSourceBinding.f6834e.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: e.a.a.g.k.d.c.m
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                RssSource item;
                RssSourceAdapter rssSourceAdapter = this.a;
                ItemViewHolder itemViewHolder2 = itemViewHolder;
                f.c0.c.j.e(rssSourceAdapter, "this$0");
                f.c0.c.j.e(itemViewHolder2, "$holder");
                if (compoundButton.isPressed() && (item = rssSourceAdapter.getItem(itemViewHolder2.getLayoutPosition())) != null && compoundButton.isPressed()) {
                    item.setEnabled(z);
                    rssSourceAdapter.callBack.update(item);
                }
            }
        });
        itemRssSourceBinding.f6831b.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: e.a.a.g.k.d.c.o
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                RssSource item;
                RssSourceAdapter rssSourceAdapter = this.a;
                ItemViewHolder itemViewHolder2 = itemViewHolder;
                f.c0.c.j.e(rssSourceAdapter, "this$0");
                f.c0.c.j.e(itemViewHolder2, "$holder");
                if (compoundButton.isPressed() && (item = rssSourceAdapter.getItem(itemViewHolder2.getLayoutPosition())) != null && compoundButton.isPressed()) {
                    if (z) {
                        rssSourceAdapter.selected.add(item);
                    } else {
                        rssSourceAdapter.selected.remove(item);
                    }
                    rssSourceAdapter.callBack.b();
                }
            }
        });
        itemRssSourceBinding.f6832c.setOnClickListener(new View.OnClickListener() { // from class: e.a.a.g.k.d.c.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RssSourceAdapter rssSourceAdapter = this.a;
                ItemViewHolder itemViewHolder2 = itemViewHolder;
                f.c0.c.j.e(rssSourceAdapter, "this$0");
                f.c0.c.j.e(itemViewHolder2, "$holder");
                RssSource item = rssSourceAdapter.getItem(itemViewHolder2.getLayoutPosition());
                if (item == null) {
                    return;
                }
                rssSourceAdapter.callBack.h(item);
            }
        });
        itemRssSourceBinding.f6833d.setOnClickListener(new View.OnClickListener() { // from class: e.a.a.g.k.d.c.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                final RssSourceAdapter rssSourceAdapter = this.a;
                ItemRssSourceBinding itemRssSourceBinding2 = itemRssSourceBinding;
                ItemViewHolder itemViewHolder2 = itemViewHolder;
                f.c0.c.j.e(rssSourceAdapter, "this$0");
                f.c0.c.j.e(itemRssSourceBinding2, "$this_apply");
                f.c0.c.j.e(itemViewHolder2, "$holder");
                AppCompatImageView appCompatImageView = itemRssSourceBinding2.f6833d;
                f.c0.c.j.d(appCompatImageView, "ivMenuMore");
                final RssSource rssSource = (RssSource) f.x.e.n(rssSourceAdapter.items, itemViewHolder2.getLayoutPosition());
                if (rssSource == null) {
                    return;
                }
                PopupMenu popupMenu = new PopupMenu(rssSourceAdapter.context, appCompatImageView);
                popupMenu.inflate(R.menu.rss_source_item);
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { // from class: e.a.a.g.k.d.c.l
                    @Override // android.widget.PopupMenu.OnMenuItemClickListener
                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        RssSourceAdapter rssSourceAdapter2 = rssSourceAdapter;
                        RssSource rssSource2 = rssSource;
                        f.c0.c.j.e(rssSourceAdapter2, "this$0");
                        f.c0.c.j.e(rssSource2, "$source");
                        int itemId = menuItem.getItemId();
                        if (itemId == R.id.menu_bottom) {
                            rssSourceAdapter2.callBack.e0(rssSource2);
                            return true;
                        }
                        if (itemId == R.id.menu_del) {
                            rssSourceAdapter2.callBack.d(rssSource2);
                            return true;
                        }
                        if (itemId != R.id.menu_top) {
                            return true;
                        }
                        rssSourceAdapter2.callBack.g(rssSource2);
                        return true;
                    }
                });
                popupMenu.show();
            }
        });
    }
}

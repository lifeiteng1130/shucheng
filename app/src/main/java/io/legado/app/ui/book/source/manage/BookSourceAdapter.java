package io.legado.app.ui.book.source.manage;

import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.PopupMenu;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
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
import io.legado.app.data.entities.BookSource;
import io.legado.app.databinding.ItemBookSourceBinding;
import io.legado.app.lib.theme.view.ATECheckBox;
import io.legado.app.lib.theme.view.ATESwitch;
import io.legado.app.ui.book.source.manage.BookSourceAdapter;
import io.legado.app.ui.widget.image.CircleImageView;
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
import java.util.Collection;
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

/* JADX INFO: compiled from: BookSourceAdapter.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u00012B\u0017\u0012\u0006\u0010/\u001a\u00020.\u0012\u0006\u0010\u001d\u001a\u00020\u0018¢\u0006\u0004\b0\u00101J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\u0007J\u0013\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017R\u0019\u0010\u001d\u001a\u00020\u00188\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0019\u0010#\u001a\u00020\u001e8\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R&\u0010(\u001a\u0012\u0012\u0004\u0012\u00020\u00020$j\b\u0012\u0004\u0012\u00020\u0002`%8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010'R&\u0010-\u001a\u0012\u0012\u0004\u0012\u00020\u00020)j\b\u0012\u0004\u0012\u00020\u0002`*8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,¨\u00063"}, d2 = {"Lio/legado/app/ui/book/source/manage/BookSourceAdapter;", "Lio/legado/app/base/adapter/RecyclerAdapter;", "Lio/legado/app/data/entities/BookSource;", "Lio/legado/app/databinding/ItemBookSourceBinding;", "Lio/legado/app/ui/widget/recycler/ItemTouchCallback$a;", "Lf/v;", ai.aC, "()V", "B", "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "()Ljava/util/List;", "", "srcPosition", "targetPosition", "", ai.aD, "(II)Z", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "viewHolder", "b", "(Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/RecyclerView$ViewHolder;)V", "Lio/legado/app/ui/book/source/manage/BookSourceAdapter$a;", "f", "Lio/legado/app/ui/book/source/manage/BookSourceAdapter$a;", "getCallBack", "()Lio/legado/app/ui/book/source/manage/BookSourceAdapter$a;", "callBack", "Lio/legado/app/ui/widget/recycler/DragSelectTouchHelper$b;", ai.aA, "Lio/legado/app/ui/widget/recycler/DragSelectTouchHelper$b;", "getDragSelectCallback", "()Lio/legado/app/ui/widget/recycler/DragSelectTouchHelper$b;", "dragSelectCallback", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "h", "Ljava/util/HashSet;", "movedItems", "Ljava/util/LinkedHashSet;", "Lkotlin/collections/LinkedHashSet;", "g", "Ljava/util/LinkedHashSet;", "selected", "Landroid/content/Context;", com.umeng.analytics.pro.c.R, "<init>", "(Landroid/content/Context;Lio/legado/app/ui/book/source/manage/BookSourceAdapter$a;)V", ai.at, "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class BookSourceAdapter extends RecyclerAdapter<BookSource, ItemBookSourceBinding> implements ItemTouchCallback.a {

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final a callBack;

    /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final LinkedHashSet<BookSource> selected;

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final HashSet<BookSource> movedItems;

    /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final DragSelectTouchHelper.b dragSelectCallback;

    /* JADX INFO: compiled from: BookSourceAdapter.kt */
    public interface a {
        void C0(@NotNull BookSource bookSource);

        void X(@NotNull BookSource bookSource);

        void a();

        void b();

        void j(@NotNull BookSource bookSource);

        void n0(@NotNull BookSource bookSource);

        void s(@NotNull BookSource bookSource);

        void update(@NotNull BookSource... bookSourceArr);
    }

    /* JADX INFO: compiled from: BookSourceAdapter.kt */
    public static final class b extends DragSelectTouchHelper.a<BookSource> {
        public b(DragSelectTouchHelper.a.EnumC0216a enumC0216a) {
            super(enumC0216a);
        }

        @Override // io.legado.app.ui.widget.recycler.DragSelectTouchHelper.a
        @NotNull
        public Set<BookSource> d() {
            return BookSourceAdapter.this.selected;
        }

        @Override // io.legado.app.ui.widget.recycler.DragSelectTouchHelper.a
        public BookSource e(int i2) {
            BookSource bookSource = (BookSource) e.n(BookSourceAdapter.this.items, i2);
            j.c(bookSource);
            return bookSource;
        }

        @Override // io.legado.app.ui.widget.recycler.DragSelectTouchHelper.a
        public boolean f(int i2, boolean z) {
            BookSource bookSource = (BookSource) e.n(BookSourceAdapter.this.items, i2);
            if (bookSource == null) {
                return false;
            }
            BookSourceAdapter bookSourceAdapter = BookSourceAdapter.this;
            if (z) {
                bookSourceAdapter.selected.add(bookSource);
            } else {
                bookSourceAdapter.selected.remove(bookSource);
            }
            bookSourceAdapter.notifyItemChanged(i2, BundleKt.bundleOf(new g("selected", null)));
            bookSourceAdapter.callBack.b();
            return true;
        }
    }

    /* JADX INFO: compiled from: Comparisons.kt */
    public static final class c<T> implements Comparator<T>, j$.util.Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator, j$.util.Comparator
        public final int compare(T t, T t2) {
            return f.V0(Integer.valueOf(((BookSource) t).getCustomOrder()), Integer.valueOf(((BookSource) t2).getCustomOrder()));
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
    public BookSourceAdapter(@NotNull Context context, @NotNull a aVar) {
        super(context);
        j.e(context, com.umeng.analytics.pro.c.R);
        j.e(aVar, "callBack");
        this.callBack = aVar;
        this.selected = new LinkedHashSet<>();
        this.movedItems = new HashSet<>();
        this.dragSelectCallback = new b(DragSelectTouchHelper.a.EnumC0216a.ToggleAndReverse);
    }

    @NotNull
    public final List<BookSource> A() {
        ArrayList arrayList = new ArrayList();
        Collection<BookSource> collection = this.items;
        ArrayList arrayList2 = new ArrayList(f.S0(collection, 10));
        for (BookSource bookSource : collection) {
            if (this.selected.contains(bookSource)) {
                arrayList.add(bookSource);
            }
            arrayList2.add(v.a);
        }
        return e.B(arrayList, new c());
    }

    public final void B() {
        for (BookSource bookSource : this.items) {
            if (this.selected.contains(bookSource)) {
                this.selected.remove(bookSource);
            } else {
                this.selected.add(bookSource);
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
            Object[] array = this.movedItems.toArray(new BookSource[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
            BookSource[] bookSourceArr = (BookSource[]) array;
            aVar.update((BookSource[]) Arrays.copyOf(bookSourceArr, bookSourceArr.length));
            this.movedItems.clear();
        }
    }

    @Override // io.legado.app.ui.widget.recycler.ItemTouchCallback.a
    public boolean c(int srcPosition, int targetPosition) {
        BookSource bookSource = (BookSource) e.n(this.items, srcPosition);
        BookSource bookSource2 = (BookSource) e.n(this.items, targetPosition);
        if (bookSource != null && bookSource2 != null) {
            if (bookSource.getCustomOrder() == bookSource2.getCustomOrder()) {
                this.callBack.a();
            } else {
                int customOrder = bookSource.getCustomOrder();
                bookSource.setCustomOrder(bookSource2.getCustomOrder());
                bookSource2.setCustomOrder(customOrder);
                this.movedItems.add(bookSource);
                this.movedItems.add(bookSource2);
            }
        }
        z(srcPosition, targetPosition);
        return true;
    }

    @Override // io.legado.app.base.adapter.RecyclerAdapter
    public void i(ItemViewHolder itemViewHolder, ViewBinding viewBinding, BookSource bookSource, List list, int i2) {
        ItemBookSourceBinding itemBookSourceBinding = (ItemBookSourceBinding) viewBinding;
        BookSource bookSource2 = bookSource;
        j.e(itemViewHolder, "holder");
        j.e(itemBookSourceBinding, "binding");
        j.e(bookSource2, "item");
        j.e(list, "payloads");
        Object objN = e.n(list, 0);
        Bundle bundle = objN instanceof Bundle ? (Bundle) objN : null;
        if (bundle != null) {
            Set<String> setKeySet = bundle.keySet();
            j.d(setKeySet, "payload.keySet()");
            ArrayList arrayList = new ArrayList(f.S0(setKeySet, 10));
            Iterator<T> it = setKeySet.iterator();
            while (it.hasNext()) {
                if (j.a((String) it.next(), "selected")) {
                    itemBookSourceBinding.f6749b.setChecked(this.selected.contains(bookSource2));
                }
                arrayList.add(v.a);
            }
            return;
        }
        itemBookSourceBinding.a.setBackgroundColor((Math.min(255, Math.max(0, (int) (255 * 0.5f))) << 24) + (f.R1(this.context) & ViewCompat.MEASURED_SIZE_MASK));
        String bookSourceGroup = bookSource2.getBookSourceGroup();
        if (bookSourceGroup == null || bookSourceGroup.length() == 0) {
            itemBookSourceBinding.f6749b.setText(bookSource2.getBookSourceName());
        } else {
            ATECheckBox aTECheckBox = itemBookSourceBinding.f6749b;
            String str = String.format("%s (%s)", Arrays.copyOf(new Object[]{bookSource2.getBookSourceName(), bookSource2.getBookSourceGroup()}, 2));
            j.d(str, "java.lang.String.format(format, *args)");
            aTECheckBox.setText(str);
        }
        itemBookSourceBinding.f6753f.setChecked(bookSource2.getEnabled());
        itemBookSourceBinding.f6749b.setChecked(this.selected.contains(bookSource2));
        CircleImageView circleImageView = itemBookSourceBinding.f6751d;
        j.d(circleImageView, "ivExplore");
        String exploreUrl = bookSource2.getExploreUrl();
        if (exploreUrl == null || exploreUrl.length() == 0) {
            f.l3(circleImageView);
        } else if (bookSource2.getEnabledExplore()) {
            circleImageView.setColorFilter(-16711936);
            f.c6(circleImageView);
        } else {
            circleImageView.setColorFilter(-65536);
            f.c6(circleImageView);
        }
    }

    @Override // io.legado.app.base.adapter.RecyclerAdapter
    public ViewBinding q(ViewGroup viewGroup) {
        j.e(viewGroup, "parent");
        View viewInflate = this.inflater.inflate(R.layout.item_book_source, viewGroup, false);
        int i2 = R.id.cb_book_source;
        ATECheckBox aTECheckBox = (ATECheckBox) viewInflate.findViewById(R.id.cb_book_source);
        if (aTECheckBox != null) {
            i2 = R.id.iv_edit;
            AppCompatImageView appCompatImageView = (AppCompatImageView) viewInflate.findViewById(R.id.iv_edit);
            if (appCompatImageView != null) {
                i2 = R.id.iv_explore;
                CircleImageView circleImageView = (CircleImageView) viewInflate.findViewById(R.id.iv_explore);
                if (circleImageView != null) {
                    i2 = R.id.iv_menu_more;
                    AppCompatImageView appCompatImageView2 = (AppCompatImageView) viewInflate.findViewById(R.id.iv_menu_more);
                    if (appCompatImageView2 != null) {
                        i2 = R.id.swt_enabled;
                        ATESwitch aTESwitch = (ATESwitch) viewInflate.findViewById(R.id.swt_enabled);
                        if (aTESwitch != null) {
                            ItemBookSourceBinding itemBookSourceBinding = new ItemBookSourceBinding((ConstraintLayout) viewInflate, aTECheckBox, appCompatImageView, circleImageView, appCompatImageView2, aTESwitch);
                            j.d(itemBookSourceBinding, "inflate(inflater, parent, false)");
                            return itemBookSourceBinding;
                        }
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
        final ItemBookSourceBinding itemBookSourceBinding = (ItemBookSourceBinding) viewBinding;
        j.e(itemViewHolder, "holder");
        j.e(itemBookSourceBinding, "binding");
        itemBookSourceBinding.f6753f.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: e.a.a.g.d.l.c.p
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                BookSource item;
                BookSourceAdapter bookSourceAdapter = this.a;
                ItemViewHolder itemViewHolder2 = itemViewHolder;
                f.c0.c.j.e(bookSourceAdapter, "this$0");
                f.c0.c.j.e(itemViewHolder2, "$holder");
                if (compoundButton.isPressed() && (item = bookSourceAdapter.getItem(itemViewHolder2.getLayoutPosition())) != null && compoundButton.isPressed()) {
                    item.setEnabled(z);
                    bookSourceAdapter.callBack.update(item);
                }
            }
        });
        itemBookSourceBinding.f6749b.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: e.a.a.g.d.l.c.o
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                BookSource item;
                BookSourceAdapter bookSourceAdapter = this.a;
                ItemViewHolder itemViewHolder2 = itemViewHolder;
                f.c0.c.j.e(bookSourceAdapter, "this$0");
                f.c0.c.j.e(itemViewHolder2, "$holder");
                if (compoundButton.isPressed() && (item = bookSourceAdapter.getItem(itemViewHolder2.getLayoutPosition())) != null && compoundButton.isPressed()) {
                    if (z) {
                        bookSourceAdapter.selected.add(item);
                    } else {
                        bookSourceAdapter.selected.remove(item);
                    }
                    bookSourceAdapter.callBack.b();
                }
            }
        });
        itemBookSourceBinding.f6750c.setOnClickListener(new View.OnClickListener() { // from class: e.a.a.g.d.l.c.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BookSourceAdapter bookSourceAdapter = this.a;
                ItemViewHolder itemViewHolder2 = itemViewHolder;
                f.c0.c.j.e(bookSourceAdapter, "this$0");
                f.c0.c.j.e(itemViewHolder2, "$holder");
                BookSource item = bookSourceAdapter.getItem(itemViewHolder2.getLayoutPosition());
                if (item == null) {
                    return;
                }
                bookSourceAdapter.callBack.s(item);
            }
        });
        itemBookSourceBinding.f6752e.setOnClickListener(new View.OnClickListener() { // from class: e.a.a.g.d.l.c.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                final BookSourceAdapter bookSourceAdapter = this.a;
                ItemBookSourceBinding itemBookSourceBinding2 = itemBookSourceBinding;
                ItemViewHolder itemViewHolder2 = itemViewHolder;
                f.c0.c.j.e(bookSourceAdapter, "this$0");
                f.c0.c.j.e(itemBookSourceBinding2, "$this_apply");
                f.c0.c.j.e(itemViewHolder2, "$holder");
                AppCompatImageView appCompatImageView = itemBookSourceBinding2.f6752e;
                f.c0.c.j.d(appCompatImageView, "ivMenuMore");
                final BookSource bookSource = (BookSource) f.x.e.n(bookSourceAdapter.items, itemViewHolder2.getLayoutPosition());
                if (bookSource == null) {
                    return;
                }
                PopupMenu popupMenu = new PopupMenu(bookSourceAdapter.context, appCompatImageView);
                popupMenu.inflate(R.menu.book_source_item);
                MenuItem menuItemFindItem = popupMenu.getMenu().findItem(R.id.menu_enable_explore);
                String exploreUrl = bookSource.getExploreUrl();
                if (exploreUrl == null || exploreUrl.length() == 0) {
                    menuItemFindItem.setVisible(false);
                } else if (bookSource.getEnabledExplore()) {
                    menuItemFindItem.setTitle(R.string.disable_explore);
                } else {
                    menuItemFindItem.setTitle(R.string.enable_explore);
                }
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { // from class: e.a.a.g.d.l.c.m
                    @Override // android.widget.PopupMenu.OnMenuItemClickListener
                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        BookSourceAdapter bookSourceAdapter2 = bookSourceAdapter;
                        BookSource bookSource2 = bookSource;
                        f.c0.c.j.e(bookSourceAdapter2, "this$0");
                        f.c0.c.j.e(bookSource2, "$source");
                        switch (menuItem.getItemId()) {
                            case R.id.menu_bottom /* 2131296794 */:
                                bookSourceAdapter2.callBack.C0(bookSource2);
                                return true;
                            case R.id.menu_debug_source /* 2131296808 */:
                                bookSourceAdapter2.callBack.X(bookSource2);
                                return true;
                            case R.id.menu_del /* 2131296810 */:
                                bookSourceAdapter2.callBack.n0(bookSource2);
                                return true;
                            case R.id.menu_enable_explore /* 2131296820 */:
                                bookSourceAdapter2.callBack.update(bookSource2.copy((1048575 & 1) != 0 ? bookSource2.bookSourceName : null, (1048575 & 2) != 0 ? bookSource2.bookSourceGroup : null, (1048575 & 4) != 0 ? bookSource2.bookSourceUrl : null, (1048575 & 8) != 0 ? bookSource2.bookSourceType : 0, (1048575 & 16) != 0 ? bookSource2.bookUrlPattern : null, (1048575 & 32) != 0 ? bookSource2.customOrder : 0, (1048575 & 64) != 0 ? bookSource2.enabled : false, (1048575 & 128) != 0 ? bookSource2.enabledExplore : !bookSource2.getEnabledExplore(), (1048575 & 256) != 0 ? bookSource2.header : null, (1048575 & 512) != 0 ? bookSource2.loginUrl : null, (1048575 & 1024) != 0 ? bookSource2.bookSourceComment : null, (1048575 & 2048) != 0 ? bookSource2.lastUpdateTime : 0L, (1048575 & 4096) != 0 ? bookSource2.weight : 0, (1048575 & 8192) != 0 ? bookSource2.exploreUrl : null, (1048575 & 16384) != 0 ? bookSource2.ruleExplore : null, (1048575 & 32768) != 0 ? bookSource2.searchUrl : null, (1048575 & 65536) != 0 ? bookSource2.ruleSearch : null, (1048575 & 131072) != 0 ? bookSource2.ruleBookInfo : null, (1048575 & 262144) != 0 ? bookSource2.ruleToc : null, (1048575 & 524288) != 0 ? bookSource2.ruleContent : null));
                                return true;
                            case R.id.menu_top /* 2131296896 */:
                                bookSourceAdapter2.callBack.j(bookSource2);
                            default:
                                return true;
                        }
                    }
                });
                popupMenu.show();
            }
        });
    }
}

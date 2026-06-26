package io.legado.app.ui.book.arrange;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.os.BundleKt;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import c.b.a.m.f;
import com.umeng.analytics.pro.ai;
import com.umeng.analytics.pro.c;
import f.c0.c.j;
import f.g;
import f.x.e;
import io.legado.app.base.adapter.ItemViewHolder;
import io.legado.app.base.adapter.RecyclerAdapter;
import io.legado.app.data.entities.Book;
import io.legado.app.data.entities.BookGroup;
import io.legado.app.databinding.ItemArrangeBookBinding;
import io.legado.app.lib.theme.view.ATECheckBox;
import io.legado.app.ui.book.arrange.ArrangeBookAdapter;
import io.legado.app.ui.widget.recycler.DragSelectTouchHelper;
import io.legado.app.ui.widget.recycler.ItemTouchCallback;
import io.wenyuange.app.release.R;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mozilla.javascript.optimizer.OptRuntime;

/* JADX INFO: compiled from: ArrangeBookAdapter.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0001:B\u0017\u0012\u0006\u00107\u001a\u000206\u0012\u0006\u0010)\u001a\u00020$¢\u0006\u0004\b8\u00109J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016R\u001c\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00020\u00178\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0019\u0010 \u001a\u00020\u001b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0016\u0010#\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0019\u0010)\u001a\u00020$8\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R$\u00100\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001c\u00105\u001a\u00020\u000b8\u0006@\u0006X\u0086D¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104¨\u0006;"}, d2 = {"Lio/legado/app/ui/book/arrange/ArrangeBookAdapter;", "Lio/legado/app/base/adapter/RecyclerAdapter;", "Lio/legado/app/data/entities/Book;", "Lio/legado/app/databinding/ItemArrangeBookBinding;", "Lio/legado/app/ui/widget/recycler/ItemTouchCallback$a;", "Lf/v;", ai.aC, "()V", "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "()[Lio/legado/app/data/entities/Book;", "", "srcPosition", "targetPosition", "", ai.aD, "(II)Z", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "viewHolder", "b", "(Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/RecyclerView$ViewHolder;)V", "Ljava/util/HashSet;", "h", "Ljava/util/HashSet;", "selectedBooks", "Lio/legado/app/ui/widget/recycler/DragSelectTouchHelper$b;", "k", "Lio/legado/app/ui/widget/recycler/DragSelectTouchHelper$b;", "getDragSelectCallback", "()Lio/legado/app/ui/widget/recycler/DragSelectTouchHelper$b;", "dragSelectCallback", "j", "Z", "isMoved", "Lio/legado/app/ui/book/arrange/ArrangeBookAdapter$a;", "f", "Lio/legado/app/ui/book/arrange/ArrangeBookAdapter$a;", "getCallBack", "()Lio/legado/app/ui/book/arrange/ArrangeBookAdapter$a;", "callBack", ai.aA, "Lio/legado/app/data/entities/Book;", "getActionItem", "()Lio/legado/app/data/entities/Book;", "setActionItem", "(Lio/legado/app/data/entities/Book;)V", "actionItem", "g", OptRuntime.GeneratorState.resumptionPoint_TYPE, "getGroupRequestCode", "()I", "groupRequestCode", "Landroid/content/Context;", c.R, "<init>", "(Landroid/content/Context;Lio/legado/app/ui/book/arrange/ArrangeBookAdapter$a;)V", ai.at, "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class ArrangeBookAdapter extends RecyclerAdapter<Book, ItemArrangeBookBinding> implements ItemTouchCallback.a {

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final a callBack;

    /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
    public final int groupRequestCode;

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final HashSet<Book> selectedBooks;

    /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public Book actionItem;

    /* JADX INFO: renamed from: j, reason: collision with root package name and from kotlin metadata */
    public boolean isMoved;

    /* JADX INFO: renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final DragSelectTouchHelper.b dragSelectCallback;

    /* JADX INFO: compiled from: ArrangeBookAdapter.kt */
    public interface a {
        void m0(int i2, long j2);

        void o();

        void q(@NotNull Book... bookArr);

        @NotNull
        List<BookGroup> u0();

        void z(@NotNull Book book);
    }

    /* JADX INFO: compiled from: ArrangeBookAdapter.kt */
    public static final class b extends DragSelectTouchHelper.a<Book> {
        public b(DragSelectTouchHelper.a.EnumC0216a enumC0216a) {
            super(enumC0216a);
        }

        @Override // io.legado.app.ui.widget.recycler.DragSelectTouchHelper.a
        @NotNull
        public Set<Book> d() {
            return ArrangeBookAdapter.this.selectedBooks;
        }

        @Override // io.legado.app.ui.widget.recycler.DragSelectTouchHelper.a
        public Book e(int i2) {
            Book book = (Book) e.n(ArrangeBookAdapter.this.items, i2);
            j.c(book);
            return book;
        }

        @Override // io.legado.app.ui.widget.recycler.DragSelectTouchHelper.a
        public boolean f(int i2, boolean z) {
            Book book = (Book) e.n(ArrangeBookAdapter.this.items, i2);
            if (book == null) {
                return false;
            }
            ArrangeBookAdapter arrangeBookAdapter = ArrangeBookAdapter.this;
            if (z) {
                arrangeBookAdapter.selectedBooks.add(book);
            } else {
                arrangeBookAdapter.selectedBooks.remove(book);
            }
            arrangeBookAdapter.notifyItemChanged(i2, BundleKt.bundleOf(new g("selected", null)));
            arrangeBookAdapter.callBack.o();
            return true;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArrangeBookAdapter(@NotNull Context context, @NotNull a aVar) {
        super(context);
        j.e(context, c.R);
        j.e(aVar, "callBack");
        this.callBack = aVar;
        this.groupRequestCode = 12;
        this.selectedBooks = new HashSet<>();
        this.dragSelectCallback = new b(DragSelectTouchHelper.a.EnumC0216a.ToggleAndReverse);
    }

    @NotNull
    public final Book[] A() {
        ArrayList arrayList = new ArrayList();
        for (Book book : this.selectedBooks) {
            if (this.items.contains(book)) {
                arrayList.add(book);
            }
        }
        Object[] array = arrayList.toArray(new Book[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        return (Book[]) array;
    }

    @Override // io.legado.app.ui.widget.recycler.ItemTouchCallback.a
    public void a(int i2) {
        j.e(this, "this");
    }

    @Override // io.legado.app.ui.widget.recycler.ItemTouchCallback.a
    public void b(@NotNull RecyclerView recyclerView, @NotNull RecyclerView.ViewHolder viewHolder) {
        j.e(recyclerView, "recyclerView");
        j.e(viewHolder, "viewHolder");
        if (this.isMoved) {
            a aVar = this.callBack;
            Object[] array = this.items.toArray(new Book[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
            Book[] bookArr = (Book[]) array;
            aVar.q((Book[]) Arrays.copyOf(bookArr, bookArr.length));
        }
        this.isMoved = false;
    }

    @Override // io.legado.app.ui.widget.recycler.ItemTouchCallback.a
    public boolean c(int srcPosition, int targetPosition) {
        Book book = (Book) e.n(this.items, srcPosition);
        Book book2 = (Book) e.n(this.items, targetPosition);
        if (book != null && book2 != null) {
            if (book.getOrder() == book2.getOrder()) {
                Iterator it = this.items.iterator();
                int i2 = 0;
                while (it.hasNext()) {
                    i2++;
                    ((Book) it.next()).setOrder(i2);
                }
            } else {
                int order = book.getOrder();
                book.setOrder(book2.getOrder());
                book2.setOrder(order);
            }
        }
        z(srcPosition, targetPosition);
        this.isMoved = true;
        return true;
    }

    @Override // io.legado.app.base.adapter.RecyclerAdapter
    public void i(ItemViewHolder itemViewHolder, ViewBinding viewBinding, Book book, List list, int i2) {
        ItemArrangeBookBinding itemArrangeBookBinding = (ItemArrangeBookBinding) viewBinding;
        Book book2 = book;
        j.e(itemViewHolder, "holder");
        j.e(itemArrangeBookBinding, "binding");
        j.e(book2, "item");
        j.e(list, "payloads");
        itemArrangeBookBinding.a.setBackgroundColor(f.R1(this.context));
        itemArrangeBookBinding.f6741g.setText(book2.getName());
        itemArrangeBookBinding.f6737c.setText(book2.getAuthor());
        itemArrangeBookBinding.f6737c.setVisibility(book2.getAuthor().length() == 0 ? 8 : 0);
        TextView textView = itemArrangeBookBinding.f6740f;
        long group = book2.getGroup();
        ArrayList arrayList = new ArrayList();
        for (BookGroup bookGroup : this.callBack.u0()) {
            if (bookGroup.getGroupId() > 0 && (bookGroup.getGroupId() & group) > 0) {
                arrayList.add(bookGroup.getGroupName());
            }
        }
        textView.setText(arrayList.isEmpty() ? "" : e.q(arrayList, ",", null, null, 0, null, null, 62));
        itemArrangeBookBinding.f6736b.setChecked(this.selectedBooks.contains(book2));
    }

    @Override // io.legado.app.base.adapter.RecyclerAdapter
    public ViewBinding q(ViewGroup viewGroup) {
        j.e(viewGroup, "parent");
        View viewInflate = this.inflater.inflate(R.layout.item_arrange_book, viewGroup, false);
        int i2 = R.id.checkbox;
        ATECheckBox aTECheckBox = (ATECheckBox) viewInflate.findViewById(R.id.checkbox);
        if (aTECheckBox != null) {
            i2 = R.id.tv_author;
            TextView textView = (TextView) viewInflate.findViewById(R.id.tv_author);
            if (textView != null) {
                i2 = R.id.tv_delete;
                TextView textView2 = (TextView) viewInflate.findViewById(R.id.tv_delete);
                if (textView2 != null) {
                    i2 = R.id.tv_group;
                    TextView textView3 = (TextView) viewInflate.findViewById(R.id.tv_group);
                    if (textView3 != null) {
                        i2 = R.id.tv_group_s;
                        TextView textView4 = (TextView) viewInflate.findViewById(R.id.tv_group_s);
                        if (textView4 != null) {
                            i2 = R.id.tv_name;
                            TextView textView5 = (TextView) viewInflate.findViewById(R.id.tv_name);
                            if (textView5 != null) {
                                ItemArrangeBookBinding itemArrangeBookBinding = new ItemArrangeBookBinding((ConstraintLayout) viewInflate, aTECheckBox, textView, textView2, textView3, textView4, textView5);
                                j.d(itemArrangeBookBinding, "inflate(inflater, parent, false)");
                                return itemArrangeBookBinding;
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i2)));
    }

    @Override // io.legado.app.base.adapter.RecyclerAdapter
    public void v() {
        this.callBack.o();
    }

    @Override // io.legado.app.base.adapter.RecyclerAdapter
    public void w(final ItemViewHolder itemViewHolder, ViewBinding viewBinding) {
        final ItemArrangeBookBinding itemArrangeBookBinding = (ItemArrangeBookBinding) viewBinding;
        j.e(itemViewHolder, "holder");
        j.e(itemArrangeBookBinding, "binding");
        itemArrangeBookBinding.f6736b.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: e.a.a.g.d.a.d
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                Book item;
                ArrangeBookAdapter arrangeBookAdapter = this.a;
                ItemViewHolder itemViewHolder2 = itemViewHolder;
                f.c0.c.j.e(arrangeBookAdapter, "this$0");
                f.c0.c.j.e(itemViewHolder2, "$holder");
                if (compoundButton.isPressed() && (item = arrangeBookAdapter.getItem(itemViewHolder2.getLayoutPosition())) != null && compoundButton.isPressed()) {
                    if (z) {
                        arrangeBookAdapter.selectedBooks.add(item);
                    } else {
                        arrangeBookAdapter.selectedBooks.remove(item);
                    }
                    arrangeBookAdapter.callBack.o();
                }
            }
        });
        itemArrangeBookBinding.a.setOnClickListener(new View.OnClickListener() { // from class: e.a.a.g.d.a.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ArrangeBookAdapter arrangeBookAdapter = this.a;
                ItemViewHolder itemViewHolder2 = itemViewHolder;
                ItemArrangeBookBinding itemArrangeBookBinding2 = itemArrangeBookBinding;
                f.c0.c.j.e(arrangeBookAdapter, "this$0");
                f.c0.c.j.e(itemViewHolder2, "$holder");
                f.c0.c.j.e(itemArrangeBookBinding2, "$this_apply");
                Book item = arrangeBookAdapter.getItem(itemViewHolder2.getLayoutPosition());
                if (item == null) {
                    return;
                }
                itemArrangeBookBinding2.f6736b.setChecked(!r2.isChecked());
                if (itemArrangeBookBinding2.f6736b.isChecked()) {
                    arrangeBookAdapter.selectedBooks.add(item);
                } else {
                    arrangeBookAdapter.selectedBooks.remove(item);
                }
                arrangeBookAdapter.callBack.o();
            }
        });
        itemArrangeBookBinding.f6738d.setOnClickListener(new View.OnClickListener() { // from class: e.a.a.g.d.a.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ArrangeBookAdapter arrangeBookAdapter = this.a;
                ItemViewHolder itemViewHolder2 = itemViewHolder;
                f.c0.c.j.e(arrangeBookAdapter, "this$0");
                f.c0.c.j.e(itemViewHolder2, "$holder");
                Book item = arrangeBookAdapter.getItem(itemViewHolder2.getLayoutPosition());
                if (item == null) {
                    return;
                }
                arrangeBookAdapter.callBack.z(item);
            }
        });
        itemArrangeBookBinding.f6739e.setOnClickListener(new View.OnClickListener() { // from class: e.a.a.g.d.a.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ArrangeBookAdapter arrangeBookAdapter = this.a;
                ItemViewHolder itemViewHolder2 = itemViewHolder;
                f.c0.c.j.e(arrangeBookAdapter, "this$0");
                f.c0.c.j.e(itemViewHolder2, "$holder");
                Book item = arrangeBookAdapter.getItem(itemViewHolder2.getLayoutPosition());
                if (item == null) {
                    return;
                }
                arrangeBookAdapter.actionItem = item;
                arrangeBookAdapter.callBack.m0(arrangeBookAdapter.groupRequestCode, item.getGroup());
            }
        });
    }
}

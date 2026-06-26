package io.legado.app.ui.book.search;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import com.umeng.analytics.pro.ai;
import com.umeng.analytics.pro.c;
import f.c0.c.j;
import io.legado.app.base.adapter.ItemViewHolder;
import io.legado.app.base.adapter.RecyclerAdapter;
import io.legado.app.data.entities.Book;
import io.legado.app.databinding.ItemFilletTextBinding;
import io.legado.app.ui.book.search.BookAdapter;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: BookAdapter.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u000eB\u0017\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\t\u001a\u00020\u0004¢\u0006\u0004\b\f\u0010\rR\u0019\u0010\t\u001a\u00020\u00048\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u000f"}, d2 = {"Lio/legado/app/ui/book/search/BookAdapter;", "Lio/legado/app/base/adapter/RecyclerAdapter;", "Lio/legado/app/data/entities/Book;", "Lio/legado/app/databinding/ItemFilletTextBinding;", "Lio/legado/app/ui/book/search/BookAdapter$a;", "f", "Lio/legado/app/ui/book/search/BookAdapter$a;", "getCallBack", "()Lio/legado/app/ui/book/search/BookAdapter$a;", "callBack", "Landroid/content/Context;", c.R, "<init>", "(Landroid/content/Context;Lio/legado/app/ui/book/search/BookAdapter$a;)V", ai.at, "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class BookAdapter extends RecyclerAdapter<Book, ItemFilletTextBinding> {

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final a callBack;

    /* JADX INFO: compiled from: BookAdapter.kt */
    public interface a {
        void k(@NotNull Book book);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BookAdapter(@NotNull Context context, @NotNull a aVar) {
        super(context);
        j.e(context, c.R);
        j.e(aVar, "callBack");
        this.callBack = aVar;
    }

    @Override // io.legado.app.base.adapter.RecyclerAdapter
    public void i(ItemViewHolder itemViewHolder, ViewBinding viewBinding, Book book, List list, int i2) {
        ItemFilletTextBinding itemFilletTextBinding = (ItemFilletTextBinding) viewBinding;
        Book book2 = book;
        j.e(itemViewHolder, "holder");
        j.e(itemFilletTextBinding, "binding");
        j.e(book2, "item");
        j.e(list, "payloads");
        itemFilletTextBinding.f6784b.setText(book2.getName());
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
        itemViewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: e.a.a.g.d.j.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BookAdapter bookAdapter = this.a;
                ItemViewHolder itemViewHolder2 = itemViewHolder;
                f.c0.c.j.e(bookAdapter, "this$0");
                f.c0.c.j.e(itemViewHolder2, "$holder");
                Book item = bookAdapter.getItem(itemViewHolder2.getLayoutPosition());
                if (item == null) {
                    return;
                }
                bookAdapter.callBack.k(item);
            }
        });
    }
}

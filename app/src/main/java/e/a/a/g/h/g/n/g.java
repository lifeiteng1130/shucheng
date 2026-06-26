package e.a.a.g.h.g.n;

import android.view.View;
import io.legado.app.base.adapter.ItemViewHolder;
import io.legado.app.data.entities.Book;
import io.legado.app.ui.main.bookshelf.books.BooksAdapterList;

/* JADX INFO: compiled from: Click.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class g implements View.OnLongClickListener {
    public final /* synthetic */ BooksAdapterList a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ItemViewHolder f5851b;

    public g(boolean z, BooksAdapterList booksAdapterList, ItemViewHolder itemViewHolder) {
        this.a = booksAdapterList;
        this.f5851b = itemViewHolder;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        Book item = this.a.getItem(this.f5851b.getLayoutPosition());
        if (item == null) {
            return true;
        }
        this.a.callBack.v(item);
        return true;
    }
}

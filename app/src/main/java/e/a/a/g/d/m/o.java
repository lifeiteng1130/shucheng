package e.a.a.g.d.m;

import android.view.View;
import io.legado.app.base.adapter.ItemViewHolder;
import io.legado.app.data.entities.Bookmark;
import io.legado.app.ui.book.toc.BookmarkAdapter;

/* JADX INFO: compiled from: Click.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class o implements View.OnLongClickListener {
    public final /* synthetic */ BookmarkAdapter a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ItemViewHolder f5834b;

    public o(boolean z, BookmarkAdapter bookmarkAdapter, ItemViewHolder itemViewHolder) {
        this.a = bookmarkAdapter;
        this.f5834b = itemViewHolder;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        Bookmark item = this.a.getItem(this.f5834b.getLayoutPosition());
        if (item == null) {
            return true;
        }
        this.a.callback.D(item);
        return true;
    }
}

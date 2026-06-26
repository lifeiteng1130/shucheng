package e.a.a.g.d.d;

import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.widget.PopupMenu;
import io.legado.app.base.adapter.ItemViewHolder;
import io.legado.app.data.entities.SearchBook;
import io.legado.app.ui.book.changesource.ChangeSourceAdapter;
import io.wenyuange.app.release.R;
import java.util.Objects;

/* JADX INFO: compiled from: Click.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class j implements View.OnLongClickListener {
    public final /* synthetic */ ChangeSourceAdapter a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ItemViewHolder f5702b;

    public j(boolean z, ChangeSourceAdapter changeSourceAdapter, ItemViewHolder itemViewHolder) {
        this.a = changeSourceAdapter;
        this.f5702b = itemViewHolder;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        final ChangeSourceAdapter changeSourceAdapter = this.a;
        View view2 = this.f5702b.itemView;
        f.c0.c.j.d(view2, "holder.itemView");
        final SearchBook item = this.a.getItem(this.f5702b.getLayoutPosition());
        Objects.requireNonNull(changeSourceAdapter);
        if (item == null) {
            return true;
        }
        PopupMenu popupMenu = new PopupMenu(changeSourceAdapter.context, view2);
        popupMenu.inflate(R.menu.change_source_item);
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { // from class: e.a.a.g.d.d.b
            @Override // androidx.appcompat.widget.PopupMenu.OnMenuItemClickListener
            public final boolean onMenuItemClick(MenuItem menuItem) {
                ChangeSourceAdapter changeSourceAdapter2 = changeSourceAdapter;
                SearchBook searchBook = item;
                f.c0.c.j.e(changeSourceAdapter2, "this$0");
                if (menuItem.getItemId() != R.id.menu_disable_book_source) {
                    return true;
                }
                changeSourceAdapter2.callBack.F(searchBook);
                return true;
            }
        });
        popupMenu.show();
        return true;
    }
}

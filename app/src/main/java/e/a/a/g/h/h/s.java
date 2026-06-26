package e.a.a.g.h.h;

import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import e.a.a.d.u.b;
import e.a.a.h.f;
import io.legado.app.base.adapter.ItemViewHolder;
import io.legado.app.data.entities.BookSource;
import io.legado.app.databinding.ItemFindBookBinding;
import io.legado.app.ui.main.explore.ExploreAdapter;
import io.wenyuange.app.release.R;

/* JADX INFO: compiled from: Click.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class s implements View.OnLongClickListener {
    public final /* synthetic */ ExploreAdapter a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ItemFindBookBinding f5859b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ItemViewHolder f5860c;

    public s(boolean z, ExploreAdapter exploreAdapter, ItemFindBookBinding itemFindBookBinding, ItemViewHolder itemViewHolder) {
        this.a = exploreAdapter;
        this.f5859b = itemFindBookBinding;
        this.f5860c = itemViewHolder;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        final ExploreAdapter exploreAdapter = this.a;
        LinearLayout linearLayout = this.f5859b.f6787d;
        f.c0.c.j.d(linearLayout, "llTitle");
        final int layoutPosition = this.f5860c.getLayoutPosition();
        final BookSource bookSource = (BookSource) f.x.e.n(exploreAdapter.items, layoutPosition);
        if (bookSource == null) {
            return true;
        }
        PopupMenu popupMenu = new PopupMenu(exploreAdapter.context, linearLayout);
        popupMenu.inflate(R.menu.explore_item);
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { // from class: e.a.a.g.h.h.j
            @Override // android.widget.PopupMenu.OnMenuItemClickListener
            public final boolean onMenuItemClick(MenuItem menuItem) {
                ExploreAdapter exploreAdapter2 = exploreAdapter;
                BookSource bookSource2 = bookSource;
                int i2 = layoutPosition;
                f.c0.c.j.e(exploreAdapter2, "this$0");
                f.c0.c.j.e(bookSource2, "$source");
                switch (menuItem.getItemId()) {
                    case R.id.menu_del /* 2131296810 */:
                        b.C0148b.b(e.a.a.d.u.b.a, exploreAdapter2.scope, null, new t(bookSource2, null), 2);
                        break;
                    case R.id.menu_edit /* 2131296818 */:
                        exploreAdapter2.callBack.J(bookSource2.getBookSourceUrl());
                        break;
                    case R.id.menu_refresh /* 2131296862 */:
                        f.b.a(e.a.a.h.f.a, exploreAdapter2.context, "explore", 0L, 0, false, 28).f(bookSource2.getBookSourceUrl());
                        exploreAdapter2.notifyItemChanged(i2);
                        break;
                    case R.id.menu_top /* 2131296896 */:
                        exploreAdapter2.callBack.j(bookSource2);
                        break;
                }
                return true;
            }
        });
        popupMenu.show();
        return true;
    }
}

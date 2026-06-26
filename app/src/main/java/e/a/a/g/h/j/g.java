package e.a.a.g.h.j;

import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.widget.PopupMenu;
import f.c0.c.j;
import io.legado.app.base.adapter.ItemViewHolder;
import io.legado.app.data.entities.RssSource;
import io.legado.app.databinding.ItemRssBinding;
import io.legado.app.ui.main.rss.RssAdapter;
import io.legado.app.ui.widget.image.FilletImageView;
import io.wenyuange.app.release.R;

/* JADX INFO: compiled from: Click.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class g implements View.OnLongClickListener {
    public final /* synthetic */ RssAdapter a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ItemViewHolder f5863b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ItemRssBinding f5864c;

    public g(boolean z, RssAdapter rssAdapter, ItemViewHolder itemViewHolder, ItemRssBinding itemRssBinding) {
        this.a = rssAdapter;
        this.f5863b = itemViewHolder;
        this.f5864c = itemRssBinding;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        final RssSource rssSourceN = this.a.n(this.f5863b.getLayoutPosition());
        if (rssSourceN == null) {
            return true;
        }
        final RssAdapter rssAdapter = this.a;
        FilletImageView filletImageView = this.f5864c.f6829b;
        j.d(filletImageView, "ivIcon");
        PopupMenu popupMenu = new PopupMenu(rssAdapter.context, filletImageView);
        popupMenu.inflate(R.menu.rss_main_item);
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { // from class: e.a.a.g.h.j.b
            @Override // androidx.appcompat.widget.PopupMenu.OnMenuItemClickListener
            public final boolean onMenuItemClick(MenuItem menuItem) {
                RssAdapter rssAdapter2 = rssAdapter;
                RssSource rssSource = rssSourceN;
                j.e(rssAdapter2, "this$0");
                j.e(rssSource, "$rssSource");
                int itemId = menuItem.getItemId();
                if (itemId == R.id.menu_del) {
                    rssAdapter2.callBack.d(rssSource);
                    return true;
                }
                if (itemId == R.id.menu_edit) {
                    rssAdapter2.callBack.h(rssSource);
                    return true;
                }
                if (itemId != R.id.menu_top) {
                    return true;
                }
                rssAdapter2.callBack.g(rssSource);
                return true;
            }
        });
        popupMenu.show();
        return true;
    }
}

package io.legado.app.ui.book.toc;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.umeng.analytics.pro.ai;
import com.umeng.analytics.pro.c;
import e.a.a.g.d.m.o;
import f.c0.c.j;
import io.legado.app.base.adapter.ItemViewHolder;
import io.legado.app.base.adapter.RecyclerAdapter;
import io.legado.app.data.entities.Bookmark;
import io.legado.app.databinding.ItemBookmarkBinding;
import io.legado.app.ui.book.toc.BookmarkAdapter;
import io.wenyuange.app.release.R;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: BookmarkAdapter.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u000eB\u0017\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\t\u001a\u00020\u0004¢\u0006\u0004\b\f\u0010\rR\u0019\u0010\t\u001a\u00020\u00048\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u000f"}, d2 = {"Lio/legado/app/ui/book/toc/BookmarkAdapter;", "Lio/legado/app/base/adapter/RecyclerAdapter;", "Lio/legado/app/data/entities/Bookmark;", "Lio/legado/app/databinding/ItemBookmarkBinding;", "Lio/legado/app/ui/book/toc/BookmarkAdapter$a;", "f", "Lio/legado/app/ui/book/toc/BookmarkAdapter$a;", "getCallback", "()Lio/legado/app/ui/book/toc/BookmarkAdapter$a;", "callback", "Landroid/content/Context;", c.R, "<init>", "(Landroid/content/Context;Lio/legado/app/ui/book/toc/BookmarkAdapter$a;)V", ai.at, "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class BookmarkAdapter extends RecyclerAdapter<Bookmark, ItemBookmarkBinding> {

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final a callback;

    /* JADX INFO: compiled from: BookmarkAdapter.kt */
    public interface a {
        void D(@NotNull Bookmark bookmark);

        void q(@NotNull Bookmark bookmark);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BookmarkAdapter(@NotNull Context context, @NotNull a aVar) {
        super(context);
        j.e(context, c.R);
        j.e(aVar, "callback");
        this.callback = aVar;
    }

    @Override // io.legado.app.base.adapter.RecyclerAdapter
    public void i(ItemViewHolder itemViewHolder, ViewBinding viewBinding, Bookmark bookmark, List list, int i2) {
        ItemBookmarkBinding itemBookmarkBinding = (ItemBookmarkBinding) viewBinding;
        Bookmark bookmark2 = bookmark;
        j.e(itemViewHolder, "holder");
        j.e(itemBookmarkBinding, "binding");
        j.e(bookmark2, "item");
        j.e(list, "payloads");
        itemBookmarkBinding.f6755c.setText(bookmark2.getChapterName());
        itemBookmarkBinding.f6754b.setText(bookmark2.getBookText());
        itemBookmarkBinding.f6756d.setText(bookmark2.getContent());
    }

    @Override // io.legado.app.base.adapter.RecyclerAdapter
    public ViewBinding q(ViewGroup viewGroup) {
        j.e(viewGroup, "parent");
        View viewInflate = this.inflater.inflate(R.layout.item_bookmark, viewGroup, false);
        int i2 = R.id.tv_book_text;
        TextView textView = (TextView) viewInflate.findViewById(R.id.tv_book_text);
        if (textView != null) {
            i2 = R.id.tv_chapter_name;
            TextView textView2 = (TextView) viewInflate.findViewById(R.id.tv_chapter_name);
            if (textView2 != null) {
                i2 = R.id.tv_content;
                TextView textView3 = (TextView) viewInflate.findViewById(R.id.tv_content);
                if (textView3 != null) {
                    ItemBookmarkBinding itemBookmarkBinding = new ItemBookmarkBinding((LinearLayout) viewInflate, textView, textView2, textView3);
                    j.d(itemBookmarkBinding, "inflate(inflater, parent, false)");
                    return itemBookmarkBinding;
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i2)));
    }

    @Override // io.legado.app.base.adapter.RecyclerAdapter
    public void w(final ItemViewHolder itemViewHolder, ViewBinding viewBinding) {
        ItemBookmarkBinding itemBookmarkBinding = (ItemBookmarkBinding) viewBinding;
        j.e(itemViewHolder, "holder");
        j.e(itemBookmarkBinding, "binding");
        itemBookmarkBinding.a.setOnClickListener(new View.OnClickListener() { // from class: e.a.a.g.d.m.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BookmarkAdapter bookmarkAdapter = this.a;
                ItemViewHolder itemViewHolder2 = itemViewHolder;
                f.c0.c.j.e(bookmarkAdapter, "this$0");
                f.c0.c.j.e(itemViewHolder2, "$holder");
                Bookmark item = bookmarkAdapter.getItem(itemViewHolder2.getLayoutPosition());
                if (item == null) {
                    return;
                }
                bookmarkAdapter.callback.q(item);
            }
        });
        LinearLayout linearLayout = itemBookmarkBinding.a;
        j.d(linearLayout, "binding.root");
        linearLayout.setOnLongClickListener(new o(true, this, itemViewHolder));
    }
}

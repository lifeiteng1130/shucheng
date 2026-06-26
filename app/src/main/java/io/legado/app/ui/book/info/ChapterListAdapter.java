package io.legado.app.ui.book.info;

import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import f.c0.c.j;
import io.legado.app.base.adapter.ItemViewHolder;
import io.legado.app.base.adapter.RecyclerAdapter;
import io.legado.app.data.entities.BookChapter;
import io.legado.app.databinding.ItemChapterListBinding;
import io.legado.app.ui.book.info.ChapterListAdapter;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: ChapterListAdapter.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001¨\u0006\u0004"}, d2 = {"Lio/legado/app/ui/book/info/ChapterListAdapter;", "Lio/legado/app/base/adapter/RecyclerAdapter;", "Lio/legado/app/data/entities/BookChapter;", "Lio/legado/app/databinding/ItemChapterListBinding;", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class ChapterListAdapter extends RecyclerAdapter<BookChapter, ItemChapterListBinding> {
    @Override // io.legado.app.base.adapter.RecyclerAdapter
    public void i(ItemViewHolder itemViewHolder, ViewBinding viewBinding, BookChapter bookChapter, List list, int i2) {
        ItemChapterListBinding itemChapterListBinding = (ItemChapterListBinding) viewBinding;
        BookChapter bookChapter2 = bookChapter;
        j.e(itemViewHolder, "holder");
        j.e(itemChapterListBinding, "binding");
        j.e(bookChapter2, "item");
        j.e(list, "payloads");
        itemChapterListBinding.f6773c.setText(bookChapter2.getTitle());
        bookChapter2.getIndex();
        throw null;
    }

    @Override // io.legado.app.base.adapter.RecyclerAdapter
    public ViewBinding q(ViewGroup viewGroup) {
        j.e(viewGroup, "parent");
        ItemChapterListBinding itemChapterListBindingA = ItemChapterListBinding.a(this.inflater, viewGroup, false);
        j.d(itemChapterListBindingA, "inflate(inflater, parent, false)");
        return itemChapterListBindingA;
    }

    @Override // io.legado.app.base.adapter.RecyclerAdapter
    public void w(final ItemViewHolder itemViewHolder, ViewBinding viewBinding) {
        j.e(itemViewHolder, "holder");
        j.e((ItemChapterListBinding) viewBinding, "binding");
        itemViewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: e.a.a.g.d.g.v
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ChapterListAdapter chapterListAdapter = this.a;
                ItemViewHolder itemViewHolder2 = itemViewHolder;
                f.c0.c.j.e(chapterListAdapter, "this$0");
                f.c0.c.j.e(itemViewHolder2, "$holder");
                if (chapterListAdapter.getItem(itemViewHolder2.getLayoutPosition()) != null) {
                    throw null;
                }
            }
        });
    }
}

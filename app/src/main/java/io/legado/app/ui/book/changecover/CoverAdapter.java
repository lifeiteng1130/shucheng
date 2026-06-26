package io.legado.app.ui.book.changecover;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.DiffUtil;
import androidx.viewbinding.ViewBinding;
import com.umeng.analytics.pro.ai;
import com.umeng.analytics.pro.c;
import f.c0.c.j;
import io.legado.app.base.adapter.DiffRecyclerAdapter;
import io.legado.app.base.adapter.ItemViewHolder;
import io.legado.app.data.entities.SearchBook;
import io.legado.app.databinding.ItemCoverBinding;
import io.legado.app.ui.book.changecover.CoverAdapter;
import io.legado.app.ui.widget.image.CoverImageView;
import io.wenyuange.app.release.R;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: CoverAdapter.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0012B\u0017\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\t\u001a\u00020\u0004¢\u0006\u0004\b\u0010\u0010\u0011R\u0019\u0010\t\u001a\u00020\u00048\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\n8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u0013"}, d2 = {"Lio/legado/app/ui/book/changecover/CoverAdapter;", "Lio/legado/app/base/adapter/DiffRecyclerAdapter;", "Lio/legado/app/data/entities/SearchBook;", "Lio/legado/app/databinding/ItemCoverBinding;", "Lio/legado/app/ui/book/changecover/CoverAdapter$a;", "d", "Lio/legado/app/ui/book/changecover/CoverAdapter$a;", "getCallBack", "()Lio/legado/app/ui/book/changecover/CoverAdapter$a;", "callBack", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "f", "()Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "diffItemCallback", "Landroid/content/Context;", c.R, "<init>", "(Landroid/content/Context;Lio/legado/app/ui/book/changecover/CoverAdapter$a;)V", ai.at, "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class CoverAdapter extends DiffRecyclerAdapter<SearchBook, ItemCoverBinding> {

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final a callBack;

    /* JADX INFO: compiled from: CoverAdapter.kt */
    public interface a {
        void c(@NotNull String str);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoverAdapter(@NotNull Context context, @NotNull a aVar) {
        super(context);
        j.e(context, c.R);
        j.e(aVar, "callBack");
        this.callBack = aVar;
    }

    @Override // io.legado.app.base.adapter.DiffRecyclerAdapter
    public void d(ItemViewHolder itemViewHolder, ViewBinding viewBinding, SearchBook searchBook, List list) {
        ItemCoverBinding itemCoverBinding = (ItemCoverBinding) viewBinding;
        SearchBook searchBook2 = searchBook;
        j.e(itemViewHolder, "holder");
        j.e(itemCoverBinding, "binding");
        j.e(searchBook2, "item");
        j.e(list, "payloads");
        itemCoverBinding.f6775b.b(searchBook2.getCoverUrl(), searchBook2.getName(), searchBook2.getAuthor());
        itemCoverBinding.f6776c.setText(searchBook2.getOriginName());
    }

    @Override // io.legado.app.base.adapter.DiffRecyclerAdapter
    @NotNull
    public DiffUtil.ItemCallback<SearchBook> f() {
        return new DiffUtil.ItemCallback<SearchBook>() { // from class: io.legado.app.ui.book.changecover.CoverAdapter$diffItemCallback$1
            @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
            public boolean areContentsTheSame(SearchBook searchBook, SearchBook searchBook2) {
                SearchBook searchBook3 = searchBook;
                SearchBook searchBook4 = searchBook2;
                j.e(searchBook3, "oldItem");
                j.e(searchBook4, "newItem");
                return j.a(searchBook3.getOriginName(), searchBook4.getOriginName()) && j.a(searchBook3.getCoverUrl(), searchBook4.getCoverUrl());
            }

            @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
            public boolean areItemsTheSame(SearchBook searchBook, SearchBook searchBook2) {
                SearchBook searchBook3 = searchBook;
                SearchBook searchBook4 = searchBook2;
                j.e(searchBook3, "oldItem");
                j.e(searchBook4, "newItem");
                return j.a(searchBook3.getBookUrl(), searchBook4.getBookUrl());
            }
        };
    }

    @Override // io.legado.app.base.adapter.DiffRecyclerAdapter
    public ViewBinding i(ViewGroup viewGroup) {
        j.e(viewGroup, "parent");
        View viewInflate = this.inflater.inflate(R.layout.item_cover, viewGroup, false);
        int i2 = R.id.iv_cover;
        CoverImageView coverImageView = (CoverImageView) viewInflate.findViewById(R.id.iv_cover);
        if (coverImageView != null) {
            i2 = R.id.tv_source;
            TextView textView = (TextView) viewInflate.findViewById(R.id.tv_source);
            if (textView != null) {
                ItemCoverBinding itemCoverBinding = new ItemCoverBinding((LinearLayout) viewInflate, coverImageView, textView);
                j.d(itemCoverBinding, "inflate(inflater, parent, false)");
                return itemCoverBinding;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i2)));
    }

    @Override // io.legado.app.base.adapter.DiffRecyclerAdapter
    public void m(final ItemViewHolder itemViewHolder, ViewBinding viewBinding) {
        j.e(itemViewHolder, "holder");
        j.e((ItemCoverBinding) viewBinding, "binding");
        itemViewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: e.a.a.g.d.c.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CoverAdapter coverAdapter = this.a;
                ItemViewHolder itemViewHolder2 = itemViewHolder;
                j.e(coverAdapter, "this$0");
                j.e(itemViewHolder2, "$holder");
                SearchBook item = coverAdapter.getItem(itemViewHolder2.getLayoutPosition());
                if (item == null) {
                    return;
                }
                CoverAdapter.a aVar = coverAdapter.callBack;
                String coverUrl = item.getCoverUrl();
                if (coverUrl == null) {
                    coverUrl = "";
                }
                aVar.c(coverUrl);
            }
        });
    }
}

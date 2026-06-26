package io.legado.app.ui.book.explore;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import c.b.a.m.f;
import com.umeng.analytics.pro.ai;
import com.umeng.analytics.pro.c;
import f.c0.c.j;
import io.legado.app.base.adapter.ItemViewHolder;
import io.legado.app.base.adapter.RecyclerAdapter;
import io.legado.app.data.entities.Book;
import io.legado.app.data.entities.SearchBook;
import io.legado.app.databinding.ItemSearchBinding;
import io.legado.app.ui.book.explore.ExploreShowAdapter;
import io.legado.app.ui.widget.LabelsBar;
import io.wenyuange.app.release.R;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ExploreShowAdapter.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u000eB\u0017\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\t\u001a\u00020\u0004¢\u0006\u0004\b\f\u0010\rR\u0019\u0010\t\u001a\u00020\u00048\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u000f"}, d2 = {"Lio/legado/app/ui/book/explore/ExploreShowAdapter;", "Lio/legado/app/base/adapter/RecyclerAdapter;", "Lio/legado/app/data/entities/SearchBook;", "Lio/legado/app/databinding/ItemSearchBinding;", "Lio/legado/app/ui/book/explore/ExploreShowAdapter$a;", "f", "Lio/legado/app/ui/book/explore/ExploreShowAdapter$a;", "getCallBack", "()Lio/legado/app/ui/book/explore/ExploreShowAdapter$a;", "callBack", "Landroid/content/Context;", c.R, "<init>", "(Landroid/content/Context;Lio/legado/app/ui/book/explore/ExploreShowAdapter$a;)V", ai.at, "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class ExploreShowAdapter extends RecyclerAdapter<SearchBook, ItemSearchBinding> {

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final a callBack;

    /* JADX INFO: compiled from: ExploreShowAdapter.kt */
    public interface a {
        void k(@NotNull Book book);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExploreShowAdapter(@NotNull Context context, @NotNull a aVar) {
        super(context);
        j.e(context, c.R);
        j.e(aVar, "callBack");
        this.callBack = aVar;
    }

    @Override // io.legado.app.base.adapter.RecyclerAdapter
    public void i(ItemViewHolder itemViewHolder, ViewBinding viewBinding, SearchBook searchBook, List list, int i2) {
        ItemSearchBinding itemSearchBinding = (ItemSearchBinding) viewBinding;
        SearchBook searchBook2 = searchBook;
        j.e(itemViewHolder, "holder");
        j.e(itemSearchBinding, "binding");
        j.e(searchBook2, "item");
        j.e(list, "payloads");
        itemSearchBinding.f6846h.setText(searchBook2.getName());
        itemSearchBinding.f6843e.setText(this.context.getString(R.string.author_show, searchBook2.getAuthor()));
        String latestChapterTitle = searchBook2.getLatestChapterTitle();
        if (latestChapterTitle == null || latestChapterTitle.length() == 0) {
            TextView textView = itemSearchBinding.f6845g;
            j.d(textView, "tvLasted");
            f.e3(textView);
        } else {
            itemSearchBinding.f6845g.setText(this.context.getString(R.string.lasted_show, searchBook2.getLatestChapterTitle()));
            TextView textView2 = itemSearchBinding.f6845g;
            j.d(textView2, "tvLasted");
            f.c6(textView2);
        }
        String intro = searchBook2.getIntro();
        if (intro == null || intro.length() == 0) {
            itemSearchBinding.f6844f.setText(this.context.getString(R.string.intro_show_null));
        } else {
            itemSearchBinding.f6844f.setText(this.context.getString(R.string.intro_show, searchBook2.getIntro()));
        }
        List<String> kindList = searchBook2.getKindList();
        if (kindList.isEmpty()) {
            LabelsBar labelsBar = itemSearchBinding.f6842d;
            j.d(labelsBar, "llKind");
            f.e3(labelsBar);
        } else {
            LabelsBar labelsBar2 = itemSearchBinding.f6842d;
            j.d(labelsBar2, "llKind");
            f.c6(labelsBar2);
            itemSearchBinding.f6842d.setLabels(kindList);
        }
        itemSearchBinding.f6841c.b(searchBook2.getCoverUrl(), searchBook2.getName(), searchBook2.getAuthor());
    }

    @Override // io.legado.app.base.adapter.RecyclerAdapter
    public ViewBinding q(ViewGroup viewGroup) {
        j.e(viewGroup, "parent");
        ItemSearchBinding itemSearchBindingA = ItemSearchBinding.a(this.inflater, viewGroup, false);
        j.d(itemSearchBindingA, "inflate(inflater, parent, false)");
        return itemSearchBindingA;
    }

    @Override // io.legado.app.base.adapter.RecyclerAdapter
    public void w(final ItemViewHolder itemViewHolder, ViewBinding viewBinding) {
        j.e(itemViewHolder, "holder");
        j.e((ItemSearchBinding) viewBinding, "binding");
        itemViewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: e.a.a.g.d.e.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ExploreShowAdapter exploreShowAdapter = this.a;
                ItemViewHolder itemViewHolder2 = itemViewHolder;
                j.e(exploreShowAdapter, "this$0");
                j.e(itemViewHolder2, "$holder");
                SearchBook item = exploreShowAdapter.getItem(itemViewHolder2.getLayoutPosition());
                if (item == null) {
                    return;
                }
                exploreShowAdapter.callBack.k(item.toBook());
            }
        });
    }
}

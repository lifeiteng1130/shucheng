package io.legado.app.ui.rss.article;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.viewbinding.ViewBinding;
import c.b.a.h;
import c.b.a.m.f;
import com.umeng.analytics.pro.c;
import e.a.a.d.n;
import f.c0.c.j;
import f.h0.k;
import io.legado.app.base.adapter.ItemViewHolder;
import io.legado.app.data.entities.RssArticle;
import io.legado.app.databinding.ItemRssArticleBinding;
import io.legado.app.ui.rss.article.BaseRssArticlesAdapter;
import io.legado.app.ui.rss.article.RssArticlesAdapter;
import io.wenyuange.app.release.R;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: RssArticlesAdapter.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lio/legado/app/ui/rss/article/RssArticlesAdapter;", "Lio/legado/app/ui/rss/article/BaseRssArticlesAdapter;", "Lio/legado/app/databinding/ItemRssArticleBinding;", "Landroid/content/Context;", c.R, "Lio/legado/app/ui/rss/article/BaseRssArticlesAdapter$a;", "callBack", "<init>", "(Landroid/content/Context;Lio/legado/app/ui/rss/article/BaseRssArticlesAdapter$a;)V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class RssArticlesAdapter extends BaseRssArticlesAdapter<ItemRssArticleBinding> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RssArticlesAdapter(@NotNull Context context, @NotNull BaseRssArticlesAdapter.a aVar) {
        super(context, aVar);
        j.e(context, c.R);
        j.e(aVar, "callBack");
    }

    @Override // io.legado.app.base.adapter.RecyclerAdapter
    public void i(ItemViewHolder itemViewHolder, ViewBinding viewBinding, RssArticle rssArticle, List list, int i2) {
        ItemRssArticleBinding itemRssArticleBinding = (ItemRssArticleBinding) viewBinding;
        RssArticle rssArticle2 = rssArticle;
        j.e(itemViewHolder, "holder");
        j.e(itemRssArticleBinding, "binding");
        j.e(rssArticle2, "item");
        j.e(list, "payloads");
        itemRssArticleBinding.f6828d.setText(rssArticle2.getTitle());
        itemRssArticleBinding.f6827c.setText(rssArticle2.getPubDate());
        String image = rssArticle2.getImage();
        if (!(image == null || k.s(image)) || this.callBack.y()) {
            h<Drawable> hVarA = n.a(this.context, rssArticle2.getImage());
            if (this.callBack.y()) {
                hVarA.m(R.drawable.image_rss_article);
            } else {
                hVarA.x(new e.a.a.g.k.a.k(itemRssArticleBinding));
            }
            hVarA.E(itemRssArticleBinding.f6826b);
        } else {
            ImageView imageView = itemRssArticleBinding.f6826b;
            j.d(imageView, "imageView");
            f.e3(imageView);
        }
        if (rssArticle2.getRead()) {
            itemRssArticleBinding.f6828d.setTextColor(f.c2(this.context, R.color.tv_text_summary));
        } else {
            itemRssArticleBinding.f6828d.setTextColor(f.c2(this.context, R.color.primaryText));
        }
    }

    @Override // io.legado.app.base.adapter.RecyclerAdapter
    public ViewBinding q(ViewGroup viewGroup) {
        j.e(viewGroup, "parent");
        ItemRssArticleBinding itemRssArticleBindingA = ItemRssArticleBinding.a(this.inflater, viewGroup, false);
        j.d(itemRssArticleBindingA, "inflate(inflater, parent, false)");
        return itemRssArticleBindingA;
    }

    @Override // io.legado.app.base.adapter.RecyclerAdapter
    public void w(final ItemViewHolder itemViewHolder, ViewBinding viewBinding) {
        j.e(itemViewHolder, "holder");
        j.e((ItemRssArticleBinding) viewBinding, "binding");
        itemViewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: e.a.a.g.k.a.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RssArticlesAdapter rssArticlesAdapter = this.a;
                ItemViewHolder itemViewHolder2 = itemViewHolder;
                f.c0.c.j.e(rssArticlesAdapter, "this$0");
                f.c0.c.j.e(itemViewHolder2, "$holder");
                RssArticle item = rssArticlesAdapter.getItem(itemViewHolder2.getLayoutPosition());
                if (item == null) {
                    return;
                }
                rssArticlesAdapter.callBack.A(item);
            }
        });
    }
}

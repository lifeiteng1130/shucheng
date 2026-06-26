package io.legado.app.ui.rss.article;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import c.b.a.h;
import c.b.a.m.f;
import com.umeng.analytics.pro.c;
import e.a.a.d.n;
import e.a.a.g.k.a.l;
import f.c0.c.j;
import f.h0.k;
import io.legado.app.base.adapter.ItemViewHolder;
import io.legado.app.data.entities.RssArticle;
import io.legado.app.databinding.ItemRssArticle1Binding;
import io.legado.app.ui.rss.article.BaseRssArticlesAdapter;
import io.legado.app.ui.rss.article.RssArticlesAdapter1;
import io.wenyuange.app.release.R;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: RssArticlesAdapter1.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lio/legado/app/ui/rss/article/RssArticlesAdapter1;", "Lio/legado/app/ui/rss/article/BaseRssArticlesAdapter;", "Lio/legado/app/databinding/ItemRssArticle1Binding;", "Landroid/content/Context;", c.R, "Lio/legado/app/ui/rss/article/BaseRssArticlesAdapter$a;", "callBack", "<init>", "(Landroid/content/Context;Lio/legado/app/ui/rss/article/BaseRssArticlesAdapter$a;)V", "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class RssArticlesAdapter1 extends BaseRssArticlesAdapter<ItemRssArticle1Binding> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RssArticlesAdapter1(@NotNull Context context, @NotNull BaseRssArticlesAdapter.a aVar) {
        super(context, aVar);
        j.e(context, c.R);
        j.e(aVar, "callBack");
    }

    @Override // io.legado.app.base.adapter.RecyclerAdapter
    public void i(ItemViewHolder itemViewHolder, ViewBinding viewBinding, RssArticle rssArticle, List list, int i2) {
        ItemRssArticle1Binding itemRssArticle1Binding = (ItemRssArticle1Binding) viewBinding;
        RssArticle rssArticle2 = rssArticle;
        j.e(itemViewHolder, "holder");
        j.e(itemRssArticle1Binding, "binding");
        j.e(rssArticle2, "item");
        j.e(list, "payloads");
        itemRssArticle1Binding.f6822d.setText(rssArticle2.getTitle());
        itemRssArticle1Binding.f6821c.setText(rssArticle2.getPubDate());
        String image = rssArticle2.getImage();
        if (!(image == null || k.s(image)) || this.callBack.y()) {
            h<Drawable> hVarA = n.a(this.context, rssArticle2.getImage());
            if (this.callBack.y()) {
                hVarA.m(R.drawable.image_rss_article);
            } else {
                hVarA.x(new l(itemRssArticle1Binding));
            }
            hVarA.E(itemRssArticle1Binding.f6820b);
        } else {
            ImageView imageView = itemRssArticle1Binding.f6820b;
            j.d(imageView, "imageView");
            f.e3(imageView);
        }
        if (rssArticle2.getRead()) {
            itemRssArticle1Binding.f6822d.setTextColor(f.c2(this.context, R.color.tv_text_summary));
        } else {
            itemRssArticle1Binding.f6822d.setTextColor(f.c2(this.context, R.color.primaryText));
        }
    }

    @Override // io.legado.app.base.adapter.RecyclerAdapter
    public ViewBinding q(ViewGroup viewGroup) {
        j.e(viewGroup, "parent");
        View viewInflate = this.inflater.inflate(R.layout.item_rss_article_1, viewGroup, false);
        int i2 = R.id.image_view;
        ImageView imageView = (ImageView) viewInflate.findViewById(R.id.image_view);
        if (imageView != null) {
            i2 = R.id.tv_pub_date;
            TextView textView = (TextView) viewInflate.findViewById(R.id.tv_pub_date);
            if (textView != null) {
                i2 = R.id.tv_title;
                TextView textView2 = (TextView) viewInflate.findViewById(R.id.tv_title);
                if (textView2 != null) {
                    ItemRssArticle1Binding itemRssArticle1Binding = new ItemRssArticle1Binding((ConstraintLayout) viewInflate, imageView, textView, textView2);
                    j.d(itemRssArticle1Binding, "inflate(inflater, parent, false)");
                    return itemRssArticle1Binding;
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i2)));
    }

    @Override // io.legado.app.base.adapter.RecyclerAdapter
    public void w(final ItemViewHolder itemViewHolder, ViewBinding viewBinding) {
        j.e(itemViewHolder, "holder");
        j.e((ItemRssArticle1Binding) viewBinding, "binding");
        itemViewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: e.a.a.g.k.a.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RssArticlesAdapter1 rssArticlesAdapter1 = this.a;
                ItemViewHolder itemViewHolder2 = itemViewHolder;
                f.c0.c.j.e(rssArticlesAdapter1, "this$0");
                f.c0.c.j.e(itemViewHolder2, "$holder");
                RssArticle item = rssArticlesAdapter1.getItem(itemViewHolder2.getLayoutPosition());
                if (item == null) {
                    return;
                }
                rssArticlesAdapter1.callBack.A(item);
            }
        });
    }
}

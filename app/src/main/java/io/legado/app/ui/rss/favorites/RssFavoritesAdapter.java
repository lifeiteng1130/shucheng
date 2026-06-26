package io.legado.app.ui.rss.favorites;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.viewbinding.ViewBinding;
import c.b.a.m.f;
import com.umeng.analytics.pro.ai;
import com.umeng.analytics.pro.c;
import e.a.a.d.n;
import f.c0.c.j;
import f.h0.k;
import io.legado.app.base.adapter.ItemViewHolder;
import io.legado.app.base.adapter.RecyclerAdapter;
import io.legado.app.data.entities.RssStar;
import io.legado.app.databinding.ItemRssArticleBinding;
import io.legado.app.ui.rss.favorites.RssFavoritesAdapter;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: RssFavoritesAdapter.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u000eB\u0017\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\t\u001a\u00020\u0004¢\u0006\u0004\b\f\u0010\rR\u0019\u0010\t\u001a\u00020\u00048\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u000f"}, d2 = {"Lio/legado/app/ui/rss/favorites/RssFavoritesAdapter;", "Lio/legado/app/base/adapter/RecyclerAdapter;", "Lio/legado/app/data/entities/RssStar;", "Lio/legado/app/databinding/ItemRssArticleBinding;", "Lio/legado/app/ui/rss/favorites/RssFavoritesAdapter$a;", "f", "Lio/legado/app/ui/rss/favorites/RssFavoritesAdapter$a;", "getCallBack", "()Lio/legado/app/ui/rss/favorites/RssFavoritesAdapter$a;", "callBack", "Landroid/content/Context;", c.R, "<init>", "(Landroid/content/Context;Lio/legado/app/ui/rss/favorites/RssFavoritesAdapter$a;)V", ai.at, "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class RssFavoritesAdapter extends RecyclerAdapter<RssStar, ItemRssArticleBinding> {

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final a callBack;

    /* JADX INFO: compiled from: RssFavoritesAdapter.kt */
    public interface a {
        void G(@NotNull RssStar rssStar);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RssFavoritesAdapter(@NotNull Context context, @NotNull a aVar) {
        super(context);
        j.e(context, c.R);
        j.e(aVar, "callBack");
        this.callBack = aVar;
    }

    @Override // io.legado.app.base.adapter.RecyclerAdapter
    public void i(ItemViewHolder itemViewHolder, ViewBinding viewBinding, RssStar rssStar, List list, int i2) {
        ItemRssArticleBinding itemRssArticleBinding = (ItemRssArticleBinding) viewBinding;
        RssStar rssStar2 = rssStar;
        j.e(itemViewHolder, "holder");
        j.e(itemRssArticleBinding, "binding");
        j.e(rssStar2, "item");
        j.e(list, "payloads");
        itemRssArticleBinding.f6828d.setText(rssStar2.getTitle());
        itemRssArticleBinding.f6827c.setText(rssStar2.getPubDate());
        String image = rssStar2.getImage();
        if (!(image == null || k.s(image))) {
            j.d(n.a(this.context, rssStar2.getImage()).x(new e.a.a.g.k.b.c(itemRssArticleBinding)).E(itemRssArticleBinding.f6826b), "{\n            tvTitle.text = item.title\n            tvPubDate.text = item.pubDate\n            if (item.image.isNullOrBlank()) {\n                imageView.gone()\n            } else {\n                ImageLoader.load(context, item.image)\n                    .addListener(object : RequestListener<Drawable> {\n                        override fun onLoadFailed(\n                            e: GlideException?,\n                            model: Any?,\n                            target: Target<Drawable>?,\n                            isFirstResource: Boolean\n                        ): Boolean {\n                            imageView.gone()\n                            return false\n                        }\n\n                        override fun onResourceReady(\n                            resource: Drawable?,\n                            model: Any?,\n                            target: Target<Drawable>?,\n                            dataSource: DataSource?,\n                            isFirstResource: Boolean\n                        ): Boolean {\n                            imageView.visible()\n                            return false\n                        }\n\n                    })\n                    .into(imageView)\n            }\n        }");
            return;
        }
        ImageView imageView = itemRssArticleBinding.f6826b;
        j.d(imageView, "imageView");
        f.e3(imageView);
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
        itemViewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: e.a.a.g.k.b.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RssFavoritesAdapter rssFavoritesAdapter = this.a;
                ItemViewHolder itemViewHolder2 = itemViewHolder;
                j.e(rssFavoritesAdapter, "this$0");
                j.e(itemViewHolder2, "$holder");
                RssStar item = rssFavoritesAdapter.getItem(itemViewHolder2.getLayoutPosition());
                if (item == null) {
                    return;
                }
                rssFavoritesAdapter.callBack.G(item);
            }
        });
    }
}

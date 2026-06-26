package io.legado.app.ui.main.rss;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.umeng.analytics.pro.ai;
import com.umeng.analytics.pro.c;
import e.a.a.d.n;
import e.a.a.g.h.j.g;
import f.c0.c.j;
import io.legado.app.base.adapter.ItemViewHolder;
import io.legado.app.base.adapter.RecyclerAdapter;
import io.legado.app.data.entities.RssSource;
import io.legado.app.databinding.ItemRssBinding;
import io.legado.app.ui.main.rss.RssAdapter;
import io.wenyuange.app.release.R;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: RssAdapter.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u000eB\u0017\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\t\u001a\u00020\u0004¢\u0006\u0004\b\f\u0010\rR\u0019\u0010\t\u001a\u00020\u00048\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u000f"}, d2 = {"Lio/legado/app/ui/main/rss/RssAdapter;", "Lio/legado/app/base/adapter/RecyclerAdapter;", "Lio/legado/app/data/entities/RssSource;", "Lio/legado/app/databinding/ItemRssBinding;", "Lio/legado/app/ui/main/rss/RssAdapter$a;", "f", "Lio/legado/app/ui/main/rss/RssAdapter$a;", "getCallBack", "()Lio/legado/app/ui/main/rss/RssAdapter$a;", "callBack", "Landroid/content/Context;", c.R, "<init>", "(Landroid/content/Context;Lio/legado/app/ui/main/rss/RssAdapter$a;)V", ai.at, "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public final class RssAdapter extends RecyclerAdapter<RssSource, ItemRssBinding> {

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final a callBack;

    /* JADX INFO: compiled from: RssAdapter.kt */
    public interface a {
        void I(@NotNull RssSource rssSource);

        void d(@NotNull RssSource rssSource);

        void g(@NotNull RssSource rssSource);

        void h(@NotNull RssSource rssSource);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RssAdapter(@NotNull Context context, @NotNull a aVar) {
        super(context);
        j.e(context, c.R);
        j.e(aVar, "callBack");
        this.callBack = aVar;
    }

    @Override // io.legado.app.base.adapter.RecyclerAdapter
    public void i(ItemViewHolder itemViewHolder, ViewBinding viewBinding, RssSource rssSource, List list, int i2) {
        ItemRssBinding itemRssBinding = (ItemRssBinding) viewBinding;
        RssSource rssSource2 = rssSource;
        j.e(itemViewHolder, "holder");
        j.e(itemRssBinding, "binding");
        j.e(rssSource2, "item");
        j.e(list, "payloads");
        itemRssBinding.f6830c.setText(rssSource2.getSourceName());
        n.a(this.context, rssSource2.getSourceIcon()).c().m(R.drawable.image_rss).g(R.drawable.image_rss).E(itemRssBinding.f6829b);
    }

    @Override // io.legado.app.base.adapter.RecyclerAdapter
    public ViewBinding q(ViewGroup viewGroup) {
        j.e(viewGroup, "parent");
        ItemRssBinding itemRssBindingA = ItemRssBinding.a(this.inflater, viewGroup, false);
        j.d(itemRssBindingA, "inflate(inflater, parent, false)");
        return itemRssBindingA;
    }

    @Override // io.legado.app.base.adapter.RecyclerAdapter
    public void w(final ItemViewHolder itemViewHolder, ViewBinding viewBinding) {
        ItemRssBinding itemRssBinding = (ItemRssBinding) viewBinding;
        j.e(itemViewHolder, "holder");
        j.e(itemRssBinding, "binding");
        itemRssBinding.a.setOnClickListener(new View.OnClickListener() { // from class: e.a.a.g.h.j.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RssAdapter rssAdapter = this.a;
                ItemViewHolder itemViewHolder2 = itemViewHolder;
                j.e(rssAdapter, "this$0");
                j.e(itemViewHolder2, "$holder");
                RssSource rssSourceN = rssAdapter.n(itemViewHolder2.getLayoutPosition());
                if (rssSourceN == null) {
                    return;
                }
                rssAdapter.callBack.I(rssSourceN);
            }
        });
        ConstraintLayout constraintLayout = itemRssBinding.a;
        j.d(constraintLayout, "root");
        constraintLayout.setOnLongClickListener(new g(true, this, itemViewHolder, itemRssBinding));
    }
}

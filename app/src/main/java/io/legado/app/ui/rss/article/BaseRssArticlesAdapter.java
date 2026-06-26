package io.legado.app.ui.rss.article;

import android.content.Context;
import androidx.viewbinding.ViewBinding;
import com.umeng.analytics.pro.ai;
import com.umeng.analytics.pro.c;
import f.c0.c.j;
import io.legado.app.base.adapter.RecyclerAdapter;
import io.legado.app.data.entities.RssArticle;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: BaseRssArticlesAdapter.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00000\u0003:\u0001\u000fB\u0017\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\n\u001a\u00020\u0005¢\u0006\u0004\b\r\u0010\u000eR\u0019\u0010\n\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\u0010"}, d2 = {"Lio/legado/app/ui/rss/article/BaseRssArticlesAdapter;", "Landroidx/viewbinding/ViewBinding;", "VB", "Lio/legado/app/base/adapter/RecyclerAdapter;", "Lio/legado/app/data/entities/RssArticle;", "Lio/legado/app/ui/rss/article/BaseRssArticlesAdapter$a;", "f", "Lio/legado/app/ui/rss/article/BaseRssArticlesAdapter$a;", "getCallBack", "()Lio/legado/app/ui/rss/article/BaseRssArticlesAdapter$a;", "callBack", "Landroid/content/Context;", c.R, "<init>", "(Landroid/content/Context;Lio/legado/app/ui/rss/article/BaseRssArticlesAdapter$a;)V", ai.at, "app_adsRelease"}, k = 1, mv = {1, 5, 1})
public abstract class BaseRssArticlesAdapter<VB extends ViewBinding> extends RecyclerAdapter<RssArticle, VB> {

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final a callBack;

    /* JADX INFO: compiled from: BaseRssArticlesAdapter.kt */
    public interface a {
        void A(@NotNull RssArticle rssArticle);

        boolean y();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseRssArticlesAdapter(@NotNull Context context, @NotNull a aVar) {
        super(context);
        j.e(context, c.R);
        j.e(aVar, "callBack");
        this.callBack = aVar;
    }
}
